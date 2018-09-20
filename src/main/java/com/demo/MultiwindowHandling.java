package com.demo;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiwindowHandling {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// File file = new File("firebug-1.8.1.xpi");
		// FirefoxProfile firefoxProfile = new FirefoxProfile();
		// firefoxProfile.addExtension(file);
		// firefoxProfile.setPreference("extensions.firebug.currentVersion",
		// "1.8.1"); // Avoid startup screen

		// WebDriver driver = new FirefoxDriver(firefoxProfile);

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.hdfcbank.com");
		driver.manage().timeouts().implicitlyWait(40L, TimeUnit.SECONDS);

		Set<String> s = driver.getWindowHandles();

		System.out.println("Number of windows = " + s.size());
		System.out.println("Clicking on login button...");
		driver.findElement(By.id("loginsubmit")).click();

		s = driver.getWindowHandles();

		System.out.println("Number of windows =" + s.size());

		Iterator<String> i = s.iterator();
		String parent = i.next();
		String child = i.next();
		System.out.println("Parent = " + parent);
		System.out.println("child = " + child);

		driver.switchTo().window(child);
		driver.findElement(By.xpath("//*[@id='wrapper']/div[6]/a/img"));
		driver.close();
		driver.switchTo().window(parent);
	}
}