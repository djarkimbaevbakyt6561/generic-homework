package java12.service.impl;

import java12.dao.GeneralDao;
import java12.dao.impl.PersonDaoImpl;
import java12.model.Person;
import java12.service.GenericService;

import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {
    GeneralDao<Person> personDao;

    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }

    @Override
    public Boolean add(Person person) {
        return personDao.add(person);
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName(Integer type) {
        return personDao.sortByName(type);
    }

    @Override
    public List<Person> sortByAge(Integer type) {
        return personDao.sortByAge(type);
    }

    @Override
    public List<Person> filterByGender(Integer type) {
        return personDao.filterByGender(type);
    }

    @Override
    public void clear() {
        personDao.clear();
    }
}
