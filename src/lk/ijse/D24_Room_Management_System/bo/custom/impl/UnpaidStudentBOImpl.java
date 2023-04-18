package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.custom.UnpaidStudentBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.QueryDAO;
import lk.ijse.D24_Room_Management_System.entity.Custom;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.StudentTDM;
import org.hibernate.Session;

import java.util.List;

public class UnpaidStudentBOImpl implements UnpaidStudentBO {
    private final  QueryDAO unpaidDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.UNPAID);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public ObservableList<StudentTDM> getUnpaidStudents() {
        ObservableList<StudentTDM> std = FXCollections.observableArrayList();
        Session session = getSession();
        unpaidDAO.setSession(session);
        List<Custom> students = unpaidDAO.loadAllStudent();
        for (Custom s : students) {
            std.add(new StudentTDM(s.getSId(),s.getName(),s.getAddress(),s.getContactNo(),s.getDate(),s.getGender()));
        }
        return std;
    }
}
