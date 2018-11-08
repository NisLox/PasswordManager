package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddUser {
    @FXML
    public Button addButton;

    public void initialize(){
        addButton.setOnAction(this::test);
    }

    private void test(ActionEvent actionEvent) {
        System.out.println("Hello");
    }
}
