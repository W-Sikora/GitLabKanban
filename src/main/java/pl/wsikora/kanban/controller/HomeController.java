package pl.wsikora.kanban.controller;

import com.google.gson.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsikora.kanban.functionalities.Api;
import pl.wsikora.kanban.model.entities.*;
import pl.wsikora.kanban.model.repositories.*;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class HomeController {
    private Api api = new Api();
    private AuthorRepository authorRepository;
    private IssueRepository issueRepository;
    private LabelRepository labelRepository;
    private MilestoneRepository milestoneRepository;
    private ProjectRepository projectRepository;
    private final String token = "private_token=yNxwdrda1hxyycdr8Aty";

    public HomeController(AuthorRepository authorRepository,
                          IssueRepository issueRepository,
                          LabelRepository labelRepository,
                          MilestoneRepository milestoneRepository,
                          ProjectRepository projectRepository) {
        this.authorRepository = authorRepository;
        this.issueRepository = issueRepository;
        this.labelRepository = labelRepository;
        this.milestoneRepository = milestoneRepository;
        this.projectRepository = projectRepository;
    }

    @RequestMapping("/")
    public String indexAction() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String logIn() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logOut() {
        return "redirect:/login";
    }


    private void createOrUpdate(O object, JpaRepository repository) {
        long id = object.getId();
        if (repository.existsById(id)) {
            O objectInDB = (O) repository.getOne(id);
            if (!objectInDB.equals(object)) {
                objectInDB = object;
                repository.save(objectInDB);
            }
        } else {
            repository.save(object);
        }
    }

    @RequestMapping("/get_issues")
    public String homeAction() {
        Gson gson = new Gson();
        JsonElement jsonProject, jsonMilestone, jsonAuthor;
        JsonArray jsonLabel;
        JsonObject object;
        List<Label> labels;
        Milestone milestone = null;
        Author author = null;
        Issue issue;
        Project project;
        Label label;

        String projectsLink = "https://192.168.100.35/api/v4/projects?" + token;
        for (JsonElement projectJsonElement : api.setLink(projectsLink).getJsonArray()) {
            object = projectJsonElement.getAsJsonObject();
            project = gson.fromJson(object, Project.class);
            createOrUpdate(project, projectRepository);

            String labelsLink = "https://192.168.100.35/api/v4/projects/" + project.getId() + "/labels?" + token;
            for (JsonElement labelJsonElement : api.setLink(labelsLink).getJsonArray()) {
                object = labelJsonElement.getAsJsonObject();
                label = gson.fromJson(object, Label.class);
                createOrUpdate(label, labelRepository);
            }
        }

        String issuesLink = "https://192.168.100.35/api/v4/issues?scope=all&" + token;
        for (JsonElement arrayElement : api.setLink(issuesLink).getJsonArray()) {
            object = arrayElement.getAsJsonObject();

            jsonMilestone = object.get("milestone");
            if (!jsonMilestone.isJsonNull()) {
                milestone = gson.fromJson(jsonMilestone, Milestone.class);
                createOrUpdate(milestone, milestoneRepository);
            }

            jsonAuthor = object.get("author");
            if (!jsonAuthor.isJsonNull()) {
                author = gson.fromJson(jsonAuthor, Author.class);
                createOrUpdate(author, authorRepository);
            }

            List<String> names = new ArrayList<>();
            for(JsonElement labelName : object.get("labels").getAsJsonArray()) {
                names.add(labelName.getAsString());
            }

            issue = new Issue.JsonBuilder()
                    .json(object)
                    .labels(labelRepository.getAllByNames(names))
                    .milestone(milestone)
                    .author(author)
                    .build();
            createOrUpdate(issue, issueRepository);
        }
        return "redirect:/board";
    }

    @RequestMapping("/board")
    public String boardAction(Model model) {
        model.addAttribute("issues", issueRepository.findAll());
        return "board";
    }

    @RequestMapping("/board/filter")
    public String filterAction(@RequestParam("query") String query, Model model) {
        Map<String, String> map = Stream
                .of(query.split("&"))
                .map(e -> e.split("="))
                .collect(Collectors.toMap(e -> e[0], e -> e[1]));

//        Filter filter = new Filter(issues);
//        if (map.containsKey("author")) {
//            filter.getByAuthor(map.get("author"));
//        }
//        if (map.containsKey("title")) {
//            filter.getByTitle(map.get("title"));
//        }
//        if (map.containsKey("milestone")) {
//            filter.getByMilestone(map.get("milestone"));
//        }
//        if (map.containsKey("labels")) {
//            filter.getByLabels(map.get("labels"));
//        }
//        if (map.containsKey("state")) {
//            filter.getByState(map.get("state"));
//        }
//        model.addAttribute("issues", filter.getAsList());
        return "board";
    }

    @RequestMapping("/board/sort")
    public String sortAction(Model model) {

//        List<Issue> resultIssues = issues.stream()
//                .sorted(Comparator.comparing(Issue::getTitle))
//                .sorted(Comparator.comparing(Issue::getCreatedAt))
//                .sorted(Comparator.comparing(Issue::getDueDate))
//                .sorted(Comparator.comparing(Issue::getUpVotes))
//                .sorted()
//                .filter(e -> e.getTitle().toLowerCase().contains(map.get("title")))
////                .filter(e -> e.getAuthor().getUserName().contains(map.get("author_name")))
////                .filter(e -> e.getState().equals(map.get("state")))
//                .collect(Collectors.toList());
//
//        model.addAttribute("issues", resultIssues);

        return "board";
    }

}
