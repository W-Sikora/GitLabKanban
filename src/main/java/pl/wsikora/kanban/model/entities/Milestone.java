package pl.wsikora.kanban.model.entities;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "milestones")
public class Milestone {

    @Id
    private Long id;

    private String title;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "web_url")
    private String webUrl;

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
                Objects.equals(title, milestone.title) &&
                Objects.equals(dueDate, milestone.dueDate) &&
                Objects.equals(webUrl, milestone.webUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, dueDate, webUrl);
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }

}
