
package com.components.pages;
/*
import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;*/
import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;


public class SubmittedPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target Submitted_title = new Target("Submitted_title"," //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target Submitted_title = new Target("Submitted_title","Submitted",Target.NAME);
	
	public static final Target Submitted_Cart=new Target("Delivered_Cart","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	  //public static final Target Delivered_Cart = new Target("Delivered_Cart","",Target.NAME);
	
	public static final Target CONFIRMED=new Target("CONFIRMED","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.widget.ListView[1]/android.view.View[1]",Target.XPATH);
	  //public static final Target CONFIRMED = new Target("CONFIRMED","CONFIRMED",Target.NAME);
	
//public static final Target Submitted_Modify = new Target("Submitted_Modify","Modify",Target.NAME);
public static final Target Submitted_Modify = new Target("Submitted_Modify","//*[@class='modify-order']",Target.XPATH);
//*[@class='main-content']//*[@class='page-body']//*[@class='button']//*[@class='modify-order']---marshmallow


	public static final Target Submitted_CancelOrder=new Target("Submitted_CancelOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[17]",Target.XPATH);
	  //public static final Target Submitted_CancelOrder = new Target("Submitted_CancelOrder","Cancel Order",Target.NAME);
	
	
	//---------------Modify Order Popup---------------
		public static final Target Submitted_ModifyOrder_Title=new Target("Submitted_ModifyOrder_Title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]",Target.XPATH);
		  //public static final Target Submitted_ModifyOrder_Title = new Target("Submitted_ModifyOrder_Title"," Modify Order",Target.NAME);
		
		public static final Target Submitted_ModifyOrder_Continue=new Target("Submitted_ModifyOrder_Continue","//*[@class='btn continue']",Target.XPATH);
		  //public static final Target Submitted_ModifyOrder_Continue = new Target("Submitted_ModifyOrder_Continue","Continue",Target.NAME);
		
		//public static final Target Submitted_ModifyOrder_Cancel=new Target("Submitted_ModifyOrder_Cancel","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[5]",Target.XPATH);
		  public static final Target Submitted_ModifyOrder_Cancel = new Target("Submitted_ModifyOrder_Cancel"," Continue",Target.NAME);
		



	
	public SubmittedPage(SiteRepository repository)
	{
		super(repository);
	}

	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	/* Functions on the Page are defined below */
	
	public SubmittedPage atSubmittedPage()
	{
		log("At SubmittedPage",LogType.STEP);
		return this;
		
	}

	
	public SubmittedPage verifySubmittedPage()
	{
		log("Verify the SubmittedPage",LogType.STEP);
		return this;
	}
	
	
	
	public SubmittedPage submitted_Modify()
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(10);
		//System.out.println("at delivered_ReOrder");
	log("at My active order",LogType.STEP);
	getCommand().waitForTargetPresent(Submitted_Modify);
	if (getCommand().isTargetPresent(Submitted_Modify))
	{
			//System.out.println("inside Submitted_Modify");
		getCommand().click(Submitted_Modify);
		
		log("Clicked on SubmittedPage Modify button: Pass",LogType.STEP);	
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"submitted_Modify"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "submitted_Modify:Fail");
		}
	return this;
	}
	
	//---------------------April 6------------
	public SubmittedPage ModifyOrder_Continue()
	{
		try{
		//System.out.println("at ModifyOrder_Popup");
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	log("at ModifyOrder_Popup",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(Submitted_ModifyOrder_Continue);
	if (getCommand().isTargetPresent(Submitted_ModifyOrder_Continue))
	{
			//System.out.println("inside Submitted_ModifyOrder_Continue");
		getCommand().click(Submitted_ModifyOrder_Continue);
		
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
	public SubmittedPage ModifyOrder_Cancel()
	{
		try{
		//System.out.println("at ModifyOrder_Cancel");
	log("at ModifyOrder_Cancel",LogType.STEP);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(Submitted_ModifyOrder_Cancel);
	if (getCommand().isTargetPresent(Submitted_ModifyOrder_Cancel))
	{
			//System.out.println("inside Submitted_ModifyOrder_Cancel");
		getCommand().click(Submitted_ModifyOrder_Cancel);
		
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
	
	
	

}		