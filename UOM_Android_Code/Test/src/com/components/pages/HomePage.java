
package com.components.pages;

import java.util.Set;

import org.openqa.jetty.http.SSORealm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;


public class HomePage extends SitePage{
	
	
	/* Defining the locators on the Page */ 
	public static final Target selectAcc = new Target("selectAcc","//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]",Target.XPATH);
	public static final Target HamMenu = new Target("HamburgerMenu","//*[@id='hamburger-nav']//*[@class='mm-o-icon icon-menu']",Target.XPATH);
	public static final Target HamLogout = new Target("HamLogout","//*[@class='mm-c-menu__logout']",Target.XPATH);


   
	public HomePage(SiteRepository repository)
	{
		super(repository);
	}
	
	
	

	/* Functions on the Page are defined below */
	
	public HomePage atHomePage()
	{
		log("Launched Sysco UOM homepage",LogType.STEP);
		
		System.out.println("home pge");
		return this;
		
	}
	
	
	
	public HomePage HamburgerMenu(String string)
	{
		log("Tapping on Hamburger menu",LogType.STEP);
		 String string1="Success";
		  String string2="Issue";
        
         String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
		  String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
		try{
				 
			getCommand().waitForTargetPresent(HamMenu);
			
			if (getCommand().isTargetPresent(HamMenu))
			{
				System.out.println("got menu");
				getCommand().click(HamMenu);
				getCommand().waitFor(5);
			}
			log("Navigating to menu page :Pass",LogType.VERIFICATION_STEP);
		}
	
		catch(Exception e)
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath1);
			log("Navigating to menu page :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	
	public HomePage HamMenu_Logout(String string)
	{
		log("Tapping on Logout from Hamburger menu",LogType.STEP);
		  String finalPath=GlobalVariable.drivePath+string+GlobalVariable.string1+GlobalVariable.pathExtension;
	      String finalPath1=GlobalVariable.drivePath+string+GlobalVariable.string2+GlobalVariable.pathExtension;
			
		try{
	       getCommand().waitForTargetPresent(HamLogout);
			
			if (getCommand().isTargetPresent(HamLogout))
			{
				log("Tap on Inventory Tool from Hamburger menu",LogType.STEP);	
				getCommand().click(HamLogout);
				System.out.println("Logout tapped");
				log("Logout :Pass",LogType.VERIFICATION_STEP);					
			}
	
		}
		
	
		catch(Exception e)
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		   getCommand().captureScreenshot(finalPath1);
			log("Logout :Fail",LogType.VERIFICATION_STEP);
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
			System.out.println("clicked accnt");
			log("Clicked  account :Pass",LogType.VERIFICATION_STEP);
			}	
}
		}
		catch(Exception e)
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath1);
			log("Clicked  account :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	


}