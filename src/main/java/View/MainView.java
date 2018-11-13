package View;

import Model.Services.DialogService;
import Model.Services.IDialogService;
import Model.Users;
import ViewModel.MainViewModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class MainView {

    @FXML
    private TextField password;
    @FXML
    private TextField login;
    @FXML
    private Button button;
    @FXML
    private Button addUserButton;

    private Stage stage;
    private IDialogService dialogService;

    private MainViewModel mainViewModel;
    private Users users;

    private BooleanProperty loginSuccess = new SimpleBooleanProperty(false);

    public void initialize(){

    }

    public void initData(MainViewModel mainViewModel, IDialogService dialogService, Users users) {
        this.mainViewModel = mainViewModel;
        this.dialogService = dialogService;
        this.users = users;

        listenersAndBinds();
    }

    private void loginAction() {
        if (mainViewModel.loginAction()) {
            stage = (Stage) button.getScene().getWindow();
            stage.close();
        }
    }

    private void addUserAction() {
        mainViewModel.openAddUser();
    }

    private void listenersAndBinds() {
        button.setOnAction(actionEvent -> loginAction());
        addUserButton.setOnAction(actionEvent -> addUserAction());

        login.textProperty().addListener((observable) -> mainViewModel.setLoginText(login.getText()));
        password.textProperty().addListener((observable) -> mainViewModel.setPasswordText(password.getText()));
        loginSuccess.bindBidirectional(mainViewModel.loginSuccess);

        loginSuccess.addListener((observable, oldValue, newValue) -> {
            dialogService.openPasswordManager(users);
        });

        button.getScene().setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)){
                loginAction();
            }
        });
    }


}