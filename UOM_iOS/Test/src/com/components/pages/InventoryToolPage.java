		
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
package com.components.pages;

import io.appium.java_client.ios.IOSDriver;



import org.testng.Assert;

import com.components.repository.SiteRepository;

import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class InventoryToolPage extends SitePage {

	public static final Target InvTool_SetUpInv = new Target("InvTool_SetUpInv",
			"//*[@id='menu-item']/a/div/span[contains(text(),'Setup Inventory')]", Target.XPATH);
	public static final Target TrackInventory = new Target("TrackInventory",
			"//*[@id='menu-item']/a/div/span[contains(text(),'Track Inventory')]", Target.XPATH);
	public static final Target LocationsPage = new Target("LocationsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Locations')]", Target.XPATH);
	public static final Target PurchasesPage = new Target("InvToolsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Purchases')]", Target.XPATH);
	public static final Target InvTool_Vendors = new Target("InvTool_Vendors",
			"//*[@id='menu-item']/a/div/span[contains(text(),'Suppliers')]", Target.XPATH);
	public static final Target InvTool_Purchases = new Target("InvTool_Purchases",
			"//*[@id='menu-item']/a/div/span[contains(text(),'Purchases')]", Target.XPATH); 
	public static final Target InvTool_Locations = new Target("InvTool_Locations",
			"//*[@id='menu-item']/a/div/span[contains(text(),'Locations')]", Target.XPATH);
	public static final Target VendorsPage = new Target("VendorsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Suppliers')]", Target.XPATH);
	public static final Target InvTool_Category = new Target("InvTool_Category",
			"//*[@id='menu-item']/a/div/span[contains(text(),'Expense Categories')]", Target.XPATH);
	public static final Target CategoriesPage = new Target("CategoriesPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Expense Categories')]", Target.XPATH);
	public static final Target InvTool_CreatePrepItem = new Target("InvTool_CreatePrepItem",
			"//*[@id='menu-item']/a/div/span[contains(text(),'Create Prep Item')]", Target.XPATH);
	public static final Target AddProduct_Page = new Target("AddProduct_Page",
			"//*[@class='navbar-brand']//*[contains(text(),'Add Product')]", Target.XPATH);
	public static final Target InvTool_CreateNonSyscoItem = new Target("InvTool_CreateNonSyscoItem",
			"//*[@id='menu-item']/a/div/span[contains(text(),'Create Non-Sysco Item')]", Target.XPATH);

	public InventoryToolPage(SiteRepository repository) {
		super(repository);

	}

	public InventoryToolPage atInventoryToolPage(String string) {
		log("Opened InventoryTool Page ", LogType.STEP);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_SetUpInventory(String string) {
		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;
		try {

			getCommand().waitForTargetPresent(InvTool_SetUpInv);
			getCommand().click(InvTool_SetUpInv);
			log("Navigating to Setup inventory page :Pass", LogType.VERIFICATION_STEP);

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Navigating to Setup inventory page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_TrackInventory(String string) {

		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(TrackInventory);

			if (getCommand().isTargetPresent(TrackInventory)) {
				getCommand().click(TrackInventory);
				getCommand().waitForTargetPresent(LocationsPage);
				getCommand().waitFor(2);

				log("Tapped  TrackInventory from inventory tools page:Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped  TrackInventory from inventory tools page:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	
	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_Suppliers(String string) {
		log("Tapping on Suppliers from Inventory tools page", LogType.STEP);

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {

			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(InvTool_Vendors);

			if (getCommand().isTargetPresent(InvTool_Vendors)) {
				log("Tap on Suppliers from Inventory tools page", LogType.STEP);
				getCommand().click(InvTool_Vendors);

			}
			getCommand().waitForTargetPresent(VendorsPage);

			if (getCommand().isTargetPresent(VendorsPage)) {
				log("In Vendors Page", LogType.STEP);
				log("Navigating to Vendors page :Pass", LogType.VERIFICATION_STEP);

			}

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Navigating to Vendors  page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_Purchases(String string) {

		log("Selecting purchases from inventory tools page ", LogType.STEP);

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(InvTool_Purchases);

			if (getCommand().isTargetPresent(InvTool_Purchases)) {
				getCommand().click(InvTool_Purchases);

				log("Tapped  purchases from inventory tools page:Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped  purchases from inventory tools page:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_Locations(String string) {

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(InvTool_Locations);
			if (getCommand().isTargetPresent(InvTool_Locations)) {
				getCommand().click(InvTool_Locations);

			}

			getCommand().waitForTargetPresent(LocationsPage);

			if (getCommand().isTargetPresent(LocationsPage)) {
				log("In locations Page", LogType.STEP);
				log("Navigating to Locations page :Pass", LogType.VERIFICATION_STEP);
			}
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Navigating to Locations page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_Category(String string) {

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(InvTool_Category);
			if (getCommand().isTargetPresent(InvTool_Category)) {

				getCommand().click(InvTool_Category);

			}

			getCommand().waitForTargetPresent(CategoriesPage);

			if (getCommand().isTargetPresent(CategoriesPage)) {
				log("In categories Page", LogType.STEP);
				log("Navigating to categories page :Pass", LogType.VERIFICATION_STEP);
			}
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Navigating to categories page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_CreatePrep(String string) {

		log("Selecting Create Nonsysco item from inventory tools page ", LogType.STEP);

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(InvTool_CreatePrepItem);

			if (getCommand().isTargetPresent(InvTool_CreatePrepItem)) {
				getCommand().click(InvTool_CreatePrepItem);
				getCommand().waitForTargetPresent(AddProduct_Page);

				log("Tapped Create Prep Item from inventory tools page:Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped Create Prep Item from inventory tools page:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_CreateNonSysco(String string) {

		log("Selecting Create Nonsysco item from inventory tools page ", LogType.STEP);

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(InvTool_CreateNonSyscoItem);

			if (getCommand().isTargetPresent(InvTool_CreateNonSyscoItem)) {
				getCommand().click(InvTool_CreateNonSyscoItem);
				getCommand().waitForTargetPresent(AddProduct_Page);

				log("Tapped Create NonSysco Item from inventory tools page:Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped Create NonSysco Item from inventory tools page:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

}
