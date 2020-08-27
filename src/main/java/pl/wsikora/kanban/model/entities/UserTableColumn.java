//package pl.wsikora.kanban.model.entities;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "users_tables_columns")
//public class UserTableColumn {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "user_table_column")
//    @JoinColumn(name = "users_tables_columns_id")
//    private List<Issue> issues = new ArrayList<>();
//
//    public UserTableColumn() {
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
//    public List<Issue> getIssues() {
//        return issues;
//    }
//
//    public void setIssues(List<Issue> issues) {
//        this.issues = issues;
//    }
//}
