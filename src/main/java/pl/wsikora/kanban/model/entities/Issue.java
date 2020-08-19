package pl.wsikora.kanban.model.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "issues")
public class Issue implements O {

    @Id
    private Long id;

    @Column(name = "project_id")
    @SerializedName("project_id")
    private Long projectId;

    @Column(name = "up_votes")
    @SerializedName("upvotes")
    private Integer upVotes;

    @Column(name = "down_votes")
    @SerializedName("downvotes")
    private Integer downVotes;

    private String title;

    @Column(length = 2000)
    private String description;

    private String state;

    @Column(name = "web_url")
    @SerializedName("web_url")
    private String webUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Label> labels;

    @Column(name = "due_date")
    @SerializedName("due_date")
    private LocalDate dueDate;

    @Column(name = "created_at")
    @SerializedName("created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @SerializedName("updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "closed_at")
    @SerializedName("closed_at")
    private LocalDateTime closedAt;

    @ManyToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public static class Builder {
        private Long id;
        private Long projectId;
        private Integer upVotes;
        private Integer downVotes;
        private String title;
        private String description;
        private String state;
        private String webUrl;
        private List<Label> labels;
        private LocalDate dueDate;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime closedAt;
        private Milestone milestone;
        private Author author;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder projectId(Long projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder upVotes(Integer upVotes) {
            this.upVotes = upVotes;
            return this;
        }

        public Builder downVotes(Integer downVotes) {
            this.downVotes = downVotes;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder webUrl(String webUrl) {
            this.webUrl = webUrl;
            return this;
        }

        public Builder labels(List<Label> labels) {
            this.labels = labels;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder closedAt(LocalDateTime closedAt) {
            this.closedAt = closedAt;
            return this;
        }

        public Builder milestone(Milestone milestone) {
            this.milestone = milestone;
            return this;
        }

        public Builder author(Author author) {
            this.author = author;
            return this;
        }

        public Issue build() {
            Issue issue = new Issue();
            issue.id = this.id;
            issue.projectId = this.projectId;
            issue.upVotes = this.upVotes;
            issue.downVotes = this.downVotes;
            issue.title = this.title;
            issue.description = this.description;
            issue.state = this.state;
            issue.webUrl = this.webUrl;
            issue.labels = this.labels;
            issue.dueDate = this.dueDate;
            issue.createdAt = this.createdAt;
            issue.updatedAt = this.updatedAt;
            issue.closedAt = this.closedAt;
            issue.milestone = this.milestone;
            issue.author = this.author;
            return issue;
        }

    }

    public static class JsonBuilder {
        private JsonObject object;
        private List<Label> labels;
        private Milestone milestone;
        private Author author;

        public JsonBuilder json(JsonObject object) {
            this.object = object;
            return this;
        }

        public JsonBuilder labels(List<Label> labels) {
            this.labels = labels;
            return this;
        }

        public JsonBuilder milestone(Milestone milestone) {
            this.milestone = milestone;
            return this;
        }

        public JsonBuilder author(Author author) {
            this.author = author;
            return this;
        }

        public Issue build() {
            Issue issue = new Issue();

            JsonElement jsonId = this.object.get("id");
            if (!jsonId.isJsonNull()) {
                issue.id = jsonId.getAsLong();
            }

            JsonElement jsonProjectId = this.object.get("project_id");
            if (!jsonProjectId.isJsonNull()) {
                issue.projectId = jsonProjectId.getAsLong();
            }

            JsonElement jsonUpVotes = this.object.get("upvotes");
            if (!jsonUpVotes.isJsonNull()) {
                issue.upVotes = jsonUpVotes.getAsInt();
            }

            JsonElement jsonDownVotes = this.object.get("downvotes");
            if (!jsonDownVotes.isJsonNull()) {
                issue.downVotes = jsonDownVotes.getAsInt();
            }

            JsonElement jsonTitle = this.object.get("title");
            if (!jsonTitle.isJsonNull()) {
                issue.title = jsonTitle.getAsString();
            }

            JsonElement jsonDescription = this.object.get("description");
            if (!jsonDescription.isJsonNull()) {
                issue.description = jsonDescription.getAsString();
            }

            JsonElement jsonState = this.object.get("state");
            if (!jsonState.isJsonNull()) {
                issue.state = jsonState.getAsString();
            }

            JsonElement jsonWebUrl = this.object.get("web_url");
            if (!jsonWebUrl.isJsonNull()) {
                issue.webUrl = jsonWebUrl.getAsString();
            }

            JsonElement jsonDueDate = this.object.get("due_date");
            if (!jsonDueDate.isJsonNull()) {
                issue.dueDate = LocalDate.parse(jsonDueDate.getAsString());
            }

            JsonElement jsonCreatedAt = this.object.get("created_at");
            if (!jsonCreatedAt.isJsonNull()) {
                String date = jsonCreatedAt.getAsString();
                issue.createdAt = LocalDateTime.parse(date.substring(0, date.length() - 1));
            }

            JsonElement jsonUpdatedAt = this.object.get("updated_at");
            if (!jsonUpdatedAt.isJsonNull()) {
                String date = jsonCreatedAt.getAsString();
                issue.updatedAt = LocalDateTime.parse(date.substring(0, date.length() - 1));
            }

            JsonElement jsonClosedAt = this.object.get("closed_at");
            if (!jsonClosedAt.isJsonNull()) {
                String date = jsonCreatedAt.getAsString();
                issue.closedAt = LocalDateTime.parse(date.substring(0, date.length() - 1));
            }

            if (labels != null) {
                issue.labels = this.labels;
            }

            if (milestone != null) {
                issue.milestone = this.milestone;
            }

            if (author != null) {
                issue.author = this.author;
            }

            return issue;
        }

    }

    public Issue() {
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

    public Integer getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Integer downVotes) {
        this.downVotes = downVotes;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id) &&
                Objects.equals(projectId, issue.projectId) &&
                Objects.equals(upVotes, issue.upVotes) &&
                Objects.equals(downVotes, issue.downVotes) &&
                Objects.equals(title, issue.title) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(state, issue.state) &&
                Objects.equals(webUrl, issue.webUrl) &&
                Objects.equals(labels, issue.labels) &&
                Objects.equals(dueDate, issue.dueDate) &&
                Objects.equals(createdAt, issue.createdAt) &&
                Objects.equals(updatedAt, issue.updatedAt) &&
                Objects.equals(closedAt, issue.closedAt) &&
                Objects.equals(milestone, issue.milestone) &&
                Objects.equals(author, issue.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, upVotes, downVotes, title, description, state, webUrl, labels, dueDate, createdAt, updatedAt, closedAt, milestone, author);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", labels=" + labels +
                ", dueDate=" + dueDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", closedAt=" + closedAt +
                ", milestone=" + milestone +
                ", author=" + author +
                '}';
    }

}
