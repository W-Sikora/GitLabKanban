package pl.wsikora.kanban.functionalities;


import com.google.gson.*;
import pl.wsikora.kanban.model.entities.*;
import pl.wsikora.kanban.model.repositories.*;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Api {

    private String baseUrl;
    private String token;

    private AssigneeRepository assigneeRepository;
    private AuthorRepository authorRepository;
    private GroupRepository groupRepository;
    private IssueRepository issueRepository;
    private LabelRepository labelRepository;
    private MilestoneRepository milestoneRepository;
    private ProjectRepository projectRepository;

    private Gson gson = new Gson();
    private JsonParser parser = new JsonParser();

    public Api() {
    }

    public Api setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public Api setToken(String token) {
        this.token = token;
        return this;
    }

    public Api setAssigneeRepository(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
        return this;
    }

    public Api setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        return this;
    }

    public Api setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        return this;
    }

    public Api setLabelRepository(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
        return this;
    }

    public Api setIssueRepository(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
        return this;
    }

    public Api setMilestoneRepository(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
        return this;
    }

    public Api setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        return this;
    }

    public String getJson(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL u = new URL(url);
            Reader reader = new InputStreamReader(u.openConnection().getInputStream());
            int ascii;
            while ((ascii = reader.read()) != -1) {
                json.append((char) ascii);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public JsonArray getJsonArray(String url) {
        return parse(getJson(url)).getAsJsonArray();
    }

    public JsonObject getJsonObject(String url) {
        return parse(getJson(url)).getAsJsonObject();
    }

    public void updateResources() {
        String groupsUrl = getEndpoint("groups", "", "");
        List<Group> groups = getEntitiesFromJson(groupsUrl, Group.class);
        groupRepository.saveAll(groups);

        String projectsUrl = getEndpoint("projects", "", "");
        List<Project> projects = getEntitiesFromJson(projectsUrl, Project.class);
        projects.forEach(project -> {
            project.setGroup(getProjectGroup(project));
            projectRepository.save(project);

            String projectEndpoint = "projects/";
            String projectId = project.getId().toString();

            String labelsProjectUrl = getEndpoint(projectEndpoint, projectId, "/labels");
            List<Label> labels = getEntitiesFromJson(labelsProjectUrl, Label.class);
            labels.forEach(label -> label.setProject(project));
            labelRepository.saveAll(labels);
            labels.forEach(label -> label.setProject(project));

            String issuesProjectUrl = getEndpoint(projectEndpoint, projectId, "/issues");
            List<Issue> issues = getEntitiesFromJson(issuesProjectUrl, Issue.class);
            issues.forEach(issue -> {
                issue.setProject(project);

                String issueId = issue.getId().toString();
                String issueUrl = getEndpoint(projectEndpoint, projectId, "/issues/" + issueId);

                Milestone milestone = getInnerEntityFromJson(issueUrl, "milestone", Milestone.class);
                milestone.setProject(project);
                milestoneRepository.save(milestone);
                issue.setMilestone(milestone);

                Author author = getInnerEntityFromJson(issueUrl, "author", Author.class);
                authorRepository.save(author);
                issue.setAuthor(author);

                List<Assignee> assignees = getInnerEntitiesSingleFromJson(issueUrl, "assignees", Assignee.class);
                assigneeRepository.saveAll(assignees);
                issue.setAssignees(assignees);

                List<Label> labelsList = new ArrayList<>();
                for (JsonElement jsonElement : parse(getJson(issueUrl)).getAsJsonObject().get("labels").getAsJsonArray()) {
                    String name = jsonElement.getAsString();
                    labelsList.add(labelRepository.getLabelByNameAndProject(name, project));
                }
                issue.setLabelsList(labelsList);

                issueRepository.save(issue);
            });
        });
    }

    private JsonElement parse(String json) {
        return parser.parse(json);
    }

    private <T> T getInnerEntityFromJson(String url, String jsonObject, Class<T> type) {
        JsonElement element = parse(getJson(url));
        JsonObject object = element.getAsJsonObject().get(jsonObject).getAsJsonObject();
        return gson.fromJson(object, type);
    }

    private <T> List<T> getEntitiesFromJson(String url, Class<T> type) {
        List<T> entities = new ArrayList<>();
        JsonArray jsonArray;
        int pageIndex = 1;
        while ((jsonArray = getJsonArray(url + "&page=" + pageIndex)).size() > 0) {
            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                T entity = gson.fromJson(jsonObject, type);
                entities.add(entity);
            }
            pageIndex++;
        }
        return entities;
    }

    private <T> List<T> getInnerEntitiesSingleFromJson(String url, String jsonObject, Class<T> type) {
        List<T> entities = new ArrayList<>();
        JsonArray jsonArray = parse(getJson(url)).getAsJsonObject().get(jsonObject).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObj = jsonElement.getAsJsonObject();
            T entity = gson.fromJson(jsonObj, type);
            entities.add(entity);
        }
        return entities;
    }

    private long getId(JsonObject jsonObject) {
        return jsonObject.get("id").getAsLong();
    }

    private Group getProjectGroup(Project project) {
        String projectUrl = String.format("%s/%s/%d?%s",
                baseUrl, "projects", project.getId(), "private_token=" + token);
        JsonObject parent = parse(getJson(projectUrl)).getAsJsonObject();
        JsonObject namespace = parent.get("namespace").getAsJsonObject();
        String kind = namespace.get("kind").getAsString();
        long id = namespace.get("id").getAsLong();
        if (kind.equals("group")) {
            return groupRepository.findById(id).get();
        } else {
            return null;
        }
    }

    private String getEndpoint(String endpoint1, String id, String endpoint2) {
        return String.format("%s/%s%s%s?%s", baseUrl, endpoint1, id, endpoint2, "private_token=" + token);
    }

}
