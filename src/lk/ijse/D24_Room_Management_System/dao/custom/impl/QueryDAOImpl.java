package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.QueryDAO;
import lk.ijse.D24_Room_Management_System.entity.Custom;
import lk.ijse.D24_Room_Management_System.entity.Student;
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
    public List<Custom> loadAllStudent() {
        String hql = "SELECT Student.sId,Student .name,Student .address,Student .contactNo,Student .dob,Student .gender," +
                "Reservation .resId FROM Student INNER JOIN Reservation ON Student .sId = Reservation.student.sId WHERE " +
                "Reservation .status ='Not Paid'";
        Query query = session.createQuery(hql);
        List<Custom> list = query.list();
        session.close();
        return list;
    }
}
