package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String goToIndex() {
        return "/index";
    }

    @GetMapping("/api/docs")
    public String goToApiDocs() {
        return "/api";
    }

    @GetMapping("/terms-conditions")
    public String goToTermsAndConditions() {
        return "/terms&conditions";
    }

    @GetMapping("/logout")
    public String logOut() {
        return "/authorized/logout";
    }

}
