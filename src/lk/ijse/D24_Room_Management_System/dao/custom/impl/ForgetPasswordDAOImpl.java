package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.ForgetPasswordDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ForgetPasswordDAOImpl implements ForgetPasswordDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public int checkUser(String id, String name, String password) {
        String hql = "UPDATE User SET password = :pass WHERE uId = :user_id AND name = :user_name";
        Query query = session.createQuery(hql);
        query.setParameter("pass",password);
        query.setParameter("user_id",id);
        query.setParameter("user_name",name);
        int i = query.executeUpdate();
        return i;
    }
}
