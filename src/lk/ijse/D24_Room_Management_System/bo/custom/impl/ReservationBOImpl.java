package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import lk.ijse.D24_Room_Management_System.bo.custom.ReservationBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.SuperDAO;
import lk.ijse.D24_Room_Management_System.dao.custom.ReservationDAO;
import lk.ijse.D24_Room_Management_System.dto.CustomDTO;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.RoomTDM;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationBOImpl implements ReservationBO {

    private final ReservationDAO resDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.RESERVATION);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public boolean addReservation(CustomDTO dto) {
        return false;
    }

    @Override
    public RoomTDM loadRoom(String id) {
        return null;
    }

    @Override
    public String generateNextReservationId(){
        Session session = getSession();
        resDAO.setSession(session);
        String id = resDAO.generateNextResId();
        if (id != null) {
            return newOrderID(id);
        }
        return newOrderID(null);
    }

    @Override
    public String newOrderID(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("R0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            if (id >= 10) {
                return "R0" + id;
            }
            return "R00" + id;
        }
        return "R001";
    }
}
