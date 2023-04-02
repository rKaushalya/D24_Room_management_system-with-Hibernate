package lk.ijse.D24_Room_Management_System.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.dto.StudentDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.StudentTDM;

public interface StudentBO extends SuperBO {

    boolean addStudent(StudentDTO dto);

    boolean updateStudent(StudentDTO dto);

    boolean deleteStudent(StudentDTO dto);

    StudentDTO searchStudent(String id);

    ObservableList<StudentTDM> getAllStudent();
}
