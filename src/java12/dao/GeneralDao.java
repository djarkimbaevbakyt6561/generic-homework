package java12.dao;

import java.util.List;

public interface GeneralDao<T> {
    Boolean add(T t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(Integer type);
    List<T> sortByAge(Integer type);
    List<T> filterByGender(Integer type);
    void clear();
}
