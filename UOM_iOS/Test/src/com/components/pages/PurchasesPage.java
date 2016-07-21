
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
package com.components.pages;

import java.util.Set;

import io.appium.java_client.ios.IOSDriver;



import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class PurchasesPage extends SitePage {

	public static final Target Purchases_Add = new Target("InvToolsPage",
			"//*[@id='add-nav']/a/i", Target.XPATH);
	public static final Target Purchases_Back = new Target("InvToolsPage",
			"//*[@id='back-nav']", Target.XPATH);
	public static final Target PurchasesDetails_Done = new Target(
			"InvToolsPage", "//*[@id='done-nav']", Target.XPATH);
	//	public static final Target PurchasesDetails_Supplier = new Target("InvToolsPage", "//*[@id='supplier']", Target.XPATH);
	public static final Target PurchasesPage = new Target("InvToolsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Purchases')]",
			Target.XPATH);

	//public static final Target PurchasesDetails_Date = new Target("InvToolsPage","//*[@class='form-control']//*[@id='date']//*[@type='date']",Target.XPATH);
	public static final Target PurchasesDetails_Supplier = new Target(
			"InvToolsPage", "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]", Target.XPATH);
	public static final Target PurchasesDetails_SupplierSelect = new Target(
			"InvToolsPage", "//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]", Target.XPATH);


	public static final Target PurchasesDetails_Date = new Target("InvToolsPage","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]",Target.XPATH);
	public static final Target PurchasesDetails_Day = new Target("InvToolsPage","//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAPicker[1]/UIAPickerWheel[1]",Target.XPATH);
	public static final Target PurchasesDetails_Month = new Target("InvToolsPage","//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAPicker[1]/UIAPickerWheel[2]",Target.XPATH);
	public static final Target PurchasesDetails_Year = new Target("InvToolsPage","//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAPicker[1]/UIAPickerWheel[3]",Target.XPATH);


	public static final Target PurchasesDetails_InvoiceNumber = new Target("InvToolsPage","//*[@id='invoice-number']",Target.XPATH);
	public static final Target PurchasesDetails_InvoiceTotal = new Target("InvToolsPage","//*[@id='invoice-total']",Target.XPATH);
	public static final Target PurchasesDetails_ExpenseAmount = new Target("InvToolsPage","//*[@id='expense-amount']",Target.XPATH);
	public static final Target PurchasesDetails_ExpenseCategory = new Target("InvToolsPage","//*[@id='expense-category']",Target.XPATH);
	public static final Target Done= new Target("Done","//UIAStaticText[@label='Done']",Target.XPATH); 
	public static final Target DoneWeb = new Target("Continue","//*[@id='done-nav/a']",Target.XPATH);

	public static final Target PurchasesDetails_AddExpenseCategory = new Target("InvToolsPage","//*[@class='mm-o-icon icon-plus-circle']",Target.XPATH);

	
	

	public static final Target YesAddPurchase = new Target("InvToolsPage",
			"//*[contains(text(),'Yes, add a new purchase')]",
			Target.XPATH);
	public static final Target NoAddPurchase = new Target("InvToolsPage",
			"//*[contains(text(),'No, I'm done')]",
			Target.XPATH);
	//Purchase added successfully
	//Would you like to add another purchase?
	
	HomePage homepage = new HomePage(repository);

	public PurchasesPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public PurchasesPage atPurchasesPage() {
		log("In Purchases page", LogType.STEP);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public PurchasesPage AddPurchases(String string) {

		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(PurchasesPage);


			getCommand().click(Purchases_Add);
			getCommand().waitForTargetPresent(PurchasesDetails_Done);

			log("Tapped  Add purchases :Pass", LogType.VERIFICATION_STEP);


		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped  Add purchases :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public PurchasesPage SupplierSelect(String string) {

		log("Creating purchases  ", LogType.STEP);
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().waitForTargetPresent(PurchasesDetails_Supplier);

			getCommand().click(PurchasesDetails_Supplier);
			getCommand().waitForTargetPresent(PurchasesDetails_SupplierSelect);
			getCommand().click(PurchasesDetails_SupplierSelect);

			log("Selected  vendor:Pass", LogType.VERIFICATION_STEP);

			Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
			System.out.println("contxtname is "+contextNames1);

			for (String contextName : contextNames1){
				System.out.println("inside loop "+contextNames1);
			}
			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));


		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected  vendor:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	///
	public  PurchasesPage DateSelect(String string){

		log("Date selection on purchases ",LogType.STEP);

		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().waitForTargetPresent(PurchasesDetails_Date);

			getCommand().click(PurchasesDetails_Date);
			getCommand().sendKeys(PurchasesDetails_Day, "19");
			getCommand().sendKeys(PurchasesDetails_Month, "June");
			getCommand().sendKeys(PurchasesDetails_Year, "2016");

			log("Selected  Date:Pass",LogType.VERIFICATION_STEP);	

			Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
			System.out.println("contxtname is "+contextNames1);

			for (String contextName : contextNames1){
				System.out.println("inside loop "+contextNames1);
			}
			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));


		}
		catch(Exception e){
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected  date :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);



		}

		return this;

	}
	public  PurchasesPage ExpenseCategorySelect(String category,String string){

		log("Expense category selection on purchases  ",LogType.STEP);
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			getCommand().waitForTargetPresent(PurchasesDetails_ExpenseCategory);

			getCommand().selectDropDown(PurchasesDetails_ExpenseCategory,category);


			log("Selected  category:Pass",LogType.VERIFICATION_STEP);						


		}
		catch(Exception e){
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected category:Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	public  PurchasesPage PurchaseDetails(String number,String total,String string){

		log("Enter purchase details  ",LogType.STEP);
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{

			getCommand().waitForTargetPresent(PurchasesDetails_InvoiceNumber);

			getCommand().sendKeys(PurchasesDetails_InvoiceNumber,number);

			getCommand().waitForTargetPresent(PurchasesDetails_InvoiceTotal);

			getCommand().sendKeys(PurchasesDetails_InvoiceTotal,total);

		/*	getCommand().waitForTargetPresent(PurchasesDetails_ExpenseAmount);

			getCommand().sendKeys(PurchasesDetails_ExpenseAmount,amount);
*/

			log("Purchase details enterd:Pass",LogType.VERIFICATION_STEP);						


		}
		catch(Exception e){
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Purchase details enterd:Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	public PurchasesPage TapOnDone(String string){
		String string2="Issue";

			String finalPath1=drivePath+string+string2+pathExtension;

		try{

			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().waitForTargetPresent(Done);
		
			
			getCommand().click(Done);
			
			log("Tapped on done:Pass",LogType.VERIFICATION_STEP);
			
			Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
     		System.out.println("contxtname is "+contextNames1);
     		
     		 for (String contextName : contextNames1){
     			 System.out.println("inside loop "+contextNames1);
     		 }
     	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
     


		}
		catch(Exception e)
		{
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			log("Tapped on done :Fail",LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}
	public  PurchasesPage EnterExpenseAmount(String number,String string){

		log("Enter expense amount details  ",LogType.STEP);
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{

			getCommand().waitForTargetPresent(PurchasesDetails_ExpenseAmount);


			getCommand().sendKeys(PurchasesDetails_ExpenseAmount,number);




			log("Enter expense amount :Pass",LogType.VERIFICATION_STEP);						


		}
		catch(Exception e){
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Enter expense amount :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	public  PurchasesPage AddExpenseCategory(String string){

		log("Tapping Add other Expense category",LogType.STEP);
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			getCommand().waitForTargetPresent(PurchasesDetails_AddExpenseCategory); 

			getCommand().click(PurchasesDetails_AddExpenseCategory);

			log("Tapped Add other Expense category :Pass",LogType.VERIFICATION_STEP);						


		}
		catch(Exception e){
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped Add other Expense category :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	public  PurchasesPage TapNoAddingPurchase(String string){

		log("Tapping Add other Expense category",LogType.STEP);
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			getCommand().waitForTargetPresent(NoAddPurchase); 

			getCommand().click(NoAddPurchase);

			getCommand().waitFor(10);
			log("Tapped No on Adding other Purchase :Pass",LogType.VERIFICATION_STEP);						


		}
		catch(Exception e){
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped No on Adding other Purchase :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
}
