package lk.ijse.D24_Room_Management_System.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Student {
    private String sId;
    private String name;
    private String address;
    private String contactNo;
    private Date date;
    private String gender;
}
