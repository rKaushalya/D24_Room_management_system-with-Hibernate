package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.EmployeeDAO;
import lk.ijse.D24_Room_Management_System.entity.Employee;
import org.hibernate.Session;

import java.io.Serializable;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Employee employee) {
        if (employee != null) {
            session.save(employee);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Employee employee) {
        if (employee != null) {
            session.update(employee);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Employee get(String id) {
        return session.get(Employee.class, id);
    }

    @Override
    public void delete(Employee object) {

    }
}
