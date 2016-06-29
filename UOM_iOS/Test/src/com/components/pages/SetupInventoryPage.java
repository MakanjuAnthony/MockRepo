		
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

import java.util.Set
;

import io.appium.java_client.ios.IOSDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class SetupInventoryPage extends SitePage {

	public static final Target SetUp_Pg1Title = new Target(
			"SetUp_Pg1Title",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Import Items')]",
			Target.XPATH);
	public static final Target StartFromScratch = new Target(
			"StartFromScratch",
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'Start From Scratch')]",
			Target.XPATH);
	public static final Target OrderGuide = new Target("OrderGuide",
			"//*[@type='button' and contains(text(),'Order Guide')]",
			Target.XPATH);

	public static final Target Continue = new Target("Continue",
			"//*[@class='btn btn-default' and contains(text(),'Continue')]",
			Target.XPATH);
	public static final Target AddItems_Scratch = new Target(
			"AddItems_Scratch",
			"//*[@class='btn-default btn btn-default' and contains(text(),'Add Items')]",
			Target.XPATH);
	public static final Target AddItemFromPage_Scratch = new Target(
			"AddItemFromPage_Scratch",
			"//*[@class='navbar-brand']//*[contains(text(),'Add Item From')]",
			Target.XPATH);
	public static final Target OrderGuidePage = new Target("OrderGuidePage",
			"//*[@class='navbar-brand']//*[contains(text(),'Order Guide')]",
			Target.XPATH);
	public static final Target OrderGuide_FirstItemSelect = new Target(
			"OrderGuide_FirstItemSelect",
			"(//*[@id='mount']//*[@class='mm-o-icon'])[1]", Target.XPATH);
	public static final Target OrderGuide_1stItemHeading = new Target(
			"OrderGuide_1stItemHeading",
			"(//*[@class='mm-c-product-list']//*[@class='mm-c-product-minlist__item'])[1]/h4",
			Target.XPATH);
	public static final Target Done = new Target("DoneWeb",
			"//UIAStaticText[@label='Done']", Target.XPATH);
	public static final Target Return = new Target("Return",
			"//UIAStaticText[@label='Return']", Target.XPATH);
	public static final Target TakeMeHome = new Target(
			"TakeMeHome",
			"//*[@class='btn btn-default' and contains(text(),'Take me Home')]",
			Target.XPATH);
	public static final Target Category_Header = new Target("Category_Header",
			"//*[@id='mount']//*[@class='navbar-brand']/h3", Target.XPATH);

	public static final Target AddItem_OrderGuide = new Target("OrderGuide",
			"//*[@id='list-item']//*[contains(text(),'Browse Order Guide')]",
			Target.XPATH);

	public static final Target AddItem_NonSyscoItem = new Target(
			"AddItem_NonSyscoItem",
			"//*[@id='list-item']//*[contains(text(),'Create Non-Sysco Item')]",
			Target.XPATH);
	public static final Target SetUp_Pg2Title = new Target(
			"SetUp_Pg1Title",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'SETUP LOCATIONS')]",
			Target.XPATH);

	public static final Target AddItem_PrepItem = new Target(
			"AddItem_PrepItem",
			"//*[@id='list-item']//*[contains(text(),'Create Prep Item')]",
			Target.XPATH);
	public static final Target AddProduct_Page = new Target("AddProduct_Page",
			"//*[@class='navbar-brand']//*[contains(text(),'Add Product')]",
			Target.XPATH);
	public static final Target AddProductPage_AddSupplier = new Target(
			"AddProductPage_AddSupplier",
			"//*[@class='row']//*[contains(text(),'Add/Select Supplier')]",
			Target.XPATH);

	public static final Target AddProductPage_ProductName = new Target(
			"AddProductPage_ProductName", "//*[@id='name']", Target.XPATH);
	public static final Target AddProductPage_UPC = new Target(
			"AddProductPage_UPC", "//*[@id='materialId']", Target.XPATH);
	public static final Target AddProductPage_Pack = new Target(
			"AddProductPage_Pack", "//*[@id='pack']", Target.XPATH);
	public static final Target AddProductPage_Size = new Target(
			"AddProductPage_Size", "//*[@id='size']", Target.XPATH);
	public static final Target AddProductPage_Weight = new Target(
			"AddProductPage_Weight", "//*[@id='averageWeightPerCase']",
			Target.XPATH);
	public static final Target AddProductPage_Price = new Target(
			"AddProductPage_Price", "//*[@id='price']", Target.XPATH);
	public static final Target AddProductPage_ProductBrand = new Target(
			"AddProductPage_ProductBrand ", "//*[@id='brand']", Target.XPATH);

	public static final Target OrderGuide_FirstItemHeader = new Target(
			"Category_FirstItemSelect",
			"//*[@id='mount']/div/div[2]/div[1]/div/div/div[1]/div/div[2]/h4",
			Target.XPATH);
	public static String ItemName;
	public static String SearchItemName;

	public static final Target SetUp_Pg3Title = new Target("SetUp_Pg3Title",
			"//UIAStaticText[@label='SET UP FOOD COST']", Target.XPATH);
	public static final Target SkipStep_TrackFoodCostPg = new Target(
			"SkipStep_TrackFoodCostPg",
			"//UIAStaticText[@label='Skip This Step']", Target.XPATH);
	public static final Target FoodAndNonFood = new Target("FoodAndNonFood",
			"//UIAButton[@label='Food & Non-Food']", Target.XPATH);
	public static final Target SuggestedCategories = new Target(
			"SuggestedCategories",
			"//UIAButton[@label='Suggested Categories']", Target.XPATH);
	public static final Target CustomCategories = new Target(
			"CustomCategories", "//UIAButton[@label='Custom Categories']",
			Target.XPATH);
	public static final Target InvToolsPg = new Target("InvToolsPg",
			"//UIAStaticText[@label='Inventory Tools']", Target.XPATH);

	public static String CategoryName;
	public static String ItemNameSelected;
	public static String ItemNameAdded;

	public static final Target setupInventryFirstProduct = new Target(
			"Category_FirstItemHeader",
			"//*[@id='content-container']/div/div/div[1]/div/div/div/div/div[3]/h4",
			Target.XPATH);

	public static final Target OrderGuide_1stItemSelect = new Target(
			"OrderGuide_1stItemSelect",
			"(//*[@class='mm-c-product-list']//*[@class='mm-o-icon'])[1]",
			Target.XPATH);
	public static final Target OrderGuide_2ndItemSelect = new Target(
			"OrderGuide_2ndItemSelect",
			"(//*[@class='mm-c-product-list']//*[@class='mm-o-icon'])[2]",
			Target.XPATH);
	public static final Target OrderGuide_3rdItemSelect = new Target(
			"OrderGuide_3rdItemSelect",
			"(//*[@class='mm-c-product-list']//*[@class='mm-o-icon'])[3]",
			Target.XPATH);

	public static final Target OrderGuide_2ndItemHeading = new Target(
			"OrderGuide_2ndItemHeading",
			"(//*[@class='mm-c-product-list']//*[@class='mm-c-product-minlist__item'])[2]/h4",
			Target.XPATH);
	public static final Target OrderGuide_3rdItemHeading = new Target(
			"OrderGuide_3rdItemHeading",
			"(//*[@class='mm-c-product-list']//*[@class='mm-c-product-minlist__item'])[3]/h4",
			Target.XPATH);

	public static final Target SetUpInventory_ItemsAddedViaOrderGuide = new Target(
			"SetUpInventory_ItemsAddedViaOrderGuide",
			"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='Grid__cell']",
			Target.XPATH);

	public static int noOfElements = 0;
	public static String ItemName1;
	public static String ItemName2;
	public static String ItemName3;
	public static String ItemAdded = null;
	public static final Target FirstItemSelectedFromUncatgorised = new Target(
			"FirstItemSelectedFromUncatgorised",
			"(//*[@id='content-container']//*[@class='mm-o-icon'])[2]",
			Target.XPATH);
	public static final Target FirstItemSelectedFromUncatgorisedHeading = new Target(
			"FirstItemSelectedFromUncatgorised",
			"(//*[@id='content-container']//*[@class='mm-c-product-list__details-wrapper'])[2]/h4",
			Target.XPATH);

	public static final Target FirstItemSelectedFromUncatgorisedAllItemsString = new Target(
			"FirstItemSelectedFromUncatgorised",
			"//*[@id='content-container']//*[@class='mm-c-product-list__details-wrapper']/h4",
			Target.XPATH);
	public static final Target AddProductPage_ModalWindowForAddSupplierYes = new Target(
			"AddProductPage_ModalWindowForAddSupplierYes",
			"//*[@class='modal-content']//*[@id='yes-button']", Target.XPATH);

	public static final Target AddItemsLink = new Target(
			"AddItemsLink",
			"//*[@class='mm-c-product-list__sticky-row mm-u-navbar-padding']//span[contains(text(),'Add More Items')]",
			Target.XPATH);
	public static final Target AddItemFromPage_PrepItemWeb = new Target(
			"AddItemFromPage_PrepItem",
			"//*[@id='list-item' and contains(text(),'Prep Item')]",
			Target.XPATH);
	public static final Target Skip = new Target("Skip", "//*[@id='skip']/a",
			Target.XPATH);
	public static final Target Search = new Target("Search",
			"//*[@placeholder='Search']", Target.XPATH);

	public static final Target AddProductPage_AddLocations = new Target(
			"AddProductPage_AddLocations",
			"//*[@class='row']//*[contains(text(),'Add/Select Location(s)')]",
			Target.XPATH);
	public static final Target AddProductPage_AddCategory = new Target(
			"AddProductPage_AddCategory",
			"//*[@class='row']//*[contains(text(),'Add/Select Expense Category')]",
			Target.XPATH);
	public static final Target DoThisLater = new Target("DoThisLater",
			"//*[contains(text(),'Do This Later')]", Target.XPATH);

	public static final Target ReadyToTrack = new Target(
			"ReadyToTrack",
			"//*[@class='btn btn-default']//*[contains(text(),'Ready to track your inventory?')]",
			Target.XPATH);
	public static final Target ReadyToStart = new Target(
			"ReadyToStart",
			"//*[@class='btn btn-default']//*[contains(text(),'ready to get started')]",
			Target.XPATH);
	public static final Target Next = new Target("next", "//*[@id='next']",
			Target.XPATH);
	public static final Target CustomList = new Target("CustomList",
			"//*[@type='button' and contains(text(),'Custom List')]",
			Target.XPATH);
	public static String keyword;
	public static String[] searchKeyword;

	public static String AddedItemId;
	public static String[] AddedItemId1;
	public static String[] AddedItemId1_1;
	public static String[] AddedItemId1_2;
	public static String[] AddedItemId1_3;
	public static final Target SuccessMsg1 = new Target("SuccessMsg1",
			"//*[contains(text(),'Congratulations!')]", Target.XPATH);
	public static final Target SuccessMsg2 = new Target(
			"SuccessMsg2",
			"//*[contains(text(),'You have completed setting up your inventory.')]",
			Target.XPATH);
	public static final Target SuccessMsg3 = new Target(
			"SuccessMsg3",
			"//*[contains(text(),'Your inventory can be accessed at any time from the inventory tools homepage. You can add items, track your inventory, enter purchases, and view food costs and trends.')]",
			Target.XPATH);

	public static final Target OrderGuideDesc = new Target(
			"OrderGuideDesc",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Import from purchase history')]",
			Target.XPATH);
	public static final Target CustomListsDesc = new Target(
			"CustomListsDesc",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Use my custom lists to import items and locations')]",
			Target.XPATH);
	public static final Target StartFromScratchDesc = new Target(
			"StartFromScratchDesc",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Add items manually')]",
			Target.XPATH);
	VendorPage vp = new VendorPage(repository);

	public SetupInventoryPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public SetupInventoryPage atSetupInventoryPage() {
		log("Opened SetupInventory Page ", LogType.STEP);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage StartFromScratch(String string) {
		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
			try {

			getCommand().waitForTargetPresent(SetUp_Pg1Title);
			getCommand().waitForTargetPresent(StartFromScratch);
			getCommand().click(StartFromScratch);

			log("Tapped on Start from Scratch :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on Start from Scratch :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage tapContinue(String string) {
		String string2 = "Issue";
			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			getCommand().waitForTargetPresent(Continue);
			getCommand().click(Continue);

			log("Tapped on Continue :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on Continue :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage Setup_AddItemsLink(String string) {
		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			getCommand().waitForTargetPresent(AddItemsLink);
			getCommand().click(AddItemsLink);

			log("Tapped on add items link :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on add items link :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage Scratch_AddItems(String string) {

		String string2 = "Issue";

			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			getCommand().waitForTargetPresent(AddItems_Scratch);
			getCommand().click(AddItems_Scratch);
			getCommand().waitForTargetPresent(AddItemFromPage_Scratch);

			log("Tapping on add items button from setup inventory page :Pass",
					LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapping on add items button from setup inventory page :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage AddItemFrom_NonSysco(String string) {

	
		String string2 = "Issue";
String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(AddItemFromPage_Scratch);

			if (getCommand().isTargetPresent(AddItem_NonSyscoItem)) {

				getCommand().click(AddItem_NonSyscoItem);

				getCommand().waitForTargetPresent(AddProduct_Page);
				log("Nonsysco item selected from add item from page :Pass",
						LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);

			log("Nonsysco item selected from add item from page  :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage AddItemFrom_PrepItem(String string) {

		String string2 = "Issue";

			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(AddItemFromPage_Scratch);

			if (getCommand().isTargetPresent(AddItem_PrepItem)) {

				getCommand().click(AddItem_PrepItem);

				getCommand().waitForTargetPresent(AddProduct_Page);
				log("Prep item selected from add item from page :Pass",
						LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);

			log("Prep item selected from add item from page  :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage AddItemFrom_OrderGuide(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(AddItem_OrderGuide);

			if (getCommand().isTargetPresent(AddItem_OrderGuide)) {

				getCommand().click(AddItem_OrderGuide);

				getCommand().waitForTargetPresent(Category_Header);

				log("Order Guide Click : Pass", LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Order Guide Click : Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage SelectItemFrom_OrderGuide(String string) {
		String string2 = "Issue";

			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(Category_Header);

			if (getCommand().isTargetPresent(OrderGuide_FirstItemSelect)) {
				getCommand().click(OrderGuide_FirstItemSelect);

				ItemName1 = getCommand().getText(OrderGuide_1stItemHeading);
	final Target keyword1 = new Target(
						"keyword1",
						"//*[@class='mm-c-product-minlist__item']//*[contains(text(),'"
								+ ItemName1
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']",
						Target.XPATH);
				AddedItemId = getCommand().getText(keyword1);
				AddedItemId1_1 = AddedItemId.split("\\s+");
				
				log("First item selected Order Guide  :Pass",
						LogType.VERIFICATION_STEP);

			} else
				log("Order Guide Items not available",
						LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("First item selected Order Guide :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage verifyOGItemsOnSetupInv(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

				final Target SetUpInventory_1stItemHeading = new Target(
					"OrderGuide_1stItemHeading",
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ SetupInventoryPage.AddedItemId1_1[0] + "')]",
					Target.XPATH);
			getCommand().waitFor(10);
			Boolean boolean1 = getCommand().isTargetPresent(
					SetUpInventory_1stItemHeading);

			if (boolean1)

				log("Item Found in Setup Inventory:Pass",
						LogType.VERIFICATION_STEP);
			else {
				Assert.assertTrue(false);
			}

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item Found in Setup Inventory:Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public SetupInventoryPage verifySearchItemsOnSetupInv(String string) {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = SitePage.drivePath + string + string1
				+ SitePage.pathExtension;
		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			if (getCommand().isTargetPresent(Category_Header)) {

				final Target SetUpInventory_1stItemHeading = new Target(
						"OrderGuide_1stItemHeading",
						"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
								+ SearchItemName + "')]", Target.XPATH);

				getCommand().waitFor(10);
				Boolean boolean1 = getCommand().isTargetPresent(
						SetUpInventory_1stItemHeading);

				if (boolean1)

					log("Item Found in Setup Inventory:Pass",
							LogType.VERIFICATION_STEP);
				else {
					log("Item Found in Setup Inventory:Fail",
							LogType.VERIFICATION_STEP);
					Assert.assertTrue(false);
				}

			}
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item Found in Setup Inventory:Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public SetupInventoryPage TapOnDone(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().waitForTargetPresent(Done);
			if (getCommand().isTargetPresent(Done)) {

				getCommand().click(Done);
				log("Tapped on done:Pass", LogType.VERIFICATION_STEP);

				Set<String> contextNames1 = ((IOSDriver) getCommand().driver)
						.getContextHandles();
				System.out.println("contxtname is " + contextNames1);

				for (String contextName : contextNames1) {
					System.out.println("inside loop " + contextNames1);
				}
				System.out.println(((IOSDriver) getCommand().driver)
						.context((String) contextNames1.toArray()[1]));

			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("Tapped on done :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage EnterItemDetails(String name, String upc,
			String pack, String size, String weight, String price,
			String brand, String string) {
		String string2 = "Issue";

	String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		log("Entering details of Nonsysco item", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(AddProductPage_ProductName);
			if (getCommand().isTargetPresent(AddProductPage_ProductName)) {

				log("Entering Product name", LogType.STEP);
				getCommand().click(AddProductPage_ProductName);

				getCommand().sendKeys(AddProductPage_ProductName, name);
			}

			getCommand().waitForTargetPresent(AddProductPage_UPC);
			if (getCommand().isTargetPresent(AddProductPage_UPC)) {
				log("Entering Product id", LogType.STEP);
				getCommand().click(AddProductPage_UPC);

				getCommand().sendKeys(AddProductPage_UPC, upc);
			}
			if (getCommand().isTargetPresent(AddProductPage_Pack)) {
				log("Entering Pack", LogType.STEP);
				getCommand().click(AddProductPage_Pack);

				getCommand().sendKeys(AddProductPage_Pack, pack);
			}
			if (getCommand().isTargetPresent(AddProductPage_Size)) {
				log("Entering size", LogType.STEP);
				getCommand().click(AddProductPage_Size);

				getCommand().sendKeys(AddProductPage_Size, size);
			}
			if (getCommand().isTargetPresent(AddProductPage_Weight)) {
				log("Entering weight", LogType.STEP);
				getCommand().click(AddProductPage_Weight);

				getCommand().sendKeys(AddProductPage_Weight, weight);
			}

			if (getCommand().isTargetPresent(AddProductPage_Price)) {
				log("Entering Price", LogType.STEP);
				getCommand().click(AddProductPage_Price);

				getCommand().sendKeys(AddProductPage_Price, price);
			}
			if (getCommand().isTargetPresent(AddProductPage_ProductBrand)) {
				log("Entering Product brand", LogType.STEP);
				getCommand().click(AddProductPage_ProductBrand);

				getCommand().sendKeys(AddProductPage_ProductBrand, brand);
			}

			getCommand().waitFor(2);
			log("Item details are entered :Pass", LogType.VERIFICATION_STEP);

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item details are entered  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage AddSupplier_AddProductDetailsPage(String string) {

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			getCommand().waitForTargetPresent(AddProductPage_AddSupplier);
			if (getCommand().isTargetPresent(AddProductPage_AddSupplier)) {
				getCommand().click(AddProductPage_AddSupplier);
			}
			log("Selected supplier : Pass", LogType.STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected supplier :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage TapOrderGuide(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(SetUp_Pg1Title);
			getCommand().waitForTargetPresent(OrderGuide);
			getCommand().click(OrderGuide);

			log("Selected  orderguide  from SetupInventoryImportItems:Pass",
					LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected  orderguide  from SetupInventoryImportItems :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage verifyNonSyscoPrepItemSetupInv(String product,
			String string) {
			String string2 = "Issue";

			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			final Target SetUpInventory_1stItemHeading = new Target(
					"NonSyscoItem",
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ product + "')]", Target.XPATH);

			getCommand().waitFor(10);
			Boolean boolean1 = getCommand().isTargetPresent(
					SetUpInventory_1stItemHeading);
			if (boolean1) {
				log("Item Found in Setup Inventory:Pass",
						LogType.VERIFICATION_STEP);
			} else {
				throw new Exception();
			}

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item Found in Setup Inventory:Fail", LogType.VERIFICATION_STEP);

			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage NonSysco_Prompt(String string) {
		String string2 = "Issue";
			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {
			getCommand().waitForTargetPresent(AddProduct_Page);
			if (getCommand().isTargetPresent(AddProductPage_ProductName)) {
				getCommand().waitForTargetPresent(AddProductPage_ProductName);
				getCommand().waitForTargetPresent(AddProductPage_UPC);
				getCommand().waitForTargetPresent(AddProductPage_Pack);

				getCommand().waitForTargetPresent(AddProductPage_Size);

				getCommand().waitForTargetPresent(AddProductPage_Pack);

				getCommand().waitForTargetPresent(AddProductPage_Weight);

				// getCommand().waitForTargetPresent(AddProductPage_Price);

				getCommand().waitForTargetPresent(AddProductPage_ProductBrand);

				// getCommand().waitForTargetPresent(AddProductPage_Option);

				getCommand().waitForTargetPresent(AddProductPage_AddSupplier);

				log("Nonsysco item details are present in page :Pass",
						LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Nonsysco item details are present in page :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage skipfoodcost(String string) {
		log("Skipping foodcost", LogType.STEP);
		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(SetUp_Pg3Title);
			getCommand().waitForTargetPresent(SkipStep_TrackFoodCostPg);
			getCommand().click(SkipStep_TrackFoodCostPg);

			getCommand().waitForTargetPresent(InvToolsPg);

			log("Skipping foodcost :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Skipping foodcost:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage NonSyscoItem_AddSupplierSelectAlertYes(
			String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		log("Updating non sysco item details", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(
					AddProductPage_ModalWindowForAddSupplierYes);
			getCommand().click(AddProductPage_ModalWindowForAddSupplierYes);
			log("Non sysco item details-Add supplier Modal window-Yes :Pass",
					LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Non sysco item details-Add supplier Modal window-Yes :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage verifyNonSysco_AddedPdtSupplier(String name,
			String string) {

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			String vendorName = name;

			final Target VD_Vendorname = new Target(
					"VD_Vendorname",
					"//*[@id='mount']//*[@class='mm-c-product-details__supplier' and contains(text(),'"
							+ vendorName + "')]", Target.XPATH);

			if (getCommand().isTargetPresent(VD_Vendorname)) {

				log("Vendor is selected on Non sysco Add product page:Pass",
						LogType.VERIFICATION_STEP);

			} else {
				log("Vendor is selected on Non sysco Add product page   :Fail",
						LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Vendor is selected on Non sysco Add product page   :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage skipOrderGuide(String string) {
	
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(SetUp_Pg3Title);
			getCommand().waitForTargetPresent(SkipStep_TrackFoodCostPg);
			getCommand().click(SkipStep_TrackFoodCostPg);

			getCommand().waitForTargetPresent(InvToolsPg);

			log("Skip order guide :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Skip order guide :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage TapOnSkip(String string) {

			String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitFor(2);
			getCommand().waitForTargetPresent(Skip);
			getCommand().click(Skip);
			log("Tapped on skip :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on skip :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage SearchItem(String keyword, String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(Search);
			getCommand().click(Search);
			getCommand().sendKeys(Search, keyword);

			((IOSDriver) getCommand().driver).findElement(
					By.xpath("//*[@placeholder='Search']"))
					.sendKeys(Keys.ENTER);

			CategoryName = getCommand().getText(Category_Header);

			log("Search item :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Search item :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage TapOnDOThisLater(String string) {

			String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(DoThisLater);
			getCommand().click(DoThisLater);
			log("Tapped on DoThisLater :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on DoThisLater :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage ReadytoStart(String string) {

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(Next);
			getCommand().click(Next);
			log("Tapped on Ready to track :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on Ready to track :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage TapTakeHome(String string) {
		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {
			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(SuccessMsg1);
			System.out.println(getCommand().getText(SuccessMsg1));

			getCommand().waitForTargetPresent(SuccessMsg2);
			System.out.println(getCommand().getText(SuccessMsg2));
			getCommand().waitForTargetPresent(SuccessMsg3);
			System.out.println(getCommand().getText(SuccessMsg3));

			getCommand().waitForTargetPresent(TakeMeHome);
			getCommand().click(TakeMeHome);
			log("Tapped on TakeHome :Pass", LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {

			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on TakeHome :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage SelectMultipleItemsFrom_OrderGuide(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			log(" Adding Item from Order Guide", LogType.STEP);

			getCommand().waitForTargetPresent(Category_Header);
			getCommand().waitFor(2);
			CategoryName = getCommand().getText(Category_Header);
			noOfElements = 0;

			if (getCommand().isTargetPresent(OrderGuide_1stItemSelect)) {
				noOfElements++;
				getCommand().click(OrderGuide_1stItemSelect);
				ItemName1 = getCommand().getText(OrderGuide_1stItemHeading);
				final Target keyword1 = new Target(
						"keyword1",
						"//*[@class='mm-c-product-minlist__item']//*[contains(text(),'"
								+ ItemName1
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']",
						Target.XPATH);
				AddedItemId = getCommand().getText(keyword1);
				AddedItemId1_1 = AddedItemId.split("\\s+");
				
			}
			if (getCommand().isTargetPresent(OrderGuide_2ndItemSelect)) {

				noOfElements++;
				getCommand().click(OrderGuide_2ndItemSelect);
				ItemName2 = getCommand().getText(OrderGuide_2ndItemHeading);
				final Target keyword1 = new Target(
						"keyword1",
						"//*[@class='mm-c-product-minlist__item']//*[contains(text(),'"
								+ ItemName2
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']",
						Target.XPATH);
				AddedItemId = getCommand().getText(keyword1);
				AddedItemId1_2 = AddedItemId.split("\\s+");
				
			}

			if (getCommand().isTargetPresent(OrderGuide_3rdItemSelect)) {
				noOfElements++;
				getCommand().click(OrderGuide_3rdItemSelect);
				ItemName3 = getCommand().getText(OrderGuide_3rdItemHeading);
				final Target keyword1 = new Target(
						"keyword1",
						"//*[@class='mm-c-product-minlist__item']//*[contains(text(),'"
								+ ItemName3
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']",
						Target.XPATH);
				AddedItemId = getCommand().getText(keyword1);
				AddedItemId1_3 = AddedItemId.split("\\s+");
					}

				log("Multiple items selected :Pass", LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Multiple items selected :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public SetupInventoryPage verifyMultipleItemsfromOGonSetUpInv(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			System.out.println(AddedItemId1_1[0]);
			System.out.println(AddedItemId1_2[0]);
			System.out.println(AddedItemId1_3[0]);

			final Target SetUpInventory_1stItemHeading = new Target(
					"OrderGuide_1stItemHeading",
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ AddedItemId1_1[0] + "')]", Target.XPATH);
			final Target SetUpInventory_2ndItemHeading = new Target(
					"OrderGuide_2ndItemHeading",
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ AddedItemId1_2[0] + "')]", Target.XPATH);
			final Target SetUpInventory_3rdItemHeading = new Target(
					"OrderGuide_3rdItemHeading",
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ AddedItemId1_3[0] + "')]", Target.XPATH);

			getCommand().waitFor(10);
			Boolean boolean1 = getCommand().isTargetPresent(
					SetUpInventory_1stItemHeading);
			Boolean boolean2 = getCommand().isTargetPresent(
					SetUpInventory_2ndItemHeading);
			Boolean boolean3 = getCommand().isTargetPresent(
					SetUpInventory_3rdItemHeading);
			LocationsPage.count = 0;

			int count = 0;
			if (boolean1) {
				LocationsPage.count++;

			}
			if (boolean2) {
				LocationsPage.count++;

			}
			if (boolean3) {
				LocationsPage.count++;

			}

			if (noOfElements == LocationsPage.count) {

				log("All Three Items Found in Setup Inventory :Pass",
						LogType.VERIFICATION_STEP);
			} else {
				throw new Exception();
			}

			log("All three Items Found in Setup Inventory :Pass",
					LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("Items Found in Setup Inventory:Fail",
					LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage SearchKeyword(String string) {

			String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(Search);
			getCommand().click(Search);
			getCommand().sendKeys(Search, AddedItemId1_2[0]);

			log("Searching using keyword :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Searching using keyword :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage verifyKeywordSearchItems(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			final Target SearchCheck = new Target("SearchCheck",
					"((//*[@class='mm-c-product-list__item mm-c-product__sysco ']//*[@class='mm-c-product-list__row-wrapper']//*[@class='mm-c-product-list__description'])[1])//*[contains(text(),'"
							+ AddedItemId1_2[0] + "')]",
					Target.XPATH);

			Boolean boolean1 = getCommand().isTargetPresent(SearchCheck);

			if (boolean1) {
				log("Item Found in location:Pass", LogType.VERIFICATION_STEP);
			} else {
				log("Item Found in location:Fail", LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item Found in in location:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage VerifyOptionsOnImportItems(String string) {

			String string2 = "Issue";
			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			if (getCommand().isTargetPresent(OrderGuide)
					&& getCommand().isTargetPresent(OrderGuideDesc)
					&& getCommand().isTargetPresent(CustomList)
					&& getCommand().isTargetPresent(CustomListsDesc)
					&& getCommand().isTargetPresent(StartFromScratch)
					&& getCommand().isTargetPresent(StartFromScratchDesc)) {
				} else {
				throw new Exception();
			}

			log("Import item page verification done :Pass",
					LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Import item page verification done  :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public SetupInventoryPage SelectItemFrom_Catalog(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(Category_Header);

			if (getCommand().isTargetPresent(OrderGuide_FirstItemSelect)) {
				getCommand().click(OrderGuide_FirstItemSelect);

				SearchItemName = getCommand()
						.getText(OrderGuide_1stItemHeading);

				final Target keyword1 = new Target(
						"keyword1",
						"//*[@class='mm-c-product-minlist__item']//*[contains(text(),'"
								+ SearchItemName
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']",
						Target.XPATH);
				AddedItemId = getCommand().getText(keyword1);
				AddedItemId1 = AddedItemId.split("\\s+");
			
				log("First item selected from pdt catalog  :Pass",
						LogType.VERIFICATION_STEP);

			}

			else {
				log("Catalog Items not available", LogType.VERIFICATION_STEP);
				((IOSDriver) getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
				log("Catalog Item Found in Setup Inventory:Fail",
						LogType.VERIFICATION_STEP);
				Set<String> contextNames1 = ((IOSDriver) getCommand().driver)
						.getContextHandles();
				for (String contextName : contextNames1) {
				}
				((IOSDriver) getCommand().driver)
						.context((String) contextNames1.toArray()[1]);

				vp.TapOnBack("Pressback1");
				vp.TapOnBack("pressback2");
			}

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("First item selected from pdt catalog :Fail",
					LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage verifyItemDescriptionSearch(String keyword,
			String string) {
			String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;
		try {

			final Target SearchCheck = new Target("SearchCheck",
					"//*[@id='content-container']//*[@class='navbar-header']//*[contains(text(),'"
							+ keyword + "')]", Target.XPATH);

			Boolean boolean1 = getCommand().isTargetPresent(SearchCheck);

			if (boolean1) {
				log("verifyItemDescriptionSearch:Pass",
						LogType.VERIFICATION_STEP);
			} else {
				log("verifyItemDescriptionSearch:Fail",
						LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("verifyItemDescriptionSearch:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public SetupInventoryPage VerifyProductID_Location(String string) {
		String string2 = "Issue";

			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			final Target keyword1 = new Target(
					"keyword1",
					"(//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__description'])[1]",
					Target.XPATH);
			AddedItemId = getCommand().getText(keyword1);
				AddedItemId1 = AddedItemId.split("\\s+");
		
			log("Product ID verified  :Pass", LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Product ID verified  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}
}