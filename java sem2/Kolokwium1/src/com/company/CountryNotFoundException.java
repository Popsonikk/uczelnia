package com.company;

public class CountryNotFoundException extends Exception{
    String name;

    public CountryNotFoundException(String name) {
        this.name = name;
    }

    public CountryNotFoundException(String message, String name) {
        super("Country not found");
        this.name = name;
    }
}
