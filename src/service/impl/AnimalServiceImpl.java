package service.impl;

import enums.Gender;
import model.Animal;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {
    List<Animal> animals = new ArrayList<>();

    @Override
    public Boolean add(Animal animal) {
        return animals.add(animal);
    }

    @Override
    public Animal getById(Long id) {
        for (Animal animal : animals) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return animals;
    }

    @Override
    public List<Animal> sortByName(Integer type) {
        if (type == 1) {
            animals.sort(Comparator.comparing(Animal::getName));
        } else if (type == 2) {
            animals.sort(Comparator.comparing(Animal::getName).reversed());
        } else {
            return null;
        }
        return animals;
    }

    @Override
    public List<Animal> sortByAge(Integer type) {
        if (type == 1) {
            animals.sort(Comparator.comparing(Animal::getAge));
        } else if (type == 2) {
            animals.sort(Comparator.comparing(Animal::getAge).reversed());
        } else {
            return null;
        }
        return animals;
    }

    @Override
    public List<Animal> filterByGender(Integer type) {
        List<Animal> newAnimalList = new ArrayList<>();
        if (type == 1) {
            for (Animal animal : animals) {
                if (animal.getGender().equals(Gender.FEMALE)) {
                    newAnimalList.add(animal);
                }
            }
        } else if (type == 2) {
            for (Animal animal : animals) {
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
        animals.clear();
    }
}
