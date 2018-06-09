package com.driver.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public enum BrowserType {
		Firefox, IE, Chrome
	};

	static {
		System.setProperty("webdriver.gecko.driver",
				"D:\\Work\\Selenium Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Work\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
	}

	public static WebDriver getInstance(BrowserType browser_type) {

		WebDriver driver = null;

		switch (browser_type) {
		case Firefox:
			driver = new FirefoxDriver();
			break;

		case Chrome:
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("No matching case found for browser type "
					+ browser_type);
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
