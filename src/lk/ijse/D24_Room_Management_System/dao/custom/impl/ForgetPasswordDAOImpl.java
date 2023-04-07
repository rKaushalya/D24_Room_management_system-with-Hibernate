package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.ForgetPasswordDAO;
import org.hibernate.Session;

public class ForgetPasswordDAOImpl implements ForgetPasswordDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
