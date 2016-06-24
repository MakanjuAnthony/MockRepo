		
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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.Set;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class LocationsPage extends SitePage {

	public static final Target NewLocation = new Target("LocationName",
			"//*[@class='mm-c-customlocation__setup-form']//*[@name='formFields[0].name']", Target.XPATH);
	public static final Target LocationCooler = new Target("LocationCooler",
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[1]", Target.XPATH);
	public static final Target Next = new Target("Next", "//UIAStaticText[@label='Next']", Target.XPATH);
	public static final Target SetUp_Pg2Title = new Target("SetUp_Pg2Title",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Setup Locations')]", Target.XPATH);
	public static final Target DefaultLocation = new Target("DefaultLocation",
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'Default')]", Target.XPATH);
	public static final Target CustomLocations = new Target("CustomLocations",
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'Custom Locations')]", Target.XPATH);
	public static final Target Continue = new Target("Continue",
			"//*[@class='btn btn-default' and contains(text(),'Continue')]", Target.XPATH);
	public static final Target Done = new Target("DoneWeb", "//UIAStaticText[@label='Done']", Target.XPATH);

	public static final Target Location_FirstItemSelect = new Target("LocationName",
			"(//*[@class='mm-c-product-list__details-wrapper'])[1]/h4", Target.XPATH);
	public static final Target Location_FirstItem = new Target("LocationName",
			"(//*[@class='checkbox']//*[@class='mm-o-icon'])[1]", Target.XPATH);
	public static final Target LocationsPage_Header = new Target("LocationName", "//*[@class='navbar-brand']/h3",
			Target.XPATH);

	public static final Target OrderGuide_FirstItemSelect = new Target("Category_FirstItemSelect",
			"(//*[@id='mount']//*[@class='mm-o-icon'])[1]", Target.XPATH);
	public static String Location1ItemSelected;
	public static String Location1ItemAdded;
	public static final Target Location_FirstItemAdded = new Target("LocationName",
			"//*[@id='mount']/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/div[2]/div[2]/h4", Target.XPATH);

	public static final Target AddLocation_LocName = new Target("ADDLocation_LocName", "//*[@id='name']", Target.XPATH);
	public static final Target AddLocation_LocTypeCoolerWeb = new Target("ADDLocation_LocTypeCooler",
			"(//*[@class='mm-c-location__details-radio']//*[@class='radio'])[1]", Target.XPATH);

	public static final Target AddWeb = new Target("ADD_Vendor", "//*[@id='add-nav']/a/i", Target.XPATH);
	public static final Target EditWeb = new Target("Edit", "//*[@id='edit-nav']/a/i", Target.XPATH);
	public static final Target AddLocation_LocTypeCooler = new Target("LocationDry",
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]", Target.XPATH);

	public static final Target AddLocation_LocTypeFreezer = new Target("LocationDry",
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]", Target.XPATH);

	public static final Target Back = new Target("Back", "//*[@id='back-nav']/a/i", Target.XPATH);

	public static final Target ADD_AnotherLocation = new Target("LocationName",
			"//*[@class='mm-c-customlocation__setup-cta']//*[contains(text(),'Add Another Location')]", Target.XPATH);
	public static final Target LocType_Dry1 = new Target("LocationName",
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]", Target.XPATH);
	public static final Target LocType_Dry1T2 = new Target("LocationName",
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]//*[@type='radio']",
			Target.XPATH);

	public static final Target LocType_Dry2 = new Target("LocationName",
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]", Target.XPATH);
	public static final Target LocType_Dry2T1 = new Target("LocationName",
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]/label", Target.XPATH);
	public static final Target LocType_Dry2T2 = new Target("LocationName",
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]//*[@type='radio']",
			Target.XPATH);
	public static final Target ADD_LocationName = new Target("LocationName", "//*[@id='name']", Target.XPATH);
	public static final Target ADD_LocTypeDry = new Target("LocationName", "//*[@value='D']", Target.XPATH);
	public static final Target ADD_LocationName1 = new Target("LocationName",
			"//*[@class='mm-c-customlocation__setup-form']//*[@name='formFields[0].name']", Target.XPATH);
	public static final Target SetupInventoryLocationUncategorizedTab = new Target("SetupInventoryCustomLoc_LocName",
			"//*[@id='mount']//*[@class='mm-c-productList--pill-right']/a", Target.XPATH);

	public static final Target SetupInventoryLocationAllItemsTab = new Target("SetupInventoryCustomLoc_LocName",
			"//*[@id='mount']//*[@class='mm-c-productList--pill-left']/a", Target.XPATH);
	public static String Location2ItemSelected;
	public static String value = "3.8";
	public static String value2 = "4";

	public static String locationInputTextBox = "//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"
			+ value + "']";
	public static String locationInputTextBox2 = "//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"
			+ value2 + "']";
	public static final Target LocationItem1_InputTextBox = new Target("LocationItem1_InputTextBox",
			"//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control']",
			Target.XPATH);
	public static final Target LocationItem1_InputTextBoxCheck = new Target("LocationItem1_InputTextBoxCheck",
			locationInputTextBox, Target.XPATH);
	public static final Target LocationItem2_InputTextBoxCheck = new Target("LocationItem1_InputTextBoxCheck",
			locationInputTextBox2, Target.XPATH);
	public static String Location2ItemAdded;
	public static final Target BackWeb = new Target("Back",
			"//*[@class='nav navbar-nav']//*[@role='presentation']//*[@class='mm-o-icon icon-chevron-left']",
			Target.XPATH);

	public static final Target Locator_firstLocname = new Target("Locator_firstLocname",
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]", Target.XPATH);
	public static final Target EditBtnLocDetailsPg = new Target("Edit",
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]/UIALink[1]/UIAStaticText[1]",
			Target.XPATH);
	public static final Target LocationFreezer = new Target("LocationFreezer",
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[3]", Target.XPATH);
	public static final Target LocationDry = new Target("LocationCooler",
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]", Target.XPATH);
	public static final Target Update = new Target("Update", "//UIAStaticText[@label='Update']", Target.XPATH);
	public static final Target Delete = new Target("Back",
			"//*[@id='delete-button' and contains(text(),'Delete Location')]", Target.XPATH);
	public static final Target YesDelete = new Target("Back",
			"//*[@id='yes-button' and contains(text(),'Yes, Delete')]", Target.XPATH);

	public static final Target AddItem_OrderGuide = new Target("OrderGuide",
			"//*[@type='button']//span[contains(text(),'Add From Order Guide')]", Target.XPATH);
	public static final Target Category_Header = new Target("Category_Header",
			"//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3", Target.XPATH);

	public static final Target LocationsDone = new Target("LocationsDone",
			"//*[@type='button' and contains(text(),'Done')]", Target.XPATH);
	public static final Target AddProductPage_AddLocations = new Target("AddProductPage_AddLocations",
			"//*[@class='row']//*[contains(text(),'Add/Select Location(s)')]", Target.XPATH);
	public static final Target ProductDetailsPage = new Target("ProductDetailsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Product Details')]", Target.XPATH);

	public static final Target Locations_1stItemSelect = new Target("Locations_1stItemSelect",
			"(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[1]", Target.XPATH);
	public static final Target Locations_2ndItemSelect = new Target("Locations_2ndItemSelect",
			"(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[2]", Target.XPATH);
	public static final Target Locations_3rdItemSelect = new Target("Locations_3rdItemSelect",
			"(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[3]", Target.XPATH);
	public static final Target Locations_1stItemHeading = new Target("Locations_1stItemHeading",
			"(//*[@class='mm-c-product-minlist__item']/h4)[1]", Target.XPATH);
	public static final Target Locations_2ndItemHeading = new Target("Locations_2ndItemHeading",
			"(//*[@class='mm-c-product-minlist__item']/h4)[2]", Target.XPATH);
	public static final Target Locations_3rdItemHeading = new Target("Locations_3rdItemHeading",
			"(//*[@class='mm-c-product-minlist__item']/h4)[3]", Target.XPATH);

	public static String LocationsItemName1_1;
	public static String LocationsItemName1_2;
	public static String LocationsItemName1_3;

	public static String LocationsItemName2_1;
	public static String LocationsItemName2_2;
	public static String LocationsItemName2_3;

	public static int locationsNoOfElements1;
	public static int locationsNoOfElements2;

	public static String LocationsItemPresent1_1;
	public static String LocationsItemPresent1_2;
	public static String LocationsItemPresent1_3;
	public static String LocationsItemName1_4;

	public static String LocationsItemPresent2_1;
	public static String LocationsItemPresent2_2;
	public static String LocationsItemPresent2_3;
	public static String LocationsItemName2_4;
	public static String LocationsItemPresent1_4;
	public static String LocationsItemPresent2_4;
	public final Target Location1_FirstItemSelectedVerify = new Target("Location1_FirstItemSelectedVerify",
			"//*[contains(text(),'" + LocationsItemName1_1 + "')]", Target.XPATH);
	public final Target Location1_SecondItemSelectedVerify = new Target("Location1_SecondItemSelectedVerify",
			"//*[contains(text(),'" + LocationsItemName1_2 + "')]", Target.XPATH);
	public final Target Location1_ThirdItemSelectedVerify = new Target("Location1_ThirdItemSelectedVerify",
			"//*[contains(text(),'" + LocationsItemName1_3 + "')]", Target.XPATH);
	public final Target Location1_FourthItemSelectedVerify = new Target("Location1_FourthItemSelectedVerify",
			"//*[contains(text(),'" + LocationsItemName1_4 + "')]", Target.XPATH);

	public final Target Location2_FirstItemSelectedVerify = new Target("Location2_FirstItemSelectedVerify",
			"//*[contains(text(),'" + LocationsItemName2_1 + "')]", Target.XPATH);
	public final Target Location2_SecondItemSelectedVerify = new Target("Location2_SecondItemSelectedVerify",
			"//*[contains(text(),'" + LocationsItemName2_2 + "')]", Target.XPATH);
	public final Target Location2_ThirdItemSelectedVerify = new Target("Location2_ThirdItemSelectedVerify",
			"//*[contains(text(),'" + LocationsItemName2_3 + "')]", Target.XPATH);
	public final Target Location2_FourthItemSelectedVerify = new Target("Location1_FourthItemSelectedVerify",
			"//*[contains(text(),'" + LocationsItemName2_4 + "')]", Target.XPATH);

	public static final Target LocType_Dry1T1 = new Target("LocationName",
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]/label", Target.XPATH);

	public static final Target ADD_LocationName2 = new Target("LocationName",
			"//*[@class='mm-c-customlocation__setup-form']//*[@name='formFields[1].name']", Target.XPATH);

	public static final Target AddProductPage_AddCategory = new Target("AddProductPage_AddCategory",
			"//*[@class='row']//*[contains(text(),'Add/Select Expense Category')]", Target.XPATH);

	public static final Target LocationItem1_QuantityInput = new Target("LocationItem1_QuantityInput",
			"(//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'])[1]",
			Target.XPATH);
	public static final Target LocationItem2_QuantityInput = new Target("LocationItem1_QuantityInput",
			"(//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'])[2]",
			Target.XPATH);
	public static final Target UomUNITCS = new Target("LocationName", "(//*[@id='uom']/option[1])[1]", Target.XPATH);
	public static final Target UomUNITLB = new Target("LocationName", "(//*[@id='uom']/option[2])[1]", Target.XPATH);
	public static final Target UomUNITEA = new Target("LocationName", "(//*[@id='uom']/option[3])[1]", Target.XPATH);
	public static final Target UomUNITOZ = new Target("LocationName", "(//*[@id='uom']/option[4])[1]", Target.XPATH);

	public static final Target Locations_NonSyscoItem1Select = new Target("Locations_NonSyscoItem1Select",
			"(//*[@class='mm-c-product-minlist mm-c-product__custom']//*[@class='mm-o-icon'])[1]", Target.XPATH);
	public static final Target Locations_NonSyscoItem2Select = new Target("Locations_NonSyscoItem2Select",
			"(//*[@class='mm-c-product-minlist mm-c-product__custom']//*[@class='mm-o-icon'])[2]", Target.XPATH);
	public static final Target Locations_4thItemHeading = new Target("Locations_4thItemHeading",
			"(//*[@class='mm-c-product-minlist__item']/h4)[4]", Target.XPATH);
	public static String categoryKeyword1;
	public static String[] Category1;
	public static String categoryKeyword2;
	public static String[] Category2;
	public static final Target CustomCategories = new Target("CustomCategories",
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'Custom Categories')]", Target.XPATH);
	public static final Target ListNames = new Target("ListNames",
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'List Names')]", Target.XPATH);
	public static String Nonsysco_categoryKeyword1;
	public static String[] NonSysco_Category1;
	public static String Prep_categoryKeyword1;
	public static String[] Prep_Category1;

	public static String categoryKeyword3;
	public static String[] Category3;
	public static String categoryKeyword4;
	public static String[] Category4;

	public static String categoryKeyword5;
	public static String[] Category5;
	public static String categoryKeyword6;
	public static String[] Category6;

	public static String categoryKeyword8;
	public static String[] Category8;
	public static String categoryKeyword7;
	public static String[] Category7;
	public static final Target Locations_Item1Delete = new Target("Locations_Item1Delete",
			"(//*[@class='mm-c-product-list__delete-option'])[1]", Target.XPATH);
	public static final Target Locations_Item2Delete = new Target("Locations_Item2Delete",
			"(//*[@class='mm-c-product-list__delete-option'])[2]", Target.XPATH);
	public static final Target Locations_Item3Delete = new Target("Locations_Item3Delete",
			"(//*[@class='mm-c-product-list__delete-option'])[3]", Target.XPATH);

	public static final Target Locations_Item1DeleteHeading = new Target("Locations_Item1DeleteHeading",
			"(//*[@class='mm-c-product-list__edit']//*[@class='mm-c-product-list__details-wrapper']/h4)[1]",
			Target.XPATH);
	public static final Target Locations_Item2DeleteHeading = new Target("Locations_Item2DeleteHeading",
			"(//*[@class='mm-c-product-list__edit']//*[@class='mm-c-product-list__details-wrapper']/h4)[2]",
			Target.XPATH);
	public static final Target Locations_Item3DeleteHeading = new Target("Locations_Item3DeleteHeading",
			"(//*[@class='mm-c-product-list__edit']//*[@class='mm-c-product-list__details-wrapper']/h4)[3]",
			Target.XPATH);
	public static String LocationsDeleteItemName1_1;
	public static String LocationsDeleteItemName1_2;
	public static String LocationsDeleteItemName1_3;

	public static String LocationsDeleteItemId;
	public static String[] LocationsDeleteItemId1_1;
	public static String[] LocationsDeleteItemId1_2;

	public static final Target DefaultLocationDesc = new Target("DefaultLocationDesc",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Default Locations: Cooler, Freezer, & Dry')]",
			Target.XPATH);
	public static final Target CustomLocationsDesc = new Target("CustomLocationsDesc",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Create your own locations')]", Target.XPATH);

	public static final Target ItemVerify = new Target("ItemVerify",
			"//*[@class='mm-c-product-list__item mm-c-product__sysco ']", Target.XPATH);

	public static final Target Product_NickName = new Target("Product_NickName", "//*[@id='nickName']", Target.XPATH);
	public static final Target EditProduct_Page = new Target("EditProduct_Page",
			"//*[@class='navbar-brand']//*[contains(text(),'Edit Product')]", Target.XPATH);

	public static final Target FirstLocation = new Target("FirstLocation",
			"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[1]", Target.XPATH);
	public static final Target SecondLocation = new Target("SecondLocation",
			"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[2]", Target.XPATH);
	public static final Target ThirdLocation = new Target("ThirdLocation",
			"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[3]", Target.XPATH);
	public static final Target FourthLocation = new Target("FourthLocation",
			"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[4]", Target.XPATH);

	public static String AddedItemId;
	public static String[] AddedItemId1;

	public static final Target ViewItemsOnLocation = new Target("ViewItemsOnLocation",
			"//*[contains(text(),'View items in this location')]", Target.XPATH);
	public static String DeletedCategory1;
	public static String DeletedCategory2;
	public static String DeletedCategory3;
	public static Integer count = 0;

	public LocationsPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public LocationsPage atLocationsPage() {
		log("Opened Locations Page ", LogType.STEP);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage EnterLocationName(String locationName, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().click(NewLocation);
			getCommand().sendKeys(NewLocation, locationName);
			log("added location name :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("added location name :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage SelectLocationCooler(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(LocationCooler);
			getCommand().click(LocationCooler);
			log("Selected cooler :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected cooler :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage TapOnNext(String string) {
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().waitForTargetPresent(Next);
			if (getCommand().isTargetPresent(Next)) {

				getCommand().click(Next);
				log("Tapped on Next : Pass", LogType.VERIFICATION_STEP);

			}
			Set<String> contextNames1 = ((IOSDriver) getCommand().driver).getContextHandles();
			System.out.println("contxtname is " + contextNames1);

			for (String contextName : contextNames1) {
				System.out.println("inside loop " + contextNames1);
			}
			System.out.println(((IOSDriver) getCommand().driver).context((String) contextNames1.toArray()[1]));

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("Tapped on Next :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}
		
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public LocationsPage CustomLocation(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {
			Set<String> contextNames1 = ((IOSDriver) getCommand().driver).getContextHandles();
			getCommand().waitForTargetPresent(SetUp_Pg2Title);
			getCommand().waitForTargetPresent(CustomLocations);
			getCommand().click(CustomLocations);
			log("custom location clicked :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("custom location clicked :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage DefaultLocation(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			getCommand().waitForTargetPresent(SetUp_Pg2Title);
			getCommand().waitForTargetPresent(DefaultLocation);
			getCommand().click(DefaultLocation);

			log("default location clicked :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("default location clicked :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage tapContinue(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
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
	public LocationsPage SelectItemFromLocations(String string) {

		log("Selecting item", LogType.STEP);
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {
			getCommand().waitForTargetPresent(LocationsPage_Header);

			if (getCommand().isTargetPresent(LocationsPage_Header)) {
				System.out.println(getCommand().getText(LocationsPage_Header));

				getCommand().waitFor(5);
				getCommand().click(Location_FirstItem);

				Location1ItemSelected = getCommand().getText(Location_FirstItemSelect);
				getCommand().waitFor(5);
				log("Selecting item1 :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selecting item1 :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage TapOnDone(String string) {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = GlobalVariable.drivePath + string + string1 + GlobalVariable.pathExtension;
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().waitForTargetPresent(Done);
			if (getCommand().isTargetPresent(Done)) {

				getCommand().click(Done);
				log("Tapped on done:Pass", LogType.VERIFICATION_STEP);

				Set<String> contextNames1 = ((IOSDriver) getCommand().driver).getContextHandles();
				System.out.println("contxtname is " + contextNames1);

				for (String contextName : contextNames1) {
					System.out.println("inside loop " + contextNames1);
				}
				System.out.println(((IOSDriver) getCommand().driver).context((String) contextNames1.toArray()[1]));
				getCommand().captureScreenshot(finalPath);
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
	public LocationsPage ItemVerifyOnLocation(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("location Item verify ", LogType.STEP);
		try {

			Location1ItemAdded = getCommand().getText(Location_FirstItemAdded);
			final Target Locations_Productcheck = new Target("Locations_check",
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + Location1ItemSelected
							+ "')]",
					Target.XPATH);

			getCommand().waitForTargetPresent(Locations_Productcheck);
			boolean flag = getCommand().isTargetPresentAfterWait(Locations_Productcheck, 3);

			if (!flag) {
				throw new Exception();
			}

			log("Item verification done :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item verification done  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage NonSyscoItemVerifyTrackInventory(String location, String product, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("locationItem verify ", LogType.STEP);
		try {

			final Target Locations_random1 = new Target("Locations_random1",
					"//*[@id='list-item' and contains(text(),'" + location + "')]", Target.XPATH);

			getCommand().waitForTargetPresent(Locations_random1);
			getCommand().click(Locations_random1);

			Location1ItemAdded = getCommand().getText(Location_FirstItemAdded);
			final Target Locations_Productcheck = new Target("Locations_check",
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + product + "')]",
					Target.XPATH);

			getCommand().waitForTargetPresent(Locations_Productcheck);
			boolean flag = getCommand().isTargetPresentAfterWait(Locations_Productcheck, 3);

			if (!flag) {
				throw new Exception();
			}

			log("Item verification done :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item verification done  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations1_name(String locname, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Entering Location name1", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(ADD_LocationName1);
			if (getCommand().isTargetPresent(ADD_LocationName1)) {
				getCommand().click(ADD_LocationName1);
				getCommand().clear(ADD_LocationName1);
				getCommand().waitFor(5);

				getCommand().sendKeys(ADD_LocationName1, locname);
				getCommand().waitFor(5);
				log("Entered location name1 in add Locations page :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Entered location name1 in add Locations page  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations1_TypeDry(String string) {

		log("Entering type Dry", LogType.STEP);
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			if (getCommand().isTargetPresent(LocType_Dry1T1)) {
				getCommand().waitFor(5);
				getCommand().click(LocType_Dry1T1);
				getCommand().waitFor(5);
				log("Entered type in add Locations page :Pass", LogType.VERIFICATION_STEP);
			}

			if (getCommand().isTargetPresent(LocType_Dry1T2)) {
				getCommand().waitFor(5);
				getCommand().click(LocType_Dry1T2);
				getCommand().waitFor(5);
				log("Entered type in add Locations page :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Entered location type in add Locations page  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations2_name(String locname, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Entering Location name", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(ADD_LocationName2);
			if (getCommand().isTargetPresent(ADD_LocationName2)) {
				getCommand().click(ADD_LocationName2);
				getCommand().clear(ADD_LocationName2);
				getCommand().waitFor(5);

				getCommand().sendKeys(ADD_LocationName2, locname);
				getCommand().waitFor(5);

				log("Entered location name2 in add Locations page :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Entered location name2 in add Locations page  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations2_TypeDry(String string) {

		log("Entering type Dry", LogType.STEP);
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			if (getCommand().isTargetPresent(LocType_Dry2T1)) {
				getCommand().click(LocType_Dry2T1);
				getCommand().waitFor(5);
				log("Entered type in add Locations page :Pass", LogType.VERIFICATION_STEP);
			}

			if (getCommand().isTargetPresent(LocType_Dry2T2)) {
				getCommand().click(LocType_Dry2T2);
				getCommand().waitFor(5);
				log("Entered type in add Locations page :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Entered location type in add Locations page  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations2(String string) {
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Entering anotherloc", LogType.STEP);

		try {

			getCommand().waitForTargetPresent(ADD_AnotherLocation);

			if (getCommand().isTargetPresent(ADD_AnotherLocation)) {
				getCommand().click(ADD_AnotherLocation);
				getCommand().waitFor(5);

				log("Entered second loc in Locations page :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Entered second loc in Locations page  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage Itemselect1(String string) {

		log("Selecting item", LogType.STEP);
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {
			getCommand().waitForTargetPresent(LocationsPage_Header);
			if (getCommand().isTargetPresent(LocationsPage_Header)) {
				getCommand().waitFor(5);
				getCommand().click(Location_FirstItem);

				Location1ItemSelected = getCommand().getText(Location_FirstItemSelect);
				getCommand().waitFor(5);

				log("Selecting item1 :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selecting item1 :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage Itemselect2(String string) {

		log("Selecting item", LogType.STEP);
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {
			getCommand().waitForTargetPresent(LocationsPage_Header);

			if (getCommand().isTargetPresent(LocationsPage_Header)) {
				getCommand().click(SetupInventoryLocationAllItemsTab);
				getCommand().waitFor(5);
				getCommand().click(Location_FirstItem);

				Location2ItemSelected = getCommand().getText(Location_FirstItemSelect);

				getCommand().waitFor(5);

				if ((Location2ItemSelected.equalsIgnoreCase(Location1ItemSelected))) {
					log("Same item is  selected for location2 :Pass", LogType.VERIFICATION_STEP);
				} else {
					log("Same item is selected for location2 :Fail", LogType.VERIFICATION_STEP);
				}
				log("Selecting item1 :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selecting item1 :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage locationItemClick1AndEnterValue(String location, String string) {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = GlobalVariable.drivePath + string + string1 + GlobalVariable.pathExtension;
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("locationItemClick1AndEnterValue ", LogType.STEP);
		try {

			final Target Locations_random1 = new Target("Locations_random1",
					"//*[@id='list-item' and contains(text(),'" + location + "')]", Target.XPATH);

			System.out.println("location1" + location);

			getCommand().waitForTargetPresent(Locations_random1);
			getCommand().click(Locations_random1);

			Location1ItemAdded = getCommand().getText(Location_FirstItemAdded);

			getCommand().waitForTargetPresent(LocationItem1_InputTextBox);
			getCommand().sendKeys(LocationItem1_InputTextBox, value);
			getCommand().waitFor(2);
			getCommand().waitForTargetPresent(Back);
			getCommand().click(Back);
			getCommand().waitForTargetPresent(Locations_random1);
			getCommand().click(Locations_random1);

			boolean flag = getCommand().isTargetPresentAfterWait(LocationItem1_InputTextBoxCheck, 5);

			if (!flag) {
				throw new Exception();
			}

			log("locationItemClick1AndEnterValue :Pass", LogType.VERIFICATION_STEP);

			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);

			log("locationItemClick1AndEnterValue :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			log("locationItemClick1AndEnterValue :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage locationItemClick2AndEnterValue(String location, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("locationItemClick1AndEnterValue ", LogType.STEP);
		try {

			final Target Locations_random2 = new Target("Locations_random2",
					"//*[@id='list-item' and contains(text(),'" + location + "')]", Target.XPATH);

			Set<String> contextNames1 = ((IOSDriver) getCommand().driver).getContextHandles();
			System.out.println("contxtname is " + contextNames1);

			for (String contextName : contextNames1) {
				System.out.println("inside loop " + contextNames1);
			}
			System.out.println(((IOSDriver) getCommand().driver).context((String) contextNames1.toArray()[1]));

			getCommand().waitForTargetPresent(Back);
			getCommand().click(Back);

			getCommand().waitForTargetPresent(Locations_random2);
			getCommand().click(Locations_random2);

			Location2ItemAdded = getCommand().getText(Location_FirstItemAdded);

			getCommand().waitForTargetPresent(LocationItem1_InputTextBox);
			getCommand().sendKeys(LocationItem1_InputTextBox, value2);

			getCommand().waitForTargetPresent(Back);
			getCommand().click(Back);

			getCommand().waitForTargetPresent(Locations_random2);
			getCommand().click(Locations_random2);

			boolean flag = getCommand().isTargetPresentAfterWait(LocationItem2_InputTextBoxCheck, 5);

			if (!flag) {
				throw new Exception();
			}

			log("locationItemClick2AndEnterValue :Pass", LogType.VERIFICATION_STEP);

			log("locationItemClick2AndEnterValue :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("locationItemClick1AndEnterValue :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapAddLocation(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(AddWeb);
			if (getCommand().isTargetPresent(AddWeb)) {
				getCommand().click(AddWeb);
				log("Navigating to Add Locations page :Pass", LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Navigating to Add Locations page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}


	public LocationsPage AddLocationDetails(String locationName, String string) {
		String string1 = "Success";
		String string2 = "Issue";
		String finalPath = GlobalVariable.drivePath + string + string1 + GlobalVariable.pathExtension;
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().click(NewLocation);
			getCommand().sendKeys(NewLocation, locationName);
			getCommand().waitForTargetPresent(LocationCooler);
			getCommand().click(LocationCooler);
			getCommand().captureScreenshot(finalPath);
			log("added location details :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			log("added location details :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage SelectLocation(String name, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Selecting location", LogType.STEP);
		try {
			String locationName = name;

			getCommand().waitFor(2);
			final Target Locname = new Target("Locname",
					"//*[@id='list-item']//*[contains(text(),'" + locationName + "')]", Target.XPATH);
			getCommand().waitForTargetPresent(Locname);
			getCommand().click(Locname);

			log("Location is selected for item :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Location is selected for item   :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocationName(String locationName, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {
			getCommand().clear(AddLocation_LocName);
			getCommand().click(AddLocation_LocName);
			getCommand().sendKeys(AddLocation_LocName, locationName);
			log("added location name :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("added location name :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage AddLocationCooler(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().waitForTargetPresent(AddLocation_LocTypeCooler);
			getCommand().click(AddLocation_LocTypeCooler);
			System.out.println("selected cooler");

			Set<String> contextNames = ((IOSDriver) getCommand().driver).getContextHandles();

			for (String contextName : contextNames) {
				System.out.println(contextNames);
			}
			System.out.println(((IOSDriver) getCommand().driver).context((String) contextNames.toArray()[1]));
			log("Selected cooler :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected cooler :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnBack(String string) {
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitFor(2);
			getCommand().waitForTargetPresent(Back);
			if (getCommand().isTargetPresent(Back)) {

				getCommand().click(Back);

				log("tap on back :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("tap on back :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyLocationList(String locationAdded, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Checking addeded Location in location list", LogType.STEP);
		try {

			String AddedLocation = locationAdded;
			final Target LocAdded = new Target("PrepProduct",
					"//*[@id='list-item']//span[contains(text(),'" + AddedLocation + "')]", Target.XPATH);

			getCommand().waitForTargetPresent(LocAdded);
			if (getCommand().isTargetPresent(LocAdded)) {
				log("Location is added :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Added new location is listed   :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage editLocation(String editlocation, String string) {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = GlobalVariable.drivePath + string + string1 + GlobalVariable.pathExtension;
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");

			getCommand().waitForTargetPresent(Locator_firstLocname);
			getCommand().click(Locator_firstLocname);

			getCommand().waitForTargetPresent(EditBtnLocDetailsPg);
			getCommand().click(EditBtnLocDetailsPg);

			String Name = getCommand().getText(NewLocation);

			getCommand().click(NewLocation);
			getCommand().clear(NewLocation);
			getCommand().sendKeys(NewLocation, editlocation);

			getCommand().waitForTargetPresent(LocationDry);
			getCommand().click(LocationDry);

			getCommand().waitForTargetPresent(Update);
			getCommand().click(Update);

			Set<String> contextNames = ((IOSDriver) getCommand().driver).getContextHandles();
			getCommand().captureScreenshot(finalPath);
			for (String contextName : contextNames) {
				System.out.println(contextNames);
			}
			System.out.println(((IOSDriver) getCommand().driver).context((String) contextNames.toArray()[1]));

			getCommand().waitForTargetPresent(Back);
			getCommand().click(Back);

			log("Edit location  :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Edit location  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnEdit(String string) {
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Editing", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(EditWeb);
			if (getCommand().isTargetPresent(EditWeb)) {
				getCommand().click(EditWeb);
				log("tap on edit :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("tap on edit :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnDeleteLocation(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Delete cliking", LogType.STEP);
		try {

			getCommand().waitFor(2);
			getCommand().waitForTargetPresent(Delete);
			if (getCommand().isTargetPresent(Delete)) {

				getCommand().click(Delete);

				log("tap on delete :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("tap on delete :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnYesDelete(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Deleted", LogType.STEP);
		try {

			getCommand().waitFor(2);
			getCommand().waitForTargetPresent(YesDelete);
			if (getCommand().isTargetPresent(YesDelete)) {

				getCommand().click(YesDelete);

				log("tap on yes delete button :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("tap on yes delete button :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyCancelledLocationList(String locationAdded, String string) {
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Checking addeded Location in location list", LogType.STEP);
		try {
			getCommand().waitFor(2);
			String AddedLocation = locationAdded;
			final Target LocAdded = new Target("LocAdded",
					"//*[@id='list-item']//span[contains(text(),'" + AddedLocation + "')]", Target.XPATH);

			if (getCommand().isTargetPresent(LocAdded)) {
				log("Cancelled Location is there :Fail", LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			log("Cancelled location is not listed   :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Cancelled location is  listed   :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddItemFrom_OrderGuide(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(AddItem_OrderGuide);

			if (getCommand().isTargetPresent(AddItem_OrderGuide)) {

				getCommand().click(AddItem_OrderGuide);

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
	public LocationsPage AddLocation_AddProductDetailsPage(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			getCommand().waitForTargetPresent(AddProductPage_AddLocations);
			if (getCommand().isTargetPresent(AddProductPage_AddLocations)) {
				getCommand().click(AddProductPage_AddLocations);
			}
			log("Selected locations : Pass", LogType.STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected locations :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ProductSelect(String item, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Selecting an item from location ", LogType.STEP);
		try {

			final Target Product_Select = new Target("Product_Select",
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + item
							+ "')]/ancestor::div[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__image']//a",
					Target.XPATH);

			getCommand().waitForTargetPresent(Product_Select);

			getCommand().click(Product_Select);

			getCommand().waitForTargetPresent(ProductDetailsPage);

			log("Selecting an item from location :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selecting an item from location :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage LocationDoneSelection(String string) {
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(LocationsDone);
			if (getCommand().isTargetPresent(LocationsDone)) {

				getCommand().click(LocationsDone);

				log("tap on back :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");

			log("tap on back :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage selectMultipleItemsFromLocation1(String string) {
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			log(" Adding Item from Order Guide", LogType.STEP);

			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(Locations_1stItemHeading);

			if (getCommand().isTargetPresent(Locations_1stItemSelect)) {
				locationsNoOfElements1++;
				LocationsItemName1_1 = getCommand().getText(Locations_1stItemHeading);
				getCommand().click(Locations_1stItemSelect);

			}
			if (getCommand().isTargetPresent(Locations_2ndItemHeading)) {

				locationsNoOfElements1++;
				LocationsItemName1_2 = getCommand().getText(Locations_2ndItemHeading);
				getCommand().click(Locations_2ndItemSelect);
			}

			if (getCommand().isTargetPresent(Locations_3rdItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName1_3 = getCommand().getText(Locations_3rdItemHeading);
				getCommand().click(Locations_3rdItemSelect);
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

	@SuppressWarnings("rawtypes")
	public LocationsPage selectMultipleItemsFromLocation2(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(Locations_1stItemHeading);

			if (getCommand().isTargetPresent(Locations_1stItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName2_1 = getCommand().getText(Locations_1stItemHeading);
				getCommand().click(Locations_1stItemSelect);

			}
			if (getCommand().isTargetPresent(Locations_2ndItemHeading)) {

				locationsNoOfElements1++;
				LocationsItemName2_2 = getCommand().getText(Locations_2ndItemHeading);
				getCommand().click(Locations_2ndItemSelect);
			}

			if (getCommand().isTargetPresent(Locations_3rdItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName2_3 = getCommand().getText(Locations_3rdItemHeading);
				getCommand().click(Locations_3rdItemSelect);
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

	@SuppressWarnings("rawtypes")
	public LocationsPage ItemVerifyOnLocation2(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("locationItem verify ", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(Location2_FirstItemSelectedVerify);
			boolean flag2_1 = getCommand().isTargetPresentAfterWait(Location2_FirstItemSelectedVerify, 3);
			boolean flag2_2 = getCommand().isTargetPresentAfterWait(Location2_SecondItemSelectedVerify, 3);
			boolean flag2_3 = getCommand().isTargetPresentAfterWait(Location2_ThirdItemSelectedVerify, 3);

			if (!(flag2_1 && flag2_2 && flag2_3)) {
				throw new Exception();
			}
			log("Item verification done :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item verification done  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ItemVerifyOnLocation1(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("locationItem verify ", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(Location1_FirstItemSelectedVerify);
			boolean flag1_1 = getCommand().isTargetPresentAfterWait(Location1_FirstItemSelectedVerify, 3);
			boolean flag1_2 = getCommand().isTargetPresentAfterWait(Location1_SecondItemSelectedVerify, 3);
			boolean flag1_3 = getCommand().isTargetPresentAfterWait(Location1_ThirdItemSelectedVerify, 3);

			if (!(flag1_1 && flag1_2 && flag1_3)) {
				throw new Exception();
			}
			log("Item verification done :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item verification done  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddCategory_AddProductDetailsPage(String string) {

		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			getCommand().waitForTargetPresent(AddProductPage_AddCategory);
			if (getCommand().isTargetPresent(AddProductPage_AddCategory)) {
				getCommand().click(AddProductPage_AddCategory);
			}
			log("Selected add category : Pass", LogType.STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected add category :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ProductQtyEnter(String qty, String string) {

		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Quantity entering  ", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(LocationItem1_QuantityInput)
					.isTargetAvailable(LocationItem1_QuantityInput);

			getCommand().sendKeys(LocationItem1_QuantityInput, qty);

			log("Quantity entered in locations page :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Quantity entered in locations page:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage UomEnterOZ(String uom, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Quantity entering  ", LogType.STEP);
		try {
			getCommand().waitForTargetPresent(UomUNITOZ);
			getCommand().click(UomUNITOZ);

			log("Uom entered in locations page :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Uom entered in locations page:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage QuantityVerify(String qty, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Quantity verification ", LogType.STEP);
		try {

			String locationInputTextBox3 = "//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"
					+ qty + "']";
			final Target InputTextBoxCheck1 = new Target("InputTextBoxCheck1", locationInputTextBox3, Target.XPATH);

			boolean flag = getCommand().isTargetPresentAfterWait(InputTextBoxCheck1, 5);
			System.out.println("Flag1: " + flag);

			if (!flag) {
				throw new Exception();
			}

			log("Quantities updated :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Quantities updated:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AssignMultipleListItemsToLocation(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			log(" Adding Items of multiplelist to location", LogType.STEP);
			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(Locations_1stItemHeading);
			getCommand().waitForTargetPresent(Locations_1stItemSelect);
			getCommand().waitForTargetPresent(Locations_2ndItemSelect);
			getCommand().waitForTargetPresent(Locations_NonSyscoItem1Select);
			getCommand().waitForTargetPresent(Locations_NonSyscoItem2Select);

			if (getCommand().isTargetPresent(Locations_1stItemSelect)) {
				locationsNoOfElements1++;
				LocationsItemName1_1 = getCommand().getText(Locations_1stItemHeading);
				getCommand().click(Locations_1stItemSelect);

			}
			if (getCommand().isTargetPresent(Locations_2ndItemHeading)) {

				locationsNoOfElements1++;
				LocationsItemName1_2 = getCommand().getText(Locations_2ndItemHeading);
				getCommand().click(Locations_2ndItemSelect);
			}

			if (getCommand().isTargetPresent(Locations_3rdItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName1_3 = getCommand().getText(Locations_3rdItemHeading);
				getCommand().click(Locations_NonSyscoItem1Select);
			}

			if (getCommand().isTargetPresent(Locations_4thItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName1_4 = getCommand().getText(Locations_4thItemHeading);
				getCommand().click(Locations_NonSyscoItem2Select);
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

	@SuppressWarnings("rawtypes")
	public LocationsPage AllItemsTabClick(String string) {

		log("Selecting item", LogType.STEP);
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {
			getCommand().waitForTargetPresent(LocationsPage_Header);

			if (getCommand().isTargetPresent(LocationsPage_Header)) {
				getCommand().click(SetupInventoryLocationAllItemsTab);
				getCommand().waitFor(3);

				log("Selected all items tab :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected all items tab:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyMultipleListItemsInLocation(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("locationItem verify ", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(Location1_FirstItemSelectedVerify);
			boolean flag1_1 = getCommand().isTargetPresentAfterWait(Location1_FirstItemSelectedVerify, 3);
			boolean flag1_2 = getCommand().isTargetPresentAfterWait(Location1_SecondItemSelectedVerify, 3);
			boolean flag1_3 = getCommand().isTargetPresentAfterWait(Location1_ThirdItemSelectedVerify, 3);
			boolean flag1_4 = getCommand().isTargetPresentAfterWait(Location1_FourthItemSelectedVerify, 3);

			if (!(flag1_1 && flag1_2 && flag1_3 && flag1_4)) {
				throw new Exception();
			}
			log("Items verification done :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Items verification done  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage CustomCategories(String string) {
		log("Selecting custom category from Locations page", LogType.STEP);

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(CustomCategories);

			if (getCommand().isTargetPresent(CustomCategories)) {
				getCommand().click(CustomCategories);

				log("Custom category selected from locations page :Pass", LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Custom category selected from locations page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ListNames(String string) {
		log("Selecting custom category from Locations page", LogType.STEP);

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(ListNames);

			if (getCommand().isTargetPresent(ListNames)) {
				getCommand().click(ListNames);

				log("List Names selected from locations page :Pass", LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("List Names selected from locations page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyListItemsOnLocation(int item1, int item2, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("locationItem verify ", LogType.STEP);
		try {

			final Target Locations_Productcheck = new Target("Locations_check",
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + item1 + "')]",
					Target.XPATH);
			final Target Locations_Productcheck1 = new Target("Locations_check",
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + item2 + "')]",
					Target.XPATH);

			boolean flag = getCommand().isTargetPresentAfterWait(Locations_Productcheck, 3);
			boolean flag1 = getCommand().isTargetPresentAfterWait(Locations_Productcheck1, 3);

			if (!(flag && flag1)) {
				throw new Exception();
			}

			log("Item verification done :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item verification done  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage NonSyscoPrepCategoryIdentify(String nonsysco, String prep, String string) {

		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("category verify ", LogType.STEP);
		try {
			System.out.println("inside veify");

			final Target Nonsyscoitem_Heading = new Target("NonSyscoItem",
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ nonsysco + "')]",
					Target.XPATH);
			final Target Prepitem_Heading = new Target("NonSyscoItem",
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ prep + "')]",
					Target.XPATH);

			if (getCommand().isTargetPresent(Nonsyscoitem_Heading)) {
				final Target Nonsysco_CategoryLine1 = new Target("Nonsysco_CategoryLine1",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + nonsysco
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				Nonsysco_categoryKeyword1 = getCommand().getText(Nonsysco_CategoryLine1);

				NonSysco_Category1 = Nonsysco_categoryKeyword1.split("\\s+");

			}

			if (getCommand().isTargetPresent(Prepitem_Heading)) {
				final Target Prep_CategoryLine1 = new Target("Prep_CategoryLine1",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + prep
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				Prep_categoryKeyword1 = getCommand().getText(Prep_CategoryLine1);

				Prep_Category1 = Prep_categoryKeyword1.split("\\s+");

			}

			log("Categories identified for nonsyscoitems :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Categories identified for nonsyscoitems :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage DeleteItems(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Delete cliking", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(Locations_Item1DeleteHeading);
			if (getCommand().isTargetPresent(Locations_Item1DeleteHeading)) {
				LocationsDeleteItemName1_1 = getCommand().getText(Locations_Item1DeleteHeading);

				final Target keyword1 = new Target("keyword2",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
								+ LocationsDeleteItemName1_1
								+ "')]/following-sibling::div[@class='mm-c-product-list__details']",
						Target.XPATH);
				LocationsDeleteItemId = getCommand().getText(keyword1);
				LocationsDeleteItemId1_1 = LocationsDeleteItemId.split("\\s+");
				getCommand().click(Locations_Item1Delete); // deleting first
															// item in location

				LocationsDeleteItemName1_2 = getCommand().getText(Locations_Item2DeleteHeading);

				final Target keyword2 = new Target("keyword2",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
								+ LocationsDeleteItemName1_2
								+ "')]/following-sibling::div[@class='mm-c-product-list__details']",
						Target.XPATH);
				LocationsDeleteItemId = getCommand().getText(keyword2);
				LocationsDeleteItemId1_2 = LocationsDeleteItemId.split("\\s+");
				getCommand().click(Locations_Item2Delete); // deleting 2nd item
															// in location

				log("Deleting items :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("Deleting items :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyDeleteItemsList(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Checking addeded Location in location list", LogType.STEP);
		try {

			System.out.println("inside loc");
			final Target DeleteItem1 = new Target("DeleteItem1",
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ LocationsDeleteItemId1_1[0] + "')]",
					Target.XPATH);
			final Target DeleteItem2 = new Target("DeleteItem1",
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ LocationsDeleteItemId1_2[0] + "')]",
					Target.XPATH);

			boolean flag = getCommand().isTargetPresentAfterWait(DeleteItem1, 3);
			boolean flag1 = getCommand().isTargetPresentAfterWait(DeleteItem2, 3);

			if ((flag || flag1)) {
				throw new Exception();
			}

			log("Deleted items is not listed   :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Deleted items is listed   :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	public LocationsPage tapOnProductOpenProductDetailsPageAndEnterQty(String prepItemName, String quantity,
			String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("tapOnProductOpenProductDetailsPageAndEnterQty", LogType.STEP);
		try {

			final Target LocationItemProdDetailsEnterQuantity = new Target("LocationItemClickToOpenProddetails",
					"//*[@class='mm-c-product-details__select-options']//*[@type='number']", Target.XPATH);

			getCommand().click(LocationItemProdDetailsEnterQuantity);
			getCommand().waitForTargetPresent(LocationItemProdDetailsEnterQuantity);
			getCommand().sendKeys(LocationItemProdDetailsEnterQuantity, quantity);

			log("tapOnProductOpenProductDetailsPageAndEnterQty :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			log("tapOnProductOpenProductDetailsPageAndEnterQty :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	
	@SuppressWarnings("rawtypes")
	public LocationsPage SyscoCategoryIdentify(String string) {

		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("category verify ", LogType.STEP);
		try {

			final Target Location1_FirstItemSelectedVerify = new Target("Location1_FirstItemSelectedVerify",
					"//*[contains(text(),'" + LocationsItemName1_1 + "')]", Target.XPATH);
			final Target Location1_SecondItemSelectedVerify = new Target("Location1_SecondItemSelectedVerify",
					"//*[contains(text(),'" + LocationsItemName1_2 + "')]", Target.XPATH);
			final Target Location1_ThirdItemSelectedVerify = new Target("Location1_ThirdItemSelectedVerify",
					"//*[contains(text(),'" + LocationsItemName1_3 + "')]", Target.XPATH);
			final Target Location1_FourthItemSelectedVerify = new Target("Location1_FourthItemSelectedVerify",
					"//*[contains(text(),'" + LocationsItemName1_4 + "')]", Target.XPATH);

			final Target Location2_FirstItemSelectedVerify = new Target("Location2_FirstItemSelectedVerify",
					"//*[contains(text(),'" + LocationsItemName2_1 + "')]", Target.XPATH);
			final Target Location2_SecondItemSelectedVerify = new Target("Location2_SecondItemSelectedVerify",
					"//*[contains(text(),'" + LocationsItemName2_2 + "')]", Target.XPATH);
			final Target Location2_ThirdItemSelectedVerify = new Target("Location2_ThirdItemSelectedVerify",
					"//*[contains(text(),'" + LocationsItemName2_3 + "')]", Target.XPATH);

			// syscoitems added from multiple lists
			if (getCommand().isTargetPresent(Location1_ThirdItemSelectedVerify)) {
				final Target CategoryLine1 = new Target("CategoryLine1",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_3
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				categoryKeyword1 = getCommand().getText(CategoryLine1);

				Category1 = categoryKeyword1.split("\\s+");

			}

			if (getCommand().isTargetPresent(Location1_FourthItemSelectedVerify)) {
				final Target CategoryLine2 = new Target("CategoryLine1",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_4
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				categoryKeyword2 = getCommand().getText(CategoryLine2);

				Category2 = categoryKeyword2.split("\\s+");

			}

			// syscoitems added from orderguide to location1

			if (getCommand().isTargetPresent(Location1_FirstItemSelectedVerify)) {
				final Target CategoryLine3 = new Target("CategoryLine3",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_1
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				categoryKeyword3 = getCommand().getText(CategoryLine3);

				Category3 = categoryKeyword3.split("\\s+");
			}

			if (getCommand().isTargetPresent(Location1_SecondItemSelectedVerify)) {
				final Target CategoryLine4 = new Target("CategoryLine4",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_2
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				categoryKeyword4 = getCommand().getText(CategoryLine4);

				Category4 = categoryKeyword4.split("\\s+");
			}

			if (getCommand().isTargetPresent(Location1_ThirdItemSelectedVerify)) {
				final Target CategoryLine5 = new Target("CategoryLine5",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_3
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				categoryKeyword5 = getCommand().getText(CategoryLine5);

				Category5 = categoryKeyword5.split("\\s+");

			}

			// syscoitem added from Orderguide to location2
			if (getCommand().isTargetPresent(Location2_FirstItemSelectedVerify)) {
				final Target CategoryLine6 = new Target("CategoryLine6",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName2_1
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				categoryKeyword6 = getCommand().getText(CategoryLine6);

				Category6 = categoryKeyword6.split("\\s+");

			}

			if (getCommand().isTargetPresent(Location2_SecondItemSelectedVerify)) {
				final Target CategoryLine7 = new Target("CategoryLine7",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName2_2
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				categoryKeyword7 = getCommand().getText(CategoryLine7);

				Category7 = categoryKeyword7.split("\\s+");

			}

			if (getCommand().isTargetPresent(Location2_ThirdItemSelectedVerify)) {
				final Target CategoryLine8 = new Target("CategoryLine8",
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName2_3
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						Target.XPATH);

				categoryKeyword8 = getCommand().getText(CategoryLine8);

				Category8 = categoryKeyword8.split("\\s+");

			}

			log("Categories identified for syscoitems :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Categories identified for syscoitems :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyItemsOnDefaultLocation(String location, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			if (getCommand().isTargetPresent(ItemVerify)) {
				count = getCommand().getTargetCount(ItemVerify);
				getCommand().waitFor(5);
				final Target Locations_check = new Target("Locations_check",
						"//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"
								+ location + "')]",
						Target.XPATH);

				if (getCommand().isTargetPresent(Locations_check)) {

					log("Item verification done :Pass", LogType.VERIFICATION_STEP);
				} else {

					throw new Exception();
				}

			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item verification done  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyOptionsOnSetupLocations(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Set up locations page verify ", LogType.STEP);
		try {

			if (getCommand().isTargetPresent(DefaultLocation) && getCommand().isTargetPresent(DefaultLocationDesc)
					&& getCommand().isTargetPresent(CustomLocations)
					&& getCommand().isTargetPresent(CustomLocationsDesc)) {
				log("Set up location verification done :Pass", LogType.VERIFICATION_STEP);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Set up location verification done  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage PdtDetailPage_Location1_EnterQty(String quantity, String loc1, String string) {
		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			final Target LocationItemProdDetailsEnterQuantity = new Target("LocationItemClickToOpenProddetails",
					"//*[@class='input-group']//*[contains(text(),'" + loc1
							+ "')]/ancestor::div[@class='input-group']//*[@type='number']",
					Target.XPATH);

			getCommand().click(LocationItemProdDetailsEnterQuantity);
			getCommand().clear(LocationItemProdDetailsEnterQuantity);
			getCommand().sendKeys(LocationItemProdDetailsEnterQuantity, quantity);

			log("Entered qty on first location on product detail page :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Entered qty on first location on product detail page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage PdtDetailPage_Location2_EnterQty(String quantity, String loc2, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {
			final Target LocationItemProdDetailsEnterQuantity = new Target("LocationItemClickToOpenProddetails",
					"//*[@class='input-group']//*[contains(text(),'" + loc2
							+ "')]/ancestor::div[@class='input-group']//*[@type='number']",
					Target.XPATH);

			getCommand().click(LocationItemProdDetailsEnterQuantity);
			getCommand().clear(LocationItemProdDetailsEnterQuantity);
			getCommand().sendKeys(LocationItemProdDetailsEnterQuantity, quantity);

			log("Entered qty on second location on product detail page :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Entered qty on second location on product detail page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage verifyLocations2(String string, String locationName, String locationNumber) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Entering anotherloc", LogType.STEP);

		try {
			final Target LocationnameNumberVerification = new Target("LocationnameNumberVerification",
					"//*[contains(text(),'" + locationName + "')]", Target.XPATH);
			getCommand().waitForTargetPresent(LocationnameNumberVerification);
			String locationNameToBeVerified = getCommand().getText(LocationnameNumberVerification);
			if (!(locationNameToBeVerified.contains(locationNumber))) {
				throw new Exception();
			}

			log("Entered second loc in Locations page :Pass", LogType.VERIFICATION_STEP);

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("LocationName(x) :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage SyscoProductSelect(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Selecting an item from location ", LogType.STEP);
		try {

			final Target Product_Select = new Target("Product_Select",
					"((//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[contains(text(),'"
							+ SetupInventoryPage.AddedItemId1[0]
							+ "')]/ancestor::div[@class='mm-c-product-list__details-wrapper'])//a)[1]",
					Target.XPATH);

			getCommand().waitForTargetPresent(Product_Select);
			;
			getCommand().click(Product_Select);
			getCommand().waitForTargetPresent(ProductDetailsPage);
			log("Selecting an item from location :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selecting an item from location :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage EditProduct_NickName(String nickName, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Assigining nickname to product", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(EditProduct_Page);

			if (getCommand().isTargetPresent(Product_NickName)) {

				getCommand().sendKeys(Product_NickName, nickName);

				log("Assigining nickname to product: Pass", LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Assigining nickname to product: Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyOrderOfLocations(String cooler, String freezer, String dry, String noloc,
			String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Order of locations verify", LogType.STEP);
		try {

			String firstLoc = getCommand().getText(FirstLocation);
			String secondLoc = getCommand().getText(SecondLocation);
			String thirdLoc = getCommand().getText(ThirdLocation);
			String fourthLoc = getCommand().getText(FourthLocation);
			fourthLoc = fourthLoc.toLowerCase();
			if (firstLoc.contains(cooler) && secondLoc.contains(freezer) && thirdLoc.contains(dry)
					&& fourthLoc.contains(noloc)) {
				log("VerifyOrderOfLocations:Pass", LogType.VERIFICATION_STEP);
			} else {
				System.out.println("Order incorrect");
				throw new Exception();
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("VerifyOrderOfLocations :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage AddLocationFreezer(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().waitForTargetPresent(AddLocation_LocTypeFreezer);
			getCommand().click(AddLocation_LocTypeFreezer);

			Set<String> contextNames = ((IOSDriver) getCommand().driver).getContextHandles();

			for (String contextName : contextNames) {
				System.out.println(contextNames);
			}
			System.out.println(((IOSDriver) getCommand().driver).context((String) contextNames.toArray()[1]));
			log("Selected freezer :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected freezer :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ViewItemsOnLocation(String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			getCommand().waitForTargetPresent(ViewItemsOnLocation);

			getCommand().click(ViewItemsOnLocation);
			log("tap on view items on location  :Pass", LogType.VERIFICATION_STEP);

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("tap on view items on location  :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyCustomListItemsCustomLocation(String location, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Verifying location of items ", LogType.STEP);
		try {

			getCommand().waitFor(5);
			final Target Locations_check1 = new Target("Locations_check1",
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"
							+ location + "')])[1]",
					Target.XPATH);
			final Target Locations_check2 = new Target("Locations_check2",
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"
							+ location + "')])[2]",
					Target.XPATH);
			final Target Locations_check3 = new Target("Locations_check3",
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"
							+ location + "')])[3]",
					Target.XPATH);

			boolean flag1 = getCommand().isTargetPresentAfterWait(Locations_check1, 3);
			boolean flag2 = getCommand().isTargetPresentAfterWait(Locations_check2, 3);
			boolean flag3 = getCommand().isTargetPresentAfterWait(Locations_check3, 3);

			if (!(flag1 && flag2 && flag3)) {
				throw new Exception();
			}

			log("Verifying location of items  :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Verifying location of items   :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyDeletedItemsCategory(String location, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		Boolean flag1 = false, flag2 = false, flag3 = false;

		log("Verifying category of items ", LogType.STEP);
		try {

			getCommand().waitFor(5);
			final Target Locations_check1 = new Target("Locations_check1",
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location'])[1]",
					Target.XPATH);
			final Target Locations_check2 = new Target("Locations_check2",
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location'])[2]",
					Target.XPATH);
			final Target Locations_check3 = new Target("Locations_check3",
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location'])[3]",
					Target.XPATH);

			DeletedCategory1 = getCommand().getText(Locations_check1);
			DeletedCategory2 = getCommand().getText(Locations_check2);
			DeletedCategory3 = getCommand().getText(Locations_check3);

			if ((DeletedCategory1.equalsIgnoreCase(location))) {
				flag1 = true;

			}
			if ((DeletedCategory1.equalsIgnoreCase(location))) {
				flag2 = true;

			}
			if ((DeletedCategory1.equalsIgnoreCase(location))) {
				flag3 = true;

			}

			System.out.println("Flag1: " + flag1 + flag2 + flag3);
			if (!(flag2 && flag1 && flag3)) {
				throw new Exception();
			}

			log("Verifying category of items  :Pass", LogType.VERIFICATION_STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Verifying category of items    :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyMultipleOGItemsCount(String locationName, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Verifying item count", LogType.STEP);

		try {

			final Target LocationnameNumberVerification = new Target("LocationnameNumberVerification",
					"//*[contains(text(),'" + locationName + "')]", Target.XPATH);

			getCommand().waitForTargetPresent(LocationnameNumberVerification);

			String locationNameToBeVerified = getCommand().getText(LocationnameNumberVerification);

			if (!(locationNameToBeVerified.contains("SetupInventoryPage.noOfElements"))) {

				throw new Exception();

			}

			log("Item count verified :Pass", LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {

			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item count verified,LocationName(x) :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyCountOfItemsInLocation(String locationName, String string) {
		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Verifying item count", LogType.STEP);

		try {

			final Target LocationnameNumberVerification = new Target("LocationnameNumberVerification",
					"//*[contains(text(),'" + locationName + "')]", Target.XPATH);

			getCommand().waitForTargetPresent(LocationnameNumberVerification);

			String locationNameToBeVerified = getCommand().getText(LocationnameNumberVerification);

			if (!(locationNameToBeVerified.contains("(" + count.toString() + ")"))) {

				throw new Exception();

			}

			log("Item count verified :Pass", LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {

			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Item count verified,LocationName(x) :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		return this;

	}
}
