package com.raduy;

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

    public AnnealingResult(double initialDistance, List<City> initialSolution, double finalDistance, List<City> finalSolution) {
        this.initialDistance = initialDistance;
        this.initialSolution = initialSolution;
        this.finalDistance = finalDistance;
        this.finalSolution = finalSolution;
    }

    public void present(IPresentStrategy presentStrategy) {
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
}
