package com.raduy.presentation.web;

import com.raduy.core.City;

import java.util.List;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class ComputeRequest {
    private final List<City> cities;
    private final double coolingRate;
    private final double initialTemp;

    public ComputeRequest(List<City> cities, double initialTemp, double coolingRate) {
        this.cities = cities;
        this.initialTemp = initialTemp;
        this.coolingRate = coolingRate;
    }

    public List<City> getCities() {
        return cities;
    }

    public double getInitialTemp() {
        return initialTemp;
    }

    public double getCoolingRate() {
        return coolingRate;
    }
}
