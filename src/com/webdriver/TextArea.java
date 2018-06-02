package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextArea {

	public static void main(String[] args) {

		String baseURL = "file:///D:/Documents/Selenium%20Training%20Material%20Activity/Code/TextArea.html";
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();

		//Force the program to wait to view the radio button
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Get textarea
		WebElement textArea = driver.findElement(By.id("textarea1"));
		
		// Get text inside textarea
		String text = textArea.getText();
		
		System.out.println("Text in textarea :- " + text);
		
		// Change text
		textArea.sendKeys(" This text is appended...");

		//Force the program to wait to view the radio button
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		driver.quit();
	}
}