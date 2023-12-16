package service;

import java.util.List;

public interface GenericService<T> {
    String add(List<T> t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(Integer type);
    List<T> filterByGender(Integer type);
    List<T> clear();
}
