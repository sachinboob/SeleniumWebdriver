package com.demo;

import static com.driver.utils.ElementFinder.getElement;
import static com.driver.utils.ElementFinder.getElementWithWait;

import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.utils.Browser;
import com.driver.utils.ElementFinder;
import com.driver.utils.Locator;

public class DemoApplicationSelenium {

	public static void main(String[] args) throws Exception {

		WebDriver driver;
		String baseUrl;
		baseUrl = "http://book.theautomatedtester.co.uk";
		driver = Browser.getInstance(Browser.BrowserType.Chrome, baseUrl);

		// Move to chapter1 page
		System.out.println("Clicking on chapter1");
		getElement(
				Locator.getInstance("homepage.chapter1.link.strategy",
						"homepage.chapter1.link.locator"), driver).click();

		// click on radio button
		// wait for 10 seconds for element to be available
		System.out.println("Finding radio button");
		WebElement radio_button = ElementFinder.getElementWithWait(Locator
				.getInstance("homepage_chapter1.radio.strategy",
						"homepage_chapter1.radio.locator"), driver);

		System.out.println("Clicking on radio button");
		radio_button.click();

		// Take screenshot using TakesScreenshot interface
		try {
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("C:\\tmp\\screenshot_"
					+ Calendar.getInstance().getTimeInMillis() + ".png"));

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		Thread.sleep(5000L);

		// navigate back to home page
		System.out
				.println("Navigating back to home page by pressing back button");
		driver.navigate().back();

		// navigate to a different page using navigate method
		Thread.sleep(5000L);
		driver.navigate().to("http://www.sangeetagruhaudyog.com");
	}
}