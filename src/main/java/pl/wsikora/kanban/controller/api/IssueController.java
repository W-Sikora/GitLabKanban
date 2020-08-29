//package pl.wsikora.kanban.controller.rest;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.rest.webmvc.RepositoryRestController;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import pl.wsikora.kanban.model.entities.Issue;
//import pl.wsikora.kanban.model.repositories.IssueRepository;
//
//@RepositoryRestController
//public class IssueController {
//
//    private IssueRepository issueRepository;
//
//    public IssueController(IssueRepository issueRepository) {
//        this.issueRepository = issueRepository;
//    }
//
////    @RequestMapping(name = "/movies/search/query", method = RequestMethod.GET)
////    public ResponseEntity<?> query(@RequestParam("q") String query, Pageable pageable) {
////        Page<Issue> page = issueRepository.search(QueryBuilders.queryStringQuery(query), pageable);
////        return ResponseEntity.ok(page.getContent());
////    }
//
//}
