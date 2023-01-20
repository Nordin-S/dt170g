package se.miun.dt170g.laboration01;

public class DailyWeather {
    private final double temperature;
    private final String temperatureUnit;
    private final double windSpeed;
    private final String windSpeedUnit;
    private final String windDirection;
    private final double cloudiness;
    private final String cloudinessUnit;
    private final double raining_min;
    private final double raining_max;
    private final String rainingUnit;

    // Constructor
    DailyWeather(double temperature, double windSpeed, String windDirection, double cloudiness, double raining_min, double raining_max) {
        this.temperature    = temperature;
        this.windSpeed      = windSpeed;
        this.windDirection  = windDirection;
        this.cloudiness     = cloudiness;
        this.raining_min    = raining_min;
        this.raining_max    = raining_max;
        this.temperatureUnit= "Celsius";
        this.windSpeedUnit  = "mps";
        this.cloudinessUnit = "%";
        this.rainingUnit    = "mm";
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public double getRaining_min() {
        return raining_min;
    }

    public double getRaining_max() {
        return raining_max;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    public String getCloudinessUnit() {
        return cloudinessUnit;
    }

    public String getRainingUnit() {
        return rainingUnit;
    }

    public DailyWeather refreshDailyWeather(double newTemperature, double newWindSpeed, String newWindDirection, double newCloudiness, double newRaining_min, double newRaining_max) {
        return new DailyWeather(newTemperature, newWindSpeed, newWindDirection, newCloudiness, newRaining_min, newRaining_max);
    }
}
