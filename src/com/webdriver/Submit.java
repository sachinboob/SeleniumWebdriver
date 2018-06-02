package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Submit {

	public static void main(String[] args) {
		String baseURL = "https://email.accenture.com";
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		//Force the program to wait
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
		
		// Identify submit button
		WebElement submit = driver.findElement(By.xpath(".//*[@type='submit']"));
		System.out.println("Clicking submit button...");
		submit.click();
		
		//Force the program to wait
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		driver.quit();
	}

}
