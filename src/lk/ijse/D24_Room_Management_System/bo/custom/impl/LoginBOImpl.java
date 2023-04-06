package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import lk.ijse.D24_Room_Management_System.bo.custom.LoginBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.LoginDAO;
import lk.ijse.D24_Room_Management_System.entity.User;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class LoginBOImpl implements LoginBO {
    private final LoginDAO loginDAO = (LoginDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.LOGIN);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public String checkUser(String name, String password) {
        Session session = getSession();
        loginDAO.setSession(session);
        User user = new User();
        List<User> check = loginDAO.check(name, password);
        for (User u : check) {
            user.setRole(u.getRole());
        }
        if (user.getRole().equals("Admin")){
            return "Admin";
        }else if (user.getRole().equals("Reception")){
            return "Reception";
        }
        return "No";
    }
}
