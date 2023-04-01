package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.UserDAO;
import lk.ijse.D24_Room_Management_System.entity.User;
import org.hibernate.Session;

public class UserDAOImpl implements UserDAO {

    @Override
    public void setSession(Session session) {

    }

    @Override
    public boolean save(User object) {
        return false;
    }

    @Override
    public boolean update(User object) {
        return false;
    }

    @Override
    public User get(String s) {
        return null;
    }

    @Override
    public boolean delete(User object) {
        return false;
    }

}
