package lk.ijse.D24_Room_Management_System.dao.custom;

import lk.ijse.D24_Room_Management_System.dao.CrudDAO;
import lk.ijse.D24_Room_Management_System.entity.Room;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room , String> {

    List<Room> getAll();
}
