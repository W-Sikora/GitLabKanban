package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
}
