package com.components.pages;

import io.appium.java_client.ios.IOSDriver;

import java.util.Set;

import org.testng.Assert;


import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;
import com.components.pages.HomePage;

public class ListPage extends SitePage{

	//String LoginPage.drivePath="/Users/sujina_s/Desktop/Sysco/iOSScreenshot/";
	String pathExtension=".png";
	
	 public static final Target SetUp_Pg1Title = new Target("SetUp_Pg1Title","//*[@class='mm-c-inventory-setup']//*[contains(text(),'Import Items')]",Target.XPATH);
	 public static final Target CustomList = new Target("CustomList", "//*[@type='button' and contains(text(),'Custom List')]",Target.XPATH);

	 public static final Target Continue = new Target("Continue","//*[@class='btn btn-default' and contains(text(),'Continue')]",Target.XPATH);
	 public static final Target Category_Header= new Target("Category_Header","//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3",Target.XPATH);
	 public static final Target Next= new Target("Next","//*[@id='next-nav']/a",Target.XPATH); 
		
	
	
	public ListPage(SiteRepository repository)
	{ 
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public ListPage atListPage()
	{
		log("Opened List Page ",LogType.STEP);
		return this;
	}
	
	public ListPage TapCustomList(String string)
   	{
   		  String string1="Success";
   		  String string2="Issue";
            
             String finalPath=LoginPage.drivePath+string+string1+pathExtension;
             String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
             
   		log("Selecting custom list  ",LogType.STEP);
   	
   		try{
   			/*Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
   	  		System.out.println("contxtname is "+contextNames1);
   	  		
   	  		 for (String contextName : contextNames1){
   	  			 System.out.println("inside loop "+contextNames1);
   	  		 }
   	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
*/   	  	
   			getCommand().waitForTargetPresent(SetUp_Pg1Title);
   			getCommand().waitForTargetPresent(CustomList);
   			getCommand().click(CustomList);
   			
   				log("Selected  custom list  from SetupInventoryImportItems:Pass",LogType.VERIFICATION_STEP);	
   		
   			//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
   		//getCommand().captureScreenshot(finalPath);
   		}
   		catch(Exception e){

   			getCommand().captureScreenshot(finalPath1);
   			log("Selected  custom list  from SetupInventoryImportItems :Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
   		
   		return this;
   		
   	} 
	public ListPage tapContinue(String string){
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
*/		  	
				getCommand().waitForTargetPresent(Continue);
			getCommand().click(Continue);
			  //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
	 	  	    
			//getCommand().captureScreenshot(finalPath);
				
			
			log("Tapped on Continue :Pass",LogType.VERIFICATION_STEP);
		}
		
		catch(Exception e)
		{
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on Continue :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		
		return this;
		
	}
	public ListPage SelectListwithItems(String name,String string)
	{
		
		  String pathExtension=".png";
		  String string1="Success";
		  String string2="Issue";
		  
	    String finalPath=LoginPage.drivePath+string+string1+pathExtension;
	    String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
	    
		log("Selecting location",LogType.STEP);
	try{
		String listName=name;
	/*	 Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
			
		 for (String contextName : contextNames){
			 System.out.println(contextNames);
		 }
	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
*/
	 getCommand().waitFor(2);
		//final Target  Listname= new Target("Locname","//*[@class='mm-c-product-list__select-list']//*[contains(text(),'"+listName+"')]",Target.XPATH);   
		final Target  Listname= new Target("Listname","//*[@class='mm-c-simplelist__item list-group-item']//*[contains(text(),'"+listName+"')]",Target.XPATH);   
		
		getCommand().click(Listname); 
	     
		
		//  $x("//*[@class='mm-c-product-minlist mm-c-product__custom']//*[contains(text(),'Test2')]/ancestor::div[@class='mm-c-product-minlist mm-c-product__custom']/child::div//label")
		
		  //((IOSDriver)getCommand().driver).context("NATIVE_APP");
		
	  
	       //getCommand().captureScreenshot(finalPath);
	  
			log("Select List from page:Pass",LogType.VERIFICATION_STEP);						
		}
		
		
		
		catch(Exception e){
			 getCommand().captureScreenshot(finalPath1); 
			log("Select List from page:Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	}
	
	 public ListPage TapOnNext(String string){
	       	String string1="Success";
	       	  String string2="Issue";

	       String finalPath=LoginPage.drivePath+string+string1+pathExtension;
	       String finalPath1=LoginPage.drivePath+string+string2+pathExtension;

	       	try{
	       		/*Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	      		System.out.println("contxtname is "+contextNames1);
	      		
	      		 for (String contextName : contextNames1){
	      			 System.out.println("inside loop "+contextNames1);
	      		 }
	      	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
	 */     	
	       			getCommand().waitForTargetPresent(Next);
	       		if (getCommand().isTargetPresent(Next))
	       		{
	       			
	       			getCommand().click(Next);
	       			
	       		 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
	       			log("Tapped on Next : Pass",LogType.VERIFICATION_STEP);
	       				//getCommand().captureScreenshot(finalPath);
	       		}
	       		
	       	}
	       	catch(Exception e)
	       	{
	       		log("Tapped on Next :Fail",LogType.VERIFICATION_STEP);
	       		getCommand().captureScreenshot(finalPath1);
	       		Assert.assertTrue(false);
	       	}
	       	
	       	return this;
	       }
}


