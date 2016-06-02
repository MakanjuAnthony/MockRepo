package com.components.pages;

import java.util.Set;


//import io.appium.java_client.ios.IOSDriver;

import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;


import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;
import com.components.pages.VendorPage;



public class SetupInventoryPage extends SitePage{
	
	//String LoginPage.drivePath="/Users/sujina_s/Desktop/Sysco/iOSScreenshot/";
	String pathExtension=".png";
	VendorPage vp=new VendorPage(repository);
	
	 public static final Target SetUp_Pg1Title = new Target("SetUp_Pg1Title","//*[@class='mm-c-inventory-setup']//*[contains(text(),'Import Items')]",Target.XPATH);
	 public static final Target StartFromScratch = new Target("StartFromScratch","//*[@class='btn btn-sm btn-primary' and contains(text(),'Start From Scratch')]",Target.XPATH);
	 public static final Target OrderGuide = new Target("OrderGuide", "//*[@type='button' and contains(text(),'Order Guide')]",Target.XPATH);
	// public static final Target AddItem_OrderGuide = new Target("OrderGuide","//*[@class='btn btn-sm btn-primary' and contains(text(),'Order Guide')]",Target.XPATH);
		
	 public static final Target Continue = new Target("Continue","//*[@class='btn btn-default' and contains(text(),'Continue')]",Target.XPATH);
	 public static final Target AddItems_Scratch = new Target("AddItems_Scratch","//*[@class='btn-default btn btn-default' and contains(text(),'Add Items')]",Target.XPATH);
	 public static final Target AddItemFromPage_Scratch = new Target("AddItemFromPage_Scratch","//*[@class='navbar-brand']//*[contains(text(),'Add Item From')]",Target.XPATH);
	 public static final Target OrderGuidePage = new Target("OrderGuidePage","//*[@class='navbar-brand']//*[contains(text(),'Order Guide')]",Target.XPATH);
	 public static final Target OrderGuide_FirstItemSelect= new Target("OrderGuide_FirstItemSelect","(//*[@id='mount']//*[@class='mm-o-icon'])[1]",Target.XPATH); 
	//public static final Target OrderGuide_FirstItemHeader= new Target("OrderGuide_FirstItemHeader","//*[@id='mount']/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/div[2]/h4",Target.XPATH); 
	 public static final Target OrderGuide_1stItemHeading= new Target("OrderGuide_1stItemHeading","(//*[@class='mm-c-product-list']//*[@class='mm-c-product-minlist__item'])[1]/h4",Target.XPATH); 
	// public static final Target Done= new Target("Done","//*[@id='done-nav']/a",Target.XPATH);	
	 public static final Target Done= new Target("DoneWeb","//*[@id='done-nav']/a",Target.XPATH); 
	 public static final Target Return= new Target("Return","//UIAStaticText[@label='Return']",Target.XPATH); 
		 
	 public static final Target Category_Header= new Target("Category_Header","//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3",Target.XPATH);
	 public static final Target AddItem_OrderGuide = new Target("OrderGuide","//*[@id='list-item']//*[contains(text(),'Browse Order Guide')]",Target.XPATH);
		
	 
/*	 public static final Target AddItem_NonSyscoItem = new Target("AddItem_NonSyscoItem","//UIAButton[@label='Non-Sysco Item']",Target.XPATH);
    public static final Target AddItem_PrepItem = new Target("AddItem_PrepItem","//UIAButton[@label='Prep Item']",Target.XPATH);
    public static final Target AddProduct_Page = new Target("AddProduct_Page","//UIAStaticText[@label='Add Product']",Target.XPATH);
	 public static final Target SetUp_Pg2Title = new Target("SetUp_Pg2Title","//UIAStaticText[@label='SETUP LOCATIONS']",Target.XPATH);
	 public static final Target AddProductPage_AddSupplier= new Target("ExpenseCategory","//UIALink[@label='Add/Select Supplier']",Target.XPATH); 
	*/ public static final Target AddItem_NonSyscoItem = new Target("AddItem_NonSyscoItem","//*[@id='list-item']//*[contains(text(),'Create Non-Sysco Item')]",Target.XPATH);
	
	   //public static final Target SetUp_Pg2Title = new Target("SetUp_Pg2Title","//UIAStaticText[@label='SETUP LOCATIONS']",Target.XPATH);
	   public static final Target SetUp_Pg2Title = new Target("SetUp_Pg1Title","//*[@class='mm-c-inventory-setup']//*[contains(text(),'SETUP LOCATIONS')]",Target.XPATH);
		
		public static final Target AddItem_PrepItem = new Target("AddItem_PrepItem","//*[@id='list-item']//*[contains(text(),'Create Prep Item')]",Target.XPATH);
	public static final Target AddProduct_Page = new Target("AddProduct_Page","//*[@class='navbar-brand']//*[contains(text(),'Add Product')]",Target.XPATH);
	public static final Target AddProductPage_AddSupplier= new Target("AddProductPage_AddSupplier","//*[@class='row']//*[contains(text(),'Add/Select Supplier')]",Target.XPATH);
		 
		 
		    public static final Target AddProductPage_ProductName = new Target("AddProductPage_ProductName","//*[@id='name']",Target.XPATH);
		    public static final Target AddProductPage_UPC = new Target("AddProductPage_UPC","//*[@id='materialId']",Target.XPATH);
			public static final Target AddProductPage_Pack = new Target("AddProductPage_Pack","//*[@id='pack']",Target.XPATH); 
			public static final Target AddProductPage_Size = new Target("AddProductPage_Size","//*[@id='size']",Target.XPATH);
			public static final Target AddProductPage_Weight = new Target("AddProductPage_Weight","//*[@id='averageWeightPerCase']",Target.XPATH);
			public static final Target AddProductPage_Price = new Target("AddProductPage_Price","//*[@id='price']",Target.XPATH); 
			public static final Target AddProductPage_ProductBrand = new Target("AddProductPage_ProductBrand ","//*[@id='brand']",Target.XPATH); 
			
	/*public static final Target SetUp_Pg1Title = new Target("SetUp_Pg1Title","//UIAStaticText[@label='IMPORT ITEMS']",Target.XPATH);
	 public static final Target StartFromScratch = new Target("StartFromScratch","//UIAButton[@label='Start From Scratch']",Target.XPATH);
	 public static final Target Continue = new Target("Continue","//UIAButton[@label='Continue']",Target.XPATH);
	 public static final Target AddItems_Scratch = new Target("AddItems_Scratch","//UIAButton[@label='Add Items']",Target.XPATH);
	 public static final Target AddItemFromPage_Scratch = new Target("AddItemFromPage_Scratch","//UIAStaticText[@label='Add Item From']",Target.XPATH);
	 public static final Target AddItem_NonSyscoItem = new Target("AddItem_NonSyscoItem","//UIAButton[@label='Non-Sysco Item']",Target.XPATH);
	    public static final Target AddItem_PrepItem = new Target("AddItem_PrepItem","//UIAButton[@label='Prep Item']",Target.XPATH);
	    public static final Target AddProduct_Page = new Target("AddProduct_Page","//UIAStaticText[@label='Add Product']",Target.XPATH);
	    public static final Target OrderGuide = new Target("OrderGuide","//UIAButton[@label='Order Guide']",Target.XPATH);
	    public static final Target Category_Header= new Target("Category_Header","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[8]",Target.XPATH);
	    public static final Target Done= new Target("Done","//UIAStaticText[@label='Done']",Target.XPATH); 
	    public static final Target OrderGuide_FirstItemSelect= new Target("Category_FirstItemSelect","(//*[@id='mount']//*[@class='mm-o-icon'])[1]",Target.XPATH); 
		
	    public static final Target OrderGuide_1stItemHeading= new Target("OrderGuide_1stItemHeading","(//*[@class='mm-c-product-list']//*[@class='mm-c-product-minlist__item'])[1]/h4",Target.XPATH); 
		 public static final Target AddProductPage_AddSupplier= new Target("ExpenseCategory","//UIALink[@label='Add/Select Supplier']",Target.XPATH); 
		 public static final Target AddProductPage_ProductName = new Target("AddProductPage_ProductName","//*[@id='name']",Target.XPATH);
		    public static final Target AddProductPage_UPC = new Target("AddProductPage_UPC","//*[@id='materialId']",Target.XPATH);
			public static final Target AddProductPage_Pack = new Target("AddProductPage_Pack","//*[@id='pack']",Target.XPATH); 
			public static final Target AddProductPage_Size = new Target("AddProductPage_Size","//*[@id='size']",Target.XPATH);
			public static final Target AddProductPage_Weight = new Target("AddProductPage_Weight","//*[@id='averageWeightPerCase']",Target.XPATH);
			public static final Target AddProductPage_Price = new Target("AddProductPage_Price","//*[@id='price']",Target.XPATH); 
			public static final Target AddProductPage_ProductBrand = new Target("AddProductPage_ProductBrand ","//*[@id='brand']",Target.XPATH); 
			public static final Target SetUp_Pg2Title = new Target("SetUp_Pg2Title","//UIAStaticText[@label='SETUP LOCATIONS']",Target.XPATH);
*/			public static final Target OrderGuide_FirstItemHeader= new Target("Category_FirstItemSelect","//*[@id='mount']/div/div[2]/div[1]/div/div/div[1]/div/div[2]/h4",Target.XPATH); 
			 public static String  ItemName;
			 public String SearchItemName;
				
			/////////
		//	public static final Target AddProductPage_Option = new Target("AddProductPage_Option","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]",Target.XPATH);
			public static final Target SetUp_Pg3Title = new Target("SetUp_Pg3Title","//UIAStaticText[@label='SET UP FOOD COST']",Target.XPATH);
		    public static final Target SkipStep_TrackFoodCostPg = new Target("SkipStep_TrackFoodCostPg","//UIAStaticText[@label='Skip This Step']",Target.XPATH);
		    public static final Target FoodAndNonFood = new Target("FoodAndNonFood","//UIAButton[@label='Food & Non-Food']",Target.XPATH);
		    public static final Target  SuggestedCategories = new Target("SuggestedCategories","//UIAButton[@label='Suggested Categories']",Target.XPATH);
		    public static final Target  CustomCategories = new Target("CustomCategories","//UIAButton[@label='Custom Categories']",Target.XPATH);
		    public static final Target InvToolsPg = new Target("InvToolsPg","//UIAStaticText[@label='Inventory Tools']",Target.XPATH);

			public String CategoryName;
			public String ItemNameSelected;
			public String ItemNameAdded;
		 
			public static final Target setupInventryFirstProduct= new Target("Category_FirstItemHeader","//*[@id='content-container']/div/div/div[1]/div/div/div/div/div[3]/h4",Target.XPATH); 
			
			public static final Target OrderGuide_1stItemSelect= new Target("OrderGuide_1stItemSelect","(//*[@class='mm-c-product-list']//*[@class='mm-o-icon'])[1]",Target.XPATH); 
			public static final Target OrderGuide_2ndItemSelect= new Target("OrderGuide_2ndItemSelect","(//*[@class='mm-c-product-list']//*[@class='mm-o-icon'])[2]",Target.XPATH); 
			public static final Target OrderGuide_3rdItemSelect= new Target("OrderGuide_3rdItemSelect","(//*[@class='mm-c-product-list']//*[@class='mm-o-icon'])[3]",Target.XPATH); 
			 
			public static final Target OrderGuide_2ndItemHeading= new Target("OrderGuide_2ndItemHeading","(//*[@class='mm-c-product-list']//*[@class='mm-c-product-minlist__item'])[2]/h4",Target.XPATH); 
			public static final Target OrderGuide_3rdItemHeading= new Target("OrderGuide_3rdItemHeading","(//*[@class='mm-c-product-list']//*[@class='mm-c-product-minlist__item'])[3]/h4",Target.XPATH); 
			
			public static final Target SetUpInventory_ItemsAddedViaOrderGuide= new Target("SetUpInventory_ItemsAddedViaOrderGuide","//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='Grid__cell']",Target.XPATH); 
			 
			 int noOfElements = 0;
			 public String ItemName1;
			 public String ItemName2;
			 public String ItemName3;
			  String ItemAdded=null;
			  public static final Target  FirstItemSelectedFromUncatgorised= new Target("FirstItemSelectedFromUncatgorised","(//*[@id='content-container']//*[@class='mm-o-icon'])[2]",Target.XPATH);
			  public static final Target  FirstItemSelectedFromUncatgorisedHeading= new Target("FirstItemSelectedFromUncatgorised","(//*[@id='content-container']//*[@class='mm-c-product-list__details-wrapper'])[2]/h4",Target.XPATH);
		          
			  public static final Target  FirstItemSelectedFromUncatgorisedAllItemsString= new Target("FirstItemSelectedFromUncatgorised","//*[@id='content-container']//*[@class='mm-c-product-list__details-wrapper']/h4",Target.XPATH);
			  public static final Target AddProductPage_ModalWindowForAddSupplierYes = new Target("AddProductPage_ModalWindowForAddSupplierYes","//*[@class='modal-content']//*[@id='yes-button']",Target.XPATH);
			
			  
			  public static final Target AddItemsLink= new Target("AddItemsLink","//*[@class='mm-c-product-list__sticky-row mm-u-navbar-padding']//span[contains(text(),'Add More Items')]",Target.XPATH);
			  public static final Target AddItemFromPage_PrepItemWeb = new Target("AddItemFromPage_PrepItem","//*[@id='list-item' and contains(text(),'Prep Item')]",Target.XPATH);
			  public static final Target Skip = new Target("Skip","//*[@id='skip']/a",Target.XPATH); 
			  public static final Target Search = new Target("Search","//*[@placeholder='Search']",Target.XPATH);
		
			  public static final Target AddProductPage_AddLocations= new Target("AddProductPage_AddLocations","//*[@class='row']//*[contains(text(),'Add/Select Location(s)')]",Target.XPATH);			
			  public static final Target AddProductPage_AddCategory= new Target("AddProductPage_AddCategory","//*[@class='row']//*[contains(text(),'Add/Select Expense Category')]",Target.XPATH);			
			  public static final Target DoThisLater = new Target("DoThisLater", "//*[contains(text(),'Do This Later')]",Target.XPATH);
			  
			  public static final Target ReadyToTrack = new Target("ReadyToTrack", "//*[@class='btn btn-default']//*[contains(text(),'Ready to track your inventory?')]",Target.XPATH);
			  public static final Target ReadyToStart = new Target("ReadyToStart", "//*[@class='btn btn-default']//*[contains(text(),'ready to get started')]",Target.XPATH);
			  public static final Target Next = new Target("next","//*[@id='next']",Target.XPATH); 
			  public static final Target CustomList = new Target("CustomList", "//*[@type='button' and contains(text(),'Custom List')]",Target.XPATH);
				
			  
			  public SetupInventoryPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public SetupInventoryPage atSetupInventoryPage()
	{
		log("Opened SetupInventory Page ",LogType.STEP);
		return this;
	}

	public SetupInventoryPage StartFromScratch(String string){
		  String string1="Success";
		  String string2="Issue";
		  String string3="Details";
		  String finalPath=LoginPage.drivePath+string+string1+pathExtension;
	       String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
	       String finalPath2=LoginPage.drivePath+string+string3+pathExtension;
		try{
		System.out.println("inside frst page");
		/* Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
	  	*/
			getCommand().waitForTargetPresent(SetUp_Pg1Title);
			getCommand().waitForTargetPresent(StartFromScratch);
			getCommand().click(StartFromScratch);
			   //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
 	  	      
			 //getCommand().captureScreenshot(finalPath);
				
			
			log("Tapped on Start from Scratch :Pass",LogType.VERIFICATION_STEP);
		}
		
		catch(Exception e)
		{
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on Start from Scratch :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		
		return this;
		
	}
	public SetupInventoryPage tapContinue(String string){
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
	public SetupInventoryPage Setup_AddItemsLink(String string){
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
				getCommand().waitForTargetPresent(AddItemsLink);
			getCommand().clickWithJavascript(AddItemsLink);
			  //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
	 	  	    
			//getCommand().captureScreenshot(finalPath);
				
			
			log("Tapped on add items link :Pass",LogType.VERIFICATION_STEP);
		}
		
		catch(Exception e)
		{
			//getCommand().captureScreenshot(finalPath1);
			log("Tapped on add items link :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		
		return this;
		
	}
	
	
	public SetupInventoryPage Scratch_AddItems(String string)
	{
		log("Clicking on add items",LogType.STEP);

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
  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));*/
  	
		getCommand().waitForTargetPresent(AddItems_Scratch);
		getCommand().click(AddItems_Scratch);
		getCommand().waitForTargetPresent(AddItemFromPage_Scratch);
		  //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		 	
			//getCommand().captureScreenshot(finalPath);   
			  	
			log("Tapping on add items button from setup inventory page :Pass",LogType.VERIFICATION_STEP);						
		}
		

		catch(Exception e){
		//	getCommand().captureScreenshot(finalPath1);   
			log("Tapping on add items button from setup inventory page :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	}
	public SetupInventoryPage AddItemFrom_NonSysco(String string)
	{
		log("Clicking on Nonsysco item",LogType.STEP);
		
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
		getCommand().waitForTargetPresent(AddItemFromPage_Scratch);
		
		if (getCommand().isTargetPresent(AddItem_NonSyscoItem))
		{

			
			getCommand().click(AddItem_NonSyscoItem);	
		
			getCommand().waitForTargetPresent(AddProduct_Page);
			 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			//getCommand().captureScreenshot(finalPath);
			log("Nonsysco item selected from add item from page :Pass",LogType.VERIFICATION_STEP);		
		
		}
		
		
	}	
		catch(Exception e){
			//getCommand().captureScreenshot(finalPath1); 
			
			log("Nonsysco item selected from add item from page  :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	}
	   
    public SetupInventoryPage AddItemFrom_PrepItem(String string)
   	{
       	
       	log("Clicking on Prep item",LogType.STEP);
       	
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
   */  	getCommand().waitForTargetPresent(AddItemFromPage_Scratch);
     	
     	if (getCommand().isTargetPresent(AddItem_PrepItem))
     	{

     		
     		getCommand().click(AddItem_PrepItem);	
     	
     		getCommand().waitForTargetPresent(AddProduct_Page);
     		
     		//getCommand().captureScreenshot(finalPath);
     		log("Prep item selected from add item from page :Pass",LogType.VERIFICATION_STEP);		
     		 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
     		//getCommand().captureScreenshot(finalPath); 
     	}
     	
     	
     }	
     	catch(Exception e){
     		//getCommand().captureScreenshot(finalPath1); 
     		
     		log("Prep item selected from add item from page  :Fail",LogType.VERIFICATION_STEP);
     		Assert.assertTrue(false);
     	}
     	return this;
     	
   		
   	
   	}
    public SetupInventoryPage AddItemFrom_OrderGuide(String string) {
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
     	
*/    	   getCommand().waitForTargetPresent(AddItem_OrderGuide);
        	
        	if (getCommand().isTargetPresent(AddItem_OrderGuide))
        	{

        		
        		getCommand().click(AddItem_OrderGuide);	
        	
        		getCommand().waitForTargetPresent(Category_Header);
        	
        		  System.out.println("heading:"+getCommand().getText(Category_Header));
        		  //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
        		//getCommand().captureScreenshot(finalPath);
        		  log("Order Guide Click : Pass",LogType.VERIFICATION_STEP);		
        		
        	}
        		
       }
   	catch(Exception e){
   	  log("Order Guide Click : Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
  	return this;
    }
    public SetupInventoryPage SelectItemFrom_OrderGuide(String string) {
   	 String string1="Success";
   	  String string2="Issue";
   	  
      String finalPath=LoginPage.drivePath+string+string1+pathExtension;
      String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
    
   	
       
       try{
   			 
       	/*  Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
   			System.out.println("contxtname is "+contextNames);
   			
   			 for (String contextName : contextNames){
   				 System.out.println("inside loop "+contextNames);
   			 }
   		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
*/   	
   		System.out.println("to add item");
    	  getCommand().waitForTargetPresent(Category_Header);
       
    	  System.out.println("heading:"+getCommand().getText(Category_Header)); 
     	 
   		if(getCommand().isTargetPresent(OrderGuide_FirstItemSelect))
   		{
   			getCommand().click(OrderGuide_FirstItemSelect);
   			
   			ItemName=getCommand().getText(OrderGuide_1stItemHeading);
   			
   			System.out.println("OG item "+ItemName);
 			System.out.println("searched item "+SearchItemName);
 			
   			
   			
   			log("First item selected Order Guide  :Pass",LogType.VERIFICATION_STEP);
   			TapOnDone("done");
   		}
   		else
   		{
   		 log("Order Guide Items not available",LogType.VERIFICATION_STEP);
   		 vp.TapOnBack("Pressback1");
   		vp.TapOnBack("pressback2");
   		}
   		
   	 
   		//((IOSDriver)getCommand().driver).context("NATIVE_APP");
   	 	//getCommand().captureScreenshot(finalPath); 
   			 			
   		}
   	
   	catch(Exception e){
   	//getCommand().captureScreenshot(finalPath1); 
   		log("First item selected Order Guide :Fail",LogType.VERIFICATION_STEP);
   		Assert.assertTrue(false);
   	}
       return this;
   }
    public SetupInventoryPage SelectItemFrom_Catalog(String string) {
      	 String string1="Success";
      	  String string2="Issue";
      	  
         String finalPath=LoginPage.drivePath+string+string1+pathExtension;
         String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
       
      	
          
          try{
      			 
          /*	  Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
      			System.out.println("contxtname is "+contextNames);
      			
      			 for (String contextName : contextNames){
      				 System.out.println("inside loop "+contextNames);
      			 }
      		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
*/      	
      		System.out.println("to add item");
       	  getCommand().waitForTargetPresent(Category_Header);
          
       	  System.out.println("heading:"+getCommand().getText(Category_Header)); 
        	 
      		if(getCommand().isTargetPresent(OrderGuide_FirstItemSelect))
      		{
      			getCommand().click(OrderGuide_FirstItemSelect);
      			
      			SearchItemName=getCommand().getText(OrderGuide_1stItemHeading);
      			
      			System.out.println("OG item "+ItemName);
     			System.out.println("searched item "+SearchItemName);
     			
      			
      			
      			log("First item selected from pdt catalog  :Pass",LogType.VERIFICATION_STEP);
      			
      		}
      		//((IOSDriver)getCommand().driver).context("NATIVE_APP");
      	 	//getCommand().captureScreenshot(finalPath); 
      			 			
      		}
      	
      	catch(Exception e){
      	getCommand().captureScreenshot(finalPath1); 
      		log("First item selected from pdt catalog :Fail",LogType.VERIFICATION_STEP);
      		Assert.assertTrue(false);
      	}
          return this;
      }
    
     public SetupInventoryPage verifyOGItemsOnSetupInv(String string) {
      	 String string1="Success";
      	  String string2="Issue";
      	  
         String finalPath=LoginPage.drivePath+string+string1+pathExtension;
         String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
          try{
       
        	/*  Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
 				System.out.println("contxtname is "+contextNames1);
 				
 				 for (String contextName : contextNames1){
 					 System.out.println("inside loop "+contextNames1);
 				 }
 			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
*/	if(getCommand().isTargetPresent(Category_Header))
   		{
   			System.out.println("added OG item is: "+ItemName);
   			 final Target SetUpInventory_1stItemHeading= new Target("OrderGuide_1stItemHeading","//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+ItemName+"')]",Target.XPATH); 
   	   			
   	   			getCommand().waitFor(10);
   	   			Boolean boolean1 =getCommand().isTargetPresent(SetUpInventory_1stItemHeading);
   	   		
   	   			if(boolean1)
   	   				
   	   			  log("Item Found in Setup Inventory:Pass",LogType.VERIFICATION_STEP);
   	   			else
   	   				{
   	   			//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
   	    	  // getCommand().captureScreenshot(finalPath1); 
   	   				log("Item Found in Setup Inventory:Fail",LogType.VERIFICATION_STEP);
   	   				Assert.assertTrue(false);
   	   				}
   			
   		    
   		  
   		}
   		//((IOSDriver)getCommand().driver).context("NATIVE_APP");
     log("No item available to search in setup inv",LogType.VERIFICATION_STEP);
   		//getCommand().captureScreenshot(finalPath);
       }
       
       catch(Exception e){
    		//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    	  // getCommand().captureScreenshot(finalPath1); 
   				log("Item Found in Setup Inventory:Fail",LogType.VERIFICATION_STEP);
   			//	getCommand().captureScreenshot(finalPath1);
   				Assert.assertTrue(false);
   			}
   		     
   		
   	return this;
   	
   }
     public SetupInventoryPage verifySearchItemsOnSetupInv(String string) {
      	 String string1="Success";
      	  String string2="Issue";
      	  
         String finalPath=LoginPage.drivePath+string+string1+pathExtension;
         String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
          try{
       
       /* 	  Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
 				System.out.println("contxtname is "+contextNames1);
 				
 				 for (String contextName : contextNames1){
 					 System.out.println("inside loop "+contextNames1);
 				 }
 			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
*/ 			
 			System.out.println("OG item "+ItemName);
 			System.out.println("searched item "+SearchItemName);
 			
 			
	if(getCommand().isTargetPresent(Category_Header))
   		{
   			
   			 final Target SetUpInventory_1stItemHeading= new Target("OrderGuide_1stItemHeading","//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+ItemName+"')]",Target.XPATH); 
   	   			
   	   			getCommand().waitFor(10);
   	   			Boolean boolean1 =getCommand().isTargetPresent(SetUpInventory_1stItemHeading);
   	   		
   	   			if(boolean1)
   	   				
   	   			  log("Item Found in Setup Inventory:Pass",LogType.VERIFICATION_STEP);
   	   			else
   	   				{
   	   			//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
   	    	 //  getCommand().captureScreenshot(finalPath1); 
   	   				log("Item Found in Setup Inventory:Fail",LogType.VERIFICATION_STEP);
   	   				Assert.assertTrue(false);
   	   				}
   			
   		    
   		  
   		}
   		//((IOSDriver)getCommand().driver).context("NATIVE_APP");
  		 
   		//getCommand().captureScreenshot(finalPath);
       }
       
       catch(Exception e){
    		//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    	 //  getCommand().captureScreenshot(finalPath1); 
   				log("Item Found in Setup Inventory:Fail",LogType.VERIFICATION_STEP);
   				getCommand().captureScreenshot(finalPath1);
   				Assert.assertTrue(false);
   			}
   		     
   		
   	return this;
   	
   }
       public SetupInventoryPage TapOnDone(String string){
       	String string1="Success";
       	  String string2="Issue";

       String finalPath=LoginPage.drivePath+string+string1+pathExtension;
       String finalPath1=LoginPage.drivePath+string+string2+pathExtension;

       	try{
       		
       			getCommand().waitForTargetPresent(Done);
       		if (getCommand().isTargetPresent(Done))
       		{
       			
       			getCommand().click(Done);
       			log("Tapped on done:Pass",LogType.VERIFICATION_STEP);
       		 
       				//getCommand().captureScreenshot(finalPath);
       		}
       		
       	}
       	catch(Exception e)
       	{
       		log("Tapped on done :Fail",LogType.VERIFICATION_STEP);
       		getCommand().captureScreenshot(finalPath1);
       		Assert.assertTrue(false);
       	}
       	
       	return this;
       }
       public SetupInventoryPage EnterItemDetails(String name,String upc, String pack, String size, String weight, String price, String brand, String string)
   	{
   		String string1="Success";
   		  String string2="Issue";
            
             String finalPath=LoginPage.drivePath+string+string1+pathExtension;
           String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
   		log("Entering details of Nonsysco item",LogType.STEP);
   	try{
   			System.out.println("inside non sysco form");
   		
   			System.out.println("OG item "+ItemName);
 			System.out.println("searched item "+SearchItemName);
 			
   			
   			/* Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
   				
   			 for (String contextName : contextNames){
   				 System.out.println(contextNames);
   			 }
   		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
*/
   		
       		getCommand().waitForTargetPresent(AddProductPage_ProductName);
       	if (getCommand().isTargetPresent(AddProductPage_ProductName))
       	{
       		
       		log("Entering Product name",LogType.STEP);
       		getCommand().click(AddProductPage_ProductName);
       		
       		getCommand().sendKeys(AddProductPage_ProductName,name);
       	}
       	
       		getCommand().waitForTargetPresent(AddProductPage_UPC);
       		if (getCommand().isTargetPresent(AddProductPage_UPC)){
       		log("Entering Product id",LogType.STEP);
       		getCommand().click(AddProductPage_UPC);
       		
       	    getCommand().sendKeys(AddProductPage_UPC,upc);
       		}
       		if (getCommand().isTargetPresent(AddProductPage_Pack)){
       		log("Entering Pack",LogType.STEP);	
       		getCommand().click(AddProductPage_Pack);
       	
       		getCommand().sendKeys(AddProductPage_Pack,pack);
       		}
       		if (getCommand().isTargetPresent(AddProductPage_Size)){
       		log("Entering size",LogType.STEP);	
       		getCommand().click(AddProductPage_Size);
       		
       		getCommand().sendKeys(AddProductPage_Size,size);
       		}
            //   getCommand().scrollTo(AddProductPage_Pack);
       		if (getCommand().isTargetPresent(AddProductPage_Weight)){
       		log("Entering weight",LogType.STEP);
       		getCommand().click(AddProductPage_Weight);
       	
       		getCommand().sendKeys(AddProductPage_Weight,weight);
       		}
       		
       		if (getCommand().isTargetPresent(AddProductPage_Price)){
       		log("Entering Price",LogType.STEP);	
       		getCommand().click(AddProductPage_Price);
       		
       		getCommand().sendKeys(AddProductPage_Price,price);
       		}
       		if (getCommand().isTargetPresent(AddProductPage_ProductBrand)){
       		log("Entering Product brand",LogType.STEP);
       		getCommand().click(AddProductPage_ProductBrand);
       		
       		getCommand().sendKeys(AddProductPage_ProductBrand,brand);
       		}
       		
       		getCommand().waitFor(2);
       	//	getCommand().click(AddProductPage_Option);
       	//	System.out.println("clicked option");
       	//	getCommand().selectDropDown(AddProductPage_Option, 1);
       	//	getCommand().selectDropDown(AddProductPage_Option, "LB")
       	//	System.out.println("selectef");
       		log("Item details are entered :Pass",LogType.VERIFICATION_STEP);
       		  //((IOSDriver)getCommand().driver).context("NATIVE_APP");
       		  
       	
       		//getCommand().captureScreenshot(finalPath);
   		
   		
   	}	
   		catch(Exception e){
   			getCommand().captureScreenshot(finalPath1);
   			log("Item details are entered  :Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
   		return this;
   		
   	}
       public SetupInventoryPage AddSupplier_AddProductDetailsPage(String string)
       {
       	
       	
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
       		//getCommand().captureScreenshot(finalPath);
       		
       		getCommand().waitForTargetPresent(AddProductPage_AddSupplier);
       		if (getCommand().isTargetPresent(AddProductPage_AddSupplier)){
       		getCommand().click(AddProductPage_AddSupplier);
       		}
       		log("Selected supplier : Pass",LogType.STEP);						
        //((IOSDriver)getCommand().driver).context("NATIVE_APP");
        //getCommand().captureScreenshot(finalPath);
       }	
        catch(Exception e){
   			getCommand().captureScreenshot(finalPath1);
   			log("Selected supplier :Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
   		return this;
}
       public SetupInventoryPage TapOrderGuide(String string)
   	{
   		  String string1="Success";
   		  String string2="Issue";
            
             String finalPath=LoginPage.drivePath+string+string1+pathExtension;
             String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
             
   		log("Selecting Orderguide ",LogType.STEP);
   	
   		try{
   		/*	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
   	  		System.out.println("contxtname is "+contextNames1);
   	  		
   	  		 for (String contextName : contextNames1){
   	  			 System.out.println("inside loop "+contextNames1);
   	  		 }
   	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
   	  	
*/   			getCommand().waitForTargetPresent(SetUp_Pg1Title);
   			getCommand().waitForTargetPresent(OrderGuide);
   			getCommand().click(OrderGuide);
   			
   			
   			log("Selected  orderguide  from SetupInventoryImportItems:Pass",LogType.VERIFICATION_STEP);	
   		 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
   		//getCommand().captureScreenshot(finalPath);
   		}
   		catch(Exception e){

   			getCommand().captureScreenshot(finalPath1);
   			log("Selected  orderguide  from SetupInventoryImportItems :Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
   		
   		return this;
   		
   	}   
       public SetupInventoryPage verifyNonSyscoPrepItemSetupInv(String product,String string) {
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
     		
     		
*/     			 final Target SetUpInventory_1stItemHeading= new Target("NonSyscoItem","//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+product+"')]",Target.XPATH); 
     	   			
     	   			getCommand().waitFor(10);
     	   			Boolean boolean1 =getCommand().isTargetPresent(SetUpInventory_1stItemHeading);
     	   		System.out.println(boolean1);
     	   			if(boolean1){
     	   			//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
              	   //getCommand().captureScreenshot(finalPath); 
     	   			  log("Item Found in Setup Inventory:Pass",LogType.VERIFICATION_STEP);
     	   			}
     	   		else {
     	   		//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
         	  // getCommand().captureScreenshot(finalPath1); 
	   				throw new Exception();
	   			}
     			
     		    
     		  
     		
     		//((IOSDriver)getCommand().driver).context("NATIVE_APP");
     		//getCommand().captureScreenshot(finalPath);
     		
         }
         
         catch(Exception e){
        	 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
      	  // getCommand().captureScreenshot(finalPath1); 
     				log("Item Found in Setup Inventory:Fail",LogType.VERIFICATION_STEP);
     				
     				Assert.assertTrue(false);
     			}
     		     
     		
     	return this;
     	
     }
       //////////////////////////////
       
       public SetupInventoryPage NonSysco_Prompt(String string)
       {
       	  String string1="Success";
       	  String string2="Issue";
       	  String string3="Success1";
             String finalPath=LoginPage.drivePath+string+string1+pathExtension;
             String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
             String finalPath2=LoginPage.drivePath+string+string3+pathExtension;
             
       	log("validating adding 'Nonsysco item' page ",LogType.STEP);
       try{
       	getCommand().waitForTargetPresent(AddProduct_Page);
       	
       	getCommand().captureScreenshot(finalPath2);
       	if (getCommand().isTargetPresent(AddProductPage_ProductName))
       	{
       		
       		getCommand().waitForTargetPresent(AddProductPage_ProductName);
       		getCommand().waitForTargetPresent(AddProductPage_UPC);
       		getCommand().waitForTargetPresent(AddProductPage_Pack);
       		getCommand().waitForTargetPresent(AddProductPage_Size);
       		
       		getCommand().scrollTo(AddProductPage_Pack);
       		getCommand().waitForTargetPresent(AddProductPage_Weight);
       		getCommand().waitForTargetPresent(AddProductPage_Price);
       		
       		getCommand().waitForTargetPresent(AddProductPage_ProductBrand);

       		//	getCommand().waitForTargetPresent(AddProductPage_Option);
       		
       		getCommand().waitForTargetPresent(AddProductPage_AddSupplier);
       	
       		//getCommand().captureScreenshot(finalPath);
       		log("Nonsysco item details are present in page :Pass",LogType.VERIFICATION_STEP);						
       	}
       	
       	
       }	
       	catch(Exception e){
       		getCommand().captureScreenshot(finalPath1);
       		log("Nonsysco item details are present in page :Fail",LogType.VERIFICATION_STEP);
       		Assert.assertTrue(false);
       	}
       	return this;
       	
       }
       public SetupInventoryPage skipfoodcost(String string){
   		log("Skipping foodcost",LogType.STEP);
   		String string1="Success";
   		String string2="Issue";   
   		String finalPath=LoginPage.drivePath+string+string1+pathExtension;
   		String finalPath1=LoginPage.drivePath+string+string2+pathExtension;

   		try{
   		System.out.println("inside frst page");
   		
   			getCommand().waitForTargetPresent(SetUp_Pg3Title);
   			getCommand().waitForTargetPresent(SkipStep_TrackFoodCostPg);
   			 //getCommand().captureScreenshot(finalPath);
   			getCommand().click(SkipStep_TrackFoodCostPg);
   			
   			getCommand().waitForTargetPresent(InvToolsPg);
   			
   			
   			log("Skipping foodcost :Pass",LogType.VERIFICATION_STEP);
   		}
   		
   		catch(Exception e)
   		{	// getCommand().captureScreenshot(finalPath1);
   			log("Skipping foodcost:Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
   		
   		return this;
   		
   	}
       public SetupInventoryPage SelectMultipleItemsFrom_OrderGuide(String string) {
    	   	 String string1="Success";
    	   	  String string2="Issue";
    	   	  
    	     String finalPath=LoginPage.drivePath+string+string1+pathExtension;
    	     String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
    	      try{

    	   		log(" Adding Item from Order Guide",LogType.STEP);
    	   		
    	   		
    	    
    	      	/*  Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
    	   			System.out.println("contxtname is "+contextNames);
    	   			
    	   			 for (String contextName : contextNames){
    	   				 System.out.println("inside loop "+contextNames);
    	   			 }
    	   		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
*/
  	   		 getCommand().waitForTargetPresent(Category_Header);
  	   	getCommand().waitFor(2);
  	      	  CategoryName= getCommand().getText(Category_Header);
  	      	  System.out.println("heading:"+CategoryName);
    	   	 
    	   		
    	   		if(getCommand().isTargetPresent(OrderGuide_1stItemSelect))
    	   		{
    	   			System.out.println("found");
    	   			noOfElements++;
    	   			getCommand().click(OrderGuide_1stItemSelect);
    	   			ItemName1=getCommand().getText(OrderGuide_1stItemHeading);
    	   			System.out.println("Item heading:"+ItemName1);
    	   			
    	   		}
    	   		if(getCommand().isTargetPresent(OrderGuide_2ndItemSelect)){
    	   			
    	   			noOfElements++;
    	   			getCommand().click(OrderGuide_2ndItemSelect);
    	   			ItemName2=getCommand().getText(OrderGuide_2ndItemHeading);
    	   			System.out.println("Item heading:"+ItemName2);
    	   		}
    	   			
    	   		if(getCommand().isTargetPresent(OrderGuide_3rdItemSelect)){	
    	   			noOfElements++;
    	   			getCommand().click(OrderGuide_3rdItemSelect);
    	   			ItemName3=getCommand().getText(OrderGuide_3rdItemHeading);
    	   			System.out.println("Item heading:"+ItemName3);
    	   		}
    	   			
    	   			
    	   			
    	   			//((IOSDriver)getCommand().driver).context("NATIVE_APP");
    	   			//getCommand().captureScreenshot(finalPath);
    	   			
    	   				System.out.println("3 items selected :Pass");
    	   			log("Multiple items selected :Pass",LogType.VERIFICATION_STEP);
    	   			
    	   		
    	   		
    	   		
    	   			 			
    	   		}
    	   	
    	   	catch(Exception e){
    	   	getCommand().captureScreenshot(finalPath1); 
    	   		log("Multiple items selected :Fail",LogType.VERIFICATION_STEP);
    	   		Assert.assertTrue(false);
    	   	}
    	      return this;
    	   }
    	      
    	    public SetupInventoryPage verifyMultipleItemsfromOGonSetUpInv(String string) {
    	      	 String string1="Success";
    	      	  String string2="Issue";
    	      	  
    	         String finalPath=LoginPage.drivePath+string+string1+pathExtension;
    	         String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
    	          try{
    	      /*
    	   			 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    	   				System.out.println("contxtname is "+contextNames1);
    	   				
    	   				 for (String contextName : contextNames1){
    	   					 System.out.println("inside loop "+contextNames1);
    	   				 }
    	   			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
//    	   		  
*/    	   		//	getCommand().waitForTargetPresent(setupInventryFirstProduct).getText(setupInventryFirstProduct).equalsIgnoreCase(ItemName);
    	   		    
    	   		    
    	   		    
    	   		    final Target SetUpInventory_1stItemHeading= new Target("OrderGuide_1stItemHeading","//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+ItemName1+"')]",Target.XPATH); 
    	   			final Target SetUpInventory_2ndItemHeading= new Target("OrderGuide_2ndItemHeading","//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+ItemName2+"')]",Target.XPATH); 
    	   			final Target SetUpInventory_3rdItemHeading= new Target("OrderGuide_3rdItemHeading","//*[@class='mm-c-product-list']//*[@class='Grid__innerScrollContainer']//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+ItemName3+"')]",Target.XPATH); 
    	   			
    	   			
    	   			getCommand().waitFor(10);
    	   			Boolean boolean1 =getCommand().isTargetPresent(SetUpInventory_1stItemHeading);
    	   			Boolean boolean2 =getCommand().isTargetPresent(SetUpInventory_2ndItemHeading);
    	   			Boolean boolean3 =getCommand().isTargetPresent(SetUpInventory_3rdItemHeading);
    	   			
    	   			int count=0;
    	   			if(boolean1){
    	   				count++;
    	   				System.out.println("inside if 1 count :"+count);
    	   			}
    	   			if(boolean2){
    	   				count++;
    	   				System.out.println("inside if 2 count :"+count);
    	   			}
    	   			if(boolean3){
    	   				count++;
    	   				System.out.println("inside if 3 count :"+count);
    	   			}   
    	   		    
    	   			if (noOfElements==count) {
    	   				System.out.println("All Three Elements Present, Pass");
    	   				log("All Three Items Found in Setup Inventory :Pass",LogType.VERIFICATION_STEP);
    	   			}else {
    	   				throw new Exception();
    	   			}
    	   		    
    	   		    log("All three Items Found in Setup Inventory :Pass",LogType.VERIFICATION_STEP);
    	   		
    	   	 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    	   	//getCommand().captureScreenshot(finalPath);
    	       }
    	       
    	       catch(Exception e){
    	   				log("Items Found in Setup Inventory:Fail",LogType.VERIFICATION_STEP);
    	   				getCommand().captureScreenshot(finalPath1);
    	   				Assert.assertTrue(false);
    	   			}
    	   		     
    	   		
    	   	return this;
    	   	
    	   }
    	    public SetupInventoryPage NonSyscoItem_AddSupplierSelectAlertYes(String string)
    		{
    			  String string1="Success";
    			  String string2="Issue";
    			  
    	        String finalPath=LoginPage.drivePath+string+string1+pathExtension;
    	        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
    			log("Updating non sysco item details",LogType.STEP);
    		try{
    		/*	 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    				System.out.println("contxtname is "+contextNames1);
    				
    				 for (String contextName : contextNames1){
    					 System.out.println("inside loop "+contextNames1);
    				 }
    			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
*/
    			
    				getCommand().waitForTargetPresent(AddProductPage_ModalWindowForAddSupplierYes);
    				getCommand().click(AddProductPage_ModalWindowForAddSupplierYes);
    				log("Non sysco item details-Add supplier Modal window-Yes :Pass",LogType.VERIFICATION_STEP);
    				
    				 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 			
    			}

    			catch(Exception e){
    				getCommand().captureScreenshot(finalPath1);
    				log("Non sysco item details-Add supplier Modal window-Yes :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			}
    			return this;
    			
    		}
    	    public SetupInventoryPage verifyNonSysco_AddedPdtSupplier(String name,String string)
    	    {
    	    	
    	    	  String pathExtension=".png";
    	    	  String string1="Success";
    	    	  String string2="Issue";
    	    	  
    	        String finalPath=LoginPage.drivePath+string+string1+pathExtension;
    	        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
    	        
    	    	log("verifyingvendor",LogType.STEP);
    	    try{
    	    	
    	    	String vendorName=name;
    	    	/* Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
    	    		
    	    	 for (String contextName : contextNames){
    	    		 System.out.println(contextNames);
    	    	 }
    	    System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
*/
    	      	final Target  VD_Vendorname= new Target("VD_Vendorname","//*[@id='mount']//*[@class='mm-c-product-details__supplier' and contains(text(),'"+vendorName+"')]",Target.XPATH);   
    	    	
    	    			if (getCommand().isTargetPresent(VD_Vendorname))
    	    			{
    	    				
    	    				log("Vendor is selected on Non sysco Add product page:Pass",LogType.VERIFICATION_STEP);			
    	    	
    	    			}
    	    			else{
    	    				log("Vendor is selected on Non sysco Add product page   :Fail",LogType.VERIFICATION_STEP);
    	    				Assert.assertTrue(false);
    	    			}
    	    	  //((IOSDriver)getCommand().driver).context("NATIVE_APP");
    	    	
    	      
    	           //getCommand().captureScreenshot(finalPath);
    	      
    	    						
    	    	}
    	    	
    	    	
    	    	
    	    	catch(Exception e){
    	    		// getCommand().captureScreenshot(finalPath1); 
    	    		log("Vendor is selected on Non sysco Add product page   :Fail",LogType.VERIFICATION_STEP);
    	    		Assert.assertTrue(false);
    	    	}
    	    	return this;
    	    	
    	    }
    	    public SetupInventoryPage skipOrderGuide(String string){
    			log("Setup inventory page",LogType.STEP);
    			
    			 String string1="Success";
    			  String string2="Issue";
    	        
    	         String finalPath=LoginPage.drivePath+string+string1+pathExtension;
    	         String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
    	         
    			try{
    			System.out.println("inside frst page");
    			
    				
    				getCommand().waitForTargetPresent(SetUp_Pg3Title);
    				getCommand().waitForTargetPresent(SkipStep_TrackFoodCostPg);
    				getCommand().click(SkipStep_TrackFoodCostPg);
    				
    				getCommand().waitForTargetPresent(InvToolsPg);
    				
    				//getCommand().captureScreenshot(finalPath);
    				log("Skip order guide :Pass",LogType.VERIFICATION_STEP);
    			}
    			
    			catch(Exception e)
    			{
    				getCommand().captureScreenshot(finalPath1);
    				log("Skip order guide :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			}
    			
    			return this;
    			
    		}
    	    public SetupInventoryPage TapOnSkip(String string){
    			log("Setup inventory page",LogType.STEP);
    			
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
    		  	getCommand().waitFor(2);
    				getCommand().waitForTargetPresent(Skip);
    				getCommand().click(Skip);
    				
    				 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    				//getCommand().captureScreenshot(finalPath);
    				log("Tapped on skip :Pass",LogType.VERIFICATION_STEP);
    			}
    			
    			catch(Exception e)
    			{
    				getCommand().captureScreenshot(finalPath1);
    				log("Tapped on skip :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			}
    			
    			return this;
    			
    		}

			public SetupInventoryPage SearchItem(String keyword,String string) {
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
   		  		getCommand().waitForTargetPresent(Search);
   				getCommand().click(Search);
   				getCommand().sendKeys(Search, keyword);
   			
   				
   				getCommand().driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys(Keys.ENTER);
   				 
   				CategoryName= getCommand().getText(Category_Header);
    	      	  System.out.println("heading:"+CategoryName);
   				
   				
   				 //((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
   				 
   				
   				//getCommand().captureScreenshot(finalPath);
   				log("Search item :Pass",LogType.VERIFICATION_STEP);
   			}
   			
   			catch(Exception e)
   			{
   				getCommand().captureScreenshot(finalPath1);
   				log("Search item :Fail",LogType.VERIFICATION_STEP);
   				Assert.assertTrue(false);
   			}
   			
   			return this;
   			
			}
			public SetupInventoryPage TapOnDOThisLater(String string){
			
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
		*/			getCommand().waitForTargetPresent(DoThisLater); getCommand().click(DoThisLater);
					//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
					//getCommand().captureScreenshot(finalPath); 
					log("Tapped on DoThisLater :Pass",LogType.VERIFICATION_STEP); 
					} 
				catch(Exception e) {
					getCommand().captureScreenshot(finalPath1); 
					log("Tapped on DoThisLater :Fail",LogType.VERIFICATION_STEP); 
					Assert.assertTrue(false); 
					} 
				return this; 
					}
			public SetupInventoryPage ReadytoStart(String string){
				
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
*/					getCommand().waitForTargetPresent(Next);
					getCommand().click(Next);
					getCommand().waitForTargetPresent(Next);
					getCommand().click(Next);
					//((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
					//getCommand().captureScreenshot(finalPath); 
					log("Tapped on Ready to track :Pass",LogType.VERIFICATION_STEP); 
					} 
				catch(Exception e) {
					getCommand().captureScreenshot(finalPath1); 
					log("Tapped on Ready to track :Fail",LogType.VERIFICATION_STEP); 
					Assert.assertTrue(false); 
					} 
				return this; 
					}
			 
}