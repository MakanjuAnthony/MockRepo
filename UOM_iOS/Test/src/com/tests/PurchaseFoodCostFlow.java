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


public class PurchaseFoodCostFlow extends Initiator{
	 /*
	  * Validating user is able to add purchase and Food cost
	  * //INV_071,INV_072//INV_139,INV_140 validations
	  */


	 @Test(groups={"FC1"},priority=0, description = "MP - WF 1-Purchases-FoodCost")
	 public void MP_WF1_OG_DefaultLoc_DefaultCat_Track_UpdateQty_Purchases_FoodCost()
	 {
		 LoginData loginData =LoginData.fetch("LoginData12");
		 LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		 LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		 LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		 UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
		 UOMQuantityData uomQuantityData3=UOMQuantityData.fetch("UOMQuantityData3");
		 VendorDetailsData vendorData=VendorDetailsData.fetch("VendorDetailData1");
		 PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");

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

		 .TapOrderGuide("SI - WF 1-OG Selected")
		 .tapContinue("SI - WF 1-Tapped Continue")


		 ._atLocationsPage()
		 .DefaultLocation("SI - WF 1-Tapped Custom location")
		 .tapContinue("SI - WF 1-Tapped Continue")


		 ._atCategoryPage()
		 .defaultCategories("SI - WF 1-Tapped Default category")
		 .tapComplete("SI - WF 1-Tapped Complete")

		 ._atSetupInventoryPage()
		 .TapTakeHome("SI - WF 1-Tapped take me home")   

		 ._atInventoryToolPage()
		 .InvTools_TrackInventory("SI - WF 1-Selected track inventory")

		 ._atLocationsPage()
		 .SelectLocation(locDataCooler.LocationName, "SI - WF 1-Selected cooler")
		 .ProductQtyEnter(uomQuantityData.Quantity,"TI-WF1-WF2-Entering Quantity1")
		 .UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
		 .TapOnDone("TI-WF1-WF2-Tapped done")
		 .TapOnBack("SI - WF 1-Tapped on Back")

		 ._atInventoryToolPage()
		 .InvTools_CloseInventory("Tapped close inventory")
		 .InvTools_ClosedInventoryYes("Tapped Yes,Close")
		 /*.InvTools_CloseInventory("Tapped close inventory")
		.InvTools_ClosedInventoryYes("Tapped Yes,Close")
		  */.InvTools_TrackInventory("SI - WF 1-Selected track inventory")


		  ._atLocationsPage()
		  .SelectLocation(locDataFreezer.LocationName, "SI - WF 1-Selected cooler")
		  .ProductQtyEnter(uomQuantityData3.Quantity,"TI-WF1-WF2-Entering Quantity1")
		  .UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
		  .TapOnDone("TI-WF1-WF2-Tapped done")
		  .TapOnBack("SI - WF 1-Tapped on Back")

		  ._atInventoryToolPage()
		  .InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers")
		  ._atVendorPage()
		  .Add_Supplier("MSP-1,MSP-2-Add button clicked")
		  .AddSupplier_Details(vendorData.VendorName, vendorData.PhoneNum, vendorData.Address, vendorData.ContactInfo, vendorData.Email, vendorData.Note, "MSP-1,MSP-2-Vendor details added")
		  .TapOnDone("MSP-1,MSP-2-Done tapped")
		  .TapOnBack("MSP-1,MSP-2-Back tapped")
		  .TapOnBack("MSP-1,MSP-2-Back tapped")

		  ._atInventoryToolPage()
		  .InvTools_Purchases("Tapped on purchase")

		  //INV_139,INV_140 validations
		  ._atPurchasesPage()
		  .AddPurchases("Tapped on Add purchase")
		  .SupplierSelect("Selected supplier")
		  .DateSelect(purchasesData.Day,purchasesData.Month,purchasesData.Year,"Date selected")
		  .ExpenseCategorySelect(purchasesData.Category1,"Selected Food category")
		  .EnterExpenseAmount(purchasesData.ExpenseAmt1, "Entered expense amount")
		  .AddExpenseCategory("Tapped add button")
		  .ExpenseCategorySelect(purchasesData.Category2,"Selected Non Food category")
		  .EnterExpenseAmount(purchasesData.ExpenseAmt2, "Entered expense amount")
		  .AddExpenseCategory("Tapped add button")
		  /*.PurchaseDetails(purchasesData.InvoiceNumber,purchasesData.InvTotal1,"Entered purchase details")
		.TapOnDone("Tapped on done")
		//verify error msg
		   */.PurchaseDetails(purchasesData.InvoiceNumber,purchasesData.InvoiceTotal,"Entered purchase details")
		   .TapOnDone("Tapped on done")

		   .TapNoAddingPurchase("Tapped No adding purchase")
		   ._atVendorPage()
		   .TapOnBack("MSP-1,MSP-2-Back tapped")

		   ._atInventoryToolPage()
		   .InvTools_CloseInventory("Tapped close inventory")
		   .InvTools_ClosedInventoryYes("Tapped Yes,Close")
		   .InvTools_FoodCost("Tapped food cost")

		   ._atFoodCostPage()
		   .VerifyTotalPurchase(purchasesData.ExpenseAmt1,"verify total purchase value")
		   .VerifyNetPurchases("verify net purchase value")
		   .VerifyCostOfGoodsSold("verify cost of goods sold value")
		   .EnterRevenue(purchasesData.Revenue1, "Entered Revenue") 
		   .CalculateFoodCost("Calculated food cost")

		   //INV_071,INV_072
		   .TapOnBack("Tapped back")
		   ._atInventoryToolPage()
		   .InvTools_TrackInventory("SI - WF 1-Selected track inventory")
		   ._atLocationsPage()
		   .SelectLocation(locDataDry.LocationName, "SI - WF 1-Selected cooler")
		   .ProductQtyEnter(uomQuantityData3.Quantity,"TI-WF1-WF2-Entering Quantity1")
		   .UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
		   .TapOnDone("TI-WF1-WF2-Tapped done")
		   .TapOnBack("SI - WF 1-Tapped on Back")
		   ._atInventoryToolPage()
		   .InvTools_CloseInventory("Tapped close inventory")
		   .InvTools_ClosedInventoryYes("Tapped Yes,Close")
		   .InvTools_FoodCost("Tapped food cost")
		   ._atFoodCostPage()
		   .VerifyCurrentAndLastclosedPrice("Verify current price =  price when the inventory closed")

		   ;
	 }
	 /*
	  * Validating user is able to add purchase and Food cost
	  * //INV_035,36 validations
	  */
	 @Test(groups={"FC2"},priority=0, description = "MP - WF 1-Purchases-FoodCost")
	 public void MP_WF2_OG_CustomLoc_SuggestedCat_Track_UpdateQty_Purchases_FoodCost()
	 {
		 LoginData loginData =LoginData.fetch("LoginData13");
		 LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
		 LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
		 LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
		 UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
		 UOMQuantityData uomQuantityData3=UOMQuantityData.fetch("UOMQuantityData3");
		 VendorDetailsData vendorData=VendorDetailsData.fetch("VendorDetailData1");
		 PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
		 LocationsData locationsData1 =LocationsData.fetch("LocatiosData1");
		 LocationsData locationsData2 =LocationsData.fetch("LocatiosData2");
		/* CategoryData categoryData=CategoryData.fetch("CategoryData");
*/
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

		 .TapOrderGuide("SI - WF 1-OG Selected")
		 .tapContinue("SI - WF 1-Tapped Continue")


		 
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
		 .TapOnDone("SI - WF 21-Tapped Done1")

		 ._atCategoryPage()
		 .SuggestedCategories("SI - WF 33-SuggestedCategories Tapped")
		 .tapContinue("SI - WF 33-Tapped Continue3")

		 ._atSetupInventoryPage()

		 .TapTakeHome("SI - WF 3-Tapped Continue4") 


		 ._atInventoryToolPage()
		 .InvTools_TrackInventory("SI - WF 1-Selected track inventory")

		 ._atLocationsPage()
		// .SelectLocation(locationsData1.LocationName, "SI - WF 1-Selected cooler")
		  .SelectLocation(locDataCooler.LocationName, "SI - WF 1-Selected cooler")
		 .ProductQtyEnter(uomQuantityData.Quantity,"TI-WF1-WF2-Entering Quantity1")
		 .UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
		 .TapOnDone("TI-WF1-WF2-Tapped done")
		 .TapOnBack("SI - WF 1-Tapped on Back")

		 ._atInventoryToolPage()
		 .InvTools_CloseInventory("Tapped close inventory")
		 .InvTools_ClosedInventoryYes("Tapped Yes,Close")
		 
		 .InvTools_TrackInventory("SI - WF 1-Selected track inventory")
		 ._atLocationsPage()
		// .SelectLocation(locationsData2.LocationName, "SI - WF 1-Selected cooler")
		   .SelectLocation(locDataDry.LocationName, "SI - WF 1-Selected cooler")
		 .ProductQtyEnter(uomQuantityData3.Quantity,"TI-WF1-WF2-Entering Quantity1")
		 .UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
		 .TapOnDone("TI-WF1-WF2-Tapped done")
		 .TapOnBack("SI - WF 1-Tapped on Back")

		 ._atInventoryToolPage()
		 .InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers")
		 ._atVendorPage()
		 .Add_Supplier("MSP-1,MSP-2-Add button clicked")
		 .AddSupplier_Details(vendorData.VendorName, vendorData.PhoneNum, vendorData.Address, vendorData.ContactInfo, vendorData.Email, vendorData.Note, "MSP-1,MSP-2-Vendor details added")
		 .TapOnDone("MSP-1,MSP-2-Done tapped")
		 .TapOnBack("MSP-1,MSP-2-Back tapped")
		 .TapOnBack("MSP-1,MSP-2-Back tapped")

		 ._atInventoryToolPage()
		 .InvTools_Purchases("Tapped on purchase")


		 ._atPurchasesPage()
		 .AddPurchases("Tapped on Add purchase")
		 .SupplierSelect("Selected supplier")
		 .DateSelect(purchasesData.Day,purchasesData.Month,purchasesData.Year,"Date selected")
		 .ExpenseCategorySelect(purchasesData.Suggcat,"Selected Food category")
		 .EnterExpenseAmount(purchasesData.ExpenseAmt1, "Entered expense amount")
		 .AddExpenseCategory("Tapped add button")
		 /*.ExpenseCategorySelect(purchasesData.Category2,"Selected Non Food category")
		 .EnterExpenseAmount(purchasesData.ExpenseAmt2, "Entered expense amount")
		 .AddExpenseCategory("Tapped add button")
		*/ .PurchaseDetails(purchasesData.InvoiceNumber,purchasesData.InvoiceTotal,"Entered purchase details")
		 .TapOnDone("Tapped on done")

		 .TapNoAddingPurchase("Tapped No adding purchase")
		 ._atVendorPage()
		 .TapOnBack("MSP-1,MSP-2-Back tapped")

		 ._atInventoryToolPage()
		 .InvTools_CloseInventory("Tapped close inventory")
		 .InvTools_ClosedInventoryYes("Tapped Yes,Close")
		 .InvTools_FoodCost("Tapped food cost")

		 ._atFoodCostPage()
		 .VerifyTotalPurchase(purchasesData.ExpenseAmt1,"verify total purchase value")
		 .VerifyNetPurchases("verify net purchase value")
		 .VerifyCostOfGoodsSold("verify cost of goods sold value")
		 .EnterRevenue(purchasesData.Revenue1, "Entered Revenue") 
		 .CalculateFoodCost("Calculated food cost")
		 .TapOnBack("Tapped back")

		 ._atInventoryToolPage()
		 .InvTools_TrackInventory("SI - WF 1-Selected track inventory")

		 ._atLocationsPage()
		 .SelectLocation(locDataCooler.LocationName,"TI-WF1-WF2-Selected location for update verify")
		 .QuantityVerify(uomQuantityData.Quantity,"TI-WF1-WF2-Verifying Quantity2")
		 .TapOnBack("Tapped on back")
		 .SelectLocation(locDataDry.LocationName,"TI-WF1-WF2-Selected location for update verify")
		 .QuantityVerify(uomQuantityData3.Quantity,"TI-WF1-WF2-Verifying Quantity2")
		 .TapOnBack("Tapped on back")
		 ;
	 }


		@Test(groups={"MP_WF2"},priority=0, description = "MP - WF 2-Purchases-FoodCost")
		public void MP_WF3_CustomList_DefaultLoc_DefaultCat_Track_UpdateQty_Purchases_FoodCost()
		{
			LoginData loginData =LoginData.fetch("LoginData11");
			LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
			LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
			LocationsData locDataDry=LocationsData.fetch("LocatiosData7");
			UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
			UOMQuantityData uomQuantityData3=UOMQuantityData.fetch("UOMQuantityData3");
			VendorDetailsData vendorData=VendorDetailsData.fetch("VendorDetailData1");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
			ListData listData=ListData.fetch("ListData");
			
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

			._atListPage()
			.TapCustomList("SI - WF 19-custom list Selected")
			.tapContinue("SI - WF 19-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "SI - WF 19-select list")
			.TapOnNext("SI - WF 19-tapped next")


			._atLocationsPage()
			.DefaultLocation("SI - WF 1-Tapped Custom location")
			.tapContinue("SI - WF 1-Tapped Continue")


			._atCategoryPage()
				.defaultCategories("SI - WF 1-Tapped Default category")
			.tapComplete("SI - WF 1-Tapped Complete")

			._atSetupInventoryPage()
			.TapTakeHome("SI - WF 1-Tapped take me home")   

			._atInventoryToolPage()
			.InvTools_TrackInventory("SI - WF 1-Selected track inventory")

			._atLocationsPage()
			.SelectLocation(locDataCooler.LocationName, "SI - WF 1-Selected cooler")
			.ProductQtyEnter(uomQuantityData.Quantity,"TI-WF1-WF2-Entering Quantity1")
			.UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
			.TapOnDone("TI-WF1-WF2-Tapped done")
			.TapOnBack("SI - WF 1-Tapped on Back")
		
			._atInventoryToolPage()
			.InvTools_CloseInventory("Tapped close inventory")
			.InvTools_ClosedInventoryYes("Tapped Yes,Close")
			.InvTools_CloseInventory("Tapped close inventory")
			.InvTools_ClosedInventoryYes("Tapped Yes,Close")
			.InvTools_TrackInventory("SI - WF 1-Selected track inventory")
			._atLocationsPage()
			.SelectLocation(locDataFreezer.LocationName, "SI - WF 1-Selected cooler")
			.ProductQtyEnter(uomQuantityData3.Quantity,"TI-WF1-WF2-Entering Quantity1")
			.UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-Entering Uom unit OZ")
			.TapOnDone("TI-WF1-WF2-Tapped done")
			.TapOnBack("SI - WF 1-Tapped on Back")
		
			._atInventoryToolPage()
			.InvTools_Suppliers("MSP-1,MSP-2-Tapped on suppliers")
			._atVendorPage()
			.Add_Supplier("MSP-1,MSP-2-Add button clicked")
			.AddSupplier_Details(vendorData.VendorName, vendorData.PhoneNum, vendorData.Address, vendorData.ContactInfo, vendorData.Email, vendorData.Note, "MSP-1,MSP-2-Vendor details added")
			.TapOnDone("MSP-1,MSP-2-Done tapped")
			.TapOnBack("MSP-1,MSP-2-Back tapped")
			.TapOnBack("MSP-1,MSP-2-Back tapped")
			
			._atInventoryToolPage()
			.InvTools_Purchases("Tapped on purchase")
			
			
			._atPurchasesPage()
			.AddPurchases("Tapped on Add purchase")
			.SupplierSelect("Selected supplier")
			.DateSelect(purchasesData.Day,purchasesData.Month,purchasesData.Year,"Date selected")
			.ExpenseCategorySelect(purchasesData.Category1,"Selected Food category")
			.EnterExpenseAmount(purchasesData.ExpenseAmt1, "Entered expense amount")
			.AddExpenseCategory("Tapped add button")
			.ExpenseCategorySelect(purchasesData.Category2,"Selected Non Food category")
			.EnterExpenseAmount(purchasesData.ExpenseAmt2, "Entered expense amount")
			.AddExpenseCategory("Tapped add button")
			.PurchaseDetails(purchasesData.InvoiceNumber,purchasesData.InvTotal1,"Entered purchase details")
			.TapOnDone("Tapped on done")
			
			.TapNoAddingPurchase("Tapped No adding purchase")
			.VerifyPurchaseAdded("verify purchase added")
			
			._atVendorPage()
			.TapOnBack("MSP-1,MSP-2-Back tapped")
			
			._atInventoryToolPage()
			.InvTools_CloseInventory("Tapped close inventory")
			.InvTools_ClosedInventoryYes("Tapped Yes,Close")
			.InvTools_FoodCost("Tapped food cost")
			
			._atFoodCostPage()
			.VerifyTotalPurchase(purchasesData.ExpenseAmt1,"verify total purchase value")
			.VerifyNetPurchases("verify net purchase value")
			.VerifyCostOfGoodsSold("verify cost of goods sold value")
			.EnterRevenue(purchasesData.Revenue1, "Entered Revenue") 
			.CalculateFoodCost("Calculated food cost")
			
			
			;
		}

		
		/*
		 * Validating user is able to close inventory and verify Food cost
		 */
		
		
		@Test(groups={"FC-WF1"},priority=0, description = "FC-WF1-TrackInventory-FoodCost")
		public void FC_WF1_OG_CustomLoc_DefaultCategory_TrackInventory_FoodCost()
		{
			LoginData loginData =LoginData.fetch("LoginData3");
			LocationsData locationsData1 =LocationsData.fetch("LocationsData");
			LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
			UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
			UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData2");
			UOMQuantityData uomQuantityData2=UOMQuantityData.fetch("UOMQuantityData3");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
			NonSyscoItemData nonSyscoItemData1 =NonSyscoItemData.fetch("NonSyscoItmData1");
			LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
			LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
			LocationsData  locDataDry=LocationsData.fetch("LocatiosData7");
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("FC-WF1-LoginPage")
			.saveUsernameCheckBoxClick("FC-WF1-save username")
			.signIn(loginData.UserName, loginData.Password,"FC-WF1-Login")

			._atHomePage()
			.ClickAccount(loginData.UserName,"FC-WF1-Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"FC-WF1-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("FC-WF1-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("FC-WF1-Skip1 Tapped")

			.TapOrderGuide("FC-WF1-OG Selected")
			.tapContinue("FC-WF1-Tapped Continue")

			._atLocationsPage()
			.CustomLocation("FC-WF1-Tapped Custom location")
			.tapContinue("FC-WF1-Tapped Continue2")

			.EnterLocationName(locationsData1.LocationName,"FC-WF1-Enter location name")
			.AddLocations1_TypeDry("FC-WF1-Tapped Dry1")

			.AddLocations2("")
			.AddLocations2_name(locationsData2.LocationName,"")
			.AddLocations2_TypeDry("FC-WF1-Tapped Dry2")
			.TapOnNext("FC-WF1-Tapped Next1")

			.selectMultipleItemsFromLocation1("FC-WF1-Selected Multiple items")
			.TapOnNext("FC-WF1-Tapped Next2")

			.selectMultipleItemsFromLocation2("FC-WF1-Selected Multiple items")
			.TapOnDone("FC-WF1-Tapped Done1")

			._atCategoryPage()
			.defaultCategories("FC-WF1-Tapped Default category")
			.tapComplete("FC-WF1-Tapped Complete")


			._atSetupInventoryPage()
			.TapTakeHome("FC-WF1-Tapped take me home")   

	    /*
			//inv_127,129,278,280 
			
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF2-Selected track inventory")
	//adding nonsyscoitem with nonfood category 
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF2-Selected cooler")
			.TapAddLocation("FC-WF6-Tapped ADD")
			._atSetupInventoryPage()
			.AddItemFrom_NonSysco("FC-WF6-Tapped NonSysco")
			.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "FC-WF6-NonSyscoItem details entered")
			.AddSupplier_AddProductDetailsPage("FC-WF6-select supplier")
			._atVendorPage()
			.Add_Supplier("FC-WF6-AddVendorTap")
			.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "FC-WF6-AddVendorDetails")
			.TapOnDone("FC-WF6-Done")
			.TapOnBack("FC-WF6-Back")
			.SupplierSelect(vendorDetailsData.VendorName,"FC-WF6-SupplierSelect")
			._atLocationsPage()
			.AddCategory_AddProductDetailsPage("MEC-WF1-CategorySelect")
			._atCategoryPage()
			.SelectCategory(nonSyscoItemData.Category2, "MEC-WF1-Select Category Name")
			.TapOnDone("")
			.TapOnBack("")
		
			//adding nonsyscoitem with food category 
					._atLocationsPage()
					.SelectLocation(locationsData2.LocationName, "FC-WF2-Selected cooler")
					.TapAddLocation("FC-WF6-Tapped ADD")
					._atSetupInventoryPage()
					.AddItemFrom_NonSysco("FC-WF6-Tapped NonSysco")
					.EnterItemDetails(nonSyscoItemData1.ProductName, nonSyscoItemData1.UPC, nonSyscoItemData1.Pack, nonSyscoItemData1.Size, nonSyscoItemData1.Weight, nonSyscoItemData1.Price, nonSyscoItemData1.ProductBrand, "FC-WF6-NonSyscoItem details entered")
					.AddSupplier_AddProductDetailsPage("FC-WF6-select supplier")
				//	._atVendorPage()
				//	.Add_Supplier("FC-WF6-AddVendorTap")
				//	.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "FC-WF6-AddVendorDetails")
				//	.TapOnDone("FC-WF6-Done")
				//	.TapOnBack("FC-WF6-Back")
					._atVendorPage()
					.SupplierSelect(vendorDetailsData.VendorName,"FC-WF6-SupplierSelect")
					._atLocationsPage()
					.AddCategory_AddProductDetailsPage("MEC-WF1-CategorySelect")
					._atCategoryPage()
					.SelectCategory(nonSyscoItemData1.Category2, "MEC-WF1-Select Category Name")
					.TapOnDone("")
					.TapOnBack("")	
			
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF2-Selected cooler")
			.ItemQtyEnterById(nonSyscoItemData.UPC,uomQuantityData.Quantity,"FC-WF2-Entering Quantity1 to food item")
			.TapOnDone("FC-WF2-Tapped done")
					
			.SelectLocation(locationsData2.LocationName, "FC-WF2-Selected cooler")
			.ItemQtyEnterById(nonSyscoItemData1.UPC,uomQuantityData.Quantity,"FC-WF2-Entering Quantity1 to food item")
			.TapOnDone("FC-WF2-Tapped done")
					
			.TapOnBack("FC-WF2-Tapped on Back")
					
			
		
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF2-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF2-Tapped Yes,Close")
		
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF2-Selected track inventory")

			
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF2-Selected cooler")
			.ItemQtyEnterById(nonSyscoItemData.UPC,uomQuantityData1.Quantity,"FC-WF2-Entering Quantity1 to food item")
			.TapOnDone("FC-WF2-Tapped done")
			
			
			._atLocationsPage()
			.SelectLocation(locationsData2.LocationName, "FC-WF2-Selected cooler")
			.ProductSelect(nonSyscoItemData1.ProductName, "WF1")
			.TapOnEdit("WF1")
			.PdtDetailPage_Location1_EnterQty(uomQuantityData1.Quantity, locationsData2.LocationName, "FC-WF2-Edited qty")
			.TapOnDone("FC-WF2-Tapped done")
			.TapOnBack("FC-WF2-Tapped on Back")
			.TapOnBack("FC-WF2-Tapped on Back")
			
			
			.TapOnBack("FC-WF2-Tapped on Back")
			
			
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF2-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF2-Tapped Yes,Close")
		
			.InvTools_FoodCost("FC-WF2-Tapped food cost")
			
			._atFoodCostPage()
			.VerifyBeginningInventory(uomQuantityData.Quantity, nonSyscoItemData1.Price, "")
			.VerifyEndingInventory(uomQuantityData1.Quantity, nonSyscoItemData1.Price, "")
			.VerifyNetPurchases("FC-WF2-Verify net purchase value")
			.VerifyCostOfGoodsSold("FC-WF2-Verify cost of goods sold value")
			.EnterRevenue(purchasesData.Revenue1, "FC-WF2-Entered Revenue")
			.CalculateFoodCost("FC-WF2-Calculated food cost")
			
			*/
			//inv_127,129 OG+Defaultloc+default category---447_1
			
					._atInventoryToolPage()
					.InvTools_TrackInventory("FC-WF1-Selected track inventory")

					._atLocationsPage()
					.SelectLocation(locDataCooler.LocationName, "FC-WF1-Selected cooler")
					.ProductQtyEnter(uomQuantityData2.Quantity,"FC-WF1-Entering Quantity1")
					.TapOnDone("FC-WF1-Tapped done")
					.TapOnBack("FC-WF1-Tapped on Back")
				
					._atInventoryToolPage()
					.InvTools_CloseInventory("FC-WF1-Tapped close inventory")
					.InvTools_ClosedInventoryYes("FC-WF1-Tapped Yes,Close")
				
					._atInventoryToolPage()
					.InvTools_TrackInventory("FC-WF1-Selected track inventory")

					._atLocationsPage()
					.SelectLocation(locDataCooler.LocationName, "FC-WF1-Selected cooler")
					.SelectItemFromLocations("FC-WF1-Selected first product")
					.TapOnEdit("")
					.PdtDetailPage_Location1_EnterQty(uomQuantityData1.Quantity, locDataCooler.LocationName, "FC-WF1-Edited qty")
					.TapOnDone("FC-WF1-Tapped done")
					.TapOnBack("FC-WF1-Tapped on Back")
					.TapOnBack("FC-WF1-Tapped on Back")
					.TapOnBack("FC-WF1-Tapped on Back")
					._atInventoryToolPage()
					.InvTools_CloseInventory("FC-WF1-Tapped close inventory")
					.InvTools_ClosedInventoryYes("FC-WF1-Tapped Yes,Close")
				
					.InvTools_FoodCost("FC-WF1-Tapped food cost")
					
					._atFoodCostPage()
					.VerifyNetPurchases("FC-WF1-Verify net purchase value")
					.VerifyCostOfGoodsSold("FC-WF1-Verify cost of goods sold value")
					.EnterRevenue(purchasesData.Revenue1, "FC-WF1-Entered Revenue")
					.CalculateFoodCost("FC-WF1-Calculated food cost")
					
			
			;
		}
		
		
		/*
		 * Validating user is able to close inventory and verify Food cost
		 */
		
		
		@Test(groups={"FC-WF3"},priority=0, description = "FC-WF3-TrackInventory-FoodCost")
		public void FC_WF3_OG_CustomLoc_SuggestedCategory_TrackInventory_FoodCost()
		{
			LoginData loginData =LoginData.fetch("LoginData4");
			LocationsData locationsData1 =LocationsData.fetch("LocationsData");
			LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
			UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
			UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData2");
			UOMQuantityData uomQuantityData2=UOMQuantityData.fetch("UOMQuantityData3");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
			NonSyscoItemData nonSyscoItemData1 =NonSyscoItemData.fetch("NonSyscoItmData1");
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("FC-WF3-LoginPage")
			.saveUsernameCheckBoxClick("FC-WF3-save username")
			.signIn(loginData.UserName, loginData.Password,"FC-WF3-Login")

			._atHomePage()
			.ClickAccount(loginData.UserName,"FC-WF3-Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"FC-WF3-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("FC-WF3-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("FC-WF3-Skip1 Tapped")

			.TapOrderGuide("FC-WF3-OG Selected")
			.tapContinue("FC-WF3-Tapped Continue")

			._atLocationsPage()
			.CustomLocation("FC-WF3-Tapped Custom location")
			.tapContinue("FC-WF3-Tapped Continue2")

			.EnterLocationName(locationsData1.LocationName,"FC-WF3-Enter location name")
			.AddLocations1_TypeDry("FC-WF3-Tapped Dry1")

			.AddLocations2("")
			.AddLocations2_name(locationsData2.LocationName,"")
			.AddLocations2_TypeDry("FC-WF3-Tapped Dry2")
			.TapOnNext("FC-WF3-Tapped Next1")

			.selectMultipleItemsFromLocation1("FC-WF3-Selected Multiple items")
			.TapOnNext("FC-WF3-Tapped Next2")

			.selectMultipleItemsFromLocation2("FC-WF3-Selected Multiple items")
			.TapOnDone("FC-WF3-Tapped Done1")

			._atCategoryPage()
			.SuggestedCategories("FC-WF3-SuggestedCategories Tapped")
			.tapContinue("FC-WF3-Tapped Continue3")


			._atSetupInventoryPage()
			.TapTakeHome("FC-WF3-Tapped take me home")   

	    
			//inv_274,276
			
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF3-Selected track inventory")
	//adding nonsyscoitem with nonfood category 
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF3-Selected cooler")
			.TapAddLocation("FC-WF3-Tapped ADD")
			._atSetupInventoryPage()
			.AddItemFrom_NonSysco("FC-WF3-Tapped NonSysco")
			.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "FC-WF3-NonSyscoItem details entered")
			.AddSupplier_AddProductDetailsPage("FC-WF3-select supplier")
			._atVendorPage()
			.Add_Supplier("FC-WF3-AddVendorTap")
			.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "FC-WF3-AddVendorDetails")
			.TapOnDone("FC-WF3-Done")
			.TapOnBack("FC-WF3-Back")
			.SupplierSelect(vendorDetailsData.VendorName,"FC-WF3-SupplierSelect")
			._atLocationsPage()
			.AddCategory_AddProductDetailsPage("FC-WF3-CategorySelect")
			._atCategoryPage()
			.SelectCategory(nonSyscoItemData.Category1, "FC-WF3-Select Category Name")
			.TapOnDone("FC-WF3-Tapped done")
			.TapOnBack("FC-WF3-Tapped back")
		
			//adding nonsyscoitem with food category 
					._atLocationsPage()
					.SelectLocation(locationsData2.LocationName, "FC-WF3-Selected cooler")
					.TapAddLocation("FC-WF3-Tapped ADD")
					._atSetupInventoryPage()
					.AddItemFrom_NonSysco("FC-WF3-Tapped NonSysco")
					.EnterItemDetails(nonSyscoItemData1.ProductName, nonSyscoItemData1.UPC, nonSyscoItemData1.Pack, nonSyscoItemData1.Size, nonSyscoItemData1.Weight, nonSyscoItemData1.Price, nonSyscoItemData1.ProductBrand, "FC-WF3-NonSyscoItem details entered")
					.AddSupplier_AddProductDetailsPage("FC-WF3-select supplier")
					/*._atVendorPage()
					.Add_Supplier("FC-WF3-AddVendorTap")
					.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "FC-WF3-AddVendorDetails")
					.TapOnDone("FC-WF3-Done")
					.TapOnBack("FC-WF3-Back")*/
					._atVendorPage()
					.SupplierSelect(vendorDetailsData.VendorName,"FC-WF3-SupplierSelect")
					._atLocationsPage()
					.AddCategory_AddProductDetailsPage("FC-WF3-CategorySelect")
					._atCategoryPage()
					.SelectCategory(nonSyscoItemData1.Category1, "FC-WF3-Select Category Name")
					.TapOnDone("FC-WF3-Tapped done")
					.TapOnBack("FC-WF3-Tapped back")	
			
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF3-Selected cooler")
			.ItemQtyEnterById(nonSyscoItemData.UPC,uomQuantityData.Quantity,"FC-WF3-Entering Quantity1 to food item")
			.TapOnDone("FC-WF3-Tapped done")
					
			.SelectLocation(locationsData2.LocationName, "FC-WF3-Selected cooler")
			.ItemQtyEnterById(nonSyscoItemData1.UPC,uomQuantityData.Quantity,"FC-WF3-Entering Quantity1 to food item")
			.TapOnDone("FC-WF3-Tapped done")
					
			.TapOnBack("FC-WF3-Tapped on Back")
					
			
		
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF3-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF3-Tapped Yes,Close")
		
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF3-Selected track inventory")

	/*		//editing pdt card
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF1-Selected cooler")
			.ProductSelect(nonSyscoItemData.ProductName, "")
			.TapOnEdit("")
			.PdtDetailPage_Location1_EnterQty(uomQuantityData1.Quantity, locationsData1.LocationName, "FC-WF1-Edited qty")
			.TapOnDone("FC-WF1-Tapped done")
			.TapOnBack("FC-WF1-Tapped on Back")
			.TapOnBack("FC-WF1-Tapped on Back")
			
			._atLocationsPage()
			.SelectLocation(locationsData2.LocationName, "FC-WF1-Selected cooler")
			.ProductSelect(nonSyscoItemData1.ProductName, "")
			.TapOnEdit("")
			.PdtDetailPage_Location1_EnterQty(uomQuantityData1.Quantity, locationsData2.LocationName, "FC-WF1-Edited qty")
			.TapOnDone("FC-WF1-Tapped done")
			.TapOnBack("FC-WF1-Tapped on Back")
			.TapOnBack("FC-WF1-Tapped on Back")
			*/
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF3-Selected cooler")
			.ItemQtyEnterById(nonSyscoItemData.UPC,uomQuantityData1.Quantity,"FC-WF3-Entering Quantity1 to food item")
			.TapOnDone("FC-WF3-Tapped done")
					
			.SelectLocation(locationsData2.LocationName, "FC-WF3-Selected cooler")
			.ItemQtyEnterById(nonSyscoItemData1.UPC,uomQuantityData1.Quantity,"FC-WF3-Entering Quantity1 to food item")
			.TapOnDone("FC-WF3-Tapped done")
				
			
			.TapOnBack("FC-WF3-Tapped on Back")
			
			
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF3-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF3-Tapped Yes,Close")
		
			.InvTools_FoodCost("FC-WF3-Tapped food cost")
			
			._atFoodCostPage()
			.VerifyBeginningInventory(uomQuantityData.Quantity, nonSyscoItemData1.Price, "FC-WF3-Verify beginning inventory value")
			.VerifyEndingInventory(uomQuantityData1.Quantity, nonSyscoItemData1.Price, "FC-WF3-Verify ending inventory value")
			.VerifyNetPurchases("FC-WF3-Verify net purchase value")
			.VerifyCostOfGoodsSold("FC-WF3-Verify cost of goods sold value")
			.EnterRevenue(purchasesData.Revenue1, "FC-WF3-Entered Revenue")
			.CalculateFoodCost("FC-WF3-Calculated food cost")
			
			
			;
		}
		
		
		
		
		/*
		 * Validating user is able to close inventory and verify Food cost
		 */
		
		
		@Test(groups={"FC-WF2"},priority=0, description = "FC-WF2-TrackInventory-FoodCost")
		public void FC_WF2_OG_DefaultLoc_CustomCategory_TrackInventory_FoodCost()
		{
			LoginData loginData =LoginData.fetch("LoginData5");
			LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
			LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
			LocationsData  locDataDry=LocationsData.fetch("LocatiosData7");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
			UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData2");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("FC-WF2-LoginPage")
			.saveUsernameCheckBoxClick("FC-WF2-save username")
			.signIn(loginData.UserName, loginData.Password,"FC-WF2-Login")

			._atHomePage()
			.ClickAccount(loginData.UserName,"FC-WF2-Clicked account")

			._atAccountsPage()
			.First_AccountSelection(loginData.UserName,"FC-WF2-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("FC-WF2-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("FC-WF2-Skip1 Tapped")

			.TapOrderGuide("FC-WF2-OG Selected")
			.tapContinue("FC-WF2-Tapped Continue")

			._atLocationsPage()
			.DefaultLocation("FC-WF2-Tapped Custom location")
			.tapContinue("FC-WF2-Tapped Continue")

			._atCategoryPage()
			.CustomCategories("FC-WF2-CustomCategories Tapped")
			.tapContinue("FC-WF2-Tapped Continue")
			.VerifyOptionsOnCreateExpenseCategory("FC-WF2-Verified create custom category Page")
			
			.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "FC-WF2-CreateTwoExpenseCategory")
			.TapOnNext("FC-WF2-Tapped Next")
			.selectMultipleItemsFromCategory1("FC-WF2-selectMultipleItemsFromCategory1")
			.TapOnNext("FC-WF2-Tapped Next")
			.selectMultipleItemsFromCategory2("FC-WF2-selectMultipleItemsFromCategory2")

			._atSetupInventoryPage()
			.TapTakeHome("FC-WF2-Tapped take me home")   
		
	  
			//inv_123,121 OG+Defaultloc+custom category--
			
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF2-Selected track inventory")

			._atLocationsPage()
			.SelectLocation(locDataCooler.LocationName, "FC-WF2-Selected cooler")
			.ProductQtyEnter(uomQuantityData.Quantity,"FC-WF2-Entering Quantity1")
			.TapOnDone("FC-WF2-Tapped done")
			.TapOnBack("FC-WF2-Tapped on Back")
		
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF2-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF2-Tapped Yes,Close")
		
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF2-Selected track inventory")

			._atLocationsPage()
			.SelectLocation(locDataCooler.LocationName, "FC-WF2-Selected cooler")
			.SelectItemFromLocations("FC-WF2-Selected first product")
			.TapOnEdit("FC-WF2-Tapped edit")
			.PdtDetailPage_Location1_EnterQty(uomQuantityData1.Quantity, locDataCooler.LocationName, "FC-WF2-Edited qty")
			.TapOnDone("FC-WF2-Tapped done")
			.TapOnBack("FC-WF2-Tapped on Back")
			.TapOnBack("FC-WF2-Tapped on Back")
			.TapOnBack("FC-WF2-Tapped on Back")
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF2-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF2-Tapped Yes,Close")
		
			.InvTools_FoodCost("FC-WF2-Tapped food cost")
			
			._atFoodCostPage()
			.VerifyNetPurchases("FC-WF2-Verify net purchase value")
			.VerifyCostOfGoodsSold("FC-WF2-Verify cost of goods sold value")
			.EnterRevenue(purchasesData.Revenue1, "FC-WF2-Entered Revenue")
			.CalculateFoodCost("FC-WF2-Calculated food cost")
			
			
			;
		}
		
		
		
		
		
		/*
		 * Validating user is able to close inventory and verify Food cost
		 */
		
		
		@Test(groups={"FC-WF4"},priority=0, description = "FC-WF4-TrackInventory-FoodCost")
		public void FC_WF4_CustomList_DefaultLoc_CustomCategory_TrackInventory_FoodCost()
		{
			LoginData loginData =LoginData.fetch("LoginData11");
			LocationsData locDataCooler=LocationsData.fetch("LocatiosData5");
			LocationsData locDataFreezer=LocationsData.fetch("LocatiosData6");
			LocationsData  locDataDry=LocationsData.fetch("LocatiosData7");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
			UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData2");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
			ListData listData=ListData.fetch("ListData5");


			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("FC-WF4-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"FC-WF4-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"FC-WF4-Clicked account")

			._atAccountsPage()
			.Third_AccountSelection(loginData.UserName,"FC-WF4-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("FC-WF4-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("FC-WF4-Skip2 Tapped")

			._atListPage()
			.TapCustomList("FC-WF4-custom list Selected")
			.tapContinue("FC-WF4-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "FC-WF4-select list")
			.TapOnNext("FC-WF4-tapped next")


			._atLocationsPage()
			.DefaultLocation("FC-WF4-Tapped Custom location")
			.tapContinue("FC-WF4-Tapped Continue")

			._atSetupInventoryPage()
			.TapOnSkip("FC-WF4-Skip1 Tapped")

			._atCategoryPage()

			.CustomCategories("FC-WF4-Custom Categories Tapped")
			.tapContinue("FC-WF4-Tapped Continue3")
			.CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "FC-WF4-CreateTwoExpenseCategory")
			.TapOnNext("FC-WF4-Tapped Next3")
			.selectMultipleItemsFromCategory1("FC-WF4-selectMultipleItemsFromCategory1")
			.TapOnNext("FC-WF4-Tapped Next4")
			.selectMultipleItemsFromCategory2("FC-WF4-selectMultipleItemsFromCategory2")
			._atSetupInventoryPage()
			.TapOnDone("FC-WF4-Tapped Done2")

			.TapTakeHome("FC-WF4-Tapped Continue3")   


			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF4-Selected track inventory")
		
			//inv_117,119 
		
			._atLocationsPage()
			.SelectLocation(locDataDry.LocationName, "FC-WF4-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.TapOnDone("FC-WF4-Tapped done")
			
			.SelectLocation(locDataFreezer.LocationName, "FC-WF4-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.TapOnDone("FC-WF4-Tapped done")
			
			.SelectLocation(locDataCooler.LocationName, "FC-WF4-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData.Quantity,"FC-WF4-Entering Quantity1 to food item")
			
			.TapOnDone("FC-WF4-Tapped done")
			.TapOnBack("FC-WF4-Tapped on Back")
		
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF4-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF4-Tapped Yes,Close")
		
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF4-Selected track inventory")

			._atLocationsPage()
			.SelectLocation(locDataDry.LocationName, "FC-WF4-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData1.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData1.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.TapOnDone("FC-WF4-Tapped done")
			
			.SelectLocation(locDataFreezer.LocationName, "FC-WF4-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData1.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData1.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.TapOnDone("FC-WF4-Tapped done")
			
			.SelectLocation(locDataCooler.LocationName, "FC-WF4-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData1.Quantity,"FC-WF4-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData1.Quantity,"FC-WF4-Entering Quantity1 to food item")
				
			.TapOnDone("FC-WF4-Tapped done")
			.TapOnBack("FC-WF4-Tapped on Back")
			
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF4-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF4-Tapped Yes,Close")
		
			.InvTools_FoodCost("FC-WF4-Tapped food cost")
			
			._atFoodCostPage()
			//	price validation
			.VerifyBeginningInventory(uomQuantityData.Quantity, listData.FoodPrice, "FC-WF4-Verify Beginning inventory value")
			.VerifyEndingInventory(uomQuantityData1.Quantity, listData.FoodPrice, "FC-WF4-Verify Ending inventory value")
		    .VerifyNetPurchases("FC-WF4-Verify net purchase value")
			.VerifyCostOfGoodsSold("FC-WF4-Verify cost of goods sold value")
			.EnterRevenue(purchasesData.Revenue1, "FC-WF4-Entered Revenue")
			.CalculateFoodCost("FC-WF4-Calculated food cost")
			._atLocationsPage()
			.TapOnBack("FC-WF4-Tapped on Back")
			

			;
		}
		
		
		
		/*
		 * Validating user is able to close inventory and verify Food cost
		 */
		
		
		@Test(groups={"FC-WF5"},priority=0, description = "FC-WF5-TrackInventory-FoodCost")
		public void FC_WF5_CustomList_CustomLoc_DefaultCategory_TrackInventory_FoodCost()
		{
			LoginData loginData =LoginData.fetch("LoginData14");
			LocationsData locationsData1 =LocationsData.fetch("LocationsData");
			LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
			UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData2");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
			ListData listData=ListData.fetch("ListData5");


			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("FC-WF5-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"FC-WF5-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"FC-WF5-Clicked account")

			._atAccountsPage()
			.Third_AccountSelection(loginData.UserName,"FC-WF5-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("FC-WF5-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("FC-WF5-Skip2 Tapped")

			._atListPage()
			.TapCustomList("FC-WF5-custom list Selected")
			.tapContinue("FC-WF5-Tapped Continue1")
			.SelectListwithItems(listData.ListName, "FC-WF5-select list")
			.TapOnNext("FC-WF5-tapped next")



			._atLocationsPage()
			.CustomLocation("FC-WF5-Tapped Custom location")
			.tapContinue("FC-WF5-Tapped Continue2")

			.EnterLocationName(locationsData1.LocationName,"FC-WF5-Enter location name")
			.AddLocations1_TypeDry("FC-WF5-Tapped Dry1")

			.AddLocations2("")
			.AddLocations2_name(locationsData2.LocationName,"")
			.AddLocations2_TypeDry("FC-WF5-Tapped Dry2")
			.TapOnNext("FC-WF5-Tapped Next1")

			.selectMultipleItemsFromLocation1("FC-WF5-Selected Multiple items")
			.TapOnNext("FC-WF5-Tapped Next2")

			.selectMultipleItemsFromLocation2("FC-WF5-Selected Multiple items")
			.TapOnDone("FC-WF5-Tapped Done1")

			._atCategoryPage()
			.defaultCategories("FC-WF5-Tapped Default category")
			.tapComplete("FC-WF5-Tapped Complete")
			
			._atSetupInventoryPage()
			.TapTakeHome("FC-WF5-Tapped Continue3")   


			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF5-Selected track inventory")
		
			//inv_278,280
		
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF5-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData.Quantity,"FC-WF5-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData.Quantity,"FC-WF5-Entering Quantity1 to food item")
			.TapOnDone("FC-WF5-Tapped done")
			
			.SelectLocation(locationsData2.LocationName, "FC-WF5-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData.Quantity,"FC-WF5-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData.Quantity,"FC-WF5-Entering Quantity1 to food item")
			.TapOnDone("FC-WF5-Tapped done")
			
			.TapOnBack("FC-WF5-Tapped on Back")
		
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF5-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF5-Tapped Yes,Close")
		
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF5-Selected track inventory")

			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF5-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData1.Quantity,"FC-WF5-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData1.Quantity,"FC-WF5-Entering Quantity1 to food item")
			.TapOnDone("FC-WF5-Tapped done")
			
			.SelectLocation(locationsData2.LocationName, "FC-WF5-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData1.Quantity,"FC-WF5-Entering Quantity1 to food item")
			.ItemQtyEnterById(listData.NonFoodPdt1,uomQuantityData1.Quantity,"FC-WF5-Entering Quantity1 to food item")
			.TapOnDone("FC-WF5-Tapped done")
		
			.TapOnBack("FC-WF5-Tapped on Back")
			
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF5-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF5-Tapped Yes,Close")
		
			.InvTools_FoodCost("FC-WF5-Tapped food cost")
			
			._atFoodCostPage()
			//	price validation
			.VerifyBeginningInventory(uomQuantityData.Quantity, listData.FoodPrice, "FC-WF5-Verify Beginning inventory value")
			.VerifyEndingInventory(uomQuantityData1.Quantity, listData.FoodPrice, "FC-WF5-Verify Ending inventory value")
		    .VerifyNetPurchases("FC-WF5-Verify net purchase value")
			.VerifyCostOfGoodsSold("FC-WF5-Verify cost of goods sold value")
			.EnterRevenue(purchasesData.Revenue1, "FC-WF5-Entered Revenue")
			.CalculateFoodCost("FC-WF5-Calculated food cost")
			._atLocationsPage()
			.TapOnBack("FC-WF5-Tapped on Back")
			

			;
		}
		
		
		/*
		 * Validating user is able to close inventory and verify Food cost
		 */
		
		
		@Test(groups={"FC-WF6"},priority=0, description = "FC-WF6-TrackInventory-FoodCost")
		public void FC_WF6_CustomList_CustomLoc_SuggestedCategory_TrackInventory_FoodCost()
		{
			LoginData loginData =LoginData.fetch("LoginData12");
			LocationsData locationsData1 =LocationsData.fetch("LocationsData");
			LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
			UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
			UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData2");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
			ListData listData=ListData.fetch("ListData5");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
			
			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("FC-WF6-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"FC-WF6-LoginPage")

			._atHomePage()
			.ClickAccount(loginData.UserName,"FC-WF6-Clicked account")

			._atAccountsPage()
			.Third_AccountSelection(loginData.UserName,"FC-WF6-FirstAccountSelect")

			._atInventoryToolPage()
			.InvTools_SetUpInventory("FC-WF6-SetupInventoryTap")

			._atSetupInventoryPage()
			.TapOnSkip("FC-WF6-Skip Tapped")

			._atListPage()
			.TapCustomList("FC-WF6-custom list Selected")
			.tapContinue("FC-WF6-Tapped Continue")
			.SelectListwithItems(listData.ListName, "FC-WF6-select list")
			.TapOnNext("FC-WF6-tapped next")



			._atLocationsPage()
			.CustomLocation("FC-WF6-Tapped Custom location")
			.tapContinue("FC-WF6-Tapped Continue")

			.EnterLocationName(locationsData1.LocationName,"FC-WF6-Enter location name")
			.AddLocations1_TypeDry("FC-WF6-Tapped Dry1")

			.AddLocations2("")
			.AddLocations2_name(locationsData2.LocationName,"")
			.AddLocations2_TypeDry("FC-WF6-Tapped Dry2")
			.TapOnNext("FC-WF6-Tapped Next")

			.selectMultipleItemsFromLocation1("FC-WF6-Selected Multiple items")
			.TapOnNext("FC-WF6-Tapped Next")

			.selectMultipleItemsFromLocation2("FC-WF6-Selected Multiple items")
			.TapOnDone("FC-WF6-Tapped Done")

			._atCategoryPage()
			.SuggestedCategories("FC-WF6-SuggestedCategories Tapped")
			.tapContinue("FC-WF6-Tapped Continue")
			
			._atSetupInventoryPage()
			.TapTakeHome("FC-WF6-Tapped Continue")   


			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF6-Selected track inventory")
		
			//inv_274,276
			//adding nonsysco item with category non food
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF6-Selected cooler")
			.TapAddLocation("FC-WF6-Tapped ADD")
			._atSetupInventoryPage()
			.AddItemFrom_NonSysco("FC-WF6-Tapped NonSysco")
			.EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "FC-WF6-NonSyscoItem details entered")
			.AddSupplier_AddProductDetailsPage("FC-WF6-select supplier")
			._atVendorPage()
			.Add_Supplier("FC-WF6-AddVendorTap")
			.AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "FC-WF6-AddVendorDetails")
			.TapOnDone("FC-WF6-Done")
			.TapOnBack("FC-WF6-Back")
			.SupplierSelect(vendorDetailsData.VendorName,"FC-WF6-SupplierSelect")
			._atLocationsPage()
			.AddCategory_AddProductDetailsPage("FC-WF6-CategorySelect")
			._atCategoryPage()
			.SelectCategory(nonSyscoItemData.Category1, "FC-WF6-Select Category Name")
			.TapOnDone("FC-WF6-Done")
			.TapOnBack("FC-WF6-Back")
		
			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF6-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData.Quantity,"FC-WF6-Entering Quantity1 to food item")
			.ItemQtyEnterById(nonSyscoItemData.UPC,uomQuantityData.Quantity,"FC-WF6-Entering Quantity1 to food item")
			.TapOnDone("FC-WF6-Tapped done")
			
			.SelectLocation(locationsData2.LocationName, "FC-WF6-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData.Quantity,"FC-WF6-Entering Quantity1 to food item")
		//	.ItemQtyEnterById(nonSyscoItemData.UPC,uomQuantityData.Quantity,"FC-WF6-Entering Quantity1 to food item")
			.TapOnDone("FC-WF6-Tapped done")
			
			.TapOnBack("FC-WF6-Tapped on Back")
		
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF6-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF6-Tapped Yes,Close")
		
			._atInventoryToolPage()
			.InvTools_TrackInventory("FC-WF6-Selected track inventory")

			._atLocationsPage()
			.SelectLocation(locationsData1.LocationName, "FC-WF6-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData1.Quantity,"FC-WF6-Entering Quantity1 to food item")
			.ItemQtyEnterById(nonSyscoItemData.UPC,uomQuantityData1.Quantity,"FC-WF6-Entering Quantity1 to food item")
			.TapOnDone("FC-WF6-Tapped done")
			
			.SelectLocation(locationsData2.LocationName, "FC-WF6-Selected cooler")
			.ItemQtyEnterById(listData.FoodPdt1,uomQuantityData1.Quantity,"FC-WF6-Entering Quantity1 to food item")
		//	.ItemQtyEnterById(nonSyscoItemData.UPC,uomQuantityData1.Quantity,"FC-WF6-Entering Quantity1 to food item")
			.TapOnDone("FC-WF6-Tapped done")
		
			.TapOnBack("FC-WF6-Tapped on Back")
			
			._atInventoryToolPage()
			.InvTools_CloseInventory("FC-WF6-Tapped close inventory")
			.InvTools_ClosedInventoryYes("FC-WF6-Tapped Yes,Close")
		
			.InvTools_FoodCost("FC-WF6-Tapped food cost")
			
			._atFoodCostPage()
			//	price validation
			.VerifyBeginningInventory(uomQuantityData.Quantity, listData.FoodPrice, "FC-WF6-Verify Beginning inventory value")
			.VerifyEndingInventory(uomQuantityData1.Quantity, listData.FoodPrice, "FC-WF6-Verify Ending inventory value")
		    .VerifyNetPurchases("FC-WF6-Verify net purchase value")
			.VerifyCostOfGoodsSold("FC-WF6-Verify cost of goods sold value")
			.EnterRevenue(purchasesData.Revenue1, "FC-WF6-Entered Revenue")
			.CalculateFoodCost("FC-WF6-Calculated food cost")
			._atLocationsPage()
			.TapOnBack("FC-WF6-Tapped on Back")
			

			;
		}

	

	
}
