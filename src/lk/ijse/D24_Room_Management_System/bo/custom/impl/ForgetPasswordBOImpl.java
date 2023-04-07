package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import lk.ijse.D24_Room_Management_System.bo.custom.ForgetPasswordBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.ForgetPasswordDAO;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ForgetPasswordBOImpl implements ForgetPasswordBO {
    private final ForgetPasswordDAO forgetDAO = (ForgetPasswordDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.FORGET);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public boolean forgetPassword(String id, String name, String password) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        forgetDAO.setSession(session);
        int i = forgetDAO.checkUser(id, name, password);
        if (i > 0){
            transaction.commit();
            session.close();
            return true;
        }else {
            transaction.rollback();
            session.close();
            return false;
        }
    }
}
