package java12.dao.impl;

import java12.dao.GeneralDao;
import java12.db.Database;
import java12.enums.Gender;
import java12.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonDaoImpl implements GeneralDao<Person> {
    private final Database database;

    public PersonDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public Boolean add(Person person) {
        return database.getPeople().add(person);
    }

    @Override
    public Person getById(Long id) {
        for (Person person : database.getPeople()) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return database.getPeople();
    }

    @Override
    public List<Person> sortByName(Integer type) {
        if (type == 1) {
            database.getPeople().sort(Comparator.comparing(Person::getName));
        } else if (type == 2) {
            database.getPeople().sort(Comparator.comparing(Person::getName).reversed());
        } else {
            return null;
        }
        return database.getPeople();
    }

    @Override
    public List<Person> sortByAge(Integer type) {
        if (type == 1) {
            database.getPeople().sort(Comparator.comparing(Person::getAge));
        } else if (type == 2) {
            database.getPeople().sort(Comparator.comparing(Person::getAge).reversed());
        } else {
            return null;
        }
        return database.getPeople();
    }

    @Override
    public List<Person> filterByGender(Integer type) {
        List<Person> newPeopleList = new ArrayList<>();
        if (type == 1) {
            for (Person person : database.getPeople()) {
                if (person.getGender().equals(Gender.FEMALE)) {
                    newPeopleList.add(person);
                }
            }
        } else if (type == 2) {
            for (Person person : database.getPeople()) {
                if (person.getGender().equals(Gender.MALE)) {
                    newPeopleList.add(person);
                }
            }
        } else {
            return null;
        }
        return newPeopleList;
    }

    @Override
    public void clear() {
        database.getPeople().clear();
    }
}
