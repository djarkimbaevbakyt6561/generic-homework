package service.impl;

import enums.Gender;
import model.Person;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {
    List<Person> people = new ArrayList<>();

    @Override
    public Boolean add(Person person) {
        return people.add(person);
    }

    @Override
    public Person getById(Long id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

    @Override
    public List<Person> sortByName(Integer type) {
        if (type == 1) {
            people.sort(Comparator.comparing(Person::getName));
        } else if (type == 2) {
            people.sort(Comparator.comparing(Person::getName).reversed());
        } else {
            return null;
        }
        return people;
    }

    @Override
    public List<Person> sortByAge(Integer type) {
        if (type == 1) {
            people.sort(Comparator.comparing(Person::getAge));
        } else if (type == 2) {
            people.sort(Comparator.comparing(Person::getAge).reversed());
        } else {
            return null;
        }
        return people;
    }

    @Override
    public List<Person> filterByGender(Integer type) {
        List<Person> newPeopleList = new ArrayList<>();
        if (type == 1) {
            for (Person person : people) {
                if (person.getGender().equals(Gender.FEMALE)) {
                    newPeopleList.add(person);
                }
            }
        } else if (type == 2) {
            for (Person person : people) {
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
        people.clear();
    }
}
