package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.custom.RoomBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.RoomDAO;
import lk.ijse.D24_Room_Management_System.dto.RoomDTO;
import lk.ijse.D24_Room_Management_System.entity.Room;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.RoomTDM;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.ROOM);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public boolean addRoom(RoomDTO dto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDAO.setSession(session);
            boolean save = roomDAO.save(new Room(dto.getRId(), dto.getType(), dto.getKeyMoney(),
                    dto.getQty()));
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
    public boolean deleteRoom(RoomDTO dto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            boolean delete = roomDAO.delete(new Room(dto.getRId(), dto.getType(),
                    dto.getKeyMoney(), dto.getQty()));
            transaction.commit();
            session.close();
            return delete;
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public RoomDTO searchRoom(String id) {
        try {
            Session session = getSession();
            roomDAO.setSession(session);
            Room room = roomDAO.get(id);
            session.close();
            return new RoomDTO(room.getRId(), room.getType(), room.getKeyMoney(), room.getQty());
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDAO.setSession(session);
            boolean update = roomDAO.update(new Room(dto.getRId(),dto.getType(),
                    dto.getKeyMoney(),dto.getQty()));
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
    public ObservableList<RoomTDM> getAllRoom() {
        return null;
    }
}
