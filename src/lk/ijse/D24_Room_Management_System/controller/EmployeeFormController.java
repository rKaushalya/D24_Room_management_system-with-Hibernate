package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.custom.EmployeeBO;
import lk.ijse.D24_Room_Management_System.dto.EmployeeDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.EmployeeTDM;

public class EmployeeFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtRole;

    private final EmployeeBO empBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.Types.EMPLOYEE);
    public TableView tblEmployee;
    public TableColumn cmbId;
    public TableColumn cmbName;
    public TableColumn cmbAddress;
    public TableColumn cmbContact;
    public TableColumn cmbRole;

    public void initialize(){
        getAllEmployee();
        setCellValueFactory();
    }



    public void addOnAction(ActionEvent actionEvent) {
        try {
            boolean add = empBO.saveEmployee(new EmployeeDTO(txtId.getText(), txtName.getText(), txtAddress.getText(),
                    txtContact.getText(), txtRole.getText()));
            if (add){
                clearText();
                new Alert(Alert.AlertType.CONFIRMATION,"Employee added Success..").show();
            }else {
                clearText();
                new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
            }
        }catch (Exception e){
            clearText();
            System.out.println(e);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        EmployeeDTO empDTO = empBO.searchEmployee(txtId.getText());
        empDTO.setName(txtName.getText());
        empDTO.setAddress(txtAddress.getText());
        empDTO.setContact(txtContact.getText());
        empDTO.setRole(txtRole.getText());

        boolean update = empBO.updateCustomer(empDTO);
        if (update){
            clearText();
            new Alert(Alert.AlertType.CONFIRMATION, "Update Success..").show();
        }else {
            clearText();
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            EmployeeDTO employeeDTO = empBO.searchEmployee(txtId.getText());
            txtId.setText(employeeDTO.getEId());
            txtName.setText(employeeDTO.getName());
            txtAddress.setText(employeeDTO.getAddress());
            txtContact.setText(employeeDTO.getContact());
            txtRole.setText(employeeDTO.getRole());
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Wrong Id.!").show();
            System.out.println(e);
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        EmployeeDTO employeeDTO = empBO.searchEmployee(txtId.getText());
        boolean delete = empBO.deleteCustomer(employeeDTO);
        if (delete){
            clearText();
            new Alert(Alert.AlertType.CONFIRMATION, "Delete success..").show();
        }else {
            clearText();
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    private void getAllEmployee(){
        try {
            ObservableList<EmployeeTDM> allEmployee = empBO.getAllEmployee();
            tblEmployee.setItems(allEmployee);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void setCellValueFactory(){
        cmbId.setCellValueFactory(new PropertyValueFactory("eId"));
        cmbName.setCellValueFactory(new PropertyValueFactory("name"));
        cmbAddress.setCellValueFactory(new PropertyValueFactory("address"));
        cmbContact.setCellValueFactory(new PropertyValueFactory("contact"));
        cmbRole.setCellValueFactory(new PropertyValueFactory("role"));
    }

    private void clearText(){
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtRole.clear();
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

    public void slipToRole(ActionEvent actionEvent) {
        txtRole.requestFocus();
    }
}
