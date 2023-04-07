package lk.ijse.D24_Room_Management_System.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @Column(name = "student_id")
    private String sId;
    private String name;
    private String address;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "dob", columnDefinition = "DATE")
    private LocalDate dob;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL, /*fetch = FetchType.EAGER,*/ mappedBy = "student")
    private List<Reservation> studentDetails = new ArrayList<>();

    public Student(String sId, String name, String address, String contactNo, LocalDate dob, String gender) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.gender = gender;
    }
}
