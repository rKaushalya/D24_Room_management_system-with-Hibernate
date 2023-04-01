package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import lk.ijse.D24_Room_Management_System.bo.custom.EmployeeBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.EmployeeDAO;
import lk.ijse.D24_Room_Management_System.dto.EmployeeDTO;
import lk.ijse.D24_Room_Management_System.entity.Employee;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
