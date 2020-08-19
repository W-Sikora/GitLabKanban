package pl.wsikora.kanban.functionalities;


import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import pl.wsikora.kanban.config.SslVerification;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class Api {
    private String link;

    public Api() {
    }

    private String getRawJson() {
        SslVerification ssl = new SslVerification();
        ssl.disable();
        StringBuilder json = new StringBuilder();
        try {
            URL url = new URL(link);
            Reader reader = new InputStreamReader(url.openConnection().getInputStream());
            int ascii;
            while ((ascii = reader.read()) != -1) {
                json.append((char) ascii);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public JsonArray getJsonArray() {
        return new JsonParser().parse(getRawJson()).getAsJsonArray();
    }

    public String getLink() {
        return link;
    }

    public Api setLink(String link) {
        this.link = link;
        return this;
    }

}
