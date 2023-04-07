package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24_Room_Management_System.util.Navigation;
import lk.ijse.D24_Room_Management_System.util.Routes;

import java.io.IOException;

public class ForgetPasswordFormController {
    public AnchorPane pane;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtCmPw;
    public JFXCheckBox cbxShow;
    public JFXTextField showPw;
    public JFXTextField showCmPw;

    public void loadLoginForm(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void loadLoginFormOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void showOnAction(ActionEvent actionEvent) {
    }
}
