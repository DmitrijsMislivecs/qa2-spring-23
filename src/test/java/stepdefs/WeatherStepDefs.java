package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.weather.WeatherResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;
import java.util.Map;

public class WeatherStepDefs {
    private long cityid;
    private WeatherResponse response;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Given("city id is {long}")
    public void set_city_id(long cityid) {
        LOGGER.info("Setting city id");
        this.cityid = cityid;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        LOGGER.info("Requesting weather forecast");
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityid);
    }

    @Then("latitude is {double}")
    public void latitude_check(double latitude){
        LOGGER.info("Latitude checking");
        Assertions.assertEquals(latitude, response.getLat(), "Incorrect Latitude!");
    }

    @Then("longitude is {double}")
    public void longitude_check(double longitude){
        LOGGER.info("Longitude checking");
        Assertions.assertEquals(longitude, response.getLon(), "Incorrect Longitude!");
    }

    @Then("timezone is {string}")
    public void timezone_check(String timezone){
        LOGGER.info("Timezone checking");
        Assertions.assertEquals(timezone, response.getTimezone(), "Incorrect Timezone!");
    }

    @Then("timezone offset is {long}")
    public void timezone_offset_check(long timezone_offset){
        LOGGER.info("Timezone offset checking");
        Assertions.assertEquals(timezone_offset, response.getTimezoneOffset(), "Incorrect Timezone Offset!");
    }

    @Then("current weather data is:")
    public void current_weather_data_check(Map<String, String> params){
        LOGGER.info("Current weather DT checking");
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getCurrent().getDt(), "Incorrect current weather DT!");
        LOGGER.info("Current weather Sunrise checking");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getCurrent().getSunrise(), "Incorrect current weather Sunrise!");
        LOGGER.info("Current weather Sunset checking");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getCurrent().getSunset(), "Incorrect current weather Sunset!");
        LOGGER.info("Current weather Temp checking");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getCurrent().getTemp(), "Incorrect current weather Temp!");
        LOGGER.info("Current weather Feel_like checking");
        Assertions.assertEquals(Double.parseDouble(params.get("feel_like")), response.getCurrent().getFeelsLike(), "Incorrect current weather Feel_like!");
        LOGGER.info("Current weather Pressure checking");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getCurrent().getPressure(), "Incorrect current weather Pressure!");
        LOGGER.info("Current weather Humidity checking");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getCurrent().getHumidity(), "Incorrect current weather Humidity!");
        LOGGER.info("Current weather Dew_point checking");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getCurrent().getDewPoint(), "Incorrect current weather Dew_point");
        LOGGER.info("Current weather Uvi checking");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getCurrent().getUvi(), "Incorrect current weather Uvi!");
        LOGGER.info("Current weather Clouds checking");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getCurrent().getClouds(), "Incorrect current weather Clouds!");
        LOGGER.info("Current weather Visibility checking");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getCurrent().getVisibility(), "Incorrect current weather Visibility!");
        LOGGER.info("Current weather Wind Speed checking");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getCurrent().getWindSpeed(), "Incorrect current weather Wind_speed!");
        LOGGER.info("Current weather Wind Deg checking");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getCurrent().getWindDeg(), "Incorrect current weather Wind_deg!");
        LOGGER.info("Current weather Wind Gust checking");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getCurrent().getWindGust(), "Incorrect current weather Wind_gust!");
    }

    @Then("current weather details are:")
    public void current_weather_details_check(Map<String, String> params){
        LOGGER.info("Current weather details checking");
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getCurrent().getWeathers().get(0).getId(), "Incorrect current weather details ID!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeathers().get(0).getMain(), "Incorrect current weather details Main!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeathers().get(0).getDescription(), "Incorrect current weather details Description!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeathers().get(0).getIcon(), "Incorrect current weather details Icon!");
    }

    @Then("minutely weather data are:")
    public void minutely_weather_data_check(Map<String, String> params){
        LOGGER.info("Minutely weather data checking");
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getMinutelies().get(0).getDt(), "Incorrect minutely weather dt!");
        Assertions.assertEquals(Integer.parseInt(params.get("precipitation")), response.getMinutelies().get(0).getPrecipitation(), "Incorrect minutely weather precipitation!");
    }

    @Then("hourly weather data are:")
    public void hourly_weather_data_check(Map<String, String> params){
        LOGGER.info("Hourly weather data checking");
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getHourlies().get(0).getDt(), "Incorrect hourly weather dt!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getHourlies().get(0).getTemp(), "Incorrect hourly weather temp!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getHourlies().get(0).getFeelsLike(), "Incorrect hourly weather Feels Like!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getHourlies().get(0).getPressure(), "Incorrect hourly weather Pressure!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getHourlies().get(0).getHumidity(), "Incorrect hourly weather Humidity!");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getHourlies().get(0).getDewPoint(), "Incorrect hourly weather Dew Point!");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getHourlies().get(0).getUvi(), "Incorrect hourly weather Uvi!");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getHourlies().get(0).getClouds(), "Incorrect hourly weather Clouds!");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getHourlies().get(0).getVisibility(), "Incorrect hourly weather Visibility!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getHourlies().get(0).getWindSpeed(), "Incorrect hourly weather Wind Speed!");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getHourlies().get(0).getWindDeg(), "Incorrect hourly weather Wind Deg!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getHourlies().get(0).getWindGust(), "Incorrect hourly weather Wind Gust!");
    }

    @Then("hourly weather details are:")
    public void hourly_weather_details_check(Map<String, String> params){
        LOGGER.info("Hourly weather details checking");
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getHourlies().get(0).getWeathers().get(0).getId(), "Incorrect hourly weather details ID!");
        Assertions.assertEquals(params.get("main"), response.getHourlies().get(0).getWeathers().get(0).getMain(), "Incorrect hourly weather details Main!");
        Assertions.assertEquals(params.get("description"), response.getHourlies().get(0).getWeathers().get(0).getDescription(), "Incorrect hourly weather details Description!");
        Assertions.assertEquals(params.get("icon"), response.getHourlies().get(0).getWeathers().get(0).getIcon(), "Incorrect hourly weather details Icon!");
    }

    @Then("hourly pop is {double}")
    public void hourly_pop_check(double pop){
        LOGGER.info("Hourly pop checking");
        Assertions.assertEquals(pop, response.getHourlies().get(0).getPop(), "Incorrect hourly pop!");
    }

    @Then("daily weather data are:")
    public void daily_weather_data_check(Map<String, String> params){
        LOGGER.info("Daily weather data checking");
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getDailies().get(0).getDt(), "Incorrect daily weather dt!");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getDailies().get(0).getSunrise() ,"Incorrect daily weather sunrise!");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getDailies().get(0).getSunset() ,"Incorrect daily weather sunset!");
        Assertions.assertEquals(Long.parseLong(params.get("moonrise")), response.getDailies().get(0).getMoonrise() ,"Incorrect daily weather moonrise!");
        Assertions.assertEquals(Long.parseLong(params.get("moonset")), response.getDailies().get(0).getMoonset() ,"Incorrect daily weather moonset!");
        Assertions.assertEquals(Double.parseDouble(params.get("moon_phase")), response.getDailies().get(0).getMoonPhase() ,"Incorrect daily weather moon phase!");
    }

    @Then("daily temp weather details is:")
    public void daily_temp_weather_details_check(Map<String, Double> params){
        LOGGER.info("Daily temp weather details checking");
        Assertions.assertEquals(params.get("day"), response.getDailies().get(0).getTemp().getDay(), "Incorrect daily temp weather details day!");
        Assertions.assertEquals(params.get("min"), response.getDailies().get(0).getTemp().getMin(), "Incorrect daily temp weather details min!");
        Assertions.assertEquals(params.get("max"), response.getDailies().get(0).getTemp().getMax(), "Incorrect daily temp weather details max!");
        Assertions.assertEquals(params.get("night"), response.getDailies().get(0).getTemp().getNight(), "Incorrect daily temp weather details night!");
        Assertions.assertEquals(params.get("eve"), response.getDailies().get(0).getTemp().getEve(), "Incorrect daily temp weather details eve!");
        Assertions.assertEquals(params.get("morn"), response.getDailies().get(0).getTemp().getMorn(), "Incorrect daily temp weather details morn!");
    }

    @Then("daily feels_like details is:")
    public void daily_feels_like_details_check(Map<String, Double> params){
        LOGGER.info("Daily feels_like details checking");
        Assertions.assertEquals(params.get("day"), response.getDailies().get(0).getFeelsLike().getDay(), "Incorrect daily feels like details day!");
        Assertions.assertEquals(params.get("night"), response.getDailies().get(0).getFeelsLike().getNight(), "Incorrect daily feels like details night!");
        Assertions.assertEquals(params.get("eve"), response.getDailies().get(0).getFeelsLike().getEve(), "Incorrect daily feels like details eve!");
        Assertions.assertEquals(params.get("morn"), response.getDailies().get(0).getFeelsLike().getMorn(), "Incorrect daily feels like details morn!");
    }

    @Then("daily pressure is {int}")
    public void daily_pressure_check(int daily_pressure){
        LOGGER.info("Daily pressure checking");
        Assertions.assertEquals(daily_pressure, response.getDailies().get(0).getPressure(), "Incorrect daily pressure!");
    }

    @Then("daily humidity is {int}")
    public void daily_humidity_check(int daily_humidity){
        LOGGER.info("Daily humidity checking");
        Assertions.assertEquals(daily_humidity, response.getDailies().get(0).getHumidity(), "Incorrect daily humidity!");
    }

    @Then("daily dew_point is {double}")
    public void daily_dew_point_check(double daily_dew_point){
        LOGGER.info("Daily dew point checking");
        Assertions.assertEquals(daily_dew_point, response.getDailies().get(0).getDewPoint(), "Incorrect daily dew point!");
    }

    @Then("daily wind_speed is {double}")
    public void daily_wind_speed_check(double daily_wind_speed){
        LOGGER.info("Daily wind speed checking");
        Assertions.assertEquals(daily_wind_speed, response.getDailies().get(0).getWindSpeed(), "Incorrect daily wind speed!");
    }

    @Then("daily wind_deg is {int}")
    public void daily_wind_deg_check(int daily_wind_deg){
        LOGGER.info("Daily wind deg checking");
        Assertions.assertEquals(daily_wind_deg, response.getDailies().get(0).getWindDeg(), "Incorrect daily wind deg!");
    }

    @Then("daily wind_gust is {double}")
    public void daily_wind_gust_check(double daily_wind_gust){
        LOGGER.info("Daily wind gust checking");
        Assertions.assertEquals(daily_wind_gust, response.getDailies().get(0).getWindGust(), "Incorrect daily wind gust!");
    }

    @Then("daily weather details are:")
    public void daily_weather_details_check(Map<String, String> param){
        LOGGER.info("Daily weather details checking");
        Assertions.assertEquals(Integer.parseInt(param.get("id")), response.getDailies().get(0).getWeathers().get(0).getId(), "Incorrect daily weather details id!");
        Assertions.assertEquals(param.get("main"), response.getDailies().get(0).getWeathers().get(0).getMain(), "Incorrect daily weather details main!");
        Assertions.assertEquals(param.get("description"), response.getDailies().get(0).getWeathers().get(0).getDescription(), "Incorrect daily weather details description!");
        Assertions.assertEquals(param.get("icon"), response.getDailies().get(0).getWeathers().get(0).getIcon(), "Incorrect daily weather details icon!");
    }

    @Then("daily clouds is {int}")
    public void daily_clouds_check(int daily_clouds){
        LOGGER.info("Daily clouds checking");
        Assertions.assertEquals(daily_clouds, response.getDailies().get(0).getClouds(), "Incorrect daily clouds!");
    }

    @Then("daily pop is {double}")
    public void daily_pop_check(double daily_pop){
        LOGGER.info("Daily pop checking");
        Assertions.assertEquals(daily_pop, response.getDailies().get(0).getPop(), "Incorrect daily pop!");
    }

    @Then("daily rain is {double}")
    public void daily_rain_check(double daily_rain){
        LOGGER.info("Daily rain checking");
        Assertions.assertEquals(daily_rain, response.getDailies().get(0).getRain(), "Incorrect daily rain!");
    }

    @Then("daily uvi is {double}")
    public void daily_uvi_check(double daily_uvi){
        LOGGER.info("Daily uvi checking");
        Assertions.assertEquals(daily_uvi, response.getDailies().get(0).getUvi(), "Incorrect daily uvi!");
    }

    @Then("alerts weather data are:")
    public void alerts_weather_data_check(Map<String, String> params){
        LOGGER.info("Alerts weather data checking");
        Assertions.assertEquals(params.get("sender_name"), response.getAlerts().get(0).getSenderName(), "Incorrect alerts weather sender name!");
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(0).getEvent(), "Incorrect alerts weather event!");
        Assertions.assertEquals(Double.parseDouble(params.get("start")), response.getAlerts().get(0).getStart(), "Incorrect alerts weather start!");
        Assertions.assertEquals(Double.parseDouble(params.get("end")), response.getAlerts().get(0).getEnd(), "Incorrect alerts weather end!");
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(0).getDescription(), "Incorrect alerts weather description");
    }

    @Then("alerts tags details list is blank")
    public void alerts_tags_details_check(){
        LOGGER.info("Alerts tags details list checking");
        Assertions.assertNotNull(response.getAlerts().get(0).getTags(), "Alerts tags is not blank!");
        Assertions.assertEquals(0, response.getAlerts().get(0).getTags().size(), "Alerts tags is not blank!");
    }
}