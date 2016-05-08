package com.tr.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class HomePageTest 
{
WebDriver driver;
HomePage homePage=null;
NewBrowserTabPage newBrowserPage=null;
String expetedTitle="Selenium";
boolean flag;

@BeforeTest
public void setUp(){
	
	driver= new FirefoxDriver();
	driver.get("http://www.seleniumframework.com/Practiceform/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}
@Test
public void verifyHomePage() throws Exception
{
	homePage = new HomePage(driver);
	String titleName = homePage.getHomePageTitle();
	boolean flag = titleName.contains(expetedTitle);
	Assert.assertTrue(flag);
	newBrowserPage=homePage.clickonNewBrowserTab();
	
	newBrowserPage = new NewBrowserTabPage(driver);
	String browserTitlePage = newBrowserPage.getBrowserTabTitle();
}
}
