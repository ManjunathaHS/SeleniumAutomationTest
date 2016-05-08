package com.tr.pages;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class MasterIndiaTest 
{
WebDriver driver;
String Base_URL="http://www.monsterindia.com/";
MonsterIndiaHomePage masterHomePage = null;
Boolean flag=false;
Boolean flag1=false;
String name;
int cout=0;
String ankerLinkText=null;
String actualTextMessage=null;

@BeforeTest
public void SetUp()
{
driver = new FirefoxDriver();
driver.get(Base_URL);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
driver.manage().window().maximize();

}
@Test
public void verifyMasterHomePage() throws Exception
{

//TestCase:1
masterHomePage= new MonsterIndiaHomePage(driver);
flag = masterHomePage.isSiteLogoDisplayed();
Assert.assertTrue("Master flag Logo not displayed", flag);

//flag1 = masterHomePage.isSingInButtonPresent();
flag = masterHomePage.verifyTopJobs();
/*
//Test Case:2, Verify link count
cout=masterHomePage.verifyanckerLinksCount();

//Test Case:3, Anker Link Texts.
//ankerLinkText=masterHomePage.ankerLinkText();

//Test Case:4, Count the links in My Monster section
//cout = masterHomePage.myMonsterLinks();


//Test case:5, Verify Job title text box
flag = masterHomePage.isJobTitleTextBoxDisplayed();
Assert.assertTrue("JobTitle text box is not Displayed/Enabled",flag);

//Test case:6, Verify Experience drop down
flag = masterHomePage.isLocationTextBoxDisplayed();
Assert.assertTrue("Location text box is not Displayed/Enabled",flag);

//Test Case 7: Verify the Find Better button status
flag = masterHomePage.clickOnFindBetter();
Assert.assertTrue("Find Better button is not displayed", flag);
*/
}

@AfterTest
public void closeBrowser()
{
	driver.quit();
}
}
