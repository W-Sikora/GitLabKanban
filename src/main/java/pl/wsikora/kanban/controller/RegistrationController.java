package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.repositories.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToRegistration() {
        return "registration";
    }

    @PostMapping
    public String register(String name,
                           String email,
                           String password,
                           String gitLabUrl,
                           String token,
                           RedirectAttributes redirectAttributes) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            User u = new User();
            u.setName(name);
            u.setEmail(email);
            u.setPassword(password);
            u.setGitLabUrl(gitLabUrl);
            u.setToken(token);
            userRepository.save(u);
            redirectAttributes.addAttribute("user", userRepository.findByEmail(email));
            return "redirect:/gitlab_resources/update_resources";
        } else {
            return "redirect:/register";
        }
    }

}
