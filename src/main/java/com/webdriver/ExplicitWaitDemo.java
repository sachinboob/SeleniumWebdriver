package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference(
				"security.mixed_content.block_active_content", false);
		firefoxProfile.setPreference(
				"security.mixed_content.block_display_content", false);

		String url = "http://www.google.com";

		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		WebElement query = driver.findElement(By.name("q"));
		query.sendKeys("selenium");
		WebElement queryButton = driver.findElement(By.name("btnG"));
		queryButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("selenium"));
	}
}