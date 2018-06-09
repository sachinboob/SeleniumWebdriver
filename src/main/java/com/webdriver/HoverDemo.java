package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverDemo {

	public static void main(String[] args) {

		String baseURL = "http://www.paytm.com";
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();

		WebElement hoverMe = driver
				.findElement(By
						.xpath(".//*[@href='/shop/h/books']"));

		Actions action = new Actions(driver);
		action.moveToElement(hoverMe).moveToElement(hoverMe).build().perform();
	}
}