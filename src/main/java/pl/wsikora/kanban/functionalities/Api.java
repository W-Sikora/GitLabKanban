package pl.wsikora.kanban.functionalities;


import com.google.gson.*;
import pl.wsikora.kanban.config.SslVerification;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Api {
    private String url;

    public Api() {
    }

    public Api url(String url) {
        this.url = url;
        return this;
    }

    public String getRawJson() {
        StringBuilder json = new StringBuilder();
        try {
            URL u = new URL(url);
            Reader reader = new InputStreamReader(u.openConnection().getInputStream());
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

    public JsonObject getJsonObject() {
        return new JsonParser().parse(getRawJson()).getAsJsonObject();
    }

//    public JsonArray getAllJsonArray(String url) {
//        StringBuilder result = new StringBuilder();
//        result.append("[");
//        JsonArray jsonArray;
//        int pageIndex = 1;
//        while ((jsonArray = url(url + "&page=" + pageIndex).getJsonArray()).size() > 0) {
//            for (JsonElement element : jsonArray) {
//                result.append(element);
//            }
//            result.append(",");
//
//            pageIndex++;
//        }
//        return  result;
//    }

    public <T> List<T> getEntitiesFromJson(String url, Class<T> type) {
        Gson gson = new Gson();
        List<T> entities = new ArrayList<>();
        JsonArray jsonArray;
        int pageIndex = 1;
        while ((jsonArray = url(url + "&page=" + pageIndex).getJsonArray()).size() > 0) {
            for (JsonElement jsonElement : jsonArray) {
                T entity = gson.fromJson(jsonElement.getAsJsonObject(), type);
                entities.add(entity);
            }
            pageIndex++;
        }
        return entities;
    }

    public <T> List<T> getInnerEntitiesFromJson(String url, Class<T> type, String jsonObject) {
        Gson gson = new Gson();
        List<T> entities = new ArrayList<>();
        JsonArray jsonArray;
        int pageIndex = 1;
        while ((jsonArray = url(url + "&page=" + pageIndex).getJsonArray()).size() > 0) {
            for (JsonElement jsonElement : jsonArray) {
                T entity = gson.fromJson(jsonElement.getAsJsonObject().get(jsonObject), type);
                entities.add(entity);
            }
            pageIndex++;
        }
        return entities;
    }

}
