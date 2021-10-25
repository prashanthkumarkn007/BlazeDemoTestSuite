package com.BlazeDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
// Page Object Class - Reserve Page
public class BlazeDemoReservePage extends base {

	public WebDriver MyDriver;

	public BlazeDemoReservePage(WebDriver MyDriver) {
		super();
		this.MyDriver = MyDriver;
	}
	
	// Getting Reservation Page Title
	By ReservePageTitle = By.tagName("title");

	public String ReservePageTitle() {
		return MyDriver.findElement(ReservePageTitle).getAttribute("textContent");
	}

	// Locating Specific Airline Name specified in data.properties file
	public Boolean SelectAirline() throws InterruptedException {
		Boolean flag = false;
		List<WebElement> rows = MyDriver.findElements(By.xpath("/html/body/div[2]/table/tbody/tr"));

		for (int i = 0; i < rows.size(); i++) {
			String AirlineName = MyDriver
					.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + (i + 1) + "]/td[3]")).getText();
			if (AirlineName.equalsIgnoreCase(properties.getProperty("AirlineName"))) {
				flag = true;
				MyDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + (i + 1) + "]/td[1]/input")).click();
				System.out.println("Selected "+properties.getProperty("AirlineName")+" Airline");
				Thread.sleep(3000);
				break;
			}
		}
		return flag;
	}
}
