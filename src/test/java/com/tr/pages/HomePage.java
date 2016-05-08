package com.tr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class HomePage
{
	WebDriver driver;
	String title = "";
	WebElement element =null;
	boolean flag= false;
	By newBrowserTab = By.xpath("//button[contains(.,'Browser Tab')]");
	//Constructor
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public  String getHomePageTitle() throws Exception 
	{
	try 
	{
	 title = driver.getTitle();
	 
	} catch (Exception e)
		
	{
		throw new Exception("Failed while getting home page tile"+getHomePageTitle()+e.getLocalizedMessage());
	}
	return title;
	}
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	public NewBrowserTabPage clickonNewBrowserTab() throws Exception
	{
		try 
		{
			element = driver.findElement(newBrowserTab);
			flag=element.isDisplayed();
			Assert.assertTrue(flag); 
			element.click();
			
			
		} catch (Exception e) 
		
		{
			throw new Exception("New Browser Tab not displayed"+clickonNewBrowserTab());
		}
		return new NewBrowserTabPage(driver);
	}
}
