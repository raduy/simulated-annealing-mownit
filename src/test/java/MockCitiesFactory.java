import com.raduy.City;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class MockCitiesFactory {

    public static City getMockCity() {
        return mock(City.class);
    }

    public static List<City> getMockCitiesList(int howMuch) {
        List<City> result = new ArrayList<City>(howMuch);

        for (int i = 0; i < howMuch; i++) {
            result.add(getMockCity());
        }

        return result;
    }
}
