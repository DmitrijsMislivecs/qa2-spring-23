package stepdefs;

import com.beust.ah.A;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.weather.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.HashMap;
import java.util.Map;

public class WeatherStepDefs {
    private long cityid;
    private WeatherResponse response;

    @Given("city id is {long}")
    public void set_city_id(long cityid) {
        this.cityid = cityid;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityid);
    }

    @Then("latitude is {double}")
    public void latitude_check(double latitude){
        Assertions.assertEquals(latitude, response.getLat(), "Incorrect Latitude!");
    }

    @Then("longitude is {double}")
    public void longitude_check(double longitude){
        Assertions.assertEquals(longitude, response.getLon(), "Incorrect Longitude!");
    }

    @Then("timezone is {string}")
    public void timezone_check(String timezone){
        Assertions.assertEquals(timezone, response.getTimezone(), "Incorrect Timezone!");
    }

    @Then("timezone offset is {long}")
    public void timezone_offset_check(long timezone_offset){
        Assertions.assertEquals(timezone_offset, response.getTimezoneOffset(), "Incorrect Timezone Offset!");
    }

    @Then("current weather data is:")
    public void current_weather_data_check(Map<String, String> params){
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getCurrent().getDt(), "Incorrect DT!");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getCurrent().getSunrise(), "Incorrect Sunrise!");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getCurrent().getSunset(), "Incorrect Sunset!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getCurrent().getTemp(), "Incorrect Temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getCurrent().getFeelsLike(), "Incorrect Feels_like!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getCurrent().getPressure(), "Incorrect Pressure!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getCurrent().getHumidity(), "Incorrect Humidity!");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getCurrent().getDewPoint(), "Incorrect Dew_point");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getCurrent().getUvi(), "Incorrect Uvi!");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getCurrent().getClouds(), "Incorrect Clouds!");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getCurrent().getVisibility(), "Incorrect Visibility!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getCurrent().getWindSpeed(), "Incorrect Wind_speed!");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getCurrent().getWindDeg(), "Incorrect Wind_deg!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getCurrent().getWindGust(), "Incorrect Wind_gust!");
    }

    @Then("current weather details are:")
    public void current_weather_details_check(Map<String, String> params){
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getCurrent().getWeathers().get(0).getId(), "Incorrect weather ID!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeathers().get(0).getMain(), "Incorrect weather Main!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeathers().get(0).getDescription(), "Incorrect weather Description!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeathers().get(0).getIcon(), "Incorrect weather Icon!");
    }

    @Then("minutely weather data are:")
    public void minutely_weather_data_check(Map<String, String> params){
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getMinutelies().get(0).getDt(), "Incorrect minutely dt!");
        Assertions.assertEquals(Integer.parseInt(params.get("precipitation")), response.getMinutelies().get(0).getPrecipitation(), "Incorrect minutely precipitation!");
    }

    @Then("hourly weather data are:")
    public void hourly_weather_data_check(Map<String, String> params){
        
    }
}
