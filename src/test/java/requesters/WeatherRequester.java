package requesters;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import model.weather.WeatherResponse;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String URL = "http://qaguru.lv:8089/tickets/getWeather.php?id=";

    public WeatherResponse requestWeather(long id) throws JsonProcessingException {
        String url = URL + id;

        RestTemplate restTemplate = new RestTemplate();
        String jsonToParse = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonToParse, WeatherResponse.class);
    }

}
