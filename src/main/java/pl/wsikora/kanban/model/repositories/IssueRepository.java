package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wsikora.kanban.model.entities.Author;
import pl.wsikora.kanban.model.entities.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    @Query("select i from Issue i where i.id = :id")
    Issue getIssueById(@Param("id") Long id);

}
