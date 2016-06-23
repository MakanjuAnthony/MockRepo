
package com.components.pages;

import java.util.Set;

import org.openqa.jetty.http.SSORealm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;


public class HomePage extends SitePage{
	
	
	/* Defining the locators on the Page */ 
	public static final Target HamMenuNormaluser = new Target("HamMenuNormaluser","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[5]",Target.XPATH);
	public static final Target HamMenu = new Target("HamburgerMenu","//*[@id='hamburger-nav']//*[@class='mm-o-icon icon-menu']",Target.XPATH);
	public static final Target Menu_InvTools = new Target("Menu_InvTools","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]",Target.XPATH);
	public static final Target Menu_Home= new Target("Menu_Home","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]",Target.XPATH);
	public static final Target Menu_Vendors= new Target("Menu_Vendors","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[3]",Target.XPATH);
	public static final Target InvToolsPage = new Target("InvToolsPage","//UIAStaticText[@label='Inventory Tools']",Target.XPATH);
	public static final Target HamLogout = new Target("HamLogout","//*[@class='mm-c-menu']//*[@id='logout']",Target.XPATH);
	
	public static final Target VendorsPage = new Target("VendorsPage","//UIAStaticText[@label='Vendors']",Target.XPATH);
	public static final Target selectAcc = new Target("selectAcc","//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]",Target.XPATH);
	 

   
	public HomePage(SiteRepository repository)
	{
		super(repository);
	}
	
	
	

	/* Functions on the Page are defined below */
	
	public HomePage atHomePage()
	{
		log("Homepage displayed",LogType.STEP);
		return this;
		
	}
	
	
	
	public HomePage HamburgerMenu(String string)
	{
		 String string1="Success";
		  String string2="Issue";
        
         String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
		  String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
		try{
				 
			getCommand().waitForTargetPresent(HamMenu);
			
			if (getCommand().isTargetPresent(HamMenu))
			{getCommand().click(HamMenu);
				getCommand().waitFor(5);
			}
			log("Navigating to menu page :Pass",LogType.VERIFICATION_STEP);
		}
	
		catch(Exception e)
		{
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath1);
			log("Navigating to menu page :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	public HomePage HamMenu_Vendors()
	{
		
		
		try{
			
			
			getCommand().waitForTargetPresent(Menu_Vendors);
		
			
				log("Tap on Vendor from Hamburger menu",LogType.STEP);	
				getCommand().click(Menu_Vendors);
				System.out.println("vendrs pge");
			
			getCommand().waitForTargetPresent(VendorsPage);
			
			if (getCommand().isTargetPresent(VendorsPage))
			{
				System.out.println("in vendors page");
				log("Navigating to Vendors page :Pass",LogType.VERIFICATION_STEP);	
										
			}
			
			
		}
		
	
		catch(Exception e)
		{
			log("Navigating to Vendors  page :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	
	public HomePage HamMenu_Logout(String string)
	{
			
		try{
	       getCommand().waitForTargetPresent(HamLogout);
			
			if (getCommand().isTargetPresent(HamLogout))
			{
				getCommand().click(HamLogout);
				log("Tapped on Logout from Hamburger menu :Pass",LogType.VERIFICATION_STEP);					
			}
	
		}
		
	
		catch(Exception e)
		{
			log("Tapped on Logout from Hamburger menu :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}

	
	public HomePage ClickAccount(String str1,String string)
	{
	
		  String finalPath=GlobalVariable.drivePath+string+GlobalVariable.string1+GlobalVariable.pathExtension;
	      String finalPath1=GlobalVariable.drivePath+string+GlobalVariable.string2+GlobalVariable.pathExtension;
			
		
		try{	
			
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002")) ){
				if (getCommand().isTargetPresent(selectAcc))
			{
			getCommand().click(selectAcc);
			log("Clicked  account :Pass",LogType.VERIFICATION_STEP);
			}	
}
		}
		catch(Exception e)
		{
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			  getCommand().captureScreenshot(finalPath1);
			log("Clicked  account :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	


	

	
	
}