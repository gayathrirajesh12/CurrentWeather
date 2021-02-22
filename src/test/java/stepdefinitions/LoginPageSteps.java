package stepdefinitions;

import org.junit.Assert;

import com.qa.pages.*;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


       @Given("Traveller is on Login Page")
	public void traveller_is_on_login_page() {
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("Traveller enters username as {string}")
	public void traveller_enters_username_as(String username) {
		
			loginPage.enterUserName(username);
	}

	@When("Traveller enters password as {string}")
	public void traveller_enters_password_as(String password) {
		
			loginPage.enterPassword(password);
	}

	@When("Traveller clicks on Sign in button")
	public void traveller_clicks_on_sign_in_button() {
		loginPage.clickOnLogin();
	}
