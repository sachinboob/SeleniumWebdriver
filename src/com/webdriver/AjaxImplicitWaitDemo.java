package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class AjaxImplicitWaitDemo {

	public static void main(String[] args) {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference(
				"security.mixed_content.block_active_content", false);
		firefoxProfile.setPreference(
				"security.mixed_content.block_display_content", false);

		String url = "http://dl.dropbox.com/u/55228056/AjaxDemo.html";

		WebDriver driver = new FirefoxDriver(firefoxProfile);

		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		try {
			// Get link for Page 4 and click on it
			WebElement page4button = driver.findElement(By.linkText("Page 4"));
			page4button.click();
			// Get an element with id page4 and verify it's text
			WebElement message = driver.findElement(By.id("page4"));
			System.out.println(message);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} finally {

		}

	}
}
