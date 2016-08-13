
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


public class MyCustomListsPage extends SitePage{

	/* Defining the locators on the Page */ 
	
	public static final Target Lists_title = new Target("Lists_title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target Lists_title=new Target("Lists_title","Lists",Target.NAME);
	
	public static final Target lists_EnterNewListName =new Target("lists_EnterNewListName ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target lists_EnterNewListName =new Target("lists_EnterNewListName ","Enter New List Name",Target.NAME);
	
	
	//-------------------Elements in My Custom  List Page --------------//

	public static final Target lists_ItemSelect1 =new Target("lists_ItemSelect ","(//*[@class='main-content']//*[@class='page-body']//*[@class='list-options']//a)[1]",Target.XPATH);
	
	
	//*[@class='main-content']//*[@class='page-body']//*[@class='list-options']//*[@class='name' and contains(text(),'NewTestList')]
	public static final Target lists_ItemSelect2 =new Target("lists_ItemSelect ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]",Target.XPATH);

																				//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]/android.widget.ListView[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[2]/android.view.View[1]																			
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]
	//	public static final Target lists_ItemSelect =new Target("lists_ItemSelect ","Order guide list Total Items: 5 List Owner",Target.NAME);
	
	
	public static final Target lists_Cart =new Target("lists_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	//public static final Target lists_Cart =new Target("lists_Cart ","",Target.NAME);
	

	
	
	
	//------------------Elements in Milk Items Product Page---------------
	
	public static final Target milkItems_title=new Target("milkItems_title ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target milkItems_title =new Target("milkItems_title ","Milk items",Target.NAME);
	
	
	public static final Target itemsInsideCustomList=new Target("itemsInsideCustomList ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]",Target.XPATH);
	//public static final Target itemsInsideCustomList =new Target("itemsInsideCustomList","Milk 2% Thickened Nectar",Target.NAME);
	
	
	public static final Target itemsInsideCustomList_PlusButton2=new Target("itemsInsideCustomList_PlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[15]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
																													//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[6]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]

	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[14]/android.view.View[1]
	public static final Target itemsInsideCustomList_PlusButton1=new Target("itemsInsideCustomList_PlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[6]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);///android.view.View[1]
	//public static final Target itemsInsideCustomList_PlusButton2=new Target("itemsInsideCustomList_PlusButton ","(//*[@class='mm-qty-input spin-container ']//*[@class='btn open-quantity']//*[@class='icon'])[1]",Target.XPATH);
	
	//public static final Target itemsInsideCustomList_Cart=new Target("itemsInsideCustomList_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	public static final Target itemsInsideCustomList_Cart=new Target("itemsInsideCustomList_Cart ","//*[@id='app-cart-button']//*[@href='/retrieve']//*[@class='icon spin-target']//*[@id='cart-count']",Target.XPATH);
	//public static final Target itemsInsideCustomList_Cart =new Target("itemsInsideCustomList_Cart ","",Target.NAME);
	//public static final Target itemsInsideCustomList_Create=new Target("itemsInsideCustomList_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	public static final Target itemsInsideCustomList_Create=new Target("itemsInsideCustomList_Cart ","//*[@id='ui-modal-container']//*[@class='create-order-page']//*[@class='page-header']//*[@class='create']",Target.XPATH);
	public static final Target itemsInsideCustomList_Filter=new Target("milkItems_Filter ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",Target.XPATH);
	//public static final Target MilkItems_Filter =new Target("itemsInsideCustomList_Cart ","",Target.NAME);
	
	public static final Target itemsInsideCustomList_SearchCatalog=new Target("milkItems_SearchCatalog ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target MilkItems_SearchCatalog =new Target("MilkItems_SearchCatalog ","Type to Filter List",Target.NAME);
	
	
	/*public static final Target milkItems_PlusButton=new Target("milkItems_PlusButton "," //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[14]/android.view.View[1]",Target.XPATH);
	//public static final Target milkItems_PlusButton =new Target("milkItems_PlusButton ","",Target.NAME);
	
	public static final Target milkItems_Cart=new Target("milkItems_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	//public static final Target MilkItems_Cart =new Target("MilkItems_Cart ","",Target.NAME);
	
	public static final Target milkItems_Filter=new Target("milkItems_Filter "," //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",Target.XPATH);
	//public static final Target MilkItems_Filter =new Target("MilkItems_Filter ","",Target.NAME);
	
	public static final Target milkItems_SearchCatalog=new Target("milkItems_SearchCatalog ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target MilkItems_SearchCatalog =new Target("MilkItems_SearchCatalog ","Type to Filter List",Target.NAME);
	*/
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	public MyCustomListsPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public MyCustomListsPage atListsPage()
	{
		log("At ListsPage",LogType.STEP);
		return this;
		
	}

	
	public MyCustomListsPage verifyListsPage()
	{
		log("Verify the ListsPage",LogType.STEP);
		return this;
	}
	
	public MyCustomListsPage customListstItem_Click()
	{
		try{
		log("at  CustomListsPage",LogType.STEP);
		getCommand().waitFor(10);
Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
//System.out.println(contextNames);
((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
//System.out.println( ((AndroidDriver)getCommand().driver).getContext());


		//System.out.println("Item from Custom List");
	Target target = lists_ItemSelect1;
//		Target target = lists_ItemSelect2;
		getCommand().waitForTargetPresent(target);
		//System.out.println("Item find from Custom list page");
		if (getCommand().isTargetPresent(target))
		{
			
			getCommand().waitFor(10);
			log("Select an item from CustomList : Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
//		System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"customListstItem_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "customListstItem_Click:Fail");
		}

		return this;
	}
	
	
	public MyCustomListsPage customListstItem_ClickWithScreenshot(String string)
	{
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		
		try{
			getCommand().captureScreenshot(finalPath);
		log("at  CustomListsPage",LogType.STEP);
		getCommand().waitFor(10);
Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
//System.out.println(contextNames);
((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
//System.out.println("Item from Custom List");
	Target target = lists_ItemSelect1;
		Target target1 = lists_ItemSelect2;
		getCommand().waitForTargetPresent(target);
		//System.out.println("Item find from Custom list page");
		if (getCommand().isTargetPresent(target))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(target);
			getCommand().waitFor(10);
			log("Select an item from CustomList : Pass",LogType.STEP);	
		}else
			if (getCommand().isTargetPresent(target1))
			{
				((AndroidDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath);
				((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
				getCommand().click(target);
				getCommand().waitFor(10);
				log("Select an item from CustomList : Pass",LogType.STEP);	
			}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "customListstItem_Click:Fail");
		}

		return this;
	}
	
	public MyCustomListsPage customListsPlusBtn_Click()
	{
		try{
			
		log("at CustomLists page",LogType.STEP);
		getCommand().waitFor(10);
Target target1= itemsInsideCustomList_PlusButton1;
Target target= itemsInsideCustomList_PlusButton2;
//		getCommand().waitForTargetPresent(target);
		if (getCommand().isTargetPresent(target))
		{
			
			getCommand().click(target);
			getCommand().waitFor(10);
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
		}else
		if (getCommand().isTargetPresent(target1))
		{
			
			getCommand().click(target1);
			getCommand().waitFor(10);
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"customListsPlusBtn_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "customListsPlusBtn_Click:Fail");
		}
		return this;
	}
	public MyCustomListsPage customLists_CreateClick() 
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at itemsInsideCustomList_Create",LogType.STEP);
		getCommand().waitFor(10);
		
		getCommand().waitForTargetPresent(itemsInsideCustomList_Create);
		//System.out.println("Clicking on Cart..");
		if (getCommand().isTargetPresent(itemsInsideCustomList_Create))
		{	getCommand().waitFor(10);
			getCommand().click(itemsInsideCustomList_Create);
			//System.out.println("Clicked on Create");
			log("Clicked on  create: Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"customLists_CreateClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "customLists_CreateClick:Fail");
		}
	return this;
	}
	
	public MyCustomListsPage customLists_CartClick() 
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at customLists_CartClick",LogType.STEP);
		getCommand().waitFor(10);
		
		getCommand().waitForTargetPresent(itemsInsideCustomList_Cart);
		//System.out.println("Clicking on Cart..");
		if (getCommand().isTargetPresent(itemsInsideCustomList_Cart))
		{	getCommand().waitFor(5);
			getCommand().click(itemsInsideCustomList_Cart);
			//System.out.println("Clicked on Cart");
			log("Clicked on  Items From Page Cart: Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"customLists_CartClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "customLists_CartClick:Fail");
		}
	return this;
	}
	
	
	

}		