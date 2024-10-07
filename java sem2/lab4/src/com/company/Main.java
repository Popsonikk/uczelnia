package com.company;


import com.company.person.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        PersonPersistenceManager manager=new CsvPersonPersistenceManager();
        Person [] people= manager.load("C:\\Users\\popso\\OneDrive\\Pulpit\\progrmowanie\\java sem2\\lab4\\src\\com\\company\\zadanie2.csv");
        for(Person p:people)
        System.out.println(p);
        System.out.println("\n");
        try {
            PersonPersistenceManager managerdir = new DirectoryPersonPersistenceManager();
            Person[] people2 = managerdir.load("C:\\Users\\popso\\OneDrive\\Pulpit\\progrmowanie\\java sem2\\lab4\\test_rodzice");
            for (Person p : people2)
                System.out.println(p);
        }
        catch (AmbigiousPersonException e) {
            e.printStackTrace();
        }
    }
}

