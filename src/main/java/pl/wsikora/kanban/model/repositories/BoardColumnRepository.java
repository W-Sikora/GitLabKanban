package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.wsikora.kanban.model.entities.BoardColumn;

@RestResource
public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {
}
