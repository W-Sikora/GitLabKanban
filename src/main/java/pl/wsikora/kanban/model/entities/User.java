package pl.wsikora.kanban.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String email;

    private String password;

    private String token;

    public User() {
    }

}
