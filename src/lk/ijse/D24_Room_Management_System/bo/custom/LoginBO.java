package lk.ijse.D24_Room_Management_System.bo.custom;

import lk.ijse.D24_Room_Management_System.bo.SuperBO;

public interface LoginBO extends SuperBO {
    String checkUser(String name,String password);
}
