package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.custom.StudentBO;
import lk.ijse.D24_Room_Management_System.dto.StudentDTO;

public class RegisterRoomFormController {
    public JFXTextField txtSId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXDatePicker txtDob;
    public JFXComboBox cmbGender;

    public void initialize(){
        ObservableList<String> gender = FXCollections.observableArrayList();
        gender.addAll("male","female");

        cmbGender.setItems(gender);
    }

    public void registerOnAction(ActionEvent actionEvent) {
        StudentBO bo = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.Types.STUDENT);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setDate(txtDob.getValue());
        studentDTO.setSId(txtSId.getText());
        studentDTO.setName(txtName.getText());
        studentDTO.setGender(String.valueOf(cmbGender.getValue()));


        boolean b = bo.addStudent(studentDTO);
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION, "ela").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "no").show();
        }
    }
}
