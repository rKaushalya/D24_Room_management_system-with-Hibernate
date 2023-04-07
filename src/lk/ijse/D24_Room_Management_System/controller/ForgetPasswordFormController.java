package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.ForgetPasswordBO;
import lk.ijse.D24_Room_Management_System.util.Navigation;
import lk.ijse.D24_Room_Management_System.util.Routes;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgetPasswordFormController {
    public AnchorPane pane;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtCmPw;
    public JFXCheckBox cbxShow;
    public JFXTextField showPw;
    public JFXTextField showCmPw;

    private Matcher userNameMatcher;
    private Matcher pwMatcher;
    private Matcher userIdMatcher;

    private final ForgetPasswordBO forgetBO = (ForgetPasswordBO) BOFactory.getBoFactory().getBO(BOFactory.Types.FORGET);
    public JFXButton btnForget;

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
        if (cbxShow.isSelected()){
            showPw.setVisible(true);
            showCmPw.setVisible(true);
            showPw.setText(txtPassword.getText());
            showCmPw.setText(txtCmPw.getText());
            txtPassword.setVisible(false);
            txtCmPw.setVisible(false);
        }else {
            txtPassword.setVisible(true);
            txtCmPw.setVisible(true);
            txtPassword.setText(showPw.getText());
            txtCmPw.setText(showCmPw.getText());
            showPw.setVisible(false);
            showCmPw.setVisible(false);
        }
    }

    public void slipToName(ActionEvent actionEvent) {
        setPatten();
        if (!userIdMatcher.matches()){
            txtId.setFocusColor(Paint.valueOf("Red"));
        }else {
            txtId.setFocusColor(Paint.valueOf("Blue"));
            txtName.requestFocus();
        }
    }

    public void slipToPassword(ActionEvent actionEvent) {
        setPatten();
        if (!userNameMatcher.matches()){
            txtName.setFocusColor(Paint.valueOf("Red"));
        }else {
            txtName.setFocusColor(Paint.valueOf("Blue"));
            txtPassword.requestFocus();
        }
    }

    public void slipTocmPw(ActionEvent actionEvent) {
        setPatten();
        if (!pwMatcher.matches()){
            txtPassword.setFocusColor(Paint.valueOf("Red"));
        }else {
            txtPassword.setFocusColor(Paint.valueOf("Blue"));
            txtCmPw.requestFocus();
        }
    }

    public void slipToButton(ActionEvent actionEvent) {
        btnForget.requestFocus();
    }

    private void setPatten() {

        Pattern userIdPattern = Pattern.compile("^(U0)([0-9]{1,})([1-9]{0,})$");
        userIdMatcher = userIdPattern.matcher(txtId.getText());

        Pattern userNamePatten = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        userNameMatcher = userNamePatten.matcher(txtName.getText());

        Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        pwMatcher = passwordPattern.matcher(txtPassword.getText());
    }
}
