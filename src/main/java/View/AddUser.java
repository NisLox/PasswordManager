package View;

import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddUser {
    private Users users;

    @FXML
    public Button addButton;

    public void initialize(){
        addButton.setOnAction(this::test);
    }

    private void test(ActionEvent actionEvent) {
        users.addUser();
    }
}
