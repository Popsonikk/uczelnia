package com.example.lab9;

public class Miasto {
    Boolean capital;
    String country;
    String name;
    Long population;

    public Miasto(Boolean capital, String country, String name, Long population) {
        this.capital = capital;
        this.country = country;
        this.name = name;
        this.population = population;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
