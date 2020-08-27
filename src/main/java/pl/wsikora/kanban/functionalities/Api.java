package pl.wsikora.kanban.functionalities;


import com.google.gson.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class Api {
    private Gson gson = new Gson();
    private JsonParser parser = new JsonParser();

    public Api() {
    }

    public String getJson(String url) {
        int TIMEOUT_VALUE = 2000;
        StringBuilder json = new StringBuilder();
        try {
            URL u = new URL(url);
            URLConnection connection = u.openConnection();
            connection.setConnectTimeout(TIMEOUT_VALUE);
            connection.setReadTimeout(TIMEOUT_VALUE);
            Reader reader = new InputStreamReader(connection.getInputStream());
            int ascii;
            while ((ascii = reader.read()) != -1) {
                json.append((char) ascii);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public JsonArray getJsonArray(String url) {
        return parse(getJson(url)).getAsJsonArray();
    }

    public JsonObject getJsonObject(String url) {
        return parse(getJson(url)).getAsJsonObject();
    }

    public JsonArray getWholeJson(String url) {
        StringBuilder string = new StringBuilder();
        String json;
        int pageIndex = 1;
        while (!(json = getJson(url + "&page=" + pageIndex)).equals("[]")) {
            if (pageIndex == 1) {
                string.append(json, 0, json.length() - 1);
            } else {
                string.append(json, 1, json.length() - 1);
            }
            pageIndex++;
        }
        if (string.length() > 0) {
            string.append("]");
        }

        JsonElement element = parse(string.toString());
        if (!element.isJsonNull()) {
            return element.getAsJsonArray();
        } else {
            return null;
        }
    }

    private JsonElement parse(String json) {
        return parser.parse(json);
    }

}
