package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsikora.kanban.model.entities.User;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping("/")
    public String boardAction(@RequestParam("user") User user,
                              Model model) {
        model.addAttribute("issues", user.getIssueList());
        return "board";
    }

}
