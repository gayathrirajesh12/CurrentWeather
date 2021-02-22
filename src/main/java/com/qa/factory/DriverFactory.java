package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String Browser)
	{
		System.out.println("Launching Browser is"+ Browser);
		
		if(Browser.equals("Chrome")) 
		{
		WebDriverManager.chromedriver().setup();
		tldriver.set(new ChromeDriver());
		}
		else if(Browser.equals("Firefox")) 
		
		{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
			}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
public static synchronized WebDriver getDriver() 
	{
		return tldriver.get();
	}
}
