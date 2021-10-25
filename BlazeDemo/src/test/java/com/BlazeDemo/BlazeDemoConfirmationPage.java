package com.BlazeDemo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Page Object Class - Confirmation Page
public class BlazeDemoConfirmationPage {
	public WebDriver MyDriver;

	public BlazeDemoConfirmationPage(WebDriver MyDriver) {
		super();
		this.MyDriver = MyDriver;
	}

	// Validating Confirmation Page
	By ConfirmPageTitle = By.tagName("title");

	public String ConfirmPageTitle() throws InterruptedException {
		Thread.sleep(6000);
		return MyDriver.findElement(ConfirmPageTitle).getAttribute("textContent");
	}

	// Printing – Amount, Card Number and Expiration
	public void PrintPurchaseDetails() {
		String MsgText = MyDriver.findElement(By.tagName("h1")).getText();
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println(MsgText);
		System.out.println("--------------------------------------------------");
		String PurchaseDetails[][] = new String[10][10];

		for (int m = 3; m <= 5; m++) {
			for (int n = 1; n <= 2; n++) {
				PurchaseDetails[m][n] = MyDriver
						.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[" + (m) + "]/td[" + n + "]"))
						.getText();
			}
		}
		System.out.println();
		System.out.println("********* FLIGHT TICKET PURCHASE DETAILS *********");
		for (int m = 3; m <= 5; m++) {
			for (int n = 1; n <= 2; n++) {
				if (n == 2) {
					System.out.print(": ");
				}
				System.out.print(PurchaseDetails[m][n]);
			}
			System.out.println();
		}
		System.out.println("**************************************************");

	}

}
