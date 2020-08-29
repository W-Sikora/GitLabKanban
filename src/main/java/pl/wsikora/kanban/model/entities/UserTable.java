package pl.wsikora.kanban.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users_tables")
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "user_table_id")
    private List<UserTableColumn> userTableColumns = new ArrayList<>();

    public UserTable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserTableColumn> getUserTableColumns() {
        return userTableColumns;
    }

    public void setUserTableColumns(List<UserTableColumn> userTableColumns) {
        this.userTableColumns = userTableColumns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTable userTable = (UserTable) o;
        return Objects.equals(id, userTable.id) &&
                Objects.equals(name, userTable.name) &&
                Objects.equals(user, userTable.user) &&
                Objects.equals(userTableColumns, userTable.userTableColumns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, user, userTableColumns);
    }

    @Override
    public String
    toString() {
        return "UserTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", userTableColumns=" + userTableColumns +
                '}';
    }

}
