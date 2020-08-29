package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.User;
import pl.wsikora.kanban.model.entities.UserTable;

public interface UserTableRepository extends JpaRepository<UserTable, Long> {

    int countAllByUser(User user);


}
