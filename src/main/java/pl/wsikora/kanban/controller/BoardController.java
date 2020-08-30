package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.kanban.model.entities.Board;
import pl.wsikora.kanban.model.repositories.UserRepository;
import pl.wsikora.kanban.model.repositories.BoardRepository;

import java.security.Principal;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    public BoardController(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToNewTable() {
        return "redirect:/dashboard";
    }

    @PostMapping
    public String createNewTable(String name, Principal principal) {
        Board b = new Board();
        b.setName(name);
        b.setUser(userRepository.findByEmail(principal.getName()));
        boardRepository.save(b);
        System.out.println(b.getId());
        return "redirect:/dashboard";
    }

    @GetMapping("/{id}")
    public String goToBoard(@PathVariable Long id, Model model) {
        boardRepository.findById(id)
                .ifPresent(v -> model.addAttribute("board", v));
        return "authorized/board";
    }

//    @GetMapping("/{id}/column")
//    public String goToNewBoardColumn(@PathVariable Long id) {
//        return "/authorized/new_column";
//    }
//
//    @PostMapping("/{id}/column")
//    public String createBoardColumn(@PathVariable Long id) {
//        return "redirect:/board";
//    }

}
