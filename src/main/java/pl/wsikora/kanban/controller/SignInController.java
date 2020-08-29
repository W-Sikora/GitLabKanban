package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.repositories.UserRepository;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    private UserRepository userRepository;

    public SignInController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public String signIn(String email,
                         String password,
                         RedirectAttributes redirectAttributes) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            redirectAttributes.addAttribute("user", user);
            return "redirect:/gitlab_resources/update_resources";
        } else {
            return "redirect:/";
        }
    }

}
