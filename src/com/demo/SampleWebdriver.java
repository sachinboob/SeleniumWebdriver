package com.demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleWebdriver {

	public static void main(String[] args) {
		WebDriver driver;
		String baseUrl;
		baseUrl = "http://www.salesforce.com/";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("button-login"));
		username.click();
		
		
		// Wait up to 10 seconds for a condition
		WebDriverWait waiting = new WebDriverWait(driver, 100);
		waiting.until(ExpectedConditions.presenceOfElementLocated(By
				.id("username")));

		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(
				"sachin.ramdhan.boob@accenture.com");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("sachinboob1!");
//		driver.findElement(By.id("Login")).click();
		
		driver.close();

	}
}