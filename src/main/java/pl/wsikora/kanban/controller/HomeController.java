package pl.wsikora.kanban.controller;

import com.google.gson.JsonElement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsikora.kanban.functionalities.Api;
import pl.wsikora.kanban.model.entities.*;
import pl.wsikora.kanban.model.repositories.*;
//import pl.wsikora.kanban.model.repositories.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class HomeController {
    private ProjectRepository projectRepository;
    private LabelRepository labelRepository;
    private MilestoneRepository milestoneRepository;
    private AuthorRepository authorRepository;
    private IssueRepository issueRepository;

    public HomeController(ProjectRepository projectRepository, LabelRepository labelRepository, MilestoneRepository milestoneRepository, AuthorRepository authorRepository, IssueRepository issueRepository) {
        this.projectRepository = projectRepository;
        this.labelRepository = labelRepository;
        this.milestoneRepository = milestoneRepository;
        this.authorRepository = authorRepository;
        this.issueRepository = issueRepository;
    }

    private Api api = new Api();
    private final String base = "https://192.168.100.35/api/v4";
    private final String token = "private_token=yNxwdrda1hxyycdr8Aty";

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

    @RequestMapping("/update_resources")
    public String homeAction() {

        List<Project> projects = api.getEntitiesFromJson(
                String.format("%s/%s?%s", base, "projects", token),
                Project.class);
        projectRepository.saveAll(projects);

        for (Project project : projects) {
            List<Milestone> milestones = api.getEntitiesFromJson(
                    String.format("%s/%s/%d/%s?%s", base, "projects", project.getId(), "milestones", token),
                    Milestone.class);
            milestones.forEach(milestone -> milestone.setProject(project));
            milestoneRepository.saveAll(milestones);

            List<Label> labels = api.getEntitiesFromJson(
                    String.format("%s/%s/%d/%s?%s", base, "projects", project.getId(), "labels", token),
                    Label.class);
            labels.forEach(label -> label.setProject(project));
            labelRepository.saveAll(labels);

            List<Author> authors = api.getInnerEntitiesFromJson(
                    String.format("%s/%s/%d/%s?%s", base, "projects", project.getId(), "issues", token),
                    Author.class, "author");
            authorRepository.saveAll(authors);

            for (JsonElement element : api.url(String.format(
                    "%s/%s/%d/%s?%s", base, "projects", project.getId(), "issues", token)).getJsonArray()) {
                Issue issue = new Issue.JsonBuilder()
                        .json(element.getAsJsonObject())
                        .authorRepository(authorRepository)
                        .labelRepository(labelRepository)
                        .milestoneRepository(milestoneRepository)
                        .projectRepository(projectRepository)
                        .build();
                issueRepository.save(issue);
            }
        }

        return "redirect:/board";
    }

    @RequestMapping("/board")
    public String boardAction(Model model) {
        model.addAttribute("issues", issueRepository.findAll());
        return "board";
    }

}
