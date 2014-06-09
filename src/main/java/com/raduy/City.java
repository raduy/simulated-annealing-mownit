package com.raduy;

import com.google.common.base.*;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class City {
    private final int x;
    private final int y;


    public City(int x, int y) {
        Preconditions.checkArgument(x > 0);
        Preconditions.checkArgument(y > 0);

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("x", x)
                .add("y", y)
                .toString();
    }

    public double computeDistanceTo(City anotherCity) {
        final int xDiff = Math.abs(anotherCity.getX() - this.getX());
        final int yDiff = Math.abs(anotherCity.getY() - this.getY());

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
