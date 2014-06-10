package com.raduy.presentation;

import com.raduy.core.AnnealingResult;
import com.raduy.core.City;

import java.util.List;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class ConsolePresentStrategy implements IPresentStrategy {

    @Override
    public void present(AnnealingResult result) {

        System.out.println("Simulated Annealing for Traveling Salesman problem");

        System.out.println("Initial solution:");
        System.out.println("\tDistance: " + result.getInitialDistance());
        System.out.print("\tTour:\n");

        printTour(result.getInitialTour());

        System.out.println("\nFinal solution:");
        System.out.println("\tDistance: " + result.getFinalDistance());
        System.out.print("\tTour:\n");


        printTour(result.getFinalTour());


    }

    private void printTour(List<City> tour) {
        for (int i = 0, size = tour.size(); i < size; i++) {
            System.out.print("\t\t" + tour.get(i));
            if (i != size - 1) {
                System.out.println(" -> ");
            }
        }
    }
}
