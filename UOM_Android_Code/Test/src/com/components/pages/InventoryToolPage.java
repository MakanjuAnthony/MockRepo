package com.components.pages;

import io.appium.java_client.ios.IOSDriver;

import java.util.Set;
import java.util.UUID;

import org.testng.Assert;

import com.components.repository.SiteRepository;

import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class InventoryToolPage extends SitePage{
	
	
	//String LoginPage.drivePath="/Users/sujina_s/Desktop/Sysco/iOSScreenshot/";
	String pathExtension=".png";
		  
		public static final Target InvTool_SetUpInv = new Target("InvTool_SetUpInv","//*[@id='menu-item']/a/div/span[contains(text(),'Setup Inventory')]",Target.XPATH);	
		public static final Target TrackInventory= new Target("TrackInventory","//*[@id='menu-item']/a/div/span[contains(text(),'Track Inventory')]",Target.XPATH);
		public static final Target LocationsPage = new Target("LocationsPage","//*[@class='navbar-brand']//*[contains(text(),'Locations')]",Target.XPATH);
		public static final Target PurchasesPage = new Target("InvToolsPage","//*[@class='navbar-brand']//*[contains(text(),'Purchases')]",Target.XPATH); 
		public static final Target InvTool_Vendors = new Target("InvTool_Vendors","//*[@id='menu-item']/a/div/span[contains(text(),'Suppliers')]",Target.XPATH);
	public static final Target  InvTool_Purchases= new Target("InvTool_Purchases","//*[@id='menu-item']/a/div/span[contains(text(),'Purchases')]",Target.XPATH);   //xpath: //*[@id="content-container"]/div/div/div[1]/a/span
	public static final Target InvTool_Locations = new Target("InvTool_Locations","//*[@id='menu-item']/a/div/span[contains(text(),'Locations')]",Target.XPATH);
	public static final Target VendorsPage = new Target("VendorsPage","//*[@class='navbar-brand']//*[contains(text(),'Suppliers')]",Target.XPATH);
	
	public InventoryToolPage(SiteRepository repository) {
		super(repository);
		
		
	}
	public InventoryToolPage atInventoryToolPage(String string)
	{
		log("Opened InventoryTool Page ",LogType.STEP);
		
		
		
		return this;
	}
	public InventoryToolPage InvTools_SetUpInventory(String string) {
		
		 String string1="Success";
		  String string2="Issue";
		  
		  String finalPath=LoginPage.drivePath+string+string1+pathExtension;
	        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
	        try{
				     
	        	/* Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
					System.out.println("contxtname is "+contextNames1);
					
					 for (String contextName : contextNames1){
						 System.out.println("inside loop "+contextNames1);
					 }
				System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
	*/			
		getCommand().waitForTargetPresent(InvTool_SetUpInv);

		getCommand().click(InvTool_SetUpInv);
		
		System.out.println("Tapped setup inventory");
		 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		//getCommand().captureScreenshot(finalPath);
			log("Navigating to Setup inventory page :Pass",LogType.VERIFICATION_STEP);						
		
	}
	catch(Exception e)
	{
		getCommand().captureScreenshot(finalPath1);
		log("Navigating to Setup inventory page :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	
	return this;
	
}
public  InventoryToolPage InvTools_TrackInventory(String string){
		
		log("Selecting TrackInventory from inventory tools page ",LogType.STEP);
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
	  	
*/	    		getCommand().waitForTargetPresent(TrackInventory);
		
		if (getCommand().isTargetPresent(TrackInventory))
		{
			getCommand().click(TrackInventory);
			getCommand().waitForTargetPresent(LocationsPage);
			
			 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			//getCommand().captureScreenshot(finalPath);
			
			log("Tapped  TrackInventory from inventory tools page:Pass",LogType.VERIFICATION_STEP);						
		}
		
	}
		catch(Exception e){
			getCommand().captureScreenshot(finalPath1);
			log("Tapped  TrackInventory from inventory tools page:Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
			
		}
		
		return this;
		
	}


public InventoryToolPage InvTools_Suppliers(String string)
{
	log("Tapping on Suppliers from Inventory tools page",LogType.STEP);
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
*/	getCommand().waitFor(5);
		getCommand().waitForTargetPresent(InvTool_Vendors);
		
		if (getCommand().isTargetPresent(InvTool_Vendors))
		{
			System.out.println("tapping Suppliers on invntry pg");
			log("Tap on Suppliers from Inventory tools page",LogType.STEP);	
			getCommand().click(InvTool_Vendors);
									
		}
		getCommand().waitForTargetPresent(VendorsPage);
		
		if (getCommand().isTargetPresent(VendorsPage))
		{
			System.out.println("inside vendrs pg");
			log("In Vendors Page",LogType.STEP);	
			log("Navigating to Vendors page :Pass",LogType.VERIFICATION_STEP);		
			 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			//getCommand().captureScreenshot(finalPath); 
		}
		
	}
	

	catch(Exception e)
	{
		getCommand().captureScreenshot(finalPath1); 
		log("Navigating to Vendors  page :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	
	return this;
	

}
public  InventoryToolPage InvTools_Purchases(String string){
	
	log("Selecting purchases from inventory tools page ",LogType.STEP);
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
*/    			getCommand().waitForTargetPresent(InvTool_Purchases);
	
	if (getCommand().isTargetPresent(InvTool_Purchases))
	{
		getCommand().click(InvTool_Purchases);
		System.out.println("clicking purchases");
		 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		//getCommand().captureScreenshot(finalPath);
		
		log("Tapped  purchases from inventory tools page:Pass",LogType.VERIFICATION_STEP);						
	}
	
}
	catch(Exception e){
		getCommand().captureScreenshot(finalPath1);
		log("Tapped  purchases from inventory tools page:Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
		
	}
	
	return this;
	
}
public InventoryToolPage InvTools_Locations(String string){
	
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
*/		getCommand().waitForTargetPresent(InvTool_Locations);
		if(getCommand().isTargetPresent(InvTool_Locations)){
			System.out.println("To tap locations");
			getCommand().click(InvTool_Locations);
			System.out.println("Tapped locations");
		}
		
        getCommand().waitForTargetPresent(LocationsPage);
		
		if (getCommand().isTargetPresent(LocationsPage))
		{
			System.out.println("Inside locations pg");
			 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			//getCommand().captureScreenshot(finalPath);
			log("In locations Page",LogType.STEP);	
			log("Navigating to Locations page :Pass",LogType.VERIFICATION_STEP);						
		}
	}
	catch(Exception e)
	{
		getCommand().captureScreenshot(finalPath1);
		log("Navigating to Locations page :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	
	return this;
	
}


	
}
