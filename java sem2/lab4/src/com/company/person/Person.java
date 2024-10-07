package com.company.person;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


public class Person {
    String name;
    LocalDate birth, death;
    List<Person> parents = new ArrayList<>();



    Person(String name, LocalDate birth, LocalDate death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                ", parents=" + parents +
                '}';
    }

    public LocalDate getBirth() {
        return birth;
    }

    static LocalDate parseDate(String str) throws DateTimeParseException, NullPointerException {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    static String parseDate(LocalDate date)  {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}
