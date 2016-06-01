
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


public class Sprint2SampleTest extends Initiator{




//sprint2

/*
@Test(groups={"Script1"}, priority=0, description = "Sprint2-Cancel modifying vendor through Homepage-Normal User")
	public void CancelVendor_Homepage_Normaluser() {	
	
	
	LoginData loginData =LoginData.fetch("LoginDatNor");
	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData3");

	Start.asTester
		.goToLoginpage()
	  // .verifyLoginPage()
	  .signIn(loginData.UserName, loginData.Password,"Script1-Login")
	
     ._atInventoryToolPage()
     .InvTools_Suppliers("Script1-SuppliersTap")
    
     ._atVendorPage()
	     .verifySupplierPage("Script1-SuppliersPage")
    .Add_Supplier("Script1-AddSupplierTap")
	 .AddVendor_Details(vendorDetailsData.VendorName,vendorDetailsData.PhoneNum,vendorDetailsData.Address,vendorDetailsData.ContactInfo,vendorDetailsData.Email,vendorDetailsData.Note,"Script1-SuppliersDetails")
    // .CancelVendor(vendorDetailsData.VendorName)  //ipad
     .CancelVendor_iPhone(vendorDetailsData.VendorName)	
     ;
			
	}
	

@Test(groups={"Script2"},priority=1, description = "Sprint2- Add location from Homepage as a normal user")
	public void AddLocationList_NormalUser() {	
		LoginData loginData =LoginData.fetch("LoginDatNor");
		LocationsData locationsData =LocationsData.fetch("LocationsData");
		
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPage()
			.signIn(loginData.UserName, loginData.Password,"Script2-Login")
			
		  ._atInventoryToolPage()
			.InvTools_Locations("Script2-LocationsTap")
		  ._atLocationsPage()
	 // .AddLocation(locationsData.LocationName, "Script2-AddedLocation")
		// .AddLocationNormaluser(locationsData.LocationName)
		  .verifyLocationsList(locationsData.LocationName,"Script2-LocationsPage")
		  
			;
			
	}

@Test(groups={"Script3"},priority=2, description = "Sprint2 - Edit location from Location list as a normal user")
public void EditLocationList_Normaluser() {	
	LoginData loginData =LoginData.fetch("LoginDatNor");
	LocationsData locationsData =LocationsData.fetch("LocationsData");
	
	
	Start.asTester
		.goToLoginpage()
	//	.verifyLoginPage()
		.signIn(loginData.UserName, loginData.Password,"Script3-Login")
	  ._atInventoryToolPage()
		.InvTools_Locations("Script3-LocationTap")
	  ._atLocationsPage()
	  .editLocation(locationsData.EditLocation,"Script3-EditLocation")
	  .verifyLocationsList(locationsData.EditLocation,"Script3-LocationPage")
		;
		
}*/

@Test(groups={"Script4"}, priority=3, description = "Sprint2-Order Guide- skip step on Track Food cost as a normal user")
public void OrderGuideSkipStep_Normaluser() {	
	LoginData loginData =LoginData.fetch("LoginDatNor1");
	
	Start.asTester
		.goToLoginpage()
		//.verifyLoginPage()
		.signIn(loginData.UserName, loginData.Password,"Script5-Login")
			
	  ._atInventoryToolPage()
	  .InvTools_SetUpInventory("Script5-SetupInventoryTap")
		
	  ._atSetupInventoryPage()
	  .AddItemFrom_OrderGuide("Script8-OrderGuidetap")
	  ._atLocationsPage()
	  .DefaultLocation("Script8-OrderGuidetap")
	  ._atSetupInventoryPage()
	  .skipOrderGuide("Script8-FoodCostSkip")
	  
		;
		
}
//MA user
/*
	@Test(groups={"Script5"},priority=4, description = "Sprint2-Cancel modifying vendor through homepage -MA User")
public void CancelVendor_HomePage_MAuser() {	

LoginData loginData =LoginData.fetch("MAusrLgn");
VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData3");

Start.asTester
	.goToLoginpage()
   //.verifyLoginPage()
   .signIn(loginData.UserName, loginData.Password,"Script1-Login")
._atHomePage()
		 .HamMenuTap("Script1-HamburgerMenutap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script1-Accountstap")
		     .AccountSwitchFirstID("Script1-FirstAccountSelect")
 ._atInventoryToolPage()
 .InvTools_Suppliers("Script1-supplierstap")
 ._atVendorPage()
 .verifySupplierPage("Script1-suppliersPage")
.Add_Supplier("Script1-AddsupplierTap")
 .AddVendor_Details(vendorDetailsData.VendorName,vendorDetailsData.PhoneNum,vendorDetailsData.Address,vendorDetailsData.ContactInfo,vendorDetailsData.Email,vendorDetailsData.Note,"Script1-SuppliersDetail")
 .CancelVendor_iPhone(vendorDetailsData.VendorName)	
// .CancelVendor(vendorDetailsData.VendorName)  //ipad
 ;
	
	}

 @Test(groups={"Script6"},priority=5, description = "Sprint2- Add location from Homepage as a MA user")
   public void AddLocationList_MAuser() {	
	LoginData loginData =LoginData.fetch("MAusrLgn");
	LocationsData locationsData =LocationsData.fetch("LocatiosData1");
	
	
	Start.asTester
		.goToLoginpage()
		//.verifyLoginPageMAuser()
		.signIn(loginData.UserName, loginData.Password,"Script8-Login")
		._atHomePage()
		      .HamMenuTap("Script8-Hamburgertap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script8-Hamburger_accounts")
		     .AccountSwitchFirstID("Script8-Accountswitch")
	  ._atInventoryToolPage()
		.InvTools_Locations("Script8-Locationstap")
	  ._atLocationsPage()
	//  .AddLocation(locationsData.LocationName,"Script8-AddedLocation")
	   .TapAddLocation(locationsData.LocationName)
	   .verifyLocationsList(locationsData.LocationName,"Script8-LocationsPage")
	  
		;
		
}	

@Test(groups={"Script7"},priority=6, description = "Sprint2 - Edit location from Location list as a MA user")
	public void EditLocationList_MAuser() {	
		LoginData loginData =LoginData.fetch("MAusrLgn");
		LocationsData locationsData =LocationsData.fetch("LocatiosData1");
		
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPageMAuser()
			.signIn(loginData.UserName, loginData.Password,"Script7-Login")
			._atHomePage()
		      .HamMenuTap("Script7-Hamburgertap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script7-Hamburger_accounts")
		     .AccountSwitchFirstID("Script7-Accountswitch")
		  ._atInventoryToolPage()
			.InvTools_Locations("Script7-LocationsTap")
		  ._atLocationsPage()
		  .editLocation(locationsData.EditLocation,"Script7-EditLocations")
		  .verifyLocationsList(locationsData.EditLocation,"Script7-LocationsPage")
			;
			
	}

*/

@Test(groups={"Script8"},priority=7, description = "Sprint2-Order Guide- skip step on Track Food cost as a MA user ")
	public void OrderGuideSkipStep_MAuser() {	
		LoginData loginData =LoginData.fetch("MAusrLgn");
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPageMAuser()
			.signIn(loginData.UserName, loginData.Password,"Script8-Login")
			._atHomePage()
			.HamburgerMenu("Script8-Hamburgertap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script8-Accountstap")
		     .AccountSwitchFirstID("Script8-FirstAccountSelect")	
		     ._atInventoryToolPage()
			  .InvTools_SetUpInventory("Script5-SetupInventoryTap")
				
			  ._atSetupInventoryPage()
			  .AddItemFrom_OrderGuide("Script8-OrderGuidetap")
			  ._atLocationsPage()
			  .DefaultLocation("Script8-OrderGuidetap")
			  ._atSetupInventoryPage()
			  .skipOrderGuide("Script8-FoodCostSkip")
			  ;
			
	}


/*	@Test(groups={"Script9"},priority=8, description = "Sprint2-Account switch for MB user")
	public void AccountSwitchMBuser() {	
		LoginData loginData =LoginData.fetch("LoginDataMB");
		
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPageMAuser()
			.signIn(loginData.UserName, loginData.Password,"Script11-Login")
			._atInventoryToolPage()
			.verifyNoAccount()
			._atHomePage()
		     .HamMenuTap("Script11-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script11-Hamburger_accounts")
		     .AccountSwitchFirstID("Script11-FirstAcountswitch")
		     ._atHomePage()
		   .HamMenuTap("Script11-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script11-Hamburger_accounts")
		     .AccountSwitchSecondID("Script11-SecondAcountswitch")
		    
		   
			;
			
	}	
	@Test(groups={"Script10"},priority=9, description = "Sprint2-Account switch for MA user")
	public void AccountSwitchMAuser() {	
		LoginData loginData =LoginData.fetch("MAusrLgn");
		
		
		Start.asTester
		.goToLoginpage()
	//	.verifyLoginPageMAuser()
		.signIn(loginData.UserName, loginData.Password,"Script12-Login")
		._atInventoryToolPage()
		.verifyNoAccount()
		._atHomePage()
	     .HamMenuTap("Script12-HamburgerTap")
	     ._atAccountsPage()
	     .HamMenu_Accounts("Script12-Hamburger_accounts")
	     .AccountSwitchFirstID("Script12-FirstAcountswitch")
	     ._atHomePage()
	    .HamMenuTap("Script12-HamburgerTap")
	     ._atAccountsPage()
	     .HamMenu_Accounts("Script12-Hamburger_accounts")
	     .AccountSwitchSecondID("Script12-SecondAcountswitch")
	     ;
			
	}
	*/
	//sprint2_UI
	
/*@Test(groups={"Script1UI"}, description = "Sprint2-Validate add items screen on selecting Start from scratch option on Setup inventory page for normal user")
	public void ValidateAddItemsScreen_StartFromScratch_SetupInv_NormalUser() {	
		LoginData loginData =LoginData.fetch("LoginDatNor");
		
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage()
			.signIn(loginData.UserName, loginData.Password,"Script1UI-Login")
			._atInventoryToolPage()
			.InvTools_SetUpInventory("Script1UI-SetupInventoryTap")
			._atSetupInventoryPage()
			.tapStartFromScratch("Script1UI-ScratchTap")
			.verifyAddItemsScreen("Script1UI-AdditemsUI")
		
			;
			
	}
	
		@Test(groups={"Script2UI"}, description = "Sprint2-Validate elements on locations page for normal user")
	public void ValidateLocationsPage_NormalUser() {	
		LoginData loginData =LoginData.fetch("LoginDatNor");
		
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPage()
			.signIn(loginData.UserName, loginData.Password,"Script2-Login")
			._atInventoryToolPage()
			
			.InvTools_Locations("Script2-LocationTap")
			._atLocationsPage()
			.validateLocationsPage_NormalUser()
		
		   
			;
			
	}
	
@Test(groups={"Script3UI"}, description = "Sprint2-Validate elements when edits a vendor and cancels operation-normal user")
	public void ValidateUI_VendorsPage_CancellingVendor_NormalUser() {	
		LoginData loginData =LoginData.fetch("LoginData");
		
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPage()
			.signIn(loginData.UserName, loginData.Password,"Script3-Login")
			._atInventoryToolPage()
		
	     .InvTools_Suppliers("Script3-SuppliersTap")
	     ._atVendorPage()
		     .VendorsPageUI_NormalUser()
		   
			;
			
	}
	
	@Test(groups={"Script4UI"}, description = "Sprint2-Validate UI for Setup Inventory page-normal user")
	public void ValidateUI_SetupInventory_Normal() {	
		LoginData loginData =LoginData.fetch("LoginDatNor");
		
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage()
		.signIn(loginData.UserName, loginData.Password,"Script4UI-Login")
		._atInventoryToolPage()
			.InvTools_SetUpInventory("Script4UI-SetupInventorTap")
			._atSetupInventoryPage()
			.VerifyUI_SetUpInv("Script4UI-SetupInvUI")
		   
			;
			}
			

@Test(groups={"Script5UI"}, description = "Sprint2-Validate UI for Custom location page-normal user")
	public void ValidateUI_CustomLocation() {	
		LoginData loginData =LoginData.fetch("LoginDatNor");
		
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPage()
			.signIn(loginData.UserName, loginData.Password,"Script5UI-Login")
			._atInventoryToolPage()
			.InvTools_SetUpInventory("Script5UI-SetupInventoryTap")
			._atSetupInventoryPage()
			.CustomLocation("Script5UI-customLoctap")
		   ._atLocationsPage()
		   .VerifyUI_CreateLocation("Script5UI-CreateLocUI")
		   
		   
			;
			
	}
	
		@Test(groups={"Script6UI"}, description = "Sprint2-Validate UI for Track Inventory page-normal user")
	public void ValidateUI_TrackInventory() {	
		LoginData loginData =LoginData.fetch("LoginDatNor");
		
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPage()
			.signIn(loginData.UserName, loginData.Password,"Script6UI-Login")
			._atInventoryToolPage()
			.VerifyUI_TrackInventory("Script6UI-TrackInvUI")
		   
		   
			;
			
	}
	
	@Test(groups={"Script7UI"}, description = "Sprint2-Validate add items screen on selecting Start from scratch option on Setup inventory page for MA user")
	public void ValidateAddItemsScreen_StartFromScratch_SetupInv_MAuser() {	
		LoginData loginData =LoginData.fetch("MAusrLgn");
		
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPageMAuser()
			.signIn(loginData.UserName, loginData.Password,"Script7UI-Login")
			._atHomePage()
		       .HamMenuTap("Script7UI-Hamburgertap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script7UI-AccountsTap")
		     .AccountSwitchFirstID("Script7UI-FirstAccountSelect")
			._atInventoryToolPage()
			.InvTools_SetUpInventory("Script7UI-SetupInvTap")
			._atSetupInventoryPage()
			.tapStartFromScratch("Script7UI-ScratchTap")
			.verifyAddItemsScreen("Script7UI-AddItemsUI")
		
		   
			;
			
	}
	

	
	
@Test(groups={"Script8UI"}, description = "Sprint2-Validate elements on locations page for MA user")
public void ValidateLocationsPage_MAUser() {	
	LoginData loginData =LoginData.fetch("MAusrLgn");
	
	
	Start.asTester
		.goToLoginpage()
		//.verifyLoginPageMAuser()
		.signIn(loginData.UserName, loginData.Password,"Script8UI-Login")
		._atHomePage()
		      .HamMenuTap("Script8UI-Hamburgertap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script8UI-HamburgerTapAccounts")
		     .AccountSwitchFirstID("Script8UI-AccountSwitch")
		._atInventoryToolPage()
		.InvTools_Locations("Script8UI-LocationTap")
		._atLocationsPage()
		.validateLocationsPage_MAUser()
	
	   
		;
		
}

	@Test(groups={"Script9UI"}, description = "Sprint2-Validate elements when edits a vendor and cancels operation-MA user")
	public void ValidateUI_VendorsPage_CancellingVendor_MAUser() {	
		LoginData loginData =LoginData.fetch("MAusrLgn");
		
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPage()
			.signIn(loginData.UserName, loginData.Password,"Script9-Login")
			._atHomePage()
		      .HamMenuTap("Script9-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script9-LoginPage")
		     .AccountSwitchFirstID("Script9-firstAccount")
			._atInventoryToolPage()
	     .InvTools_Suppliers("Script9-suppliertap")
	     ._atVendorPage()
		     .VendorsPageUI_NormalUser();
		   
			;
			
	}

	
@Test(groups={"Script10UI"}, description = "Sprint2-Validate UI for Setup Inventory page-MA user")
	public void ValidateUI_SetupInventory_MA() {	
		LoginData loginData =LoginData.fetch("MAusrLgn");
		
		
		Start.asTester
			.goToLoginpage()
		//	.verifyLoginPageMAuser()
			.signIn(loginData.UserName, loginData.Password,"Script10UI-Login")
			._atHomePage()
		      .HamMenuTap("Script10UI-Hamburgertap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script10UI-AccountsTap")
		     .AccountSwitchFirstID("Script10UI-FirstAccountSelect")
			._atInventoryToolPage()
			.InvTools_SetUpInventory("Script10UI-SetupInventoryTap")
			._atSetupInventoryPage()
			.VerifyUI_SetUpInv("Script10UI-SetUPUI")
		   
		   
			;
			
	}
	

@Test(groups={"Script11UI"}, description = "Sprint2-Validate UI for Custom location page-MA user")
	public void ValidateUI_CustomLocation_MA() {	
		LoginData loginData =LoginData.fetch("MAusrLgn");
		
		
	Start.asTester
			.goToLoginpage()
			//.verifyLoginPageMAuser()
			.signIn(loginData.UserName, loginData.Password,"Script11UI-Login")
			._atHomePage()
		        .HamMenuTap("Script11UI-Hamburgertap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script11UI-Accountstap")
		     .AccountSwitchFirstID("Script11UI-accountswitch")
			._atInventoryToolPage()
			.InvTools_SetUpInventory("Script11UI-Setupinvtap")
			._atSetupInventoryPage()
			.CustomLocation("Script11UI-customLoctap")
		   ._atLocationsPage()
		   .VerifyUI_CreateLocation("Script11UI-CreateLocUI")
		   
			;
			
	}

		
	@Test(groups={"Script12UI"}, description = "Sprint2-Validate UI for Track Inventory page-MA user")
	public void ValidateUI_TrackInventoryMA() {	
		LoginData loginData =LoginData.fetch("MAusrLgn");
		
		
		Start.asTester
			.goToLoginpage()
			//.verifyLoginPageMAuser()
			.signIn(loginData.UserName, loginData.Password,"Script12UI-Login")
			._atHomePage()
			.HamMenuTap("Script12UI-HamburgerTap")
		      
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script12UI-Accounttsap")
		     .AccountSwitchFirstID("Script12UI-accountswitch")
			._atInventoryToolPage()
			.VerifyUI_TrackInventory("Script12UI-TrackInvUI")
		   
		   
			;
			
	}
	
	
	
	*/
	
}
