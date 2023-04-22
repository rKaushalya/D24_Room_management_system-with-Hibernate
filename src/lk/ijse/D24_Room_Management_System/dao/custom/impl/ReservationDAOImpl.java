package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.ReservationDAO;
import lk.ijse.D24_Room_Management_System.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean register(Reservation reservation) {
        if (reservation != null){
            session.save(reservation);
            return true;
        }
        return false;
    }

    @Override
    public String generateNextResId() {
        String hql = "SELECT resId FROM Reservation ORDER BY resId DESC";
        Query query = session.createQuery(hql).setMaxResults(1);
        List<String> list = query.list();
        session.close();

        for (String id : list) {
            return id;
        }
        return null;
    }

    @Override
    public List<Reservation> allData() {
        Query query = session.createQuery("FROM Reservation");
        List<Reservation> list = query.list();
        session.close();
        return list;
    }
}
