package lk.ijse.D24_Room_Management_System.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {
    @Id
    @Column(name = "room_type_id")
    private String rId;
    private String type;
    @Column(name = "key_money")
    private String keyMoney;
    private int qty;

    @OneToMany(cascade = CascadeType.ALL, /*fetch = FetchType.EAGER,*/ mappedBy = "room")
    private List<Reservation> roomDetails = new ArrayList<>();

    public Room(String rId, String type, String keyMoney, int qty) {
        this.rId = rId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }
}
