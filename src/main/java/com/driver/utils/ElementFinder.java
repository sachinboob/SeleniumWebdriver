package com.driver.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementFinder {

	/**
	 * @param locator
	 *            Locator object containing element locator id and strategy
	 * @param driver
	 *            WebDriver browser instance
	 * @return WebElement found based on locator
	 */
	public static WebElement getElement(Locator locator, WebDriver driver) {
		WebElement element = null;
		By by = null;
		by = getBy(locator);
		element = driver.findElement(by);
		return element;
	}

	/**
	 * @param locator
	 *            Locator object containing element locator id and strategy
	 * @param driver
	 *            WebDriver browser instance
	 * @param waitTimeInSeconds
	 *            Number of seconds to wait for the element to be located
	 * @return WebElement found based on the parameters
	 */
	public static WebElement getElementWithWait(Locator locator,
			WebDriver driver, long waitTimeInSeconds) {
		WebElement element = null;
		By by = null;
		by = getBy(locator);

		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

		return element;
	}

	public static WebElement getElementWithWait(Locator locator,
			WebDriver driver) {
		// call method with 5 seconds wait time
		return getElementWithWait(locator, driver, 5L);

	}

	private static By getBy(Locator locator) {
		String locator_id = locator.getLocator_id();
		By by = null;
		switch (locator.getLocator_strategy()) {
		case ID:
			by = By.id(locator_id);
			break;

		case XPATH:
			by = By.xpath(locator_id);
			break;

		case LINKTEXT:
			by = By.linkText(locator_id);
			break;

		case CLASSNAME:
			by = By.className(locator_id);
			break;
		}

		return by;
	}
}
