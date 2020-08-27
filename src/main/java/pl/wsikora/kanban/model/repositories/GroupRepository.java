package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
