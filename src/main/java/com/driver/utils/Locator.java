package com.driver.utils;

import java.io.FileReader;
import java.util.Properties;

public class Locator {

	public enum LocatorStrategy {
		ID, XPATH, CLASSNAME, LINKTEXT
	};

	private String locator_id;
	private LocatorStrategy locator_strategy;
	private static Properties properties = null;

	static {
		try {
			properties = new Properties();
			properties.load(new FileReader(
					"./src/test/resources/properties/locators.properties"));
		} catch (Exception e) {
			System.out.println("Exception occurred while loading properties.");
			e.printStackTrace();
			System.out.println("Exiting...");
			System.exit(0);
		}
	}

	/**
	 * @param locator_id
	 *            locator string path (xpath / id value / classname value)
	 * @param locator_strategy
	 */
	private Locator(String locator_id, LocatorStrategy locator_strategy) {
		super();
		this.locator_id = locator_id;
		this.locator_strategy = locator_strategy;
	}

	/**
	 * @param locator_strategy_key
	 * @param locator_value_key
	 * @return
	 * @throws Exception
	 */
	public static Locator getInstance(String locator_strategy_key,
			String locator_value_key) throws Exception {

		LocatorStrategy locator_strategy = null;

		switch (properties.getProperty(locator_strategy_key).toUpperCase()) {

		case "ID":
			locator_strategy = LocatorStrategy.ID;
			break;
		case "LINKTEXT":
			locator_strategy = LocatorStrategy.LINKTEXT;
			break;
		case "XPATH":
			locator_strategy = LocatorStrategy.XPATH;
			break;
		case "CLASSNAME":
			locator_strategy = LocatorStrategy.CLASSNAME;
			break;
		default:
			throw new Exception("Invalid locator strategy - "
					+ locator_strategy_key);

		}
		return new Locator(properties.getProperty(locator_value_key),
				locator_strategy);
	}

	/**
	 * @return the locator_id
	 */
	public String getLocator_id() {
		return locator_id;
	}

	/**
	 * @param locator_id
	 *            the locator_id to set
	 */
	public void setLocator_id(String locator_id) {
		this.locator_id = locator_id;
	}

	/**
	 * @return the locator_strategy
	 */
	public LocatorStrategy getLocator_strategy() {
		return locator_strategy;
	}

	/**
	 * @param locator_strategy
	 *            the locator_strategy to set
	 */
	public void setLocator_strategy(LocatorStrategy locator_strategy) {
		this.locator_strategy = locator_strategy;
	}
}
