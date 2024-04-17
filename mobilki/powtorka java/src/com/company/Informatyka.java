package com.company;

import java.util.ArrayList;

public class Informatyka extends Wydział{


    public Informatyka(String nazwa, String dziekan) {
        super(nazwa, dziekan,new ArrayList<Student>());
    }

    @Override
    void dodajStudenta(Student student) {
        ArrayList<Student> st= getListaStudentów();
        st.add(student);
        setListaStudentów(st);
    }

    @Override
    void usunStudenta(Student student) {
        ArrayList<Student> st= getListaStudentów();
        for(int i=0;i<st.size();i++)
        {
            if(student.getNumerAlbumu()==st.get(i).getNumerAlbumu())
            {
                st.remove(student);
                setListaStudentów(st);
                return;
            }
        }

    }

    @Override
    void pokazStudenta() {
        ArrayList<Student> st= getListaStudentów();
        for (Student student : st) student.wyswieltInfo();
    }
}
