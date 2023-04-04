package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.custom.StudentBO;
import lk.ijse.D24_Room_Management_System.dto.StudentDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.StudentTDM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtDob;
    public TableView tblStudent;
    public JFXComboBox cmbGender;
    public TableColumn clmId;
    public TableColumn clmName;
    public TableColumn clmAddress;
    public TableColumn clmContact;
    public TableColumn clmDob;
    public TableColumn clmGender;
    public Label lblGender;

    private final StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.Types.STUDENT);

    public void initialize(){
        setCellValue();
        getAllStudent();

        ObservableList<String> gender = FXCollections.observableArrayList();
        gender.addAll("Male","Female");
        cmbGender.setItems(gender);
    }

    public void updateOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = studentBO.searchStudent(txtId.getText());
        studentDTO.setName(txtName.getText());
        studentDTO.setAddress(txtAddress.getText());
        studentDTO.setContactNo(txtContact.getText());
        studentDTO.setGender((String) cmbGender.getValue());

        LocalDate dob = LocalDate.parse(txtDob.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        studentDTO.setDate(dob);

        boolean update = studentBO.updateStudent(studentDTO);
        if (update){
            clearText();
            new Alert(Alert.AlertType.CONFIRMATION, "Update Success..").show();
        }else {
            clearText();
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = studentBO.searchStudent(txtId.getText());
        if (studentDTO != null){
            txtName.setText(studentDTO.getName());
            txtAddress.setText(studentDTO.getAddress());
            txtContact.setText(studentDTO.getContactNo());
            lblGender.setText(studentDTO.getGender());
            txtDob.setText(String.valueOf(studentDTO.getDate()));
        }else {
            new Alert(Alert.AlertType.ERROR, "Wrong Id.!").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = studentBO.searchStudent(txtId.getText());
        boolean delete = studentBO.deleteStudent(studentDTO);
        if (delete){
            clearText();
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Success..").show();
        }else {
            clearText();
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    private void getAllStudent(){
        try {
            ObservableList<StudentTDM> allStudent = studentBO.getAllStudent();
            tblStudent.setItems(allStudent);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void setCellValue(){
        clmId.setCellValueFactory(new PropertyValueFactory("sId"));
        clmName.setCellValueFactory(new PropertyValueFactory("name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory("address"));
        clmContact.setCellValueFactory(new PropertyValueFactory("contact"));
        clmDob.setCellValueFactory(new PropertyValueFactory("date"));
        clmGender.setCellValueFactory(new PropertyValueFactory("gender"));
    }

    private void clearText(){
        txtName.clear();
        txtContact.clear();
        txtDob.clear();
        txtAddress.clear();
        txtId.clear();
        lblGender.setText("");
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

    public void slipToDob(ActionEvent actionEvent) {
        txtDob.requestFocus();
    }

    public void slipToGender(ActionEvent actionEvent) {
        cmbGender.requestFocus();
    }
}
