package lk.ijse.D24_Room_Management_System.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
    @Id
    @Column(name = "res_id")
    private String resId;
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id",
     referencedColumnName = "student_id",
     insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_type_id",
    referencedColumnName = "room_type_id",
    insertable = false, updatable = false)
    private Room room;
}
