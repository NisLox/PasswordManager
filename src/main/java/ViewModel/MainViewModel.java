package ViewModel;

import Model.Services.DialogService;
import Model.Services.IDialogService;
import Model.Users;
import Model.Helper.Alert;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class MainViewModel {

    public BooleanProperty loginSuccess = new SimpleBooleanProperty();
    private String loginText = "";
    private String passwordText = "";
    private Users users;
    private DialogService dialogService;

    public MainViewModel(IDialogService dialogService) {
        this.dialogService = (DialogService) dialogService;
        users = new Users();
    }

    public void loginAction() {
        if (users.checkHashMap(loginText).equals("error")) {
            Alert.showErrorAlert("Login Failed", "Unsuccessful login");
            loginSuccess.setValue(false);
        } else {
            if (users.checkHashMap(loginText).equals(passwordText)) {
                Alert.showConfirmationAlert("Access Granted", "Welcome!");
                loginSuccess.setValue(true);
            } else {
                Alert.showErrorAlert("Error", "Error");
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

    public void openAddUser() {
        dialogService.openAddUser(users);
    }
}
