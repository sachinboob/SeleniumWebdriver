package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextField {

	
	public static void main(String[] args) {
		String baseURL = "https://email.accenture.com";
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		WebElement textField = driver.findElement(By.id("username"));
		
		//Write text into username
		textField.sendKeys("abc");
		
		//Get text from username field
		System.out.println("Text in username field is :- " + textField.getText());
		
		//Clear text from username field
		textField.clear();
	}
}
