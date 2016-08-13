
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



public class ProductCategoriesPage extends SitePage{
	
	/* Defining the locators on the Page */ 
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]
	public static final Target productCategories_CartNU = new Target("productCategories_CartNU","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);

	public static final Target ProductCategories_title = new Target("ProductCategories_title","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target orderGuide_PlusButton=new Target("orderGuide_PlusButton","Product Categories",Target.NAME);
	
	//-------------------Selecting Dairy Products--------------//

	public static final Target ProductCategories_FirstItemSelect =new Target("ProductCategories_FirstItemSelect ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[4]/android.view.View[2]/android.view.View[1]",Target.XPATH);
	//public static final Target ProductCategories_FirstItemSelect =new Target("ProductCategories_FirstItemSelect ","Dairy Products ",Target.NAME);
																													

	public static final Target ProductCategories_SecondItemSelect =new Target("ProductCategories_SecondItemSelect ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.ListView[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]",Target.XPATH);
	//public static final Target ProductCategories_SecondItemSelect =new Target("ProductCategories_SecondItemSelect ","Eggs ",Target.NAME);
	
	public static final Target ProductCategories_ThirdItemSelect =new Target("ProductCategories_ThirdItemSelect ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.ListView[1]/android.view.View[2]/android.widget.ListView[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]",Target.XPATH);
	//public static final Target ProductCategories_ThirdItemSelect =new Target("ProductCategories_ThirdItemSelect ","Shell Eggs ",Target.NAME);
	
	
	
	//------------------Elements in Dairy Product Page---------------
	public static final Target DairyProducts_title=new Target("DairyProducts_title ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",Target.XPATH);
	//public static final Target DairyProducts_title =new Target("DairyProducts_title ","Dairy Products",Target.NAME);

	public static final Target dairyProducts_PlusButton1=new Target("dairyProducts_PlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[14]/android.view.View[1]",Target.XPATH);
	public static final Target dairyProducts_PlusButton2=new Target("dairyProducts_PlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]",Target.XPATH);
	
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]
	//public static final Target dairyProducts_PlusButton =new Target("dairyProducts_PlusButton ","",Target.NAME);
	
	public static final Target dairyProducts_Cart=new Target("dairyProducts_Cart ","//*[@id='app-cart-button']//*[@href='/retrieve']",Target.XPATH);
	//public static final Target dairyProducts_Cart =new Target("dairyProducts_Cart ","",Target.NAME);
	
	public static final Target dairyProducts_Filter=new Target("dairyProducts_Filter ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",Target.XPATH);
	//public static final Target dairyProducts_Filter =new Target("dairyProducts_Filter ","",Target.NAME);
	
	public static final Target dairyProducts_SearchCatalog=new Target("dairyProducts_SearchCatalog ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	//public static final Target dairyProducts_SearchCatalog =new Target("dairyProducts_SearchCatalog ","Type to Filter List",Target.NAME);
	
	
	public static final Target categories_Create=new Target("categories_Create ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	//public static final Target dairyProducts_SearchCatalog =new Target("dairyProducts_SearchCatalog ","Type to Filter List",Target.NAME);
	
	//--------------------Apr 12 ---------
	
	public static final Target productCategories_PlusButton=new Target("productCategories_PlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]",Target.XPATH);
																										//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[7]/android.view.View[1]

	//public static final Target dairyProducts_PlusButton =new Target("dairyProducts_PlusButton ","",Target.NAME);
	
	public static final Target productCategories_Cart=new Target("dairyProducts_Cart ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]",Target.XPATH);
	//public static final Target dairyProducts_Cart =new Target("dairyProducts_Cart ","",Target.NAME);
	
	public static final Target productCategories_SecondPlusButton=new Target("productCategories_SecondPlusButton ","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]/android.view.View[18]/android.view.View[1]",Target.XPATH);
	//public static final Target productCategories_SecondPlusButton =new Target("productCategories_SecondPlusButton ","",Target.NAME);
	
	//May 26
	public static final Target productCategories_FirstPlusButton=new Target("productCategories_FirstPlusButton","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[6]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[13]
	public static final Target Brand_SecondPlusButton=new Target("Brand_SecondPlusButton","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[12]/android.view.View[1]/android.view.View[1]/android.view.View[3]",Target.XPATH);
																							//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.view.View[12]/android.view.View[1]/android.view.View[1]/android.view.View[3]
	                  																		//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[23]
	public static final Target category_Cart=new Target("category_Cart","//*[@id='app-cart-button']//*[@href='/retrieve']//*[@class='icon spin-target']//*[@id='cart-count']",Target.XPATH);
	public static final Target category_Create=new Target("category_Create","//*[@id='ui-modal-container']//*[@class='create-order-page']//*[@class='page-header']//*[@class='create']",Target.XPATH);
	
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";

	String pathExtension=".png";
	
	
	public ProductCategoriesPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public ProductCategoriesPage atProductCategoriesPage()
	{
		log("At Order Guide",LogType.STEP);
		return this;
		
	}

	
	public ProductCategoriesPage verifyProductCategoriesPage()
	{
		log("Verify the Home Page Logo",LogType.STEP);
		return this;
	}
	
	public ProductCategoriesPage Item_Click()
	{
		try{
		log("at  ProductCategories Page",LogType.STEP);
	    //System.out.println("In Product Categories ...Item Click");
		getCommand().waitForTargetPresent(ProductCategories_FirstItemSelect);
		if (getCommand().isTargetPresent(ProductCategories_FirstItemSelect))
		{
			
			getCommand().click(ProductCategories_FirstItemSelect);
			getCommand().waitFor(5);
			log("Select on Order Guide Tab: Pass",LogType.STEP);	
		}
		
		getCommand().waitForTargetPresent(ProductCategories_SecondItemSelect);
		if (getCommand().isTargetPresent(ProductCategories_SecondItemSelect))
		{
			
			getCommand().click(ProductCategories_SecondItemSelect);
			getCommand().waitFor(5);
			log("Select on Order Guide Tab: Pass",LogType.STEP);	
		}
		
		
		getCommand().waitForTargetPresent(ProductCategories_ThirdItemSelect);
		if (getCommand().isTargetPresent(ProductCategories_ThirdItemSelect))
		{
			
			getCommand().click(ProductCategories_ThirdItemSelect);
			getCommand().waitFor(5);
			log("Select ProductCategories_ThirdItem : Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"Item_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "pItem_Click:Fail");
		}
		
		return this;
	}
	
	
	public ProductCategoriesPage Item_Click_WithScreenshot(String string)
	{
		String string1="Success";
		String string2="Issue";
	    String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		
		try{
			
			
		log("at  ProductCategories Page",LogType.STEP);
	    //System.out.println("In Product Categories ...Item Click");
		getCommand().waitForTargetPresent(ProductCategories_FirstItemSelect);
		if (getCommand().isTargetPresent(ProductCategories_FirstItemSelect))
		{
			
			getCommand().click(ProductCategories_FirstItemSelect);
			getCommand().waitFor(5);
			log("Select on Order Guide Tab: Pass",LogType.STEP);	
		}
		
		getCommand().waitForTargetPresent(ProductCategories_SecondItemSelect);
		if (getCommand().isTargetPresent(ProductCategories_SecondItemSelect))
		{
			
			getCommand().click(ProductCategories_SecondItemSelect);
			getCommand().waitFor(5);
			
			
//				getCommand().captureScreenshot(finalPath);
		
			
			log("Select on Order Guide Tab: Pass",LogType.STEP);	
		}
		
		
		getCommand().waitForTargetPresent(ProductCategories_ThirdItemSelect);

		if (getCommand().isTargetPresent(ProductCategories_ThirdItemSelect))
		{
			
			getCommand().click(ProductCategories_ThirdItemSelect);
			getCommand().waitFor(5);
			log("Select ProductCategories_ThirdItem : Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "pItem_Click:Fail");
		}
		
		return this;
	}
	
	
	public ProductCategoriesPage PlusBtn_Click()
	{
		try{
		log("at  ProductCategoriesPage",LogType.STEP);
		Target target = null;
		target=dairyProducts_PlusButton2;
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
			String finalPath1=drivePath+"PlusBtn_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "PlusBtn_Click:Fail");
		}
		return this;
	}
	public ProductCategoriesPage categories_CreateClick() 
	{
		try{
		getCommand().waitFor(10);
		log("at orderGuide_CartClick",LogType.STEP);
		getCommand().waitForTargetPresent(categories_Create);
		if (getCommand().isTargetPresent(categories_Create))
		{
				
			getCommand().click(categories_Create);
			getCommand().waitFor(5);
			log("Clicked on dairyProduct Page Cart: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"categories_CreateClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "categories_CreateClick:Fail");
		}
	return this;
	}
	public ProductCategoriesPage categories_CartClick() 
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at orderGuide_CartClick",LogType.STEP);
		getCommand().waitForTargetPresent(dairyProducts_Cart);
		if (getCommand().isTargetPresent(dairyProducts_Cart))
		{
				
			getCommand().click(dairyProducts_Cart);
			getCommand().waitFor(5);
			log("Clicked on dairyProduct Page Cart: Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"categories_CartClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "categories_CartClick:Fail");
		}
	return this;
	}
	
//-------------Apr 12 ---------
	public ProductCategoriesPage NU_PlusBtn_Click()
	{
		try{
		log("at  ProductCategoriesPage",LogType.STEP);
		
		getCommand().waitForTargetPresent(productCategories_PlusButton);
		if (getCommand().isTargetPresent(productCategories_PlusButton))
		{
			
			getCommand().click(productCategories_PlusButton);
			
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
			getCommand().waitFor(10);
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"NU_PlusBtn_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "NU_PlusBtn_Click:Fail");
		}
		return this;
	}
	
	public ProductCategoriesPage NU_categories_CartClick() 
	{
		try{
		getCommand().waitFor(10);
		log("at orderGuide_CartClick",LogType.STEP);
		getCommand().waitForTargetPresent(productCategories_CartNU);
		if (getCommand().isTargetPresent(productCategories_CartNU))
		{
				
			getCommand().click(productCategories_CartNU);
			getCommand().waitFor(5);
			log("Clicked on dairyProduct Page Cart: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"NU_categories_CartClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "NU_categories_CartClick:Fail");
		}
	return this;
	}
	
	
	public ProductCategoriesPage SecondPlusButton_Click()
	{
		try{
		getCommand().waitFor(10);
		//System.out.println("SecondPlus Btn Click");
		log("at createNewOrder_OrderGuide",LogType.STEP);
		
		getCommand().waitForTargetPresent(productCategories_SecondPlusButton);
		if (getCommand().isTargetPresent(productCategories_SecondPlusButton))
		{

			getCommand().click(productCategories_SecondPlusButton);
			getCommand().waitFor(5);
			log("Clicked on Second Plus Button: Pass",LogType.STEP);	
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"SecondPlusButton_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "SecondPlusButton_Click:Fail");
		}
		return this;
	}
	
	
	//May 26
	public ProductCategoriesPage plus_Click()
	{
		try{
		log("at  ProductCategoriesPage",LogType.STEP);
		Target target = null;
		target=productCategories_FirstPlusButton;
		getCommand().waitFor(8);
		getCommand().waitForTargetPresent(target);
		if (getCommand().isTargetPresent(target))
		{
			System.out.println("inside if");
			getCommand().click(target);
			System.out.println("plus clicked");
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
			getCommand().waitFor(15);
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"plus_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "plus_Click:Fail");
		}
		return this;
	}
	
	
	public ProductCategoriesPage second_Plus_Click()
	{
		try{
		log("at  ProductCategoriesPage",LogType.STEP);
		Target target = null;
		target=Brand_SecondPlusButton;
		getCommand().waitFor(12);
		getCommand().waitForTargetPresent(target);
		if (getCommand().isTargetPresent(target))
		{
			System.out.println("inside if");
			getCommand().click(target);
			System.out.println("plus clicked");
			log("Clicked on Plus Btn : Pass",LogType.STEP);	
			getCommand().waitFor(15);
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"second_Plus_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "second_Plus_Click:Fail");
		}
		return this;
	}
	
	public ProductCategoriesPage cart_Click() throws InterruptedException
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at cart_Click",LogType.STEP);
		getCommand().waitFor(10);
		//System.out.println("Clicking on Cart..");
		getCommand().waitForTargetPresent(category_Cart);
		if (getCommand().isTargetPresent(category_Cart))
		{	getCommand().waitFor(10);
			getCommand().click(category_Cart);
			
			log("Clicked on Cart : Pass",LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"cart_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "cart_Click:Fail");
		}
		
	return this;
	}
	
	public ProductCategoriesPage create_Click() throws InterruptedException
	{
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		log("at create_Click",LogType.STEP);
		getCommand().waitFor(10);
		//System.out.println("Clicking on Create..");
		getCommand().waitForTargetPresent(category_Create);
		
		if (getCommand().isTargetPresent(category_Create))
				
		{	getCommand().waitFor(5);
			getCommand().click(category_Create);
			
			log("Clicked on Create : Pass",LogType.STEP);	
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"create_Click"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "create_Click:Fail");
		}
		
	return this;
	}
}		