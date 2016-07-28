
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
	@Test(groups={"SI-WF9"},priority=7, description = "SI-WF9-Start From Scratch + add items from Product catelog +Default Loc + Default Category ")
	public void SI_WF9_StartFromScratch_PdtCatalog_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData15");

		SearchData searchData=SearchData.fetch("SearchData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF9-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF9-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF9-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF9-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI-WF9-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF9-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF9-Tapped Skip")

		.StartFromScratch("SI-WF9-ScratchSelected")
		.tapContinue("SI-WF9-Tapped Continue")
		.Scratch_AddItems("SI-WF9-Tapped Add items")
		.SearchItem(searchData.keyword,"SI-WF9-Search item")
		.SelectMultipleItemsFrom_OrderGuide("SI-WF9-Selected item from OG")
		.TapOnDone("SI-WF9-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("SI-WF9-Verify item selected")
		.TapOnDone("SI-WF9-Tapped Done")


		._atLocationsPage()
		.DefaultLocation("SI-WF9-Tapped Default location")
		.tapContinue("SI-WF9-Tapped Continue")

		._atCategoryPage()
		.defaultCategories("SI-WF9-Tapped Custom category")
		.tapComplete("SI-WF9-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI-WF9-Tapped Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF9-Selected track inventory")



		;
	}


	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (OrderGuide) and then assign those items to Default locations and default category.
	 * Prerequisite:Normal/MA User with OG items.
	 */
	@Test(groups={"SI-WF10"},priority=8, description = "SI-WF10-Start From Scratch + add items from Order Guide +Default Loc + Default Category")
	public void SI_WF10_StartFromScratch_OG_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData2");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF10-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF10-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF10-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF10-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI-WF10-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF10-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF10-Tapped Skip")
		.StartFromScratch("SI-WF10-ScratchSelected")
		.tapContinue("SI-WF10-Tapped Continue")
		.Scratch_AddItems("SI-WF10-Tapped Add items")
		.AddItemFrom_OrderGuide("SI-WF10-Tapped Order Guide")
		.SelectMultipleItemsFrom_OrderGuide("SI-WF10-Selected item from OG")
		.TapOnDone("SI-WF10-Tapped Done")
		.verifyMultipleItemsfromOGonSetUpInv("SI-WF10-Verify item selected")
		.TapOnDone("SI-WF10-Tapped Done")


		._atLocationsPage()
		.DefaultLocation("SI-WF10-Tapped Default location")
		.tapContinue("SI-WF10-Tapped Continue")

		._atCategoryPage()
		.defaultCategories("SI-WF10-Tapped Custom category")
		.tapComplete("SI-WF10-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI-WF10-Tapped Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF10-Selected track inventory")


		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Prep and NonSysco items) and then assign those items to Default locations and default category.
	 * Validating Non sysco prompt details
	 * Validating Non Sysco and Prep item displayed on 'No locations' on Track Inventory
	 * Prerequisite:Normal/MA User
	 */
	@Test(groups={"SI-WF11"},priority=9, description = "SI-WF11-Start From Scratch + add items Non-sysco & Prep+Default Loc + Default Category ")
	public void SI_WF11_StartFromScratch_NonSysco_Prep_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData3");

		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF11-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF11-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF11-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF11-Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI-WF11-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF11-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF11-Tapped Skip")
		.StartFromScratch("SI-WF11-ScratchSelected")
		.tapContinue("SI-WF11-Tapped Continue")
		.Scratch_AddItems("SI-WF11-Tapped Add items")
		.AddItemFrom_NonSysco("SI-WF11-Tapped NonSysco")
		.NonSysco_Prompt(loginData.UserName,"SI-WF11-verify NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF11-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF11-select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF11-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF11-AddVendorDetails")
		.TapOnDone("SI-WF11-Done")
		.TapOnBack("SI-WF11-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF11-SupplierSelect")
		.TapOnDone("SI-WF11-Done")

		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF11-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF11-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF11-NonSyscoItemAddPage")
		.TapOnDone("SI-WF11-Tapped Done")

		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF11-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF11-Verify item selected")


		.TapOnDone("SI-WF11-Tapped Done")

		._atLocationsPage()
		.DefaultLocation("SI-WF11-Tapped Default location")
		.tapContinue("SI-WF11-Tapped Continue")

		._atCategoryPage()
		.defaultCategories("SI-WF11-Tapped Custom category")
		.tapComplete("SI-WF11-Tapped Complete")
		._atSetupInventoryPage()
		.TapTakeHome("SI-WF11-Tapped Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF11-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF11-select added location")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF11-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF11-Verify item selected")
		.TapOnDone("SI-WF11-Tapped Done")
		;
	}


	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Default locations and default category.
	 * Validating Non Sysco and Prep item displayed on 'No locations' on Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI-WF12"},priority=10, description = "SI-WF12-Start From Scratch + add items from multiple lists +Default Loc + Default Category ")
	public void SI_WF12_StartFromScratch_Catalog_OG_NonSysco_Prep_DefaultLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData4");

		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF12-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF12-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF12-Login")
		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF12-Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI-WF12-FirstAccountSelect")


		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF12-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF12-Tapped Skip")

		.StartFromScratch("SI-WF12-ScratchSelected")
		.tapContinue("SI-WF12-Tapped Continue")
		.Scratch_AddItems("SI-WF12-Tapped Add items")
		.SearchItem(searchData.keyword,"SI-WF12-Search item")
		.SelectItemFrom_Catalog("SI-WF12-Selected item from OG")
		.TapOnDone("SI-WF12-Tapped Done")


		.Setup_AddItemsLink("SI-WF12-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF12-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF12-Selected item from OG")


		.verifySearchItemsOnSetupInv("SI-WF12-Verify item selected")  
		.verifyOGItemsOnSetupInv("SI-WF12-Verify item selected")    

		.Setup_AddItemsLink("SI-WF12-Add items Selected")
		.AddItemFrom_NonSysco("SI-WF12-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF12-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF12-select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF12-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF12-AddVendorDetails")
		.TapOnDone("SI-WF12-Done")
		.TapOnBack("SI-WF12-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI - WF 12-TC2-SupplierSelect")
		.TapOnDone("SI-WF12-Done")

		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF12-Verify item selected")
		.Setup_AddItemsLink("SI-WF12-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF12-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF12-NonSyscoItemAddPage")
		.TapOnDone("SI-WF12-Tapped Done")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF12-Verify item selected")

		.TapOnDone("SI-WF12-Tapped Done")


		._atLocationsPage()
		.DefaultLocation("SI-WF12-Tapped Default location")
		.tapContinue("SI-WF12-Tapped Continue")



		._atCategoryPage()
		.defaultCategories("SI-WF12-Tapped Custom category")
		.tapComplete("SI-WF12-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF12-TC1-Tapped take me home")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF12-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF12-select added location")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF12-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF12-Verify item selected")
		.TapOnDone("SI-WF12-Tapped Done")
		;
	}
	
	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Custom locations and Custom category.
	 * Validating uncategorized items on locations and categories page
	 * Validating all items are displayed on corresponding location at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI-WF13"},priority=11, description = "SI-WF13-Start from scratch+ Multiple lists +Custom location + Custom category")
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
		.verifyLoginPage("SI-WF13-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF13-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF13-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF13-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI-WF13-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF13-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF13-Tapped Skip1")

		.StartFromScratch("SI-WF13-ScratchSelected")
		.tapContinue("SI-WF13-Tapped Continue1")
		.Scratch_AddItems("SI-WF13-Tapped Add items")
		//nonsysco item
		.AddItemFrom_NonSysco("SI-WF13-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF13-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF13-select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF13-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF13-AddVendorDetails")
		.TapOnDone("SI-WF13-Tapped Done1")
		.TapOnBack("SI-WF13-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF13-SupplierSelect")
		.TapOnDone("SI-WF13-Tapped Done2")

		//prepitem
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF13-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF13-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF13-PrepItemAddPage")
		.TapOnDone("SI-WF13-Tapped Done3")

		.Setup_AddItemsLink("SI-WF13-Add items Selected")
		.SearchItem(searchData.keyword2,"SI-WF13-Search item")
		.verifyItemDescriptionSearch(searchData.keyword2, "SI-WF13-Verified search with item description")
		.SelectItemFrom_Catalog("SI-WF13-Selected item from catalog")
		.TapOnDone("SI-WF13-Tapped Done4")

		.Setup_AddItemsLink("SI-WF13-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF13-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF13-Selected item from OG")

		//verifications
		.verifySearchItemsOnSetupInv("SI-WF13-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI-WF13-Verify OG item selected")  

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF13-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF13-Verify nonsysco item selected")
		.TapOnDone("SI-WF13-Tapped Done6")

		._atLocationsPage()
		.CustomLocation("SI-WF13-Tapped Custom location")
		.tapContinue("SI-WF13-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI-WF13-Enter location name")
		.AddLocations1_TypeDry("SI-WF13-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData1.LocationName)
		.AddLocations2_TypeDry("SI-WF13-Tapped Dry2")
		.TapOnNext("SI-WF13-Tapped Next1")


		.AssignMultipleListItemsToLocation("SI-WF13-Selected Multiple items to Location1")
		.AssignMultipleListItemsToLocation("SI-WF13-Selected Multiple items to Location1")
		.TapOnNext("SI-WF13-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI-WF13-Selected Multiple items to Location2")
		.TapOnDone("SI-WF13-Tapped Done7")


		._atCategoryPage()
		.CustomCategories("SI - WF 13-TC1-CustomCategories Tapped")
		.tapContinue("SI - WF 13-TC1-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 13-TC1-CreateTwoExpenseCategory") 
		.TapOnNext("SI - WF 13-TC1-Tapped Next3")
		.AssignMultipleItemsToCategory("SI - WF 13-TC1-Assign MultipleItems To Category1")
		.AssignMultipleItemsToCategory("SI - WF 13-TC1-Assign MultipleItems To Category1")
		.TapOnNext("SI - WF 13-TC1-Tapped Next4")
		.AssignMultipleItemsToCategory("SI - WF 13-TC1-Assign MultipleItems To Category2")

		._atSetupInventoryPage()
		.TapOnDone("SI - WF 13-TC1-Tapped Done8")
		.TapTakeHome("SI-WF13-TC1-Tapped Done8")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF13-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData1.LocationName, "SI-WF13-Select added location2")
		.VerifyMultipleListItemsInLocation("SI-WF13-Verifying Multiple items in Location2")

		;
	}


	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Default location and Custom category.
	 * Validating categorized items on categories page
	 * Validating Non Sysco and Prep items are displayed on corresponding location at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI-WF14"},priority=12, description = "SI-WF14-Start from scratch+ Multiple lists +Default location + Custom category")
	public void SI_WF14_StartFromScratch_MultipleList_DefaultLocation_CustomCategory() {	

		LoginData loginData =LoginData.fetch("LoginData2");	  

		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF14-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF14-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF14-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF14-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI-WF14-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF14-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF14-Tapped Skip1")

		.StartFromScratch("SI-WF14-ScratchSelected")
		.tapContinue("SI-WF14-Tapped Continue1")
		.Scratch_AddItems("SI-WF14-Tapped Add items")
		//nonsysco item addition
		.AddItemFrom_NonSysco("SI-WF14-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF14-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF14-select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF14-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF14-AddVendorDetails")
		.TapOnDone("SI-WF14-Tapped Done on add supplier page")
		.TapOnBack("SI-WF14-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF14-SupplierSelect")
		.TapOnDone("SI-WF14-Tapped Done2")

		//prepitem addition
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF14-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF14-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF14-PrepItemAddPage")
		.TapOnDone("SI-WF14-Tapped Done3")

		.Setup_AddItemsLink("SI-WF14-Add items Selected")
		.SearchItem(searchData.keyword,"SI-WF14-Search item")
		.SelectItemFrom_Catalog("SI-WF14-Selected item from catalog")
		.TapOnDone("SI-WF14-Tapped Done4")

		.Setup_AddItemsLink("SI-WF14-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF14-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF14-Selected item from OG")

		//verifications 
		.verifySearchItemsOnSetupInv("SI-WF14-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI-WF14-Verify OG item selected")  

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF14-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF14-Verify nonsysco item selected")


		.TapOnDone("SI-WF14-Tapped Done6")


		._atLocationsPage()
		.DefaultLocation("SI-WF14-Tapped Custom location")
		.tapContinue("SI-WF14-Tapped Continue2")


		._atCategoryPage()
		.CustomCategories("SI-WF14-CustomCategories Tapped")
		.tapContinue("SI-WF14-Tapped Continue3")
		.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI-WF14-CreateTwoExpenseCategory")
		.TapOnNext("SI-WF14-Tapped Next3")
		.AssignMultipleItemsToCategory("SI-WF14-Assign MultipleItems To Category1")
		.TapOnNext("SI-WF14-Tapped Next4")

		._atCategoryPage()
		.VerifyItemPresentUncategorizedAndAllItems("SI-WF14-Tapped Next4-verified all items ad uncategorized tab items")
		._atSetupInventoryPage()
		.TapOnDone("SI-WF14-Tapped Done7")
		.TapTakeHome("SI-WF14-Tapped Done8")
		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF14-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF14-Select added location1")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF14-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF14-Verify item selected")
		.TapOnDone("SI-WF14-Tapped Done")

		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to multiple  locations and Default category.
	 * Validating all items are displayed on corresponding location at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */


	@Test(groups={"SI-WF15"},priority=13, description = "SI-WF15-Start from scratch+ Multiple lists +Custom location + Default category")
	public void SI_WF15_StartFromScratch_MultipleList_CustomLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData3");	  

		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");

		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF15-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF15-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF15-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF15-Clicked account")

		._atAccountsPage()
		.Second_AccountSelection(loginData.UserName,"SI-WF15-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF15-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF15-Tapped Skip1")

		.StartFromScratch("SI-WF15-ScratchSelected")
		.tapContinue("SI-WF15-Tapped Continue1")
		.Scratch_AddItems("SI-WF15-Tapped Add items")
		//nonsysco item addition
		.AddItemFrom_NonSysco("SI-WF15-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF15-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF15-Select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF15-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF15-AddVendorDetails")
		.TapOnDone("SI-WF15-Tapped Done1")
		.TapOnBack("SI-WF15-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF15-SupplierSelect")
		.TapOnDone("SI-WF15-Tapped Done2")

		//prepitem addition
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF15-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF15-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF15-PrepItemAddPage")
		.TapOnDone("SI-WF15-Tapped Done3")

		.Setup_AddItemsLink("SI-WF15-Add items Selected")
		.SearchItem(searchData.keyword,"SI-WF15-Search item")
		.SelectItemFrom_Catalog("SI-WF15-Selected item from catalog")
		.TapOnDone("SI-WF15-Tapped Done4")
		.verifySearchItemsOnSetupInv("SI-WF15-Verify catalog item selected") 

		.Setup_AddItemsLink("SI-WF15-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF15-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF15-Selected item from OG")

		//verifications
		.verifySearchItemsOnSetupInv("SI-WF15-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI-WF15-Verify OG item selected")
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF15-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF15-Verify nonsysco item selected")


		.TapOnDone("SI-WF15-Tapped Done6")

		._atLocationsPage()
		.CustomLocation("SI-WF15-Tapped Custom location")
		.tapContinue("SI-WF15-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI-WF15-Enter location name")
		.AddLocations1_TypeDry("SI-WF15-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData1.LocationName)
		.AddLocations2_TypeDry("SI-WF15-Tapped Dry2")
		.TapOnNext("SI-WF15-Tapped Next1")

		.AssignMultipleListItemsToLocation("SI-WF15-Selected Multiple items to Location1")
		.TapOnNext("SI-WF15-Tapped Next2")
		.AllItemsTabClick("SI-WF15-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI-WF15-Selected Multiple items to Location2")
		.TapOnDone("SI-WF15-Tapped Done6")

		._atCategoryPage()
		.defaultCategories("SI-WF15-Tapped Custom category")
		.tapComplete("SI-WF15-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF15-Tapped Continue3")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF15-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF15-select added location1")
		.VerifyMultipleListItemsInLocation("SI-WF15-Verifying Multiple items in Location1")
		.TapOnBack("SI-WF15-Tapped back")
		.SelectLocation(locationsData1.LocationName, "SI-WF15-select added location2")
		.VerifyMultipleListItemsInLocation("SI-WF15-Verifying Multiple items in Location2")

		;
	}


	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then skipping location and skipping category.
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI-WF16"},priority=14, description = "SI-WF16-Start from scratch + Multiple lists+ Skip location+ Skip Category")
	public void SI_WF16_StartFromScratch_MultipleList_skipLocation_SkipCategory() {	

		LoginData loginData =LoginData.fetch("LoginData1");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF16-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF16-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF16-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF16-Clicked account")

		._atAccountsPage()
		.Third_AccountSelection(loginData.UserName,"SI-WF16-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF16-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF16-Tapped Skip")

		.StartFromScratch("SI-WF16-ScratchSelected")
		.tapContinue("SI-WF16-Tapped Continue")
		.Scratch_AddItems("SI-WF16-Tapped Add items")
		.SearchItem(searchData.keyword,"SI-WF16-Search item")
		.SelectItemFrom_Catalog("SI-WF16-Selected item from catalog")
		.TapOnDone("SI-WF16-Tapped Done")
		.verifySearchItemsOnSetupInv("SI-WF16-Verify item selected")

		.Setup_AddItemsLink("SI-WF16-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF16-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF16-Selected item from OG")
		.verifyOGItemsOnSetupInv("SI-WF16-Verify item selected")

		.Setup_AddItemsLink("SI-WF16-Add items Selected")
		.AddItemFrom_NonSysco("SI-WF16-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF16-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF16-select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF16-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF16-AddVendorDetails")
		.TapOnDone("SI-WF16-Done")
		.TapOnBack("SI-WF16-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF16-SupplierSelect")
		.TapOnDone("SI-WF16-Done")

		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF16-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF16-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF16-NonSyscoItemAddPage")
		.TapOnDone("SI-WF16-Tapped Done")

		//verifications
		.verifySearchItemsOnSetupInv("SI-WF16-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI-WF16-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF16-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF16-Verify nonsysco item selected")



		.TapOnDone("SI-WF16-Tapped Done")

		.TapOnDOThisLater("SI-WF16-Tapped do this later")
		.TapOnSkip("SI-WF16-Tapped Skip")


		.TapOnDOThisLater("SI-WF16-Tapped do this later")
		.tapContinue("SI-WF16-Tapped Continue")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF16-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF16-select added location")

		.TapOnDone("SI-WF16-Tapped Done")
		;
	}
	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Default  locations and Skipping category.
	 * Validating Non Sysco and Prep items are displayed on corresponding location at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI-WF17"},priority=15, description = "SI-WF17-Start from scratch + Multiple lists + Default loc + Skip Category")
	public void SI_WF17_StartFromScratch_MultipleList_DefaultLocation_SkipCategory() {	

		LoginData loginData =LoginData.fetch("LoginData2");	  
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF17-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF17-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF17-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF17-Clicked account")

		._atAccountsPage()
		.Fourth_AccountSelection(loginData.UserName,"SI-WF17-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF17-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF17-Tapped Skip")

		.StartFromScratch("SI-WF17-ScratchSelected")
		.tapContinue("SI-WF17-Tapped Continue")
		.Scratch_AddItems("SI-WF17-Tapped Add items")
		.SearchItem(searchData.keyword,"SI-WF17-Search item")
		.SelectItemFrom_Catalog("SI-WF17-Selected item from catalog")
		.TapOnDone("SI-WF17-Tapped Done")
		.verifySearchItemsOnSetupInv("SI-WF17-Verify item selected")   

		.Setup_AddItemsLink("SI-WF17-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF17-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF17-Selected item from OG")  

		.Setup_AddItemsLink("SI-WF17-Add items Selected")
		.AddItemFrom_NonSysco("SI-WF17-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF17-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF17-select supplier")
		._atVendorPage()
		.Add_Supplier("SI-WF17-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF17-AddVendorDetails")
		.TapOnDone("SI-WF17-Done")
		.TapOnBack("SI-WF17-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF17-SupplierSelect")
		.TapOnDone("SI-WF17-Done")

		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF17-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF17-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF17-NonSyscoItemAddPage")
		.TapOnDone("SI-WF17-Tapped Done")

		//verifications   
		.verifySearchItemsOnSetupInv("SI-WF17-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI-WF17-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF17-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF17-Verify nonsysco item selected")



		.TapOnDone("SI-WF17-Tapped Done")  

		._atLocationsPage()
		.DefaultLocation("SI-WF17-Tapped Default location")
		.tapContinue("SI-WF17-Tapped Continue")

		._atSetupInventoryPage()
		.TapOnDOThisLater("SI-WF17-Tapped do this later")
		.TapTakeHome("SI-WF17-Tapped TakeMeHome")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF17-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF17-select added location")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF17-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF17-Verify nonsysco item selected")
		.TapOnDone("SI-WF17-Tapped Done")
		;
	}		

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then skip location and assign to default category.
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI-WF18"},priority=16, description = "SI-WF18-Start from scratch+ Multiple lists +skip location + default category")
	public void SI_WF18_StartFromScratch_MultipleList_skipLocation_DefaultCategory() {	

		LoginData loginData =LoginData.fetch("LoginData3");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF18-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF18-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF18-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF18-Clicked account")

		._atAccountsPage()
		.Fifth_AccountSelection(loginData.UserName,"SI-WF18-FirstAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF18-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF18-Tapped Skip")

		.StartFromScratch("SI-WF18-ScratchSelected")
		.tapContinue("SI-WF18-Tapped Continue")
		.Scratch_AddItems("SI-WF18-Tapped Add items")
		.SearchItem(searchData.keyword,"SI-WF18-Search item")
		.SelectItemFrom_Catalog("SI-WF18-Selected item from catalog")
		.TapOnDone("SI-WF18-Tapped Done")

		.Setup_AddItemsLink("SI-WF18-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF18-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF18-Selected item from OG")

		.Setup_AddItemsLink("SI-WF18-Add items Selected")
		.AddItemFrom_NonSysco("SI-WF18-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF18-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF18-select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF18-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF18-AddVendorDetails")
		.TapOnDone("SI-WF18-Done")
		.TapOnBack("SI-WF18-Back")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF18-SupplierSelect")
		.TapOnDone("SI-WF18-Done")

		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF18-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF18-Tapped NonSysco")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF18-NonSyscoItemAddPage")
		.TapOnDone("SI-WF18-Tapped Done")

		//verifications
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF18-Verify item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF18-Verify item selected")

		.verifySearchItemsOnSetupInv("SI-WF18-Verify item selected")
		.verifyOGItemsOnSetupInv("SI-WF18-Verify item selected")

		.TapOnDone("SI-WF18-Tapped Done")


		.TapOnDOThisLater("SI-WF18-Tapped do this later")


		._atCategoryPage()
		.defaultCategories("SI-WF18-Tapped Custom category")
		.tapComplete("SI-WF18-Tapped Complete")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF18-Tapped take me home")   

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF18-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF18-select added location")
		.TapOnDone("SI-WF18-Tapped Done")
		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to multiple  locations and Suggested category.
	 * Validating all items are displayed on corresponding location at Track Inventory
	 * Validating  suggested category is displayed at Track Inventory
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI-WF37"},priority=35, description = "SI-WF37-Start from scratch+ Multiple lists +Custom location +Suggested category")
	public void SI_WF37_StartFromScratch_MultipleList_CustomLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData4");	  
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");

		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF37-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF37-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF37-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF37-Clicked account")

		._atAccountsPage()
		.Sixth_AccountSelection(loginData.UserName,"SI-WF37-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF37-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF37-Tapped Skip1")

		.StartFromScratch("SI-WF37-ScratchSelected")
		.tapContinue("SI-WF37-Tapped Continue1")
		.Scratch_AddItems("SI-WF37-Tapped Add items")
		//nonsysco item addition
		.AddItemFrom_NonSysco("SI-WF37-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF37-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF37-select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF37-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF37-AddVendorDetails")
		.TapOnDone("SI-WF37-Tapped Done1")
		.TapOnBack("SI-WF37-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF37-SupplierSelect")
		.TapOnDone("SI-WF37-Tapped Done2")

		//prepitem addition
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF37-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF37-Tapped Prep")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF37-PrepItemAddPage")
		.TapOnDone("SI-WF37-Tapped Done3")

		.Setup_AddItemsLink("SI-WF37-Add items Selected")
		.SearchItem(searchData.keyword,"SI-WF37-Search item")
		.SelectItemFrom_Catalog("SI-WF37-Selected item from catalog")
		.TapOnDone("SI-WF37-Tapped Done4")

		.Setup_AddItemsLink("SI-WF37-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF37-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF37-Selected item from OG")

		//verifications
		.verifySearchItemsOnSetupInv("SI-WF37-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI-WF37-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF37-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF37-Verify nonsysco item selected")


		.TapOnDone("SI-WF37-Tapped Done6")


		._atLocationsPage()
		.CustomLocation("SI-WF37-Tapped Custom location")
		.tapContinue("SI-WF37-Tapped Continue2")

		.EnterLocationName(locationsData.LocationName,"SI-WF37-Enter location name")
		.AddLocations1_TypeDry("SI-WF37-Tapped Dry1")

		.AddLocations2()
		.AddLocations2_name(locationsData1.LocationName)
		.AddLocations2_TypeDry("SI-WF37-Tapped Dry2")
		.TapOnNext("SI-WF37-Tapped Next1")

		.AssignMultipleListItemsToLocation("SI-WF37-Selected Multiple items to Location1")
		.TapOnNext("SI-WF37-Tapped Next2")
		.AllItemsTabClick("SI-WF37-Tapped Next2")

		.AssignMultipleListItemsToLocation("SI-WF37-Selected Multiple items to Location2")
		.TapOnDone("SI-WF37-Tapped Done7")


		._atCategoryPage()
		.SuggestedCategories("SI - WF 37-TC1-SuggestedCategories Tapped")
		.tapContinue("SI - WF 37-TC1-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI - WF 37-TC1-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF37-Selected track inventory")


		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF37-Select added location1")
		.VerifyMultipleListItemsInLocation("SI-WF37-Verifying Multiple items in Location1")
		.TapOnBack("SI-WF37-Tapped back2")
		.SelectLocation(locationsData1.LocationName, "SI-WF37-Select added location2")
		.VerifyMultipleListItemsInLocation("SI-WF37-Verifying Multiple items in Location2")
		.SyscoCategoryIdentify("SI-WF37-Identifying categories")
		._atCategoryPage()
		.VerifyMultipleListSyscoSuggestedCategory("SI-WF37-Verifying categories")
		;
	}

	/*
	 * Validating user is able to setup inventory by adding items from StartFromScratch (Pdt catalog+ OG+ Prep+ NonSysco items) and then assign those items to Default  locations and Suggested category.
	 * Validating Non sysco and Prep items are displayed on No location at Track Inventory
	 * Validating  suggested category list on Categories page
	 * Prerequisite:Normal/MA User with OG items
	 */
	@Test(groups={"SI-WF38"},priority=36, description = "SI-WF38-Start from scratch+ Multiple lists +Default location + Suggested category")
	public void SI_WF38_StartFromScratch_MultipleList_DefaultLocation_SuggestedCategory() {	

		LoginData loginData =LoginData.fetch("LoginData5");	  
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");


		SearchData searchData=SearchData.fetch("SearchData");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");

		Start.asTester
		.goToLoginpage()
		.verifyLoginPage("SI-WF38-LoginPage")
		.saveUsernameCheckBoxClick("SI-WF38-save username")
		.signIn(loginData.UserName, loginData.Password,"SI-WF38-Login")

		._atHomePage()
		.ClickAccount(loginData.UserName,"SI-WF38-Clicked account")

		._atAccountsPage()
		.First_AccountSelection(loginData.UserName,"SI-WF38-ThirdAccountSelect")

		._atInventoryToolPage()
		.InvTools_SetUpInventory("SI-WF38-SetupInventoryTap")

		._atSetupInventoryPage()
		.TapOnSkip("SI-WF38-Tapped Skip1")

		.StartFromScratch("SI-WF38-ScratchSelected")
		.tapContinue("SI-WF38-Tapped Continue1")
		.Scratch_AddItems("SI-WF38-Tapped Add items")
		//nonsysco item addition
		.AddItemFrom_NonSysco("SI-WF38-Tapped NonSysco")
		.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI-WF38-NonSyscoItem details entered")
		.AddSupplier_AddProductDetailsPage("SI-WF38-select supplier")

		._atVendorPage()
		.Add_Supplier("SI-WF38-AddVendorTap")
		.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI-WF38-AddVendorDetails")
		.TapOnDone("SI-WF38-Tapped Done on add supplier page")
		.TapOnBack("SI-WF38-Tapped Back1")
		.SupplierSelect(vendorDetailsData.VendorName,"SI-WF38-SupplierSelect")
		.TapOnDone("SI-WF38-Tapped Done2")

		//prepitem addition
		._atSetupInventoryPage()
		.Setup_AddItemsLink("SI-WF38-Add items Selected")
		.AddItemFrom_PrepItem("SI-WF38-Tapped Prepitem")
		.EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI-WF38-PrepItemAddPage")
		.TapOnDone("SI-WF38-Tapped Done3")

		.Setup_AddItemsLink("SI-WF38-Add items Selected")
		.SearchItem(searchData.keyword,"SI-WF38-Search item")
		.SelectItemFrom_Catalog("SI-WF38-Selected item from catalog")
		.TapOnDone("SI-WF38-Tapped Done4")

		.Setup_AddItemsLink("SI-WF38-Add items Selected")
		.AddItemFrom_OrderGuide("SI-WF38-Tapped Order Guide")
		.SelectItemFrom_OrderGuide("SI-WF38-Selected item from OG")


		//verifications  

		.verifySearchItemsOnSetupInv("SI-WF38-Verify catalog item selected")
		.verifyOGItemsOnSetupInv("SI-WF38-Verify OG item selected")

		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF38-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF38-Verify nonsysco item selected")


		.TapOnDone("SI-WF38-Tapped Done6")

		._atLocationsPage()
		.DefaultLocation("SI-WF38-Tapped Custom location")
		.tapContinue("SI-WF38-Tapped Continue2")


		._atCategoryPage()
		.SuggestedCategories("SI-WF38-SuggestedCategories Tapped")
		.tapContinue("SI-WF38-Tapped Continue3")

		._atSetupInventoryPage()
		.TapTakeHome("SI-WF38-Tapped Take me Home")

		._atInventoryToolPage()
		.InvTools_TrackInventory("SI-WF38-Selected track inventory")

		._atLocationsPage()
		.SelectLocation(locationsData.LocationName, "SI-WF38-Select added location1")
		._atSetupInventoryPage()
		.verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI-WF38-Verify prep item selected")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI-WF38-Verify nonsysco item selected")
		.TapOnDone("SI - WF 38-TC1-Tapped Done")

		._atCategoryPage()
		.TapOnBack("SI-WF38-Tapped back")
		._atInventoryToolPage()
		.InvTools_Category("SI-WF38-Tapped Categories")
		._atCategoryPage()
		.VerifySuggestedCategoryList("SI-WF38-Verified Suggested Categories List")
		;

	}

}


