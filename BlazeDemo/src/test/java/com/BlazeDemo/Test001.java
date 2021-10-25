package com.BlazeDemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test001 extends base {
	@Test
	public void TS001() throws IOException, InterruptedException {
// Test Implementation Code HERE....
		MyDriver.manage().window().maximize();
		MyDriver.get(properties.getProperty("URL"));
		MyDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

// Call Page Object Class - Home Page
		// Validating Home Page
		BlazeDemoHomePage homepage = new BlazeDemoHomePage(MyDriver);
		String HomePageText = homepage.GetHomePageText().getText();
		Assert.assertEquals(HomePageText, properties.getProperty("ValidateHomePage"));
		MyPrint("Navigated to a Blaze Demo Home Page.....");

// Call Page Object Class - Find Flight Page
		BlazeDemoFindFlightPage FlightPage = new BlazeDemoFindFlightPage(MyDriver);
		// Select Departure City and Destination City
		FlightPage.SelectCities();
		Thread.sleep(2000);
		WebElement GetFindFlightButton = FlightPage.GetFindFlightButton();
		GetFindFlightButton.click();
		MyPrint("Searching Available Flights.....");
		Thread.sleep(2000);

// Call Page Object Class - Reserve Page	

		// Validating Reservation Page
		BlazeDemoReservePage ReservePage = new BlazeDemoReservePage(MyDriver);
		String ReservePageTitle = ReservePage.ReservePageTitle();

		Assert.assertEquals(ReservePageTitle, properties.getProperty("ValidateReservePage"));
		MyPrint("Navigated to a Reservation Page.....");

		// Click Choose this Flight for United Airlines
		Boolean flag = ReservePage.SelectAirline();
		if (flag == false) {
			System.out.println(properties.getProperty("AirlineName") + " Not Available for "
					+ properties.getProperty("DepartureCity") + " to " + properties.getProperty("DestinationCity"));
		}

// Call Page Object Class - Purchase Page
		// Validating Purchase Page
		BlazeDemoPurchasePage PurchasePage = new BlazeDemoPurchasePage(MyDriver);
		String PurchasePageTitle = PurchasePage.PurchasePageTitle();

		Assert.assertEquals(PurchasePageTitle, properties.getProperty("ValidatePurchasePage"));
		MyPrint("Navigated to a Purchase Page.....");

		// Input data for First Name, Credit Card Number and Name on Card fields.
		PurchasePage.FormFeed();

// Call Page Object Class - Confirmation Page
		// Validating Confirmation Page
		BlazeDemoConfirmationPage ConfirmPage = new BlazeDemoConfirmationPage(MyDriver);
		String ConfirmPageTitle = ConfirmPage.ConfirmPageTitle();

		Assert.assertEquals(ConfirmPageTitle, properties.getProperty("ValidateConfirmationPage"));
		MyPrint("Navigated to a Confirmation Page.....");

		// Printing – Amount, Card Number and Expiration
		ConfirmPage.PrintPurchaseDetails();
	}

	public void MyPrint(String PrintText) {
		System.out.println(PrintText);
	}
}
