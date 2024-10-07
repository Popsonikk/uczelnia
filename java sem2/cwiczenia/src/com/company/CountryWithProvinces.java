package com.company;

public class CountryWithProvinces extends Country{
    private Country [] countries;

    public CountryWithProvinces(String name, Country[] countries) {
        super(name);
        this.countries = countries;
    }
}
