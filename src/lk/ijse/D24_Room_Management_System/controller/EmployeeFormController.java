package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.EmployeeBO;
import lk.ijse.D24_Room_Management_System.dto.EmployeeDTO;

public class EmployeeFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtRole;
    public JFXComboBox cmbRole;

    private final EmployeeBO empBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.Types.EMPLOYEE);

    public void initialize(){
        loadRole();
    }

    private void loadRole(){
        ObservableList<String> role = FXCollections.observableArrayList();
        role.addAll("Admin","Reception");
        cmbRole.setItems(role);
    }

    public void addOnAction(ActionEvent actionEvent) {
        try {
            boolean add = empBO.saveEmployee(new EmployeeDTO(txtId.getText(), txtName.getText(), txtAddress.getText(),
                    txtContact.getText(), (String) cmbRole.getValue()));
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION,"Employee added Success..").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }
}
