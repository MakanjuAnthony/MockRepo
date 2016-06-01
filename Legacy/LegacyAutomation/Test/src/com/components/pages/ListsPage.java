
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


public class ListsPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target Lists_title = new Target("Lists_title","",Target.XPATH);

	
	//public static final Target orderGuide_Lists=new Target("orderGuide_Lists","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[2]/android.view.View[1]",Target.XPATH);
	public static final Target orderGuide_Lists=new Target("orderGuide_Lists","//*[@class='list-options']//*[@href='/guide']",Target.XPATH);
	//public static final Target orderGuide_Lists=new Target("orderGuide_Lists","",Target.NAME);
																						

	public static final Target categories_Lists=new Target("categories_Lists","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]",Target.XPATH);
	//public static final Target categories_Lists=new Target("categories_Lists"," Categories",Target.NAME);
	
	//public static final Target myCustomList_Lists=new Target("myCustomList_Lists","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
	public static final Target myCustomList_Lists=new Target("myCustomList_Lists","//*[@class='list-options']//*[@href='/lists-summary/M']//*[@class='icon spin-target']",Target.XPATH);
	//public static final Target myCustomList_Lists=new Target("myCustomList_Lists"," My Custom Lists",Target.NAME);
	//*[@class='list-options']//*[@href='/lists-summary/M']
	//public static final Target syscoList_Lists=new Target("syscoList_Lists","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[4]/android.view.View[1]",Target.XPATH);
	public static final Target syscoList_Lists=new Target("syscoList_Lists","//*[@class='list-options']//*[@href='/lists-summary/S']//*[@class='icon spin-target']",Target.XPATH);
	//public static final Target syscoList_Lists=new Target("syscoList_Lists"," Sysco Lists",Target.NAME);
	
	//public static final Target sharedList_Lists=new Target("sharedList_Lists","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[5]/android.view.View[1]",Target.XPATH);
	public static final Target sharedList_Lists=new Target("sharedList_Lists","//*[@class='list-options']//*[@href='/lists-summary/H']//*[@class='icon spin-target']",Target.XPATH);
	//public static final Target sharedList_Lists=new Target("sharedList_Lists"," Shared Lists",Target.NAME);
	
	public static final Target inventory_Lists=new Target("inventory_Lists","//*[@class='list-options']//*[@href='/products/inventory']//*[@class='icon spin-target']",Target.XPATH);
	
	public static final Target sharedList_SearchCatalog=new Target("sharedList_SearchCatalog","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target sharedList_SearchCatalog=new Target("sharedList_SearchCatalog"," Shared Lists",Target.NAME);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";


	
	public ListsPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public ListsPage atListsPage()
	{
		log("At Create Order Page",LogType.STEP);
		return this;
		
	}

	
	public ListsPage verifyListsPage()
	{
		log("Verify the ListsPage",LogType.STEP);
		return this;
	}
	

	public ListsPage lists_Categories()
	{
		try{
		//System.out.println("In Categories Tab - Start");
		log("at createNewOrder_Categories",LogType.STEP);
		getCommand().waitForTargetPresent(categories_Lists);
		//System.out.println("In Categories Tab - Present");
		if (getCommand().isTargetPresent(categories_Lists))
		{
			//System.out.println("In Categories Tab");
			
			getCommand().click(categories_Lists);
			log("Create new order via categories  From Lists Page: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			Assert.assertFalse(true, "lists_Categories:Fail");
		}
		return this;
	}
	
	public ListsPage lists_Inventory(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
		
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at lists_Inventory",LogType.STEP);
		getCommand().waitForTargetPresent(inventory_Lists);
		if (getCommand().isTargetPresent(inventory_Lists))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(inventory_Lists);
			log("Create new order via inventory From Lists Page: Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "lists_Inventory:Fail");
		}
		return this;
	}
	
	
	public ListsPage lists_CategoriesWithScreenshot(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
		//System.out.println("In Categories Tab - Start");
		log("at createNewOrder_Categories",LogType.STEP);
		getCommand().waitForTargetPresent(categories_Lists);
		//System.out.println("In Categories Tab - Present");
		if (getCommand().isTargetPresent(categories_Lists))
		{
			getCommand().captureScreenshot(finalPath);
			//System.out.println("In Categories Tab");
			getCommand().click(categories_Lists);
			log("Create new order via categories  From Lists Page: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "lists_Categories:Fail");
		}
		return this;
	}
	
	public ListsPage lists_OrderGuide(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at createNewOrder_OrderGuide",LogType.STEP);
		//System.out.println("In OrderGuide  Tab");
		getCommand().waitForTargetPresent(orderGuide_Lists);
		if (getCommand().isTargetPresent(orderGuide_Lists))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(orderGuide_Lists);
			log("Create new order via orderGuide From Lists Page: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "lists_OrderGuide:Fail");
		}
		return this;
	}
	
	public ListsPage lists_MyCustomLists(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at createNewOrder_MyCustomLists",LogType.STEP);
		
		//System.out.println("inside createNewOrder_MyCustomLists");
		getCommand().waitForTargetPresent(myCustomList_Lists);
		if (getCommand().isTargetPresent(myCustomList_Lists))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(myCustomList_Lists);
			log("Create new order via myCustomList  From Lists Page: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
	}
	catch (Exception e) {
		getCommand().captureScreenshot(finalPath1);
		Assert.assertFalse(true, "lists_MyCustomLists:Fail");
	}
		return this;
	}

	public ListsPage lists_SyscoLists(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at createNewOrder_SyscoLists",LogType.STEP);
		//System.out.println("inside createNewOrder_SyscoLists");
		getCommand().waitForTargetPresent(syscoList_Lists);
		if (getCommand().isTargetPresent(syscoList_Lists))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(syscoList_Lists);
			log("Create new order via syscoList  From Lists Page: Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "lists_SyscoLists:Fail");
		}
		return this;
	}
	
	public ListsPage lists_SharedLists(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at createNewOrder_SharedLists",LogType.STEP);
		//System.out.println("inside createNewOrder_SharedLists");
		getCommand().waitForTargetPresent(sharedList_Lists);
		if (getCommand().isTargetPresent(sharedList_Lists))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(sharedList_Lists);
			log("Create new order via sharedList  From Lists Page: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "lists_SharedLists:Fail");
		}
		return this;
	}
	
	


	

}		