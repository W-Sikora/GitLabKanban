package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.repositories.UserRepository;
import pl.wsikora.kanban.model.repositories.UserTableRepository;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private UserTableRepository userTableRepository;
    private UserRepository userRepository;

    public DashboardController(UserTableRepository userTableRepository, UserRepository userRepository) {
        this.userTableRepository = userTableRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToDashboard(@RequestParam("user") User user, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("boardsNb", userTableRepository.countAllByUser(user))
                .addAttribute("projectsNb", userRepository.countAllProjectsByUserId(user.getId()))
                .addAttribute("issuesNb", userRepository.countAllIssuesByUser(user))
                .addAttribute("user", user);
        redirectAttributes.addAttribute("user", user);
        return "authorized/dashboard";
    }

    @RequestMapping("/signOut")
    public String signOut() {
        return "redirect:/";
    }

}
