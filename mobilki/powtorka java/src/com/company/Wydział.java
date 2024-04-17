package com.company;

import java.util.ArrayList;

public  abstract class Wydział {
    public String nazwa;
    public String dziekan;
    private ArrayList<Student> listaStudentów;

    public Wydział(String nazwa, String dziekan,ArrayList<Student> list) {
        this.nazwa = nazwa;
        this.dziekan = dziekan;
        this.listaStudentów=list;

    }

    abstract void dodajStudenta(Student student);
    abstract void usunStudenta(Student student);
    abstract void pokazStudenta();

    public void setListaStudentów(ArrayList<Student> listaStudentów) {
        this.listaStudentów = listaStudentów;
    }

    public ArrayList<Student> getListaStudentów() {
        return listaStudentów;
    }
}
