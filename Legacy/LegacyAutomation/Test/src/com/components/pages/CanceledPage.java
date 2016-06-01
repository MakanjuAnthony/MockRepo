
package com.components.pages;
import org.testng.Assert;
import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;

import io.appium.java_client.android.AndroidDriver;

import com.iwaf.framework.components.Target;


public class CanceledPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target Canceled_title = new Target("Cancelled_title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target Cancelled_title = new Target("Cancelled_title"," Canceled",Target.NAME);
	
	public static final Target Canceled_Reorder=new Target("Cancelled_Reorder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[16]",Target.XPATH);
	  //public static final Target Cancelled_Reorder = new Target("Cancelled_Reorder","Reorder",Target.NAME);
	
	public static final Target Canceled_Cart=new Target("Cancelled_Cart","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	  //public static final Target Cancelled_Cart = new Target("Cancelled_Cart","",Target.NAME);
	
	public static final Target canceled=new Target("CANCELLED","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.widget.ListView[1]/android.view.View[1]",Target.XPATH);
	  //public static final Target CANCELLED = new Target("CANCELLED","CANCELLED",Target.NAME);
	
	
	public static final Target canceledOrder=new Target("CANCELLED","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[6]",Target.XPATH); 
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[6]
	public static final Target canceled_DeleteOrder=new Target("canceled_DeleteOrder","Delete Order",Target.NAME);
	public static final Target canceled_DeleteOrderWeb=new Target("canceled_DeleteOrderWeb","//*[@class='delete-order']",Target.XPATH);
//	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	public CanceledPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public CanceledPage atCanceledPage()
	{
		log("At DeliveredPage",LogType.STEP);
		return this;
		
	}

	public CanceledPage verifyCanceledPage()
	{
		log("Verify the CancelledPage",LogType.STEP);
		return this;
	}
	
	public CanceledPage canceled_ReOrder()
	{
	try{	
		//System.out.println("at myActiveOrder_SubmitOrder");
	log("at My active order",LogType.STEP);
	getCommand().waitForTargetPresent(Canceled_Reorder);
	if (getCommand().isTargetPresent(Canceled_Reorder))
	{
			//System.out.println("inside cancelled Reorder");
		getCommand().click(Canceled_Reorder);
		
		log("Clicked on Cancelled_Reorder button : Pass",LogType.STEP);			
	}
	}
	catch (Exception e) {
		Assert.assertFalse(true, "canceled_ReOrder:Fail");
	}
	return this;
	}
	
	public CanceledPage canceled_DeleteButtonCheck(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			
	((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	getCommand().waitFor(8);
	//getCommand().captureScreenshot(finalPath);
Boolean deleteOrderButtonIsPresent = getCommand().isTargetVisible(canceled_DeleteOrderWeb);
	System.out.println(deleteOrderButtonIsPresent);
	Assert.assertTrue(!deleteOrderButtonIsPresent);
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "canceled_DeleteButtonCheck");
		}
	return this;
}	

}		