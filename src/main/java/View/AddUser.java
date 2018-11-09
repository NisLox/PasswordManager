package View;

import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddUser {

    private Users users;

    @FXML
    public Button addButton;

    public void initData(Users users) {
        this.users = users;
    }

    public void initialize(){
        addButton.setOnAction(this::test);
    }

    private void test(ActionEvent actionEvent) {
        System.out.println("HELLO");
        users.addUser();
    }


}
