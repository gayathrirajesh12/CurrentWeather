package com.qa.pages;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.*;

import com.google.gson.reflect.*;
import com.weather.Gson;
import com.weather.HashMap;
import com.weather.TypeToken;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeatherPage {
	
	LoginPage loginPage;
	
	WebDriver driver;
	
	public static Map<String, Object> jsonToMap(String str)
	{
		Map<String, Object> map =new Gson().fromJson(str, new TypeToken<HashMap<String, Object>> {}.getType());
		return map;
		}
	
	private static final String API_KEY = "3186a0eff9f74b1da1ec0ea93c0e3bf6";
	String Location = "Mumbai";
	String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + Location + "&appid=" + API_KEY; 
	
	private By weatherinyourcity = By.id("q");
	
	
	public WeatherPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver enterCityNameInSearchBar(String city) {
        weatherinyourcity.clear();
        weatherinyourcity.sendKeys(city);
        
    }
	
	public Map<String, Object> getWeatherDetails() {
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferredReader(new InputStreamReader(conn.getInputStream()));
			String line;
			
			while((line = rd.readLine()) != null)
			{
				result.append(line);
			}
			rd.close();
			System.out.println(result);
		
		
		Map<String, Object> respMap = jsonToMap(result.toString());
		Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
		Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
		
		System.out.println("Current Temperature:" + mainMap.get("temp"));
		System.out.println("Current Humidity:" + mainMap.get("humidity"));
		System.out.println("WindSpeed:" + windMap.get("speed"));
		System.out.println("Wind Angle" + windMap.get("deg"));}
		
		catch(IOException e)
		System.out.println(e.getMessage());
		
		

		

	}

}