package pl.wsikora.kanban.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "labels")
public class Label {

    @Id
    private Long id;

    private String name;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "text_color")
    private String textColor;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Label() {
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

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(id, label.id) &&
                Objects.equals(name, label.name) &&
                Objects.equals(backgroundColor, label.backgroundColor) &&
                Objects.equals(textColor, label.textColor) &&
                Objects.equals(project, label.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, backgroundColor, textColor, project);
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", textColor='" + textColor + '\'' +
                ", project=" + project +
                '}';
    }
}
