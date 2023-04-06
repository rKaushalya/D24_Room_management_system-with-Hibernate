package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.RoomDAO;
import lk.ijse.D24_Room_Management_System.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Room room) {
        if (room != null){
            session.save(room);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Room room) {
        if (room != null){
            session.update(room);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Room get(String id) {
        return session.get(Room.class,id);
    }

    @Override
    public boolean delete(Room room) {
        if (room != null){
            session.delete(room);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Room> getAll() {
        String hql = "FROM Room";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<String> getRoomId() {
        String hql = "SELECT rId FROM Room";
        Query query = session.createQuery(hql);
        List<String> list = query.list();
        session.close();
        return list;
    }
}
