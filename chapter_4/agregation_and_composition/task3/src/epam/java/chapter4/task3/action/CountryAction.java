package epam.java.chapter4.task3.action;

import epam.java.chapter4.task3.entity.City;
import epam.java.chapter4.task3.entity.Country;
import epam.java.chapter4.task3.entity.Region;

import java.util.ArrayList;
import java.util.List;

public class CountryAction {
    public CountryAction(){

    }

    public double getCountrySquare(Country country){
        double tempSquare;

        tempSquare = country.getSquare();

        return tempSquare;
    }

    public String getCapital(Country country){
        return country.getCapital().getName();
    }

    public int getRegionCount(Country country){
        return country.getRegions().length;
    }

    public List<City> getRegionCenterCities(Country country){
        List<City> cities = new ArrayList<>();

        for (Region r : country.getRegions()) {
            cities.add(r.getMainCity());
        }

        return cities;
    }
}