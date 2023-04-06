package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.BOFactory;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.bo.custom.ReservationBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.SuperDAO;
import lk.ijse.D24_Room_Management_System.dao.custom.ReservationDAO;
import lk.ijse.D24_Room_Management_System.dao.custom.RoomDAO;
import lk.ijse.D24_Room_Management_System.dao.custom.StudentDAO;
import lk.ijse.D24_Room_Management_System.dto.CustomDTO;
import lk.ijse.D24_Room_Management_System.entity.Reservation;
import lk.ijse.D24_Room_Management_System.entity.Room;
import lk.ijse.D24_Room_Management_System.entity.Student;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import lk.ijse.D24_Room_Management_System.view.tdm.RoomTDM;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    private final ReservationDAO resDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.RESERVATION);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.ROOM);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.STUDENT);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public boolean addReservation(CustomDTO dto) {
        Student student = new Student();
        student.setSId(dto.getSId());
        student.setName(dto.getName());
        student.setAddress(dto.getAddress());
        student.setContactNo(dto.getContactNo());
        student.setDob(dto.getDob());
        student.setGender(dto.getGender());

        Session session = getSession();
        roomDAO.setSession(session);
        Room room = roomDAO.get(dto.getRId());
        room.setQty(room.getQty()-1);

        Reservation reservation = new Reservation();
        reservation.setResId(dto.getResId());
        reservation.setDate(dto.getDate());
        reservation.setStatus(dto.getStatus());
        reservation.setStudent(student);
        reservation.setRoom(room);

        student.getStudentDetails().add(reservation);
        room.getRoomDetails().add(reservation);

        Transaction transaction = session.beginTransaction();
        studentDAO.setSession(session);
        boolean save = studentDAO.save(student);
        if (save){
            roomDAO.setSession(session);
            boolean update = roomDAO.update(room);
            if (update){
                resDAO.setSession(session);
                boolean register = resDAO.register(reservation);
                if (register){
                    transaction.commit();
                    session.close();
                    return true;
                }
            }
        }
        transaction.rollback();
        session.close();
        return false;
    }

    @Override
    public ObservableList<String> loadAllRid() {
       ObservableList<String> roomId = FXCollections.observableArrayList();
        Session session = getSession();
        roomDAO.setSession(session);
        List<String> rId = roomDAO.getRoomId();
        for (String id : rId) {
            roomId.add(id);
        }
        return roomId;
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
