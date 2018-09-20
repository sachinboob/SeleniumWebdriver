package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) {

		// Configurations as per -
		// https://code.google.com/p/selenium/wiki/InternetExplorerDriver

		String driverPath = "D:\\Work\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", driverPath);

		String baseURL = "http://book.theautomatedtester.co.uk/chapter1";
		WebDriver driver = new ChromeDriver();

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
