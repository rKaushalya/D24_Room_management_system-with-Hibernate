package lk.ijse.D24_Room_Management_System.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UnpaidStudentFormController {
    public AnchorPane unpaidPane;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/D24_Room_Management_System/view/studentForm.fxml");
    }

    public void setUi(String ui) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource(ui));
        unpaidPane.getChildren().clear();
        unpaidPane.getChildren().add(load);
    }
}
