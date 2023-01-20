package se.miun.dt170g.laboration01;

public class DailyWeather {

    private double temperature;
    private double windSpeed;
    private String windDirection;
    private double cloudiness;
    private double raining_min;
    private double raining_max;


    // Constructor
    DailyWeather(double temperature, double windSpeed, String windDirection, double cloudiness, double raining_min, double raining_max) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cloudiness = cloudiness;
        this.raining_min = raining_min;
        this.raining_max = raining_max;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getRaining_min() {
        return raining_min;
    }

    public void setRaining_min(double raining_min) {
        this.raining_min = raining_min;
    }

    public double getRaining_max() {
        return raining_max;
    }

    public void setRaining_max(double raining_max) {
        this.raining_max = raining_max;
    }
}
