package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.LoginDAO;
import lk.ijse.D24_Room_Management_System.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<User> check(String name, String password) {
        String hql = "FROM User WHERE name = :nam AND password = :passwor";
        Query query = session.createQuery(hql);
        query.setParameter("nam", name);
        query.setParameter("passwor", password);
        List<User> list = query.list();
        session.close();
        return list;
    }
}
