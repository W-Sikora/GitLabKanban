package pl.wsikora.kanban.model.entities;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "labels")
public class Label {

    @Id
    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("color")
    private String color;

    @SerializedName("text_color")
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
                Objects.equals(color, label.color) &&
                Objects.equals(textColor, label.textColor) &&
                Objects.equals(project, label.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, textColor, project);
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", textColor='" + textColor + '\'' +
                ", project=" + project +
                '}';
    }

}
