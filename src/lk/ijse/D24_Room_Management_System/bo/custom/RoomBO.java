package lk.ijse.D24_Room_Management_System.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.D24_Room_Management_System.bo.SuperBO;
import lk.ijse.D24_Room_Management_System.dto.RoomDTO;
import lk.ijse.D24_Room_Management_System.view.tdm.RoomTDM;

public interface RoomBO extends SuperBO {

    boolean addRoom(RoomDTO dto);

    boolean deleteRoom(RoomDTO dto);

    RoomDTO searchRoom(String id);

    boolean updateRoom(RoomDTO dto);

    ObservableList<RoomTDM> getAllRoom();
}
