package pl.wsikora.kanban.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "web_url")
    private String webUrl;

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(userName, author.userName) &&
                Objects.equals(webUrl, author.webUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, webUrl);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}
