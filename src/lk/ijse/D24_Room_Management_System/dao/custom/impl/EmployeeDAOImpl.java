package lk.ijse.D24_Room_Management_System.dao.custom.impl;

import lk.ijse.D24_Room_Management_System.dao.custom.EmployeeDAO;
import lk.ijse.D24_Room_Management_System.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

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
    public boolean delete(Employee employee) {
        if (employee != null){
            session.delete(employee);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Employee> getEmployee() {
        String hql = "FROM Employee";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }
}
