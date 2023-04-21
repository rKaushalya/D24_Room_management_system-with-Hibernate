package lk.ijse.D24_Room_Management_System.bo.custom.impl;

import lk.ijse.D24_Room_Management_System.bo.custom.DashBordBO;
import lk.ijse.D24_Room_Management_System.dao.DAOFactory;
import lk.ijse.D24_Room_Management_System.dao.custom.EmployeeDAO;
import lk.ijse.D24_Room_Management_System.dao.custom.RoomDAO;
import lk.ijse.D24_Room_Management_System.dao.custom.StudentDAO;
import lk.ijse.D24_Room_Management_System.entity.Employee;
import lk.ijse.D24_Room_Management_System.entity.Room;
import lk.ijse.D24_Room_Management_System.entity.Student;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class DashBordBOImpl implements DashBordBO {
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.ROOM);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.STUDENT);
    private final EmployeeDAO empDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.Types.EMPLOYEE);

    @Override
    public Session getSession() {
        return FactoryConfiguration.getInstance().getSession();
    }

    @Override
    public int getRoomCount1() {
        Session session = getSession();
        roomDAO.setSession(session);
        List<Room> room1 = roomDAO.getRoom1();
        int count = 0;
        for (Room r : room1) {
            count = r.getQty();
        }
        return count;
    }

    @Override
    public int getRoomCount2() {
        Session session = getSession();
        roomDAO.setSession(session);
        List<Room> room1 = roomDAO.getRoom2();
        int count = 0;
        for (Room r : room1) {
            count = r.getQty();
        }
        return count;
    }

    @Override
    public int getRoomCount3() {
        Session session = getSession();
        roomDAO.setSession(session);
        List<Room> room1 = roomDAO.getRoom3();
        int count = 0;
        for (Room r : room1) {
            count = r.getQty();
        }
        return count;
    }

    @Override
    public int getRoomCount4() {
        Session session = getSession();
        roomDAO.setSession(session);
        List<Room> room1 = roomDAO.getRoom4();
        int count = 0;
        for (Room r : room1) {
            count = r.getQty();
        }
        return count;
    }

    @Override
    public int getStudentCount() {
        Session session = getSession();
        studentDAO.setSession(session);
        List<Student> all = studentDAO.getAll();
        int count = 0;
        for (Student student : all) {
            count ++;
        }
        return count;
    }

    @Override
    public int getEmployeeCount() {
        Session session = getSession();
        empDAO.setSession(session);
        List<Employee> employee = empDAO.getEmployee();
        int count = 0;
        for (Employee e : employee) {
            count ++;
        }
        return count;
    }
}
