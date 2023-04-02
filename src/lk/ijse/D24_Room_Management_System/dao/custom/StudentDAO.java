package lk.ijse.D24_Room_Management_System.dao.custom;

import lk.ijse.D24_Room_Management_System.dao.CrudDAO;
import lk.ijse.D24_Room_Management_System.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student, String> {

    List<Student> getAll();
}
