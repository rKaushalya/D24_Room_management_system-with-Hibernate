package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import lk.ijse.D24_Room_Management_System.bo.custom.ForgetPasswordBO;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;

public class ForgetPasswordBOImpl implements ForgetPasswordBO {
    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }
}
