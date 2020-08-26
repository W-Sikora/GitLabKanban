package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wsikora.kanban.model.entities.Author;
import pl.wsikora.kanban.model.entities.Issue;
import pl.wsikora.kanban.model.entities.Project;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    @Query("select i from Issue i where i.project in :projects")
    List<Issue> getAllByProjectIn(@Param("projects") List<Project> projects);

}
