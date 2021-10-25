package com.BlazeDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// Page Object Class - Home Page
		
public class BlazeDemoHomePage extends base {
	public WebDriver MyDriver;

	public BlazeDemoHomePage(WebDriver MyDriver) {
		super();
		this.MyDriver = MyDriver;
	}
	
	// Validating Home Page
	By GetHomePageText = By.xpath("/html/body/div[2]/div/h1");
	public WebElement GetHomePageText() {
		return MyDriver.findElement(GetHomePageText);
	}
}