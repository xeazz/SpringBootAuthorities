package ru.netology.springbootauthorities.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootauthorities.authorities.Authorities;
import ru.netology.springbootauthorities.model.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    Map<Person, List<Authorities>> personMap = new HashMap<>();

    {
        personMap.put(new Person("Dima", "1234"), List.of(Authorities.values()));
        personMap.put(new Person("Tanya", "qwe123"), List.of(Authorities.READ));
        personMap.put(new Person("Pavel", "zXc!"), List.of(Authorities.WRITE));
        personMap.put(new Person("Vyacheslav", "234cd1"), List.of(Authorities.WRITE, Authorities.DELETE));
    }

    public List<Authorities> getUserAuthorities(Person person) {
        for (Person newPerson : personMap.keySet()) {
            if (newPerson.getUser().equals(person.getUser()) &&
                    newPerson.getPassword().equals(person.getPassword())) {
                return personMap.get(newPerson);
            }
        }
        return null;
    }

}