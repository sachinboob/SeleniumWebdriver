package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.basics.Debug;

import com.gargoylesoftware.htmlunit.javascript.host.Screen;

public class Checkbox {

	public static void main(String[] args) {
		String baseURL = "http://book.theautomatedtester.co.uk/chapter1";
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		Debug.setDebugLevel(3);
	    Screen s = new Screen();
//	    s.
		
		//Force the program to wait to view the checkbox
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Get radio button
		WebElement checkbox = driver.findElement(By.name("selected(1234)"));

		// Check if checkbox is in selected state
		if (!checkbox.isSelected()) {
			System.out.println("Checkbox is NOT selected !! ");
		}

		//Force the program to wait to view the checkbox
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Click on Radio button
		checkbox.click();

		// Check if checkbox is in selected state
		if (checkbox.isSelected()) {
			System.out.println("Checkbox is selected !! ");
		}
		
		//Force the program to wait to view the checkbox
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		driver.quit();
	}

}
