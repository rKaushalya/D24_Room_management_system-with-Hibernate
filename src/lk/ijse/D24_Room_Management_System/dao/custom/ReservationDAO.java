package lk.ijse.D24_Room_Management_System.dao.custom;

import lk.ijse.D24_Room_Management_System.dao.SuperDAO;
import lk.ijse.D24_Room_Management_System.entity.Reservation;

import java.util.List;

public interface ReservationDAO extends SuperDAO {

    boolean register(Reservation reservation);

    String generateNextResId();

    List<Reservation> allData();
}
