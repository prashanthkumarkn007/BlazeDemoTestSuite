package com.BlazeDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
// Page Object Class - Find Flight Page
public class BlazeDemoFindFlightPage extends base {
	public WebDriver MyDriver;

	public BlazeDemoFindFlightPage(WebDriver MyDriver) {
		super();
		this.MyDriver = MyDriver;
	}
	
	// Select Departure City and Destination City
	public void SelectCities() throws InterruptedException {
		// Create object of the Select class
		Thread.sleep(2000);
		Select DepCity = new Select(MyDriver.findElement(By.xpath("/html/body/div[3]/form/select[1]")));

		DepCity.selectByValue(properties.getProperty("DepartureCity"));
		System.out.println("Selected Departure City: " +properties.getProperty("DepartureCity"));
		Thread.sleep(2000);
		Select DestCity = new Select(MyDriver.findElement(By.xpath("/html/body/div[3]/form/select[2]")));
		DestCity.selectByValue(properties.getProperty("DestinationCity"));
		System.out.println("Selected Destination City: " +properties.getProperty("DestinationCity"));
	}

	// Get Valid "Find Flight" Button
	public WebElement GetFindFlightButton() {
		WebElement GetFindFlightButton = MyDriver.findElement(By.tagName(("input")));
		String FindFlightLabel = GetFindFlightButton.getAttribute("value");
		Assert.assertEquals(FindFlightLabel, properties.getProperty("FindFlightButtonLabel"));
		return GetFindFlightButton;

	}

}