package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.kanban.model.entities.Board;
import pl.wsikora.kanban.model.repositories.UserRepository;
import pl.wsikora.kanban.model.repositories.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardRepository userTableRepository;
    private UserRepository userRepository;

    public BoardController(BoardRepository userTableRepository, UserRepository userRepository) {
        this.userTableRepository = userTableRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToNewTable() {
        return "authorized/new_table";
    }

    @PostMapping
    public String createNewTable(String name) {
        Board u = new Board();
        u.setName(name);
//        u.setUser();
        userTableRepository.save(u);
        return "";
    }

    @GetMapping("/{id}/column")
    public String goToNewBoardColumn(@PathVariable Long id) {
        return "/authorized/new_column";
    }

    @PostMapping("/{id}/column")
    public String createBoardColumn(@PathVariable Long id) {
        return "redirect:/board";
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String boardAction(Model model, @PathVariable("userId") Long userId) {
        userRepository.findById(userId).ifPresent(u -> {
            model.addAttribute("issues", u.getIssueList());
        });
        return "authorized/board";
    }

}
