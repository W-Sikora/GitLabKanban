package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.entities.UserTable;
import pl.wsikora.kanban.model.repositories.UserRepository;
import pl.wsikora.kanban.model.repositories.UserTableRepository;

@Controller
@RequestMapping("/board")
public class UserTableController {

    private UserTableRepository userTableRepository;
    private UserRepository userRepository;

    public UserTableController(UserTableRepository userTableRepository, UserRepository userRepository) {
        this.userTableRepository = userTableRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToNewTable() {
        return "authorized/new_table";
    }

    @PostMapping
    public String createNewTable(String name) {
        UserTable u = new UserTable();
        u.setName(name);
//        u.setUser();
        userTableRepository.save(u);
        return "";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String boardAction(Model model, @PathVariable("userId") Long userId) {
        userRepository.findById(userId).ifPresent(u -> {
            model.addAttribute("issues", u.getIssueList());
        });
        return "authorized/board";
    }

}
