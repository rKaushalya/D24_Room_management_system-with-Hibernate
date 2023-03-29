package lk.ijse.D24_Room_Management_System.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24_Room_Management_System.util.Navigation;
import lk.ijse.D24_Room_Management_System.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane pane;

    public void loadDashBordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOAD,pane);
    }

    public void loadForgetOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FORGET,pane);
    }
}
