
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

import java.util.Set;
import java.util.UUID;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;
import io.appium.java_client.android.AndroidDriver;


public class CategoryPage extends SitePage{

	
	
	// public static final Target FoodAndNonFood = new Target("FoodAndNonFood","//*[@class='btn btn-sm btn-primary' and contains(text(),'Food & Non-Food')]",Target.XPATH);
	// public static final Target  SuggestedCategories = new Target("SuggestedCategories","//*[@class='btn btn-sm btn-primary' and contains(text(),'Suggested Categories')]",Target.XPATH);
	   public static final Target Continue = new Target("Continue","//*[@class='btn btn-default' and contains(text(),'Continue')]",Target.XPATH);
	   public static final Target Header= new Target("Category_Header","//*[@class='navbar-brand']/h3",Target.XPATH);
	   public static final Target Category_FirstItemSelect= new Target("Category_FirstItemSelect","//*[@class='checkbox']//*[@class='mm-o-icon']//*[@class='item-input'and @data-index='0']",Target.XPATH);
	   public static final Target Category_FirstItemHeader= new Target("Category_FirstItemHeader","//*[@id='mount']/div/div/div[2]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]/h4",Target.XPATH); 
	   public static final Target InvToolsPg = new Target("InvToolsPg","//*[@class='navbar-brand']//*[contains(text(),'Inventory Tools')]",Target.XPATH);
	   public static final Target SecondCategory_FirstItemSelect= new Target("Category_FirstItemSelect","//*[@class='checkbox']//*[@class='mm-o-icon']//*[@class='item-input'and @data-index='1']",Target.XPATH); 
			
	   public String CategoryName;
	   public String ItemNameSelected;
	   public String ItemNameAdded;
	   public static final Target Complete = new Target("Continue","//*[@class='btn btn-default' and contains(text(),'Complete')]",Target.XPATH);		public static final Target SetupInventoryCustomCategoryAllItemsTab = new Target("SetupInventoryCustomLoc_LocName","//*[@id='mount']//*[@class='mm-c-productList--pill-left']/a",Target.XPATH);
	   public static final Target SetupInventoryCustomCategoryUncategorizedTab = new Target("SetupInventoryCustomLoc_LocName","//*[@id='mount']//*[@class='mm-c-productList--pill-right']/a",Target.XPATH);
		
	   public static String ItemAdded;
	   public static final Target Category_Header= new Target("Category_Header","//*[@class='navbar-brand']/h3",Target.XPATH);
					 
	   public static final Target ExpenseCategory_Food= new Target("ExpenseCategory_Food","(//*[@class='mm-c-customexpense__details-category']//*[@class='radio'])[1]/label",Target.XPATH); 
	   public static final Target ExpenseCategory_Page= new Target("ExpenseCategory_Page","//*[@class='mm-c-customexpense__setup-text']//*[contains(text(),'Create Custom Expense Categories')]",Target.XPATH); 		    public static final Target ExpenseCategory_Name= new Target("ExpenseCategory_Name","//*[@class='mm-c-customexpense__details-category-name form-control form-control' and @name='formFields[0].name']",Target.XPATH); 
	   public static final Target ExpenseCategory_NonFood= new Target("ExpenseCategory_NonFood","(//*[@class='mm-c-customexpense__details-category']//*[@class='radio'])[2]/label",Target.XPATH); 
	   public static final Target Next= new Target("Next","//*[@id='next-nav']/a",Target.XPATH); 

	// public static final Target  CustomCategories = new Target("CustomCategories","//*[@class='btn btn-sm btn-primary' and contains(text(),'Create Expense Cat.')]",Target.XPATH);
	   public static final Target ExpenseCategory_NameTxt= new Target("ExpenseCategory_NameTxt","//*[@class='mm-c-customexpense__details-category-name form-control form-control' and @name='formFields[0].name']",Target.XPATH); 
	   public static final Target ExpenseCategory_AnotherCategory= new Target("ExpenseCategory_AnotherCategory","//*[@class='mm-c-customexpense__setup-cta']//*[contains(text(),'Add Another Category')]",Target.XPATH);		public static final Target ExpenseCategory_Name1= new Target("ExpenseCategory_Name1","//*[@class='mm-c-customexpense__details-category-name form-control form-control' and @name='formFields[1].name']",Target.XPATH);
	   public static final Target ExpenseCategory_Food1= new Target("ExpenseCategory_Food1","(//*[@class='mm-c-customexpense__details-category']//*[@class='radio'])[3]/label",Target.XPATH); 
							

	   public static final Target Category_1stItemSelect= new Target("Category_1stItemSelect","(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[1]",Target.XPATH);
	   public static final Target Category_2ndItemSelect= new Target("Category_2ndItemSelect","(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[2]",Target.XPATH);
	   public static final Target Category_3rdItemSelect= new Target("Category_3rdItemSelect","(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[3]",Target.XPATH);
	   public static final Target Category_1stItemHeading= new Target("Category_1stItemHeading","(//*[@class='mm-c-product-minlist__item']/h4)[1]",Target.XPATH);
	   public static final Target Category_2ndItemHeading= new Target("Category_2ndItemHeading","(//*[@class='mm-c-product-minlist__item']/h4)[2]",Target.XPATH);
	   public static final Target Category_3rdItemHeading= new Target("Category_3rdItemHeading","(//*[@class='mm-c-product-minlist__item']/h4)[3]",Target.XPATH);

	   public static	String CategoryItemName1_1;
	   public static	String CategoryItemName1_2;
	   public static	String CategoryItemName1_3;
	   public static	String CategoryItemName1_4;
	   public static	String CategoryItemName2_1;
	   public static	String CategoryItemName2_2;
	   public static	String CategoryItemName2_3;
	 
	   public static	int CategoryNoOfElements1;
	   public static	int CategorysNoOfElements2;
	   
	   public static final Target ADD_CategoryName= new Target("ADD_CategoryName","//*[@id='name']",Target.XPATH); 
	   public static final Target AddCategory_FoodWeb= new Target("AddCategory_Food","(//*[@class='mm-c-expense__details-radio']//*[@class='radio'])[1]",Target.XPATH);
	   public static final Target AddCategory_Food= new Target("AddCategory_Food","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]",Target.XPATH); 
								
	   public static final Target Done= new Target("Done","//UIAStaticText[@label='Done']",Target.XPATH); 
	   public static final Target DoneWeb= new Target("DoneWeb","//*[@id='done-nav']/a",Target.XPATH); 

	   public static final Target Back = new Target("Back","//*[@id='back-nav']/a/i",Target.XPATH);
	   public static final Target AddWeb= new Target("AddWeb","//*[@id='add-nav']/a/i",Target.XPATH);
	   public static final Target EditWeb = new Target("Edit","//*[@id='edit-nav']/a/i",Target.XPATH);
	   public static final Target Delete = new Target("Delete ","//*[@id='delete-button' and contains(text(),'Delete Expense Category')]",Target.XPATH);
	   public static final Target YesDelete = new Target("YesDelete ","//*[@id='yes-button' and contains(text(),'Yes, Delete')]",Target.XPATH);

	   public static final Target Category_NonSyscoItem1Select= new Target("Category_NonSyscoItem1Select","(//*[@class='mm-c-product-minlist mm-c-product__custom']//*[@class='mm-o-icon'])[1]",Target.XPATH);
	   public static final Target Category_NonSyscoItem2Select= new Target("Category_NonSyscoItem2Select","(//*[@class='mm-c-product-minlist mm-c-product__custom']//*[@class='mm-o-icon'])[2]",Target.XPATH);
	   public static final Target Category_4thItemHeading= new Target("Category_4thItemHeading","(//*[@class='mm-c-product-minlist__item']/h4)[4]",Target.XPATH);
	  
	   public static final Target SuggestedCategory_Dairy= new Target("Category_NonSyscoItem1Select","//*[@id='list-item']//span[contains(text(),'Dairy')]",Target.XPATH);
	   public static final Target SuggestedCategory_Meat= new Target("Category_NonSyscoItem1Select","//*[@id='list-item']//span[contains(text(),'Meat')]",Target.XPATH);
	   public static final Target SuggestedCategory_Poultry= new Target("Category_NonSyscoItem1Select","//*[@id='list-item']//span[contains(text(),'Poultry')]",Target.XPATH);
	   public static final Target SuggestedCategory_Seafood= new Target("Category_NonSyscoItem1Select","//*[@id='list-item']//span[contains(text(),'Seafood')]",Target.XPATH);
	   public static final Target SuggestedCategory_Produce= new Target("Category_NonSyscoItem1Select","//*[@id='list-item']//span[contains(text(),'Produce')]",Target.XPATH);
	   public static final Target SuggestedCategory_Groceries= new Target("Category_NonSyscoItem1Select","//*[@id='list-item']//span[contains(text(),'Groceries')]",Target.XPATH);
	   public static final Target SuggestedCategory_Beverage= new Target("Category_NonSyscoItem1Select","//*[@id='list-item']//span[contains(text(),'Beverage')]",Target.XPATH);
	   public static final Target SuggestedCategory_Miscellaneous= new Target("Category_NonSyscoItem1Select","//*[@id='list-item']//span[contains(text(),'Miscellaneous')]",Target.XPATH);
	   public static final Target DefaultCategory_Food= new Target("DefaultCategory_Food","//*[@id='list-item']//span[contains(text(),'Food')]",Target.XPATH);
	   public static final Target DefaultCategory_NonFood= new Target("DefaultCategory_NonFood","//*[@id='list-item']//span[contains(text(),'Non-Food')]",Target.XPATH);
													  
	
	   public static String SyscocategoryKeyword1;
	   public static String[] SyscoCategory1;
	   public static String Selected_SuggCat1;
	   
	   public static final Target Select_SuggCat_Dairy = new Target("Select_SuggCat_Dairy","//*[@id='list-item']//*[contains(text(),'Dairy')]",Target.XPATH);
	   public static final Target Select_SuggCat_Meat = new Target("Select_SuggCat_Meat","//*[@id='list-item']//*[contains(text(),'Meat')]",Target.XPATH);
						
//	   public static final Target FoodAndNonFoodDesc = new Target("FoodAndNonFoodDesc","//*[@class='mm-c-inventory-setup']//*[contains(text(),'Use these as expense categories')]",Target.XPATH);
//	   public static final Target SuggestedCategoriesDesc = new Target("SuggestedCategoriesDesc","//*[@class='mm-c-inventory-setup']//*[contains(text(),'Meat, Poultry, Seafood, Dairy, Produce, Groceries, Beverages, & Miscellaneous')]",Target.XPATH);
//	   public static final Target CustomCategoriesDesc = new Target("CustomCategoriesDesc","//*[@class='mm-c-inventory-setup']//*[contains(text(),'Create your own')]",Target.XPATH);

	   public static final Target SetUp_Pg3Title = new Target("SetUp_Pg3Title","//*[contains(text(),'Set up Food Cost')]",Target.XPATH);  
	   public static final Target FoodAndNonFood = new Target("FoodAndNonFood","//*[contains(text(),'Food & Non-Food')]",Target.XPATH);
	   public static final Target  SuggestedCategories = new Target("SuggestedCategories","//*[contains(text(),'Suggested Categories')]",Target.XPATH);
	   public static final Target  CustomCategories = new Target("CustomCategories","//*[contains(text(),'Create Expense Cat.')]",Target.XPATH);
	   public static final Target textUnderFoodAndNOnFood = new Target("textUnderFoodAndNOnFood","//*[contains(text(),'Use these as expense categories')]",Target.XPATH);
	   public static final Target textUnderSuggestedCat = new Target("textUnderSuggestedCat","//*[contains(text(),'Meat, Poultry, Seafood, Dairy, Produce, Groceries, Beverages, & Miscellaneous')]",Target.XPATH);
	   public static final Target textUnderCreateExpCat = new Target("textUnderCreateExpCat","//*[contains(text(),'Create your own')]",Target.XPATH);

	   public static final Target FoodAndNonFoodDesc = new Target("FoodAndNonFoodDesc","//*[contains(text(),'Use these as expense categories')]",Target.XPATH);
	   public static final Target SuggestedCategoriesDesc = new Target("SuggestedCategoriesDesc","//*[contains(text(),'Meat, Poultry, Seafood, Dairy, Produce, Groceries, Beverages, and Miscellaneous')]",Target.XPATH);
	   public static final Target CustomCategoriesDesc = new Target("CustomCategoriesDesc","//*[contains(text(),'Create your own')]",Target.XPATH);



						  
	public CategoryPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public CategoryPage atCategoryPage()
	{
		log("Launched Category Page",LogType.STEP);
		
		return this;
	}

	public CategoryPage CustomCategories(String string)
	{
		log("Selecting custom category from Food cost page",LogType.STEP);
		
		  String string1="Success";
		  String string2="Issue";
         
          String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
          String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
		
          try{
        	  
        	  	getCommand().waitForTargetPresent(FoodAndNonFood);
				
				getCommand().waitForTargetPresent(CustomCategories);
				
				if(getCommand().isTargetPresent(CustomCategories))
				{
					getCommand().click(CustomCategories);
				
					  
					log("CustomCategory selected :Pass",LogType.VERIFICATION_STEP);
					
				}
				
          }
		
	
		catch(Exception e){
			 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
				getCommand().captureScreenshot(finalPath1);
			log("Custom category selected from food cost page :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	}
	 public CategoryPage tapContinue(String string){
		  String string1="Success";
		  String string2="Issue";
		   String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
	       String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
	     	try{
	     		
	     	
				getCommand().waitForTargetPresent(Continue);
				getCommand().click(Continue);
			
				log("Tapped on Continue :Pass",LogType.VERIFICATION_STEP);
	     	 }
		
		catch(Exception e)
		{
			 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
				getCommand().captureScreenshot(finalPath1);
			log("Tapped on Continue :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		
		return this;
		
	}
	 public CategoryPage CategoryDetails(String Name, String string)
	 {
	 	log("Creating custom category",LogType.STEP);
	 	  String string1="Success";
	 	  String string2="Issue";
	 	   String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
	       String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
	      	
	       String name=Name;
	       try{
	 		System.out.println("exp pg");
	 		getCommand().waitForTargetPresent(ExpenseCategory_Page);
	 		
	 		getCommand().waitForTargetPresent(ExpenseCategory_Name);
	 		
	 		if(getCommand().isTargetPresent(ExpenseCategory_Name))
	 		{
	 			getCommand().click(ExpenseCategory_Name);
	 			getCommand().sendKeys(ExpenseCategory_Name, name);
	 			
	 			getCommand().waitForTargetPresent(ExpenseCategory_Food);
	 			getCommand().click(ExpenseCategory_Food);
	 		
	 			
	 		}
	 	
	 		log("Custom category created  :Pass",LogType.VERIFICATION_STEP);	
	 	}
	 	

	 	catch(Exception e){
	 		 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
				getCommand().captureScreenshot(finalPath1);
	 	
	 		log("Custom category created  :Fail",LogType.VERIFICATION_STEP);
	 		Assert.assertTrue(false);
	 	}
	 	return this;
	 	
	 }
	  public CategoryPage TapOnNext(String string){
	       	String string1="Success";
	       	  String string2="Issue";

	       String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
	       String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;

	       	try{
	       			getCommand().waitForTargetPresent(Next);
	       		if (getCommand().isTargetPresent(Next))
	       		{
	       			
	       			getCommand().click(Next);
	       			log("Tapped on Next : Pass",LogType.VERIFICATION_STEP);
	       			
	       		}
	       		
	       	}
	       	catch(Exception e)
	       	{ 
	       		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath1);
	       		log("Tapped on Next :Fail",LogType.VERIFICATION_STEP);
	       	
	       		Assert.assertTrue(false);
	       	}
	       	
	       	return this;
	       }
	  public CategoryPage SelectItemFromCategory(String name,String string) { 
	    	log("Selecting item to custom category created",LogType.STEP); 
	    	String string1="Success";
	    	String string2="Issue";
	    	String string3="Page"; 
	    	String string4="Success1";
	    	String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension; 
	    	String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
	    	String finalPath2=GlobalVariable.drivePath+string+string3+GlobalVariable.pathExtension;
	    	String finalPath3=GlobalVariable.drivePath+string+string4+GlobalVariable.pathExtension;
	    	try{ 
	    	  getCommand().captureScreenshot(finalPath2);
	    	  getCommand().waitFor(5);
	    	
	    	  getCommand().waitForTargetPresent(Header);
	    	 
	    	CategoryName= getCommand().getText(Header);
	    	System.out.println("heading:"+CategoryName); 
	    	
	
	    	getCommand().waitFor(5);
	    	if(getCommand().isTargetPresent(Category_FirstItemSelect)) {
	    		getCommand().waitFor(5);
	    		getCommand().click(Category_FirstItemSelect); 
	    		ItemNameSelected=getCommand().getText(Category_FirstItemHeader); 
	    		System.out.println("Item heading:"+ItemNameSelected); 
	    		 
	    		log("First item selected :Pass",LogType.VERIFICATION_STEP); 
	    		} 
	    	
	    	
	    
	    	
	    	if(getCommand().isTargetPresent(Done)) { 
	    		getCommand().click(Done); 
	    		
	    		getCommand().waitForTargetPresent(InvToolsPg);

	    		log("First item added to category created :Passed",LogType.VERIFICATION_STEP); 
	    		
	    		}
	    	
	    	
	    	else { 
	    		
	    		System.out.println("second item");
	    		
	    		if(getCommand().isTargetPresent(Next)) { 
	    			getCommand().click(Next);
	    			
	    			getCommand().waitForTargetPresent(Header).getText(Header).equalsIgnoreCase(name);
	    			log("Second Category Page available :Pass",LogType.VERIFICATION_STEP);
	
	    		
	    			getCommand().click(SecondCategory_FirstItemSelect); 
	    			System.out.println("item selected for second category");
	    			log("First item selected in second category:Pass",LogType.VERIFICATION_STEP); 
	    			 
	    				getCommand().click(Done); 
	    			
	    				getCommand().waitForTargetPresent(InvToolsPg);
	    			 log("Item added to Second Category :Pass",LogType.VERIFICATION_STEP);	
	    			} 
	    		  
	    		}
	    	
	    	} 
	    	catch(Exception e){ 
	    		 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
					getCommand().captureScreenshot(finalPath1);
	    	
	    		log(" Item added to category created :Fail",LogType.VERIFICATION_STEP); 
	    		Assert.assertTrue(false); 
	    		} 
	    	return this; 
	    	
	    }

	  public CategoryPage defaultCategories(String string)
		{
			log("Selecting default category from Food cost page",LogType.STEP);
			
			  String string1="Success";
			  String string2="Issue";
	         
	          String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
	          String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
			
	          try{
	        	   getCommand().waitForTargetPresent(FoodAndNonFood);
					
					if(getCommand().isTargetPresent(FoodAndNonFood))
					{
						getCommand().click(FoodAndNonFood);
						  
						log("default Category selected :Pass",LogType.VERIFICATION_STEP);
						
					}
					
	          }
			
		
			catch(Exception e){
				 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
					getCommand().captureScreenshot(finalPath1);
			
				log("default category selected from food cost page :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
	  public CategoryPage tapComplete(String string){
		  String string1="Success";
		  String string2="Issue";
		   String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
	       String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
	     	try{
	     		
	     
				getCommand().waitForTargetPresent(Complete);
				getCommand().click(Complete);
			
		
			
			log("Tapped on Complete :Pass",LogType.VERIFICATION_STEP);
		}
		
		catch(Exception e)
		{
			 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
				getCommand().captureScreenshot(finalPath1);
		
			log("Tapped on Complete :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		
		return this;
		
	}      
	  
	  public CategoryPage CreateTwoExpenseCategory(String Name1,String Name2,String string) {
	       	log("Creating multiple custom category",LogType.STEP); 
	       	
	       	String finalPath=GlobalVariable.drivePath+string+GlobalVariable.string1+GlobalVariable.pathExtension; 
	       	String finalPath1=GlobalVariable.drivePath+string+GlobalVariable.string2+GlobalVariable.pathExtension;
	       	//String finalPath2=GlobalVariable.drivePath+string+string3+GlobalVariable.pathExtension;
	       	 
	       	try{ 
	       		 getCommand().waitForTargetPresent(ExpenseCategory_Page);

	    //   	getCommand().waitForTargetPresent(ExpenseCategory_NameTxt);
	       	if(getCommand().isTargetPresent(ExpenseCategory_NameTxt))
	       	{ 
	       		
	       		getCommand().click(ExpenseCategory_NameTxt);
	       		getCommand().sendKeys(ExpenseCategory_NameTxt, Name1); 
	  
	       		getCommand().waitForTargetPresent(ExpenseCategory_Food);
	       		getCommand().click(ExpenseCategory_Food); 
	       		
	       		
//	       		getCommand().waitForTargetPresent(ExpenseCategory_AnotherCategory);
	       		if(getCommand().isTargetPresent(ExpenseCategory_AnotherCategory)) { 
	       			
	       			getCommand().click(ExpenseCategory_AnotherCategory); 
	                      System.out.println("clicked second category");
	                     
	       			
	                    }
	       	
	 
	       	
	       	System.out.println("entering second name");
	       		if(getCommand().isTargetPresent(ExpenseCategory_Name1)) {
	       			System.out.println("second category");
	       			getCommand().click(ExpenseCategory_Name1);
	       			getCommand().sendKeys(ExpenseCategory_Name1, Name2); 
	       			
	       			getCommand().waitForTargetPresent(ExpenseCategory_Food1);

	       			getCommand().click(ExpenseCategory_Food1);

	       			}
	       			
	       		getCommand().waitFor(5);
	    
	       		
	       			
	       				
	       		
    		log("CustomCategories created:Pass",LogType.VERIFICATION_STEP); 
	       		} 
	       
	   }
	       catch(Exception e){
	    	   ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
				getCommand().captureScreenshot(finalPath1);
	     
	       	log("CustomCategories created:Fail",LogType.VERIFICATION_STEP);
	       	Assert.assertTrue(false); 
	       	} 
	       return this;
	       	}  

	  public CategoryPage CustomCategory_ItemSelectAndCheck(String string)
	   	{
	   		log("Verifyinging added item is in  custom category - Uncategorised and All Items",LogType.STEP);
	   		
	   		  String string1="Success";
	   		  String string2="Issue";
	   		 
	             String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
	             String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
	            
	   			
	             try{
	   			
	           	  
	           	  getCommand().waitForTargetPresent(Category_Header);
	            	 
	             	CategoryName= getCommand().getText(Category_Header);
	             	System.out.println("headeing:"+CategoryName); 
	           
	             		    	getCommand().waitFor(5);
	             	if(getCommand().isTargetPresent(Category_FirstItemSelect)) {
	             		getCommand().waitFor(5);
	             		getCommand().click(Category_FirstItemSelect); 
	             		ItemAdded=getCommand().getText(Category_FirstItemHeader); 
	             		System.out.println("Item heading:"+ItemAdded); 
	             		
	             		
	             		log("First item selected",LogType.VERIFICATION_STEP); 
	             		} 
	             	
	           	  
	           	  
	   		       getCommand().waitFor(5);	
	   		       getCommand().waitForTargetPresent(SetupInventoryCustomCategoryAllItemsTab);
	   		       getCommand().click(SetupInventoryCustomCategoryAllItemsTab);
	   		       getCommand().waitFor(3);
	   		       final Target  FirstItemSelectedFromUncatgorisedVerify= new Target("FirstItemSelectedFromUncatgorised","//*[@id='mount']//*[contains(text(),'"+ItemAdded+"')]",Target.XPATH);
	   			   
	   		      System.out.println("//*[@id='mount']//*[contains(text(),'"+ItemAdded+"')]");
	   		       System.out.println("TargetPresent: "+getCommand().isTargetVisible(FirstItemSelectedFromUncatgorisedVerify));
	   		       
	   		       if (getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify)) {
	   				System.out.println("Selected item is present in All Items Tab : Pass");
	   				log(" Added item  is present in All Items Tab  :Pass",LogType.VERIFICATION_STEP);
	   				
	   			}
	   		       getCommand().waitFor(5);	
	   		       getCommand().waitForTargetPresent(SetupInventoryCustomCategoryUncategorizedTab);
	   		       getCommand().click(SetupInventoryCustomCategoryUncategorizedTab);
	   		     
	   		      		       
	   		       if (getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify)) {
	   					System.out.println("Added item  is present in uncategorized Tab(Expected-Item should not be present) :Fail");
	   					log(" Added item  is present in category Tab(Expected-Item should not be present) :Fail",LogType.VERIFICATION_STEP);
	   					throw new Exception();
	   				}
	   		       else if (!(getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify))) {
	   		    	   System.out.println("Added item  is not present in uncategorized Tab :Pass");
	   					log(" Added item  is not present in uncategorized Tab :Pass",LogType.VERIFICATION_STEP);
	   			}
	   		       
	   		       getCommand().waitFor(5);	
	   		       
	   		     
	   		}
	   		
	   	
	   		catch(Exception e){
	   		 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
				getCommand().captureScreenshot(finalPath1);
	  
	   			log("Added item  is present in category created :Fail",LogType.VERIFICATION_STEP);
	   			Assert.assertTrue(false);
	   		}
	   		return this;
	   		
	   	}	
	
	  
	  
	  
	  public CategoryPage selectMultipleItemsFromCategory1(String string) {
	   	   	 String string1="Success";
	   	   	  String string2="Issue";
	   	   String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
        String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
       
	   	      try{

	   	   		log(" Selecting multiple Items to category",LogType.STEP);
	   	   		
	   	   			
	   	   		getCommand().waitForTargetPresent(Category_1stItemSelect);
	 	      	
	   	   		if(getCommand().isTargetPresent(Category_1stItemSelect))
	   	   		{
	   	   		CategoryNoOfElements1++;
	   	   		CategoryItemName1_1=getCommand().getText(Category_1stItemHeading);
	   	   			getCommand().click(Category_1stItemSelect);
	   	   			System.out.println("Item heading:"+CategoryItemName1_1);
	   	   		log("First item selected :Pass",LogType.VERIFICATION_STEP); 
	   	   		}
	   	   		
	   	   		if(getCommand().isTargetPresent(Category_2ndItemSelect)){
	   	   			
	   	   		CategoryNoOfElements1++;
	   	   		CategoryItemName1_2=getCommand().getText(Category_2ndItemHeading);
	   	   			getCommand().click(Category_2ndItemSelect);
	   	   			System.out.println("Item heading:"+CategoryItemName1_2);
	   	   		log("2nd item selected :Pass",LogType.VERIFICATION_STEP); 
	   	   		}
	   	   			
	   	   		if(getCommand().isTargetPresent(Category_3rdItemSelect)){	
	   	   		CategoryNoOfElements1++;
	   	   		CategoryItemName1_3=getCommand().getText(Category_3rdItemHeading);
	   	   			getCommand().click(Category_3rdItemSelect);
	   	   			System.out.println("Item heading:"+CategoryItemName1_3);
	   	   		log("3rd item selected :Pass",LogType.VERIFICATION_STEP); 
	   	   		}
	   	   	
	   	   		else
	   	   		
	   	   			{

		   			((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		   			getCommand().captureScreenshot(finalPath1);
		     			log("Multiple items selected :Fail",LogType.VERIFICATION_STEP); 
		     		
			   			 Set<String> contextNames1 = ((AndroidDriver) getCommand().driver).getContextHandles();
			    	  	  	    	  		 for (String contextName : contextNames1){
			    	  		 }
			    	  	((AndroidDriver)getCommand().driver).context((String) contextNames1.toArray()[1]);
	   	   			}
	   	   		}
	   	   	
	   	   	catch(Exception e){
	   	   	 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
				getCommand().captureScreenshot(finalPath1);
	   	   
	   	   		log("Multiple items selected :Fail",LogType.VERIFICATION_STEP);
	   	   		Assert.assertTrue(false);
	   	   	}
	   	      return this;
	   	   }
	
   public CategoryPage selectMultipleItemsFromCategory2(String string) {
	   	 String string1="Success";
	   	  String string2="Issue";
		String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
		String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;	
	
	      try{

	    	log(" Selecting multiple Items to category",LogType.STEP);
	   		
	
	     	getCommand().waitForTargetPresent(Category_1stItemSelect);
	      	
	   		if(getCommand().isTargetPresent(Category_1stItemSelect))
	   		{
	   		CategoryNoOfElements1++;
	   		CategoryItemName2_1=getCommand().getText(Category_1stItemHeading);
	   			getCommand().click(Category_1stItemSelect);
	   			System.out.println("Item heading:"+CategoryItemName2_1);
	   		log("First item selected :Pass",LogType.VERIFICATION_STEP); 
	   		}
	   		if(getCommand().isTargetPresent(Category_2ndItemSelect)){
	   			
	   		CategoryNoOfElements1++;
	   		CategoryItemName2_2=getCommand().getText(Category_2ndItemHeading);
	   			getCommand().click(Category_2ndItemSelect);
	   			System.out.println("Item heading:"+CategoryItemName2_2);
	   		log("second item selected :Pass",LogType.VERIFICATION_STEP); 
	   		}
	   			
	   		if(getCommand().isTargetPresent(Category_3rdItemSelect)){	
	   		CategoryNoOfElements1++;
	   		CategoryItemName2_3=getCommand().getText(Category_3rdItemHeading);
	   			getCommand().click(Category_3rdItemSelect);
	   			System.out.println("Item heading:"+CategoryItemName2_3);
	   		log("third item selected :Pass",LogType.VERIFICATION_STEP); 
	   		
	   		}
	   			
	   		
	   		else{
	   			((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
	   			    
	   			     getCommand().captureScreenshot(finalPath1);
	     			log("Multiple items selected :Fail",LogType.VERIFICATION_STEP); 
	     		
		   			 Set<String> contextNames1 = ((AndroidDriver) getCommand().driver).getContextHandles();
		    	  	  	    	  		 for (String contextName : contextNames1){
		    	  		 }
		    	  	((AndroidDriver)getCommand().driver).context((String) contextNames1.toArray()[1]);

	   		}
	      }
	   	catch(Exception e){
	   		
	   	((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);

	   		log("Multiple items selected :Fail",LogType.VERIFICATION_STEP);
	   		Assert.assertTrue(false);
	   	}
	      return this;
	   }
	    

public CategoryPage AddCategoryName(String categoryName,String string)
   	{
   		String string1="Success";
   		String string2="Issue";   
   		String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
   		String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;	
   		
   		try{
   		
   			getCommand().clear(ADD_CategoryName);
   			getCommand().click(ADD_CategoryName);
   			getCommand().sendKeys(ADD_CategoryName,categoryName);
   			log("added category name :Pass",LogType.VERIFICATION_STEP);
   			}
   			
   	
   		
   		catch(Exception e)
   		{
   			((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath1);
   	
   			log("added category name :Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
   		
   		return this;
   		
   	}
   public CategoryPage AddCategoryFood(String string)
   	{
   		String string1="Success";
   		String string2="Issue";   
   		String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
   		String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;	
   		
   		try{
   			
 
   			getCommand().waitForTargetPresent(AddCategory_FoodWeb);
   		    getCommand().click(AddCategory_FoodWeb);
   		    
   			log("Selected cooler :Pass",LogType.VERIFICATION_STEP);
   			}
   			
   	
   		
   		catch(Exception e)
   		{
   			((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath1);
   			
   			log("Selected cooler :Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
   		
   		return this;
   		
   	}


public CategoryPage TapOnDone(String string){
    	String string1="Success";
    	  String string2="Issue";

    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;

    	try{
    	
    			getCommand().waitForTargetPresent(DoneWeb);
    		if (getCommand().isTargetPresent(DoneWeb))
    		{
    			
    			getCommand().clickWithJavascript(DoneWeb);
    			log("Tapped on done:Pass",LogType.VERIFICATION_STEP);
    			
    			
    		}
    		
    	}
    	catch(Exception e)
    	{
    		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath1);
    		log("Tapped on done :Fail",LogType.VERIFICATION_STEP);
    		
    		Assert.assertTrue(false);
    	}
    	
    	return this;
    }


public CategoryPage SelectCategory(String name,String string)
{
	

	  
    String finalPath=GlobalVariable.drivePath+string+GlobalVariable.string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+GlobalVariable.string2+GlobalVariable.pathExtension;
    
	log("Selecting Category",LogType.STEP);
try{

		getCommand().waitFor(2);
		final Target  Locname= new Target("Locname","//*[@id='list-item']//*[contains(text(),'"+name+"')]",Target.XPATH);   
		getCommand().click(Locname); 
      
	
  
		log("Category is selected for item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
	
		log("Category is selected for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}


public CategoryPage TapOnBack(String string){
		

	String finalPath=GlobalVariable.drivePath+string+GlobalVariable.string1+GlobalVariable.pathExtension;
	String finalPath1=GlobalVariable.drivePath+string+GlobalVariable.string2+GlobalVariable.pathExtension;

		try{
		
			getCommand().waitForTargetPresent(Back);
			if (getCommand().isTargetPresent(Back))
			{
				
				getCommand().clickWithJavascript(Back);
				
			
				log("tap on back :Pass",LogType.VERIFICATION_STEP);
			}
			
		}
		catch(Exception e)
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath1);
			log("tap on back :Fail",LogType.VERIFICATION_STEP);
			
			Assert.assertTrue(false);
		}
		
		return this;
	}



public CategoryPage VerifyCategory(String name,String string)
{
	

	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	log("Selected Category is there",LogType.STEP);
try{
	

	getCommand().waitFor(2);
	final Target  Locname= new Target("Locname","//*[@class='mm-c-product-list__details']//*[contains(text(),'"+name+"')]",Target.XPATH);   
	   

  
		log("Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
	
		log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}



public CategoryPage TapAdd(String string)
{
String string1="Success";
String string2="Issue";   
String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;	

try{


getCommand().waitForTargetPresent(AddWeb);
if(getCommand().isTargetPresent(AddWeb))
{
	getCommand().clickWithJavascript(AddWeb);

	System.out.println("Inside add categories pg");

	log("Navigating to Add categories page :Pass",LogType.VERIFICATION_STEP);	

}


}
catch(Exception e)
{	((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
getCommand().captureScreenshot(finalPath1);

log("Navigating to Add categories page :Fail",LogType.VERIFICATION_STEP);
Assert.assertTrue(false);
}

return this;

}

public  CategoryPage VerifyCategoryList(String categoryAdded,String string){
String string1="Success";
String string2="Issue";

String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
log("Checking addeded Location in location list",LogType.STEP);
try{	



final Target  CatAdded= new Target("CatAdded","//*[@id='list-item']//span[contains(text(),'"+categoryAdded+"')]",Target.XPATH);   

getCommand().waitForTargetPresent(CatAdded);

if (getCommand().isTargetPresent(CatAdded)) {
	

	log("Category is added :Pass",LogType.VERIFICATION_STEP);
}

}
catch(Exception e)
{
	((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
	getCommand().captureScreenshot(finalPath1);

log("Added Category is listed   :Fail",LogType.VERIFICATION_STEP);	
Assert.assertTrue(false);
}

return this;


}

public CategoryPage TapOnEdit(String string){
String string1="Success";
String string2="Issue";

String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
log("Editing",LogType.STEP);
try{
	getCommand().waitForTargetPresent(EditWeb);
	if (getCommand().isTargetPresent(EditWeb))
	{
		
		getCommand().click(EditWeb);
		
		log("tap on edit :Pass",LogType.VERIFICATION_STEP);
	}
	
}
catch(Exception e)
{
	((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
	getCommand().captureScreenshot(finalPath1);
	log("tap on edit :Fail",LogType.VERIFICATION_STEP);

	Assert.assertTrue(false);
}

return this;
}

public CategoryPage TapOnDeleteCategory(String string){
String string1="Success";
String string2="Issue";

String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
log("Delete cliking",LogType.STEP);
try{
	
	getCommand().waitForTargetPresent(Delete);
	if (getCommand().isTargetPresent(Delete))
	{
		
		getCommand().click(Delete);
		
	
		log("tap on Delete :Pass",LogType.VERIFICATION_STEP);
	}
	
}
catch(Exception e)
{
	((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
	getCommand().captureScreenshot(finalPath1);
	log("tap on delete:Fail",LogType.VERIFICATION_STEP);
	
	Assert.assertTrue(false);
}

return this;
}

public CategoryPage TapOnYesDelete(String string){
	String string1="Success";
	  String string2="Issue";

String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
log("Deleted",LogType.STEP);
	try{
		getCommand().waitForTargetPresent(YesDelete);
		if (getCommand().isTargetPresent(YesDelete))
		{
			
			getCommand().click(YesDelete);
		
			log("tap on yes delete :Pass",LogType.VERIFICATION_STEP);
		}
		
	}
	catch(Exception e)
	{
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
		log("tap on yes delete :Fail",LogType.VERIFICATION_STEP);
	
		Assert.assertTrue(false);
	}
	
	return this;
}
public  CategoryPage VerifyDeletedCategoryList(String categoryAdded,String string){
String string1="Success";
String string2="Issue";

String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
log("Checking addeded category in list",LogType.STEP);
try{	

final Target  CatAdded= new Target("LocAdded","//*[@id='list-item']//span[contains(text(),'"+categoryAdded+"')]",Target.XPATH);   


if (getCommand().isTargetPresent(CatAdded)) {
	
	log("Deleted category is there :Fail",LogType.VERIFICATION_STEP);
	Assert.assertTrue(false);
}


log("Deleted category is not listed   :Pass",LogType.VERIFICATION_STEP);
}
catch(Exception e)
{	
	((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
	getCommand().captureScreenshot(finalPath1);
	
log("Deleted category is  listed   :Fail",LogType.VERIFICATION_STEP);	
Assert.assertTrue(false);
}

return this;


}  	


public CategoryPage AssignMultipleItemsToCategory(String string) {
String string1="Success";
 String string2="Issue";
 
String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
try{

	log(" Adding Items of multiplelist to Category",LogType.STEP);
	

getCommand().waitForTargetPresent(Category_1stItemSelect);

	if(getCommand().isTargetPresent(Category_1stItemSelect))
	{
	CategoryNoOfElements1++;
	CategoryItemName1_1=getCommand().getText(Category_1stItemHeading);
		getCommand().click(Category_1stItemSelect);
		System.out.println("Item heading:"+CategoryItemName1_1);
	
	
	if(getCommand().isTargetPresent(Category_2ndItemSelect)){
		
	CategoryNoOfElements1++;
CategoryItemName1_2=getCommand().getText(Category_2ndItemHeading);
		getCommand().click(Category_2ndItemSelect);
		System.out.println("Item heading:"+CategoryItemName1_2);
	}
		
	if(getCommand().isTargetPresent(Category_NonSyscoItem1Select)){	
	CategoryNoOfElements1++;
CategoryItemName1_3=getCommand().getText(Category_3rdItemHeading);
		getCommand().click(Category_NonSyscoItem1Select);
		System.out.println("Item heading:"+CategoryItemName1_3);
	}
		
	if(getCommand().isTargetPresent(Category_NonSyscoItem2Select)){	
		CategoryNoOfElements1++;
	CategoryItemName1_4=getCommand().getText(Category_3rdItemHeading);   
	
			getCommand().click(Category_NonSyscoItem2Select);
			System.out.println("Item heading:"+CategoryItemName1_4);
		}	
	log("Multiple items selected :Pass",LogType.VERIFICATION_STEP);
	}
	else {
		log("Multiple items selected :Fail",LogType.VERIFICATION_STEP);
	}
		
					
	}

catch(Exception e){
	((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
	getCommand().captureScreenshot(finalPath1);
    
	log("Multiple items selected :Fail",LogType.VERIFICATION_STEP);
	Assert.assertTrue(false);
}
return this;
}



public CategoryPage SuggestedCategories(String string)
{
	log("Selecting suggested category from Food cost page",LogType.STEP);
	
	  String string1="Success";
	  String string2="Issue";
     
      String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
      String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
	
      try{
    	  	getCommand().waitForTargetPresent(FoodAndNonFood);
			
			getCommand().waitForTargetPresent(SuggestedCategories);
			
			if(getCommand().isTargetPresent(SuggestedCategories))
			{
				getCommand().click(SuggestedCategories);
				  
				log("Suggested Category selected :Pass",LogType.VERIFICATION_STEP);
				
			}
			
      }
	

	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
	//	getCommand().captureScreenshot(finalPath1); 
		log("Suggested category selected from food cost page :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}


public CategoryPage VerifyMultipleListSyscoSuggestedCategory(String string)
{
	
	 Boolean flag1=false;
	 Boolean flag2=false;
	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	log("Ctegory verification",LogType.STEP);
try{
	
 getCommand().waitFor(2);
	System.out.println(LocationsPage.Category1[0]);
	System.out.println(LocationsPage.Category2[0]);
	
 if((LocationsPage.Category1[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category1[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category1[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category1[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category1[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category1[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category1[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category1[0].equalsIgnoreCase("Miscellaneous"))){
	  flag1=true;
	  
 }
 if((LocationsPage.Category2[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category2[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category2[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category2[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category2[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category2[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category2[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category2[0].equalsIgnoreCase("Miscellaneous"))){
	  flag2=true;
	  
}
 System.out.println("Flag1: "+flag1+flag2);
 if(!(flag2&&flag1)){ 
	   throw new Exception();
 } 
   

		log("Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
	 
		log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}

public CategoryPage VerifyPrepCustomCategory(String customcategory,String string)
{
	
	 Boolean flag4=false;
	
	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	log("Category verification for nonsysco",LogType.STEP);
try{
	

 getCommand().waitFor(2);
	System.out.println(LocationsPage.Prep_Category1[0]);
	
	
 if((LocationsPage.Prep_Category1[0].equalsIgnoreCase(customcategory))){
	  flag4=true;
	  
 }

 System.out.println("Flag4: "+flag4);
 if(!(flag4)){ 
	   throw new Exception();
 } 
   
  
		log("Category is verified for prep item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
		
		log("Category is verified for prep item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}
public CategoryPage VerifyOGSyscoItemsSuggestedCategoryLocation1(String string)
{
	Boolean flag3=false;
	 Boolean flag1=false;
	 Boolean flag2=false;
	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	log("Ctegory verification",LogType.STEP);
try{

 getCommand().waitFor(2);
	System.out.println(LocationsPage.Category3[0]);
	System.out.println(LocationsPage.Category4[0]);
	System.out.println(LocationsPage.Category5[0]);
	
 if((LocationsPage.Category3[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category3[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category3[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category3[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category3[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category3[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category3[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category3[0].equalsIgnoreCase("Miscellaneous"))){
	  flag1=true;
	  
 }
 if((LocationsPage.Category4[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category4[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category4[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category4[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category4[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category4[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category4[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category4[0].equalsIgnoreCase("Miscellaneous"))){
	  flag2=true;
	  
}
 if((LocationsPage.Category5[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category5[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category5[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category5[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category5[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category5[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category4[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category5[0].equalsIgnoreCase("Miscellaneous"))){
	  flag3=true;
	  
}
 
 System.out.println("Flag1: "+flag1+flag2+flag3);
 if(!(flag2&&flag1&&flag3)){ 
	   throw new Exception();
 } 
   
 
  
		log("Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
	
		log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}


public CategoryPage VerifyOGSyscoItemsSuggestedCategoryLocation2(String string)
{
	Boolean flag3=false;
	 Boolean flag1=false;
	 Boolean flag2=false;
	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	log("Ctegory verification",LogType.STEP);
try{
	

 getCommand().waitFor(2);
	
	System.out.println(LocationsPage.Category6[0]);
	System.out.println(LocationsPage.Category7[0]);
	System.out.println(LocationsPage.Category8[0]);
 if((LocationsPage.Category6[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category6[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category6[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category6[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category6[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category6[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category6[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category6[0].equalsIgnoreCase("Miscellaneous"))){
	  flag1=true;
	  
 }
 if((LocationsPage.Category7[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category7[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category7[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category7[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category7[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category7[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category7[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category7[0].equalsIgnoreCase("Miscellaneous"))){
	  flag2=true;
	  
}
 if((LocationsPage.Category8[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category8[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category8[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category8[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category8[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category8[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category8[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category8[0].equalsIgnoreCase("Miscellaneous"))){
	  flag3=true;
	  
}
 
 System.out.println("Flag1: "+flag1+flag2+flag3);
 if(!(flag2&&flag1&&flag3)){ 
	   throw new Exception();
 } 
   
  
		log("Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		
		 getCommand().captureScreenshot(finalPath1); 
		log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}
public CategoryPage VerifyNonSycoCustomCategory(String customcategory,String string)
{
	
	 Boolean flag3=false;
	
	  String string1="Success";
	  String string2="Issue";
	  
  String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
  String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
  
	log("Category verification for nonsysco",LogType.STEP);
try{
	
	

getCommand().waitFor(2);
	System.out.println(LocationsPage.NonSysco_Category1[0]);
	
	
if((LocationsPage.NonSysco_Category1[0].equalsIgnoreCase(customcategory))){
	  flag3=true;
	  
}

System.out.println("Flag3: "+flag3);
if(!(flag3)){ 
	   throw new Exception();
} 
 

		log("Category is verified for nonsysco item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
 
		log("Category is verified for nonsyco item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}


public CategoryPage VerifySuggestedCategoryList(String string)
{
	
	 Boolean flag3=false;
	
	  String string1="Success";
	  String string2="Issue";
	  
  String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
  String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
  
	log("Suggested Category list verification",LogType.STEP);
try{
	


	boolean flag2_1 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Dairy, 3);
	boolean flag2_2 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Meat, 3);
	boolean flag2_3 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Poultry, 3);
	boolean flag2_4 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Seafood, 3);
	boolean flag2_5 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Produce, 3);
	boolean flag2_6 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Groceries, 3);
	boolean flag2_7 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Beverage, 3);
	boolean flag2_8 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Miscellaneous, 3);
	
	System.out.println("Flag2: "+flag2_1+flag2_2+flag2_3+flag2_4+flag2_5+flag2_6+flag2_7+flag2_8);
	if((flag2_1 && flag2_2 && flag2_3 && flag2_4 && flag2_5 && flag2_6 && flag2_7 && flag2_8)){ 
		log("Suggested category list verification done :Pass",LogType.VERIFICATION_STEP);
	}    			     
	
	else {
		log("Suggested category list verification done :Fail",LogType.VERIFICATION_STEP);
		 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			 getCommand().captureScreenshot(finalPath1); 
				
				Assert.assertTrue(false);
			 Set<String> contextNames1 = ((AndroidDriver) getCommand().driver).getContextHandles();
	  	  	    	  		 for (String contextName : contextNames1){
	  		 }
	  	((AndroidDriver)getCommand().driver).context((String) contextNames1.toArray()[1]);
	}
	
	
	}
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
     	log("Suggested categories are listed  :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}

public CategoryPage VerifyCustomListItemsDefaultCategoryLocation1(String string)
{
	 Boolean flag3=false;
	 Boolean flag1=false;
	 Boolean flag2=false;
	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	log("Default Category verification",LogType.STEP);
try{
	
 getCommand().waitFor(2);
	System.out.println(LocationsPage.Category3[0]);
	System.out.println(LocationsPage.Category4[0]);
	System.out.println(LocationsPage.Category5[0]);
	
 if((LocationsPage.Category3[0].equalsIgnoreCase("Food"))||(LocationsPage.Category3[0].equalsIgnoreCase("Non-Food"))){
	  flag1=true;
	  
 }
 if((LocationsPage.Category4[0].equalsIgnoreCase("Food"))||(LocationsPage.Category4[0].equalsIgnoreCase("Non-Food"))){
	  flag2=true;
	  
}
 if((LocationsPage.Category5[0].equalsIgnoreCase("Food"))||(LocationsPage.Category5[0].equalsIgnoreCase("Non-Food"))){
	  flag3=true;
	  
}
 
 System.out.println("Flag1: "+flag1+flag2+flag3);
 if(!(flag2&&flag1&&flag3)){ 
	   throw new Exception();
 } 
   
 
  
		log("Default Category is verified for items :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);

		log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}

public CategoryPage VerifyCustomListItemsDefaultCategoryLocation2(String string)
{
	Boolean flag3=false;
	 Boolean flag1=false;
	 Boolean flag2=false;
	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	log("Default Category verification",LogType.STEP);
try{
	
	getCommand().waitFor(2);
	System.out.println(LocationsPage.Category7[0]);
	System.out.println(LocationsPage.Category6[0]);
	System.out.println(LocationsPage.Category8[0]);
	
 if((LocationsPage.Category6[0].equalsIgnoreCase("Food"))||(LocationsPage.Category6[0].equalsIgnoreCase("Non-Food"))){
	  flag1=true;
	  
 }
 if((LocationsPage.Category7[0].equalsIgnoreCase("Food"))||(LocationsPage.Category7[0].equalsIgnoreCase("Non-Food"))){
	  flag2=true;
	  
}
 if((LocationsPage.Category8[0].equalsIgnoreCase("Food"))||(LocationsPage.Category8[0].equalsIgnoreCase("Non-Food"))){
	  flag3=true;
	  
}
 
 System.out.println("Flag1: "+flag1+flag2+flag3);
 if(!(flag2&&flag1&&flag3)){ 
	   throw new Exception();
 } 
   
 
  
		log("Default Category is verified for items :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);

		log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}

public CategoryPage VerifyDefaultCategoryList(String string)
{
	
	 Boolean flag3=false;
	
	  String string1="Success";
	  String string2="Issue";
	  
  String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
  String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
  
	log("Default Category list verification",LogType.STEP);
try{
	


	boolean flag2_1 = getCommand().isTargetPresentAfterWait(DefaultCategory_Food, 3);
	boolean flag2_2 = getCommand().isTargetPresentAfterWait(DefaultCategory_NonFood, 3);
	
	
	System.out.println("Flag2: "+flag2_1+flag2_2);
	if((flag2_1 && flag2_2)){ 
		log("Default category list verification done :Pass",LogType.VERIFICATION_STEP);
	}    			     
	
	else {
		log("Default category list verification done :Fail",LogType.VERIFICATION_STEP);
		 ((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
			 getCommand().captureScreenshot(finalPath1); 
				
				Assert.assertTrue(false);
			 Set<String> contextNames1 = ((AndroidDriver) getCommand().driver).getContextHandles();
	  	  	    	  		 for (String contextName : contextNames1){
	  		 }
	  	((AndroidDriver)getCommand().driver).context((String) contextNames1.toArray()[1]);
	}
	
	
	
	}
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
     	log("Default categories are listed  :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}


public CategoryPage VerifySuggestedCategory(String string)
{
	

	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	
try{
	
  final Target Sysco_Product_Select= new Target("Product_Select","(//*[@class='mm-c-product-list']//*[@class='mm-c-product-list__item mm-c-product__sysco ']//*[@class='mm-c-product-list__image'])[1]",Target.XPATH); 
	
		if(getCommand().isTargetPresent(Sysco_Product_Select)){
			final Target CategoryLine1= new Target("CategoryLine1","(//*[@class='mm-c-product-list']//*[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__location'])[1]",Target.XPATH); 
		//	$x("(//*[@class='mm-c-product-list']//*[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__location'])[1]")
			String SyscocategoryKeyword1 = getCommand().getText(CategoryLine1);
			System.out.println(SyscocategoryKeyword1);
				SyscoCategory1=SyscocategoryKeyword1.split("\\s+");
			System.out.println("Sysco Category1"+SyscoCategory1[0]);

			
		}
	   
		log("Suggested Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		 getCommand().captureScreenshot(finalPath1); 
		log("Suggested Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}
public CategoryPage TapAnySuggestedCategory(String string)
{
	

	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    

try{
	
  System.out.println("Category is "+SyscoCategory1[0]);
	if(SyscoCategory1[0].equalsIgnoreCase("Dairy"))
		{getCommand().waitForTargetPresent(Select_SuggCat_Meat).click(Select_SuggCat_Meat);
		Selected_SuggCat1="Meat";
		}
	else
		{getCommand().waitForTargetPresent(Select_SuggCat_Dairy).click(Select_SuggCat_Dairy);
		Selected_SuggCat1="Dairy";
		}
	System.out.println("changed category to :"+Selected_SuggCat1);
		log("Suggested Category is selected for item :Pass",LogType.VERIFICATION_STEP);						
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		 getCommand().captureScreenshot(finalPath1); 
		log("Suggested Category is selected for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}
public CategoryPage VerifySelectedSuggestedCategory(String string)
{
	

	  String string1="Success";
	  String string2="Issue";
	  
    String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
    String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
    
	
try{
	
	
	if(SyscoCategory1[0].equalsIgnoreCase(Selected_SuggCat1))
		 throw new Exception();
		//log("Suggested Category is changed for item :Fail",LogType.VERIFICATION_STEP);	
	else
		log("Suggested Category is changed for item :Pass",LogType.VERIFICATION_STEP);	
	
	
	}
	
	
	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		 getCommand().captureScreenshot(finalPath1); 
		log("Suggested Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}

public CategoryPage VerifyItemPresentUncategorizedAndAllItems(String string)
{
	log("Verifying added item is in  custom category - Uncategorised and All Items",LogType.STEP);
		
		  String string1="Success";
		  String string2="Issue";
		 
       String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
       String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;
      
			
       try{
	getCommand().waitFor(5);	
       getCommand().waitForTargetPresent(SetupInventoryCustomCategoryAllItemsTab);
       getCommand().click(SetupInventoryCustomCategoryAllItemsTab);
       getCommand().waitFor(3);
       final Target  FirstItemSelectedFromUncatgorisedVerify= new Target("FirstItemSelectedFromUncatgorised","//*[@id='mount']//*[contains(text(),'"+ItemAdded+"')]",Target.XPATH);
	   
      System.out.println("//*[@id='mount']//*[contains(text(),'"+ItemAdded+"')]");
       System.out.println("TargetPresent: "+getCommand().isTargetVisible(FirstItemSelectedFromUncatgorisedVerify));
       
       if (getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify)) {
		System.out.println("Selected item is present in All Items Tab : Pass");
		log(" Added item  is present in All Items Tab  :Pass",LogType.VERIFICATION_STEP);
		
	}
       getCommand().waitFor(5);	
       getCommand().waitForTargetPresent(SetupInventoryCustomCategoryUncategorizedTab);
       getCommand().click(SetupInventoryCustomCategoryUncategorizedTab);
     
      		       
       if (getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify)) {
			System.out.println("Added item  is present in uncategorized Tab(Expected-Item should not be present) :Fail");
			log(" Added item  is present in category Tab(Expected-Item should not be present) :Fail",LogType.VERIFICATION_STEP);
			throw new Exception();
		}
       else if (!(getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify))) {
    	   System.out.println("Added item  is not present in uncategorized Tab :Pass");
			log(" Added item  is not present in uncategorized Tab :Pass",LogType.VERIFICATION_STEP);
	}
       
       getCommand().waitFor(5);	
	
 

		log("Category is verified for nonsysco item :Pass",LogType.VERIFICATION_STEP);						
	
       }

	
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		 getCommand().captureScreenshot(finalPath1); 
		log("Category is verified for nonsyco item   :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	
}


public CategoryPage VerifyOptionsOnSetUpFoodCost(String string){

	String string1="Success";
	String string2="Issue";	
	String finalPath=GlobalVariable.drivePath+string+string1+GlobalVariable.pathExtension;
	String finalPath1=GlobalVariable.drivePath+string+string2+GlobalVariable.pathExtension;

	log("Category page verify ",LogType.STEP);
	try{


	
		
		getCommand().waitForTargetPresent(SetUp_Pg3Title);
			if(getCommand().isTargetPresent(FoodAndNonFood) && getCommand().isTargetPresent(FoodAndNonFoodDesc) && getCommand().isTargetPresent(SuggestedCategories) && getCommand().isTargetPresent(SuggestedCategoriesDesc) && getCommand().isTargetPresent(CustomCategories) && getCommand().isTargetPresent(CustomCategoriesDesc))
			{
				log("VerifyOptionsOnSetUpFoodCost:Pass",LogType.STEP);
				System.out.println("All present");
			}
			else
			{
				System.out.println("not present");
				log("VerifyOptionsOnSetUpFoodCost:Fail",LogType.STEP);
				throw new Exception();
			}
		log("Category page verification done :Pass",LogType.VERIFICATION_STEP);
	}
	catch(Exception e){
		((AndroidDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
		log("Category page verification done  :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}

	return this;

}




}
