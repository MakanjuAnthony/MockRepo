
package com.tests;


import org.testng.annotations.Test;


import com.components.entities.Start;
import com.components.yaml.LocationsData;

import com.components.yaml.CategoryData;
import com.components.yaml.ListData;
import com.components.yaml.NonSyscoItemData;
import com.components.yaml.PrepItemData;
import com.components.yaml.ProductNickNameData;
import com.components.yaml.SearchData;
import com.components.yaml.UOMQuantityData;
import com.components.yaml.VendorDetailsData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;


public class WorkFlow extends Initiator{

	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default location and Default category. 
	 * Validating location displayed for first item section on default locations and verifying count of items displayed on each default location.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI - WF 1"},priority=4, description = "SI - WF 1-OG + Dafault Loc + Default Category")
	public void SI_WF1_OG_DefaultLocation_DefaultCategory() {
		LoginData loginData =LoginData.fetch("LoginData1");
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 1-Skip1 Tapped")

		.VerifyOptionsOnImportItems("SI - WF 1-Verified import items page")
		.TapOrderGuide("SI - WF 1-OG Selected")
		.tapContinue("SI - WF 1-Tapped Continue")


		._atLocationsPage()
		.VerifyOptionsOnSetupLocations("SI - WF 1-Location page verified")
		.DefaultLocation("SI - WF 1-Tapped Custom location")
		.tapContinue("SI - WF 1-Tapped Continue")


		._atCategoryPage()
		.VerifyOptionsOnSetUpFoodCost("SI - WF 1-Category page verified")
		.defaultCategories("SI - WF 1-Tapped Default category")
		.tapComplete("SI - WF 1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 1-Tapped take me home")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 1-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locDataCooler.LocationName, "SI - WF 1-Selected cooler")
		.VerifyItemsOnDefaultLocation(locDataCooler.LocationName, "SI - WF 1-Verified cooler")

		.TapOnBack("SI - WF 1-Tapped on Back")
		.VerifyCountOfItemsInLocation(locDataCooler.LocationName, "")

		.SelectLocation(locDataFreezer.LocationName, "SI - WF 1-Selected freezer")
		.VerifyItemsOnDefaultLocation(locDataFreezer.LocationName, "SI - WF 1-Verified freezer")
		.TapOnBack("SI - WF 1-Tapped on Back")
		.VerifyCountOfItemsInLocation(locDataFreezer.LocationName, "")

		.SelectLocation(locDataDry.LocationName, "SI - WF 1-Selected dry")
		.VerifyItemsOnDefaultLocation(locDataDry.LocationName, "SI - WF 1-Verified dry")
		.TapOnBack("SI - WF 1-Tapped on Back")
		.VerifyCountOfItemsInLocation(locDataDry.LocationName, "")

		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Multiple locations and Multiple category. 
	 * Validating items are displayed on appropriate locations on Track Inventory.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI - WF 3"},priority=0, description = "SI - WF 3-OG + Cus Loc + Cust Category")
	public void SI_WF3_OG_CustomMultipleLocation_CustomMultipleCategory() {	

		LoginData loginData =LoginData.fetch("LoginData2");
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 3-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 3-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 3-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 3-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI - WF 3-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 3-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 3-Skip1 Tapped")
		.TapOrderGuide("SI - WF 3-OG Selected")
		.tapContinue("SI - WF 3-Tapped Continue1")

		._atLocationsPage()
		.CustomLocation("SI - WF 3-Tapped Custom location")
		.tapContinue("SI - WF 3-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 3-Enter location name")
		.AddLocations1_TypeDry("SI - WF 3-Tapped Dry1")

		.AddLocations2("SI - WF 3-Second location")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 3-Tapped Dry2")
		.TapOnNext("SI - WF 3-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 3-Selected Multiple items")
		.TapOnNext("SI - WF 3-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 3-Selected Multiple items")
		.TapOnDone("SI - WF 3-Tapped Done1")
		._atSetupInventoryPage()

		._atCategoryPage()
		.CustomCategories("SI - WF 1-CustomCategories Tapped")
		.tapContinue("SI - WF 3-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 3-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 3-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 3-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 3-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 3-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 3-Tapped Done2")
		.TapTakeHome("SI - WF 3-Tapped Continue4") 


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 3-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 3-LocationTap1")
		.ItemVerifyOnLocation1("SI - WF 3-Verify item inside location1")
		.TapOnBack("SI - WF 3-Tap on Back1")
		.SelectLocation(locationsData2.LocationName, "SI - WF 3-LocationTap2")
		.ItemVerifyOnLocation2("SI - WF 3-Verify item inside location2")
		;




	}
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default locations and Multiple category. 
	 * Validating order of default locations on Track Inventory.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI - WF 4"},priority=4, description = "SI - WF 4-OG + Default Loc + Custom Category ")
	public void SI_WF4_OG_DefaultLocation_CustomCategory() {
		LoginData loginData =LoginData.fetch("LoginData3");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		LocationsData locDataNoLoc=LocationsData.fetch("LocatiosData4");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 4-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 4-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 4-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 4-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI - WF 4-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 4-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 4-Skip1 Tapped")
		.TapOrderGuide("SI - WF 4-OG Selected")
		.tapContinue("SI - WF 4-Tapped Continue")


		._atLocationsPage()
		.DefaultLocation("SI - WF 4-Tapped Custom location")
		.tapContinue("SI - WF 4-Tapped Continue")

		._atSetupInventoryPage() 

		._atCategoryPage()
		.CustomCategories("SI - WF 4-CustomCategories Tapped")
		.tapContinue("SI - WF 4-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 4-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 4-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 4-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 4-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 4-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 4-Tapped Done2")
		.TapTakeHome("SI - WF 4-Tapped Continue4") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 4-Selected track inventory")

		._atLocationsPage()
		.VerifyOrderOfLocations(locDataCooler.LocationName, locDataFreezer.LocationName, locDataDry.LocationName, locDataNoLoc.LocationName, "SI - WF 4-Verified order of locations")

		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Multiple locations and Default category. 
	 * Validating items are displayed on appropriate locations on Track Inventory.
	 * Validating items can be viewed by tapping 'View Items' link in Home page>>Location>>Location Details page
	 * Prerequisite:Normal/MA User with OG items.
	 */

	@Test(groups={"SI - WF 5"},priority=4, description = "SI - WF 5-OG + Custom Loc + Default Category")
	public void SI_WF5_OG_CustomLocation_DefaultCategory() {

		LoginData loginData =LoginData.fetch("LoginData4");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 5-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 5-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 5-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 5-Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 5-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 5-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 5-Skip1 Tapped")
		.TapOrderGuide("SI - WF 5-OG Selected")
		.tapContinue("SI - WF 5-Tapped Continue1")

		._atLocationsPage()
		.CustomLocation("SI - WF 5-Tapped Custom location")
		.tapContinue("SI - WF 5-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 5-Enter location name")
		.AddLocations1_TypeDry("SI - WF 5-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 5-Tapped Dry2")
		.TapOnNext("SI - WF 5-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 5-Selected Multiple items")
		.TapOnNext("SI - WF 5-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 3-Selected Multiple items")
		.TapOnDone("SI - WF 5-Tapped Done1")
		._atCategoryPage()
		.defaultCategories("SI - WF 5-Tapped Default category")
		.tapComplete("SI - WF 5-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 5-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 5-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 5-LocationTap1")
		.ItemVerifyOnLocation1("SI - WF 5-Verify item inside location1")
		.TapOnBack("SI - WF 5-Tap on Back1")
		.SelectLocation(locationsData2.LocationName, "SI - WF 5-LocationTap2")
		.ItemVerifyOnLocation2("SI - WF 5-Verify item inside location2")
		.TapOnBack("SI - WF 5-Tap on Back1")
		.TapOnBack("SI - WF 5-Tap on Back1")

		//Validating View items link on locations
		._atInventoryToolPage()
		.InvTools_Locations("SI - WF 5-Tapped Locations")
		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 5-Selecting Location1")
		.ViewItemsOnLocation("SI - WF 5-view items on Location1")
		.ItemVerifyOnLocation1("SI - WF 5-Verify item inside location1")

		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then skip assigning location and category. 
	 * Prerequisite:Normal/MA User with OG items.
	 */

	@Test(groups={"SI - WF 6"},priority=0, description = "SI - WF 6-OG + Skip Loc + Skip Cust")
	public void SI_WF6_OG_SkipLocation_SkipCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 6-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 6-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 6-LoginPage")


		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 6 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 6-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 6-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 6-Skip1 Tapped")
		.TapOrderGuide("SI - WF 6-OG Selected")
		.tapContinue("SI - WF 6-Tapped Continue1")
		.TapOnDOThisLater("SI - WF 6-Do this Later for locations Tapped")
		.TapOnDOThisLater("Do this Later for category Tapped")
		.TapTakeHome("SI - WF 6-Cotinue2 Tapped") 
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 6-Selected track inventory")

		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default locations and skip category.
	 * Validating users cache is not cleared when logout after setting up inventory.  
	 * Validating Track Inventory displayed after setting up inventory.
	 * Validating location is created on Track Inventory and adding items to that location by product catalog addition.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI - WF 7"},priority=0, description = "SI - WF 7-OG+Default loc + Skip Category")
	public void SI_WF7_OG_DefaultLocation_SkipCategory() {
		LoginData loginData =LoginData.fetch("LoginData6");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		SearchData searchData=SearchData.fetch("SearchData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 7-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 7-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 7-Login")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 7-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI - WF 7-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 7-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 7-Skip1 Tapped")
		.TapOrderGuide("SI - WF 7-OG Selected")
		.tapContinue("SI - WF 7-Tapped Continue1")

		._atLocationsPage()
		.DefaultLocation("SI - WF 7-Tapped Custom location")
		.tapContinue("SI - WF 7-Tapped Continue2")

		._atSetupInventoryPage() 
		.TapOnDOThisLater("SI - WF 7-TapOnDOThisLater Tapped")
		.TapTakeHome("SI - WF 7-Tapped Continue3") 


		//verify users cached state is not cleared
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 7-Selected track inventory")
		._atLocationsPage()
		.TapOnBack("SI - WF 7-tapped on back")

		._atHomePage()
		.HamburgerMenu("SI - WF 7-tapped hamburger")
		.HamMenu_Logout("SI - WF 7-tapped logout")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 7-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 7-FirstAccountSelect")

		._atLoginPage()
		.signIn(loginData.UserName, loginData.Password,"SI - WF 7-Login")
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 7-Selected track inventory")

		//validating D-0338
		._atLocationsPage()
		.TapAddLocation("MIL-WF1-WF4-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL-WF1-WF4-Enter location name")
		.AddLocationCooler("MIL-WF1-WF4-Tapped Cooler")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")
		.TapOnBack("MIL-WF1-WF4-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF1-WF4-Verifing AddedLocation")
		.SelectLocation(locationsData.LocationName, "MIL-WF1-WF4-Selecting AddedLocation")
		._atLocationsPage()
		.TapAddLocation("MIL - WF 1 WF 4-Tapped ADD") 
		._atSetupInventoryPage()
		.SearchItem(searchData.keyword,"MIL-WF1-WF4-Search item")
		.SelectItemFrom_Catalog("MIL-WF1-WF4-Selected item from OG")
		.TapOnDone("MIL-WF1-WF4-Done")
		.verifySearchItemsOnSetupInv("MIL-WF1-WF4-Verify item selected")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")
		.verifySearchItemsOnSetupInv("MIL-WF1-WF4-Verify item selected")

		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then skip location and assigning to Default category.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI - WF 8"},priority=4, description = "SI - WF 8-OG + Skip Loc + Default Category ")
	public void SI_WF8_OG_SkipLocation_DefaultCategory() {
		LoginData loginData =LoginData.fetch("LoginData7");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 6-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 8-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 8-LoginPage")


		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 8-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 8-Skip1 Tapped")
		.TapOrderGuide("SI - WF 8-OG Selected")
		.tapContinue("SI - WF 8-Tapped Continue1")
		.TapOnDOThisLater("SI - WF 8-Do this Later for locations Tapped")

		._atCategoryPage()
		.defaultCategories("SI - WF 8-Tapped Default category")
		.tapComplete("SI - WF 8-Tapped Complete")

		._atSetupInventoryPage()
		.tapContinue("SI - WF 8-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 8-Selected track inventory")


		;
	}		

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch(Product catalog) and then assign those items to Default location and Default category.
	 * Prerequisite:Normal/MA User
	 */

	@Test(groups={"SI - WF 9"},priority=0, description = "SI - WF 9-Start From Scratch + add items from Product catelog +Default Loc + Default Category")
	public void SI_WF9_StartFromScratch_PdtCatalog_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData8");
		SearchData searchData=SearchData.fetch("SearchData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 9-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 9-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 9-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 9-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 9-Tapped Skip")

		.StartFromScratch("SI - WF 9-ScratchSelected")
		.tapContinue("SI - WF 9-Tapped Continue")
		.Scratch_AddItems("SI - WF 9-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 9-Search item")
		.SelectMultipleItemsFrom_OrderGuide("SI - WF 9-Selected item from OG")
		.TapOnDone("SI - WF 9-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("SI - WF 9-Verify item selected")
		.TapOnDone("SI - WF 9-Tapped Done")

		._atLocationsPage()
		.DefaultLocation("SI - WF 9-Tapped Default location")
		.tapContinue("SI - WF 9-Tapped Continue")

		._atSetupInventoryPage()

		._atCategoryPage()
		.defaultCategories("SI - WF 9-Tapped Custom category")
		.tapComplete("SI - WF 9-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 9-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 9-Selected track inventory")



		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (OrderGuide) and then assign those items to Default locations and default category.
	 * Prerequisite:Normal/MA User with OG items.
	 */

	@Test(groups={"SI - WF 10"},priority=1, description = "SI - WF 10-Start From Scratch + add items from Order Guide +Default Loc + Default Category ")
	public void SI_WF10_StartFromScratch_OG_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData9");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 10-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 10-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 10-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 10-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 10-Tapped Skip")
		.StartFromScratch("SI - WF 10-ScratchSelected")
		.tapContinue("SI - WF 10-Tapped Continue")
		.Scratch_AddItems("SI - WF 10-Tapped Add items")
		.AddItemFrom_OrderGuide("SI - WF 10-Tapped Order Guide")
		.SelectMultipleItemsFrom_OrderGuide("SI - WF 10-Selected item from OG")
		.TapOnDone("SI - WF 10-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("SI - WF 10-Verify item selected")
		.TapOnDone("SI - WF 10-Tapped Done")

		._atLocationsPage()
		.DefaultLocation("SI - WF 10-Tapped Default location")
		.tapContinue("SI - WF 10-Tapped Continue")

		._atSetupInventoryPage()

		._atCategoryPage()
		.defaultCategories("SI - WF 10-Tapped Custom category")
		.tapComplete("SI - WF 10-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 10-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 10-Selected track inventory")


		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Prep and NonSysco items) and then assign those items to Default locations and default category.
	 * Validating Non sysco prompt details
	 * Validating Non Sysco and Prep item displayed on 'No locations' on Track Inventory
	 * Prerequisite:Normal/MA User
	 */

	@Test(groups={"SI - WF 11"},priority=3, description = "SI - WF 11-Start From Scratch + add items Non-sysco & Prep+Default Loc + Default Category")
	public void SI_WF11_StartFromScratch_NonSysco_Prep_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData10");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 11-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 11-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 11-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 11-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 11-Tapped Skip")
		.StartFromScratch("SI - WF 11-ScratchSelected")
		.tapContinue("SI - WF 11-Tapped Continue")
		.Scratch_AddItems("SI - WF 11-Tapped Add items")
		.AddItemFrom_NonSysco("SI - WF 11-Tapped NonSysco")
		.NonSysco_Prompt("SI - WF 11-verify NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 11-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 11-select supplier")

		._atVendorPage()
		.Add_Supplier("SI - WF 11-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 11-AddVendorDetails")
		.TapOnDone("SI - WF 11-Done")
		.TapOnBack("SI - WF 11-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 11-SupplierSelect")
		.TapOnDone("SI - WF 11-Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 11-Verify item selected")
		.Setup_AddItemsLink("SI - WF 11-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 11-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 11-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 11-Tapped Done")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 11-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 11-Verify item selected")
		.TapOnDone("SI - WF 11-Tapped Done")

		._atLocationsPage()
		.DefaultLocation("SI - WF 11-Tapped Default location")
		.tapContinue("SI - WF 11-Tapped Continue")


		._atCategoryPage()
		.defaultCategories("SI - WF 11-Tapped Custom category")
		.tapComplete("SI - WF 11-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 11-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 11-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 11-select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 11-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 11-Verify item selected")
		.TapOnDone("SI - WF 11-Tapped Done")
		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Default locations and default category.
	 * Validating Non Sysco and Prep item displayed on 'No locations' on Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */

	@Test(groups={"SI - WF 12"},priority=3, description = "SI - WF 12-Start From Scratch + add items from multiple lists +Default Loc + Default Category")
	public void SI_WF12_StartFromScratch_Catalog_OG_NonSysco_Prep_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData1");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 12-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 12-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 12-Login")
		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 12-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 12-Tapped Skip")

		.StartFromScratch("SI - WF 12-ScratchSelected")
		.tapContinue("SI - WF 12-Tapped Continue")
		.Scratch_AddItems("SI - WF 12-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 12-Search item")
		.SelectItemFrom_Catalog("SI - WF 12-Selected item from OG")
		.TapOnDone("SI - WF 12-Tapped Done")


		.Setup_AddItemsLink("SI - WF 12-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 12-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 12-Selected item from OG")
		.TapOnDone("SI - WF 12-Tapped Done")


		.Setup_AddItemsLink("SI - WF 11-Add items Selected")
		.AddItemFrom_NonSysco("SI - WF 12-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 12-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 12-select supplier")

		._atVendorPage()
		.Add_Supplier("SI - WF 12-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 12-AddVendorDetails")
		.TapOnDone("SI - WF 12-Done")
		.TapOnBack("SI - WF 12-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 12-SupplierSelect")
		.TapOnDone("SI - WF 12-Done")

		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI - WF 12-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 12-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 12-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 12-Tapped Done")

		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 12-Verify item selected")
		.verifySearchItemsOnSetupInv("SI - WF 12-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 12-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 12-Verify item selected")

		.TapOnDone("SI - WF 12-Tapped Done")

		._atLocationsPage()
		.DefaultLocation("SI - WF 12-Tapped Default location")
		.tapContinue("SI - WF 12-Tapped Continue")


		._atCategoryPage()
		.defaultCategories("SI - WF 12-Tapped Custom category")
		.tapComplete("SI - WF 12-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 12-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 12-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 12-select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 12-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 12-Verify item selected")
		.TapOnDone("SI - WF 12-Tapped Done")
		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Custom locations and Custom category.
	 * Validating uncategorized items on locations and categories page
	 * Validating all items are displayed on corresponding location at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */

	@Test(groups={"SI - WF 13"},priority=1, description = "SI - WF 13-Start from scratch+ Multiple lists +Custom location + Custom category")
	public void SI_WF13_StartFromScratch_MultipleList_CustomLocation_CustomCategory() {	


		LoginData loginData =LoginData.fetch("LoginData2");       
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 13-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 13-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 13-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 13-Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI- WF 13-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 13-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 13-Tapped Skip1")

		.StartFromScratch("SI- WF 13-ScratchSelected")
		.tapContinue("SI- WF 13-Tapped Continue1")
		.Scratch_AddItems("SI- WF 13-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 13-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 13-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 13-select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 13-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 13-AddVendorDetails")
		.TapOnDone("SI- WF 13-Tapped Done1")
		.TapOnBack("SI- WF 13-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 13-SupplierSelect")
		.TapOnDone("SI- WF 13-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 13-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 13-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 13-PrepItemAddPage")
		.TapOnDone("SI- WF 13-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 13-Add items Selected")
		.SearchItem(searchData.keyword2,"SI- WF 13-Search item")
		.verifyItemDescriptionSearch(searchData.keyword2, "SI- WF 13-Verified search with item description")
		.SelectItemFrom_Catalog("SI- WF 13-Selected item from catalog")
		.TapOnDone("SI- WF 13-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 13-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 13-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 13-Selected item from OG")
		.TapOnDone("SI- WF 13-Tapped Done5")


		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 13-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 13-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 13-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 13-Verify nonsysco item selected")


		.TapOnDone("SI- WF 13-Tapped Done6")

		// location setup
		._atLocationsPage()
		.CustomLocation("SI- WF 13-Tapped Custom location")
		.tapContinue("SI- WF 13-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI- WF 13-Enter location name")
		.AddLocations1_TypeDry("SI- WF 13-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData1.LocationName,"")
		.AddLocations2_TypeDry("SI- WF 13-Tapped Dry2")
		.TapOnNext("SI- WF 13-Tapped Next1")
		//validating D-0336
		.AssignMultipleListItemsToLocation("SI- WF 13-Selected Multiple items to Location1")
		.AssignMultipleListItemsToLocation("SI- WF 13-Selected Multiple items to Location1")
		.TapOnNext("SI- WF 13-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI- WF 13-Selected Multiple items to Location2")
		.TapOnDone("SI- WF 13-Tapped Done7")


		._atCategoryPage()
		.CustomCategories("SI - WF 13-CustomCategories Tapped")
		.tapContinue("SI - WF 13-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 13-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 13-Tapped Next3")
		.AssignMultipleItemsToCategory("SI - WF 13-Assign MultipleItems To Category1")
		.AssignMultipleItemsToCategory("SI - WF 13-Assign MultipleItems To Category1")
		.TapOnNext("SI - WF 13-Tapped Next4")
		.AssignMultipleItemsToCategory("SI - WF 13-Assign MultipleItems To Category1")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 13-Tapped Done8")
		.TapTakeHome("SI - WF 13-Tapped Continue4") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 13-Selected track inventory")


		._atLocationsPage()
		//.SelectLocation(locationsData.LocationName, "SI- WF 13-Select added location1")
		//.VerifyMultipleListItemsInLocation("SI- WF 13-Verifying Multiple items in Location1")
		//.TapOnBack("SI- WF 13-Tapped back2")
		.SelectLocation(locationsData1.LocationName, "SI- WF 13-Select added location2")
		.VerifyMultipleListItemsInLocation("SI- WF 13-Verifying Multiple items in Location2")

		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Default location and Custom category.
	 * Validating categorized items on categories page
	 * Validating Non Sysco and Prep items are displayed on corresponding location at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */


	@Test(groups={"SI - WF 14"},priority=2, description = "SI - WF 14-Start from scratch+ Multiple lists +Default location + Custom category")
	public void SI_WF14_StartFromScratch_MultipleList_DefaultLocation_CustomCategory() {	

		LoginData loginData =LoginData.fetch("LoginData3");	 
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 14-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 14-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 14-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 14-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI- WF 14-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 14-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 14-Tapped Skip1")

		.StartFromScratch("SI- WF 14-ScratchSelected")
		.tapContinue("SI- WF 14-Tapped Continue1")
		.Scratch_AddItems("SI- WF 14-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 14-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 14-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 14-select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 14-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 14-AddVendorDetails")
		.TapOnDone("SI- WF 14-Tapped Done on add supplier page")
		.TapOnBack("SI- WF 14-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 14-SupplierSelect")
		.TapOnDone("SI- WF 14-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 14-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 14-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 14-PrepItemAddPage")
		.TapOnDone("SI- WF 14-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 14-Add items Selected")
		.SearchItem(searchData.keyword,"SI- WF 14-Search item")
		.SelectItemFrom_Catalog("SI- WF 14-Selected item from catalog")
		.TapOnDone("SI- WF 14-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 14-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 14-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 14-Selected item from OG")
		.TapOnDone("SI- WF 14-Tapped Done5")


		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 14-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 14-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 14-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 14-Verify nonsysco item selected")


		.TapOnDone("SI- WF 14-Tapped Done6")

		// location setup
		._atLocationsPage()
		.DefaultLocation("SI - WF 14-Tapped Custom location")
		.tapContinue("SI - WF 14-Tapped Continue2")


		._atCategoryPage()
		.CustomCategories("SI - WF 14-CustomCategories Tapped")
		.tapContinue("SI - WF 14-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 14-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 14-Tapped Next3")
		.AssignMultipleItemsToCategory("SI - WF 14-Assign MultipleItems To Category1")
		.TapOnNext("SI - WF 14-Tapped Next4")

		._atCategoryPage()
		.VerifyItemPresentUncategorizedAndAllItems("SI - WF 14-Tapped Next4-verified all items ad uncategorized tab items")


		._atSetupInventoryPage()
		.TapOnDone("SI - WF 14-Tapped Done7")
		.TapTakeHome("SI - WF 14-Tapped Continue4") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 14-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 14-select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 14-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 14-Verify item selected")
		.TapOnDone("SI - WF 14-Tapped Done")

		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to multiple  locations and Default category.
	 * Validating all items are displayed on corresponding location at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */



	@Test(groups={"SI - WF 15"},priority=2, description = "SI - WF 15-Start from scratch+ Multiple lists +Custom location + Default category")
	public void SI_WF15_StartFromScratch_MultipleList_CustomLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData4");	  
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 15-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 15-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 15-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 15-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI- WF 15-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 15-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 15-Tapped Skip1")

		.StartFromScratch("SI- WF 15-ScratchSelected")
		.tapContinue("SI- WF 15-Tapped Continue1")
		.Scratch_AddItems("SI- WF 15-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 15-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 15-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 15-Select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 15-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 15-AddVendorDetails")
		.TapOnDone("SI- WF 15-Tapped Done1")
		.TapOnBack("SI- WF 15-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 15-SupplierSelect")
		.TapOnDone("SI- WF 15-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 15-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 15-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 15-PrepItemAddPage")
		.TapOnDone("SI- WF 15-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 15-Add items Selected")
		.SearchItem(searchData.keyword,"SI- WF 15-Search item")
		.SelectItemFrom_Catalog("SI- WF 15-Selected item from catalog")
		.TapOnDone("SI- WF 15-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 15-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 15-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 15-Selected item from OG")
		.TapOnDone("SI- WF 15-Tapped Done5")


		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 15-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 15-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 15-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 15-Verify nonsysco item selected")


		.TapOnDone("SI- WF 15-Tapped Done6")

		// location setup
		._atLocationsPage()
		.CustomLocation("SI- WF 15-Tapped Custom location")
		.tapContinue("SI- WF 15-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI- WF 15-Enter location name")
		.AddLocations1_TypeDry("SI- WF 15-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData1.LocationName,"")
		.AddLocations2_TypeDry("SI- WF 15-Tapped Dry2")
		.TapOnNext("SI- WF 15-Tapped Next1")

		.AssignMultipleListItemsToLocation("SI- WF 15-Selected Multiple items to Location1")
		.TapOnNext("SI- WF 15-Tapped Next2")
		.AllItemsTabClick("SI- WF 15-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI- WF 15-Selected Multiple items to Location2")
		.TapOnDone("SI- WF 15-Tapped Done6")


		._atCategoryPage()
		.defaultCategories("SI- WF 15-Tapped Custom category")
		.tapComplete("SI- WF 15-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI- WF 15-Tapped Continue3")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 15-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI- WF 15-select added location1")
		.VerifyMultipleListItemsInLocation("SI- WF 15-Verifying Multiple items in Location1")
		.TapOnBack("SI- WF 15-Tapped back")
		.SelectLocation(locationsData1.LocationName, "SI- WF 15-select added location2")
		.VerifyMultipleListItemsInLocation("SI- WF 15-Verifying Multiple items in Location2")

		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then skipping location and skipping category.
	 * Prerequisite:Normal/MA User with OG items
	 */

	@Test(groups={"SI - WF 16"},priority=0, description = "SI - WF 16-Start from scratch + Multiple lists+ Skip location+ Skip Category")
	public void SI_WF16_StartFromScratch_MultipleList_skipLocation_SkipCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 16-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 16-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 16-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 16-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 16-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 16-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 16-Tapped Skip")

		.StartFromScratch("SI - WF 16-ScratchSelected")
		.tapContinue("SI - WF 16-Tapped Continue")
		.Scratch_AddItems("SI - WF 16-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 16-Search item")
		.SelectItemFrom_Catalog("SI - WF 16-Selected item from catalog")
		.TapOnDone("SI - WF 16-Tapped Done")
		.verifySearchItemsOnSetupInv("SI - WF 16-Verify item selected")

		.Setup_AddItemsLink("SI - WF 16-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 16-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 16-Selected item from OG")
		.TapOnDone("SI - WF 16-Tapped Done")
		.verifyOGItemsOnSetupInv("SI - WF 16-Verify item selected")

		.Setup_AddItemsLink("SI - WF 16-Add items Selected")
		.AddItemFrom_NonSysco("SI - WF 16-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 16-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 16-select supplier")



		._atVendorPage()
		.Add_Supplier("SI - WF 16-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 16-AddVendorDetails")
		.TapOnDone("SI - WF 16-Done")
		.TapOnBack("SI - WF 16-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 16-SupplierSelect")
		.TapOnDone("SI - WF 16-Done")

		._atSetupInventoryPage()

		.Setup_AddItemsLink("SI - WF 16-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 16-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 16-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 16-Tapped Done")


		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 16-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 16-Verify item selected")
		.verifySearchItemsOnSetupInv("SI - WF 16-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 16-Verify item selected")


		.TapOnDone("SI - WF 16-Tapped Done")

		.TapOnDOThisLater("SI - WF 16-Tapped do this later")


		.TapOnDOThisLater("SI - WF 16-Tapped do this later")
		.tapContinue("SI - WF 16-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 16-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 16-select added location")
		// .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 9-Verify item inside location")
		.TapOnDone("SI - WF 16-Tapped Done")
		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Default  locations and Skipping category.
	 * Validating Non Sysco and Prep items are displayed on corresponding location at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI - WF 17"},priority=3, description = "SI - WF 17-Start from scratch + Multiple lists + Default loc + Skip Category")
	public void SI_WF17_StartFromScratch_MultipleList_DefaultLocation_SkipCategory() {	

		LoginData loginData =LoginData.fetch("LoginData6");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 17-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 17-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 17-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 17-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 17-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 17-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 17-Tapped Skip")

		.StartFromScratch("SI - WF 17-ScratchSelected")
		.tapContinue("SI - WF 17-Tapped Continue")
		.Scratch_AddItems("SI - WF 17-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 17-Search item")
		.SelectItemFrom_Catalog("SI - WF 17-Selected item from catalog")
		.TapOnDone("SI - WF 17-Tapped Done")

		.Setup_AddItemsLink("SI - WF 17-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 17-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 17-Selected item from OG")
		.TapOnDone("SI - WF 17-Tapped Done")

		.Setup_AddItemsLink("SI - WF 17-Add items Selected")
		.AddItemFrom_NonSysco("SI - WF 17-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 17-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 17-select supplier")


		._atVendorPage()
		.Add_Supplier("SI - WF 17-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 17-AddVendorDetails")
		.TapOnDone("SI - WF 17-Done")
		.TapOnBack("SI - WF 17-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 17-SupplierSelect")
		.TapOnDone("SI - WF 17-Done")

		._atSetupInventoryPage()

		.Setup_AddItemsLink("SI - WF 17-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 17-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 17-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 17-Tapped Done")


		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 17-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 17-Verify item selected")
		.verifySearchItemsOnSetupInv("SI - WF 17-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 17-Verify item selected")


		.TapOnDone("SI - WF 17-Tapped Done")


		._atLocationsPage()
		.DefaultLocation("SI - WF 17-Tapped Default location")
		.tapContinue("SI - WF 17-Tapped Continue")


		._atSetupInventoryPage()
		.TapOnDOThisLater("SI - WF 17-Tapped do this later")
		.TapTakeHome("SI - WF 17-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 17-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 17-select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 17-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 17-Verify item selected")
		.TapOnDone("SI - WF 17-Tapped Done")

		;
	}		

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then skip location and assign to default category.
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI - WF 18"},priority=0, description = "SI - WF 18-Start from scratch+ Multiple lists +skip location + default category")
	public void SI_WF18_StartFromScratch_MultipleList_skipLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData7");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 18-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 18-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 18-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 18-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 18-Tapped Skip")

		.StartFromScratch("SI - WF 18-ScratchSelected")
		.tapContinue("SI - WF 18-Tapped Continue")
		.Scratch_AddItems("SI - WF 18-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 18-Search item")
		.SelectItemFrom_Catalog("SI - WF 18-Selected item from catalog")
		.TapOnDone("SI - WF 18-Tapped Done")
		.verifySearchItemsOnSetupInv("SI - WF 18-Verify item selected")

		.Setup_AddItemsLink("SI - WF 18-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 18-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 18-Selected item from OG")
		.TapOnDone("SI - WF 18-Tapped Done")
		.verifyOGItemsOnSetupInv("SI - WF 18-Verify item selected")

		.Setup_AddItemsLink("SI - WF 18-Add items Selected")
		.AddItemFrom_NonSysco("SI - WF 18-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 18-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 18-select supplier")

		._atVendorPage()
		.Add_Supplier("SI - WF 18-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 18-AddVendorDetails")
		.TapOnDone("SI - WF 18-Done")
		.TapOnBack("SI - WF 18-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 18-SupplierSelect")
		.TapOnDone("SI - WF 18-Done")

		._atSetupInventoryPage()

		.Setup_AddItemsLink("SI - WF 18-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 18-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 18-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 18-Tapped Done")


		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 18-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 18-Verify item selected")

		.verifySearchItemsOnSetupInv("SI - WF 18-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 18-Verify item selected")

		.TapOnDone("SI - WF 18-Tapped Done")

		.TapOnDOThisLater("SI - WF 18-Tapped do this later")

		._atCategoryPage()
		.defaultCategories("SI - WF 18-Tapped Custom category")
		.tapComplete("SI - WF 18-Tapped Complete")
		.tapContinue("SI - WF 18-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 18-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 18-select added location")
		.TapOnDone("SI - WF 18-Tapped Done")
		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign those items to Default  location and default category.
	 * Validating Default categories are listed on Expense categories page 
	 * Prerequisite:Normal/MA User with MyList.
	 */
	@Test(groups={"SI - WF 19"},priority=0, description = "SI - WF 19-Custom List + default Loc + default Category")
	public void SI_WF19_CustomList_defaultLoc_defaultcategory() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 19-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 19-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 19-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 19-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 19-custom list Selected")
		.tapContinue("SI - WF 19-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 19-select list")
		.TapOnNext("SI - WF 19-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI - WF 19-Tapped Custom location")
		.tapContinue("SI - WF 19-Tapped Continue")


		._atCategoryPage()
		.defaultCategories("SI - WF 19-Tapped Default category")
		.tapComplete("SI - WF 19-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 19-Tapped takeme home")   


		._atInventoryToolPage()
		.InvTools_Category("SI- WF 19-Tapped Categories")
		._atCategoryPage()
		.VerifyDefaultCategoryList("SI- WF 19-Verified default Categories List")

		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assigning all items to multiple  locations and Custom category.
	 * Validating items are displayed on corresponding locations assigned
	 * Validating location and category displayed on item section on locations page is same as assigned ones.
	 * Validating delete location functionality and checking items are listed on No Location in Track Inventory
	 * Validating delete category functionality and checking no category is displayed for those items on No Location in Track Inventory
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI - WF 20"},priority=0, description = "SI - WF 20-Custom List + Custom Loc + Custom Category + All items")
	public void SI_WF20_CustomList_CustomLoc_Customcategory_AllItems() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		LocationsData locationsData3 =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 20-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 20-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 20-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 20-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 20-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 20-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 20-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 20-custom list Selected")
		.tapContinue("SI - WF 20-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 20-select list")
		.TapOnNext("SI - WF 20-tapped next")


		._atLocationsPage()
		.CustomLocation("SI - WF 20-Tapped Custom location")
		.tapContinue("SI - WF 20-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 20-Enter location name")
		.AddLocations1_TypeDry("SI - WF 20-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 20-Tapped Dry2")
		.TapOnNext("SI - WF 20-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 20-Selected Multiple items")
		.TapOnNext("SI - WF 20-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 20-Selected Multiple items")
		.TapOnDone("SI - WF 20-Tapped Done1")

		._atCategoryPage()

		.CustomCategories("SI - WF 20-Custom Categories Tapped")
		.tapContinue("SI - WF 20-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 20-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 20-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 20-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 20-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 20-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 20-Tapped Done2")

		.TapTakeHome("SI - WF 20-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 20-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 20-select added location")
		.ItemVerifyOnLocation1("SI - WF 20-Item verification")
		.SyscoCategoryIdentify("SI - WF 20-Category Identify on location1")
		._atCategoryPage()
		.VerifyCustomListItemsCustomCategoryLocation1(categoryData.Name,"SI - WF 20-Category verification on location1")
		._atLocationsPage()
		.VerifyCustomListItemsCustomLocation(locationsData1.LocationName, "SI - WF 20-Location1 verification")

		.TapOnDone("SI - WF 1-Tapped Done")
		.SelectLocation(locationsData2.LocationName, "SI - WF 20-select added location")
		.ItemVerifyOnLocation2("SI - WF 20-Item verification")
		.SyscoCategoryIdentify("SI - WF 20-Category Identify on location2")
		._atCategoryPage()
		.VerifyCustomListItemsCustomCategoryLocation2(categoryData.Name1,"SI - WF 20-Category verification on location2")
		._atLocationsPage()
		.VerifyCustomListItemsCustomLocation(locationsData2.LocationName, "SI - WF 20-Location2 verification")

		.TapOnDone("SI - WF 20-Tapped Done")  

		//deleting location and checking items in no location
		.TapOnBack("SI - WF 20-Tapped Back")
		._atInventoryToolPage()
		.InvTools_Locations("SI - WF 20-Tapped Locations")
		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 20-Selecting Location1")
		.TapOnDeleteLocation("SI - WF 20-Tapped Delete")
		.TapOnYesDelete("SI - WF 20-Deleting AddedLocation")
		.VerifyCancelledLocationList(locationsData1.LocationName, "SI - WF 20-Verifing AddedLocation")
		.TapOnBack("SI - WF 20-Tapped Back")
		._atInventoryToolPage()
		.InvTools_Category("SI - WF 20-Tapped Category")
		._atCategoryPage()
		.SelectCategory(categoryData.Name1, "SI - WF 20-Selecting Category")
		.TapOnDeleteCategory("SI - WF 20-Deleting Category")
		.TapOnYesDelete("SI - WF 20-Tap on Yes Delete")
		.VerifyDeletedCategoryList(categoryData.Name1, "SI - WF 20-Verifying Deleted category list")
		.TapOnBack("SI - WF 20-Tapped Back")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 20-Tapped Track Inventory")
		._atLocationsPage()
		.SelectLocation(locationsData3.LocationName, "SI - WF 20-Selecting nolocation")
		.ItemVerifyOnLocation1("SI - WF 20-Item verification in nolocation")
		.VerifyDeletedItemsCategory(locationsData3.LocationName,"SI - WF 20-Item category verification in nolocation")

		;
	}	

	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign few items to multiple  locations and Custom category.
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI - WF 21"},priority=0, description = "SI - WF 21-Custom List + Custom Loc + Custom Category + Few items")
	public void SI_WF21_CustomList_CustomLoc_Customcategory_FewItems() {	

		LoginData loginData =LoginData.fetch("LoginData13");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData4 =LocationsData.fetch("LocatiosData4");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 21-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 21-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 21-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 21-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 21-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 21-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 21-Ready to start")

		._atListPage()
		.TapCustomList("SI - WF 21-custom list Selected")
		.tapContinue("SI - WF 21-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 21-select list")
		.TapOnNext("SI - WF 21-tapped next")


		._atLocationsPage()
		.CustomLocation("SI - WF 21-Tapped Custom location")
		.tapContinue("SI - WF 21-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 21-Enter location name")
		.AddLocations1_TypeDry("SI - WF 21-Tapped Dry1")

		.AddLocations2("SI - WF 21- tapped add another location")
		.AddLocations2_name(locationsData2.LocationName,"enter loc name 2")
		.AddLocations2_TypeDry("SI - WF 21-Tapped Dry2")
		.TapOnNext("SI - WF 21-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 21-Selected Multiple items")
		.TapOnNext("SI - WF 21-Tapped Next2")
		.selectMultipleItemsFromLocation2("SI - WF 21-Selected Multiple items")
		.selectMultipleItemsFromLocation2("SI - WF 21-Selected Multiple items")
		.TapOnDone("SI - WF 21-Tapped Done1")

		._atCategoryPage()

		.CustomCategories("SI - WF 21-Custom Categories Tapped")
		.tapContinue("SI - WF 21-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 21-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 21-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 21-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 21-Tapped Next4")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 21-Tapped Done2")

		.TapTakeHome("SI - WF 21-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 21-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 21-select added location")
		.ItemVerifyOnLocation1("SI - WF 21-Item verification")
		.TapOnDone("SI - WF 1-Tapped Done")
		.SelectLocation(locationsData4.LocationName, "SI - WF 21-select added location")
		.ItemVerifyOnLocation2("SI - WF 21-Item verification")
		.TapOnDone("SI - WF 21-Tapped Done")      
		;
	}	

	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to Default  locations and Custom category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */

	@Test(groups={"SI - WF 22"},priority=0, description = "SI - WF 22-Custom List + Default Loc + custom Category")
	public void SI_WF22_CustomList_DefaultLoc_Customcategory() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 22-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 22-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 22-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 22-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 22-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 22-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 22-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 22-custom list Selected")
		.tapContinue("SI - WF 22-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 22-select list")
		.TapOnNext("SI - WF 22-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI - WF 22-Tapped Custom location")
		.tapContinue("SI - WF 22-Tapped Continue")


		._atCategoryPage()

		.CustomCategories("SI - WF 22-Custom Categories Tapped")
		.tapContinue("SI - WF 22-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 22-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 22-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 22-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 22-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 22-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 22-Tapped Done2")

		.TapTakeHome("SI - WF 22-Tapped Continue3")   


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 22-Selected track inventory")


		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to multiple  locations and default category.
	 * Validating items are displayed on corresponding locations assigned
	 * Validating category displayed on item section on locations page is same as assigned ones.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */

	@Test(groups={"SI - WF 23"},priority=0, description = "SI - WF 23-Custom List + Custom Loc + default Category")
	public void SI_WF23_CustomList_CustomLoc_defaultcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 23-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 23-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 23-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 23-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 23-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 23-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 23-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 23-custom list Selected")
		.tapContinue("SI - WF 23-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 23-select list")
		.TapOnNext("SI - WF 23-tapped next")


		._atLocationsPage()
		.CustomLocation("SI - WF 23-Tapped Custom location")
		.tapContinue("SI - WF 23-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 23-Enter location name")
		.AddLocations1_TypeDry("SI - WF 23-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 23-Tapped Dry2")
		.TapOnNext("SI - WF 23-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 23-Selected Multiple items")
		.TapOnNext("SI - WF 23-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 23-Selected Multiple items")
		.TapOnDone("SI - WF 23-Tapped Done1")

		._atCategoryPage()
		.defaultCategories("SI - WF 23-Tapped Default category")
		.tapComplete("SI - WF 23-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 23-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 23-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 23-select added location")
		.ItemVerifyOnLocation1("SI - WF 23-Item verification in location1")
		.SyscoCategoryIdentify("SI - WF 23-Category Identification in location1")
		._atCategoryPage()
		.VerifyCustomListItemsDefaultCategoryLocation1("SI- WF 23-Verifying default categories in location1")
		.TapOnDone("SI - WF 1-Tapped Done")
		._atLocationsPage()
		.SelectLocation(locationsData2.LocationName, "SI - WF 23-select added location")
		.ItemVerifyOnLocation2("SI - WF 23-Item verification in location2")
		.SyscoCategoryIdentify("SI - WF 23-Category Identification in location1")
		._atCategoryPage()
		.VerifyCustomListItemsDefaultCategoryLocation2("SI- WF 23-Verifying default categories in location2")
		//.TapOnDone("SI - WF 23-Tapped Done")      
		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items by skipping locations and category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */

	@Test(groups={"SI - WF 24"},priority=0, description = "SI - WF 24-Custom List + Skip location+ Skip Category")
	public void SI_WF24_CustomList_SkipLoc_Skipcategory() {	

		LoginData loginData =LoginData.fetch("LoginData13");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 24-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 24-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 24-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 24-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 24-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 24-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 24-custom list Selected")
		.tapContinue("SI - WF 24-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 24-select list")
		.TapOnNext("SI - WF 24-tapped next")


		._atSetupInventoryPage()

		.TapOnDOThisLater("SI - WF 224-STapOnDOThisLater Tapped")


		.TapOnSkip("SI - WF 24-Skip3 Tapped") 

		.TapOnDOThisLater("SI - WF 24 TapOnDOThisLater Tapped")

		.tapContinue("SI - WF 24-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 24-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 24-select added location")
		//.ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-Verify item inside location")
		.TapOnDone("SI - WF 24-Tapped Done")
		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to Default  locations and skip category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */

	@Test(groups={"SI - WF 25"},priority=0, description = "SI - WF 25-Custom List+Default loc + Skip Category")
	public void SI_WF25_CustomList_DefaultLoc_Skipcategory() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 25-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 25-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 25-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 25-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 25-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 25-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 25-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 25-custom list Selected")
		.tapContinue("SI - WF 25-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 25-select list")
		.TapOnNext("SI - WF 25-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI - WF 25-Tapped Custom location")
		.tapContinue("SI - WF 25-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("SI - WF 25-STapOnDOThisLater Tapped")


		.TapTakeHome("SI - WF 25-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 25-Selected track inventory")

		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items by skipping locations and default category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI - WF 26"},priority=0, description = "SI - WF 26-Custom List+skip location + default category for Normal user")
	public void SI_WF26_CustomList_SkipLoc_defaultcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 26-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 26-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 26-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 26-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 26-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 26-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 26-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 26-custom list Selected")
		.tapContinue("SI - WF 26-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 26-select list")
		.TapOnNext("SI - WF 26-tapped next")


		._atSetupInventoryPage()

		.TapOnDOThisLater("SI - WF 26-TapOnDOThisLater Tapped")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 26-Skip1 Tapped")

		._atCategoryPage()
		.defaultCategories("SI - WF 26-Tapped Custom category")
		.tapComplete("SI - WF 26-Tapped Complete")

		.tapContinue("SI - WF 26-Tapped Continue")


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 26-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 26-select added location")
		//.ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-Verify item inside location")
		.TapOnDone("SI - WF 26-Tapped Done")
		;

	}

	/*
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to Default category.
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
	 * 
	 */
	@Test(groups={"SI - WF 27"},priority=0, description = "SI - WF 27-Custom List + Select Multiple List +List Names+Default Cat")
	public void SI_WF27_CustomList_MultipleList_ListNames_DefaultCat() {	

		LoginData loginData =LoginData.fetch("LoginData13");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 27-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 27-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 27-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 27-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 27-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 27-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 27-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 27-custom list Selected")
		.tapContinue("SI - WF 27-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 27-select list")
		.SelectListwithItems(listData1.ListName, "SI - WF 27-select list")
		.TapOnNext("SI - WF 27-tapped next")


		._atLocationsPage()
		.ListNames("SI - WF 27-Tapped Custom location")
		.tapContinue("SI - WF 27-Tapped Continue")


		._atCategoryPage()
		.defaultCategories("SI - WF 27-Tapped Default category")
		.tapComplete("SI - WF 27-Tapped Complete")

		._atSetupInventoryPage() 
		.TapTakeHome("SI - WF 27-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 27-Selected track inventory")
		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI - WF 27-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI - WF 27-Item verification")
		.TapOnDone("SI - WF 1-Tapped Done")
		.SelectLocation(listData1.ListName, "SI - WF 27-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI - WF 27-Item verification")
		.TapOnDone("SI - WF 27-Tapped Done")      
		;

		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to custom category.
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
	 * 
	 */
	@Test(groups={"SI - WF 28"},priority=0, description = "SI - WF 28-Custom List + Select Multiple List +List Names as location+custom Cat")
	public void SI_WF28_CustomList_MultipleList_ListNames_Customcategory() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 28-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 28-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 28-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 28-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 28-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 28-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 28-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 28-custom list Selected")
		.tapContinue("SI - WF 28-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 28-select list")
		.SelectListwithItems(listData1.ListName, "SI - WF 28-select list")
		.TapOnNext("SI - WF 28-tapped next")



		._atLocationsPage()
		.ListNames("SI - WF 28-Tapped List Names")
		.tapContinue("SI - WF 28-Tapped Continue")



		._atCategoryPage()

		.CustomCategories("SI - WF 28-Custom Categories Tapped")
		.tapContinue("SI - WF 28-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 28-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 28-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 28-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 28-Tapped Next4")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 28-Tapped Done2")
		._atSetupInventoryPage() 
		.TapTakeHome("SI - WF 28-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 28-Selected track inventory")
		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI - WF 28-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI - WF 28-Item verification")
		.TapOnDone("SI - WF 28-Tapped Done")
		.SelectLocation(listData1.ListName, "SI - WF 28-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI - WF 28-Item verification")
		.TapOnDone("SI - WF 28-Tapped Done")      
		;

		;

	}	
	/*
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Default Cat .
	 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
	 * 
	 */
	@Test(groups={"SI - WF 29"},priority=0, description = "SI - WF 29-Custom List + Select single  List +Custom categories as location+Default Cat")
	public void SI_WF29_CustomListSingleList_CustomCategoryOnLocationsPage_defaultcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 29-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 29-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 29-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 29-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 29-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 29-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 29-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 29-custom list Selected")
		.tapContinue("SI - WF 29-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 29-select list")
		.TapOnNext("SI - WF 29-tapped next")


		._atLocationsPage()
		.CustomCategories("SI - WF 29-Tapped Default category in Location Page")
		.tapContinue("SI - WF 29-Tapped Continue2")

		._atCategoryPage()
		.defaultCategories("SI - WF 29-Tapped Default category")
		.tapComplete("SI - WF 29-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 29-Tapped Continue3")   
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 29-Selected track inventory")


		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Custom Cat 
	 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
	 * 
	 */


	@Test(groups={"SI - WF 30"},priority=0, description = "SI - WF 30-Custom List + Select single  List +Custom Categories as location+Custom Cat")
	public void SI_WF30_CustomListSingleList_CustomCategoryOnLocationsPage_customcategory() {	

		LoginData loginData =LoginData.fetch("LoginData13");
		ListData listData=ListData.fetch("ListData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 30-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 30-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 30-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 30-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 30-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 30-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 30-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 30-custom list Selected")
		.tapContinue("SI - WF 30-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 29-select list")
		.TapOnNext("SI - WF 30-tapped next")


		._atLocationsPage()
		.CustomCategories("SI - WF 30-Tapped Default category in Location Page")
		.tapContinue("SI - WF 30-Tapped Continue2")

		._atCategoryPage()
		.CustomCategories("SI - WF 30-Custom Categories Tapped")
		.tapContinue("SI - WF 30-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 20-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 30-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 30-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 30-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 20-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 30-Tapped Done2")

		.TapTakeHome("SI - WF 30-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 30-Selected track inventory")

		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then skipping Category 
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
	 * 
	 */
	@Test(groups={"SI - WF 31"},priority=0, description = "SI - WF 31-Custom List + Select Multiple List +List Names as location+skip Cat")
	public void SI_WF31_CustomList_MultipleList_ListNames_Skipcategory() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 31-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 31-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 31-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 31-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 31-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 31-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 31-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 31-custom list Selected")
		.tapContinue("SI - WF 31-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 31-select list")
		.SelectListwithItems(listData1.ListName, "SI - WF 31-select list")
		.TapOnNext("SI - WF 31-tapped next")


		._atLocationsPage()
		.ListNames("SI - WF 31-Tapped List Names")
		.tapContinue("SI - WF 31-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("SI - WF 31-STapOnDOThisLater Tapped")

		._atSetupInventoryPage() 
		.TapTakeHome("SI - WF 31-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 31-Selected track inventory")
		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI - WF 31-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI - WF 31-Item verification")
		.TapOnDone("SI - WF 31-Tapped Done")
		.SelectLocation(listData1.ListName, "SI - WF 31-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI - WF 31-Item verification")
		.TapOnDone("SI - WF 31-Tapped Done")      
		;

		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and then skipping Category 
	 * Prerequisite:Normal/MA User with MyList having 6 items 
	 * 
	 */
	@Test(groups={"SI - WF 32"},priority=0, description = "SI - WF 32-Custom List + Select single  List +Custom categories as location+Skip Cat")
	public void SI_WF32_CustomList_SingleList_CustomCatLoc_Skipcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 32-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 32-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 32-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 32-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 32-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 32-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 32-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 32-custom list Selected")
		.tapContinue("SI - WF 32-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 32-select list")
		.TapOnNext("SI - WF 32-tapped next")



		._atLocationsPage()
		.CustomCategories("SI - WF 32-Tapped Custom location")
		.tapContinue("SI - WF 32-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("SI - WF 32-STapOnDOThisLater Tapped")


		.TapTakeHome("SI - WF 32-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 32-Selected track inventory")


		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default locations and Suggested category.
	 * Prerequisite:Normal/MA User with OG items.
	 */

	@Test(groups={"SI - WF 33"},priority=4, description = "SI - WF 33-OG + Default Loc + Suggested Category")
	public void SI_WF33_OG_DefaultLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData8");	 

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 33-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 33-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 33-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 33-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 33-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 33-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 33-Skip1 Tapped")
		.TapOrderGuide("SI - WF 33-OG Selected")
		.tapContinue("SI - WF 33-Tapped Continue")


		._atLocationsPage()
		.DefaultLocation("SI - WF 33-Tapped Custom location")
		.tapContinue("SI - WF 33-Tapped Continue")

		._atSetupInventoryPage() 

		._atCategoryPage()
		.SuggestedCategories("SI - WF 33-SuggestedCategories Tapped")
		.tapContinue("SI - WF 33-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 33-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 33-Selected track inventory")


		;



	}
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Custom locations and Suggested category.
	 * Validating items are displayed on corresponding locations assigned
	 * Validating suggested categories are displayed for each item on Track Inv
	 * Prerequisite:Normal/MA User with OG items.
	 */

	@Test(groups={"SI - WF 34"},priority=0, description = "SI - WF 34-OG + Custom Loc + Suggested Category")
	public void SI_WF34_OG_CustomLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData9"); 
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 34-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 34-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 34-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 34-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 34-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 34-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 34-Skip1 Tapped")
		.TapOrderGuide("SI - WF 34-OG Selected")
		.tapContinue("SI - WF 34-Tapped Continue")


		._atLocationsPage()
		.CustomLocation("SI - WF 34-Tapped Custom location")
		.tapContinue("SI - WF 34-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 34-Enter location name")
		.AddLocations1_TypeDry("SI - WF 34-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 34-Tapped Dry2")
		.TapOnNext("SI - WF 34-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 34-Selected Multiple items")
		.TapOnNext("SI - WF 34-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 34-Selected Multiple items")
		.TapOnDone("SI - WF 34-Tapped Done1")

		._atSetupInventoryPage() 

		._atCategoryPage()
		.SuggestedCategories("SI - WF 34-SuggestedCategories Tapped")
		.tapContinue("SI - WF 34-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 34-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 34-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 34-select added location1")
		.ItemVerifyOnLocation1("SI - WF 34-Verify item inside location1")
		.SyscoCategoryIdentify("SI - WF 34-Category identification for Syscoitems in location1")
		._atCategoryPage()
		.VerifyOGSyscoItemsSuggestedCategoryLocation1("SI - WF 34-Category verification for Syscoitems in location1")
		.TapOnDone("SI - WF 34-Tapped Done2")
		._atLocationsPage()
		.SelectLocation(locationsData2.LocationName, "SI - WF 34-select added location2")
		.ItemVerifyOnLocation2( "SI - WF 34-Verify item inside location2")
		.SyscoCategoryIdentify("SI - WF 34-Category identification for Syscoitems in location2")
		._atCategoryPage()
		.VerifyOGSyscoItemsSuggestedCategoryLocation1("SI - WF 34-Category verification for Syscoitems in location2")

		.TapOnDone("SI - WF 34-Tapped Done3")

		;


	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Suggested Cat .
	 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
	 * 
	 */

	@Test(groups={"SI - WF 35"},priority=0, description = "SI - WF 35-Custom List + Select single  List +Custom Categories as location+Suggested Cat")
	public void SI_WF35_CustomListSingleList_CustomCategoryOnLocationsPage_suggestedcategory() {

		LoginData loginData =LoginData.fetch("LoginData13");
		ListData listData=ListData.fetch("ListData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 35-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 35-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 35-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 35-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 35-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 35-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 35-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 35-custom list Selected")
		.tapContinue("SI - WF 35-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 35-select list")
		.TapOnNext("SI - WF 35-tapped next")


		._atLocationsPage()
		.CustomCategories("SI - WF 35-Tapped Default category in Location Page")
		.tapContinue("SI - WF 35-Tapped Continue2")


		._atCategoryPage()
		.SuggestedCategories("SI - WF 35-SuggestedCategories Tapped")
		.tapContinue("SI - WF 35-Tapped Continue3") 

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 35-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 35-Selected track inventory")

		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to Suggested Category .
	 * Validating suggested category can be edited on product detail page and verifying.
	 * Prerequisite:Normal/MA User with MyList having  2 items each for List2,List3
	 * 
	 */
	@Test(groups={"SI - WF 36"},priority=0, description = "SI - WF 36-Custom List + Select Multiple List +List Names+Suggested Cat")
	public void SI_WF36_CustomList_MultipleList_ListNames_SuggestedCat() {

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");


		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 36-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 36-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 36-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 36-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 36-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 36-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 36-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 36-custom list Selected")
		.tapContinue("SI - WF 36-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 36-select list")
		.SelectListwithItems(listData1.ListName, "SI - WF 36-select list")
		.TapOnNext("SI - WF 36-tapped next")

		._atLocationsPage()
		.ListNames("SI - WF 36-Tapped Custom location")
		.tapContinue("SI - WF 36-Tapped Continue")

		._atCategoryPage()
		.SuggestedCategories("SI - WF 36-SuggestedCategories Tapped")
		.tapContinue("SI - WF 36-Tapped Continue1")

		._atSetupInventoryPage() 
		.TapTakeHome("SI - WF 36-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 36-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI - WF 36-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI - WF 36-Item verification")
		.TapOnDone("SI - WF 36-Tapped Done")
		.SelectLocation(listData1.ListName, "SI - WF 36-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI - WF 36-Item verification")

		//changing category and verification
		._atSetupInventoryPage()
		.VerifyProductID_Location("SI - WF 36-Verified Product")
		._atCategoryPage()
		.VerifySuggestedCategory("SI - WF 36-Verified Category")
		._atLocationsPage()
		.SyscoProductSelect("SI - WF 36-Select Product")
		.TapOnEdit("SI - WF 36-Tapped Edit")
		.AddCategory_AddProductDetailsPage("SI - WF 36-CategorySelect")
		._atCategoryPage()
		.TapAnySuggestedCategory("SI - WF 36- tapped on a suggested category")
		.TapOnDone("SI - WF 36-Tapped Done")
		.TapOnBack("SI - WF 36-Tapped Back")
		.VerifySelectedSuggestedCategory("SI - WF 36-Verified Category")

		.TapOnDone("SI - WF 36-Tapped Done")      

		;


	}
	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to multiple  locations and Suggested category.
	 * Validating all items are displayed on corresponding location at Track Inventory
	 * Validating  suggested category is displayed at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */

	@Test(groups={"SI - WF 37"},priority=1, description = "SI - WF 37-Start from scratch+ Multiple lists +Custom location +Suggested category")
	public void SI_WF37_StartFromScratch_MultipleList_CustomLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData10");	  
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 37-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 37-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 37-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 37-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI- WF 37-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 37-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 37-Tapped Skip1")

		.StartFromScratch("SI- WF 37-ScratchSelected")
		.tapContinue("SI- WF 37-Tapped Continue1")
		.Scratch_AddItems("SI- WF 37-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 37-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 37-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 37-select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 37-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 37-AddVendorDetails")
		.TapOnDone("SI- WF 37-Tapped Done1")
		.TapOnBack("SI- WF 37-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 37-SupplierSelect")
		.TapOnDone("SI- WF 37-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 37-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 37-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 37-PrepItemAddPage")
		.TapOnDone("SI- WF 37-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 37-Add items Selected")
		.SearchItem(searchData.keyword,"SI- WF 37-Search item")
		.SelectItemFrom_Catalog("SI- WF 37-Selected item from catalog")
		.TapOnDone("SI- WF 37-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 37-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 37-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 37-Selected item from OG")
		.TapOnDone("SI- WF 37-Tapped Done5")


		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 37-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 37-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 37-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 37-Verify nonsysco item selected")


		.TapOnDone("SI- WF 37-Tapped Done6")

		// location setup
		._atLocationsPage()
		.CustomLocation("SI- WF 37-Tapped Custom location")
		.tapContinue("SI- WF 37-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI- WF 37-Enter location name")
		.AddLocations1_TypeDry("SI- WF 37-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData1.LocationName,"")
		.AddLocations2_TypeDry("SI- WF 37-Tapped Dry2")
		.TapOnNext("SI- WF 37-Tapped Next1")

		.AssignMultipleListItemsToLocation("SI- WF 37-Selected Multiple items to Location1")
		.TapOnNext("SI- WF 37-Tapped Next2")
		.AllItemsTabClick("SI- WF 37-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI- WF 37-Selected Multiple items to Location2")
		.TapOnDone("SI- WF 37-Tapped Done7")


		._atCategoryPage()
		.SuggestedCategories("SI - WF 37-SuggestedCategories Tapped")
		.tapContinue("SI - WF 37-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 37-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 37-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI- WF 37-Select added location1")
		.VerifyMultipleListItemsInLocation("SI- WF 37-Verifying Multiple items in Location1")
		.TapOnBack("SI- WF 37-Tapped back2")
		.SelectLocation(locationsData1.LocationName, "SI- WF 37-Select added location2")
		.VerifyMultipleListItemsInLocation("SI- WF 37-Verifying Multiple items in Location2")
		.SyscoCategoryIdentify("SI- WF 37-Identifying categories")
		._atCategoryPage()
		.VerifyMultipleListSyscoSuggestedCategory("SI- WF 37-Verifying categories")
		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Default  locations and Suggested category.
	 * Validating Non sysco and Prep items are displayed on No location at Track Inventory
	 * Validating  suggested category list on Categories page
	 * Prerequisite:Normal/MA User with OG items
	 */

	@Test(groups={"SI - WF 38"},priority=2, description = "SI - WF 38-Start from scratch+ Multiple lists +Default location + Suggested category")
	public void SI_WF38_StartFromScratch_MultipleList_DefaultLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData1");       
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 38-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 38-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 38-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 38-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI- WF 38-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 38-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 38-Tapped Skip1")

		.StartFromScratch("SI- WF 38-ScratchSelected")
		.tapContinue("SI- WF 38-Tapped Continue1")
		.Scratch_AddItems("SI- WF 38-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 38-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 38-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 38-select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 38-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 38-AddVendorDetails")
		.TapOnDone("SI- WF 38-Tapped Done on add supplier page")
		.TapOnBack("SI- WF 38-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 38-SupplierSelect")
		.TapOnDone("SI- WF 38-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 38-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 38-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 38-PrepItemAddPage")
		.TapOnDone("SI- WF 38-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 38-Add items Selected")
		.SearchItem(searchData.keyword,"SI- WF 38-Search item")
		.SelectItemFrom_Catalog("SI- WF 38-Selected item from catalog")
		.TapOnDone("SI- WF 38-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 38-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 38-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 38-Selected item from OG")
		.TapOnDone("SI- WF 38-Tapped Done6")

		//verifications  

		.verifySearchItemsOnSetupInv("SI- WF 38-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 38-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 38-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 38-Verify nonsysco item selected")

		.TapOnDone("SI- WF 38-Tapped Done6")


		// location setup
		._atLocationsPage()
		.DefaultLocation("SI - WF 38-Tapped Custom location")
		.tapContinue("SI - WF 38-Tapped Continue2")


		._atCategoryPage()
		.SuggestedCategories("SI - WF 38-SuggestedCategories Tapped")
		.tapContinue("SI - WF 38-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 38-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 38-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI- WF 38-Select added location1")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 38-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 38-Verify nonsysco item selected")
		.TapOnDone("SI - WF 38-Tapped Done")

		._atLocationsPage()
		.TapOnBack("SI- WF 38-Tapped back")
		._atInventoryToolPage()
		.InvTools_Category("SI- WF 38-Tapped Categories")
		._atCategoryPage()
		.VerifySuggestedCategoryList("SI- WF 38-Verified Suggested Categories List")
		;

	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding items to location and verifying quantity updation.
	 * Prerequisite:Normal/MA User with OG items
	 */

	@Test(groups={"TI-WF1-WF2"},priority=3, description = "TI-WF1-WF2-Select a location from trackinventory updating quantity and uom")
	public void TI_WF1_WF2_Location_Item_UOMQuantity() {	

		LoginData loginData =LoginData.fetch("LoginData14");	
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
		UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData1");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("TI-WF1-WF2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"TI-WF1-WF2-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"TI-WF1-WF2-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"TI-WF1-WF2-ThirdAccountSelect")



		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("TI-WF1-WF2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("TI-WF1-WF2-Skip1 Tapped")
		.TapOrderGuide("TI-WF1-WF2-OG Selected")
		.tapContinue("TI-WF1-WF2-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("TI-WF1-WF2-Tapped Custom location")
		.tapContinue("TI-WF1-WF2-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("TI-WF1-WF2-Tapped do this later")
		.TapTakeHome("TI-WF1-WF2-Tapped Take me Home")


		._atInventoryToolPage()
		.InvTools_TrackInventory("TI-WF1-WF2-Tapped trackINventory")

		//creating a location
		._atLocationsPage()
		.TapAddLocation("TI-WF1-WF2-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"TI-WF1-WF2-Enter location name")
		.AddLocationCooler("TI-WF1-WF2-Tapped Cooler")
		.TapOnDone("TI-WF1-WF2-Tapped Done")
		.TapOnBack("TI-WF1-WF2-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "TI-WF1-WF2-Verifing AddedLocation")

		.SelectLocation(locationsData1.LocationName, "MIL - WF 1 WF 4-Selecting AddedLocation")
		.TapAddLocation("MIL - WF 1 WF 4-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF 2-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF 2-NonSyscoItem details entered")
		.TapOnDone("MIL-WF 2-Tapped Done")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL - WF 1,4-Verify item selected")


		._atLocationsPage()
		//.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-Selected location for entering")
		.ProductQtyEnter(uomQuantityData.Quantity,"TI-WF1-WF2-Entering Quantity1")
		.UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
		.TapOnDone("TI-WF1-WF2-Tapped done")

		.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-Selected location for verifying")
		.QuantityVerify(uomQuantityData.Quantity, "TI-WF1-WF2-Verifying Quantity1")

		.TapOnBack("TI-WF1-WF2-Tapped Back")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-Selected location for updating")
		.ProductQtyEnter(uomQuantityData1.Quantity,"TI-WF1-WF2-Entering Quantity2")
		.UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
		.TapOnDone("TI-WF1-WF2-Tapped done")

		.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-Selected location for update verify")
		.QuantityVerify(uomQuantityData1.Quantity,"TI-WF1-WF2-Verifying Quantity2")

		;

	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding multiple items to location (Pdt catalog + OG +Non sysco+Prep)
	 * Validating nickname can be assigned for OG and catalog items  
	 * Prerequisite:Normal/MA User with OG items
	 */

	@Test(groups={"MIL-WF1-WF4"},priority=0, description = "MIL - WF 1,WF 4-Creating Location in trackinventory and add items from multiple lists to location")
	public void MIL_WF1_WF4_Location_AddItems() {	

		LoginData loginData =LoginData.fetch("LoginData14");	
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		ProductNickNameData productNickNameData=ProductNickNameData.fetch("ProductNickNameData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		SearchData searchData=SearchData.fetch("SearchData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF1-WF4-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF1-WF4-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF1-WF4-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"MIL-WF1-WF4-FirstAccountSelect")


		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF1-WF4-SetupInventoryTap")
		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF1-WF4-Skip1 Tapped")
		.TapOrderGuide("MIL-WF1-WF4-OG Selected")
		.tapContinue("MIL-WF1-WF4-Tapped Continue")
		._atLocationsPage()
		.DefaultLocation("MIL-WF1-WF4-Tapped Custom location")
		.tapContinue("MIL-WF1-WF4-Tapped Continue")
		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF1-WF4-Tapped do this later")
		.TapTakeHome("MIL-WF1-WF4-Tapped TakeMeHome")

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF1-WF4-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MIL-WF1-WF4-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL-WF1-WF4-Enter location name")
		.AddLocationCooler("MIL-WF1-WF4-Tapped Cooler")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")
		.TapOnBack("MIL-WF1-WF4-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF1-WF4-Verifing AddedLocation")

		//nonsysco addition 
		.SelectLocation(locationsData.LocationName, "MIL-WF1-WF4-Selecting AddedLocation")
		.TapAddLocation("MIL-WF1-WF4-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MIL-WF1-WF4-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF1-WF4-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL-WF1-WF4-select supplier")
		._atVendorPage()
		.Add_Supplier("MIL-WF1-WF4-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF1-WF4-AddVendorDetails")
		.TapOnDone("MIL-WF1-WF4-Done")
		.TapOnBack("MIL-WF1-WF4-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF1-WF4-SupplierSelect")
		.TapOnDone("MIL-WF1-WF4-Done")


		//prepitemaddition
		._atLocationsPage()   
		.TapAddLocation("MIL-WF1-WF4-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF1-WF4-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF1-WF4-NonSyscoItem details entered")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")


		//product catalog additin
		._atLocationsPage()
		.TapAddLocation("MIL - WF 1 WF 4-Tapped ADD") 
		._atSetupInventoryPage()
		.SearchItem(searchData.keyword,"MIL-WF1-WF4-Search item")
		.SelectItemFrom_Catalog("MIL-WF1-WF4-Selected item from OG")
		.TapOnDone("MIL-WF1-WF4-Done")
		.verifySearchItemsOnSetupInv("MIL-WF1-WF4-Verify item selected")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")
		//assiging nickname to catalog item
		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "MIL-WF1-WF4-Selecting AddedLocation")
		.SyscoProductSelect("MIL-WF1-WF4-Select Product")
		.TapOnEdit("MIL-WF1-WF4-Tapped Edit")
		.EditProduct_NickName(productNickNameData.NickName, "MIL-WF1-WF4-Entering Nickname")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")
		.TapOnBack("MIL-WF1-WF4-Tapped Back")

		//og item addition and assigning nickname to it
		._atLocationsPage()
		.TapAddLocation("MIL-WF1-WF4-Tapped ADD")
		.AddItemFrom_OrderGuide("MIL-WF1-WF4-Tapped NonSysco")
		._atSetupInventoryPage()
		.SelectItemFrom_OrderGuide("MIL-WF1-WF4-Selected item from OG")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")
		.verifyOGItemsOnSetupInv("MIL-WF1-WF4-Verify item selected")  
		.TapOnDone("MIL-WF1-WF4-Tapped Done") 

		._atLocationsPage()
		.SyscoProductSelect("MIL-WF1-WF4-Select Product")
		.TapOnEdit("MIL-WF1-WF4-Tapped Edit")
		.EditProduct_NickName("nickName", "MIL-WF1-WF4-Entering Nickname")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")
		.TapOnBack("MIL-WF1-WF4-Tapped Back")


		._atSetupInventoryPage()
		.verifySearchItemsOnSetupInv("MIL-WF1-WF4-Verify item selected")


		.verifyOGItemsOnSetupInv("MIL  - WF 1 WF 4-Verify item selected") 

		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF1-WF4-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF1-WF4-Verify item selected")

		;
	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding Non sysco and Prep items to multiple locations
	 * Validating  quantity updation on Product detail page for same item on different locations
	 * Prerequisite:Normal/MA User with OG items
	 */


	@Test(groups={"MIL - WF 2"},priority=1, description = "MIL - WF 2-Selecing a location, adding same items to multiple location")
	public void MIL_WF2_Location_AddItems__MultipleLocation() {	

		LoginData loginData =LoginData.fetch("LoginData14");
		LocationsData locationsData3 =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		//SearchData searchData=SearchData.fetch("SearchData");
		UOMQuantityData uomQuantityData = UOMQuantityData.fetch("UOMQuantityData");
		UOMQuantityData uomQuantityData1 = UOMQuantityData.fetch("UOMQuantityData1");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF 2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF 2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"MIL-WF 2-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF 2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF 2-Tapped Skip1")
		.TapOrderGuide("MIL-WF 2-Tapped orderguide")
		.tapContinue("MIL-WF 2-Tapped continue")

		._atLocationsPage()
		.DefaultLocation("MIL-WF 2-Tapped Custom location")
		.tapContinue("MIL-WF 2-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-Tapped do this later")
		.TapTakeHome("MIL-WF 2-Tapped take me home")


		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF 2-TrackinventoryTap")

		//creating a location1       
		._atLocationsPage()
		.TapAddLocation("MIL-WF 2-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL-WF 2-Enter location1 name")
		.AddLocationCooler("MIL-WF 2-Tapped Cooler")
		.TapOnDone("MIL-WF 2-Tapped Done")
		.TapOnBack("MIL-WF 2-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL-WF 2-Verifing Added Location1")

		//nonsysco item addition to location1
		.SelectLocation(locationsData1.LocationName, "MIL-WF 2-Selecting Added Location1")
		.TapAddLocation("MIL-WF 2-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MIL-WF 2-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF 2-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL-WF 2-select supplier")

		._atVendorPage()
		.Add_Supplier("MIL-WF 2-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF 2-AddVendorDetails")
		.TapOnDone("MIL-WF 2-Done")
		.TapOnBack("MIL-WF 2-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF 2-SupplierSelect")

		//same nonsysco item addition to location2 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MIL-WF 2-Select Add/Select location option")
		.TapAddLocation("MIL-WF 2-Tapped ADD")
		.AddLocationName(locationsData2.LocationName,"MIL-WF 2-Enter location2 name")
		.AddLocationCooler("MIL-WF 2-Tapped Cooler")
		.TapOnDone("MIL-WF 2-Tapped Done")
		.TapOnBack("MIL-WF 2-Tapped Back")
		.VerifyLocationList(locationsData2.LocationName, "MIL-WF 2-Verifing Added Location2")

		.SelectLocation(locationsData2.LocationName, "MIL-WF 2-Selecting Added Location2")
		.LocationDoneSelection("MIL-WF 2-Selecting Done")
		.TapOnDone("MIL-WF 2-Tapped Done")

		//location1 displayed with 1 non sysco item
		//prep item addition to location1

		.TapAddLocation("MIL-WF 2-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF 2-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF 2-NonSyscoItem details entered")

		//same prep item addition to location3 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MIL-WF 2-Select Add/Select location option")
		.TapAddLocation("MIL-WF 2-Tapped ADD")
		.AddLocationName(locationsData3.LocationName,"MIL-WF 2-Enter location3 name")
		.AddLocationCooler("MIL-WF 2-Tapped Cooler")
		.TapOnDone("MIL-WF 2-Tapped Done")
		.TapOnBack("MIL-WF 2-Tapped Back")
		.VerifyLocationList(locationsData3.LocationName, "MIL-WF 2-Verifing Added Location3")

		.SelectLocation(locationsData3.LocationName, "MIL-WF 2-Selecting Added Location3")
		.LocationDoneSelection("MIL-WF 2-Selecting Done")
		.TapOnDone("MIL-WF 2-Tapped Done")
		// .TapOnDone("MIL-WF 2-Tapped Done")

		//location1 displayed with nonsysco and prep item
		//Verifications
		._atLocationsPage()
		.TapOnBack("MIL-WF 2-Tapped back")

		.SelectLocation(locationsData1.LocationName, "MIL-WF 2-Selecting Added Location2") 
		._atSetupInventoryPage()
		. verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF 2-Verify nonsysco item selected in Location2")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF 2-Verify prep item selected in Location3")

		._atLocationsPage()
		.TapOnBack("MIL-WF 2-Tapped Back")

		.SelectLocation(locationsData2.LocationName, "MIL-WF 2-Selecting Added Location3")
		._atSetupInventoryPage()
		. verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF 2-Verify nonsysco item selected in Location2")
		._atLocationsPage()
		.TapOnBack("MIL-WF 2-Tapped Back")


		._atLocationsPage()
		.SelectLocation(locationsData3.LocationName, "MIL-WF 2-Selecting Added Location3")
		._atSetupInventoryPage()

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF 2-Verify prep item selected in Location3")


		._atLocationsPage()
		.ProductSelect(prepItemData.ProductName, "MIL-WF 2-Selecting prep item")
		.TapOnEdit("MIL - WF 10 NU Tap on edit")
		.PdtDetailPage_Location1_EnterQty(uomQuantityData.Quantity,locationsData1.LocationName, "Enter Qty frst location")
		.PdtDetailPage_Location2_EnterQty(uomQuantityData1.Quantity,locationsData3.LocationName, "Enter Qty second location")
		.TapOnDone("MIL - WF 10 NU tap on done")
		.TapOnBack("MIL - WF 10 NU tap on back")
		.QuantityVerify(uomQuantityData1.Quantity, "MIL - WF 2 NU Quantity verify")

		._atLocationsPage()
		.TapOnBack("MIL-WF 2-Tapped Back")
		.SelectLocation(locationsData1.LocationName, "MIL-WF 2-Selecting Added Location1")
		.QuantityVerify(uomQuantityData.Quantity, "MIL - WF 2 NU Quantity verify")



		;
	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding OG items to location and searching items within location
	 * Validating count of items displayed for each location.
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"MIL - WF 3"},priority=2, description = "MIL - WF 3-Selecting a specific location in trackinventory and search for items within location for MA user")
	public void MIL_WF3_Location_SearchItems() {	

		LoginData loginData =LoginData.fetch("LoginData14");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 3-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 3-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 3-TC2 Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 3-FirstAccountSelect")

		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 3-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 3-Tapped Skip")
		.StartFromScratch("SI - WF 3-ScratchSelected")
		.tapContinue("SI - WF 3-Tapped Continue")
		.Scratch_AddItems("SI - WF 3-Tapped Add items")
		.AddItemFrom_OrderGuide("SI - WF 3-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("MIL-WF3-Selected item from OG")
		.TapOnDone("MIL-WF3-Tapped Done")
		.verifyOGItemsOnSetupInv("MIL-WF3-Verify item selected")
		.TapOnDone("MIL-WF3-Tapped Done")

		._atLocationsPage()
		.DefaultLocation("MIL-WF3-Tapped Custom location")
		.tapContinue("MIL-WF3-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF3-Tapped do this later")
		.TapTakeHome("MIL-WF3-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF3-TrackinventoryTap")


		._atLocationsPage()
		.TapAddLocation("MIL-WF3-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL-WF 3-Enter location name")
		.AddLocationCooler("MIL-WF3-Tapped Cooler")
		.TapOnDone("MIL-WF3-Tapped Done")
		.TapOnBack("MIL-WF3-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF3-Verifing AddedLocation")
		.SelectLocation(locationsData.LocationName, "MIL-WF3-Selecting location")

		//og item addition
		._atLocationsPage()
		.TapAddLocation("MIL-WF3-Tapped ADD")

		.AddItemFrom_OrderGuide("MIL-WF3-Tapped Orderguide")
		._atSetupInventoryPage()
		.SelectMultipleItemsFrom_OrderGuide("MIL-WF3-Selected multiple items from OG")
		.TapOnDone("MIL-WF3-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF3-Verify items selected")  
		.TapOnDone("MIL-WF3-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF3-Verify item selected")  
		.SearchKeyword("MIL-WF3-Keyword searching")
		.verifyKeywordSearchItems("MIL-WF3-Verify Keyword search")
		.TapOnDone("MIL-WF3-Done tap")
		._atLocationsPage()
		.VerifyCountOfItemsInLocation(locationsData.LocationName, "verify count")
;
	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding Non sysco item to location 
	 * Validating different locations can be assigned to same item through product detail page
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */@Test(groups={"MIL - WF 5"},priority=3, description = "MIL - WF 5-Selecting a location navigate to product and assiging  item  to diff location")
	public void MIL_WF5_Locations_ItemEdit_UpdateLocation() {	

		LoginData loginData =LoginData.fetch("LoginData14");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL- WF 5-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL- WF 5-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"MIL- WF 5-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL- WF 5-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF6-Tapped Skip")
		.StartFromScratch("MIL-WF6-ScratchSelected")
		.tapContinue("MIL-WF6-Tapped Continue")
		.Scratch_AddItems("MIL-WF6-Tapped Add items")
		.AddItemFrom_OrderGuide("MIL-WF6-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("MIL-WF6-Selected item from OG")
		.TapOnDone("MNS-1-Tapped Done1")
		.verifyOGItemsOnSetupInv("MPI-1-Verify item selected")
		.TapOnDone("MPI-1-Tapped Done2")

		._atLocationsPage()
		.DefaultLocation("SI - WF 1-Tapped Custom location")
		.tapContinue("SI - WF 1-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-Tapped do this later")
		.TapTakeHome("SI - WF 32-Tapped take me home")


		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL- WF 5-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MIL- WF 5-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL- WF 5-Enter location name")
		.AddLocationCooler("MIL- WF 5-Tapped Cooler")
		.TapOnDone("MIL- WF 5-Tapped Done")
		.TapOnBack("MIL- WF 5-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL- WF 5-Verifing AddedLocation")
		.SelectLocation(locationsData.LocationName, "MIL- WF 5-Selecting AddedLocation")
		.TapAddLocation("MIL- WF 5-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MIL- WF 5-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL- WF 5-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL- WF 5-select supplier")

		._atVendorPage()
		.Add_Supplier("MIL- WF 5-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL- WF 5-AddVendorDetails")
		.TapOnDone("MIL- WF 5-Done")

		.TapOnBack("MIL- WF 5-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL- WF 5-SupplierSelect")
		.TapOnDone("MIL- WF 5-Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 5-Verify item selected")

		._atLocationsPage()
		.ProductSelect(nonSyscoItemData.ProductName, "MIL- WF 5-Select Product")
		.TapOnEdit("MIL- WF 5-Tapped Edit")
		.AddLocation_AddProductDetailsPage("MIL- WF 5-Select Add/Select option")
		.TapAddLocation("MIL- WF 5-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL- WF 5-Enter location name")
		.AddLocationCooler("MIL- WF 5-Tapped Cooler")
		.TapOnDone("MIL- WF 5-Tapped Done")
		.TapOnBack("MIL- WF 5-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL- WF 5-Verifing AddedLocation")

		.SelectLocation(locationsData1.LocationName, "MIL- WF 5-Selecting AddedLocation")
		.SelectLocation(locationsData.LocationName, "MIL- WF 5-Selecting AddedLocation")
		.LocationDoneSelection("MIL- WF 5-Selecting Done")
		.TapOnDone("MIL- WF 5-Tapped Done")

		.TapOnBack("MIL- WF 5-Tapped Back")
		.TapOnBack("MIL- WF 5-Tapped Back")

		.SelectLocation(locationsData.LocationName, "MIL- WF 5-Selecting AddedLocation")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 5-Verify item selected")

		._atLocationsPage() 
		.TapOnBack("MIL- WF 5-Tapped Back")
		.SelectLocation(locationsData1.LocationName, "MIL- WF 5-Selecting AddedLocation")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 5-Verify item selected")

		;
	}

	 /*
		 * Validating user is able to setup inventory.
		 * Validating Creating Location,Editing Location in Manage Locations and deleting location
		 * Prerequisite:Normal/MA User with OG items
		 * 
		 */


@Test(groups={"MIL - WF 6"},priority=4, description = "MIL - WF 6-Creating Location,Editing Location in Manage Locations and assiging  item  to diff location")
	public void MIL_WF6_Create_Edit_Delete_Locations() {	

		LoginData loginData =LoginData.fetch("LoginData14");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL - WF 6-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL - WF 6-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"MIL - WF 6-FirstAccountSelect")


		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL - WF 6-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL - WF 6-Skip1 Tapped")
		.TapOrderGuide("MIL - WF 6-OG Selected")
		.tapContinue("MIL - WF 6-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("MIL - WF 6-Tapped Custom location")
		.tapContinue("MIL - WF 6-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL - WF 6-Tapped do this later")
		.TapTakeHome("MIL - WF 6-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_Locations("MIL - WF 6-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MIL- WF 6-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL- WF 6-Enter location name")
		.AddLocationFreezer("MIL- WF 6-Tapped Cooler")
		.TapOnDone("MIL- WF 6-Tapped Done")
		.TapOnBack("MIL- WF 6-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL- WF 6-Verifing AddedLocation")

		.TapAddLocation("MIL- WF 6-Tapped ADD")
		.AddLocationName(locationsData2.LocationName,"MIL- WF 6-Enter location name")
		.AddLocationCooler("MIL- WF 6-Tapped Cooler")
		.TapOnDone("MIL- WF 6-Tapped Done")
		.TapOnBack("MIL- WF 6-Tapped Back")
		.VerifyLocationList(locationsData2.LocationName, "MIL- WF 6-Verifing AddedLocation")

		._atLocationsPage()
		.SelectLocation(locationsData2.LocationName, "MIL- WF 6-Selecting AddedLocation")
		.TapOnEdit("MIL- WF 6-Editing AddedLocation")
		.AddLocationFreezer("MIL- WF 6-Tapped Cooler")
		.AddLocationName(locationsData2.EditLocation,"MIL- WF 6-Enter location name")

		.TapOnDone("MIL- WF 6-Tapped Done")
		.TapOnBack("MIL- WF 6-Tapped Back")
		.VerifyLocationList(locationsData2.EditLocation, "MIL- WF 6-Verifing AddedLocation")

		.SelectLocation(locationsData2.EditLocation, "MIL- WF 6-Selecting AddedLocation")
		.TapOnDeleteLocation("MIL- WF 6-Tapped Delete")
		.TapOnYesDelete("MIL- WF 6-Deleting AddedLocation")
		//  .TapOnBack("MIL- WF 6-Tapped Back")
		.VerifyCancelledLocationList(locationsData2.EditLocation, "MIL- WF 6-Verifing AddedLocation")



		;
	}
/*
 * Validating user is able to setup inventory.
 * Validating Creating Location and Delete Items from location
 * Prerequisite:Normal/MA User with OG items
 * 
 */

	@Test(groups={"MIL - WF 7"},priority=4, description = "MIL - WF 7-Track Inventory+Location+Edit+Delete Items from location")
	public void MIL_WF7_TrackInventory_Location_Edit_Delete_Items_location_MA() {

		LoginData loginData =LoginData.fetch("LoginData13"); 
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF7-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF7-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF7-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"MIL-WF7-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF7-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF7-Skip1 Tapped")
		.TapOrderGuide("MIL-WF7-OG Selected")
		.tapContinue("MIL-WF7-Tapped Continue1")

		._atLocationsPage()
		.CustomLocation("MIL-WF7-Tapped Custom location")
		.tapContinue("MIL-WF7-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"MIL-WF7-Enter location name1")
		.AddLocations1_TypeDry("MIL-WF7-Tapped Dry1")

		.AddLocations2("MIL-WF7-Add location2")
		.AddLocations2_name(locationsData2.LocationName,"MIL-WF7-Enter location name2")
		.AddLocations2_TypeDry("MIL-WF7-Tapped Dry2")
		.TapOnNext("MIL-WF7-Tapped Next1")

		.selectMultipleItemsFromLocation1("MIL-WF7-Selected Multiple items")
		.TapOnNext("MIL-WF7-Tapped Next2")

		.selectMultipleItemsFromLocation2("MIL-WF7-Selected Multiple items")
		.TapOnDone("MIL-WF7-Tapped Done1")

		._atCategoryPage()
		.defaultCategories("MIL-WF7-Tapped Default category")
		.tapComplete("MIL-WF7-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("MIL-WF7-Tapped Take me Home")  

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF7-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "MIL-WF7-selected location1")
		.ItemVerifyOnLocation1("MIL-WF7-Verify items inside location1")
		.TapOnEdit("MIL-WF7-Tapped Edit")
		.DeleteItems("MIL-WF7-Deleting items in location")
		.TapOnDone("MIL-WF7-Tapped Done2")
		.TapOnYesDelete("MIL-WF7-confirming Deleting items")
		.VerifyDeleteItemsList("MIL-WF7-Verifying Deleted items list")
		;
	}	
	/*
	 * Validating user is able to setup inventory.
	 * Validating Creating Location and updating quantity on product card
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */


	@Test(groups={"MIL - WF 10"},priority=6, description = "MIL - WF 10 NU Track Inventory+Location+item product card + update qty & UOM")
	public void MIL_WF10_TrackInventory_Location_item_productcard_updateqtyUOM() {	

		LoginData loginData =LoginData.fetch("LoginData13");;
		LocationsData locationsData =LocationsData.fetch("LocationsData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		UOMQuantityData uomQuantityData = UOMQuantityData.fetch("UOMQuantityData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL - WF 10 NU-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL - WF 10 NU-Login")


		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")


		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"MIL-WF 2-FirstAccountSelect")



		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - MIL - WF 10 NU-SetupInventoryTap")


		._atSetupInventoryPage()
		.TapOnSkip("MIL - WF 10 NU-Skip1 Tapped")
		.TapOrderGuide("MIL - WF 10 NU Selected")
		.tapContinue("MIL - WF 10 NU-Tapped Continue")
		._atLocationsPage()
		.DefaultLocation("MIL-WF 2-Tapped Custom location")
		.tapContinue("MIL-WF 2-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-Tapped do this later")
		.TapTakeHome("MIL-WF 2-Tapped take me home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL - WF 10 NU-TrackinventoryTap")


		._atLocationsPage()
		.TapAddLocation("MIL - WF 10 NU-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL - WF 10 NU-Enter location name")
		.AddLocationCooler("MIL - WF 10 NU-Tapped Cooler")
		.TapOnDone("MIL - WF 10 NU-Tapped Done")
		.TapOnBack("MIL - WF 10 NU-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL - WF 10 NU-Verifing AddedLocation")

		.SelectLocation(locationsData.LocationName, "MIL - WF 10 NU-Selecting AddedLocation")
		.TapAddLocation("MIL - WF 10 NU-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL - WF 10 NU-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL - WF 1,3-NonSyscoItem details entered")
		.TapOnDone("MIL - WF 10 NU-Tapped Done")
		._atLocationsPage()
		.ProductSelect(prepItemData.ProductName, "")
		.TapOnEdit("MIL - WF 10 NU Tap on edit")
		.tapOnProductOpenProductDetailsPageAndEnterQty(prepItemData.ProductName, uomQuantityData.Quantity, "")
		.TapOnDone("MIL - WF 10 NU tap on done")
		.TapOnBack("MIL - WF 10 NU tap on back")
		.QuantityVerify(uomQuantityData.Quantity, "MIL - WF 10 NU Quantity verify")
		;

	}



	/*
	 * Validating user is able to setup inventory.
	 * Validating editing item and updating category on product card
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */

     @Test(groups={"MEC - WF 1"},priority=7, description = "MEC - WF 1-Selecting a location navigate to product and assiging  item  to category created")
	public void MEC_WF1_Locations_ItemEdit_UpdateCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData13");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		CategoryData categoryData =CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SMEC - WF 1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MEC-WF 1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 19-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL - WF 10 NU-Skip1 Tapped")
		.TapOrderGuide("MIL - WF 10 NU Selected")
		.tapContinue("MIL - WF 10 NU-Tapped Continue")
		._atLocationsPage()
		.DefaultLocation("MIL-WF 2-Tapped Custom location")
		.tapContinue("MIL-WF 2-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-Tapped do this later")
		.TapTakeHome("MIL-WF 2-Tapped take me home")


		._atInventoryToolPage()
		.InvTools_TrackInventory("MEC-WF 1-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MEC-WF 1-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MEC-WF 1-Enter location name")
		.AddLocationCooler("MEC-WF 1-Tapped Cooler")
		.TapOnDone("MEC-WF 1-Tapped Done")
		.TapOnBack("MEC-WF 1-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MEC-WF 1-Verifing AddedLocation")
		//nonsysco item addition 
		.SelectLocation(locationsData1.LocationName, "MEC-WF 1-Selecting AddedLocation")
		.TapAddLocation("MEC-WF 1-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MEC-WF 1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MEC-WF 1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MEC-WF 1-select supplier")
		._atVendorPage()
		.Add_Supplier("MEC-WF 1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MEC-WF 1-AddVendorDetails")
		.TapOnDone("MEC-WF 1-Tapped Done")
		.TapOnBack("MEC-WF 1-Tapped Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MEC-WF 1-SupplierSelect")
		.TapOnDone("MEC-WF 1-Tapped Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MEC-WF 1-Verify item selected")

		._atLocationsPage()
		.ProductSelect(nonSyscoItemData.ProductName, "MEC-WF 1-Select Product")
		.TapOnEdit("MEC-WF 1-Tapped Edit")

		._atLocationsPage()
		.AddCategory_AddProductDetailsPage("MEC-WF 1-CategorySelect")
		.TapAddLocation("MEC-WF 1-Tapped Add")
		._atCategoryPage()
		.AddCategoryName(categoryData.Name, "MEC-WF 1-Enter Category Name")
		.AddCategoryFood("MEC-WF 1-Enter type food")
		.TapOnDone("MEC-WF 1-Tapped Done")
		.TapOnBack("MEC-WF 1-Tapped Back")
		.SelectCategory(categoryData.Name, "MEC-WF 1-Select Category Name")
		.TapOnDone("MEC-WF 1-Tapped Done") 
		.TapOnBack("MEC-WF 1-Tapped Back")
		.TapOnBack("MEC-WF 1-Tapped Back")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "MEC-WF 1-Selecting AddedLocation")
		._atCategoryPage()
		.VerifyCategory(categoryData.Name, "MEC-WF 1-Verified Category")

		;
	}

     /*
 	 * Validating user is able to setup inventory.
 	 * Validating Creating, editing and deleting category
 	 * Prerequisite:Normal/MA User with OG items
 	 * 
 	 */

	@Test(groups={"MEC - WF 2"},priority=8, description = "MEC - WF 2-Creating, editing and deleting category ")
	public void MEC_WF2_Category_Create_Edit_Delete_Category() {	

		LoginData loginData =LoginData.fetch("LoginData14");
		CategoryData categoryData =CategoryData.fetch("CategoryData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF 2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MEC-WF 2-Login")


		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-FirstAccountSelect")


		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("TI-WF1-WF2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("TI-WF1-WF2-Skip1 Tapped")
		.TapOrderGuide("TI-WF1-WF2-OG Selected")
		.tapContinue("TI-WF1-WF2-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("TI-WF1-WF2-Tapped Custom location")
		.tapContinue("TI-WF1-WF2-Tapped Continue")
		._atSetupInventoryPage()
		.TapOnDOThisLater("TI-WF1-WF2-Tapped do this later")
		.TapTakeHome("TI-WF1-WF2-Tapped Take me Home")


		._atInventoryToolPage()
		.InvTools_Category("MEC-WF 2-Expense Category Tap")

		._atCategoryPage()
		.TapAdd("MEC-WF 2-Add Expense Category Tap")
		.AddCategoryName(categoryData.Name, "MEC-WF 2-Enter Category Name")
		.AddCategoryFood("MEC-WF 2-Enter type food")
		.TapOnDone("MEC-WF 2-Tapped Done")
		.TapOnBack("MEC-WF 2-Tapped Back")
		.VerifyCategoryList(categoryData.Name, "MEC-WF 2-Verifying added category list")

		.SelectCategory(categoryData.Name, "MEC-WF 2-Selecting Category")
		.TapOnEdit("MEC-WF 2-Tap on Edit")
		.AddCategoryFood("MEC-WF 2-Enter type food")
		.AddCategoryName(categoryData.Name1, "MEC-WF 2-Entering new name")
		.TapOnDone("MEC-WF 2-Tapped Done")
		.TapOnBack("MEC-WF 2-Tapped Back")
		.VerifyCategoryList(categoryData.Name1, "MEC-WF 2-Verifying edited category list")

		.SelectCategory(categoryData.Name1, "MEC-WF 2-Selecting Category")
		.TapOnDeleteCategory("MEC-WF 2-Deleting Category")
		.TapOnYesDelete("MEC-WF 2-Tap on Yes Delete")
		.VerifyDeletedCategoryList(categoryData.Name1, "MEC-WF 2-Verifying Deleted category list")
		;
	}		
	  /*
	 	 * Validating user is able to setup inventory.
	 	 * Validating Non sysco item addition through Homepage and linking supplier location and category
	 	 * Prerequisite:Normal/MA User with OG items
	 	 * 
	 	 */

	@Test(groups={"MNS-1"},priority=2, description = "MNS-1-Manage_Create Non-Sysco Item_Link Supplier_Location_Expense Category")
	public void MNS_1_CreateNonSyscoItem_LinkSupplier_Location_Category() {	

		LoginData loginData =LoginData.fetch("LoginData14");	  
		LocationsData locationsData =LocationsData.fetch("LocationsData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData1");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MNS-1-LoginPage")
		.saveUsernameCheckBoxClick("MNS-1-save username")
		.signIn(loginData.UserName, loginData.Password,"MNS-1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MNS-1-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"MNS-1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MNS-1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MNS-1-Tapped Skip1")
		.StartFromScratch("MNS-1-ScratchSelected")
		.tapContinue("MNS-1-Tapped Continue1")
		.Scratch_AddItems("MNS-1-Tapped Add items")
		.AddItemFrom_OrderGuide("MNS-1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("MNS-1-Selected item from OG")
		.TapOnDone("MNS-1-Tapped Done1")
		.verifyOGItemsOnSetupInv("MNS-1-Verify item selected")
		.TapOnDone("MNS-1-Tapped Done2")
		._atLocationsPage()
		.DefaultLocation("SI - WF 1-Tapped Custom location")
		.tapContinue("SI - WF 1-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-Tapped do this later")
		.TapTakeHome("SI - WF 32-Tapped take me home")  

		._atInventoryToolPage()
		.InvTools_CreateNonSysco("MNS-1-Tapped Nonsysco item")

		._atSetupInventoryPage()
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MNS-1-NonSyscoItem details entered")

		//linking supplier
		.AddSupplier_AddProductDetailsPage("MNS-1-Select supplier")
		._atVendorPage()
		.Add_Supplier("MNS-1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MNS-1-AddVendorDetails")
		.TapOnDone("MNS-1-Supplier added")
		.TapOnBack("MNS-1-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"MNS-1-SupplierSelect")

		//linking location
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MNS-1-Select Add/Select location option")
		.TapAddLocation("MNS-1-Tapped ADD Location")
		.AddLocationName(locationsData.LocationName,"MNS-1-Enter location name")
		.AddLocationCooler("MNS-1-Tapped Cooler")
		.TapOnDone("MNS-1-Tapped Done4")
		.TapOnBack("MNS-1-Tapped Back2")
		.VerifyLocationList(locationsData.LocationName, "MNS-1-Verifing Added Location")
		.SelectLocation(locationsData.LocationName, "MNS-1-Selecting Added Location")
		.LocationDoneSelection("MNS-1-Selecting Done")

		//linking category
		._atLocationsPage()
		.AddCategory_AddProductDetailsPage("MNS-1-Tapped CategorySelect")
		._atCategoryPage()
		.TapAdd("MNS-1-Tapped Add category")
		.AddCategoryName(categoryData.Name, "MNS-1-Enter Category Name")
		.AddCategoryFood("MNS-1-Enter type food")
		.TapOnDone("MNS-1-Tapped Done5")
		.TapOnBack("MNS-1-Tapped Back3")
		.SelectCategory(categoryData.Name, "MNS-1-Select Category Name")

		.TapOnDone("MNS-1-Tapped Done,Nonsyscoitem added")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("MNS-1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "MNS-1-Select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MNS-1-Verify nonsysco item added")
		._atLocationsPage()
		.NonSyscoPrepCategoryIdentify(nonSyscoItemData.ProductName,prepItemData.ProductName,"MNS-1-Category idenitification for nonsysco")
		._atCategoryPage()
		.VerifyNonSycoCustomCategory(categoryData.Name, "MNS-1-Category verification")
		;
	}


	 /*
 	 * Validating user is able to setup inventory.
 	 * Validating Prep item addition through Homepage and linking supplier location and category
 	 * Prerequisite:Normal/MA User with OG items
 	 * 
 	 */

	@Test(groups={"MPI-1"},priority=1, description = "MPI-1-Manage_Create Prep Item_LinkLocation_Expense Category")
	public void MPI_1_CreatePrepItem_LinkLocation_Category_NU() {	

		LoginData loginData =LoginData.fetch("LoginData14");	  
		SearchData searchData=SearchData.fetch("SearchData");

		LocationsData locationsData =LocationsData.fetch("LocationsData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MPI-1-LoginPage")
		.saveUsernameCheckBoxClick("MPI-1-save username")
		.signIn(loginData.UserName, loginData.Password,"MPI-1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MPI-1-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"MPI-1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MPI-1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MPI-1-Tapped Skip1")
		.StartFromScratch("MPI-1-ScratchSelected")
		.tapContinue("MPI-1-Tapped Continue1")
		.Scratch_AddItems("MPI-1-Tapped Add items")
		.SearchItem(searchData.keyword,"MIL - WF 1,3-Search item")
		.SelectItemFrom_Catalog("MIL - WF 1,3-Selected item from OG")
		.TapOnDone("MNS-1-Tapped Done1")
		.verifySearchItemsOnSetupInv("MPI-1-Verify item selected")
		.TapOnDone("MPI-1-Tapped Done1")


		._atLocationsPage()
		.DefaultLocation("SI - WF 1-Tapped Custom location")
		.tapContinue("SI - WF 1-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-Tapped do this later")
		.TapTakeHome("SI - WF 32-Tapped take me home")

		._atInventoryToolPage()
		.InvTools_CreatePrep("MPI-1-Tapped Prep item")

		._atSetupInventoryPage()
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MPI-1-PrepItem details entered")



		//linking location
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MPI-1-Select Add/Select location option")
		.TapAddLocation("MPI-1-Tapped ADD Location")
		.AddLocationName(locationsData.LocationName,"MPI-1-Enter location name")
		.AddLocationCooler("MPI-1-Tapped Cooler")
		.TapOnDone("MPI-1-Tapped Done3")
		.TapOnBack("MPI-1-Tapped Back1")
		.VerifyLocationList(locationsData.LocationName, "MPI-1-Verifing Added Location")
		.SelectLocation(locationsData.LocationName, "MPI-1-Selecting Added Location")
		.LocationDoneSelection("MPI-1-Selecting Done")

		//linking category
		._atLocationsPage()
		.AddCategory_AddProductDetailsPage("MPI-1-Tapped CategorySelect")
		._atCategoryPage()
		.TapAdd("MPI-1-Tapped Add category")
		.AddCategoryName(categoryData.Name, "MPI-1-Enter Category Name")
		.AddCategoryFood("MPI-1-Enter type food")
		.TapOnDone("MPI-1-Tapped Done4")
		.TapOnBack("MPI-1-Tapped Back2")
		.SelectCategory(categoryData.Name, "MPI-1-Select Category Name")

		.TapOnDone("MPI-1-Tapped Done,Prepitem added") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("MPI-1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "MPI-1-Select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MPI-1-Verify Prep item added")
		._atLocationsPage()
		.NonSyscoPrepCategoryIdentify(nonSyscoItemData.ProductName,prepItemData.ProductName,"MPI-1-Category idenitification for Prepitem")
		._atCategoryPage()
		.VerifyPrepCustomCategory(categoryData.Name, "MPI-1-Category verification")
		;
	}


	 /*
 	 * Validating user is able to setup inventory.
 	 * Validating add/edit/delete supplier  through Homepage 
 	 * Prerequisite:Normal/MA User with OG items
 	 * 
 	 */

	@Test(groups={"MSP-1 MSP-2"},priority=0, description = "MSP-1 MSP-2 Home Screen-->Suppliers-->Add new Suppliers/View/Maintain Suppliers")
	public void MSP1_MSP2_Add_View_ManageSuppliers()
	{
		LoginData loginData =LoginData.fetch("LoginData14");
		VendorDetailsData vendorData=VendorDetailsData.fetch("VendorDetailData2");
		VendorDetailsData vendorDataEdit=VendorDetailsData.fetch("VendorDetailData3");
		VendorDetailsData vendorData1=VendorDetailsData.fetch("VendorDetailData1");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MSP-1,MSP-2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MSP-1,MSP-2-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")
		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"MSP-1,MSP-2-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 1-SetupInventoryTap")
		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 1-OG Selected")
		.tapContinue("SI - WF 1-Tapped Continue")
		._atLocationsPage()
		.DefaultLocation("SI - WF 1-Tapped Custom location")
		.tapContinue("SI - WF 1-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-Tapped do this later")
		.TapTakeHome("SI - WF 32-Tapped take me home")  

		._atInventoryToolPage()
		.InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers")
		._atVendorPage()
		.verifySupplierPage("MSP-1,MSP-2-Supplier page verified")
		.Add_Supplier("MSP-1,MSP-2-Add button clicked")
		.AddSupplier_Details(vendorData.VendorName, vendorData.PhoneNum, vendorData.Address, vendorData.ContactInfo, vendorData.Email, vendorData.Note, "MSP-1,MSP-2-Vendor details added")
		.TapOnDone("MSP-1,MSP-2-Done tapped")
		.TapOnBack("MSP-1,MSP-2-Back tapped")
		.SupplierSelect(vendorData.VendorName,"MSP-1,MSP-2-selected added vendor")
		.TapOnEdit("MSP-1,MSP-2-Edit tapped")
		.ViewSupplierDetails(vendorData.VendorName, vendorData.PhoneNum, vendorData.Address, vendorData.ContactInfo, vendorData.Email,vendorData.Note,"MSP-1,MSP-2-Verified vendor details")
		.AddSupplier_Details(vendorDataEdit.VendorName, vendorDataEdit.PhoneNum, vendorDataEdit.Address, vendorDataEdit.ContactInfo, vendorDataEdit.Email, vendorDataEdit.Note, "MSP-1,MSP-2-Editted vendor details")
		.TapOnDone("MSP-1,MSP-2-Done tapped")
		.TapOnBack("MSP-1,MSP-2-Back tapped")
		.Add_Supplier("MSP-1,MSP-2-Add2 button clicked")
		.AddSupplier_Details(vendorData1.VendorName, vendorData1.PhoneNum, vendorData1.Address, vendorData1.ContactInfo, vendorDataEdit.Email, vendorData1.Note, "MSP-1,MSP-2-Entered vendor details to be cancelled vendor details")
		.TapOnCancel("MSP-1,MSP-2-Cancel tapped")
		.SupplierCancelledVerify(vendorData1.VendorName, "MSP-1,MSP-2-SupplierCancel Verified")
		.SupplierSelect(vendorDataEdit.VendorName, "MSP-1,MSP-2-selected edited vendor")
		.TapOnEdit("MSP-1,MSP-2-Edit tapped")
		.ViewSupplierDetails(vendorDataEdit.VendorName, vendorDataEdit.PhoneNum, vendorDataEdit.Address, vendorDataEdit.ContactInfo, vendorDataEdit.Email, vendorDataEdit.Note, "MSP-1,MSP-2-Verified editted vendor details")
		.DeleteSupplier("MSP-1,MSP-2-deleted added vendor")
		.VerifyDeletedSupplier(vendorDataEdit.VendorName, "MSP-1,MSP-2-verify deleted  vendor")
		;
	}







}


