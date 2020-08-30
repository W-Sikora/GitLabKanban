package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.entities.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

    int countAllByUser(User user);

}
