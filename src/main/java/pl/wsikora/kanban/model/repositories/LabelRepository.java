package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.wsikora.kanban.model.entities.Label;
import pl.wsikora.kanban.model.entities.Project;

public interface LabelRepository extends JpaRepository<Label, Long> {

    Label getLabelByNameAndProject(String name, Project project);
}
