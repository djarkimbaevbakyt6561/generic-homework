package java12.db;

import java12.model.Animal;
import java12.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Person> people = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Person> getPeople() {
        return people;
    }
}
