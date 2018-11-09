package ViewModel;

import Model.Users;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddUserViewModel {

    public StringProperty user = new SimpleStringProperty();
    public StringProperty password = new SimpleStringProperty();
    private Users users;

    public AddUserViewModel(Users users) {
        this.users = users;
    }

    public void okButtonAction() {
        if (!user.getValue().equals("") && !password.getValue().equals("")) {
            users.addUser(user.getValue(), password.getValue());
        }

    }

    public void cancelButtonAction() {

    }
}
