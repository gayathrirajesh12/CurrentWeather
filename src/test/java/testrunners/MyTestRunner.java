package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"E:\\eclipse-java-2020-12-R-win32-x86_64\\Eclipse-workspace\\CucumberPOMseries\\src\\test\\resources\\WeatherPage.feature"},
        glue = {"stepdefinitions"},
        plugin = {"pretty", 
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class MyTestRunner {

	
	        
	
}
