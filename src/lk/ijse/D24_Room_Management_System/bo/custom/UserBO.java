package lk.ijse.D24_Room_Management_System.bo.custom;


import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.dto.UserDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.UserTDM;

public interface UserBO extends SuperBO {

    boolean addUser(UserDTO dto);

    boolean updateUser(UserDTO dto);

    boolean deleteUser(UserDTO dto);

    ObservableList<UserTDM> getAllUser();
}
