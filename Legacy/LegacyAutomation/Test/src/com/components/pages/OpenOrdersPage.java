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


public class OpenOrdersPage extends SitePage{

	public static final Target OpenOrdersPage_Order1 =new Target("OpenOrdersPage_Order1 ","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Open'])[127]",Target.XPATH);
	public static final Target OpenOrdersPage_Order2 =new Target("OpenOrdersPage_Order2 ","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Open'])[1]",Target.XPATH);
	
//	public static final Target OpenOrdersPage_Order1Web =new Target("OpenOrdersPage_Order1Web ","//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@data-order-status='Open'and @data-order-id='1018389']",Target.XPATH);
	public static final Target OpenOrdersPage_Order1Web =new Target("OpenOrdersPage_Order1Web ","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Open'])[1]",Target.XPATH);
	//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-id='1018053']

	
	//------------Apr 12 ---------
	//public static final Target OpenOrdersPage_RejectedOrder_NU =new Target("OpenOrdersPage_RejectedOrder_NU","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[2]",Target.XPATH);
//	public static final Target OpenOrdersPage_RejectedOrder_NU =new Target("OpenOrdersPage_RejectedOrder_NU","//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Rejected']/div[contains(text(),'Order number: 1020652')]",Target.XPATH);
	public static final Target OpenOrdersPage_PendingApproval =new Target("OpenOrdersPage_PendingApproval_MA","",Target.XPATH);
	public static final Target OpenOrdersPage_OpenedItem_NU =new Target("OpenOrdersPage_OpenedItem_NU","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Open'])[1]",Target.XPATH);
//	//*[@class='icon check spin-target']
//	public static final Target OpenOrdersPage_OpenedItem_NU =new Target("OpenOrdersPage_OpenedItem_NU","//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Open'and @data-order-id='1020650']",Target.XPATH);
	public static final Target OpenOrdersPage_RejectedOrder_NU =new Target("OpenOrdersPage_RejectedOrder_NU","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Rejected'])[1]",Target.XPATH);
	public static final Target OpenOrdersPage_PendingApproval_NU =new Target("OpenOrdersPage_PendingApproval_NU","(//*[@class='main-content']//*[@class='page-body']//*[@class='orders']//*[@class='order']//*[@data-order-status='Pending approval'])[79]//i",Target.XPATH);
//	public static final Target OpenOrdersPage_OpenedItem_NU =new Target("OpenOrdersPage_OpenedItem_NU","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[2]",Target.XPATH);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";
	
	public OpenOrdersPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public OpenOrdersPage atDeliveredPageOpenOrdersPage()
	{
		log("At OpenOrdersPage",LogType.STEP);
		return this;
		
	}
	
	
	public OpenOrdersPage openItem_Click(String string)
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
		log("at  OpenOrdersPage Page",LogType.STEP);
		getCommand().waitFor(5);
	    //System.out.println("In OpenOrdersPage ...Item Click");
		getCommand().waitForTargetPresent(OpenOrdersPage_Order1);
		if (getCommand().isTargetPresent(OpenOrdersPage_Order1))
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().waitFor(5);
			getCommand().click(OpenOrdersPage_Order1);
			
			log("Select on Open Item in OpenOrdersPage Page: Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "openItem_Click:Fail");
		}
		return this;
	}
	
	public OpenOrdersPage openItem2_Click()
	{
		try{
			Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

			//System.out.println(contextNames);


			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

			// getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

			//System.out.println( ((AndroidDriver)getCommand().driver).getContext());	
		log("at  OpenOrdersPage Page",LogType.STEP);
		getCommand().waitFor(5);
	    //System.out.println("In OpenOrdersPage ...Item Click");
		getCommand().waitForTargetPresent(OpenOrdersPage_Order1);
		if (getCommand().isTargetPresent(OpenOrdersPage_Order1))
		{
			getCommand().waitFor(5);
			getCommand().click(OpenOrdersPage_Order1);
			
			log("Select on Open Item in OpenOrdersPage Page: Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
getCommand().waitFor(10);
		}
		
		catch (Exception e) {
			Assert.assertFalse(true, "openItem_Click:Fail");
		}
		return this;
	}
	
	public OpenOrdersPage openItem_ClickWeb()
	
	{
		try{
		Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
		//System.out.println(contextNames);
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		// getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());

		log("at  OpenOrdersPage Page",LogType.STEP);
		getCommand().waitFor(10);
	    //System.out.println("In OpenOrdersPage ...Item Click");
		getCommand().waitForTargetPresent(OpenOrdersPage_Order1Web);
		if (getCommand().isTargetPresent(OpenOrdersPage_Order1Web))
		{
			getCommand().waitFor(5);
			getCommand().click(OpenOrdersPage_Order1Web);
			
			log("Select on Open Item in OpenOrdersPage Page: Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		getCommand().waitFor(10);
		}
		catch (Exception e) {
			Assert.assertFalse(true, "openItem_ClickWeb:Fail");
		}
		return this;
	}

public OpenOrdersPage openItem_ClickWebWithScreenshot(String string)
	
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
		log("at  OpenOrdersPage Page",LogType.STEP);
		getCommand().captureScreenshot(finalPath);
		getCommand().waitFor(10);
	    //System.out.println("In OpenOrdersPage ...Item Click");
		getCommand().waitForTargetPresent(OpenOrdersPage_Order1Web);
		if (getCommand().isTargetPresent(OpenOrdersPage_Order1Web))
		{
			
			getCommand().waitFor(5);
			getCommand().click(OpenOrdersPage_Order1Web);
			
			log("Select on Open Item in OpenOrdersPage Page: Pass",LogType.STEP);	
		}
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		getCommand().waitFor(10);
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "openItem_ClickWeb:Fail");
		}
		return this;
	}

	
	//-------------------April 12 --------------
		public OpenOrdersPage rejectedItem_Click(String string)
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

	
			log("at  OpenOrdersPage ",LogType.STEP);
			getCommand().waitFor(10);
		    //System.out.println("In OpenOrdersPage ...Rejected Item Click");
			getCommand().waitForTargetPresent(OpenOrdersPage_RejectedOrder_NU);
			if (getCommand().isTargetPresent(OpenOrdersPage_RejectedOrder_NU))
			{
				((AndroidDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath);
				((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
				getCommand().waitFor(5);
				getCommand().click(OpenOrdersPage_RejectedOrder_NU);
				
				log("Select on RejectedOrder Item in OpenOrdersPage Page: Pass",LogType.STEP);	
			}
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
	getCommand().waitFor(10);


			}
			catch (Exception e) {
				getCommand().captureScreenshot(finalPath1);
				Assert.assertFalse(true, "rejectedItem_Click:Fail");
			}
			return this;
		}

		public OpenOrdersPage pendingApprovalItem_Click(String string)
		{
			String string1="Success";
			String string2="Issue";
			String finalPath=drivePath+string+string1+pathExtension;
			String finalPath1=drivePath+string+string2+pathExtension;
			getCommand().captureScreenshot(finalPath);
			try{
				Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

				 //System.out.println(contextNames);


				 ((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

				 // getCommand().switchToWindow("WEBVIEW_com.syscocorp.uomqa");

				 //System.out.println( ((AndroidDriver)getCommand().driver).getContext());
	
			log("at  OpenOrdersPage ",LogType.STEP);
			getCommand().waitFor(10);
			
		    //System.out.println("In OpenOrdersPage ...Pending Approval Item Click");
			getCommand().waitForTargetPresent(OpenOrdersPage_PendingApproval_NU);
			if (getCommand().isTargetPresent(OpenOrdersPage_PendingApproval_NU))
			{
				((AndroidDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath);
				((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
				
				getCommand().waitFor(5);
				getCommand().click(OpenOrdersPage_PendingApproval_NU);
				
				log("Select on PendingApproval Item in OpenOrdersPage Page: Pass",LogType.STEP);	
			}
			}
			catch (Exception e) {
				getCommand().captureScreenshot(finalPath1);
				Assert.assertFalse(true, "pendingApprovalItem_Click:Fail");
			}
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
	getCommand().waitFor(10);
			return this;
		}
		
		
		public OpenOrdersPage openItem_NU_Click(String string)
		{
			String string1="Success";
			String string2="Issue";
			String finalPath=drivePath+string+string1+pathExtension;
			String finalPath1=drivePath+string+string2+pathExtension;
			try{
				 Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();

				 System.out.println(contextNames);


				 ((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

				 System.out.println( ((AndroidDriver)getCommand().driver).getContext());


			log("at  OpenOrdersPage Page - Normal User",LogType.STEP);
			getCommand().waitFor(10);
		    //System.out.println("In OpenOrdersPage ...Item Click");
//			((AndroidDriver) getCommand().driver).scrollTo("Open").click();
			getCommand().waitForTargetPresent(OpenOrdersPage_OpenedItem_NU);
			if (getCommand().isTargetPresent(OpenOrdersPage_OpenedItem_NU))
			{
				((AndroidDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath);
				((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
				getCommand().waitFor(5);
				getCommand().click(OpenOrdersPage_OpenedItem_NU);
				
				log("Select on Open Item in OpenOrdersPage Page of Normal User: Pass",LogType.STEP);	
			}
			
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
	getCommand().waitFor(10);
			}
			catch (Exception e) {
				getCommand().captureScreenshot(finalPath1);
				Assert.assertFalse(true, "openItem_NU_Click:Fail");
			}
			return this;
		}
}		

