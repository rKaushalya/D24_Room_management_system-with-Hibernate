package lk.ijse.D24_Room_Management_System.dao.custom;

import lk.ijse.D24_Room_Management_System.dao.CrudDAO;
import lk.ijse.D24_Room_Management_System.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User, String> {

    List<User> getAllUser();
}
