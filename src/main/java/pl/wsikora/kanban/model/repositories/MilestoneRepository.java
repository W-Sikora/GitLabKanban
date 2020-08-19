package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.kanban.model.entities.Author;
import pl.wsikora.kanban.model.entities.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

    @Query("select m from Milestone m where m.id = :id")
    Milestone getMilestoneById(@Param("id") Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Milestone m set m.description = :description, m.projectId = :projectId, m.title = :title, m.webUrl = :webUrl where m.id = :id")
    void update(@Param("id") Long id,
                @Param("description") String description,
                @Param("projectId") Long projectId,
                @Param("title") String title,
                @Param("webUrl") String webUrl);
}
