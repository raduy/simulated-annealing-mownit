import com.raduy.City;
import com.raduy.Tour;
import com.raduy.TourManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Lukasz Raduj <raduj.lukasz@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class TourTest {
    private Tour instance;

    @Mock
    private TourManager tourMangerMock;

    private final int NUMBER_OF_CITIES = 5;
    private List<City> mockCities = MockCitiesFactory.getMockCitiesList(NUMBER_OF_CITIES);

    @Before
    public void setUp() throws Exception {
        when(tourMangerMock.getNumberOfCities()).thenReturn(NUMBER_OF_CITIES);
        when(tourMangerMock.getCities()).thenReturn(mockCities);
        instance = new Tour(tourMangerMock);
        instance.generateInitialTour();
    }

    @Test
    public void shouldCreateInitialTourWithAllCities() throws Exception {

        assertThat(instance.getTour().size()).isEqualTo(NUMBER_OF_CITIES);
    }

    @Test
    public void shouldShuffleCitiesWhenCreateInitialTour() throws Exception {
//        given
//        empty

//        then
        List<City> generatedCities = instance.getTour();

//        then
        assertThat(generatedCities).contains(mockCities.toArray());
        assertThat(mockCities.equals(generatedCities)).isFalse();
    }

    @Test
    public void shouldSwapCitiesInList() throws Exception {
//        given
        final int FIRST_POSITION_TO_SWAP = 0;
        final int SECOND_POSITION_TO_SWAP = 1;

        City fromFistPosition = instance.getCityByIndex(FIRST_POSITION_TO_SWAP);
        City fromSecondPosition = instance.getCityByIndex(SECOND_POSITION_TO_SWAP);

//        when
        instance.swapCitiesOrder(FIRST_POSITION_TO_SWAP, SECOND_POSITION_TO_SWAP);

//        then
        assertThat(instance.getCityByIndex(FIRST_POSITION_TO_SWAP)).isEqualTo(fromSecondPosition);
        assertThat(instance.getCityByIndex(SECOND_POSITION_TO_SWAP)).isEqualTo(fromFistPosition);
    }

    @Test
    public void shouldSetDistanceToZeroWhenSetNewCity() throws Exception {
//        given
        int CITY_POSITION = NUMBER_OF_CITIES - 1;
        City mockCity = MockCitiesFactory.getMockCity();


//        when
        instance.setCityAtPosition(CITY_POSITION, mockCity);

//        then
        assertThat(instance.getCityByIndex(CITY_POSITION)).isEqualTo(mockCity);
        assertThat(instance.getDistance()).isZero();
    }
}
