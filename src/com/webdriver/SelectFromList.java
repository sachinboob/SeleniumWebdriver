package com.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectFromList {


	public static void main(String[] args) {
		
		String baseURL = "http://book.theautomatedtester.co.uk/chapter1";
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		//Force the program to wait to view the dropdown list
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}

		// Create instance of select list
		WebElement select = driver.findElement(By.id("selecttype"));
		
		// Fetch options
		List<WebElement> options = select.findElements(By.tagName("option"));
		
		System.out.println("There are " + options.size() + " options in the list.");
		
		// Display all options
		int i = 1;
		for(WebElement tmp : options){
			System.out.println("Option " + i + " = " + tmp.getAttribute("value"));
			i++;
			
			// One way to select an option from list
			tmp.click();
			try{Thread.sleep(2000);}catch(Exception e){System.out.println(e.toString());}

		}
		
		// Another way to select an option from list
		Select selectList = new Select(driver.findElement(By.id("selecttype")));
		System.out.println("Select Selenium Core option from list.");
		selectList.selectByVisibleText("Selenium Core");
		try{Thread.sleep(5000);}catch(Exception e){System.out.println(e.toString());}
		
		driver.quit();
	}
}