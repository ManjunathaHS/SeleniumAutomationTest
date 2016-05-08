package com.tr.pages;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.Extension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.google.common.base.Throwables;
import com.sun.jna.platform.win32.OaIdl.PARAMDESC;
import com.sun.jna.platform.win32.Secur32.EXTENDED_NAME_FORMAT;

import junit.framework.Assert;

public class MonsterIndiaHomePage 
{
	WebDriver driver;
	boolean flag = false;
	List<WebElement> list=null;
	WebElement actualList,homePageTab=null;
	int count = 0;
	int actualaCount=4;
	String ankerLinkText=null;
	Actions act;
	String outPutValue=null;
	String expectedTopJobstext="Top Jobs";
	By siteImage = By.xpath("//div[@id='header']//a[contains(@class,'logo')]");
	By ankerLinks=By.xpath("//div[@id='header']//div//a[contains(@id,'mn-lnk')]");
	By myHomeLinks = By.id("mn-lnk-2");
	By txtJobTitleId = By.id("fts_id");
	By drpExpId=By.id("selExp");
	By txtLocation=By.id("lmy");
	By btnFindBetter = By.xpath("//input[@value='Find Better']");
	By textTopJobs = By.xpath("//span[@class='txt lft']");
			//By.linkText("Top Jobs");
			//By.xpath("//section[@id='bodysection']//div[contains(@class,'tp_jobhead')]//span[contains(@class,'txt')]");
	
	By btnSingIN = By.xpath("//div[@id='header']//div[@class='txtbig']");
	//Constructor
	public MonsterIndiaHomePage(WebDriver driver) 
	{
	this.driver=driver;	
	}
	/**
	 * This method helps us to find the site Logo
	 * @return boolean
	 * @param No param
	 * @throws Exception
	 */
	public boolean isSiteLogoDisplayed() throws Exception
	{
		try 
		{
			flag = driver.findElement(siteImage).isDisplayed();
			if (flag) 
			{
			System.out.println("Monster Flag is displayed in Home Page");	
			}			
			else
			{
				System.out.println("Monster Flag is not displayed in Home Page");
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("Master Flag not displayed in Home page::"+isSiteLogoDisplayed()+e.getLocalizedMessage());
		}
		return flag;
	}
	/** To verify a links count in the Page header
	 * @return integer
	 * @param No param
	 * @throws Exception 
	 */
	public int verifyanckerLinksCount() throws Exception
	{
		try 
		{
			list=driver.findElements(ankerLinks);
			count = list.size();
			if (count==actualaCount)
			{
			System.out.println("Expected and Actual Links Counts are Same:"+count);	
			}
			else
			{
				System.out.println("Actual Links are:"+count + "But expected links are:"+actualaCount);
			}
							
		} 
		catch (Exception e) 
		{
		throw new Exception("Expected and Actual Link counts are not same::"+verifyanckerLinksCount());	
		}
		
		return count;
	}
	/**
	 * Display the Page header Anker Link Text details
	 * @return String
	 * @param No Parm
	 * @throws Exception
	 */
	public String ankerLinkText() throws Exception
	{
		try 
		{
			list = driver.findElements(ankerLinks);
			count = list.size();
			for (int i = 0; i <= count; i++)
			{
				actualList=list.get(i);
				outPutValue = actualList.getText();
				System.out.println("Anker Link details are:"+outPutValue);
			}
			
		} 
		catch (Exception e) 
		{
			//Getting Exception here, Need to Check with Manju
			throw new Exception("Not showing the Anker Header Text:"+ankerLinkText);
		}
		return ankerLinkText;
	}
	/**Count the total links in 'My Manster' page
	 * @param No Param
	 * @return Integer
	 * @throws Showing Error, need to check
	 */
	public int myMonsterLinks()
	{
		try 
		{
			actualList=null;
			count=0;
			actualList = driver.findElement(myHomeLinks);
			act = new Actions(driver);
			//act.moveToElement(actualList);
			//Thread.sleep(3000);
			act.click().build().perform();
			list=null;
			list = driver.findElements(By.xpath("//div[@id='mn-navdd-2']/div[contains(@class,'ddnavinnr ')]"));
			count = list.size();
			System.out.println(count);
			
		} 
		catch (Exception e) 
		{
			
		}
		return myMonsterLinks();
	}
	/**To check Job Title Text box is displayed and Enabled
	 * @return boolean;
	 * @param No Param
	 * @throws Exception
	 */
	public boolean isJobTitleTextBoxDisplayed() throws Exception
	{
		try
		{
		flag = driver.findElement(txtJobTitleId).isDisplayed() && driver.findElement(txtJobTitleId).isEnabled();
		if (flag)
		{
		System.out.println("Job Title TextBox is Displayed and it is Enabled");	
		}
		else
		{
			System.out.println("Job Title Text Box is either Not displayed OR Not Enabled");
		}
		}
		catch(Exception e)
		{
			throw new Exception("Job title text box is not displayed/enabled:"+isJobTitleTextBoxDisplayed()+e.getLocalizedMessage());
		}
		return flag;
	}
	/**
	 * To Verify Location text box status
	 * @return boolean
	 * @param No param
	 * @throws Exception
	 */
	public boolean isLocationTextBoxDisplayed() throws Exception
	{
		try 
		{
		flag=driver.findElement(txtLocation).isDisplayed() && driver.findElement(txtLocation).isEnabled();
		if (flag)
		{
		System.out.println("Location Drop Down text box is Displayed and Enabled");	
		}
		else
		{
			System.out.println("Location Drop Down text box is Not Displayed OR Enabled");
		}
		}
		catch (Exception e) 
		{
			throw new Exception("Location text box is Not Enabled/Displayed:"+isLocationTextBoxDisplayed()+e.getLocalizedMessage());
		}
		return flag;
	}
	/**
	 * To check Find Better check Box is displayed.
	 * @return boolean
	 * @param No param
	 * @throws Exception
	 */
	public boolean clickOnFindBetter(){
		try {
			actualList = driver.findElement(btnFindBetter);
			flag = actualList.isDisplayed();
			Assert.assertTrue("Find button is not displayed", flag);
			} 
		catch (Exception e) 
		{
			
		}
		
		return flag;
	}
	/**
	 * to validate the Top Job Section in Monster Home page
	 * @return String
	 * @throws Exception
	 * @param No param
	 */
	public boolean verifyTopJobs()throws Exception
	 
	{
		try 
		{
		homePageTab = driver.findElement(textTopJobs);
		//Assert.assertEquals(expectedTopJobstext, homePageTab,"Tops Jobs Section not present");
		if (homePageTab.equals(expectedTopJobstext)) 
		{
		System.out.println("Top Jobs section is Present");	
		}
		else
		{
		System.out.println("Top Jobs section is not present");
		}
		}
		catch (Exception e)
		{
			throw new Exception("TopJob Section Not Present:"+verifyTopJobs()+expectedTopJobstext+e.getLocalizedMessage());
		}
		return flag;
		
	}
	
	/**
	 * to Verify SignIn button present in the Home Page
	 * @return boolean
	 * @throws Exception
	 * @param No Param
	 */
	public boolean isSingInButtonPresent() throws Exception
	{
		try 
		{
			flag = driver.findElement(btnSingIN).isDisplayed() && driver.findElement(btnSingIN).isEnabled();
			Assert.assertTrue("SingIn Button Not Present",flag);
			
		} catch (Exception e)
		{
			throw new Exception("Sign-In button Not Present/Enabled:"+isSingInButtonPresent()+e.getLocalizedMessage());
		}
		return flag;
	}
}
