package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wsikora.kanban.model.entities.User;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @RequestMapping("/")
    public String dashboardAction(@RequestParam("user") User user, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("user", user);
        redirectAttributes.addAttribute("user", user);
        return "dashboard";
    }

    @RequestMapping("/signOut")
    public String signOut() {
        return "redirect:/";
    }

}
