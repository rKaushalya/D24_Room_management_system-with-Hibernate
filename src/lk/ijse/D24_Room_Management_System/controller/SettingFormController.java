package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.UserBO;
import lk.ijse.D24_Room_Management_System.dto.UserDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.UserTDM;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtCMPassword;
    public TableView tblUser;
    public TableColumn clmId;
    public TableColumn clmName;
    public TableColumn clmEmail;
    public TableColumn clmRole;
    public JFXComboBox cmbRole;
    public JFXCheckBox cbxShowPW;
    public JFXTextField showPW;
    public JFXTextField showCMPW;

    private Matcher userNameMatcher;
    private Matcher emailMatcher;
    private Matcher pwMatcher;
    private Matcher userIdMatcher;

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.Types.USER);

    public void initialize(){
        getAllUser();
        setCellValue();
        loadRole();
        showPW.setVisible(false);
        showCMPW.setVisible(false);
    }

    private void loadRole(){
        ObservableList<String> role = FXCollections.observableArrayList();
        role.addAll("Admin","Reception");
        cmbRole.setItems(role);
    }

    public void addOnAction(ActionEvent actionEvent) {
        if (txtPassword.getText().equals(txtCMPassword.getText())) {
            boolean add = userBO.addUser(new UserDTO(txtId.getText(), txtName.getText(),
                    txtEmail.getText(), txtPassword.getText(), (String) cmbRole.getValue()));
            if (add) {
                clearText();
                getAllUser();
                new Alert(Alert.AlertType.CONFIRMATION, "User Added Success..").show();
            } else {
                clearText();
                new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Password didn't match.!").show();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        UserDTO userDTO = userBO.searchUser(txtId.getText());
        userDTO.setName(txtName.getText());
        userDTO.setEmail(txtEmail.getText());
        userDTO.setPassword(txtPassword.getText());
        userDTO.setRole((String) cmbRole.getValue());

        if (txtPassword.getText() != null && txtPassword.getText().equals(txtCMPassword.getText())) {
            boolean update = userBO.updateUser(userDTO);
            if (update) {
                clearText();
                getAllUser();
                new Alert(Alert.AlertType.CONFIRMATION, "Update Success..").show();
            } else {
                clearText();
                new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Check Password again.!").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        UserDTO userDTO = userBO.searchUser(txtId.getText());
        boolean delete = userBO.deleteUser(userDTO);
        if (delete){
            clearText();
            getAllUser();
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Success..").show();
        }else {
            clearText();
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    private void getAllUser(){
        try {
            ObservableList<UserTDM> allUser = userBO.getAllUser();
            tblUser.setItems(allUser);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void showPWOnAction(ActionEvent actionEvent) {
        if (cbxShowPW.isSelected()){
            showPW.setText(txtPassword.getText());
            showCMPW.setText(txtCMPassword.getText());
            txtPassword.setVisible(false);
            txtCMPassword.setVisible(false);
            showPW.setVisible(true);
            showCMPW.setVisible(true);
        }else {
            txtPassword.setText(showPW.getText());
            txtCMPassword.setText(showCMPW.getText());
            txtPassword.setVisible(true);
            txtCMPassword.setVisible(true);
            showPW.setVisible(false);
            showCMPW.setVisible(false);
        }
    }

    private void clearText(){
        txtId.clear();
        txtName.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtCMPassword.clear();
    }

    private void setCellValue(){
        clmId.setCellValueFactory(new PropertyValueFactory("uId"));
        clmName.setCellValueFactory(new PropertyValueFactory("name"));
        clmEmail.setCellValueFactory(new PropertyValueFactory("email"));
        clmRole.setCellValueFactory(new PropertyValueFactory("role"));
    }


    public void loadText(MouseEvent mouseEvent) {
        ObservableList<UserTDM> user  = tblUser.getSelectionModel().getSelectedItems();
        txtId.setText(user.get(0).getUId());
        txtName.setText(user.get(0).getName());
        txtEmail.setText(user.get(0).getEmail());
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

    public void slipToEmail(ActionEvent actionEvent) {
        setPatten();
        if (!userNameMatcher.matches()){
            txtName.setFocusColor(Paint.valueOf("Red"));
        }else {
            txtName.setFocusColor(Paint.valueOf("Blue"));
            txtEmail.requestFocus();
        }
    }

    public void slipToPW(ActionEvent actionEvent) {
        setPatten();
        if (!emailMatcher.matches()){
            txtEmail.setFocusColor(Paint.valueOf("Red"));
        }else {
            txtEmail.setFocusColor(Paint.valueOf("Blue"));
            txtPassword.requestFocus();
        }
    }

    public void slipToCmPw(ActionEvent actionEvent) {
        setPatten();
        if (!pwMatcher.matches()){
            txtPassword.setFocusColor(Paint.valueOf("Red"));
        }else {
            txtPassword.setFocusColor(Paint.valueOf("Blue"));
            txtCMPassword.requestFocus();
        }
    }

    public void slipToRole(ActionEvent actionEvent) {
        cmbRole.requestFocus();
    }

    private void setPatten() {

        Pattern userIdPattern = Pattern.compile("^(U0)([0-9]{1,})([1-9]{0,})$");
        userIdMatcher = userIdPattern.matcher(txtId.getText());

        Pattern userNamePatten = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        userNameMatcher = userNamePatten.matcher(txtName.getText());

        Pattern emailPattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        emailMatcher = emailPattern.matcher(txtEmail.getText());

        Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        pwMatcher = passwordPattern.matcher(txtPassword.getText());
    }
}
