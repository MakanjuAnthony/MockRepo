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


public class DeliveredPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target Delivered_title = new Target("Delivered_title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target Delivered_title = new Target("Delivered_title","Delivered",Target.NAME);
	
//	public static final Target Delivered_Reorder=new Target("Delivered_Reorder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[16]",Target.XPATH);
																					//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[16]  
	//public static final Target Delivered_Reorder = new Target("Delivered_Reorder","Reorder",Target.NAME);
	public static final Target Delivered_Reorder = new Target("Delivered_Reorder","//*[@class='order-details-page']//*[@class='page-body']//*[@class='order-tools']//*[@class='button']//*[@href='#']",Target.XPATH);
	
	public static final Target Delivered_Cart=new Target("Delivered_Cart","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	  //public static final Target Delivered_Cart = new Target("Delivered_Cart","",Target.NAME);
	
	public static final Target CONFIRMED=new Target("CONFIRMED","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.widget.ListView[1]/android.view.View[1]",Target.XPATH);
	  //public static final Target CONFIRMED = new Target("CONFIRMED","CONFIRMED",Target.NAME);
	
	
	public static final Target Delivered_QtyTxt=new Target("Delivered_QtyTxt","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[13]",Target.XPATH);
	  //public static final Target Delivered_QtyTxt = new Target("Delivered_QtyTxt","1",Target.NAME);
	
//	public static final Target delivered_DeleteOrder=new Target("delivered_DeleteOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[18]",Target.XPATH);
	//public static final Target delivered_DeleteOrder=new Target("delivered_DeleteOrder","Delete Order",Target.NAME);
	public static final Target delivered_DeleteOrder=new Target("canceled_DeleteOrderWeb","//*[@class='delete-order']",Target.XPATH);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";


	public DeliveredPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public DeliveredPage atDeliveredPage()
	{
		log("At DeliveredPage",LogType.STEP);
		return this;
		
	}

	
	public DeliveredPage verifyDeliveredPage()
	{
		log("Verify the DeliveredPage",LogType.STEP);
		return this;
	}
	
	
	
	public DeliveredPage delivered_ReOrder()
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");	
		getCommand().waitFor(5);
		//System.out.println("at delivered_ReOrder");
	log("at delivered_ReOrder",LogType.STEP);
	getCommand().waitForTargetPresent(Delivered_Reorder);
	if (getCommand().isTargetPresent(Delivered_Reorder))
	{
			//System.out.println("inside if loop");
		getCommand().click(Delivered_Reorder);
		
		log("Clicked on delivered_ReOrder button: Pass",LogType.STEP);	
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"delivered_ReOrder"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "delivered_ReOrder:Fail");
		}
	return this;
	}
	
	
	public DeliveredPage delivered_ReOrderWithScreenshots(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;	
		
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(10);
		//System.out.println("at delivered_ReOrder");
	log("at delivered_ReOrder",LogType.STEP);
	getCommand().waitForTargetPresent(Delivered_Reorder);
	if (getCommand().isTargetPresent(Delivered_Reorder))
	{
		
		//getCommand().captureScreenshot(finalPath);
		
			//System.out.println("inside if loop");
		getCommand().click(Delivered_Reorder);
		
		log("Clicked on delivered_ReOrder button: Pass",LogType.STEP);	
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "delivered_ReOrder:Fail");
		}
	return this;
	}
	
	public DeliveredPage delivered_DeleteButtonCheck(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
	
		
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");	
	getCommand().waitFor(10);
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	getCommand().captureScreenshot(finalPath);
	((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");	
	
	Boolean deleteOrderButtonIsPresent = getCommand().isTargetVisible(delivered_DeleteOrder);
	Assert.assertTrue(!deleteOrderButtonIsPresent);
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "delivered_DeleteButtonCheck:Fail");
		}
	return this;
}	
	

}		

