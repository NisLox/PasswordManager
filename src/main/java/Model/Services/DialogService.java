package Model.Services;

import Model.Users;
import View.AddUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogService implements IDialogService {

    @Override
    public void openPasswordManager() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane rootPane;
        try {
             rootPane = fxmlLoader.load(getClass().getResource(
                    "/passwordManager.fxml"));
            Scene scene = new Scene(rootPane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
