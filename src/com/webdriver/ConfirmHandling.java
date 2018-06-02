package com.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmHandling {
	public static void main(String[] args) {

		String message = null;
		String baseURL = "file:///D:/Documents/Selenium%20Training%20Material%20Activity/Code/Confirm.html";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		//Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		Alert confirm = driver.switchTo().alert();

		//Get message in Alert pop up
		message = confirm.getText();
		System.out.println("Confirm message :- " + message);
		
		//Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Accept Confirm dialog (Click on default Ok button)
		confirm.accept();
		System.out.println("Confirm dialog accepted...");
		
		//Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		Alert confirm2 = driver.switchTo().alert();

		//Get message in Alert pop up
		message = confirm2.getText();
		System.out.println("Confirm message :- " + message);
		
		//Force the program to wait to view the dialog box
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// Dismiss confirm dialog box
		confirm2.dismiss();
		System.out.println("Confirm dialog accepted...");
	}
}
