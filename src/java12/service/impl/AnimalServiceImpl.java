package java12.service.impl;

import java12.dao.GeneralDao;
import java12.dao.impl.AnimalDaoImpl;
import java12.enums.Gender;
import java12.model.Animal;
import java12.service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {
    GeneralDao<Animal> animalDao;

    public AnimalServiceImpl(AnimalDaoImpl animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public Boolean add(Animal animal) {
        return animalDao.add(animal);
    }

    @Override
    public Animal getById(Long id) {
        return animalDao.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName(Integer type) {
        return animalDao.sortByName(type);
    }

    @Override
    public List<Animal> sortByAge(Integer type) {
        return animalDao.sortByAge(type);
    }

    @Override
    public List<Animal> filterByGender(Integer type) {
        return animalDao.filterByGender(type);
    }

    @Override
    public void clear() {
        animalDao.clear();
    }
}
