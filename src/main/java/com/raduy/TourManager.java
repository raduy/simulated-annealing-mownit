package com.raduy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Holds cities to visit by traveling salesman.
 *
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class TourManager {
    private List<City> cities = new ArrayList<City>();

    public int getNumberOfCities() {
        return cities.size();
    }

    /**
     * Holds ordered list of cities to visit.
     * @param cityToVisit New city to be add to list.
     */
    public void addCityToList(City cityToVisit) {
        cities.add(cityToVisit);
    }

    public void addAllCitiesToList(List<City> citiesToVisit) {
        for (City city : citiesToVisit) {
            cities.add(city);
        }
    }

    public City getCityByIndex(int index) {
        return cities.get(index);
    }

    public List<City> getCities() {
        return Collections.unmodifiableList(cities);
    }
}
