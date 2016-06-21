
package com.tests;


//import org.apache.commons.exec.CommandLine;

import org.testng.annotations.Test;

import org.apache.commons.exec.DefaultExecuteResultHandler;

import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.os.CommandLine;
import org.openqa.selenium.remote.DesiredCapabilities;

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
import org.testng.annotations.Test;


public class WorkFlow extends Initiator{

	
	@Test(groups={"SI - WF 1"},priority=4, description = "SI - WF 2-TC2-OG + Dafault Loc + Default Category for MA user")
	public void SI_WF1_OG_DefaultLocation_DefaultCategory_MA() {
		LoginData loginData =LoginData.fetch("LoginData5");
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		
	
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 1-TC2-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 1-TC2-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 1-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 1-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 1-TC1-Skip1 Tapped")
		
		.VerifyOptionsOnImportItems("SI - WF 1-TC1-Verified import items page")
		.TapOrderGuide("SI - WF 1-TC1-OG Selected")
		.tapContinue("SI - WF 1-TC1-Tapped Continue")
		

		._atLocationsPage()
		.VerifyOptionsOnSetupLocations("SI - WF 1-TC1-Location page verified")
		.DefaultLocation("SI - WF 1-TC1-Tapped Custom location")
		.tapContinue("SI - WF 1-TC1-Tapped Continue")

		
		._atCategoryPage()
		.VerifyOptionsOnSetUpFoodCost("SI - WF 1-TC1-Category page verified")
		.defaultCategories("SI - WF 1-TC1-Tapped Default category")
		.tapComplete("SI - WF 1-TC1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 1-TC1-Tapped take me home")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 1-TC1-Selected track inventory")
		
		._atLocationsPage()
		.SelectLocation(locDataCooler.LocationName, "SI - WF 1-TC1-Selected cooler")
		.VerifyItemsOnDefaultLocation(locDataCooler.LocationName, "SI - WF 1-TC1-Verified cooler")
		.TapOnBack("SI - WF 1-TC1-Tapped on Back")
		.SelectLocation(locDataFreezer.LocationName, "SI - WF 1-TC1-Selected freezer")
		.VerifyItemsOnDefaultLocation(locDataFreezer.LocationName, "SI - WF 1-TC1-Verified freezer")
		.TapOnBack("SI - WF 1-TC1-Tapped on Back")
		.SelectLocation(locDataDry.LocationName, "SI - WF 1-TC1-Selected dry")
		.VerifyItemsOnDefaultLocation(locDataDry.LocationName, "SI - WF 1-TC1-Verified dry")
		.TapOnBack("SI - WF 1-TC1-Tapped on Back")
		
		;
	}

	
	@Test(groups={"SI - WF 3"},priority=0, description = "SI - WF 3-TC1-OG + Cus Loc + Cust Category for MA user")
	public void SI_WF3_OG_CustomMultipleLocation_CustomMultipleCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData6");
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 3-TC1-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 3-TC2-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 3-TC1-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 3-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 3-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 3-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 3-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 3-TC1-OG Selected")
		.tapContinue("SI - WF 3-TC1-Tapped Continue1")
		
		._atLocationsPage()
		.CustomLocation("SI - WF 3-TC1-Tapped Custom location")
		.tapContinue("SI - WF 3-TC1-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 3-TC1-Enter location name")
		.AddLocations1_TypeDry("SI - WF 3-TC1-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 3-TC1-Tapped Dry2")
		.TapOnNext("SI - WF 3-TC1-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 3-TC1-Selected Multiple items")
		.TapOnNext("SI - WF 3-TC1-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 3-TC1-Selected Multiple items")
		.TapOnDone("SI - WF 3-TC1-Tapped Done1")
		._atSetupInventoryPage()
		
		._atCategoryPage()
		.CustomCategories("SI - WF 1-TC2-CustomCategories Tapped")
		.tapContinue("SI - WF 3-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 3-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 3-TC1-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 3-TC1-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 3-TC1-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 3-TC1-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 3-TC1-Tapped Done2")
		.TapTakeHome("SI - WF 3-TC1-Tapped Continue4") 


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 3-TC1-Selected track inventory")

		   ._atLocationsPage()
		  .SelectLocation(locationsData1.LocationName, "SI - WF 3-TC1-LocationTap1")
		 .ItemVerifyOnLocation1("SI - WF 3-TC1-Verify item inside location1")
		  .TapOnBack("SI - WF 3-TC1-Tap on Back1")
		  .SelectLocation(locationsData2.LocationName, "SI - WF 3-TC1-LocationTap2")
		 .ItemVerifyOnLocation2("SI - WF 3-TC1-Verify item inside location2")
		;




	}

	@Test(groups={"SI - WF 4"},priority=4, description = "SI - WF 4-TC1-OG + Default Loc + Custom Category for MA user")
	public void SI_WF4_OG_DefaultLocation_CustomCategory_MA() {
		LoginData loginData =LoginData.fetch("LoginData6");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		LocationsData locDataNoLoc=LocationsData.fetch("LocatiosData4");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 4-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 4-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 4-TC1-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 4-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 4-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 4-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 4-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 4-TC1-OG Selected")
		.tapContinue("SI - WF 4-TC1-Tapped Continue")
	

		._atLocationsPage()
		.DefaultLocation("SI - WF 4-TC1-Tapped Custom location")
		.tapContinue("SI - WF 4-TC1-Tapped Continue")

		._atSetupInventoryPage() 
		
		._atCategoryPage()
		.CustomCategories("SI - WF 4-TC1-CustomCategories Tapped")
		.tapContinue("SI - WF 4-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 4-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 4-TC1-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 4-TC1-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 4-TC1-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 4-TC1-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 4-TC1-Tapped Done2")
		.TapTakeHome("SI - WF 4-TC1-Tapped Continue4") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 4-TC1-Selected track inventory")
		
		._atLocationsPage()
		.VerifyOrderOfLocations(locDataCooler.LocationName, locDataFreezer.LocationName, locDataDry.LocationName, locDataNoLoc.LocationName, "SI - WF 4-TC1-Verified order of locations")

		;
	}


	@Test(groups={"SI - WF 5"},priority=4, description = "SI - WF 8-TC1-OG + Custom Loc + Default Category for Normal user")
	public void SI_WF5_OG_CustomLocation_DefaultCategory_NU() {
		
		LoginData loginData =LoginData.fetch("LoginData5");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 5-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 5-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 5-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 5-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 5-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 5-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 5-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 5-TC1-OG Selected")
		.tapContinue("SI - WF 5-TC1-Tapped Continue1")
		
		._atLocationsPage()
		.CustomLocation("SI - WF 5-TC1-Tapped Custom location")
		.tapContinue("SI - WF 5-TC1-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 5-TC1-Enter location name")
		.AddLocations1_TypeDry("SI - WF 5-TC1-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 5-TC1-Tapped Dry2")
		.TapOnNext("SI - WF 5-TC1-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 5-TC1-Selected Multiple items")
		.TapOnNext("SI - WF 5-TC1-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 3-TC1-Selected Multiple items")
		.TapOnDone("SI - WF 5-TC1-Tapped Done1")
		._atCategoryPage()
		.defaultCategories("SI - WF 5-TC1-Tapped Default category")
		.tapComplete("SI - WF 5-TC1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 5-TC1-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 5-TC1-Selected track inventory")

		  ._atLocationsPage()
		  .SelectLocation(locationsData1.LocationName, "SI - WF 3-TC1-LocationTap1")
		 .ItemVerifyOnLocation1("SI - WF 3-TC1-Verify item inside location1")
		  .TapOnBack("SI - WF 3-TC1-Tap on Back1")
		  .SelectLocation(locationsData2.LocationName, "SI - WF 3-TC1-LocationTap2")
		 .ItemVerifyOnLocation2("SI - WF 3-TC1-Verify item inside location2")
		;
	}


	@Test(groups={"SI - WF 6"},priority=0, description = "SI - WF 6-TC1-OG + Skip Loc + Skip Cust for Normal user")
	public void SI_WF6_OG_SkipLocation_SkipCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData6");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 6-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 6-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 6-TC1-LoginPage")


		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 6 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 6-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 6-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 6-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 6-TC1-OG Selected")
		.tapContinue("SI - WF 6-TC1-Tapped Continue1")
		.TapOnDOThisLater("SI - WF 6-TC1-Do this Later for locations Tapped")
		.TapOnDOThisLater("Do this Later for category Tapped")
		.TapTakeHome("SI - WF 6-TC1-Cotinue2 Tapped") 
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 6-TC1-Selected track inventory")

		;
	}


	@Test(groups={"SI - WF 7"},priority=4, description = "SI - WF 7-TC2-OG+Default loc + Skip Category for MA user")
	public void SI_WF7_OG_DefaultLocation_SkipCategory_MA() {
		LoginData loginData =LoginData.fetch("LoginData6");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 7-TC2-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 7-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 7-TC1-Login")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 7-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 7-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 7-TC2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 7-TC2-Skip1 Tapped")
		.TapOrderGuide("SI - WF 7-TC2-OG Selected")
		.tapContinue("SI - WF 7-TC2-Tapped Continue1")
		
		._atLocationsPage()
		.DefaultLocation("SI - WF 7-TC2-Tapped Custom location")
		.tapContinue("SI - WF 7-TC2-Tapped Continue2")

		._atSetupInventoryPage() 
			.TapOnDOThisLater("SI - WF 7-TC2-TapOnDOThisLater Tapped")
		.TapTakeHome("SI - WF 7-TC2-Tapped Continue3") 


//verify users cached state is cleared
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 7-TC2-Selected track inventory")
		._atLocationsPage()
		.TapOnBack("SI - WF 7-TC2-tapped on back")
		
		._atHomePage()
		.HamburgerMenu("SI - WF 7-TC2-tapped hamburger")
		.HamMenu_Logout("SI - WF 7-TC2-tapped logout")
		
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 7-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 7-TC1-FirstAccountSelect")

		._atLoginPage()
		.signIn(loginData.UserName, loginData.Password,"SI - WF 7-TC1-Login")
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 7-TC2-Selected track inventory")
		
		;

	}
	@Test(groups={"SI - WF 8"},priority=4, description = "SI - WF 8-TC1-OG + Skip Loc + Default Category for Normal user")
	public void SI_WF8_OG_SkipLocation_DefaultCategory_MA() {
		LoginData loginData =LoginData.fetch("LoginData5");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 6-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 8-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 8-TC1-LoginPage")


		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 8-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 8-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 8-TC1-OG Selected")
		.tapContinue("SI - WF 8-TC1-Tapped Continue1")
			.TapOnDOThisLater("SI - WF 8-TC1-Do this Later for locations Tapped")
		
		._atCategoryPage()
		.defaultCategories("SI - WF 8-TC1-Tapped Default category")
		.tapComplete("SI - WF 8-TC1-Tapped Complete")

		._atSetupInventoryPage()
		.tapContinue("SI - WF 8-TC1-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 8-TC1-Selected track inventory")

	
		;
	}		



	@Test(groups={"SI - WF 9"},priority=0, description = "SI - WF 9-TC2-Start From Scratch + add items from Product catelog +Default Loc + Default Category for MA user")
	public void SI_WF9_StartFromScratch_PdtCatalog_DefaultLocation_DefaultCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData7");
		SearchData searchData=SearchData.fetch("SearchData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 9-TC2-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 9-TC2-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 9-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 9-TC2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 9-TC2-Tapped Skip")

		.StartFromScratch("SI - WF 9-TC2-ScratchSelected")
		.tapContinue("SI - WF 9-TC2-Tapped Continue")
		.Scratch_AddItems("SI - WF 9-TC2-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 9-TC2-Search item")
		.SelectMultipleItemsFrom_OrderGuide("SI - WF 9-TC2-Selected item from OG")
		.TapOnDone("SI - WF 9-TC2-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("SI - WF 9-TC2-Verify item selected")
		.TapOnDone("SI - WF 9-TC2-Tapped Done")
		
		._atLocationsPage()
		.DefaultLocation("SI - WF 9-TC2-Tapped Default location")
		.tapContinue("SI - WF 9-TC2-Tapped Continue")

		._atSetupInventoryPage()
	
		._atCategoryPage()
		.defaultCategories("SI - WF 9-TC2-Tapped Custom category")
		.tapComplete("SI - WF 9-TC2-Tapped Complete")
		
		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 9-TC2-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 9-TC2-Selected track inventory")


	
		;
	}



	@Test(groups={"SI - WF 10"},priority=0, description = "SI - WF 10-TC1-Start From Scratch + add items from Order Guide +Default Loc + Default Category for MA user")
	public void SI_WF10_StartFromScratch_OG_DefaultLocation_DefaultCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData8");
	
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 10-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 10-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 10-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 10-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 10-TC1-Tapped Skip")
		.StartFromScratch("SI - WF 10-TC1-ScratchSelected")
		.tapContinue("SI - WF 10-TC1-Tapped Continue")
		.Scratch_AddItems("SI - WF 10-TC1-Tapped Add items")
		.AddItemFrom_OrderGuide("SI - WF 10-TC1-Tapped Order Guide")
		.SelectMultipleItemsFrom_OrderGuide("SI - WF 10-TC1-Selected item from OG")
		.TapOnDone("SI - WF 10-TC1-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("SI - WF 10-TC1-Verify item selected")
		.TapOnDone("SI - WF 10-TC1-Tapped Done")
		
		._atLocationsPage()
		.DefaultLocation("SI - WF 10-TC1-Tapped Default location")
		.tapContinue("SI - WF 10-TC1-Tapped Continue")

		._atSetupInventoryPage()
		
		._atCategoryPage()
		.defaultCategories("SI - WF 10-TC1-Tapped Custom category")
		.tapComplete("SI - WF 10-TC1-Tapped Complete")
		
		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 10-TC1-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 10-TC1-Selected track inventory")

	
		;
	}


	@Test(groups={"SI - WF 11"},priority=0, description = "SI - WF 11-TC1-Start From Scratch + add items Non-sysco & Prep+Default Loc + Default Category for MA user")
	public void SI_WF11_StartFromScratch_NonSysco_Prep_DefaultLocation_DefaultCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData5");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 11-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 11-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 11-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 11-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 11-TC1-Tapped Skip")
		.StartFromScratch("SI - WF 11-TC1-ScratchSelected")
		.tapContinue("SI - WF 11-TC1-Tapped Continue")
		.Scratch_AddItems("SI - WF 11-TC1-Tapped Add items")
		.AddItemFrom_NonSysco("SI - WF 11-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 11-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 11-TC1-select supplier")

		._atVendorPage()
		.Add_Supplier("SI - WF 11-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 11-TC1-AddVendorDetails")
		.TapOnDone("SI - WF 11-TC1-Done")
		.TapOnBack("SI - WF 11-TC1-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 11-TC1-SupplierSelect")
		.TapOnDone("SI - WF 11-TC1-Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 11-TC1-Verify item selected")
		.Setup_AddItemsLink("SI - WF 11-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 11-TC1-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 11-TC1-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 11-TC1-Tapped Done")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 11-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 11-TC1-Verify item selected")
		.TapOnDone("SI - WF 11-TC1-Tapped Done")
		
		._atLocationsPage()
		.DefaultLocation("SI - WF 11-TC1-Tapped Default location")
		.tapContinue("SI - WF 11-TC1-Tapped Continue")

		
		._atCategoryPage()
		.defaultCategories("SI - WF 11-TC1-Tapped Custom category")
		.tapComplete("SI - WF 11-TC1-Tapped Complete")
		
			._atSetupInventoryPage()
		.TapTakeHome("SI - WF 11-TC1-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 11-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 11-TC1-select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 11-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 11-TC1-Verify item selected")
		.TapOnDone("SI - WF 11-TC1-Tapped Done")
		;
	}


	
	@Test(groups={"SI - WF 12"},priority=0, description = "SI - WF 12-TC2-Start From Scratch + add items from multiple lists +Default Loc + Default Category for MA user")
	public void SI_WF12_StartFromScratch_Catalog_OG_NonSysco_Prep_DefaultLocation_DefaultCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData6");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 12-TC2-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 12-TC2-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 12-TC2-Login")
		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 12-TC2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 12-TC2-Tapped Skip")

		.StartFromScratch("SI - WF 12-TC2-ScratchSelected")
		.tapContinue("SI - WF 12-TC2-Tapped Continue")
		.Scratch_AddItems("SI - WF 12-TC2-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 12-TC2-Search item")
		.SelectItemFrom_Catalog("SI - WF 12-TC2-Selected item from OG")
		.TapOnDone("SI - WF 12-TC2-Tapped Done")


		.Setup_AddItemsLink("SI - WF 12-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 12-TC2-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 12-TC2-Selected item from OG")
		.TapOnDone("SI - WF 12-TC2-Tapped Done")

		
		.Setup_AddItemsLink("SI - WF 11-TC2-Add items Selected")
		.AddItemFrom_NonSysco("SI - WF 12-TC2-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 12-TC2-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 12-TC2-select supplier")

		._atVendorPage()
		.Add_Supplier("SI - WF 12-TC2-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 12-TC2-AddVendorDetails")
		.TapOnDone("SI - WF 12-TC2-Done")
		.TapOnBack("SI - WF 12-TC2-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 12-TC2-SupplierSelect")
		.TapOnDone("SI - WF 12-TC2-Done")

		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI - WF 12-TC2-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 12-TC2-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 12-TC2-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 12-TC2-Tapped Done")
		
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		.verifySearchItemsOnSetupInv("SI - WF 12-TC2-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 12-TC2-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		
		.TapOnDone("SI - WF 12-TC2-Tapped Done")
		
		._atLocationsPage()
		.DefaultLocation("SI - WF 12-TC2-Tapped Default location")
		.tapContinue("SI - WF 12-TC2-Tapped Continue")

		
		._atCategoryPage()
		.defaultCategories("SI - WF 12-TC2-Tapped Custom category")
		.tapComplete("SI - WF 12-TC2-Tapped Complete")
		
		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 12-TC2-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 12-TC2-Selected track inventory")


		._atLocationsPage()
		            .SelectLocation(locationsData.LocationName, "SI - WF 12-TC2-select added location")
		           
		            ._atSetupInventoryPage()
		            .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		            .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		              .TapOnDone("SI - WF 12-TC2-Tapped Done")
		;
	}
	@Test(groups={"SI - WF 13"},priority=0, description = "SI - WF 13-TC1-Start from scratch+ Multiple lists +Custom location + Custom category")
	public void SI_WF13_StartFromScratch_MultipleList_CustomLocation_CustomCategory_MA() {	

		
		LoginData loginData =LoginData.fetch("LoginData6");       
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 13-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 13-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 13-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 13-TC1-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI- WF 13-TC1-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 13-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 13-TC1-Tapped Skip1")

		.StartFromScratch("SI- WF 13-TC1-ScratchSelected")
		.tapContinue("SI- WF 13-TC1-Tapped Continue1")
		.Scratch_AddItems("SI- WF 13-TC1-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 13-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 13-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 13-TC1-select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 13-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 13-TC1-AddVendorDetails")
		.TapOnDone("SI- WF 13-TC1-Tapped Done1")
		.TapOnBack("SI- WF 13-TC1-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 13-TC1-SupplierSelect")
		.TapOnDone("SI- WF 13-TC1-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 13-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 13-TC1-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 13-TC1-PrepItemAddPage")
		.TapOnDone("SI- WF 13-TC1-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 13-TC1-Add items Selected")
		.SearchItem(searchData.keyword2,"SI- WF 13-TC1-Search item")
		.verifyItemDescriptionSearch(searchData.keyword2, "SI- WF 13-TC1-Verified search with item description")
		.SelectItemFrom_Catalog("SI- WF 13-TC1-Selected item from catalog")
		.TapOnDone("SI- WF 13-TC1-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 13-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 13-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 13-TC1-Selected item from OG")
		.TapOnDone("SI- WF 13-TC1-Tapped Done5")


		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 13-TC1-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 13-TC1-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 13-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 13-TC1-Verify nonsysco item selected")


		.TapOnDone("SI- WF 13-TC1-Tapped Done6")
		
		// location setup
		._atLocationsPage()
		.CustomLocation("SI- WF 13-TC1-Tapped Custom location")
		.tapContinue("SI- WF 13-TC1-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI- WF 13-TC1-Enter location name")
		.AddLocations1_TypeDry("SI- WF 13-TC1-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData1.LocationName,"")
		.AddLocations2_TypeDry("SI- WF 13-TC1-Tapped Dry2")
		.TapOnNext("SI- WF 13-TC1-Tapped Next1")

		.AssignMultipleListItemsToLocation("SI- WF 13-TC1-Selected Multiple items to Location1")
		.TapOnNext("SI- WF 13-TC1-Tapped Next2")
		.AllItemsTabClick("SI- WF 13-TC1-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI- WF 13-TC1-Selected Multiple items to Location2")
		.TapOnDone("SI- WF 13-TC1-Tapped Done7")

		
		._atCategoryPage()
		.CustomCategories("SI - WF 13-TC1-CustomCategories Tapped")
		.tapContinue("SI - WF 13-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 13-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 13-TC1-Tapped Next3")
		.AssignMultipleItemsToCategory("SI - WF 13-TC1-Assign MultipleItems To Category1")
		.TapOnNext("SI - WF 13-TC1-Tapped Next4")

		._atSetupInventoryPage()
		.TapOnDone("SI - WF 13-TC1-Tapped Done8")
		.TapTakeHome("SI - WF 13-TC1-Tapped Continue4") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 13-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI- WF 13-TC1-Select added location1")
		.VerifyMultipleListItemsInLocation("SI- WF 13-TC1-Verifying Multiple items in Location1")
		.TapOnBack("SI- WF 13-TC1-Tapped back2")
		.SelectLocation(locationsData1.LocationName, "SI- WF 13-TC1-Select added location2")
		.VerifyMultipleListItemsInLocation("SI- WF 13-TC1-Verifying Multiple items in Location2")

		;
	}



	@Test(groups={"SI - WF 14"},priority=0, description = "SI - WF 14-TC1-Start from scratch+ Multiple lists +Default location + Custom category")
	public void SI_WF14_StartFromScratch_MultipleList_DefaultLocation_CustomCategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData7");	 
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 14-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 14-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 14-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 14-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI- WF 14-TC1-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 14-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 14-TC1-Tapped Skip1")

		.StartFromScratch("SI- WF 14-TC1-ScratchSelected")
		.tapContinue("SI- WF 14-TC1-Tapped Continue1")
		.Scratch_AddItems("SI- WF 14-TC1-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 14-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 14-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 14-TC1-select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 14-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 14-TC1-AddVendorDetails")
		.TapOnDone("SI- WF 14-TC1-Tapped Done on add supplier page")
		.TapOnBack("SI- WF 14-TC1-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 14-TC1-SupplierSelect")
		.TapOnDone("SI- WF 14-TC1-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 14-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 14-TC1-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 14-TC1-PrepItemAddPage")
		.TapOnDone("SI- WF 14-TC1-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 14-TC1-Add items Selected")
		.SearchItem(searchData.keyword,"SI- WF 14-TC1-Search item")
		.SelectItemFrom_Catalog("SI- WF 14-TC1-Selected item from catalog")
		.TapOnDone("SI- WF 14-TC1-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 14-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 14-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 14-TC1-Selected item from OG")
		.TapOnDone("SI- WF 14-TC1-Tapped Done5")


		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 14-TC1-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 14-TC1-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 14-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 14-TC1-Verify nonsysco item selected")


		.TapOnDone("SI- WF 14-TC1-Tapped Done6")
		
		// location setup
		._atLocationsPage()
		.DefaultLocation("SI - WF 14-TC1-Tapped Custom location")
		.tapContinue("SI - WF 14-TC1-Tapped Continue2")

		
		._atCategoryPage()
		.CustomCategories("SI - WF 14-TC1-CustomCategories Tapped")
		.tapContinue("SI - WF 14-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 14-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 14-TC1-Tapped Next3")
		.AssignMultipleItemsToCategory("SI - WF 14-TC1-Assign MultipleItems To Category1")
		.TapOnNext("SI - WF 14-TC1-Tapped Next4")
		
		._atCategoryPage()
		.VerifyItemPresentUncategorizedAndAllItems("SI - WF 14-TC1-Tapped Next4-verified all items ad uncategorized tab items")
		
		
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 14-TC1-Tapped Done7")
		.TapTakeHome("SI - WF 14-TC1-Tapped Continue4") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 14-TC1-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 14-TC1-select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 14-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 14-TC1-Verify item selected")
		.TapOnDone("SI - WF 14-TC1-Tapped Done")
		
		;
	}



	@Test(groups={"SI - WF 15"},priority=0, description = "SI - WF 15-TC1-Start from scratch+ Multiple lists +Custom location + Default category")
	public void SI_WF15_StartFromScratch_MultipleList_CustomLocation_DefaultCategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData8");	  
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 15-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 15-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 15-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 15-TC1-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI- WF 15-TC1-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 15-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 15-TC1-Tapped Skip1")

		.StartFromScratch("SI- WF 15-TC1-ScratchSelected")
		.tapContinue("SI- WF 15-TC1-Tapped Continue1")
		.Scratch_AddItems("SI- WF 15-TC1-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 15-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 15-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 15-TC1-Select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 15-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 15-TC1-AddVendorDetails")
		.TapOnDone("SI- WF 15-TC1-Tapped Done1")
		.TapOnBack("SI- WF 15-TC1-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 15-TC1-SupplierSelect")
		.TapOnDone("SI- WF 15-TC1-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 15-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 15-TC1-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 15-TC1-PrepItemAddPage")
		.TapOnDone("SI- WF 15-TC1-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 15-TC1-Add items Selected")
		.SearchItem(searchData.keyword,"SI- WF 15-TC1-Search item")
		.SelectItemFrom_Catalog("SI- WF 15-TC1-Selected item from catalog")
		.TapOnDone("SI- WF 15-TC1-Tapped Done4")
		
		.Setup_AddItemsLink("SI- WF 15-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 15-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 15-TC1-Selected item from OG")
		.TapOnDone("SI- WF 15-TC1-Tapped Done5")
		

		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 15-TC1-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 15-TC1-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 15-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 15-TC1-Verify nonsysco item selected")


		.TapOnDone("SI- WF 15-TC1-Tapped Done6")
		
		// location setup
		._atLocationsPage()
		.CustomLocation("SI- WF 15-TC1-Tapped Custom location")
		.tapContinue("SI- WF 15-TC1-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI- WF 15-TC1-Enter location name")
		.AddLocations1_TypeDry("SI- WF 15-TC1-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData1.LocationName,"")
		.AddLocations2_TypeDry("SI- WF 15-TC1-Tapped Dry2")
		.TapOnNext("SI- WF 15-TC1-Tapped Next1")

		.AssignMultipleListItemsToLocation("SI- WF 15-TC1-Selected Multiple items to Location1")
		.TapOnNext("SI- WF 15-TC1-Tapped Next2")
		.AllItemsTabClick("SI- WF 15-TC1-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI- WF 15-TC1-Selected Multiple items to Location2")
		.TapOnDone("SI- WF 15-TC1-Tapped Done6")

		
		._atCategoryPage()
		.defaultCategories("SI- WF 15-TC1-Tapped Custom category")
		.tapComplete("SI- WF 15-TC1-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI- WF 15-TC1-Tapped Continue3")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 15-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI- WF 15-TC1-select added location1")
		.VerifyMultipleListItemsInLocation("SI- WF 15-TC1-Verifying Multiple items in Location1")
		.TapOnBack("SI- WF 15-TC1-Tapped back")
		.SelectLocation(locationsData1.LocationName, "SI- WF 15-TC1-select added location2")
		.VerifyMultipleListItemsInLocation("SI- WF 15-TC1-Verifying Multiple items in Location2")

		;
	}


	
	@Test(groups={"SI - WF 16"},priority=0, description = "SI - WF 16-TC1-Start from scratch + Multiple lists+ Skip location+ Skip Category")
	public void SI_WF16_StartFromScratch_MultipleList_skipLocation_SkipCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData3");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 16-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 16-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 16-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 16-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 16-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 16-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 16-TC1-Tapped Skip")

		.StartFromScratch("SI - WF 16-TC1-ScratchSelected")
		.tapContinue("SI - WF 16-TC1-Tapped Continue")
		.Scratch_AddItems("SI - WF 16-TC1-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 16-TC1-Search item")
		.SelectItemFrom_Catalog("SI - WF 16-TC1-Selected item from catalog")
		.TapOnDone("SI - WF 16-TC1-Tapped Done")
		.verifySearchItemsOnSetupInv("SI - WF 16-TC1-Verify item selected")

		.Setup_AddItemsLink("SI - WF 16-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 16-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 16-TC1-Selected item from OG")
		.TapOnDone("SI - WF 16-TC1-Tapped Done")
		.verifyOGItemsOnSetupInv("SI - WF 16-TC1-Verify item selected")

		.Setup_AddItemsLink("SI - WF 16-TC1-Add items Selected")
		.AddItemFrom_NonSysco("SI - WF 16-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 16-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 16-TC1-select supplier")


		
		._atVendorPage()
		.Add_Supplier("SI - WF 16-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 16-TC1-AddVendorDetails")
		.TapOnDone("SI - WF 16-TC1-Done")
		.TapOnBack("SI - WF 16-TC1-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 16-TC1-SupplierSelect")
		.TapOnDone("SI - WF 16-TC1-Done")

		._atSetupInventoryPage()

		.Setup_AddItemsLink("SI - WF 16-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 16-TC1-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 16-TC1-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 16-TC1-Tapped Done")


		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 16-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 16-TC1-Verify item selected")
		.verifySearchItemsOnSetupInv("SI - WF 16-TC1-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 16-TC1-Verify item selected")


		.TapOnDone("SI - WF 16-TC1-Tapped Done")
		
		.TapOnDOThisLater("SI - WF 16-TC1-Tapped do this later")
		

		.TapOnDOThisLater("SI - WF 16-TC1-Tapped do this later")
		.tapContinue("SI - WF 16-TC1-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 16-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 16-TC1-select added location")
		// .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 9-TC2-Verify item inside location")
		.TapOnDone("SI - WF 16-TC1-Tapped Done")
		;
	}
	@Test(groups={"SI - WF 17"},priority=0, description = "SI - WF 17-TC1-Start from scratch + Multiple lists + Default loc + Skip Category")
	public void SI_WF17_StartFromScratch_MultipleList_DefaultLocation_SkipCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData6");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 17-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 17-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 17-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 17-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 17-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 17-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 17-TC1-Tapped Skip")

		.StartFromScratch("SI - WF 17-TC1-ScratchSelected")
		.tapContinue("SI - WF 17-TC1-Tapped Continue")
		.Scratch_AddItems("SI - WF 17-TC1-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 17-TC1-Search item")
		.SelectItemFrom_Catalog("SI - WF 17-TC1-Selected item from catalog")
		.TapOnDone("SI - WF 17-TC1-Tapped Done")
		
		.Setup_AddItemsLink("SI - WF 17-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 17-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 17-TC1-Selected item from OG")
		.TapOnDone("SI - WF 17-TC1-Tapped Done")
		
		.Setup_AddItemsLink("SI - WF 17-TC1-Add items Selected")
		.AddItemFrom_NonSysco("SI - WF 17-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 17-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 17-TC1-select supplier")

		
		._atVendorPage()
		.Add_Supplier("SI - WF 17-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 17-TC1-AddVendorDetails")
		.TapOnDone("SI - WF 17-TC1-Done")
		.TapOnBack("SI - WF 17-TC1-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 17-TC1-SupplierSelect")
		.TapOnDone("SI - WF 17-TC1-Done")

		._atSetupInventoryPage()

		.Setup_AddItemsLink("SI - WF 17-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 17-TC1-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 17-TC1-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 17-TC1-Tapped Done")


		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 17-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 17-TC1-Verify item selected")
		.verifySearchItemsOnSetupInv("SI - WF 17-TC1-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 17-TC1-Verify item selected")


		.TapOnDone("SI - WF 17-TC1-Tapped Done")
		

		._atLocationsPage()
		.DefaultLocation("SI - WF 17-TC2-Tapped Default location")
		.tapContinue("SI - WF 17-TC2-Tapped Continue")

		
._atSetupInventoryPage()
		.TapOnDOThisLater("SI - WF 17-TC1-Tapped do this later")
		.TapTakeHome("SI - WF 17-TC1-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 17-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 17-TC1-select added location")
		
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 17-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 17-TC1-Verify item selected")
		.TapOnDone("SI - WF 17-TC1-Tapped Done")
		
			;
	}		
	@Test(groups={"SI - WF 18"},priority=0, description = "SI - WF 18-TC1-Start from scratch+ Multiple lists +skip location + default category for MA user")
	public void SI_WF18_StartFromScratch_MultipleList_skipLocation_DefaultCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData4");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 18-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 18-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 18-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 18-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 18-TC1-Tapped Skip")

		.StartFromScratch("SI - WF 18-TC1-ScratchSelected")
		.tapContinue("SI - WF 18-TC1-Tapped Continue")
		.Scratch_AddItems("SI - WF 18-TC1-Tapped Add items")
		.SearchItem(searchData.keyword,"SI - WF 18-TC1-Search item")
		.SelectItemFrom_Catalog("SI - WF 18-TC1-Selected item from catalog")
		.TapOnDone("SI - WF 18-TC1-Tapped Done")
		//.verifySearchItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")

		.Setup_AddItemsLink("SI - WF 18-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 18-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 18-TC1-Selected item from OG")
		.TapOnDone("SI - WF 18-TC1-Tapped Done")
		//  .verifyOGItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")

		.Setup_AddItemsLink("SI - WF 18-TC1-Add items Selected")
		.AddItemFrom_NonSysco("SI - WF 18-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 18-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI - WF 18-TC1-select supplier")

		._atVendorPage()
		.Add_Supplier("SI - WF 18-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 18-TC1-AddVendorDetails")
		.TapOnDone("SI - WF 18-TC1-Done")
		.TapOnBack("SI - WF 18-TC1-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 18-TC1-SupplierSelect")
		.TapOnDone("SI - WF 18-TC1-Done")

		._atSetupInventoryPage()

		.Setup_AddItemsLink("SI - WF 18-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 18-TC1-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 18-TC1-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 18-TC1-Tapped Done")


		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 18-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 18-TC1-Verify item selected")

		.verifySearchItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")

		.TapOnDone("SI - WF 18-TC1-Tapped Done")
		
		.TapOnDOThisLater("SI - WF 18-TC1-Tapped do this later")
		
		._atCategoryPage()
		.defaultCategories("SI - WF 18-TC1-Tapped Custom category")
		.tapComplete("SI - WF 18-TC1-Tapped Complete")
		.tapContinue("SI - WF 18-TC1-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 18-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 18-TC1-select added location")
		.TapOnDone("SI - WF 18-TC1-Tapped Done")
		;
	}


	@Test(groups={"SI - WF 19"},priority=0, description = "SI - WF 19-TC1-Custom List + default Loc + default Category for Normal user")
	public void SI_WF19_CustomList_defaultLoc_defaultcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData4");
		ListData listData=ListData.fetch("ListData");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 19-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 19-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 19-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 19-TC1-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 19-TC1-custom list Selected")
		.tapContinue("SI - WF 19-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 19-TC1-select list")
		.TapOnNext("SI - WF 19-TC1-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI - WF 19-TC1-Tapped Custom location")
		.tapContinue("SI - WF 19-TC1-Tapped Continue")

	
		._atCategoryPage()
		.defaultCategories("SI - WF 19-TC1-Tapped Default category")
		.tapComplete("SI - WF 19-TC1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 19-TC1-Tapped takeme home")   


        ._atInventoryToolPage()
        .InvTools_Category("SI- WF 19-TC1-Tapped Categories")
    	._atCategoryPage()
        .VerifyDefaultCategoryList("SI- WF 19-TC1-Verified default Categories List")
	  
		;

	}

	@Test(groups={"SI - WF 20"},priority=0, description = "SI - WF 20-TC1-Custom List + Custom Loc + Custom Category + All items for Normal user")
	public void SI_WF20_CustomList_CustomLoc_Customcategory_AllItems_NU() {	

		LoginData loginData =LoginData.fetch("LoginData3");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 20-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 20-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 20-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 20-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 20-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 20-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 20-TC1-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 20-TC1-custom list Selected")
		.tapContinue("SI - WF 20-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 20-TC1-select list")
		.TapOnNext("SI - WF 20-TC1-tapped next")


		._atLocationsPage()
		.CustomLocation("SI - WF 20-TC1-Tapped Custom location")
		.tapContinue("SI - WF 20-TC1-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 20-TC1-Enter location name")
		.AddLocations1_TypeDry("SI - WF 20-TC1-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 20-TC1-Tapped Dry2")
		.TapOnNext("SI - WF 20-TC1-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 20-TC1-Selected Multiple items")
		.TapOnNext("SI - WF 20-TC1-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 20-TC1-Selected Multiple items")
		.TapOnDone("SI - WF 20-TC1-Tapped Done1")
		
		._atCategoryPage()

		.CustomCategories("SI - WF 20-TC1-Custom Categories Tapped")
		.tapContinue("SI - WF 20-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 20-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 20-TC1-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 20-TC1-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 20-TC1-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 20-TC1-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 20-TC1-Tapped Done2")

		.TapTakeHome("SI - WF 20-TC1-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 20-TC1-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 20-TC1-select added location")
		.ItemVerifyOnLocation1("SI - WF 20-TC1-Item verification")
		.TapOnDone("SI - WF 1-TC1-Tapped Done")
		.SelectLocation(locationsData2.LocationName, "SI - WF 20-TC1-select added location")
		.ItemVerifyOnLocation2("SI - WF 20-TC1-Item verification")
		.TapOnDone("SI - WF 20-TC1-Tapped Done")      
		;
	}	
	@Test(groups={"SI - WF 21"},priority=0, description = "SI - WF 21-TC1-Custom List + Custom Loc + Custom Category + Few items for Normal user")
	public void SI_WF21_CustomList_CustomLoc_Customcategory_FewItems_NU() {	

		LoginData loginData =LoginData.fetch("LoginData1");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData4 =LocationsData.fetch("LocatiosData4");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 21-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 21-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 21-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 21-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 21-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 21-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 21-TC1-Ready to start")
		
		._atListPage()
		.TapCustomList("SI - WF 21-TC1-custom list Selected")
		.tapContinue("SI - WF 21-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 21-TC1-select list")
		.TapOnNext("SI - WF 21-TC1-tapped next")


		._atLocationsPage()
		.CustomLocation("SI - WF 21-TC1-Tapped Custom location")
		.tapContinue("SI - WF 21-TC1-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 21-TC1-Enter location name")
		.AddLocations1_TypeDry("SI - WF 21-TC1-Tapped Dry1")

		.AddLocations2("SI - WF 21- tapped add another location")
		.AddLocations2_name(locationsData2.LocationName,"enter loc name 2")
		.AddLocations2_TypeDry("SI - WF 21-TC1-Tapped Dry2")
		.TapOnNext("SI - WF 21-TC1-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 21-TC1-Selected Multiple items")
		.TapOnNext("SI - WF 21-TC1-Tapped Next2")
		.selectMultipleItemsFromLocation2("SI - WF 21-TC1-Selected Multiple items")
		.selectMultipleItemsFromLocation2("SI - WF 21-TC1-Selected Multiple items")
		.TapOnDone("SI - WF 21-TC1-Tapped Done1")
		
		._atCategoryPage()

		.CustomCategories("SI - WF 21-TC1-Custom Categories Tapped")
		.tapContinue("SI - WF 21-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 21-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 21-TC1-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 21-TC1-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 21-TC1-Tapped Next4")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 21-TC1-Tapped Done2")

		.TapTakeHome("SI - WF 21-TC1-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 21-TC1-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 21-TC1-select added location")
		.ItemVerifyOnLocation1("SI - WF 21-TC1-Item verification")
		.TapOnDone("SI - WF 1-TC1-Tapped Done")
		.SelectLocation(locationsData4.LocationName, "SI - WF 21-TC1-select added location")
		.ItemVerifyOnLocation2("SI - WF 21-TC1-Item verification")
		.TapOnDone("SI - WF 21-TC1-Tapped Done")      
		;
	}	



	@Test(groups={"SI - WF 22"},priority=0, description = "SI - WF 22-TC1-Custom List + Default Loc + custom Category for Normal user")
	public void SI_WF22_CustomList_DefaultLoc_Customcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData4");
		ListData listData=ListData.fetch("ListData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 22-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 22-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 22-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 22-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 22-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 22-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 22-TC1-Skip1 Tapped")
		
		._atListPage()
		.TapCustomList("SI - WF 22-TC1-custom list Selected")
		.tapContinue("SI - WF 22-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 22-TC1-select list")
		.TapOnNext("SI - WF 22-TC1-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI - WF 22-TC1-Tapped Custom location")
		.tapContinue("SI - WF 22-TC1-Tapped Continue")

		
		._atCategoryPage()

		.CustomCategories("SI - WF 22-TC1-Custom Categories Tapped")
		.tapContinue("SI - WF 22-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 22-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI - WF 22-TC1-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI - WF 22-TC1-selectMultipleItemsFromCategory1")
		.TapOnNext("SI - WF 22-TC1-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI - WF 22-TC1-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI - WF 22-TC1-Tapped Done2")

		.TapTakeHome("SI - WF 22-TC1-Tapped Continue3")   


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 22-TC1-Selected track inventory")


		;

	}
	
	@Test(groups={"SI - WF 23"},priority=0, description = "SI - WF 23-TC1-Custom List + Custom Loc + default Category for Normal user")
	public void SI_WF23_CustomList_CustomLoc_defaultcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData3");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 23-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 23-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 23-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 23-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 23-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 23-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 23-TC1-Skip2 Tapped")
		
		._atListPage()
		.TapCustomList("SI - WF 23-TC1-custom list Selected")
		.tapContinue("SI - WF 23-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 23-TC1-select list")
		.TapOnNext("SI - WF 23-TC1-tapped next")


		._atLocationsPage()
		.CustomLocation("SI - WF 23-TC1-Tapped Custom location")
		.tapContinue("SI - WF 23-TC1-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 23-TC1-Enter location name")
		.AddLocations1_TypeDry("SI - WF 23-TC1-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData2.LocationName,"")
		.AddLocations2_TypeDry("SI - WF 23-TC1-Tapped Dry2")
		.TapOnNext("SI - WF 23-TC1-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 23-TC1-Selected Multiple items")
		.TapOnNext("SI - WF 23-TC1-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 23-TC1-Selected Multiple items")
		.TapOnDone("SI - WF 23-TC1-Tapped Done1")
		
		._atCategoryPage()
		.defaultCategories("SI - WF 23-TC1-Tapped Default category")
		.tapComplete("SI - WF 23-TC1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 23-TC1-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 23-TC1-Selected track inventory")
      
		
		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 23-TC1-select added location")
		.ItemVerifyOnLocation1("SI - WF 23-TC1-Item verification in location1")
		.SyscoCategoryIdentify("SI - WF 23-TC1-Category Identification in location1")
		._atCategoryPage()
		.VerifyCustomListItemsDefaultCategoryLocation1("SI- WF 23-TC1-Verifying default categories in location1")
		.TapOnDone("SI - WF 1-TC1-Tapped Done")
		._atLocationsPage()
		.SelectLocation(locationsData2.LocationName, "SI - WF 23-TC1-select added location")
		.ItemVerifyOnLocation2("SI - WF 23-TC1-Item verification in location2")
		.SyscoCategoryIdentify("SI - WF 23-TC1-Category Identification in location1")
		._atCategoryPage()
		.VerifyCustomListItemsDefaultCategoryLocation2("SI- WF 23-TC1-Verifying default categories in location2")
		//.TapOnDone("SI - WF 23-TC1-Tapped Done")      
		;
	}

	@Test(groups={"SI - WF 24"},priority=0, description = "SI - WF 24-TC1-Custom List + Skip location+ Skip Category for Normal user")
	public void SI_WF24_CustomList_SkipLoc_Skipcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData4");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 24-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 24-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 24-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 24-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 24-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 24-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-TC1-Skip1 Tapped")
		
		._atListPage()
		.TapCustomList("SI - WF 24-TC1-custom list Selected")
		.tapContinue("SI - WF 24-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 24-TC1-select list")
		.TapOnNext("SI - WF 24-TC1-tapped next")


		._atSetupInventoryPage()
		
		.TapOnDOThisLater("SI - WF 224-TC1-STapOnDOThisLater Tapped")


		.TapOnSkip("SI - WF 24-TC1-Skip3 Tapped") 

		.TapOnDOThisLater("SI - WF 24 TC1-TapOnDOThisLater Tapped")

		.tapContinue("SI - WF 24-TC1-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 24-TC1-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 24-TC1-select added location")
		//.ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
		.TapOnDone("SI - WF 24-TC1-Tapped Done")
		;

	}
	@Test(groups={"SI - WF 25"},priority=0, description = "SI - WF 25-TC1-Custom List+Default loc + Skip Category for Normal user")
	public void SI_WF25_CustomList_DefaultLoc_Skipcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData1");
		ListData listData=ListData.fetch("ListData");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 25-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 25-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 25-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 25-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 25-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 25-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 25-TC1-Skip1 Tapped")
		
		._atListPage()
		.TapCustomList("SI - WF 25-TC1-custom list Selected")
		.tapContinue("SI - WF 25-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 25-TC1-select list")
		.TapOnNext("SI - WF 25-TC1-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI - WF 25-TC1-Tapped Custom location")
		.tapContinue("SI - WF 25-TC1-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("SI - WF 25-TC1-STapOnDOThisLater Tapped")


		.TapTakeHome("SI - WF 25-TC1-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 25-TC1-Selected track inventory")

		;

	}
	@Test(groups={"SI - WF 26"},priority=0, description = "SI - WF 26-TC1-Custom List+skip location + default category for Normal user")
	public void SI_WF26_CustomList_SkipLoc_defaultcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData3");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 26-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 26-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 26-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 26-TC1 Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 26-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 26-TC1-SetupInventoryTap")

	._atSetupInventoryPage()
		.TapOnSkip("SI - WF 26-TC1-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI - WF 26-TC1-custom list Selected")
		.tapContinue("SI - WF 26-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 26-TC1-select list")
		.TapOnNext("SI - WF 26-TC1-tapped next")


		._atSetupInventoryPage()
		
		.TapOnDOThisLater("SI - WF 26-TC1-TapOnDOThisLater Tapped")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 26-TC1-Skip1 Tapped")

		._atCategoryPage()
		.defaultCategories("SI - WF 26-TC2-Tapped Custom category")
		.tapComplete("SI - WF 26-TC2-Tapped Complete")
		
		.tapContinue("SI - WF 26-TC2-Tapped Continue")


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 26-TC1-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 26-TC1-select added location")
		//.ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
		.TapOnDone("SI - WF 26-TC1-Tapped Done")
		;

	}
	//Precondition: Need 2 items each for List2,List3 for logged in user. Give item ID on datapool. uomsc002
		@Test(groups={"SI - WF 27"},priority=0, description = "SI - WF 27-TC1-Custom List + Select Multiple List +List Names+Default Cat for Normal user")
		public void SI_WF27_CustomList_MultipleList_ListNames_DefaultCat_NU() {	

			LoginData loginData =LoginData.fetch("LoginData4");
			ListData listData=ListData.fetch("ListData2");
			ListData listData1=ListData.fetch("ListData3");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 27-TC1-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 27-TC1-Save Username")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 27-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 27-TC1 Clicked account")

			._atAccountsPage()
			.Fifth_AccountSelection(loginData.UserName,"SI - WF 27-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 27-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 27-TC1-Skip1 Tapped")
			
			._atListPage()
			.TapCustomList("SI - WF 27-TC1-custom list Selected")
			.tapContinue("SI - WF 27-TC1-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "SI - WF 27-TC1-select list")
			.SelectListwithItems(listData1.ListName, "SI - WF 27-TC1-select list")
			.TapOnNext("SI - WF 27-TC1-tapped next")


			._atLocationsPage()
			.ListNames("SI - WF 27-TC1-Tapped Custom location")
			.tapContinue("SI - WF 27-TC1-Tapped Continue")

		
			._atCategoryPage()
			.defaultCategories("SI - WF 27-TC1-Tapped Default category")
			.tapComplete("SI - WF 27-TC1-Tapped Complete")

			._atSetupInventoryPage() 
			.TapTakeHome("SI - WF 27-TC1-Tapped take me home")      

			._atInventoryToolPage()
			.InvTools_TrackInventory("SI - WF 27-TC1-Selected track inventory")
			._atLocationsPage()
			.SelectLocation(listData.ListName, "SI - WF 27-TC1-select added location")
			.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI - WF 27-TC1-Item verification")
			.TapOnDone("SI - WF 1-TC1-Tapped Done")
			.SelectLocation(listData1.ListName, "SI - WF 27-TC1-select added location")
			.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI - WF 27-TC1-Item verification")
			.TapOnDone("SI - WF 27-TC1-Tapped Done")      
			;

			;

		}
		//Precondition: Need 2 items each for List2,List3 for logged in user. Give item ID on datapool. uomsc002

		@Test(groups={"SI - WF 28"},priority=0, description = "SI - WF 28-TC1-Custom List + Select Multiple List +List Names as location+custom Cat for Normal user")
		public void SI_WF28_CustomList_MultipleList_ListNames_Customcategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData3");
			ListData listData=ListData.fetch("ListData2");
			ListData listData1=ListData.fetch("ListData3");
			CategoryData categoryData=CategoryData.fetch("CategoryData");

			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 28-TC1-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 28-TC1-Save Username")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 28-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 28-TC1 Clicked account")

			._atAccountsPage()
			.Fifth_AccountSelection(loginData.UserName,"SI - WF 28-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 28-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
			.TapOnSkip("SI - WF 28-TC1-Skip1 Tapped")

			._atListPage()
			.TapCustomList("SI - WF 28-TC1-custom list Selected")
			.tapContinue("SI - WF 28-TC1-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "SI - WF 28-TC1-select list")
			.SelectListwithItems(listData1.ListName, "SI - WF 28-TC1-select list")
			.TapOnNext("SI - WF 28-TC1-tapped next")


			
			._atLocationsPage()
			.ListNames("SI - WF 28-TC1-Tapped List Names")
			.tapContinue("SI - WF 28-TC1-Tapped Continue")

			

			._atCategoryPage()

			.CustomCategories("SI - WF 28-TC1-Custom Categories Tapped")
			.tapContinue("SI - WF 28-TC1-Tapped Continue3")
			.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 28-TC1-CreateTwoExpenseCategory")
			.TapOnNext("SI - WF 28-TC1-Tapped Next3")
			.selectMultipleItemsFromCategory1("SI - WF 28-TC1-selectMultipleItemsFromCategory1")
			.TapOnNext("SI - WF 28-TC1-Tapped Next4")
			._atSetupInventoryPage()
			.TapOnDone("SI - WF 28-TC1-Tapped Done2")
			._atSetupInventoryPage() 
			.TapTakeHome("SI - WF 28-TC1-Tapped take me home")      

			._atInventoryToolPage()
			.InvTools_TrackInventory("SI - WF 28-TC1-Selected track inventory")
			._atLocationsPage()
			.SelectLocation(listData.ListName, "SI - WF 28-TC1-select added location")
			.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI - WF 28-TC1-Item verification")
			.TapOnDone("SI - WF 28-TC1-Tapped Done")
			.SelectLocation(listData1.ListName, "SI - WF 28-TC1-select added location")
			.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI - WF 28-TC1-Item verification")
			.TapOnDone("SI - WF 28-TC1-Tapped Done")      
			;

			;

		}	
		@Test(groups={"SI - WF 29"},priority=0, description = "SI - WF 29-TC1-Custom List + Select single  List +Custom categories as location+Default Cat")
		public void SI_WF29_CustomListSingleList_CustomCategoryOnLocationsPage_defaultcategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData1");
			ListData listData=ListData.fetch("ListData");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 29-TC1-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 29-TC1-Save Username")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 29-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 29-TC1 Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"SI - WF 29-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 29-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 29-TC1-Skip1 Tapped")

			._atListPage()
			.TapCustomList("SI - WF 29-TC1-custom list Selected")
			.tapContinue("SI - WF 29-TC1-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "SI - WF 29-TC1-select list")
			.TapOnNext("SI - WF 29-TC1-tapped next")


			._atLocationsPage()
			.CustomCategories("SI - WF 29-TC1-Tapped Default category in Location Page")
			.tapContinue("SI - WF 29-TC1-Tapped Continue2")
			
			._atCategoryPage()
			.defaultCategories("SI - WF 29-TC1-Tapped Default category")
			.tapComplete("SI - WF 29-TC1-Tapped Complete")
			._atSetupInventoryPage()
			.TapTakeHome("SI - WF 29-TC1-Tapped Continue3")   
			._atInventoryToolPage()
			.InvTools_TrackInventory("SI - WF 29-TC1-Selected track inventory")


			;
		}






		@Test(groups={"SI - WF 30"},priority=0, description = "SI - WF 30-TC1-Custom List + Select single  List +Custom Categories as location+Custom Cat")
		public void SI_WF30_CustomListSingleList_CustomCategoryOnLocationsPage_customcategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData4");
			ListData listData=ListData.fetch("ListData");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 30-TC1-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 30-TC1-Save Username")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 30-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 30-TC1 Clicked account")

			._atAccountsPage()
			.Fifth_AccountSelection(loginData.UserName,"SI - WF 30-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 30-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 30-TC1-Skip1 Tapped")

			._atListPage()
			.TapCustomList("SI - WF 30-TC1-custom list Selected")
			.tapContinue("SI - WF 30-TC1-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "SI - WF 29-TC1-select list")
			.TapOnNext("SI - WF 30-TC1-tapped next")


			._atLocationsPage()
			.CustomCategories("SI - WF 30-TC1-Tapped Default category in Location Page")
			.tapContinue("SI - WF 30-TC1-Tapped Continue2")
			
			._atCategoryPage()
			.CustomCategories("SI - WF 30-TC1-Custom Categories Tapped")
			.tapContinue("SI - WF 30-TC1-Tapped Continue3")
			.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 20-TC1-CreateTwoExpenseCategory")
			.TapOnNext("SI - WF 30-TC1-Tapped Next3")
			.selectMultipleItemsFromCategory1("SI - WF 30-TC1-selectMultipleItemsFromCategory1")
			.TapOnNext("SI - WF 30-TC1-Tapped Next4")
			.selectMultipleItemsFromCategory2("SI - WF 20-TC1-selectMultipleItemsFromCategory2")
			._atSetupInventoryPage()
			.TapOnDone("SI - WF 30-TC1-Tapped Done2")

			.TapTakeHome("SI - WF 30-TC1-Tapped Continue3")   

			._atInventoryToolPage()
			.InvTools_TrackInventory("SI - WF 30-TC1-Selected track inventory")

			;
		}
		//Precondition: Need 2 items each for List2,List3 for logged in user. Give item ID on datapool. uomsc002

			@Test(groups={"SI - WF 31"},priority=0, description = "SI - WF 31-TC1-Custom List + Select Multiple List +List Names as location+skip Cat for Normal user")
			public void SI_WF31_CustomList_MultipleList_ListNames_Skipcategory_NU() {	

				LoginData loginData =LoginData.fetch("LoginData3");
				ListData listData=ListData.fetch("ListData2");
				ListData listData1=ListData.fetch("ListData3");
				
				Start.asTester
				.goToLoginpage()
				.verifyLoginPage("SI - WF 31-TC1-LoginPage")
				.saveUsernameCheckBoxClick("SI - WF 31-TC1-Save Username")
				.signIn(loginData.UserName, loginData.Password,"SI - WF 31-TC1-LoginPage")

				._atHomePage()
				.ClickAccount(loginData.UserName,"SI - WF 31-TC1 Clicked account")

				._atAccountsPage()
				.Fifth_AccountSelection(loginData.UserName,"SI - WF 31-TC1-FirstAccountSelect")

				._atInventoryToolPage()
				.InvTools_SetUpInventory("SI - WF 31-TC1-SetupInventoryTap")

				._atSetupInventoryPage()
				.TapOnSkip("SI - WF 31-TC1-Skip1 Tapped")

				._atListPage()
				.TapCustomList("SI - WF 31-TC1-custom list Selected")
				.tapContinue("SI - WF 31-TC1-Tapped Continue1")
				.SelectListwithItems(listData.ListName, "SI - WF 31-TC1-select list")
				.SelectListwithItems(listData1.ListName, "SI - WF 31-TC1-select list")
				.TapOnNext("SI - WF 31-TC1-tapped next")


				._atLocationsPage()
				.ListNames("SI - WF 31-TC1-Tapped List Names")
				.tapContinue("SI - WF 31-TC1-Tapped Continue")

				._atSetupInventoryPage()
				.TapOnDOThisLater("SI - WF 31-TC1-STapOnDOThisLater Tapped")

				._atSetupInventoryPage() 
				.TapTakeHome("SI - WF 31-TC1-Tapped take me home")      

				._atInventoryToolPage()
				.InvTools_TrackInventory("SI - WF 31-TC1-Selected track inventory")
				._atLocationsPage()
				.SelectLocation(listData.ListName, "SI - WF 31-TC1-select added location")
				.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI - WF 31-TC1-Item verification")
				.TapOnDone("SI - WF 31-TC1-Tapped Done")
				.SelectLocation(listData1.ListName, "SI - WF 31-TC1-select added location")
				.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI - WF 31-TC1-Item verification")
				.TapOnDone("SI - WF 31-TC1-Tapped Done")      
				;

				;

			}
		@Test(groups={"SI - WF 32"},priority=0, description = "SI - WF 32-TC1-Custom List + Select single  List +Custom categories as location+Skip Cat for Normal user")
		public void SI_WF32_CustomList_SingleList_CustomCatLoc_Skipcategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData1");
			ListData listData=ListData.fetch("ListData");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 32-TC1-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 32-TC1-Save Username")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 32-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 32-TC1 Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"SI - WF 32-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 32-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 32-TC1-Skip1 Tapped")

			._atListPage()
			.TapCustomList("SI - WF 32-TC1-custom list Selected")
			.tapContinue("SI - WF 32-TC1-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "SI - WF 32-TC1-select list")
			.TapOnNext("SI - WF 32-TC1-tapped next")


			
			._atLocationsPage()
			.CustomCategories("SI - WF 32-TC1-Tapped Custom location")
			.tapContinue("SI - WF 32-TC1-Tapped Continue")

			._atSetupInventoryPage()
				.TapOnDOThisLater("SI - WF 32-TC1-STapOnDOThisLater Tapped")


			.TapTakeHome("SI - WF 32-TC1-Tapped take me home")      

			._atInventoryToolPage()
			.InvTools_TrackInventory("SI - WF 32-TC1-Selected track inventory")


			;

		}
		
		@Test(groups={"SI - WF 33"},priority=0, description = "SI - WF 33-TC1-OG + Default Loc + Suggested Category")
		public void SI_WF33_OG_DefaultLocation_SuggestedCategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData6");	 

				Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 33-TC1-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 33-TC1-Save Username")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 33-TC1-LoginPage")
			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 33-TC1-Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"SI - WF 33-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 33-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 33-TC1-Skip1 Tapped")
			.TapOrderGuide("SI - WF 33-TC1-OG Selected")
			.tapContinue("SI - WF 33-TC1-Tapped Continue")
			

			._atLocationsPage()
			.DefaultLocation("SI - WF 33-TC1-Tapped Custom location")
			.tapContinue("SI - WF 33-TC1-Tapped Continue")

			._atSetupInventoryPage() 
			
			._atCategoryPage()
			.SuggestedCategories("SI - WF 33-TC1-SuggestedCategories Tapped")
			.tapContinue("SI - WF 33-TC1-Tapped Continue3")

			._atSetupInventoryPage()
			.TapTakeHome("SI - WF 33-TC1-Tapped Take me Home")

			._atInventoryToolPage()
			.InvTools_TrackInventory("SI- WF 33-TC1-Selected track inventory")


			;



		}
		@Test(groups={"SI - WF 34"},priority=0, description = "SI - WF 34-TC1-OG + Custom Loc + Suggested Category")
		public void SI_WF34_OG_CustomLocation_SuggestedCategory_MA() {	

			LoginData loginData =LoginData.fetch("LoginData5"); 
			LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
			LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 34-TC1-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 34-TC1-Save Username")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 34-TC1-LoginPage")
			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 34-TC1-Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"SI - WF 34-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 34-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 34-TC1-Skip1 Tapped")
			.TapOrderGuide("SI - WF 34-TC1-OG Selected")
			.tapContinue("SI - WF 34-TC1-Tapped Continue")
			

			._atLocationsPage()
			.CustomLocation("SI - WF 34-TC1-Tapped Custom location")
			.tapContinue("SI - WF 34-TC1-Tapped Continue2")

			.EnterLocationName(locationsData1.LocationName,"SI - WF 34-TC1-Enter location name")
			.AddLocations1_TypeDry("SI - WF 34-TC1-Tapped Dry1")

			.AddLocations2("")
			.AddLocations2_name(locationsData2.LocationName,"")
			.AddLocations2_TypeDry("SI - WF 34-TC1-Tapped Dry2")
			.TapOnNext("SI - WF 34-TC1-Tapped Next1")

			.selectMultipleItemsFromLocation1("SI - WF 34-TC1-Selected Multiple items")
			.TapOnNext("SI - WF 34-TC1-Tapped Next2")

			.selectMultipleItemsFromLocation2("SI - WF 34-TC1-Selected Multiple items")
			.TapOnDone("SI - WF 34-TC1-Tapped Done1")

			._atSetupInventoryPage() 
			
			._atCategoryPage()
			.SuggestedCategories("SI - WF 34-TC1-SuggestedCategories Tapped")
			.tapContinue("SI - WF 34-TC1-Tapped Continue3")

			._atSetupInventoryPage()
			.TapTakeHome("SI - WF 34-TC1-Tapped Take me Home")

			._atInventoryToolPage()
			.InvTools_TrackInventory("SI- WF 34-TC1-Selected track inventory")

			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "SI - WF 34-TC1-select added location1")
			.ItemVerifyOnLocation1("SI - WF 34-TC1-Verify item inside location1")
			.SyscoCategoryIdentify("SI - WF 34-TC1-Category identification for Syscoitems in location1")
			._atCategoryPage()
			.VerifyOGSyscoItemsSuggestedCategoryLocation1("SI - WF 34-TC1-Category verification for Syscoitems in location1")
			.TapOnDone("SI - WF 34-TC1-Tapped Done2")
			._atLocationsPage()
			.SelectLocation(locationsData2.LocationName, "SI - WF 34-TC1-select added location2")
			.ItemVerifyOnLocation2( "SI - WF 34-TC1-Verify item inside location2")
			.SyscoCategoryIdentify("SI - WF 34-TC1-Category identification for Syscoitems in location2")
			._atCategoryPage()
			.VerifyOGSyscoItemsSuggestedCategoryLocation1("SI - WF 34-TC1-Category verification for Syscoitems in location2")

			.TapOnDone("SI - WF 34-TC1-Tapped Done3")

			;


		}

	
	@Test(groups={"SI - WF 35"},priority=0, description = "SI - WF 35-TC1-Custom List + Select single  List +Custom Categories as location+Suggested Cat")
	public void SI_WF35_CustomListSingleList_CustomCategoryOnLocationsPage_suggestedcategory_NU() {

		LoginData loginData =LoginData.fetch("LoginData4");
		ListData listData=ListData.fetch("ListData");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 35-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 35-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 35-TC1-LoginPage")
		
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 35-TC1 Clicked account")
		
		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 35-TC1-FirstAccountSelect")
		
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 35-TC1-SetupInventoryTap")
		
		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 35-TC1-Skip1 Tapped")
		
		._atListPage()
		.TapCustomList("SI - WF 35-TC1-custom list Selected")
		.tapContinue("SI - WF 35-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 35-TC1-select list")
		.TapOnNext("SI - WF 35-TC1-tapped next")
		
		
		._atLocationsPage()
		.CustomCategories("SI - WF 35-TC1-Tapped Default category in Location Page")
		.tapContinue("SI - WF 35-TC1-Tapped Continue2")
		
		
		._atCategoryPage()
		.SuggestedCategories("SI - WF 35-TC1-SuggestedCategories Tapped")
		.tapContinue("SI - WF 35-TC1-Tapped Continue3") 
		
		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 35-TC1-Tapped Take me Home")
		
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 35-TC1-Selected track inventory")

		;

	}


	//Precondition: Need 2 items each for List2,List3 for logged in user. Give item ID on datapool. uomsc002
	@Test(groups={"SI - WF 36"},priority=0, description = "SI - WF 36-TC1-Custom List + Select Multiple List +List Names+Suggested Cat for Normal user")
	public void SI_WF36_CustomList_MultipleList_ListNames_SuggestedCat_NU() {
		
		LoginData loginData =LoginData.fetch("LoginData3");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");
		

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 36-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 36-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 36-TC1-LoginPage")
		
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 36-TC1 Clicked account")
		
		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 36-TC1-FirstAccountSelect")
		
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 36-TC1-SetupInventoryTap")
		
		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 36-TC1-Skip1 Tapped")
		
		._atListPage()
		.TapCustomList("SI - WF 36-TC1-custom list Selected")
		.tapContinue("SI - WF 36-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 36-TC1-select list")
		.SelectListwithItems(listData1.ListName, "SI - WF 36-TC1-select list")
		.TapOnNext("SI - WF 36-TC1-tapped next")
			
		._atLocationsPage()
		.ListNames("SI - WF 36-TC1-Tapped Custom location")
		.tapContinue("SI - WF 36-TC1-Tapped Continue")
		
		._atCategoryPage()
		.SuggestedCategories("SI - WF 36-TC1-SuggestedCategories Tapped")
		.tapContinue("SI - WF 36-TC1-Tapped Continue1")
		
		._atSetupInventoryPage() 
		.TapTakeHome("SI - WF 36-TC1-Tapped take me home")      
		
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 36-TC1-Selected track inventory")
		
		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI - WF 36-TC1-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI - WF 36-TC1-Item verification")
		.TapOnDone("SI - WF 36-TC1-Tapped Done")
		.SelectLocation(listData1.ListName, "SI - WF 36-TC1-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI - WF 36-TC1-Item verification")
		
		//changing category and verification
		._atSetupInventoryPage()
		.VerifyProductID_Location("SI - WF 36-TC1-Verified Product")
		._atCategoryPage()
		.VerifySuggestedCategory("SI - WF 36-TC1-Verified Category")
		._atLocationsPage()
		.SyscoProductSelect("SI - WF 36-TC1-Select Product")
		.TapOnEdit("SI - WF 36-TC1-Tapped Edit")
		.AddCategory_AddProductDetailsPage("SI - WF 36-TC1-CategorySelect")
		._atCategoryPage()
		.TapAnySuggestedCategory("SI - WF 36-TC1- tapped on a suggested category")
		.TapOnDone("SI - WF 36-TC1-Tapped Done")
		.TapOnBack("SI - WF 36-TC1-Tapped Back")
		.VerifySelectedSuggestedCategory("SI - WF 36-TC1-Verified Category")
			
		.TapOnDone("SI - WF 36-TC1-Tapped Done")      

		;


	}

	@Test(groups={"SI - WF 37"},priority=0, description = "SI - WF 37-TC1-Start from scratch+ Multiple lists +Custom location +Suggested category")
	public void SI_WF37_StartFromScratch_MultipleList_CustomLocation_SuggestedCategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData6");	  
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 37-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 37-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 37-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 37-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI- WF 37-TC1-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 37-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 37-TC1-Tapped Skip1")

		.StartFromScratch("SI- WF 37-TC1-ScratchSelected")
		.tapContinue("SI- WF 37-TC1-Tapped Continue1")
		.Scratch_AddItems("SI- WF 37-TC1-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 37-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 37-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 37-TC1-select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 37-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 37-TC1-AddVendorDetails")
		.TapOnDone("SI- WF 37-TC1-Tapped Done1")
		.TapOnBack("SI- WF 37-TC1-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 37-TC1-SupplierSelect")
		.TapOnDone("SI- WF 37-TC1-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 37-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 37-TC1-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 37-TC1-PrepItemAddPage")
		.TapOnDone("SI- WF 37-TC1-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 37-TC1-Add items Selected")
		.SearchItem(searchData.keyword,"SI- WF 37-TC1-Search item")
		.SelectItemFrom_Catalog("SI- WF 37-TC1-Selected item from catalog")
		.TapOnDone("SI- WF 37-TC1-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 37-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 37-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 37-TC1-Selected item from OG")
		.TapOnDone("SI- WF 37-TC1-Tapped Done5")


		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 37-TC1-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 37-TC1-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 37-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 37-TC1-Verify nonsysco item selected")


		.TapOnDone("SI- WF 37-TC1-Tapped Done6")
	
		// location setup
		._atLocationsPage()
		.CustomLocation("SI- WF 37-TC1-Tapped Custom location")
		.tapContinue("SI- WF 37-TC1-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI- WF 37-TC1-Enter location name")
		.AddLocations1_TypeDry("SI- WF 37-TC1-Tapped Dry1")

		.AddLocations2("")
		.AddLocations2_name(locationsData1.LocationName,"")
		.AddLocations2_TypeDry("SI- WF 37-TC1-Tapped Dry2")
		.TapOnNext("SI- WF 37-TC1-Tapped Next1")

		.AssignMultipleListItemsToLocation("SI- WF 37-TC1-Selected Multiple items to Location1")
		.TapOnNext("SI- WF 37-TC1-Tapped Next2")
		.AllItemsTabClick("SI- WF 37-TC1-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI- WF 37-TC1-Selected Multiple items to Location2")
		.TapOnDone("SI- WF 37-TC1-Tapped Done7")

		
		._atCategoryPage()
		.SuggestedCategories("SI - WF 37-TC1-SuggestedCategories Tapped")
		.tapContinue("SI - WF 37-TC1-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 37-TC1-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 37-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI- WF 37-TC1-Select added location1")
		.VerifyMultipleListItemsInLocation("SI- WF 37-TC1-Verifying Multiple items in Location1")
		.TapOnBack("SI- WF 37-TC1-Tapped back2")
		.SelectLocation(locationsData1.LocationName, "SI- WF 37-TC1-Select added location2")
		.VerifyMultipleListItemsInLocation("SI- WF 37-TC1-Verifying Multiple items in Location2")
		.SyscoCategoryIdentify("SI- WF 37-TC1-Identifying categories")
		._atCategoryPage()
		.VerifyMultipleListSyscoSuggestedCategory("SI- WF 37-TC1-Verifying categories")
		;
	}


@Test(groups={"SI - WF 38"},priority=0, description = "SI - WF 38-TC1-Start from scratch+ Multiple lists +Default location + Suggested category")
	public void SI_WF38_StartFromScratch_MultipleList_DefaultLocation_SuggestedCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData5");       
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI- WF 38-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI- WF 38-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI- WF 38-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI- WF 38-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI- WF 38-TC1-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI- WF 38-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI- WF 38-TC1-Tapped Skip1")

		.StartFromScratch("SI- WF 38-TC1-ScratchSelected")
		.tapContinue("SI- WF 38-TC1-Tapped Continue1")
		.Scratch_AddItems("SI- WF 38-TC1-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI- WF 38-TC1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI- WF 38-TC1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI- WF 38-TC1-select supplier")

		._atVendorPage()
		.Add_Supplier("SI- WF 38-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI- WF 38-TC1-AddVendorDetails")
		.TapOnDone("SI- WF 38-TC1-Tapped Done on add supplier page")
		.TapOnBack("SI- WF 38-TC1-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI- WF 38-TC1-SupplierSelect")
		.TapOnDone("SI- WF 38-TC1-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI- WF 38-TC1-Add items Selected")
		.AddItemFrom_PrepItem("SI- WF 38-TC1-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 38-TC1-PrepItemAddPage")
		.TapOnDone("SI- WF 38-TC1-Tapped Done3")

		.Setup_AddItemsLink("SI- WF 38-TC1-Add items Selected")
		.SearchItem(searchData.keyword,"SI- WF 38-TC1-Search item")
		.SelectItemFrom_Catalog("SI- WF 38-TC1-Selected item from catalog")
		.TapOnDone("SI- WF 38-TC1-Tapped Done4")

		.Setup_AddItemsLink("SI- WF 38-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 38-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 38-TC1-Selected item from OG")
		.TapOnDone("SI- WF 38-TC1-Tapped Done6")

		//verifications  
	 
		.verifySearchItemsOnSetupInv("SI- WF 38-TC1-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 38-TC1-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 38-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 38-TC1-Verify nonsysco item selected")

		.TapOnDone("SI- WF 38-TC1-Tapped Done6")
		
		
		// location setup
		._atLocationsPage()
		.DefaultLocation("SI - WF 38-TC1-Tapped Custom location")
		.tapContinue("SI - WF 38-TC1-Tapped Continue2")

	
		._atCategoryPage()
		.SuggestedCategories("SI - WF 38-TC1-SuggestedCategories Tapped")
		.tapContinue("SI - WF 38-TC1-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 38-TC1-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 38-TC1-Selected track inventory")

           ._atLocationsPage()
		  .SelectLocation(locationsData.LocationName, "SI- WF 38-TC1-Select added location1")
		   ._atSetupInventoryPage()
			.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 38-TC1-Verify prep item selected")
			.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 38-TC1-Verify nonsysco item selected")
	        .TapOnDone("SI - WF 38-TC1-Tapped Done")
	        
	    	._atLocationsPage()
	        .TapOnBack("SI- WF 38-TC1-Tapped back")
	        ._atInventoryToolPage()
	        .InvTools_Category("SI- WF 38-TC1-Tapped Categories")
	    	._atCategoryPage()
	        .VerifySuggestedCategoryList("SI- WF 38-TC1-Verified Suggested Categories List")
		;

	}
@Test(groups={"TI-WF1-WF2"},priority=2, description = "TI-WF1-WF2-TC1-Select a location from trackinventory updating quantity and uom")
public void TI_WF1_WF2_Location_Item_UOMQuantity_NU() {	

	LoginData loginData =LoginData.fetch("LoginData8");	
	LocationsData locationsData1 =LocationsData.fetch("LocationsData");
	UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
	UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData1");
	PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

	Start.asTester
	.goToLoginpage()
	.verifyLoginPage("TI-WF1-WF2-TC1-LoginPage")
	.signIn(loginData.UserName, loginData.Password,"TI-WF1-WF2-TC1-LoginPage")

	._atHomePage()
	.ClickAccount(loginData.UserName,"TI-WF1-WF2-TC1-Clicked account")

	._atAccountsPage()
	.First_AccountSelection(loginData.UserName,"TI-WF1-WF2-TC1-ThirdAccountSelect")

	

	//setting up inventory    
	._atInventoryToolPage()
	.InvTools_SetUpInventory("TI-WF1-WF2-TC1-SetupInventoryTap")

	._atSetupInventoryPage()
	.TapOnSkip("TI-WF1-WF2-TC1-Skip1 Tapped")
	.TapOrderGuide("TI-WF1-WF2-TC1-OG Selected")
	.tapContinue("TI-WF1-WF2-TC1-Tapped Continue")
	
	._atLocationsPage()
	.DefaultLocation("TI-WF1-WF2-TC1-Tapped Custom location")
	.tapContinue("TI-WF1-WF2-TC1-Tapped Continue")

	._atSetupInventoryPage()
	.TapOnDOThisLater("TI-WF1-WF2-TC1-Tapped do this later")
	.TapTakeHome("TI-WF1-WF2-TC1-Tapped Take me Home")
		

	._atInventoryToolPage()
	.InvTools_TrackInventory("TI-WF1-WF2-TC1-Tapped trackINventory")
	
	//creating a location
	._atLocationsPage()
	.TapAddLocation("TI-WF1-WF2-TC1-Tapped ADD")
	.AddLocationName(locationsData1.LocationName,"TI-WF1-WF2-TC1-Enter location name")
	.AddLocationCooler("TI-WF1-WF2-TC1-Tapped Cooler")
	.TapOnDone("TI-WF1-WF2-TC1-Tapped Done")
	.TapOnBack("TI-WF1-WF2-TC1-Tapped Back")
	.VerifyLocationList(locationsData1.LocationName, "TI-WF1-WF2-TC1-Verifing AddedLocation")
	
	.SelectLocation(locationsData1.LocationName, "MIL - WF 1 WF 4-TC2-Selecting AddedLocation")
	.TapAddLocation("MIL - WF 1 WF 4-TC2-Tapped ADD")
	._atSetupInventoryPage()
	.AddItemFrom_PrepItem("MIL-WF 2-TC2-Tapped Prepitem")
	.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF 2-TC2-NonSyscoItem details entered")
	.TapOnDone("MIL-WF 2-TC2-Tapped Done")
	.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL - WF 1,4-TC2-Verify item selected")
	
	
	._atLocationsPage()
	//.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-TC1-Selected location for entering")
	.ProductQtyEnter(uomQuantityData.Quantity,"TI-WF1-WF2-TC1-Entering Quantity1")
	.UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-TC1-Entering Uom unit OZ")
	.TapOnDone("TI-WF1-WF2-TC1-Tapped done")
	
	.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-TC1-Selected location for verifying")
	.QuantityVerify(uomQuantityData.Quantity, "TI-WF1-WF2-TC1-Verifying Quantity1")

	.TapOnBack("TI-WF1-WF2-TC1-Tapped Back")

	._atLocationsPage()
	.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-TC1-Selected location for updating")
	.ProductQtyEnter(uomQuantityData1.Quantity,"TI-WF1-WF2-TC1-Entering Quantity2")
	.UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-TC1-Entering Uom unit OZ")
	.TapOnDone("TI-WF1-WF2-TC1-Tapped done")

	.SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-TC1-Selected location for update verify")
	.QuantityVerify(uomQuantityData1.Quantity,"TI-WF1-WF2-TC1-Verifying Quantity2")

	;

}



	@Test(groups={"MIL-WF1-WF4"},priority=2, description = "MIL - WF 1,WF 4-TC2-Creating Location in trackinventory and add items from multile lists to location")
	public void MIL_WF1_WF4_Location_AddItems() {	
			
			LoginData loginData =LoginData.fetch("LoginData5");	
			LocationsData locationsData =LocationsData.fetch("LocatiosData3");
			ProductNickNameData productNickNameData=ProductNickNameData.fetch("ProductNickNameData");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
			PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
			SearchData searchData=SearchData.fetch("SearchData");
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("MIL-WF1-WF4-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"MIL-WF1-WF4-TC1-Login")

			._atHomePage()
			.ClickAccount(loginData.UserName,"MIL-WF1-WF4-TC1-Clicked account")

			._atAccountsPage()
			.Third_AccountSelection(loginData.UserName,"MIL-WF1-WF4-TC1-FirstAccountSelect")


			//setting up inventory    
			._atInventoryToolPage()
			.InvTools_SetUpInventory("MIL-WF1-WF4-TC1-SetupInventoryTap")
			._atSetupInventoryPage()
			.TapOnSkip("MIL-WF1-WF4-TC1-Skip1 Tapped")
			.TapOrderGuide("MIL-WF1-WF4-TC1-OG Selected")
			.tapContinue("MIL-WF1-WF4-TC1-Tapped Continue")
			._atLocationsPage()
			.DefaultLocation("MIL-WF1-WF4-TC1-Tapped Custom location")
			.tapContinue("MIL-WF1-WF4-TC1-Tapped Continue")
			._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF1-WF4-TC1-Tapped do this later")
			.TapTakeHome("MIL-WF1-WF4-TC1-Tapped TakeMeHome")
			
			._atInventoryToolPage()
			.InvTools_TrackInventory("MIL-WF1-WF4-TC1-TrackinventoryTap")

			._atLocationsPage()
			.TapAddLocation("MIL-WF1-WF4-TC1-Tapped ADD")
			.AddLocationName(locationsData.LocationName,"MIL-WF1-WF4-TC1-Enter location name")
			.AddLocationCooler("MIL-WF1-WF4-TC1-Tapped Cooler")
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done")
			.TapOnBack("MIL-WF1-WF4-TC1-Tapped Back")
			.VerifyLocationList(locationsData.LocationName, "MIL-WF1-WF4-TC1-Verifing AddedLocation")
			
			//nonsysco addition 
			.SelectLocation(locationsData.LocationName, "MIL-WF1-WF4-TC1-Selecting AddedLocation")
			.TapAddLocation("MIL-WF1-WF4-TC1-Tapped ADD")
			._atSetupInventoryPage()
			.AddItemFrom_NonSysco("MIL-WF1-WF4-TC1-Tapped NonSysco")
			.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF1-WF4-TC1-NonSyscoItem details entered")
			.AddSupplier_AddProductDetailsPage("MIL-WF1-WF4-TC1-select supplier")
			._atVendorPage()
			.Add_Supplier("MIL-WF1-WF4-TC1-AddVendorTap")
			.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF1-WF4-TC1-AddVendorDetails")
			.TapOnDone("MIL-WF1-WF4-TC1-Done")
			.TapOnBack("MIL-WF1-WF4-TC1-Back")
			.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF1-WF4-TC1-SupplierSelect")
			.TapOnDone("MIL-WF1-WF4-TC1-Done")


			//prepitemaddition
			._atLocationsPage()   
			.TapAddLocation("MIL-WF1-WF4-TC1-Tapped ADD")
			._atSetupInventoryPage()
			.AddItemFrom_PrepItem("MIL-WF1-WF4-TC1-Tapped NonSysco")
			.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF1-WF4-TC1-NonSyscoItem details entered")
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done")

			
			//product catalog additin
			._atLocationsPage()
			.TapAddLocation("MIL - WF 1 WF 4-TC2-Tapped ADD") 
			._atSetupInventoryPage()
			.SearchItem(searchData.keyword,"MIL-WF1-WF4-TC1-Search item")
			.SelectItemFrom_Catalog("MIL-WF1-WF4-TC1-Selected item from OG")
			.TapOnDone("MIL-WF1-WF4-TC1-Done")
			.verifySearchItemsOnSetupInv("MIL-WF1-WF4-TC1-Verify item selected")
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done")
			//assiging nickname to catalog item
			._atLocationsPage()
			.SelectLocation(locationsData.LocationName, "MIL-WF1-WF4-TC1-Selecting AddedLocation")
			.SyscoProductSelect("MIL-WF1-WF4-TC1-Select Product")
			.TapOnEdit("MIL-WF1-WF4-TC1-Tapped Edit")
			.EditProduct_NickName(productNickNameData.NickName, "MIL-WF1-WF4-TC1-Entering Nickname")
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done")
			.TapOnBack("MIL-WF1-WF4-TC1-Tapped Back")
			
			//og item addition and assigning nickname to it
			._atLocationsPage()
			.TapAddLocation("MIL-WF1-WF4-TC1-Tapped ADD")
			.AddItemFrom_OrderGuide("MIL-WF1-WF4-TC1-Tapped NonSysco")
			._atSetupInventoryPage()
			.SelectItemFrom_OrderGuide("MIL-WF1-WF4-TC1-Selected item from OG")
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done")
			.verifyOGItemsOnSetupInv("MIL-WF1-WF4-TC1-Verify item selected")  
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done") 
			
			._atLocationsPage()
			//.SelectLocation(locationsData.LocationName, "MIL-WF1-WF4-TC1-Selecting AddedLocation")
			.SyscoProductSelect("MIL-WF1-WF4-TC1-Select Product")
			.TapOnEdit("MIL-WF1-WF4-TC1-Tapped Edit")
			.EditProduct_NickName("nickName", "MIL-WF1-WF4-TC1-Entering Nickname")
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done")
			.TapOnBack("MIL-WF1-WF4-TC1-Tapped Back")

			
			._atSetupInventoryPage()
			.verifySearchItemsOnSetupInv("MIL-WF1-WF4-TC1-Verify item selected")
			
		
			.verifyOGItemsOnSetupInv("MIL  - WF 1 WF 4-TC2-Verify item selected") 
			
			.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF1-WF4-TC1-Verify item selected")
			.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF1-WF4-TC1-Verify item selected")
			
			;
		}

	
	
	@Test(groups={"MIL - WF 2"},priority=0, description = "MIL - WF 2-TC2-Selecing a location, adding same items to multiple location")
	public void MIL_WF2_Location_AddItems__MultipleLocation_MA() {	

		LoginData loginData =LoginData.fetch("LoginData7");
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
		.verifyLoginPage("MIL-WF 2-TC2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF 2-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"MIL-WF 2-TC2-FirstAccountSelect")
		
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF 2-TC2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF 2-TC2-Tapped Skip1")
		.TapOrderGuide("MIL-WF 2-TC2-Tapped orderguide")
		.tapContinue("MIL-WF 2-TC2-Tapped continue")
		
		._atLocationsPage()
		.DefaultLocation("MIL-WF 2-TC2-Tapped Custom location")
		.tapContinue("MIL-WF 2-TC2-Tapped Continue")
		._atSetupInventoryPage()
		
		.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
		.TapTakeHome("MIL-WF 2-TC2-Tapped take me home")
		
 
	    ._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF 2-TC2-TrackinventoryTap")

		//creating a location1       
		._atLocationsPage()
		.TapAddLocation("MIL-WF 2-TC2-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL-WF 2-TC2-Enter location1 name")
		.AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
		.TapOnDone("MIL-WF 2-TC2-Tapped Done")
		.TapOnBack("MIL-WF 2-TC2-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL-WF 2-TC2-Verifing Added Location1")

		//nonsysco item addition to location1
		.SelectLocation(locationsData1.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
		.TapAddLocation("MIL-WF 2-TC2-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MIL-WF 2-TC2-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF 2-TC2-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL-WF 2-TC2-select supplier")

		._atVendorPage()
		.Add_Supplier("MIL-WF 2-TC2-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF 2-TC2-AddVendorDetails")
		.TapOnDone("MIL-WF 2-TC2-Done")
		.TapOnBack("MIL-WF 2-TC2-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF 2-TC2-SupplierSelect")

		//same nonsysco item addition to location2 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MIL-WF 2-TC2-Select Add/Select location option")
		.TapAddLocation("MIL-WF 2-TC2-Tapped ADD")
		.AddLocationName(locationsData2.LocationName,"MIL-WF 2-TC2-Enter location2 name")
		.AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
		.TapOnDone("MIL-WF 2-TC2-Tapped Done")
		.TapOnBack("MIL-WF 2-TC2-Tapped Back")
		.VerifyLocationList(locationsData2.LocationName, "MIL-WF 2-TC2-Verifing Added Location2")

		.SelectLocation(locationsData2.LocationName, "MIL-WF 2-TC2-Selecting Added Location2")
			.LocationDoneSelection("MIL-WF 2-TC2-Selecting Done")
		.TapOnDone("MIL-WF 2-TC2-Tapped Done")

		//location1 displayed with 1 non sysco item
		//prep item addition to location1

		.TapAddLocation("MIL-WF 2-TC2-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF 2-TC2-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF 2-TC2-NonSyscoItem details entered")

		//same prep item addition to location3 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MIL-WF 2-TC2-Select Add/Select location option")
		.TapAddLocation("MIL-WF 2-TC2-Tapped ADD")
		.AddLocationName(locationsData3.LocationName,"MIL-WF 2-TC2-Enter location3 name")
		.AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
		.TapOnDone("MIL-WF 2-TC2-Tapped Done")
		.TapOnBack("MIL-WF 2-TC2-Tapped Back")
		.VerifyLocationList(locationsData3.LocationName, "MIL-WF 2-TC2-Verifing Added Location3")

		.SelectLocation(locationsData3.LocationName, "MIL-WF 2-TC2-Selecting Added Location3")
		.LocationDoneSelection("MIL-WF 2-TC2-Selecting Done")
		.TapOnDone("MIL-WF 2-TC2-Tapped Done")
       // .TapOnDone("MIL-WF 2-TC2-Tapped Done")
		
        //location1 displayed with nonsysco and prep item
		//Verifications
		._atLocationsPage()
		.TapOnBack("MIL-WF 2-TC2-Tapped back")
		
		.SelectLocation(locationsData1.LocationName, "MIL-WF 2-TC2-Selecting Added Location2") 
		._atSetupInventoryPage()
		. verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF 2-TC2-Verify nonsysco item selected in Location2")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF 2-TC2-Verify prep item selected in Location3")
		
		._atLocationsPage()
		.TapOnBack("MIL-WF 2-TC2-Tapped Back")
		
		.SelectLocation(locationsData2.LocationName, "MIL-WF 2-TC2-Selecting Added Location3")
		._atSetupInventoryPage()
		. verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF 2-TC2-Verify nonsysco item selected in Location2")
		._atLocationsPage()
		.TapOnBack("MIL-WF 2-TC2-Tapped Back")
		
		
			._atLocationsPage()
		.SelectLocation(locationsData3.LocationName, "MIL-WF 2-TC2-Selecting Added Location3")
		._atSetupInventoryPage()
		
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF 2-TC2-Verify prep item selected in Location3")
		
		
		._atLocationsPage()
		.ProductSelect(prepItemData.ProductName, "MIL-WF 2-TC2-Selecting prep item")
		 .TapOnEdit("MIL - WF 10 NU Tap on edit")
		      .PdtDetailPage_Location1_EnterQty(uomQuantityData.Quantity,locationsData1.LocationName, "Enter Qty frst location")
		      .PdtDetailPage_Location2_EnterQty(uomQuantityData1.Quantity,locationsData3.LocationName, "Enter Qty second location")
		     .TapOnDone("MIL - WF 10 NU tap on done")
		     .TapOnBack("MIL - WF 10 NU tap on back")
		     .QuantityVerify(uomQuantityData1.Quantity, "MIL - WF 2 NU Quantity verify")
			
		._atLocationsPage()
		.TapOnBack("MIL-WF 2-TC2-Tapped Back")
		.SelectLocation(locationsData1.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
		.QuantityVerify(uomQuantityData.Quantity, "MIL - WF 2 NU Quantity verify")
		
		
	 		
		;
	}

		
	@Test(groups={"MIL - WF 3"},priority=0, description = "MIL - WF 3-TC2-Selecting a specific location in trackinventory and search for items within location for MA user")
	public void MIL_WF3_Location_SearchItems_MA() {	

		LoginData loginData =LoginData.fetch("LoginData8");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		SearchData searchData=SearchData.fetch("SearchData");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 3-TC2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 3-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 3-TC2 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 3-TC2-FirstAccountSelect")

		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 3-TC2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 3-TC2-Tapped Skip")
		.StartFromScratch("SI - WF 3-TC2-ScratchSelected")
		.tapContinue("SI - WF 3-TC2-Tapped Continue")
		.Scratch_AddItems("SI - WF 3-TC2-Tapped Add items")
		.AddItemFrom_OrderGuide("SI - WF 3-TC2-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("MIL-WF3-TC2-Selected item from OG")
		.TapOnDone("MIL-WF3-TC2-Tapped Done")
		.verifyOGItemsOnSetupInv("MIL-WF3-TC2-Verify item selected")
		.TapOnDone("MIL-WF3-TC2-Tapped Done")
		
		._atLocationsPage()
	.DefaultLocation("MIL-WF3-TC2-Tapped Custom location")
	.tapContinue("MIL-WF3-TC2-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF3-TC2-Tapped do this later")
		.TapTakeHome("MIL-WF3-TC2-Tapped Take me Home")
		
		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF3-TC2-TrackinventoryTap")


		._atLocationsPage()
		.TapAddLocation("MIL-WF3-TC2-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL-WF 3-TC2-Enter location name")
		.AddLocationCooler("MIL-WF3-TC2-Tapped Cooler")
		.TapOnDone("MIL-WF3-TC2-Tapped Done")
		.TapOnBack("MIL-WF3-TC2-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF3-TC2-Verifing AddedLocation")
		.SelectLocation(locationsData.LocationName, "MIL-WF3-TC2-Selecting location")

		//og item addition
		._atLocationsPage()
		.TapAddLocation("MIL-WF3-TC2-Tapped ADD")

		.AddItemFrom_OrderGuide("MIL-WF3-TC2-Tapped Orderguide")
		._atSetupInventoryPage()
		.SelectMultipleItemsFrom_OrderGuide("MIL-WF3-TC2-Selected multiple items from OG")
		.TapOnDone("MIL-WF3-TC2-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF3-TC2-Verify items selected")  
		.TapOnDone("MIL-WF3-TC2-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF3-TC2-Verify item selected")  
		.SearchKeyword("MIL-WF3-TC2-Keyword searching")
		
			.TapOnDone("MIL-WF3-TC2-Done tap")
		.verifyKeywordSearchItems("MIL-WF3-TC2-Verify Keyword search")

		/*//search
		._atSetupInventoryPage()
		.SearchItem(searchData.keyword, "MIL-WF3-TC2-Searched")
		.SelectMultipleItemsFrom_OrderGuide("MIL-WF3-TC2-Selected multiple items from OG")
		.TapOnDone("MIL-WF3-TC2-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF3-TC2-Verify items selected")
		.TapOnDone("MIL-WF3-TC2-Tapped Done")
		
		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "MIL-WF3-TC2-Selecting location")
		._atSetupInventoryPage()
		.SearchKeyword("MIL-WF3-TC2-Keyword searching")
		//.TapOnDone("MIL-WF3-TC2-Done tap")
		.verifyKeywordSearchItems("MIL-WF3-TC2-Verify Keyword search")
*/;
	}




	//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
	@Test(groups={"MIL - WF 5"},priority=0, description = "MIL - WF 5-TC2-Selecting a location navigate to product and assiging  item  to diff location")
	public void MIL_WF5_Locations_ItemEdit_UpdateLocation_MA() {	

		LoginData loginData =LoginData.fetch("LoginData9");
		SearchData searchData=SearchData.fetch("SearchData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL- WF 5-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL- WF 5-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"MIL- WF 5-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL- WF 5-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
		.StartFromScratch("MIL-WF6-TC2-ScratchSelected")
		.tapContinue("MIL-WF6-TC2-Tapped Continue")
		.Scratch_AddItems("MIL-WF6-TC2-Tapped Add items")
		.AddItemFrom_OrderGuide("MIL-WF6-TC2-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("MIL-WF6-TC2-Selected item from OG")
		.TapOnDone("MNS-1-TC1-Tapped Done1")
		.verifyOGItemsOnSetupInv("MPI-1-TC1-Verify item selected")
		.TapOnDone("MPI-1-TC1-Tapped Done2")
		
		._atLocationsPage()
		.DefaultLocation("SI - WF 1-TC1-Tapped Custom location")
		.tapContinue("SI - WF 1-TC1-Tapped Continue")
		._atSetupInventoryPage()
		
		.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
		.TapTakeHome("SI - WF 32-TC1-Tapped take me home")


		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL- WF 5-TC2-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MIL- WF 5-TC2-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL- WF 5-TC2-Enter location name")
		.AddLocationCooler("MIL- WF 5-TC2-Tapped Cooler")
		.TapOnDone("MIL- WF 5-TC2-Tapped Done")
		.TapOnBack("MIL- WF 5-TC2-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL- WF 5-TC2-Verifing AddedLocation")
		//prepitem addition 
		.SelectLocation(locationsData.LocationName, "MIL- WF 5-TC2-Selecting AddedLocation")
		.TapAddLocation("MIL- WF 5-TC2-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MIL- WF 5-TC2-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL- WF 5-TC2-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL- WF 5-TC2-select supplier")

		._atVendorPage()
		.Add_Supplier("MIL- WF 5-TC2-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL- WF 5-TC2-AddVendorDetails")
		.TapOnDone("MIL- WF 5-TC2-Done")

		.TapOnBack("MIL- WF 5-TC2-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL- WF 5-TC2-SupplierSelect")
		.TapOnDone("MIL- WF 5-TC2-Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 5-TC2-Verify item selected")

		._atLocationsPage()
		.ProductSelect(nonSyscoItemData.ProductName, "MIL- WF 5-TC2-Select Product")
		.TapOnEdit("MIL- WF 5-TC2-Tapped Edit")
		.AddLocation_AddProductDetailsPage("MIL- WF 5-TC2-Select Add/Select option")
		.TapAddLocation("MIL- WF 5-TC2-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL- WF 5-TC2-Enter location name")
		.AddLocationCooler("MIL- WF 5-TC2-Tapped Cooler")
		.TapOnDone("MIL- WF 5-TC2-Tapped Done")
		.TapOnBack("MIL- WF 5-TC2-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL- WF 5-TC2-Verifing AddedLocation")

		.SelectLocation(locationsData1.LocationName, "MIL- WF 5-TC2-Selecting AddedLocation")
		.SelectLocation(locationsData.LocationName, "MIL- WF 5-TC2-Selecting AddedLocation")
		.LocationDoneSelection("MIL- WF 5-TC2-Selecting Done")
		.TapOnDone("MIL- WF 5-TC2-Tapped Done")

		.TapOnBack("MIL- WF 5-TC2-Tapped Back")
		.TapOnBack("MIL- WF 5-TC2-Tapped Back")

		.SelectLocation(locationsData.LocationName, "MIL- WF 5-TC2-Selecting AddedLocation")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 5-TC2-Verify item selected")

		._atLocationsPage() 
		.TapOnBack("MIL- WF 5-TC2-Tapped Back")
		.SelectLocation(locationsData1.LocationName, "MIL- WF 5-TC2-Selecting AddedLocation")
		
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 5-TC2-Verify item selected")

		;
	}





	//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
				@Test(groups={"MIL - WF 6"},priority=0, description = "MIL - WF 6-TC2-Creating Location,Editing Location in Manage Locations and assiging  item  to diff location")
				public void MIL_WF6_Create_Edit_Delete_Locations_MA() {	

					LoginData loginData =LoginData.fetch("LoginData5");
					LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
					LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
					NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
					PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
					VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
					Start.asTester
					.goToLoginpage()
					.verifyLoginPage("MIL - WF 6-TC1-LoginPage")
					.signIn(loginData.UserName, loginData.Password,"MIL - WF 6-TC1-Login")

					._atHomePage()
					.ClickAccount(loginData.UserName,"Clicked account")

					._atAccountsPage()
					.Second_AccountSelection(loginData.UserName,"MIL - WF 6-TC1-FirstAccountSelect")

					
					//setting up inventory    
							._atInventoryToolPage()
							.InvTools_SetUpInventory("MIL - WF 6-TC1-SetupInventoryTap")

							._atSetupInventoryPage()
							.TapOnSkip("MIL - WF 6-TC1-Skip1 Tapped")
							.TapOrderGuide("MIL - WF 6-TC1-OG Selected")
							.tapContinue("MIL - WF 6-TC1-Tapped Continue")
							
							._atLocationsPage()
							.DefaultLocation("MIL - WF 6-TC1-Tapped Custom location")
							.tapContinue("MIL - WF 6-TC1-Tapped Continue")

							._atSetupInventoryPage()
							.TapOnDOThisLater("MIL - WF 6-TC1-Tapped do this later")
							.TapTakeHome("MIL - WF 6-TC1-Tapped Take me Home")
					
					._atInventoryToolPage()
					.InvTools_Locations("MIL - WF 6-TC1-TrackinventoryTap")

					._atLocationsPage()
					.TapAddLocation("MIL- WF 6-TC1-Tapped ADD")
					.AddLocationName(locationsData1.LocationName,"MIL- WF 6-TC1-Enter location name")
					.AddLocationFreezer("MIL- WF 6-TC1-Tapped Cooler")
					.TapOnDone("MIL- WF 6-TC1-Tapped Done")
					.TapOnBack("MIL- WF 6-TC1-Tapped Back")
					.VerifyLocationList(locationsData1.LocationName, "MIL- WF 6-TC1-Verifing AddedLocation")

					.TapAddLocation("MIL- WF 6-TC1-Tapped ADD")
					.AddLocationName(locationsData2.LocationName,"MIL- WF 6-TC1-Enter location name")
					.AddLocationCooler("MIL- WF 6-TC1-Tapped Cooler")
					.TapOnDone("MIL- WF 6-TC1-Tapped Done")
					.TapOnBack("MIL- WF 6-TC1-Tapped Back")
					.VerifyLocationList(locationsData2.LocationName, "MIL- WF 6-TC1-Verifing AddedLocation")

					._atLocationsPage()
					.SelectLocation(locationsData2.LocationName, "MIL- WF 6-TC2-Selecting AddedLocation")
					.TapOnEdit("MIL- WF 6-TC2-Editing AddedLocation")
					.AddLocationFreezer("MIL- WF 6-TC2-Tapped Cooler")
					.AddLocationName(locationsData2.EditLocation,"MIL- WF 6-TC2-Enter location name")
					
					.TapOnDone("MIL- WF 6-TC2-Tapped Done")
					.TapOnBack("MIL- WF 6-TC2-Tapped Back")
					.VerifyLocationList(locationsData2.EditLocation, "MIL- WF 6-TC2-Verifing AddedLocation")

					.SelectLocation(locationsData2.EditLocation, "MIL- WF 6-TC2-Selecting AddedLocation")
					.TapOnDeleteLocation("MIL- WF 6-TC2-Tapped Delete")
					.TapOnYesDelete("MIL- WF 6-TC2-Deleting AddedLocation")
					//  .TapOnBack("MIL- WF 6-TC2-Tapped Back")
					.VerifyCancelledLocationList(locationsData2.EditLocation, "MIL- WF 6-TC1-Verifing AddedLocation")



					;
				}

	
	@Test(groups={"MIL - WF 7"},priority=4, description = "MIL - WF 7-TC1-Track Inventory+Location+Edit+Delete Items from location")
	public void MIL_WF7_TrackInventory_Location_Edit_Delete_Items_location_MA() {

			LoginData loginData =LoginData.fetch("LoginData6"); 
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF7-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF7-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF7-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"MIL-WF7-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF7-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF7-TC1-Skip1 Tapped")
		.TapOrderGuide("MIL-WF7-TC1-OG Selected")
		.tapContinue("MIL-WF7-TC1-Tapped Continue1")
		
		._atLocationsPage()
		.CustomLocation("MIL-WF7-TC1-Tapped Custom location")
		.tapContinue("MIL-WF7-TC1-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"MIL-WF7-TC1-Enter location name1")
		.AddLocations1_TypeDry("MIL-WF7-TC1-Tapped Dry1")

		.AddLocations2("MIL-WF7-TC1-Add location2")
		.AddLocations2_name(locationsData2.LocationName,"MIL-WF7-TC1-Enter location name2")
		.AddLocations2_TypeDry("MIL-WF7-TC1-Tapped Dry2")
		.TapOnNext("MIL-WF7-TC1-Tapped Next1")

		.selectMultipleItemsFromLocation1("MIL-WF7-TC1-Selected Multiple items")
		.TapOnNext("MIL-WF7-TC1-Tapped Next2")

		.selectMultipleItemsFromLocation2("MIL-WF7-TC1-Selected Multiple items")
		.TapOnDone("MIL-WF7-TC1-Tapped Done1")

		._atCategoryPage()
		.defaultCategories("MIL-WF7-TC1-Tapped Default category")
		.tapComplete("MIL-WF7-TC1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("MIL-WF7-TC1-Tapped Take me Home")  

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF7-TC1-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "MIL-WF7-TC1-selected location1")
		.ItemVerifyOnLocation1("MIL-WF7-TC1-Verify items inside location1")
		.TapOnEdit("MIL-WF7-TC1-Tapped Edit")
		.DeleteItems("MIL-WF7-TC1-Deleting items in location")
		.TapOnDone("MIL-WF7-TC1-Tapped Done2")
		.TapOnYesDelete("MIL-WF7-TC1-confirming Deleting items")
		.VerifyDeleteItemsList("MIL-WF7-TC1-Verifying Deleted items list")
		;
	}	


	
	@Test(groups={"MIL - WF 10"},priority=0, description = "MIL - WF 10 NU Track Inventory+Location+item product card + update qty & UOM")
	public void MIL_WF10_TrackInventory_Location_item_productcard_updateqtyUOM() {	
		
		LoginData loginData =LoginData.fetch("LoginData7");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocationsData");
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		UOMQuantityData uomQuantityData = UOMQuantityData.fetch("UOMQuantityData");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL - WF 10 NU-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL - WF 10 NU-TC1-Login")


		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")


		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"MIL-WF 2-TC2-FirstAccountSelect")



		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - MIL - WF 10 NU-SetupInventoryTap")


		._atSetupInventoryPage()
		.TapOnSkip("MIL - WF 10 NU-Skip1 Tapped")
		.TapOrderGuide("MIL - WF 10 NU Selected")
		.tapContinue("MIL - WF 10 NU-Tapped Continue")
		._atLocationsPage()
		.DefaultLocation("MIL-WF 2-TC2-Tapped Custom location")
		.tapContinue("MIL-WF 2-TC2-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
		.TapTakeHome("MIL-WF 2-TC2-Tapped take me home")

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
		     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL - WF 1,3-TC2-NonSyscoItem details entered")
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





	
	//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
	@Test(groups={"MEC - WF 1"},priority=0, description = "MEC - WF 1-TC2-Selecting a location navigate to product and assiging  item  to category created")
	public void MEC_WF1_Locations_ItemEdit_UpdateCategory_MA() {	

		LoginData loginData =LoginData.fetch("LoginData8");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		CategoryData categoryData =CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SMEC - WF 1-TC2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MEC-WF 1-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		 ._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 19-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL - WF 10 NU-Skip1 Tapped")
		.TapOrderGuide("MIL - WF 10 NU Selected")
		.tapContinue("MIL - WF 10 NU-Tapped Continue")
		._atLocationsPage()
		.DefaultLocation("MIL-WF 2-TC2-Tapped Custom location")
		.tapContinue("MIL-WF 2-TC2-Tapped Continue")
		._atSetupInventoryPage()

		.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
		.TapTakeHome("MIL-WF 2-TC2-Tapped take me home")

		
		._atInventoryToolPage()
		.InvTools_TrackInventory("MEC-WF 1-TC2-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MEC-WF 1-TC2-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MEC-WF 1-TC2-Enter location name")
		.AddLocationCooler("MEC-WF 1-TC2-Tapped Cooler")
		.TapOnDone("MEC-WF 1-TC2-Tapped Done")
		.TapOnBack("MEC-WF 1-TC2-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MEC-WF 1-TC2-Verifing AddedLocation")
		//nonsysco item addition 
		.SelectLocation(locationsData1.LocationName, "MEC-WF 1-TC2-Selecting AddedLocation")
		.TapAddLocation("MEC-WF 1-TC2-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MEC-WF 1-TC2-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MEC-WF 1-TC2-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MEC-WF 1-TC2-select supplier")
		._atVendorPage()
		.Add_Supplier("MEC-WF 1-TC2-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MEC-WF 1-TC2-AddVendorDetails")
		.TapOnDone("MEC-WF 1-TC2-Tapped Done")
		.TapOnBack("MEC-WF 1-TC2-Tapped Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MEC-WF 1-TC2-SupplierSelect")
		.TapOnDone("MEC-WF 1-TC2-Tapped Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MEC-WF 1-TC2-Verify item selected")

		._atLocationsPage()
		.ProductSelect(nonSyscoItemData.ProductName, "MEC-WF 1-TC2-Select Product")
		.TapOnEdit("MEC-WF 1-TC2-Tapped Edit")

		._atLocationsPage()
		.AddCategory_AddProductDetailsPage("MEC-WF 1-TC2-CategorySelect")
		.TapAddLocation("MEC-WF 1-TC2-Tapped Add")
		._atCategoryPage()
		.AddCategoryName(categoryData.Name, "MEC-WF 1-TC2-Enter Category Name")
		.AddCategoryFood("MEC-WF 1-TC2-Enter type food")
		.TapOnDone("MEC-WF 1-TC2-Tapped Done")
		.TapOnBack("MEC-WF 1-TC2-Tapped Back")
		.SelectCategory(categoryData.Name, "MEC-WF 1-TC2-Select Category Name")
		.TapOnDone("MEC-WF 1-TC2-Tapped Done") 
		.TapOnBack("MEC-WF 1-TC2-Tapped Back")
		.TapOnBack("MEC-WF 1-TC2-Tapped Back")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "MEC-WF 1-TC2-Selecting AddedLocation")
		._atCategoryPage()
		.VerifyCategory(categoryData.Name, "MEC-WF 1-TC2-Verified Category")

		;
	}



	
	//Precond:setupinventory should be done so that trackinv is enabled
	@Test(groups={"MEC - WF 2"},priority=0, description = "MEC - WF 2-TC1-Creating, editing and deleting category as a MA user")
	public void MEC_WF2_Category_Create_Edit_Delete_Category_MA() {	

		LoginData loginData =LoginData.fetch("LoginData6");
		CategoryData categoryData =CategoryData.fetch("CategoryData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF 2-TC2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MEC-WF 2-TC1-Login")


		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

 
		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("TI-WF1-WF2-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("TI-WF1-WF2-TC1-Skip1 Tapped")
		.TapOrderGuide("TI-WF1-WF2-TC1-OG Selected")
		.tapContinue("TI-WF1-WF2-TC1-Tapped Continue")
		
		._atLocationsPage()
		.DefaultLocation("TI-WF1-WF2-TC1-Tapped Custom location")
		.tapContinue("TI-WF1-WF2-TC1-Tapped Continue")
	._atSetupInventoryPage()
		.TapOnDOThisLater("TI-WF1-WF2-TC1-Tapped do this later")
		.TapTakeHome("TI-WF1-WF2-TC1-Tapped Take me Home")

		
		._atInventoryToolPage()
		.InvTools_Category("MEC-WF 2-TC1-Expense Category Tap")

		._atCategoryPage()
		.TapAdd("MEC-WF 2-TC1-Add Expense Category Tap")
		.AddCategoryName(categoryData.Name, "MEC-WF 2-TC1-Enter Category Name")
		.AddCategoryFood("MEC-WF 2-TC1-Enter type food")
		.TapOnDone("MEC-WF 2-TC1-Tapped Done")
		.TapOnBack("MEC-WF 2-TC1-Tapped Back")
		.VerifyCategoryList(categoryData.Name, "MEC-WF 2-TC1-Verifying added category list")
		
		.SelectCategory(categoryData.Name, "MEC-WF 2-TC1-Selecting Category")
		.TapOnEdit("MEC-WF 2-TC1-Tap on Edit")
		.AddCategoryFood("MEC-WF 2-TC1-Enter type food")
		.AddCategoryName(categoryData.Name1, "MEC-WF 2-TC1-Entering new name")
		.TapOnDone("MEC-WF 2-TC1-Tapped Done")
		.TapOnBack("MEC-WF 2-TC1-Tapped Back")
		.VerifyCategoryList(categoryData.Name1, "MEC-WF 2-TC1-Verifying edited category list")
		
		.SelectCategory(categoryData.Name1, "MEC-WF 2-TC1-Selecting Category")
		.TapOnDeleteCategory("MEC-WF 2-TC1-Deleting Category")
		.TapOnYesDelete("MEC-WF 2-TC1-Tap on Yes Delete")
		.VerifyDeletedCategoryList(categoryData.Name1, "MEC-WF 2-TC1-Verifying Deleted category list")
		;
	}		

	
	@Test(groups={"MNS-1"},priority=0, description = "MNS-1-TC1-Manage_Create Non-Sysco Item_Link Supplier_Location_Expense Category")
	public void MNS_1_CreateNonSyscoItem_LinkSupplier_Location_Category_NU() {	

		LoginData loginData =LoginData.fetch("LoginData7");	  
		SearchData searchData=SearchData.fetch("SearchData");

		LocationsData locationsData =LocationsData.fetch("LocationsData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData1");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MNS-1-TC1-LoginPage")
		.saveUsernameCheckBoxClick("MNS-1-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"MNS-1-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MNS-1-TC1-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"MNS-1-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MNS-1-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MNS-1-TC1-Tapped Skip1")
		.StartFromScratch("MNS-1-TC1-ScratchSelected")
		.tapContinue("MNS-1-TC1-Tapped Continue1")
		.Scratch_AddItems("MNS-1-TC1-Tapped Add items")
		.AddItemFrom_OrderGuide("MNS-1-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("MNS-1-TC1-Selected item from OG")
		.TapOnDone("MNS-1-TC1-Tapped Done1")
		.verifyOGItemsOnSetupInv("MNS-1-TC1-Verify item selected")
		.TapOnDone("MNS-1-TC1-Tapped Done2")
		._atLocationsPage()
		.DefaultLocation("SI - WF 1-TC1-Tapped Custom location")
		.tapContinue("SI - WF 1-TC1-Tapped Continue")
		._atSetupInventoryPage()
		
	.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
.TapTakeHome("SI - WF 32-TC1-Tapped take me home")  

		._atInventoryToolPage()
		.InvTools_CreateNonSysco("MNS-1-TC1-Tapped Nonsysco item")

		._atSetupInventoryPage()
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MNS-1-TC1-NonSyscoItem details entered")

		//linking supplier
		.AddSupplier_AddProductDetailsPage("MNS-1-TC1-Select supplier")
		._atVendorPage()
		.Add_Supplier("MNS-1-TC1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MNS-1-TC1-AddVendorDetails")
		.TapOnDone("MNS-1-TC1-Supplier added")
		.TapOnBack("MNS-1-TC1-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"MNS-1-TC1-SupplierSelect")
		
		//linking location
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MNS-1-TC1-Select Add/Select location option")
		.TapAddLocation("MNS-1-TC1-Tapped ADD Location")
		.AddLocationName(locationsData.LocationName,"MNS-1-TC1-Enter location name")
		.AddLocationCooler("MNS-1-TC1-Tapped Cooler")
		.TapOnDone("MNS-1-TC1-Tapped Done4")
		.TapOnBack("MNS-1-TC1-Tapped Back2")
		.VerifyLocationList(locationsData.LocationName, "MNS-1-TC1-Verifing Added Location")
		.SelectLocation(locationsData.LocationName, "MNS-1-TC1-Selecting Added Location")
		.LocationDoneSelection("MNS-1-TC1-Selecting Done")

		//linking category
		._atLocationsPage()
		.AddCategory_AddProductDetailsPage("MNS-1-TC1-Tapped CategorySelect")
		._atCategoryPage()
		.TapAdd("MNS-1-TC1-Tapped Add category")
		.AddCategoryName(categoryData.Name, "MNS-1-TC1-Enter Category Name")
		.AddCategoryFood("MNS-1-TC1-Enter type food")
		.TapOnDone("MNS-1-TC1-Tapped Done5")
		.TapOnBack("MNS-1-TC1-Tapped Back3")
		.SelectCategory(categoryData.Name, "MNS-1-TC1-Select Category Name")

		.TapOnDone("MNS-1-TC1-Tapped Done,Nonsyscoitem added")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("MNS-1-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "MNS-1-TC1-Select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MNS-1-TC1-Verify nonsysco item added")
		._atLocationsPage()
		.NonSyscoPrepCategoryIdentify(nonSyscoItemData.ProductName,prepItemData.ProductName,"MNS-1-TC1-Category idenitification for nonsysco")
		._atCategoryPage()
		.VerifyNonSycoCustomCategory(categoryData.Name, "MNS-1-TC1-Category verification")
		;
	}




	@Test(groups={"MPI-1"},priority=0, description = "MPI-1-TC1-Manage_Create Prep Item_LinkLocation_Expense Category")
	public void MPI_1_CreatePrepItem_LinkLocation_Category_NU() {	

		LoginData loginData =LoginData.fetch("LoginData5");	  
		SearchData searchData=SearchData.fetch("SearchData");

			LocationsData locationsData =LocationsData.fetch("LocationsData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MPI-1-TC1-LoginPage")
		.saveUsernameCheckBoxClick("MPI-1-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"MPI-1-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MPI-1-TC1-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"MPI-1-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("MPI-1-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MPI-1-TC1-Tapped Skip1")
		.StartFromScratch("MPI-1-TC1-ScratchSelected")
		.tapContinue("MPI-1-TC1-Tapped Continue1")
		.Scratch_AddItems("MPI-1-TC1-Tapped Add items")
		.SearchItem(searchData.keyword,"MIL - WF 1,3-TC2-Search item")
		.SelectItemFrom_Catalog("MIL - WF 1,3-TC2-Selected item from OG")
		.TapOnDone("MNS-1-TC1-Tapped Done1")
		.verifySearchItemsOnSetupInv("MPI-1-TC1-Verify item selected")
		.TapOnDone("MPI-1-TC1-Tapped Done1")
		
	
		._atLocationsPage()
		.DefaultLocation("SI - WF 1-TC1-Tapped Custom location")
		.tapContinue("SI - WF 1-TC1-Tapped Continue")
		._atSetupInventoryPage()
		
		.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
		.TapTakeHome("SI - WF 32-TC1-Tapped take me home")

		._atInventoryToolPage()
		.InvTools_CreatePrep("MPI-1-TC1-Tapped Prep item")

		._atSetupInventoryPage()
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MPI-1-TC1-PrepItem details entered")



		//linking location
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MPI-1-TC1-Select Add/Select location option")
		.TapAddLocation("MPI-1-TC1-Tapped ADD Location")
		.AddLocationName(locationsData.LocationName,"MPI-1-TC1-Enter location name")
		.AddLocationCooler("MPI-1-TC1-Tapped Cooler")
		.TapOnDone("MPI-1-TC1-Tapped Done3")
		.TapOnBack("MPI-1-TC1-Tapped Back1")
		.VerifyLocationList(locationsData.LocationName, "MPI-1-TC1-Verifing Added Location")
		.SelectLocation(locationsData.LocationName, "MPI-1-TC1-Selecting Added Location")
		.LocationDoneSelection("MPI-1-TC1-Selecting Done")

		//linking category
		._atLocationsPage()
		.AddCategory_AddProductDetailsPage("MPI-1-TC1-Tapped CategorySelect")
		._atCategoryPage()
		.TapAdd("MPI-1-TC1-Tapped Add category")
		.AddCategoryName(categoryData.Name, "MPI-1-TC1-Enter Category Name")
		.AddCategoryFood("MPI-1-TC1-Enter type food")
		.TapOnDone("MPI-1-TC1-Tapped Done4")
		.TapOnBack("MPI-1-TC1-Tapped Back2")
		.SelectCategory(categoryData.Name, "MPI-1-TC1-Select Category Name")

		.TapOnDone("MPI-1-TC1-Tapped Done,Prepitem added") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("MPI-1-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "MPI-1-TC1-Select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MPI-1-TC1-Verify Prep item added")
		._atLocationsPage()
		.NonSyscoPrepCategoryIdentify(nonSyscoItemData.ProductName,prepItemData.ProductName,"MPI-1-TC1-Category idenitification for Prepitem")
		._atCategoryPage()
		.VerifyPrepCustomCategory(categoryData.Name, "MPI-1-TC1-Category verification")
		;
	}




	@Test(groups={"MSP-1 MSP-2"},priority=0, description = "MSP-1 MSP-2 Home Screen-->Suppliers-->Add new Suppliers/View/Maintain Suppliers")
	public void MSP1_MSP2_Add_View_ManageSuppliers()
	{
		LoginData loginData =LoginData.fetch("LoginData9");
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
	    .Second_AccountSelection(loginData.UserName,"MSP-1,MSP-2-FirstAccountSelect")
	   
	    ._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 1-TC1-SetupInventoryTap")
._atSetupInventoryPage()
		.TapOnSkip("SI - WF 1-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 1-TC1-OG Selected")
		.tapContinue("SI - WF 1-TC1-Tapped Continue")
	._atLocationsPage()
		.DefaultLocation("SI - WF 1-TC1-Tapped Custom location")
		.tapContinue("SI - WF 1-TC1-Tapped Continue")
		._atSetupInventoryPage()
		
	.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
.TapTakeHome("SI - WF 32-TC1-Tapped take me home")  
			
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


