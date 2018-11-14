package View;

import Model.Helper.Alert;
import Model.User;
import Model.Users;
import Model.Website;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


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

    private User user;

    public void initialize() {
        addButton.setOnAction(e -> addAction());
    }

    public void initData(Users users) {
        user = users.getUser();
        createHeaders();
    }


    private void addAction() {
        if (website.getText().equals("") || username.getText().equals("") || username.getText().equals("")) {
            Alert.showErrorAlert("Insufficient Data Entered", "Please complete all fields");
        } else {
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
}
