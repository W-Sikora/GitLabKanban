package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wsikora.kanban.model.entities.Board;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.repositories.UserRepository;
import pl.wsikora.kanban.model.repositories.BoardRepository;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    public DashboardController(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToDashboard(Principal principal, Board board, Model model) {
        User user = userRepository.findByEmail(principal.getName());
        List<Board> recentlyCreated = boardRepository.findTop5GroupByCreatedAtDesc();
        if (board != null) {
            model.addAttribute("board", board);
        }
        model.addAttribute("user", user)
                .addAttribute("boardsNb", boardRepository.countAllByUser(user))
                .addAttribute("projectsNb", userRepository.countAllProjectsByUserId(user.getId()))
                .addAttribute("issuesNb", userRepository.countAllIssuesByUser(user))
                .addAttribute("recentlyCreated", recentlyCreated);

        return "authorized/dashboard";
    }

    @PostMapping("/find")
    public String findBoard(Principal principal, String name, RedirectAttributes redirectAttributes) {
        User user = userRepository.findByEmail(principal.getName());
        boardRepository.findByUserAndName(user, name)
                .ifPresent(v -> redirectAttributes.addAttribute("board", v));
        return "redirect:/dashboard";
    }

    @GetMapping("/settings")
    public String goToSettings() {
        return "authorized/settings";
    }

    @GetMapping("/other")
    public String goToOther() {
        return "authorized/other";
    }

}
