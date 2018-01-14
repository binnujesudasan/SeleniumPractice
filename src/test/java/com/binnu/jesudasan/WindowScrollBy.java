package com.binnu.jesudasan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowScrollBy {
	private WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "C:\\Binnu\\My_Stuff\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver(); 
		driver.get("https://www.guru99.com/selenium-tutorial.html");
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void testWindowScrollBy1() throws InterruptedException{
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		javascriptExecutor.executeScript("window.scrollBy(0,-250)", "");
	}

	@Test(enabled=false)
	public void testWindowScrollBy2() throws InterruptedException{
		WebElement pageBody = driver.findElement(By.tagName("body"));
		Action actions = new Actions(driver).
				moveToElement(pageBody, pageBody.getSize().getWidth() - 10,15).
				clickAndHold().
				moveByOffset(0, 50).
				release().
				build();
				actions.perform();
				Thread.sleep(10000);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}