
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
import com.components.yaml.NonSyscoItemData;
import com.components.yaml.PrepItemData;
import com.components.yaml.SearchData;
import com.components.yaml.VendorDetailsData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;
import org.testng.annotations.Test;


public class Sprint3SampleTest extends Initiator{




	
	//Sprint3
	 


	@Test(groups={"Script1"},priority=0, description = "Sprint3-Adding non sysco item to inventory as a MA user")
	public void AddNonsysco_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage("Script1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script1-Login")
			._atHomePage()
			.HamburgerMenu("Script1-HamburgerTap")
			._atAccountsPage()
			.HamMenu_Accounts("Script1-AccountsTap")
			.AccountSwitchFirstID("Script1-FirstAccountSelect")
			._atInventoryToolPage()
			 .InvTools_SetUpInventory("Script1-SetupInventoryTap")
		    ._atSetupInventoryPage()
		    .StartFromScratch("Script1-ScratchSelected")
		    .Scratch_AddItems("Script1-AddItemsTap")
		    .AddItemFrom_NonSysco("Script1-NonSyscoItemAddition")
		  .EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Script1-NonSyscoItemAddPage")
		 .AddSupplier_AddProductDetailsPage("SI - WF 6-TC1-select supplier")
		 ._atVendorPage()
		.Add_Supplier("Script1-AddVendorTap")
		 .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Script1-AddVendorDetails")
		.TapOnDone("Script1-Done")
		//.TapOnDone("Script1-Done") //iphone
		.TapOnBack("Script1-Back")
			.VendorSelect(vendorDetailsData.VendorName,"Script1-VendorSelect")
			.TapOnDone("Script1-Done")
		
		   	
		    ;
			
	}

	@Test(groups={"Script2"},priority=1, description = "Sprint3-Adding non sysco item to inventory as a normal user")
	public void AddNonsysco_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage("Script2-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script2-LoginPage")
			
			 ._atInventoryToolPage()
			 
			  .InvTools_SetUpInventory("Script2-SetupInventoryTap")
		    ._atSetupInventoryPage()
		    .StartFromScratch("Script2-ScratchSelected")
		    .Scratch_AddItems("Script2-AddItemsTap")
		    .AddItemFrom_NonSysco("Script2-NonSyscoItemAddition")
		  .EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Script2-NonSyscoItemAddPage")
		 .AddSupplier_AddProductDetailsPage("SI - WF 6-TC1-select supplier")
		
		  ._atVendorPage()
		.Add_Supplier("Script2-AddVendorTap")
		 .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Script2-AddVendorDetails")
		.TapOnDone("Script2-Done")
		//.TapOnDone("Script2-Done") //iphone
		.TapOnBack("Script2-Back")
			.VendorSelect(vendorDetailsData.VendorName,"Script2-VendorSelect")
			.TapOnDone("Script2-Done")
			;
			
	}
	
	
  @Test(groups={"Script3"},priority=2, description = "Sprint3-Validating non sysco item addition page as a MA user")
	public void NonSyscoItem_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
    	
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script3-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script3-Login")
			._atHomePage()
			.HamburgerMenu("Script6-HamburgerTap")
		      ._atAccountsPage()
		     .HamMenu_Accounts("Script3-AccountsTap")
		     .AccountSwitchFirstID("Script3-FirstAccountSelect")
			._atInventoryToolPage()
			 .InvTools_SetUpInventory("Script3-SetupInventoryTap")
			._atSetupInventoryPage()
			.StartFromScratch("Script3-ScratchSelected")
			.Scratch_AddItems("Script3-AddItemsTap")
		    .AddItemFrom_NonSysco("Script3-NonSyscoItemAddition")
		  .NonSysco_Prompt("Script3-NonSyscoItemAddPage")
			
			;
			
	}

	
	@Test(groups={"Script4"},priority=3, description = "Sprint3-Validating non sysco item addition page as a normal user")
	public void NonSyscoItem_NU() {	
		
		LoginData loginData=LoginData.fetch("LoginDatNor1");
		// NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmDatas");
		//VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script4-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script4-Login")
			 ._atInventoryToolPage()
			 .InvTools_SetUpInventory("Script4-SetupInventoryTap")
			._atSetupInventoryPage()
			.StartFromScratch("Script3-ScratchSelected")
			.Scratch_AddItems("Script3-AddItemsTap")
		     .AddItemFrom_NonSysco("Script4-NonSyscoItemAddition")
		  .NonSysco_Prompt("Script4-NonSyscoItemAddPage")
			
			;
			
	}



	@Test(groups={"Script5"},priority=4, description = "Sprint3-Creating expense category and adding item to it")
	public void CreateCategory_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor1");
	//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
	//	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPage("Script5-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script5-LoginPage")
			 ._atInventoryToolPage()
		      .InvTools_SetUpInventory("Script5-SetupInventoryTap")
		    ._atSetupInventoryPage()
		   .AddItemFrom_OrderGuide("Script5-ScratchSelected")
		   ._atLocationsPage()
		   .DefaultLocation("Script5-ContinueSelected")
		   .tapContinue("Script5-ContinueSelected")
		  ._atCategoryPage()
	           .CustomCategories("-Tapped Custom category")
	           .tapContinue("-Tapped Continue")
	           .CategoryDetails(categoryData.Name,"-Enter category details")
	            .TapOnNext("Tapped Next")
	            .SelectItemFromCategory(categoryData.Name, "-Selected first item")
	          //   ._atInventoryToolPage()
		  // .InvTools_TrackInventory("Script5-TrackInventoryTap")
		 // ._atSetupInventoryPage()
		 // .Category_Item(categoryData.Name,"Script5-ItemListed_AddedCategory")
		
			;
			
	}

	
@Test(groups={"Script6"},priority=5, description = "Sprint3-Creating expense category and adding item to it")
	public void CreateCategoryItem_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
	//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
	//	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData1");
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPage("Script6-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script6-LoginPage")
			._atHomePage()
			.HamburgerMenu("Script6-HamburgerTap")
		      ._atAccountsPage()
		     .HamMenu_Accounts("Script6-AccountsTap")
		    .AccountSwitchFirstID("Script6-FirstAccountSelect")
		     //.AccountSwitchSecondID("Script6-SecondAccountSelect")
		._atInventoryToolPage()
		      .InvTools_SetUpInventory("Script6-SetupInventoryTap")
		   ._atSetupInventoryPage()
		   .AddItemFrom_OrderGuide("Script5-ScratchSelected")
		   ._atLocationsPage()
		   .DefaultLocation("Script5-ContinueSelected")
		   .tapContinue("Script5-ContinueSelected")
		  ._atCategoryPage()
	           .CustomCategories("-Tapped Custom category")
	           .tapContinue("-Tapped Continue")
	           .CategoryDetails(categoryData.Name,"-Enter category details")
	            .TapOnNext("Tapped Next")
	            .SelectItemFromCategory(categoryData.Name, "-Selected first item")
	         
		//   ._atInventoryToolPage()
		//   .InvTools_TrackInventory("Script6-TrackInventoryTap")
	//	  ._atSetupInventoryPage()
	//	  .Category_Item(categoryData.Name,"Script6-ItemListed_AddedCategory_")
		
			;
			
	}
	
		
	@Test(groups={"Script7"},priority=6, description = "Sprint3-Creating expense category as normal user ")
	public void CreateCategoryItem_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
	//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
	//	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData1");
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage("Script7-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script7-LoginPage")
			._atInventoryToolPage()
		      .InvTools_SetUpInventory("Script6-SetupInventoryTap")
		   ._atSetupInventoryPage()
		   .AddItemFrom_OrderGuide("Script5-ScratchSelected")
		   ._atLocationsPage()
		   .DefaultLocation("Script5-ContinueSelected")
		   .tapContinue("Script5-ContinueSelected")
		  ._atCategoryPage()
	           .CustomCategories("-Tapped Custom category")
	           .tapContinue("-Tapped Continue")
	           .CategoryDetails(categoryData.Name,"-Enter category details")
	            .TapOnNext("Tapped Next") 
			;
			
	}

	@Test(groups={"Script8"},priority=7, description = "Sprint3-Creating expense category as MA  user")
	public void CreateCategory_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
		CategoryData categoryData=CategoryData.fetch("CategoryData1");
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script8-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script8-LoginPage")
			._atHomePage()
		     .HamburgerMenu("Script8-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script8-AccountsTap")
		     .AccountSwitchFirstID("Script8-FirstAccountSelect")
			 ._atInventoryToolPage()
		      .InvTools_SetUpInventory("Script6-SetupInventoryTap")
		   ._atSetupInventoryPage()
		   .AddItemFrom_OrderGuide("Script5-ScratchSelected")
		   ._atLocationsPage()
		   .DefaultLocation("Script5-ContinueSelected")
		   .tapContinue("Script5-ContinueSelected")
		  ._atCategoryPage()
	           .CustomCategories("-Tapped Custom category")
	           .tapContinue("-Tapped Continue")
	           .CategoryDetails(categoryData.Name,"-Enter category details")
	            .TapOnNext("Tapped Next")
		
			;
			
	}
	
	
	@Test(groups={"Script9"},priority=1, description = "Sprint3-Create multiple Categories and add item")
	public void CreateMultipleCategories_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
		//NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSycoItemData");
		//VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script11-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script11-LoginPage")
			
			 ._atInventoryToolPage()
			 .InvTools_SetUpInventory("Script11-SetupInventoryTap")
		     ._atSetupInventoryPage()
		   .AddItemFrom_OrderGuide("Script11-ScratchSelected")
		   ._atLocationsPage()
		   .DefaultLocation("Script5-ContinueSelected")
		   .tapContinue("Script5-ContinueSelected")
		   ._atCategoryPage()
	           .CustomCategories("-Tapped Custom category")
	           .tapContinue("-Tapped Continue")
	       .CreateTwoExpenseCategory(categoryData.Name,categoryData.Name1,"Script11-CategoryCretion")
		   .SelectItemFromCategory(categoryData.Name, "-Selected first item")
	         
			;
			
	}
	
	@Test(groups={"Script10"},priority=1, description = "Sprint3-Create multiple Categories and add item with MA")
	public void CreateMultipleCategories_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage("Script10-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script10-Login")
			._atHomePage()
			.HamburgerMenu("Script10-HamburgerTap")
			._atAccountsPage()
			.HamMenu_Accounts("Script10-LoginPage")
			.AccountSwitchFirstID("Script10-LoginPage")
			._atInventoryToolPage()
		      .InvTools_SetUpInventory("Script10-SetupInventoryTap")
		      ._atSetupInventoryPage()
			   .AddItemFrom_OrderGuide("Script11-ScratchSelected")
			   ._atLocationsPage()
			   .DefaultLocation("Script5-ContinueSelected")
			   .tapContinue("Script5-ContinueSelected")
			   ._atCategoryPage()
		           .CustomCategories("-Tapped Custom category")
		           .tapContinue("-Tapped Continue")
		      
			   .CreateTwoExpenseCategory(categoryData.Name,categoryData.Name1,"Script11-CategoryCretion")
			   .SelectItemFromCategory(categoryData.Name, "-Selected first item")
		      ;
			
	}


@Test(groups={"Script11"},priority=4, description = "Sprint3-425.8 Inventory & Food Cost")
	public void OrderGuidePro_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
    	
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script11-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script11-Login")
			 ._atInventoryToolPage()
		      .InvTools_SetUpInventory("Script11-SetupInventoryTap")
		        ._atSetupInventoryPage()
		     .StartFromScratch("Script11-ScratchSelected")
		     .Scratch_AddItems("Script11-AddItemsTap")
            .AddItemFrom_OrderGuide("Script11-AddItemsOrderGuide")
			.verifyOGItemsOnSetupInv("Script11-VerifyItemsOrderGuide")
			;
			
	}

@Test(groups={"Script12"},priority=4, description = "Sprint3-425.8 Inventory & Food Cost")
	public void OrderGuidePro_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
     	
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage("Script11-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script12-Login")
			._atHomePage()
			.HamburgerMenu("Script12-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script12-AccountsTap")
		     .AccountSwitchFirstID("Script12-FirstAccountSelect")
			 ._atInventoryToolPage()
		      .InvTools_SetUpInventory("Script12-SetupInventoryTap")
		      ._atSetupInventoryPage()
			     .StartFromScratch("Script11-ScratchSelected")
			     .Scratch_AddItems("Script11-AddItemsTap")
	            .AddItemFrom_OrderGuide("Script11-AddItemsOrderGuide")
				.verifyOGItemsOnSetupInv("Script11-VerifyItemsOrderGuide")
				;
			
	}




	@Test(groups={"Script13"},priority=1, description = "Sprint3-430 Toogle Price Unit")
	public void Menu_UI_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
	//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
	
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage("Script3-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script3-Login")
		 ._atInventoryToolPage()
	      .InvTools_SetUpInventory("Script4-SetupInventoryTap")
	    ._atSetupInventoryPage()
	    .StartFromScratch("Script4-ScratchSelected")
	    .Scratch_AddItems("Script4-AddItemsTap")
	    .AddItemFrom_NonSysco("Script4-AddItemsTap")
	   // .AddProduct_NonSysco_Toggle()
   	;
			
	}
	
	@Test(groups={"Script14"},priority=1, description = "Sprint3-430 Toogle Price Unit")
	public void Menu_UI_MA() {	
		
 		LoginData loginData =LoginData.fetch("MAusrLgn1");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSycoItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
	
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script14-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script3-Login")
			._atHomePage()
		.HamburgerMenu("Script14-LoginPage")
		._atAccountsPage()
		.HamMenu_Accounts("Script14-LoginPage")
		.AccountSwitchFirstID("Script14-LoginPage")
		 ._atInventoryToolPage()
	      .InvTools_SetUpInventory("Script14-SetupInventoryTap")
	    ._atSetupInventoryPage()
	     .StartFromScratch("Script14-ScratchSelected")
    .Scratch_AddItems("Script14-AddItemsTap")
    .AddItemFrom_NonSysco("YOYO")
	   // .SetupInventory_AddItems("Script4-AddItemsTap")
	  // .AddProduct_NonSysco_Toggle("")
   	;
			
	}



		@Test(groups={"Script15"},priority=14, description = "Sprint3-446.6-refresh uncategorized view as normal user")
		public void RefreshUncategorized_NU() {	
			
			LoginData loginData =LoginData.fetch("LoginDatNor");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			Start.asTester
				.goToLoginpage()
				.verifyLoginPage("Script1-LoginPage")
				.signIn(loginData.UserName, loginData.Password,"Script4-Login")
				
				 ._atInventoryToolPage()
			      .InvTools_SetUpInventory("Script1-SetupInventoryTap")
			    ._atSetupInventoryPage()
			    .AddItemFrom_OrderGuide("Script1-SetupInventoryTap")
			    ._atLocationsPage()
			    .DefaultLocation("Script1-DefaultLocation")
			    .tapContinue("")
			    ._atCategoryPage()
			    .CustomCategories("-Tapped Custom category")
	           .tapContinue("-Tapped Continue")
	           .CategoryDetails(categoryData.Name,"-Enter category details")
	            .TapOnNext("Tapped Next")
	            
		  .CustomCategory_ItemSelectAndCheck("Script1-CustomCategories_ItemVerifyinAllTabAndUncategorizedTab")
	            ;
				
		}

		
		
		@Test(groups={"Script16"},priority=15, description = "Sprint3-446.6-refresh uncategorized view as MA user")
		public void RefreshUncategorized_MA() {	
			
			LoginData loginData =LoginData.fetch("MAusrLgn");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			Start.asTester
				.goToLoginpage()
				.verifyLoginPage("Script2-LoginPage")
				.signIn(loginData.UserName, loginData.Password,"Script2-Login")
				._atHomePage()
				.HamburgerMenu("Script2-HamburgerTap")
				._atAccountsPage()
				.HamMenu_Accounts("Script2-AccountsTap")
				.AccountSwitchFirstID("Script2-AccountSwitch")
				 ._atInventoryToolPage()
			      .InvTools_SetUpInventory("Script1-SetupInventoryTap")
			    ._atSetupInventoryPage()
			    .AddItemFrom_OrderGuide("Script1-SetupInventoryTap")
			    ._atLocationsPage()
			    .DefaultLocation("Script1-DefaultLocation")
			    .tapContinue("")
			    ._atCategoryPage()
			    .CustomCategories("-Tapped Custom category")
	           .tapContinue("-Tapped Continue")
	           .CategoryDetails(categoryData.Name,"-Enter category details")
	            .TapOnNext("Tapped Next")
	            
		  .CustomCategory_ItemSelectAndCheck("Script1-CustomCategories_ItemVerifyinAllTabAndUncategorizedTab")
	            ;
		
				;
				
		}
	
		
	
	
	
	
}
