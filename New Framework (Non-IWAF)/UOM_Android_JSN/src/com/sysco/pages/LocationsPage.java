		
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

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import com.sysco.jsn_framework.JSN_Framework;
import com.sysco.locators.Screenshot;
public class LocationsPage extends JSN_Framework {
	private static final Logger LOGGER= Logger.getLogger(LocationsPage.class.getCanonicalName());
JSN_Framework jsn_Framework= new JSN_Framework();
	
public static final String NewLocation ="//*[@class='mm-c-customlocation__setup-form']//*[@name='dynamicFields[0].name']";
//public static final String NewLocation ="//*[@class='mm-c-customlocation__setup-form']//*[@class='mm-c-customlocation__details-category-name form-control form-control']";




public static final String LocationCooler = 
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[1]";
//	public static final String Next = "//UIAStaticText[@label='Next']";
	public static final String Next ="//*[@id='next-nav']/a";
	public static final String SetUp_Pg2Title = 
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Setup Locations')]";
	public static final String DefaultLocation = 
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'Default')]";
	public static final String CustomLocations = 
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'Custom Locations')]";
	public static final String Continue =
			"//*[@class='btn btn-default' and contains(text(),'Continue')]";
	//public static final String Done ="//UIAStaticText[@label='Done']";

	public static final String Location_FirstItemSelect = 
			"(//*[@class='mm-c-product-list__details-wrapper'])[1]/h4";
	public static final String Location_FirstItem = 
			"(//*[@class='checkbox']//*[@class='mm-o-icon'])[1]";
	public static final String LocationsPage_Header = "//*[@class='navbar-brand']/h3";
			
	public static final String Cancel = "//*[contains(text(),'Cancel')]";
	public static final String OrderGuide_FirstItemSelect = 
			"(//*[@id='mount']//*[@class='mm-o-icon'])[1]";
	public static String Location1ItemSelected;
	public static String Location1ItemAdded;
	public static final String Location_FirstItemAdded =
			"//*[@id='mount']/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/div[2]/div[2]/h4";

	public static final String AddLocation_LocName = "//*[@id='name']";
	public static final String AddLocation_LocTypeCoolerWeb = 
			"(//*[@class='mm-c-location__details-radio']//*[@class='radio'])[1]";
	public static final String AddLocation_LocTypeCooler = "//*[@value='C']";
	
	public static final String AddWeb =  "//*[@id='add-nav']/a/i";
	public static final String EditWeb =  "//*[@id='edit-nav']/a/i";
	/*public static final String AddLocation_LocTypeCooler = 
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]";

*/	public static final String AddLocation_LocTypeFreezer = 
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]";

	public static final String Back =  "//*[@id='back-nav']/a/i";
	public static final String Done =  "//*[@id='done-nav']/a";
	public static final String ADD_AnotherLocation = 
			"//*[@class='mm-c-customlocation__setup-cta']//*[contains(text(),'Add Another Location')]";
	public static final String LocType_Dry1 = 
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]";
	public static final String LocType_Dry1T2 = 
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]//*[@type='radio']";
		
	public static final String LocType_Dry2 = 
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]";
	public static final String LocType_Dry2T1 =
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]/label";
	public static final String LocType_Dry2T2 =
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]//*[@type='radio']";
			
	public static final String ADD_LocationName = "//*[@id='name']";
	public static final String ADD_LocTypeDry = "//*[@value='D']";
	public static final String ADD_LocationName1 = 
			"//*[@class='mm-c-customlocation__setup-form']//*[@name='formFields[0].name']";
	public static final String SetupInventoryLocationUncategorizedTab =
			"//*[@id='mount']//*[@class='mm-c-productList--pill-right']/a";

	public static final String SetupInventoryLocationAllItemsTab = 
			"//*[@id='mount']//*[@class='mm-c-productList--pill-left']/a";
	public static String Location2ItemSelected;
	public static String value = "3.8";
	public static String value2 = "4";

	public static String locationInputTextBox = "//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"
			+ value + "']";
	public static String locationInputTextBox2 = "//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"
			+ value2 + "']";
	public static final String LocationItem1_InputTextBox = 
			"//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control']";
	
	public static final String LocationItem1_InputTextBoxCheck =
			locationInputTextBox;
	public static final String LocationItem2_InputTextBoxCheck = 
			locationInputTextBox2;
	public static String Location2ItemAdded;
	public static final String BackWeb = 
			"//*[@class='nav navbar-nav']//*[@role='presentation']//*[@class='mm-o-icon icon-chevron-left']";
			

	public static final String Locator_firstLocname = 
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]";
	public static final String EditBtnLocDetailsPg = 
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]/UIALink[1]/UIAStaticText[1]";
			
	public static final String LocationFreezer =
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[3]";
	public static final String LocationDry =
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]";
	public static final String Update =  "//UIAStaticText[@label='Update']";
	public static final String Delete =
			"//*[@id='delete-button' and contains(text(),'Delete Location')]";
	public static final String YesDelete = 
			"//*[@id='yes-button' and contains(text(),'Yes, Delete')]";

	public static final String AddItem_OrderGuide =
			"//*[@type='button']//span[contains(text(),'Add From Order Guide')]";
	public static final String Category_Header =
			"//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3";

	public static final String LocationsDone = 
			"//*[@type='button' and contains(text(),'Done')]";
	public static final String AddProductPage_AddLocations = 
			"#expense-add > div > select";
	public static final String ProductDetailsPage = 
			"//*[@class='navbar-brand']//*[contains(text(),'Product Details')]";

	public static final String Locations_1stItemSelect = 
			"(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[1]";
	public static final String Locations_2ndItemSelect = 
			"(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[2]";
	public static final String Locations_3rdItemSelect = 
			"(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[3]";
	public static final String Locations_1stItemHeading = 
			"(//*[@class='mm-c-product-minlist__item']/h4)[1]";
	public static final String Locations_2ndItemHeading =
			"(//*[@class='mm-c-product-minlist__item']/h4)[2]";
	public static final String Locations_3rdItemHeading = 
			"(//*[@class='mm-c-product-minlist__item']/h4)[3]";

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
/*	public final String Location1_FirstItemSelectedVerify =
			"//*[contains(text(),'" + LocationsItemName1_1 + "')]";
	public final String Location1_SecondItemSelectedVerify =
			"//*[contains(text(),'" + LocationsItemName1_2 + "')]";
	public final String Location1_ThirdItemSelectedVerify = 
			"//*[contains(text(),'" + LocationsItemName1_3 + "')]";
	*/public final String Location1_FourthItemSelectedVerify = 
			"//*[contains(text(),'" + LocationsItemName1_4 + "')]";

/*	public final String Location2_FirstItemSelectedVerify = 
			"//*[contains(text(),'" + LocationsItemName2_1 + "')]";
	public final String Location2_SecondItemSelectedVerify = 
			"//*[contains(text(),'" + LocationsItemName2_2 + "')]";
	public final String Location2_ThirdItemSelectedVerify = 
			"//*[contains(text(),'" + LocationsItemName2_3 + "')]";*/
	public final String Location2_FourthItemSelectedVerify = 
			"//*[contains(text(),'" + LocationsItemName2_4 + "')]";

	public static final String LocType_Dry1T1 = 
			"(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]/label";

	public static final String ADD_LocationName2 = 
			"//*[@class='mm-c-customlocation__setup-form']//*[@name='dynamicFields[1].name']";

	public static final String AddProductPage_AddCategory = 
			"//*[@class='row']//*[contains(text(),'Add/Select Expense Category')]";

	public static final String LocationItem1_QuantityInput = 
			"(//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'])[1]";
		
	public static final String LocationItem2_QuantityInput = 
			"(//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'])[2]";
		
	public static final String UomUNITCS = "(//*[@id='uom']/option[1])[1]";
	public static final String UomUNITLB = "(//*[@id='uom']/option[2])[1]";
	public static final String UomUNITEA = "(//*[@id='uom']/option[3])[1]";
	public static final String UomUNITOZ = "(//*[@id='uom']/option[4])[1]";

	public static final String Locations_NonSyscoItem1Select = 
			"(//*[@class='mm-c-product-minlist mm-c-product__custom']//*[@class='mm-o-icon'])[1]";
	public static final String Locations_NonSyscoItem2Select = 
			"(//*[@class='mm-c-product-minlist mm-c-product__custom']//*[@class='mm-o-icon'])[2]";
	public static final String Locations_4thItemHeading = 
			"(//*[@class='mm-c-product-minlist__item']/h4)[4]";
	public static String categoryKeyword1;
	public static String[] Category1;
	public static String categoryKeyword2;
	public static String[] Category2;
	public static final String CustomCategories = 
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'Custom Categories')]";
	public static final String ListNames = 
			"//*[@class='btn btn-sm btn-primary' and contains(text(),'List Names')]";
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
	public static final String Locations_Item1Delete = 
			"(//*[@class='mm-c-product-list__delete-option'])[1]";
	public static final String Locations_Item2Delete =
			"(//*[@class='mm-c-product-list__delete-option'])[2]";
	public static final String Locations_Item3Delete = 
			"(//*[@class='mm-c-product-list__delete-option'])[3]";

	public static final String Locations_Item1DeleteHeading = 
			"(//*[@class='mm-c-product-list__edit']//*[@class='mm-c-product-list__details-wrapper']/h4)[1]";
			
	public static final String Locations_Item2DeleteHeading = 
			"(//*[@class='mm-c-product-list__edit']//*[@class='mm-c-product-list__details-wrapper']/h4)[2]";
			
	public static final String Locations_Item3DeleteHeading = 
			"(//*[@class='mm-c-product-list__edit']//*[@class='mm-c-product-list__details-wrapper']/h4)[3]";
		
	public static String LocationsDeleteItemName1_1;
	public static String LocationsDeleteItemName1_2;
	public static String LocationsDeleteItemName1_3;

	public static String LocationsDeleteItemId;
	public static String[] LocationsDeleteItemId1_1;
	public static String[] LocationsDeleteItemId1_2;

	public static final String DefaultLocationDesc = 
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Default Locations: Cooler, Freezer, & Dry')]";
			
	public static final String CustomLocationsDesc = 
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Create your own locations')]";

	public static final String ItemVerify = 
			"//*[@class='mm-c-product-list__item mm-c-product__sysco ']";

	public static final String Product_NickName = "//*[@id='nickName']";
	public static final String EditProduct_Page = 
			"//*[@class='navbar-brand']//*[contains(text(),'Edit Product')]";

	public static final String FirstLocation = 
			"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[1]";
	public static final String SecondLocation = 
			"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[2]";
	public static final String ThirdLocation = 
			"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[3]";
	public static final String FourthLocation = 
			"(//*[@class='list-group']//*[@id='list-item']//*[@class='mm-c-simplelist__name'])[4]";

	public static String AddedItemId;
	public static String[] AddedItemId1;

	public static final String ViewItemsOnLocation = 
			"//*[contains(text(),'View items in this location')]";
	public static String DeletedCategory1;
	public static String DeletedCategory2;
	public static String DeletedCategory3;
	public static Integer count =0;
	public static Integer count1 =0;
	public static String[] locationNamesArray1;
	public static String[] locationNamesArray;
	
	
	public static String 	LocAddedItemId;
	public static String[] Loc1AddedItemId_1;
	public static String[] Loc1AddedItemId_2;
	public static String[] Loc1AddedItemId_3;
	public static String[] Loc2AddedItemId_1;
	public static String[] Loc2AddedItemId_2;
	public static String[] Loc2AddedItemId_3;
	public static String[] Loc2AddedItemId_4;

	public static String Locations_4thItemSelect = "(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[4]";
	public static String 	NoLocItemId;
	public static String[] NoLocItemId_1;
	
	public static String ProductCardDelete_Loc1= "(//*[@class='mm-o-icon icon-minus-circle'])[1]";
	public static String ProductCardDelete_Loc2= "(//*[@class='mm-o-icon icon-minus-circle'])[22]";
	public static String ProductCardDeleteAllLoc_Confirmation = "//*[contains(text(),'By removing all locations from this item, you will no longer be able to track this item in your inventory. Are you sure? ')]";
	public static String NoDelete = "//*[@id='no-button' and contains(text(),'No, Cancel')]";
	public static String SetUp_Pg2Header ="//*[@class='navbar-brand']//*[contains(text(),'Setup Inventory')]";
	public static String CreateLocationDesc = "//*[@class='mm-c-customlocation__setup mm-u-navbar-padding']//*[contains(text(),'Create Locations')]";
	/* Functions on the Page are defined below */
	@SuppressWarnings("rawtypes")
	public LocationsPage EnterLocationName(String locationName, String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			
			clickElement(NewLocation);
			sendText(NewLocation, locationName);
			Reporter.log("added location name :Pass");
		}

		catch (Exception e) {
			Reporter.log("added location name :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage SelectLocationCooler(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitForElementToBeClickable(LocationCooler);
			clickElement(LocationCooler);
			Reporter.log("Selected cooler :Pass");
		}

		catch (Exception e) {
			Reporter.log("Selected cooler :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage TapOnNext(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			
			waitForElementToBeClickable(Next);
			if (isElementPresent(Next)) {

				clickElement(Next);
				Reporter.log("Tapped on Next : Pass");

			}
			switchToWebContext();

		} catch (Exception e) {
			Reporter.log("Tapped on Next :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}
		
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public LocationsPage CustomLocation(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {
			switchToWebContext();
			//waitForElementToBeClickable(SetUp_Pg2Title);
			Thread.sleep(3000);
			waitForElementToBeClickable(CustomLocations);
			clickElement(CustomLocations);
			Reporter.log("custom location clickElemented :Pass");
		}

		catch (Exception e) {
			Reporter.log("custom location clickElemented :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage DefaultLocation(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			//waitForElementToBeClickable(SetUp_Pg2Title);
			Thread.sleep(7000);
			waitForElementToBeClickable(DefaultLocation);
			clickElement(DefaultLocation);

			Reporter.log("default location clickElemented :Pass");
		}

		catch (Exception e) {
			Reporter.log("default location clickElemented :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage tapContinue(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			waitForElementToBeClickable(Continue);
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
	public LocationsPage SelectItemFromLocations(String string) throws InterruptedException, IOException {

		Reporter.log("Selecting item");
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {
			waitForElementToBeClickable(LocationsPage_Header);

			if (isElementPresent(LocationsPage_Header)) {
				System.out.println(getElementText(LocationsPage_Header));

				waitFor(5);
				clickElement(Location_FirstItem);

				Location1ItemSelected = getElementText(Location_FirstItemSelect);
				waitFor(5);
				Reporter.log("Selecting item1 :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Selecting item1 :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage TapOnDone(String string) throws InterruptedException, IOException {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = Screenshot.drivePath + string + string1 + Screenshot.pathExtension;
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			
			waitForElementToBeClickable(Done);
			if (isElementPresent(Done)) {

				clickElement(Done);
				Reporter.log("Tapped on done:Pass");

				switchToWebContext();
			}

		} catch (Exception e) {
			Reporter.log("Tapped on done :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ItemVerifyOnLocation(String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("location Item verify ");
		try {

			Location1ItemAdded = getElementText(Location_FirstItemAdded);
			final String Locations_Productcheck ="//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + Location1ItemSelected+ "')]";
			waitForElementToBeClickable(Locations_Productcheck);
			boolean flag = isElementPresentAfterWait(Locations_Productcheck, 3);

			if (!flag) {
				throw new Exception();
			}

			Reporter.log("Item verification done :Pass");
		} catch (Exception e) {
			Reporter.log("Item verification done  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage NonSyscoItemVerifyTrackInventory(String location, String product, String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("locationItem verify ");
		try {

			final String Locations_random1 = 
					"//*[@id='list-item' and contains(text(),'" + location + "')]";

			waitForElementToBeClickable(Locations_random1);
			clickElement(Locations_random1);

			Location1ItemAdded = getElementText(Location_FirstItemAdded);
			final String Locations_Productcheck = 
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + product + "')]";
					

			waitForElementToBeClickable(Locations_Productcheck);
			boolean flag = isElementPresentAfterWait(Locations_Productcheck, 3);

			if (!flag) {
				throw new Exception();
			}

			Reporter.log("Item verification done :Pass");
		} catch (Exception e) {
			Reporter.log("Item verification done  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations1_name(String locname, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Entering Location name1");
		try {

			waitForElementToBeClickable(ADD_LocationName1);
			if (isElementPresent(ADD_LocationName1)) {
				clickElement(ADD_LocationName1);
				clearElement(ADD_LocationName1);
				waitFor(5);

				sendText(ADD_LocationName1, locname);
				waitFor(5);
				Reporter.log("Entered location name1 in add Locations page :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Entered location name1 in add Locations page  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations1_TypeDry(String string) throws InterruptedException, IOException {

		Reporter.log("Entering type Dry");
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			if (isElementPresent(LocType_Dry1T1)) {
				waitFor(5);
				clickElement(LocType_Dry1T1);
				waitFor(5);
				Reporter.log("Entered type in add Locations page :Pass");
			}

			/*if (isElementPresent(LocType_Dry1T2)) {
				waitFor(5);
				clickElement(LocType_Dry1T2);
				waitFor(5);
				Reporter.log("Entered type in add Locations page :Pass");
			}*/

		} catch (Exception e) {
			Reporter.log("Entered location type in add Locations page  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations2_name(String locname, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Entering Location name");
		try {

			waitForElementToBeClickable(ADD_LocationName2);
			if (isElementPresent(ADD_LocationName2)) {
				clickElement(ADD_LocationName2);
				clearElement(ADD_LocationName2);
				waitFor(5);

				sendText(ADD_LocationName2, locname);
				waitFor(5);

				Reporter.log("Entered location name2 in add Locations page :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Entered location name2 in add Locations page  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations2_TypeDry(String string) throws InterruptedException, IOException {

		Reporter.log("Entering type Dry");
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			if (isElementPresent(LocType_Dry2T1)) {
				clickElement(LocType_Dry2T1);
				waitFor(5);
				Reporter.log("Entered type in add Locations page :Pass");
			}

			/*if (isElementPresent(LocType_Dry2T2)) {
				clickElement(LocType_Dry2T2);
				waitFor(5);
				Reporter.log("Entered type in add Locations page :Pass");
			}
*/
		} catch (Exception e) {
			Reporter.log("Entered location type in add Locations page  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocations2(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Entering anotherloc");

		try {

			waitForElementToBeClickable(ADD_AnotherLocation);

			if (isElementPresent(ADD_AnotherLocation)) {
				clickElement(ADD_AnotherLocation);
				waitFor(5);

				Reporter.log("Entered second loc in Locations page :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Entered second loc in Locations page  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage Itemselect1(String string) throws InterruptedException, IOException {

		Reporter.log("Selecting item");
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {
			waitForElementToBeClickable(LocationsPage_Header);
			if (isElementPresent(LocationsPage_Header)) {
				waitFor(5);
				clickElement(Location_FirstItem);

				Location1ItemSelected = getElementText(Location_FirstItemSelect);
				waitFor(5);

				Reporter.log("Selecting item1 :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Selecting item1 :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage Itemselect2(String string) throws InterruptedException, IOException {

		Reporter.log("Selecting item");
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {
			waitForElementToBeClickable(LocationsPage_Header);

			if (isElementPresent(LocationsPage_Header)) {
				clickElement(SetupInventoryLocationAllItemsTab);
				waitFor(5);
				clickElement(Location_FirstItem);

				Location2ItemSelected = getElementText(Location_FirstItemSelect);

				waitFor(5);

				if ((Location2ItemSelected.equalsIgnoreCase(Location1ItemSelected))) {
					Reporter.log("Same item is  selected for location2 :Pass");
				} else {
					Reporter.log("Same item is selected for location2 :Fail");
				}
				Reporter.log("Selecting item1 :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Selecting item1 :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage locationItemclickElement1AndEnterValue(String location, String string) throws InterruptedException, IOException {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = Screenshot.drivePath + string + string1 + Screenshot.pathExtension;
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("locationItemclickElement1AndEnterValue ");
		try {

			final String Locations_random1 =
					"//*[@id='list-item' and contains(text(),'" + location + "')]";

			System.out.println("location1" + location);

			waitForElementToBeClickable(Locations_random1);
			clickElement(Locations_random1);

			Location1ItemAdded = getElementText(Location_FirstItemAdded);

			waitForElementToBeClickable(LocationItem1_InputTextBox);
			sendText(LocationItem1_InputTextBox, value);
			waitFor(2);
			waitForElementToBeClickable(Back);
			clickElement(Back);
			waitForElementToBeClickable(Locations_random1);
			clickElement(Locations_random1);

			boolean flag = isElementPresentAfterWait(LocationItem1_InputTextBoxCheck, 5);

			if (!flag) {
				throw new Exception();
			}

			Reporter.log("locationItemclickElement1AndEnterValue :Pass");

			Reporter.log("locationItemclickElement1AndEnterValue :Pass");
		} catch (Exception e) {
			Reporter.log("locationItemclickElement1AndEnterValue :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage locationItemclickElement2AndEnterValue(String location, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("locationItemclickElement1AndEnterValue ");
		try {

			final String Locations_random2 ="//*[@id='list-item' and contains(text(),'" + location + "')]";

			switchToWebContext();
			waitForElementToBeClickable(Back);
			clickElement(Back);

			waitForElementToBeClickable(Locations_random2);
			clickElement(Locations_random2);

			Location2ItemAdded = getElementText(Location_FirstItemAdded);

			waitForElementToBeClickable(LocationItem1_InputTextBox);
			sendText(LocationItem1_InputTextBox, value2);

			waitForElementToBeClickable(Back);
			clickElement(Back);

			waitForElementToBeClickable(Locations_random2);
			clickElement(Locations_random2);

			boolean flag = isElementPresentAfterWait(LocationItem2_InputTextBoxCheck, 5);

			if (!flag) {
				throw new Exception();
			}

			Reporter.log("locationItemclickElement2AndEnterValue :Pass");

			Reporter.log("locationItemclickElement2AndEnterValue :Pass");
		} catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("locationItemclickElement1AndEnterValue :Fail");
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapAddLocation(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitForElementToBeClickable(AddWeb);
			if (isElementPresent(AddWeb)) {
				clickElement(AddWeb);
				Reporter.log("Navigating to Add Locations page :Pass");

			}

		} catch (Exception e) {
			Reporter.log("Navigating to Add Locations page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}


	public LocationsPage AddLocationDetails(String locationName, String string) throws InterruptedException, IOException {
		String string1 = "Success";
		String string2 = "Issue";
		String finalPath = Screenshot.drivePath + string + string1 + Screenshot.pathExtension;
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			clickElement(NewLocation);
			sendText(NewLocation, locationName);
			waitForElementToBeClickable(LocationCooler);
			clickElement(LocationCooler);

			Reporter.log("added location details :Pass");
		}

		catch (Exception e) {
			Reporter.log("added location details :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage SelectLocation(String name, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Selecting location");
		try {
			String locationName = name;

			waitFor(2);
			final String Locname ="//*[contains(text(),'"+locationName +"')]";
			waitForElementToBeClickable(Locname);
			clickElement(Locname);

			Reporter.log("Location is selected for item :Pass");
		}

		catch (Exception e) {
			Reporter.log("Location is selected for item   :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocationName(String locationName, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			clearElement(AddLocation_LocName);
			clickElement(AddLocation_LocName);
			//sendText(AddLocation_LocName, locationName);
			Reporter.log("added location name :Pass");
		}

		catch (Exception e) {
			Reporter.log("added location name :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage AddLocationCooler(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			
			waitForElementToBeClickable(AddLocation_LocTypeCooler);
			clickElement(AddLocation_LocTypeCooler);
			System.out.println("selected cooler");

			
			Reporter.log("Selected cooler :Pass");
		}

		catch (Exception e) {
			Reporter.log("Selected cooler :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage AddCatFood(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			
			waitForElementToBeClickable(AddLocation_LocTypeCooler);
			clickElement(AddLocation_LocTypeCooler);
			System.out.println("selected cooler");

			
			Reporter.log("Selected cooler :Pass");
		}

		catch (Exception e) {
			Reporter.log("Selected cooler :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnBack(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitFor(2);
			waitForElementToBeClickable(Back);
			if (isElementPresent(Back)) {

				clickElement(Back);

				Reporter.log("tap on back :Pass");
			}

		} catch (Exception e) {
			Reporter.log("tap on back :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyLocationList(String locationAdded, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Checking addeded Location in location list");
		try {

			String AddedLocation = locationAdded;
			final String LocAdded = 
					"//*[@id='list-item']//span[contains(text(),'" + AddedLocation + "')]";

			waitForElementToBeClickable(LocAdded);
			if (isElementPresent(LocAdded)) {
				Reporter.log("Location is added :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Added new location is listed   :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	/*@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage editLocation(String editlocation, String string) throws InterruptedException, IOException {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = Screenshot.drivePath + string + string1 + Screenshot.pathExtension;
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			switchToNativeContext();

			waitForElementToBeClickable(Locator_firstLocname);
			clickElement(Locator_firstLocname);

			waitForElementToBeClickable(EditBtnLocDetailsPg);
			clickElement(EditBtnLocDetailsPg);

			String Name = getElementText(NewLocation);

			clickElement(NewLocation);
			clearElement(NewLocation);
			sendText(NewLocation, editlocation);

			waitForElementToBeClickable(LocationDry);
			clickElement(LocationDry);

			waitForElementToBeClickable(Update);
			clickElement(Update);

			switchToWebContext();
			waitForElementToBeClickable(Back);
			clickElement(Back);

			Reporter.log("Edit location  :Pass");
		} catch (Exception e) {
			Reporter.log("Edit location  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;
	}
*/
	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnEdit(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Editing");
		try {

			waitForElementToBeClickable(EditWeb);
			if (isElementPresent(EditWeb)) {
				clickElement(EditWeb);
				Reporter.log("tap on edit :Pass");
			}

		} catch (Exception e) {
			Reporter.log("tap on edit :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnDeleteLocation(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Delete cliking");
		try {

			waitFor(2);
			waitForElementToBeClickable(Delete);
			if (isElementPresent(Delete)) {

				clickElement(Delete);

				Reporter.log("tap on delete :Pass");
			}

		} catch (Exception e) {
			Reporter.log("tap on delete :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnYesDelete(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Deleted");
		try {

			waitFor(2);
			waitForElementToBeClickable(YesDelete);
			if (isElementPresent(YesDelete)) {

				clickElement(YesDelete);

				Reporter.log("tap on yes delete button :Pass");
			}

		} catch (Exception e) {
			Reporter.log("tap on yes delete button :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyCancelledLocationList(String locationAdded, String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Checking addeded Location in location list");
		try {
			waitFor(2);
			String AddedLocation = locationAdded;
			final String LocAdded = 
					"//*[@id='list-item']//span[contains(text(),'" + AddedLocation + "')]";

			if (isElementPresent(LocAdded)) {
				Reporter.log("Cancelled Location is there :Fail");
				Assert.assertTrue(false);
			}
			Reporter.log("Cancelled location is not listed   :Pass");
		} catch (Exception e) {
			Reporter.log("Cancelled location is  listed   :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddItemFrom_OrderGuide(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitForElementToBeClickable(AddItem_OrderGuide);

			if (isElementPresent(AddItem_OrderGuide)) {

				clickElement(AddItem_OrderGuide);

				Reporter.log("Order Guide clickElement : Pass");

			}

		} catch (Exception e) {
			Reporter.log("Order Guide clickElement : Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}
	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocation_ProductDetailsPage(String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			waitForElementToBeClickable(AddProductPage_AddLocations);
			if (isElementPresent(AddProductPage_AddLocations)) {
				clickElement(AddProductPage_AddLocations);
			}
			Reporter.log("Selected locations : Pass");
		} catch (Exception e) {
			Reporter.log("Selected locations :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}


	@SuppressWarnings("rawtypes")
	public LocationsPage AddLocation_AddProductDetailsPage(String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			waitForElementToBeClickable(AddProductPage_AddLocations);
			if (isElementPresent(AddProductPage_AddLocations)) {
				clickElement(AddProductPage_AddLocations);
			}
			Reporter.log("Selected locations : Pass");
		} catch (Exception e) {
			Reporter.log("Selected locations :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ProductSelect(String item, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Selecting an item from location ");
		try {

			final String Product_Select ="//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + item+ "')]/ancestor::div[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__image']//a";
					

			waitForElementToBeClickable(Product_Select);

			clickElement(Product_Select);

			waitForElementToBeClickable(ProductDetailsPage);

			Reporter.log("Selecting an item from location :Pass");
		} catch (Exception e) {
			Reporter.log("Selecting an item from location :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage LocationDoneSelection(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitForElementToBeClickable(LocationsDone);
			if (isElementPresent(LocationsDone)) {

				clickElement(LocationsDone);

				Reporter.log("tap on back :Pass");
			}

		} catch (Exception e) {
			Reporter.log("tap on back :Fail");
			switchToNativeContext();

			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage selectMultipleItemsFromLocation1(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			Reporter.log(" Adding Item from Order Guide");
Thread.sleep(5000);
			waitFor(5);
			waitForElementToBeClickable(Locations_1stItemHeading);

			if (isElementPresent(Locations_1stItemSelect)) {
				locationsNoOfElements1++;
				LocationsItemName1_1 = getElementText(Locations_1stItemHeading);
				clickElement(Locations_1stItemSelect);
				
				final String keyword1 ="//*[@class='mm-c-product-minlist__item']//*[contains(text(),'" + LocationsItemName1_1+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']";
				LocAddedItemId = getElementText(keyword1);
				Loc1AddedItemId_1 = LocAddedItemId.split("/");


			}
			if (isElementPresent(Locations_2ndItemHeading)) {

				locationsNoOfElements1++;
				LocationsItemName1_2 = getElementText(Locations_2ndItemHeading);
				clickElement(Locations_2ndItemSelect);
				
				final String keyword2 = "//*[@class='mm-c-product-minlist__item']//*[contains(text(),'" + LocationsItemName1_2
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']";
				LocAddedItemId =getElementText(keyword2);
				Loc1AddedItemId_2 = LocAddedItemId.split("/");

			}

			if (isElementPresent(Locations_3rdItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName1_3 = getElementText(Locations_3rdItemHeading);
				clickElement(Locations_3rdItemSelect);
				
				final String keyword3 ="//*[@class='mm-c-product-minlist__item']//*[contains(text(),'" + LocationsItemName1_3
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']";
				LocAddedItemId = getElementText(keyword3);
				Loc1AddedItemId_3 = LocAddedItemId.split("/");

			}

			Reporter.log("Multiple items selected :Pass");
		}

		catch (Exception e) {
			Reporter.log("Multiple items selected :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage selectMultipleItemsFromLocation2(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {
Thread.sleep(5000);
			waitFor(5);
			waitForElementToBeClickable(Locations_1stItemHeading);

			if (isElementPresent(Locations_1stItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName2_1 = getElementText(Locations_1stItemHeading);
				clickElement(Locations_1stItemSelect);
				final String keyword1 ="//*[@class='mm-c-product-minlist__item']//*[contains(text(),'" + LocationsItemName2_1
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']";
				LocAddedItemId = getElementText(keyword1);
				Loc2AddedItemId_1 = LocAddedItemId.split("/");


			}
			if (isElementPresent(Locations_2ndItemHeading)) {

				locationsNoOfElements1++;
				LocationsItemName2_2 = getElementText(Locations_2ndItemHeading);
				clickElement(Locations_2ndItemSelect);
				
				final String keyword2 ="//*[@class='mm-c-product-minlist__item']//*[contains(text(),'" + LocationsItemName2_2
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']";
				LocAddedItemId = getElementText(keyword2);
				Loc2AddedItemId_2 = LocAddedItemId.split("/");

			}

			if (isElementPresent(Locations_3rdItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName2_3 = getElementText(Locations_3rdItemHeading);
				clickElement(Locations_3rdItemSelect);
				
				final String keyword3 ="//*[@class='mm-c-product-minlist__item']//*[contains(text(),'" + LocationsItemName2_3
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']";
				LocAddedItemId = getElementText(keyword3);
				Loc2AddedItemId_3 = LocAddedItemId.split("/");

			}
			if (isElementPresent(Locations_4thItemSelect)) {
				
				LocationsItemName2_4 = getElementText(Locations_4thItemHeading);
				
				final String keyword4 ="//*[@class='mm-c-product-minlist__item']//*[contains(text(),'" + LocationsItemName2_4
								+ "')]/following-sibling::div[@class='mm-c-product-minlist__details']";
				LocAddedItemId =getElementText(keyword4);
				Loc2AddedItemId_4 = LocAddedItemId.split("/");
			}

			Reporter.log("Multiple items selected :Pass");
		}

		catch (Exception e) {
			Reporter.log("Multiple items selected :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ItemVerifyOnLocation2(String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("locationItem verify ");
		try {
			 final String Location2_FirstItemSelectedVerify = 
					"//*[contains(text(),'" + Loc2AddedItemId_1[0] + "')]";
		 final String Location2_SecondItemSelectedVerify = 
					"//*[contains(text(),'" + Loc2AddedItemId_2[0] + "')]";
			 final String Location2_ThirdItemSelectedVerify = 
					"//*[contains(text(),'" + Loc2AddedItemId_3[0] + "')]";
			waitForElementToBeClickable(Location2_FirstItemSelectedVerify);
			boolean flag2_1 = isElementPresentAfterWait(Location2_FirstItemSelectedVerify, 3).booleanValue();
			boolean flag2_2 = isElementPresentAfterWait(Location2_SecondItemSelectedVerify, 3).booleanValue();
			boolean flag2_3 = isElementPresentAfterWait(Location2_ThirdItemSelectedVerify, 3).booleanValue();

			if (!(flag2_1 && flag2_2 && flag2_3)) {
				throw new Exception();
			}
			Reporter.log("Item verification done :Pass");
		} catch (Exception e) {
			Reporter.log("Item verification done  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ItemVerifyOnLocation1(String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("locationItem verify ");
		try {
			final String Location1_FirstItemSelectedVerify =
					"//*[contains(text(),'" + Loc1AddedItemId_1[0] + "')]";
			 final String Location1_SecondItemSelectedVerify =
					"//*[contains(text(),'" + Loc1AddedItemId_2[0] + "')]";
			 final String Location1_ThirdItemSelectedVerify = 
					"//*[contains(text(),'" + Loc1AddedItemId_3[0] + "')]";
			
			System.out.println("ids"+Loc1AddedItemId_2[0]);
			waitForElementToBeClickable(Location1_FirstItemSelectedVerify);
			boolean flag1_1 = isElementPresentAfterWait(Location1_FirstItemSelectedVerify, 3);
			boolean flag1_2 = isElementPresentAfterWait(Location1_SecondItemSelectedVerify, 3);
			boolean flag1_3 = isElementPresentAfterWait(Location1_ThirdItemSelectedVerify, 3);

		
			System.out.println(flag1_1);
			
			if (!(flag1_1 && flag1_2 && flag1_3)) {
				throw new Exception();
			}
			Reporter.log("Item verification done :Pass");
			count1=3;
		} catch (Exception e) {
			Reporter.log("Item verification done  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AddCategory_AddProductDetailsPage(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			waitForElementToBeClickable(AddProductPage_AddCategory);
			if (isElementPresent(AddProductPage_AddCategory)) {
				clickElement(AddProductPage_AddCategory);
			}
			Reporter.log("Selected add category : Pass");
		} catch (Exception e) {
			Reporter.log("Selected add category :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ProductQtyEnter(String qty, String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Quantity entering  ");
		try {

			waitForElementToBeClickable(LocationItem1_QuantityInput);
			
					isElementPresent(LocationItem1_QuantityInput);

			sendText(LocationItem1_QuantityInput, qty);

			Reporter.log("Quantity entered in locations page :Pass");
		} catch (Exception e) {
			Reporter.log("Quantity entered in locations page:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage UomEnterOZ(String uom, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Quantity entering  ");
		try {
			waitForElementToBeClickable(UomUNITOZ);
			clickElement(UomUNITOZ);

			Reporter.log("Uom entered in locations page :Pass");
		} catch (Exception e) {
			Reporter.log("Uom entered in locations page:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage QuantityVerify(String qty, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Quantity verification ");
		try {

			String locationInputTextBox3 = "//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"
					+ qty + "']";
			final String InputTextBoxCheck1 = locationInputTextBox3;

			boolean flag = isElementPresentAfterWait(InputTextBoxCheck1, 5);
			System.out.println("Flag1: " + flag);

			if (!flag) {
				throw new Exception();
			}

			Reporter.log("Quantities updated :Pass");
		} catch (Exception e) {
			Reporter.log("Quantities updated:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AssignMultipleListItemsToLocation(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			Reporter.log(" Adding Items of multiplelist to location");
			waitFor(5);
			waitForElementToBeClickable(Locations_1stItemHeading);
			waitForElementToBeClickable(Locations_1stItemSelect);
			waitForElementToBeClickable(Locations_2ndItemSelect);
			waitForElementToBeClickable(Locations_NonSyscoItem1Select);
			waitForElementToBeClickable(Locations_NonSyscoItem2Select);

			if (isElementPresent(Locations_1stItemSelect)) {
				locationsNoOfElements1++;
				LocationsItemName1_1 = getElementText(Locations_1stItemHeading);
				clickElement(Locations_1stItemSelect);

			}
			if (isElementPresent(Locations_2ndItemHeading)) {

				locationsNoOfElements1++;
				LocationsItemName1_2 = getElementText(Locations_2ndItemHeading);
				clickElement(Locations_2ndItemSelect);
			}

			if (isElementPresent(Locations_3rdItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName1_3 = getElementText(Locations_3rdItemHeading);
				clickElement(Locations_NonSyscoItem1Select);
			}

			if (isElementPresent(Locations_4thItemHeading)) {
				locationsNoOfElements1++;
				LocationsItemName1_4 = getElementText(Locations_4thItemHeading);
				clickElement(Locations_NonSyscoItem2Select);
			}

			Reporter.log("Multiple items selected :Pass");
		}

		catch (Exception e) {
			Reporter.log("Multiple items selected :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage AllItemsTabclickElement(String string) throws InterruptedException, IOException {

		Reporter.log("Selecting item");
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {
			waitForElementToBeClickable(LocationsPage_Header);

			if (isElementPresent(LocationsPage_Header)) {
				clickElement(SetupInventoryLocationAllItemsTab);
				waitFor(3);

				Reporter.log("Selected all items tab :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Selected all items tab:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyMultipleListItemsInLocation(String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("locationItem verify ");
		try {
			 final String Location1_FirstItemSelectedVerify =
					"//*[contains(text(),'" + Loc1AddedItemId_1[0] + "')]";
			 final String Location1_SecondItemSelectedVerify =
					"//*[contains(text(),'" + Loc1AddedItemId_2[0] + "')]";
			 final String Location1_ThirdItemSelectedVerify = 
					"//*[contains(text(),'" + Loc1AddedItemId_3[0] + "')]";
			
			waitForElementToBeClickable(Location1_FirstItemSelectedVerify);
			boolean flag1_1 = isElementPresentAfterWait(Location1_FirstItemSelectedVerify, 3);
			boolean flag1_2 = isElementPresentAfterWait(Location1_SecondItemSelectedVerify, 3);
			boolean flag1_3 = isElementPresentAfterWait(Location1_ThirdItemSelectedVerify, 3);
			boolean flag1_4 = isElementPresentAfterWait(Location1_FourthItemSelectedVerify, 3);

			if (!(flag1_1 && flag1_2 && flag1_3 && flag1_4)) {
				throw new Exception();
			}
			Reporter.log("Items verification done :Pass");
		} catch (Exception e) {
			Reporter.log("Items verification done  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage CustomCategories(String string) throws InterruptedException, IOException {
		Reporter.log("Selecting custom category from Locations page");

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitForElementToBeClickable(CustomCategories);

			if (isElementPresent(CustomCategories)) {
				clickElement(CustomCategories);

				Reporter.log("Custom category selected from locations page :Pass");

			}

		} catch (Exception e) {
			Reporter.log("Custom category selected from locations page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ListNames(String string) throws InterruptedException, IOException {
		Reporter.log("Selecting custom category from Locations page");

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			waitForElementToBeClickable(ListNames);

			if (isElementPresent(ListNames)) {
				clickElement(ListNames);

				Reporter.log("List Names selected from locations page :Pass");

			}

		} catch (Exception e) {
			Reporter.log("List Names selected from locations page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyListItemsOnLocation(String item1, String item2, String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("locationItem verify ");
		try {

			final String Locations_Productcheck = 
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + item1 + "')]";
					
			final String Locations_Productcheck1 = 
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + item2 + "')]";
					

			boolean flag = isElementPresentAfterWait(Locations_Productcheck, 3);
			boolean flag1 = isElementPresentAfterWait(Locations_Productcheck1, 3);

			if (!(flag && flag1)) {
				throw new Exception();
			}

			Reporter.log("Item verification done :Pass");
		} catch (Exception e) {
			Reporter.log("Item verification done  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage NonSyscoPrepCategoryIdentify(String nonsysco, String prep, String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("category verify ");
		try {
			System.out.println("inside veify");

			final String Nonsyscoitem_Heading =
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ nonsysco + "')]";
					
			final String Prepitem_Heading = 
					"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ prep + "')]";
					

			if (isElementPresent(Nonsyscoitem_Heading)) {
				final String Nonsysco_CategoryLine1 =
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + nonsysco
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']" ;
						

				Nonsysco_categoryKeyword1 = getElementText(Nonsysco_CategoryLine1);

				NonSysco_Category1 = Nonsysco_categoryKeyword1.split("\\s+");

			}

			if (isElementPresent(Prepitem_Heading)) {
				final String Prep_CategoryLine1 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + prep
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']",
						

				Prep_categoryKeyword1 = getElementText(Prep_CategoryLine1);

				Prep_Category1 = Prep_categoryKeyword1.split("\\s+");

			}

			Reporter.log("Categories identified for nonsyscoitems :Pass");
		}

		catch (Exception e) {
			Reporter.log("Categories identified for nonsyscoitems :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage DeleteItems(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Delete cliking");
		try {

			waitForElementToBeClickable(Locations_Item1DeleteHeading);
			if (isElementPresent(Locations_Item1DeleteHeading)) {
				LocationsDeleteItemName1_1 = getElementText(Locations_Item1DeleteHeading);

				final String keyword1 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
								+ LocationsDeleteItemName1_1
								+ "')]/following-sibling::div[@class='mm-c-product-list__details']";
				String LocationsDeleteItemId = getElementText(keyword1);
				LocationsDeleteItemId1_1 = LocationsDeleteItemId.split("\\s+");
				clickElement(Locations_Item1Delete); // deleting first
															// item in location

				LocationsDeleteItemName1_2 = getElementText(Locations_Item2DeleteHeading);

				final String keyword2 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
								+ LocationsDeleteItemName1_2
								+ "')]/following-sibling::div[@class='mm-c-product-list__details']";
						
				LocationsDeleteItemId = getElementText(keyword2);
				LocationsDeleteItemId1_2 = LocationsDeleteItemId.split("\\s+");
				clickElement(Locations_Item2Delete); // deleting 2nd item
															// in location

				Reporter.log("Deleting items :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Deleting items :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyDeleteItemsList(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Checking addeded Location in location list");
		try {

			
			final String DeleteItem1 = 
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ LocationsDeleteItemId1_1[0] + "')]";
					
			final String DeleteItem2 = 
					"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
							+ LocationsDeleteItemId1_2[0] + "')]";
					

			boolean flag = isElementPresentAfterWait(DeleteItem1, 3);
			boolean flag1 = isElementPresentAfterWait(DeleteItem2, 3);

			if ((flag || flag1)) {
				throw new Exception();
			}

			Reporter.log("Deleted items is not listed   :Pass");
		} catch (Exception e) {
			Reporter.log("Deleted items is listed   :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	public LocationsPage tapOnProductOpenProductDetailsPageAndEnterQty(String prepItemName, String quantity,
			String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("tapOnProductOpenProductDetailsPageAndEnterQty");
		try {

			final String LocationItemProdDetailsEnterQuantity = 
					"//*[@class='mm-c-product-details__select-options']//*[@type='number']";

			clickElement(LocationItemProdDetailsEnterQuantity);
			waitForElementToBeClickable(LocationItemProdDetailsEnterQuantity);
			sendText(LocationItemProdDetailsEnterQuantity, quantity);

			Reporter.log("tapOnProductOpenProductDetailsPageAndEnterQty :Pass");
		} catch (Exception e) {
			Reporter.log("tapOnProductOpenProductDetailsPageAndEnterQty :Fail");
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	
	@SuppressWarnings("rawtypes")
	public LocationsPage SyscoCategoryIdentify(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("category verify ");
		try {

			final String Location1_FirstItemSelectedVerify = 
					"//*[contains(text(),'" + LocationsItemName1_1 + "')]";
			final String Location1_SecondItemSelectedVerify = 
					"//*[contains(text(),'" + LocationsItemName1_2 + "')]";
			final String Location1_ThirdItemSelectedVerify = 
					"//*[contains(text(),'" + LocationsItemName1_3 + "')]";
			final String Location1_FourthItemSelectedVerify =
					"//*[contains(text(),'" + LocationsItemName1_4 + "')]";

			final String Location2_FirstItemSelectedVerify = 
					"//*[contains(text(),'" + LocationsItemName2_1 + "')]";
			final String Location2_SecondItemSelectedVerify = 
					"//*[contains(text(),'" + LocationsItemName2_2 + "')]";
			final String Location2_ThirdItemSelectedVerify =
					"//*[contains(text(),'" + LocationsItemName2_3 + "')]";

			// syscoitems added from multiple lists
			if (isElementPresent(Location1_ThirdItemSelectedVerify)) {
				final String CategoryLine1 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_3
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']";
						

				categoryKeyword1 = getElementText(CategoryLine1);

				Category1 = categoryKeyword1.split("\\s+");

			}

			if (isElementPresent(Location1_FourthItemSelectedVerify)) {
				final String CategoryLine2 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_4
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']";
						

				categoryKeyword2 = getElementText(CategoryLine2);

				Category2 = categoryKeyword2.split("\\s+");

			}

			// syscoitems added from orderguide to location1

			if (isElementPresent(Location1_FirstItemSelectedVerify)) {
				final String CategoryLine3 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_1
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']";
						

				categoryKeyword3 = getElementText(CategoryLine3);

				Category3 = categoryKeyword3.split("\\s+");
			}

			if (isElementPresent(Location1_SecondItemSelectedVerify)) {
				final String CategoryLine4 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_2
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']";
						

				categoryKeyword4 = getElementText(CategoryLine4);

				Category4 = categoryKeyword4.split("\\s+");
			}

			if (isElementPresent(Location1_ThirdItemSelectedVerify)) {
				final String CategoryLine5 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName1_3
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']";
						

				categoryKeyword5 = getElementText(CategoryLine5);

				Category5 = categoryKeyword5.split("\\s+");

			}

			// syscoitem added from Orderguide to location2
			if (isElementPresent(Location2_FirstItemSelectedVerify)) {
				final String CategoryLine6 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName2_1
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']";
						

				categoryKeyword6 = getElementText(CategoryLine6);

				Category6 = categoryKeyword6.split("\\s+");

			}

			if (isElementPresent(Location2_SecondItemSelectedVerify)) {
				final String CategoryLine7 =
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName2_2
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']";
						

				categoryKeyword7 = getElementText(CategoryLine7);

				Category7 = categoryKeyword7.split("\\s+");

			}

			if (isElementPresent(Location2_ThirdItemSelectedVerify)) {
				final String CategoryLine8 = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + LocationsItemName2_3
								+ "')]/ancestor::div[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__location']";
						

				categoryKeyword8 = getElementText(CategoryLine8);

				Category8 = categoryKeyword8.split("\\s+");

			}

			Reporter.log("Categories identified for syscoitems :Pass");
		} catch (Exception e) {
			Reporter.log("Categories identified for syscoitems :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyItemsOnDefaultLocation(String location, String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			if (isElementPresent(ItemVerify)) {
			
				getElementCount(ItemVerify);
			count=jsn_Framework.noOfElements;
				waitFor(5);
				final String Locations_check = 
						"//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"
								+ location + "')]";
				if (isElementPresent(Locations_check)) {

					Reporter.log("Item verification done :Pass");
				} else {

					throw new Exception();
				}

			}

		} catch (Exception e) {
			Reporter.log("Item verification done  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyOptionsOnSetupLocations(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Set up locations page verify ");
		try {

			if (isElementPresent(DefaultLocation) && isElementPresent(DefaultLocationDesc)
					&& isElementPresent(CustomLocations)
					&& isElementPresent(CustomLocationsDesc)) {
				Reporter.log("Set up location verification done :Pass");
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			Reporter.log("Set up location verification done  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage PdtDetailPage_Location1_EnterQty(String quantity, String loc1, String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			final String LocationItemProdDetailsEnterQuantity = 
					"//*[@class='input-group']//*[contains(text(),'" + loc1
							+ "')]/ancestor::div[@class='input-group']//*[@type='number']";
					

			clickElement(LocationItemProdDetailsEnterQuantity);
			clearElement(LocationItemProdDetailsEnterQuantity);
			sendText(LocationItemProdDetailsEnterQuantity, quantity);

			Reporter.log("Entered qty on first location on product detail page :Pass");
		} catch (Exception e) {
			Reporter.log("Entered qty on first location on product detail page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage PdtDetailPage_Location2_EnterQty(String quantity, String loc2, String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {
			final String LocationItemProdDetailsEnterQuantity =
					"//*[@class='input-group']//*[contains(text(),'" + loc2
							+ "')]/ancestor::div[@class='input-group']//*[@type='number']";
					

			clickElement(LocationItemProdDetailsEnterQuantity);
			clearElement(LocationItemProdDetailsEnterQuantity);
			sendText(LocationItemProdDetailsEnterQuantity, quantity);

			Reporter.log("Entered qty on second location on product detail page :Pass");
		} catch (Exception e) {
			Reporter.log("Entered qty on second location on product detail page :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage verifyLocations2(String string, String locationName, String locationNumber) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Entering anotherloc");

		try {
			final String LocationnameNumberVerification = 
					"//*[contains(text(),'" + locationName + "')]";
			waitForElementToBeClickable(LocationnameNumberVerification);
			String locationNameToBeVerified = getElementText(LocationnameNumberVerification);
			if (!(locationNameToBeVerified.contains(locationNumber))) {
				throw new Exception();
			}

			Reporter.log("Entered second loc in Locations page :Pass");

		} catch (Exception e) {
			Reporter.log("LocationName(x) :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage SyscoProductSelect(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Selecting sysco item from location ");
		try {

			final String Product_Select =
					"((//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[contains(text(),'"
							+ SetupInventoryPage.AddedItemId1[0]
							+ "')]/ancestor::div[@class='mm-c-product-list__details-wrapper'])//a)[1]";
					

			waitForElementToBeClickable(Product_Select);
			
			clickElement(Product_Select);
			waitForElementToBeClickable(ProductDetailsPage);
			Reporter.log("Selecting an item from location :Pass");
		} catch (Exception e) {
			Reporter.log("Selecting an item from location :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage EditProduct_NickName(String nickName, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		Reporter.log("Assigining nickname to product");
		try {

			waitForElementToBeClickable(EditProduct_Page);

			if (isElementPresent(Product_NickName)) {

				sendText(Product_NickName, nickName);

				Reporter.log("Assigining nickname to product: Pass");

			}

		} catch (Exception e) {
			Reporter.log("Assigining nickname to product: Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyOrderOfLocations(String cooler, String freezer, String dry, String noloc,
			String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Order of locations verify");
		try {

			String firstLoc = getElementText(FirstLocation).toString();
			String secondLoc = getElementText(SecondLocation).toString();
			String thirdLoc = getElementText(ThirdLocation).toString();
			
			
			if(isElementPresentAfterWait(FourthLocation, 3)){
				System.out.println("fourth location present");
			String fourthLoc = getElementText(FourthLocation).toString();
			System.out.println(fourthLoc);
			System.out.println("datapool"+noloc);
			//fourthLoc = fourthLoc.toLowerCase();
			if (firstLoc.contains(cooler) && secondLoc.contains(freezer) && thirdLoc.contains(dry)
					&& fourthLoc.contains(noloc)) {
				Reporter.log("VerifyOrderOfLocations:Pass");
			} else {
				System.out.println("Order incorrect");
				throw new Exception();
			    }
			}
			else{
				System.out.println("3rd location present");
				System.out.println(firstLoc+secondLoc+thirdLoc);
				
				if (firstLoc.contains(cooler) && secondLoc.contains(freezer) && thirdLoc.contains(dry)) {
					
					Reporter.log("VerifyOrderOfLocations:Pass");
				} else {
					System.out.println("Order incorrect");
					throw new Exception();
				}
				}	

		} catch (Exception e) {
			Reporter.log("VerifyOrderOfLocations :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public LocationsPage AddLocationFreezer(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		try {

			
			waitForElementToBeClickable(AddLocation_LocTypeCoolerWeb);
			clickElement(AddLocation_LocTypeCoolerWeb);

			
			Reporter.log("Selected Cooler :Pass");
		}

		catch (Exception e) {
			Reporter.log("Selected Cooler :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage ViewItemsOnLocation(String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;
		try {

			waitForElementToBeClickable(ViewItemsOnLocation);

			clickElement(ViewItemsOnLocation);
			Reporter.log("tap on view items on location  :Pass");

		} catch (Exception e) {
			Reporter.log("tap on view items on location  :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyCustomListItemsCustomLocation(String location, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Verifying location of items ");
		try {

			waitFor(5);
			final String Locations_check1 = 
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"
							+ location + "')])[1]";
					
			final String Locations_check2 = 
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"
							+ location + "')])[2]";
					
			final String Locations_check3 =
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"
							+ location + "')])[3]";
					

			boolean flag1 = isElementPresentAfterWait(Locations_check1, 3);
			boolean flag2 = isElementPresentAfterWait(Locations_check2, 3);
			boolean flag3 = isElementPresentAfterWait(Locations_check3, 3);

			if (!(flag1 && flag2 && flag3)) {
				throw new Exception();
			}

			Reporter.log("Verifying location of items  :Pass");
		} catch (Exception e) {
			Reporter.log("Verifying location of items   :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyDeletedItemsCategory(String location, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Boolean flag1 = false, flag2 = false, flag3 = false;

		Reporter.log("Verifying category of items ");
		try {

			waitFor(5);
			final String Locations_check1 = 
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location'])[1]";
					
			final String Locations_check2 =
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location'])[2]";
					
			final String Locations_check3 = 
					"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location'])[3]";
					

			DeletedCategory1 = getElementText(Locations_check1);
			DeletedCategory2 = getElementText(Locations_check2);
			DeletedCategory3 = getElementText(Locations_check3);

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

			Reporter.log("Verifying category of items  :Pass");
		} catch (Exception e) {
			Reporter.log("Verifying category of items    :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyMultipleOGItemsCount(String locationName, String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Verifying item count");

		try {

			final String LocationnameNumberVerification = 
					"//*[contains(text(),'" + locationName + "')]";

			waitForElementToBeClickable(LocationnameNumberVerification);

			String locationNameToBeVerified = getElementText(LocationnameNumberVerification);

			if (!(locationNameToBeVerified.contains("SetupInventoryPage.noOfElements"))) {

				throw new Exception();

			}

			Reporter.log("Item count verified :Pass");

		}

		catch (Exception e) {
			Reporter.log("Item count verified,LocationName(x) :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyCountOfItemsInLocation(String locationName, String string) throws InterruptedException, IOException {
		String string2 = "Issue";
		String finalPath1 = Screenshot.drivePath + string + string2 + Screenshot.pathExtension;

		Reporter.log("Verifying item count");

		try {

			final String LocationnameNumberVerification =
					"//*[contains(text(),'" + locationName + "')]";

			waitForElementToBeClickable(LocationnameNumberVerification);

			String locationNameToBeVerified = getElementText(LocationnameNumberVerification);

			if (!(locationNameToBeVerified.contains("(" + count.toString() + ")"))) {

				throw new Exception();

			}

			Reporter.log("Item count verified :Pass");

		}

		catch (Exception e) {
			Reporter.log("Item count verified,LocationName(x) :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}
		return this;

	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public LocationsPage TapOnCancel(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		try {
		
			waitForElementToBeClickable(Cancel);
			if (isElementPresent(Cancel)) {

				clickElement(Cancel);
				Reporter.log("Tapped on Cancel");

			}
			
		} catch (Exception e) {
			Reporter.log("Tapped on Cancel :Fail");
			switchToNativeContext();
			
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public LocationsPage verifyUIAfterSearch(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;
		try {
		
			
			boolean flag = isElementPresent(EditWeb);
			boolean flag1 = isElementPresent(AddWeb);
			boolean flag2 = isElementPresent(Done);
			
			if (flag||flag1||flag2) {
				throw new Exception();
			}
			
			Reporter.log("verify UI After Search :Pass");
		}

		catch (Exception e) {
			Reporter.log("verify UI After Search :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public LocationsPage GetLocationsNameText(String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
	    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
	    
		
	try{	
	  final String ItemNameHeading= "define";
			if(isElementPresent(ItemNameHeading)){
				final String locationNames= "locationNames";
				String SyscocategoryKeyword1 = getElementText(locationNames);
					locationNamesArray1 = SyscocategoryKeyword1.split("/");
					locationNamesArray = locationNamesArray1[1].split(",");

			}
		   
			Reporter.log("Location Names are stored into an Array :Pass");						
		}
		
		
		
		catch(Exception e){
			Reporter.log("Location Names are stored into an Array  :Fail");
			switchToNativeContext(); 
			 takeScreenshot(finalPath1); 
			
			Assert.assertTrue(false);
		}
		return this;
		
	}
	@SuppressWarnings("rawtypes")
	public LocationsPage VerifyOptionsOnCustomLocations(String string) throws InterruptedException, IOException {

		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
		Reporter.log("Custom locations page verify ");
		try {
			
			waitForElementToBeClickable(SetUp_Pg2Header);
			
			if (isElementPresent(CreateLocationDesc) && isElementPresent(SetUp_Pg2Header)
					&& isElementPresent(ADD_AnotherLocation)) {
				Reporter.log("All options are there");
			} else {

				throw new Exception();
			}

			Reporter.log("Custom  location verification done :Pass");
		} catch (Exception e) {
			Reporter.log("Custom location verification done  :Fail");
			switchToNativeContext(); 
			 takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}
	
	@SuppressWarnings("rawtypes")
	public LocationsPage CustomLocItemsCheckInNoLocation(String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
	    
	    Reporter.log("No location Items verification ");
	    
	    final String Loc1_1stItemHeading = 
				"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
						+ Loc1AddedItemId_1[0] + "')]";
		final String Loc1_2ndItemHeading = 
				"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
						+ Loc1AddedItemId_2[0] + "')]";
		final String Loc1_3rdItemHeading = 
				"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
						+ Loc1AddedItemId_3[0] + "')]";
		final String Loc2_1stItemHeading = 
				"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
						+ Loc2AddedItemId_1[0] + "')]";
		final String Loc2_2ndItemHeading =
				"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
						+ Loc2AddedItemId_2[0] + "')]";
		final String Loc2_3rdItemHeading = 
				"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
						+ Loc2AddedItemId_3[0] + "')]";
		
		final String Loc2_4thItemHeading = 
				"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
						+ Loc2AddedItemId_4[0] + "')]";

		waitFor(5);
		
	try{	
		
		boolean flag1_1 = isElementPresent(Loc1_1stItemHeading).booleanValue();
		boolean flag1_2 = isElementPresent(Loc1_2ndItemHeading).booleanValue();
		boolean flag1_3 = isElementPresent(Loc1_3rdItemHeading).booleanValue();
		boolean flag2_1 = isElementPresent(Loc2_1stItemHeading).booleanValue();
		boolean flag2_2 = isElementPresent(Loc2_2ndItemHeading).booleanValue();
		boolean flag2_3 = isElementPresent(Loc2_3rdItemHeading).booleanValue();
		boolean flag2_4 = isElementPresent(Loc2_4thItemHeading).booleanValue();
		
		/*boolean flag1_1 = driver.findElement(By.xpath(Loc1_1stItemHeading)).isDisplayed();
		boolean flag1_2 = driver.findElement(By.xpath(Loc1_2ndItemHeading)).isDisplayed();
		boolean flag1_3 = driver.findElement(By.xpath(Loc1_3rdItemHeading)).isDisplayed();
		boolean flag2_1 = driver.findElement(By.xpath(Loc2_1stItemHeading)).isDisplayed();
		boolean flag2_2 = driver.findElement(By.xpath(Loc2_2ndItemHeading)).isDisplayed();
		boolean flag2_3 = driver.findElement(By.xpath(Loc2_3rdItemHeading)).isDisplayed();
		boolean flag2_4 =driver.findElement(By.xpath(Loc2_4thItemHeading)).isDisplayed();*/
		
		
		if ((flag1_1 || flag1_2 || flag1_3 || flag2_1 || flag2_2 || flag2_3)) {
			
			throw new Exception();
		}
		
		if (flag2_4) {
		
			Reporter.log("Items in custom location are not assigned to no location : Pass");
		}
		
		
		}
		
		
		
		catch(Exception e){
			Reporter.log("Items in custom location are not assigned to no location :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public LocationsPage NoItemsCheckInNoLocation(String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
	    
	    Reporter.log("No location Items verification ");
	    
	    final String Location_FirstItemVerify = 
				"(//*[@class='mm-c-product-list__details']//h4)[1]";
		

		waitFor(5);
		
		
	try{	
		
		boolean flag1_1 = isElementPresent(Location_FirstItemVerify);
			
		if ((flag1_1 )) {
			
			throw new Exception();
			
		}
		
		else {
			Reporter.log("No items present in no location: Pass");
			
		}
		
		}
		
			catch(Exception e){
				Reporter.log("No items present in no location:Fail");
				switchToNativeContext();
				takeScreenshot(finalPath1); 
			
			Assert.assertTrue(false);
		}
		return this;
		
	}
	
	@SuppressWarnings("rawtypes")
	public LocationsPage NoLocationTextCheck(String loc,String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
	    Reporter.log("No location text verification ");
	  

		waitFor(5);
		
		final String Locations_check1 = 
				"(//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__details']//*[@class='mm-c-product-list__location']//*[contains(text(),'"+loc+"')])";
		
	try{	
		boolean flag1_1 = isElementPresentAfterWait( Locations_check1, 3).booleanValue();
		if (flag1_1) {
			
			throw new Exception();
		}

		Reporter.log("Items in no location are not associated with no location text : Pass");
		}
		
			catch(Exception e){
				Reporter.log("Items in no location are not associated with no location text  :Fail");
				switchToNativeContext();
				takeScreenshot(finalPath1); 
			
			Assert.assertTrue(false);
		}
		return this;
		
	}
	
	@SuppressWarnings("rawtypes")
	public LocationsPage UncategorizedItemsCheckInNoLocation(String listUnCatProduct1DataPool,String listUnCatProduct2DataPool,String listUnCatProduct2DataPool2, String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
	    Reporter.log("No location Items verification ");
	    
	
	try{	
		

		final String Locations_Productcheck = 
				"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text();'" + listUnCatProduct1DataPool + "')]";
		
		final String Locations_Productcheck1 = 
				"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + listUnCatProduct2DataPool + "')]";
			
		final String Locations_Productcheck2 = 
				"//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'" + listUnCatProduct2DataPool2 + "')]";
		
		boolean flag = isElementPresentAfterWait(Locations_Productcheck, 3);
		boolean flag1 = isElementPresentAfterWait(Locations_Productcheck1, 3);
		boolean flag2 = isElementPresentAfterWait(Locations_Productcheck2, 3);
		if (!(flag && flag1 && flag2)) {
			throw new Exception();
		}
		Reporter.log("Uncategorized items present in no location:Pass");
		}
		
			catch(Exception e){
				Reporter.log("Uncategorized items present in no location:Fail");
				switchToNativeContext();
				takeScreenshot(finalPath1); 
			
			Assert.assertTrue(false);
		}
		return this;
		
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public LocationsPage NoLocationEdit(String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
	    
	Reporter.log("No location  verification ");
	  

		waitFor(5);
		
		
	try{
		
		final String keyword1 ="(//*[@class='mm-c-product-list__description'])[1]";
		NoLocItemId = getElementText(keyword1);
		NoLocItemId_1 = NoLocItemId.split("/");
		
		 
		boolean flag = isElementPresent(EditWeb);
		boolean flag1 = isElementPresent(AddWeb);
		boolean flag2 = isElementPresent(Done);
		
		if (flag||flag1||flag2) {
			throw new Exception();
		}
	Reporter.log("No operations can be performed in No location  :Pass");
		
		}
		
			catch(Exception e){
				Reporter.log("No operations can be performed in No location  :Fail");
				switchToNativeContext();
				takeScreenshot(finalPath1);
	
			Assert.assertTrue(false);
		}
		return this;
		
	}
	

	@SuppressWarnings("rawtypes")
	public LocationsPage LocationFirstItemCheck(String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
	    
	Reporter.log("No location item verification in another location ");
	  

		waitFor(5);
		
		
		
	try{
		final String Loc_FirstItemID= 
				"//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"
						+ NoLocItemId_1[0] + "')]";
				

		Boolean boolean1 = isElementPresent(Loc_FirstItemID); 
		if (boolean1) {
			throw new Exception();

		}
		Reporter.log("Items in no location is not available in other location:Pass");	
		}
		
			catch(Exception e){
				Reporter.log("Items in no location is not available in other location:Fail");
				switchToNativeContext();
				takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}
		return this;
		
	}

	
	@SuppressWarnings("rawtypes")
	public LocationsPage LocationsDelete(String string) throws InterruptedException, IOException
	{
		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
	    Reporter.log("Deleting locations from product card");
	  
	    waitFor(5);
		
	try{
		clickElement(ProductCardDelete_Loc1);
	//	clickElement(ProductCardDelete_Loc2);
		
		waitForElementToBeClickable(ProductCardDeleteAllLoc_Confirmation);
		
		Reporter.log("Deleting all locations from product card:Pass");
		
		}
		
			catch(Exception e){
				Reporter.log("Deleting all locations from product card :Fail");
				switchToNativeContext();
				takeScreenshot(finalPath1); 
			
			Assert.assertTrue(false);
		}
		return this;
		
	}
	
	@SuppressWarnings("rawtypes")
	public LocationsPage TapOnNoDelete(String string) throws InterruptedException, IOException {

		  String string2="Issue";
		    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
		   
	Reporter.log("Deleted");
		try {
			waitForElementToBeClickable(NoDelete);
			if (isElementPresent(NoDelete)) {

				clickElement(NoDelete);

		Reporter.log("Tap on no delete button :Pass");
			}

		} catch (Exception e) {
			Reporter.log("Tap on no delete button :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
		

			Assert.assertTrue(false);
		}

		return this;
	}


@SuppressWarnings("rawtypes")
	public LocationsPage LocationsDelete(String loc,String string) throws InterruptedException, IOException
	{
	String string2="Issue";
    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
 
//	    Reporter.log("Deleting locations from product card");
	  
	    waitFor(5);
		final String LocDelete_Icon= 
				"//*[contains(text(),'"+loc+"')]/ancestor::div[@class='mm-c-product-details__location']//*[@class='mm-o-icon icon-minus-circle']";
				
	try{
		
		clickElement(LocDelete_Icon);
		
		
		Reporter.log("Deleting location from product card:Pass");
			
		}
		
			catch(Exception e){
				Reporter.log("Deleting  location from product card :Fail");
				switchToNativeContext();
				takeScreenshot(finalPath1); 
			
			Assert.assertTrue(false);
		}
		return this;
		
	}
	@SuppressWarnings("rawtypes")
	public LocationsPage DeleteAllLocConfirmation(String string) throws InterruptedException, IOException {

		String string2="Issue";
	    String finalPath1=Screenshot.drivePath+string+string2+Screenshot.pathExtension;
	 
	Reporter.log("Deleted");
		try {
			
				waitFor(5);
				waitForElementToBeClickable(ProductCardDeleteAllLoc_Confirmation);
						
	Reporter.log("Deleting all locations from product card confirmation:Pass");
				
			

		} catch (Exception e) {
			Reporter.log("Deleting all locations from product card confirmation:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
	
			Assert.assertTrue(false);
		}

		return this;
	}



}
