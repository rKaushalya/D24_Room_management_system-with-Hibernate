package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.QueryDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<Object[]> loadAllStudent() {
        String hql = "SELECT res.resId,s.sId,s.name, r.rId, r.type, res.status FROM Reservation res JOIN " +
                "Student s ON res.student=s.sId JOIN Room r ON res.room=r.rId \n" +
                "WHERE res.status='Not Paid'";
        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        session.close();
        return list;
    }
}
