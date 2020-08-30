package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.kanban.model.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
