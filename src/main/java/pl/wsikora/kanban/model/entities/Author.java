package pl.wsikora.kanban.model.entities;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "authors")
public class Author {

    @Id
    @SerializedName("id")
    private Long id;

    @SerializedName("username")
    private String userName;

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
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}
