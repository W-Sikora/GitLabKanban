package pl.wsikora.kanban.functionalities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import pl.wsikora.kanban.model.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class JsonConverter {

    public JsonConverter() {
    }

    public Assignee toAssignee(JsonObject o) {
        Assignee a = new Assignee();
        a.setId(o.get("id").getAsLong());
        JsonElement username = o.get("username");
        if (!username.isJsonNull()) {
            a.setUserName(username.getAsString());
        }
        return a;
    }

    public Author toAuthor(JsonObject o) {
        Author a = new Author();
        a.setId(o.get("id").getAsLong());
        JsonElement userName = o.get("username");
        if (!userName.isJsonNull()) {
            a.setUserName(userName.getAsString());
        }
        JsonElement webUrl = o.get("web_url");
        if (!webUrl.isJsonNull()) {
            a.setWebUrl(o.get("web_url").getAsString());
        }
        return a;
    }

    public Group toGroup(JsonObject o) {
        Group g = new Group();
        g.setId(o.get("id").getAsLong());
        JsonElement name = o.get("name");
        if (!name.isJsonNull()) {
            g.setName(name.getAsString());
        }
        JsonElement webUrl = o.get("web_url");
        if (!webUrl.isJsonNull()) {
            g.setWebUrl(webUrl.getAsString());
        }
        return g;
    }

    public Issue toIssue(JsonObject o) {
        Issue i = new Issue();
        i.setId(o.get("id").getAsLong());
        JsonElement title = o.get("title");
        if (!title.isJsonNull()) {
            i.setTitle(title.getAsString());
        }
        JsonElement description = o.get("description");
        if (!description.isJsonNull()) {
            i.setDescription(description.getAsString());
        }
        JsonElement state = o.get("state");
        if (!state.isJsonNull()) {
            i.setState(state.getAsString());
        }
        JsonElement createdAt = o.get("created_at");
        if (!createdAt.isJsonNull()) {
            i.setCreatedAt(dateTimeParser(createdAt));
        }
        JsonElement updatedAt = o.get("updated_at");
        if (!updatedAt.isJsonNull()) {
            i.setUpdatedAt(dateTimeParser(updatedAt));
        }
        JsonElement dueDate = o.get("due_date");
        if (!dueDate.isJsonNull()) {
            i.setDueDate(dateParser(dueDate));
        }
        JsonElement upVotes = o.get("upvotes");
        if (!upVotes.isJsonNull()) {
            i.setUpVotes(upVotes.getAsInt());
        }
        JsonElement downVotes = o.get("downvotes");
        if (!downVotes.isJsonNull()) {
            i.setDownVotes(downVotes.getAsInt());
        }
        JsonElement webUrl = o.get("web_url");
        if (!webUrl.isJsonNull()) {
            i.setWebUrl(webUrl.getAsString());
        }
        return i;
    }

    public Label toLabel(JsonObject o) {
        Label l = new Label();
        l.setId(o.get("id").getAsLong());
        JsonElement name = o.get("name");
        if (!name.isJsonNull()) {
            l.setName(name.getAsString());
        }
        JsonElement backgroundColor = o.get("color");
        if (!backgroundColor.isJsonNull()) {
            l.setBackgroundColor(backgroundColor.getAsString());
        }
        JsonElement textColor = o.get("text_color");
        if (!textColor.isJsonNull()) {
            l.setTextColor(textColor.getAsString());
        }
        return l;
    }

    public Milestone toMilestone(JsonObject o) {
        Milestone m = new Milestone();
        m.setId(o.get("id").getAsLong());
        JsonElement title = o.get("title");
        if (!title.isJsonNull()) {
            m.setTitle(title.getAsString());
        }
        JsonElement dueDate = o.get("due_date");
        if (!dueDate.isJsonNull()) {
            m.setDueDate(dateParser(dueDate));
        }
        JsonElement webUrl = o.get("web_url");
        if (!webUrl.isJsonNull()) {
            m.setWebUrl(webUrl.getAsString());
        }
        return m;
    }

    public Project toProject(JsonObject o) {
        Project p = new Project();
        p.setId(o.get("id").getAsLong());
        JsonElement name = o.get("name");
        if (!name.isJsonNull()) {
            p.setName(name.getAsString());
        }
        JsonElement webUrl = o.get("web_url");
        if (!webUrl.isJsonNull()) {
            p.setWebUrl(webUrl.getAsString());
        }
        return p;
    }

    private LocalDateTime dateTimeParser(JsonElement dateTime) {
        String dT = dateTime.getAsString();
        return LocalDateTime.parse(dT.substring(0, dT.length() - 1));
    }

    private LocalDate dateParser(JsonElement date) {
        return LocalDate.parse(date.getAsString());
    }

}
