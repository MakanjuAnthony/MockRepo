package com.components.pages;

import io.appium.java_client.ios.IOSDriver;

import java.util.Set;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class PurchasesPage extends SitePage {

	
//	public static final Target PurchasesPage = new Target("InvToolsPage","//*[@id='content-container']/div/nav/div/div/span/h3",Target.XPATH);
	public static final Target Purchases_Add = new Target("InvToolsPage","//*[@id='add-nav']/a/i",Target.XPATH);
	public static final Target Purchases_Back = new Target("InvToolsPage","//*[@id='back-nav']",Target.XPATH);
	public static final Target PurchasesDetails_Done = new Target("InvToolsPage","//*[@id='done-nav']",Target.XPATH);
	public static final Target PurchasesDetails_Supplier = new Target("InvToolsPage","//*[@id='supplier']",Target.XPATH);
	public static final Target PurchasesPage = new Target("InvToolsPage","//*[@class='navbar-brand']//*[contains(text(),'Purchases')]",Target.XPATH);
	
	//String LoginPage.drivePath="/Users/sujina_s/Desktop/Sysco/iOSScreenshot/";
	String pathExtension=".png";
	
	HomePage homepage=new HomePage(repository);
	public PurchasesPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public PurchasesPage atPurchasesPage()
	{
		log("In Purchases page",LogType.STEP);
		System.out.println("purchases pge");
		return this;
	}

	
public  PurchasesPage AddPurchases(String string){
		
		log("Creating purchases  ",LogType.STEP);
		  String string1="Success";
		  String string2="Issue";
		 
	    String finalPath=LoginPage.drivePath+string+string1+pathExtension;
	    String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
	    
	    try{
	   /* 	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
			System.out.println("contxtname is "+contextNames1);
			
			 for (String contextName : contextNames1){
				 System.out.println("inside loop "+contextNames1);
			 }
		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));		
*/		getCommand().waitForTargetPresent(PurchasesPage);
		
		if (getCommand().isTargetPresent(PurchasesPage))
		{
			getCommand().click(Purchases_Add);
		System.out.println("add button click");
			getCommand().waitForTargetPresent(PurchasesDetails_Done);
			 //((IOSDriver)getCommand().driver).context("NATIVE_APP");
			//getCommand().captureScreenshot(finalPath);
			
			log("Tapped  Add purchases :Pass",LogType.VERIFICATION_STEP);						
		}
		
	}
		catch(Exception e){
			getCommand().captureScreenshot(finalPath1);
			log("Tapped  Add purchases :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
			
		}
		
		return this;
		
	}

public  PurchasesPage SupplierSelect(String string){
	
	log("Creating purchases  ",LogType.STEP);
	  String string1="Success";
	  String string2="Issue";
	 
    String finalPath=LoginPage.drivePath+string+string1+pathExtension;
    String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
    
    try{
    /*	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
		System.out.println("contxtname is "+contextNames1);
		
		 for (String contextName : contextNames1){
			 System.out.println("inside loop "+contextNames1);
		 }
	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));		
*/	getCommand().waitForTargetPresent(PurchasesDetails_Supplier);
	
	if (getCommand().isTargetPresent(PurchasesDetails_Supplier))
	{
		//getCommand().click(PurchasesDetails_Supplier);
		getCommand().selectDropDown(PurchasesDetails_Supplier, 1);
		 //((IOSDriver)getCommand().driver).context("NATIVE_APP");
		 getCommand().waitFor(5);
	//	getCommand().waitForTargetPresent(PurchasesDetails_Done);
		//getCommand().captureScreenshot(finalPath);
		
		log("Selected  vendor:Pass",LogType.VERIFICATION_STEP);						
	}
	
}
	catch(Exception e){
		getCommand().captureScreenshot(finalPath1);
		log("Selected  vendor:Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
		
	}
	
	return this;
	
}

}
