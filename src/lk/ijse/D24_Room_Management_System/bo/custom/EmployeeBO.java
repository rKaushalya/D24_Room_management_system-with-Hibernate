package lk.ijse.D24_Room_Management_System.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.dto.EmployeeDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.EmployeeTDM;

import java.util.List;

public interface EmployeeBO extends SuperBO {
    boolean saveEmployee(EmployeeDTO employeeDTO);

    boolean updateCustomer(EmployeeDTO employeeDTO);

    EmployeeDTO searchEmployee(String id);

    boolean deleteCustomer(EmployeeDTO employeeDTO);

    ObservableList<EmployeeTDM> getAllEmployee();
}
