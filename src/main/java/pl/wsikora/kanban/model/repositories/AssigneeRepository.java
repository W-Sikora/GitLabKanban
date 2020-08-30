package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.Assignee;

public interface AssigneeRepository extends JpaRepository<Assignee, Long> {
}
