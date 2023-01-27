package se.miun.dt170g.laboration01;

public class BackgroundProcess {
    void run(WeatherParser wp) {
        wp.parseWeather(new DailyWeather(1,5.2, 2.1, "SW", 40, 0.0, 1.2));
    }
}
