package com.binnu.jesudasan;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RawTemplate {
	private WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "C:\\Binnu\\My_Stuff\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver(); 
		driver.get("");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test(){
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
