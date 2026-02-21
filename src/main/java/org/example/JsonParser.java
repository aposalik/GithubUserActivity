package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {

    public List<Event> parseJson (String json) {
        Gson gson = new Gson();
        Type eventListType = new TypeToken <List<Event>>(){}.getType();
        List<Event> events = gson.fromJson(json, eventListType);

        return events;
    }
}
