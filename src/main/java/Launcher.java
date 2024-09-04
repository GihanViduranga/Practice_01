import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/dashboard.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
        stage.show();
    }
}