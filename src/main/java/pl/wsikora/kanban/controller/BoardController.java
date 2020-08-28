package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsikora.kanban.model.entities.Issue;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.repositories.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private UserRepository userRepository;

    public BoardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/{userId}")
    public String boardAction(Model model, @PathVariable("userId") Long userId) {
        userRepository.findById(userId).ifPresent(u -> {
            model.addAttribute("issues", u.getIssueList());
        });
        return "board";
    }

}
