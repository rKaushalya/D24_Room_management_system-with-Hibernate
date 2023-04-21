package lk.ijse.D24_Room_Management_System.controller;

import javafx.event.ActionEvent;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.util.Utility;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.Connection;

public class ReportFormController {
    public void loadEmployeeReportOnAction(ActionEvent actionEvent) {
        try {
            InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/D24_Room_Management_System/view/report/studentReport.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(resource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, (Connection) FactoryConfiguration.getInstance().getSession());

            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
