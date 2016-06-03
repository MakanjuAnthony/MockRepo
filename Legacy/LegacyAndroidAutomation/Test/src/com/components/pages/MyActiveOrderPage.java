
package com.components.pages;

import java.util.Set;


import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;


import io.appium.java_client.android.AndroidDriver;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;


public class MyActiveOrderPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target MyActiveOrder_title = new Target("MyActiveOrder_title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target MyActiveOrder_title = new Target("MyActiveOrder_title","My Active Order",Target.NAME);

	
	
//	submit order in My Active Order Page   //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[17]
//	alert close   //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]
//	alert xxxxx //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]
	
//	public static final Target myActiveOrder_SubmitOrder=new Target("myActiveOrder_SubmitOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[17]",Target.XPATH);
//	  public static final Target myActiveOrder_SubmitOrder = new Target("myActiveOrder_SubmitOrder","Submit Order",Target.NAME);
	public static final Target myActiveOrder_SubmitOrder = new Target("myActiveOrder_SubmitOrder","//*[@class='main-content']//*[@class='page-body']//*[@class='button']//*[@class='submit-order']",Target.XPATH);
	
	public static final Target myActiveOrder_DeletetOrder=new Target("myActiveOrder_DeletetOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[18]",Target.XPATH);
	  //public static final Target myActiveOrder_DeletetOrder = new Target("myActiveOrder_DeletetOrder","Delete Order",Target.NAME);
	
	public static final Target myActiveOrder_Qty=new Target("myActiveOrder_Qty","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[13]",Target.XPATH);
	  //public static final Target myActiveOrder_Qty = new Target("myActiveOrder_Qty","1",Target.NAME);
																		
//	public static final Target myActiveOrder_AddMoreItems=new Target("myActiveOrder_AddMoreItems","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[7]",Target.XPATH);
	  //public static final Target myActiveOrder_AddMoreItems = new Target("myActiveOrder_AddMoreItems","• ",Target.NAME);
	public static final Target myActiveOrder_AddMoreItems=new Target("myActiveOrder_AddMoreItems","//*[@id='addMoreItems']//*[@class='button']",Target.XPATH);
	public static final Target myActiveOrder_MoreInfo=new Target("myActiveOrder_MoreInfo","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[10]",Target.XPATH);
	  //public static final Target myActiveOrder_MoreInfo = new Target("myActiveOrder_MoreInfo","MORE INFO ",Target.NAME);
	
//	Delete Order
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[18]
	public static final Target myActiveOrder_DeleteOrder=new Target("myActiveOrder_DeleteOrder","//*[@class='delete-order']",Target.XPATH);
//	public static final Target myActiveOrder_DeleteOrder=new Target("myActiveOrder_DeleteOrder","Delete Order",Target.NAME);
	
	 
	
	
	
	
	
	
	
//	public static final Target myActiveOrder_CloseAlert=new Target("myActiveOrder_CloseAlert","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
//	public static final Target myActiveOrder_CloseAlert=new Target("myActiveOrder_CloseAlert","Close",Target.NAME);
	public static final Target myActiveOrder_CloseAlert=new Target("myActiveOrder_CloseAlert","//*[@class='modal']//*[@class='footer']//*[@class='btn close']",Target.XPATH);
	
	//*[@class='modal']//*[@class='footer']//*[@class='btn close']
	
	public static final Target myActiveOrder_PleaseConfirmPop_OK=new Target("myActiveOrder_PleaseConfirmPop_OK","//*[@class='buttons']//*[@class='btn confirm']",Target.XPATH);
//	public static final Target myActiveOrder_PleaseConfirmPop_OK=new Target("myActiveOrder_PleaseConfirmPop_OK","OK",Target.NAME);
	
	public static final Target myActiveOrder_PleaseConfirmPop_Cancel=new Target("myActiveOrder_PleaseConfirmPop_Cancel","//*[@class='btn close']",Target.XPATH);
//	public static final Target myActiveOrder_PleaseConfirmPop_Cancel=new Target("myActiveOrder_PleaseConfirmPop_Cancel","Cancel",Target.NAME);
	
	
	public static final Target myActiveOrder_NonCancelablePopup_Continue=new Target("myActiveOrder_NonCancelablePopup_Continue","//*[@class='btn continue']",Target.XPATH);
	//public static final Target myActiveOrder_NonCancelablePopup_Continue=new Target("myActiveOrder_NonCancelablePopup_Continue","Cancel",Target.NAME);
	
	public static final Target myActiveOrder_NonCancelablePopup_Cancel=new Target("myActiveOrder_NonCancelablePopup_Continue","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",Target.XPATH);
	//public static final Target myActiveOrder_NonCancelablePopup_Cancel=new Target("myActiveOrder_NonCancelablePopup_Continue","Cancel",Target.NAME);
	
	public static final Target myActiveOrder_Close_Alert=new Target("myActiveOrder_Close_Alert","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[3]",Target.XPATH);
	//public static final Target myActiveOrder_Close_Alert=new Target("myActiveOrder_Close_Alert","Close",Target.NAME);//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[3]

	
	               //************** -Apr 12 ***************-//
	
		//------------Elements in MyActive order page while login as MA-------------
		
	//public static final Target myActiveOrder_Approve=new Target("myActiveOrder_Approve","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[5]",Target.XPATH);
	 //public static final Target myActiveOrder_Approve = new Target("myActiveOrder_Approve","Approve",Target.NAME);
	 public static final Target myActiveOrder_Approve = new Target("myActiveOrder_Approve","//*[@class='main-content']//*[@class='page-body']//*[@class='button']//*[@class='submit-order']",Target.XPATH);
	 
	
			
	//public static final Target myActiveOrder_Reject=new Target("myActiveOrder_Reject","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[6]",Target.XPATH);
	 //public static final Target myActiveOrder_Reject = new Target("myActiveOrder_Reject","Reject",Target.NAME);
	 public static final Target myActiveOrder_Reject = new Target("myActiveOrder_Reject","//*[@class='main-content']//*[@class='page-body']//*[@class='button']//*[@class='reject-order']",Target.XPATH);
	 
	//*[@class='main-content']//*[@class='page-body']//*[@class='button']//*[@class='reject-order']
	 
	 
			
	 public static final Target myActiveOrder_AddMoreItems_MA=new Target("myActiveOrder_AddMoreItems_MA","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[18]",Target.XPATH);
	//public static final Target myActiveOrder_AddMoreItems_MA = new Target("myActiveOrder_DeletetOrder","Delete Order",Target.NAME);
			
		
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	
	public MyActiveOrderPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public MyActiveOrderPage atOrderGuide()
	{
		log("At MyActiveOrderPagee",LogType.STEP);
		return this;
		
	}

	
	public MyActiveOrderPage verifyMyActiveOrderPage()
	{
		log("Verify the MyActiveOrderPage",LogType.STEP);
		getCommand().waitForTargetPresent(MyActiveOrder_title);
		return this;
	}
	
	
/*	public MyActiveOrderPage myActiveOrder_AddMoreItems()
	{
		//System.out.println("at myActiveOrder_AddMoreItems");
	log("at My active order",LogType.STEP);
	getCommand().waitForTargetPresent(myActiveOrder_MoreInfo);
	if (getCommand().isTargetPresent(myActiveOrder_MoreInfo))
	{
			//System.out.println("inside myActiveOrder_MoreInfo ...");
		getCommand().click(myActiveOrder_MoreInfo);
		
		log("Clicked on myActiveOrder_MoreInfo : Pass",LogType.STEP);			
	}
	getCommand().waitForTargetPresent(myActiveOrder_AddMoreItems);
	if (getCommand().isTargetPresent(myActiveOrder_AddMoreItems))
	{
			//System.out.println("inside myActiveOrder_AddMoreItems ....");
		getCommand().click(myActiveOrder_AddMoreItems);
		
		log("Clicked on My Active order Sumbit button: Pass",LogType.STEP);			
	}
	
	return this;
}
	*/
	
	
	
	
	public MyActiveOrderPage myActiveOrder_SubmitOrder(String string)
	{
		
		Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
		System.out.println(contextNames);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
		//System.out.println("at myActiveOrder_SubmitOrder");
	log("at My active order",LogType.STEP);
	getCommand().waitFor(10);
	getCommand().waitForTargetPresent(myActiveOrder_SubmitOrder,5);
	
	
		getCommand().waitFor(5);
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		getCommand().captureScreenshot(finalPath);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			//System.out.println("inside if loop");
		getCommand().click(myActiveOrder_SubmitOrder);
		log("Clicked on My Active order Submit button: Pass",LogType.STEP);			

	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
	getCommand().waitFor(5);
		
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "myActiveOrder_SubmitOrder:Fail");
		}
	return this;
}
	public MyActiveOrderPage myActiveOrder_alertClose()
	{Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
	System.out.println(contextNames);
	((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	
		try{
	getCommand().waitFor(5);	
	getCommand().waitForTargetPresent(myActiveOrder_CloseAlert);
	getCommand().click(myActiveOrder_CloseAlert);
	log("Alert closed: Pass",LogType.STEP);	
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
	getCommand().waitFor(10);
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"myActiveOrder_alertClose"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "myActiveOrder_alertClose:Fail");
		}
	return this;
}	
	
	
	public MyActiveOrderPage myActiveOrder_DeleteOrderButtonCheck()
	{
		try{
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(myActiveOrder_DeleteOrder);
	//System.out.println("Delete Button Present");
	log("Delete Button Present",LogType.STEP);	
	getCommand().click(myActiveOrder_DeleteOrder);
	getCommand().waitForTargetPresent(myActiveOrder_PleaseConfirmPop_OK);
	getCommand().click(myActiveOrder_PleaseConfirmPop_OK);
	log("Deleted : Pass",LogType.STEP);
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"myActiveOrder_DeleteOrderButtonCheck"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "myActiveOrder_DeleteOrderButtonCheck:Fail");
		}
	return this;
}	
	
	public MyActiveOrderPage myActiveOrder_AddMoreItems()
	{
		try{
			Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
		//System.out.println(contextNames);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
	//System.out.println("at myActiveOrder_AddMoreItems");
	log("at My active order",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(myActiveOrder_AddMoreItems);
	if (getCommand().isTargetPresent(myActiveOrder_AddMoreItems))
	{
			//System.out.println("inside myActiveOrder_AddMoreItems ....");
		getCommand().click(myActiveOrder_AddMoreItems);
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		getCommand().waitFor(10);

		log("Clicked on My Active order Sumbit button: Pass",LogType.STEP);			
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"myActiveOrder_AddMoreItems"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "myActiveOrder_AddMoreItems:Fail");
		}
	return this;
}
	
	
	public MyActiveOrderPage myActiveOrder_AddMoreItemsWithScreenshot(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		getCommand().captureScreenshot(finalPath);
		try{
			
			Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
			
		//System.out.println(contextNames);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
	//System.out.println("at myActiveOrder_AddMoreItems");
	log("at My active order",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(myActiveOrder_AddMoreItems);
	if (getCommand().isTargetPresent(myActiveOrder_AddMoreItems))
	{
			//System.out.println("inside myActiveOrder_AddMoreItems ....");
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		getCommand().captureScreenshot(finalPath);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().click(myActiveOrder_AddMoreItems);
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		getCommand().waitFor(10);

		log("Clicked on My Active order Add more items button: Pass",LogType.STEP);			
	}
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "myActiveOrder_AddMoreItems:Fail");
		}
	return this;
}
	
	
	
	
	public MyActiveOrderPage NonCancellableItems_Continue()
	{
		try{
		//System.out.println("at NonCancellableItems_Continue ");
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	log("at NonCancellableItems_Continue",LogType.STEP);
	getCommand().waitFor(10);
	getCommand().waitForTargetPresent(myActiveOrder_NonCancelablePopup_Continue);
	if (getCommand().isTargetPresent(myActiveOrder_NonCancelablePopup_Continue))
	{
			//System.out.println("inside Submitted_NonCancellableItems_Continue");
		getCommand().click(myActiveOrder_NonCancelablePopup_Continue);
		
		log("Clicked on SubmittedPage Submitted_NonCancellableItems_Continue button: Pass",LogType.STEP);
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"NonCancellableItems_Continue"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "NonCancellableItems_Continue:Fail");
		}
	
	return this;
	}
	public MyActiveOrderPage NonCancellableItems_Cancel()
	{
		try{
		//System.out.println("atNonCancellableItems_Cancell");
	log("atNonCancellableItems_Cancel",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(myActiveOrder_NonCancelablePopup_Cancel);
	if (getCommand().isTargetPresent(myActiveOrder_NonCancelablePopup_Cancel))
	{
			//System.out.println("inside Submitted_ModifyOrder_Cancel");
		getCommand().click(myActiveOrder_NonCancelablePopup_Cancel);
		
		log("Clicked on SubmittedPage NonCancellableItems_Cancel button: Pass",LogType.STEP);			
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"NonCancellableItems_Cancel"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "NonCancellableItems_Cancel:Fail");
		}
	return this;
	}
	public MyActiveOrderPage myActiveOrder_AddMoreItems_alertClose()
	{
	try{	
	getCommand().waitForTargetPresent(myActiveOrder_Close_Alert);
	getCommand().click(myActiveOrder_Close_Alert);
	}
	catch (Exception e) {
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		String finalPath1=drivePath+"myActiveOrder_AddMoreItems_alertClose"+"Fail"+pathExtension;
		getCommand().captureScreenshot(finalPath1);
		Assert.assertFalse(true, "myActiveOrder_AddMoreItems_alertClose:Fail");
	}
	return this;
}	
	
	
	//----------------------April 12 ------------------
		public MyActiveOrderPage myActiveOrder_Approve(String string)
		{String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
			try{
				
				((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
					//getCommand().captureScreenshot(finalPath);
			//System.out.println("at myActiveOrder_Approve");
		log("at My active order - Approve",LogType.STEP);
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(myActiveOrder_Approve);
		if (getCommand().isTargetPresent(myActiveOrder_Approve))
		{
				//System.out.println("inside myActiveOrder_Approve");
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(myActiveOrder_Approve);
			
			log("Clicked on My Active order Approve button: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
			}
			catch (Exception e) {
				((AndroidDriver) getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
				Assert.assertFalse(true, "myActiveOrder_Approve:Fail");
			}
		return this;
	}
		
		
		public MyActiveOrderPage myActiveOrder_Reject(String string)
		{String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
			try{
				
				//getCommand().captureScreenshot(finalPath);
				((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			//System.out.println("at myActiveOrder_Reject");
		log("at My active order",LogType.STEP);
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(myActiveOrder_Reject);
		if (getCommand().isTargetPresent(myActiveOrder_Reject))
		{
				//System.out.println("inside myActiveOrder_Reject");
			getCommand().click(myActiveOrder_Reject);
			
			log("Clicked on My Active order Reject  button: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
			}
			catch (Exception e) {
				((AndroidDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
				Assert.assertFalse(true, "myActiveOrder_Reject:Fail");
			}
		return this;
	}
		
		public MyActiveOrderPage PleaseConfirmAlert_OK(String string)
		{
			String string1="Success";
			String string2="Issue";
			String finalPath=drivePath+string+string1+pathExtension;
			String finalPath1=drivePath+string+string2+pathExtension;

			try{
				((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			//System.out.println("atmyActiveOrder_PleaseConfirmPop_OK");
		log("at myActiveOrder_PleaseConfirmPop",LogType.STEP);
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(myActiveOrder_PleaseConfirmPop_OK);
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		getCommand().captureScreenshot(finalPath);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		if (getCommand().isTargetPresent(myActiveOrder_PleaseConfirmPop_OK))
		{
			System.out.println("inside myActiveOrder_PleaseConfirmPop_OK");
			getCommand().click(myActiveOrder_PleaseConfirmPop_OK);
			
			log("Clicked on PleaseConfirmPop_Ok in My Active Order page: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
			}
			catch (Exception e) {
				((AndroidDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
				Assert.assertFalse(true, "PleaseConfirmAlert_OK:Fail");
			}
		return this;
		}
		
		
		public MyActiveOrderPage PleaseConfirmAlert_Cancel()
		{
			try{
			//System.out.println("atNonCancellableItems_Cancell");
		log("atNonCancellableItems_Cancel",LogType.STEP);
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(myActiveOrder_PleaseConfirmPop_Cancel);
		if (getCommand().isTargetPresent(myActiveOrder_PleaseConfirmPop_Cancel))
		{
				//System.out.println("inside myActiveOrder_PleaseConfirmPop_Cancel");
			getCommand().click(myActiveOrder_PleaseConfirmPop_Cancel);
			
			log("Clicked on PleaseConfirmPop_Cancel in My Active Order page : Pass",LogType.STEP);			
		}
			}
			catch (Exception e) {
				((AndroidDriver)getCommand().driver).context("NATIVE_APP");
				String finalPath1=drivePath+"PleaseConfirmAlert_Cancel"+"Fail"+pathExtension;
				getCommand().captureScreenshot(finalPath1);
				Assert.assertFalse(true, "PleaseConfirmAlert_Cancel:Fail");
			}
		return this;
		}

		
		public MyActiveOrderPage myActiveOrder_DeleteOrderClick()
		{
			try{
				((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(myActiveOrder_DeleteOrder);
		//System.out.println("Delete Button Present");
		log("Delete Button Present",LogType.STEP);	
		getCommand().click(myActiveOrder_DeleteOrder);
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//getCommand().waitForTargetPresent(myActiveOrder_PleaseConfirmPop_OK);
		//getCommand().click(myActiveOrder_PleaseConfirmPop_OK);
		log("Deleted : Pass",LogType.STEP);
			}
			catch (Exception e) {
				((AndroidDriver)getCommand().driver).context("NATIVE_APP");
				String finalPath1=drivePath+"myActiveOrder_DeleteOrderClick"+"Fail"+pathExtension;
				getCommand().captureScreenshot(finalPath1);
				Assert.assertFalse(true, "myActiveOrder_DeleteOrderClick:Fail");
			}
		return this;
	}	
}		