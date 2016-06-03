/**
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 *																																		   	*
 * 2011-2012 Infosys Limited, Banglore, India. All Rights Reserved																			*
 * Version: 2.0																																*
 * 																																			*
 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
 * and will be prosecuted to the maximum extent possible under the law 																		*
 *																																			*
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 **/	
package com.components.pages;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

import io.appium.java_client.android.AndroidDriver;

public class SearchResultPage extends SitePage {
	
	/* Defining the locators on the Page */
	
	public static final Target HEADER_SEARCH_INPUT = new Target("header-search-input","//input[@id='lst-ib']",Target.XPATH);
	public static final Target HEADER_SEARCH_BUTTON = new Target("header-search-button","//button[@name='btnG']",Target.XPATH);
	public static final Target IMG_SELECT = new Target("Image_select","//img[@alt='Image result for testing for images']",Target.XPATH);
	public static final Target SIGNOUT_ARROW=new Target("signout-arrow","//div[@id='gbw']/div/div/div[2]/div[4]/div/a/span",Target.XPATH);
	public static final Target LNK_SIGNOUT = new Target("lnk_signout","//a[@id='gb_71']",Target.XPATH);
	public static final Target MSG_NOTAVAILABLE = new Target("msg_notavailable","//*[@id='search_results_msg']",Target.XPATH);
	
	
	
//	public static final Target searchResults_Plus = new Target("searchResults_Plus","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[14]/android.view.View[1]",Target.XPATH);
	
	public static final Target searchResults_PlusSecondButton = new Target("searchResults_Plus2","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[25]/android.view.View[1]",Target.XPATH);
	
	public static final Target searchResults_Plus2 = new Target("searchResults_Plus2","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]",Target.XPATH);
																						//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[25]/android.view.View[1]
	public static final Target searchResults_Plus3 = new Target("searchResults_Plus2","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[18]/android.view.View[1]",Target.XPATH);
																					//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[18]/android.view.View[1]
	public static final Target searchResults_Plus1 = new Target("searchResults_Plus1","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]",Target.XPATH);
																						//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]

																						//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]
																						//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[7]/android.view.View[7]/android.view.View[1]
	public static final Target searchResults_Plus = new Target("searchResults_Plus","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[6]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
																						//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]
	                                                                                  //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[13]
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[14]/android.view.View[1]
	//public static final Target searchResults_Cart=new Target("orderGuide_Cart","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	public static final Target searchResults_Cart=new Target("searchResults_Cart","//*[@id='app-cart-button']//*[@href='/retrieve']//*[@class='icon spin-target']//*[@id='cart-count']",Target.XPATH);
	//public static final Target searchResults_Create=new Target("orderGuide_Create","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	public static final Target searchResults_Create=new Target("searchResults_Create","//*[@id='ui-modal-container']//*[@class='create-order-page']//*[@class='page-header']//*[@class='create']",Target.XPATH);
	public SearchResultPage(SiteRepository repository)
	{
		super(repository);
	}
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	/* Functions on the Page are defined below */
	
	public SearchResultPage searchKeyword(String keyword)
	{
		try{
		log("Search for keyword <B>"+keyword+"</B> from home page",LogType.STEP);
		getCommand().sendKeys(HEADER_SEARCH_INPUT, keyword);
		getCommand().waitForTargetPresent(HEADER_SEARCH_INPUT);
		getCommand().click(HEADER_SEARCH_BUTTON);
		getCommand().waitForTargetPresent(IMG_SELECT);
		getCommand().click(IMG_SELECT);
		getCommand().waitFor(15);
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"create_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "searchKeyword:Fail");
		}
		return this;
		
	}
	
	public SearchResultPage closeBrowser()
	{
		log("Close Browser",LogType.STEP);
		getCommand().closeCurrentWindow();
		return this;
	}
	
	
	public SearchResultPage searchResults_PlusButtonClick()
	{
		try{
		getCommand().waitFor(10);	
		log("At plusButtonSearchResults",LogType.STEP);
		if (getCommand().isTargetPresent(searchResults_Plus))
		{
			
			getCommand().click(searchResults_Plus);
			getCommand().waitFor(5);
			log("Clicked on plus button in search results page: Pass",LogType.STEP);	
		}else
		if (getCommand().isTargetPresent(searchResults_Plus2))
		{
			
			getCommand().click(searchResults_Plus2);
			getCommand().waitFor(5);
			log("Clicked on plus button in search results page: Pass",LogType.STEP);	
		}else
			if (getCommand().isTargetPresent(searchResults_Plus1))
			{
				
				getCommand().click(searchResults_Plus1);
				getCommand().waitFor(5);
				log("Clicked on plus button in search results page: Pass",LogType.STEP);	
			}
	
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"searchResults_PlusButtonClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "searchResults_PlusButtonClick:Fail");
		}
		return this;
	}
	public SearchResultPage searchResults_PlusButton2ndItemClick()
	{
		try{
		log("At plusButtonSearchResults",LogType.STEP);
		if (getCommand().isTargetPresent(searchResults_PlusSecondButton))
		{
			getCommand().waitFor(10);
			getCommand().click(searchResults_PlusSecondButton);
		}	
			
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"searchResults_PlusButton2ndItemClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "searchResults_PlusButton2ndItemClick:Fail");
		}
		return this;
	}
	public SearchResultPage searchResults_CreateClick()
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(10);
		if (getCommand().isTargetPresent(searchResults_Create))
		{
				
			getCommand().click(searchResults_Create);
			getCommand().waitFor(5);
			log("Clicked on Create: Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"searchResults_CreateClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "searchResults_CreateClick:Fail");
		}
		return this;
	}
	public SearchResultPage searchResults_CartClick()
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(10);
		if (getCommand().isTargetPresent(searchResults_Cart))
		{
				
			getCommand().click(searchResults_Cart);
			getCommand().waitFor(5);
			log("Clicked on Cart: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"searchResults_CartClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "searchResults_CartClick:Fail");
		}
		return this;
	}
	}		