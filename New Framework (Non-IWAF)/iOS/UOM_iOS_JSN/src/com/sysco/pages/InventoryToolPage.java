		
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


public class InventoryToolPage extends JSN_Framework {
	private static final Logger LOGGER= Logger.getLogger(InventoryToolPage.class.getCanonicalName());
	
	public static final String InvTool_SetUpInv = "//*[@id='menu-item']/a/div/span[contains(text(),'Setup Inventory')]";
	public static final String TrackInventory = "//*[@id='menu-item']/a/div/span[contains(text(),'Track Inventory')]";
	public static final String LocationsPage = "//*[@class='navbar-brand']//*[contains(text(),'Locations')]";
	public static final String PurchasesPage = "//*[@class='navbar-brand']//*[contains(text(),'Purchases')]";
	public static final String InvTool_Vendors = "//*[@id='menu-item']/a/div/span[contains(text(),'Suppliers')]";
	public static final String InvTool_Purchases = "//*[@id='menu-item']/a/div/span[contains(text(),'Purchases')]"; 
	public static final String InvTool_Locations = "//*[@id='menu-item']/a/div/span[contains(text(),'Locations')]";
	public static final String VendorsPage = "//*[@class='navbar-brand']//*[contains(text(),'Suppliers')]";
	public static final String InvTool_Category = "//*[@id='menu-item']/a/div/span[contains(text(),'Expense Categories')]";
	public static final String CategoriesPage = "//*[@class='navbar-brand']//*[contains(text(),'Expense Categories')]";
	public static final String InvTool_CreatePrepItem ="//*[@id='menu-item']/a/div/span[contains(text(),'Create Prep Item')]";
	public static final String AddProduct_Page ="//*[@class='navbar-brand']//*[contains(text(),'Add Product')]";
	public static final String InvTool_CreateNonSyscoItem = "//*[@id='menu-item']/a/div/span[contains(text(),'Create Non-Sysco Item')]";
	public static final String  InvTool_CloseInventory= "//*[@id='menu-item']//span[contains(text(),'Close Inventory')]";  
	 public static final String  InvTool_CloseInventoryYes= "//*[@id='yes-button']";  
	 public static final String  InvTool_CloseInventoryOK= "//*[@id='yes-button' and contains(text(),'Ok! Sounds Good')]";  
	 public static final String  InvTool_FoodCost= "//*[@id='menu-item']//span[contains(text(),'View Food Cost')]";   
	 public static final String  InvTool_FoodCostsPage= "//*[@class='navbar-brand']//*[contains(text(),'Food Costs')]";   
	
	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_SetUpInventory(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			waitForElementPresent(InvTool_SetUpInv);
			clickElement(InvTool_SetUpInv);
			Reporter.log("Navigating to Setup inventory page :Pass");

		} catch (Exception e) {
			Reporter.log("Navigating to Setup inventory page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_TrackInventory(String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitForElementPresent(TrackInventory);

			if (isElementPresent(TrackInventory)) {
				clickElement(TrackInventory);
				waitForElementPresent(LocationsPage);
				waitFor(2);

				Reporter.log("Tapped  TrackInventory from inventory tools page:Pass");
			}

		} catch (Exception e) {
			Reporter.log("Tapped  TrackInventory from inventory tools page:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	
	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_Suppliers(String string) throws InterruptedException, IOException {
		Reporter.log("Tapping on Suppliers from Inventory tools page");

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitFor(5);
			waitForElementPresent(InvTool_Vendors);

			if (isElementPresent(InvTool_Vendors)) {
				Reporter.log("Tap on Suppliers from Inventory tools page");
				clickElement(InvTool_Vendors);

			}
			waitForElementPresent(VendorsPage);

			if (isElementPresent(VendorsPage)) {
				Reporter.log("In Vendors Page");
				Reporter.log("Navigating to Vendors page :Pass");

			}

		}

		catch (Exception e) {
			Reporter.log("Navigating to Vendors  page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_Purchases(String string) throws InterruptedException, IOException {

		Reporter.log("Selecting purchases from inventory tools page ");

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			waitForElementPresent(InvTool_Purchases);

			if (isElementPresent(InvTool_Purchases)) {
				clickElement(InvTool_Purchases);

				Reporter.log("Tapped  purchases from inventory tools page:Pass");
			}

		} catch (Exception e) {
			Reporter.log("Tapped  purchases from inventory tools page:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
		
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_Locations(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			waitForElementPresent(InvTool_Locations);
			if (isElementPresent(InvTool_Locations)) {
				clickElement(InvTool_Locations);

			}

			waitForElementPresent(LocationsPage);

			if (isElementPresent(LocationsPage)) {
				Reporter.log("In locations Page");
				Reporter.log("Navigating to Locations page :Pass");
			}
		} catch (Exception e) {
			Reporter.log("Navigating to Locations page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_Category(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			waitForElementPresent(InvTool_Category);
			if (isElementPresent(InvTool_Category)) {

				clickElement(InvTool_Category);

			}

			waitForElementPresent(CategoriesPage);

			if (isElementPresent(CategoriesPage)) {
				Reporter.log("In categories Page");
				Reporter.log("Navigating to categories page :Pass");
			}
		} catch (Exception e) {
			Reporter.log("Navigating to categories page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_CreatePrep(String string) throws InterruptedException, IOException {

		Reporter.log("Selecting Create Nonsysco item from inventory tools page ");

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			waitForElementPresent(InvTool_CreatePrepItem);

			if (isElementPresent(InvTool_CreatePrepItem)) {
				clickElement(InvTool_CreatePrepItem);
				waitForElementPresent(AddProduct_Page);

				Reporter.log("Tapped Create Prep Item from inventory tools page:Pass");
			}

		} catch (Exception e) {
			Reporter.log("Tapped Create Prep Item from inventory tools page:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public InventoryToolPage InvTools_CreateNonSysco(String string) throws InterruptedException, IOException {

		Reporter.log("Selecting Create Nonsysco item from inventory tools page ");

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			waitForElementPresent(InvTool_CreateNonSyscoItem);

			if (isElementPresent(InvTool_CreateNonSyscoItem)) {
				clickElement(InvTool_CreateNonSyscoItem);
				waitForElementPresent(AddProduct_Page);

				Reporter.log("Tapped Create NonSysco Item from inventory tools page:Pass");
			}

		} catch (Exception e) {
			Reporter.log("Tapped Create NonSysco Item from inventory tools page:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
public  InventoryToolPage InvTools_CloseInventory(String string) throws InterruptedException, IOException{
		
		Reporter.log("Selecting closeinventory from inventory tools page ");
		  String string2="Issue";
		 
	    String finalPath1=drivePath+string+string2+Screenshot.pathExtension;
	    
	    try{
	    	  waitForElementPresent(InvTool_CloseInventory);
		
		
			clickElement(InvTool_CloseInventory);
			System.out.println("clicking closeinv");
			waitForElementPresent(InvTool_CloseInventoryYes);
			
			Reporter.log("Tapped  closeinventory from inventory tools page:Pass");						
		
		
	}
		catch(Exception e){
			Reporter.log("Tapped  closeinventory from inventory tools page:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
		
			Assert.assertTrue(false);
			
		}
		
		return this;
		
	}



	public  InventoryToolPage InvTools_ClosedInventoryYes(String string) throws InterruptedException, IOException{
		
		Reporter.log("Selecting Yes ");
		   String string2="Issue";
		 
	     String finalPath1=drivePath+string+string2+Screenshot.pathExtension;
	    
	    try{
	    	 		
		
		waitForElementPresent(InvTool_CloseInventoryYes);
	
			clickElement(InvTool_CloseInventoryYes);
			System.out.println("clicking yes");
			waitForElementPresent(InvTool_CloseInventoryOK);
			clickElement(InvTool_CloseInventoryOK);
			
			Reporter.log("Closed inventory successfully :Pass");						
		
		
	}
		catch(Exception e){
			Reporter.log("Closed inventory successfully :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
			
		}
		
		return this;
		
	}

	public  InventoryToolPage InvTools_FoodCost(String string) throws InterruptedException, IOException{
		
		Reporter.log("Selecting closeinventory from inventory tools page ");
		  String string2="Issue";
		 
	     String finalPath1=drivePath+string+string2+Screenshot.pathExtension;
	    
	    try{
	    			waitForElementPresent(InvTool_FoodCost);
		
		
			clickElement(InvTool_FoodCost);
			System.out.println("clicking foodcost");
			waitForElementPresent(InvTool_FoodCostsPage);
			
			Reporter.log("Tapped  closeinventory from inventory tools page:Pass");						
		
		
	}
		catch(Exception e){
			Reporter.log("Tapped  closeinventory from inventory tools page:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
			
		}
		
		return this;
		
	}

}
