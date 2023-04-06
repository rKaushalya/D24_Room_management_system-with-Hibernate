package lk.ijse.D24_Room_Management_System.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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

    public void initialize(){
        LocalDate date = LocalDate.now();
        txtDate.setText(String.valueOf(date));
        setTime();
    }

    public void setUi(String ui) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(ui));
        dashBordPane.getChildren().clear();
        dashBordPane.getChildren().add(parent);
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
