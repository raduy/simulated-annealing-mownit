package com.raduy.core;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class City {
    private String name = "Server Custom Name";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double computeDistanceTo(City anotherCity) {
        final int xDiff = Math.abs(anotherCity.getX() - this.getX());
        final int yDiff = Math.abs(anotherCity.getY() - this.getY());

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("x", x)
                .add("y", y)
                .toString();
    }
}
