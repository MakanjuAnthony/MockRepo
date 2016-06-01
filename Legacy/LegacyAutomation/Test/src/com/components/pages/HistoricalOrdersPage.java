package com.components.pages;
/*
import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;*/
import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;


public class HistoricalOrdersPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target HistoricalOrders_title = new Target("HistoricalOrders_title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target HistoricalOrders_title=new Target("HistoricalOrders_title","Historical Orders",Target.NAME);
	
	//-------------------Selecting From Historical--------------//

	//public static final Target HistoricalOrders_DeliverdItem =new Target("HistoricalOrders_DeliverdItem ","//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Delivered' and @data-order-id='20368']",Target.XPATH);
	public static final Target HistoricalOrders_DeliverdItem =new Target("HistoricalOrders_DeliverdItem ","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Delivered'])[1]",Target.XPATH);
	//public static final Target HistoricalOrders_DeliverdItem =new Target("HistoricalOrders_DeliverdItem ","Dairy Products ",Target.NAME);
	
	public static final Target HistoricalOrders_CanceledItem =new Target("HistoricalOrders_CanceledItem ","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Canceled'])[1]",Target.XPATH);
	//public static final Target HistoricalOrders_CanceledItem =new Target("HistoricalOrders_CanceledItem ","Eggs ",Target.NAME);
	
	public static final Target HistoricalOrders_Cart =new Target("HistoricalOrders_Cart "," //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	//public static final Target HistoricalOrders_Cart =new Target("HistoricalOrders_Cart ","",Target.NAME);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	public HistoricalOrdersPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public HistoricalOrdersPage atHistoricalOrdersPage()
	{
		log("At Order Guide",LogType.STEP);
		return this;
		
	}

	
	public HistoricalOrdersPage verifyHistoricalOrdersPage()
	{
		getCommand().waitForTargetPresent(HistoricalOrders_title);
		log("Verify the HistoricalOrdersPage",LogType.STEP);
		return this;
	}
	
	public HistoricalOrdersPage DeliveredItem_Click(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

			//System.out.println(contextNames);


			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

			// getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

			//System.out.println( ((AndroidDriver)getCommand().driver).getContext());


		log("at  HistoricalOrders Page",LogType.STEP);
		getCommand().waitFor(5);
	    //System.out.println("In HistoricalOrdersPage ...Item Click");
		getCommand().waitForTargetPresent(HistoricalOrders_DeliverdItem);
		if (getCommand().isTargetPresent(HistoricalOrders_DeliverdItem))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().waitFor(5);
			getCommand().click(HistoricalOrders_DeliverdItem);
			
			log("Select on Delivered Item in HistoricalOrders Page: Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);


		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "DeliveredItem_Click:Fail");
		}
		return this;
	}
	
	
	public HistoricalOrdersPage CanceledItem_Click(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

			//System.out.println(contextNames);


			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

			// getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

			//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		log("at  HistoricalOrders Page",LogType.STEP);
		getCommand().waitFor(5);
	    //System.out.println("In HistoricalOrdersPage ...Item Click");
		getCommand().waitForTargetPresent(HistoricalOrders_CanceledItem);
		if (getCommand().isTargetPresent(HistoricalOrders_CanceledItem))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().waitFor(5);
			getCommand().click(HistoricalOrders_CanceledItem);
		log("Select on Cancelled Item in HistoricalOrders Page: Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "CanceledItem_Click:Fail");
		}
		return this;
	}
	
	

}