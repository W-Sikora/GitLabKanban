package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.Group;
import pl.wsikora.kanban.model.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
