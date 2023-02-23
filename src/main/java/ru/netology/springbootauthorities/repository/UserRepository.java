package ru.netology.springbootauthorities.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootauthorities.authorities.Authorities;
import ru.netology.springbootauthorities.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    Map<String, Person> personMap = new HashMap<>();

    {
        personMap.put("Dima", new Person("Dima", "1234"));
        personMap.put("Tanya", new Person("Tanya", "qwe123"));
        personMap.put("Pavel", new Person("Pavel", "zXc!"));
        personMap.put("Vyacheslav", new Person("Vyacheslav", "234cd1"));
    }

    public List<Authorities> getUserAuthorities(Person person) {
        List<Authorities> authoritiesList = new ArrayList<>();
        Person newPerson = personMap.get(person.getUser());
        if (personMap.containsKey(person.getUser()) && newPerson.getPassword().equals(person.getPassword())) {
            if ("Dima".equals(person.getUser())) {
                authoritiesList.add(Authorities.READ);
                authoritiesList.add(Authorities.DELETE);
                authoritiesList.add(Authorities.WRITE);
            } else if ("Tanya".equals(person.getUser())) {
                authoritiesList.add(Authorities.READ);
            } else if ("Pavel".equals(person.getUser())) {
                authoritiesList.add(Authorities.WRITE);
            } else if ("Vyacheslav".equals(person.getUser())) {
                authoritiesList.add(Authorities.WRITE);
                authoritiesList.add(Authorities.DELETE);
            }
        }
        return authoritiesList;
    }
}