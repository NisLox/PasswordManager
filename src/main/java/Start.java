import ViewModel.MainViewModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Start extends Application {

    private Button button = new Button();
    private TextField login = new TextField();
    private TextField password = new TextField();

    private Scene scene;

    private MainViewModel mainViewModel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Manager");

        mainViewModel = new MainViewModel();

        GridPane gridPane = new GridPane();
        scene = new Scene(gridPane);

        Label loginText = new Label("Login: ");
        Label passwordText = new Label("Password: ");

        gridPane.add(loginText,1,1);
        gridPane.add(passwordText, 1,2);
        gridPane.add(login, 2,1);
        gridPane.add(password, 2,2);
        gridPane.add(button, 2,3);

        button.setText("Log in");

        primaryStage.setScene(scene);
        primaryStage.show();

        listenersAndBinds();

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
        password.textProperty().addListener((observable) -> mainViewModel.setPassWordText(password.getText()));

    }

}