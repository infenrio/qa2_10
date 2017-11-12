package weatherStepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import weatherStepDefs.model.WeatherResponse;

import java.io.IOException;
import java.math.BigDecimal;

public class WeatherStepDefs {
    private String cityName;
    private WeatherResponse weatherResponse;
    private WeatherRequester weatherRequester = new WeatherRequester();

    @Given("City name is (.*)")
    public void setCityName(String name) {
        cityName = name;
    }

    @When("Requesting weather information")
    public void requestWeatherInformation() throws IOException {
        weatherResponse = weatherRequester.getWeather(cityName);
    }

    @Then("Coordinates are lon:(.*) and lat:(.*)")
    public void checkCoordinates(BigDecimal lon, BigDecimal lat) {
        Assert.assertEquals("Longitude is incorrect", lon, weatherResponse.getCoord().getLon());
        Assert.assertEquals("Latitude is incorrect", lat, weatherResponse.getCoord().getLat());
    }
}
