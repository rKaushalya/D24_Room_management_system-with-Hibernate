package lk.ijse.D24_Room_Management_System.dao;

public interface CrudDAO<T, ID> extends SuperDAO{

    ID save(T object);

    void update(T object);

    T get(ID id);

    void delete(T object);
}
