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

    private final Session session = FactoryConfiguration.getInstance().getSession();
    private final EmployeeDAO empDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.EMPLOYEE);


    @Override
    public boolean saveEmployee(EmployeeDTO employeeDTO) {
        Transaction transaction = session.beginTransaction();
        try{
            empDAO.setSession(session);
            String save = empDAO.save(new Employee(employeeDTO.getEId(), employeeDTO.getName(), employeeDTO.getAddress(),
                    employeeDTO.getContact(), employeeDTO.getRole()));
            transaction.commit();
            session.close();
            return save.equals("ADD");
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }
}
