
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


public class Sprint1SampleTest extends Initiator{

	//Sprint1

		


	@Test(groups={"Script2"},priority=3, description = "Adding a new vendor and verify added vendor displayed on vendor list page from Home page for normal user")
	public void AddVendor_Homepage_NormalUser() {	

LoginData loginData =LoginData.fetch("LoginDatNor");
	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData2");

	Start.asTester
		.goToLoginpage()
	.verifyLoginPage("Script2 UI-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"Script2 LoginPage")
	._atInventoryToolPage()
			 .InvTools_Suppliers("Script2 InventoryPage -tap Suppliers")
			._atVendorPage()
			   .verifySupplierPage("Script2 Verify supplier page")
			  .Add_Supplier("Script2 Add supplier page")   

	 .AddSupplier_Details(vendorDetailsData.VendorName,vendorDetailsData.PhoneNum,vendorDetailsData.Address,vendorDetailsData.ContactInfo,vendorDetailsData.Email,vendorDetailsData.Note,"Script2 Add supplier details page")
	.TapOnDone("Script2 Done tapped on supplier page")  
	 .SuppliersList(vendorDetailsData.VendorName,"Script2  Verify supplier list  page")
	;			
	}

@Test(groups={"Script1"},priority=1, description = "Verify vendors displayed in list view navigating from homepage for normal user")
	public void DisplayVendorList_normaluser_homepage() {	
		
		LoginData loginData =LoginData.fetch("LoginDatNor");
		
		
		Start.asTester
			.goToLoginpage()
			.verifyLoginPage("Script1 UI-LoginPage")
		.signIn(loginData.UserName, loginData.Password,"Script1 LoginPage")
			._atInventoryToolPage()
		 .InvTools_Suppliers("Script1 InventoryPage -tap Suppliers")
		    ._atVendorPage()
		   .verifySupplierPage("Script1 Verify supplier page")
		   .Supplier_List("Script1 Verify supplier list page")
		  ;		
	}


@Test(groups={"Script3"},priority=5, description = "verify vendor information displayed on vendor details page-Home page navigation-Normal user")
public void VendorDetails_Homepage_Normaluser() {	

LoginData loginData =LoginData.fetch("LoginDatNor");
VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData2");

Start.asTester
		.goToLoginpage()
	.verifyLoginPage("Script3 UI-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Scrip3 LoginPage")
	._atInventoryToolPage()
			 .InvTools_Suppliers("Script3 InventoryPage -tap Suppliers")
			._atVendorPage()
			   .verifySupplierPage("Script3 Verify supplier page")
   //.ViewVendorDetails("Script3 Verify elements on supplier page")
      .AddedVendorDetails(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum,vendorDetailsData.Address,vendorDetailsData.ContactInfo,vendorDetailsData.Email,vendorDetailsData.Note,"Script3 Verify elements on supplier page")   
     
  
	;
	
}


@Test(groups={"Script4"},priority=6, description = "Delete a vendor and verify deleted vendor is removed from vendor list pages-Home page navigation-Normal user")
public void DeleteVendor_Homepage_Normaluser() {	

	LoginData loginData =LoginData.fetch("LoginDatNor");
	VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData2");
	
Start.asTester
		.goToLoginpage()
	.verifyLoginPage("Script4 UI-LoginPage")
			.signIn(loginData.UserName, loginData.Password,"Scrip4 LoginPage")
	._atInventoryToolPage()
			 .InvTools_Suppliers("Script4 InventoryPage -tap Suppliers")
			._atVendorPage()
			   .verifySupplierPage("Script4 Verify supplier page")
  // .ViewVendorDetails("Script4 Verify elements on supplier page") //uncomnt
	    .DeleteVendor(vendorDetailsData.VendorName,"Script4 Delete supplier") //to edit
	     ;
		
}

//MA

@Test(groups={"Script1"},priority=1, description = "Verify vendors displayed in list view navigating from homepage for MA user")
public void DisplayVendorList_MAuser_homepage() {	

LoginData loginData =LoginData.fetch("MAusrLgn");


Start.asTester
	.goToLoginpage()
	.verifyLoginPage("Script1 UI-LoginPage")
.signIn(loginData.UserName, loginData.Password,"Script1 LoginPage")
._atHomePage()
		     .HamburgerMenu("Script1-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script1-AccountsTap")
		     .AccountSwitchFirstID("Script1-FirstAccountSelect")
			
	._atInventoryToolPage()
 .InvTools_Suppliers("Script1 InventoryPage -tap Suppliers")
    ._atVendorPage()
   .verifySupplierPage("Script1 Verify supplier page")
   .Supplier_List("Script1 Verify supplier list page")
  ;		
}

@Test(groups={"Script2"},priority=3, description = "Adding a new vendor and verify added vendor displayed on vendor list page from Home page for MA user")
public void AddVendor_Homepage_MAUser() {	

LoginData loginData =LoginData.fetch("MAusrLgn");
VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData2");

Start.asTester
.goToLoginpage()
.verifyLoginPage("Script2 UI-LoginPage")
.signIn(loginData.UserName, loginData.Password,"Script2 LoginPage")
._atHomePage()
		     .HamburgerMenu("Script2-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script2-AccountsTap")
		     .AccountSwitchFirstID("Script2-FirstAccountSelect")
	
		     ._atInventoryToolPage()
			 .InvTools_Suppliers("Script2 InventoryPage -tap Suppliers")
			._atVendorPage()
			   .verifySupplierPage("Script2 Verify supplier page")
			  .Add_Supplier("Script2 Add supplier page")   

	 .AddSupplier_Details(vendorDetailsData.VendorName,vendorDetailsData.PhoneNum,vendorDetailsData.Address,vendorDetailsData.ContactInfo,vendorDetailsData.Email,vendorDetailsData.Note,"Script2 Add supplier details page")
	.TapOnDone("Script2 Done tapped on supplier page")  
	 .SuppliersList(vendorDetailsData.VendorName,"Script2  Verify supplier list  page")
	;		
}




@Test(groups={"Script3"},priority=5, description = "verify vendor information displayed on vendor details page-Home page navigation-MA user")
public void VendorDetails_Homepage_MAuser() {	

LoginData loginData =LoginData.fetch("MAusrLgn");
VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData2");

Start.asTester
.goToLoginpage()
.verifyLoginPage("Script3 UI-LoginPage")
	.signIn(loginData.UserName, loginData.Password,"Scrip3 LoginPage")
	._atHomePage()
	.HamburgerMenu("Script3-HamburgerTap")
		  
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script3-AccountsTap")
		     .AccountSwitchFirstID("Script3-FirstAccountSelect")
	
._atInventoryToolPage()
	 .InvTools_Suppliers("Script3 InventoryPage -tap Suppliers")
	._atVendorPage()
	   .verifySupplierPage("Script3 Verify supplier page")
.ViewVendorDetails("Script3 Verify elements on supplier page")
//.AddedVendorDetails(vendorDetailsData.VendorName, vendorDetailsData.PhoneNum,vendorDetailsData.Address,vendorDetailsData.ContactInfo,vendorDetailsData.Email,vendorDetailsData.Note,"Script3 Verify elements on supplier page")   


;

}


@Test(groups={"Script4"},priority=6, description = "Delete a vendor and verify deleted vendor is removed from vendor list pages-Home page navigation-MA user")
public void DeleteVendor_Homepage_MAuser() {	

LoginData loginData =LoginData.fetch("MAusrLgn");
VendorDetailsData vendorDetailsData =VendorDetailsData.fetch("VendorDetailData2");

Start.asTester
.goToLoginpage()
.verifyLoginPage("Script4 UI-LoginPage")
	.signIn(loginData.UserName, loginData.Password,"Scrip4 LoginPage")
	._atHomePage()
		     .HamburgerMenu("Script3-HamburgerTap")
		     ._atAccountsPage()
		     .HamMenu_Accounts("Script3-AccountsTap")
		     .AccountSwitchFirstID("Script3-FirstAccountSelect")
	
._atInventoryToolPage()
	 .InvTools_Suppliers("Script4 InventoryPage -tap Suppliers")
	._atVendorPage()
	   .verifySupplierPage("Script4 Verify supplier page")
// .ViewVendorDetails("Script4 Verify elements on supplier page") //uncomnt
.DeleteVendor(vendorDetailsData.VendorName,"Script4 Delete supplier") //to edit
 ;

}


	


	
	
	
}
