package ViewModel;

import Model.Users;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Account Created");
            alert.showAndWait();
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Account Creation Failed");
            alert.showAndWait();
            return false;
        }

    }
}
