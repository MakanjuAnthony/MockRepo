
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


public class OrderGuide extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target syscoLogoHome = new Target("InventoryTitle","",Target.XPATH);
	public static final Target orderGuide_PlusButton=new Target("orderGuide_PlusButton","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[7]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
																							//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[8]/android.view.View[1]
																							//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[8]
	public static final Target orderGuide_PlusButtonCheck=new Target("orderGuide_PlusButtonCheck","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[7]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[8]
	
//	public static final Target orderGuide_PlusButton=new Target("orderGuide_PlusButton","(//*[@class='mm-qty-input spin-container ']//*[@class='btn open-quantity']//*[@class='icon'])[1]",Target.XPATH);
//	public static final Target orderGuide_PlusButtonWebView=new Target("orderGuide_PlusButton","//*[@class='main-content']//*[@class='page-body']//*[@class='product-list list']//*[@data-index='1']//*[@class='state-1']//*[@class='mm-qty-input spin-container ']",Target.XPATH);
	public static final Target orderGuide_PlusButtonWebView=new Target("orderGuide_PlusButton","//*[@id='content']/div/div/div[2]/div/div[2]/div[3]/div/div[1]/div[3]/span]",Target.XPATH);
	
	
	public static final Target orderGuide_Quantity=new Target("orderGuide_PlusButton","//*[@class='main-content']//*[@class='page-body']//*[@class='product-list list']//*[@data-index='1']//*[@class='state-1']//*[@class='mm-qty-input spin-container ']",Target.XPATH);
	
	//*[@class='main-content']//*[@class='page-body']//*[@class='product-list list']//*[@data-index='1']//*[@class='mm-qty-input-increment spin-container has-quantity active']//*[@class='keyboard-input']
	//*[@class='product-list list']/div[1]//*[@class='list-item-bar']//*[@class='mm-qty-input spin-container ']
//	public static final Target orderGuide_PlusButton=new Target("orderGuide_PlusButton","//*[@class='product-list list']/div[1]//*[@class='list-item-bar']//*[@class='mm-qty-input spin-container ']",Target.XPATH);
	public static final Target orderGuide_QtyButton=new Target("orderGuide_QtyButton"," ",Target.XPATH);
	//public static final Target orderGuide_CreateOrder=new Target("orderGuide_CreateOrder","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	
	public static final Target orderGuide_CreateOrder=new Target("orderGuide_CreateOrder","//*[@id='ui-modal-container']//*[@class='create-order-page']//*[@class='page-header']//*[@class='create']",Target.XPATH);
	
	//public static final Target orderGuide_Cart=new Target("orderGuide_Cart","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	public static final Target orderGuide_Cart=new Target("orderGuide_Cart","//*[@id='app-cart-button']//*[@href='/retrieve']//*[@class='icon spin-target']//*[@id='cart-count']",Target.XPATH);
																				//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]
	public static final Target orderGuide_Filter=new Target("orderGuide_Filter","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5] ",Target.XPATH);
	public static final Target orderGuide_SearchCatalog=new Target("orderGuide_SearchCatalog","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1] ",Target.XPATH);
	
	//-----------Elements of OrderGuide from Hamburger----
	public static final Target orderGuide_Hamburger_PlusButton=new Target("orderGuide_Hamburger_PlusButton","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[15]/android.view.View[1]",Target.XPATH);
	//*[@class='main-content']//*[@class='page-body']//*[@class='product-list list']//*[@data-index='1']//*[@class='state-1']//*[@class='mm-qty-input spin-container ']																										
	public static final Target orderGuide_Hamburger_Cart=new Target("orderGuide_Hamburger_Cart","",Target.XPATH);
	public static final Target orderGuide_Hamburger_Create=new Target("orderGuide_Hamburger_Create","",Target.XPATH);
	public static final Target orderGuide_Hamburger_Cancel=new Target("orderGuide_Hamburger_Cancel","",Target.XPATH);
	
	
	
//	submit order in My Active Order Page   //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[17]
//	alert close   //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]
//	alert xxxxx //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]
	
	public static final Target orderGuide_CreateLink=new Target("orderGuide_CreateLink","Create",Target.NAME);
	
	
	public static final Target orderGuide_SecondPlusButton = new Target("orderGuide_SecondPlusButton","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[25]/android.view.View[1]",Target.XPATH);
	
	public static final Target orderGuide_PlusButtonIncrementWeb = new Target("orderGuide_PlusButtonIncrementWeb","//*[@class='main-content']//*[@class='order-guide-page']//*[@class='product-list list']//*[@data-id='6672182-CS']//*[@class='states-holder show-state-2']//*[@class='state-2']//*[@class='btn quantity-up']",Target.XPATH);
	
	//*[@class='main-content']//*[@class='order-guide-page']//*[@class='product-list list']//*[@data-id='6672182-CS']//*[@class='states-holder show-state-2']//*[@class='state-2']//*[@class='btn quantity-up']
	
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	public OrderGuide(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public OrderGuide atOrderGuide()
	{
		log("At Order Guide",LogType.STEP);
		return this;
		
	}

	
	public OrderGuide verifyOrderGuide()
	{
		log("Verify the Home Page Logo",LogType.STEP);
		return this;
	}
	
	public OrderGuide orderGuide_Click()
	{
		try{
		log("at orderGuide_Click",LogType.STEP);
		getCommand().waitFor(10);
		getCommand().waitForTargetPresent(orderGuide_PlusButton);
		if (getCommand().isTargetPresent(orderGuide_PlusButton))
		{
			
			getCommand().click(orderGuide_PlusButton);
			getCommand().waitFor(10);
			log("Clicked on Order Guide Tab: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"orderGuide_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuide_Click:Fail");
		}
		return this;
	}
	public OrderGuide orderGuide_ClickWithScreenshot(String string)
	{
	String string1="Success";
	String string2="Issue";
	String finalPath=drivePath+string+string1+pathExtension;
	String finalPath1=drivePath+string+string2+pathExtension;
		try{
			
		log("at orderGuide_Click",LogType.STEP);
		getCommand().waitFor(10);
		getCommand().waitForTargetPresent(orderGuide_PlusButton);
		
		if (getCommand().isTargetPresent(orderGuide_PlusButton))
		{
			
			getCommand().click(orderGuide_PlusButton);
			
			getCommand().captureScreenshot(finalPath);
			getCommand().waitFor(10);
			log("Clicked on Order Guide Tab: Pass",LogType.STEP);
		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuide_Click:Fail");
		}
		return this;
	}
	public OrderGuide orderGuide_PlusButtonClickWeb()
	{
		
try{
		 Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
		//System.out.println(contextNames);
		
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		// getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		
		log("at createNewOrder_OrderGuide",LogType.STEP);
		
		
		
		getCommand().waitFor(10);
		getCommand().waitForTargetPresent(orderGuide_PlusButtonWebView);
		if (getCommand().isTargetPresent(orderGuide_PlusButtonWebView))
		{
			
			getCommand().click(orderGuide_PlusButtonWebView);
			getCommand().waitFor(10);
			log("Clicked on Order Guide Tab: Pass",LogType.STEP);	
		}
		
		
		
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		getCommand().waitFor(10);
}
catch (Exception e) {
	((AndroidDriver)getCommand().driver).context("NATIVE_APP");
	String finalPath1=drivePath+"orderGuide_PlusButtonClickWeb"+"Fail"+pathExtension;
	getCommand().captureScreenshot(finalPath1);
	Assert.assertFalse(true, "orderGuide_PlusButtonClickWeb:Fail");
}
		return this;
	}
	public OrderGuide orderGuidePlusButton_Click()
	{
		try{
		log("at createNewOrder_OrderGuide",LogType.STEP);
		getCommand().waitFor(10);
		getCommand().waitForTargetPresent(orderGuide_PlusButtonCheck);
		if (getCommand().isTargetPresent(orderGuide_PlusButtonCheck))
		{
			
			getCommand().click(orderGuide_PlusButtonCheck);
	
			getCommand().waitFor(10);
			log("Clicked on Order Guide Plus: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"orderGuidePlusButton_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuide_PlusButtonClick:Fail");
		}
		return this;
	}
	public OrderGuide orderGuidePlusButton_ClickWithScreenshot(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			
		log("at createNewOrder_OrderGuide",LogType.STEP);
		getCommand().waitFor(10);
		getCommand().waitForTargetPresent(orderGuide_PlusButton);
		getCommand().captureScreenshot(finalPath);
		if (getCommand().isTargetPresent(orderGuide_PlusButton))
		{
			
			getCommand().click(orderGuide_PlusButton);
			getCommand().waitFor(10);
			log("Clicked on Order Guide Tab: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuide_PlusButtonClick:Fail");
		}
		return this;
	}
	
	public OrderGuide orderGuidePlus_ButtonIncrement_Click()
	{
		try{
		 Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

		 //System.out.println(contextNames);


		 ((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

		 // getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

		 //System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		log("at createNewOrder_OrderGuide",LogType.STEP);
		getCommand().waitFor(10);
		getCommand().waitForTargetPresent(orderGuide_PlusButtonIncrementWeb);
		if (getCommand().isTargetPresent(orderGuide_PlusButtonIncrementWeb))
		{
			
			getCommand().click(orderGuide_PlusButtonIncrementWeb);
			getCommand().waitFor(10);
			log("Clicked on Order Guide Tab: Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"openItem2_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuidePlus_ButtonIncrement_Click:Fail");
		}
		return this;
		
	}
	public OrderGuide orderGuideCreateLink_Click()
	{
		try{
		log("at createNewOrder_OrderGuide",LogType.STEP);
		getCommand().waitForTargetPresent(orderGuide_CreateLink);
		if (getCommand().isTargetPresent(orderGuide_CreateLink))
		{
			getCommand().waitFor(10);
			getCommand().click(orderGuide_CreateLink);
			getCommand().waitFor(10);
			log("Clicked on Order Guide Tab: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"orderGuideCreateLink_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuideCreateLink_Click:Fail");
		}
		return this;
	}
	public OrderGuide orderGuide_CartClick() throws InterruptedException
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		//getCommand().captureScreenshot("/Users/naveen_raj04/Desktop/ScreenShotSysco/Cart.png");
		log("at orderGuide_CartClick",LogType.STEP);
		getCommand().waitForTargetPresent(orderGuide_Cart);
		if (getCommand().isTargetPresent(orderGuide_Cart))
		{
				
			getCommand().click(orderGuide_Cart);
			getCommand().waitFor(5);
			log("Clicked on OrderGuide Cart: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"orderGuide_CartClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuide_CartClick:Fail");
		}
	return this;
	}
	public OrderGuide orderGuide_CreateOrderClick() throws InterruptedException
	{
		try{
			 ((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at orderGuide_CreateOrderClick",LogType.STEP);
		getCommand().waitForTargetPresent(orderGuide_CreateOrder);
		if (getCommand().isTargetPresent(orderGuide_CreateOrder))
		{
				
			getCommand().click(orderGuide_CreateOrder);
			getCommand().waitFor(10);
			log("Clicked on OrderGuide create order: Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"orderGuide_CreateOrderClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuide_CreateOrderClick:Fail");
		}
	return this;
	}
	
	public OrderGuide orderGuide_PlusButton2ndItemClick()
	{
		try{
		log("At plusButtonSearchResults",LogType.STEP);
		getCommand().waitFor(5);
		if (getCommand().isTargetPresent(orderGuide_SecondPlusButton))
		{
				
			getCommand().click(orderGuide_SecondPlusButton);
			getCommand().waitFor(10);
			log("Clicked on OrderGuide Cart: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"orderGuide_PlusButton2ndItemClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuide_PlusButton2ndItemClick:Fail");
		}
		return this;
	}
	
	public OrderGuide orderGuide_InsertQuantity()
	{

		log("At plusButtonSearchResults",LogType.STEP);
		 Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

		 //System.out.println(contextNames);


		 ((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

		 // getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

		 //System.out.println( ((AndroidDriver)getCommand().driver).getContext());


		getCommand().waitFor(5);
		if (getCommand().isTargetPresent(orderGuide_Quantity))
		{
				
			getCommand().click(orderGuide_Quantity);
			getCommand().clear(orderGuide_Quantity);
			getCommand().sendKeys(orderGuide_Quantity, "100");
			getCommand().waitFor(10);
			log("Clicked on OrderGuide Cart: Pass",LogType.STEP);	
		}
		
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		return this;
	}
	

}		