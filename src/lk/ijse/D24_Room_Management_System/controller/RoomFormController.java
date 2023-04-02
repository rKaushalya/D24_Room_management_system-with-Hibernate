package lk.ijse.D24_Room_Management_System.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.custom.RoomBO;
import lk.ijse.D24_Room_Management_System.dto.RoomDTO;

public class RoomFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtMoney;
    public JFXTextField txtQty;
    public TableView tblRoom;
    public TableColumn clmId;
    public TableColumn clmType;
    public TableColumn clmMoney;
    public TableColumn clmQty;

    private final RoomBO roomBo = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.Types.ROOM);

    public void addOnAction(ActionEvent actionEvent) {
        boolean add = roomBo.addRoom(new RoomDTO(txtId.getText(), txtName.getText(), txtMoney.getText(),
                Integer.parseInt(txtQty.getText())));
        if (add){
            new Alert(Alert.AlertType.CONFIRMATION, "Room Added Success..").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        RoomDTO roomDTO = roomBo.searchRoom(txtId.getText());
        boolean delete = roomBo.deleteRoom(roomDTO);
        if (delete){
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Success..").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }

    }

    public void searchOnAction(ActionEvent actionEvent) {
        RoomDTO roomDTO = roomBo.searchRoom(txtId.getText());
        if (roomDTO != null){
            txtName.setText(roomDTO.getType());
            txtMoney.setText(roomDTO.getKeyMoney());
            txtQty.setText(String.valueOf(roomDTO.getQty()));
        }else {
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        RoomDTO roomDTO = roomBo.searchRoom(txtId.getText());
        roomDTO.setType(txtName.getText());
        roomDTO.setKeyMoney(txtMoney.getText());
        roomDTO.setQty(Integer.parseInt(txtQty.getText()));

        boolean update = roomBo.updateRoom(roomDTO);
        if (update){
            new Alert(Alert.AlertType.CONFIRMATION, "Update Success..").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Something Wrong.!").show();
        }
    }
}
