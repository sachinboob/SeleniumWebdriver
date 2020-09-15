package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.driver.utils.Browser;

public class ShadowExample {

	public ShadowExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		String baseUrl;
		baseUrl = "chrome://downloads/";
		driver = Browser.getInstance(Browser.BrowserType.Chrome, baseUrl);
		Thread.sleep(5000);

		WebElement downloadsManager = driver.findElement(By.tagName("downloads-manager"));
		WebElement shadowOfDownloadsManager = getShadowRoot(driver, downloadsManager);
		WebElement downloadsToolbar = shadowOfDownloadsManager.findElement(By.tagName("downloads-toolbar"));
		WebElement crToolbarSearchField = getShadowRoot(driver,
				getShadowRoot(driver, downloadsToolbar).findElement(By.tagName("cr-toolbar")))
						.findElement(By.tagName("cr-toolbar-search-field"));
		getShadowRoot(driver, crToolbarSearchField).findElement(By.id("searchInput")).sendKeys("xyz");

	}

	public static WebElement getShadowRoot(WebDriver driver, WebElement element) {

		return (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", element);
	}

}
