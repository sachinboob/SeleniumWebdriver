package com.demo;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.driver.utils.Browser;
import com.driver.utils.Browser.BrowserType;

public class DragAndDropDemo {

	public static void main(String args[]) throws Exception {

		WebDriver driver = Browser.getInstance(BrowserType.Chrome);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");

		WebElement eleA = driver.findElement(By.id("column-a"));
		WebElement eleB = driver.findElement(By.id("column-b"));

		System.out.println("Element A location :- " + eleA.getLocation());

		System.out.println("Element B location :- " + eleB.getLocation());

		Actions action = new Actions(driver);
//		action.dragAndDrop(eleA, eleB).perform();
		Thread.sleep(5000);

//		action.contextClick(eleA).perform();

//		action.dragAndDropBy(driver.findElement(By.id("column-a")), 250, 0).build().perform();

//		action.clickAndHold(eleA).pause(5).moveToElement(eleB, 50, 0).build().perform();

		System.out.println(MessageFormat.format("Element A :- Height {0}, Width {1}, X {2}, Y {3}",
				eleA.getRect().getHeight(), eleA.getRect().getWidth(), eleA.getRect().getX(), eleA.getRect().getY()));

		System.out.println(MessageFormat.format("Element B :- Height {0}, Width {1}, X {2}, Y {3}",
				eleB.getRect().getHeight(), eleB.getRect().getWidth(), eleB.getRect().getX(), eleB.getRect().getY()));

//		int elementACoordX = eleA.getRect().
//		int elementACoordY = eleA.getRect().getY();

		Robot robot = new Robot();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("Screen height :- " + screenSize.height);
		System.out.println("Screen width :- " + screenSize.width);

		robot.mouseMove(screenSize.height/2, screenSize.width/2);
//		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
//		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
//		robot.mouseMove(eleB.getRect().getX() + 50, eleB.getRect().getY());
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//		action.contextClick();

	}

}
