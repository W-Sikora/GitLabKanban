package pl.wsikora.kanban.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "board")
public class Board {

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
    private List<BoardColumn> boardColumns = new ArrayList<>();

    public Board() {
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

    public List<BoardColumn> getBoardColumns() {
        return boardColumns;
    }

    public void setBoardColumns(List<BoardColumn> userTableColumns) {
        this.boardColumns = userTableColumns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board userTable = (Board) o;
        return Objects.equals(id, userTable.id) &&
                Objects.equals(name, userTable.name) &&
                Objects.equals(user, userTable.user) &&
                Objects.equals(boardColumns, userTable.boardColumns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, user, boardColumns);
    }

    @Override
    public String
    toString() {
        return "UserTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", userTableColumns=" + boardColumns +
                '}';
    }

}
