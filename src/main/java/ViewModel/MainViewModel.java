package ViewModel;

import Model.Services.DialogService;
import Model.Services.IDialogService;
import Model.Users;
import Model.Helper.Alert;
import javafx.beans.property.BooleanProperty;

import javafx.beans.property.SimpleBooleanProperty;


public class MainViewModel {

    public BooleanProperty loginSuccess = new SimpleBooleanProperty();
    public BooleanProperty passwordManagerOpen = new SimpleBooleanProperty();
    private String loginText = "";
    private String passwordText = "";
    private Users users;
    private DialogService dialogService;

    public MainViewModel(IDialogService dialogService, Users users) {
        this.dialogService = (DialogService) dialogService;
        this.users = users;
        listeners();
    }

    public boolean loginAction() {
        if (users.checkHashMap(loginText).equals("error")) {
            Alert.showErrorAlert("Login Failed", "Unsuccessful login");
            loginSuccess.setValue(false);
            return false;
        } else {
            if (users.checkHashMap(loginText).equals(passwordText)) {
                Alert.showConfirmationAlert("Access Granted", "Welcome!");
                loginSuccess.setValue(true);
                passwordManagerOpen.setValue(true);
                return true;
            } else {
                Alert.showErrorAlert("Error", "Error");
                loginSuccess.setValue(false);
                return false;
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

    public void openPasswordManager() {
        dialogService.openPasswordManager(users);
    }

    private void openLoginView(){
        dialogService.openLoginScreen();
    }

    private void listeners(){
        passwordManagerOpen.bindBidirectional(users.passwordManagerOpen);
       passwordManagerOpen.addListener((observable, oldValue, newValue) -> {
           if (!newValue) {
               openLoginView();
           }
       });
    }
}
