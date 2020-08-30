package pl.wsikora.kanban.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.wsikora.kanban.model.entities.User;

@RestResource
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("select u.issueList.size from User u where u = :user")
    int countAllIssuesByUser(@Param("user") User user);

    @Query(nativeQuery = true, value = "select count(distinct i.project_id) from users_issue_list join issues i on users_issue_list.issue_list_id = i.id where user_id = :userId")
    int countAllProjectsByUserId(@Param("userId") long userId);

}
