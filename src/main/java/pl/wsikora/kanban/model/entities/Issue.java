package pl.wsikora.kanban.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "issues")
public class Issue {

    @Id
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String state;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "up_votes")
    private Integer upVotes;

    @Column(name = "down_votes")
    private Integer downVotes;

    @Column(name = "web_url")
    private String webUrl;

    @OneToMany
    @JoinColumn(name = "issue_id")
    private List<Assignee> assignees = new ArrayList<>();

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

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
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
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id) &&
                Objects.equals(title, issue.title) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(state, issue.state) &&
                Objects.equals(createdAt, issue.createdAt) &&
                Objects.equals(updatedAt, issue.updatedAt) &&
                Objects.equals(dueDate, issue.dueDate) &&
                Objects.equals(upVotes, issue.upVotes) &&
                Objects.equals(downVotes, issue.downVotes) &&
                Objects.equals(webUrl, issue.webUrl) &&
                Objects.equals(assignees, issue.assignees) &&
                Objects.equals(labels, issue.labels) &&
                Objects.equals(milestone, issue.milestone) &&
                Objects.equals(author, issue.author) &&
                Objects.equals(project, issue.project) &&
                Objects.equals(group, issue.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, state, createdAt, updatedAt, dueDate, upVotes, downVotes, webUrl, assignees, labels, milestone, author, project, group);
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
                ", dueDate=" + dueDate +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", webUrl='" + webUrl + '\'' +
                ", assignees=" + assignees +
                ", labels=" + labels +
                ", milestone=" + milestone +
                ", author=" + author +
                ", project=" + project +
                ", group=" + group +
                '}';
    }
}
