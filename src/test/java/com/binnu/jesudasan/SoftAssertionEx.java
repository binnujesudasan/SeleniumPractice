package com.binnu.jesudasan;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SoftAssertionEx {
	private WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "C:\\Binnu\\My_Stuff\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver(); 
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testSoftAssertion(){
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Soft Assertion Started");
		softAssert.assertEquals(driver.getTitle(), "Hello World");
		System.out.println("Soft Assertion Completed");
		softAssert.assertAll();
	}
	
	@Test
	public void testHardAssertion(){
		System.out.println("Hard Assertion Started");
		Assert.assertEquals(driver.getTitle(), "Hello World");
		System.out.println("Hard Assertion Completed");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
