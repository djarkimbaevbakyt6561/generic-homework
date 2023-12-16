package service;

import java.util.List;

public interface GenericService<T> {

    Boolean add(T t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(Integer type);
    List<T> sortByAge(Integer type);
    List<T> filterByGender(Integer type);
    void clear();
}
