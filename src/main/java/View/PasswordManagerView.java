package View;

import Model.Helper.Alert;
import Model.User;
import Model.Users;
import Model.Website;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.nio.charset.Charset;
import java.util.Random;


public class PasswordManagerView {

    @FXML
    public Button addButton;
    @FXML
    public TextField website;
    @FXML
    public TextField username;
    @FXML
    public TextField password;
    @FXML
    public TableView tableView;
    @FXML
    public Button logout;
    @FXML
    public Button createPassword;

    private User user;

    private Stage stage;

    private BooleanProperty passwordManagerOpen = new SimpleBooleanProperty();

    private int count = 0;
    private String generatedString;

    public void initialize() {
        addButton.setOnAction(e -> addAction());
        logout.setOnAction(e -> logoutAction());
        createPassword.setOnAction(e -> createPasswordAction());
        passwordManagerOpen.setValue(true);
    }

    private void logoutAction() {
        stage.close();
        passwordManagerOpen.setValue(false);
    }

    public void initData(Users users, Stage stage) {
        user = users.getUser();
        this.stage = stage;
        createHeaders();

        passwordManagerOpen.bindBidirectional(users.passwordManagerOpen);
    }


    private void addAction() {
        if (website.getText().equals("") || username.getText().equals("") || username.getText().equals("")) {
            Alert.showErrorAlert("Insufficient Data Entered", "Please complete all fields");
        } else {
            if (user == null) {
                user = new User();
            }
            user.addWebsite(website.getText(), username.getText(), password.getText());
            website.clear();
            username.clear();
            password.clear();
            tableView.setItems(user.getData());
        }
    }

    private void createHeaders() {
        TableColumn websiteCol = new TableColumn("Website");
        TableColumn usernameCol = new TableColumn("Username");
        TableColumn passwordCol = new TableColumn("Password");

        websiteCol.setCellValueFactory(new PropertyValueFactory<Website, String>("Website"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<Website, String>("Username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<Website, String>("Password"));

        tableView.getColumns().addAll(websiteCol, usernameCol, passwordCol);
    }

    private void createPasswordAction() {
        count++;
        password.setText(createRandomString());
    }

    private String createRandomString(){
        byte [] array = new byte[7];
        new Random().nextBytes(array);
        return generatedString = new String(array, Charset.forName("UTF-8"));
    }
}
