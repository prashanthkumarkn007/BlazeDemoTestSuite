package com.BlazeDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class base {

	public static Properties properties;
	public FileInputStream fis;
	public String vBrowser;
	public WebDriver MyDriver;

	// Browser Initialization
	@BeforeTest
	public void SetUP() throws IOException {
		properties = new Properties();
		fis = new FileInputStream("C:\\Eclipse IDE 2021_JUN\\Prashanth\\Automation\\BlazeDemo\\data.properties");
		properties.load(fis);
		fis.close();
		vBrowser = properties.getProperty("Browser");

		// Chrome Driver Selection
		if (vBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium\\CromeDriver\\chromedriver_win32\\chromedriver.exe");
			MyDriver = new ChromeDriver();
		}
		// Edge Driver Selection
		else if (vBrowser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\EdgeDriver\\edgedriver_win32\\msedgedriver.exe");
			MyDriver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
	}

	@AfterTest
	public void tearDown() {
		MyDriver.close();
	}

	@BeforeSuite
	public void suitestart() throws InterruptedException {
		System.out.println("Starting Browser........");
		Thread.sleep(5000);
	}

	@AfterSuite
	public void suiteend() throws InterruptedException {
		System.out.println("Closing Browser........");
		Thread.sleep(5000);
	}
}
