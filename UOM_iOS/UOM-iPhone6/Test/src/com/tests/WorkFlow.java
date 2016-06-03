
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
import com.components.yaml.SearchData;
import com.components.yaml.UOMQuantityData;
import com.components.yaml.VendorDetailsData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;
import org.testng.annotations.Test;


public class WorkFlow extends Initiator{

	

	@Test(groups={"SI - WF 10 MA"},priority=0, description = "SI - WF 10-TC1-Start From Scratch + add items from Order Guide +Default Loc + Default Category for MA user")
	public void SI_WF10_StartFromScratch_OG_DefaultLocation_DefaultCategory_MA() {	
		
		LoginData loginData =LoginData.fetch("LoginData3");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		
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
		       .TapOnSkip("SI - WF 10-TC1-Tapped Skip")
		        
		       ._atLocationsPage()
		       .DefaultLocation("SI - WF 10-TC1-Tapped Default location")
		        .tapContinue("SI - WF 10-TC1-Tapped Continue")
		          
		        ._atSetupInventoryPage()
		         .TapOnSkip("SI - WF 10-TC1-Tapped Skip")
		        
		           ._atCategoryPage()
		           .defaultCategories("SI - WF 10-TC1-Tapped Custom category")
		           .tapComplete("SI - WF 10-TC1-Tapped Complete")
		            .tapContinue("SI - WF 10-TC1-Tapped Continue")
		           
		           ._atInventoryToolPage()
		           .InvTools_TrackInventory("SI - WF 10-TC1-Selected track inventory")
		
		          /*  
		            ._atLocationsPage()
		            .SelectLocation(locationsData.LocationName, "SI - WF 10-TC1-select added location")
		          //.ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 10-TC1-Verify item inside location")
		              .TapOnDone("SI - WF 10-TC1-Tapped Done")*/
			;
	}
	
	@Test(groups={"SI - WF 11 MA"},priority=0, description = "SI - WF 11-TC1-Start From Scratch + add items Non-sysco & Prep+Default Loc + Default Category for MA user")
	public void SI_WF11_StartFromScratch_NonSysco_Prep_DefaultLocation_DefaultCategory_MA() {	
		
		LoginData loginData =LoginData.fetch("LoginData4");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
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
		     .Second_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		     
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
   .VendorSelect(vendorDetailsData.VendorName,"SI - WF 11-TC1-VendorSelect")
 	.TapOnDone("SI - WF 11-TC1-Done")
 	
 	._atSetupInventoryPage()
	.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 11-TC1-Verify item selected")
	.Setup_AddItemsLink("SI - WF 11-TC1-Add items Selected")
	 .AddItemFrom_PrepItem("SI - WF 11-TC1-Tapped NonSysco")
		     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 11-TC1-NonSyscoItemAddPage")
		   	.TapOnDone("SI - WF 11-TC1-Tapped Done")
		 .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 11-TC1-Verify item selected")
		   	.TapOnDone("SI - WF 11-TC1-Tapped Done")
 	  .TapOnSkip("SI - WF 11-TC1-Tapped Skip")
 	  
		          ._atLocationsPage()
		       .DefaultLocation("SI - WF 11-TC1-Tapped Default location")
		        .tapContinue("SI - WF 11-TC1-Tapped Continue")
		           
		        ._atSetupInventoryPage()
		         .TapOnSkip("SI - WF 11-TC1-Tapped Skip")
		         
		           ._atCategoryPage()
		           .defaultCategories("SI - WF 11-TC1-Tapped Custom category")
		           .tapComplete("SI - WF 11-TC1-Tapped Complete")
		            .tapContinue("SI - WF 11-TC1-Tapped Continue")
		           
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

	
	@Test(groups={"SI - WF 9 MA"},priority=0, description = "SI - WF 9-TC2-Start From Scratch + add items from Product catelog +Default Loc + Default Category for MA user")
	public void SI_WF9_StartFromScratch_PdtCatalog_DefaultLocation_DefaultCategory_MA() {	
		
		LoginData loginData =LoginData.fetch("LoginData3");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		SearchData searchData=SearchData.fetch("SearchData");
		
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("SI - WF 9-TC2-LoginPage")
			.saveUsernameCheckBoxClick("SI - WF 9-TC2-save username")
			.signIn(loginData.UserName, loginData.Password,"SI - WF 9-TC2-Login")
			
			._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .Third_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		     
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
		       .TapOnSkip("SI - WF 9-TC2-Tapped Skip")
		        
		       ._atLocationsPage()
		       .DefaultLocation("SI - WF 9-TC2-Tapped Default location")
		        .tapContinue("SI - WF 9-TC2-Tapped Continue")
		          
		        ._atSetupInventoryPage()
		         .TapOnSkip("SI - WF 9-TC2-Tapped Skip")
		        
		           ._atCategoryPage()
		           .defaultCategories("SI - WF 9-TC2-Tapped Custom category")
		           .tapComplete("SI - WF 9-TC2-Tapped Complete")
		            .tapContinue("SI - WF 9-TC2-Tapped Continue")
		           
		           ._atInventoryToolPage()
		           .InvTools_TrackInventory("SI - WF 9-TC2-Selected track inventory")
		
		            
		          /* ._atLocationsPage()
		           .SelectLocation(locationsData.LocationName, "SI - WF 9-TC2-select added location")
		         // .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 9-TC2-Verify item inside location")
		             .TapOnDone("SI - WF 9-TC2-Tapped Done")*/
			;
	}

	
	@Test(groups={"SI - WF 12 MA"},priority=0, description = "SI - WF 912-TC2-Start From Scratch + add items from multiple lists +Default Loc + Default Category for MA user")
	public void SI_WF12_StartFromScratch_Catalog_OG_NonSysco_Prep_DefaultLocation_DefaultCategory_MA() {	
		
		LoginData loginData =LoginData.fetch("LoginData3");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
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
   .VendorSelect(vendorDetailsData.VendorName,"SI - WF 12-TC2-VendorSelect")
 	.TapOnDone("SI - WF 12-TC2-Done")
 	
 	._atSetupInventoryPage()
	.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
	.Setup_AddItemsLink("SI - WF 12-TC2-Add items Selected")
	 .AddItemFrom_PrepItem("SI - WF 12-TC2-Tapped NonSysco")
		     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 12-TC2-NonSyscoItemAddPage")
		   	.TapOnDone("SI - WF 12-TC2-Tapped Done")
		 .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		   	.TapOnDone("SI - WF 12-TC2-Tapped Done")
 	  .TapOnSkip("SI - WF 12-TC2-Tapped Skip")
		     
		       ._atLocationsPage()
		       .DefaultLocation("SI - WF 12-TC2-Tapped Default location")
		        .tapContinue("SI - WF 12-TC2-Tapped Continue")
		          
		        ._atSetupInventoryPage()
		         .TapOnSkip("SI - WF 12-TC2-Tapped Skip")
		        
		           ._atCategoryPage()
		           .defaultCategories("SI - WF 12-TC2-Tapped Custom category")
		           .tapComplete("SI - WF 12-TC2-Tapped Complete")
		            .tapContinue("SI - WF 12-TC2-Tapped Continue")
		           
		           ._atInventoryToolPage()
		           .InvTools_TrackInventory("SI - WF 12-TC2-Selected track inventory")
		
		            
		            /*._atLocationsPage()
		            .SelectLocation(locationsData.LocationName, "SI - WF 12-TC2-select added location")
		          .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 12-TC2-Verify item inside location")
		            ._atSetupInventoryPage()
		            .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		            .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		              .TapOnDone("SI - WF 12-TC2-Tapped Done")*/
			;
	}
	
	@Test(groups={"SI - WF 19 NU"},priority=0, description = "SI - WF 19-TC1-Custom List + default Loc + default Category for Normal user")
	public void SI_WF19_CustomList_defaultLoc_defaultcategory_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginData3");
		ListData listData=ListData.fetch("ListData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		
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
			           
			          
			          ._atSetupInventoryPage()
			      .TapOnSkip("SI - WF 19-TC1-Skip1 Tapped")
			      
			          
			          ._atLocationsPage()
				      .DefaultLocation("SI - WF 19-TC1-Tapped Custom location")
				        .tapContinue("SI - WF 19-TC1-Tapped Continue")
				       
				          ._atSetupInventoryPage() 
				       .TapOnSkip("SI - WF 19-TC1-Skip3 Tapped") 

				      ._atCategoryPage()
				      .defaultCategories("SI - WF 19-TC1-Tapped Default category")
				      .tapComplete("SI - WF 19-TC1-Tapped Complete")
				           
				       ._atSetupInventoryPage()
				      .tapContinue("SI - WF 19-TC1-Tapped Continue3")   
				      
				  ._atInventoryToolPage()
				  .InvTools_TrackInventory("SI - WF 19-TC1-Selected track inventory")
				 
				      /*._atLocationsPage()
				        .SelectLocation(locationsData.LocationName, "SI - WF 19-TC1-select added location")
				            .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
				             .TapOnDone("SI - WF 9-TC1-Tapped Done")*/
				;
			
	}
	@Test(groups={"SI - WF 18 MA"},priority=0, description = "SI - WF 18-TC1-Start from scratch+ Multiple lists +skip location + default category for MA user")
	public void SI_WF18_StartFromScratch_MultipleList_skipLocation_DefaultCategory_MA() {	
		
		LoginData loginData =LoginData.fetch("LoginData4");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
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
   .VendorSelect(vendorDetailsData.VendorName,"SI - WF 18-TC1-VendorSelect")
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
 	  .TapOnSkip("SI - WF 18-TC1-Tapped Skip")
		     
		       .TapOnDOThisLater("SI - WF 18-TC1-Tapped do this later")
		         .TapOnSkip("SI - WF 18-TC1-Tapped Skip")
		        
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
	
	
	@Test(groups={"SI - WF 1 MA"},priority=4, description = "SI - WF 2-TC2-OG + Dafault Loc + Default Category for MA user")
	public void SI_WF1_OG_DefaultLocation_DefaultCategory_MA() {
	LoginData loginData =LoginData.fetch("LoginData3");
	LocationsData locationsData =LocationsData.fetch("LocatiosData4");

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
	      .TapOrderGuide("SI - WF 1-TC1-OG Selected")
	      .tapContinue("SI - WF 1-TC1-Tapped Continue")
	       .TapOnSkip("SI - WF 1-TC1-Skip2 Tapped")

	   
	    ._atLocationsPage()
	      .DefaultLocation("SI - WF 1-TC1-Tapped Custom location")
	        .tapContinue("SI - WF 1-TC1-Tapped Continue")
	       
	          ._atSetupInventoryPage() 
	       .TapOnSkip("SI - WF 1-TC1-Skip3 Tapped") 

	      ._atCategoryPage()
	      .defaultCategories("SI - WF 1-TC1-Tapped Default category")
	      .tapComplete("SI - WF 1-TC1-Tapped Complete")
	           
	       ._atSetupInventoryPage()
	      .tapContinue("SI - WF 1-TC1-Tapped Continue3")   
	      
	  ._atInventoryToolPage()
	  .InvTools_TrackInventory("SI - WF 1-TC1-Selected track inventory")
	 
	     /* ._atLocationsPage()
	        .SelectLocation(locationsData.LocationName, "SI - WF 10-TC1-select added location")
	          //  .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
	             .TapOnDone("SI - WF 1-TC1-Tapped Done")*/
	;
	}
	
	
	
		@Test(groups={"SI - WF 7 MA"},priority=4, description = "SI - WF 7-TC2-OG+Default loc + Skip Category for MA user")
		public void SI_WF7_OG_DefaultLocation_SkipCategory_MA() {
			LoginData loginData =LoginData.fetch("LoginData4");
		LocationsData locationsData =LocationsData.fetch("LocatiosData4");

		Start.asTester
		.goToLoginpage()
		 .verifyLoginPage("SI - WF 7-TC2-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"SI - WF 7-TC1-Login")
		._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		      
		._atInventoryToolPage()
		      .InvTools_SetUpInventory("SI - WF 7-TC2-SetupInventoryTap")

		      ._atSetupInventoryPage()
		      .TapOnSkip("SI - WF 7-TC2-Skip1 Tapped")
		      .TapOrderGuide("SI - WF 7-TC2-OG Selected")
		      .tapContinue("SI - WF 7-TC2-Tapped Continue1")
		      .TapOnSkip("SI - WF 7-TC1-Skip2 Tapped")
		      
		    ._atLocationsPage()
		      .DefaultLocation("SI - WF 7-TC2-Tapped Custom location")
		        .tapContinue("SI - WF 7-TC2-Tapped Continue2")
		        
		        ._atSetupInventoryPage() 
		       .TapOnSkip("SI - WF 7-TC2-Skip3 Tapped") 
		       .TapOnDOThisLater("SI - WF 7-TC2-TapOnDOThisLater Tapped")
		      .tapContinue("SI - WF 7-TC2-Tapped Continue3") 
		     

		     
		  ._atInventoryToolPage()
		  .InvTools_TrackInventory("SI - WF 7-TC2-Selected track inventory")
		 
		    /*  ._atLocationsPage()
		     //       .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
		             .TapOnDone("SI - WF 7-TC1-Tapped Done")*/
		;
		
		}
		

		
		@Test(groups={"SI - WF 3 MA"},priority=0, description = "SI - WF 3-TC1-OG + Cus Loc + Cust Category for MA user")
		public void SI_WF3_OG_CustomMultipleLocation_CustomMultipleCategory_MA() {	
			
			LoginData loginData =LoginData.fetch("LoginData2");
			LocationsData locationsData1 =LocationsData.fetch("LocationsData");
			LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			Start.asTester
				.goToLoginpage()
					.verifyLoginPage("SI - WF 3-TC1-LoginPage")
				.signIn(loginData.UserName, loginData.Password,"SI - WF 3-TC1-LoginPage")
		._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		  
		     ._atInventoryToolPage()
	      .InvTools_SetUpInventory("SI - WF 3-TC1-SetupInventoryTap")
	      
	       ._atSetupInventoryPage()
	       .TapOnSkip("SI - WF 3-TC1-Skip1 Tapped")
	       .TapOrderGuide("SI - WF 3-TC1-OG Selected")
	      .tapContinue("SI - WF 3-TC1-Tapped Continue1")
	      .TapOnSkip("SI - WF 3-TC1-Skip2 Tapped")
	      
	         ._atLocationsPage()
	       .CustomLocation("SI - WF 3-TC1-Tapped Custom location")
	        .tapContinue("SI - WF 3-TC1-Tapped Continue2")
	        
	        .EnterLocationName(locationsData1.LocationName,"SI - WF 3-TC1-Enter location name")
	        .AddLocations1_TypeDry("SI - WF 3-TC1-Tapped Dry1")
	        
	        .AddLocations2()
	        .AddLocations2_name(locationsData2.LocationName)
	        .AddLocations2_TypeDry("SI - WF 3-TC1-Tapped Dry2")
	        .TapOnNext("SI - WF 3-TC1-Tapped Next1")
	        
	        .selectMultipleItemsFromLocation1("SI - WF 3-TC1-Selected Multiple items")
	        .TapOnNext("SI - WF 3-TC1-Tapped Next2")
	        
	        .selectMultipleItemsFromLocation2("SI - WF 3-TC1-Selected Multiple items")
	        .TapOnDone("SI - WF 3-TC1-Tapped Done1")
	        ._atSetupInventoryPage()
		       .TapOnSkip("SI - WF 1-TC2-Skip3 Tapped")
		       
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
	       .tapContinue("SI - WF 3-TC1-Tapped Continue4") 
	           
	       
	              ._atInventoryToolPage()
	           .InvTools_TrackInventory("SI - WF 3-TC1-Selected track inventory")

	         //   ._atLocationsPage()
	          //  .SelectLocation(locationsData1.LocationName, "SI - WF 3-TC1-LocationTap1")
	           // .ItemVerifyOnLocation1("SI - WF 3-TC1-Verify item inside location1")
	         //  .TapOnBack("SI - WF 3-TC1-Tap on Back1")
	        //   .SelectLocation(locationsData2.LocationName, "SI - WF 3-TC1-LocationTap2")
	         //  .ItemVerifyOnLocation1("SI - WF 3-TC1-Verify item inside location2")
		;
	
	
	

		}





		
		
		//Precond:setupinventory should be done so that trackinv is enabled
				@Test(groups={"MIL - WF 1 WF 4 MA"},priority=0, description = "MIL - WF 1,WF 4-TC2-Creating Location in trackinventory and add items from multile lists to location for MA user")
				public void MIL_WF1_WF4_Location_AddItems_MA() {	
					
					LoginData loginData =LoginData.fetch("LoginData1");
					LocationsData locationsData =LocationsData.fetch("LocatiosData3");
					LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
					NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
					PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
					VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
					SearchData searchData=SearchData.fetch("SearchData");
					Start.asTester
						.goToLoginpage()
					//	.verifyLoginPage("SI - WF 1-TC2-TC2-LoginPage")
						.signIn(loginData.UserName, loginData.Password,"MIL - WF 1 WF 4-TC2-Login")
							
	._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"MIL - WF 1 WF 4-TC2-FirstAccountSelect")
		   
		     
		     //setting up inventory    
			 ._atInventoryToolPage()
				.InvTools_SetUpInventory("MIL - WF 1 WF 4-TC2-SetupInventoryTap")
				
			 ._atSetupInventoryPage()
				 .TapOnSkip("MIL - WF 1 WF 4-TC2-Tapped Skip")
				.StartFromScratch("MIL - WF 1 WF 4-TC2-ScratchSelected")
			 .tapContinue("MIL - WF 1 WF 4-TC2-Tapped Continue")
				 .Scratch_AddItems("MIL - WF 1 WF 4-TC2-Tapped Add items")
				 .AddItemFrom_OrderGuide("MIL - WF 1 WF 4-TC2-Tapped Order Guide")
				 .SelectItemFrom_OrderGuide("MIL - WF 1 WF 4-TC2-Selected item from OG")
				 .TapOnDone("MIL - WF 1 WF 4-TC2-Tapped Done")
				.verifyOGItemsOnSetupInv("MIL - WF 1 WF 4-TC2-Verify item selected")
				.TapOnDone("MIL - WF 1 WF 4-TC2-Tapped Done")
				.TapOnSkip("MIL - WF 1 WF 4-TC2-Tapped Skip")
			
				._atSetupInventoryPage()
			.TapOnDOThisLater("MIL - WF 1 WF 4-TC2-Tapped do this later")
				.TapOnSkip("MIL - WF 1 WF 4-TC2-Tapped Skip")
				.TapOnDOThisLater("MIL - WF 1 WF 4-TC2-Tapped do this later")
			
				._atCategoryPage()
				.tapContinue("MIL - WF 1 WF 4-TC2-Tapped Continue")

						 ._atInventoryToolPage()
						 .InvTools_TrackInventory("MIL - WF 1 WF 4-TC2-TrackinventoryTap")
					    
					       
					     ._atLocationsPage()
					     .TapAddLocation("MIL - WF 1 WF 4-TC2-Tapped ADD")
				         .AddLocationName(locationsData.LocationName,"MIL - WF 1 WF 4-TC2-Enter location name")
					     .AddLocationCooler("MIL - WF 1 WF 4-TC2-Tapped Cooler")
					     .TapOnDone("MIL - WF 1 WF 4-TC2-Tapped Done")
					     .TapOnBack("MIL - WF 1 WF 4-TC2-Tapped Back")
					     .VerifyLocationList(locationsData.LocationName, "MIL - WF 1 WF 4-TC2-Verifing AddedLocation")
					    //nonsysco addition 
					     .SelectLocation(locationsData.LocationName, "MIL - WF 1 WF 4-TC2-Selecting AddedLocation")
					     .TapAddLocation("MIL - WF 1 WF 4-TC2-Tapped ADD")
					  
					     ._atSetupInventoryPage()
					     .AddItemFrom_NonSysco("MIL - WF 1 WF 4-TC2-Tapped NonSysco")
					     .EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL - WF 1 WF 4-TC2-NonSyscoItem details entered")
					 	  .AddSupplier_AddProductDetailsPage("MIL - WF 1 WF 4-TC2-select supplier")
					 	
					 	  ._atVendorPage()
				         .Add_Supplier("MIL - WF 1 WF 4-TC2-AddVendorTap")
				       .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL - WF 1 WF 4-TC2-AddVendorDetails")
				      .TapOnDone("MIL - WF 1 WF 4-TC2-Done")
				    // .TapOnDone("SI - WF 6-TC2-Done") //iphone
				     .TapOnBack("MIL - WF 1,3-TC2-Back")
				       .VendorSelect(vendorDetailsData.VendorName,"MIL - WF 1 WF 4-TC2-VendorSelect")
			 	     .TapOnDone("MIL - WF 1 WF 4-TC2-Done")
			 	 
			 	     
			 
			 	    
			 	     //prepitemaddition
			 	     ._atLocationsPage()   
			 	     .TapAddLocation("MIL - WF 1 WF 4-TC2-Tapped ADD")
			 	     
			 	     ._atSetupInventoryPage()
			 	      .AddItemFrom_PrepItem("MIL - WF 1 WF 4-TC2-Tapped NonSysco")
				     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL - WF 1 WF 4-TC2-NonSyscoItem details entered")
				     .TapOnDone("MIL - WF 1 WF 4-TC2-Tapped Done")
				   
			 	     
				     //og item addition
				     ._atLocationsPage()
			 	     .TapAddLocation("MIL - WF 1 WF 4-TC2-Tapped ADD")
			 	    
			 	     .AddItemFrom_OrderGuide("MIL - WF 1 WF 4-TC2-Tapped NonSysco")
			 	    ._atSetupInventoryPage()
			 	    .SelectItemFrom_OrderGuide("MIL - WF 1 WF 4-TC2-Selected item from OG")
				     .TapOnDone("MIL - WF 1 WF 4-TC2-Tapped Done")
				     .verifyOGItemsOnSetupInv("MIL - WF 1 WF 4-TC2-Verify item selected")
				       .TapOnDone("MIL - WF 1 WF 4-TC2-Tapped Done")
				      
				       
				         //product catalog additin
		         ._atLocationsPage()
	 	     .TapAddLocation("MIL - WF 1 WF 4-TC2-Tapped ADD")
	 	     ._atSetupInventoryPage()
	 	     .SearchItem(searchData.keyword,"MIL - WF 1 WF 4-TC2-Search item")
		      .SelectItemFrom_OrderGuide("MIL - WF 1 WF 4-TC2-Selected item from OG")
		     .TapOnDone("MIL - WF 1 WF 4-TC2-Tapped Done")
		     .verifyOGItemsOnSetupInv("MIL - WF 1 WF 4-TC2-Verify item selected")
		      .TapOnDone("MIL - WF 1 WF 4-TC2-Tapped Done")
		       
		      ._atLocationsPage()
		       .SelectLocation(locationsData.LocationName, "MIL - WF 1 WF 4-TC2-Selecting AddedLocation")
		      
		    //checking othr items in setupinventory -failing step
		     ._atSetupInventoryPage()
		           .verifySearchItemsOnSetupInv("MIL - WF 1 WF 4-TC2-Verify item selected")
		      .verifyOGItemsOnSetupInv("MIL - WF 1 WF 4-TC2-Verify item selected")
		   . verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL - WF 1 WF 4-TC2-Verify item selected")
		  .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL - WF 1 WF 4-TC2-Verify item selected")
						;
				}

			

			
				//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
				@Test(groups={"MIL - WF 5 MA"},priority=0, description = "MIL - WF 5-TC2-Selecting a location navigate to product and assiging  item  to diff location")
				public void MIL_WF5_Locations_ItemEdit_UpdateLocation_MA() {	
					
					LoginData loginData =LoginData.fetch("LoginData1");
					LocationsData locationsData =LocationsData.fetch("LocatiosData3");
					LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
					NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
					PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
					VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
					Start.asTester
						.goToLoginpage()
					//	.verifyLoginPage("SI - WF 8-TC2-TC1-LoginPage")
						.signIn(loginData.UserName, loginData.Password,"MIL- WF 5-TC2-Login")
					
					._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"MIL- WF 5-TC2-FirstAccountSelect")
		 		  
		     ._atInventoryToolPage()
			      .InvTools_SetUpInventory("MIL- WF 5-TC2-SetupInventoryTap")
			 
				._atSetupInventoryPage()
				 .TapOnSkip("MIL-WF5-TC2-Tapped Skip")
				.StartFromScratch("MIL-WF5-TC2-ScratchSelected")
			 .tapContinue("MIL-WF5-TC2-Tapped Continue")
				 .Scratch_AddItems("MIL-WF6-TC2-Tapped Add items")
				 .AddItemFrom_OrderGuide("MIL-WF5-TC2-Tapped Order Guide")
				 .SelectItemFrom_OrderGuide("MIL-WF5-TC2-Selected item from OG")
				 .TapOnDone("MIL-WF5-TC2-Tapped Done")
				.verifyOGItemsOnSetupInv("MIL-WF5-TC2-Verify item selected")
				.TapOnDone("MIL-WF5-TC2-Tapped Done")
				.TapOnSkip("MIL-WF5-TC2-Tapped Skip")
			
				._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF5-TC2-Tapped do this later")
				.TapOnSkip("MIL-WF5-TC2-Tapped Skip")
				.TapOnDOThisLater("MIL-WF5-TC2-Tapped do this later")
			
				._atCategoryPage()
				.tapContinue("MIL-WF5-TC2-Tapped Continue")
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
			       .VendorSelect(vendorDetailsData.VendorName,"MIL- WF 5-TC2-VendorSelect")
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
				   //defect there
				 //  ._atSetupInventoryPage()
				  // .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 4-TC2-Verify item selected")
					  
				  
						;
				}

				
			
				//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
				@Test(groups={"MEC - WF 1 MA"},priority=0, description = "MEC - WF 1-TC2-Selecting a location navigate to product and assiging  item  to category created")
				public void MEC_WF1_Locations_ItemEdit_UpdateCategory_MA() {	
					
					LoginData loginData =LoginData.fetch("LoginData1");
					LocationsData locationsData =LocationsData.fetch("LocatiosData3");
					LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
					NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
					PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
					VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
					CategoryData categoryData =CategoryData.fetch("CategoryData");
					
					Start.asTester
						.goToLoginpage()
					//	.verifyLoginPage("SMEC - WF 1-TC2-LoginPage")
						.signIn(loginData.UserName, loginData.Password,"MEC-WF 1-TC2-Login")
					
						._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .Third_AccountSelection(loginData.UserName,"MEC-WF 1-TC2-FirstAccountSelect")
		 		 
		     ._atInventoryToolPage()
			      .InvTools_SetUpInventory("MEC-WF 1-TC2-SetupInventoryTap")
			 
		     ._atSetupInventoryPage()
				 .TapOnSkip("MEC-WF 1-TC2-Tapped Skip")
				.StartFromScratch("MEC-WF 1-TC2-ScratchSelected")
			 .tapContinue("MEC-WF 1-TC2-Tapped Continue")
				 .Scratch_AddItems("MEC-WF 1-TC2-Tapped Add items")
				 .AddItemFrom_OrderGuide("MEC-WF 1-TC2-Tapped Order Guide")
				 .SelectItemFrom_OrderGuide("MEC-WF 1-TC2-Selected item from OG")
				 .TapOnDone("MEC-WF 1-TC2-Tapped Done")
				.verifyOGItemsOnSetupInv("MEC-WF 1-TC2-Verify item selected")
				.TapOnDone("MEC-WF 1-TC2-Tapped Done")
				.TapOnSkip("MEC-WF 1-TC2-Tapped Skip")
			
				._atSetupInventoryPage()
			.TapOnDOThisLater("MEC-WF 1-TC2-Tapped do this later")
				.TapOnSkip("MEC-WF 1-TC2-Tapped Skip")
				.TapOnDOThisLater("MEC-WF 1-TC2-Tapped do this later")
			
				._atCategoryPage()
				.tapContinue("MEC-WF 1-TC2-Tapped Continue")
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
			       .VendorSelect(vendorDetailsData.VendorName,"MEC-WF 1-TC2-VendorSelect")
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
							@Test(groups={"MIL - WF 2 MA"},priority=0, description = "MIL - WF 2-TC2-Selecing a location, adding same items to multiple location")
							public void MIL_WF2_Location_AddItems__MultipleLocation_MA() {	
								
								LoginData loginData =LoginData.fetch("LoginData2");
								LocationsData locationsData =LocationsData.fetch("LocatiosData3");
								LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
								LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
								NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
								PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
								VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
								SearchData searchData=SearchData.fetch("SearchData");
								Start.asTester
									.goToLoginpage()
									.verifyLoginPage("MIL-WF 2-TC2-LoginPage")
									.signIn(loginData.UserName, loginData.Password,"MIL-WF 2-TC2-Login")
										
											._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		 	
									 ._atInventoryToolPage()
									 .InvTools_TrackInventory("MIL-WF 2-TC2-TrackinventoryTap")
								    
								//creating a location1       
								     ._atLocationsPage()
								     .TapAddLocation("MIL-WF 2-TC2-Tapped ADD")
							         .AddLocationName(locationsData.LocationName,"MIL-WF 2-TC2-Enter location1 name")
								     .AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
								     .TapOnDone("MIL-WF 2-TC2-Tapped Done")
								     .TapOnBack("MIL-WF 2-TC2-Tapped Back")
								     .VerifyLocationList(locationsData.LocationName, "MIL-WF 2-TC2-Verifing Added Location1")
								     
								    //nonsysco item addition to location1
								     .SelectLocation(locationsData.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
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
							       .VendorSelect(vendorDetailsData.VendorName,"MIL-WF 2-TC2-VendorSelect")
							       
							     //same nonsysco item addition to location2 
							       ._atLocationsPage()
							        .AddLocation_AddProductDetailsPage("MIL-WF 2-TC2-Select Add/Select location option")
							   .TapAddLocation("MIL-WF 2-TC2-Tapped ADD")
							   .AddLocationName(locationsData1.LocationName,"MIL-WF 2-TC2-Enter location2 name")
							     .AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
							     .TapOnDone("MIL-WF 2-TC2-Tapped Done")
							     .TapOnBack("MIL-WF 2-TC2-Tapped Back")
							     .VerifyLocationList(locationsData1.LocationName, "MIL-WF 2-TC2-Verifing Added Location2")
							     
							   .SelectLocation(locationsData1.LocationName, "MIL-WF 2-TC2-Selecting Added Location2")
							   .SelectLocation(locationsData.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
							   .LocationDoneSelection("MIL-WF 2-TC2-Selecting Done")
							   .TapOnDone("MIL-WF 2-TC2-Tapped Done")
							   
							 //prep item addition to location1
							      
						 	     .TapAddLocation("MIL-WF 2-TC2-Tapped ADD")
						 	     
						 	     ._atSetupInventoryPage()
						 	      .AddItemFrom_PrepItem("MIL-WF 2-TC2-Tapped Prepitem")
							     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL-WF 2-TC2-NonSyscoItem details entered")
							    
							   //same prep item addition to location3 
							       ._atLocationsPage()
							     .AddLocation_AddProductDetailsPage("MIL-WF 2-TC2-Select Add/Select location option")
								   .TapAddLocation("MIL-WF 2-TC2-Tapped ADD")
								   .AddLocationName(locationsData2.LocationName,"MIL-WF 2-TC2-Enter location3 name")
								     .AddLocationCooler("MIL-WF 2-TC2-Tapped Cooler")
								     .TapOnDone("MIL-WF 2-TC2-Tapped Done")
								     .TapOnBack("MIL-WF 2-TC2-Tapped Back")
								     .VerifyLocationList(locationsData2.LocationName, "MIL-WF 2-TC2-Verifing Added Location3")
								     
								   .SelectLocation(locationsData2.LocationName, "MIL-WF 2-TC2-Selecting Added Location3")
								   .SelectLocation(locationsData.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
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
					      .TapOnBack("MIL-WF 2-TC2-Tapped Back")
					      .SelectLocation(locationsData.LocationName, "MIL-WF 2-TC2-Selecting Added Location1")
					      ._atSetupInventoryPage()
					      .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL-WF 2-TC2-Verify prep item selected in Location1")
					      
					      //failing since items are replaced
						//  . verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL-WF 2-TC2-Verify nonsysco item selected in Location1")
			             
					      //from og,catalog not able to add location
					  				;
							}
	
    
						
	//Precond:setupinventory should be done so that trackinv is enabled , location with items
							@Test(groups={"MIL - WF 3"},priority=0, description = "MIL - WF 3-TC2-Selecting a specific location in trackinventory and search for items within location for MA user")
							public void MIL_WF3_Location_SearchItems_MA() {	
								
								LoginData loginData =LoginData.fetch("LoginData2");
								LocationsData locationsData =LocationsData.fetch("LocatiosData3");
								LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
								NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
								PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
								VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
								SearchData searchData=SearchData.fetch("SearchData");
								Start.asTester
									.goToLoginpage()
									.verifyLoginPage("MIL - WF 3-TC2-LoginPage")
									.signIn(loginData.UserName, loginData.Password,"MIL - WF 3-TC2-Login")
																			
											._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"MIL - WF 3-TC2-FirstAccountSelect")
		 	
				 //setting up inventory    
				     ._atInventoryToolPage()
				      .InvTools_SetUpInventory("MIL-WF3-TC2-SetupInventoryTap")
				      
				       ._atSetupInventoryPage()
				       .TapOnSkip("MIL-WF3-TC2-Tapped Skip")
				     .StartFromScratch("MIL-WF3-TC2-ScratchSelected")
				     .tapContinue("MIL-WF3-TC2-Tapped Continue")
				     .Scratch_AddItems("MIL-WF3-TC2-Tapped Add items")
				     .AddItemFrom_OrderGuide("MIL-WF3-TC2-Tapped Order Guide")
				     .SelectItemFrom_OrderGuide("MIL-WF3-TC2-Selected item from OG")
				     .TapOnDone("MIL-WF3-TC2-Tapped Done")
				     .verifyOGItemsOnSetupInv("MIL-WF3-TC2-Verify item selected")
				       .TapOnDone("MIL-WF3-TC2-Tapped Done")
				       .TapOnSkip("MIL-WF3-TC2-Tapped Skip")
				           
				        ._atSetupInventoryPage()
				        .TapOnDOThisLater("MIL-WF3-TC2-Tapped do this later")
				        .TapOnSkip("MIL-WF3-TC2-Tapped Skip")
				        .TapOnDOThisLater("MIL-WF3-TC2-Tapped do this later")
				        
				        ._atCategoryPage()
				        .tapContinue("MIL-WF3-TC2-Tapped Continue")
				           
				            
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
					     
									;
							}
	
	
						
    
							@Test(groups={"SI - WF 16 MA"},priority=0, description = "SI - WF 16-TC1-Start from scratch + Multiple lists+ Skip location+ Skip Category")
							public void SI_WF16_StartFromScratch_MultipleList_skipLocation_SkipCategory_MA() {	
								
								LoginData loginData =LoginData.fetch("LoginData3");
								LocationsData locationsData =LocationsData.fetch("LocatiosData4");
								CategoryData categoryData=CategoryData.fetch("CategoryData");
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
								 	  
								 	  
								 	  .verifySearchItemsOnSetupInv("SI - WF 16-TC1-Verify item selected")
								  		.verifyOGItemsOnSetupInv("SI - WF 16-TC1-Verify item selected")
								  		
								 	    ._atVendorPage()
							.Add_Supplier("SI - WF 16-TC1-AddVendorTap")
							 .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 16-TC1-AddVendorDetails")
							 .TapOnDone("SI - WF 16-TC1-Done")
							.TapOnBack("SI - WF 16-TC1-Back")
						   .VendorSelect(vendorDetailsData.VendorName,"SI - WF 16-TC1-VendorSelect")
						 	.TapOnDone("SI - WF 16-TC1-Done")
						 	
						 	._atSetupInventoryPage()
							
							.Setup_AddItemsLink("SI - WF 16-TC1-Add items Selected")
							 .AddItemFrom_PrepItem("SI - WF 16-TC1-Tapped NonSysco")
								     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 16-TC1-NonSyscoItemAddPage")
								   	.TapOnDone("SI - WF 16-TC1-Tapped Done")
								   	
								  	
								    .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 16-TC1-Verify item selected")
								    	.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 16-TC1-Verify item selected")
								
								   		
								   	.TapOnDone("SI - WF 16-TC1-Tapped Done")
						 	  .TapOnSkip("SI - WF 16-TC1-Tapped Skip")
								     
								       .TapOnDOThisLater("SI - WF 16-TC1-Tapped do this later")
								         .TapOnSkip("SI - WF 16-TC1-Tapped Skip")
								        
								 
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
							@Test(groups={"SI - WF 17 MA"},priority=0, description = "SI - WF 17-TC1-Start from scratch + Multiple lists + Default loc + Skip Category")
							public void SI_WF17_StartFromScratch_MultipleList_DefaultLocation_SkipCategory_MA() {	
								
								LoginData loginData =LoginData.fetch("LoginData3");
								LocationsData locationsData =LocationsData.fetch("LocatiosData4");
								CategoryData categoryData=CategoryData.fetch("CategoryData");
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
								     .verifySearchItemsOnSetupInv("SI - WF 17-TC1-Verify item selected")
								       
								       .Setup_AddItemsLink("SI - WF 17-TC1-Add items Selected")
								       .AddItemFrom_OrderGuide("SI - WF 17-TC1-Tapped Order Guide")
								     .SelectItemFrom_OrderGuide("SI - WF 17-TC1-Selected item from OG")
								     .TapOnDone("SI - WF 17-TC1-Tapped Done")
								     .verifyOGItemsOnSetupInv("SI - WF 17-TC1-Verify item selected")
								       
								     .Setup_AddItemsLink("SI - WF 17-TC1-Add items Selected")
								      .AddItemFrom_NonSysco("SI - WF 17-TC1-Tapped NonSysco")
								     .EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "SI - WF 17-TC1-NonSyscoItem details entered")
								 	  .AddSupplier_AddProductDetailsPage("SI - WF 17-TC1-select supplier")
								 	  
								 	  
								 	  .verifySearchItemsOnSetupInv("SI - WF 17-TC1-Verify item selected")
								  		.verifyOGItemsOnSetupInv("SI - WF 17-TC1-Verify item selected")
								  		
								 	    ._atVendorPage()
							.Add_Supplier("SI - WF 17-TC1-AddVendorTap")
							 .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "SI - WF 17-TC1-AddVendorDetails")
							 .TapOnDone("SI - WF 17-TC1-Done")
							.TapOnBack("SI - WF 17-TC1-Back")
						   .VendorSelect(vendorDetailsData.VendorName,"SI - WF 17-TC1-VendorSelect")
						 	.TapOnDone("SI - WF 17-TC1-Done")
						 	
						 	._atSetupInventoryPage()
							
							.Setup_AddItemsLink("SI - WF 17-TC1-Add items Selected")
							 .AddItemFrom_PrepItem("SI - WF 17-TC1-Tapped NonSysco")
								     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI - WF 17-TC1-NonSyscoItemAddPage")
								   	.TapOnDone("SI - WF 17-TC1-Tapped Done")
								   	
								  	
								    .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 17-TC1-Verify item selected")
								    	.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 17-TC1-Verify item selected")
								
								   		
								   	.TapOnDone("SI - WF 17-TC1-Tapped Done")
						 	  .TapOnSkip("SI - WF 17-TC1-Tapped Skip")
								     
						 	  
						 	   ._atLocationsPage()
		       .DefaultLocation("SI - WF 12-TC2-Tapped Default location")
		        .tapContinue("SI - WF 12-TC2-Tapped Continue")
		          
		        ._atSetupInventoryPage()
		         .TapOnSkip("SI - WF 12-TC2-Tapped Skip")
		       
								      
								           .TapOnDOThisLater("SI - WF 17-TC1-Tapped do this later")
								           .tapContinue("SI - WF 17-TC1-Tapped Continue")
								           
								           ._atInventoryToolPage()
								           .InvTools_TrackInventory("SI - WF 17-TC1-Selected track inventory")
								
								            
								            ._atLocationsPage()
								            .SelectLocation(locationsData.LocationName, "SI - WF 17-TC1-select added location")
								                // .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 9-TC2-Verify item inside location")
								             .TapOnDone("SI - WF 17-TC1-Tapped Done")
									;
							}				
    
							@Test(groups={"SI - WF 24 NU"},priority=0, description = "SI - WF 24-TC1-Custom List + Skip location+ Skip Category for Normal user")
							public void SI_WF24_CustomList_SkipLoc_Skipcategory_NU() {	
								
								LoginData loginData =LoginData.fetch("LoginData3");
								ListData listData=ListData.fetch("ListData");
								LocationsData locationsData =LocationsData.fetch("LocatiosData4");
								
								Start.asTester
									.goToLoginpage()
										.verifyLoginPage("SI - WF 24-TC1-LoginPage")
									.signIn(loginData.UserName, loginData.Password,"SI - WF 24-TC1-LoginPage")
									
									._atHomePage()
									.ClickAccount(loginData.UserName,"SI - WF 24-TC1 Clicked account")
									
									._atAccountsPage()
								     .Fifth_AccountSelection(loginData.UserName,"SI - WF 24-TC1-FirstAccountSelect")
								  
									._atInventoryToolPage()
									      .InvTools_SetUpInventory("SI - WF 24-TC1-SetupInventoryTap")
									     
									       ._atSetupInventoryPage()
									       .ReadytoStart("SI - WF 24-TC1-Ready to start")
									       .ReadytoStart("SI - WF 24-TC1-Ready to start")
									       
									       ._atListPage()
									       .TapCustomList("SI - WF 24-TC1-custom list Selected")
									         .tapContinue("SI - WF 24-TC1-Tapped Continue1")
									           .SelectListwithItems(listData.ListName, "SI - WF 24-TC1-select list")
									           .TapOnNext("SI - WF 24-TC1-tapped next")
									           
									          
									          ._atSetupInventoryPage()
									      .TapOnSkip("SI - WF 24-TC1-Skip1 Tapped")
									      
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
							@Test(groups={"SI - WF 25 NU"},priority=0, description = "SI - WF 25-TC1-Custom List+Default loc + Skip Category for Normal user")
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
								     .Fifth_AccountSelection(loginData.UserName,"SI - WF 25-TC1-FirstAccountSelect")
								  
									._atInventoryToolPage()
									      .InvTools_SetUpInventory("SI - WF 25-TC1-SetupInventoryTap")
									     
									       ._atSetupInventoryPage()
									       .ReadytoStart("SI - WF 25-TC1-Ready to start")
									       .ReadytoStart("SI - WF 25-TC1-Ready to start")
									       
									       ._atListPage()
									       .TapCustomList("SI - WF 25-TC1-custom list Selected")
									         .tapContinue("SI - WF 25-TC1-Tapped Continue1")
									           .SelectListwithItems(listData.ListName, "SI - WF 25-TC1-select list")
									           .TapOnNext("SI - WF 25-TC1-tapped next")
									           
									          
									          ._atSetupInventoryPage()
									      .TapOnSkip("SI - WF 25-TC1-Skip1 Tapped")
									      
									      ._atLocationsPage()
				      .DefaultLocation("SI - WF 25-TC1-Tapped Custom location")
				        .tapContinue("SI - WF 25-TC1-Tapped Continue")
				        
				        ._atSetupInventoryPage()
									      .TapOnSkip("SI - WF 25-TC1-Skip1 Tapped")
									           .TapOnDOThisLater("SI - WF 25-TC1-STapOnDOThisLater Tapped")
										       
										           
										        .tapContinue("SI - WF 25-TC1-Tapped Continue3")   
										      
										  ._atInventoryToolPage()
										  .InvTools_TrackInventory("SI - WF 25-TC1-Selected track inventory")
										 
										      ._atLocationsPage()
										        .SelectLocation(locationsData.LocationName, "SI - WF 25-TC1-select added location")
										           //.ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
										             .TapOnDone("SI - WF 25-TC1-Tapped Done")
										;
									
							}
							@Test(groups={"SI - WF 26 NU"},priority=0, description = "SI - WF 26-TC1-Custom List+skip location + default category for Normal user")
							public void SI_WF26_CustomList_SkipLoc_defaultcategory_NU() {	
								
								LoginData loginData =LoginData.fetch("LoginData3");
								ListData listData=ListData.fetch("ListData");
								LocationsData locationsData =LocationsData.fetch("LocatiosData4");
								
								Start.asTester
									.goToLoginpage()
										.verifyLoginPage("SI - WF 26-TC1-LoginPage")
									.signIn(loginData.UserName, loginData.Password,"SI - WF 26-TC1-LoginPage")
									
									._atHomePage()
									.ClickAccount(loginData.UserName,"SI - WF 26-TC1 Clicked account")
									
									._atAccountsPage()
								     .Fifth_AccountSelection(loginData.UserName,"SI - WF 26-TC1-FirstAccountSelect")
								  
									._atInventoryToolPage()
									      .InvTools_SetUpInventory("SI - WF 26-TC1-SetupInventoryTap")
									     
									       ._atSetupInventoryPage()
									       .ReadytoStart("SI - WF 26-TC1-Ready to start")
									       .ReadytoStart("SI - WF 26-TC1-Ready to start")
									       
									       ._atListPage()
									       .TapCustomList("SI - WF 26-TC1-custom list Selected")
									         .tapContinue("SI - WF 26-TC1-Tapped Continue1")
									           .SelectListwithItems(listData.ListName, "SI - WF 26-TC1-select list")
									           .TapOnNext("SI - WF 26-TC1-tapped next")
									           
									          
									          ._atSetupInventoryPage()
									      .TapOnSkip("SI - WF 26-TC1-Skip1 Tapped")
									      
									           .TapOnDOThisLater("SI - WF 226-TC1-TapOnDOThisLater Tapped")
										       
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
							
							
    
								@Test(groups={"SI - WF 23 NU"},priority=0, description = "SI - WF 23-TC1-Custom List + Custom Loc + default Category for Normal user")
								public void SI_WF23_CustomList_CustomLoc_defaultcategory_NU() {	
									
									LoginData loginData =LoginData.fetch("LoginData4");
									ListData listData=ListData.fetch("ListData");
									LocationsData locationsData =LocationsData.fetch("LocatiosData4");
									LocationsData locationsData1 =LocationsData.fetch("LocationsData");
									LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
									
									Start.asTester
										.goToLoginpage()
											.verifyLoginPage("SI - WF 23-TC1-LoginPage")
										.signIn(loginData.UserName, loginData.Password,"SI - WF 23-TC1-LoginPage")
										
										._atHomePage()
										.ClickAccount(loginData.UserName,"SI - WF 23-TC1 Clicked account")
										
										._atAccountsPage()
									     .Fifth_AccountSelection(loginData.UserName,"SI - WF 23-TC1-FirstAccountSelect")
									  
										._atInventoryToolPage()
										      .InvTools_SetUpInventory("SI - WF 23-TC1-SetupInventoryTap")
										     
										       ._atSetupInventoryPage()
										       .ReadytoStart("SI - WF 23-TC1-Ready to start")
										       .ReadytoStart("SI - WF 23-TC1-Ready to start")
										       
										       ._atListPage()
										       .TapCustomList("SI - WF 23-TC1-custom list Selected")
										         .tapContinue("SI - WF 23-TC1-Tapped Continue1")
										           .SelectListwithItems(listData.ListName, "SI - WF 23-TC1-select list")
										           .TapOnNext("SI - WF 23-TC1-tapped next")
										           
										          
										          ._atSetupInventoryPage()
										      .TapOnSkip("SI - WF 23-TC1-Skip1 Tapped")
										      
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
											      ._atSetupInventoryPage()
												       .TapOnSkip("SI - WF 23-TC2-Skip3 Tapped")
												      ._atCategoryPage()
												      .defaultCategories("SI - WF 23-TC1-Tapped Default category")
												      .tapComplete("SI - WF 23-TC1-Tapped Complete")
												           
												       ._atSetupInventoryPage()
												      .TapTakeHome("SI - WF 23-TC1-Tapped Continue3")   
												      
												  ._atInventoryToolPage()
												  .InvTools_TrackInventory("SI - WF 23-TC1-Selected track inventory")
												 
												      ._atLocationsPage()
											        .SelectLocation(locationsData1.LocationName, "SI - WF 23-TC1-select added location")
											        .ItemVerifyOnLocation1("SI - WF 23-TC1-Item verification")
											        .TapOnDone("SI - WF 1-TC1-Tapped Done")
												     .SelectLocation(locationsData2.LocationName, "SI - WF 23-TC1-select added location")
											        .ItemVerifyOnLocation2("SI - WF 23-TC1-Item verification")
											        .TapOnDone("SI - WF 23-TC1-Tapped Done")      
												;
												}
								@Test(groups={"SI - WF 20 NU"},priority=0, description = "SI - WF 20-TC1-Custom List + Custom Loc + Custom Category for Normal user")
								public void SI_WF20_CustomList_CustomLoc_Customcategory_NU() {	
									
									LoginData loginData =LoginData.fetch("LoginData4");
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
									     .Fifth_AccountSelection(loginData.UserName,"SI - WF 20-TC1-FirstAccountSelect")
									  
										._atInventoryToolPage()
										      .InvTools_SetUpInventory("SI - WF 20-TC1-SetupInventoryTap")
										     
										       ._atSetupInventoryPage()
										       .ReadytoStart("SI - WF 20-TC1-Ready to start")
										       .ReadytoStart("SI - WF 20-TC1-Ready to start")
										       
										       ._atListPage()
										       .TapCustomList("SI - WF 20-TC1-custom list Selected")
										         .tapContinue("SI - WF 20-TC1-Tapped Continue1")
										           .SelectListwithItems(listData.ListName, "SI - WF 20-TC1-select list")
										           .TapOnNext("SI - WF 20-TC1-tapped next")
										           
										          
										          ._atSetupInventoryPage()
										      .TapOnSkip("SI - WF 20-TC1-Skip1 Tapped")
										      
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
											      ._atSetupInventoryPage()
												       .TapOnSkip("SI - WF 20-TC2-Skip3 Tapped")
												    
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
								@Test(groups={"SI - WF 22 NU"},priority=0, description = "SI - WF 22-TC1-Custom List + Default Loc + custom Category for Normal user")
								public void SI_WF22_CustomList_DefaultLoc_Customcategory_NU() {	
									
									LoginData loginData =LoginData.fetch("LoginData4");
									ListData listData=ListData.fetch("ListData");
									LocationsData locationsData =LocationsData.fetch("LocatiosData4");
									CategoryData categoryData=CategoryData.fetch("CategoryData");
									
									Start.asTester
										.goToLoginpage()
											.verifyLoginPage("SI - WF 22-TC1-LoginPage")
										.signIn(loginData.UserName, loginData.Password,"SI - WF 22-TC1-LoginPage")
										
										._atHomePage()
										.ClickAccount(loginData.UserName,"SI - WF 22-TC1 Clicked account")
										
										._atAccountsPage()
									     .Fifth_AccountSelection(loginData.UserName,"SI - WF 22-TC1-FirstAccountSelect")
									  
										._atInventoryToolPage()
										      .InvTools_SetUpInventory("SI - WF 22-TC1-SetupInventoryTap")
										     
										       ._atSetupInventoryPage()
										       .ReadytoStart("SI - WF 22-TC1-Ready to start")
										       .ReadytoStart("SI - WF 22-TC1-Ready to start")
										       
										       ._atListPage()
										       .TapCustomList("SI - WF 22-TC1-custom list Selected")
										         .tapContinue("SI - WF 22-TC1-Tapped Continue1")
										           .SelectListwithItems(listData.ListName, "SI - WF 22-TC1-select list")
										           .TapOnNext("SI - WF 22-TC1-tapped next")
										           
										          
										          ._atSetupInventoryPage()
										      .TapOnSkip("SI - WF 22-TC1-Skip1 Tapped")
										      
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
    
								@Test(groups={"SI - WF 21 NU"},priority=0, description = "SI - WF 21-TC1-Custom List + Custom Loc + Custom Category for Normal user")
								public void SI_WF21_CustomList_CustomLoc_Customcategory_NU() {	
									
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
									     .Fifth_AccountSelection(loginData.UserName,"SI - WF 21-TC1-FirstAccountSelect")
									  
										._atInventoryToolPage()
										      .InvTools_SetUpInventory("SI - WF 21-TC1-SetupInventoryTap")
										     
										       ._atSetupInventoryPage()
										       .ReadytoStart("SI - WF 21-TC1-Ready to start")
										       .ReadytoStart("SI - WF 21-TC1-Ready to start")
										       
										       ._atListPage()
										       .TapCustomList("SI - WF 21-TC1-custom list Selected")
										         .tapContinue("SI - WF 21-TC1-Tapped Continue1")
										           .SelectListwithItems(listData.ListName, "SI - WF 21-TC1-select list")
										           .TapOnNext("SI - WF 21-TC1-tapped next")
										           
										          
										          ._atSetupInventoryPage()
										      .TapOnSkip("SI - WF 21-TC1-Skip1 Tapped")
										      
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
											      ._atSetupInventoryPage()
												       .TapOnSkip("SI - WF 21-TC2-Skip3 Tapped")
												    
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
    
    
								//Precondition: Need 2 items each for List2,List3 for logged in user. Give item ID on datapool. uomsc002
								@Test(groups={"SI - WF 27 NU"},priority=0, description = "SI - WF 27-TC1-Custom List + Select Multiple List +List Names+Default Cat for Normal user")
								public void SI_WF27_CustomList_MultipleList_ListNames_DefaultCat_NU() {	
									
									LoginData loginData =LoginData.fetch("LoginData4");
									ListData listData=ListData.fetch("ListData2");
									ListData listData1=ListData.fetch("ListData3");
									LocationsData locationsData =LocationsData.fetch("LocatiosData4");
									
									Start.asTester
										.goToLoginpage()
											.verifyLoginPage("SI - WF 27-TC1-LoginPage")
										.signIn(loginData.UserName, loginData.Password,"SI - WF 27-TC1-LoginPage")
										
										._atHomePage()
										.ClickAccount(loginData.UserName,"SI - WF 27-TC1 Clicked account")
										
										._atAccountsPage()
									     .Fifth_AccountSelection(loginData.UserName,"SI - WF 27-TC1-FirstAccountSelect")
									  
										._atInventoryToolPage()
										      .InvTools_SetUpInventory("SI - WF 27-TC1-SetupInventoryTap")
										     
										       ._atSetupInventoryPage()
										       .ReadytoStart("SI - WF 27-TC1-Ready to start")
										       .ReadytoStart("SI - WF 27-TC1-Ready to start")
										       
										       ._atListPage()
										       .TapCustomList("SI - WF 27-TC1-custom list Selected")
										         .tapContinue("SI - WF 27-TC1-Tapped Continue1")
										           .SelectListwithItems(listData.ListName, "SI - WF 27-TC1-select list")
										            .SelectListwithItems(listData1.ListName, "SI - WF 27-TC1-select list")
										           .TapOnNext("SI - WF 27-TC1-tapped next")
										           
										          
										          ._atSetupInventoryPage()
										      .TapOnSkip("SI - WF 27-TC1-Skip1 Tapped")
										      
										      ._atLocationsPage()
					      .ListNames("SI - WF 27-TC1-Tapped Custom location")
					        .tapContinue("SI - WF 27-TC1-Tapped Continue")
					        
					        ._atSetupInventoryPage()
										      .TapOnSkip("SI - WF 27-TC1-Skip1 Tapped")
										         
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
								}


