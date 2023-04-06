package lk.ijse.D24_Room_Management_System.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24_Room_Management_System.util.Navigation;
import lk.ijse.D24_Room_Management_System.util.Routes;

import java.io.IOException;

public class ReseptionFormController {
    public AnchorPane pane;
    public AnchorPane dashBordPane;

    public void loadDashbordUiOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RECEPTION,pane);
    }

    public void loadRegisterOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/registerRoomForm.fxml");
    }

    public void loadStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/studentForm.fxml");
    }

    public void loadRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/roomForm.fxml");
    }

    public void loadLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void setUi(String ui) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(ui));
        dashBordPane.getChildren().clear();
        dashBordPane.getChildren().add(parent);
    }
}
