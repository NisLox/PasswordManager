package View;

import Model.Users;
import ViewModel.AddUserViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddUser {

    @FXML
    public TextField user;
    @FXML
    public TextField password;
    @FXML
    public Button okButton;
    @FXML
    public Button cancelButton;
    @FXML
    private Users users;

    private AddUserViewModel addUserViewModel;

    private StringProperty userName = new SimpleStringProperty();
    private StringProperty userPassword = new SimpleStringProperty();

    public void initData(Users users) {
        this.users = users;
        addUserViewModel = new AddUserViewModel(users);
    }

    public void initialize(){
        okButton.setOnAction(this::okButtonAction);
        cancelButton.setOnAction(this::cancelButtonAction);

        user.textProperty().addListener((observable, oldValue, newValue) -> userName.setValue(newValue));
        password.textProperty().addListener((observable, oldValue, newValue) -> userPassword.setValue(newValue));

        userName.addListener((observable, oldValue, newValue) -> addUserViewModel.user.setValue(newValue));
        userPassword.addListener((observable, oldValue, newValue) -> addUserViewModel.password.setValue(newValue));
    }

    private void okButtonAction(ActionEvent actionEvent) {
        addUserViewModel.okButtonAction();
    }

    private void cancelButtonAction(ActionEvent actionEvent) {
        addUserViewModel.cancelButtonAction();
    }


}
