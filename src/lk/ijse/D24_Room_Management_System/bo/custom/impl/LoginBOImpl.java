package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import lk.ijse.D24_Room_Management_System.bo.custom.LoginBO;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;

public class LoginBOImpl implements LoginBO {
    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public boolean checkUser(String name, String password) {
        return false;
    }
}
