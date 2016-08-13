package com.components.pages;
/*
import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;*/
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;


public class PendingOrdersPage extends SitePage{

	//----Apr 18 ----
public static final Target OpenOrdersPage_PendingApproval_MA =new Target("OpenOrdersPage_PendingApproval_MA","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Pending approval'])[1]",Target.XPATH);
public static final Target OpenOrdersPage_PendingApprovalNative =new Target("OpenOrdersPage_PendingApproval_Native","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[2]",Target.XPATH);

public static final Target Pending_Modify = new Target("Submitted_Modify","//*[@class='modify-order']",Target.XPATH);
//public static final Target Pending_Modify = new Target("Submitted_Modify","Modify",Target.NAME);

	//public static final Target Submitted_CancelOrder=new Target("Submitted_CancelOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[18]",Target.XPATH);
//public static final Target Pending_DeleteOrder = new Target("Pending_DeleteOrder","Delete Order",Target.NAME);
public static final Target Pending_DeleteOrder = new Target("Pending_DeleteOrder","//*[@class='delete-order']",Target.XPATH);

	//---------------Modify Order Popup---------------
public static final Target Pending_ModifyOrder_Title=new Target("Pending_ModifyOrder_Title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]",Target.XPATH);
//public static final Target Pending_ModifyOrder_Title = new Target("Pending_ModifyOrder_Title"," Modify Order",Target.NAME);
		
public static final Target Pending_ModifyOrder_Continue=new Target("Pending_ModifyOrder_Continue","//*[@class='btn continue']",Target.XPATH);
//public static final Target Pending_ModifyOrder_Continue = new Target("Pending_ModifyOrder_Continue","Continue",Target.NAME);
		
		//public static final Target Pending_ModifyOrder_Cancel=new Target("Pending_ModifyOrder_Cancel","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[5]",Target.XPATH);
public static final Target Pending_ModifyOrder_Cancel = new Target("Pending_ModifyOrder_Cancel","Cancel",Target.NAME);

	public static final Target Pending_PleaseConfirmPop_OK=new Target("Pending_PleaseConfirmPop_OK","//*[@class='btn confirm']",Target.XPATH);
//		public static final Target Pending_PleaseConfirmPop_OK=new Target("Pending_PleaseConfirmPop_OK","OK",Target.NAME);
		
	//public static final Target Pending_PleaseConfirmPop_Cancel=new Target("Pending_PleaseConfirmPop_Cancel","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",Target.XPATH);
		public static final Target Pending_PleaseConfirmPop_Cancel=new Target("Pending_PleaseConfirmPop_Cancel","Cancel",Target.NAME);
	
	
	public static final Target OpenOrdersPage_PendingApproval =new Target("OpenOrdersPage_PendingApproval_MA","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Pending approval'])[78]",Target.XPATH);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	public PendingOrdersPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public PendingOrdersPage atDeliveredPageOpenOrdersPage()
	{
		log("At OpenOrdersPage",LogType.STEP);
		return this;
		
	}
	
	
	

	public PendingOrdersPage pendingApprovalItem_Click()
	{
		
		
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at  OpenOrdersPage ",LogType.STEP);
		getCommand().waitFor(10);
	    //System.out.println("In OpenOrdersPage ...Pending Approval Item Click");
		getCommand().waitForTargetPresent(OpenOrdersPage_PendingApproval);
		if (getCommand().isTargetPresent(OpenOrdersPage_PendingApproval))
		{
			getCommand().waitFor(5);
			getCommand().click(OpenOrdersPage_PendingApproval);
			
			log("Select on PendingApproval Item in OpenOrdersPage Page: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		} 
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"pendingApprovalItem_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "pendingApprovalItem_Click:Fail");
		}
		return this;
	}
	
	//---Apr 18
	public PendingOrdersPage pendingApprovalItem_MAClick()
	{
		try{
	log("at  OpenOrdersPage ",LogType.STEP);
	getCommand().waitFor(10);
//System.out.println("In OpenOrdersPage ...Pending Approval Item Click");
	getCommand().waitForTargetPresent(OpenOrdersPage_PendingApprovalNative);
	if (getCommand().isTargetPresent(OpenOrdersPage_PendingApprovalNative))
	{
	getCommand().waitFor(5);
	getCommand().click(OpenOrdersPage_PendingApprovalNative);
	
	log("Select on PendingApproval Item in OpenOrdersPage Page: Pass",LogType.STEP);
	}else
	if (getCommand().isTargetPresent(OpenOrdersPage_PendingApproval_MA))
	{
	getCommand().waitFor(5);

	getCommand().click(OpenOrdersPage_PendingApproval_MA);
	
	log("Select on PendingApproval Item in OpenOrdersPage Page: Pass",LogType.STEP);
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"pendingApprovalItem_MAClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "pendingApprovalItem_MAClick:Fail");
		}
		
	return this;
	}

	public PendingOrdersPage pending_Modify()
	{
		try{
	//System.out.println("at delivered_ReOrder");
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	log("at My active order",LogType.STEP);
	getCommand().waitForTargetPresent(Pending_Modify);
	if (getCommand().isTargetPresent(Pending_Modify))
	{
	//System.out.println("inside Submitted_Modify");
	getCommand().click(Pending_Modify);
	
	log("Clicked on SubmittedPage Modify button: Pass",LogType.STEP);
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"pending_Modify"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "pending_Modify:Fail");
		}
	return this;
	}
	
	public PendingOrdersPage pending_Delete()
	{
		try{
	//System.out.println("at  Pending Approval page");
	((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	log("at Pending Approval page",LogType.STEP);
	getCommand().waitForTargetPresent(Pending_DeleteOrder);
	if (getCommand().isTargetPresent(Pending_DeleteOrder))
	{
	//System.out.println("inside  Pending Approval page");
	getCommand().click(Pending_DeleteOrder);
	
	log("Delete order button in pending Approval Page: Pass",LogType.STEP);
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"pending_Delete"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "pending_Delete:Fail");
		}
	
	return this;
	}
	
	
	public PendingOrdersPage ModifyOrder_Continue()
	{
		try{
	//System.out.println("at ModifyOrder_Popup");
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	log("at ModifyOrder_Popup",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(Pending_ModifyOrder_Continue);
	if (getCommand().isTargetPresent(Pending_ModifyOrder_Continue))
	{
	//System.out.println("inside Submitted_ModifyOrder_Continue");
	getCommand().click(Pending_ModifyOrder_Continue);
	
	log("Clicked on SubmittedPage Submitted_ModifyOrder_Continue button: Pass",LogType.STEP);
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		}
	catch (Exception e) {
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		String finalPath1=drivePath+"ModifyOrder_Continue"+"Fail"+pathExtension;
		getCommand().captureScreenshot(finalPath1);
		Assert.assertFalse(true, "ModifyOrder_Continue:Fail");
	}

	
	return this;
	}
	public PendingOrdersPage ModifyOrder_Cancel()
	{
		try{
	//System.out.println("at ModifyOrder_Cancel");
	log("at ModifyOrder_Cancel",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(Pending_ModifyOrder_Cancel);
	if (getCommand().isTargetPresent(Pending_ModifyOrder_Cancel))
	{
	//System.out.println("inside Submitted_ModifyOrder_Cancel");
	getCommand().click(Pending_ModifyOrder_Cancel);
	
	log("Clicked on SubmittedPage Submitted_ModifyOrder_Cancel button: Pass",LogType.STEP);
	}
		}
	catch (Exception e) {
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		String finalPath1=drivePath+"ModifyOrder_Cancel"+"Fail"+pathExtension;
		getCommand().captureScreenshot(finalPath1);
		Assert.assertFalse(true, "ModifyOrder_Cancel:Fail");
	}
	return this;
	}
	
	public PendingOrdersPage PleaseConfirmAlert_OK(String string)
	{
		try{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		
	//System.out.println("atmyActiveOrder_PleaseConfirmPop_OK");
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	log("at myActiveOrder_PleaseConfirmPop",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(Pending_PleaseConfirmPop_OK);
	if (getCommand().isTargetPresent(Pending_PleaseConfirmPop_OK))
	{
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		getCommand().captureScreenshot(finalPath);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	//System.out.println("inside myActiveOrder_PleaseConfirmPop_OK");
	getCommand().click(Pending_PleaseConfirmPop_OK);
	
	log("Clicked on PleaseConfirmPop_Okl in My Active Order page: Pass",LogType.STEP);
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"PleaseConfirmAlert_OK"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "PleaseConfirmAlert_OK:Fail");
		}
	return this;
		
	}
	
	
	public PendingOrdersPage PleaseConfirmAlert_Cancel()
	{
		try{
	//System.out.println("atNonCancellableItems_Cancell");
	log("atNonCancellableItems_Cancel",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(Pending_PleaseConfirmPop_Cancel);
	if (getCommand().isTargetPresent(Pending_PleaseConfirmPop_Cancel))
	{
	//System.out.println("inside myActiveOrder_PleaseConfirmPop_Cancel");
	getCommand().click(Pending_PleaseConfirmPop_Cancel);
	
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

	
	
	
}		

