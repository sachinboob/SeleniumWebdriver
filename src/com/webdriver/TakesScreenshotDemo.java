package com.webdriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.apache.commons.io.FileUtils;

public class TakesScreenshotDemo {

	public static void main(String[] args) throws Exception {

		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference(
				"security.mixed_content.block_active_content", false);
		firefoxProfile.setPreference(
				"security.mixed_content.block_display_content", false);

		String url = "http://www.sangeetagruhaudyog.com";

		WebDriver driver = new FirefoxDriver(firefoxProfile);

		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		driver.manage().window().maximize();
		driver.get(url);

		Thread.sleep(5000);

		// Take screenshot using TakesScreenshot interface
		try {
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("C:\\tmp\\Our_Products.png"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
