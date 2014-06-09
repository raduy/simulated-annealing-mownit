package com.raduy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class CitiesMap {
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


}
