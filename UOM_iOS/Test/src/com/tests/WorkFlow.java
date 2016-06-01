
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
		
		            
		            ._atLocationsPage()
		            .SelectLocation(locationsData.LocationName, "SI - WF 10-TC1-select added location")
		          //.ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 10-TC1-Verify item inside location")
		              .TapOnDone("SI - WF 10-TC1-Tapped Done")
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
		
		            
		           ._atLocationsPage()
		           .SelectLocation(locationsData.LocationName, "SI - WF 9-TC2-select added location")
		         // .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 9-TC2-Verify item inside location")
		             .TapOnDone("SI - WF 9-TC2-Tapped Done")
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
		
		            
		            ._atLocationsPage()
		            .SelectLocation(locationsData.LocationName, "SI - WF 12-TC2-select added location")
		          /*.ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 12-TC2-Verify item inside location")
		            ._atSetupInventoryPage()
		            .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		            .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI - WF 12-TC2-Verify item selected")
		         */     .TapOnDone("SI - WF 12-TC2-Tapped Done")
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
				 
				      ._atLocationsPage()
				        .SelectLocation(locationsData.LocationName, "SI - WF 19-TC1-select added location")
				          //  .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
				             .TapOnDone("SI - WF 9-TC1-Tapped Done")
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
		     .verifySearchItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")
		       
		       .Setup_AddItemsLink("SI - WF 18-TC1-Add items Selected")
		       .AddItemFrom_OrderGuide("SI - WF 18-TC1-Tapped Order Guide")
		     .SelectItemFrom_OrderGuide("SI - WF 18-TC1-Selected item from OG")
		     .TapOnDone("SI - WF 18-TC1-Tapped Done")
		     .verifyOGItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")
		       
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
		
		   		//.verifySearchItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")
		  	//	.verifyOGItemsOnSetupInv("SI - WF 18-TC1-Verify item selected")
		  
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
	 
	      ._atLocationsPage()
	        .SelectLocation(locationsData.LocationName, "SI - WF 10-TC1-select added location")
	          //  .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
	             .TapOnDone("SI - WF 1-TC1-Tapped Done")
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
		 
		      ._atLocationsPage()
		     //       .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
		             .TapOnDone("SI - WF 7-TC1-Tapped Done")
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
				@Test(groups={"MIL - WF 1 WF 3 MA"},priority=0, description = "MIL - WF 1,WF 3-TC2-Creating Location in trackinventory and add items from multile lists to location for MA user")
				public void MIL_WF1_WF3_Location_AddItems_MA() {	
					
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
						.signIn(loginData.UserName, loginData.Password,"MIL - WF 1,3-TC2-Login")
							
	._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		   
		     
		     //setting up inventory    
			 ._atInventoryToolPage()
				.InvTools_SetUpInventory("MIL-WF6-TC2-SetupInventoryTap")
				
			 ._atSetupInventoryPage()
				 .TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				.StartFromScratch("MIL-WF6-TC2-ScratchSelected")
			 .tapContinue("MIL-WF6-TC2-Tapped Continue")
				 .Scratch_AddItems("MIL-WF6-TC2-Tapped Add items")
				 .AddItemFrom_OrderGuide("MIL-WF6-TC2-Tapped Order Guide")
				 .SelectItemFrom_OrderGuide("MIL-WF6-TC2-Selected item from OG")
				 .TapOnDone("MIL-WF6-TC2-Tapped Done")
				.verifyOGItemsOnSetupInv("MIL-WF6-TC2-Verify item selected")
				.TapOnDone("MIL-WF6-TC2-Tapped Done")
				.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
			
				._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
				.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
			
				._atCategoryPage()
				.tapContinue("MIL-WF6-TC2-Tapped Continue")

						 ._atInventoryToolPage()
						 .InvTools_TrackInventory("MIL-WF1,3-TC2-TrackinventoryTap")
					    
					       
					     ._atLocationsPage()
					     .TapAddLocation("MIL - WF 1,3-TC2-Tapped ADD")
				         .AddLocationName(locationsData.LocationName,"MIL - WF 1,3-TC2-Enter location name")
					     .AddLocationCooler("MIL- WF 1,3-TC2-Tapped Cooler")
					     .TapOnDone("MIL - WF 1,3-TC2-Tapped Done")
					     .TapOnBack("MIL - WF 1,3-TC2-Tapped Back")
					     .VerifyLocationList(locationsData.LocationName, "MIL - WF 1,3-TC2-Verifing AddedLocation")
					    //nonsysco addition 
					     .SelectLocation(locationsData.LocationName, "MIL - WF 1,3-TC2-Selecting AddedLocation")
					     .TapAddLocation("MIL - WF 1,3-TC2-Tapped ADD")
					  
					     ._atSetupInventoryPage()
					     .AddItemFrom_NonSysco("MIL - WF 1,3-TC2-Tapped NonSysco")
					     .EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL - WF 1,3-TC2-NonSyscoItem details entered")
					 	  .AddSupplier_AddProductDetailsPage("MIL - WF 1,3-TC2-select supplier")
					 	
					 	  ._atVendorPage()
				         .Add_Supplier("MIL - WF 1,3-TC2-AddVendorTap")
				       .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL - WF 1,3-TC2-AddVendorDetails")
				      .TapOnDone("MIL - WF 1,3-TC2-Done")
				    // .TapOnDone("SI - WF 6-TC2-Done") //iphone
				     .TapOnBack("MIL - WF 1,3-TC2-Back")
				       .VendorSelect(vendorDetailsData.VendorName,"MIL - WF 1,3-TC2-VendorSelect")
			 	     .TapOnDone("MIL - WF 1,3-TC2-Done")
			 	 
			 	     
			 
			 	    
			 	     //prepitemaddition
			 	     ._atLocationsPage()   
			 	     .TapAddLocation("MIL - WF 1,3-TC2-Tapped ADD")
			 	     
			 	     ._atSetupInventoryPage()
			 	      .AddItemFrom_PrepItem("MIL - WF 1,3-TC2-Tapped NonSysco")
				     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "MIL - WF 1,3-TC2-NonSyscoItem details entered")
				     .TapOnDone("MIL - WF 1,3-TC2-Tapped Done")
				   
			 	     
				     //og item addition
				     ._atLocationsPage()
			 	     .TapAddLocation("MIL - WF 1,3-TC2-Tapped ADD")
			 	    
			 	     .AddItemFrom_OrderGuide("MIL- WF 1,3-TC2-Tapped NonSysco")
			 	    ._atSetupInventoryPage()
			 	    .SelectItemFrom_OrderGuide("MIL - WF 1,3-TC2-Selected item from OG")
				     .TapOnDone("MIL - WF 1,3-TC2-Tapped Done")
				     .verifyOGItemsOnSetupInv("MIL  - WF 1,3-TC2-Verify item selected")  
				       .TapOnDone("MIL - WF 1,3-TC2-Tapped Done")
				      
				       
				         //product catalog additin
		         ._atLocationsPage()
	 	     .TapAddLocation("MIL - WF 1,3-TC2-Tapped ADD")
	 	     ._atSetupInventoryPage()
	 	     .SearchItem(searchData.keyword,"MIL - WF 1,3-TC2-Search item")
		      .SelectItemFrom_OrderGuide("MIL - WF 1,3-TC2-Selected item from OG")
		     .TapOnDone("MIL - WF 1,3-TC2-Tapped Done")
		     .verifyOGItemsOnSetupInv("MIL - WF 1,3-TC2-Verify item selected")
		      .TapOnDone("MIL - WF 1,3-TC2-Tapped Done")
		       
		      ._atLocationsPage()
		       .SelectLocation(locationsData.LocationName, "MIL - WF 1,3-TC2-Selecting AddedLocation")
		      
		    //checking othr items in setupinventory -failing step
		  //      ._atSetupInventoryPage()
		        //   .verifySearchItemsOnSetupInv("MIL - WF 1,3-TC2-Verify item selected")
		 //      .verifyOGItemsOnSetupInv("MIL  - WF 1,3-TC2-Verify item selected")  
		//   . verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL - WF 1,3-TC2-Verify item selected")
		 //   .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"MIL - WF 1,3-TC2-Verify item selected")
						;
				}

			

		//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
				@Test(groups={"MIL - WF 5 MA"},priority=0, description = "MIL - WF 5-TC2-Creating Location,Editing Location in Manage Locations and assiging  item  to diff location")
				public void MIL_WF5_Create_Edit_Delete_Locations_MA() {	
					
					LoginData loginData =LoginData.fetch("LoginData2");
					LocationsData locationsData =LocationsData.fetch("LocatiosData3");
					LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
					NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
					PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
					VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
					Start.asTester
						.goToLoginpage()
					//	.verifyLoginPage("SI - WF 8-TC2-TC1-LoginPage")
						.signIn(loginData.UserName, loginData.Password,"MIL - WF 5-TC2-Login")
					
				._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .Fourth_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		 		
		     ._atInventoryToolPage()
			      .InvTools_SetUpInventory("SI - WF 19-TC1-SetupInventoryTap")
			 
		     ._atSetupInventoryPage()
				 .TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				.StartFromScratch("MIL-WF6-TC2-ScratchSelected")
			 .tapContinue("MIL-WF6-TC2-Tapped Continue")
				 .Scratch_AddItems("MIL-WF6-TC2-Tapped Add items")
				 .AddItemFrom_OrderGuide("MIL-WF6-TC2-Tapped Order Guide")
				 .SelectItemFrom_OrderGuide("MIL-WF6-TC2-Selected item from OG")
				 .TapOnDone("MIL-WF6-TC2-Tapped Done")
				.verifyOGItemsOnSetupInv("MIL-WF6-TC2-Verify item selected")
				.TapOnDone("MIL-WF6-TC2-Tapped Done")
				.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
			
				._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
				.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
			
				._atCategoryPage()
				.tapContinue("MIL-WF6-TC2-Tapped Continue")
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
					   //  .TapOnBack("MIL- WF 5-TC2-Tapped Back")
					     .VerifyCancelledLocationList(locationsData.EditLocation, "MIL- WF 5-TC2-Verifing AddedLocation")
					     
					     
					  
						;
				}

				
				
				//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
				@Test(groups={"MIL - WF 4 MA"},priority=0, description = "MIL - WF 4-TC2-Selecting a location navigate to product and assiging  item  to diff location")
				public void MIL_WF4_Locations_ItemEdit_UpdateLocation_MA() {	
					
					LoginData loginData =LoginData.fetch("LoginData1");
					LocationsData locationsData =LocationsData.fetch("LocatiosData3");
					LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
					NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
					PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
					VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
					Start.asTester
						.goToLoginpage()
					//	.verifyLoginPage("SI - WF 8-TC2-TC1-LoginPage")
						.signIn(loginData.UserName, loginData.Password,"MIL- WF 4-TC2-Login")
					
					._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		 		  
		     ._atInventoryToolPage()
			      .InvTools_SetUpInventory("SI - WF 19-TC1-SetupInventoryTap")
			 
				._atSetupInventoryPage()
				 .TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				.StartFromScratch("MIL-WF6-TC2-ScratchSelected")
			 .tapContinue("MIL-WF6-TC2-Tapped Continue")
				 .Scratch_AddItems("MIL-WF6-TC2-Tapped Add items")
				 .AddItemFrom_OrderGuide("MIL-WF6-TC2-Tapped Order Guide")
				 .SelectItemFrom_OrderGuide("MIL-WF6-TC2-Selected item from OG")
				 .TapOnDone("MIL-WF6-TC2-Tapped Done")
				.verifyOGItemsOnSetupInv("MIL-WF6-TC2-Verify item selected")
				.TapOnDone("MIL-WF6-TC2-Tapped Done")
				.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
			
				._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
				.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
			
				._atCategoryPage()
				.tapContinue("MIL-WF6-TC2-Tapped Continue")
			         ._atInventoryToolPage()
					 .InvTools_TrackInventory("MIL- WF 4-TC2-TrackinventoryTap")
				     
				     ._atLocationsPage()
				     .TapAddLocation("MIL- WF 4-TC2-Tapped ADD")
			         .AddLocationName(locationsData.LocationName,"MIL- WF 4-TC2-Enter location name")
				     .AddLocationCooler("MIL- WF 4-TC2-Tapped Cooler")
				     .TapOnDone("MIL- WF 4-TC2-Tapped Done")
				     .TapOnBack("MIL- WF 4-TC2-Tapped Back")
				     .VerifyLocationList(locationsData.LocationName, "MIL- WF 4-TC2-Verifing AddedLocation")
				    //prepitem addition 
				     .SelectLocation(locationsData.LocationName, "MIL- WF 4-TC2-Selecting AddedLocation")
				     .TapAddLocation("MIL- WF 4-TC2-Tapped ADD")
				  
				     ._atSetupInventoryPage()
				     .AddItemFrom_NonSysco("MIL- WF 4-TC2-Tapped NonSysco")
				     .EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "MIL- WF 4-TC2-NonSyscoItem details entered")
				 	  .AddSupplier_AddProductDetailsPage("MIL- WF 4-TC2-select supplier")
				 	
				 	  ._atVendorPage()
			         .Add_Supplier("MIL- WF 4-TC2-AddVendorTap")
			       .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "MIL- WF 4-TC2-AddVendorDetails")
			      .TapOnDone("MIL- WF 4-TC2-Done")
			   
			     .TapOnBack("MIL- WF 4-TC2-Back")
			       .VendorSelect(vendorDetailsData.VendorName,"MIL- WF 4-TC2-VendorSelect")
		 	     .TapOnDone("MIL- WF 4-TC2-Done")
		 	        
		 	    ._atSetupInventoryPage()
				   .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 4-TC2-Verify item selected")
				   
				   ._atLocationsPage()
				   .ProductSelect(nonSyscoItemData.ProductName, "MIL- WF 4-TC2-Select Product")
				   .TapOnEdit("MIL- WF 4-TC2-Tapped Edit")
				   .AddLocation_AddProductDetailsPage("MIL- WF 4-TC2-Select Add/Select option")
				   .TapAddLocation("MIL- WF 4-TC2-Tapped ADD")
				   .AddLocationName(locationsData1.LocationName,"MIL- WF 4-TC2-Enter location name")
				     .AddLocationCooler("MIL- WF 4-TC2-Tapped Cooler")
				     .TapOnDone("MIL- WF 4-TC2-Tapped Done")
				     .TapOnBack("MIL- WF 4-TC2-Tapped Back")
				     .VerifyLocationList(locationsData1.LocationName, "MIL- WF 4-TC2-Verifing AddedLocation")
				     
				   .SelectLocation(locationsData1.LocationName, "MIL- WF 4-TC2-Selecting AddedLocation")
				   .SelectLocation(locationsData.LocationName, "MIL- WF 4-TC2-Selecting AddedLocation")
				   .LocationDoneSelection("MIL- WF 4-TC2-Selecting Done")
				   .TapOnDone("MIL- WF 4-TC2-Tapped Done")
				   
				   .TapOnBack("MIL- WF 4-TC2-Tapped Back")
				   .TapOnBack("MIL- WF 4-TC2-Tapped Back")
				   
				   .SelectLocation(locationsData.LocationName, "MIL- WF 4-TC2-Selecting AddedLocation")
				   ._atSetupInventoryPage()
				   .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"MIL- WF 4-TC2-Verify item selected")
				   
				   ._atLocationsPage() 
				   .TapOnBack("MIL- WF 4-TC2-Tapped Back")
				   .SelectLocation(locationsData1.LocationName, "MIL- WF 4-TC2-Selecting AddedLocation")
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
		     .Third_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		 		 
		     ._atInventoryToolPage()
			      .InvTools_SetUpInventory("SI - WF 19-TC1-SetupInventoryTap")
			 
		     ._atSetupInventoryPage()
				 .TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				.StartFromScratch("MIL-WF6-TC2-ScratchSelected")
			 .tapContinue("MIL-WF6-TC2-Tapped Continue")
				 .Scratch_AddItems("MIL-WF6-TC2-Tapped Add items")
				 .AddItemFrom_OrderGuide("MIL-WF6-TC2-Tapped Order Guide")
				 .SelectItemFrom_OrderGuide("MIL-WF6-TC2-Selected item from OG")
				 .TapOnDone("MIL-WF6-TC2-Tapped Done")
				.verifyOGItemsOnSetupInv("MIL-WF6-TC2-Verify item selected")
				.TapOnDone("MIL-WF6-TC2-Tapped Done")
				.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
			
				._atSetupInventoryPage()
			.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
				.TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				.TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
			
				._atCategoryPage()
				.tapContinue("MIL-WF6-TC2-Tapped Continue")
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
	
							//Precond:setupinventory should be done so that trackinv is enabled
							@Test(groups={"MEC - WF 2"},priority=0, description = "MEC - WF 2-TC1-Creating, editing and deleting category as a MA user")
							public void MEC_WF2_Category_Create_Edit_Delete_Category_MA() {	
								
								LoginData loginData =LoginData.fetch("LoginData2");
								CategoryData categoryData =CategoryData.fetch("CategoryData");
								Start.asTester
									.goToLoginpage()
									.verifyLoginPage("MIL-WF 2-TC2-LoginPage")
									.signIn(loginData.UserName, loginData.Password,"MEC-WF 2-TC1-Login")
							
																
											._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		 	
				
							 //setting up inventory    
				     ._atInventoryToolPage()
				      .InvTools_SetUpInventory("MEC-WF 2-TC1-SetupInventoryTap")
				      
				       ._atSetupInventoryPage()
				       .TapOnSkip("MEC-WF 2-TC1-Tapped Skip")
				     .StartFromScratch("MEC-WF 2-TC1-ScratchSelected")
				     .tapContinue("MEC-WF 2-TC1-Tapped Continue")
				     .Scratch_AddItems("MEC-WF 2-TC1-Tapped Add items")
				     .AddItemFrom_OrderGuide("MEC-WF 2-TC1-Tapped Order Guide")
				     .SelectItemFrom_OrderGuide("MEC-WF 2-TC1-Selected item from OG")
				     .TapOnDone("MEC-WF 2-TC1-Tapped Done")
				     .verifyOGItemsOnSetupInv("MEC-WF 2-TC1-Verify item selected")
				       .TapOnDone("MEC-WF 2-TC1-Tapped Done")
				       .TapOnSkip("MEC-WF 2-TC1-Tapped Skip")
				           
				        ._atSetupInventoryPage()
				        .TapOnDOThisLater("MEC-WF 2-TC1-Tapped do this later")
				        .TapOnSkip("MEC-WF 2-TC1-Tapped Skip")
				        .TapOnDOThisLater("MEC-WF 2-TC1-Tapped do this later")
				        
				        ._atCategoryPage()
				        .tapContinue("MEC-WF 2-TC1-Tapped Continue")
				           	
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
							
							
							
						
	//Precond:setupinventory should be done so that trackinv is enabled , location with items
							@Test(groups={"MIL - WF 6"},priority=0, description = "MIL - WF 6-TC2-Selecting a specific location in trackinventory and search for items within location for MA user")
							public void MIL_WF6_Location_SearchItems_MA() {	
								
								LoginData loginData =LoginData.fetch("LoginData2");
								LocationsData locationsData =LocationsData.fetch("LocatiosData3");
								LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
								NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
								PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
								VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
								SearchData searchData=SearchData.fetch("SearchData");
								Start.asTester
									.goToLoginpage()
									.verifyLoginPage("SI - WF 1-TC2-TC2-LoginPage")
									.signIn(loginData.UserName, loginData.Password,"MIL-WF6-TC2-Login")
																			
											._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		 	
				 //setting up inventory    
				     ._atInventoryToolPage()
				      .InvTools_SetUpInventory("MIL-WF6-TC2-SetupInventoryTap")
				      
				       ._atSetupInventoryPage()
				       .TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				     .StartFromScratch("MIL-WF6-TC2-ScratchSelected")
				     .tapContinue("MIL-WF6-TC2-Tapped Continue")
				     .Scratch_AddItems("MIL-WF6-TC2-Tapped Add items")
				     .AddItemFrom_OrderGuide("MIL-WF6-TC2-Tapped Order Guide")
				     .SelectItemFrom_OrderGuide("MIL-WF6-TC2-Selected item from OG")
				     .TapOnDone("MIL-WF6-TC2-Tapped Done")
				     .verifyOGItemsOnSetupInv("MIL-WF6-TC2-Verify item selected")
				       .TapOnDone("MIL-WF6-TC2-Tapped Done")
				       .TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				           
				        ._atSetupInventoryPage()
				        .TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
				        .TapOnSkip("MIL-WF6-TC2-Tapped Skip")
				        .TapOnDOThisLater("MIL-WF6-TC2-Tapped do this later")
				        
				        ._atCategoryPage()
				        .tapContinue("MIL-WF6-TC2-Tapped Continue")
				           
				            
									 ._atInventoryToolPage()
									 .InvTools_TrackInventory("MIL-WF6-TC2-TrackinventoryTap")
								    
								       
								     ._atLocationsPage()
								   .TapAddLocation("MIL-WF6-TC2-Tapped ADD")
							        .AddLocationName(locationsData.LocationName,"MIL-WF 6-TC2-Enter location name")
								     .AddLocationCooler("MIL-WF6-TC2-Tapped Cooler")
								    .TapOnDone("MIL-WF6-TC2-Tapped Done")
								     .TapOnBack("MIL-WF6-TC2-Tapped Back")
								     .VerifyLocationList(locationsData.LocationName, "MIL-WF6-TC2-Verifing AddedLocation")
								     .SelectLocation(locationsData.LocationName, "MIL-WF6-TC2-Selecting location")
								     
							     //og item addition
							     ._atLocationsPage()
						 	     .TapAddLocation("MIL-WF6-TC2-Tapped ADD")
						 	    
						 	     .AddItemFrom_OrderGuide("MIL-WF6-TC2-Tapped Orderguide")
						 	    ._atSetupInventoryPage()
						 	    .SelectMultipleItemsFrom_OrderGuide("MIL-WF6-TC2-Selected multiple items from OG")
							     .TapOnDone("MIL-WF6-TC2-Tapped Done")
							     .verifyMultipleItemsfromOGonSetUpInv("MIL-WF6-TC2-Verify items selected")  
							       .TapOnDone("MIL-WF6-TC2-Tapped Done")
							       .verifyMultipleItemsfromOGonSetUpInv("MIL-WF6-TC2-Verify item selected")  
							       .SearchKeyword("MIL-WF6-TC2-Keyword searching")
							       .TapOnDone("MIL-WF6-TC2-Done tap")
							       .verifyKeywordSearchItems("MIL-WF6-TC2-Verify Keyword search")
					     
									;
							}
	
	
						
							@Test(groups={"TestRun"},priority=0, description = "SI - WF 6-TC1-OG + Skip Loc + Skip Cust for Normal user")
							public void SI_WF6_OG_SkipLocation_SkipCategory_MA() {	
								
								LoginData loginData =LoginData.fetch("LoginData2");
								Start.asTester
								.goToLoginpage()
									.verifyLoginPage("SI - WF 6-TC1-LoginPage")
								.signIn(loginData.UserName, loginData.Password,"SI - WF 3-TC1-LoginPage")
								
																			
											._atHomePage()
			.ClickAccount(loginData.UserName,"Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"SI - WF 10-TC1-FirstAccountSelect")
		 			
									._atInventoryToolPage()
									      .InvTools_SetUpInventory("SI - WF 6-TC1-SetupInventoryTap")
									      
									       ._atSetupInventoryPage()
									       .TapOnSkip("SI - WF 6-TC1-Skip1 Tapped")
									       .TapOrderGuide("SI - WF 6-TC1-OG Selected")
									      .tapContinue("SI - WF 6-TC1-Tapped Continue1")
									      .TapOnSkip("SI - WF 6-TC1-Skip2 Tapped")
									      .TapOnDOThisLater("SI - WF 6-TC1-Do this Later for locations Tapped")
									      .TapOnSkip("SI - WF 6-TC1-Skip3 Tapped")
									      .TapOnDOThisLater("Do this Later for category Tapped")
									      .tapContinue("SI - WF 6-TC1-Cotinue2 Tapped") 
									      ._atInventoryToolPage()
								           .InvTools_TrackInventory("SI - WF 6-TC1-Selected track inventory")
						         
										;
								}
							
						
							@Test(groups={"SI - WF 8"},priority=4, description = "SI - WF 8-TC1-OG + Skip Loc + Default Category for Normal user")
							public void SI_WF8_OG_DefaultLocation_DefaultCategory_MA() {
							LoginData loginData =LoginData.fetch("LoginData2");
							LocationsData locationsData =LocationsData.fetch("LocatiosData4");
							Start.asTester
							.goToLoginpage()
								.verifyLoginPage("SI - WF 6-TC1-LoginPage")
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
							      .TapOnSkip("SI - WF 8-TC1-Skip2 Tapped")
							      .TapOnDOThisLater("SI - WF 8-TC1-Do this Later for locations Tapped")
							       .TapOnSkip("SI - WF 8-TC1-Skip3 Tapped") 

							      ._atCategoryPage()
							      .defaultCategories("SI - WF 8-TC1-Tapped Default category")
							      .tapComplete("SI - WF 8-TC1-Tapped Complete")
							           
							       ._atSetupInventoryPage()
							      .tapContinue("SI - WF 8-TC1-Tapped Continue3")   
							      
							  ._atInventoryToolPage()
							  .InvTools_TrackInventory("SI - WF 8-TC1-Selected track inventory")
							 
							      ._atLocationsPage()
//							        .SelectLocation(locationsData.LocationName, "SI - WF 8-TC1-select added location")
							          //  .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
//							             .TapOnDone("SI - WF 1-TC1-Tapped Done")
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
							@Test(groups={"TI-WF1-WF2"},priority=2, description = "TI-WF1-WF2-TC1-Select a location from trackinventory updating quantity and uom")
							public void TI_WF1_WF2_Location_Item_UOMQuantity_NU() {	
								
								LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003
							//	LoginData loginData =LoginData.fetch("LoginData1");	
								LocationsData locationsData1 =LocationsData.fetch("LocationsData");
								UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
								UOMQuantityData uomQuantityData1=UOMQuantityData.fetch("UOMQuantityData1");
								
							
								Start.asTester
								.goToLoginpage()
									.verifyLoginPage("TI-WF1-WF2-TC1-LoginPage")
								.signIn(loginData.UserName, loginData.Password,"TI-WF1-WF2-TC1-LoginPage")
						
								._atHomePage()
							.ClickAccount(loginData.UserName,"TI-WF1-WF2-TC1-Clicked account")
							
							._atAccountsPage()
						     .Third_AccountSelection(loginData.UserName,"TI-WF1-WF2-TC1-ThirdAccountSelect")
						  
						     ._atInventoryToolPage()
					      .InvTools_SetUpInventory("TI-WF1-WF2-TC1-SetupInventoryTap")
					        ._atSetupInventoryPage()
					       .TapOnSkip("TI-WF1-WF2-TC1-Skip1 Tapped")
					       .TapOrderGuide("TI-WF1-WF2-TC1-OG Selected")
					      .tapContinue("TI-WF1-WF2-TC1-Tapped Continue1")
					      .TapOnSkip("TI-WF1-WF2-TC1-Skip2 Tapped")
					         ._atLocationsPage()
					       .CustomLocation("TI-WF1-WF2-TC1-Tapped Custom location")
					        .tapContinue("TI-WF1-WF2-TC1-Tapped Continue2")
					        .EnterLocationName(locationsData1.LocationName,"TI-WF1-WF2-TC1-Enter location name")
					        .AddLocations1_TypeDry("TI-WF1-WF2-TC1-Tapped Dry1")
					        .TapOnNext("TI-WF1-WF2-TC1-Tapped Next1")
					        .selectMultipleItemsFromLocation1("TI-WF1-WF2-TC1-Selected Multiple items")
					        .TapOnDone("TI-WF1-WF2-TC1-Tapped Done1")
					        ._atSetupInventoryPage()
						       .TapOnSkip("TI-WF1-WF2-TC1-Skip3 Tapped")
						       ._atSetupInventoryPage()
								.TapOnDOThisLater("TI-WF1-WF2-TC1-Tapped do this later")
						   ._atSetupInventoryPage()
					       .tapContinue("TI-WF1-WF2-TC1-Tapped Continue4") 
					           
		
											 ._atInventoryToolPage()
												    .InvTools_TrackInventory("TI-WF1-WF2-TC1-Tapped trackINventory")
												     ._atLocationsPage()
												     .SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-TC1-Selected location for entering")
									         .ProductQtyEnter(uomQuantityData.Quantity,"TI-WF1-WF2-TC1-Entering Quantity1")
									         .UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-TC1-Entering Uom unit OZ")
									         .TapOnDone("TI-WF1-WF2-TC1-Tapped done")
									         .TapOnBack("TI-WF1-WF2-TC1-Tapped Back")
									         .SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-TC1-Selected location for verifying")
									         .QuantityVerify(uomQuantityData.Quantity, "TI-WF1-WF2-TC1-Verifying Quantity1")
									         
									         .TapOnBack("TI-WF1-WF2-TC1-Tapped Back")
									       
									         ._atLocationsPage()
										     .SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-TC1-Selected location for updating")
							         .ProductQtyEnter(uomQuantityData1.Quantity,"TI-WF1-WF2-TC1-Entering Quantity2")
							         .UomEnterOZ(uomQuantityData.UOM, "TI-WF1-WF2-TC1-Entering Uom unit OZ")
							         .TapOnDone("TI-WF1-WF2-TC1-Tapped done")
							         .TapOnBack("TI-WF1-WF2-TC1-Tapped Back")
							         .SelectLocation(locationsData1.LocationName,"TI-WF1-WF2-TC1-Selected location for update verify")
							         .QuantityVerify(uomQuantityData1.Quantity,"TI-WF1-WF2-TC1-Verifying Quantity2")
							               
									;
									
							}
							
							@Test(groups={"SI - WF 5"},priority=4, description = "SI - WF 8-TC1-OG + Custom Loc + Default Category for Normal user")
							public void SI_WF5_OG_CustomLocation_DefaultCategory_NU() {
							LoginData loginData =LoginData.fetch("LoginDatNor");
							LocationsData locationsData1 =LocationsData.fetch("LocationsData");
							LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
							Start.asTester
							.goToLoginpage()
								.verifyLoginPage("SI - WF 5-TC1-LoginPage")
							.signIn(loginData.UserName, loginData.Password,"SI - WF 5-TC1-LoginPage")

							._atInventoryToolPage()
						    .InvTools_SetUpInventory("SI - WF 3-TC1-SetupInventoryTap")
						    
						     ._atSetupInventoryPage()
						     .TapOnSkip("SI - WF 5-TC1-Skip1 Tapped")
						     .TapOrderGuide("SI - WF 5-TC1-OG Selected")
						    .tapContinue("SI - WF 5-TC1-Tapped Continue1")
						    .TapOnSkip("SI - WF 5-TC1-Skip2 Tapped")
						    
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
						      ._atSetupInventoryPage()
							       .TapOnSkip("SI - WF 1-TC2-Skip3 Tapped")
							      ._atCategoryPage()
							      .defaultCategories("SI - WF 5-TC1-Tapped Default category")
							      .tapComplete("SI - WF 5-TC1-Tapped Complete")
							           
							       ._atSetupInventoryPage()
							      .tapContinue("SI - WF 5-TC1-Tapped Continue3")   
							      
							  ._atInventoryToolPage()
							  .InvTools_TrackInventory("SI - WF 5-TC1-Selected track inventory")
							 
							      ._atLocationsPage()
//							        .SelectLocation(locationsData.LocationName, "SI - WF 8-TC1-select added location")
							          //  .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
//							             .TapOnDone("SI - WF 1-TC1-Tapped Done")
							;
							}
							
							
							@Test(groups={"SI - WF 4"},priority=4, description = "SI - WF 4-TC1-OG + Default Loc + Custom Category for MA user")
							public void SI_WF4_OG_DefaultLocation_CustomCategory_MA() {
							LoginData loginData =LoginData.fetch("MAusrLgn");
							CategoryData categoryData=CategoryData.fetch("CategoryData");
							Start.asTester
							.goToLoginpage()
								.verifyLoginPage("SI - WF 4-TC1-LoginPage")
								.saveUsernameCheckBoxClick("SI - WF 4-TC1-Save Username")
							.signIn(loginData.UserName, loginData.Password,"SI - WF 4-TC1-LoginPage")
							
							._atHomePage()
							.HamburgerMenu("SI - WF 4-TC1-HamburgerTap")
							._atAccountsPage()
							.HamMenu_Accounts("SI - WF 4-TC1-AccountsTap")
							.AccountSwitchSecondID("SI - WF 4-TC1-Accounts1st ID")
							._atInventoryToolPage()
							      .InvTools_SetUpInventory("SI - WF 4-TC1-SetupInventoryTap")

							      ._atSetupInventoryPage()
							       .TapOnSkip("SI - WF 4-TC1-Skip1 Tapped")
							      .TapOrderGuide("SI - WF 4-TC1-OG Selected")
							      .tapContinue("SI - WF 4-TC1-Tapped Continue")
							       .TapOnSkip("SI - WF 4-TC1-Skip2 Tapped")

							   
							    ._atLocationsPage()
							      .DefaultLocation("SI - WF 4-TC1-Tapped Custom location")
							        .tapContinue("SI - WF 4-TC1-Tapped Continue")
							       
							          ._atSetupInventoryPage() 
							       .TapOnSkip("SI - WF 4-TC1-Skip3 Tapped") 

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
						       .tapContinue("SI - WF 4-TC1-Tapped Continue4") 
							      
							  ._atInventoryToolPage()
							  .InvTools_TrackInventory("SI - WF 4-TC1-Selected track inventory")
							 
							      ._atLocationsPage()
//							        .SelectLocation(locationsData.LocationName, "SI - WF 8-TC1-select added location")
							          //  .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
//							             .TapOnDone("SI - WF 1-TC1-Tapped Done")
							;
							}
		
}
