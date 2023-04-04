package lk.ijse.D24_Room_Management_System.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentTDM {
    private String sId;
    private String name;
    private String address;
    private String contactNo;
    private LocalDate date;
    private String gender;
}
