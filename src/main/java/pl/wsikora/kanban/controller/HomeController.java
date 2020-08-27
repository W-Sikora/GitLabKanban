package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wsikora.kanban.model.entities.*;
import pl.wsikora.kanban.model.repositories.*;


@Controller
public class HomeController {

    private UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String indexAction() {
        return "index";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         RedirectAttributes redirectAttributes) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            redirectAttributes.addAttribute("user", user);
            return "redirect:/update_resources";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("token") String token,
                           RedirectAttributes redirectAttributes) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setToken(token);
            userRepository.save(newUser);
            redirectAttributes.addAttribute("user", userRepository.findByEmail(email));
            return "redirect:/update_resources";
        } else {
            return "redirect:/";
        }
    }

}
