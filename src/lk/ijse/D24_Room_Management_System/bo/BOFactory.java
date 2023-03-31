package lk.ijse.D24_Room_Management_System.bo;

import lk.ijse.D24_Room_Management_System.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.D24_Room_Management_System.bo.custom.impl.ReservationBOImpl;
import lk.ijse.D24_Room_Management_System.bo.custom.impl.RoomBOImpl;
import lk.ijse.D24_Room_Management_System.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum Types{
        STUDENT,ROOM,RESERVATION,EMPLOYEE
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
            default:
                return null;
        }
    }
}
