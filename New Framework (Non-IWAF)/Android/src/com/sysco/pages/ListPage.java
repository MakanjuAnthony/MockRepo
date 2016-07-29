		
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

import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.Reporter;

import com.sysco.jsn_framework.JSN_Framework;
import com.sysco.locators.Screenshot;

public class ListPage extends JSN_Framework {

	private static final Logger LOGGER= Logger.getLogger(ListPage.class.getCanonicalName());
	public static final String SetUp_Pg1Title =
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Import Items')]";
	public static final String CustomList = 
			"//*[@type='button' and contains(text(),'Custom List')]";

	public static final String Continue =
			"//*[@class='btn btn-default' and contains(text(),'Continue')]";
	public static final String Category_Header =
			"//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3";
	public static final String Next =  "//*[@id='next-nav']/a";
	
	/* Functions on the Page are defined below */
	@SuppressWarnings("rawtypes")
	public ListPage TapCustomList(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Selecting custom list  ");

		try {

			waitForElementPresent(SetUp_Pg1Title);
			waitForElementPresent(CustomList);
			clickElement(CustomList);

			Reporter.log("Selected  custom list  from SetupInventoryImportItems:Pass");

		} catch (Exception e) {
			Reporter.log("Selected  custom list  from SetupInventoryImportItems :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public ListPage tapContinue(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			waitForElementPresent(Continue);
			clickElement(Continue);

			Reporter.log("Tapped on Continue :Pass");
		}

		catch (Exception e) {
			Reporter.log("Tapped on Continue :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public ListPage SelectListwithItems(String name, String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Selecting list");
		try {
			String listName = name;

			waitFor(5);
			final String Listname =
					"//*[@class='mm-c-simplelist__item list-group-item']//*[contains(text(),'" + listName
							+ "')]/ancestor::button[@class='mm-c-simplelist__item list-group-item']/child::i[@class='mm-o-icon icon-uncheck-circle']";
					

			clickElement(Listname);

			Reporter.log("List is selected :Pass");
		}

		catch (Exception e) {
			Reporter.log("List is selected   :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("unused")
	public ListPage TapOnNext(String string) throws InterruptedException, IOException {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = Screenshot.drivePath + string + string1 + Screenshot.pathExtension;
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitForElementPresent(Next);
			if (isElementPresent(Next)) {
				clickElement(Next);
			}

		} catch (Exception e) {
			Reporter.log("Tapped on Next :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}
}
