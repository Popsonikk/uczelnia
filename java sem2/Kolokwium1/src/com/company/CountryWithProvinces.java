package com.company;

public class CountryWithProvinces extends  Country{
    private Country [] countryProf;

    public CountryWithProvinces(String name,Country [] countryProf) {
        super(name);
        this.countryProf=countryProf;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
