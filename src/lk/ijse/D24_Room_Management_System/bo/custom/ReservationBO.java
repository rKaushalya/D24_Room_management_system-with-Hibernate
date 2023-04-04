package lk.ijse.D24_Room_Management_System.bo.custom;

import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.dto.CustomDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.RoomTDM;

import java.sql.SQLException;

public interface ReservationBO extends SuperBO {

    boolean addReservation(CustomDTO dto);

    RoomTDM loadRoom(String id);

    String generateNextReservationId();

    String newOrderID(String currentOrderId);
}
