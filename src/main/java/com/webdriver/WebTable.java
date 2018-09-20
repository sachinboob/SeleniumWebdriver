package com.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTable {
	
	public static void main(String[] args){
		
		String baseURL = "file:///D:/Documents/Selenium%20Training%20Material%20Activity/Code/For%20Webtable/WI%20254%20%2882.2%20ov,%20S%20Shillingford%2030%20,%20TA%20Boult%203_48%29%20-%20Match%20over%20_%20Live%20Scorecard%20_%20ESPN%20Cricinfo.htm";
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		//Force the program to wait to view the radio button
		try{Thread.sleep(4000);}catch(Exception e){System.out.println(e.toString());}
		
		// xpath -> .//*[@id='full-scorecard']/div[2]/div/table[1]/tbody/tr[2]/td[2]
		
		// Variables for generating xpath dynamically 
		String xPathTableBody = ".//*[@id='full-scorecard']/div[2]/div/table[1]/tbody/";
		String rowStart = "tr[";
		String rowEnd = "]/";
		String columnStart = "td[";
		String columnEnd = "]";
		
		int rowCounter = 0;
		int columnCounter = 0;
		
		// Loop through table data and display on console
		
		System.out.println("Loop through table and display data on console...");

		for (rowCounter = 2; rowCounter <= 24; rowCounter = rowCounter + 2) {
			String tableRow = "";

			for (columnCounter = 2; columnCounter <= 9; columnCounter++) {
				String xpathExpression = xPathTableBody + rowStart + rowCounter
						+ rowEnd + columnStart + columnCounter + columnEnd;
				tableRow = tableRow
						+ driver.findElement(By.xpath(xpathExpression))
								.getText() + " | ";
			}
			
			System.out.println(tableRow);
		}
		
		driver.quit();
	}
}