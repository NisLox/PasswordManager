package Model;

import javafx.beans.property.SimpleStringProperty;

public class Website {

    private final SimpleStringProperty website;
    private final SimpleStringProperty usernameOfWebsite;
    private final SimpleStringProperty passwordOfWebsite;

    public Website(String websiteUrl, String usernameOfWebsite, String passwordOfWebsite) {
        this.website = new SimpleStringProperty(websiteUrl);
        this.usernameOfWebsite = new SimpleStringProperty(usernameOfWebsite);
        this.passwordOfWebsite = new SimpleStringProperty(passwordOfWebsite);
    }

    public String getWebsite() {
        return website.get();
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

    public String getUsernameOfWebsite() {
        return usernameOfWebsite.get();
    }

    public void setUsernameOfWebsite(String usernameOfWebsite) {
        this.usernameOfWebsite.set(usernameOfWebsite);
    }

    public String getPasswordOfWebsite() {
        return passwordOfWebsite.get();
    }

    public void setPasswordOfWebsite(String passwordOfWebsite) {
        this.passwordOfWebsite.set(passwordOfWebsite);
    }



}
