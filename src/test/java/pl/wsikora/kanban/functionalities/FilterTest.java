//package pl.wsikora.kanban.functionalities;
//
//import org.junit.jupiter.api.Test;
//import pl.wsikora.kanban.model.entities.Author;
//import pl.wsikora.kanban.model.entities.Issue;
//import pl.wsikora.kanban.model.entities.Milestone;
//
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FilterTest {
//
//    private List<Issue> getDemoList() {
//        List<Issue> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Author author = new Author.Builder()
//                    .userName("user name" + i)
//                    .build();
//            Milestone milestone = new Milestone.Builder()
//                    .title("milestone title" + i)
//                    .build();
//            Issue issue = new Issue.Builder()
//                    .title("title" + i)
//                    .author(author)
//                    .state("opened" + i)
//                    .milestone(milestone)
//                    .labels(List.of("label" + i, "Label" + i))
//                    .build();
//            list.add(issue);
//        }
//        return list;
//    }
//
//    @Test
//    void getByTitle() {
//        List<Issue> list = getDemoList();
//        Filter f1 = new Filter(list), f2 = new Filter(list), f3 = new Filter(list);
//        f1.getByTitle("title2");
//        f2.getByTitle("title");
//        f3.getByTitle("demo");
//        assertEquals(list.get(2), f1.getAsList().get(0));
//        assertEquals(list, f2.getAsList());
//        assertEquals(Collections.EMPTY_LIST, f3.getAsList());
//    }
//
//    @Test
//    void getByAuthor() {
//        List<Issue> list = getDemoList();
//        Filter f1 = new Filter(list), f2 = new Filter(list), f3 = new Filter(list);
//        f1.getByAuthor("user name3");
//        f2.getByAuthor("use");
//        f3.getByAuthor("p");
//        assertEquals(list.get(3), f1.getAsList().get(0));
//        assertEquals(list, f2.getAsList());
//        assertEquals(Collections.EMPTY_LIST, f3.getAsList());
//    }
//
//    @Test
//    void getByState() {
//        List<Issue> list = getDemoList();
//        Filter f1 = new Filter(list), f2 = new Filter(list), f3 = new Filter(list);
//        f1.getByState("opened0");
//        f2.getByTitle("op");
//        f3.getByTitle("demo");
//        assertEquals(list.get(0), f1.getAsList().get(0));
//        assertEquals(Collections.EMPTY_LIST, f2.getAsList());
//        assertEquals(Collections.EMPTY_LIST, f3.getAsList());
//    }
//
//    @Test
//    void getByMilestone() {
//        List<Issue> list = getDemoList();
//        Filter f1 = new Filter(list), f2 = new Filter(list), f3 = new Filter(list);
//        f1.getByMilestone("milestone title1");
//        f2.getByMilestone("o");
//        f3.getByMilestone("demo");
//        assertEquals(list.get(1), f1.getAsList().get(0));
//        assertEquals(list, f2.getAsList());
//        assertEquals(Collections.EMPTY_LIST, f3.getAsList());
//    }
//
//    @Test
//    void getByLabels() {
//        List<Issue> list = getDemoList();
//        Filter f1 = new Filter(list), f2 = new Filter(list), f3 = new Filter(list);
//        f1.getByLabels("label1");
//        f2.getByLabels("label");
//        f3.getByLabels("demo");
//        assertEquals(list.get(1), f1.getAsList().get(0));
//        assertEquals(Collections.EMPTY_LIST, f2.getAsList());
//        assertEquals(Collections.EMPTY_LIST, f3.getAsList());
//    }
//
//}
