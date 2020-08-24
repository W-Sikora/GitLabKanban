package pl.wsikora.kanban.model.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import pl.wsikora.kanban.model.repositories.AuthorRepository;
import pl.wsikora.kanban.model.repositories.LabelRepository;
import pl.wsikora.kanban.model.repositories.MilestoneRepository;
import pl.wsikora.kanban.model.repositories.ProjectRepository;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "issues")
public class Issue {

    @Id
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String state;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime closedAt;

    private Integer upVotes;

    private Integer downVotes;

    private LocalDate dueDate;

    private String webUrl;

    @ManyToMany
    private List<Label> labels = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public static class JsonBuilder {
        private JsonObject object;
        private AuthorRepository authorRepository;
        private LabelRepository labelRepository;
        private MilestoneRepository milestoneRepository;
        private ProjectRepository projectRepository;

        public JsonBuilder json(JsonObject object) {
            this.object = object;
            return this;
        }

        public JsonBuilder authorRepository(AuthorRepository authorRepository) {
            this.authorRepository = authorRepository;
            return this;
        }

        public JsonBuilder labelRepository(LabelRepository labelRepository) {
            this.labelRepository = labelRepository;
            return this;
        }

        public JsonBuilder milestoneRepository(MilestoneRepository milestoneRepository) {
            this.milestoneRepository = milestoneRepository;
            return this;
        }

        public JsonBuilder projectRepository(ProjectRepository projectRepository) {
            this.projectRepository = projectRepository;
            return this;
        }

        public Issue build() {
            Issue issue = new Issue();

            JsonElement jsonId = this.object.get("id");
            if (!jsonId.isJsonNull()) {
                issue.id = jsonId.getAsLong();
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

            JsonElement jsonCreatedAt = this.object.get("created_at");
            if (!jsonCreatedAt.isJsonNull()) {
                String part = jsonCreatedAt.getAsString();
                issue.createdAt = LocalDateTime.parse(part.substring(0, part.length() - 1));
            }

            JsonElement jsonUpdatedAt = this.object.get("updated_at");
            if (!jsonUpdatedAt.isJsonNull()) {
                String part = jsonUpdatedAt.getAsString();
                issue.updatedAt = LocalDateTime.parse(part.substring(0, part.length() - 1));
            }

            JsonElement jsonClosedAt = this.object.get("closed_at");
            if (!jsonClosedAt.isJsonNull()) {
                String part = jsonClosedAt.getAsString();
                issue.closedAt = LocalDateTime.parse(part.substring(0, part.length() - 1));
            }

            JsonElement jsonUpVotes = this.object.get("upvotes");
            if (!jsonUpVotes.isJsonNull()) {
                issue.upVotes = jsonUpVotes.getAsInt();
            }

            JsonElement jsonDownVotes = this.object.get("downvotes");
            if (!jsonDownVotes.isJsonNull()) {
                issue.downVotes = jsonDownVotes.getAsInt();
            }

            JsonElement jsonDueDate = this.object.get("due_date");
            if (!jsonDueDate.isJsonNull()) {
                issue.dueDate = LocalDate.parse(jsonDueDate.getAsString());
            }

            JsonElement jsonWebUrl = this.object.get("web_url");
            if (!jsonWebUrl.isJsonNull()) {
                issue.webUrl = jsonWebUrl.getAsString();
            }

            JsonElement jsonMilestone = this.object.get("milestone");
            if(!jsonMilestone.isJsonNull()) {
                JsonElement jsonMilestoneId = jsonMilestone.getAsJsonObject().get("id");
                if (!jsonMilestoneId.isJsonNull()) {
                    long id = jsonMilestoneId.getAsLong();
                    Optional<Milestone> milestone = milestoneRepository.findById(id);
                    milestone.ifPresent(value -> issue.milestone = value);
                }
            }

            JsonElement jsonAuthor = this.object.get("author");
            if(!jsonAuthor.isJsonNull()) {
                JsonElement jsonAuthorId = jsonAuthor.getAsJsonObject().get("id");
                if (!jsonAuthorId.isJsonNull()) {
                    long id = jsonAuthorId.getAsLong();
                    Optional<Author> author = authorRepository.findById(id);
                    author.ifPresent(value -> issue.author = value);
                }
            }

            JsonElement jsonProjectId = this.object.get("project_id");
            if (!jsonProjectId.isJsonNull()) {
                long id = jsonProjectId.getAsLong();
                Optional<Project> project = projectRepository.findById(id);
                project.ifPresent(value -> issue.project = value);
            }

            JsonElement jsonLabels = this.object.get("labels");
            List<Label> labels = new ArrayList<>();
            for (JsonElement labelName : jsonLabels.getAsJsonArray()) {
                String name = labelName.getAsString();
                labels.add(labelRepository.getLabelByNameAndProject(name, issue.project));
            }
            issue.labels = labels;

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

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
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
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id) &&
                Objects.equals(title, issue.title) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(state, issue.state) &&
                Objects.equals(createdAt, issue.createdAt) &&
                Objects.equals(updatedAt, issue.updatedAt) &&
                Objects.equals(closedAt, issue.closedAt) &&
                Objects.equals(upVotes, issue.upVotes) &&
                Objects.equals(downVotes, issue.downVotes) &&
                Objects.equals(dueDate, issue.dueDate) &&
                Objects.equals(webUrl, issue.webUrl) &&
                Objects.equals(labels, issue.labels) &&
                Objects.equals(milestone, issue.milestone) &&
                Objects.equals(author, issue.author) &&
                Objects.equals(project, issue.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, state, createdAt, updatedAt, closedAt, upVotes, downVotes, dueDate, webUrl, labels, milestone, author, project);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", closedAt=" + closedAt +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", dueDate=" + dueDate +
                ", webUrl='" + webUrl + '\'' +
                ", labels=" + labels +
                ", milestone=" + milestone +
                ", author=" + author +
                ", project=" + project +
                '}';
    }
}
