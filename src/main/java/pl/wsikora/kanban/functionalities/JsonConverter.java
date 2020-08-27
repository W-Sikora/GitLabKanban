package pl.wsikora.kanban.functionalities;

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
        a.setUserName(o.get("username").getAsString());
        return a;
    }

    public Author toAuthor(JsonObject o) {
        Author a = new Author();
        a.setId(o.get("id").getAsLong());
        a.setUserName(o.get("username").getAsString());
        a.setWebUrl(o.get("web_url").getAsString());
        return a;
    }

    public Group toGroup(JsonObject o) {
        Group g = new Group();
        g.setId(o.get("id").getAsLong());
        g.setName(o.get("name").getAsString());
        g.setWebUrl(o.get("web_url").getAsString());
        return g;
    }

    public Issue toIssue(JsonObject o) {
        Issue i = new Issue();
        i.setId(o.get("id").getAsLong());
        i.setTitle(o.get("title").getAsString());
        i.setDescription(o.get("description").getAsString());
        i.setState(o.get("state").getAsString());
        i.setCreatedAt(dateTimeParser(o, "created_at"));
        i.setUpdatedAt(dateTimeParser(o, "updated_at"));
        i.setDueDate(dateParser(o, "due_date"));
        i.setUpVotes(o.get("upvotes").getAsInt());
        i.setDownVotes(o.get("downvotes").getAsInt());
        i.setWebUrl(o.get("web_url").getAsString());
        return i;
    }

    public Label toLabel(JsonObject o) {
        Label l = new Label();
        l.setId(o.get("id").getAsLong());
        l.setName(o.get("name").getAsString());
        l.setBackgroundColor(o.get("color").getAsString());
        l.setTextColor(o.get("text_color").getAsString());
        return l;
    }

    public Milestone toMilestone(JsonObject o) {
        Milestone m = new Milestone();
        m.setId(o.get("id").getAsLong());
        m.setTitle(o.get("title").getAsString());
        if (!o.get("due_date").isJsonNull()) {
            m.setDueDate(dateParser(o, "due_date"));
        }
        m.setWebUrl(o.get("web_url").getAsString());
        return m;
    }

    public Project toProject(JsonObject o) {
        Project p = new Project();
        p.setId(o.get("id").getAsLong());
        p.setName(o.get("name").getAsString());
        p.setWebUrl(o.get("web_url").getAsString());
        return p;
    }

    private LocalDateTime dateTimeParser(JsonObject object, String objectName) {
        String dateTime = object.get(objectName).getAsString();
        if (!dateTime.isEmpty()) {
            return LocalDateTime.parse(dateTime.substring(0, dateTime.length() - 1));
        } else {
            return null;
        }
    }

    private LocalDate dateParser(JsonObject object, String objectName) {
        String dateTime = object.get(objectName).getAsString();
        if (!dateTime.isEmpty()) {
            return LocalDate.parse(dateTime);
        } else {
            return null;
        }
    }

}
