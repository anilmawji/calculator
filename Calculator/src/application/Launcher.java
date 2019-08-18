package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        try {
            stage.getIcons().add(new Image("/res/icon.png"));
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/application/UI.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}