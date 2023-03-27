import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass()
                .getResource("lk/ijse/D24_Room_Management_System/view/loginForm.fxml"))));
        primaryStage.setTitle("Login Form");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
