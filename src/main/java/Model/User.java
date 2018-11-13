package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {

    private final ObservableList<Website> data =
            FXCollections.observableArrayList();

    public void addWebsite(String websiteUrl, String usernameOfWebsite, String passwordOfWebsite) {
        data.add(new Website(websiteUrl, usernameOfWebsite, passwordOfWebsite));
    }

    public ObservableList<Website> getData() {
        return data;
    }

}
