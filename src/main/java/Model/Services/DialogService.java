package Model.Services;

import Model.Users;
import View.AddUser;
import View.PasswordManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
        PasswordManager passwordManager = fxmlLoader.getController();
        passwordManager.initData(users);
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
        AddUser addUser = fxmlLoader.getController();
        addUser.initData(users);

        stage.show();
    }
}
