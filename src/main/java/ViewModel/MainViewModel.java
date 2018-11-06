package ViewModel;

import Model.Users;
import javafx.scene.control.Alert;

public class MainViewModel {

    private String loginText = "";
    private String passWordText = "";
    private Users users;

    public MainViewModel() {
        users = new Users();
    }

    public void loginAction() {
        if (users.checkHashMap(loginText)
                .equals(passWordText)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Access Granted");
            alert.setContentText("Welcome");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed");
            alert.setContentText("Failed");
            alert.showAndWait();
        }
    }

    public void setLoginText(String loginText) {
        this.loginText = loginText;
    }

    public void setPassWordText(String passWordText) {
        this.passWordText = passWordText;
    }
}
