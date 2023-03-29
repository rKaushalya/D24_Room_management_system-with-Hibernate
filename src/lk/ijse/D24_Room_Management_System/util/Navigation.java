package lk.ijse.D24_Room_Management_System.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes routes,AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage stage = (Stage) Navigation.pane.getScene().getWindow();

        switch (routes){
            case LOGIN:
                stage.setTitle("Login Form");
                initUi("loginForm.fxml");
                break;
            case FORGET:
                stage.setTitle("Forget Password");
                initUi("forgetPasswordForm.fxml");
                break;
            case DASHBOAD:
                stage.setTitle("DashBord Form");
                initUi("dashBordForm.fxml");
                break;
        }
    }

    private static void initUi(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(
                Navigation.class.getResource("/lk/ijse/D24_Room_Management_System/view/" + location)));
    }
}
