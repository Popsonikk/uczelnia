package com.company;

public abstract  class Subject {
    String name;
   float [] arr;

    public Subject(String name, float[] arr) {
        this.name = name;
        this.arr = arr;
    }
    abstract float avg();


}
