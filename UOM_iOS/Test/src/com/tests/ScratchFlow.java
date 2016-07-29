
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


public class ScratchFlow extends Initiator{

	

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch(Product catalog) and then assign those items to Default location and Default category.
	 * Prerequisite:Normal/MA User
	 */

	@Test(groups={"SI - WF 9"},priority=0, description = "SI - WF 9-Start From Scratch + add items from Product catelog +Default Loc + Default Category")
	public void SI_WF9_StartFromScratch_PdtCatalog_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData9");
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

		LoginData loginData =LoginData.fetch("LoginData8");

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

		LoginData loginData =LoginData.fetch("LoginData9");
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
		.NonSysco_Prompt(loginData.UserName,"SI - WF 11-verify NonSysco")
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

		LoginData loginData =LoginData.fetch("LoginData8");
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


		LoginData loginData =LoginData.fetch("LoginData8");       
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

		LoginData loginData =LoginData.fetch("LoginData9");	 
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

		LoginData loginData =LoginData.fetch("LoginData8");	  
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

		LoginData loginData =LoginData.fetch("LoginData9");
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

		LoginData loginData =LoginData.fetch("LoginData2");
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
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to multiple  locations and Suggested category.
	 * Validating all items are displayed on corresponding location at Track Inventory
	 * Validating  suggested category is displayed at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */

	@Test(groups={"SI - WF 37"},priority=1, description = "SI - WF 37-Start from scratch+ Multiple lists +Custom location +Suggested category")
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

		LoginData loginData =LoginData.fetch("LoginData9");       
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


}


