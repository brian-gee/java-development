package com.brian;

import java.util.ArrayList;

public class CountriesTextFile {
    CountryIO cio = new CountryIO();
    ArrayList countries = cio.getCountries();
    Console c = new Console();



    public void addCountry(String content)  {
        countries.add(content);
        System.out.println("This country has been saved.");
    }

    public void deleteCountry(int countryNum) {
        countries.remove(countryNum);
    }

    public void listCountries() {
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }
    }
}