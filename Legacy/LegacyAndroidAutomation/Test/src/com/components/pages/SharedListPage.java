
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


public class SharedListPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target Lists_title = new Target("Lists_title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target Lists_title=new Target("Lists_title","Lists",Target.NAME);
	
	public static final Target lists_EnterNewListName =new Target("lists_EnterNewListName ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target lists_EnterNewListName =new Target("lists_EnterNewListName ","Enter New List Name",Target.NAME);
	
	


	//------------Elements in sharedList-----
		public static final Target sharedList_itemSelect=new Target("sharedList_itemSelect","(//*[@class='main-content']//*[@class='page-body']//*[@class='list-options']//a)[1]",Target.XPATH);
		public static final Target sharedList_itemSelect1=new Target("sharedList_itemSelect","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]",Target.XPATH);
		
		//*[@class='main-content']//*[@class='page-body']//*[@class='list-options']//*[@class='name' and contains(text(),'MM list 8')]
		
		//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]

		//public static final Target sharedList_itemSelect=new Target("sharedList_itemSelect","list1 Total Items: 2 List Owner",Target.NAME);
		
		
	
	
	//------------------Elements in Milk Items Product Page---------------
	
	public static final Target milkItems_title=new Target("milkItems_title ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target milkItems_title =new Target("milkItems_title ","Milk items",Target.NAME);
	
	
	public static final Target itemsInsideSharedList=new Target("itemsInsideSharedList ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]",Target.XPATH);
	//public static final Target itemsInsideSharedList =new Target("itemsInsideSharedList","Dough Cookie Butter Sugar",Target.NAME);
	
	
	public static final Target itemsInsideSharedList_PlusButton2=new Target("itemsInsideSharedList_PlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[14]/android.view.View[1]",Target.XPATH);
	public static final Target itemsInsideSharedList_PlusButton1=new Target("itemsInsideSharedList_PlusButton "," //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[12]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]

	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]																											
	//public static final Target itemsInsideSharedList_PlusButton =new Target("itemsInsideSharedList_PlusButton ","",Target.NAME);
	public static final Target itemsInsideSharedList_Cart=new Target("itemsInsideSharedList_Cart","//*[@id='app-cart-button']//*[@href='/retrieve']//*[@class='icon spin-target']//*[@id='cart-count']",Target.XPATH);
	//public static final Target itemsInsideSharedList_Cart=new Target("itemsInsideSharedList_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH); 
	//public static final Target itemsInsideSharedList_Cart =new Target("itemsInsideSharedList_Cart ","",Target.NAME);
	//public static final Target itemsInsideSharedList_Create=new Target("itemsInsideSharedList_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	public static final Target itemsInsideSharedList_Create=new Target("itemsInsideSharedList_Create","//*[@id='ui-modal-container']//*[@class='create-order-page']//*[@class='page-header']//*[@class='create']",Target.XPATH);
	public static final Target itemsInsideSharedList_Filter=new Target("itemsInsideSharedList_Filter ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",Target.XPATH);
	//public static final Target itemsInsideSharedList_Filter =new Target("itemsInsideSharedList_Filter ","",Target.NAME);
	
	public static final Target itemsInsideSharedList_SearchCatalog=new Target("itemsInsideSharedList_SearchCatalog ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target itemsInsideSharedList_SearchCatalog =new Target("itemsInsideSharedList_SearchCatalog ","Type to Filter List",Target.NAME);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	

	public SharedListPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public SharedListPage atListsPage()
	{
		log("At SharedListsPage",LogType.STEP);
		return this;
		
	}

	
	public SharedListPage verifySharedListPage()
	{
		log("Verify the ListsPage",LogType.STEP);
		return this;
	}
	
	public SharedListPage sharedListItem_Click()
	{
		try{
		log("at  SharedListsPage",LogType.STEP);
		getCommand().waitFor(5);
		 Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

		 //System.out.println(contextNames);


		 ((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

		 // getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

		 //System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		getCommand().waitForTargetPresent(sharedList_itemSelect);
		if (getCommand().isTargetPresent(sharedList_itemSelect))
		{
			
			getCommand().click(sharedList_itemSelect);
			getCommand().waitFor(10);
			log("Select on item from List : Pass",LogType.STEP);	
		}

((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"sharedListItem_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "sharedListItem_Click:Fail");
		}

		return this;
	}
	
	public SharedListPage sharedListItem_ClickWithScreenshots(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		//getCommand().captureScreenshot(finalPath);
		try{
			
		log("at  SharedListsPage",LogType.STEP);
		getCommand().waitFor(5);
		 Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
		 //System.out.println(contextNames);
		 ((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		 // getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

		 //System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		getCommand().waitForTargetPresent(sharedList_itemSelect);
		if (getCommand().isTargetPresent(sharedList_itemSelect))
		{
		
			getCommand().click(sharedList_itemSelect);
			getCommand().waitFor(8);
			log("Select an item from List : Pass",LogType.STEP);	
		}else
			if (getCommand().isTargetPresent(sharedList_itemSelect1))
			{
			
				getCommand().click(sharedList_itemSelect1);
				getCommand().waitFor(10);
				log("Select on item from List : Pass",LogType.STEP);	
			}

((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "sharedListItem_Click:Fail");
		}

		return this;
	}
	
	
	
	public SharedListPage sharedListPlusBtn_Click()
	{
		try{
		log("at  SharedListsPage",LogType.STEP);
		Target target= itemsInsideSharedList_PlusButton1;
	Target target1= itemsInsideSharedList_PlusButton2;

		getCommand().waitForTargetPresent(target);
		if (getCommand().isTargetPresent(target))
		{
			getCommand().waitFor(10);
			getCommand().click(target);
			
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
		}else if (getCommand().isTargetPresent(target1))
		{
			getCommand().waitFor(10);
			getCommand().click(target1);
			
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"sharedListPlusBtn_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "sharedListPlusBtn_Click:Fail");
		}
		return this;
	}
	
	public SharedListPage sharedLists_CartClick() throws InterruptedException
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at SharedLists_CartClick",LogType.STEP);
		getCommand().waitFor(10);
		//System.out.println("Clicking on Cart..");
		getCommand().waitForTargetPresent(itemsInsideSharedList_Cart);
		if (getCommand().isTargetPresent(itemsInsideSharedList_Cart))
		{	getCommand().waitFor(10);
			getCommand().click(itemsInsideSharedList_Cart);
			
			log("Clicked on Cart in List Page : Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"sharedLists_CartClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "sharedLists_CartClick:Fail");
		}
		
	return this;
	}
	public SharedListPage sharedLists_CreateClick() throws InterruptedException
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at SharedLists_CreateClick",LogType.STEP);
		getCommand().waitFor(10);
		//System.out.println("Clicking on Create..");
		getCommand().waitForTargetPresent(itemsInsideSharedList_Create);
		
		if (getCommand().isTargetPresent(itemsInsideSharedList_Create))
				
		{	getCommand().waitFor(5);
			getCommand().click(itemsInsideSharedList_Create);
			
			log("Clicked on Create in List Page : Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"sharedLists_CreateClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "sharedLists_CreateClick:Fail");
		}
		
	return this;
	}
	
	
	

}		
