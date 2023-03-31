package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.EmployeeDAO;
import lk.ijse.D24_Room_Management_System.entity.Employee;
import org.hibernate.Session;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String save(Employee employee) {
        String save = (String) session.save(employee);
        return "ADD";
    }

    @Override
    public void update(Employee object) {

    }

    @Override
    public Employee get(String id) {
        return session.get(Employee.class, id);
    }

    @Override
    public void delete(Employee object) {

    }
}
