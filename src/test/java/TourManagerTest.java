import com.raduy.core.TourManager;
import com.raduy.core.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class TourManagerTest {
    private TourManager instance;

    private City cityMockOne = MockCitiesFactory.getMockCity();

    private City cityMockTwo = MockCitiesFactory.getMockCity();

    @Before
    public void setUp() throws Exception {
        instance = new TourManager();
    }

    @Test
    public void shouldCreateEmptyListOfCities() throws Exception {
//        no cities added

        assertThat(instance.getNumberOfCities()).isEqualTo(0);
    }

    @Test
    public void shouldBeAbleToAddCityToTour() throws Exception {
        when(cityMockOne.getX()).thenReturn(1);
        when(cityMockOne.getY()).thenReturn(1);

        instance.addCityToList(cityMockOne);

        assertThat(instance.getNumberOfCities()).isEqualTo(1);
    }

    @Test
    public void shouldBeAbleToGetCityByIndexPosition() throws Exception {
//        given
        instance.addCityToList(cityMockOne);
        instance.addCityToList(cityMockTwo);

//        when
        City cityByIndex = instance.getCityByIndex(1);

//        then
        assertThat(cityByIndex).isEqualTo(cityMockTwo);
    }
}
