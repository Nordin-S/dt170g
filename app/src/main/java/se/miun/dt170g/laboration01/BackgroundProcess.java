package se.miun.dt170g.laboration01;

public class BackgroundProcess {
    void run(WeatherParser wp) {
        wp.parseWeather(new DailyWeather());
    }
}
