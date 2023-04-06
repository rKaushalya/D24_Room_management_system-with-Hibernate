package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.ReservationBO;
import lk.ijse.D24_Room_Management_System.bo.custom.StudentBO;
import lk.ijse.D24_Room_Management_System.dto.CustomDTO;
import lk.ijse.D24_Room_Management_System.dto.StudentDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.RoomTDM;

import java.sql.SQLException;
import java.time.LocalDate;

public class RegisterRoomFormController {
    public JFXTextField txtSId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXDatePicker txtDob;
    public JFXComboBox cmbGender;
    public Text txtResId;
    public JFXComboBox cmbRid;
    public JFXTextField txtStatus;
    public TableView tblRoom;
    public TableColumn clmType;
    public TableColumn clmKMoney;
    public TableColumn clmQty;

    private final ReservationBO resBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.Types.RESERVATION);

    public void initialize(){
        loadResId();
        loadRoomId();
        setSellValue();

        ObservableList<String> gender = FXCollections.observableArrayList();
        gender.addAll("male","female");
        cmbGender.setItems(gender);
    }

    public void registerOnAction(ActionEvent actionEvent) {
        try {
            LocalDate date = LocalDate.now();
            boolean added = resBO.addReservation(new CustomDTO(txtSId.getText(),txtName.getText(),txtAddress.getText(),
                    txtContact.getText(),txtDob.getValue(),(String)cmbGender.getValue(),txtResId.getText(),date,txtStatus.getText(),(String) cmbRid.getValue()));
            if (added){
                new Alert(Alert.AlertType.CONFIRMATION, "Register Room Success..").show();
                clearText();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void loadResId(){
        try {
            String s = resBO.generateNextReservationId();
            txtResId.setText(s);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void loadRoomId(){
        try {
            ObservableList<String> observableList = resBO.loadAllRid();
            cmbRid.setItems(observableList);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void clearText(){
        txtSId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtStatus.clear();
    }

    private void setSellValue(){
        clmType.setCellValueFactory(new PropertyValueFactory("type"));
        clmKMoney.setCellValueFactory(new PropertyValueFactory("keyMoney"));
        clmQty.setCellValueFactory(new PropertyValueFactory("qty"));
    }

    public void loadRoomOnAction(ActionEvent actionEvent) {
        try {
            ObservableList<RoomTDM> roomTDMS = resBO.loadRoom((String) cmbRid.getValue());
            tblRoom.setItems(roomTDMS);
        }catch (Exception e){
            System.out.println(e);
        }
        txtStatus.requestFocus();
    }

    public void slipToName(ActionEvent actionEvent) {
        txtName.requestFocus();
    }

    public void slipToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void slipToContact(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void slipTODob(ActionEvent actionEvent) {
        txtDob.requestFocus();
    }

    public void slipToGender(ActionEvent actionEvent) {
        cmbGender.requestFocus();
    }

    public void slipToRid(ActionEvent actionEvent) {
        cmbRid.requestFocus();
    }
}
