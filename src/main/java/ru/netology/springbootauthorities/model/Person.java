package ru.netology.springbootauthorities.model;

import java.util.Objects;

public class Person {
    private String user;
    private String password;

    public Person() {
    }

    public Person(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(user, person.user) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }
}
