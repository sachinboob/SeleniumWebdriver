package com.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HtmlUnitDriverDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver htmlDriver = new HtmlUnitDriver();
		htmlDriver.get("http://www.google.com");
		System.out.println(htmlDriver.getTitle());
		System.out.println(htmlDriver.getCurrentUrl());
		System.out.println(htmlDriver.getPageSource());
	}
}
