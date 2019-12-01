package ua.kiev.prog.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.models.User;

import java.util.List;
import java.util.UUID;

public class ChatGroup {
    private User admin;
    private List<User> users;
    private String title;
    private UUID groupID;

    public ChatGroup(User admin, String title) {
        this.admin = admin;
        this.title = title;
    }

    public User getAdmin() {
        return admin;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getTitle() {
        return title;
    }

    public UUID getGroupID() {
        return groupID;
    }

    public static ChatGroup fromJSON(String s){
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s,ChatGroup.class);
    }

}
