package by.it.academy.Repository;

import java.io.Serializable;
import java.util.List;

public interface UserDao<T> {

    void create(T t);
    void update(T t);
    T read(Class clazz, Serializable id);
    void delete(T t);

    public T find(String userId);

    List<T> findAll(String searchStr);

}
