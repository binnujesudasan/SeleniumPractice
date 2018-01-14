package com.binnu.jesudasan;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public class Guru99 {
    private WebDriver driver;
    private String reportFile;
    private Document document;
    private PdfPTable pdfPTable;
    @BeforeMethod
    public void setUp(){
        reportFile = System.getProperty("user.dir")+"\\PDFReport.pdf";
        System.setProperty("webdriver.gecko.driver", "C:\\Binnu\\My_Stuff\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.guru99.com/selenium-tutorial.html");
        driver.manage().window().maximize();

        try {
            document = new Document();
            PdfWriter.getInstance(document,new FileOutputStream(reportFile));
            document.open();
            pdfPTable = new PdfPTable(1);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
        for(int i = 1; i < tableRows.size(); i++){
            System.out.println(i+". "+tableRows.get(i).getAttribute("innerText"));
            pdfPTable.addCell(i+". "+tableRows.get(i).getAttribute("innerText"));

        }
    }

    @AfterMethod
    public void tearDown(){
        try {
            document.add(pdfPTable);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
        driver.quit();
    }
}
