package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.wsikora.kanban.model.entities.Author;
import pl.wsikora.kanban.model.entities.Milestone;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.id = :id")
    Author getAuthorById(@Param("id") Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Author a set a.name = :name, a.userName = :userName, a.webUrl = :webUrl where a.id = :id")
    void update(@Param("id") Long id,
                @Param("name") String name,
                @Param("userName") String userName,
                @Param("webUrl") String webUrl);


}
