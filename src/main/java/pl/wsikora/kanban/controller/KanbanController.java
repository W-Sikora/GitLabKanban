package pl.wsikora.kanban.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.kanban.functionalities.Api;
import pl.wsikora.kanban.model.entities.Issue;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class KanbanController {
    private Api api = new Api();

//    @RequestMapping("/issues")
//    public List<Issue> read() {
//        api.url("")
//
//        return ;
//    }
}
