
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


public class Sprint4SampleTest extends Initiator{

	
	
	//sprint4
	
	
	@Test(groups={"Script1"},priority=0, description = "Sprint4-426.2 adding same item to diff locations")
	public void ItemLocation_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
	//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
		//VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
	//	CategoryData categoryData=CategoryData.fetch("CategoryData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData2");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData3");

		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Sprint4_Script1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Sprint4_Script1-Login")
		 
			._atInventoryToolPage()
	      .InvTools_SetUpInventory("Sprint4_Script1-SetupInventoryTap")
	    ._atSetupInventoryPage()
	    .AddItemFrom_OrderGuide("Sprint4_Script1-OrderguideTap")
	    ._atLocationsPage()
	    .CustomLocation("Sprint4_Script1-customlocation")
	    .tapContinue("")
	    ._atLocationsPage()
	    .AddLocations1_name(locationsData.LocationName)
	    .AddLocations1_TypeDry("Sprint4_Script1-Addlocation1")
	    .AddLocations2()
	    .AddLocations2_name(locationsData1.LocationName)
	    .AddLocations2_TypeDry("Sprint4_Script1-Addlocation2")
	    .tapContinue("")
	    .Itemselect1("Sprint4_Script1-itemselect1")
	    .TapOnNext("")
	    .Itemselect2("Sprint4_Script1-itemselect2")
	   .TapOnDone("Sprint4_Script1-done")
	   ._atSetupInventoryPage()
        .skipfoodcost("Sprint4_Script1-Skip food cost")
			;
	}
	
	@Test(groups={"Script2"},priority=1, description = "Sprint4-426.2 adding same item to diff locations MA user")
	public void ItemLocation_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
	//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData2");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData3");

		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Sprint4_Script2-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Sprint4_Script2-Login")
			._atHomePage()
			.HamburgerMenu("Sprint4_Script2-HamburgerTap")
		 //    .HamMenuTap_MAuser("Script2-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Sprint4_Script2-AccountsTap")
		     .AccountSwitchFirstID("Sprint4_Script2-FirstAccountSelect")
		  
		 	._atInventoryToolPage()
		      .InvTools_SetUpInventory("Sprint4_Script1-SetupInventoryTap")
		    ._atSetupInventoryPage()
		    .AddItemFrom_OrderGuide("Sprint4_Script1-OrderguideTap")
		    ._atLocationsPage()
		    .CustomLocation("Sprint4_Script1-customlocation")
		    .tapContinue("")
		    ._atLocationsPage()
		    .AddLocations1_name(locationsData.LocationName)
		    .AddLocations1_TypeDry("Sprint4_Script1-Addlocation1")
		    .AddLocations2()
		    .AddLocations2_name(locationsData1.LocationName)
		    .AddLocations2_TypeDry("Sprint4_Script1-Addlocation2")
		    .tapContinue("")
		    .Itemselect1("Sprint4_Script1-itemselect1")
		    .TapOnNext("")
		    .Itemselect2("Sprint4_Script1-itemselect2")
		   .TapOnDone("Sprint4_Script1-done")
		   ._atSetupInventoryPage()
	        .skipfoodcost("Sprint4_Script1-Skip food cost")
				;
	}
	
	
	@Test(groups={"Script3"},priority=2, description = "Sprint4-trackINventoryTwoLocationsVerify as normal user")
	public void trackINventoryTwoLocationsVerify() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
		//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			LocationsData locationsData =LocationsData.fetch("LocatiosData2");
			LocationsData locationsData1 =LocationsData.fetch("LocatiosData3");

			Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Sprint4_Script3-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Sprint4_Script3-Login")
		 ._atInventoryToolPage()
	      .InvTools_SetUpInventory("Sprint4_Script3-SetupInventoryTap")
	    ._atSetupInventoryPage()
	    .AddItemFrom_OrderGuide("Sprint4_Script3-OrderguideTap")
	    ._atLocationsPage()
	    .CustomLocation("Sprint4_Script3-customlocation")
	    ._atLocationsPage()
	    .AddLocations1_name(locationsData.LocationName)
	    .AddLocations1_TypeDry("Sprint4_Script3-Addlocation1")
	    .AddLocations2()
	    .AddLocations2_name(locationsData1.LocationName)
	    .AddLocations2_TypeDry("Sprint4_Script3-Addlocation2")
	    .tapContinue("")
	    .Itemselect1("Sprint4_Script3-itemselect1")
	    .TapOnNext("")
	    .Itemselect2("Sprint4_Script3-itemselect2")
	   .TapOnDone("Sprint4_Script3-done")
	   ._atSetupInventoryPage()
        .skipfoodcost("Sprint4_Script3-Skip food cost")
	        ._atInventoryToolPage()
			.InvTools_TrackInventory("Sprint4_Script4-trackINventoryclick")
			._atLocationsPage()
			.locationItemClick1AndEnterValue(locationsData.LocationName,"Sprint4_Script3-qtyfirstitem")
			.locationItemClick2AndEnterValue(locationsData1.LocationName,"Sprint4_Script3-qtyseconditem")
			;
			
	}
	
	@Test(groups={"Script4"},priority=3, description = "Sprint4-trackINventoryTwoLocationsVerify as MA user")
	public void trackINventoryTwoLocationsVerify_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
		//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			LocationsData locationsData =LocationsData.fetch("LocatiosData2");
			LocationsData locationsData1 =LocationsData.fetch("LocatiosData3");

			Start.asTester
				.goToLoginpage()
				.verifyLoginPage("Sprint4_Script4-LoginPage")
				.signIn(loginData.UserName, loginData.Password,"Sprint4_Script4-Login")
				._atHomePage()
				.HamburgerMenu("Sprint4_Script4-HamburgerTap")
		   //  .HamMenuTap_MAuser("Script4-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Sprint4_Script4-AccountsTap")
		   .AccountSwitchSecondID("Sprint4_Script4-FirstAccountSelect")
		 //    .AccountSwitchFirstID("Script4-FirstAccountSelect")
		   ._atInventoryToolPage()
		      .InvTools_SetUpInventory("Sprint4_Script3-SetupInventoryTap")
		    ._atSetupInventoryPage()
		    .AddItemFrom_OrderGuide("Sprint4_Script3-OrderguideTap")
		    ._atLocationsPage()
		    .CustomLocation("Sprint4_Script3-customlocation")
		    ._atLocationsPage()
		    .AddLocations1_name(locationsData.LocationName)
		    .AddLocations1_TypeDry("Sprint4_Script3-Addlocation1")
		    .AddLocations2()
		    .AddLocations2_name(locationsData1.LocationName)
		    .AddLocations2_TypeDry("Sprint4_Script3-Addlocation2")
		    .tapContinue("")
		    .Itemselect1("Sprint4_Script3-itemselect1")
		    .TapOnNext("")
		    .Itemselect2("Sprint4_Script3-itemselect2")
		   .TapOnDone("Sprint4_Script3-done")
		   ._atSetupInventoryPage()
	        .skipfoodcost("Sprint4_Script3-Skip food cost")
		        ._atInventoryToolPage()
				.InvTools_TrackInventory("Sprint4_Script4-trackINventoryclick")
				._atLocationsPage()
				.locationItemClick1AndEnterValue(locationsData.LocationName,"Sprint4_Script3-qtyfirstitem")
				.locationItemClick2AndEnterValue(locationsData1.LocationName,"Sprint4_Script3-qtyseconditem")
				;
				
			
	}

	
	
	
	
	

	
	@Test(groups={"Script5"},priority=4, description = "Sprint4-449-Selecting supplier in purchases as normal user")
	public void PurchaseVendor_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
	//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData2");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData3");

		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Sprint4_Script5-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Sprint4_Script5-Login")
		 ._atInventoryToolPage()
		 .InvTools_Suppliers("Sprint4_Script5-supplierstap")
		 ._atVendorPage()
		 .Add_Supplier("Sprint4_Script5-suppliersadd")
		 .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note,"Sprint4_Script5-suppliersdetails")
	    //.AddVendor_Done_iPhone("Script5-suppliersadded")
		 .TapOnDone("Sprint4_Script5-Done")
		 .TapOnDone("Sprint4_Script6-Done") //iphone
		 .TapOnBack("Sprint4_Script5-Back")
		 .TapOnBack("Sprint4_Script5-Back")
		
		 ._atInventoryToolPage()
	    . InvTools_Purchases("Sprint4_Script5-PurchaseTap")
		 ._atPurchasesPage()
		 .AddPurchases("Sprint4_Script5-CreatePurchase")
		 .SupplierSelect("Sprint4_Script5-SupplierTap")
			;
	}

	@Test(groups={"Script6"},priority=5, description = "Sprint4-449-Selecting supplier in purchases as ma user")
	public void PurchaseVendor_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
	//	NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSycoItemData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		LocationsData locationsData =LocationsData.fetch("LocatiosData2");
		LocationsData locationsData1 =LocationsData.fetch("LocatiosData3");

		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Sprint4_Script6-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Sprint4_Script6-Login")
		
			._atHomePage()
			.HamburgerMenu("Script6-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Sprint4_Script6-AccountsTap")
		     .AccountSwitchFirstID("Sprint4_Script6-FirstAccountSelect")
		     
		     ._atInventoryToolPage()
			 .InvTools_Suppliers("Sprint4_Script6-supplierstap")
			 ._atVendorPage()
			 .Add_Supplier("Sprint4_Script6-suppliersadd")
			 .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note,"Sprint4_Script6-suppliersdetails")
		    //.AddVendor_Done_iPhone("Script5-suppliersadded")
			 .TapOnDone("Sprint4_Script6-Done")
			 .TapOnDone("Sprint4_Script6-Done") //iphone
			 .TapOnBack("Sprint4_Script6-Back")
			 .TapOnBack("Sprint4_Script6-Back")
			
			 ._atInventoryToolPage()
		    . InvTools_Purchases("Sprint4_Script6-PurchaseTap")
			 ._atPurchasesPage()
			 .AddPurchases("Sprint4_Script6-CreatePurchase")
			 .SupplierSelect("Sprint4_Script6-SupplierTap")
				
			;
	}
	


	
}
