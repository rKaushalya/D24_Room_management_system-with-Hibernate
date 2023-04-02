package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.UserBO;
import lk.ijse.D24_Room_Management_System.dto.UserDTO;

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

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.Types.USER);

    public void initialize(){
        loadRole();
    }

    private void loadRole(){
        ObservableList<String> role = FXCollections.observableArrayList();
        role.addAll("Admin","Reception");
        cmbRole.setItems(role);
    }

    public void addOnAction(ActionEvent actionEvent) {
        boolean add = userBO.addUser(new UserDTO(txtId.getText(),txtName.getText(),
                txtEmail.getText(),txtPassword.getText(), (String) cmbRole.getValue()));
        if (add){
            clearText();
            new Alert(Alert.AlertType.CONFIRMATION, "User Added Success..").show();
        }else {
            clearText();
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        UserDTO userDTO = userBO.searchUser(txtId.getText());
        userDTO.setName(txtName.getText());
        userDTO.setEmail(txtEmail.getText());
        userDTO.setPassword(txtPassword.getText());
        userDTO.setRole((String) cmbRole.getValue());

        boolean update = userBO.updateUser(userDTO);
        if (update){
            clearText();
            new Alert(Alert.AlertType.CONFIRMATION, "Update Success..").show();
        }else {
            clearText();
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void showPWOnAction(ActionEvent actionEvent) {
    }

    private void clearText(){
        txtId.clear();
        txtName.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtCMPassword.clear();
    }
}
