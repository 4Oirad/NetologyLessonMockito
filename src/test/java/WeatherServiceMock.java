public class WeatherServiceMock implements WeatherService {

    public Weather value;
    @Override
    public Weather currentWeather() {
        return value;
    }

    public void setValue(Weather value) {
        this.value = value;
    }
}
