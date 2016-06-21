
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

	@Test(groups={"SI-WF1"},priority=1, description = "SI - WF 1-OG + Dafault Loc + Default Category")
	public void SI_WF1_OG_DefaultLocation_DefaultCategory() {
		
		
		LoginData loginData =LoginData.fetch("LoginData5");	  
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF1-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF1-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF1-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI-WF1-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF1-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF1-TC1-Skip1 Tapped")
		.TapOrderGuide("SI-WF1-TC1-OG Selected")
		.tapContinue("SI-WF1-TC1-Tapped Continue")
	
		._atLocationsPage()
		.DefaultLocation("SI-WF1-TC1-Tapped Custom location")
		.tapContinue("SI-WF1-TC1-Tapped Continue")

		._atCategoryPage()
		.VerifyOptionsOnSetUpFoodCost("SI - WF 1-TC1-Category page verified")
		.defaultCategories("SI-WF1-TC1-Tapped Default category")
		.tapComplete("SI-WF1-TC1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF1-TC1-Tapped take me home")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF1-TC1-Selected track inventory")
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
	
	@Test(groups={"SI-WF3"},priority=1, description = "SI - WF 3-TC1-OG + Cus Loc + Cust Category for MA user")
	public void SI_WF3_OG_CustomMultipleLocation_CustomMultipleCategory() {	

		LoginData loginData =LoginData.fetch("LoginData6");
		
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF3-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF3-TC1-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF3-TC1-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI-WF3-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF3-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF3-TC1-Skip1 Tapped")
		.TapOrderGuide("SI-WF3-TC1-OG Selected")
		.tapContinue("SI-WF3-TC1-Tapped Continue1")
	

		._atLocationsPage()
		.CustomLocation("SI-WF3-TC1-Tapped Custom location")
		.tapContinue("SI-WF3-TC1-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI-WF3-TC1-Enter location name")
		.AddLocations1_TypeDry("SI-WF3-TC1-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("SI-WF3-TC1-Tapped Dry2")
		.TapOnNext("SI-WF3-TC1-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI-WF3-TC1-Selected Multiple items")
		.TapOnNext("SI-WF3-TC1-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI-WF3-TC1-Selected Multiple items")
		.TapOnDone("SI-WF3-TC1-Tapped Done1")
	
		._atCategoryPage()
		.CustomCategories("SI-WF3-TC1-CustomCategories Tapped")
		.tapContinue("SI-WF3-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF3-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF3-TC1-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF3-TC1-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF3-TC1-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI-WF3-TC1-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF3-TC1-Tapped Done2")
		.TapTakeHome("SI-WF3-TC1-Tapped Continue4") 


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF3-TC1-Selected track inventory")

		   ._atLocationsPage()
		  .SelectLocation(locationsData1.LocationName, "SI-WF3-TC1-LocationTap1")
		 .ItemVerifyOnLocation1("SI-WF3-TC1-Verify item inside location1")
		  .TapOnBack("SI-WF3-TC1-Tap on Back1")
		  .SelectLocation(locationsData2.LocationName, "SI-WF3-TC1-LocationTap2")
		 .ItemVerifyOnLocation2("SI-WF3-TC1-Verify item inside location2")
		;




	}

	@Test(groups={"SI-WF4"},priority=2, description = "SI - WF 4-TC1-OG + Default Loc + Custom Category for MA user")
	public void SI_WF4_OG_DefaultLocation_CustomCategory() {
		
		LoginData loginData =LoginData.fetch("LoginData6");
		
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		LocationsData locDataNoLoc=LocationsData.fetch("LocatiosData4");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF4-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF4-TC1-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF4-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF4-TC1-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI-WF4-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF4-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF4-TC1-Skip1 Tapped")
		.TapOrderGuide("SI-WF4-TC1-OG Selected")
		.tapContinue("SI-WF4-TC1-Tapped Continue")
		
		._atLocationsPage()
		.DefaultLocation("SI-WF4-TC1-Tapped Custom location")
		.tapContinue("SI-WF4-TC1-Tapped Continue")
		
		._atCategoryPage()
		.CustomCategories("SI-WF4-TC1-CustomCategories Tapped")
		.tapContinue("SI-WF4-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF4-TC1-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF4-TC1-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF4-TC1-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF4-TC1-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI-WF4-TC1-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF4-TC1-Tapped Done2")
		.TapTakeHome("SI-WF4-TC1-Tapped TakeHome") 

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF4-TC1-Selected track inventory")
		._atLocationsPage()
		.VerifyOrderOfLocations(locDataCooler.LocationName, locDataFreezer.LocationName, locDataDry.LocationName, locDataNoLoc.LocationName, "SI - WF 4-TC1-Verified order of locations")
		;
	}
	
	@Test(groups={"SI-WF5"},priority=3, description = "SI - WF 8-TC1-OG + Custom Loc + Default Category for Normal user")
	public void SI_WF5_OG_CustomLocation_DefaultCategory() {
		
		LoginData loginData =LoginData.fetch("LoginData7");
	
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 5-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 5-TC1-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")
		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 3-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 5-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 5-TC1-OG Selected")
		.tapContinue("SI - WF 5-TC1-Tapped Continue1")

		._atLocationsPage()
		.CustomLocation("SI - WF 5-TC1-Tapped Custom location")
		.tapContinue("SI - WF 5-TC1-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI - WF 5-TC1-Enter location name")
		.AddLocations1_TypeDry("SI - WF 5-TC1-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
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


	@Test(groups={"SI-WF6"},priority=2, description = "SI - WF 6-TC1-OG + Skip Loc + Skip Cust for Normal user")
	public void SI_WF6_OG_SkipLocation_SkipCategory() {	

	
		LoginData loginData =LoginData.fetch("LoginData7");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 6-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 3-TC1-LoginPage")


		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")
		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 6-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 6-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 6-TC1-OG Selected")
		.tapContinue("SI - WF 6-TC1-Tapped Continue1")
		
		.TapOnDOThisLater("SI - WF 6-TC1-Do this Later for locations Tapped")
		.TapOnSkip("SI - WF 6-TC1-Skip3 Tapped")
		.TapOnDOThisLater("Do this Later for category Tapped")
		.TapTakeHome("SI - WF 6-TC1-Cotinue2 Tapped") 
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 6-TC1-Selected track inventory")

		;
	}


	@Test(groups={"SI-WF7"},priority=4, description = "SI - WF 7-TC2-OG+Default loc + Skip Category")
	public void SI_WF7_OG_DefaultLocation_SkipCategory() {
		LoginData loginData =LoginData.fetch("LoginData8");	  

	
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 7-TC2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 7-TC1-Login")
		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

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


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 7-TC2-Selected track inventory")
		._atLocationsPage()
		.TapOnBack("SI - WF 7-TC2-tapped on back")
		
		._atHomePage()
		.HamburgerMenu("SI - WF 7-TC2-tapped hamburger")
		.HamMenu_Logout("SI - WF 7-TC2-tapped logout")
		
		._atLoginPage()
		.signIn(loginData.UserName, loginData.Password,"SI - WF 7-TC1-Login")
		
		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 7-TC2-Selected track inventory")

		
		;

	}
	@Test(groups={"SI-WF8"},priority=0, description = "SI - WF 8-TC1-OG + Skip Loc + Default Category for Normal user")
	public void SI_WF8_OG_SkipLocation_DefaultCategory() {
		
		LoginData loginData =LoginData.fetch("LoginData8");	 

	
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF8-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 8-TC1-LoginPage")


		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 8-TC1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 8-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 8-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 8-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 8-TC1-OG Selected")
		.tapContinue("SI - WF 8-TC1-Tapped Continue1")
		
		.TapOnDOThisLater("SI-WF8-TC1-Do this Later for locations Tapped")
		.TapOnSkip("SI - WF 8-TC1-Skip3 Tapped") 

		._atCategoryPage()
		.defaultCategories("SI - WF 8-TC1-Tapped Default category")
		.tapComplete("SI - WF 8-TC1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 8-TC1-Tapped TakeHome")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 8-TC1-Selected track inventory")

	
		;
	}		



	@Test(groups={"SI-WF9"},priority=0, description = "SI - WF 9-TC2-Start From Scratch + add items from Product catelog +Default Loc + Default Category for MA user")
	public void SI_WF9_StartFromScratch_PdtCatalog_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData2");
		
		SearchData searchData=SearchData.fetch("SearchData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 9-TC2-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 9-TC2-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 9-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

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

		._atCategoryPage()
		.defaultCategories("SI - WF 9-TC2-Tapped Custom category")
		.tapComplete("SI - WF 9-TC2-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 9-TC2-Tapped Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 9-TC2-Selected track inventory")


	
		;
	}



	@Test(groups={"SI-WF10"},priority=0, description = "SI - WF 10-TC1-Start From Scratch + add items from Order Guide +Default Loc + Default Category for MA user")
	public void SI_WF10_StartFromScratch_OG_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");
	
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 10-TC1-LoginPage")
		.saveUsernameCheckBoxClick("SI - WF 10-TC1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 10-TC1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")


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

		._atCategoryPage()
		.defaultCategories("SI - WF 10-TC1-Tapped Custom category")
		.tapComplete("SI - WF 10-TC1-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 10-TC1-Tapped Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 10-TC1-Selected track inventory")

	
		;
	}

	@Test(groups={"SI-WF11"},priority=0, description = "SI - WF 11-TC1-Start From Scratch + add items Non-sysco & Prep+Default Loc + Default Category for MA user")
	public void SI_WF11_StartFromScratch_NonSysco_Prep_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData2");
		
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
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

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
		.TapTakeHome("SI - WF 11-TC1-Tapped Home")

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


	
	@Test(groups={"SI-WF12"},priority=0, description = "SI - WF 912-TC2-Start From Scratch + add items from multiple lists +Default Loc + Default Category for MA user")
	public void SI_WF12_StartFromScratch_Catalog_OG_NonSysco_Prep_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");
	
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
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")


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
		
       
	     .verifySearchItemsOnSetupInv("SI - WF 12-TC2-Verify item selected")  
		 .verifyOGItemsOnSetupInv("SI - WF 12-TC2-Verify item selected")    

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
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		.Setup_AddItemsLink("SI - WF 12-TC2-Add items Selected")
		.AddItemFrom_PrepItem("SI - WF 12-TC2-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 12-TC2-NonSyscoItemAddPage")
		.TapOnDone("SI - WF 12-TC2-Tapped Done")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		
		.TapOnDone("SI - WF 12-TC2-Tapped Done")
		

		._atLocationsPage()
		.DefaultLocation("SI - WF 12-TC2-Tapped Default location")
		.tapContinue("SI - WF 12-TC2-Tapped Continue")

		

		._atCategoryPage()
		.defaultCategories("SI - WF 12-TC2-Tapped Custom category")
		.tapComplete("SI - WF 12-TC2-Tapped Complete")
		
		._atSetupInventoryPage()
		.TapTakeHome("SI-WF12-TC2-Tapped take me home")   

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
	@Test(groups={"SI-WF13"},priority=0, description = "SI - WF 13-TC1-Start from scratch+ Multiple lists +Custom location + Custom category")
	public void SI_WF13_StartFromScratch_MultipleList_CustomLocation_CustomCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");  
	       
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
		.Sixth_AccountSelection(loginData.UserName,"SI- WF 13-TC1-ThirdAccountSelect")

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
    
		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 13-TC1-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 13-TC1-Verify OG item selected")  //issue

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 13-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 13-TC1-Verify nonsysco item selected")


         .TapOnDone("SI- WF 13-TC1-Tapped Done6")
		
		// location setup
		._atLocationsPage()
		.CustomLocation("SI- WF 13-TC1-Tapped Custom location")
		.tapContinue("SI- WF 13-TC1-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI- WF 13-TC1-Enter location name")
		.AddLocations1_TypeDry("SI- WF 13-TC1-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData1.LocationName)
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
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 13-TC1-CreateTwoExpenseCategory") //
		.TapOnNext("SI - WF 13-TC1-Tapped Next3")
		.AssignMultipleItemsToCategory("SI - WF 13-TC1-Assign MultipleItems To Category1")
		.TapOnNext("SI - WF 13-TC1-Tapped Next4")

		._atSetupInventoryPage()
		.TapOnDone("SI - WF 13-TC1-Tapped Done8")
		.TapTakeHome("SI-WF13-TC1-Tapped Done8")
		
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


	@Test(groups={"SI-WF14"},priority=0, description = "SI - WF 14-TC1-Start from scratch+ Multiple lists +Default location + Custom category")
	public void SI_WF14_StartFromScratch_MultipleList_DefaultLocation_CustomCategory() {	

		LoginData loginData =LoginData.fetch("LoginData6");	  
		     
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
		.TapTakeHome("SI-WF14-TC1-Tapped Done8")
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 14-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI- WF 14-TC1-Select added location1")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 14-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 14-TC1-Verify item selected")
		.TapOnDone("SI - WF 14-TC1-Tapped Done")
	  
		;
	}
	@Test(groups={"SI-WF15"},priority=0, description = "SI - WF 15-TC1-Start from scratch+ Multiple lists +Custom location + Default category")
	public void SI_WF15_StartFromScratch_MultipleList_CustomLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData7");	  
	      
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
		.Second_AccountSelection(loginData.UserName,"SI- WF 15-TC1-ThirdAccountSelect")

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
	    .verifySearchItemsOnSetupInv("SI- WF 15-TC1-Verify catalog item selected") 
	    
		.Setup_AddItemsLink("SI- WF 15-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI- WF 15-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI- WF 15-TC1-Selected item from OG")
		
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

		.AddLocations2()
		.AddLocations2_name(locationsData1.LocationName)
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


	
	@Test(groups={"SI-WF16"},priority=0, description = "SI - WF 16-TC1-Start from scratch + Multiple lists+ Skip location+ Skip Category")
	public void SI_WF16_StartFromScratch_MultipleList_skipLocation_SkipCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");
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
		.Third_AccountSelection(loginData.UserName,"SI - WF 16-TC1-FirstAccountSelect")

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

		//verifications
		.verifySearchItemsOnSetupInv("SI- WF 16-TC1-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 16-TC1-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 16-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 16-TC1-Verify nonsysco item selected")



		.TapOnDone("SI - WF 16-TC1-Tapped Done")
	
		.TapOnDOThisLater("SI - WF 16-TC1-Tapped do this later")
		.TapOnSkip("SI - WF 16-TC1-Tapped Skip")


		.TapOnDOThisLater("SI - WF 16-TC1-Tapped do this later")
		.tapContinue("SI - WF 16-TC1-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 16-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 16-TC1-select added location")
		
		.TapOnDone("SI - WF 16-TC1-Tapped Done")
		;
	}
	@Test(groups={"SI-WF17"},priority=0, description = "SI - WF 17-TC1-Start from scratch + Multiple lists + Default loc + Skip Category")
	public void SI_WF17_StartFromScratch_MultipleList_DefaultLocation_SkipCategory() {	

		LoginData loginData =LoginData.fetch("LoginData8");	  
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
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 17-TC1-FirstAccountSelect")

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
		.verifySearchItemsOnSetupInv("SI - WF 17-TC1-Verify item selected")   //failed-productname not displayed

		.Setup_AddItemsLink("SI - WF 17-TC1-Add items Selected")
		.AddItemFrom_OrderGuide("SI - WF 17-TC1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI - WF 17-TC1-Selected item from OG")  
		//.verifyOGItemsOnSetupInv("SI - WF 17-TC1-Verify item selected")  //failed-no products in og now

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

		//verifications   
		.verifySearchItemsOnSetupInv("SI- WF 17-TC1-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI- WF 17-TC1-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 17-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 17-TC1-Verify nonsysco item selected")

		

		.TapOnDone("SI - WF 17-TC1-Tapped Done")  
		
		._atLocationsPage()
		.DefaultLocation("SI - WF 12-TC2-Tapped Default location")
		.tapContinue("SI - WF 12-TC2-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("SI - WF 17-TC1-Tapped do this later")
		.TapTakeHome("SI - WF 17-TC1-Tapped TakeMeHome")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 17-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 17-TC1-select added location")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 17-TC1-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 17-TC1-Verify nonsysco item selected")
        .TapOnDone("SI - WF 17-TC1-Tapped Done")
		;
	}		
	@Test(groups={"SI-WF18"},priority=0, description = "SI - WF 18-TC1-Start from scratch+ Multiple lists +skip location + default category for MA user")
	public void SI_WF18_StartFromScratch_MultipleList_skipLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData6");
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
		.Fifth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

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

         //verifications
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 18-TC1-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 18-TC1-Verify item selected")

		.verifySearchItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")
		.verifyOGItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")

		.TapOnDone("SI - WF 18-TC1-Tapped Done")
	

		.TapOnDOThisLater("SI - WF 18-TC1-Tapped do this later")


		._atCategoryPage()
		.defaultCategories("SI - WF 18-TC1-Tapped Custom category")
		.tapComplete("SI - WF 18-TC1-Tapped Complete")
		
		._atSetupInventoryPage()
		.TapTakeHome("SI-WF18-TC1-Tapped take me home")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 18-TC1-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 18-TC1-select added location")
		.TapOnDone("SI - WF 18-TC1-Tapped Done")
		;
	}


	@Test(groups={"SI-WF19"},priority=0, description = "SI - WF 19-TC1-Custom List + default Loc + default Category for Normal user")
	public void SI_WF19_CustomList_defaultLoc_defaultcategory() {	

		LoginData loginData =LoginData.fetch("LoginData3");
		ListData listData=ListData.fetch("ListData");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 19-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 19-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

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
	@Test(groups={"SI-WF20"},priority=0, description = "SI - WF 20-TC1-Custom List + Custom Loc + Custom Category for Normal user")
	public void SI_WF20_CustomList_CustomLoc_Customcategory() {	

		LoginData loginData =LoginData.fetch("LoginData1");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 20-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 20-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 20-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 20-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 20-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 20-TC1-Skip2 Tapped")
	
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

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
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
		
		//deleting location and checking items in nolocation
		.TapOnBack("SI - WF 20-TC1-Tapped Back")
		._atInventoryToolPage()
		.InvTools_Locations("SI - WF 20-TC1-Tapped Locations")
		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI - WF 20-TC1-Selecting Location1")
		.TapOnDeleteLocation("SI - WF 20-TC1-Tapped Delete")
		.TapOnYesDelete("SI - WF 20-TC1-Deleting AddedLocation")
		.VerifyCancelledLocationList(locationsData1.LocationName, "SI - WF 20-TC1-Verifing AddedLocation")
		.TapOnBack("SI - WF 20-TC1-Tapped Back")
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI - WF 20-TC1-Tapped Track Inventory")
		._atLocationsPage()
		.SelectLocation( locationsData.LocationName, "SI - WF 20-TC1-Selecting nolocation")
		.ItemVerifyOnLocation1("SI - WF 20-TC1-Item verification in nolocation")
		
		;
	}	
	@Test(groups={"SI-WF21"},priority=0, description = "SI - WF 21-TC1-Custom List + Custom Loc + Custom Category for Normal user")
	public void SI_WF21_CustomList_CustomLoc_Customcategory_FewItems() {	

		LoginData loginData =LoginData.fetch("LoginData4");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 21-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 21-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 21-TC1 Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI - WF 21-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 21-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 21-TC1-Skip2 Tapped")
		
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

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
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
		.SelectLocation(locationsData.LocationName, "SI - WF 21-TC1-select added location")
		.ItemVerifyOnLocation2("SI - WF 21-TC1-Item verification")
		.TapOnDone("SI - WF 21-TC1-Tapped Done")    
		
		;
	}	



	@Test(groups={"SI-WF22"},priority=0, description = "SI - WF 22-TC1-Custom List + Default Loc + custom Category for Normal user")
	public void SI_WF22_CustomList_DefaultLoc_Customcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData3");
		ListData listData=ListData.fetch("ListData");
		
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 22-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 22-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 22-TC1 Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI - WF 22-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 22-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 22-TC1-Skip2 Tapped")
	
		._atListPage()
		.TapCustomList("SI - WF 22-TC1-custom list Selected")
		.tapContinue("SI - WF 22-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 22-TC1-select list")
		.TapOnNext("SI - WF 22-TC1-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI - WF 22-TC1-Tapped Custom location")
		.tapContinue("SI - WF 22-TC1-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 22-TC1-Skip1 Tapped")

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
	@Test(groups={"SI-WF23"},priority=0, description = "SI - WF 23-TC1-Custom List + Custom Loc + default Category for Normal user")
	public void SI_WF23_CustomList_CustomLoc_defaultcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData4");
		ListData listData=ListData.fetch("ListData");
	
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 23-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 23-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 23-TC1 Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 23-TC1-FirstAccountSelect")

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

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
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
	@Test(groups={"SI-WF24"},priority=0, description = "SI - WF 24-TC1-Custom List + Skip location+ Skip Category for Normal user")
	public void SI_WF24_CustomList_SkipLoc_Skipcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData1");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 24-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 24-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 24-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 24-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 24-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
	
		._atListPage()
		.TapCustomList("SI - WF 24-TC1-custom list Selected")
		.tapContinue("SI - WF 24-TC1-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI - WF 24-TC1-select list")
		.TapOnNext("SI - WF 24-TC1-tapped next")


		._atSetupInventoryPage()
		.TapOnDOThisLater("SI - WF 24-TC1-TapOnDOThisLater Tapped")
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
	@Test(groups={"SI-WF25"},priority=0, description = "SI - WF 25-TC1-Custom List+Default loc + Skip Category for Normal user")
	public void SI_WF25_CustomList_DefaultLoc_Skipcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData3");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 25-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 25-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 25-TC1 Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI - WF 25-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 25-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
	

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

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI - WF 25-TC1-select added location")
		.TapOnDone("SI - WF 25-TC1-Tapped Done")
		;

	}
	@Test(groups={"SI-WF26"},priority=0, description = "SI - WF 26-TC1-Custom List+skip location + default category for Normal user")
	public void SI_WF26_CustomList_SkipLoc_defaultcategory_NU() {	

		LoginData loginData =LoginData.fetch("LoginData1");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 26-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 26-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 26-TC1 Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 26-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 26-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
	
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
		@Test(groups={"SI-WF27"},priority=0, description = "SI - WF 27-TC1-Custom List + Select Multiple List +List Names+Default Cat for Normal user")
		public void SI_WF27_CustomList_MultipleList_ListNames_DefaultCat_NU() {	

			LoginData loginData =LoginData.fetch("LoginData4");
			ListData listData=ListData.fetch("ListData2");
			ListData listData1=ListData.fetch("ListData3");
			

			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 27-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 27-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 27-TC1 Clicked account")

			._atAccountsPage()
			.Second_AccountSelection(loginData.UserName,"SI - WF 27-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 27-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
			
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

		@Test(groups={"SI-WF28"},priority=0, description = "SI - WF 28-TC1-Custom List + Select Multiple List +List Names as location+custom Cat for Normal user")
		public void SI_WF28_CustomList_MultipleList_ListNames_Customcategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData3");
			ListData listData=ListData.fetch("ListData2");
			ListData listData1=ListData.fetch("ListData3");
			
			CategoryData categoryData=CategoryData.fetch("CategoryData");

			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 28-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 28-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 28-TC1 Clicked account")

			._atAccountsPage()
			.Third_AccountSelection(loginData.UserName,"SI - WF 28-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 28-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
		
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
		@Test(groups={"SI-WF29"},priority=0, description = "SI - WF 29-TC1-Custom List + Select single  List +Custom categories as location+Default Cat")
		public void SI_WF29_CustomListSingleList_CustomCategoryOnLocationsPage_defaultcategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData4");
			ListData listData=ListData.fetch("ListData");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 29-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 29-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 29-TC1 Clicked account")

			._atAccountsPage()
			.Fourth_AccountSelection(loginData.UserName,"SI - WF 29-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 29-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
		
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






		@Test(groups={"SI-WF30"},priority=0, description = "SI - WF 30-TC1-Custom List + Select single  List +Custom Categories as location+Custom Cat")
		public void SI_WF30_CustomListSingleList_CustomCategoryOnLocationsPage_customcategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData1");
			ListData listData=ListData.fetch("ListData");
			
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 30-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 30-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 30-TC1 Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"SI - WF 30-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 30-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
		
			._atListPage()
			.TapCustomList("SI - WF 30-TC1-custom list Selected")
			.tapContinue("SI - WF 30-TC1-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "SI - WF 29-TC1-select list")
			.TapOnNext("SI - WF 30-TC1-tapped next")



			._atLocationsPage()
			.CustomCategories("SI - WF 30-TC1-Tapped Default category in Location Page")
			.tapContinue("SI - WF 30-TC1-Tapped Continue2")
		
			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 30-TC2-Skip3 Tapped")
		
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

			@Test(groups={"SI-WF31"},priority=0, description = "SI - WF 31-TC1-Custom List + Select Multiple List +List Names as location+skip Cat for Normal user")
			public void SI_WF31_CustomList_MultipleList_ListNames_Skipcategory_NU() {	

				LoginData loginData =LoginData.fetch("LoginData3");
				ListData listData=ListData.fetch("ListData2");
				ListData listData1=ListData.fetch("ListData3");
				

				Start.asTester
				.goToLoginpage()
				.verifyLoginPage("SI - WF 31-TC1-LoginPage")
				.signIn(loginData.UserName, loginData.Password,"SI - WF 31-TC1-LoginPage")

				._atHomePage()
				.ClickAccount(loginData.UserName,"SI - WF 31-TC1 Clicked account")

				._atAccountsPage()
				.Sixth_AccountSelection(loginData.UserName,"SI - WF 31-TC1-FirstAccountSelect")

				._atInventoryToolPage()
				.InvTools_SetUpInventory("SI - WF 31-TC1-SetupInventoryTap")

				._atSetupInventoryPage()
				.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
			

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
		@Test(groups={"SI-WF32"},priority=0, description = "SI - WF 32-TC1-Custom List + Select single  List +Custom categories as location+Skip Cat for Normal user")
		public void SI_WF32_CustomList_SingleList_CustomCatLoc_Skipcategory_NU() {	

			LoginData loginData =LoginData.fetch("LoginData1");
			ListData listData=ListData.fetch("ListData");
		
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 32-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 32-TC1-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"SI - WF 32-TC1 Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"SI - WF 32-TC1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("SI - WF 32-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("SI - WF 32-TC1-Skip2 Tapped")
		
			._atListPage()
			.TapCustomList("SI - WF 32-TC1-custom list Selected")
			.tapContinue("SI - WF 32-TC1-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "SI - WF 32-TC1-select list")
			.TapOnNext("SI - WF 32-TC1-tapped next")



			._atLocationsPage()
			.CustomCategories("SI - WF 32-TC1-Tapped Custom location")
			.tapContinue("SI - WF 32-TC1-Tapped Continue")

			._atSetupInventoryPage()
			//.TapOnSkip("SI - WF 32-TC1-Skip1 Tapped")
			.TapOnDOThisLater("SI - WF 32-TC1-STapOnDOThisLater Tapped")


			.TapTakeHome("SI - WF 32-TC1-Tapped take me home")      

			._atInventoryToolPage()
			.InvTools_TrackInventory("SI - WF 32-TC1-Selected track inventory")


			;

		}
		
	@Test(groups={"SI-WF33"},priority=0, description = "SI - WF 33-TC1-OG + Default Loc + Suggested Category")
	public void SI_WF33_OG_DefaultLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");	  

		
		
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 33-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 33-TC1-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 33-TC1-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI - WF 33-TC1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 33-TC1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 33-TC1-Skip1 Tapped")
		.TapOrderGuide("SI - WF 33-TC1-OG Selected")
		.tapContinue("SI - WF 33-TC1-Tapped Continue")
		
		._atLocationsPage()
		.DefaultLocation("SI - WF 33-TC1-Tapped Custom location")
		.tapContinue("SI - WF 33-TC1-Tapped Continue")

		
		._atCategoryPage()
		.SuggestedCategories("SI - WF 33-TC1-SuggestedCategories Tapped")
		.tapContinue("SI - WF 33-TC1-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 33-TC1-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 33-TC1-Selected track inventory")


		;



	}
	@Test(groups={"SI-WF34"},priority=0, description = "SI - WF 34-TC1-OG + Custom Loc + Suggested Category")
	public void SI_WF34_OG_CustomLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData7");	  
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
	
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 34-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 34-TC1-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 34-TC1-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI - WF 34-TC1-FirstAccountSelect")

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

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("SI - WF 34-TC1-Tapped Dry2")
		.TapOnNext("SI - WF 34-TC1-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI - WF 34-TC1-Selected Multiple items")
		.TapOnNext("SI - WF 34-TC1-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI - WF 34-TC1-Selected Multiple items")
		.TapOnDone("SI - WF 34-TC1-Tapped Done1")

		
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

	
	@Test(groups={"SI-WF35"},priority=0, description = "SI - WF 35-TC1-Custom List + Select single  List +Custom Categories as location+Suggested Cat")
	public void SI_WF35_CustomListSingleList_CustomCategoryOnLocationsPage_suggestedcategory_NU() {

		LoginData loginData =LoginData.fetch("LoginData4");
		ListData listData=ListData.fetch("ListData");
		

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 35-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 35-TC1-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 35-TC1 Clicked account")
		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI - WF 35-TC1-FirstAccountSelect")
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 35-TC1-SetupInventoryTap")
		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
	
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
	@Test(groups={"SI-WF36"},priority=0, description = "SI - WF 36-TC1-Custom List + Select Multiple List +List Names+Suggested Cat for Normal user")
	public void SI_WF36_CustomList_MultipleList_ListNames_SuggestedCat_NU() {
		
		LoginData loginData =LoginData.fetch("LoginData1");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");
		

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 36-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 36-TC1-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI - WF 36-TC1 Clicked account")
		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 36-TC1-FirstAccountSelect")
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI - WF 36-TC1-SetupInventoryTap")
		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")
		
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
		//.TapOnDone("SI - WF 36-TC1-Tapped Done")      
	
		._atSetupInventoryPage()
		.VerifyProductID_Location("SI - WF 36-TC1-ProductId")
		
		//changing category and verification
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

	@Test(groups={"SI-WF37"},priority=0, description = "SI - WF 37-TC1-Start from scratch+ Multiple lists +Custom location +Suggested category")
	public void SI_WF37_StartFromScratch_MultipleList_CustomLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData8");	  
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
		.Sixth_AccountSelection(loginData.UserName,"SI- WF 37-TC1-ThirdAccountSelect")

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

		.AddLocations2()
		.AddLocations2_name(locationsData1.LocationName)
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

	@Test(groups={"SI-WF38"},priority=0, description = "SI - WF 38-TC1-Start from scratch+ Multiple lists +Default location + Suggested category")
	public void SI_WF38_StartFromScratch_MultipleList_DefaultLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData6");	  
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
	        
	    ._atCategoryPage()
	    .TapOnBack("SI- WF 38-TC1-Tapped back")
	    ._atInventoryToolPage()
	    .InvTools_Category("SI- WF 38-TC1-Tapped Categories")
	    ._atCategoryPage()
	    .VerifySuggestedCategoryList("SI- WF 38-TC1-Verified Suggested Categories List")
		;

	}


	

@Test(groups={"TI-WF1-WF2"},priority=2, description = "TI-WF1-WF2-TC1-Select a location from trackinventory updating quantity and uom")
	public void TI_WF1_WF2_Location_Item_UOMQuantity() {	

		
		LoginData loginData =LoginData.fetch("LoginData2");	
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
		.Second_AccountSelection(loginData.UserName,"TI-WF1-WF2-TC1-ThirdAccountSelect")


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
			
			LoginData loginData =LoginData.fetch("LoginData7");	  
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
			.verifyOGItemsOnSetupInv("MIL-WF1-WF4-TC1-Verify item selected")  
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done") 
			._atLocationsPage()
			
			.SyscoProductSelect("MIL-WF1-WF4-TC1-Select Product")
			.TapOnEdit("MIL-WF1-WF4-TC1-Tapped Edit")
			.EditProduct_NickName("nickName", "MIL-WF1-WF4-TC1-Entering Nickname")
			.TapOnDone("MIL-WF1-WF4-TC1-Tapped Done")
			.TapOnBack("MIL-WF1-WF4-TC1-Tapped Back")

			
			._atSetupInventoryPage()
			.verifySearchItemsOnSetupInv("MIL-WF1-WF4-TC1-Verify item selected")	
			.verifyOGItemsOnSetupInv("MIL-WF1-WF4-TC1-Verify item selected") 	
			.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF1-WF4-TC1-Verify item selected")
			.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF1-WF4-TC1-Verify item selected")
			
			;
		}

	//Precond:setupinventory should be done so that trackinv is enabled
			@Test(groups={"MIL-WF2"},priority=0, description = "MIL - WF 2-TC2-Selecing a location, adding same items to multiple location")
			public void MIL_WF2_Location_AddItems__MultipleLocation() {	

			
				LoginData loginData =LoginData.fetch("LoginData2");
				LocationsData locationsData =LocationsData.fetch("LocatiosData3");
				LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
				LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
				NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
				PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
				VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
				
				UOMQuantityData uomQuantityData = UOMQuantityData.fetch("UOMQuantityData");
				UOMQuantityData uomQuantityData1 = UOMQuantityData.fetch("UOMQuantityData1");

				Start.asTester
				.goToLoginpage()
				.verifyLoginPage("MIL-WF 2-TC2-LoginPage")
				.signIn(loginData.UserName, loginData.Password,"MIL-WF 2-TC2-Login")

				._atHomePage()
				.ClickAccount(loginData.UserName,"Clicked account")

				._atAccountsPage()
				.Fourth_AccountSelection(loginData.UserName,"MIL-WF 2-TC2-FirstAccountSelect")
		
				//setting up inventory    
				._atInventoryToolPage()
				.InvTools_SetUpInventory("TI-WF1-WF2-TC1-SetupInventoryTap")

				._atSetupInventoryPage()
				.TapOnSkip("MIL-WF 2-TC2-Skip1 Tapped")
				.TapOrderGuide("MIL-WF 2-TC2-OG Selected")
				.tapContinue("MIL-WF 2-TC2-Tapped Continue")
				
				._atLocationsPage()
				.DefaultLocation("MIL-WF 2-TC2-Tapped Custom location")
				.tapContinue("MIL-WF 2-TC2-Tapped Continue")

		
				._atSetupInventoryPage()
				.TapOnDOThisLater("MIL-WF 2-TC2-Tapped do this later")
				.TapTakeHome("MIL-WF 2-TC2-Tapped Take me Home")
				
				._atInventoryToolPage()
				.InvTools_TrackInventory("MIL-WF 2-TC2-TrackinventoryTap")

				//creating a location1       
				._atLocationsPage()
				.TapAddLocation("MIL-WF 2-TC2-Tapped ADD1")
				.AddLocationName(locationsData.LocationName,"MIL-WF 2-TC2-Enter location1 name")
				.AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
				.TapOnDone("MIL-WF 2-TC2-Tapped Done")
				.TapOnBack("MIL-WF 2-TC2-Tapped Back")
				.VerifyLocationList(locationsData.LocationName, "MIL-WF 2-TC2-Verifing Added Location1")

				//nonsysco item addition to location1
				.SelectLocation(locationsData.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
				.TapAddLocation("MIL-WF 2-TC2-Tapped ADD2")

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
				.TapAddLocation("MIL-WF 2-TC2-Tapped ADD3")
				.AddLocationName(locationsData1.LocationName,"MIL-WF 2-TC2-Enter location2 name")
				.AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
				.TapOnDone("MIL-WF 2-TC2-Tapped Done")
				.TapOnBack("MIL-WF 2-TC2-Tapped Back")
				.VerifyLocationList(locationsData1.LocationName, "MIL-WF 2-TC2-Verifing Added Location2")

				.SelectLocation(locationsData1.LocationName, "MIL-WF 2-TC2-Selecting Added Location2")
				//.SelectLocation(locationsData.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
				.LocationDoneSelection("MIL-WF 2-TC2-Selecting Done")
				.TapOnDone("MIL-WF 2-TC2-Tapped Done")

				//prep item addition to location1

				.TapAddLocation("MIL-WF 2-TC2-Tapped ADD4")

				._atSetupInventoryPage()
				.AddItemFrom_PrepItem("MIL-WF 2-TC2-Tapped Prepitem")
				.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF 2-TC2-NonSyscoItem details entered")

				//same prep item addition to location3 
				._atLocationsPage()
				.AddLocation_AddProductDetailsPage("MIL-WF 2-TC2-Select Add/Select location option")
				.TapAddLocation("MIL-WF 2-TC2-Tapped ADD5")
				.AddLocationName(locationsData2.LocationName,"MIL-WF 2-TC2-Enter location3 name")
				.AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
				.TapOnDone("MIL-WF 2-TC2-Tapped Done")
				.TapOnBack("MIL-WF 2-TC2-Tapped Back")
				.VerifyLocationList(locationsData2.LocationName, "MIL-WF 2-TC2-Verifing Added Location3")

				.SelectLocation(locationsData2.LocationName, "MIL-WF 2-TC2-Selecting Added Location3")
			//	.SelectLocation(locationsData.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
				.LocationDoneSelection("MIL-WF 2-TC2-Selecting Done")
				.TapOnDone("MIL-WF 2-TC2-Tapped Done")

				//Verifications
				._atLocationsPage()
				.TapOnBack("MIL-WF 2-TC2-Tapped back")
				.SelectLocation(locationsData1.LocationName, "MIL-WF 2-TC2-Selecting Added Location2") 
				._atSetupInventoryPage()
				. verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF 2-TC2-Verify nonsysco item selected in Location2")
				._atLocationsPage()
				.TapOnBack("MIL-WF 2-TC2-Tapped Back")
				.SelectLocation(locationsData2.LocationName, "MIL-WF 2-TC2-Selecting Added Location3")
				._atSetupInventoryPage()
				.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF 2-TC2-Verify prep item selected in Location3")
				
				._atLocationsPage()
				.ProductSelect(prepItemData.ProductName, "MIL-WF 2-TC2-Selecting prep item")
				.TapOnEdit("MIL - WF2-TC2-Tap on edit")
				.PdtDetailPage_Location1_EnterQty(uomQuantityData.Quantity,locationsData2.LocationName, "MIL-WF 2-TC2-Enter Qty frst location")
				.PdtDetailPage_Location2_EnterQty(uomQuantityData1.Quantity,locationsData.LocationName, "MIL-WF 2-TC2-Enter Qty second location")
				.TapOnDone("MIL - WF2-TC2-tap on done")
				.TapOnBack("MIL - WF2-TC2-tap on back")
				.QuantityVerify(uomQuantityData.Quantity, "MIL - WF2-TC2-Quantity verify")

				
				._atLocationsPage()
				.TapOnBack("MIL-WF 2-TC2-Tapped Back")
				.SelectLocation(locationsData.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
				.QuantityVerify(uomQuantityData1.Quantity, "MIL -2-TC2-Quantity verify")

				._atSetupInventoryPage()
				.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF 2-TC2-Verify prep item selected in Location1")
                .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF 2-TC2-Verify nonsysco item selected in Location1")

				;
			}
		//Precond:setupinventory should be done so that trackinv is enabled , location with items
		@Test(groups={"MIL-WF3"},priority=0, description = "MIL - WF 3-TC2-Selecting a specific location in trackinventory and search for items within location for MA user")
		public void MIL_WF3_Location_SearchItems() {	

			LoginData loginData =LoginData.fetch("LoginData8");
			LocationsData locationsData =LocationsData.fetch("LocatiosData3");
			
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("MIL-WF3-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"MIL-WF3-TC1--Login")

			._atHomePage()
			.ClickAccount(loginData.UserName,"MIL-WF3-TC1-Clicked account")

			._atAccountsPage()
			.Fifth_AccountSelection(loginData.UserName,"MIL-WF3-TC1-FirstAccountSelect")

			
			//setting up inventory    
			._atInventoryToolPage()
			.InvTools_SetUpInventory("MIL-WF3-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("MIL-WF3-TC1--Tapped Skip")
			.StartFromScratch("MIL-WF3-TC1-ScratchSelected")
			.tapContinue("MIL-WF3-TC1-Tapped Continue")
			.Scratch_AddItems("MIL-WF3-TC1-Tapped Add items")
			.AddItemFrom_OrderGuide("MIL-WF3-TC1-Tapped Order Guide")
			.SelectItemFrom_OrderGuide("MIL-WF3-TC1-Selected item from OG")
			.verifyOGItemsOnSetupInv("MIL-WF3-TC1-Verify item selected")
			.TapOnDone("MIL-WF3-TC1-Tapped Done")
		
			._atLocationsPage()
			.DefaultLocation("MIL-WF3-TC1-Tapped Custom location")
			.tapContinue("MIL-WF3-TC1-Tapped Continue")
			._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF3-TC1-Tapped do this later")
			.TapTakeHome("MIL-WF3-TC1-Tapped TakeMeHome")

			._atInventoryToolPage()
			.InvTools_TrackInventory("MIL-WF3-TC1-TrackinventoryTap")


			._atLocationsPage()
			.TapAddLocation("MIL-WF3-TC1-Tapped ADD")
			.AddLocationName(locationsData.LocationName,"MIL-WF3-TC1-Enter location name")
			.AddLocationCooler("MIL-WF3-TC1-Tapped Cooler")
			.TapOnDone("MIL-WF3-TC1-Tapped Done")
			.TapOnBack("MIL-WF3-TC1-Tapped Back")
			.VerifyLocationList(locationsData.LocationName, "MIL-WF3-TC1-Verifing AddedLocation")
			.SelectLocation(locationsData.LocationName, "MIL-WF3-TC1-Selecting location")

			//og item addition
			._atLocationsPage()
			.TapAddLocation("MIL-WF3-TC1-Tapped ADD")

			.AddItemFrom_OrderGuide("MIL-WF3-TC1-Tapped Orderguide")
			._atSetupInventoryPage()
			.SelectMultipleItemsFrom_OrderGuide("MIL-WF3-TC1-Selected multiple items from OG")
			.TapOnDone("MIL-WF3-TC1-Tapped Done")
			.verifyMultipleItemsfromOGonSetUpInv("MIL-WF3-TC1-Verify items selected")  
			.TapOnDone("MIL-WF3-TC1-Tapped Done")
			.verifyMultipleItemsfromOGonSetUpInv("MIL-WF3-TC1-Verify item selected")  
			
			.SearchKeyword("MIL-WF3-TC1-Keyword searching")
			//.TapOnDone("MIL-WF3-TC1-Done tap")
			.verifyKeywordSearchItems("MIL-WF3-TC1-Verify Keyword search")

			;
		}



	//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
		@Test(groups={"MIL-WF5"},priority=0, description = "MIL - WF 5-TC2-Selecting a location navigate to product and assiging  item  to diff location")
		public void MIL_WF5_Locations_ItemEdit_UpdateLocation() {	

		  

			LoginData loginData =LoginData.fetch("LoginData2"); //ma sa002
			LocationsData locationsData =LocationsData.fetch("LocatiosData3");
			LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
			
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("MIL-WF5-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"MIL-WF5-TC1-Login")

			._atHomePage()
			.ClickAccount(loginData.UserName,"MIL-WF5-TC1-Clicked account")

			._atAccountsPage()
			.Sixth_AccountSelection(loginData.UserName,"MIL-WF5-TC1-FirstAccountSelect")

			//setting up inv
			._atInventoryToolPage()
			.InvTools_SetUpInventory("MIL-WF5-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("MIL-WF5-TC1-Skip1 Tapped")
			.TapOrderGuide("MIL-WF5-TC1-Selected OG")
			.tapContinue("MIL-WF5-TC1-Tapped Continue")
		
			._atLocationsPage()
			.DefaultLocation("MIL-WF5-TC1-Tapped Default location")
			.tapContinue("MIL-WF5-TC1-Tapped Continue")
			._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF5-TC1-Tapped do this later")
			.TapTakeHome("MIL-WF5-TC1-Tapped take me home")  
				
			
			._atInventoryToolPage()
			.InvTools_TrackInventory("MIL-WF5-TC1-TrackinventoryTap")

			._atLocationsPage()
			.TapAddLocation("MIL-WF5-TC1-Tapped ADD")
			.AddLocationName(locationsData.LocationName,"MIL-WF5-TC1-Enter location name")
			.AddLocationCooler("MIL-WF5-TC1-Tapped Cooler")
			.TapOnDone("MIL-WF5-TC1-Tapped Done")
			.TapOnBack("MIL-WF5-TC1-Tapped Back")
			.VerifyLocationList(locationsData.LocationName, "MIL-WF5-TC1-Verifing AddedLocation")
			//nonsyscoitem addition 
			.SelectLocation(locationsData.LocationName, "MIL-WF5-TC1-Selecting AddedLocation")
			.TapAddLocation("MIL-WF5-TC1-Tapped ADD")

			._atSetupInventoryPage()
			.AddItemFrom_NonSysco("MIL-WF5-TC1-Tapped NonSysco")
			.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF5-TC1-NonSyscoItem details entered")
			.AddSupplier_AddProductDetailsPage("MIL-WF5-TC1-select supplier")

			._atVendorPage()
			.Add_Supplier("MIL-WF5-TC1-AddVendorTap")
			.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF5-TC1-AddVendorDetails")
			.TapOnDone("MIL-WF5-TC1-Done")

			.TapOnBack("MIL-WF5-TC1-Back")
			.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF5-TC1-SupplierSelect")
			.TapOnDone("MIL-WF5-TC1-Done")

			._atSetupInventoryPage()
			.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF5-TC1-Verify item selected")

			._atLocationsPage()
			.ProductSelect(nonSyscoItemData.ProductName, "MIL-WF5-TC1-Select Product")
			.TapOnEdit("MIL-WF5-TC1-Tapped Edit")
			.AddLocation_AddProductDetailsPage("MIL-WF5-TC1-Select Add/Select option")
			.TapAddLocation("MIL-WF5-TC1-Tapped ADD")
			.AddLocationName(locationsData1.LocationName,"MIL-WF5-TC1-Enter location name")
			.AddLocationCooler("MIL-WF5-TC1-Tapped Cooler")
			.TapOnDone("MIL-WF5-TC1-Tapped Done")
			.TapOnBack("MIL-WF5-TC1-Tapped Back")
			.VerifyLocationList(locationsData1.LocationName, "MIL-WF5-TC1-Verifing AddedLocation")

			.SelectLocation(locationsData1.LocationName, "MIL-WF5-TC1-Selecting AddedLocation")
			.SelectLocation(locationsData.LocationName, "MIL-WF5-TC1-Selecting AddedLocation")
			.LocationDoneSelection("MIL-WF5-TC1-Selecting Done")
			.TapOnDone("MIL-WF5-TC1-Tapped Done")

			.TapOnBack("MIL-WF5-TC1-Tapped Back")
			.TapOnBack("MIL-WF5-TC1-Tapped Back")

			.SelectLocation(locationsData.LocationName, "MIL-WF5-TC1-Selecting AddedLocation")
			._atSetupInventoryPage()
			.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF5-TC1-Verify item selected")

			._atLocationsPage() 
			.TapOnBack("MIL-WF5-TC1-Tapped Back")
			.SelectLocation(locationsData1.LocationName, "MIL-WF5-TC1-Selecting AddedLocation")
			
			._atSetupInventoryPage()
			.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF5-TC1-Verify item selected")


			;
		}




	//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
	@Test(groups={"MIL-WF6"},priority=0, description = "MIL - WF 6-TC2-Creating Location,Editing Location in Manage Locations and assiging  item  to diff location")
	public void MIL_WF6_Create_Edit_Delete_Locations() {	

		LoginData loginData =LoginData.fetch("LoginData2");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI - WF 8-TC2-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL - WF 5-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")

		
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
		.InvTools_Locations("MIL- WF 5-TC2-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MIL- WF 5-TC2-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL- WF 5-TC2-Enter location name")
		.AddLocationCooler("MIL- WF 5-TC2-Tapped Cooler")
		.TapOnDone("MIL- WF 5-TC2-Tapped Done")
		.TapOnBack("MIL- WF 5-TC2-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL- WF 5-TC2-Verifing AddedLocation")

		.TapAddLocation("MIL- WF 5-TC2-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL- WF 5-TC2-Enter location name")
		.AddLocationCooler("MIL- WF 5-TC2-Tapped Cooler")
		.TapOnDone("MIL- WF 5-TC2-Tapped Done")
		.TapOnBack("MIL- WF 5-TC2-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL- WF 5-TC2-Verifing AddedLocation")

		.SelectLocation(locationsData.LocationName, "MIL- WF 5-TC2-Selecting AddedLocation")
		.TapOnEdit("MIL- WF 5-TC2-Editing AddedLocation")
		.AddLocationName(locationsData.EditLocation,"MIL- WF 5-TC2-Enter location name")
		.AddLocationCooler("MIL- WF 5-TC2-Tapped Cooler")
		.TapOnDone("MIL- WF 5-TC2-Tapped Done")
		.TapOnBack("MIL- WF 5-TC2-Tapped Back")
		.VerifyLocationList(locationsData.EditLocation, "MIL- WF 5-TC2-Verifing AddedLocation")

		.SelectLocation(locationsData.EditLocation, "MIL- WF 5-TC2-Selecting AddedLocation")
		.TapOnDeleteLocation("MIL- WF 5-TC2-Tapped Delete")
		.TapOnYesDelete("MIL- WF 5-TC2-Deleting AddedLocation")
		.VerifyCancelledLocationList(locationsData.EditLocation, "MIL- WF 5-TC2-Verifing AddedLocation")



		;
	}


@Test(groups={"MIL-WF7"},priority=4, description = "MIL - WF 7-TC1-Track Inventory+Location+Edit+Delete Items from location")
	public void MIL_WF7_TrackInventory_Location_Edit_Delete_Items_location() {

		LoginData loginData =LoginData.fetch("LoginData5");	  
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF7-TC1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF7-TC1-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF7-TC1-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"MIL-WF7-TC1-FirstAccountSelect")

		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF7-TC1-SetupInventoryTap")
		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF7-TC1-Skip1 Tapped")
		.TapOrderGuide("MIL-WF7-TC1-OG Selected")
		.tapContinue("MIL-WF7-TC1-Tapped Continue")
		._atLocationsPage()
		.DefaultLocation("MIL-WF7-TC1-Tapped Custom location")
		.tapContinue("MIL-WF7-TC1-Tapped Continue")
		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF7-TC1-Tapped do this later")
		.TapTakeHome("MIL-WF7-TC1-Tapped TakeMeHome")
		
		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF7-TC1-TrackinventoryTap")


		._atLocationsPage()
		.TapAddLocation("MIL-WF7-TC1-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL-WF7-TC1-Enter location name")
		.AddLocationCooler("MIL-WF7-TC1-Tapped Cooler")
		.TapOnDone("MIL-WF7-TC1-Tapped Done")
		.TapOnBack("MIL-WF7-TC1-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL-WF7-TC1-Verifing AddedLocation")
		.SelectLocation(locationsData1.LocationName, "MIL-WF7-TC1-Selecting location")

		//og item addition
		._atLocationsPage()
		.TapAddLocation("MIL-WF7-TC1-Tapped ADD")
		.AddItemFrom_OrderGuide("MIL-WF7-TC1-Tapped Orderguide")
		._atSetupInventoryPage()
		.SelectMultipleItemsFrom_OrderGuide("MIL-WF7-TC1-Selected multiple items from OG")
		.TapOnDone("MIL-WF7-TC1-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF7-TC1-Verify items selected")  
		.TapOnDone("MIL-WF7-TC1-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF7-TC1-Verify items selected")  
		._atLocationsPage()
		.TapOnEdit("MIL-WF7-TC1-Tapped Edit")
		.DeleteItems("MIL-WF7-TC1-Deleting items in location")
		.TapOnDone("MIL-WF7-TC1-Tapped Done2")
		.TapOnYesDelete("MIL-WF7-TC1-confirming Deleting items")
		.VerifyDeleteItemsList("MIL-WF7-TC1-Verifying Deleted items list")	
		
		
		;
	}	

	@Test(groups={"MIL-WF10"},priority=0, description = "MIL - WF 10  Track Inventory+Location+item product card + update qty & UOM")
	public void MIL_WF10_TrackInventory_Location_item_productcard_updateqtyUOM() {	
	
	    LoginData loginData =LoginData.fetch("LoginData2"); 	
		LocationsData locationsData =LocationsData.fetch("LocationsData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		UOMQuantityData uomQuantityData = UOMQuantityData.fetch("UOMQuantityData");
		
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("MIL-WF10-TC1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"MIL-WF10-TC1-Login")


			._atHomePage()
			.ClickAccount(loginData.UserName,"MIL-WF10-TC1-Clicked account")


			._atAccountsPage()
			.Third_AccountSelection(loginData.UserName,"MIL-WF10-TC1-FirstAccountSelect")

	
			._atInventoryToolPage()
			.InvTools_SetUpInventory("MIL-WF10-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("MIL-WF10-TC1-Skip1 Tapped")
			.TapOrderGuide("MIL-WF10-TC1-Selected")
			.tapContinue("MIL-WF10-TC1-Tapped Continue")
		

			._atSetupInventoryPage()
			._atLocationsPage()
			.DefaultLocation("MIL-WF10-TC1-Tapped Default location")
			.tapContinue("MIL-WF10-TC1-Tapped Continue")
			._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF10-TC1-Tapped do this later")
			.TapTakeHome("MIL-WF10-TC1-Tapped take me home")  
			
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
	@Test(groups={"MEC-WF1"},priority=0, description = "MEC - WF 1-TC2-Selecting a location navigate to product and assiging  item  to category created")
	public void MEC_WF1_Locations_ItemEdit_UpdateCategory() {	

		LoginData loginData =LoginData.fetch("LoginData2");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		CategoryData categoryData =CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MEC - WF 1-TC2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MEC-WF 1-TC2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MEC - WF 1-TC2-Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"MEC-WF 1-TC2-FirstAccountSelect")

		
		
		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MEC-WF 1-TC2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MEC-WF 1-TC2-Skip1 Tapped")
		.TapOrderGuide("MEC-WF 1-TC2-OG Selected")
		.tapContinue("MEC-WF 1-TC2-Tapped Continue")
		
		._atLocationsPage()
		.DefaultLocation("MEC-WF 1-TC2-Tapped Custom location")
		.tapContinue("MEC-WF 1-TC2-Tapped Continue")

	
		._atSetupInventoryPage()
		.TapOnDOThisLater("MEC-WF 1-TC2-Tapped do this later")
		.TapTakeHome("MEC-WF 1-TC2-Tapped Take me Home")
		
		._atInventoryToolPage()
		.InvTools_TrackInventory("MEC-WF 1-TC2-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MEC-WF 1-TC2-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MEC-WF 1-TC2-Enter location name")
		.AddLocationCooler("MEC-WF 1-TC2-Tapped Cooler")
		.TapOnDone("MEC-WF 1-TC2-Tapped Done")
		.TapOnBack("MEC-WF 1-TC2-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MEC-WF 1-TC2-Verifing AddedLocation")
		//nonsysco item addition 
		.SelectLocation(locationsData.LocationName, "MEC-WF 1-TC2-Selecting AddedLocation")
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
		.SelectLocation(locationsData.LocationName, "MEC-WF 1-TC2-Selecting AddedLocation")
		._atCategoryPage()
		.VerifyCategory(categoryData.Name, "MEC-WF 1-TC2-Verified Category")

		;
	}







	
	//Precond:setupinventory should be done so that trackinv is enabled
		@Test(groups={"MEC-WF2"},priority=0, description = "MEC - WF 2-TC1-Creating, editing and deleting category as a MA user")
		public void MEC_WF2_Category_Create_Edit_Delete_Category_NU() {	

		LoginData loginData =LoginData.fetch("LoginData2");  
		CategoryData categoryData =CategoryData.fetch("CategoryData");
		
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("MEC-WF 2-TC2-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"MEC-WF 2-TC1-Login")


			._atHomePage()
			.ClickAccount(loginData.UserName,"MEC-WF 2-TC1-Clicked account")

			._atAccountsPage()
			.Fifth_AccountSelection(loginData.UserName,"MEC-WF 2-TC1-FirstAccountSelect")

			//setting up inventory    
			._atInventoryToolPage()
			.InvTools_SetUpInventory("MEC-WF 2-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("MEC-WF 2-TC1-Skip1 Tapped")
			.TapOrderGuide("MEC-WF 2-TC1-OG Selected")
			.tapContinue("MEC-WF 2-TC1-Tapped Continue")
			
			._atLocationsPage()
			.DefaultLocation("MEC-WF 2-TC1-Tapped Custom location")
			.tapContinue("MEC-WF 2-TC1-Tapped Continue")

			._atSetupInventoryPage()
			.TapOnDOThisLater("MEC-WF 2-TC1-Tapped do this later")
			.TapTakeHome("MEC-WF 2-TC1-Tapped Take me Home")

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
			.AddCategoryName(categoryData.Name1, "MEC-WF 2-TC1-Entering new name")
			.AddCategoryFood("MEC-WF 2-TC1-Enter type food") 
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
		public void MNS_1_CreateNonSyscoItem_LinkSupplier_Location_Category() {	

		

			LoginData loginData =LoginData.fetch("LoginData2"); 
			LocationsData locationsData =LocationsData.fetch("LocationsData");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData1");
			PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
			SearchData searchData=SearchData.fetch("SearchData");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("MNS-1-TC1-LoginPage")
			.saveUsernameCheckBoxClick("MNS-1-TC1-save username")
			.signIn(loginData.UserName, loginData.Password,"MNS-1-TC1-Login")

			._atHomePage()
			.ClickAccount(loginData.UserName,"MNS-1-TC1-Clicked account")

			._atAccountsPage()
			.Sixth_AccountSelection(loginData.UserName,"MNS-1-TC1-FirstAccountSelect")

			
			._atInventoryToolPage()
			.InvTools_SetUpInventory("MNS-1-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("MNS-1-TC1-Tapped Skip1")
			.StartFromScratch("MNS-1-TC1-ScratchSelected")
			.tapContinue("MNS-1-TC1-Tapped Continue1")
			.Scratch_AddItems("MNS-1-TC1-Tapped Add items")
		    .SearchItem(searchData.keyword,"MIL - WF 1,3-TC2-Search item")

		     .SelectItemFrom_Catalog("SI- WF 37-TC1-Selected item from catalog")
			.TapOnDone("SI- WF 37-TC1-Tapped Done4")

			.verifySearchItemsOnSetupInv("SI- WF 37-TC1-Verify catalog item selected")
			.TapOnDone("MNS-1-TC1-Tapped Done2")
		
			._atLocationsPage()
			.DefaultLocation("MNS-1-TC1-Tapped Custom location")
			.tapContinue("MNS-1-TC1-Tapped Continue")

			._atSetupInventoryPage()
			.TapOnDOThisLater("MNS-1-TC1-Tapped do this later")
			 .TapTakeHome("MNS-1-TC11-Tapped Take me Home")  

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

			.TapOnDone("MNS-1-TC1-Tapped Done,Nonsyscoitem added")   //issue

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
		public void MPI_1_CreatePrepItem_LinkLocation_Category() {	

			LoginData loginData =LoginData.fetch("LoginData6");	  
			LocationsData locationsData =LocationsData.fetch("LocationsData");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
			PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("MPI-1-TC1-LoginPage")
			.saveUsernameCheckBoxClick("MPI-1-TC1-save username")
			.signIn(loginData.UserName, loginData.Password,"MPI-1-TC1-Login")

			._atHomePage()
			.ClickAccount(loginData.UserName,"MPI-1-TC1-Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"MPI-1-TC1-FirstAccountSelect")

			
			 ._atInventoryToolPage()
			.InvTools_SetUpInventory("MPI-1-TC1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("MPI-1-TC1-Tapped Skip1")
			.StartFromScratch("MPI-1-TC1-ScratchSelected")
			.tapContinue("MPI-1-TC1-Tapped Continue1")
			.Scratch_AddItems("MPI-1-TC1-Tapped Add items")
			.AddItemFrom_OrderGuide("MPI-1-TC1-Tapped Order Guide")
			.SelectItemFrom_OrderGuide("MPI-1-TC1-Selected item from OG")
			
			.verifyOGItemsOnSetupInv("MPI-1-TC1-Verify item selected")
			.TapOnDone("MPI-1-TC1-Tapped Done2")
		
			._atLocationsPage()
			.DefaultLocation("MPI-1-TC1-Tapped Custom location")
			.tapContinue("MPI-1-TC1-Tapped Continue")

			._atSetupInventoryPage()
			.TapOnDOThisLater("MPI-1-TC1-Tapped do this later")
			.TapTakeHome("MPI-1-TC11-Tapped Take me Home")  

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
		public void MSP1_MSP2_Add_View_ManageSuppliers_NU()
		{
			
		
			LoginData loginData =LoginData.fetch("LoginData2"); 
			VendorDetailsData vendorData=VendorDetailsData.fetch("VendorDetailData4");
			VendorDetailsData vendorDataEdit=VendorDetailsData.fetch("VendorDetailData1");
			VendorDetailsData vendorData1=VendorDetailsData.fetch("VendorDetailData2");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("MSP-1,MSP-2-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"MSP-1,MSP-2-LoginPage")
			._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			._atAccountsPage()
		    .Second_AccountSelection(loginData.UserName,"MSP-1,MSP-2-FirstAccountSelect")
		
		    ._atInventoryToolPage()
			.InvTools_SetUpInventory("MSP-1,MSP-2SetupInventoryTap")
			._atSetupInventoryPage()
			.TapOnSkip("MSP-1,MSP-2-Skip1 Tapped")
			.TapOrderGuide("MSP-1,MSP-2-OG Selected")
			.tapContinue("MSP-1,MSP-2-Tapped Continue")
			
			._atLocationsPage()
			.DefaultLocation("MSP-1,MSP-2-Tapped Custom location")
			.tapContinue("MSP-1,MSP-2-Tapped Continue")

			._atSetupInventoryPage()
			.TapOnDOThisLater("MSP-1,MSP-2-Tapped do this later")
			 .TapTakeHome("MSP-1,MSP-2-Tapped Take me Home")  
				
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
			.AddSupplier_Details(vendorData1.VendorName, vendorData1.PhoneNum, vendorData1.Address, vendorData1.ContactInfo, vendorData1.Email, vendorData1.Note, "MSP-1,MSP-2-Entered vendor details to be cancelled vendor details")
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


