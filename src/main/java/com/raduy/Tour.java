package com.raduy;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class Tour {
    private final List<City> tourOrderedCities;
    private final TourManager tourManager;
    private int distance = 0;

    public Tour(TourManager tourManager) {
        this.tourManager = tourManager;
        this.tourOrderedCities = new ArrayList<City>(tourManager.getNumberOfCities());
    }

    public Tour(TourManager tourManager, Tour currentSolution) {
        this.tourManager = tourManager;
        this.tourOrderedCities = Lists.newArrayList(currentSolution.getTour());
        this.distance = currentSolution.getDistance();
    }

    public List<City> getTour() {
        return Collections.unmodifiableList(tourOrderedCities);
    }

    public void generateInitialTour() {
        tourOrderedCities.addAll(tourManager.getCities());

        Collections.shuffle(tourOrderedCities);
    }

    public City getCityByIndex(int index) {
        return tourOrderedCities.get(index);
    }

    public void setCityAtPosition(int position, City city) {
        distance = 0;
        tourOrderedCities.set(position, city);
    }

    public int getDistance() {
        if (distance != 0) {
            return distance;
        }

        int partialDistance = 0;
        for (int i = 0; i < getTourSize(); i++) {
            City fromCity = tourOrderedCities.get(i);

            City toCity = (i + 1 >= getTourSize() ? tourOrderedCities.get(0) : tourOrderedCities.get(i + 1));

            partialDistance += fromCity.computeDistanceTo(toCity);
        }

        distance = partialDistance;

        return distance;
    }

    public int getTourSize() {
        return tourOrderedCities.size();
    }

    public void swapCitiesOrder(int firstPosition, int secondPosition) {
        City fromFirstPosition = getCityByIndex(firstPosition);
        City fromSecondPosition = getCityByIndex(secondPosition);
        setCityAtPosition(firstPosition, fromSecondPosition);
        setCityAtPosition(secondPosition, fromFirstPosition);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("distance", distance)
                .add("tourOrderedCities", tourOrderedCities)
                .toString();
    }
}
