package lk.ijse.D24_Room_Management_System.bo.custom;

import lk.ijse.D24_Room_Management_System.bo.SuperBO;

public interface ForgetPasswordBO extends SuperBO {

    boolean forgetPassword(String id,String name,String password);
}
