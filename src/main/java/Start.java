import Model.Services.DialogService;
import Model.Services.IDialogService;
import Model.Users;
import View.MainView;
import ViewModel.MainViewModel;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {

    private IDialogService dialogService = new DialogService();
    private Users users = new Users();
    private BooleanProperty passwordManagerOpen = new SimpleBooleanProperty();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Stage stage = new Stage();

        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainView mainView = fxmlLoader.getController();
        passwordManagerOpen.setValue(false);
        MainViewModel mainViewModel = new MainViewModel(dialogService, users);
        passwordManagerOpen.bindBidirectional(mainViewModel.passwordManagerOpen);
        mainView.initData(mainViewModel);

        stage.show();
    }

}