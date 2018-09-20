package com.driver.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {

	public enum BrowserType {
		Firefox, IE, Chrome
	};

	static {
		System.setProperty("webdriver.gecko.driver",
				"./src/test/resources/drivers/geckodriver-v0.21.0-win32/geckodriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
	}

	public static WebDriver getInstance(BrowserType browser_type) {

		WebDriver driver = null;

		switch (browser_type) {
		case Firefox:
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", false);
			driver = new FirefoxDriver(options);
			break;

		case Chrome:
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("No matching case found for browser type " + browser_type);
		}

		return driver;
	}

	public static WebDriver getInstance(BrowserType browser_type, String url) {

		WebDriver driver = null;

		driver = getInstance(browser_type);
		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}
}
