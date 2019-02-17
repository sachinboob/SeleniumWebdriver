package com.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.driver.utils.Browser;

public class TestNGTests {
	static {
		Reporter.setEscapeHtml(true);
	}

	@Test(testName = "VAPI_Test_Trial_With_Commands", groups = { "VAPI_Test_Trial_With_Commands" })
	public void VAPI_Test_Trial_With_Commands() throws Exception {
		System.out.println("In method1");
		Reporter.log("<Report - In method1>");

		WebDriver driver;
		String baseUrl;
		String parentWindowHandle;
		baseUrl = "http://book.theautomatedtester.co.uk";
		driver = Browser.getInstance(Browser.BrowserType.Chrome, baseUrl);
		parentWindowHandle = driver.getWindowHandle();

		driver.quit();
	}

	@Test(testName = "SecondName", groups = { "sanity" })
	public void method2() throws Exception {
		System.out.println("In method2");
		Reporter.log("<Report - In method2>");

		WebDriver driver;
		String baseUrl;
		String parentWindowHandle;
		baseUrl = "http://book.theautomatedtester.co.uk";
		driver = Browser.getInstance(Browser.BrowserType.Chrome, baseUrl);
		parentWindowHandle = driver.getWindowHandle();


	}

}
