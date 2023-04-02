package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.custom.EmployeeBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.EmployeeDAO;
import lk.ijse.D24_Room_Management_System.dto.EmployeeDTO;
import lk.ijse.D24_Room_Management_System.entity.Employee;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.EmployeeTDM;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    private final EmployeeDAO empDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.EMPLOYEE);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public boolean saveEmployee(EmployeeDTO employeeDTO) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try{
            empDAO.setSession(session);
            boolean save = empDAO.save(new Employee(employeeDTO.getEId(), employeeDTO.getName(), employeeDTO.getAddress(),
                    employeeDTO.getContact(), employeeDTO.getRole()));
            transaction.commit();
            session.close();
            return save;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean updateCustomer(EmployeeDTO employeeDTO) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            empDAO.setSession(session);
            boolean update = empDAO.update(new Employee(employeeDTO.getEId(),employeeDTO.getName(),
                    employeeDTO.getAddress(),employeeDTO.getContact(),employeeDTO.getRole()));
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
    public EmployeeDTO searchEmployee(String id) {
        try{
            Session session = getSession();
            empDAO.setSession(session);
            Employee emp = empDAO.get(id);
            session.close();
            return new EmployeeDTO(emp.getEId(),emp.getName(),emp.getAddress(),emp.getContact(),emp.getRole());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean deleteCustomer(EmployeeDTO empDTO) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            empDAO.setSession(session);
            boolean delete = empDAO.delete(new Employee(empDTO.getEId(), empDTO.getName(), empDTO.getAddress(),
                    empDTO.getContact(), empDTO.getRole()));
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
    public ObservableList<EmployeeTDM> getAllEmployee() {
        Session session = getSession();
        empDAO.setSession(session);
        List<Employee> employee = empDAO.getEmployee();
        ObservableList<EmployeeTDM> empList = FXCollections.observableArrayList();
        for (Employee emp : employee) {
            empList.add(new EmployeeTDM(emp.getEId(),emp.getName(),emp.getAddress(),emp.getContact(),emp.getRole()));
        }
        return empList;
    }
}
