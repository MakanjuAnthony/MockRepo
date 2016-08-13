
package com.components.pages;
/*
import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;*/
import java.util.Set;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;


public class SubmittedOrdersPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target SubmittedOrders_title = new Target("SubmittedOrders_title"," //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target SubmittedOrders_title=new Target("SubmittedOrders_title","Submitted Orders",Target.NAME);
	
	//-------------------Selecting From Historical--------------//

	public static final Target SubmittedOrders_submittedItem =new Target("SubmittedOrders_submittedItem ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",Target.XPATH);
//	public static final Target SubmittedOrders_submittedItemWeb =new Target("SubmittedOrders_Order1Web ","//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Submitted']/div[contains(text(),'Order number: 24010')]",Target.XPATH);
//	public static final Target SubmittedOrders_submittedItemWeb =new Target("SubmittedOrders_Order1Web ","//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Submitted'and @data-order-id='25378']",Target.XPATH);
	public static final Target SubmittedOrders_submittedItemWeb =new Target("SubmittedOrders_Order1Web ","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Submitted'])[9]",Target.XPATH);
																																																								
																											//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]
	public static final Target SubmittedOrders_Cart =new Target("SubmittedOrders_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	//public static final Target SubmittedOrders_Cart =new Target("SubmittedOrders_Cart ","",Target.NAME);
	
	
	
	public SubmittedOrdersPage(SiteRepository repository)
	{
		super(repository);
	}
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	
	
	/* Functions on the Page are defined below */
	
	public SubmittedOrdersPage atSubmittedOrdersPage()
	{
		log("At Order Guide",LogType.STEP);
		return this;
		
	}

	
	public SubmittedOrdersPage verifySubmittedOrdersPage()
	{
		log("Verify the SubmittedOrdersPage",LogType.STEP);
		return this;
	}
	
	public SubmittedOrdersPage submittedItem_Click()
	{
		try{
		getCommand().waitFor(10);
		log("at  SubmittedOrdersPage",LogType.STEP);
	    //System.out.println("In SubmittedOrdersPage ...Item Click");
		getCommand().waitForTargetPresent(SubmittedOrders_submittedItem);
		if (getCommand().isTargetPresent(SubmittedOrders_submittedItem))
		{
			
			getCommand().click(SubmittedOrders_submittedItem);
			getCommand().waitFor(5);
			log("Select on Delivered Item in SubmittedOrdersPage Page: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"submittedItem_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "submittedItem_Click:Fail");
		}
		return this;
	}
	
	
	public SubmittedOrdersPage submittedItem_ClickWeb()
	{
		try{
		Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

		//System.out.println(contextNames);


		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

		// getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());

		getCommand().waitFor(10);
		log("at  SubmittedOrdersPage",LogType.STEP);
	    //System.out.println("In SubmittedOrdersPage ...Item Click");
		getCommand().waitForTargetPresent(SubmittedOrders_submittedItemWeb);
		if (getCommand().isTargetPresent(SubmittedOrders_submittedItemWeb))
		{
			
			getCommand().click(SubmittedOrders_submittedItemWeb);
			getCommand().waitFor(5);
			log("Select on Delivered Item in SubmittedOrdersPage Page: Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"submittedItem_ClickWeb"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "submittedItem_ClickWeb:Fail");
		}
		return this;
	}
	
	

}		