package com.demo;

import java.io.File;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.driver.utils.Browser;

import action.core.ActionPerformer;

public class DemoApplicationSelenium {

	public static void main(String[] args) throws Exception {

		WebDriver driver;
		String baseUrl;
		String parentWindowHandle;
		baseUrl = "https://test.salesforce.com";
		driver = Browser.getInstance(Browser.BrowserType.Chrome, baseUrl);
		parentWindowHandle = driver.getWindowHandle();

//		ActionUtils action = new ActionUtils(driver);

//		ActionPerformer myActionPerformer = new ActionPerformer(driver);

		// Move to chapter1 page
//		System.out.println("Clicking on BMW");

		System.out.println("Username ----------------" + driver.findElement(By.id("username")).isDisplayed());

		System.out.println("Username hidden field ----------------"
				+ driver.findElement(By.xpath("//input[@type='hidden' and @name='ExtraLog']")).isDisplayed());

		// Fill forms
		driver.findElement(By.id("username")).sendKeys("testusersfdc@infobloxinc.com.uat");
		Thread.sleep(5000L);
		driver.findElement(By.id("password")).sendKeys("jade@1234");
		Thread.sleep(5000L);
		driver.findElement(By.id("Login")).click();

		Thread.sleep(30000L);

//		"//*[normalize-space(text())='Accounts']//ancestor::one-app-nav-bar-item-root

		System.out.println("Accounts ********* "
				+ driver.findElement(By.xpath("//*[normalize-space(text())='Accounts']")).isDisplayed());

//		System.out.println(driver.findElement(By.xpath(".//div[not(@id)]")).isDisplayed());

//		myActionPerformer.click(By.xpath(".//label[@for='bmw']"));

//		try {
//			myActionPerformer.click(By.xpath(".//label[@for='bmw']"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		action.click("linktext=Chapter1");

//		printLogs(driver);

		// click on radio button
		// wait for 10 seconds for element to be available
		System.out.println("Finding radio button");
//		WebElement radio_button = ElementFinder.getElementWithWait(
//				Locator.getInstance("homepage_chapter1.radio.strategy", "homepage_chapter1.radio.locator"), driver);

		System.out.println("Clicking on radio button");
//		radio_button.click();

		// Take screenshot using TakesScreenshot interface
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile,
					new File("C:\\tmp\\screenshot_" + Calendar.getInstance().getTimeInMillis() + ".png"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		Thread.sleep(5000L);

		System.exit(0);

		// navigate back to home page
		// System.out
		// .println("Navigating back to home page by pressing back button");
		// driver.navigate().back();

		// click on div to open second widnow
		System.out.println("Clicking on div to open second window");
//		getElementWithWait(Locator.getInstance("homepage_chapter1.multiwindow_div.strategy",
//				"homepage_chapter1.multiwindow_div.locator"), driver).click();

		// Switch to second window
		// Iterate over all window handles and find out appropriate window
		// handle to switch to
		Iterator<String> windowHandleIterator = driver.getWindowHandles().iterator();

		String windowHandle = null;
		while (windowHandleIterator.hasNext()) {
			windowHandle = windowHandleIterator.next();
			driver.switchTo().window(windowHandle);

			WebElement closePopupDiv = null;
			try {
				System.out.println("Current window URL is - " + driver.getCurrentUrl());
//				closePopupDiv = getElementWithWait(
//						Locator.getInstance("chapter1_childwindow.closepopup_paragraph.strategy",
//								"chapter1_childwindow.closepopup_paragraph.locator"),
//						driver);
			} catch (Exception e) {
				System.out.println("Element not found");
			}

			if (closePopupDiv != null) {
				System.out.println("Child window found - " + windowHandle);
				System.out.println("Closing child window");

				closePopupDiv.click();
			}
		}

		// switch back to parent window
		driver.switchTo().window(parentWindowHandle);

		// ajax loading by clicking div tag
		WebElement ajaxDiv = null;
//		ajaxDiv = getElementWithWait(Locator.getInstance("homepage_chapter1.div.ajaxpage.strategy",
//				"homepage_chapter1.div.ajaxpage.locator"), driver, 1L);
//		ajaxDiv.click();

		// ajax loading by clicking button
//		WebElement ajaxButton = getElement(Locator.getInstance("homepage_chapter1.button.ajaxbutton.strategy",
//				"homepage_chapter1.button.ajaxbutton.locator"), driver);
//		ajaxButton.click();

		printLogs(driver);
		// close browser
		// driver.quit();

		// Added a comment to test how it works with pull
	}

	private static void printLogs(WebDriver driver) {

		System.out.println("Available log types :- " + driver.manage().logs().getAvailableLogTypes());
		System.out.println("-------printing browser logs-------------");
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

		for (LogEntry logEntry : logEntries) {
			System.out.println(logEntry.getMessage() + " : " + logEntry.getLevel());
		}
		System.out.println("-------printing client logs-------------");
		logEntries = driver.manage().logs().get(LogType.CLIENT);

		for (LogEntry logEntry : logEntries) {
			System.out.println(logEntry.getMessage() + " : " + logEntry.getLevel());
		}

		System.out.println("-------printing driver logs-------------");
		logEntries = driver.manage().logs().get(LogType.DRIVER);

		for (LogEntry logEntry : logEntries) {
			System.out.println(logEntry.getMessage() + " : " + logEntry.getLevel());
		}

		System.out.println("-------printing performance logs-------------");
		logEntries = driver.manage().logs().get(LogType.PERFORMANCE);

		for (LogEntry logEntry : logEntries) {
			System.out.println(logEntry.getMessage() + " : " + logEntry.getLevel());
		}

	}
}
