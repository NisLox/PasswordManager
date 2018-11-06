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
        return hashMap.get(login);
    }
}
