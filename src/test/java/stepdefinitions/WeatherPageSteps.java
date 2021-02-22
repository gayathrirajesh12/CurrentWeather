package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.By;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.WeatherPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WeatherPageSteps {
	
	LoginPage loginPage;
	WeatherPage weatherPage;
	
	

	
	@Given("Traveller is on Login Page")
	public void traveller_is_on_login_page() {
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	
	@When("Traveller clicks on {string} in search bar")
	public void traveller_clicks_on_in_search_bar(String string) {
	   Map<String, Object> weatherinyourcity = null;
	weatherinyourcity.clear();
	   
	}

	@Then("Entered city as {string} in search bar")
	public String entered_city_as_in_search_bar(String string) {
		weatherPage.enterCityNameInSearchBar("city");
		
	}

	

	@Then("Traveller should get the weather details of {string}")
	public void traveller_should_get_the_weather_details_of(String string) {
	    weatherPage.getWeatherDetails();
	}



}

