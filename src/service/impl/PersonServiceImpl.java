package service.impl;

import model.Person;
import service.GenericService;

import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {
    @Override
    public String add(List<Person> persons) {
        return null;
    }

    @Override
    public Person getById(Long id) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public List<Person> sortByName(Integer type) {
        return null;
    }

    @Override
    public List<Person> filterByGender(Integer type) {
        return null;
    }

    @Override
    public List<Person> clear() {
        return null;
    }
}
