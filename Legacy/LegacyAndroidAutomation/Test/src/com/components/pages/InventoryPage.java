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

public class InventoryPage extends SitePage{
	
	public static final Target Inventory_FirstItemSelectPlus =new Target("Inventory_FirstItemSelectPlus","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[7]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
																											
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[8]
	//public static final Target Inventory_FirstItemSelectPlus =new Target("Inventory_FirstItemSelectPlus","(//*[@class='mm-qty-input spin-container ']//*[@class='btn open-quantity']//*[@class='icon'])[1]",Target.XPATH);
	public static final Target Inventory_Cart=new Target("Inventory_Cart","//*[@id='app-cart-button']//*[@href='/retrieve']//*[@class='icon spin-target']//*[@id='cart-count']",Target.XPATH);
	public static final Target Inventory_FirstItemPlus =new Target("Inventory_FirstItemPlus","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[16]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
																								//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[6]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]
	public static final Target Inventory_FirstItemPlus1 =new Target("Inventory_FirstItemPlus1","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[6]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
	
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[16]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[7]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[15]
	public static final Target Inventory_Create=new Target("Inventory_Create","//*[@id='ui-modal-container']//*[@class='create-order-page']//*[@class='page-header']//*[@class='create']",Target.XPATH);
	public InventoryPage(SiteRepository repository)
	{
		super(repository);
	}
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";


	/* Functions on the Page are defined below */
	
	public InventoryPage firstItem_PlusBtn_Click()
	{
		try{
			
		log("at  InventoryPage",LogType.STEP);
		Target target = null;
		target=Inventory_FirstItemSelectPlus;
		getCommand().waitForTargetPresent(target);
		if (getCommand().isTargetPresent(target))
		{
			
			getCommand().click(target);
			
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
			getCommand().waitFor(10);
			
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"firstItem_PlusBtn_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "PlusBtn_Click:Fail");
		}
		return this;
	}
	
	public InventoryPage plusBtn_Click()
	{
		try{
			
		log("at  Inventory",LogType.STEP);
		Target target = null;
		target=Inventory_FirstItemPlus;
		getCommand().waitForTargetPresent(target);
		if (getCommand().isTargetPresent(target))
		{
			
			getCommand().click(target);
			
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
			getCommand().waitFor(10);
			
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"plusBtn_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "PlusBtn_Click:Fail");
		}
		return this;
	}
	
	public InventoryPage inventory_CartClick() 
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at inventory_CartClick",LogType.STEP);
		getCommand().waitForTargetPresent(Inventory_Cart);
		if (getCommand().isTargetPresent(Inventory_Cart))
		{
				
			getCommand().click(Inventory_Cart);
			getCommand().waitFor(5);
			log("Clicked on Inventory Page Cart: Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"inventory_CartClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "inventory_CartClick:Fail");
		}
	return this;
	}
	
	public InventoryPage inventory_CreateClick() 
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at inventory_CreateClick",LogType.STEP);
		getCommand().waitFor(5);
		//System.out.println("Clicking on Create..");
		getCommand().waitForTargetPresent(Inventory_Create);
		if (getCommand().isTargetPresent(Inventory_Create))
		{	getCommand().waitFor(10);
			getCommand().click(Inventory_Create);	
			log("Clicked on Create order link",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"inventory_CreateClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "inventory_CreateClick:Fail");
		}
		return this;
	}

}
