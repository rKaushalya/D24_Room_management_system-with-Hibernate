package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.DashBordBO;
import lk.ijse.D24_Room_Management_System.util.Navigation;
import lk.ijse.D24_Room_Management_System.util.Routes;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DashBordFormController {
    public AnchorPane pane;
    public AnchorPane dashBordPane;
    public Text txtDate;
    public Text txtTime;
    public JFXButton txtId1;
    public JFXButton txtId2;
    public JFXButton txtId3;
    public JFXButton txtId4;

    private final DashBordBO dashBO = (DashBordBO) BOFactory.getBoFactory().getBO(BOFactory.Types.DASHBORD);

    public void initialize(){
        LocalDate date = LocalDate.now();
        txtDate.setText(String.valueOf(date));
        setTime();
        getCount1();
        getCount2();
        getCount3();
        getCount4();
    }

    public void setUi(String ui) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(ui));
        dashBordPane.getChildren().clear();
        dashBordPane.getChildren().add(parent);
    }

    private void getCount1(){
        try {
            int roomCount1 = dashBO.getRoomCount1();
            txtId1.setText(String.valueOf(roomCount1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getCount2(){
        try {
            int roomCount1 = dashBO.getRoomCount2();
            txtId2.setText(String.valueOf(roomCount1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getCount3(){
        try {
            int roomCount1 = dashBO.getRoomCount3();
            txtId3.setText(String.valueOf(roomCount1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getCount4(){
        try {
            int roomCount1 = dashBO.getRoomCount4();
            txtId4.setText(String.valueOf(roomCount1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void loadDashbordUiOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOAD,pane);
    }

    public void loadRegisterOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/registerRoomForm.fxml");
    }

    public void loadStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/studentForm.fxml");
    }

    public void loadRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/roomForm.fxml");
    }

    public void loadEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/employeeForm.fxml");
    }

    public void loadReportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/reportForm.fxml");
    }

    public void openSettingPAgeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/settingForm.fxml");
    }

    private void setTime() {
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                    txtTime.setText(hour.format(new Date()));

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        clock.start();
    }
}
