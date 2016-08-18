		
		/**
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 *																																		   	*
		 * 2016-2017 Infosys Limited, Banglore, India. All Rights Reserved																			*

		 * Version: 1.0																																*
		 * 																																			*
		 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
		 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
		 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
		 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
		 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
		 * and will be prosecuted to the maximum extent possible under the law 																		*
		 *																																			*
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 **/
package com.sysco.pages;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.Reporter;

import com.sysco.jsn_framework.JSN_Framework;
import com.sysco.locators.Screenshot;

import io.appium.java_client.ios.IOSDriver;

public class VendorPage extends JSN_Framework {
	private static final Logger LOGGER= Logger.getLogger(VendorPage.class.getCanonicalName());
	public static final String ADD_Vendor = 
			"//*[@id='add-nav']/a/i";
	public static final String ADD_VendorPage = 
			"//*[@class='navbar-brand']//*[contains(text(),'Add Supplier')]";
		

	public static final String ADD_VendorName = 
			"//*[@id='name']";
	public static final String ADD_VendorNumber =  "//*[@id='phoneNumber']";
	public static final String ADD_VendorAddress =  "//*[@id='address']";
	public static final String ADD_VendorContactInfo =  "//*[@id='contactName']";
	public static final String ADD_VendorEmail = 	"//*[@id='emailAddress']";
	public static final String ADD_VendorNote = "//*[@id='notes']";
	public static final String DoneWeb = "//*[@id='done-nav']";
	//done-nav
	public static final String Done = 	"//UIAStaticText[@label='Done']";
	public static final String Back = 	"//*[@id='back-nav']/a/i";

	//public static final String Vendor_firstVendorname = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]";
	

	public static final String VendorDetails_name = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]";
	public static final String VendorDetails_number = 	"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]";
	public static final String VendorDetails_address =	"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[3]";
	public static final String VendorDetails_contact = 	"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[4]";
	public static final String VendorDetails_email = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[5]";
	public static final String VendorDetails_note =	"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[6]";
	public static final String Edit = "//*[@id='edit-nav']//a[contains(text(),'Edit')]";
	
	public static String Name;
	public static final String ADD_VendorDelete = "//*[@id='delete-button' and contains(text(),'Delete Supplier')]";
	public static final String Delete_Yes = 	"//*[@id='yes-button' and contains(text(),'Yes, Delete')]";
	public static final String Delete_Cancel = "//*[@id='yes-button' and contains(text(),'No, Cancel')]";

	public static final String VendorsPage = "//*[contains(text(),'Suppliers')]";

	public static final String ADD_VendorNameLabel = "//*[contains(text(),'SUPPLIER NAME')]";
	public static final String ADD_VendorNumberLabel ="//*[contains(text(),'PHONE NUMBER')]";
	public static final String ADD_VendorAddressLabel =  "//*[contains(text(),'ADDRESS')]";
	public static final String ADD_VendorContactInfoLabel = "//*[contains(text(),'CONTACT INFORMATION')]";
	public static final String ADD_VendorEmailLabel =  "//*[contains(text(),'EMAIL ADDRESS')]";
	public static final String ADD_VendorNoteLabel =  "//*[contains(text(),'NOTE/COMMENTS')]";
	public static final String Cancel = "//*[contains(text(),'Cancel')]";

	public static final String VendorDetails_name_Android ="(//android.widget.EditText)[1]";
	public static final String VendorDetails_number_Android ="(//android.widget.EditText)[2]";
	public static final String VendorDetails_address_Android ="(//android.widget.EditText)[3]";	      
	public static final String VendorDetails_contact_Android ="(//android.widget.EditText)[4]";
	public static final String VendorDetails_email_Android ="(//android.widget.EditText)[5]";
	public static final String VendorDetails_note_Android ="(//android.widget.EditText)[6]";
	
	//public static final String VendorDetails_name_Android ="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[1]";
	//public static final String VendorDetails_number_Android ="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[2]";
	//public static final String VendorDetails_address_Android ="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[3]";
	//public static final String VendorDetails_contact_Android ="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[4]";
	//public static final String VendorDetails_email_Android ="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[5]";
			
	//public static final String VendorDetails_note_Android ="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[6]";
				
	
	
	
	

	public VendorPage verifySupplierPage(String string) throws InterruptedException {
		Reporter.log("Verify the Supplier Page");

		waitForElementToBeClickable(VendorsPage);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage Add_Supplier(String string) throws InterruptedException, IOException {
			String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		try {
			waitForElementToBeClickable(ADD_Vendor);

			if (isElementPresent(ADD_Vendor)) {
				Reporter.log("clickElement on ADD Vendor Button");
				clickElement(ADD_Vendor);

			}

			waitForElementToBeClickable(ADD_VendorPage);

			if (isElementPresent(ADD_VendorPage)) {
				Reporter.log("Add vendor button clickElement :Pass");

			}
		}

		catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("Add vendor button clickElement :Fail");
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public VendorPage TapOnDone(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

			String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		try {
			
			waitForElementToBeClickable(DoneWeb);
			if (isElementPresent(DoneWeb)) {

				clickElement(DoneWeb);
				waitForElement(9);
				Reporter.log("Tapped on done:Pass");

			}
		

		} catch (Exception e) {
			switchToNativeContext();
			Reporter.log("Tapped on done :Fail");
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage TapOnBack(String string) throws InterruptedException, IOException {
			String string2 = "Issue";

			String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		try {
			waitForElementToBeClickable(Back);
			if (isElementPresent(Back)) {

				clickElement(Back);
				Reporter.log("tap on back :Pass");
			}

		} catch (Exception e) {
			switchToNativeContext();
			Reporter.log("tap on back :Fail");
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage SupplierSelect(String name, String string) throws InterruptedException, IOException {

			String string2 = "Issue";
	String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		try {

			String vendorName = name;
			switchToNativeContext();

			final String VD_Vendorname = 
					"//android.widget.CheckedTextView[contains(@text,'" + vendorName
							+ "')]";
			waitForElementToBeClickable(VD_Vendorname);
			clickElement(VD_Vendorname);
			
			switchToWebContext();

			Reporter.log("Vendor is selected for item :Pass");
		}

		catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("Vendor is selected for item   :Fail");
					
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public VendorPage SuppliersList(String vendorname, String string) throws InterruptedException, IOException {
		String string2 = "Issue";

			String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		try {

			String y = vendorname;

			boolean c = driver.getPageSource().contains(y);

			if (c == true) {

				Reporter.log("Added  vendor is listed :Pass");
			} else {
				Reporter.log("Added  vendor is listed :Fail");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			switchToNativeContext();
			Assert.assertTrue(false);
			Reporter.log("Added new vendor is listed   :Fail");
			takeScreenshot(finalPath1);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage Supplier_List(String string) {

		try {

			isElementPresent(ADD_Vendor);
			isElementPresent(Back);

			Reporter.log("Vendor list is displayed :Pass");

		}

		catch (Exception e) {
			switchToNativeContext();

			Reporter.log("Vendor list is displayed :Fail");
			Assert.assertTrue(false);
		}

		return this;
	}

/*	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public VendorPage ViewSupplierDetails(String name, String number,
			String address, String contactinfo, String email, String note,
			String string) throws InterruptedException, IOException {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = Screenshot.drivePath + string + string1
				+ Screenshot.pathExtension;
		String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;
		try {

			switchToNativeContext();

			if (isElementPresent(VendorDetails_name)) {

				Name = getElementText(VendorDetails_name);
			
				if (Name.equals(name)) {
					Reporter.log("view vendor name :Pass");
				}
			}

			if (isElementPresent(VendorDetails_number)) {

				String Num = getElementText(VendorDetails_number);
				if (Num.equals(number)) {
					Reporter.log("view vendor no   :Pass");
				}
			}

			if (isElementPresent(VendorDetails_address)) {

				String Address = getElementText(VendorDetails_address);
				if (Address.equals(address)) {
					Reporter.log("view vendor Address   :Pass");
							
				}
			}

			if (isElementPresent(VendorDetails_contact)) {

				String Contact = getElementText(VendorDetails_contact);
				if (Contact.equals(contactinfo)) {
					Reporter.log("view vendor Contact   :Pass");
							
				}
			}

			if (isElementPresent(VendorDetails_email)) {

				String Email = getElementText(VendorDetails_email);
				if (Email.equals(email)) {
					Reporter.log("view vendor Email   :Pass");
				}
			}

			if (isElementPresent(VendorDetails_note)) {

				String Note = getElementText(VendorDetails_note);
				if (Note.equals(note)) {
					Reporter.log("view vendor Note  :Pass");
				}
			}

		
			Reporter.log("view vendor detail   :Pass");
			switchToWebContext();
		} catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("view vendor detail  :Fail");
			Assert.assertTrue(false);
		}

		return this;
	}
	*/
	
	public VendorPage ViewSupplierDetails(String name, String number,
			String address, String contactinfo, String email, String note,
			String string) throws InterruptedException, IOException {
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = Screenshot.drivePath + string + string1
				+ Screenshot.pathExtension;
		String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;
		try {

			switchToNativeContext();

			if (isElementPresent(VendorDetails_name_Android)) {

				Name = getElementText(VendorDetails_name_Android);
			
				if (Name.equals(name)) {
					Reporter.log("view vendor name :Pass");
				}else{
					throw new Exception("view vendor name :Fail");
				}
			}

			if (isElementPresent(VendorDetails_number_Android)) {

				String Num = getElementText(VendorDetails_number_Android);
				if (Num.equals(number)) {
					Reporter.log("view vendor no   :Pass");
				}
				else{
					throw new Exception("view vendor no :Fail");
				}
			}

			if (isElementPresent(VendorDetails_address_Android)) {

				String Address = getElementText(VendorDetails_address_Android);
				if (Address.equals(address)) {
					Reporter.log("view vendor Address   :Pass");
							
				}
				else{
					throw new Exception("view vendor Address :Fail");
				}
			}

			if (isElementPresent(VendorDetails_contact_Android)) {

				String Contact = getElementText(VendorDetails_contact_Android);
				if (Contact.equals(contactinfo)) {
					Reporter.log("view vendor Contact   :Pass");
							
				}else{
					throw new Exception("view vendor Contact :Fail");
				}
			}

			if (isElementPresent(VendorDetails_email_Android)) {

				String Email = getElementText(VendorDetails_email_Android);
				if (Email.equals(email)) {
					Reporter.log("view vendor Email   :Pass");
				}
				else{
					throw new Exception("view vendor Email :Fail");
				}
			}

			if (isElementPresent(VendorDetails_note_Android)) {

				String Note = getElementText(VendorDetails_note_Android);
				if (Note.equals(note)) {
					Reporter.log("view vendor Note  :Pass");
				}
				else{
					throw new Exception("view vendor Note :Fail");
				}
			}

		
			Reporter.log("view vendor detail   :Pass");
			switchToWebContext();

		} catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("view vendor detail  :Fail");
			Assert.assertTrue(false);
		}

		return this;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public VendorPage DeleteSupplier(String string) throws InterruptedException, IOException {

		Reporter.log("Delete a vendor");
		String string1 = "Success";
		String string2 = "Issue";

		String finalPath = Screenshot.drivePath + string + string1
				+ Screenshot.pathExtension;
		String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;
		try {
			
			waitForElementToBeClickable(ADD_VendorDelete);
			if (isElementPresent(ADD_VendorDelete)) {

				clickElement(ADD_VendorDelete);

			}

			waitForElementToBeClickable(Delete_Yes);
			if (isElementPresent(Delete_Yes)) {

				clickElement(Delete_Yes);

			}

			Reporter.log("Deleting vender :Pass");
			

			
		}

		catch (Exception e) {
			switchToNativeContext();
			Reporter.log("Deleting vender :Fail");
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);

		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage TapOnEdit(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		try {
			waitForElementToBeClickable(Edit);
			if (isElementPresent(Edit)) {

				clickElement(Edit);

				Reporter.log("tap on Edit :Pass");
			}

		} catch (Exception e) {
			switchToNativeContext();
			Reporter.log("tap on Edit :Fail");
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage VerifyDeletedSupplier(String name, String string) throws InterruptedException, IOException {

			String string2 = "Issue";

			String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		Reporter.log("Selecting vendor");
		try {

			String vendorName = name;
			System.out.println(vendorName);

			waitFor(2);

			final String VD_Vendorname = 
					"//*[@id='list-item']//*[contains(text(),'" + vendorName
							+ "')]";

			Boolean flag = isElementPresent(VD_Vendorname);
			if ((flag)) {
				throw new Exception();
			}

			else
				System.out.println("Deleted supplier is not listed on supplier page :Pass");
				Reporter.log("Deleted supplier is not listed on supplier page :Pass");
					

		}

		catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("Deleted supplier is not listed on supplier page :Fail");
					
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public VendorPage SupplierCancelledVerify(String name, String string) throws InterruptedException, IOException {

		String string2 = "Issue";

			String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		Reporter.log("Searching for cancelled supplier");
		try {

			String vendorName = name;
			System.out.println(vendorName);

			final String VD_Vendorname = 
					"//*[@id='list-item']//*[contains(text(),'" + vendorName
							+ "')]";

			waitFor(6);
			if (isElementPresent(VD_Vendorname)) {
				throw new Exception();
			}

			Reporter.log("Supplier which was cancelleld is not present: Pass");
				
		}

		catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("Supplier which was cancelleld is not present: Fail");
				
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public VendorPage AddSupplier_Details(String name, String number,
			String address, String contactinfo, String email, String note,
			String string) throws InterruptedException, IOException {
		String string2 = "Issue";

			String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;
		Reporter.log("Adding vendor details");
		try {

			waitForElementToBeClickable(ADD_VendorNameLabel);
			waitForElementToBeClickable(ADD_VendorName);
			clickElement(ADD_VendorName);
			if (isElementPresent(ADD_VendorName)) {
				clearElement(ADD_VendorName);
				sendText(ADD_VendorName, name);

			}
			waitForElementToBeClickable(ADD_VendorNumberLabel);
			if (isElementPresent(ADD_VendorNumber)) {
				clickElement(ADD_VendorNumber);
				clearElement(ADD_VendorNumber);
				sendText(ADD_VendorNumber, number);

			}
			waitForElementToBeClickable(ADD_VendorAddressLabel);
			if (isElementPresent(ADD_VendorAddress)) {
				clickElement(ADD_VendorAddress);
				clearElement(ADD_VendorAddress);
				sendText(ADD_VendorAddress, address);

			}
			waitForElementToBeClickable(ADD_VendorContactInfoLabel);
			if (isElementPresent(ADD_VendorContactInfo)) {
				clickElement(ADD_VendorContactInfo);
				clearElement(ADD_VendorContactInfo);
				sendText(ADD_VendorContactInfo, contactinfo);

			}
			waitForElementToBeClickable(ADD_VendorEmailLabel);
			if (isElementPresent(ADD_VendorEmail)) {
				clickElement(ADD_VendorEmail);
				clearElement(ADD_VendorEmail);
				sendText(ADD_VendorEmail, email);

			}
			waitForElementToBeClickable(ADD_VendorNoteLabel);
			if (isElementPresent(ADD_VendorNote)) {
				clickElement(ADD_VendorNote);
				clearElement(ADD_VendorNote);
				sendText(ADD_VendorNote, note);
				waitFor(5);

			}

			Reporter.log("Vendor details entered  :Pass");

		} catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("Vendor details entered  :Fail");
			Assert.assertTrue(false);
		}

		return this;

	}

	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public VendorPage TapOnCancel(String string) throws InterruptedException, IOException {
		String string2 = "Issue";

		String finalPath1 = Screenshot.drivePath + string + string2
				+ Screenshot.pathExtension;

		try {
		
			waitForElementToBeClickable(Cancel);
			if (isElementPresent(Cancel)) {

				clickElement(Cancel);
				Reporter.log("Tapped on Cancel");

			}
		
		} catch (Exception e) {
			switchToNativeContext();
			Reporter.log("Tapped on Cancel :Fail");
			takeScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}
}
