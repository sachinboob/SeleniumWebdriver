package com.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExtractAllLinks {

	public static void main(String[] args) {

		String baseURL = "http://book.theautomatedtester.co.uk/";

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		// Fetch all links from page
		List<WebElement> linkList = driver.findElements(By.tagName("a"));

		System.out.println("Number of links :- " + linkList.size());

		// Display links and href values
		for (WebElement link : linkList) {
			System.out.println(link.getText() + " :- "
					+ link.getAttribute("href"));
		}
	}
}