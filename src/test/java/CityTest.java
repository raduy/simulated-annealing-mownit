import com.raduy.core.City;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
public class CityTest {
    final int X_COORDINATE = 100;
    final int Y_COORDINATE = 101;

    private City instance;


    @Before
    public void setUp() throws Exception {
        instance = new City(X_COORDINATE, Y_COORDINATE);
    }

    @Test
    public void shouldCreateCityWithProperCoordinates() throws Exception {
        assertThat(instance.getX()).isEqualTo(X_COORDINATE);

        assertThat(instance.getY()).isEqualTo(Y_COORDINATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAndCoordsIsNegative() throws Exception {
        instance = new City(1, -2);
    }

    @Test
    public void shouldBeAbleToComputeDistanceToAnotherCity() throws Exception {
        //given
        instance = new City(1, 1);
        final City anotherCity = new City(5, 4);

        //when
        double distance = instance.computeDistanceTo(anotherCity);

        //then
        assertThat(Double.compare(distance, 5)).isEqualTo(0);
    }
}
