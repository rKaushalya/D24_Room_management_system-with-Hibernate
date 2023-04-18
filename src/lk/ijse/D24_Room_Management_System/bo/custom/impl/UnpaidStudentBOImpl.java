package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.custom.UnpaidStudentBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.QueryDAO;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.CustomTDM;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UnpaidStudentBOImpl implements UnpaidStudentBO {
    private final  QueryDAO unpaidDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.UNPAID);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public ObservableList<CustomTDM> getUnpaidStudents() {
        ObservableList<CustomTDM> std = FXCollections.observableArrayList();
        Session session = getSession();
        unpaidDAO.setSession(session);
        List<Object[]> students = unpaidDAO.loadAllStudent();
        for (Object[] s : students) {
            std.add(new CustomTDM(s[1].toString(),s[2].toString(),s[0].toString(),s[5].toString(),s[3].toString(),s[4].toString()));
        }
        return std;
    }

    @Override
    public boolean updateStatus(String id, String status) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try{
        unpaidDAO.setSession(session);
        boolean update = unpaidDAO.update(id, status);
            transaction.commit();
            session.close();
            return update;
        }catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
            session.close();
            return false;
        }
    }
}
