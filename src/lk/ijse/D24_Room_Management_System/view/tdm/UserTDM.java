package lk.ijse.D24_Room_Management_System.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserTDM {
    private String uId;
    private String name;
    private String email;
    private String password;
    private String role;
}
