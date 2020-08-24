package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.Author;
import pl.wsikora.kanban.model.entities.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
