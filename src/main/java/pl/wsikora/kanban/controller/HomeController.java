package pl.wsikora.kanban.controller;

import com.google.gson.JsonElement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsikora.kanban.functionalities.Api;
import pl.wsikora.kanban.model.entities.*;
import pl.wsikora.kanban.model.repositories.*;


@Controller
public class HomeController {
    private AssigneeRepository assigneeRepository;
    private AuthorRepository authorRepository;
    private GroupRepository groupRepository;
    private IssueRepository issueRepository;
    private LabelRepository labelRepository;
    private MilestoneRepository milestoneRepository;
    private ProjectRepository projectRepository;

    public HomeController(AssigneeRepository assigneeRepository, AuthorRepository authorRepository, GroupRepository groupRepository, IssueRepository issueRepository, LabelRepository labelRepository, MilestoneRepository milestoneRepository, ProjectRepository projectRepository) {
        this.assigneeRepository = assigneeRepository;
        this.authorRepository = authorRepository;
        this.groupRepository = groupRepository;
        this.issueRepository = issueRepository;
        this.labelRepository = labelRepository;
        this.milestoneRepository = milestoneRepository;
        this.projectRepository = projectRepository;
    }

    private Api api = new Api();
    private final String base = "https://192.168.100.35/api/v4";
    private String token = "private_token=";
//    private User currentUser;

    @RequestMapping("/")
    public String indexAction() {
        return "redirect:/login";
    }

    @RequestMapping("/update_resources")
    private void action() {
        api.setBaseUrl("https://192.168.0.16/api/v4/")
                .setToken("jU1nVoPAs2DwwcHApw8d")
                .setAssigneeRepository(assigneeRepository)
                .setAuthorRepository(authorRepository)
                .setGroupRepository(groupRepository)
                .setIssueRepository(issueRepository)
                .setLabelRepository(labelRepository)
                .setMilestoneRepository(milestoneRepository)
                .setProjectRepository(projectRepository)
                .updateResources();
    }

    @RequestMapping("/login")
    public String logIn() {
        return "login";
    }

//    @RequestMapping("/login/action")
//    public String logInAction(@RequestParam("email") String email,
//                              @RequestParam("password") String password) {
//        User user = userRepository.findByEmail(email);
//        if (user != null && user.getPassword().equals(password)) {
//            token += user.getToken();
//            currentUser = user;
//            return "redirect:/update_resources";
//        } else {
//            return "redirect:/login";
//        }
//    }

    @RequestMapping("/logout")
    public String logOut() {
        return "redirect:/login";
    }

//    @RequestMapping("/update_resources")
//    public String homeAction() {
//
//        List<Project> projects = api.getEntitiesFromJson(
//                String.format("%s/%s?%s", base, "projects", token),
//                Project.class);
//        projectRepository.saveAll(projects);
//
//        currentUser.setProjects(projects);
//        userRepository.save(currentUser);
//
//        for (Project project : projects) {
//            List<Milestone> milestones = api.getEntitiesFromJson(
//                    String.format("%s/%s/%d/%s?%s", base, "projects", project.getId(), "milestones", token),
//                    Milestone.class);
//            milestones.forEach(milestone -> milestone.setProject(project));
//            milestoneRepository.saveAll(milestones);
//
//            List<Label> labels = api.getEntitiesFromJson(
//                    String.format("%s/%s/%d/%s?%s", base, "projects", project.getId(), "labels", token),
//                    Label.class);
//            labels.forEach(label -> label.setProject(project));
//            labelRepository.saveAll(labels);
//
//            List<Author> authors = api.getInnerEntitiesFromJson(
//                    String.format("%s/%s/%d/%s?%s", base, "projects", project.getId(), "issues", token),
//                    Author.class, "author");
//            authorRepository.saveAll(authors);
//
//            for (JsonElement element : api.url(String.format(
//                    "%s/%s/%d/%s?%s", base, "projects", project.getId(), "issues", token)).getJsonArray()) {
//                Issue issue = new Issue.JsonBuilder()
//                        .json(element.getAsJsonObject())
//                        .authorRepository(authorRepository)
//                        .labelRepository(labelRepository)
//                        .milestoneRepository(milestoneRepository)
//                        .projectRepository(projectRepository)
//                        .build();
//                issueRepository.save(issue);
//            }
//        }
//
//        return "redirect:/board";
//    }
//
//    @RequestMapping("/board")
//    public String boardAction(Model model) {
//        model.addAttribute("issues", issueRepository.getAllByProjectIn(currentUser.getProjects()));
//        return "board";
//    }

}
