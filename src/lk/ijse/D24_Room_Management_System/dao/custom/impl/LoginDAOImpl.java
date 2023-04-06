package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.LoginDAO;
import lk.ijse.D24_Room_Management_System.entity.User;
import org.hibernate.Session;

public class LoginDAOImpl implements LoginDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public User check(String name, String password) {
        return null;
    }
}
