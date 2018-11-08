import Model.Services.DialogService;
import Model.Services.IDialogService;
import View.PasswordManager;
import ViewModel.MainViewModel;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {

    private Button button = new Button();
    private TextField login = new TextField();
    private TextField password = new TextField();
    private GridPane gridPane = new GridPane();
    private Button addUserButton = new Button();
    private Scene scene;
    private Stage primaryStage;

    private MainViewModel mainViewModel;
    private IDialogService dialogService = new DialogService();

    private BooleanProperty loginSuccess = new SimpleBooleanProperty(false);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Password Manager");
        mainViewModel = new MainViewModel();
        scene = new Scene(gridPane);

        populateStage();

        primaryStage.setScene(scene);
        primaryStage.show();

        listenersAndBinds();
    }

    private void populateStage() {
        Label loginText = new Label("Login: ");
        Label passwordText = new Label("Password: ");

        gridPane.add(loginText,1,1);
        gridPane.add(passwordText, 1,2);
        gridPane.add(login, 2,1);
        gridPane.add(password, 2,2);
        gridPane.add(button, 2,3);
        gridPane.add(addUserButton,3,3);

        button.setText("Log in");
        addUserButton.setText("Add user");
    }

    private void loginAction() {
        mainViewModel.loginAction();
    }

    private void listenersAndBinds() {
        button.setOnAction(actionEvent -> loginAction());
        addUserButton.setOnAction(actionEvent -> addUserAction());
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)){
                loginAction();
            }
        });

        login.textProperty().addListener((observable) -> mainViewModel.setLoginText(login.getText()));
        password.textProperty().addListener((observable) -> mainViewModel.setPasswordText(password.getText()));
        loginSuccess.bindBidirectional(mainViewModel.loginSuccess);

        loginSuccess.addListener((observable, oldValue, newValue) -> {
            dialogService.openPasswordManager();
        });

    }

    private void addUserAction() {
        dialogService.openAddUser();
    }

}