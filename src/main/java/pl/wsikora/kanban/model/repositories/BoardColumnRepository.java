package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.BoardColumn;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {

}
