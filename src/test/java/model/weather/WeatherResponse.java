package model.weather;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherResponse {
    private double lat;
    private double lon;
    private String timezone;

    @JsonProperty("timezone_offset")
    private int timezoneOffset;

    private Current current;

    @JsonProperty("minutely")
    private List<Minutely> minutelies;

    @JsonProperty("hourly")
    private List<Hourly> hourlies;

    @JsonProperty("daily")
    private List<Daily> dailies;

    @JsonProperty("alerts")
    private List<Alert> alerts;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public List<Minutely> getMinutelies() {
        return minutelies;
    }

    public void setMinutelies(List<Minutely> minutelies) {
        this.minutelies = minutelies;
    }

    public List<Hourly> getHourlies() {
        return hourlies;
    }

    public void setHourlies(List<Hourly> hourlies) {
        this.hourlies = hourlies;
    }

    public List<Daily> getDailies() {
        return dailies;
    }

    public void setDailies(List<Daily> dailies) {
        this.dailies = dailies;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }
}
