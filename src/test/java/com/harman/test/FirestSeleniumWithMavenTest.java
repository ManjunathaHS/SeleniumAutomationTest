package com.harman.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirestSeleniumWithMavenTest 
{
String DEFULT_URL ="http://www.flipkart.com/";
WebDriver driver;
String name = "WOMEN";
@BeforeTest
public void setUp()
{
	driver = new FirefoxDriver();
	driver.get(DEFULT_URL);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();;
}
@Test
public void verifyHeaderLinks()
{
	List<WebElement> list = driver.findElements(By.xpath("//div[@id='container']//div[@Class='_3Ed3Ub']//li[@Class='Wbt_B2']"));
	int count = list.size();
	System.out.println("Total Number of links:"+count);
	for (int i = 0; i < count; i++)
	{
	WebElement actualList = list.get(i);
	String outPutValue = actualList.getText();
	System.out.println("Header Text Details:"+outPutValue);
	if (outPutValue.equals(name))
	{
		System.out.println("Actual and Expected Names are Same");
		break;
	}
	}
}
@AfterTest
public void afterTest()
{
	
	driver.quit();
	
}
}
