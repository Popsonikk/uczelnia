package com.company;

import java.time.LocalDate;

public class Student extends Account
{
    private  String course;
    private int startYear;

    public Student(String login, String password, String firstName, String lastName, String course, int startYear) {
        super(login, password, firstName, lastName);
        this.course = course;
        this.startYear = startYear;
    }
    public int semestr()
    {
        int yearNow=LocalDate.now().getYear();
        int sem=(yearNow-startYear)*2;
        int month=LocalDate.now().getDayOfMonth();
        if(month<2)
            sem--;

        else if(month>=10)
            sem++;

        return sem;
    }
}
