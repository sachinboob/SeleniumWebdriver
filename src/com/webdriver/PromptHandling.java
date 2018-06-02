package com.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PromptHandling {
	public static void main(String[] args) {

		String message = null;
		String baseURL = "file:///D:/Documents/Selenium%20Training%20Material%20Activity/Code/Prompt.html";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		
		// Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		Alert prompt = driver.switchTo().alert();

		// Get message in Alert pop up
		message = prompt.getText();
		System.out.println("Prompt pop up message :- " + message);
		
		// Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Type value in prompt dialog box
		prompt.sendKeys("Akshay Kumar");
		
		// Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Click on Ok button
		prompt.accept();
	}		
}
