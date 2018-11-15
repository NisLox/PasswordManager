package Model.Services;

import Model.Users;
import View.AddUserView;
import View.PasswordManagerView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogService implements IDialogService {

    @Override
    public void openPasswordManager(Users users) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/passwordManager.fxml"));
        Stage stage = new Stage();

        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PasswordManagerView passwordManager = fxmlLoader.getController();
        passwordManager.initData(users, stage);
        stage.show();
    }

    @Override
    public void openAddUser(Users users) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addUser.fxml"));

        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        AddUserView addUser = fxmlLoader.getController();
        addUser.initData(users);

        stage.show();
    }
}
