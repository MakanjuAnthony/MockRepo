
package com.components.pages;
import java.util.Set;

/*
import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;*/
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;


public class SyscoListsPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target SyscoLists_title = new Target("Lists_title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target Lists_title=new Target("Lists_title","Lists",Target.NAME);
	
	public static final Target lists_EnterNewListName =new Target("lists_EnterNewListName ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target lists_EnterNewListName =new Target("lists_EnterNewListName ","Enter New List Name",Target.NAME);
	
	
	//-----------------Elements in syscoList BB558--------------------------
	public static final Target syscoList_itemSelect=new Target("sysco_itemSelect","(//*[@class='main-content']//*[@class='page-body']//*[@class='list-options']//a)[1]",Target.XPATH);
	public static final Target syscoList_itemSelect1=new Target("sysco_itemSelect","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]",Target.XPATH);

	//public static final Target sysco_itemSelect=new Target("sysco_itemSelect","BB558 Total Items: 178 List Owner: ",Target.NAME);
	//*[@class='main-content']//*[@class='page-body']//*[@class='list-options']//*[@class='name' and contains(text(),'BB558')]
//	(//*[@class='main-content']//*[@class='page-body']//*[@class='list-options']//a)[1]
	
	public static final Target itemsInsideSyscoList=new Target("itemsInsideSyscoList ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[3]",Target.XPATH);
	//public static final Target itemsInsideSyscoList =new Target("itemsInsideSyscoList","Avocado Hass 100% Halves",Target.NAME);
	
	public static final Target itemsInsideSyscoList_PlusButton2=new Target("itemsInsideSharedList_PlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[14]/android.view.View[1]",Target.XPATH);
	public static final Target itemsInsideSyscoList_PlusButton1=new Target("itemsInsideSharedList_PlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]",Target.XPATH);
																													//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]
	public static final Target itemsInsideSyscoList_Cart=new Target("itemsInsideSyscoList_Cart","//*[@id='app-cart-button']//*[@href='/retrieve']//*[@class='icon spin-target']//*[@id='cart-count']",Target.XPATH);
	//public static final Target itemsInsideSyscoList_Cart=new Target("itemsInsideSyscoList_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	//public static final Target itemsInsideSyscoList_Cart=new Target("itemsInsideSyscoList_Cart ","//*[@id='app-cart-button']//*[@href='/retrieve']",Target.XPATH);
	//public static final Target itemsInsideSyscoList_Cart =new Target("itemsInsideSyscoList_Cart ","",Target.NAME);
	
	public static final Target itemsInsideSyscoList_Filter=new Target("itemsInsideSyscoList_Filter ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",Target.XPATH);
	//public static final Target itemsInsideSyscoList_Filter =new Target("itemsInsideSyscoList_Filter ","",Target.NAME);
	
	public static final Target itemsInsideSyscoList_SearchCatalog=new Target("itemsInsideSyscoList_SearchCatalog ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target itemsInsideSyscoList_SearchCatalog =new Target("itemsInsideSyscoList_SearchCatalog ","Type to Filter List",Target.NAME);
	
	//public static final Target itemsInsideSyscoList_Create=new Target("itemsInsideSyscoList_Create ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	public static final Target itemsInsideSyscoList_Create=new Target("itemsInsideSyscoList_Create","//*[@id='ui-modal-container']//*[@class='create-order-page']//*[@class='page-header']//*[@class='create']",Target.XPATH);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	public SyscoListsPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public SyscoListsPage atSyscoListsPage ()
	{
		log("At SyscoListsPage ",LogType.STEP);
		return this;
		
	}

	
	public SyscoListsPage verifySyscoListsPage()
	{
		log("Verify the SyscoListsPage",LogType.STEP);
		return this;
	}
	

		
	
	
	
	public SyscoListsPage syscoListItem_Click()
	{
		try{
		log("at  SyscoListsPage",LogType.STEP);
		getCommand().waitFor(5);
		Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

		//System.out.println(contextNames);


		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

		// getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		//System.out.println("Item find from Syscolist page");
		getCommand().waitForTargetPresent(syscoList_itemSelect);
		if (getCommand().isTargetPresent(syscoList_itemSelect))
		{
			
			getCommand().click(syscoList_itemSelect);
			getCommand().waitFor(10);
			log("Select an item from SyscoList : Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			Assert.assertFalse(true, "syscoListItem_Click:Fail");
		}

		return this;
	}
	
	
	public SyscoListsPage syscoListItem_ClickWithScreenshot(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		
		getCommand().captureScreenshot(finalPath);
		try{
		log("at  SyscoListsPage",LogType.STEP);
		getCommand().waitFor(5);
		Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

		//System.out.println(contextNames);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

		// getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());


		//System.out.println("Item find from Syscolist page");
		getCommand().waitForTargetPresent(syscoList_itemSelect);
		if (getCommand().isTargetPresent(syscoList_itemSelect))
		{
			
			getCommand().click(syscoList_itemSelect);
			getCommand().waitFor(10);
			log("Select an item from SyscoList : Pass",LogType.STEP);	
		}else
			if (getCommand().isTargetPresent(syscoList_itemSelect1))
			{
				
				getCommand().click(syscoList_itemSelect1);
				getCommand().waitFor(10);
				log("Select an item from SyscoList : Pass",LogType.STEP);	
			}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "syscoListItem_Click:Fail");
		}

		return this;
	}
	
	
	public SyscoListsPage syscoListPlusBtn_Click()
	{

		try{
		log("at  SyscolistsPage",LogType.STEP);
		Target target= itemsInsideSyscoList_PlusButton1;
//		Target target= itemsInsideSyscoList_PlusButton2;
		getCommand().waitFor(10);
		getCommand().waitForTargetPresent(target);
		
		if (getCommand().isTargetPresent(target))
		{
			
			getCommand().click(target);
			
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			
			Assert.assertFalse(true, "syscoListPlusBtn_Click:Fail");
		}
		return this;
	}
	public SyscoListsPage syscoLists_CreateClick() 
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at syscoLists_CreateClick",LogType.STEP);
		getCommand().waitFor(5);
		//System.out.println("Clicking on Create..");
		getCommand().waitForTargetPresent(itemsInsideSyscoList_Create);
		if (getCommand().isTargetPresent(itemsInsideSyscoList_Create))
		{	getCommand().waitFor(10);
			getCommand().click(itemsInsideSyscoList_Create);	
			log("Clicked on Create order link",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			Assert.assertFalse(true, "syscoLists_CreateClick:Fail");
		}
		return this;
	}
	public SyscoListsPage syscoLists_CartClick() 
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");	
		log("at syscoLists_CartClick",LogType.STEP);
		
		//System.out.println("Clicking on Cart..");
		getCommand().waitForTargetPresent(itemsInsideSyscoList_Cart);
		if (getCommand().isTargetPresent(itemsInsideSyscoList_Cart))
		{	getCommand().waitFor(10);
			getCommand().click(itemsInsideSyscoList_Cart);
			
			log("Clicked on Sysco Items Page Cart: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			Assert.assertFalse(true, "syscoLists_CartClick:Fail");
		}
	return this;
	}
	
	
	
	

}		

