package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.StudentDAO;
import lk.ijse.D24_Room_Management_System.entity.Student;
import org.hibernate.Session;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public void setSession(Session session) {

    }


    @Override
    public boolean save(Student object) {
        return false;
    }

    @Override
    public boolean update(Student object) {
        return false;
    }

    @Override
    public Student get(String s) {
        return null;
    }

    @Override
    public boolean delete(Student object) {
        return false;
    }
}
