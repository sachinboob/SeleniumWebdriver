package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExtractAttributeValues {

	public static void main(String[] args) {

		String baseURL = "http://book.theautomatedtester.co.uk";
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		// Get href attribute value of link Chapter 1
		WebElement link = driver.findElement(By.linkText("Chapter1"));
		System.out.println("Href attribute value for link Chapter1 is :- " + link.getAttribute("href"));
		link.click();
		
		// Get name and type attribute value of checkbox
		WebElement checkbox = driver.findElement(By.xpath("html/body/div[2]/p[3]/input"));
		System.out.println("name attribute value of of Checkbox is :- " + checkbox.getAttribute("name"));
		System.out.println("type attribute value of Checkbox is :- " + checkbox.getAttribute("type"));
		System.out.println("Is Checkbox selected ? :- " + checkbox.isSelected());
		
		// Get value attribute of a button
		WebElement button = driver.findElement(By.id("verifybutton"));
		System.out.println("value attribute of button is :- " + button.getAttribute("value"));
		
		// Get onClick attribute value of div tag to open new window
		WebElement divText = driver.findElement(By.className("multiplewindow"));
		System.out.println("Text within div tag is :- " + divText.getText());
		System.out.println("onclick attribute value of div is :- " + divText.getAttribute("onclick"));
	}

}
