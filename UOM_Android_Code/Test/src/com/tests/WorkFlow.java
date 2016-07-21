
package com.tests;


import org.testng.annotations.Test;
import com.components.entities.Start;
import com.components.yaml.LocationsData;
import com.components.yaml.CategoryData;
import com.components.yaml.ListData;
import com.components.yaml.NonSyscoItemData;
import com.components.yaml.PrepItemData;
import com.components.yaml.ProductNickNameData;
import com.components.yaml.PurchasesData;
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

	@Test(groups={"SI-WF1"},priority=0, description = "SI-WF1-OG + Default Loc + Default Category")
	public void SI_WF1_OG_DefaultLocation_DefaultCategory() {


		LoginData loginData =LoginData.fetch("LoginData1");	  
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
	
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF1-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF1-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI-WF1-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF1-Skip1 Tapped")
		.VerifyOptionsOnImportItems("SI-WF1-Verified import items page")
		.TapOrderGuide("SI-WF1-OG Selected")
		.tapContinue("SI-WF1-Tapped Continue")

		._atLocationsPage()
		.VerifyOptionsOnSetupLocations("SI-WF1-Location page verified")
		.DefaultLocation("SI-WF1-Tapped Custom location")
		.tapContinue("SI-WF1-Tapped Continue")

		._atCategoryPage()
		.VerifyOptionsOnSetUpFoodCost("SI-WF1-Category page verified")
		.defaultCategories("SI-WF1-Tapped Default category")
		.tapComplete("SI-WF1-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF1-Tapped take me home")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF1-Selected track inventory")
		._atLocationsPage()
		.SelectLocation(locDataCooler.LocationName, "SI-WF1-Selected cooler")
		.VerifyItemsOnDefaultLocation(locDataCooler.LocationName, "SI-WF1-Verified cooler")
		.TapOnBack("SI-WF1-Tapped on Back")
		//.VerifyCountOfItemsInLocation(locDataCooler.LocationName, "SI-WF1-Count of items in cooler")
		.SelectLocation(locDataFreezer.LocationName, "SI-WF1-Selected freezer")
		.VerifyItemsOnDefaultLocation(locDataFreezer.LocationName, "SI-WF1-Verified freezer")
		.TapOnBack("SI-WF1-Tapped on Back")
	//	.VerifyCountOfItemsInLocation(locDataFreezer.LocationName, "SI-WF1-Count of items in freezer")
		.SelectLocation(locDataDry.LocationName, "SI-WF1-Selected dry")
		.VerifyItemsOnDefaultLocation(locDataDry.LocationName, "SI-WF1-Verified dry")
		.TapOnBack("SI-WF1-Tapped on Back")
	//	.VerifyCountOfItemsInLocation(locDataDry.LocationName, "SI-WF1-Count of items in Dry")
		
		
		;
	}


	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Multiple locations and Multiple category. 
	 * Validating items are displayed on appropriate locations on Track Inventory.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	
	@Test(groups={"SI-WF3"},priority=1, description = "SI-WF3-OG + Cus Loc + Cust Category")
	public void SI_WF3_OG_CustomMultipleLocation_CustomMultipleCategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");

		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF3-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF3-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF3-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI-WF3-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF3-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF3-Skip1 Tapped")
		.TapOrderGuide("SI-WF3-OG Selected")
		.tapContinue("SI-WF3-Tapped Continue1")


		._atLocationsPage()
		.CustomLocation("SI-WF3-Tapped Custom location")
		.tapContinue("SI-WF3-Tapped Continue2")
		
		.VerifyOptionsOnCustomLocations("SI-WF3-Verified create custom LocationsPage")

		.EnterLocationName(locationsData1.LocationName,"SI-WF3-Enter location name")
		.AddLocations1_TypeDry("SI-WF3-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("SI-WF3-Tapped Dry2")
		.TapOnNext("SI-WF3-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI-WF3-Selected Multiple items")
		.TapOnNext("SI-WF3-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI-WF3-Selected Multiple items")
		.TapOnDone("SI-WF3-Tapped Done1")

		._atCategoryPage()
		.CustomCategories("SI-WF3-CustomCategories Tapped")
		.tapContinue("SI-WF3-TC1-Tapped Continue3")
		
		.VerifyOptionsOnCreateExpenseCategory("SI-WF3-Verified create custom category Page")
		
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF3-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF3-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF3-selectMultipleItemsFromCategory1")
		.selectMultipleItemsFromCategory1("SI-WF3-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF3-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI-WF3-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF3-TTapped Done2")
		.TapTakeHome("SI-WF3-Tapped Continue4") 


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF3-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF3-LocationTap1")
		.ItemVerifyOnLocation1("SI-WF3-Verify item inside location1")
		.TapOnBack("SI-WF3-Tap on Back1")
		.SelectLocation(locationsData2.LocationName, "SI-WF3-LocationTap2")
		.ItemVerifyOnLocation2("SI-WF3-Verify item inside location2")
		;




	}

	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default locations and Multiple category. 
	 * Validating order of default locations on Track Inventory.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI-WF4"},priority=2, description = "SI-WF4-OG + Default Loc + Custom Category")
	public void SI_WF4_OG_DefaultLocation_CustomCategory() {

		LoginData loginData =LoginData.fetch("LoginData2");

		CategoryData categoryData=CategoryData.fetch("CategoryData");
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		LocationsData locDataNoLoc=LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF4-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF4-Save Username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF4-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF4-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI-WF4-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF4-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF4-Skip1 Tapped")
		.TapOrderGuide("SI-WF4-OG Selected")
		.tapContinue("SI-WF4-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("SI-WF4-Tapped Custom location")
		.tapContinue("SI-WF4-Tapped Continue")

		._atCategoryPage()
		.CustomCategories("SI-WF4-CustomCategories Tapped")
		.tapContinue("SI-WF4-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF4-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF4-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF4-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF4-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI-WF4-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF4-Tapped Done2")
		.TapTakeHome("SI-WF4-Tapped TakeHome") 

		._atInventoryToolPage()
		.InvTools_Locations("SI-WF4-Selected Locations")
		._atLocationsPage()
		.VerifyOrderOfLocations(locDataCooler.LocationName, locDataFreezer.LocationName, locDataDry.LocationName, locDataNoLoc.LocationName, "SI-WF4-Verified order of locations")
		.TapOnBack("SI-WF4-Tapped Back")
		
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF4-Selected track inventory")
		._atLocationsPage()
		.VerifyOrderOfLocations(locDataCooler.LocationName, locDataFreezer.LocationName, locDataDry.LocationName, locDataNoLoc.LocationName, "SI-WF4-Verified order of locations")
		
		
		//checking INV_248,249 scenario 5, INV_250,251 scenario 5
		.SelectLocation(locDataNoLoc.LocationName, "SI-WF4-Selecting no location")
		.NoItemsCheckInNoLocation("SI-WF4-Item verification in no location")
		
		
		;
	}
	
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Multiple locations and Default category. 
	 * Validating items are displayed on appropriate locations on Track Inventory.
	 * Validating items can be viewed by tapping 'View Items' link in Home page>>Location>>Location Details page
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI-WF5"},priority=3, description = "SI-WF5-OG + Custom Loc + Default Category")
	public void SI_WF5_OG_CustomLocation_DefaultCategory() {

		LoginData loginData =LoginData.fetch("LoginData1");

		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData3 =LocationsData.fetch("LocatiosData4");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF5-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF5-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF5-Clicked account")
		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI-WF5-FirstAccountSelect")
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF5-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF5-Skip1 Tapped")
		.TapOrderGuide("SI-WF5-OG Selected")
		.tapContinue("SI-WF5-Tapped Continue1")

		._atLocationsPage()
		.CustomLocation("SI-WF5-Tapped Custom location")
		.tapContinue("SI-WF5-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI-WF5-Enter location name")
		.AddLocations1_TypeDry("SI-WF5-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("SI-WF5-Tapped Dry2")
		.TapOnNext("SI-WF5-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI-WF5-Selected Multiple items")
		.TapOnNext("SI-WF5-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI-WF5-Selected Multiple items")
		.TapOnDone("SI-WF5-Tapped Done1")

		._atCategoryPage()
		.defaultCategories("SI-WF5-Tapped Default category")
		.tapComplete("SI-WF5-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF5-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF5-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF5-LocationTap1")
		.ItemVerifyOnLocation1("SI-WF5-Verify item inside location1")
		.TapOnBack("SI-WF5-Tap on Back1")
		.SelectLocation(locationsData2.LocationName, "SI-WF5-LocationTap2")
		.ItemVerifyOnLocation2("SI-WF5-Verify item inside location2")

		.TapOnBack("SI-WF5-Tap on Back1")
		.TapOnBack("SI-WF5-Tap on Back1")


		._atInventoryToolPage()
		.InvTools_Locations("SI-WF5-Tapped Locations")
		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF5-Selecting Location1")
		.ViewItemsOnLocation("SI-WF5-view items on Location1")
		.ItemVerifyOnLocation1("SI-WF5-Verify item inside location1")
		
		
		.TapOnBack("SI-WF5-Tap on Back1")
		.TapOnBack("SI-WF5-Tap on Back1")
		.TapOnBack("SI-WF5-Tap on Back1")
		
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF5-Selected track inventory")

		//checking INV_248,249 scenario 1
		._atLocationsPage()
		.SelectLocation(locationsData3.LocationName, "SI-WF5-Selecting no location")
		.CustomLocItemsCheckInNoLocation("SI-WF5-Item verification in no location")
        .NoLocationTextCheck(locationsData3.LocationName,"SI-WF5-No location text verification")
       
      //checking INV_250,251 scenario 1
    	.NoLocationEdit("SI-WF5-No location verification")
    	.TapOnBack("SI-WF5-Tap on Back1")
		.SelectLocation(locationsData1.LocationName, "SI-WF5-Selecting no location")
		.LocationFirstItemCheck("SI-WF5-")
		.TapOnBack("SI-WF5-Tap on Back1")
		.SelectLocation(locationsData2.LocationName, "SI-WF5-Selecting no location")
		.LocationFirstItemCheck("SI-WF5-Verifying no loc item in another location")
		.TapOnBack("SI-WF5-Tap on Back1")
		
		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then skip assigning location and category. 
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI-WF6"},priority=5, description = "SI-WF6-OG + Skip Loc + Skip Category")
	public void SI_WF6_OG_SkipLocation_SkipCategory() {	


		LoginData loginData =LoginData.fetch("LoginData5");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF6-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF6-LoginPage")


		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF6-Clicked account")
		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI-WF6-FirstAccountSelect")
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF6-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF6-Skip1 Tapped")
		.TapOrderGuide("SI-WF6-OG Selected")
		.tapContinue("SI-WF6-Tapped Continue1")

		.TapOnDOThisLater("SI-WF6-Do this Later for locations Tapped")
		.TapOnSkip("SI-WF6-Skip3 Tapped")
		.TapOnDOThisLater("SI-WF6-Do this Later for category Tapped")
		.TapTakeHome("SI-WF6-Cotinue2 Tapped") 
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF6-Selected track inventory")

		;
	}


	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default locations and skip category.
	 * Validating users cache is not cleared when logout after setting up inventory.  
	 * Validating Track Inventory displayed after setting up inventory.
	 * Validating location is created on Track Inventory and adding items to that location by product catalog addition.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI-WF7"},priority=4, description = "SI-WF7-OG+Default loc + Skip Category")
	public void SI_WF7_OG_DefaultLocation_SkipCategory() {
		
		LoginData loginData =LoginData.fetch("LoginData8");	  
		SearchData searchData=SearchData.fetch("SearchData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF7-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF7-Login")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF7-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI-WF7-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF7-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF7-Skip1 Tapped")
		.TapOrderGuide("SI-WF7-OG Selected")
		.tapContinue("SI-WF7-Tapped Continue1")


		._atLocationsPage()
		.DefaultLocation("SI-WF7-Tapped Custom location")
		.tapContinue("SI-WF7-Tapped Continue2")

		._atSetupInventoryPage() 
		.TapOnDOThisLater("SI-WF7-TapOnDOThisLater Tapped")
		.TapTakeHome("SI-WF7-Tapped Continue3") 


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF7-Selected track inventory")
		._atLocationsPage()
		.TapOnBack("SI-WF7-tapped on back")

		._atHomePage()
		.HamburgerMenu("SI-WF7-tapped hamburger")
		.HamMenu_Logout("SI-WF7-tapped logout")

		._atLoginPage()
		.signIn(loginData.UserName, loginData.Password,"SI-WF7-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF7-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI-WF7-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF7-Selected track inventory")


		._atLocationsPage()
		.TapAddLocation("SI-WF7-Tapped ADD")
		.AddLocationName(locationsData.LocationName, "SI-WF7-Enter location name")
		.AddLocationCooler("SI-WF7-Tapped Cooler")
		.TapOnDone("SI-WF7-Tapped Done")
		.TapOnBack("SI-WF7-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "SI-WF7-Verifing AddedLocation")
		.SelectLocation(locationsData.LocationName, "SI-WF7-Selecting AddedLocation")
		._atLocationsPage()
		.TapAddLocation("SI-WF7-Tapped ADD")
		._atSetupInventoryPage()
		.SearchItem(searchData.keyword, "SI-WF7-Search item")
		.SelectItemFrom_Catalog("SI-WF7-Selected item from OG")
		.TapOnDone("SI-WF7-Done")
		.verifySearchItemsOnSetupInv("SI-WF7-Verify item selected")
		.TapOnDone("SI-WF7-Tapped Done")
		._atSetupInventoryPage()
		.verifySearchItemsOnSetupInv("SI-WF7-Verify item selected")
		;

	}
	
	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then skip location and assigning to Default category.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI-WF8"},priority=6, description = "SI-WF8-OG + Skip Loc + Default Category")
	public void SI_WF8_OG_SkipLocation_DefaultCategory() {

		LoginData loginData =LoginData.fetch("LoginData1");	 



		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF8-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF8-LoginPage")


		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF8-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI-WF8-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF8-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF8-Skip1 Tapped")
		.TapOrderGuide("SI-WF8-OG Selected")
		.tapContinue("SI-WF8-Tapped Continue1")

		.TapOnDOThisLater("SI-WF8-Do this Later for locations Tapped")
		.TapOnSkip("SI-WF8-Skip3 Tapped") 

		._atCategoryPage()
		.defaultCategories("SI-WF8-Tapped Default category")
		.tapComplete("SI-WF8-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF8-Tapped TakeHome")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF8-Selected track inventory")


		;
	}		


	
	
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign those items to Default  location and default category.
	 * Validating Default categories are listed on Expense categories page 
	 * Prerequisite:Normal/MA User with MyList.
	 */
	@Test(groups={"SI-WF19"},priority=17, description = "SI-WF19-Custom List + default Loc + default Category ")
	public void SI_WF19_CustomList_defaultLoc_defaultcategory() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF19-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF19-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF19-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI-WF19-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF19-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF19-Skip1 Tapped")

		._atListPage()
		.TapCustomList("SI-WF19-custom list Selected")
		.tapContinue("SI-WF19-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF19-select list")
		.TapOnNext("SI-WF19-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI-WF19-Tapped Custom location")
		.tapContinue("SI-WF19-Tapped Continue")


		._atCategoryPage()
		.defaultCategories("SI-WF19-Tapped Default category")
		.tapComplete("SI-WF19-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF19-Tapped takeme home")   


		._atInventoryToolPage()
		.InvTools_Category("SI-WF19-Tapped Categories")
		._atCategoryPage()
		.VerifyDefaultCategoryList("SI-WF19-Verified default Categories List")

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
	@Test(groups={"SI-WF20"},priority=18, description = "SI-WF20-Custom List + Custom Loc + Custom Category ")
	public void SI_WF20_CustomList_CustomLoc_Customcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF20-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF20-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF20-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI-WF20-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF20-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF20-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF20-custom list Selected")
		.tapContinue("SI-WF20-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF20-select list")
		.TapOnNext("SI-WF20-tapped next")


		._atLocationsPage()
		.CustomLocation("SI-WF20-Tapped Custom location")
		.tapContinue("SI-WF20-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI-WF20-Enter location name")
		.AddLocations1_TypeDry("SI-WF20-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("SI-WF20-Tapped Dry2")
		.TapOnNext("SI-WF20-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI-WF20-Selected Multiple items")
		.TapOnNext("SI-WF20-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI-WF20-Selected Multiple items")
		.TapOnDone("SI-WF20-Tapped Done1")

		._atCategoryPage()
		.CustomCategories("SI-WF20-Custom Categories Tapped")
		.tapContinue("SI-WF20-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF20-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF20-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF20-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF20-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI-WF20-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF20-Tapped Done2")

		.TapTakeHome("SI-WF20-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF20-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF20-select added location")
		.ItemVerifyOnLocation1("SI-WF20-Item verification")
		.SyscoCategoryIdentify("SI-WF20-Category Identify on location1")
		._atCategoryPage()
		.VerifyCustomListItemsCustomCategoryLocation1(categoryData.Name,"SI-WF20-Category verification on location1")
		._atLocationsPage()
		.VerifyCustomListItemsCustomLocation(locationsData1.LocationName, "SI-WF20-Location1 verification")
		.TapOnDone("SI - WF 1-TC1-Tapped Done")
		.SelectLocation(locationsData2.LocationName, "SI-WF20-select added location")
		.ItemVerifyOnLocation2("SI-WF20-Item verification")
		.SyscoCategoryIdentify("SI-WF20-Category Identify on location2")
		._atCategoryPage()
		.VerifyCustomListItemsCustomCategoryLocation2(categoryData.Name1,"SI-WF20-Category verification on location2")
		._atLocationsPage()
		.VerifyCustomListItemsCustomLocation(locationsData2.LocationName, "SI-WF20-Location2 verification")
		.TapOnDone("SI-WF20-Tapped Done")      

		//deleting location&category and checking items in nolocation
		.TapOnBack("SI-WF20-Tapped Back")
		._atInventoryToolPage()
		.InvTools_Locations("SI-WF20-Tapped Locations")
		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF20-Selecting Location1")
		.TapOnDeleteLocation("SI-WF20-Tapped Delete")
		.TapOnYesDelete("SI-WF20-Deleting AddedLocation")
		.VerifyCancelledLocationList(locationsData1.LocationName, "SI-WF20-Verifing AddedLocation")
		.TapOnBack("SI-WF20-Tapped Back")
		._atInventoryToolPage()
		.InvTools_Category("SI-WF20-Tapped Category")
		._atCategoryPage()
		.SelectCategory(categoryData.Name1, "SI-WF20-Selecting Category")
		.TapOnDeleteCategory("SI-WF20-Deleting Category")
		.TapOnYesDelete("SI-WF20-Tap on Yes Delete")
		.VerifyDeletedCategoryList(categoryData.Name1, "SI-WF20-Verifying Deleted category list")
		.TapOnBack("SI-WF20-Tapped Back")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF20-Tapped Track Inventory")
		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF20-Selecting nolocation")
		.ItemVerifyOnLocation1("SI-WF20-Item verification in no location")	
	//	.VerifyCountOfItemsInLocation(locationsData.LocationName, "SI-WF20-Verifying count of items in location1")
		.VerifyDeletedItemsCategory(locationsData.LocationName,"SI-WF20-Item category verification in nolocation")  
		;
	}	
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign few items to multiple  locations and Custom category.
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI-WF21"},priority=19, description = "SI-WF21-Custom List + Custom Loc + Custom Category")
	public void SI_WF21_CustomList_CustomLoc_Customcategory_FewItems() {	

		LoginData loginData =LoginData.fetch("LoginData13");
		ListData listData=ListData.fetch("ListData");  
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF21-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF21-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF21-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI-WF21-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF21-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF21-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF21-custom list Selected")
		.tapContinue("SI-WF21-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF21-select list")
		.TapOnNext("SI-WF21-tapped next")



		._atLocationsPage()
		.CustomLocation("SI-WF21-Tapped Custom location")
		.tapContinue("SI-WF21-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI-WF21-Enter location name")
		.AddLocations1_TypeDry("SI-WF21-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("SI-WF21-Tapped Dry2")
		.TapOnNext("SI-WF21-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI-WF21-Selected Multiple items")
		.TapOnNext("SI-WF21-Tapped Next2")
		.selectMultipleItemsFromLocation2("SI-WF21-Selected Multiple items")
		.selectMultipleItemsFromLocation2("SI-WF21-Selected Multiple items")
		.TapOnDone("SI-WF21-Tapped Done1")


		._atCategoryPage()
		.CustomCategories("SI-WF21-Custom Categories Tapped")
		.tapContinue("SI-WF21-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF21-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF21-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF21-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF21-Tapped Next4")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF21-Tapped Done2")

		.TapTakeHome("SI-WF21-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF21-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF21-select added location")
		.ItemVerifyOnLocation1("SI-WF21-Item verification")
		.TapOnDone("SI-WF21-Tapped Done")
		.SelectLocation(locationsData.LocationName, "SI-WF21-select added location")
		.ItemVerifyOnLocation2("SI-WF21-Item verification")
		.TapOnDone("SI-WF21-Tapped Done")    

		;
	}	




	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to Default  locations and Custom category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI-WF22"},priority=20, description = "SI-WF22-Custom List + Default Loc + custom Category")
	public void SI_WF22_CustomList_DefaultLoc_Customcategory() {	

		LoginData loginData =LoginData.fetch("LoginData14");
		ListData listData=ListData.fetch("ListData");

		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF22-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF22-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF22-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI-WF22-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF22-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF22-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF22-custom list Selected")
		.tapContinue("SI-WF22-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF22-select list")
		.TapOnNext("SI-WF22-tapped next")


		._atLocationsPage()
		.DefaultLocation("SI-WF22-Tapped Custom location")
		.tapContinue("SI-WF22-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF22-Skip1 Tapped")

		._atCategoryPage()

		.CustomCategories("SI-WF22-Custom Categories Tapped")
		.tapContinue("SI-WF22-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF22-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF22-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF22-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF22-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI-WF22-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF22-Tapped Done2")

		.TapTakeHome("SI-WF22-Tapped Continue3")   


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF22-Selected track inventory")


		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to multiple  locations and default category.
	 * Validating items are displayed on corresponding locations assigned
	 * Validating category displayed on item section on locations page is same as assigned ones.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI-WF23"},priority=21, description = "SI-WF23-Custom List + Custom Loc + default Category ")
	public void SI_WF23_CustomList_CustomLoc_defaultcategory() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData4");   //list with semicategorized items

		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData3 =LocationsData.fetch("LocatiosData4");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF23-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF23-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF23-Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI-WF23-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF23-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF23-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF23-custom list Selected")
		.tapContinue("SI-WF23-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF23-select list")
		.TapOnNext("SI-WF23-tapped next")




		._atLocationsPage()
		.CustomLocation("SI-WF23-Tapped Custom location")
		.tapContinue("SI-WF23-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI-WF23-Enter location name")
		.AddLocations1_TypeDry("SI-WF23-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("SI-WF23-Tapped Dry2")
		.TapOnNext("SI-WF23-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI-WF23-Selected Multiple items")
		.TapOnNext("SI-WF23-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI-WF23-Selected Multiple items")
		.TapOnDone("SI-WF23-Tapped Done1")

		._atCategoryPage()
		.defaultCategories("SI-WF23-Tapped Default category")
		.tapComplete("SI-WF23-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF23-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF23-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF23-select added location")
		.ItemVerifyOnLocation1("SI-WF23-Item verification in location1")
		.SyscoCategoryIdentify("SI-WF23-Category Identification in location1")
		._atCategoryPage()
		.VerifyCustomListItemsDefaultCategoryLocation1("SI-WF23-Verifying default categories in location1")
		.TapOnDone("SI-WF23-Tapped Done")
		._atLocationsPage()
		.SelectLocation(locationsData2.LocationName, "SI-WF23-select added location")
		.ItemVerifyOnLocation2("SI-WF23-Item verification in location2")
		.SyscoCategoryIdentify("SI-WF23-Category Identification in location1")
		._atCategoryPage()
		.VerifyCustomListItemsDefaultCategoryLocation2("SI-WF23-TC1-Verifying default categories in location2")
		
		
		
		.TapOnDone("SI-WF23-Tapped Done")
		//checking INV_248,249 scenario 3
		._atLocationsPage()
		.SelectLocation(locationsData3.LocationName, "SI-WF23-Selecting no location")
		.CustomLocItemsCheckInNoLocation("SI-WF23-Item verification in no location")
		.NoLocationTextCheck(locationsData3.LocationName,"SI-WF23-No location text verification")
		        
	    //checking INV_250,251 scenario 3	
		.NoLocationEdit("SI-WF23-No location verification")
		.TapOnBack("SI-WF23-Tap on Back")
		.SelectLocation(locationsData1.LocationName, "SI-WF23-Selecting no location")
		.LocationFirstItemCheck("SI-WF23-")
		.TapOnBack("SI-WF23-Tap on Back")
		.SelectLocation(locationsData2.LocationName, "SI-WF23-Selecting no location")
		.LocationFirstItemCheck("SI-WF23-Verifying no loc item in another location")
		.TapOnBack("SI-WF23-Tap on Back1")
		
		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items by skipping locations and category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI-WF24"},priority=22, description = "SI-WF24-Custom List + Skip location+ Skip Category")
	public void SI_WF24_CustomList_SkipLoc_Skipcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF24-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF24-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF24-Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI-WF24-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF24-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF24-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF24-custom list Selected")
		.tapContinue("SI-WF24-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF24-select list")
		.TapOnNext("SI-WF24-tapped next")


		._atSetupInventoryPage()
		.TapOnDOThisLater("SI-WF24-TapOnDOThisLater Tapped")
		.TapOnSkip("SI-WF24-Skip3 Tapped") 

		.TapOnDOThisLater("SI - WF 24 TC1-TapOnDOThisLater Tapped")

		.tapContinue("SI-WF24-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF24-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF24-select added location")
		.TapOnDone("SI-WF24-Tapped Done")
		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items to Default  locations and skip category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI-WF25"},priority=23, description = "SI-WF25-Custom List+Default loc + Skip Category ")
	public void SI_WF25_CustomList_DefaultLoc_Skipcategory() {	

		LoginData loginData =LoginData.fetch("LoginData13");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF25-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF25-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF25-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI-WF25-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF25-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")


		._atListPage()
		.TapCustomList("SI-WF25-custom list Selected")
		.tapContinue("SI-WF25-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF25-select list")
		.TapOnNext("SI-WF25-tapped next")



		._atLocationsPage()
		.DefaultLocation("SI-WF25-Tapped Custom location")
		.tapContinue("SI-WF25-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("SI-WF25-STapOnDOThisLater Tapped")
		.TapTakeHome("SI-WF25-Tapped Continue3")    

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF25-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF25-select added location")
		.TapOnDone("SI-WF25-Tapped Done")
		;

	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList and then assign items by skipping locations and default category.
	 * Prerequisite:Normal/MA User with MyList with 6 items.
	 * 
	 */
	@Test(groups={"SI-WF26"},priority=24, description = "SI-WF26-Custom List+skip location + default category")
	public void SI_WF26_CustomList_SkipLoc_defaultcategory() {	

		LoginData loginData =LoginData.fetch("LoginData14");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF26-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF26-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF26-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI-WF26-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF26-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF26-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF26-custom list Selected")
		.tapContinue("SI-WF26-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF26-select list")
		.TapOnNext("SI-WF26-tapped next")


		._atSetupInventoryPage()
		.TapOnDOThisLater("SI-WF26-TapOnDOThisLater Tapped")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF26-Skip1 Tapped")

		._atCategoryPage()
		.defaultCategories("SI-WF26-Tapped Custom category")
		.tapComplete("SI-WF26-Tapped Complete")
		.tapContinue("SI-WF26-Tapped Continue")


		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF26-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF26-select added location")
		.TapOnDone("SI-WF26-Tapped Done")
		;

	}

	/*
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to Default category.
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
	 * 
	 */
	@Test(groups={"SI-WF27"},priority=25, description = "SI-WF27-Custom List + Select Multiple List +List Names+Default Category")
	public void SI_WF27_CustomList_MultipleList_ListNames_DefaultCat() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");


		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF27-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF27-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF27-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI-WF27-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF27-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI - WF 24-TC1-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF27-custom list Selected")
		.tapContinue("SI-WF27-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF27-select list")
		.SelectListwithItems(listData1.ListName, "SI-WF27-select list")
		.TapOnNext("SI-WF27-tapped next")



		._atLocationsPage()
		.ListNames("SI-WF27-Tapped Custom location")
		.tapContinue("SI-WF27-Tapped Continue")


		._atCategoryPage()
		.defaultCategories("SI-WF27-Tapped Default category")
		.tapComplete("SI-WF27-Tapped Complete")

		._atSetupInventoryPage() 
		.TapTakeHome("SI-WF27-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF27-Selected track inventory")
		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI-WF27-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI-WF27-Item verification")
		.TapOnDone("SI-WF27-Tapped Done")
		.SelectLocation(listData1.ListName, "SI-WF27-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI-WF27-Item verification")
		.TapOnDone("SI-WF27-Tapped Done")      
		;

		;

	}

		/*
		 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to custom category.
		 * Validating items are displayed on corresponding locations assigned
		 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
		 * 
		 */
	@Test(groups={"SI-WF28"},priority=26, description = "SI-WF28-Custom List + Select Multiple List +List Names as location+custom Category")
	public void SI_WF28_CustomList_MultipleList_ListNames_Customcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");

		CategoryData categoryData=CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF28-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF28-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF28-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI-WF28-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF28-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF28-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF28-custom list Selected")
		.tapContinue("SI-WF28-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF28-select list")
		.SelectListwithItems(listData1.ListName, "SI-WF28-select list")
		.TapOnNext("SI-WF28-tapped next")



		._atLocationsPage()
		.ListNames("SI-WF28-Tapped List Names")
		.tapContinue("SI-WF28-Tapped Continue")


		._atCategoryPage()

		.CustomCategories("SI-WF28-Custom Categories Tapped")
		.tapContinue("SI-WF28-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF28-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF28-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF28-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF28-Tapped Next4")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF28-Tapped Done2")
		._atSetupInventoryPage() 
		.TapTakeHome("SI-WF28-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF28-Selected track inventory")
		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI-WF28-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI-WF28-Item verification")
		.TapOnDone("SI-WF28-Tapped Done")
		.SelectLocation(listData1.ListName, "SI-WF28-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI-WF28-Item verification")
		.TapOnDone("SI-WF28-Tapped Done")      
		;


	}	

		/*
		 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Default Cat .
		 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
		 * 
		 */
	@Test(groups={"SI-WF29"},priority=27, description = "SI-WF29-Custom List + Select single  List +Custom categories as location+Default Cat")
	public void SI_WF29_CustomListSingleList_CustomCategoryOnLocationsPage_defaultcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData");  //list with fully categorized items
		LocationsData locDataNoLoc=LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF29-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF29-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF29-Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI-WF29-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF29-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF29-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF29-custom list Selected")
		.tapContinue("SI-WF29-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF29-select list")
		.TapOnNext("SI-WF29-tapped next")



		._atLocationsPage()
		.CustomCategories("SI-WF29-Tapped Default category in Location Page")
		.tapContinue("SI-WF29-Tapped Continue2")

		._atCategoryPage()
		.defaultCategories("SI-WF29-Tapped Default category")
		.tapComplete("SI-WF29-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI-WF29-Tapped Continue3")   
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF29-Selected track inventory")

		//checking INV_248,249 scenario 5 INV_250,251 scenario 5
		._atLocationsPage()
		.SelectLocation(locDataNoLoc.LocationName, "SI-WF29-Selecting no location")
		.NoItemsCheckInNoLocation("SI-WF29-Item verification in no location")
				
		;
	}


		/*
		 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Custom Cat 
		 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
		 * 
		 */

	@Test(groups={"SI-WF30"},priority=28, description = "SI-WF30-Custom List + Select single  List +Custom Categories as location+Custom Cat")
	public void SI_WF30_CustomListSingleList_CustomCategoryOnLocationsPage_customcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData4");   //list with semicategorized items,both categorized and u
		LocationsData locationsData3 =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF30-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF30-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF30-Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI-WF30-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF30-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF30-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF30-custom list Selected")
		.tapContinue("SI-WF30-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF30-select list")
		.TapOnNext("SI-WF30-tapped next")



		._atLocationsPage()
		.CustomCategories("SI-WF30-Tapped Default category in Location Page")
		.tapContinue("SI-WF30-Tapped Continue2")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF30-Skip3 Tapped")

		._atCategoryPage()
		.CustomCategories("SI-WF30-Custom Categories Tapped")
		.tapContinue("SI-WF30-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF30-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF30-Tapped Next3")
		.selectMultipleItemsFromCategory1("SI-WF30-selectMultipleItemsFromCategory1")
		.TapOnNext("SI-WF30-Tapped Next4")
		.selectMultipleItemsFromCategory2("SI-WF30-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF30-Tapped Done2")

		.TapTakeHome("SI-WF30-Tapped Continue3")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF30-Selected track inventory")
		
		
		//checking INV_248,249 scenario 4
		._atLocationsPage()
		.SelectLocation(locationsData3.LocationName, "SI-WF30-Selecting no location")
		.UncategorizedItemsCheckInNoLocation(listData.UnCatPdt1,listData.UnCatPdt2,listData.UnCatPdt3,"SI-WF30-Item verification in no location")
		.NoLocationTextCheck(locationsData3.LocationName,"SI-WF30-No location text verification")
				        
		 //checking INV_250,251 scenario 4
		.NoLocationEdit("SI-WF30-No location verification")
		.TapOnBack("SI-WF30-Tap on Back")
		.SelectLocation(listData.CatName, "SI-WF23-Selecting no location")
		.LocationFirstItemCheck("SI-WF30-Verifying no loc item in another location")
		.TapOnBack("SI-WF30-Tap on Back")
		

		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then skipping Category 
	 * Validating items are displayed on corresponding locations assigned
	 * Prerequisite:Normal/MA User with MyList having 2 items each for List2,List3
	 * 
	 */
	@Test(groups={"SI-WF31"},priority=29, description = "SI-WF31-Custom List + Select Multiple List +List Names as location+skip Category")
	public void SI_WF31_CustomList_MultipleList_ListNames_Skipcategory() {	

		LoginData loginData =LoginData.fetch("LoginData12");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");


		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF31-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF31-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF31-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI-WF31-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF31-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF31-Skip2 Tapped")


		._atListPage()
		.TapCustomList("SI-WF31-custom list Selected")
		.tapContinue("SI-WF31-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF31-select list")
		.SelectListwithItems(listData1.ListName, "SI-WF31-select list")
		.TapOnNext("SI-WF31-tapped next")



		._atLocationsPage()
		.ListNames("SI-WF31-Tapped List Names")
		.tapContinue("SI-WF31-Tapped Continue")

		._atSetupInventoryPage()

		.TapOnDOThisLater("SI-WF31-STapOnDOThisLater Tapped")

		._atSetupInventoryPage() 
		.TapTakeHome("SI-WF31-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF31-Selected track inventory")
		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI-WF31-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI-WF31-Item verification")
		.TapOnDone("SI-WF31-Tapped Done")
		.SelectLocation(listData1.ListName, "SI-WF31-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI-WF31-Item verification")
		.TapOnDone("SI-WF31-Tapped Done")      
		;



	}
	/*
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and then skipping Category 
	 * Prerequisite:Normal/MA User with MyList having 6 items 
	 * 
	 */
	@Test(groups={"SI-WF32"},priority=30, description = "SI-WF32-Custom List + Select single  List +Custom categories as location+Skip Category")
	public void SI_WF32_CustomList_SingleList_CustomCatLoc_Skipcategory() {	

		LoginData loginData =LoginData.fetch("LoginData11");
		ListData listData=ListData.fetch("ListData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF32-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF32-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF32-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI-WF32-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF32-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF32-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF32-custom list Selected")
		.tapContinue("SI-WF32-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF32-select list")
		.TapOnNext("SI-WF32-tapped next")



		._atLocationsPage()
		.CustomCategories("SI-WF32-Tapped Custom location")
		.tapContinue("SI-WF32-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("SI-WF32-STapOnDOThisLater Tapped")


		.TapTakeHome("SI-WF32-Tapped take me home")      

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF32-Selected track inventory")


		;

	}

	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Default locations and Suggested category.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI-WF33"},priority=31, description = "SI-WF33-OG + Default Loc + Suggested Category")
	public void SI_WF33_OG_DefaultLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData4");	  
		LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		LocationsData locDataNoLoc=LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF33-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF33-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF33-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI-WF33-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF33-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF33-Skip1 Tapped")
		.TapOrderGuide("SI-WF33-OG Selected")
		.tapContinue("SI-WF33-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("SI-WF33-Tapped Custom location")
		.tapContinue("SI-WF33-Tapped Continue")


		._atCategoryPage()
		.SuggestedCategories("SI-WF33-SuggestedCategories Tapped")
		.tapContinue("SI-WF33-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF33-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF33-Selected track inventory")
		
		._atLocationsPage()
		.VerifyOrderOfLocations(locDataCooler.LocationName, locDataFreezer.LocationName, locDataDry.LocationName, locDataNoLoc.LocationName, "SI-WF33-Verified order of locations")
		

		;



	}

	/*
	 * Validating user is able to setup inventory by adding items from OrderGuide and then assign those items to Custom locations and Suggested category.
	 * Validating items are displayed on corresponding locations assigned
	 * Validating suggested categories are displayed for each item on Track Inv
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI-WF34"},priority=32, description = "SI-WF34-OG + Custom Loc + Suggested Category")
	public void SI_WF34_OG_CustomLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");	  
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF34-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF34-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF34-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI-WF34-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF34-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF34-Skip1 Tapped")
		.TapOrderGuide("SI-WF34-OG Selected")
		.tapContinue("SI-WF34-Tapped Continue")

		._atLocationsPage()
		.CustomLocation("SI-WF34-Tapped Custom location")
		.tapContinue("SI-WF34-Tapped Continue2")

		.EnterLocationName(locationsData1.LocationName,"SI-WF34-Enter location name")
		.AddLocations1_TypeDry("SI-WF34-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("SI-WF34-Tapped Dry2")
		.TapOnNext("SI-WF34-Tapped Next1")

		.selectMultipleItemsFromLocation1("SI-WF34-Selected Multiple items")
		.TapOnNext("SI-WF34-Tapped Next2")

		.selectMultipleItemsFromLocation2("SI-WF34-Selected Multiple items")
		.TapOnDone("SI-WF34-Tapped Done1")


		._atCategoryPage()
		.SuggestedCategories("SI-WF34-SuggestedCategories Tapped")
		.tapContinue("SI-WF34-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF34-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI- WF 34-TC1-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF34-select added location1")
		.ItemVerifyOnLocation1("SI-WF34-Verify item inside location1")
		.SyscoCategoryIdentify("SI-WF34-Category identification for Syscoitems in location1")
		._atCategoryPage()
		.VerifyOGSyscoItemsSuggestedCategoryLocation1("SI-WF34-Category verification for Syscoitems in location1")
		.TapOnDone("SI-WF34-Tapped Done2")
		._atLocationsPage()
		.SelectLocation(locationsData2.LocationName, "SI-WF34-select added location2")
		.ItemVerifyOnLocation2( "SI-WF34-Verify item inside location2")
		.SyscoCategoryIdentify("SI-WF34-Category identification for Syscoitems in location2")
		._atCategoryPage()
		.VerifyOGSyscoItemsSuggestedCategoryLocation1("SI-WF34-Category verification for Syscoitems in location2")
		.TapOnDone("SI-WF34-Tapped Done3")

		;


	}

	/*
	 * Validating user is able to setup inventory by adding items from CustomList(single list) and then assign items to custom category as location and Suggested Cat .
	 * Prerequisite:Normal/MA User with MyList having 6 items and items should be categorized
	 * 
	 */
	@Test(groups={"SI-WF35"},priority=33, description = "SI-WF35-Custom List + Select single  List +Custom Categories as location+Suggested Cat")
	public void SI_WF35_CustomListSingleList_CustomCategoryOnLocationsPage_suggestedcategory() {

		LoginData loginData =LoginData.fetch("LoginData14");
		ListData listData=ListData.fetch("ListData");


		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF35-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF35-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF35-Clicked account")
		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI-WF35-FirstAccountSelect")
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF35-SetupInventoryTap")
		._atSetupInventoryPage()
		.TapOnSkip("SI-WF35-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF35-custom list Selected")
		.tapContinue("SI-WF35-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF35-select list")
		.TapOnNext("SI-WF35-tapped next")

		._atLocationsPage()
		.CustomCategories("SI-WF35-Tapped Default category in Location Page")
		.tapContinue("SI-WF35-Tapped Continue2")

		._atCategoryPage()
		.SuggestedCategories("SI-WF35-SuggestedCategories Tapped")
		.tapContinue("SI-WF35-Tapped Continue3") 
		._atSetupInventoryPage()
		.TapTakeHome("SI-WF35-Tapped Take me Home")
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF35-Selected track inventory")

		;

	}


	/*
	 * Validating user is able to setup inventory by adding items from CustomList(Multiple list) and then assign items to Suggested Category .
	 * Validating suggested category can be edited on product detail page and verifying.
	 * Prerequisite:Normal/MA User with MyList having  2 items each for List2,List3
	 * 
	 */
	@Test(groups={"SI-WF36"},priority=34, description = "SI-WF36-Custom List + Select Multiple List +List Names+Suggested Category")
	public void SI_WF36_CustomList_MultipleList_ListNames_SuggestedCat() {

		LoginData loginData =LoginData.fetch("LoginData13");
		ListData listData=ListData.fetch("ListData2");
		ListData listData1=ListData.fetch("ListData3");


		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF36-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI-WF36-LoginPage")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF36-Clicked account")
		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI-WF36-FirstAccountSelect")
		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF36-SetupInventoryTap")
		._atSetupInventoryPage()
		.TapOnSkip("SI-WF36-Skip2 Tapped")

		._atListPage()
		.TapCustomList("SI-WF36-custom list Selected")
		.tapContinue("SI-WF36-Tapped Continue1")
		.SelectListwithItems(listData.ListName, "SI-WF36-select list")
		.SelectListwithItems(listData1.ListName, "SI-WF36-select list")
		.TapOnNext("SI-WF36-tapped next")

		._atLocationsPage()
		.ListNames("SI-WF36-Tapped Custom location")
		.tapContinue("SI-WF36-Tapped Continue")

		._atCategoryPage()
		.SuggestedCategories("SI-WF36-SuggestedCategories Tapped")
		.tapContinue("SI-WF36-Tapped Continue1")
		._atSetupInventoryPage() 
		.TapTakeHome("SI-WF36-Tapped take me home")      
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF36-Selected track inventory")
		._atLocationsPage()
		.SelectLocation(listData.ListName, "SI-WF36-select added location")
		.VerifyListItemsOnLocation(listData.Pdt1,listData.Pdt2,"SI-WF36-Item verification")
		.TapOnDone("SI-WF36-Tapped Done")
		.SelectLocation(listData1.ListName, "SI-WF36-select added location")
		.VerifyListItemsOnLocation(listData1.Pdt1,listData1.Pdt2,"SI-WF36-Item verification")

		._atSetupInventoryPage()
		.VerifyProductID_Location("SI-WF36-ProductId")

		//changing category and verification
		._atCategoryPage()
		.VerifySuggestedCategory("SI-WF36-Verified Category")
		._atLocationsPage()
		.SyscoProductSelect("SI-WF36-Select Product")
		.TapOnEdit("SI-WF36-Tapped Edit")
		.AddCategory_AddProductDetailsPage("SI-WF36-CategorySelect")
		._atCategoryPage()
		.TapAnySuggestedCategory("SI-WF36- tapped on a suggested category")
		.TapOnDone("SI-WF36-Tapped Done")
		.TapOnBack("SI-WF36-Tapped Back")
		.VerifySelectedSuggestedCategory("SI-WF36-Verified Category")					
		.TapOnDone("SI-WF36-Tapped Done")      


		;


	}

	



	/*
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding items to location and verifying quantity updation.
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"TI-WF1-WF2"},priority=37, description = "TI-WF1-WF2-Select a location from trackinventory updating quantity and uom")
	public void TI_WF1_WF2_Location_Item_UOMQuantity() {	


		LoginData loginData =LoginData.fetch("LoginData12");	
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
		.Second_AccountSelection(loginData.UserName,"TI-WF1-WF2-ThirdAccountSelect")


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

		.SelectLocation(locationsData1.LocationName, "TI-WF1-WF2-Selecting AddedLocation")
		.TapAddLocation("TI-WF1-WF2-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("TI-WF1-WF2-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "TI-WF1-WF2-NonSyscoItem details entered")
		.TapOnDone("TI-WF1-WF2-Tapped Done")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"TI-WF1-WF2-Verify item selected")


		._atLocationsPage()
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
	@Test(groups={"MIL-WF1-WF4"},priority=38, description = "MIL-WF1-WF4-Creating Location in trackinventory and add items from multile lists to location")
	public void MIL_WF1_WF4_Location_AddItems() {	

		LoginData loginData =LoginData.fetch("LoginData2");	  
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
		.Third_AccountSelection(loginData.UserName,"MIL-WF1-WF4-FirstAccountSelect")


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
		.NonSysco_Prompt(loginData.UserName,"MIL-WF1-WF4-verify NonSysco")
		
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF1-WF4-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL-WF1-WF4-select supplier")
		._atVendorPage()
		.Add_Supplier("MIL-WF1-WF4-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF1-WF4-AddVendorDetails")
		.TapOnDone("MIL-WF1-WF4-Done")
		.TapOnBack("MIL-WF1-WF4-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF1-WF4-SupplierSelect")
		.TapOnDone("MIL-WF1-WF4-Done")


		//prepitem addition
		._atLocationsPage()   
		.TapAddLocation("MIL-WF1-WF4-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF1-WF4-Tapped NonSysco")
		.Prep_Prompt("MIL-WF1-WF4-verify Prep")   ///change to prep item
		
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF1-WF4-NonSyscoItem details entered")
		.TapOnDone("MIL-WF1-WF4-Tapped Done")


		//product catalog addition
		._atLocationsPage()
		.TapAddLocation("MIL - WF 1 WF 4-TC2-Tapped ADD") 
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
		.verifyOGItemsOnSetupInv("MIL-WF1-WF4-Verify item selected") 	
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
	@Test(groups={"MIL-WF2"},priority=39, description = "MIL-WF2-Selecing a location, adding same items to multiple location")
	public void MIL_WF2_Location_AddItems__MultipleLocation() {	


		LoginData loginData =LoginData.fetch("LoginData3");
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
		.verifyLoginPage("MIL-WF2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF2-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF2-Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"MIL-WF2-FirstAccountSelect")

		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF2-Skip1 Tapped")
		.TapOrderGuide("MIL-WF2-OG Selected")
		.tapContinue("MIL-WF2-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("MIL-WF2-Tapped Custom location")
		.tapContinue("MIL-WF2-Tapped Continue")


		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF2-Tapped do this later")
		.TapTakeHome("MIL-WF2-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF2-TrackinventoryTap")

		//creating a location1       
		._atLocationsPage()
		.TapAddLocation("MIL-WF2-Tapped ADD1")
		.AddLocationName(locationsData.LocationName,"MIL-WF2-Enter location1 name")
		.AddLocationCooler("MIL-WF2-Tapped Cooler")
		.TapOnDone("MIL-WF2-Tapped Done")
		.TapOnBack("MIL-WF2-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF2-Verifing Added Location1")

		//nonsysco item addition to location1
		.SelectLocation(locationsData.LocationName, "MIL-WF2-Selecting Added Location1")
		.TapAddLocation("MIL-WF2-Tapped ADD2")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MIL-WF2-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF2-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL-WF2-select supplier")

		._atVendorPage()
		.Add_Supplier("MIL-WF2-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF2-AddVendorDetails")
		.TapOnDone("MIL-WF2-Done")
		.TapOnBack("MIL-WF2-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF2-SupplierSelect")

		//same nonsysco item addition to location2 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MIL-WF2-Select Add/Select location option")
		.TapAddLocation("MIL-WF2-Tapped ADD3")
		.AddLocationName(locationsData1.LocationName,"MIL-WF2-Enter location2 name")
		.AddLocationCooler("MIL-WF2-Tapped Cooler")
		.TapOnDone("MIL-WF2-Tapped Done")
		.TapOnBack("MIL-WF2-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL-WF2-Verifing Added Location2")

		.SelectLocation(locationsData1.LocationName, "MIL-WF2-Selecting Added Location2")
	//	.SelectLocation(locationsData.LocationName, "MIL-WF2-Selecting Added Location2")     //not preselected
		.LocationDoneSelection("MIL-WF2-Selecting Done")
		.TapOnDone("MIL-WF2-Tapped Done")

		//prep item addition to location1

		.TapAddLocation("MIL-WF2-Tapped ADD4")

		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF2-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF2-NonSyscoItem details entered")

		//same prep item addition to location3 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MIL-WF2-Select Add/Select location option")
		.TapAddLocation("MIL-WF2-Tapped ADD5")
		.AddLocationName(locationsData2.LocationName,"MIL-WF2-Enter location3 name")
		.AddLocationCooler("MIL-WF2-Tapped Cooler")
		.TapOnDone("MIL-WF2-Tapped Done")
		.TapOnBack("MIL-WF2-Tapped Back")
		.VerifyLocationList(locationsData2.LocationName, "MIL-WF2-Verifing Added Location3")

		.SelectLocation(locationsData2.LocationName, "MIL-WF2-Selecting Added Location3")
	//	.SelectLocation(locationsData.LocationName, "MIL-WF2-Selecting Added Location1") //xtra
		.LocationDoneSelection("MIL-WF2-Selecting Done")
		.TapOnDone("MIL-WF2-Tapped Done")

		//Verifications
		._atLocationsPage()
		.TapOnBack("MIL-WF2-Tapped back")
		.SelectLocation(locationsData1.LocationName, "MIL-WF2-Selecting Added Location2") 
		._atSetupInventoryPage()
		. verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF2-Verify nonsysco item selected in Location2")
		._atLocationsPage()
		.TapOnBack("MIL-WF2-Tapped Back")
		.SelectLocation(locationsData2.LocationName, "MIL-WF2-Selecting Added Location3")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF2-Verify prep item selected in Location3")

		._atLocationsPage()
		.ProductSelect(prepItemData.ProductName, "MIL-WF2-Selecting prep item")
		.TapOnEdit("MIL - WF2-TC1-Tap on edit")
		.PdtDetailPage_Location1_EnterQty(uomQuantityData.Quantity,locationsData2.LocationName, "MIL-WF2-Enter Qty frst location")
		.PdtDetailPage_Location2_EnterQty(uomQuantityData1.Quantity,locationsData.LocationName, "MIL-WF2-Enter Qty second location")
		.TapOnDone("MIL - WF2-TC1-tap on done")
		.TapOnBack("MIL - WF2-TC1-tap on back")
		.QuantityVerify(uomQuantityData.Quantity, "MIL - WF2-TC1-Quantity verify")


		._atLocationsPage()
		.TapOnBack("MIL-WF2-Tapped Back")
		.SelectLocation(locationsData.LocationName, "MIL-WF2-Selecting Added Location1")
		.QuantityVerify(uomQuantityData1.Quantity, "MIL -2-TC1-Quantity verify")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF2-Verify prep item selected in Location1")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF2-Verify nonsysco item selected in Location1")

		;
	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding OG items to location and searching items within location
	 * Validating count of items displayed for each location.
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"MIL-WF3"},priority=40, description = "MIL-WF3-Selecting a specific location in trackinventory and search for items within location")
	public void MIL_WF3_Location_SearchItems() {	

		LoginData loginData =LoginData.fetch("LoginData15");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		SearchData searchData=SearchData.fetch("SearchData");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		CategoryData categoryData=CategoryData.fetch("CategoryData");


		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF3-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF3-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF3-Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"MIL-WF3-FirstAccountSelect")


		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF3-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF3-Tapped Skip")
		/*.StartFromScratch("MIL-WF3-ScratchSelected")
		.tapContinue("MIL-WF3-Tapped Continue")
		.Scratch_AddItems("MIL-WF3-Tapped Add items")
		.AddItemFrom_OrderGuide("MIL-WF3-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("MIL-WF3-Selected item from OG")
		.verifyOGItemsOnSetupInv("MIL-WF3-Verify item selected")
		.TapOnDone("MIL-WF3-Tapped Done")*/
		.TapOrderGuide("MIL-WF3-OG Selected")
		.tapContinue("MIL-WF3-Tapped Continue")


		._atLocationsPage()
		.CustomLocation("MIL-WF3-Tapped Custom location")
		.tapContinue("MIL-WF3-Tapped Continue2")
		
		.EnterLocationName(locationsData1.LocationName,"MIL-WF3-Enter location name")
		.AddLocations1_TypeDry("MIL-WF3-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData2.LocationName)
		.AddLocations2_TypeDry("MIL-WF3-Tapped Dry2")
		.TapOnNext("MIL-WF3-Tapped Next1")
		
		._atSetupInventoryPage()
		.SearchItem(searchData.keyword1,"MIL-WF3-Search item")
		._atLocationsPage()
		.selectMultipleItemsFromLocation1("MIL-WF3-Selected Multiple items")
		._atSetupInventoryPage()
		.verifySearchedItems(searchData.keyword1,"MIL-WF3-Searched items verify")
		._atLocationsPage()
		.TapOnNext("MIL-WF3-Tapped Next2")

		.selectMultipleItemsFromLocation2("MIL-WF3-Selected Multiple items")
		.TapOnDone("MIL-WF3-Tapped Done1")
		
		._atCategoryPage()
		.CustomCategories("MIL-WF3-CustomCategories Tapped")
		.tapContinue("MIL-WF3-TC1-Tapped Continue3")
			
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "MIL-WF3-CreateTwoExpenseCategory")
		.TapOnNext("MIL-WF3-Tapped Next3")
		
		._atSetupInventoryPage()
		.SearchItem(searchData.keyword1,"MIL-WF3-Search item")
		._atCategoryPage()

		._atSetupInventoryPage()
		.verifySearchedItems(searchData.keyword1,"MIL-WF3-Searched items verify")
		._atCategoryPage()
		.TapOnNext("MIL-WF3-Tapped Next4")
		.selectMultipleItemsFromCategory2("MIL-WF3-selectMultipleItemsFromCategory2")
		._atSetupInventoryPage()
		.TapOnDone("MIL-WF3-TTapped Done2")
		.TapTakeHome("MIL-WF3-Tapped Continue4") 
		
		

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF3-TrackinventoryTap")


		._atLocationsPage()
		.TapAddLocation("MIL-WF3-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL-WF3-Enter location1 name")
		.AddLocationCooler("MIL-WF3-Tapped Cooler")
		.TapOnDone("MIL-WF3-Tapped Done")
		.TapOnBack("MIL-WF3-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF3-Verifing AddedLocation")
		.SelectLocation(locationsData.LocationName, "MIL-WF3-Selecting location1")

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
		.VerifyCountOfItemsInLocation(locationsData.LocationName, "MIL-WF3-Verifying count of items in location1")
		
		
		.SelectLocation(locationsData.LocationName, "MIL-WF3-Selecting location1")
		.TapAddLocation("MIL-WF3-Tapped ADD")
		._atSetupInventoryPage()
		.SearchItem(searchData.keyword2,"MIL-WF3-Search item")
		.verifyItemDescriptionSearch(searchData.keyword2, "MIL-WF3-Verified search with item description")
		.SelectItemFrom_Catalog("MIL-WF3-Selected item from catalog")
		.TapOnDone("MIL-WF3-Tapped Done4")

		.TapOnDone("MIL-WF3-Tapped Done4")
		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "MIL-WF3-Selecting location")
       ._atSetupInventoryPage()
		.SearchWord("MIL-WF3-Keyword searching")
		.verifyWordSearchItems("MIL-WF3-Verify word search")
		._atLocationsPage()
		.verifyUIAfterSearch("MIL-WF3-Verify after search")
		.TapOnBack("tapped on back")
		
		.SelectLocation(locationsData.LocationName, "MIL-WF3-Selecting location")
		.TapOnEdit("MIL-WF3-Tapped Edit")
		 ._atSetupInventoryPage()
		.verifyEditLocationPage("MIL-WF3-verify edit location page")
	
		
		;
	}




	/*
	 * Validating user is able to setup inventory.
	 * Validating creation of location on Track inventory,adding Non sysco item to location 
	 * Validating different locations can be assigned to same item through product detail page
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */
	@Test(groups={"MIL-WF5"},priority=41, description = "MIL-WF5-Selecting a location navigate to product and assiging  item  to diff location")
	public void MIL_WF5_Locations_ItemEdit_UpdateLocation() {	



		LoginData loginData =LoginData.fetch("LoginData5"); 
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");

		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF5-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF5-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF5-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"MIL-WF5-FirstAccountSelect")

		//setting up inventory
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF5-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF5-Skip1 Tapped")
		.TapOrderGuide("MIL-WF5-Selected OG")
		.tapContinue("MIL-WF5-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("MIL-WF5-Tapped Default location")
		.tapContinue("MIL-WF5-Tapped Continue")
		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF5-Tapped do this later")
		.TapTakeHome("MIL-WF5-Tapped take me home")  


		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF5-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MIL-WF5-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL-WF5-Enter location name")
		.AddLocationCooler("MIL-WF5-Tapped Cooler")
		.TapOnDone("MIL-WF5-Tapped Done")
		.TapOnBack("MIL-WF5-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF5-Verifing AddedLocation")
		//nonsyscoitem addition 
		.SelectLocation(locationsData.LocationName, "MIL-WF5-Selecting AddedLocation")
		.TapAddLocation("MIL-WF5-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MIL-WF5-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF5-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL-WF5-select supplier")

		._atVendorPage()
		.Add_Supplier("MIL-WF5-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF5-AddVendorDetails")
		.TapOnDone("MIL-WF5-Done")

		.TapOnBack("MIL-WF5-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF5-SupplierSelect")
		.TapOnDone("MIL-WF5-Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF5-Verify item selected")

		._atLocationsPage()
		.ProductSelect(nonSyscoItemData.ProductName, "MIL-WF5-Select Product")
		.TapOnEdit("MIL-WF5-Tapped Edit")
		.AddLocation_AddProductDetailsPage("MIL-WF5-Select Add/Select option")
		.TapAddLocation("MIL-WF5-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL-WF5-Enter location name")
		.AddLocationCooler("MIL-WF5-Tapped Cooler")
		.TapOnDone("MIL-WF5-Tapped Done")
		.TapOnBack("MIL-WF5-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL-WF5-Verifing AddedLocation")

		.SelectLocation(locationsData1.LocationName, "MIL-WF5-Selecting AddedLocation")
		.SelectLocation(locationsData.LocationName, "MIL-WF5-Selecting AddedLocation")   
		.LocationDoneSelection("MIL-WF5-Selecting Done")
		.TapOnDone("MIL-WF5-Tapped Done")

		.TapOnBack("MIL-WF5-Tapped Back")
		.TapOnBack("MIL-WF5-Tapped Back")

		.SelectLocation(locationsData.LocationName, "MIL-WF5-Selecting AddedLocation")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF5-Verify item selected")

		._atLocationsPage() 
		.TapOnBack("MIL-WF5-Tapped Back")
		.SelectLocation(locationsData1.LocationName, "MIL-WF5-Selecting AddedLocation")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF5-Verify item selected")


		;
	}




	/*
	 * Validating user is able to setup inventory.
	 * Validating Creating Location,Editing Location in Manage Locations and deleting location
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */
	@Test(groups={"MIL-WF6"},priority=42, description = "MIL-WF6-Creating Location,Editing Location in Manage Locations")
	public void MIL_WF6_Create_Edit_Delete_Locations() {	

		LoginData loginData =LoginData.fetch("LoginData1");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF6-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF6-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF6-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"MIL-WF6-FirstAccountSelect")


		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF6-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF6-Skip1 Tapped")
		.TapOrderGuide("MIL-WF6-OG Selected")
		.tapContinue("MIL-WF6-Tapped Continue")


		._atLocationsPage()
		.DefaultLocation("MIL-WF6-Tapped Custom location")
		.tapContinue("MIL-WF6-Tapped Continue")


		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF6-Tapped do this later")
		.TapTakeHome("MIL-WF6-Tapped Take me Home")


		._atInventoryToolPage()
		.InvTools_Locations("MIL-WF6-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MIL- WF 6-TC1-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL-WF6-Enter location name")
		.AddLocationCooler("MIL-WF6-Tapped Cooler")
		.TapOnDone("MIL-WF6-Tapped Done")
		.TapOnBack("MIL-WF6-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF6-Verifing AddedLocation")

		.TapAddLocation("MIL-WF6-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL-WF6-Enter location name")
		.AddLocationCooler("MIL-WF6-Tapped Cooler")
		
		.TapOnCancel("MIL-WF6-Tapped Cancel")
		.VerifyCancelledLocationList(locationsData1.LocationName, "MIL-WF6-Verifing CancelledLocation")
		.TapAddLocation("MIL-WF6-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL-WF6-Enter location name")
		.AddLocationCooler("MIL-WF6-Tapped Cooler")
		
		.TapOnDone("MIL-WF6-Tapped Done")
		.TapOnBack("MIL-WF6-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL-WF6-Verifing AddedLocation")

		.SelectLocation(locationsData.LocationName, "MIL-WF6-Selecting AddedLocation")
		.TapOnEdit("MIL-WF6-Editing AddedLocation")
		.AddLocationName(locationsData.EditLocation,"MIL-WF6-Enter location name")
		.AddLocationCooler("MIL-WF6-Tapped Cooler")
		.TapOnDone("MIL-WF6-Tapped Done")
		.TapOnBack("MIL-WF6-Tapped Back")
		.VerifyLocationList(locationsData.EditLocation, "MIL-WF6-Verifing AddedLocation")

		.SelectLocation(locationsData.EditLocation, "MIL-WF6-Selecting AddedLocation")
		.TapOnDeleteLocation("MIL-WF6-Tapped Delete")
		.TapOnYesDelete("MIL-WF6-Deleting AddedLocation")
		.VerifyCancelledLocationList(locationsData.EditLocation, "MIL-WF6-Verifing AddedLocation")



		;
	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating Creating Location and Deleting Items from location
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */
	@Test(groups={"MIL-WF7"},priority=43, description = "MIL-WF7-Track Inventory+Location+Edit+Delete Items from location")
	public void MIL_WF7_TrackInventory_Location_Edit_Delete_Items_location() {

		LoginData loginData =LoginData.fetch("LoginData12");	  
		LocationsData locationsData4 =LocationsData.fetch("LocationsData");
		LocationsData locationsData3 =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		LocationsData locationsData5 =LocationsData.fetch("LocatiosData4");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF7-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF7-LoginPage")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF7-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"MIL-WF7-FirstAccountSelect")

		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF7-SetupInventoryTap")
		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF7-Skip1 Tapped")
		.TapOrderGuide("MIL-WF7-OG Selected")
		.tapContinue("MIL-WF7-Tapped Continue")
		._atLocationsPage()
		.DefaultLocation("MIL-WF7-Tapped Custom location")
		.tapContinue("MIL-WF7-Tapped Continue")
		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF7-Tapped do this later")
		.TapTakeHome("MIL-WF7-Tapped TakeMeHome")

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF7-TrackinventoryTap")


		._atLocationsPage()
		.TapAddLocation("MIL-WF7-Tapped ADD")
		.AddLocationName(locationsData4.LocationName,"MIL-WF7-Enter location name")
		.AddLocationCooler("MIL-WF7-Tapped Cooler")
		.TapOnDone("MIL-WF7-Tapped Done")
		.TapOnBack("MIL-WF7-Tapped Back")
		.VerifyLocationList(locationsData4.LocationName, "MIL-WF7-Verifing AddedLocation")
		.SelectLocation(locationsData4.LocationName, "MIL-WF7-Selecting location")

		//og item addition
		._atLocationsPage()
		.TapAddLocation("MIL-WF7-Tapped ADD")
		.AddItemFrom_OrderGuide("MIL-WF7-Tapped Orderguide")
		._atSetupInventoryPage()
		.SelectMultipleItemsFrom_OrderGuide("MIL-WF7-Selected multiple items from OG")
		.TapOnDone("MIL-WF7-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF7-Verify items selected")  
		.TapOnDone("MIL-WF7-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("MIL-WF7-Verify items selected")  
		._atLocationsPage()
		.TapOnEdit("MIL-WF7-Tapped Edit")
		.DeleteItems("MIL-WF7-Deleting items in location")
		.TapOnDone("MIL-WF7-Tapped Done2")
		.TapOnYesDelete("MIL-WF7-confirming Deleting items")
		.VerifyDeleteItemsList("MIL-WF7-Verifying Deleted items list")	


		.TapOnBack("MIL-WF7-Tapped Back")
		//creating a location1       
		._atLocationsPage()
		.TapAddLocation("MIL-WF 2-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MIL-WF7-Enter location1 name")
		.AddLocationCooler("MIL-WF7-Tapped Cooler")
		.TapOnDone("MIL-WF7-Tapped Done")
		.TapOnBack("MIL-WF7-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MIL-WF7-Verifing Added Location1")

		//nonsysco item addition to location1
		.SelectLocation(locationsData1.LocationName, "MIL-WF7-Selecting Added Location1")
		.TapAddLocation("MIL-WF7-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MIL-WF7-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL-WF7-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MIL-WF7-select supplier")

		._atVendorPage()
		.Add_Supplier("MIL-WF 2-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL-WF7-AddVendorDetails")
		.TapOnDone("MIL-WF7-Done")
		.TapOnBack("MIL-WF7-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MIL-WF7-SupplierSelect")

		//same nonsysco item addition to location2 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MIL-WF7-Select Add/Select location option")
		.TapAddLocation("MIL-WF7-Tapped ADD")
		.AddLocationName(locationsData2.LocationName,"MIL-WF7-Enter location2 name")
		.AddLocationCooler("MIL-WF7-Tapped Cooler")
		.TapOnDone("MIL-WF7-Tapped Done")
		.TapOnBack("MIL-WF7-Tapped Back")
		.VerifyLocationList(locationsData2.LocationName, "MIL-WF7-Verifing Added Location2")
		.SelectLocation(locationsData2.LocationName, "MIL-WF7-Selecting Added Location3")
		.SelectLocation(locationsData1.LocationName, "MIL-WF7-Selecting Added Location2")
		.LocationDoneSelection("MIL-WF7-Selecting Done")
		.TapOnDone("MIL-WF7-Tapped Done")

		//location1 displayed with 1 non sysco item
		//prep item addition to location1

		.TapAddLocation("MIL-WF7-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF7-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF7-NonSyscoItem details entered")

		//same prep item addition to location3 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MIL-WF7-Select Add/Select location option")
		.TapAddLocation("MIL-WF7-Tapped ADD")
		.AddLocationName(locationsData3.LocationName,"MIL-WF7-Enter location3 name")
		.AddLocationCooler("MIL-WF7-Tapped Cooler")
		.TapOnDone("MIL-WF7-Tapped Done")
		.TapOnBack("MIL-WF7-Tapped Back")
		.VerifyLocationList(locationsData3.LocationName, "MIL-WF7-Verifing Added Location3")

		.SelectLocation(locationsData3.LocationName, "MIL-WF7-Selecting Added Location3")
		.SelectLocation(locationsData1.LocationName, "MIL-WF7-Selecting Added Location3")
		.LocationDoneSelection("MIL-WF7-Selecting Done")
		.TapOnDone("MIL-WF7-Tapped Done")
		// .TapOnDone("MIL-WF 2-Tapped Done")

		//location1 displayed with nonsysco and prep item
		//Verifications
		._atLocationsPage()
		.TapOnBack("MIL-WF7-Tapped back")

		.SelectLocation(locationsData1.LocationName, "MIL-WF7-Selecting Added Location2") 
		.TapOnBack("MIL-WF7-Tapped back")
		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF7-TrackinventoryTap")
		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "MIL-WF7-selected location1")
		.TapOnEdit("MIL-WF7-Tapped Edit")
		.DeleteItems("MIL-WF7-Deleting items in location")
		.TapOnDone("MIL-WF7-Tapped Done2")
		.TapOnYesDelete("MIL-WF7-confirming Deleting items")
		//.VerifyDeleteItemsList("MIL-WF7-Verifying Deleted items list")
		.TapOnBack("MIL-WF7-Tapped back")
		.SelectLocation(locationsData3.LocationName, "MIL-WF7-selected location1")
		//verify item deleted locn
		.TapOnBack("MIL-WF7-Tapped back")
		.TapOnBack("MIL-WF7-Tapped back")
		//inv 254 
		._atInventoryToolPage()
		.InvTools_Locations("MIL-WF7-Tapped Locations")
		._atLocationsPage()
		.SelectLocation(locationsData3.LocationName, "MIL-WF7-selected location1")
		.TapOnEdit("MIL-WF7-Tapped Edit")
		.TapOnDeleteLocation("MIL-WF7-Tapped delete location")
		.TapOnYesDelete("MIL-WF7-confirming Deleting items")
		.SelectLocation(locationsData5.LocationName,"MIL-WF7-Select no location")
		.ViewItemsOnLocation("MIL-WF7-view items on Location1")
		//verify items in no location
		.GetLocationsNameText("")
		//verify item on the split location obtained
		
		
		;
	}	

	/*
	 * Validating user is able to setup inventory.
	 * Validating Creating Location and updating quantity on product card
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */
	@Test(groups={"MIL-WF10"},priority=44, description = "MIL-WF10-Track Inventory+Location+item product card + update qty & UOM")
	public void MIL_WF10_TrackInventory_Location_item_productcard_updateqtyUOM() {	

		LoginData loginData =LoginData.fetch("LoginData3"); 	
		LocationsData locationsData =LocationsData.fetch("LocationsData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		UOMQuantityData uomQuantityData1 = UOMQuantityData.fetch("UOMQuantityData1");
		PrepItemData prepItemData1 =PrepItemData.fetch("PrepItemData1");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MIL-WF10-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MIL-WF10-Login")


		._atHomePage()
		.ClickAccount(loginData.UserName,"MIL-WF10-Clicked account")


		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"MIL-WF10-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("MIL-WF10-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MIL-WF10-Skip1 Tapped")
		.TapOrderGuide("MIL-WF10-Selected")
		.tapContinue("MIL-WF10-Tapped Continue")


		._atSetupInventoryPage()
		._atLocationsPage()
		.DefaultLocation("MIL-WF10-Tapped Default location")
		.tapContinue("MIL-WF10-Tapped Continue")
		._atSetupInventoryPage()
		.TapOnDOThisLater("MIL-WF10-Tapped do this later")
		.TapTakeHome("MIL-WF10-Tapped take me home")  

		._atInventoryToolPage()
		.InvTools_TrackInventory("MIL-WF10-TrackinventoryTap")


		._atLocationsPage()
		.TapAddLocation("MIL-WF10-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MIL-WF10-Enter location name")
		.AddLocationCooler("MIL-WF10-Tapped Cooler")
		.TapOnDone("MIL-WF10-Tapped Done")
		.TapOnBack("MIL-WF10-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MIL-WF10-Verifing AddedLocation")

		.SelectLocation(locationsData.LocationName, "MIL-WF10-Selecting AddedLocation")
		.TapAddLocation("MIL-WF10-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF10-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF10-NonSyscoItem details entered")
		.TapOnDone("MIL-WF10-Tapped Done")
		._atLocationsPage()
		.ProductSelect(prepItemData.ProductName, "MIL-WF10-Product select")
		.TapOnEdit("MIL-WF10-Tap on edit")
		
		._atSetupInventoryPage()
		.EnterItemDetails(prepItemData1.ProductName, prepItemData1.UPC, prepItemData1.Pack, prepItemData1.Size, prepItemData1.Weight, prepItemData1.Price, prepItemData1.ProductBrand, "MIL-WF10-NonSyscoItem details entered")
		
		._atLocationsPage()
		.tapOnProductOpenProductDetailsPageAndEnterQty(prepItemData.ProductName, uomQuantityData1.Quantity, "MIL-WF10-Qty entering")
		.TapOnDone("MIL-WF10-tap on done")
		.TapOnBack("MIL-WF10-tap on back")
		.QuantityVerify(uomQuantityData1.Quantity, "MIL-WF10-Quantity verify")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData1.ProductName,"MIL-WF10-Verify item selected")
		
		
		

		;

	}



	/*
	 * Validating user is able to setup inventory.
	 * Validating editing item and updating category on product card
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */
	@Test(groups={"MEC-WF1"},priority=45, description = "MEC-WF1-Selecting a location navigate to product and assiging  item  to category created")
	public void MEC_WF1_Locations_ItemEdit_UpdateCategory() {	

		LoginData loginData =LoginData.fetch("LoginData2");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		CategoryData categoryData =CategoryData.fetch("CategoryData");
		
		LocationsData locationsData1 =LocationsData.fetch("LocationsData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		LocationsData locationsData2 =LocationsData.fetch("LocatiosData4");
		PrepItemData prepItemData1 =PrepItemData.fetch("PrepItemData1");
		LocationsData locationsData3 =LocationsData.fetch("LocatiosData2");	
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MEC-WF1-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MEC-WF1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MEC-WF1-Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"MEC-WF1-FirstAccountSelect")



		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MEC-WF1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MEC-WF1-Skip1 Tapped")
		.TapOrderGuide("MEC-WF1-OG Selected")
		.tapContinue("MEC-WF1-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("MEC-WF1-Tapped Custom location")
		.tapContinue("MEC-WF1-Tapped Continue")


		._atSetupInventoryPage()
		.TapOnDOThisLater("MEC-WF1-Tapped do this later")
		.TapTakeHome("MEC-WF1-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("MEC-WF1-TrackinventoryTap")

		._atLocationsPage()
		.TapAddLocation("MEC-WF1-Tapped ADD")
		.AddLocationName(locationsData.LocationName,"MEC-WF1-Enter location name")
		.AddLocationCooler("MEC-WF1-Tapped Cooler")
		.TapOnDone("MEC-WF1-Tapped Done")
		.TapOnBack("MEC-WF1-Tapped Back")
		.VerifyLocationList(locationsData.LocationName, "MEC-WF1-Verifing AddedLocation")
		//nonsysco item addition 
		.SelectLocation(locationsData.LocationName, "MEC-WF1-Selecting AddedLocation")
		.TapAddLocation("MEC-WF1-Tapped ADD")

		._atSetupInventoryPage()
		.AddItemFrom_NonSysco("MEC-WF1-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MEC-WF1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MEC-WF1-select supplier")
		._atVendorPage()
		.Add_Supplier("MEC-WF1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MEC-WF1-AddVendorDetails")
		.TapOnDone("MEC-WF1-Tapped Done")
		.TapOnBack("MEC-WF1-Tapped Back")
		.SupplierSelect(vendorDetailsData.VendorName,"MEC-WF1-SupplierSelect")
		.TapOnDone("MEC-WF1-Tapped Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MEC-WF1-Verify item selected")

		._atLocationsPage()
		.ProductSelect(nonSyscoItemData.ProductName, "MEC-WF1-Select Product")
		.TapOnEdit("MEC-WF1-Tapped Edit")
		
		._atLocationsPage()
		.AddCategory_AddProductDetailsPage("MEC-WF1-CategorySelect")
		.TapAddLocation("MEC-WF1-Tapped Add")
		._atCategoryPage()
		.AddCategoryName(categoryData.Name, "MEC-WF1-Enter Category Name")
		.AddCategoryFood("MEC-WF1-Enter type food")
		.TapOnDone("MEC-WF1-Tapped Done")
		.TapOnBack("MEC-WF1-Tapped Back")
		.SelectCategory(categoryData.Name, "MEC-WF1-Select Category Name")
		.TapOnDone("MEC-WF1-Tapped Done") 
		.TapOnBack("MEC-WF1-Tapped Back")
		.TapOnBack("MEC-WF1-Tapped Back")
		
		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "MEC-WF1-Selecting AddedLocation")
		._atCategoryPage()
		.VerifyCategory(categoryData.Name, "MEC-WF1-Verified Category")
		
		
		//inv 252,253
		
		//no scenario
		._atLocationsPage()
		.TapAddLocation("MEC-WF1-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MEC-WF1-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MEC-WF1-NonSyscoItem details entered")

		// prep item addition to 2 locations created 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MEC-WF1-Select Add/Select location option")
		.TapAddLocation("MEC-WF1-Tapped ADD5")
		.AddLocationName(locationsData1.LocationName,"MEC-WF1-Enter location3 name")
		.AddLocationCooler("MEC-WF1-Tapped Cooler")
		.TapOnDone("MEC-WF1-Tapped Done")
		.TapOnBack("MEC-WF1-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MEC-WF1-Verifing Added Location3")

		.SelectLocation(locationsData1.LocationName, "MEC-WF1-Selecting Added Location3")
	    .SelectLocation(locationsData.LocationName, "MEC-WF1-Selecting Added Location1")
		.LocationDoneSelection("MEC-WF1-Selecting Done")
		.TapOnDone("MEC-WF1-Tapped Done")
		
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MEC-WF1-Verify item selected")
	
		._atLocationsPage()
		.ProductSelect(prepItemData.ProductName, "MEC-WF1-Select Product")
		.TapOnEdit("MEC-WF1-Tapped Edit")
		.LocationsDelete("MEC-WF1-Tapped Edit")
		//.LocationsDelete("MEC-WF1-Tapped Edit")
		.TapOnNoDelete("MEC-WF1-Confirming deleting all locations")
		.TapOnEdit("MEC-WF1-Tapped Edit")
		.TapOnDone("MEC-WF1-Tapped Done")
		.TapOnBack("MEC-WF1-Tapped Back")
		.TapOnBack("MEC-WF1-Tapped Back")
		.SelectLocation(locationsData2.LocationName, "MEC-WF1-Selecting Added Location3")
		._atLocationsPage()
		.NoItemsCheckInNoLocation("MEC-WF1-No items in no location")
		
		
		.TapOnBack("MEC-WF1-Tapped Back")
		//yes scenario
		.SelectLocation(locationsData.LocationName, "MEC-WF1-Selecting AddedLocation")
		._atLocationsPage()
		.TapAddLocation("MEC-WF1-Tapped ADD")
		._atSetupInventoryPage()
		.AddItemFrom_PrepItem("MIL-WF2-Tapped Prepitem")
		.EnterItemDetails(prepItemData1.ProductName, prepItemData1.UPC, prepItemData1.Pack, prepItemData1.Size, prepItemData1.Weight, prepItemData1.Price, prepItemData1.ProductBrand, "MEC-WF1-PrepItem details entered")

		// prep item addition to 2 locations created 
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MEC-WF1-Select Add/Select location option")
		.TapAddLocation("MEC-WF1-Tapped ADD5")
		.AddLocationName(locationsData3.LocationName,"MEC-WF1-Enter location3 name")
		.AddLocationCooler("MEC-WF1-Tapped Cooler")
		.TapOnDone("MEC-WF1-Tapped Done")
		.TapOnBack("MEC-WF1-Tapped Back")
		.VerifyLocationList(locationsData3.LocationName, "MEC-WF1-Verifing Added Location3")

		.SelectLocation(locationsData3.LocationName, "MEC-WF1-Selecting Added Location3")
	    .SelectLocation(locationsData.LocationName, "MEC-WF1-Selecting Added Location1")
		.LocationDoneSelection("MEC-WF1-Selecting Done")
		.TapOnDone("MEC-WF1-Tapped Done")
		
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData1.ProductName,"MEC-WF1-Verify item selected")

		._atLocationsPage()
		.ProductSelect(prepItemData1.ProductName, "MEC-WF1-Select Product")
		
		.TapOnEdit("MEC-WF1-Tapped Edit")
		.LocationsDelete("MEC-WF1-Tapped Edit")
		//.LocationsDelete("MEC-WF1-Tapped Edit")
		.TapOnYesDelete("MEC-WF1-Confirming deleting all locations")
		.TapOnDone("MEC-WF1-Tapped Done")
		.TapOnBack("MEC-WF1-Tapped Back")
		.SelectLocation(locationsData2.LocationName, "MEC-WF1-Selecting Added Location3")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData1.ProductName,"MEC-WF1-Verify item selected")
		._atLocationsPage()
		.NoLocationTextCheck(locationsData2.LocationName,"MEC-WF1-No location text verification")
	
		;
	}




	/*
	 * Validating user is able to setup inventory.
	 * Validating Creating, editing and deleting category
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */
	@Test(groups={"MEC-WF2"},priority=46, description = "MEC-WF2-Creating, editing and deleting category ")
	public void MEC_WF2_Category_Create_Edit_Delete_Category() {	

		LoginData loginData =LoginData.fetch("LoginData2");  
		CategoryData categoryData =CategoryData.fetch("CategoryData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MEC-WF2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"MEC-WF2-Login")


		._atHomePage()
		.ClickAccount(loginData.UserName,"MEC-WF2-Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"MEC-WF2-FirstAccountSelect")

		//setting up inventory    
		._atInventoryToolPage()
		.InvTools_SetUpInventory("MEC-WF2-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MEC-WF2-Skip1 Tapped")
		.TapOrderGuide("MEC-WF2-OG Selected")
		.tapContinue("MEC-WF2-Tapped Continue")

		._atLocationsPage()
		.DefaultLocation("MEC-WF2-Tapped Custom location")
		.tapContinue("MEC-WF2-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("MEC-WF2-Tapped do this later")
		.TapTakeHome("MEC-WF2-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_Category("MEC-WF2-Expense Category Tap")

		._atCategoryPage()
		.TapAdd("MEC-WF2-Add Expense Category Tap")
		.AddCategoryName(categoryData.Name, "MEC-WF2-Enter Category Name")
		.AddCategoryFood("MEC-WF2-Enter type food")
		.TapOnDone("MEC-WF2-Tapped Done")
		.TapOnBack("MEC-WF2-Tapped Back")
		.VerifyCategoryList(categoryData.Name, "MEC-WF2-Verifying added category list")
		.SelectCategory(categoryData.Name, "MEC-WF2-Selecting Category")
		.TapOnEdit("MEC-WF2-Tap on Edit")
		.AddCategoryName(categoryData.Name1, "MEC-WF2-Entering new name")
		.AddCategoryFood("MEC-WF2-Enter type food") 
		.TapOnDone("MEC-WF2-Tapped Done") 
		.TapOnBack("MEC-WF2-Tapped Back")
		.VerifyCategoryList(categoryData.Name1, "MEC-WF2-Verifying edited category list")
		.SelectCategory(categoryData.Name1, "MEC-WF2-Selecting Category")
		.TapOnDeleteCategory("MEC-WF2-Deleting Category")
		.TapOnYesDelete("MEC-WF2-Tap on Yes Delete")
		.VerifyDeletedCategoryList(categoryData.Name1, "MEC-WF2-Verifying Deleted category list")
		;
	}		




	/*
	 * Validating user is able to setup inventory.
	 * Validating Non sysco item addition through Homepage and linking supplier location and category
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */

	@Test(groups={"MNS-1"},priority=47, description = "MNS-1-Manage_Create Non-Sysco Item_Link Supplier_Location_Expense Category")
	public void MNS_1_CreateNonSyscoItem_LinkSupplier_Location_Category() {	



		LoginData loginData =LoginData.fetch("LoginData3"); 
		LocationsData locationsData =LocationsData.fetch("LocationsData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		NonSyscoItemData nonSyscoItemData1 =NonSyscoItemData.fetch("NonSyscoItmData1");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData1");
		VendorDetailsData vendorDetailsData1 =VendorDetailsData.fetch("VendorDetailData2");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
//		SearchData searchData=SearchData.fetch("SearchData");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData3");
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MNS-1-LoginPage")
		.saveUsernameCheckBoxClick("MNS-1-save username")
		.signIn(loginData.UserName, loginData.Password,"MNS-1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MNS-1-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"MNS-1-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("MNS-1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MNS-1-Tapped Skip1")
		.TapOrderGuide("MNS-1-Selected OG")
		.tapContinue("MNS-1-Tapped Continue")
		
		/*.StartFromScratch("MNS-1-ScratchSelected")
		.tapContinue("MNS-1-Tapped Continue1")
		.Scratch_AddItems("MNS-1-Tapped Add items")
		.SearchItem(searchData.keyword,"MNS-1-Search item")

		.SelectItemFrom_Catalog("MNS-1-Selected item from catalog")
		.TapOnDone("MNS-1-Tapped Done4")

		.verifySearchItemsOnSetupInv("MNS-1-Verify catalog item selected")
		.TapOnDone("MNS-1-Tapped Done2")*/

		._atLocationsPage()
		.DefaultLocation("MNS-1-Tapped Custom location")
		.tapContinue("MNS-1-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("MNS-1-Tapped do this later")
		.TapTakeHome("MNS-1-Tapped Take me Home")  

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
		
		
		
		._atLocationsPage()
		.ProductSelect(nonSyscoItemData.ProductName, "MNS-1-Product select")
		.TapOnEdit("MNS-1-Tap on edit")
		
		._atSetupInventoryPage()	
		.EnterItemDetails(nonSyscoItemData1.ProductName, nonSyscoItemData1.UPC, nonSyscoItemData1.Pack, nonSyscoItemData1.Size, nonSyscoItemData1.Weight, nonSyscoItemData1.Price, nonSyscoItemData1.ProductBrand, "MNS-1-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("MNS-1-select supplier")
		._atVendorPage()
		.Add_Supplier("MNS-1-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData1.VendorName, vendorDetailsData1.PhoneNum, vendorDetailsData1.Address, vendorDetailsData1.ContactInfo, vendorDetailsData1.Email, vendorDetailsData1.Note, "MNS-1-AddVendorDetails")
		.TapOnDone("MNS-1-Done")
		.TapOnBack("MNS-1-Back")
		.SupplierSelect(vendorDetailsData1.VendorName,"MNS-1-SupplierSelect")
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MNS-1-Select Add/Select location option")
		.TapAddLocation("MNS-1-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MNS-1-Enter location2 name")
		.AddLocationCooler("MNS-1-Tapped Cooler")
		.TapOnDone("MNS-1-Tapped Done")
		.TapOnBack("MNS-1-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MNS-1-Verifing Added Location2")

		.SelectLocation(locationsData1.LocationName, "MNS-1-Selecting Added Location2")
		.SelectLocation(locationsData.LocationName, "MNS-1-Selecting Added Location2")     //not preselected
		.LocationDoneSelection("MNS-1-Selecting Done")
		.TapOnDone("MNS-1-Tapped Done")
		
		.TapOnBack("MNS-1-Tapped Back")
		.SelectLocation(locationsData1.LocationName, "MNS-1-Selecting Added Location2")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData1.ProductName,"MNS-1-Verify nonsysco item added")
		;
	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating Prep item addition through Homepage and linking supplier location and category
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */
	@Test(groups={"MPI-1"},priority=48, description = "MPI-1-Manage_Create Prep Item_LinkLocation_Expense Category")
	public void MPI_1_CreatePrepItem_LinkLocation_Category() {	

		LoginData loginData =LoginData.fetch("LoginData4");	  
		LocationsData locationsData =LocationsData.fetch("LocationsData");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData3");
		PrepItemData prepItemData1 =PrepItemData.fetch("PrepItemData1");
		
		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("MPI-1-LoginPage")
		.saveUsernameCheckBoxClick("MPI-1-save username")
		.signIn(loginData.UserName, loginData.Password,"MPI-1-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"MPI-1-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"MPI-1-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("MPI-1-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("MPI-1-Tapped Skip1")
		.TapOrderGuide("MPI-1-Selected OG")
		.tapContinue("MPI-1-Tapped Continue")
		/*.StartFromScratch("MPI-1-ScratchSelected")
		.tapContinue("MPI-1-Tapped Continue1")
		.Scratch_AddItems("MPI-1-Tapped Add items")
		.AddItemFrom_OrderGuide("MPI-1-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("MPI-1-Selected item from OG")

		.verifyOGItemsOnSetupInv("MPI-1-Verify item selected")
		.TapOnDone("MPI-1-Tapped Done2")*/

		._atLocationsPage()
		.DefaultLocation("MPI-1-Tapped Custom location")
		.tapContinue("MPI-1-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("MPI-1-Tapped do this later")
		.TapTakeHome("MPI-11-Tapped Take me Home")  

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
		
		
		._atLocationsPage()
		.ProductSelect(prepItemData.ProductName, "MPI-1-Product select")
		.TapOnEdit("MPI-1-Tap on edit")
		
		._atSetupInventoryPage()	
		.EnterItemDetails(prepItemData1.ProductName, prepItemData1.UPC, prepItemData1.Pack, prepItemData1.Size, prepItemData1.Weight, prepItemData1.Price, prepItemData1.ProductBrand, "MPI-1-PrepItem details entered")
		._atLocationsPage()
		.AddLocation_AddProductDetailsPage("MPI-1-Select Add/Select location option")
		.TapAddLocation("MPI-1-Tapped ADD")
		.AddLocationName(locationsData1.LocationName,"MPI-1-Enter location2 name")
		.AddLocationCooler("MPI-1-Tapped Cooler")
		.TapOnDone("MPI-1-Tapped Done")
		.TapOnBack("MPI-1-Tapped Back")
		.VerifyLocationList(locationsData1.LocationName, "MPI-1-Verifing Added Location2")

		.SelectLocation(locationsData1.LocationName, "MPI-1-Selecting Added Location2")
		.SelectLocation(locationsData.LocationName, "MPI-1-Selecting Added Location2")     //not preselected
		.LocationDoneSelection("MPI-1-Selecting Done")
		.TapOnDone("MPI-1-Tapped Done")
		
		.TapOnBack("MPI-1-Tapped Back")
		.SelectLocation(locationsData1.LocationName, "MPI-1-Selecting Added Location2")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData1.ProductName,"MPI-1-Verify nonsysco item added")
		
		
		;
	}

	/*
	 * Validating user is able to setup inventory.
	 * Validating add/edit/delete supplier  through Homepage 
	 * Prerequisite:Normal/MA User with OG items
	 * 
	 */
	@Test(groups={"MSP-1 MSP-2"},priority=49, description = "MSP-1 MSP-2 Home Screen-->Suppliers-->Add new Suppliers/View/Maintain Suppliers")
	public void MSP1_MSP2_Add_View_ManageSuppliers()
	{


		LoginData loginData =LoginData.fetch("LoginData5"); 
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


