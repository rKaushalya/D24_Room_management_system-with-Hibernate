package lk.ijse.D24_Room_Management_System.dao.custom;

import lk.ijse.D24_Room_Management_System.dao.SuperDAO;
import lk.ijse.D24_Room_Management_System.entity.User;

import java.util.List;

public interface LoginDAO extends SuperDAO {
    List<User> check(String name, String password);
}
