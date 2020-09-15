package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.driver.utils.Browser;

public class NewClass {

	public static void main(String[] args) throws Exception {

		WebDriver driver;
		WebElement element;
		
		String baseUrl;
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver = Browser.getInstance(Browser.BrowserType.Firefox, baseUrl);

		Thread.sleep(30L);
		driver.findElement(By.id("openwindow")).click();
		
	}

}
