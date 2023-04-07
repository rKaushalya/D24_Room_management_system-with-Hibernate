package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.ForgetPasswordBO;
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

    private final ForgetPasswordBO forgetBO = (ForgetPasswordBO) BOFactory.getBoFactory().getBO(BOFactory.Types.FORGET);

    public void initialize(){
        showPw.setVisible(false);
        showCmPw.setVisible(false);
    }

    public void loadLoginForm(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void loadLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        if (txtPassword.getText().equals(txtCmPw.getText())){
            boolean update = forgetBO.forgetPassword(txtId.getText(), txtName.getText(), txtPassword.getText());
            if (update){
                new Alert(Alert.AlertType.CONFIRMATION, "Password Updated...").show();
                Navigation.navigate(Routes.LOGIN,pane);
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Password didn't match.!").show();
        }
    }

    public void showOnAction(ActionEvent actionEvent) {
    }
}
