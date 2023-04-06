package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.LoginBO;
import lk.ijse.D24_Room_Management_System.util.Navigation;
import lk.ijse.D24_Room_Management_System.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    private final LoginBO loginBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.Types.LOGIN);

    public void loadDashBordOnAction(ActionEvent actionEvent) throws IOException {
        try {
            String user = loginBO.checkUser(txtUserName.getText(), txtPassword.getText());
            if (user.equals("Admin")) {
                Navigation.navigate(Routes.DASHBOAD, pane);
            } else if (user.equals("Reception")) {

            } else if (user.equals("No")) {
                new Alert(Alert.AlertType.ERROR, "Wrong UserName or Password.!").show();
            }
        }catch (Exception e){
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Wrong UserName or Password.!").show();
        }
    }

    public void loadForgetOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FORGET,pane);
    }

    public void showOnAction(ActionEvent actionEvent) {
    }
}
