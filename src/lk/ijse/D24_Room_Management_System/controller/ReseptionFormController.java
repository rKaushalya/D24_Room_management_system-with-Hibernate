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

public class ReseptionFormController {
    public AnchorPane pane;
    public AnchorPane dashBordPane;
    public Text txtDate;
    public Text txtTime;

    public void initialize(){
        setTime();

        LocalDate date = LocalDate.now();
        txtDate.setText(String.valueOf(date));
    }

    public void loadDashbordUiOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RECEPTION,pane);
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

    public void loadLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void setUi(String ui) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(ui));
        dashBordPane.getChildren().clear();
        dashBordPane.getChildren().add(parent);
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
