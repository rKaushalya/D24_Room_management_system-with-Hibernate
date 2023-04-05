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
import javafx.scene.text.Text;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.ReservationBO;
import lk.ijse.D24_Room_Management_System.bo.custom.StudentBO;
import lk.ijse.D24_Room_Management_System.dto.CustomDTO;
import lk.ijse.D24_Room_Management_System.dto.StudentDTO;

import java.sql.SQLException;

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

        ObservableList<String> gender = FXCollections.observableArrayList();
        gender.addAll("male","female");
        cmbGender.setItems(gender);
    }

    public void registerOnAction(ActionEvent actionEvent) {
        try {
            boolean added = resBO.addReservation(new CustomDTO());
            if (added){
                new Alert(Alert.AlertType.CONFIRMATION, "Register Room Success..").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void loadResId(){
        ReservationBO bo = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.Types.RESERVATION);

            String s = bo.generateNextReservationId();
            txtResId.setText(s);

    }
}
