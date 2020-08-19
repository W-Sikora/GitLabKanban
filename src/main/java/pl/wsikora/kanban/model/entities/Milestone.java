package pl.wsikora.kanban.model.entities;


import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "milestones")
public class Milestone implements O {

    @Id
    private Long id;

    @Column(name = "project_id")
    @SerializedName("project_id")
    private Long projectId;

    private String title;

    private String description;

    @Column(name = "web_url")
    @SerializedName("web_url")
    private String webUrl;

    public Milestone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milestone milestone = (Milestone) o;
        return Objects.equals(id, milestone.id) &&
                Objects.equals(projectId, milestone.projectId) &&
                Objects.equals(title, milestone.title) &&
                Objects.equals(description, milestone.description) &&
                Objects.equals(webUrl, milestone.webUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, title, description, webUrl);
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }

}
