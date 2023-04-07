package lk.ijse.D24_Room_Management_System.dao.custom;

import lk.ijse.D24_Room_Management_System.dao.SuperDAO;

public interface ForgetPasswordDAO extends SuperDAO {

    int checkUser(String id,String name,String password);

}
