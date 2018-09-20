package com.webdriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiWindow {

	public static void main(String[] args) {

		String baseURL = "http://www.hdfcbank.com";
		WebElement loginButton = null;
		Set<String> WindowHandles = null;
		String parentWindow = null;
		String childWindow = null;

		// Create and configure browser instance
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);

		// Load web page
		driver.get(baseURL);
		driver.manage().window().maximize();

		WindowHandles = driver.getWindowHandles();

		// Check number of windows currently opened
		System.out.println("Currenlty opened number of windows :- "
				+ (WindowHandles.size()));

		// Click on Login image button
		loginButton = driver.findElement(By.id("loginsubmit"));
		loginButton.click();

		WindowHandles = driver.getWindowHandles();
		// Check number of windows currently opened
		System.out.println("Currenlty opened number of windows :- "
				+ (WindowHandles.size()));

		// Create iterator instance for handling windows
		Iterator<String> iterator = WindowHandles.iterator();
		parentWindow = iterator.next();

		// Display unique identifier of parent window
		System.out.println("Parent Window identifier :- " + parentWindow);
		childWindow = iterator.next();

		// Display unique identifier of child window
		System.out.println("Child Window identifier :- " + childWindow);

		// Switch to newly opened window using iterator
		driver.switchTo().window(childWindow);

		// Close child window
		System.out.println("Closing child window...");
		driver.close();

		// Close parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Closing parent window...");
		driver.close();
	}
}