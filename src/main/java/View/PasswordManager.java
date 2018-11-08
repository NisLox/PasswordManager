package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PasswordManager {
    @FXML
    public Label welcomeNote;
    @FXML
    public Label entryWebsite;
    @FXML
    public Label entryUsername;
    @FXML
    public Label entryPassword;
    @FXML
    public GridPane gridPane;
    @FXML
    public Button addButton;

    public void initialize(){
        addButton.setOnAction(this::addAction);
    }


    private void addAction(ActionEvent actionEvent) {
        System.out.println("Hello");
    }
}
