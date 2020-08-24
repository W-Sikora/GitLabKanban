package pl.wsikora.kanban.model.entities;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "milestones")
public class Milestone {

    @Id
    @SerializedName("id")
    private Long id;

    @SerializedName("title")
    private String title;

    @SerializedName("state")
    private String state;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("due_date")
    private String dueDate;

    @SerializedName("web_url")
    private String webUrl;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Milestone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
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
        Milestone milestone = (Milestone) o;
        return Objects.equals(id, milestone.id) &&
                Objects.equals(title, milestone.title) &&
                Objects.equals(state, milestone.state) &&
                Objects.equals(createdAt, milestone.createdAt) &&
                Objects.equals(updatedAt, milestone.updatedAt) &&
                Objects.equals(dueDate, milestone.dueDate) &&
                Objects.equals(webUrl, milestone.webUrl) &&
                Objects.equals(project, milestone.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, state, createdAt, updatedAt, dueDate, webUrl, project);
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", state='" + state + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", project=" + project +
                '}';
    }

}
