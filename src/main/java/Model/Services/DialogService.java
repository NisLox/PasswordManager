package Model.Services;

import Model.Users;
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
    public void openAddUser(Users user) {

    }
}
