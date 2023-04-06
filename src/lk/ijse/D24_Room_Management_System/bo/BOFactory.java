package lk.ijse.D24_Room_Management_System.bo;

import lk.ijse.D24_Room_Management_System.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum Types{
        STUDENT,ROOM,RESERVATION,EMPLOYEE,USER,LOGIN
    }

    public SuperBO getBO(Types types){
        switch (types){
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            case USER:
                return new UserBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            default:
                return null;
        }
    }
}
