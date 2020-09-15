package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import com.driver.utils.Browser;

import action.core.ActionPerformer;

public class ActionPerformerDemo {

	private static final String ID_SELECTTYPE = "ID=selecttype";

	public static void main(String[] args) throws Exception {

		WebDriver driver;
		String baseUrl;
		String parentWindowHandle;
		baseUrl = "https://learn.letskodeit.com/p/practice";
//		baseUrl = "http://www.axmag.com/download/pdfurl-guide.pdf";
		driver = Browser.getInstance(Browser.BrowserType.Chrome, baseUrl);
		
		SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
		
		System.out.println("Session id - " + sessionId);
		

//		new BufferedReader(new InputStreamReader(System.in)).readLine();

//		ExtractTextSimple.extractText(Browser.downloadDirectory + "\\" + "pdfurl-guide.pdf");
//		System.exit(0);

//		ActionPerformer myActionPerformer = new ActionPerformer(driver);
//
//		myActionPerformer.click(By.xpath("//a[contains(text(),'Join now')]")).waitTime(10);
//	
//		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("04/04/1989");
		
//		myActionPerformer.enterText("ID=userid", "ssri00h").enterText("ID=password", "Welcome1")
//				.click("XPATH=//button[normalize-space(text())='Sign In']");

//		myActionPerformer.click("XPATH=(//a[normalize-space(@title)='shared finance'])[2]")
//				.click("XPATH=//a[normalize-space(text())='Sign Out']");

//		By clickonHome = By.xpath("//a[@title='Home' and @id='pt1:_UIShome']");
//		By clickonProcurement = By.xpath("//a[contains(text(),'Procurement')]");
//		By clickonPurchaseOrder = By.xpath("//a[contains(@id,'itemNode_procurement_PurchaseOrders_2')]");
//		By clickonTask = By.xpath("//a[contains(@id,'FndTasksList::disAcr')]");
//		By clickonCreateOrder = By.xpath("//a[contains(text(),'Create Order')]");
//
//		myActionPerformer.click(clickonHome).click(clickonProcurement).click(clickonPurchaseOrder);
//		myActionPerformer.click(clickonTask).click(clickonCreateOrder);
//
//		By clickonProcurementBU = By.xpath("//select[contains(@id,'ProcurementBu::content')]");
//		String createOrderFormProcurementBUDropDownValue = "JG IN Business Unit";
//		By clickonSupplier = By.xpath("//input[contains(@id,'Supplier::content')]");
//		String createOrderFormSupplierName = "Nyati Builders Pvt Lyd";
//		By selectNyati = By.xpath("//li[contains(text(),'Nyati Builders Pvt Lyd 10708')]");
//
//		myActionPerformer.click(clickonProcurementBU).selectOption(
//				"XPATH=//select[contains(@id,'ProcurementBu::content')]", createOrderFormProcurementBUDropDownValue);
//
//		myActionPerformer.enterText("XPATH=//input[contains(@id,'Supplier::content')]", createOrderFormSupplierName)
//				.click("XPATH=//li[contains(text(),'Nyati Builders Pvt Lyd 10708')]");

	}

}
