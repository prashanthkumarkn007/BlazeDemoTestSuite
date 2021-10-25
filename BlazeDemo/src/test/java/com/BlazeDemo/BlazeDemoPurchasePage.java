package com.BlazeDemo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

// Page Object Class - Purchase Page
		
public class BlazeDemoPurchasePage extends base {

	public WebDriver MyDriver;

	public BlazeDemoPurchasePage(WebDriver MyDriver) {
		super();
		this.MyDriver = MyDriver;
	}

	// Validating Purchase Page
	By PurchasePageTitle = By.tagName("title");
	public String PurchasePageTitle() {
		return MyDriver.findElement(PurchasePageTitle).getAttribute("textContent");
	}
	
	// Inputting data for  First Name, Credit Card Number and Name on Card fields.
	public void FormFeed() throws InterruptedException
	{
		Thread.sleep(2000);
		MyDriver.findElement(By.id("inputName")).sendKeys(properties.getProperty("FirstName"));
		Thread.sleep(2000);
		MyDriver.findElement(By.id("creditCardNumber")).sendKeys(properties.getProperty("CreditCardNumber"));
		Thread.sleep(2000);
		MyDriver.findElement(By.id("nameOnCard")).sendKeys(properties.getProperty("NameOnCard"));
		Thread.sleep(2000);
		MyDriver.findElement(By.id("rememberMe")).click();
		WebElement PurchaseFlightButton = GetPurchaseFlightButton();
		Thread.sleep(2000);
		PurchaseFlightButton.click();
		System.out.println("Flight Ticket Booking Success");
	}
	
	// Get Valid "Purchase Flight" Button
	public WebElement GetPurchaseFlightButton() {
		WebElement GetPurchaseFlightButton = MyDriver.findElement(By.xpath(("/html/body/div[2]/form/div[11]/div/input")));
		String PurchaseFlightLabel = GetPurchaseFlightButton.getAttribute("value");
		Assert.assertEquals(PurchaseFlightLabel, properties.getProperty("PurchaseFlightButtonLabel"));
		return GetPurchaseFlightButton;

	}
	
}
