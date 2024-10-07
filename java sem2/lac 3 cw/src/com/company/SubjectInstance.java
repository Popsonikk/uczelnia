package com.company;

import java.util.ArrayList;
import java.util.List;

public class SubjectInstance
{
    private Subject subject;
    private  int year;
    private Teacher teacher;
    private List<Student> students= new ArrayList<>();
    private int limit;

    public SubjectInstance(Subject subject, int year, Teacher teacher, int limit) {
        this.subject = subject;
        this.year = year;
        this.teacher = teacher;
        this.limit = limit;

    }
    public  Boolean enroll(Student student)
    {
        if(students.size()<limit)
        {
            students.add(student);
            return true;
        }
        else return false;
    }
    public List<Student> getCopy()
    {
        return List.copyOf(students);
    }
}
