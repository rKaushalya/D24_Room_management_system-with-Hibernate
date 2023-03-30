package lk.ijse.D24_Room_Management_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    String eId;
    String name;
    String address;
    String contact;
    String role;
}
