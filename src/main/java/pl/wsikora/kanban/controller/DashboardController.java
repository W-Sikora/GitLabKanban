package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.repositories.UserRepository;
import pl.wsikora.kanban.model.repositories.BoardRepository;

import java.security.Principal;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private BoardRepository userTableRepository;
    private UserRepository userRepository;

    public DashboardController(BoardRepository userTableRepository, UserRepository userRepository) {
        this.userTableRepository = userTableRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToDashboard(Principal principal, Model model) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("boardsNb", userTableRepository.countAllByUser(user))
                .addAttribute("projectsNb", userRepository.countAllProjectsByUserId(user.getId()))
                .addAttribute("issuesNb", userRepository.countAllIssuesByUser(user))
                .addAttribute("user", user);
        return "authorized/dashboard";
    }

    @GetMapping("/settings")
    public String goToSettings() {
        return "authorized/settings";
    }

    @GetMapping("/other")
    public String goToOther() {
        return "authorized/other";
    }

}
