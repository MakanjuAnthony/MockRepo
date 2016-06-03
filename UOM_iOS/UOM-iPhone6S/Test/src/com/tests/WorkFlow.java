
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

	

			//Precond:setupinventory should be done so that trackinv is enabled,location with at least one product
				@Test(groups={"MIL - WF 6 MA"},priority=0, description = "MIL - WF 6-TC2-Creating Location,Editing Location in Manage Locations and assiging  item  to diff location")
				public void MIL_WF6_Create_Edit_Delete_Locations_MA() {	
					
					LoginData loginData =LoginData.fetch("LoginData2");
					LocationsData locationsData =LocationsData.fetch("LocatiosData3");
					LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
					NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
					PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
					VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
					Start.asTester
						.goToLoginpage()
					//	.verifyLoginPage("SI - WF 8-TC2-TC1-LoginPage")
						.signIn(loginData.UserName, loginData.Password,"MIL - WF 6-TC2-Login")
					
				._atHomePage()
			.ClickAccount(loginData.UserName,"MIL - WF 6-TC2-Clicked account")
			
			._atAccountsPage()
		     .Fourth_AccountSelection(loginData.UserName,"MIL - WF 6-TC2-FirstAccountSelect")
		 		
		     ._atInventoryToolPage()
			      .InvTools_SetUpInventory("MIL - WF 6-TC2-SetupInventoryTap")
			 
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
						 .InvTools_Locations("MIL- WF 6-TC2-Locations Tap")
						  
					     ._atLocationsPage()
					    .TapAddLocation("MIL- WF 6-TC2-Tapped ADD")
				         .AddLocationName(locationsData.LocationName,"MIL- WF 6-TC2-Enter location name")
					     .AddLocationCooler("MIL- WF 5-TC2-Tapped Cooler")
					     .TapOnDone("MIL- WF 6-TC2-Tapped Done")
					     .TapOnBack("MIL- WF 6-TC2-Tapped Back")
					     .VerifyLocationList(locationsData.LocationName, "MIL- WF 6-TC2-Verifing AddedLocation")
					     
					     .TapAddLocation("MIL- WF 6-TC2-Tapped ADD")
				         .AddLocationName(locationsData1.LocationName,"MIL- WF 6-TC2-Enter location name")
					     .AddLocationCooler("MIL- WF 6-TC2-Tapped Cooler")
					     .TapOnDone("MIL- WF 6-TC2-Tapped Done")
					     .TapOnBack("MIL- WF 6-TC2-Tapped Back")
					     .VerifyLocationList(locationsData1.LocationName, "MIL- WF 6-TC2-Verifing AddedLocation")
					     
					     .SelectLocation(locationsData.LocationName, "MIL- WF 6-TC2-Selecting AddedLocation")
					     .TapOnEdit("MIL- WF 6-TC2-Editing AddedLocation")
					     .AddLocationName(locationsData.EditLocation,"MIL- WF 6-TC2-Enter location name")
					     .AddLocationCooler("MIL- WF 6-TC2-Tapped Cooler")
					     .TapOnDone("MIL- WF 6-TC2-Tapped Done")
					     .TapOnBack("MIL- WF 6-TC2-Tapped Back")
					     .VerifyLocationList(locationsData.EditLocation, "MIL- WF 6-TC2-Verifing AddedLocation")
					     
					     .SelectLocation(locationsData.EditLocation, "MIL- WF 6-TC2-Selecting AddedLocation")
					     .TapOnDeleteLocation("MIL- WF 6-TC2-Tapped Delete")
					     .TapOnYesDelete("MIL- WF 6-TC2-Deleting AddedLocation")
					   //  .TapOnBack("MIL- WF 5-TC2-Tapped Back")
					     .VerifyCancelledLocationList(locationsData.EditLocation, "MIL- WF 6-TC2-Verifing AddedLocation")
					     
					     
					  
						;
				}

				
				
							//Precond:setupinventory should be done so that trackinv is enabled
							@Test(groups={"MEC - WF 2"},priority=0, description = "MEC - WF 2-TC1-Creating, editing and deleting category as a MA user")
							public void MEC_WF2_Category_Create_Edit_Delete_Category_MA() {	
								
								LoginData loginData =LoginData.fetch("LoginData2");
								CategoryData categoryData =CategoryData.fetch("CategoryData");
								Start.asTester
									.goToLoginpage()
									.verifyLoginPage("MEC-WF 2-TC1-LoginPage")
									.signIn(loginData.UserName, loginData.Password,"MEC-WF 2-TC1-Login")
							
																
											._atHomePage()
			.ClickAccount(loginData.UserName,"MEC-WF 2-TC1-Clicked account")
			
			._atAccountsPage()
		     .First_AccountSelection(loginData.UserName,"MEC-WF 2-TC1-FirstAccountSelect")
		 	
				
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
							
							
							
	
							
							@Test(groups={"SI - WF 15"},priority=0, description = "SI - WF 15-TC1-Start from scratch+ Multiple lists +Custom location + Default category")
							public void SI_WF15_StartFromScratch_MultipleList_CustomLocation_DefaultCategory_NU() {	
								
								LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003
							//	LoginData loginData =LoginData.fetch("LoginData1");       //MA sa001
								LocationsData locationsData =LocationsData.fetch("LocatiosData3");
								LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
							//	CategoryData categoryData=CategoryData.fetch("CategoryData");
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
						   .VendorSelect(vendorDetailsData.VendorName,"SI- WF 15-TC1-VendorSelect")
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
								    // .verifySearchItemsOnSetupInv("SI- WF 15-TC1-Verify catalog item selected")
								       
								       .Setup_AddItemsLink("SI- WF 15-TC1-Add items Selected")
								       .AddItemFrom_OrderGuide("SI- WF 15-TC1-Tapped Order Guide")
								     .SelectItemFrom_OrderGuide("SI- WF 15-TC1-Selected item from OG")
								     .TapOnDone("SI- WF 15-TC1-Tapped Done5")
								    // .verifyOGItemsOnSetupInv("SI- WF 15-TC1-Verify OG item selected")	 
								   
								     
								     //verifications
								   	.verifySearchItemsOnSetupInv("SI- WF 15-TC1-Verify catalog item selected")
									 .verifyOGItemsOnSetupInv("SI- WF 15-TC1-Verify OG item selected")
									  
									    .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 15-TC1-Verify prep item selected")
									    .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 15-TC1-Verify nonsysco item selected")
							
								     
								   	.TapOnDone("SI- WF 15-TC1-Tapped Done6")
						 	        .TapOnSkip("SI- WF 15-TC1-Tapped Skip2")
								   
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
							        
							        ._atSetupInventoryPage()
								     .TapOnSkip("SI- WF 15-TC1-Skip3 Tapped")
								     
								           ._atCategoryPage()
								           .defaultCategories("SI- WF 15-TC1-Tapped Custom category")
								           .tapComplete("SI- WF 15-TC1-Tapped Complete")
								            .tapContinue("SI- WF 15-TC1-Tapped Continue3")
								           
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
		
						
							@Test(groups={"SI - WF 13"},priority=0, description = "SI - WF 13-TC1-Start from scratch+ Multiple lists +Custom location + Custom category")
							public void SI_WF13_StartFromScratch_MultipleList_CustomLocation_CustomCategory_MA() {	
								
							//	LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003
								LoginData loginData =LoginData.fetch("LoginData1");       //MA sa001
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
						   .VendorSelect(vendorDetailsData.VendorName,"SI- WF 13-TC1-VendorSelect")
						 	.TapOnDone("SI- WF 13-TC1-Tapped Done2")
						 	
						 	//prepitem
						 	._atSetupInventoryPage()
							.Setup_AddItemsLink("SI- WF 13-TC1-Add items Selected")
							 .AddItemFrom_PrepItem("SI- WF 13-TC1-Tapped Prep")
								     .EnterItemDetails(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "SI- WF 13-TC1-PrepItemAddPage")
								   	.TapOnDone("SI- WF 13-TC1-Tapped Done3")
								 
								    .Setup_AddItemsLink("SI- WF 13-TC1-Add items Selected")
								     .SearchItem(searchData.keyword,"SI- WF 13-TC1-Search item")
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
						 	        .TapOnSkip("SI- WF 13-TC1-Tapped Skip2")
								   
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
							        
							        ._atSetupInventoryPage()
								     .TapOnSkip("SI- WF 13-TC1-Skip3 Tapped")

								       ._atCategoryPage()
								       .CustomCategories("SI - WF 13-TC1-CustomCategories Tapped")
							        .tapContinue("SI - WF 13-TC1-Tapped Continue3")
							       .CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 13-TC1-CreateTwoExpenseCategory")
							       .TapOnNext("SI - WF 13-TC1-Tapped Next3")
							       .AssignMultipleItemsToCategory("SI - WF 13-TC1-Assign MultipleItems To Category1")
							       .TapOnNext("SI - WF 13-TC1-Tapped Next4")
							      
							    //   ._atLocationsPage()
							   //      .AllItemsTabClick("SI- WF 13-TC1-Tapped Next2")
							      
							   //      ._atCategoryPage()
							  //     .AssignMultipleItemsToCategory("SI - WF 13-TC1-Assign MultipleItems To Category2")
							       ._atSetupInventoryPage()
							       .TapOnDone("SI - WF 13-TC1-Tapped Done8")
							       .tapContinue("SI - WF 13-TC1-Tapped Continue4") 
								           
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
								
								LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003
							//	LoginData loginData =LoginData.fetch("LoginData1");       //MA sa001
								LocationsData locationsData =LocationsData.fetch("LocatiosData3");
								LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
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
								     .Third_AccountSelection(loginData.UserName,"SI- WF 14-TC1-ThirdAccountSelect")
								  	   
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
						   .VendorSelect(vendorDetailsData.VendorName,"SI- WF 14-TC1-VendorSelect")
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
						 	        .TapOnSkip("SI- WF 14-TC1-Tapped Skip2")
								   
						 	        // location setup
								    ._atLocationsPage()
		                     .DefaultLocation("SI - WF 14-TC1-Tapped Custom location")
		                        .tapContinue("SI - WF 14-TC1-Tapped Continue2")
							        
							        ._atSetupInventoryPage()
								     .TapOnSkip("SI- WF 14-TC1-Skip3 Tapped")

								       ._atCategoryPage()
								       .CustomCategories("SI - WF 14-TC1-CustomCategories Tapped")
							        .tapContinue("SI - WF 14-TC1-Tapped Continue3")
							       .CreateTwoExpenseCategory(categoryData.Name, categoryData.Name1, "SI - WF 14-TC1-CreateTwoExpenseCategory")
							       .TapOnNext("SI - WF 14-TC1-Tapped Next3")
							       .AssignMultipleItemsToCategory("SI - WF 14-TC1-Assign MultipleItems To Category1")
							       .TapOnNext("SI - WF 14-TC1-Tapped Next4")
							      
							     //  ._atLocationsPage()
							    //     .AllItemsTabClick("SI- WF 14-TC1-Tapped Next2")
							      
							     //    ._atCategoryPage()
							    //   .AssignMultipleItemsToCategory("SI - WF 14-TC1-Assign MultipleItems To Category2")
							       ._atSetupInventoryPage()
							       .TapOnDone("SI - WF 14-TC1-Tapped Done7")
							       .tapContinue("SI - WF 14-TC1-Tapped Continue4") 
								           
								           ._atInventoryToolPage()
								           .InvTools_TrackInventory("SI- WF 14-TC1-Selected track inventory")
								
								            
								        //    ._atLocationsPage()
								       //     .SelectLocation(locationsData.LocationName, "SI- WF 14-TC1-Select added location1")
								       //     .VerifyMultipleListItemsInLocation("SI- WF 14-TC1-Verifying Multiple items in Location1")
								       //     .TapOnBack("SI- WF 14-TC1-Tapped back")
								       //     .SelectLocation(locationsData1.LocationName, "SI- WF 14-TC1-Select added location2")
								       //     .VerifyMultipleListItemsInLocation("SI- WF 14-TC1-Verifying Multiple items in Location2")
								          
									;
							}
    
								@Test(groups={"SI - WF 37"},priority=0, description = "SI - WF 37-TC1-Start from scratch+ Multiple lists +Custom location +Suggested category")
								public void SI_WF37_StartFromScratch_MultipleList_CustomLocation_SuggestedCategory_NU() {	
									
								LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003
								//	LoginData loginData =LoginData.fetch("LoginData1");       //MA sa001
									LocationsData locationsData =LocationsData.fetch("LocatiosData3");
									LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
									CategoryData categoryData=CategoryData.fetch("CategoryData");
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
									     .Third_AccountSelection(loginData.UserName,"SI- WF 37-TC1-ThirdAccountSelect")
									 	   
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
							   .VendorSelect(vendorDetailsData.VendorName,"SI- WF 37-TC1-VendorSelect")
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
							 	        .TapOnSkip("SI- WF 37-TC1-Tapped Skip2")
									   
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
								        
								        ._atSetupInventoryPage()
									     .TapOnSkip("SI- WF 37-TC1-Skip3 Tapped")

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
								public void SI_WF38_StartFromScratch_MultipleList_DefaultLocation_SuggestedCategory_NU() {	
									
									LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003
								//	LoginData loginData =LoginData.fetch("LoginData1");       //MA sa001
									LocationsData locationsData =LocationsData.fetch("LocatiosData3");
									LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
									CategoryData categoryData=CategoryData.fetch("CategoryData");
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
									     .Third_AccountSelection(loginData.UserName,"SI- WF 38-TC1-ThirdAccountSelect")
									  	   
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
							   .VendorSelect(vendorDetailsData.VendorName,"SI- WF 38-TC1-VendorSelect")
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
									     .TapOnDone("SI- WF 38-TC1-Tapped Done5")
									    
									     
									     //verifications
									   	.verifySearchItemsOnSetupInv("SI- WF 38-TC1-Verify catalog item selected")
										 .verifyOGItemsOnSetupInv("SI- WF 38-TC1-Verify OG item selected")
										  
										    .verifyNonSyscoPrepItemSetupInv(prepItemData.ProductName,"SI- WF 38-TC1-Verify prep item selected")
										    .verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"SI- WF 38-TC1-Verify nonsysco item selected")
								
									     
									   	.TapOnDone("SI- WF 38-TC1-Tapped Done6")
							 	        .TapOnSkip("SI- WF 38-TC1-Tapped Skip2")
									   
							 	        // location setup
									    ._atLocationsPage()
			                          .DefaultLocation("SI - WF 38-TC1-Tapped Custom location")
			                          .tapContinue("SI - WF 38-TC1-Tapped Continue2")
								        
								        ._atSetupInventoryPage()
									     .TapOnSkip("SI- WF 38-TC1-Skip3 Tapped")

									     ._atCategoryPage()
									       .SuggestedCategories("SI - WF 38-TC1-SuggestedCategories Tapped")
								            .tapContinue("SI - WF 38-TC1-Tapped Continue3")
								       
								       ._atSetupInventoryPage()
								       .TapTakeHome("SI - WF 38-TC1-Tapped Take me Home")
								       
								         ._atInventoryToolPage()
									      .InvTools_TrackInventory("SI- WF 38-TC1-Selected track inventory")
									
									            
									        //    ._atLocationsPage()
									       //     .SelectLocation(locationsData.LocationName, "SI- WF 38-TC1-Select added location1")
									       //     .VerifyMultipleListItemsInLocation("SI- WF 38-TC1-Verifying Multiple items in Location1")
									       //     .TapOnBack("SI- WF 38-TC1-Tapped back")
									        
										;
											
	}
								
								
								@Test(groups={"SI - WF 33"},priority=0, description = "SI - WF 33-TC1-OG + Default Loc + Suggested Category")
								public void SI_WF33_OG_DefaultLocation_SuggestedCategory_NU() {	
									
	              				LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003

								//	LoginData loginData =LoginData.fetch("LoginData1"); //ma sa001
									LocationsData locationsData1 =LocationsData.fetch("LocationsData");
									LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
									CategoryData categoryData=CategoryData.fetch("CategoryData");
									Start.asTester
										.goToLoginpage()
											.verifyLoginPage("SI - WF 33-TC1-LoginPage")
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
								       .TapOnSkip("SI - WF 33-TC1-Skip2 Tapped")

								   
								    ._atLocationsPage()
								      .DefaultLocation("SI - WF 33-TC1-Tapped Custom location")
								        .tapContinue("SI - WF 33-TC1-Tapped Continue")
								       
								          ._atSetupInventoryPage() 
								       .TapOnSkip("SI - WF 33-TC1-Skip3 Tapped") 
								       
								       ._atCategoryPage()
								       .SuggestedCategories("SI - WF 33-TC1-SuggestedCategories Tapped")
							            .tapContinue("SI - WF 33-TC1-Tapped Continue3")
							       
							       ._atSetupInventoryPage()
							       .TapTakeHome("SI - WF 33-TC1-Tapped Take me Home")
							       
							         ._atInventoryToolPage()
								      .InvTools_TrackInventory("SI- WF 33-TC1-Selected track inventory")
								

								;
							
							

								}
    
    
								@Test(groups={"MPI-1"},priority=0, description = "MPI-1-TC1-Manage_Create Prep Item_LinkLocation_Expense Category")
								public void MPI_1_CreatePrepItem_LinkLocation_Category_NU() {	
									
									LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003

										//LoginData loginData =LoginData.fetch("LoginData1"); //ma sa001
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
									     .Third_AccountSelection(loginData.UserName,"MPI-1-TC1-FirstAccountSelect")

									     ._atInventoryToolPage()
									      .InvTools_SetUpInventory("MPI-1-TC1-SetupInventoryTap")
									      
									      ._atSetupInventoryPage()
											 .TapOnSkip("MPI-1-TC1-Tapped Skip1")
											.StartFromScratch("MPI-1-TC1-ScratchSelected")
										 .tapContinue("MPI-1-TC1-Tapped Continue1")
											 .Scratch_AddItems("MPI-1-TC1-Tapped Add items")
											 .AddItemFrom_OrderGuide("MPI-1-TC1-Tapped Order Guide")
											 .SelectItemFrom_OrderGuide("MPI-1-TC1-Selected item from OG")
											 .TapOnDone("MPI-1-TC1-Tapped Done1")
											.verifyOGItemsOnSetupInv("MPI-1-TC1-Verify item selected")
											.TapOnDone("MPI-1-TC1-Tapped Done2")
											.TapOnSkip("MPI-1-TC1-Tapped Skip2")
										
											._atSetupInventoryPage()
										.TapOnDOThisLater("MPI-1-TC1-Tapped do this later1")
											.TapOnSkip("MPI-1-TC1-Tapped Skip3")
											.TapOnDOThisLater("MPI-1-TC1-Tapped do this later2")
										
											 ._atSetupInventoryPage()
										       .TapTakeHome("MPI-1-TC1-Tapped Take me Home")
										       
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

								
								
								@Test(groups={"SI - WF 34"},priority=0, description = "SI - WF 34-TC1-OG + Custom Loc + Suggested Category")
								public void SI_WF34_OG_CustomLocation_SuggestedCategory_MA() {	
									
	              			//	LoginData loginData =LoginData.fetch("LoginData4");	  //NU sc003

									LoginData loginData =LoginData.fetch("LoginData1"); //ma sa001
									LocationsData locationsData1 =LocationsData.fetch("LocationsData");
									LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
									CategoryData categoryData=CategoryData.fetch("CategoryData");
									Start.asTester
										.goToLoginpage()
											.verifyLoginPage("SI - WF 34-TC1-LoginPage")
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
								       .TapOnSkip("SI - WF 34-TC1-Skip2 Tapped")

								   
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
								       
								          ._atSetupInventoryPage() 
								       .TapOnSkip("SI - WF 34-TC1-Skip3 Tapped") 
								       
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

