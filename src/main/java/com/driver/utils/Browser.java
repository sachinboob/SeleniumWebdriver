package com.driver.utils;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.demo.EventHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public enum BrowserType {
		Firefox, IE, Chrome
	};

	public static final String downloadDirectory = "D:\\temp";

//	static {
//		System.setProperty("webdriver.gecko.driver",
//				"./src/test/resources/drivers/geckodriver-v0.21.0-win32/geckodriver.exe");
//
//		System.setProperty("webdriver.chrome.driver",
//				"./src/test/resources/drivers/chromedriver_win32/chromedriver.exe");
//	}

	public static WebDriver getInstance(BrowserType browser_type) throws Exception {

		WebDriver driver = null;

		switch (browser_type) {
		case Firefox:
			WebDriverManager.firefoxdriver().setup();
			System.out.println("Downloaded version :- " + WebDriverManager.firefoxdriver().getDownloadedVersion());
			FirefoxOptions options = new FirefoxOptions();
//			options.setCapability("marionette", false);
			driver = new FirefoxDriver(options);
			break;

		case Chrome:
//			System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

			System.setProperty("webdriver.chrome.logfile", "./chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			
			WebDriverManager.chromedriver().setup();
			System.out.println("Downloaded version :- " + WebDriverManager.chromedriver().getDownloadedVersion());
//			LoggingPreferences preferences = new LoggingPreferences();
//			preferences.enable(LogType.PERFORMANCE, Level.ALL);
			ChromeOptions chromeOptions = new ChromeOptions();

//			chromeOptions.setCapability(CapabilityType.LOGGING_sPREFS, preferences);

			Map<String, Object> other_preferences = new Hashtable<String, Object>();

			// disable flash and the PDF viewer
//			other_preferences.put("plugins.plugins_disabled",
//					new String[] { "Adobe Flash Player", "Chrome PDF Viewer" });

			other_preferences.put("plugins.always_open_pdf_externally", true);
			other_preferences.put("download.default_directory", downloadDirectory);

			chromeOptions.setExperimentalOption("prefs", other_preferences);

			driver = new ChromeDriver(chromeOptions);
			break;

		default:
			throw new Exception("No matching case found for browser type " + browser_type);
		}

		return driver;
	}

	public static WebDriver getInstance(BrowserType browser_type, String url) throws Exception {

		WebDriver driver = null;

		driver = getInstance(browser_type);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}
}
