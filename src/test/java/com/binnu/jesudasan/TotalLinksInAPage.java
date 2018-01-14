package com.binnu.jesudasan;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TotalLinksInAPage {
	private WebDriver driver;
	private String siteDomain;
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "C:\\Binnu\\My_Stuff\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.guru99.com/top-100-selenium-interview-questions-answers.html");
		siteDomain = "https://www.guru99.com/";
	}
	
	@Test
	public void totalLinksInAPage() throws IOException{
		List<WebElement> linksCount = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links "+linksCount.size());
		int unBrokenLinks = 0;
		for (int i = 0; i < linksCount.size(); i++) {
			String webLink = linksCount.get(i).getAttribute("href");
			try{
				if((!webLink.isEmpty()) && (!webLink.equals(null)) && (webLink.contains(siteDomain))){
					System.out.println(webLink);
					unBrokenLinks++; 
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		System.out.println("No of Non Broken links "+unBrokenLinks);
	}
	
	public static boolean checkBrokenLink(String webUrl){
		try {
			URL url = new URL(webUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setReadTimeout(10000);
			connection.connect();
			if(connection.getResponseCode() == 200){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}