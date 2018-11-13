package Model;

import javafx.beans.property.SimpleStringProperty;

public class Website {

    private final SimpleStringProperty website;
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;

    public Website(String websiteUrl, String usernameOfWebsite, String passwordOfWebsite) {
        this.website = new SimpleStringProperty(websiteUrl);
        this.username = new SimpleStringProperty(usernameOfWebsite);
        this.password = new SimpleStringProperty(passwordOfWebsite);
    }

    public String getWebsite() {
        return website.get();
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }



}
