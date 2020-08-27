package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.Assignee;
import pl.wsikora.kanban.model.entities.Label;
import pl.wsikora.kanban.model.entities.Project;

public interface LabelRepository extends JpaRepository<Label, Long> {

    Label findByProjectAndName(Project project, String name);
}
