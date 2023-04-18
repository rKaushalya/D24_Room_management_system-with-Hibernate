package lk.ijse.D24_Room_Management_System.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.view.tdm.StudentTDM;

public interface UnpaidStudentBO extends SuperBO {
    ObservableList<StudentTDM> getUnpaidStudents();
}
