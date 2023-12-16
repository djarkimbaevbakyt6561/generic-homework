package java12.dao.impl;

import java12.dao.GeneralDao;
import java12.db.Database;
import java12.enums.Gender;
import java12.model.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalDaoImpl implements GeneralDao<Animal> {
    private final Database database;

    public AnimalDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public Boolean add(Animal animal) {
        return database.getAnimals().add(animal);
    }

    @Override
    public Animal getById(Long id) {
        for (Animal animal : database.getAnimals()) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return database.getAnimals();
    }

    @Override
    public List<Animal> sortByName(Integer type) {
        if (type == 1) {
            database.getAnimals().sort(Comparator.comparing(Animal::getName));
        } else if (type == 2) {
            database.getAnimals().sort(Comparator.comparing(Animal::getName).reversed());
        } else {
            return null;
        }
        return database.getAnimals();
    }

    @Override
    public List<Animal> sortByAge(Integer type) {
        if (type == 1) {
            database.getAnimals().sort(Comparator.comparing(Animal::getAge));
        } else if (type == 2) {
            database.getAnimals().sort(Comparator.comparing(Animal::getAge).reversed());
        } else {
            return null;
        }
        return database.getAnimals();
    }

    @Override
    public List<Animal> filterByGender(Integer type) {
        List<Animal> newAnimalList = new ArrayList<>();
        if (type == 1) {
            for (Animal animal : database.getAnimals()) {
                if (animal.getGender().equals(Gender.FEMALE)) {
                    newAnimalList.add(animal);
                }
            }
        } else if (type == 2) {
            for (Animal animal : database.getAnimals()) {
                if (animal.getGender().equals(Gender.MALE)) {
                    newAnimalList.add(animal);
                }
            }
        } else {
            return null;
        }
        return newAnimalList;
    }

    @Override
    public void clear() {
        database.getAnimals().clear();
    }
}
