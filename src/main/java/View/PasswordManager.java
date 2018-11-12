package View;

import Model.User;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class PasswordManager {
    @FXML
    public Button addButton;
    @FXML
    public TextField website;
    @FXML
    public TextField username;
    @FXML
    public TextField password;
    @FXML
    public Button testButton;

    private User user;
    private ArrayList<User> arrayOfUsers;

    public void initialize(){

        addButton.setOnAction(e -> addAction());
        testButton.setOnAction(e -> showWebsites());
    }

    public void initData(Users users) {
        user = users.getUser();
        arrayOfUsers = users.getArrayOfUsers();
    }

    private void showWebsites() {
        for (int i = 0; i < arrayOfUsers.get(0).getTableEntries().size(); i++) {
            System.out.println(user.getTableEntries().get(i));
        }
    }

    private void addAction() {
        user.addWebsite(website.getText(), username.getText(), password.getText());
        website.clear();
        username.clear();
        password.clear();
    }


}
