package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wsikora.kanban.model.entities.Label;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Long> {

    @Query("select l from Label l where l.name = :name")
    Label getMilestoneByName(@Param("name") String name);

    @Query("select l from Label l where l.name in :names")
    List<Label> getAllByNames(@Param("names") List<String> name);

}
