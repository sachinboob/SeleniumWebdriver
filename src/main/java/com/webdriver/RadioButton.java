package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {

	public static void main(String[] args) {

		String baseURL = "http://book.theautomatedtester.co.uk/chapter1";
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		//Force the program to wait to view the radio button
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Get radio button
		WebElement radioButton = driver.findElement(By.id("radiobutton"));

		// Check if Radio button is in selected state
		if (!radioButton.isSelected()) {
			System.out.println("Radio Button is NOT selected !! ");
		}

		//Force the program to wait to view the radio button
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Click on Radio button
		radioButton.click();

		// Check if Radio button is in selected state
		if (radioButton.isSelected()) {
			System.out.println("Radio Button is selected !! ");
		}
		
		//Force the program to wait to view the radio button
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		driver.quit();
	}
}