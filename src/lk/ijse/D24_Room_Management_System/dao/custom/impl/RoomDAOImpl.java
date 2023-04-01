package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.RoomDAO;
import lk.ijse.D24_Room_Management_System.entity.Room;
import org.hibernate.Session;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public void setSession(Session session) {

    }


    @Override
    public boolean save(Room object) {
        return false;
    }

    @Override
    public boolean update(Room object) {
        return false;
    }

    @Override
    public Room get(String s) {
        return null;
    }

    @Override
    public void delete(Room object) {

    }
}
