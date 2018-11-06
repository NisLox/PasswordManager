package ViewModel;

import Model.Users;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Alert;

public class MainViewModel {

    public BooleanProperty loginSuccess = new SimpleBooleanProperty();
    private String loginText = "";
    private String passwordText = "";
    private Users users;

    public MainViewModel() {
        users = new Users();
    }

    public void loginAction() {
        if (users.checkHashMap(loginText).equals("error")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Username");
            alert.setContentText("Please try again");
            alert.showAndWait();
        } else {
            if (users.checkHashMap(loginText).equals(passwordText)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Access Granted");
                alert.setContentText("Welcome");
                alert.showAndWait();
                loginSuccess.setValue(true);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failed");
                alert.setContentText("Failed");
                alert.showAndWait();
                loginSuccess.setValue(false);
            }
        }

    }

    public void setLoginText(String loginText) {
        this.loginText = loginText;
    }

    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
    }

}
