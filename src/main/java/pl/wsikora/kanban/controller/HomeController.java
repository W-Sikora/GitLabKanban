package pl.wsikora.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToIndex() {
        return "index";
    }


    @RequestMapping(value = "/api/docs", method = RequestMethod.GET)
    public String goToApiDocs() {
        return "/api";
    }

}
