package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsikora.kanban.model.entities.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p.id from Project p")
    List<Long> getAllIds();
}
