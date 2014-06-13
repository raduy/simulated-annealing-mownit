package com.raduy.core;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class SimulatedAnnealing {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimulatedAnnealing.class);

    public static double isNewEnergyAcceptable(double energy, double newEnergy, double temperature) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp((energy - newEnergy) / temperature);
    }


    public static AnnealingResult compute(List<City> cities, double initialTemp, double coolingRate) {
        LOGGER.info("Computing started. InitTemp: {}, CoolingRate: {}", initialTemp, coolingRate);

        TourManager tourManager = new TourManager();
        tourManager.addAllCitiesToList(cities);

        Tour currentSolution = new Tour(tourManager);
        currentSolution.generateInitialTour();

        final double initialDistance = currentSolution.getDistance();
        final List<City> initialTour = currentSolution.getTour();

        Tour best = new Tour(tourManager, currentSolution);

        while (initialTemp > 1) {
            Tour newSolution = new Tour(tourManager, currentSolution);

            int firstPosition = (int) (Math.random() * newSolution.getTourSize());
            int secondPosition = (int) (Math.random() * newSolution.getTourSize());

            newSolution.swapCitiesOrder(firstPosition, secondPosition);

            double currentEnergy = currentSolution.getDistance();
            double possibleEnergy = newSolution.getDistance();

            if (isNewEnergyAcceptable(currentEnergy, possibleEnergy, initialTemp) > Math.random()) {
                currentSolution = newSolution;
            }

            if (currentSolution.getDistance() < best.getDistance()) {
                best = currentSolution;
            }

            initialTemp *= 1 - coolingRate;
        }

        final double finalDistance = best.getDistance();
        final List<City> finalTour = best.getTour();

        LOGGER.info("Computing finish with success");
        return new AnnealingResult(initialDistance, initialTour, finalDistance, finalTour);
    }
}