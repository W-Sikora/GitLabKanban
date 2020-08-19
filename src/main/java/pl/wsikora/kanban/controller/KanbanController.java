package pl.wsikora.kanban.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.kanban.model.entities.Author;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class KanbanController {

//    @RequestMapping("/author")
//    public List<Author> read() {
//        List<Author> authors = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Author author = new Author.Builder()
//                    .id((long) i)
//                    .name("name")
//                    .userName("user")
//                    .build();
//            authors.add(author);
//        }
//
//        return authors;
//    }
}
