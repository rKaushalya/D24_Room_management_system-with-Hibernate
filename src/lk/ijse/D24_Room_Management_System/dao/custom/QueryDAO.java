package lk.ijse.D24_Room_Management_System.dao.custom;

import lk.ijse.D24_Room_Management_System.dao.SuperDAO;
import lk.ijse.D24_Room_Management_System.entity.Custom;
import lk.ijse.D24_Room_Management_System.entity.Student;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<Custom> loadAllStudent();
}
