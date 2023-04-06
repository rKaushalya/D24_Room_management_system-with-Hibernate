package lk.ijse.D24_Room_Management_System.dao;

import lk.ijse.D24_Room_Management_System.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum Types{
        ROOM,RESERVATION,STUDENT,EMPLOYEE,USER,LOGIN
    }

    public SuperDAO getDAO(Types types){
        switch (types){
            case STUDENT:
                return new StudentDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case USER:
                return new UserDAOImpl();
            case LOGIN:
                return new LoginDAOImpl();
            default:
                return null;
        }
    }
}
