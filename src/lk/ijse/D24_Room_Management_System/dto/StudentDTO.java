package lk.ijse.D24_Room_Management_System.dto;

import lk.ijse.D24_Room_Management_System.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate date;
    private String gender;
    private List<Reservation> studentDetails = new ArrayList<>();

    public StudentDTO(String sId, String name, String address, String contactNo, LocalDate date, String gender) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.date = date;
        this.gender = gender;
    }
}
