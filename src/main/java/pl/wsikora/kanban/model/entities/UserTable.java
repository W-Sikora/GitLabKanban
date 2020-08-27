//package pl.wsikora.kanban.model.entities;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "users_tables")
//public class UserTable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "user_table")
//    @JoinColumn(name = "users_tables_id")
//    private List<UserTableColumn> userTableColumns = new ArrayList<>();
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public UserTable() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<UserTableColumn> getUserTableColumns() {
//        return userTableColumns;
//    }
//
//    public void setUserTableColumns(List<UserTableColumn> userTableColumns) {
//        this.userTableColumns = userTableColumns;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
