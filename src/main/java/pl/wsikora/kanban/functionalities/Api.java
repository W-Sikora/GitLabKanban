package pl.wsikora.kanban.functionalities;


import com.google.gson.*;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

public class Api {

    private JsonParser parser = new JsonParser();

    public Api() {
    }

    public String getJson(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL u = new URL(url);
            URLConnection connection = u.openConnection();
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(8000);
            Reader reader = new InputStreamReader(connection.getInputStream());
            int ascii;
            while ((ascii = reader.read()) != -1) {
                json.append((char) ascii);
            }
            reader.close();
        } catch (SocketTimeoutException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public JsonArray getWholeJsonArray(String url) {
        String json;
        StringBuilder string = new StringBuilder();
        Set<String> emptySigns = Set.of("", "[]", "{}");
        int pageIndex = 1;
        while ((json = getJson(url + "&page=" + pageIndex)).length() > 0
                && !emptySigns.contains(json)) {
            if (pageIndex == 1) {
                string.append(json, 0, json.length() - 1);
            } else {
                string.append(json, 1, json.length() - 1);
            }
            pageIndex++;
        }
        if (string.length() > 0) {
            string.append("]");
            return parse(string.toString()).getAsJsonArray();
        } else {
            return new JsonArray();
        }
    }

    private JsonElement parse(String json) {
        return parser.parse(json);
    }

}
