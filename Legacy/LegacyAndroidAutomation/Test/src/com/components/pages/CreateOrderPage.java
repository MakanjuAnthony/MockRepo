
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


public class CreateOrderPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target CreateOrder_title = new Target("CreateOrder_title","",Target.XPATH);

	
	//public static final Target orderGuide_CreateOrder=new Target("orderGuide_CreateOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[2]/android.view.View[1]",Target.XPATH);
	public static final Target orderGuide_CreateOrder=new Target("orderGuide_CreateOrder","//*[@class='list-options']//*[@href='/guide']",Target.XPATH);
	//public static final Target orderGuide_CreateOrder=new Target("orderGuide_CreateOrder","",Target.NAME);
																						

	public static final Target categories_CreateOrder=new Target("categories_CreateOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]",Target.XPATH);
	//public static final Target categories_CreateOrder=new Target("categories_CreateOrder"," Categories",Target.NAME);
	
	//public static final Target myCustomList_CreateOrder=new Target("myCustomList_CreateOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
	public static final Target myCustomList_CreateOrder=new Target("myCustomList_CreateOrder","//*[@class='list-options']//*[@href='/lists-summary/M']",Target.XPATH);
																
	//public static final Target myCustomList_CreateOrder=new Target("myCustomList_CreateOrder"," My Custom Lists",Target.NAME);
	
	//public static final Target syscoList_CreateOrder=new Target("syscoList_CreateOrder"," //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[4]/android.view.View[1]",Target.XPATH);
	public static final Target syscoList_CreateOrder=new Target("syscoList_CreateOrder","//*[@class='list-options']//*[@href='/lists-summary/S']",Target.XPATH);
																							//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[4]/android.view.View[1]
	//public static final Target syscoList_CreateOrder=new Target("syscoList_CreateOrder"," Sysco Lists",Target.NAME);
	
	//public static final Target sharedList_CreateOrder=new Target("sharedList_CreateOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[5]/android.view.View[1]",Target.XPATH);
	public static final Target sharedList_CreateOrder=new Target("sharedList_CreateOrder","//*[@class='list-options']//*[@href='/lists-summary/H']",Target.XPATH);
	//public static final Target sharedList_CreateOrder=new Target("sharedList_CreateOrder"," Shared Lists",Target.NAME);
	
	public static final Target inventory_CreateOrder=new Target("inventory_CreateOrder","//*[@class='list-options']//*[@href='/products/inventory']",Target.XPATH);
	
	public static final Target orderNameTxt_CreateOrder=new Target("orderNameTxt_CreateOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target orderNameTxt_CreateOrder=new Target("orderNameTxt_CreateOrder","03/30/2016 04:27 AM",Target.NAME);
	
	public static final Target deliveyDateTxt_CreateOrder=new Target("deliveyDateTxt_CreateOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]/android.view.View[2]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target deliveyDateTxt_CreateOrder=new Target("deliveyDateTxt_CreateOrder","04/04/2016",Target.NAME);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	String string1="Success";
	String string2="Issue";

	
	public CreateOrderPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public CreateOrderPage atCreateOrderPage()
	{
		log("At Create Order Page",LogType.STEP);
		return this;
		
	}

	
	public CreateOrderPage verifyCreateOrderPage()
	{
		log("Verify the CreateOrderPage",LogType.STEP);
		return this;
	}
	
	public CreateOrderPage createNewOrder_OrderGuide(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().waitFor(5);
		log("at createNewOrder_OrderGuide",LogType.STEP);
		//System.out.println("In OrderGuide  Tab");
		getCommand().waitForTargetPresent(orderGuide_CreateOrder);
		if (getCommand().isTargetPresent(orderGuide_CreateOrder))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(orderGuide_CreateOrder);
			log("Create new order via orderGuide: Pass",LogType.STEP);	
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "createNewOrder_OrderGuide:Fail");
		}
		return this;
	}
	
	
	//---------------------------March 30-----------
	public CreateOrderPage createNewOrder_Categories()
	{
		try{
		getCommand().waitFor(10);
		//System.out.println("In Categories Tab - Start");
		log("at createNewOrder_Categories",LogType.STEP);
		getCommand().waitForTargetPresent(categories_CreateOrder);
		//System.out.println("In Categories Tab - Present");
		if (getCommand().isTargetPresent(categories_CreateOrder))
		{
			//System.out.println("In Categories Tab");
			
			getCommand().click(categories_CreateOrder);
			log("Create new order via categories: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"createNewOrder_Categories"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "createNewOrder_Categories:Fail");
		}
		return this;
	}
	
	public CreateOrderPage createNewOrder_MyCustomLists(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().waitFor(5);
		log("at createNewOrder_MyCustomLists",LogType.STEP);
		//System.out.println("inside createNewOrder_MyCustomLists");
		getCommand().waitForTargetPresent(myCustomList_CreateOrder);
		if (getCommand().isTargetPresent(myCustomList_CreateOrder))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(myCustomList_CreateOrder);
			log("Create new order via myCustomList: Pass",LogType.STEP);
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "createNewOrder_MyCustomLists:Fail");
		}
		return this;
	}

	public CreateOrderPage createNewOrder_SyscoLists(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at createNewOrder_SyscoLists",LogType.STEP);
		//System.out.println("inside createNewOrder_SyscoLists");
		getCommand().waitForTargetPresent(syscoList_CreateOrder);
		if (getCommand().isTargetPresent(syscoList_CreateOrder))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(syscoList_CreateOrder);
			log("Create new order via syscoList: Pass",LogType.STEP);	
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "createNewOrder_SyscoLists:Fail");
		}
		return this;
	}
	public CreateOrderPage createNewOrder_SyscoListsWithScreenshot(String string)
	{
		try{
		log("at createNewOrder_SyscoLists",LogType.STEP);
		//System.out.println("inside createNewOrder_SyscoLists");
		getCommand().waitForTargetPresent(syscoList_CreateOrder);
		if (getCommand().isTargetPresent(syscoList_CreateOrder))
		{
			
			getCommand().click(syscoList_CreateOrder);
			log("Create new order via syscoList: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"createNewOrder_SyscoListsWithScreenshot"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "createNewOrder_SyscoLists:Fail");
		}
		return this;
	}
	
	public CreateOrderPage createNewOrder_SharedLists(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			log("at createNewOrder_SharedLists",LogType.STEP);
		
		//System.out.println("inside createNewOrder_SharedLists");
		getCommand().waitForTargetPresent(sharedList_CreateOrder);
		if (getCommand().isTargetPresent(sharedList_CreateOrder))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(sharedList_CreateOrder);
			log("Create new order via sharedList: Pass",LogType.STEP);	
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "createNewOrder_SharedLists:Fail");
		}
		return this;
	}
	
	//May 24
	
	public CreateOrderPage createNewOrder_Inventory(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at createNewOrder_Inventory",LogType.STEP);
		//System.out.println("inside createNewOrder_SyscoLists");
		getCommand().waitForTargetPresent(inventory_CreateOrder);
		if (getCommand().isTargetPresent(inventory_CreateOrder))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(inventory_CreateOrder);
			log("Create new order via Inventory: Pass",LogType.STEP);	
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			//((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			//getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "createNewOrder_Inventory:Fail");
		}
		return this;
	}
}
