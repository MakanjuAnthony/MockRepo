
package com.tests;


//import org.apache.commons.exec.CommandLine;

import org.testng.annotations.Test
;

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
import com.components.yaml.PurchasesData;
import com.components.yaml.SearchData;
import com.components.yaml.UOMQuantityData;
import com.components.yaml.VendorDetailsData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;
import org.testng.annotations.Test;


public class Sprint5SampleTest extends Initiator{

	
	
	//sprint5
	@Test(groups={"Script1"},priority=0, description = "Sprint5-425.6- OrderGuideMultipleItems_NU")
	public void OrderGuideMultipleItems_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
      //  NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSyscoItemData");
//		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script1-Login")
			 ._atInventoryToolPage()
		      .InvTools_SetUpInventory("Script1-SetupInventoryTap")
		       ._atSetupInventoryPage()
		     .StartFromScratch("Script1-ScratchSelected")
		     .Scratch_AddItems("Script1-AddItemsTap")
            .SelectMultipleItemsFrom_OrderGuide("Script1-AddItemsOrderGuide")
            .verifyMultipleItemsfromOGonSetUpInv("Script1-verifyMultipleItemsfromOGonSetUpInv")
			;
			
	}
	@Test(groups={"Script1"},priority=0, description = "Sprint5-425.6- OrderGuideMultipleItems_MA")
	public void OrderGuideMultipleItems_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
      //  NonSycoItemData nonSyscoItemData =NonSycoItemData.fetch("NonSyscoItemData");
//		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailsNonsysco");
		
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script1-Login")
			._atHomePage()
			.HamburgerMenu("Script1-HamburgerTap")
			     ._atAccountsPage()
			     .HamMenu_Accounts("Script11-AccountsTap")
			     .AccountSwitchFirstID("Script11-FirstAccountSelect")
			     ._atInventoryToolPage()
			      .InvTools_SetUpInventory("Script1-SetupInventoryTap")
			       ._atSetupInventoryPage()
			     .StartFromScratch("Script1-ScratchSelected")
			     .Scratch_AddItems("Script1-AddItemsTap")
	            .SelectMultipleItemsFrom_OrderGuide("Script1-AddItemsOrderGuide")
	            .verifyMultipleItemsfromOGonSetUpInv("Script1-verifyMultipleItemsfromOGonSetUpInv")
				;
	}
	
	
	@Test(groups={"Script1"},priority=0, description = "Sprint5-427.1-Adding non sysco item to inventory as a normal user -ve flow")
	public void AddNonsysco_NegFlow_NU() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script1-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script1-Login")
		 ._atInventoryToolPage()
		  .InvTools_SetUpInventory("Script1-SetupInventoryTap")
	    ._atSetupInventoryPage()
	    .StartFromScratch("Script1-ScratchSelected")
	    .Scratch_AddItems("Script1-AddItemsTap")
	    .AddItemFrom_NonSysco("Script1-NonSyscoItemAddition")
	  .EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Script1-NonSyscoItemAddPage")
	  .TapOnDone("Script1-Done")
		.NonSyscoItem_AddSupplierSelectAlertYes("Script1-VendorSelect")
		    ._atVendorPage()
	.Add_Supplier("Script1-AddVendorTap")
	 .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Script1-AddVendorDetails")
	.TapOnDone("Script1-Done")
	//.TapOnDone("Script2-Done") //iphone
	.TapOnBack("Script1-Back")
		.VendorSelect(vendorDetailsData.VendorName,"Script1-VendorSelect")
		._atSetupInventoryPage()
		.verifyNonSysco_AddedPdtSupplier(vendorDetailsData.VendorName,"Script1-VendorSelect")
		.TapOnDone("Script1-Done")
		.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"Script1-NonsycoItemadded")	 
		.TapOnDone("Script1-Done")
		;
}
	
	@Test(groups={"Script2"},priority=1, description = "Sprint5-427.1-Adding non sysco item to inventory as a MA user -ve flow")
	public void AddNonsysco_NegFlow_MA() {	
		
		LoginData loginData =LoginData.fetch("MAusrLgn");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script2-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Script2-Login")
			._atHomePage()
			.HamburgerMenu("Script1-HamburgerTap")
			     ._atAccountsPage()
			     .HamMenu_Accounts("Script11-AccountsTap")
			     .AccountSwitchFirstID("Script11-FirstAccountSelect")
			     ._atInventoryToolPage()
				  .InvTools_SetUpInventory("Script1-SetupInventoryTap")
			    ._atSetupInventoryPage()
			    .StartFromScratch("Script1-ScratchSelected")
			    .Scratch_AddItems("Script1-AddItemsTap")
			    .AddItemFrom_NonSysco("Script1-NonSyscoItemAddition")
			  .EnterItemDetails(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Script1-NonSyscoItemAddPage")
			  .TapOnDone("Script1-Done")
				.NonSyscoItem_AddSupplierSelectAlertYes("Script1-VendorSelect")
				    ._atVendorPage()
			.Add_Supplier("Script1-AddVendorTap")
			 .AddSupplier_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Script1-AddVendorDetails")
			.TapOnDone("Script1-Done")
			//.TapOnDone("Script2-Done") //iphone
			.TapOnBack("Script1-Back")
				.VendorSelect(vendorDetailsData.VendorName,"Script1-VendorSelect")
				._atSetupInventoryPage()
				.verifyNonSysco_AddedPdtSupplier(vendorDetailsData.VendorName,"Script1-VendorSelect")
				.TapOnDone("Script1-Done")
				.verifyNonSyscoPrepItemSetupInv(nonSyscoItemData.ProductName,"Script1-NonsycoItemadded")	 
				.TapOnDone("Script1-Done")
				;
	
}
	
/*
@Test(groups={"P1_Script7"},priority=3, description = "Sprint5-430.5 adding Nonsysco items to location -normal user")
  public void NonSycoItemsAddLoc_NU() {	
  	
  	LoginData loginData =LoginData.fetch("LoginDatNor1");
  				VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
  				LocationsData locationsData =LocationsData.fetch("LocatiosData3");
  				NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
  				
  				Start.asTester
  					.goToLoginpage()
  					.verifyLoginPage("Script7-LoginPage")
  					.signIn(loginData.UserName, loginData.Password,"Script7-Login")
  						
  					 ._atInventoryToolPage()
  		     		.InvTools_Locations("Script7-LocationsTap")
  		     		._atLocationsPage()
  		     		.TapAddLocation("Script7-AddLocation")
  		     		.AddLocationDetails(locationsData.LocationName,"Script7-LocationDetails")
  		     		.TapOnDone("Script7-Done")
  		    		.TapOnBack("Script7-Back")
  		    		.TapOnBack("Script7-Back")
  		    		 ._atInventoryToolPage()
				    .InvTools_TrackInventory("Script7-trackINventory")
				     ._atLocationsPage()
  				     .LocationSelect(locationsData.LocationName,"Script7-LocationSelect")
  				      .TapAddLocation("Script7-AddLocation")
  				    ._atSetupInventoryPage()    
  		 			.AddItemFrom_NonSysco("Script7-NonSyscoItemAddition")
        			.AddProduct_NonSysco(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Script7-NonSyscoItemAddPage")
     					._atVendorPage()
  				.Add_Supplier("Script7-AddVendorTap")
  				 .AddVendor_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Script7-AddVendorDetails")
  				.TapOnDone("Script7-Done")
  				.TapOnDone("Script7-Done") //iphone
  				.TapOnBack("Script7-Back")
  					._atSetupInventoryPage()
  					.NonSysco_VendorSelect(vendorDetailsData.VendorName,"Script7-VendorSelect")
  					.TapOnDone("Script7-Done")
  					.verifyNonsyscoItem(nonSyscoItemData.ProductName,"Script7-NonsycoItemadded")	 
  					.TapOnDone("Script7-Done")
  					;
  				
  		
  }


 @Test(groups={"P1_Script8"},priority=3, description = "Sprint5-430.5 adding Nonsysco items to location -MA user")
  public void NonSycoItemsAddLoc_MA() {	
  	
  	LoginData loginData =LoginData.fetch("MAusrLgn");
  			
  	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		
  				Start.asTester
  					.goToLoginpage()
  					.verifyLoginPage("Script8-LoginPage")
  					.signIn(loginData.UserName, loginData.Password,"Script8-Login")
  					._atHomePage()
			.HamMenuTap("Script8-HamburgerTap")
			     ._atAccountsPage()
			     .HamMenu_Accounts("Script8-AccountsTap")
			     .AccountSwitchFirstID("Script8-FirstAccountSelect")
			     ._atInventoryToolPage()
		     		.InvTools_Locations("Script8-LocationsTap")
		     		._atLocationsPage()
		     		.TapAddLocation("Script8-AddLocation")
		     		.AddLocationDetails(locationsData.LocationName,"Script8-LocationDetails")
		     		.TapOnDone("Script8-Done")
		    		.TapOnBack("Script8-Back")
		    		.TapOnBack("Script8-Back")
		    		 ._atInventoryToolPage()
			    .InvTools_TrackInventory("Script8-trackINventory")
			     ._atLocationsPage()
				     .LocationSelect(locationsData.LocationName,"Script8-LocationSelect")
				      .TapAddLocation("Script8-AddLocation")
				    ._atSetupInventoryPage()    
		 			.AddItemFrom_NonSysco("Script8-NonSyscoItemAddition")
   			.AddProduct_NonSysco(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Script8-NonSyscoItemAddPage")
					._atVendorPage()
				.Add_Supplier("Script8-AddVendorTap")
				 .AddVendor_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Script8-AddVendorDetails")
				.TapOnDone("Script8-Done")
				.TapOnDone("Script8-Done") //iphone
				.TapOnBack("Script8-Back")
					._atSetupInventoryPage()
					.NonSysco_VendorSelect(vendorDetailsData.VendorName,"Script8-VendorSelect")
					.TapOnDone("Script8-Done")
					.verifyNonsyscoItem(nonSyscoItemData.ProductName,"Script8-NonsycoItemadded")	 
					.TapOnDone("Script8-Done")
					;
  		
  }*/


/*	@Test(groups={"Script1"},priority=4, description = "Sprint5-429.12-Verify qty entering as decimal- normal user")
	public void VerifyQuantityDecimal_NU() {	
	  	
	  	//LoginData loginData =LoginData.fetch("MAusrLgn");
	  		 	LoginData loginData =LoginData.fetch("LoginDatNor");	
	  	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
			LocationsData locationsData =LocationsData.fetch("LocatiosData3");
			LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		
		
		Start.asTester
		.goToLoginpage()
		//.verifyLoginPage("Script3-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"Sprint5_Script1-Login")
	 ._atInventoryToolPage()
      .InvTools_SetUpInventory("Sprint5_Script1-SetupInventoryTap")
    ._atSetupInventoryPage()
    .tapStartFromScratch("Sprint5_Script1-ScratchSelected")
    .SetupInventory_AddItems("Sprint5_Script1-AddItemsTap")
		
    .AddItemFrom_NonSysco("Sprint5_Script1-NonSyscoItemAddition")
	  .AddProduct_NonSysco(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Sprint5_Script1-NonSyscoItemAddPage")
	._atVendorPage()
	.Add_Supplier("Sprint5_Script1-AddVendorTap")
	 .AddVendor_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Sprint5_Script1-AddVendorDetails")
	.TapOnDone("Sprint5_Script1-Done")
	.TapOnDone("Sprint5_Script1-Done") //iphone
	.TapOnBack("Sprint5_Script1-Back")
		._atSetupInventoryPage()
		.NonSysco_VendorSelect(vendorDetailsData.VendorName,"SSprint5_Script1-VendorSelect")
		.TapOnDone("Sprint5_Script1-Done")
		.verifyNonsyscoItem(nonSyscoItemData.ProductName, "Sprint5_Script1-NonsycoItemadded")
		
		.AddItemLink("Sprint5_Script1-AdditemsLinkTap")
	  		 			
		.AddItemFrom_PrepItem("Sprint5_Script1-PrepItemAddition")
	     .AddProduct_NonSyscoWithoutClickingAddSupplier(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "Sprint5_Script1-NonSyscoItemAddPage")
	     				.TapOnDone("Sprint5_Script1-Done")
	     				.verifyNonsyscoItem(prepItemData.ProductName,"Sprint5_Script1-PrepItemadded")
	  					.TapOnDone("Sprint5_Script1-Done")
	  					
	  					.SetupInventoryLocations_CustomLocation("Sprint5_Script1-customlocation")
	  				    ._atLocationsPage()
	  				    .AddLocations1_name(locationsData.LocationName)
	  				    .AddLocations1_TypeDry("Sprint5_Script1-Addlocation1")  //not working
	  				    .AddLocations2()
	  				//    .AddLocations2_name("test")
	  				   .AddLocations2_name(locationsData1.LocationName)
	  				    .AddLocations2_TypeDry("Sprint5_Script1-Addlocation2")  //not working
	  				    .Loc_Continue()
	  				    .Itemselect1("Sprint5_Script1-itemselect1")
	  				    .Location1_Next()
	  				    .Itemselect2("Sprint5_Script1-itemselect2")
	  				   .Location2_Done("Sprint5_Script1-done")		
	  				  ._atSetupInventoryPage()
	  		        .skipfoodcost("Sprint5_Script1-Skip food cost")
	  			        ._atInventoryToolPage()
	  					.InvTools_TrackInventory("Sprint5_Script1-trackInventory")
	  					._atLocationsPage()
	  					.locationItemClick1AndEnterValue(locationsData.LocationName,"Sprint5_Script1-qtyfirstitem")
	  					.locationItemClick2AndEnterValue(locationsData1.LocationName,"Sprint5_Script1-qtyseconditem")
	  					;
	 
	  		
	  }

	
	
	
	
@Test(groups={"Script2"},priority=4, description = "Sprint5-429.12-Verify qty entering as decimal- MA user")
	public void VerifyQuantityDecimal_MA() {	
	  	
	  	LoginData loginData =LoginData.fetch("MAusrLgn");
	  		 
	  	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
			LocationsData locationsData =LocationsData.fetch("LocatiosData3");
			LocationsData locationsData1 =LocationsData.fetch("LocatiosData2");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		
		
		Start.asTester
		.goToLoginpage()
		//.verifyLoginPage("Script3-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"Sprint5_Script2-Login")
		._atHomePage()
		.HamMenuTap("Sprint5_Script2-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Sprint5_Script2-AccountsTap")
		     .AccountSwitchFirstID("Sprint5_Script2-FirstAccountSelect")
	 ._atInventoryToolPage()
      .InvTools_SetUpInventory("Sprint5_Script2-SetupInventoryTap")
    ._atSetupInventoryPage()
    .tapStartFromScratch("Sprint5_Script2-ScratchSelected")
    .SetupInventory_AddItems("Sprint5_Script2-AddItemsTap")
		
    .AddItemFrom_NonSysco("Sprint5_Script2-NonSyscoItemAddition")
	  .AddProduct_NonSysco(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Sprint5_Script2-NonSyscoItemAddPage")
	._atVendorPage()
	.Add_Supplier("Sprint5_Script2-AddVendorTap")
	 .AddVendor_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Sprint5_Script2-AddVendorDetails")
	.TapOnDone("Sprint5_Script2-Done")
	.TapOnDone("Sprint5_Script2-Done") //iphone
	.TapOnBack("Sprint5_Script2-Back")
		._atSetupInventoryPage()
		.NonSysco_VendorSelect(vendorDetailsData.VendorName,"SSprint5_Script2-VendorSelect")
		.TapOnDone("Sprint5_Script2-Done")
		.verifyNonsyscoItem(nonSyscoItemData.ProductName, "Sprint5_Script2-NonsycoItemadded")
		
		.AddItemLink("Sprint5_Script2-AdditemsLinkTap")
	  		 			
		.AddItemFrom_PrepItem("Sprint5_Script2-PrepItemAddition")
	     .AddProduct_NonSyscoWithoutClickingAddSupplier(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "Sprint5_Script2-NonSyscoItemAddPage")
	     				.TapOnDone("Sprint5_Script2-Done")
	     				.verifyNonsyscoItem(prepItemData.ProductName,"Sprint5_Script2-PrepItemadded")
	  					.TapOnDone("Sprint5_Script1-Done")
	  					
	  					.SetupInventoryLocations_CustomLocation("Sprint5_Script2-customlocation")
	  				    ._atLocationsPage()
	  				    .AddLocations1_name(locationsData.LocationName)
	  				    .AddLocations1_TypeDry("Sprint5_Script2-Addlocation1")
	  				    .AddLocations2()
	  				    .AddLocations2_name(locationsData1.LocationName)
	  				    .AddLocations2_TypeDry("Sprint5_Script2-Addlocation2")
	  				    .Loc_Continue()
	  				    .Itemselect1("Sprint5_Script2-itemselect1")
	  				    .Location1_Next()
	  				    .Itemselect2("Sprint5_Script2-itemselect2")
	  				   .Location2_Done("Sprint5_Script2-done")		
	  				  ._atSetupInventoryPage()
	  		        .skipfoodcost("Sprint5_Script2-Skip food cost")
	  			        ._atInventoryToolPage()
	  					.InvTools_TrackInventory("Sprint5_Script2-trackInventory")
	  					._atLocationsPage()
	  					.locationItemClick1AndEnterValue(locationsData.LocationName,"Sprint5_Script2-qtyfirstitem")
	  					.locationItemClick2AndEnterValue(locationsData1.LocationName,"Sprint5_Script2-qtyseconditem")
	  					;
	 	
	  }

@Test(groups={"Script3"},priority=2, description = "Sprint5-427.2-Adding non sysco item to inventory as a normal user & verify")
public void AddNonsyscoVerify_NU() {	
	LoginData loginData =LoginData.fetch("LoginDatNor1");
	NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
	LocationsData locationsData =LocationsData.fetch("LocatiosData2");
	Start.asTester
		.goToLoginpage()
		.verifyLoginPage("Sprint5_Script3-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"Script3-Login")
		
		 ._atInventoryToolPage()
	      .InvTools_SetUpInventory("Sprint5_Script3-SetupInventoryTap")
	    ._atSetupInventoryPage()
	    .tapStartFromScratch("Sprint5_Script3-ScratchSelected")
	    .SetupInventory_AddItems("Sprint5_Script3-AddItemsTap")	
	    .AddItemFrom_NonSysco("Sprint5_Script3-NonSyscoItemAddition")
		  .AddProduct_NonSysco(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Sprint5_Script3-NonSyscoItemAddPage")
		
	    ._atVendorPage()
	    .Add_Supplier("Sprint5_Script3-AddVendorTap")
		 .AddVendor_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Sprint5_Script3-AddVendorDetails")
		.TapOnDone("Sprint5_Script3-Done")
		.TapOnDone("Sprint5_Script3-Done") //iphone
		
		.TapOnBack("Sprint5_Script3-Back")
		

		._atSetupInventoryPage()
		.NonSysco_VendorSelect(vendorDetailsData.VendorName,"SSprint5_Script2-VendorSelect")
		.TapOnDone("Sprint5_Script3-Done")
		
		.verifyNonsyscoItem(nonSyscoItemData.ProductName,"Sprint5_Script3-NonsycoItemadded")
		.TapOnDone("Sprint5_Script3-Done")
		 
		.SetupInventoryLocations_CustomLocation("Sprint5_Script3-Customlocselected")
		._atLocationsPage()
	    .AddLocations1_name(locationsData.LocationName)
	    .AddLocations1_TypeDry("Sprint5_Script3-Addlocation1") 
	    .Loc_Continue()  
	    
	    .Itemselect1("Sprint5_Script3-Itemselected")
	    .Location2_Done("Script3-Donetap")
	    ._atSetupInventoryPage()
	    
	    .skipfoodcost("Sprint5_Script3-Skip food cost")
	     ._atInventoryToolPage()
		.InvTools_TrackInventory("Sprint5_Script3-trackINventoryTwoLocationsVerify")
		._atLocationsPage()
		.locationItemVerify(locationsData.LocationName,"Script3-LocationsItemVerify")
		;
		
	
	
	
	

	
}

@Test(groups={"Script4"},priority=3, description = "Sprint5-427.2-Adding non sysco item to inventory as a normal user & verify")
public void AddNonsyscoVerify_MA() {	
	
	LoginData loginData =LoginData.fetch("MAusrLgn");
	NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
	LocationsData locationsData =LocationsData.fetch("LocatiosData2");
	Start.asTester
		.goToLoginpage()
		.verifyLoginPage("Sprint5_Script3-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"Script3-Login")
		
		 ._atInventoryToolPage()
	      .InvTools_SetUpInventory("Sprint5_Script3-SetupInventoryTap")
	    ._atSetupInventoryPage()
	    .tapStartFromScratch("Sprint5_Script3-ScratchSelected")
	    .SetupInventory_AddItems("Sprint5_Script3-AddItemsTap")	
	    .AddItemFrom_NonSysco("Sprint5_Script3-NonSyscoItemAddition")
		  .AddProduct_NonSysco(nonSyscoItemData.ProductName, nonSyscoItemData.UPC, nonSyscoItemData.Pack, nonSyscoItemData.Size, nonSyscoItemData.Weight, nonSyscoItemData.Price, nonSyscoItemData.ProductBrand, "Sprint5_Script3-NonSyscoItemAddPage")
		
	    ._atVendorPage()
	    .Add_Supplier("Sprint5_Script3-AddVendorTap")
		 .AddVendor_Details(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum, vendorDetailsData.Address, vendorDetailsData.ContactInfo, vendorDetailsData.Email, vendorDetailsData.Note, "Sprint5_Script3-AddVendorDetails")
		.TapOnDone("Sprint5_Script3-Done")
		.TapOnDone("Sprint5_Script3-Done") //iphone
		
		.TapOnBack("Sprint5_Script3-Back")
		

		._atSetupInventoryPage()
		.NonSysco_VendorSelect(vendorDetailsData.VendorName,"SSprint5_Script2-VendorSelect")
		.TapOnDone("Sprint5_Script3-Done")
		
		.verifyNonsyscoItem(nonSyscoItemData.ProductName,"Sprint5_Script3-NonsycoItemadded")
		.TapOnDone("Sprint5_Script3-Done")
		 
		.SetupInventoryLocations_CustomLocation("Sprint5_Script3-Customlocselected")
		._atLocationsPage()
	    .AddLocations1_name(locationsData.LocationName)
	    .AddLocations1_TypeDry("Sprint5_Script3-Addlocation1") 
	    .Loc_Continue()  
	    
	    .Itemselect1("Sprint5_Script3-Itemselected")
	    .Location2_Done("Script3-Donetap")
	    ._atSetupInventoryPage()
	    
	    .skipfoodcost("Sprint5_Script3-Skip food cost")
	     ._atInventoryToolPage()
		.InvTools_TrackInventory("Sprint5_Script3-trackINventoryTwoLocationsVerify")
		._atLocationsPage()
		.locationItemVerify(locationsData.LocationName,"Script3-LocationsItemVerify")
		;
		
	
	
	
		
}
@Test(groups={"Script11"},priority=10, description = "Sprint5-430.5-adding Prep items to location -normal user")
public void PrepItemsAddLoc_NU() {	
	
	//LoginData loginData =LoginData.fetch("MAusrLgn");
		 	LoginData loginData =LoginData.fetch("LoginDatNor");	
	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
	PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
	
	Start.asTester
					.goToLoginpage()
					.verifyLoginPage("Script7-LoginPage")
					.signIn(loginData.UserName, loginData.Password,"Script7-Login")
					
._atInventoryToolPage()
		     		.InvTools_Locations("Script7-LocationsTap")
		     		._atLocationsPage()
		     		.TapAddLocation("Script7-AddLocation")
		     		.AddLocationDetails(locationsData.LocationName,"Script7-LocationDetails")
		     		.TapOnDone("Script7-Done")
		    		.TapOnBack("Script7-Back")
		    		.TapOnBack("Script7-Back")
		    		 ._atInventoryToolPage()
				    .InvTools_TrackInventory("Script7-trackINventory")
				     ._atLocationsPage()
				     .LocationSelect(locationsData.LocationName,"Script7-LocationSelect")
				      .TapAddLocation("Script7-AddLocation")
				    ._atSetupInventoryPage()    
		 			 .AddItemFrom_PrepItem("Sprint5_Script11-PrepItemAddition")
      				.AddProduct_NonSyscoWithoutClickingAddSupplier(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "Sprint5_Script11-NonSyscoItemAddPage")
   				.TapOnDone("Script2-Done")
   				.verifyNonsyscoItem(prepItemData.ProductName,"Sprint5-PrepItemadded")
					.TapOnDone("Script7-Done")
					;
	


		
}



@Test(groups={"Script12"},priority=11, description = "Sprint5-430.5-adding Prep items to location -MA user")
public void PrepItemsAddLoc_MA() {	
	
	 	LoginData loginData =LoginData.fetch("MAusrLgn");
		 		
	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VDNonsysco");
		LocationsData locationsData =LocationsData.fetch("LocatiosData3");
		NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
	PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
	
	Start.asTester
					.goToLoginpage()
					.verifyLoginPage("Script7-LoginPage")
					.signIn(loginData.UserName, loginData.Password,"Script7-Login")
					
._atInventoryToolPage()
		     		.InvTools_Locations("Script7-LocationsTap")
		     		._atLocationsPage()
		     		.TapAddLocation("Script7-AddLocation")
		     		.AddLocationDetails(locationsData.LocationName,"Script7-LocationDetails")
		     		.TapOnDone("Script7-Done")
		    		.TapOnBack("Script7-Back")
		    		.TapOnBack("Script7-Back")
		    		 ._atInventoryToolPage()
				    .InvTools_TrackInventory("Script7-trackINventory")
				     ._atLocationsPage()
				     .LocationSelect(locationsData.LocationName,"Script7-LocationSelect")
				      .TapAddLocation("Script7-AddLocation")
				    ._atSetupInventoryPage()    
		 			 .AddItemFrom_PrepItem("Sprint5_Script11-PrepItemAddition")
      				.AddProduct_NonSyscoWithoutClickingAddSupplier(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "Sprint5_Script11-NonSyscoItemAddPage")
   				.TapOnDone("Script2-Done")
   				.verifyNonsyscoItem(prepItemData.ProductName,"Sprint5-PrepItemadded")
					.TapOnDone("Script7-Done")
					;
	
	
}

	*/
/*	
	//Precondition:Location should be added with an item in it. Location=loc2 item=Egg Category=Test

	@Test(groups={"Script3"},priority=2, description = "Sprint5-425.11-trackINventoryTwoLocationsVerify as normal user")
	public void ProductDetailsQuanityVerify() {	
		

		LoginData loginData =LoginData.fetch("LoginDatNor1");	
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData4");
			LocationsData locationsData =LocationsData.fetch("LocatiosData3");
			NonSyscoItemData nonSyscoItemData =NonSyscoItemData.fetch("NonSyscoItmData");
		PrepItemData prepItemData =PrepItemData.fetch("PrepItemData");
		UOMQuantityData uomQuantityData=UOMQuantityData.fetch("UOMQuantityData");
		
	
		Start.asTester
						.goToLoginpage()
						.verifyLoginPage("Script7-LoginPage")
						.signIn(loginData.UserName, loginData.Password,"Script7-Login")
						
	                   ._atInventoryToolPage()
			     		.InvTools_Locations("Script7-LocationsTap")
			     		._atLocationsPage()
			     		.TapAddLocation("Script7-AddLocation")
			     		.AddLocationDetails(locationsData.LocationName,"Script7-LocationDetails")
			     		.TapOnDone("Script7-Done")
			    		.TapOnBack("Script7-Back")
			    		.TapOnBack("Script7-Back")
			    		 ._atInventoryToolPage()
					    .InvTools_TrackInventory("Script7-trackINventory")
					     ._atLocationsPage()
					     .LocationSelect(locationsData.LocationName,"Script7-LocationSelect")
					      .TapAddLocation("Script7-AddLocation")
					    ._atSetupInventoryPage()    
			 			 .AddItemFrom_PrepItem("Sprint5_Script11-PrepItemAddition")
	      				.AddProduct_NonSyscoWithoutClickingAddSupplier(prepItemData.ProductName, prepItemData.UPC, prepItemData.Pack, prepItemData.Size, prepItemData.Weight, prepItemData.Price, prepItemData.ProductBrand, "Sprint5_Script11-NonSyscoItemAddPage")
	   				.TapOnDone("Script2-Done")
	   				.verifyNonsyscoItem(prepItemData.ProductName,"Sprint5-PrepItemadded")
	   				._atLocationsPage()
	   				
	   				
						
					 ._atInventoryToolPage()
						    .InvTools_TrackInventory("Script7-trackINventory")
						     ._atLocationsPage()
						     .LocationSelect(locationsData.LocationName,"Script7-LocationSelect")
			         .ProductSelect(prepItemData.ProductName, "Script7-ProductSelect")
			         .TapOnEdit("Script7-Edit")
			         .ProdDetailQtyEnter(locationsData.LocationName,uomQuantityData.Quantity,  "Script7-Quantity")
			         .TapOnDone("Script7-Done")
			         .TapOnBack("Script7-Back")
			         .LocationSelect(locationsData.LocationName,"Script7-LocationSelect")
			         .QuantityVerify(uomQuantityData.Quantity, "Script7-Quantityverify")
			         .TapOnBack("Script7-Back")
			         .TapOnBack("Script7-Back")
			         ._atInventoryToolPage()
			         .InvTools_CloseInventory("Script7-Closeinventorytap")
			         .InvTools_ClosedInventoryYes("Script7-ClosedInventory")
			         .InvTools_FoodCost("Script7-FoodCostTap")
						
						
			         
			;
			
	}*/
	
	
/*	//precondition: supplier,category,item in that category
	@Test(groups={"Script3"},priority=2, description = "Sprint5--purchases as normal user")
	public void PurchaseDetails() {	
		

		LoginData loginData =LoginData.fetch("LoginDatNor1");	
		VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData4");
		CategoryData categoryData=CategoryData.fetch("CategoryData");
		PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
	
		Start.asTester
						.goToLoginpage()
						.verifyLoginPage("Script7-LoginPage")
						.signIn(loginData.UserName, loginData.Password,"Script7-Login")
						
	                 
						
						 ._atInventoryToolPage()
						    . InvTools_Purchases("Sprint4_Script5-PurchaseTap")
							 ._atPurchasesPage()
							 .AddPurchases("Sprint4_Script5-CreatePurchase")
							 .SupplierSelect("Sprint4_Script5-SupplierTap")
							 .ExpenseCategorySelect(categoryData.Name,"Sprint4_Script5-CategrySelect")
							 .PurchaseDetails(purchasesData.InvoiceNumber, purchasesData.InvoiceTotal, purchasesData.ExpenseAmount, "Sprint4_Script5-purchasedetail")
							 .DateSelect("Sprint4_Script5-DateTap")
							 .TapOnDone("Script4-Done")
			         
			;
			
	}*/
	/*
	//precondition: supplier,category,item in that category
		@Test(groups={"Script3"},priority=2, description = "Sprint5--purchases as normal user")
		public void TC431_1_1_Location() {	
			

			LoginData loginData =LoginData.fetch("LoginDatNor1");	
			VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData4");
			CategoryData categoryData=CategoryData.fetch("CategoryData");
			PurchasesData purchasesData=PurchasesData.fetch("PurchasesData");
			LocationsData locationsData =LocationsData.fetch("LocatiosData3");
			Start.asTester
							.goToLoginpage()
							.verifyLoginPage("TC431_1_1_Location")
							.signIn(loginData.UserName, loginData.Password,"TC431_1_1_Location")
				
							 ._atInventoryToolPage()
							 .InvTools_TrackInventory("TC431_1_1_Location")
							 ._atLocationsPage()
							 .LocationSelect(locationsData.LocationName,"TC431_1_1_Location")
							 .ProductSelect("Egg","TC431_1_1_Location")
							 .TapOnEdit("TC431_1_1_Location")
							 .tapONAddSelectLocations("TC431_1_1_Location")
							 .anotherLocationSelect("T", "TC431_1_1_Location")
							 .doneBlueButton("TC431_1_1_Location")
							 .ProdDetailQtyEnter("T", "12", "TC431_1_1_Location")
//							 .locationNumberForAProductOnEditProductPage("TC431_1_1_Location")
							 .TapOnDone("TC431_1_1_Location")
							 .TapOnBack("TC431_1_1_Location")
							 .anotherLocationSelect("T", "TC431_1_1_Location")
							 .QuantityVerify("T", "")
							 
				;
			
				
		}*/

}
