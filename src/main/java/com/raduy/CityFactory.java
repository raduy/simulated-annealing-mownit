package com.raduy;

import com.raduy.core.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class CityFactory {
    private static final Random random = new Random();

    public static City newCity(int x, int y) {
        return new City(x, y);
    }

    public static List<City> newRandomCitiesList(int quantity) {
        List<City> result = new ArrayList<>(quantity);

        for (int i = 0; i < quantity; i++) {
            result.add(newCity(random.nextInt(100) + 1, random.nextInt(100) + 1));
        }

        return result;
    }
}
