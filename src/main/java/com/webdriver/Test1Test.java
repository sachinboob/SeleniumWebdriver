package com.webdriver;
// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Test1Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\sachin.boob\\eclipse-workspace\\SeleniumWebdriver\\src\\test\\resources\\drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
//    driver.quit();
  }
  @Test
  public void test1() {
    driver.get("https://egcd-dev1.login.us6.oraclecloud.com");
    driver.manage().window().setSize(new Dimension(1552, 849));
//    driver.findElement(By.id("Login")).click();
//    driver.findElement(By.id("Login")).click();
    driver.findElement(By.id("userid")).sendKeys("aai");
//    driver.findElement(By.id("Login")).click();
    driver.findElement(By.id("password")).sendKeys("test1234");
    driver.findElement(By.id("btnActive")).click();
    driver.findElement(By.cssSelector("#pt1\\3A_UIShome\\3A\\3Aicon > g:nth-child(6) > .svg-outline")).click();
    driver.findElement(By.cssSelector("#groupNode_my_information > .svg-nav")).click();
    driver.findElement(By.cssSelector("#PER_HCMPEOPLETOP_FUSE_DIRECTORY .svg-outline:nth-child(6)")).click();
    driver.findElement(By.id("_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_DIRECTORY:0:_FOTsr1:0:it1::content")).click();
    driver.findElement(By.id("_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_DIRECTORY:0:_FOTsr1:0:it1::content")).sendKeys("neha");
    driver.findElement(By.id("_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_DIRECTORY:0:_FOTsr1:0:cil1::icon")).click();
  }
}
