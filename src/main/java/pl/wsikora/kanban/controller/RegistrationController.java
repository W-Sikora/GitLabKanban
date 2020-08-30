package pl.wsikora.kanban.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.repositories.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public RegistrationController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
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
                           String token) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            User u = new User();
            u.setName(name);
            u.setEmail(email);
            u.setPassword(passwordEncoder.encode(password));
            u.setGitLabUrl(gitLabUrl);
            u.setToken(token);
            userRepository.save(u);
            return "redirect:/";
        } else {
            return "redirect:/register";
        }
    }

}
