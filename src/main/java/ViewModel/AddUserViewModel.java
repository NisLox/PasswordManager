package ViewModel;

import Model.Users;
import Model.Helper.Alert;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddUserViewModel {

    public StringProperty user = new SimpleStringProperty();
    public StringProperty password = new SimpleStringProperty();
    private Users users;

    public AddUserViewModel(Users users) {
        this.users = users;
    }

    public boolean okButtonAction() {
        if (!user.getValue().equals("") && !password.getValue().equals("")) {
            users.addUser(user.getValue(), password.getValue());
            Alert.showConfirmationAlert("Account Created", "Account has successfully been created");
            return true;
        } else {
            Alert.showErrorAlert("Account Creation Failed", "Account has not been created, User already exists with that username");
            return false;
        }

    }
}
