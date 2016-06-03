
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
							 
							     /* ._atLocationsPage()
							        .SelectLocation(locationsData.LocationName, "SI - WF 8-TC1-select added location")
							            .ItemVerifyOnLocation(locationsData.LocationName, "SI - WF 1-TC1-Verify item inside location")
							             .TapOnDone("SI - WF 1-TC1-Tapped Done")*/
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
    
								@Test(groups={"SI - WF 29 NU"},priority=0, description = "SI - WF 29-TC1-Custom List + Select single  List +Custom categories as location+Default Cat")
								public void SI_WF29_CustomListSingleList_CustomCategoryOnLocationsPage_defaultcategory_NU() {	
									
									LoginData loginData =LoginData.fetch("LoginData3");
									ListData listData=ListData.fetch("ListData");
									LocationsData locationsData =LocationsData.fetch("LocatiosData4");
									LocationsData locationsData1 =LocationsData.fetch("LocationsData");
									LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
									
									Start.asTester
										.goToLoginpage()
											.verifyLoginPage("SI - WF 29-TC1-LoginPage")
										.signIn(loginData.UserName, loginData.Password,"SI - WF 29-TC1-LoginPage")
										
										._atHomePage()
										.ClickAccount(loginData.UserName,"SI - WF 29-TC1 Clicked account")
										
										._atAccountsPage()
									     .Fifth_AccountSelection(loginData.UserName,"SI - WF 29-TC1-FirstAccountSelect")
									  
										._atInventoryToolPage()
										      .InvTools_SetUpInventory("SI - WF 29-TC1-SetupInventoryTap")
										     
										       ._atSetupInventoryPage()
										       .ReadytoStart("SI - WF 29-TC1-Ready to start")
										       .ReadytoStart("SI - WF 29-TC1-Ready to start")
										       
										       ._atListPage()
										       .TapCustomList("SI - WF 29-TC1-custom list Selected")
										         .tapContinue("SI - WF 29-TC1-Tapped Continue1")
										           .SelectListwithItems(listData.ListName, "SI - WF 29-TC1-select list")
										           .TapOnNext("SI - WF 29-TC1-tapped next")
										           
										          
										          ._atSetupInventoryPage()
										      .TapOnSkip("SI - WF 29-TC1-Skip1 Tapped")
										      
										      ._atLocationsPage()
										      .CustomCategories("SI - WF 29-TC1-Tapped Default category in Location Page")
										      .tapContinue("SI - WF 29-TC1-Tapped Continue2")
										      ._atSetupInventoryPage()
										       .TapOnSkip("SI - WF 29-TC2-Skip3 Tapped")
										       ._atCategoryPage()
											      .defaultCategories("SI - WF 29-TC1-Tapped Default category")
											      .tapComplete("SI - WF 29-TC1-Tapped Complete")
											      ._atSetupInventoryPage()
											      .TapTakeHome("SI - WF 29-TC1-Tapped Continue3")   
											    ._atInventoryToolPage()
												  .InvTools_TrackInventory("SI - WF 29-TC1-Selected track inventory")
										      
										     
												;
												}
								
								
								
								
								
								
								@Test(groups={"SI - WF 30 NU"},priority=0, description = "SI - WF 30-TC1-Custom List + Select single  List +Custom Categories as location+Custom Cat")
								public void SI_WF30_CustomListSingleList_CustomCategoryOnLocationsPage_customcategory_NU() {	
									
									LoginData loginData =LoginData.fetch("LoginData3");
									ListData listData=ListData.fetch("ListData");
									LocationsData locationsData =LocationsData.fetch("LocatiosData4");
									LocationsData locationsData1 =LocationsData.fetch("LocationsData");
									LocationsData locationsData2 =LocationsData.fetch("LocatiosData1");
									CategoryData categoryData=CategoryData.fetch("CategoryData");
									Start.asTester
										.goToLoginpage()
											.verifyLoginPage("SI - WF 30-TC1-LoginPage")
										.signIn(loginData.UserName, loginData.Password,"SI - WF 30-TC1-LoginPage")
										
										._atHomePage()
										.ClickAccount(loginData.UserName,"SI - WF 30-TC1 Clicked account")
										
										._atAccountsPage()
									     .Fifth_AccountSelection(loginData.UserName,"SI - WF 30-TC1-FirstAccountSelect")
									  
										._atInventoryToolPage()
										      .InvTools_SetUpInventory("SI - WF 30-TC1-SetupInventoryTap")
										     
										       ._atSetupInventoryPage()
										       .ReadytoStart("SI - WF 30-TC1-Ready to start")
										       .ReadytoStart("SI - WF 30-TC1-Ready to start")
										       
										       ._atListPage()
										       .TapCustomList("SI - WF 30-TC1-custom list Selected")
										         .tapContinue("SI - WF 30-TC1-Tapped Continue1")
										           .SelectListwithItems(listData.ListName, "SI - WF 29-TC1-select list")
										           .TapOnNext("SI - WF 30-TC1-tapped next")
										           
										          
										          ._atSetupInventoryPage()
										      .TapOnSkip("SI - WF 30-TC1-Skip1 Tapped")
										      
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
								

}


