package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDemo {

	public static void main(String[] args) {

		// Configurations as per -
		// https://code.google.com/p/selenium/wiki/InternetExplorerDriver

		String driverPath = "D:\\Work\\Selenium Drivers\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe";

		System.setProperty("webdriver.ie.driver", driverPath);

		String baseURL = "http://book.theautomatedtester.co.uk/chapter1";
		WebDriver driver = new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();

		// Force the program to wait to view the button
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// Get button
		WebElement button = driver.findElement(By.id("secondajaxbutton"));

		// Get button label
		String buttonLabel = button.getAttribute("value");
		System.out.println("Label of button is :- " + buttonLabel);

		// Click on button
		button.click();
	}
}
