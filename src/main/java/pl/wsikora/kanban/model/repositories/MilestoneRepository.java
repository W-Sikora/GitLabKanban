package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wsikora.kanban.model.entities.Label;
import pl.wsikora.kanban.model.entities.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

    @Query("select m from Milestone m where m.id = :id")
    Milestone findMilestoneById(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select count(*) from milestone m where m.id = :id")
    int countMilestoneById(@Param("id") Long id);
}
