package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.driver.utils.Browser;

public class TestNGTests {
	static {
		Reporter.setEscapeHtml(true);
	}

	WebDriver driver;
	String baseUrl;

	@BeforeTest
	public void beforeTest() throws Exception {

		baseUrl = "https://test.salesforce.com";
		driver = Browser.getInstance(Browser.BrowserType.Chrome, baseUrl);

	}

	@Test(testName = "Test_1", groups = { "Group_1" })
	public void test_1() throws Exception {
		if (driver.findElement(By.xpath(".//input[@id='username']")).isDisplayed()) {
			driver.findElement(By.xpath(".//input[@id='username']")).sendKeys("testusersfdc@infobloxinc.com.uat");
		}

		Thread.sleep(5000L);

		if (driver.findElement(By.xpath(".//input[@id='Login']")).isDisplayed()) {
			driver.findElement(By.xpath(".//input[@id='Login']")).click();
		}

	}

}
