package ua.kiev.prog.models;

import java.util.ArrayList;
import java.util.List;


public class User {
    private String login;
    private String password;
    private String status;
    private List<Message> privateMessages = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void addPrivateMessage(Message message){
        privateMessages.add(message);
    }
    public List<Message> getPrivateMessages(){return privateMessages;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
