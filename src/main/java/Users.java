import java.util.HashMap;

class Users {

    private HashMap<String, String> hashMap;

    Users() {
        hashMap = new HashMap<>();
        hashMap.put("Will", "Password");
        hashMap.put("Lewis", "Password1");
    }

    String checkHashMap(String login) {
        return hashMap.get(login);
    }
}
