package lk.ijse.D24_Room_Management_System.dto;

import lk.ijse.D24_Room_Management_System.entity.Room;
import lk.ijse.D24_Room_Management_System.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDTO {
    private String resId;
    private LocalDate date;
    private String status;
    private Student student;
    private Room room;
}
