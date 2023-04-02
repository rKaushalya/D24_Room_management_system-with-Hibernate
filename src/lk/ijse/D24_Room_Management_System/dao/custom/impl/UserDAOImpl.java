package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.UserDAO;
import lk.ijse.D24_Room_Management_System.entity.User;
import org.hibernate.Session;

public class UserDAOImpl implements UserDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(User user) {
        if (user != null) {
            session.save(user);
            return true;
        }else {
            return false;
        }
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
