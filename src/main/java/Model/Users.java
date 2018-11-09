package Model;

import java.util.HashMap;

public class Users {

    private HashMap<String, String> hashMap;

    public Users() {
        hashMap = new HashMap<>();
        hashMap.put("Will", "Password");
        hashMap.put("Lewis", "Password1");
    }

    public String checkHashMap(String login) {
        if (hashMap.get(login) == null) {
            return "error";
        } else {
            return hashMap.get(login);
        }
   }

    public void addUser(String value, String passwordValue) {
        hashMap.put(value ,passwordValue);
    }
}
