package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.entities.Board;

import java.util.List;
import java.util.Optional;


@RestResource
public interface BoardRepository extends JpaRepository<Board, Long> {

    int countAllByUser(User user);

    Optional<Board> findByUserAndName(User user, String name);

    @Query(nativeQuery = true, value = "select * from boards order by created_at desc limit 5")
    List<Board> findTop5GroupByCreatedAtDesc();

//    @Query(nativeQuery = true, value = "select * from boards order by updated_at desc limit 5")
//    List<Board> findTop5GroupByUpdatedAtDesc();

}
