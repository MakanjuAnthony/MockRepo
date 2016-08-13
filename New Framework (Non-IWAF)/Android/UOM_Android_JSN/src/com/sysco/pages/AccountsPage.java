package com.sysco.pages;
		
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

import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.Reporter;

import com.sysco.jsn_framework.JSN_Framework;
import com.sysco.locators.Screenshot;


public class AccountsPage extends JSN_Framework{
	
	private static final Logger LOGGER= Logger.getLogger(AccountsPage.class.getCanonicalName());
	
	public static final String Menu_Account ="//*[@id='accounts']";
	public static final String Accounts_Page = "//*[@class='navbar-brand']//*[contains(text(),'Accounts')]";
	public static final String Accounts_1Account = "//*[@id='list-item'][1]";	
	public static final String Accounts_2Account =  "//*[@id='list-item'][2]";	
	public static final String Accounts_3Account = "//*[@id='list-item'][3]";	
	public static final String Accounts_4Account =  "//*[@id='list-item'][4]";		
	public static final String Accounts_5Account =  "//*[@id='list-item'][5]";		
	public static final String Accounts_6Account = "//*[@id='list-item'][6]";	
	public static final String InventoryToolsPage_Accountinfo = "//*[@id='mount']/div/div/div[2]/nav/div/div/span/h4/a";
	public static final String HamburgerMenu = "//*[@id='hamburger-nav']";
	public static final String InvToolsPage = "//*[@class='navbar-brand']//*[contains(text(),'Inventory Tools')]";
	public static final String selectAcc = "//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]";
	public static final String account_None = "//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]";
	public String T_AccountInfo;
	public String F_AccountInfo;
	public String FfAccountInfo;
	public String SxAccountInfo;
	public String SecondAccountInfo;
	public String FirstAccountInfo;
	public static final String FirstAccounts = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]";
	public static final String SecondAccounts = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[3]";
	public static final String accountID = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[5]";
	public String firstAccount;
	public String secondAccount;

	/* Functions on the Page are defined below */

	@SuppressWarnings("rawtypes")
	public AccountsPage HamMenu_Accounts(String string) throws InterruptedException, IOException {
		String finalPath1 = Screenshot.drivePath + string + Screenshot.string2 + Screenshot.pathExtension;

		try {
			waitForElementToBeClickable(Menu_Account);
			clickElement(Menu_Account);
			waitForElementToBeClickable(Accounts_Page);
			Reporter.log("Account page displayed :Pass");
		}
		catch (Exception e) {
			Reporter.log("Account page displayed :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public AccountsPage Third_AccountSelection(String str1, String string) throws InterruptedException, IOException {
		String finalPath1 = Screenshot.drivePath + string + Screenshot.string2 + Screenshot.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {
				waitForElementToBeClickable(Accounts_3Account).clickElement(Accounts_3Account);
				
				
				if (isElementPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					T_AccountInfo = getElementText(InventoryToolsPage_Accountinfo);
				}
			}
		} catch (Exception e) {
			Reporter.log("Got 3rd account information :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);

		}
		return this;

	}
	
	@SuppressWarnings("rawtypes")
	public AccountsPage Fourth_AccountSelection(String str1, String string) throws InterruptedException, IOException {

		String finalPath1 = Screenshot.drivePath + string + Screenshot.string2 + Screenshot.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {
				waitForElementToBeClickable(Accounts_4Account);
				clickElement(Accounts_4Account);
				waitFor(5);
				if (isElementPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					F_AccountInfo = getElementText(InventoryToolsPage_Accountinfo);
				}
				Reporter.log("Got 4th account information :Pass");
			}
		} catch (Exception e) {
			Reporter.log("Got 4th account information :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public AccountsPage Fifth_AccountSelection(String str1, String string) throws InterruptedException, IOException {
		String finalPath1 = Screenshot.drivePath + string + Screenshot.string2 + Screenshot.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {
				waitForElementToBeClickable(Accounts_5Account);
				clickElement(Accounts_5Account);
				waitFor(5);
				if (isElementPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					FfAccountInfo = getElementText(InventoryToolsPage_Accountinfo);
				}
				Reporter.log("Got 5th account information :Pass");
			}
		} catch (Exception e) {
			Reporter.log("Got 5th account information :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);

		}
		return this;

	}
	
	@SuppressWarnings("rawtypes")
	public AccountsPage Sixth_AccountSelection(String str1, String string) throws InterruptedException, IOException {
		String finalPath1 = Screenshot.drivePath + string + Screenshot.string2 + Screenshot.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {
				clickElement(Accounts_6Account);
				waitFor(5);
				if (isElementPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					SxAccountInfo = getElementText(InventoryToolsPage_Accountinfo);
				}
				Reporter.log("Got 6th account information :Pass");
			}
		} catch (Exception e) {
			Reporter.log("Got 6th account information :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);

		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage clickElementAccount(String string) throws InterruptedException, IOException {
		String finalPath1 = Screenshot.drivePath + string + Screenshot.string2 + Screenshot.pathExtension;

		try {
			if (isElementPresent(selectAcc)) {
				clickElement(selectAcc);
				Reporter.log("clickElemented select account :Pass");
			}
		} catch (Exception e) {
			Reporter.log("clickElemented select account :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage First_AccountSelection(String str1, String string) throws InterruptedException, IOException {
		String finalPath1 = Screenshot.drivePath + string + Screenshot.string2 + Screenshot.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("sqsauser32")) || (str1.equalsIgnoreCase("sqsauser33"))) {
				waitForElementToBeClickable(Accounts_1Account).clickElement(Accounts_1Account);
				if (isElementPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					T_AccountInfo = getElementText(InventoryToolsPage_Accountinfo);
				}
				Reporter.log("Got 1st account information :Pass");
			}
		}

		catch (Exception e) {
			Reporter.log("Got 1st account information :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public AccountsPage Second_AccountSelection(String str1, String string) throws InterruptedException, IOException {
		String finalPath1 = Screenshot.drivePath + string + Screenshot.string2 + Screenshot.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("sqsauser32")) || (str1.equalsIgnoreCase("sqsauser33"))) {
				waitForElementToBeClickable(Accounts_2Account).clickElement(Accounts_2Account);
				if (isElementPresentAfterWait(InventoryToolsPage_Accountinfo, 30)) {
					T_AccountInfo = getElementText(InventoryToolsPage_Accountinfo);
				}
				Reporter.log("Got 2nd account information :Pass");
			}
		} catch (Exception e) {
			Reporter.log("Got 2nd account information :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}
		return this;
	}
}
