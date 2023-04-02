package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.custom.StudentBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.StudentDAO;
import lk.ijse.D24_Room_Management_System.dto.StudentDTO;
import lk.ijse.D24_Room_Management_System.entity.Student;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.StudentTDM;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentBOImpl implements StudentBO {

    private final  StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.STUDENT);
    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public boolean addStudent(StudentDTO dto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
           studentDAO.setSession(session);
            boolean save = studentDAO.save(new Student(dto.getSId(), dto.getName(), dto.getAddress(),
                    dto.getContactNo(), dto.getDate(), dto.getGender()));
            transaction.commit();
            session.close();
            return save;
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean updateStudent(StudentDTO dto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.setSession(session);
            boolean update = studentDAO.update(new Student(dto.getSId(), dto.getName(), dto.getAddress(),
                    dto.getContactNo(), dto.getDate(), dto.getGender()));
            transaction.commit();
            session.close();
            return update;
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(StudentDTO dto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.setSession(session);
            boolean delete = studentDAO.delete(new Student(dto.getSId(), dto.getName(), dto.getAddress(),
                    dto.getContactNo(), dto.getDate(), dto.getGender()));
            transaction.commit();
            session.close();
            return delete;
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public StudentDTO searchStudent(String id) {
        Session session = getSession();
        try {
            studentDAO.setSession(session);
            Student student = studentDAO.get(id);
            session.close();
            return new StudentDTO(student.getSId(),student.getName(),student.getAddress(),
                    student.getContactNo(),student.getDob(),student.getGender());
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ObservableList<StudentTDM> getAllStudent() {
        Session session = getSession();
        ObservableList<StudentTDM> tdms = FXCollections.observableArrayList();
        studentDAO.setSession(session);
        List<Student> all = studentDAO.getAll();
        for (Student student : all) {
            tdms.add(new StudentTDM(student.getSId(),student.getName(),student.getAddress(),
                    student.getContactNo(),student.getDob(),student.getGender()));
        }
        return tdms;
    }
}
