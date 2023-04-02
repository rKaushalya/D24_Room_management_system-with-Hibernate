package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.StudentDAO;
import lk.ijse.D24_Room_Management_System.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Student student) {
        if (student != null) {
            session.save(student);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Student student) {
        if (student != null){
            session.update(student);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Student get(String id) {
        return session.get(Student.class,id);
    }

    @Override
    public boolean delete(Student student) {
        if (student != null){
            session.delete(student);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Student> getAll() {
        String hql = "FROM Student";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }
}
