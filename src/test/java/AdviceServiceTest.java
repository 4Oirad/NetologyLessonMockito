import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;

public class AdviceServiceTest {

    @Test
    void testGetAdviceInBadWeather() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        Mockito.when(weatherService.currentWeather()).thenReturn(Weather.STORMY);

        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
        Mockito.when(preferencesService.get("user1")).thenReturn(Set.of(Preference.FOOTBALL,
                Preference.WATCHING_FILMS, Preference.READING));

        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        Set<Preference> preferences = adviceService.getAdvice("user1");

        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);
        Assertions.assertEquals(expected, preferences);
    }
}
