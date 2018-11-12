package Model;

import java.util.ArrayList;

public class User {

    private ArrayList<Website> tableEntries = new ArrayList<>();

    public User(String username, String passwordValue) {

    }

    public void addWebsite(String websiteUrl, String usernameOfWebsite, String passwordOfWebsite) {
        Website website = new Website(websiteUrl, usernameOfWebsite, passwordOfWebsite);
        tableEntries.add(website);
    }

    public ArrayList<Website> getTableEntries() {
        return tableEntries;
    }


}
