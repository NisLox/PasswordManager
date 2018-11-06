import ViewModel.MainViewModel;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private Scene scene;
    private Stage primaryStage;

    private MainViewModel mainViewModel;

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

        button.setText("Log in");
    }

    private void loginAction() {
        mainViewModel.loginAction();
    }

    private void listenersAndBinds() {
        button.setOnAction(actionEvent -> loginAction());
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)){
                loginAction();
            }
        });

        login.textProperty().addListener((observable) -> mainViewModel.setLoginText(login.getText()));
        password.textProperty().addListener((observable) -> mainViewModel.setPasswordText(password.getText()));
        loginSuccess.bindBidirectional(mainViewModel.loginSuccess);
        loginSuccess.addListener((observable, oldValue, newValue) -> {
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("passwordManager.fxml"));
                scene = new Scene(root);
                primaryStage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}