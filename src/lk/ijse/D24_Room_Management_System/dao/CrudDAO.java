package lk.ijse.D24_Room_Management_System.dao;

public interface CrudDAO<T, ID> extends SuperDAO{

    boolean save(T object);

    boolean update(T object);

    T get(ID id);

    boolean delete(T object);
}
