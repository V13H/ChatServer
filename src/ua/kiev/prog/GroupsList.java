package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.models.ChatGroup;

import java.util.concurrent.ConcurrentHashMap;

public class GroupsList {
    private final static GroupsList groupsList = new GroupsList();
    private final ConcurrentHashMap<String,ChatGroup> groupsMap = new ConcurrentHashMap<>();

    private GroupsList() {
    }
    public static GroupsList getInstance(){
        return groupsList;
    }
    public void add(String user,ChatGroup group){
        groupsMap.put(user, group);
    }
    public static String toJSON(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(groupsList,GroupsList.class);
    }
}
