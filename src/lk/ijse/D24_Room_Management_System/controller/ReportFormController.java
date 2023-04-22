package lk.ijse.D24_Room_Management_System.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.ReservationBO;
import lk.ijse.D24_Room_Management_System.dto.CustomDTO;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.CustomTDM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.Connection;

public class ReportFormController {
    public TableView tblRes;
    public TableColumn clmStdId;
    public TableColumn clmName;
    public TableColumn clmRoomId;
    public TableColumn clmRType;
    public TableColumn clmResId;
    public TableColumn clmStatus;
    public TableColumn clmDate;

    private final ReservationBO resBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.Types.RESERVATION);

    public void initialize(){
        loadAll();
        setCollValues();
    }

    public void loadAll(){
        try {
            ObservableList<CustomTDM> allData = resBO.getAllData();
            tblRes.setItems(allData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setCollValues(){
        clmStdId.setCellValueFactory(new PropertyValueFactory("sId"));
        clmDate.setCellValueFactory(new PropertyValueFactory("date"));
        clmName.setCellValueFactory(new PropertyValueFactory("name"));
        clmRoomId.setCellValueFactory(new PropertyValueFactory("rId"));
        clmRType.setCellValueFactory(new PropertyValueFactory("type"));
        clmStatus.setCellValueFactory(new PropertyValueFactory("status"));
        clmResId.setCellValueFactory(new PropertyValueFactory("resId"));
    }

    public void loadEmployeeReportOnAction(ActionEvent actionEvent) {
        /*try {
            InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/D24_Room_Management_System/view/report/studentReport.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(resource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, (Connection) FactoryConfiguration.getInstance().getSession());

            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            System.out.println(e);
        }*/
    }
}
