package com.driver.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementFinder {

	public static WebElement getElement(Locator locator, WebDriver driver) {
		WebElement element = null;
		String locator_id = locator.getLocator_id();

		switch (locator.getLocator_strategy()) {
		case ID:
			element = driver.findElement(By.id(locator_id));
			break;

		case XPATH:
			element = driver.findElement(By.xpath(locator_id));
			break;

		case LINKTEXT:
			element = driver.findElement(By.linkText(locator_id));
			break;
		}

		return element;
	}

	public static WebElement getElementWithWait(Locator locator,
			WebDriver driver) {
		WebElement element = null;
		String locator_id = locator.getLocator_id();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		switch (locator.getLocator_strategy()) {
		case ID:
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By
					.id(locator_id)));
			break;

		case XPATH:
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath(locator_id)));
			break;

		case LINKTEXT:
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By
					.linkText(locator_id)));
			break;
		}

		return element;
	}
}
