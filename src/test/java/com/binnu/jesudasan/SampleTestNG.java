package com.binnu.jesudasan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by SG0224471 on 1/14/2018.
 */
public class SampleTestNG {
    private WebDriver driver;

        @Parameters("browser")
        @BeforeMethod
        public void setUp(String browser){
        if(browser.equalsIgnoreCase("Mozilla Firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("Google Chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Internet Explorer")){
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else{
            System.err.println("Please configure appropriate browser");
        }

        driver.get("https://www.google.co.in/");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testTestNG(){

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}