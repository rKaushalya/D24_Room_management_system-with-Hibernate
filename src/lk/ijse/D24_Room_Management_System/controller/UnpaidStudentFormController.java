package lk.ijse.D24_Room_Management_System.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.custom.UnpaidStudentBO;
import lk.ijse.D24_Room_Management_System.dto.CustomDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.CustomTDM;
import lk.ijse.D24_Room_Management_System.view.tdm.StudentTDM;

import java.io.IOException;

public class UnpaidStudentFormController {
    public AnchorPane unpaidPane;
    public Text txtId;
    public Text txtName;
    public Text txtAddress;
    public Text txtContact;
    public TableView tblStudent;
    public TableColumn clmId;
    public TableColumn clmName;
    public TableColumn clmRId;
    public TableColumn clmRType;
    public TableColumn clmResId;
    public TableColumn clmStatus;
    public Text txtPaid;

    private final UnpaidStudentBO unpaidStudentBO = (UnpaidStudentBO) BOFactory.getBoFactory().getBO(BOFactory.Types.UNPAID);

    public void initialize(){
        getStudent();
        setColValues();
    }
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/studentForm.fxml");
    }

    public void setUi(String ui) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource(ui));
        unpaidPane.getChildren().clear();
        unpaidPane.getChildren().add(load);
    }

    private void getStudent(){
        try {
            ObservableList<CustomTDM> unpaidStudents = unpaidStudentBO.getUnpaidStudents();
            tblStudent.setItems(unpaidStudents);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    private void setColValues(){
        clmId.setCellValueFactory(new PropertyValueFactory("sId"));
        clmName.setCellValueFactory(new PropertyValueFactory("name"));
        clmRId.setCellValueFactory(new PropertyValueFactory("rId"));
        clmRType.setCellValueFactory(new PropertyValueFactory("type"));
        clmResId.setCellValueFactory(new PropertyValueFactory("resId"));
        clmStatus.setCellValueFactory(new PropertyValueFactory("status"));
    }
}
