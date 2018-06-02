package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) {

		// set firefox profile for handling mixed content
		// using the below code mixed content - some http and some https, will
		// not be blocked
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference(
				"security.mixed_content.block_active_content", false);
		firefoxProfile.setPreference(
				"security.mixed_content.block_display_content", false);

		WebDriver driver = new FirefoxDriver(firefoxProfile);
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		String url = "http://dl.dropbox.com/u/55228056/DragDropDemo.html";

		driver.manage().window().maximize();
		driver.get(url);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(source, target).build().perform();

	}

}
