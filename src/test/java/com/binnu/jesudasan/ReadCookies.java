package com.binnu.jesudasan;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadCookies {
	private WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "C:\\Binnu\\My_Stuff\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver(); 
		driver.get("http://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testReadCookies(){
		Cookie ck = new Cookie("Binnu", "Gudapati");
		driver.manage().addCookie(ck);
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Default + Added Cookies ");
		for (Cookie cookie : cookies) {
			System.out.println(cookie);
		}
		System.out.println("Cookies Deleted");
		driver.manage().deleteAllCookies();
		Set<Cookie> cookies1 = driver.manage().getCookies();
		for (Cookie cookie1 : cookies1) {
			System.out.println(cookie1);
		}
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
