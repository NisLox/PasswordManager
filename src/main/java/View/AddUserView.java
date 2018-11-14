package View;

import Model.Users;
import ViewModel.AddUserViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserView {

    @FXML
    public TextField user;
    @FXML
    public TextField password;
    @FXML
    public Button okButton;
    @FXML
    public Button cancelButton;

    private AddUserViewModel addUserViewModel;

    public void initData(Users users) {
        addUserViewModel = new AddUserViewModel(users);
    }

    public void initialize(){
        okButton.setOnAction(e -> okButtonAction());
        cancelButton.setOnAction(e -> cancelButtonAction());

        user.textProperty().addListener((observable, oldValue, newValue) -> addUserViewModel.user.setValue(newValue));
        password.textProperty().addListener((observable, oldValue, newValue) -> addUserViewModel.password.setValue(newValue));
    }

    private void okButtonAction() {
       if (addUserViewModel.okButtonAction()) {
           closeWindow();
       }
    }

    private void cancelButtonAction() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
