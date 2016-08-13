		
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

import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.Reporter;

import com.sysco.jsn_framework.JSN_Framework;
import com.sysco.locators.Screenshot;
public class PurchasesPage extends JSN_Framework {
	private static final Logger LOGGER= Logger.getLogger(PurchasesPage.class.getCanonicalName());
	public static final String Purchases_Add = 
			"//*[@id='add-nav']/a/i";
	public static final String Purchases_Back = 
			"//*[@id='back-nav']";
	public static final String PurchasesDetails_Done = 
			"//*[@id='done-nav']";
/*	public static final String PurchasesDetails_Supplier = 
			 "//*[@id='supplier']";*/
	public static final String PurchasesPage =
			"//*[@class='navbar-brand']//*[contains(text(),'Purchases')]";
	public static final String PurchasesDetails_Supplier = 
			 "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.Spinner[1]";
	public static final String PurchasesDetails_SupplierSelect = 
			"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.CheckedTextView[2]";

/*
	public static final String PurchasesDetails_Date ="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]";
	public static final String PurchasesDetails_Day = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAPicker[1]/UIAPickerWheel[1]";
	public static final String PurchasesDetails_Month = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAPicker[1]/UIAPickerWheel[2]";
	public static final String PurchasesDetails_Year = "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAPicker[1]/UIAPickerWheel[3]";
*/
	

	public static final String PurchasesDetails_Date = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.Spinner[2]";
	public static final String PurchasesDetails_Day = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]";
	public static final String PurchasesDetails_Month = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]";
	public static final String PurchasesDetails_Year = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText[1]";
	public static final String PurchasesDetails_Set ="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]";


	public static final String PurchasesDetails_InvoiceNumber = "//*[@id='invoice-number']";
	public static final String PurchasesDetails_InvoiceTotal = "//*[@id='invoice-total']";
	public static final String PurchasesDetails_ExpenseAmount = "//*[@id='expense-amount']";
	public static final String PurchasesDetails_ExpenseCategory = "//*[@id='expense-category']";
	public static final String Done= "//UIAStaticText[@label='Done']"; 
	public static final String DoneWeb = "//*[@id='done-nav/a']";

	public static final String PurchasesDetails_AddExpenseCategory = "//*[@class='mm-o-icon icon-plus-circle']";
	public static final String PurchasesBack ="//*[@class='mm-c-purchases__header']//*[@id='back']//*[@class='mm-o-icon icon-arrow-left']";

	public static final String PurchasesFwd = "//*[@class='mm-c-purchases__header']//*[@id='forward']//*[@class='mm-o-icon icon-arrow-right']";

	public static final String YesAddPurchase = 
			"//*[@class='modal-content']//*[@id='yes-button']";
			
	public static final String NoAddPurchase = 
			"//*[@class='modal-content']//*[@id='no-button']";
			

	/* Functions on the Page are defined below */


	@SuppressWarnings("rawtypes")
	public PurchasesPage AddPurchases(String string) throws InterruptedException, IOException {

		String string2 = "Issue";
		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;
	

		try {

			waitForElementToBeClickable(PurchasesPage);


			clickElement(Purchases_Add);
			waitForElementToBeClickable(PurchasesDetails_Done);

			Reporter.log("Tapped  Add purchases :Pass");


		} catch (Exception e) {
			switchToNativeContext();
			takeScreenshot(finalPath1);
			Reporter.log("Tapped  Add purchases :Fail");
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public PurchasesPage SupplierSelect(String string) throws InterruptedException, IOException {

		Reporter.log("Creating purchases  ");
		String string2 = "Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;
				

		try {
			switchToNativeContext();
			waitForElementToBeClickable(PurchasesDetails_Supplier);

			clickElement(PurchasesDetails_Supplier);
			waitForElementToBeClickable(PurchasesDetails_SupplierSelect);
			clickElement(PurchasesDetails_SupplierSelect);

			Reporter.log("Selected  vendor:Pass");

			switchToWebContext();

		} catch (Exception e) {
			Reporter.log("Selected  vendor:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	///
	public  PurchasesPage DateSelect(String day, String month, String year,String string) throws InterruptedException, IOException{

		Reporter.log("Date selection on purchases ");

		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			switchToNativeContext();
			waitForElementToBeClickable(PurchasesDetails_Date);

			clickElement(PurchasesDetails_Date);
			/*sendText(PurchasesDetails_Day, day);
			sendText(PurchasesDetails_Month, month);
			sendText(PurchasesDetails_Year, year);*/
			clickElement(PurchasesDetails_Set);
			
			Reporter.log("Selected  Date:Pass");	

			switchToWebContext();

		}
		catch(Exception e){
			Reporter.log("Selected  date :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);



		}

		return this;

	}
	public  PurchasesPage ExpenseCategorySelect(String category,String string) throws InterruptedException, IOException{

		Reporter.log("Expense category selection on purchases  ");
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			waitForElementToBeClickable(PurchasesDetails_ExpenseCategory);

			selectDropDownByValue(PurchasesDetails_ExpenseCategory,category);


			Reporter.log("Selected  category:Pass");						


		}
		catch(Exception e){
			Reporter.log("Selected category:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}

	public  PurchasesPage PurchaseDetails(String number,String total,String string) throws InterruptedException, IOException{

		Reporter.log("Enter purchase details  ");
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{

			waitForElementToBeClickable(PurchasesDetails_InvoiceNumber);

			sendText(PurchasesDetails_InvoiceNumber,number);

			waitForElementToBeClickable(PurchasesDetails_InvoiceTotal);

			sendText(PurchasesDetails_InvoiceTotal,total);

		/*	waitForElementToBeClickable(PurchasesDetails_ExpenseAmount);

			sendText(PurchasesDetails_ExpenseAmount,amount);
*/

			Reporter.log("Purchase details enterd:Pass");						


		}
		catch(Exception e){
			Reporter.log("Purchase details enterd:Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}

	public PurchasesPage TapOnDone(String string) throws InterruptedException, IOException{
		String string2="Issue";

			String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{

			
			waitForElementToBeClickable(DoneWeb);
		
			
			clickElement(DoneWeb);
			
			Reporter.log("Tapped on done:Pass");
			
			


		}
		catch(Exception e)
		{
			Reporter.log("Tapped on done :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
		
			
			
			Assert.assertTrue(false);
		}

		return this;
	}
	public  PurchasesPage EnterExpenseAmount(String number,String string) throws InterruptedException, IOException{

		Reporter.log("Enter expense amount details  ");
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{

			waitForElementToBeClickable(PurchasesDetails_ExpenseAmount);


			sendText(PurchasesDetails_ExpenseAmount,number);




			Reporter.log("Enter expense amount :Pass");						


		}
		catch(Exception e){
			Reporter.log("Enter expense amount :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	public  PurchasesPage AddExpenseCategory(String string) throws InterruptedException, IOException{

		Reporter.log("Tapping Add other Expense category");
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			waitForElementToBeClickable(PurchasesDetails_AddExpenseCategory); 

			clickElement(PurchasesDetails_AddExpenseCategory);

			Reporter.log("Tapped Add other Expense category :Pass");						


		}
		catch(Exception e){
			Reporter.log("Tapped Add other Expense category :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	public  PurchasesPage TapNoAddingPurchase(String string) throws InterruptedException, IOException{

		Reporter.log("Tapping Not to add anymore purchase");
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			waitForElementToBeClickable(NoAddPurchase); 

			clickElement(NoAddPurchase);

			waitFor(10);
			Reporter.log("Tapped No on Adding other Purchase :Pass");						


		}
		catch(Exception e){
			Reporter.log("Tapped No on Adding other Purchase :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public PurchasesPage ViewPurchasesForward(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;
				

		try {

			waitForElementToBeClickable(PurchasesFwd);


			clickElement(PurchasesFwd);
			
			
			Reporter.log("Tapped  Right arrow purchases :Pass");


		} catch (Exception e) {
			Reporter.log("Tapped  Right arrow purchases :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public PurchasesPage ViewPurchasesBack(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;
				

		try {

			waitForElementToBeClickable(PurchasesBack);


			clickElement(PurchasesBack);
			
			
			Reporter.log("Tapped  Left arrow purchases :Pass");


		} catch (Exception e) {
			Reporter.log("Tapped  Left arrow purchases :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public PurchasesPage VerifyPurchaseAdded(String string) throws InterruptedException, IOException {

		String string2 = "Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;
				

		try {

			waitForElementToBeClickable(PurchasesBack);


			clickElement(PurchasesBack);
			
			
			Reporter.log("Tapped  Left arrow purchases :Pass");


		} catch (Exception e) {
			Reporter.log("Tapped  Left arrow purchases :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	
}
