package pl.wsikora.kanban.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    private Long id;

    private String name;

    @Column(name = "web_url")
    private String webUrl;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Project() {
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

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(name, project.name) &&
                Objects.equals(webUrl, project.webUrl) &&
                Objects.equals(group, project.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, webUrl, group);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", group=" + group +
                '}';
    }
}
