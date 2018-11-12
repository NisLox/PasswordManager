import Model.Services.DialogService;
import Model.Services.IDialogService;
import Model.Users;
import ViewModel.MainViewModel;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
    private GridPane gridPane = new GridPane();
    private Button addUserButton = new Button();
    private Scene scene;
    private Stage stage;

    private MainViewModel mainViewModel;
    private IDialogService dialogService = new DialogService();
    private Users users;

    private BooleanProperty loginSuccess = new SimpleBooleanProperty(false);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Manager");
        users = new Users();
        mainViewModel = new MainViewModel(dialogService, users);
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

        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)){
                loginAction();
            }
        });

    }



}