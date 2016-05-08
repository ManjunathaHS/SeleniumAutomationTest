package com.tr.pages;

import java.security.PublicKey;

import javax.print.attribute.standard.RequestingUserName;

import org.openqa.selenium.WebDriver;

public class NewBrowserTabPage 
{
WebDriver driver;
String title=null;
//Constructor to insalize te browser properties.
public NewBrowserTabPage(WebDriver driver)
{
	this.driver=driver;
}
public String getBrowserTabTitle()
{
	try 
	{
		title=driver.getTitle();	
	} catch (Exception e)
	{
		
	}
	return title;
}

}
