import enums.Gender;
import model.Animal;
import model.Person;

import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите: 1 (Животное) / 2 (Человек)");
            String num = scanner.nextLine();
            boolean exit = false;

            if (num.equals("1")) {
                AnimalServiceImpl animalService = new AnimalServiceImpl();
                while (!exit) {
                    System.out.println("""
                            1.Добавить животного
                            2.Посмотреть всех животный
                            3.Посмотреть животного по id
                            4.Сортировать по имени
                            5.Сортировать по возрасту
                            6.Отфильтровать по гендеру
                            7.Очистить животных
                            8.Выйти""");
                    System.out.print("Выберите команду: ");
                    String num2 = scanner.nextLine();
                    switch (num2) {
                        case "1" -> {
                            Animal newAnimal = addAnimal(scanner);
                            if (newAnimal != null) {
                                newAnimal.setId((long) (animalService.getAll().size() + 1));
                                if (animalService.add(newAnimal)) {
                                    System.out.println("Животное успешно добавлено!");
                                } else {
                                    System.out.println("Ошибка при добавлении!");
                                }
                            }
                        }
                        case "2" -> {
                            if (animalService.getAll().isEmpty()) {
                                System.out.println("Животных нет!");
                            } else {
                                System.out.println("Все животные: ");
                                for (Animal animal : animalService.getAll()) {
                                    System.out.println(animal);
                                }
                            }
                        }
                        case "3" -> {
                            if (animalService.getAll().isEmpty()) {
                                System.out.println("Животных нет!");
                            } else {
                                System.out.print("Введите id: ");
                                String id = scanner.nextLine();
                                Animal foundAnimal = animalService.getById(Long.valueOf(id));
                                if (foundAnimal != null) {
                                    System.out.println(foundAnimal);
                                } else {
                                    System.out.println("Неправильный id!");
                                }
                            }

                        }
                        case "4" -> {
                            if (animalService.getAll().isEmpty()) {
                                System.out.println("Животных нет!");
                            } else {
                                try {
                                    System.out.println("Введите как будете сортировать: 1 (по возрастанию) / 2 (по убыванию)");
                                    List<Animal> newAnimals = animalService.sortByName(Integer.valueOf(scanner.nextLine()));
                                    if (newAnimals != null) {
                                        System.out.println("Все животные: ");
                                        for (Animal animal : newAnimals) {
                                            System.out.println(animal);
                                        }
                                    } else {
                                        System.out.println("Введите правильное число!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Введите число!");
                                }
                            }
                        }
                        case "5" -> {
                            if (animalService.getAll().isEmpty()) {
                                System.out.println("Животных нет!");
                            } else {
                                try {
                                    System.out.println("Введите как будете сортировать: 1 (по возрастанию) / 2 (по убыванию)");
                                    List<Animal> newAnimals = animalService.sortByAge(Integer.valueOf(scanner.nextLine()));
                                    if (newAnimals != null) {
                                        System.out.println("Все животные: ");
                                        for (Animal animal : newAnimals) {
                                            System.out.println(animal);
                                        }
                                    } else {
                                        System.out.println("Введите правильное число!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Введите число!");
                                }
                            }
                        }
                        case "6" -> {
                            if (animalService.getAll().isEmpty()) {
                                System.out.println("Животных нет!");
                            } else {
                                try {
                                    System.out.println("Введите как будете фильтровать: 1 (женщины) / 2 (мужчины)");
                                    List<Animal> newAnimals = animalService.filterByGender(Integer.valueOf(scanner.nextLine()));
                                    if (newAnimals != null) {
                                        System.out.println("Все животные: ");
                                        for (Animal animal : newAnimals) {
                                            System.out.println(animal);
                                        }
                                    } else {
                                        System.out.println("Введите правильное число!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Введите число!");
                                }
                            }
                        }
                        case "7" -> {
                            if (animalService.getAll().isEmpty()) {
                                System.out.println("Животных нет!");
                            } else {
                                animalService.clear();
                                System.out.println("Животные успешно очищены!");
                            }
                        }
                        case "8" -> {
                            System.out.println("Вы успешно вышли!");
                            exit = true;
                        }
                    }
                }
                break;
            } else if (num.equals("2")) {
                PersonServiceImpl personService = new PersonServiceImpl();
                while (!exit) {
                    System.out.println("""
                            1.Добавить человека
                            2.Посмотреть всех людей
                            3.Посмотреть человека по id
                            4.Сортировать по имени
                            5.Сортировать по возрасту
                            6.Отфильтровать по гендеру
                            7.Очистить людей
                            8.Выйти""");
                    System.out.print("Выберите команду: ");
                    String num2 = scanner.nextLine();
                    switch (num2) {
                        case "1" -> {
                            Person newPerson = addPerson(scanner);
                            if (newPerson != null) {
                                newPerson.setId((long) (personService.getAll().size() + 1));
                                if (personService.add(newPerson)) {
                                    System.out.println("Человек успешно добавлен!");
                                } else {
                                    System.out.println("Ошибка при добавлении!");
                                }
                            }
                        }
                        case "2" -> {
                            if (personService.getAll().isEmpty()) {
                                System.out.println("Людей нет!");
                            } else {
                                System.out.println("Все люди: ");
                                for (Person person : personService.getAll()) {
                                    System.out.println(person);
                                }
                            }
                        }
                        case "3" -> {
                            if (personService.getAll().isEmpty()) {
                                System.out.println("Людей нет!");
                            } else {
                                System.out.print("Введите id: ");
                                String id = scanner.nextLine();
                                Person foundPerson = personService.getById(Long.valueOf(id));
                                if (foundPerson != null) {
                                    System.out.println(foundPerson);
                                } else {
                                    System.out.println("Неправильный id!");
                                }
                            }
                        }
                        case "4" -> {
                            if (personService.getAll().isEmpty()) {
                                System.out.println("Людей нет!");
                            } else {
                                try {
                                    System.out.println("Введите как будете сортировать: 1 (по возрастанию) / 2 (по убыванию)");
                                    List<Person> newPersons = personService.sortByName(Integer.valueOf(scanner.nextLine()));
                                    if (newPersons != null) {
                                        System.out.println("Все люди: ");
                                        for (Person person : newPersons) {
                                            System.out.println(person);
                                        }
                                    } else {
                                        System.out.println("Введите правильное число!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Введите число!");
                                }

                            }
                        }
                        case "5" -> {
                            if (personService.getAll().isEmpty()) {
                                System.out.println("Людей нет!");
                            } else {
                                try {
                                    System.out.println("Введите как будете сортировать: 1 (по возрастанию) / 2 (по убыванию)");
                                    List<Person> newPersons = personService.sortByAge(Integer.valueOf(scanner.nextLine()));
                                    if (newPersons != null) {
                                        System.out.println("Все люди: ");
                                        for (Person person : newPersons) {
                                            System.out.println(person);
                                        }
                                    } else {
                                        System.out.println("Введите правильное число!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Введите число!");
                                }

                            }
                        }
                        case "6" -> {
                            if (personService.getAll().isEmpty()) {
                                System.out.println("Людей нет!");
                            } else {
                                try {
                                    System.out.println("Введите как будете фильтровать: 1 (женщины) / 2 (мужчины)");
                                    List<Person> newPersons = personService.filterByGender(Integer.valueOf(scanner.nextLine()));
                                    if (newPersons != null) {
                                        System.out.println("Все люди: ");
                                        for (Person person : newPersons) {
                                            System.out.println(person);
                                        }
                                    } else {
                                        System.out.println("Введите правильное число!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Введите число!");
                                }

                            }
                        }
                        case "7" -> {
                            if (personService.getAll().isEmpty()) {
                                System.out.println("Людей нет!");

                            } else {
                                personService.clear();
                                System.out.println("Люди успешно очищены!");
                            }
                        }
                        case "8" -> {
                            System.out.println("Вы успешно вышли!");
                            exit = true;
                        }
                    }
                }
                break;
            }
        }

    }
    public static Animal addAnimal(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Значение не должно быть пустым.");
            return null;
        }
        System.out.print("Введите возраст: ");
        byte age;
        if (scanner.hasNextByte()) {
            age = scanner.nextByte();
        } else {
            System.out.println("Некорректный ввод возраста!");
            scanner.nextLine();
            return null;
        }
        scanner.nextLine();
        System.out.print("Введите гендер (male/female): ");
        Gender gender;
        String genderInput = scanner.nextLine();
        if (genderInput.equalsIgnoreCase("male")) {
            gender = Gender.MALE;
        } else if (genderInput.equalsIgnoreCase("female")) {
            gender = Gender.FEMALE;
        } else {
            System.out.println("Некорректный ввод гендера.");
            return null;
        }
        return new Animal(name, age, gender);
    }

    public static Person addPerson(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Значение не должно быть пустым.");
            return null;
        }
        System.out.print("Введите возраст: ");
        byte age;
        if (scanner.hasNextByte()) {
            age = scanner.nextByte();
        } else {
            System.out.println("Некорректный ввод возраста!");
            scanner.nextLine();
            return null;
        }
        scanner.nextLine();
        System.out.print("Введите гендер (male/female): ");
        Gender gender;
        String genderInput = scanner.nextLine();
        if (genderInput.equalsIgnoreCase("male")) {
            gender = Gender.MALE;
        } else if (genderInput.equalsIgnoreCase("female")) {
            gender = Gender.FEMALE;
        } else {
            System.out.println("Некорректный ввод гендера.");
            return null;
        }
        return new Person(name, age, gender);
    }
}