package lk.ijse.D24_Room_Management_System.dao.custom;

import lk.ijse.D24_Room_Management_System.dao.CrudDAO;
import lk.ijse.D24_Room_Management_System.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee , String> {

    List<Employee> getEmployee();
}
