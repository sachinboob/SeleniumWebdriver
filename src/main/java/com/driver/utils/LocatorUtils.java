package com.driver.utils;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.driver.utils.Locator.LocatorStrategy;

public class LocatorUtils {

	

	public static Properties locators;

	static {
		try {
			locators = new Properties();
			locators.load(new FileReader(
					"./src/test/resources/locator.properties"));
		} catch (Exception e) {
			System.out.println("Exception while loading properties");
			e.printStackTrace();
			System.out.println("Exiting system...");
			System.exit(0);
		}
	}

	public WebElement getElement(String element_key,
			LocatorStrategy locator_strategy) {
		WebElement element = null;

		switch(locator_strategy){
//		case ID: element = 
		}
		
		return element;
	}

}
