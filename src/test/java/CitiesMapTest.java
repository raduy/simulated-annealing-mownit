import com.raduy.CitiesMap;
import com.raduy.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class CitiesMapTest {
    private CitiesMap instance;

    @Mock
    private City cityMock;

    @Before
    public void setUp() throws Exception {
        instance = new CitiesMap();
    }

    @Test
    public void shouldCreateEmptyListOfCities() throws Exception {
        //no cities added

        assertThat(instance.getNumberOfCities()).isEqualTo(0);
    }

    @Test
    public void shouldBeAbleToAddCityToTour() throws Exception {
        when(cityMock.getX()).thenReturn(1);
        when(cityMock.getY()).thenReturn(1);

        instance.addCityToList(cityMock);

        assertThat(instance.getNumberOfCities()).isEqualTo(1);
    }
}
