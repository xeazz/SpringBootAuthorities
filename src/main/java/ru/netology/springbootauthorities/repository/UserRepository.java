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
    }

    public List<Authorities> getUserAuthorities(Person person) {
        List<Authorities> authoritiesList = new ArrayList<>();
        Person newPerson = personMap.get(person.getUser());
        if (newPerson.equals(person)) {
            authoritiesList.add(Authorities.READ);
            authoritiesList.add(Authorities.DELETE);
        }
        return authoritiesList;
    }
}