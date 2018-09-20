package com.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHandling {

	public static void main(String[] args) {

		String message = null;
		String baseURL = "file:///D:/Documents/Selenium%20Training%20Material%20Activity/Code/Alert.html";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		
		//Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		Alert alert = driver.switchTo().alert();

		//Get message in Alert pop up
		message = alert.getText();
		System.out.println("Alert message :- " + message);
		
		//Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Accept Alert dialog (Click on default Ok button)
		alert.accept();
		System.out.println("Alert dialog accepted...");
		
		driver.quit();
	}
}
