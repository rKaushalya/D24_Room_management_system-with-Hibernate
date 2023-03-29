package lk.ijse.D24_Room_Management_System.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24_Room_Management_System.util.Navigation;
import lk.ijse.D24_Room_Management_System.util.Routes;

import java.io.IOException;

public class DashBordFormController {
    public AnchorPane pane;

    public void loadLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }
}
