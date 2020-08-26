package pl.wsikora.kanban.model.entities;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignees")
public class Assignee {

    @Id
    @SerializedName("id")
    private Long id;

    @SerializedName("username")
    private String username;

    public Assignee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
