		
		/**
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 *																																		   	*
		 * 2016-2017 Infosys Limited, Banglore, India. All Rights Reserved																			*

		 * Version: 1.0																																*
		 * 																																			*
		 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
		 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
		 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
		 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
		 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
		 * and will be prosecuted to the maximum extent possible under the law 																		*
		 *																																			*
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 **/
package com.sysco.pages;
import java.io.IOException;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.Reporter;

import com.sysco.jsn_framework.JSN_Framework;
import com.sysco.locators.Screenshot;


public class HomePage extends JSN_Framework{
	
	private static final Logger LOGGER= Logger.getLogger(HomePage.class.getCanonicalName());
	
	/* Defining the locators on the Page */ 
//	public static final String HamMenuNormaluser = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[5]";
	public static final String HamMenu = "//*[@id='hamburger-nav']//*[@class='mm-o-icon icon-menu']";
//	public static final String Menu_InvTools ="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]";
//	public static final String Menu_Home= "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]";
//	public static final String Menu_Vendors= "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[3]";
//	public static final String InvToolsPage = "//UIAStaticText[@label='Inventory Tools']";
	public static final String HamLogout = "//*[@class='mm-c-menu']//*[@id='logout']";
//	public static final String VendorsPage = "//UIAStaticText[@label='Vendors']";
	public static final String selectAcc = "//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]";


	/* Functions on the Page are defined below */

	@SuppressWarnings("rawtypes")
	public HomePage HamburgerMenu(String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
		  String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		try{ 
			waitForElementToBeClickable(HamMenu);
			
			if (isElementPresent(HamMenu))
			{clickElement(HamMenu);
				waitFor(5);
			}
			Reporter.log("Navigating to menu page :Pass");
		}
	
		catch(Exception e)
		{
			Reporter.log("Navigating to menu page :Fail");
			switchToNativeContext(); 
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
		
	
	}

	public HomePage HamMenu_Logout(String string)
	{
			
		try{
	       waitForElementToBeClickable(HamLogout);
			
			if (isElementPresent(HamLogout))
			{
				clickElement(HamLogout);
				Reporter.log("Tapped on Logout from Hamburger menu :Pass");					
			}
	
		}
		
	
		catch(Exception e)
		{
			Reporter.log("Tapped on Logout from Hamburger menu :Fail");
			Assert.assertTrue(false);
		}
		return this;
		
	
	}

	
	@SuppressWarnings("rawtypes")
	public HomePage ClickAccount(String str1,String string) throws InterruptedException, IOException
	{
	      String finalPath1=Screenshot.drivePath+string+Screenshot.string2+Screenshot.pathExtension;
			
		
		try{	
			
			if ((str1.equalsIgnoreCase("sqsauser32")) || (str1.equalsIgnoreCase("sqsauser33")) ){
				if (isElementPresent(selectAcc))
			{
			clickElement(selectAcc);
			Reporter.log("clickElemented  account :Pass");
			}	
}
		}
		catch(Exception e)
		{
			Reporter.log("clickElemented  account :Fail");
			switchToNativeContext(); 
			  takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	


	

	
	
}