package com.raduy.core;

import com.raduy.presentation.IPresentationStrategy;

import java.util.Collections;
import java.util.List;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class AnnealingResult {
    private final double initialDistance;
    private final List<City> initialSolution;
    private final double finalDistance;
    private final List<City> finalSolution;
    private final List<Double> xForGraph;
    private final List<Double> yForGraph;


    public AnnealingResult(double initialDistance, List<City> initialSolution, double finalDistance, List<City> finalSolution, List<Double> xForGraph, List<Double> yForGraph) {
        this.initialDistance = initialDistance;
        this.initialSolution = initialSolution;
        this.finalDistance = finalDistance;
        this.finalSolution = finalSolution;
        this.xForGraph = xForGraph;
        this.yForGraph = yForGraph;
    }

    public void present(IPresentationStrategy presentStrategy) {
        presentStrategy.present(this);
    }

    public double getInitialDistance() {
        return initialDistance;
    }

    public List<City> getInitialTour() {
        return Collections.unmodifiableList(initialSolution);
    }

    public double getFinalDistance() {
        return finalDistance;
    }

    public List<City> getFinalTour() {
        return Collections.unmodifiableList(finalSolution);
    }

    public List<Double> getxForGraph() {
        return xForGraph;
    }

    public List<Double> getyForGraph() {
        return yForGraph;
    }
}
