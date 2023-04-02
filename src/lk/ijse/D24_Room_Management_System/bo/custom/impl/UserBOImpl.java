package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.custom.UserBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.UserDAO;
import lk.ijse.D24_Room_Management_System.dto.UserDTO;
import lk.ijse.D24_Room_Management_System.entity.User;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.UserTDM;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserBOImpl implements UserBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.USER);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public boolean addUser(UserDTO dto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userDAO.setSession(session);
            boolean save = userDAO.save(new User(dto.getUId(),dto.getName(),
                    dto.getEmail(),dto.getPassword(),dto.getRole()));
            transaction.commit();
            session.close();
            return save;
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean updateUser(UserDTO dto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userDAO.setSession(session);
            boolean update = userDAO.update(new User(dto.getUId(), dto.getName(),
                    dto.getEmail(), dto.getPassword(), dto.getRole()));
            transaction.commit();
            session.close();
            return update;
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean deleteUser(UserDTO dto) {
        return false;
    }

    @Override
    public UserDTO searchUser(String id) {
        Session session = getSession();
        try {
            userDAO.setSession(session);
            User user = userDAO.get(id);
            session.close();
            return new UserDTO(user.getUId(),user.getName(),
                    user.getEmail(),user.getPassword(),user.getRole());
        }catch (Exception e){
            System.out.println(e);
            session.close();
            return null;
        }
    }

    @Override
    public ObservableList<UserTDM> getAllUser() {
        return null;
    }
}
