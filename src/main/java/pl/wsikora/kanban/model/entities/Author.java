package pl.wsikora.kanban.model.entities;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author implements O {

    @Id
    private Long id;

    private String name;

    @Column(name = "user_name")
    @SerializedName("username")
    private String userName;

    @Column(name = "web_url")
    @SerializedName("web_url")
    private String webUrl;

    public Author() {
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
                Objects.equals(name, author.name) &&
                Objects.equals(userName, author.userName) &&
                Objects.equals(webUrl, author.webUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userName, webUrl);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }

}
