package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.UserTableColumn;

public interface UserTableColumnRepository extends JpaRepository<UserTableColumn, Long> {

}
