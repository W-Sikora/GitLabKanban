package pl.wsikora.kanban.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wsikora.kanban.functionalities.Api;
import pl.wsikora.kanban.functionalities.JsonConverter;
import pl.wsikora.kanban.model.entities.*;
import pl.wsikora.kanban.model.repositories.*;

import java.lang.reflect.Field;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GitLabResourcesController {
    private final String baseUrl = "https://192.168.0.16/api/v4";
    private String token;
    private Api api = new Api();
    private JsonConverter converter = new JsonConverter();

    private AssigneeRepository assigneeRepository;
    private AuthorRepository authorRepository;
    private GroupRepository groupRepository;
    private IssueRepository issueRepository;
    private LabelRepository labelRepository;
    private MilestoneRepository milestoneRepository;
    private ProjectRepository projectRepository;
    private UserRepository userRepository;

    public GitLabResourcesController(AssigneeRepository assigneeRepository,
                                     AuthorRepository authorRepository,
                                     GroupRepository groupRepository,
                                     IssueRepository issueRepository,
                                     LabelRepository labelRepository,
                                     MilestoneRepository milestoneRepository,
                                     ProjectRepository projectRepository,
                                     UserRepository userRepository) {
        this.assigneeRepository = assigneeRepository;
        this.authorRepository = authorRepository;
        this.groupRepository = groupRepository;
        this.issueRepository = issueRepository;
        this.labelRepository = labelRepository;
        this.milestoneRepository = milestoneRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping("/update_resources")
    public String loadGitLabData(@RequestParam("user") User user,
                                 RedirectAttributes redirectAttributes) {
        token = user.getToken();
        try {
            user.setIssueList(updateResourcesAndGetUserIssues());
            userRepository.save(user);
        } catch (SocketTimeoutException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        redirectAttributes.addAttribute("user", user);
        return "redirect:/dashboard/";
    }

    private List<Issue> updateResourcesAndGetUserIssues() throws SocketTimeoutException, IndexOutOfBoundsException {
        String groupsEndpoint = String.format("%s%s%s", baseUrl, "/groups", "?private_token=" + token);
        JsonArray groupArray = api.getWholeJson(groupsEndpoint);
        if (groupArray != null) {
            for (JsonElement groupElement : groupArray) {
                Group group = converter.toGroup(groupElement.getAsJsonObject());
                createOrUpdate(group, groupRepository);
            }
        }

        String projectsEndpoint = String.format("%s%s%s", baseUrl, "/projects", "?private_token=" + token);
        JsonArray projectArray = api.getWholeJson(projectsEndpoint);
        if (projectArray != null) {
            for (JsonElement projectElement : projectArray) {
                Project project = converter.toProject(projectElement.getAsJsonObject());
                JsonObject namespace = projectElement.getAsJsonObject().get("namespace").getAsJsonObject();
                boolean hasGroup = namespace.get("kind").getAsString().equals("group");
                long id = namespace.get("id").getAsLong();
                if (hasGroup) {
                    Optional<Group> group = groupRepository.findById(id);
                    group.ifPresent(project::setGroup);
                }
                createOrUpdate(project, projectRepository);

                String labelsEndpoint = String.format("%s%s%d%s%s", baseUrl, "/projects/", project.getId(), "/labels", "?private_token=" + token);
                JsonArray labelArray = api.getWholeJson(labelsEndpoint);
                if (labelArray != null) {
                    for (JsonElement labelElement : labelArray.getAsJsonArray()) {
                        Label label = converter.toLabel(labelElement.getAsJsonObject());
                        label.setProject(project);
                        createOrUpdate(label, labelRepository);
                    }
                }
            }
        }

        List<Issue> issueList = new ArrayList<>();
        String issuesEndpoint = String.format("%s%s%s", baseUrl, "/issues", "?private_token=" + token);
        JsonArray issueArray = api.getWholeJson(issuesEndpoint);
        if (issueArray != null) {
            for (JsonElement issueElement : api.getWholeJson(issuesEndpoint)) {
                JsonObject issueJson = issueElement.getAsJsonObject();

                JsonObject authorJson = issueJson.get("author").getAsJsonObject();
                Author author = converter.toAuthor(authorJson);
                createOrUpdate(author, authorRepository);

                List<Assignee> assigneeList = new ArrayList<>();
                JsonArray assignees = issueJson.get("assignees").getAsJsonArray();
                for (JsonElement assigneeElement : assignees) {
                    Assignee assignee = converter.toAssignee(assigneeElement.getAsJsonObject());
                    createOrUpdate(assignee, assigneeRepository);
                    assigneeList.add(assignee);
                }

                Issue issue = converter.toIssue(issueElement.getAsJsonObject());
                issue.setAuthor(author);
                JsonElement milestoneJson = issueJson.get("milestone");
                System.out.println(milestoneJson);
                if (!milestoneJson.isJsonNull()) {
                    Milestone milestone = converter.toMilestone(milestoneJson.getAsJsonObject());
                    createOrUpdate(milestone, milestoneRepository);
                    issue.setMilestone(milestone);
                }
                issue.setAssignees(assigneeList);
                long projectId = issueJson.get("project_id").getAsLong();
                Optional<Project> project = projectRepository.findById(projectId);
                project.ifPresent(v -> {
                    issue.setProject(v);
                    issue.setGroup(v.getGroup());
                });

                List<Label> labelList = new ArrayList<>();
                issueJson.get("labels").getAsJsonArray().forEach(name -> {
                    labelList.add(labelRepository.findByProjectAndName(issue.getProject(), name.getAsString()));
                });
                issue.setLabels(labelList);
                createOrUpdate(issue, issueRepository);
                issueList.add(issue);
            }
        }

        return issueList;
    }

    private <T> void createOrUpdate(T object, JpaRepository<T, Long> repository) {
        try {
            Field field = object.getClass().getDeclaredField("id");
            field.setAccessible(true);
            long id = (long) field.get(object);
            Optional<T> objectInDB = repository.findById(id);
            objectInDB.ifPresentOrElse(
                    v -> {
                        if (!v.equals(object)) {
                            repository.save(object);
                        }
                    },
                    () -> repository.save(object)
            );
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
