package Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.HashMap;

public class Users {

    private HashMap<String, String> hashMap;
    private User user;
    public BooleanProperty passwordManagerOpen = new SimpleBooleanProperty();

    public Users() {
        hashMap = new HashMap<>();
        hashMap.put("Will", "Password");
    }

    public String checkHashMap(String login) {
        if (hashMap.get(login) == null) {
            return "error";
        } else {
            return hashMap.get(login);
        }
   }

    public void addUser(String username, String passwordValue) {
        user = new User();
        hashMap.put(username, passwordValue);
    }

    public User getUser() {
        return user;
    }









}
