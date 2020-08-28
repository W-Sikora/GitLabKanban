package pl.wsikora.kanban.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "assignees")
public class Assignee {
    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    public Assignee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignee assignee = (Assignee) o;
        return Objects.equals(id, assignee.id) &&
                Objects.equals(userName, assignee.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }

    @Override
    public String toString() {
        return "Assignee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
