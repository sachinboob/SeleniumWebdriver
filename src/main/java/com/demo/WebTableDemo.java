package com.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver
				.get("file:///C:/Users/training_p3.00.08/Downloads/4th%20ODI%20%20England%20v%20Sri%20Lanka%20at%20Nottingham,%20Jul%206,%202011%20_%20Cricket%20Scorecard%20_%20ESPN%20Cricinfo.html");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String xPathTableBody = "//*[@id='inningsBat1']/tbody/";
		String rowStart = "tr[";
		String rowEnd = "]/";
		String columnStart = "td[";
		String columnEnd = "]";
		
//		//*[@id='inningsBat1']/tbody/tr[3]/td[2]

		int rowCounter;
		int columnCounter;

		for (rowCounter = 3; rowCounter <= 25; rowCounter = rowCounter + 2) {
			String tableRow = "";

			for (columnCounter = 2; columnCounter <= 9; columnCounter++) {
				String xpathExpression = xPathTableBody + rowStart + rowCounter
						+ rowEnd + columnStart + columnCounter + columnEnd;
				tableRow = tableRow
						+ driver.findElement(By.xpath(xpathExpression))
								.getText() + " | ";
				// System.out.println(xpathExpression);
			}
			System.out.println(tableRow);
		}
	}
}
