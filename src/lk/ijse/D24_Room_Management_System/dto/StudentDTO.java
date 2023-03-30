package lk.ijse.D24_Room_Management_System.dto;

import lk.ijse.D24_Room_Management_System.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private String sId;
    private String name;
    private String address;
    private String contactNo;
    private Date date;
    private String gender;
    private List<Reservation> studentDetails = new ArrayList<>();
}
