package lk.ijse.D24_Room_Management_System.dto;

import lk.ijse.D24_Room_Management_System.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTO {
    private String rId;
    private String type;
    private String keyMoney;
    private int qty;
    private List<Reservation> roomDetails = new ArrayList<>();
}
