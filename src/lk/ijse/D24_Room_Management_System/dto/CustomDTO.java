package lk.ijse.D24_Room_Management_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomDTO {
    private String sId;
    private String name;
    private String address;
    private String contactNo;
    private LocalDate dob;
    private String gender;

    private String resId;
    private LocalDate date;
    private String status;

    private String rId;
}
