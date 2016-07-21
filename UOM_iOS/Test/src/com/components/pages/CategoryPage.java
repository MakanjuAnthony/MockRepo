		
		/**
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 *																																		   	*
		 * 2016-2017 Infosys Limited, Banglore, India. All Rights Reserved										
									*

		 * Version: 1.0																																*
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
		import org.testng.Assert;
		import com.components.repository.SiteRepository;
		import com.iwaf.framework.components.IReporter.LogType;
		import com.iwaf.framework.components.Target;
		import io.appium.java_client.android.AndroidDriver;
		import io.appium.java_client.ios.IOSDriver;
		public class CategoryPage extends SitePage{
			public static final Target Continue = new Target("Continue","//*[@class='btn btn-default' and contains(text(),'Continue')]",Target.XPATH);
			public static final Target Header= new Target("Category_Header","//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3",Target.XPATH);
			public static final Target Category_FirstItemSelect= new Target("Category_FirstItemSelect","//*[@class='checkbox']//*[@class='mm-o-icon']//*[@class='item-input'and @data-index='0']",Target.XPATH);
			public static final Target Category_FirstItemHeader= new Target("Category_FirstItemHeader","//*[@id='mount']/div/div/div[2]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[2]/h4",Target.XPATH); 
			public static final Target InvToolsPg = new Target("InvToolsPg","//*[@class='navbar-brand']//*[contains(text(),'Inventory Tools')]",Target.XPATH);
			public static final Target SecondCategory_FirstItemSelect= new Target("Category_FirstItemSelect","//*[@class='checkbox']//*[@class='mm-o-icon']//*[@class='item-input'and @data-index='1']",Target.XPATH); 
			public static final Target FoodAndNonFood = new Target("FoodAndNonFood","//*[contains(text(),'Food & Non-Food')]",Target.XPATH);
			public static final Target  SuggestedCategories = new Target("SuggestedCategories","//*[contains(text(),'Suggested Categories')]",Target.XPATH);
			public static final Target  CustomCategories = new Target("CustomCategories","//*[contains(text(),'Create Expense Cat.')]",Target.XPATH);
		
			public String CategoryName;
			public String ItemNameSelected;
			public String ItemNameAdded;
			public static final Target Complete = new Target("Continue","//*[@class='btn btn-default' and contains(text(),'Complete')]",Target.XPATH);
		
			public static final Target SetupInventoryCustomCategoryAllItemsTab = new Target("SetupInventoryCustomLoc_LocName","//*[@id='mount']//*[@class='mm-c-productList--pill-left']/a",Target.XPATH);
			public static final Target SetupInventoryCustomCategoryUncategorizedTab = new Target("SetupInventoryCustomLoc_LocName","//*[@id='mount']//*[@class='mm-c-productList--pill-right']/a",Target.XPATH);
			public static String ItemAdded;
			public static final Target Category_Header= new Target("Category_Header","//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3",Target.XPATH);
		
			public static final Target ExpenseCategory_Food= new Target("ExpenseCategory_Food","(//*[@class='mm-c-customexpense__details-category']//*[@class='radio'])[1]/label",Target.XPATH); 
			public static final Target ExpenseCategory_Page= new Target("ExpenseCategory_Page","//*[@class='mm-c-customexpense__setup-text']//*[contains(text(),'Create Custom Expense Categories')]",Target.XPATH); 
			public static final Target ExpenseCategory_Name= new Target("ExpenseCategory_Name","//*[@class='mm-c-customexpense__details-category-name form-control form-control' and @name='formFields[0].name']",Target.XPATH); 
			public static final Target ExpenseCategory_NonFood= new Target("ExpenseCategory_NonFood","(//*[@class='mm-c-customexpense__details-category']//*[@class='radio'])[2]/label",Target.XPATH); 
			public static final Target Next= new Target("Next","//UIAStaticText[@label='Next']",Target.XPATH); 
		
			public static final Target ExpenseCategory_NameTxt= new Target("ExpenseCategory_NameTxt","//*[@class='mm-c-customexpense__details-category-name form-control form-control' and @name='formFields[0].name']",Target.XPATH); 
			public static final Target ExpenseCategory_AnotherCategory= new Target("ExpenseCategory_AnotherCategory","//*[@class='mm-c-customexpense__setup-cta']//*[contains(text(),'Add Another Category')]",Target.XPATH);
			public static final Target ExpenseCategory_Name1= new Target("ExpenseCategory_Name1","//*[@class='mm-c-customexpense__details-category-name form-control form-control' and @name='formFields[1].name']",Target.XPATH);
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
		
			public static	String CategoryItemName2_1;
			public static	String CategoryItemName2_2;
			public static	String CategoryItemName2_3;
		
			public static	int CategoryNoOfElements1;
			public static	int CategorysNoOfElements2;
			public static final Target ADD_CategoryName= new Target("ADD_CategoryName","//*[@id='name']",Target.XPATH); 
			public static final Target AddCategory_FoodWeb= new Target("AddCategory_Food","(//*[@class='mm-c-expense__details-radio']//*[@class='radio'])[1]",Target.XPATH); 
			public static final Target AddCategory_Food= new Target("AddCategory_Food","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]",Target.XPATH); 
			public static final Target AddCategory_NonFood= new Target("AddCategory_Food","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]",Target.XPATH); 
		
		
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
			public static	String CategoryItemName1_4;
			public static final Target SetUp_Pg3Header = new Target("SetUp_Pg1Header",
					"//*[@class='navbar-brand']//*[contains(text(),'Setup Inventory')]", Target.XPATH);
			public static final Target CreateExpenseCategoryHeader = new Target("CreateExpenseCategoryHeader",
					"//*[@class='mm-c-customexpense__setup-text']//*[contains(text(),'Create Custom Expense Categories')]",
					Target.XPATH);
			public static final Target CreateExpenseCategoryDesc1 = new Target("CreateExpenseCategoryDesc1",
					"//*[@class='mm-c-customexpense__setup-text']//*[contains(text(),'Create one or more custom expense categories ')]",Target.XPATH);
			public static final Target CreateExpenseCategoryDesc2 = new Target("CreateExpenseCategoryDesc2",
					"//*[@class='mm-c-customexpense__setup-text']//*[contains(text(),'and then select items that belong to each.')]",
					Target.XPATH); 
		

		
			public static String SyscocategoryKeyword1;
			public static String[] SyscoCategory1;
			public static String Selected_SuggCat1;
			public static final Target Select_SuggCat_Dairy = new Target("Select_SuggCat_Dairy","//*[@id='list-item']//*[contains(text(),'Dairy')]",Target.XPATH);
			public static final Target Select_SuggCat_Meat = new Target("Select_SuggCat_Meat","//*[@id='list-item']//*[contains(text(),'Meat')]",Target.XPATH);
		
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
		
			public static final Target SetUp_Pg3Title = new Target("SetUp_Pg3Title","//*[contains(text(),'Set up Food Cost')]",Target.XPATH);  
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
				log("Category page displayed",LogType.STEP);
				
			  	return this;
			}
			
			@SuppressWarnings("rawtypes")
			public CategoryPage CustomCategories(String string)
			{
				  String string2="Issue"; 
		          String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		          try{
		        	 	getCommand().waitForTargetPresent(FoodAndNonFood);
		        	 	getCommand().waitForTargetPresent(SetUp_Pg3Header);
						getCommand().waitForTargetPresent(CustomCategories);
						
						if(getCommand().isTargetPresent(CustomCategories))
						{
							getCommand().click(CustomCategories);
							  
							log("Custom Category selected from Food cost page :Pass",LogType.VERIFICATION_STEP);	
						}
		          }
				catch(Exception e){
					((IOSDriver)getCommand().driver).context("NATIVE_APP");
					getCommand().captureScreenshot(finalPath1); 
					log("Custom category selected from food cost page :Fail",LogType.VERIFICATION_STEP);
					Assert.assertTrue(false);
				}
				return this;
				
			}
			@SuppressWarnings("rawtypes")
			 public CategoryPage tapContinue(String string){
				  String string2="Issue";
			       String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			     	try{
			     	getCommand().waitForTargetPresent(Continue);
					getCommand().click(Continue);
					log("Tapped on Continue :Pass",LogType.VERIFICATION_STEP);
				}
				
				catch(Exception e)
				{((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
					getCommand().captureScreenshot(finalPath1);
					log("Tapped on Continue :Fail",LogType.VERIFICATION_STEP);
					Assert.assertTrue(false);
				}
				return this;
			}
			
			@SuppressWarnings("rawtypes")
			 public CategoryPage CategoryDetails(String Name, String string)
			 {
			 	log("Creating custom category",LogType.STEP);
			 	  String string2="Issue";
			       String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			       String name=Name;
			       try{
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
			 		((IOSDriver)getCommand().driver).context("NATIVE_APP");
			 		getCommand().captureScreenshot(finalPath1); 
			 		log("Custom category created  :Fail",LogType.VERIFICATION_STEP);
			 		Assert.assertTrue(false);
			 	}
			 	return this;
			 	
			 }
			
			@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
			  public CategoryPage TapOnNext(String string){
			       	  String string2="Issue";
			       String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			       	try{
			       		((IOSDriver)getCommand().driver).context("NATIVE_APP");
			       			getCommand().waitForTargetPresent(Next);
			       		if (getCommand().isTargetPresent(Next))
			       		{
			       			getCommand().click(Next);
			       			log("Tapped on Next : Pass",LogType.VERIFICATION_STEP);
			       		}
					Set<String> contextNames =((IOSDriver)getCommand().driver).getContextHandles();
			    	  for (String contextName : contextNames){
			    			System.out.println(contextNames);
			    			}
			    	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
		
			       	}
			       	catch(Exception e)
			       	{ ((IOSDriver)getCommand().driver).context("NATIVE_APP");
			       		log("Tapped on Next :Fail",LogType.VERIFICATION_STEP);
			       		getCommand().captureScreenshot(finalPath1);
			       		Assert.assertTrue(false);
			       	}
			       	return this;
			       }
			@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
			  public CategoryPage SelectItemFromCategory(String name,String string) { 
			    	log("Selecting item to custom category created",LogType.STEP); ;
			    	String string2="Issue";
			    	String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			    	try{ 
			    	getCommand().waitFor(5);
			    	getCommand().waitForTargetPresent(Header);
			    	CategoryName= getCommand().getText(Header);
			    	getCommand().waitFor(5);
			    	if(getCommand().isTargetPresent(Category_FirstItemSelect)) {
			    		getCommand().waitFor(5);
			    		getCommand().click(Category_FirstItemSelect); 
			    		ItemNameSelected=getCommand().getText(Category_FirstItemHeader); 
			    		System.out.println("Item heading:"+ItemNameSelected); 			    		
			    		log("First item selected :Pass",LogType.VERIFICATION_STEP); 
			    		} 
			    	((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			    	 if(getCommand().isTargetPresent(Done)) { 
			    		getCommand().click(Done); 
						Set<String> contextNames =((IOSDriver)getCommand().driver).getContextHandles();
				    	  for (String contextName : contextNames){
				    			System.out.println(contextNames);
				    			}
				    	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
				    	
			    		getCommand().waitForTargetPresent(InvToolsPg);
		
			    		log("First item added to category created :Passed",LogType.VERIFICATION_STEP); 
			    		
			    		}
			    	else { 
			    			if(getCommand().isTargetPresent(Next)) { 
			    			getCommand().click(Next);
			    			log("Second Category Page available :Pass",LogType.VERIFICATION_STEP);
			    			  Set<String> contextNames2 =((IOSDriver)getCommand().driver).getContextHandles();
			    	    	  for (String contextName : contextNames2){
			    	    			System.out.println(contextNames2);
			    	    			}
			    	    	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames2.toArray()[1]));
			    	    	getCommand().waitForTargetPresent(Header).getText(Header).equalsIgnoreCase(name);
			    			getCommand().click(SecondCategory_FirstItemSelect); 
			    			log("First item selected in second category:Pass",LogType.VERIFICATION_STEP); 		    			
			    			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			    				getCommand().click(Done); 
			    			  Set<String> contextNames3 =((IOSDriver)getCommand().driver).getContextHandles();
			    	    	  for (String contextName : contextNames3){
			    	    			System.out.println(contextNames3);
			    	    			}
			    	    	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames3.toArray()[1]));
		
			    				getCommand().waitForTargetPresent(InvToolsPg);
			    			 log("Item added to Second Category :Pass",LogType.VERIFICATION_STEP);	
			    			} 
			    		}
			    	} 
			    	catch(Exception e){ 
			    		((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			    		 getCommand().captureScreenshot(finalPath1); 
			    		log(" Item added to category created :Fail",LogType.VERIFICATION_STEP); 
			    		Assert.assertTrue(false); 
			    		} 
			    	return this; 
			    	
			    }
			@SuppressWarnings("rawtypes")
			  public CategoryPage defaultCategories(String string)
				{
					log("Selecting default category from Food cost page",LogType.STEP);
					  String string2="Issue";
			          String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
					
			          try{
			        	    getCommand().waitForTargetPresent(FoodAndNonFood);
			        	    getCommand().waitForTargetPresent(SetUp_Pg3Header);
							if(getCommand().isTargetPresent(FoodAndNonFood))
							{
								getCommand().click(FoodAndNonFood);
								
								log("default Category selected :Pass",LogType.VERIFICATION_STEP);
								
							}
							
			          }
			          catch(Exception e){
						((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
						getCommand().captureScreenshot(finalPath1); 
						log("default category selected from food cost page :Fail",LogType.VERIFICATION_STEP);
						Assert.assertTrue(false);
					}
					return this;
					
				}
			  @SuppressWarnings("rawtypes")
			public CategoryPage tapComplete(String string){
				  String string2="Issue";
			       String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			     	try{
			     		getCommand().waitForTargetPresent(Complete);
					getCommand().click(Complete);
					
					
					log("Tapped on Complete :Pass",LogType.VERIFICATION_STEP);
				}
				catch(Exception e)
				{
					((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
					getCommand().captureScreenshot(finalPath1);
					log("Tapped on Complete :Fail",LogType.VERIFICATION_STEP);
					Assert.assertTrue(false);
		
				}
				
				return this;
				
			}       
			  @SuppressWarnings("rawtypes")
			public CategoryPage CreateTwoExpenseCategory(String Name1,String Name2,String string) {
			       	log("Creating multiple custom category",LogType.STEP); 
			       	String finalPath1=SitePage.drivePath+string+SitePage.string2+SitePage.pathExtension;
			       	 
			       	try{ 
			       		 
			        		getCommand().waitForTargetPresent(ExpenseCategory_Page);
		
			       	getCommand().waitForTargetPresent(ExpenseCategory_NameTxt);
			       	if(getCommand().isTargetPresent(ExpenseCategory_NameTxt))
			       	{ 
			       		
			       		getCommand().click(ExpenseCategory_NameTxt);
			       		getCommand().sendKeys(ExpenseCategory_NameTxt, Name1); 
			  
			       		getCommand().waitForTargetPresent(ExpenseCategory_Food);
			       		getCommand().click(ExpenseCategory_Food); 

			       		if(getCommand().isTargetPresent(ExpenseCategory_AnotherCategory)) { 
			       			
			       			getCommand().click(ExpenseCategory_AnotherCategory);
			                    }

			       		if(getCommand().isTargetPresent(ExpenseCategory_Name1)) {
			       			getCommand().click(ExpenseCategory_Name1);
			       			getCommand().sendKeys(ExpenseCategory_Name1, Name2); 
			       			
			       			getCommand().waitForTargetPresent(ExpenseCategory_Food1);
		
			       			getCommand().click(ExpenseCategory_Food1);
		
			       			}
			       			
			       		getCommand().waitFor(5);
			       				
			       		
		    		log("Custom Categories created:Pass",LogType.VERIFICATION_STEP); 
			       		} 
			       
			   }
			       catch(Exception e){
			    	   ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			      	 getCommand().captureScreenshot(finalPath1); 
			       	log("Custom Categories created:Fail",LogType.VERIFICATION_STEP);
			       	Assert.assertTrue(false); 
			       	} 
			       return this;
			       	}  
		
			  @SuppressWarnings("rawtypes")
			public CategoryPage CustomCategory_ItemSelectAndCheck(String string)
			   	{
			   		log("Verifying added item is in  custom category - Uncategorised and All Items",LogType.STEP);

			   		  String string2="Issue";
			   		  String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			            
			   			
			             try{
			   			
			           	  
			           	  getCommand().waitForTargetPresent(Category_Header);
			            	 
			             	CategoryName= getCommand().getText(Category_Header);

			             	
			             		    	getCommand().waitFor(5);
			             	if(getCommand().isTargetPresent(Category_FirstItemSelect)) {
			             		getCommand().waitFor(5);
			             		getCommand().click(Category_FirstItemSelect); 
			             		ItemAdded=getCommand().getText(Category_FirstItemHeader); 
			             		log("First item selected",LogType.VERIFICATION_STEP); 
			             		} 
			             	
			   		       getCommand().waitFor(5);	
			   		       getCommand().waitForTargetPresent(SetupInventoryCustomCategoryAllItemsTab);
			   		       getCommand().click(SetupInventoryCustomCategoryAllItemsTab);
			   		       getCommand().waitFor(3);
			   		       final Target  FirstItemSelectedFromUncatgorisedVerify= new Target("FirstItemSelectedFromUncatgorised","//*[@id='mount']//*[contains(text(),'"+ItemAdded+"')]",Target.XPATH);
			   		       if (getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify)) {
			   				log(" Added item  is present in All Items Tab  :Pass",LogType.VERIFICATION_STEP);
			   				
			   			}
			   		       getCommand().waitFor(5);	
			   		       getCommand().waitForTargetPresent(SetupInventoryCustomCategoryUncategorizedTab);
			   		       getCommand().click(SetupInventoryCustomCategoryUncategorizedTab);
			   		     
			   		      		       
			   		       if (getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify)) {
			   					log(" Added item  is present in category Tab(Expected-Item should not be present) :Fail",LogType.VERIFICATION_STEP);
			   					throw new Exception();
			   				}
			   		       else if (!(getCommand().isTargetPresent(FirstItemSelectedFromUncatgorisedVerify))) {
			   					log(" Added item  is not present in uncategorized Tab :Pass",LogType.VERIFICATION_STEP);
			   			}
			   		       
			   		       getCommand().waitFor(5);	
			   		       
			   		   	}
			   		
			   	
			   		catch(Exception e){
			   			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			   		getCommand().captureScreenshot(finalPath1); 
			   			log("Added item  is present in category created :Fail",LogType.VERIFICATION_STEP);
			   			Assert.assertTrue(false);
			   		}
			   		return this;
			   		
			   	}	
			  @SuppressWarnings("rawtypes")
			public CategoryPage selectMultipleItemsFromCategory1(String string) {
			   	   	  String string2="Issue";
			   	     String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			   	      try{

			 	      	getCommand().waitForTargetPresent(Category_1stItemSelect);
			 	    	getCommand().waitForTargetPresent(Category_2ndItemSelect);
			 	    	getCommand().waitForTargetPresent(Category_3rdItemSelect);
				 	     
			   	   		if(getCommand().isTargetPresent(Category_1stItemSelect))
			   	   		{
			   	   		CategoryNoOfElements1++;
			   	   	CategoryItemName1_1=getCommand().getText(Category_1stItemHeading);
			   	   			getCommand().click(Category_1stItemSelect);
			   	   			
			   	   		}
			   	   		if(getCommand().isTargetPresent(Category_2ndItemSelect)){
			   	   			
			   	   		CategoryNoOfElements1++;
			   	   	CategoryItemName1_2=getCommand().getText(Category_2ndItemHeading);
			   	   			getCommand().click(Category_2ndItemSelect);
			   	   		}
			   	   			
			   	   		if(getCommand().isTargetPresent(Category_3rdItemSelect)){	
			   	   		CategoryNoOfElements1++;
			   	   	CategoryItemName1_3=getCommand().getText(Category_3rdItemHeading);
			   	   			getCommand().click(Category_3rdItemSelect);
			   	   		}
			   	   			log("Multiple items selected :Pass",LogType.VERIFICATION_STEP); 			
			   	   		}
			   	   	
			   	   	catch(Exception e){
			   	   	((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			   	   	getCommand().captureScreenshot(finalPath1); 
			   	   		log("Multiple items selected :Fail",LogType.VERIFICATION_STEP);
			   	   		Assert.assertTrue(false);
			   	   	}
			   	      return this;
			   	   }
			        @SuppressWarnings("rawtypes")
					public CategoryPage selectMultipleItemsFromCategory2(String string) {
			      	   	  String string2="Issue";
			      	     String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			      	      try{
		
			    	      	getCommand().waitForTargetPresent(Category_1stItemSelect);
			    	      	getCommand().waitForTargetPresent(Category_2ndItemSelect);
			    	      	getCommand().waitForTargetPresent(Category_3rdItemSelect);
			    	      	
			      	   		if(getCommand().isTargetPresent(Category_1stItemSelect))
			      	   		{
			      	   		CategoryNoOfElements1++;
			      	   	CategoryItemName2_1=getCommand().getText(Category_1stItemHeading);
			      	   			getCommand().click(Category_1stItemSelect);
			      	   			
			      	   		}
			      	   		if(getCommand().isTargetPresent(Category_2ndItemSelect)){
			      	   			
			      	   		CategoryNoOfElements1++;
			      	   	CategoryItemName2_2=getCommand().getText(Category_2ndItemHeading);
			      	   			getCommand().click(Category_2ndItemSelect);
			      	   		}
			      	   			
			      	   		if(getCommand().isTargetPresent(Category_3rdItemSelect)){	
			      	   		CategoryNoOfElements1++;
			      	   	CategoryItemName2_3=getCommand().getText(Category_3rdItemHeading);
			      	   			getCommand().click(Category_3rdItemSelect);
			      	   		}
			      	   			log("Multiple items selected :Pass",LogType.VERIFICATION_STEP); 			
			      	   		}
			      	   	
			      	   	catch(Exception e){
			      	   	((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		      	   	getCommand().captureScreenshot(finalPath1); 
			      	   		log("Multiple items selected :Fail",LogType.VERIFICATION_STEP);
		      	   		Assert.assertTrue(false);
			      	   	}
			      	      return this;
			      	   }

		@SuppressWarnings("rawtypes")
		public CategoryPage AddCategoryName(String categoryName,String string)
		   	{
		   		String string2="Issue";   
		   		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;	
		   		
		   		try{
		   				getCommand().clear(ADD_CategoryName);
		   			getCommand().click(ADD_CategoryName);
		   			getCommand().sendKeys(ADD_CategoryName,categoryName);
		   		 		log("added category name :Pass",LogType.VERIFICATION_STEP);
		   			}
		   			
		   	
		   		
		   		catch(Exception e)
		   		{
		   			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		   			getCommand().captureScreenshot(finalPath1);
		   			log("added category name :Fail",LogType.VERIFICATION_STEP);
		   			Assert.assertTrue(false);
		   		}
		   		
		   		return this;
		   		
		   	}
		   @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
		public CategoryPage AddCategoryFood(String string)
		   	{
		   		String string2="Issue";   
		   		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;	
		   		
		   		try{
		  			((IOSDriver)getCommand().driver).context("NATIVE_APP");
		
		   			getCommand().waitForTargetPresent(AddCategory_Food);
		   		    getCommand().click(AddCategory_Food);
		   			 Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
					
				 for (String contextName : contextNames){
					 System.out.println(contextNames);
				 }
		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
		   			 		log("Selected food :Pass",LogType.VERIFICATION_STEP);
		   			}
		   			
		   	
		   		
		   		catch(Exception e)
		   		{
		   			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		   			getCommand().captureScreenshot(finalPath1);
		   			log("Selected food :Fail",LogType.VERIFICATION_STEP);
		   			Assert.assertTrue(false);
		   		}
		   		
		   		return this;
		   		
		   	}
		
		
		@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
		public CategoryPage TapOnDone(String string){
		    	String string1="Success";
		    	  String string2="Issue";
		
		    String finalPath=SitePage.drivePath+string+string1+SitePage.pathExtension;
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		
		    	try{
		    		
		    		
		    		((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		    			getCommand().waitForTargetPresent(Done);
		    		if (getCommand().isTargetPresent(Done))
		    		{
		    			
		    			getCommand().click(Done);
		    			log("Tapped on done:Pass",LogType.VERIFICATION_STEP);
		    			Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
		         		System.out.println("contxtname is "+contextNames1);
		         		
		         		 for (String contextName : contextNames1){
		         			 System.out.println("inside loop "+contextNames1);
		         		 }
		         	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
		         
		    					
		    		}
		    		
		    	}
		    	catch(Exception e)
		    	{((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		    		log("Tapped on done :Fail",LogType.VERIFICATION_STEP);
		    		getCommand().captureScreenshot(finalPath1);
		    		Assert.assertTrue(false);
		    	}
		    	
		    	return this;
		    }
		
		
		@SuppressWarnings("rawtypes")
		public CategoryPage SelectCategory(String name,String string)
		{
		    String finalPath1=SitePage.drivePath+string+SitePage.string2+SitePage.pathExtension;
		    
			log("Selecting Category",LogType.STEP);
		try{
			
		 getCommand().waitFor(2);
			final Target  Locname= new Target("Locname","//*[@id='list-item']//*[contains(text(),'"+name+"')]",Target.XPATH);   
			  getCommand().click(Locname); 
		      
			 	log("Category is selected for item :Pass",LogType.VERIFICATION_STEP);						
			}
			
			
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				 getCommand().captureScreenshot(finalPath1); 
				log("Category is selected for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		
		
		@SuppressWarnings("rawtypes")
		public CategoryPage TapOnBack(String string){
			String finalPath1=SitePage.drivePath+string+SitePage.string2+SitePage.pathExtension;
		
				try{
					
					getCommand().waitForTargetPresent(Back);
					if (getCommand().isTargetPresent(Back))
					{
						
						getCommand().click(Back);
						log("tap on back :Pass",LogType.VERIFICATION_STEP);
					}
					
				}
				catch(Exception e)
				{
					((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
					log("tap on back :Fail",LogType.VERIFICATION_STEP);
					getCommand().captureScreenshot(finalPath1);
					Assert.assertTrue(false);
				}
				
				return this;
			}
		
		
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyCategory(String name,String string)
		{
			String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    
			log("Selected Category is there",LogType.STEP);
		try{
			
			
		 getCommand().waitFor(2);
			final Target  Locname= new Target("Locname","//*[@class='mm-c-product-list__details']//*[contains(text(),'"+name+"')]",Target.XPATH);    
			getCommand().waitForTargetPresent(Locname);
				log("Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
			}
			
				catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				 getCommand().captureScreenshot(finalPath1); 
				log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}

		@SuppressWarnings("rawtypes")
		public CategoryPage TapAdd(String string)
		{
		String string2="Issue";   
		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;	
		
		try{
		getCommand().waitForTargetPresent(AddWeb);
		if(getCommand().isTargetPresent(AddWeb))
		{
			getCommand().click(AddWeb);
			log("Navigating to Add categories page :Pass",LogType.VERIFICATION_STEP);	
		
		}

		}
		catch(Exception e)
		{
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
		log("Navigating to Add categories page :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
		}
		
		return this;
		
		}
		
		@SuppressWarnings("rawtypes")
		public  CategoryPage VerifyCategoryList(String categoryAdded,String string){
		String string2="Issue";
		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		log("Checking addeded Location in location list",LogType.STEP);
		try{	
		
		final Target  CatAdded= new Target("CatAdded","//*[@id='list-item']//span[contains(text(),'"+categoryAdded+"')]",Target.XPATH);   
		
		getCommand().waitForTargetPresent(CatAdded);
		if (getCommand().isTargetPresent(CatAdded)) {
			log("Added Category is listed :Pass",LogType.VERIFICATION_STEP);
		}
		
		}
		catch(Exception e)
		{
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
		log("Added Category is listed   :Fail",LogType.VERIFICATION_STEP);	
		Assert.assertTrue(false);
		}
		
		return this;
		
		
		}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage TapOnEdit(String string){
		String string2="Issue";
		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		
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
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			log("tap on edit :Fail",LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}
		
		return this;
		}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage TapOnDeleteCategory(String string){
		String string2="Issue";

		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		
		try{
			
			
			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(Delete);
			if (getCommand().isTargetPresent(Delete))
			{
				
				getCommand().click(Delete);
				log("tap on Delete :Pass",LogType.VERIFICATION_STEP);
			}
			
		}
		catch(Exception e)
		{
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			log("tap on delete:Fail",LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}
		
		return this;
		}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage TapOnYesDelete(String string){
			  String string2="Issue";
		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		log("Deleted",LogType.STEP);
			try{
				
				getCommand().waitFor(5);
				getCommand().waitForTargetPresent(YesDelete);
				if (getCommand().isTargetPresent(YesDelete))
				{
					
					getCommand().click(YesDelete);
					log("tap on yes delete :Pass",LogType.VERIFICATION_STEP);
				}
				
			}
			catch(Exception e)
			{
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				log("tap on yes delete :Fail",LogType.VERIFICATION_STEP);
				getCommand().captureScreenshot(finalPath1);
				Assert.assertTrue(false);
			}
			
			return this;
		}
		@SuppressWarnings("rawtypes")
		public  CategoryPage VerifyDeletedCategoryList(String categoryAdded,String string){
		String string2="Issue";
		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		
		try{	
		
			getCommand().waitFor(5);
		final Target  CatAdded= new Target("LocAdded","//*[@id='list-item']//span[contains(text(),'"+categoryAdded+"')]",Target.XPATH);   
		
		if (getCommand().isTargetPresent(CatAdded)) {
			log("Deleted category is there :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		log("Deleted category is not listed   :Pass",LogType.VERIFICATION_STEP);
		}
		catch(Exception e)
		{	((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
		log("Deleted category is  listed   :Fail",LogType.VERIFICATION_STEP);	
		Assert.assertTrue(false);
		}
		
		return this;
		
		
		}  	
		
		
		@SuppressWarnings("rawtypes")
		public CategoryPage AssignMultipleItemsToCategory(String string) {
		 String string2="Issue";
		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		try{
		
			getCommand().waitFor(5);
		getCommand().waitForTargetPresent(Category_1stItemSelect);
		getCommand().waitForTargetPresent(Category_2ndItemSelect);
		getCommand().waitForTargetPresent(Category_NonSyscoItem1Select);
		getCommand().waitForTargetPresent(Category_NonSyscoItem2Select);
		
			if(getCommand().isTargetPresent(Category_1stItemSelect))
			{
			CategoryNoOfElements1++;
			CategoryItemName1_1=getCommand().getText(Category_1stItemHeading);
				getCommand().click(Category_1stItemSelect);
				
			}
			if(getCommand().isTargetPresent(Category_2ndItemSelect)){
				
			CategoryNoOfElements1++;
		CategoryItemName1_2=getCommand().getText(Category_2ndItemHeading);
				getCommand().click(Category_2ndItemSelect);
			}
				
			if(getCommand().isTargetPresent(Category_NonSyscoItem1Select)){	
			CategoryNoOfElements1++;
		CategoryItemName1_3=getCommand().getText(Category_3rdItemHeading);
				getCommand().click(Category_NonSyscoItem1Select);
			}
				
			if(getCommand().isTargetPresent(Category_NonSyscoItem2Select)){	
				CategoryNoOfElements1++;
			CategoryItemName1_4=getCommand().getText(Category_4thItemHeading);
					getCommand().click(Category_NonSyscoItem2Select);
				}	
				log("Multiple items selected :Pass",LogType.VERIFICATION_STEP); 			
			}
		
		catch(Exception e){
			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1); 
			log("Multiple items selected :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		}

		@SuppressWarnings("rawtypes")
		public CategoryPage SuggestedCategories(String string)
		{
			log("Selecting suggested category from Food cost page",LogType.STEP);

			  String string2="Issue";
		      String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
			
		      try{
		    	 
		    		 getCommand().waitForTargetPresent(FoodAndNonFood);
		    		 getCommand().waitForTargetPresent(SetUp_Pg3Header);
					getCommand().waitForTargetPresent(SuggestedCategories);
					
					if(getCommand().isTargetPresent(SuggestedCategories))
					{
						getCommand().click(SuggestedCategories);
						 
						log("Suggested Category selected :Pass",LogType.VERIFICATION_STEP);
						
					}
					
		      }
			
		
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				getCommand().captureScreenshot(finalPath1); 
				log("Suggested category selected from food cost page :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyMultipleListSyscoSuggestedCategory(String string)
		{
			
			 Boolean flag1=false;
			 Boolean flag2=false;
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    
			
		try{
			
			
		 getCommand().waitFor(2);
		 if((LocationsPage.Category1[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category1[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category1[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category1[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category1[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category1[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category1[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category1[0].equalsIgnoreCase("Miscellaneous"))){
			  flag1=true;
			  
		 }
		 if((LocationsPage.Category2[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category2[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category2[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category2[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category2[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category2[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category2[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category2[0].equalsIgnoreCase("Miscellaneous"))){
			  flag2=true;
			  
		}
		 if(!(flag2&&flag1)){ 
			   throw new Exception();
		 } 
		   
			  
				log("Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
			}
			
			
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				 getCommand().captureScreenshot(finalPath1); 
				log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		
	
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyPrepCustomCategory(String customcategory,String string)
		{
			
			 Boolean flag4=false;
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    
			log("Category verification for nonsysco",LogType.STEP);
		try{
			
			
		 getCommand().waitFor(2);
		 if((LocationsPage.Prep_Category1[0].equalsIgnoreCase(customcategory))){
			  flag4=true;
			  
		 }
		 if(!(flag4)){ 
			   throw new Exception();
		 } 
		   
			
				log("Category is verified for prep item :Pass",LogType.VERIFICATION_STEP);						
			}
			
			
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				 getCommand().captureScreenshot(finalPath1); 
				log("Category is verified for prep item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyOGSyscoItemsSuggestedCategoryLocation1(String string)
		{
			Boolean flag3=false;
			 Boolean flag1=false;
			 Boolean flag2=false;
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;	
		try{
		 getCommand().waitFor(2);
			
		 if((LocationsPage.Category3[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category3[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category3[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category3[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category3[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category3[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category3[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category3[0].equalsIgnoreCase("Miscellaneous"))){
			  flag1=true;
			  
		 }
		 if((LocationsPage.Category4[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category4[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category4[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category4[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category4[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category4[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category4[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category4[0].equalsIgnoreCase("Miscellaneous"))){
			  flag2=true;
			  
		}
		 if((LocationsPage.Category5[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category5[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category5[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category5[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category5[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category5[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category4[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category5[0].equalsIgnoreCase("Miscellaneous"))){
			  flag3=true;
			  
		}

		 if(!(flag2&&flag1&&flag3)){ 
			   throw new Exception();
		 } 
				log("Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
			}

			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP");
				 getCommand().captureScreenshot(finalPath1); 
				log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}

		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyOGSyscoItemsSuggestedCategoryLocation2(String string)
		{
			Boolean flag3=false;
			 Boolean flag1=false;
			 Boolean flag2=false;
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    
			log("Ctegory verification",LogType.STEP);
		try{
			
			
		 getCommand().waitFor(2);
		 if((LocationsPage.Category6[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category6[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category6[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category6[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category6[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category6[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category6[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category6[0].equalsIgnoreCase("Miscellaneous"))){
			  flag1=true;
			  
		 }
		 if((LocationsPage.Category7[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category7[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category7[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category7[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category7[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category7[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category7[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category7[0].equalsIgnoreCase("Miscellaneous"))){
			  flag2=true;
			  
		}
		 if((LocationsPage.Category8[0].equalsIgnoreCase("Meat"))||(LocationsPage.Category8[0].equalsIgnoreCase("Groceries"))||(LocationsPage.Category8[0].equalsIgnoreCase("Dairy"))||(LocationsPage.Category8[0].equalsIgnoreCase("Poultry"))||(LocationsPage.Category8[0].equalsIgnoreCase("Seafood"))||(LocationsPage.Category8[0].equalsIgnoreCase("Produce"))||(LocationsPage.Category8[0].equalsIgnoreCase("Beverage"))||(LocationsPage.Category8[0].equalsIgnoreCase("Miscellaneous"))){
			  flag3=true;
			  
		}
		 if(!(flag2&&flag1&&flag3)){ 
			   throw new Exception();
		 } 
		   
		 
		
				log("Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
			}
			
			
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP");
				 getCommand().captureScreenshot(finalPath1); 
				log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyNonSycoCustomCategory(String customcategory,String string)
		{
			
			 Boolean flag3=false;
			  String string2="Issue";
		  String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		  
			log("Category verification for nonsysco",LogType.STEP);
		try{
			
		
		getCommand().waitFor(2);
		if((LocationsPage.NonSysco_Category1[0].equalsIgnoreCase(customcategory))){
			  flag3=true;
			  
		}
		if(!(flag3)){ 
			   throw new Exception();
		} 
		 
			
				log("Category is verified for nonsysco item :Pass",LogType.VERIFICATION_STEP);						
			}
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP");
				 getCommand().captureScreenshot(finalPath1); 
				log("Category is verified for nonsyco item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifySuggestedCategory(String string)
		{
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    
			
		try{
			
		  final Target Sysco_Product_Select= new Target("Product_Select","(//*[@class='mm-c-product-list']//*[@class='mm-c-product-list__item mm-c-product__sysco ']//*[@class='mm-c-product-list__image'])[1]",Target.XPATH); 
				if(getCommand().isTargetPresent(Sysco_Product_Select)){
					final Target CategoryLine1= new Target("CategoryLine1","(//*[@class='mm-c-product-list']//*[@class='mm-c-product-list__all-prods']//*[@class='mm-c-product-list__details-wrapper']//*[@class='mm-c-product-list__location'])[1]",Target.XPATH); 
					String SyscocategoryKeyword1 = getCommand().getText(CategoryLine1);
						SyscoCategory1=SyscocategoryKeyword1.split("\\s+");

		
					
				}
			   
				log("Suggested Category is verified for item :Pass",LogType.VERIFICATION_STEP);						
			}
			
			
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				 getCommand().captureScreenshot(finalPath1); 
				log("Suggested Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		@SuppressWarnings("rawtypes")
		public CategoryPage TapAnySuggestedCategory(String string)
		{
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    
		
		try{

			if(SyscoCategory1[0].equalsIgnoreCase("Dairy"))
				{getCommand().waitForTargetPresent(Select_SuggCat_Meat).click(Select_SuggCat_Meat);
				Selected_SuggCat1="Meat";
				}
			else
				{getCommand().waitForTargetPresent(Select_SuggCat_Dairy).click(Select_SuggCat_Dairy);
				Selected_SuggCat1="Dairy";
				}
				log("Suggested Category is selected for item :Pass",LogType.VERIFICATION_STEP);						
			}
			
			
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				 getCommand().captureScreenshot(finalPath1); 
				log("Suggested Category is selected for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifySelectedSuggestedCategory(String string)
		{
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    try{
			if(SyscoCategory1[0].equalsIgnoreCase(Selected_SuggCat1))
				 throw new Exception();
			else
				log("Suggested Category is changed for item :Pass",LogType.VERIFICATION_STEP);	
			
			
			}
			
			
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
				 getCommand().captureScreenshot(finalPath1); 
				log("Suggested Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifySuggestedCategoryList(String string)
		{
			  String string2="Issue";
		  String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		  
			
		try{
			boolean flag2_1 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Dairy, 3);
			boolean flag2_2 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Meat, 3);
			boolean flag2_3 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Poultry, 3);
			boolean flag2_4 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Seafood, 3);
			boolean flag2_5 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Produce, 3);
			boolean flag2_6 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Groceries, 3);
			boolean flag2_7 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Beverage, 3);
			boolean flag2_8 = getCommand().isTargetPresentAfterWait(SuggestedCategory_Miscellaneous, 3);
			if((flag2_1 && flag2_2 && flag2_3 && flag2_4 && flag2_5 && flag2_6 && flag2_7 && flag2_8)){ 
				log("Suggested category list verification done :Pass",LogType.VERIFICATION_STEP);
			}    			     
			
			else {
				throw new Exception();
				}
				}
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
		     	log("Suggested categories are listed  :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyCustomListItemsDefaultCategoryLocation1(String string)
		{
			Boolean flag3=false;
			 Boolean flag1=false;
			 Boolean flag2=false;
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    
		
		try{
			
		 getCommand().waitFor(2);
			
		 if((LocationsPage.Category3[0].equalsIgnoreCase("Food"))||(LocationsPage.Category3[0].equalsIgnoreCase("Non-Food"))){
			  flag1=true;
			  
		 }
		 if((LocationsPage.Category4[0].equalsIgnoreCase("Food"))||(LocationsPage.Category4[0].equalsIgnoreCase("Non-Food"))){
			  flag2=true;
			  
		}
		 if((LocationsPage.Category5[0].equalsIgnoreCase("Food"))||(LocationsPage.Category5[0].equalsIgnoreCase("Non-Food"))){
			  flag3=true;
			  
		}

		 if(!(flag2&&flag1&&flag3)){ 
			   throw new Exception();
		 } 
		   
		 
		 
				log("Default Category is verified for items :Pass",LogType.VERIFICATION_STEP);						
			}
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
				log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyCustomListItemsDefaultCategoryLocation2(String string)
		{
			Boolean flag3=false;
			 Boolean flag1=false;
			 Boolean flag2=false;
			  String string2="Issue";
		    String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		    
			log("Default Category verification",LogType.STEP);
		try{
			
		 getCommand().waitFor(2);

		 if((LocationsPage.Category6[0].equalsIgnoreCase("Food"))||(LocationsPage.Category6[0].equalsIgnoreCase("Non-Food"))){
			  flag1=true;
			  
		 }
		 if((LocationsPage.Category7[0].equalsIgnoreCase("Food"))||(LocationsPage.Category7[0].equalsIgnoreCase("Non-Food"))){
			  flag2=true;
			  
		}
		 if((LocationsPage.Category8[0].equalsIgnoreCase("Food"))||(LocationsPage.Category8[0].equalsIgnoreCase("Non-Food"))){
			  flag3=true;
			  
		}
		 if(!(flag2&&flag1&&flag3)){ 
			   throw new Exception();
		 } 
		   
		 
				log("Default Category is verified for items :Pass",LogType.VERIFICATION_STEP);						
			}
			
			
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
				log("Category is verified for item   :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyDefaultCategoryList(String string)
		{
			  String string2="Issue";
		  String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		  
		
		try{
			
			
		
			boolean flag2_1 = getCommand().isTargetPresentAfterWait(DefaultCategory_Food, 3);
			boolean flag2_2 = getCommand().isTargetPresentAfterWait(DefaultCategory_NonFood, 3);
			if((flag2_1 && flag2_2)){ 
				log("Default category list verification done :Pass",LogType.VERIFICATION_STEP);
			}    			     
			
			else {
				throw new Exception();
				}
			
				}
			
			catch(Exception e){
				((IOSDriver)getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
		     	log("Default categories are listed  :Fail",LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
			
		}
		
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyItemPresentUncategorizedAndAllItems(String string)
		{
		  String string2="Issue";
		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		
			
		try{
		getCommand().waitFor(5);	
		getCommand().waitForTargetPresent(SetupInventoryCustomCategoryAllItemsTab);
		getCommand().click(SetupInventoryCustomCategoryAllItemsTab);
		getCommand().waitFor(3);
		final Target  ItemSelectedFromUncatgorisedVerify= new Target("FirstItemSelectedFromUncatgorised","//*[@id='mount']//*[contains(text(),'"+CategoryItemName1_1+"')]",Target.XPATH);
		final Target  ItemSelectedFromUncatgorisedVerify1= new Target("FirstItemSelectedFromUncatgorised","//*[@id='mount']//*[contains(text(),'"+CategoryItemName1_2+"')]",Target.XPATH);
		final Target  ItemSelectedFromUncatgorisedVerify2= new Target("FirstItemSelectedFromUncatgorised","//*[@id='mount']//*[contains(text(),'"+CategoryItemName1_3+"')]",Target.XPATH);
		final Target  ItemSelectedFromUncatgorisedVerify3= new Target("FirstItemSelectedFromUncatgorised","//*[@id='mount']//*[contains(text(),'"+CategoryItemName1_4+"')]",Target.XPATH);
		
		if (getCommand().isTargetPresent(ItemSelectedFromUncatgorisedVerify)) {
			getCommand().waitForTargetPresent(ItemSelectedFromUncatgorisedVerify1);
			getCommand().waitForTargetPresent(ItemSelectedFromUncatgorisedVerify2);
			getCommand().waitForTargetPresent(ItemSelectedFromUncatgorisedVerify3);
		log(" Added item  is present in All Items Tab  :Pass",LogType.VERIFICATION_STEP);
		
		}
		getCommand().waitFor(5);	
		getCommand().waitForTargetPresent(SetupInventoryCustomCategoryUncategorizedTab);
		getCommand().click(SetupInventoryCustomCategoryUncategorizedTab);
		
				       
		if (getCommand().isTargetPresent(ItemSelectedFromUncatgorisedVerify)) {
			getCommand().waitForTargetPresent(ItemSelectedFromUncatgorisedVerify1);
			getCommand().waitForTargetPresent(ItemSelectedFromUncatgorisedVerify2);
			getCommand().waitForTargetPresent(ItemSelectedFromUncatgorisedVerify3);
			log(" Added item  is present in category Tab(Expected-Item should not be present) :Fail",LogType.VERIFICATION_STEP);
			throw new Exception();
		}
		else if ( !(  (getCommand().isTargetPresent(ItemSelectedFromUncatgorisedVerify))&& (getCommand().isTargetPresent(ItemSelectedFromUncatgorisedVerify1))&&
				( getCommand().isTargetPresent(ItemSelectedFromUncatgorisedVerify2))&&(getCommand().isTargetPresent(ItemSelectedFromUncatgorisedVerify3) )))  {
			log(" Added item  is not present in uncategorized Tab :Pass",LogType.VERIFICATION_STEP);
		}
		
		getCommand().waitFor(5);	
		
		
		
		log("Category is verified for nonsysco item :Pass",LogType.VERIFICATION_STEP);						
		
		}

		catch(Exception e){
		((IOSDriver)getCommand().driver).context("NATIVE_APP");
		 getCommand().captureScreenshot(finalPath1); 
		log("Added item  is present in category Tab(Expected-Item should not be present)    :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
		}
		return this;
		
		}

		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyOptionsOnSetUpFoodCost(String string){
		String string2="Issue";	
		String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;
		try{
		getCommand().waitForTargetPresent(SetUp_Pg3Title);
			if(getCommand().isTargetPresent(FoodAndNonFood) && getCommand().isTargetPresent(FoodAndNonFoodDesc) && getCommand().isTargetPresent(SuggestedCategories) && getCommand().isTargetPresent(SuggestedCategoriesDesc) && getCommand().isTargetPresent(CustomCategories) && getCommand().isTargetPresent(CustomCategoriesDesc))
			{
				log("VerifyOptionsOnSetUpFoodCost:Pass",LogType.STEP);
			}
			else
			{
				log("VerifyOptionsOnSetUpFoodCost:Fail",LogType.STEP);
				throw new Exception();
			}
			
		
		log("Category page verification done :Pass",LogType.VERIFICATION_STEP);
		}
		catch(Exception e){
		((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		getCommand().captureScreenshot(finalPath1);
		log("Category page verification done  :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
		}
		
		return this;
		
		}
		@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
		public CategoryPage AddCategoryNonFood(String string)
			{
				String string2="Issue";   
				String finalPath1=SitePage.drivePath+string+string2+SitePage.pathExtension;	
				
				try{
					
						((IOSDriver)getCommand().driver).context("NATIVE_APP");
		
							getCommand().waitForTargetPresent(AddCategory_NonFood);
				    getCommand().click(AddCategory_NonFood);
					 Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
				
			 for (String contextName : contextNames){
				 System.out.println(contextNames);
			 }
		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
					 		log("Selected Non Food :Pass",LogType.VERIFICATION_STEP);
					}
				catch(Exception e)
				{
					((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
					getCommand().captureScreenshot(finalPath1);
					log("Selected Non Food :Fail",LogType.VERIFICATION_STEP);
					Assert.assertTrue(false);
				}
				return this;
			}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyCustomListItemsCustomCategoryLocation1(String category, String string) {
			Boolean flag3 = false;
			Boolean flag1 = false;
			Boolean flag2 = false;
			String string2 = "Issue";
			String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;
		
			log("Custom Category verification on location1", LogType.STEP);
			try {
		
				getCommand().waitFor(2);
				if ((LocationsPage.Category3[0].equalsIgnoreCase(category))) {
					flag1 = true;
		
				}
				if ((LocationsPage.Category4[0].equalsIgnoreCase(category))) {
					flag2 = true;
		
				}
				if ((LocationsPage.Category5[0].equalsIgnoreCase(category))) {
					flag3 = true;
		
				}
		
				if (!(flag2 && flag1 && flag3)) {
					throw new Exception();
				}
		
				log("Custom Category is verified for items in location1 :Pass", LogType.VERIFICATION_STEP);
			}
		
			catch (Exception e) {
				((AndroidDriver) getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
		
				log("Custom Category is verified for item in location1  :Fail", LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
		
		}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyCustomListItemsCustomCategoryLocation2(String category, String string) {
			Boolean flag3 = false;
			Boolean flag1 = false;
			Boolean flag2 = false;
			String string2 = "Issue";
			String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;
		
			log("Custom Category verification on location2", LogType.STEP);
			try {
		
				getCommand().waitFor(2);
		
				if ((LocationsPage.Category6[0].equalsIgnoreCase(category))) {
					flag1 = true;
		
				}
				if ((LocationsPage.Category7[0].equalsIgnoreCase(category))) {
					flag2 = true;
		
				}
				if ((LocationsPage.Category8[0].equalsIgnoreCase(category))) {
					flag3 = true;
		
				}
				if (!(flag2 && flag1 && flag3)) {
					throw new Exception();
				}
		
				log("Custom Category is verified for items in location2 :Pass", LogType.VERIFICATION_STEP);
			}
		
			catch (Exception e) {
				((AndroidDriver) getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
		
				log("Custom Category is verified for item in location2  :Fail", LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
			return this;
		
		}
		
		@SuppressWarnings("rawtypes")
		public CategoryPage VerifyOptionsOnCreateExpenseCategory(String string) {

			String string2 = "Issue";
			String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

			log("Category page verify ", LogType.STEP);
			try {

				getCommand().waitForTargetPresent(CreateExpenseCategoryHeader);
				if (getCommand().isTargetPresent(CreateExpenseCategoryHeader) && getCommand().isTargetPresent(SetUp_Pg3Header)
						&& getCommand().isTargetPresent(CreateExpenseCategoryDesc1)
						&& getCommand().isTargetPresent(CreateExpenseCategoryDesc2)) {
					
					log("Verify Options On Create custom category page:Pass", LogType.STEP);

				} else {

					log("Verify Options On Create custom category page:Fail", LogType.STEP);
					throw new Exception();
				}
				log("Create custom Category page verification done :Pass", LogType.VERIFICATION_STEP);
			} catch (Exception e) {
				((AndroidDriver) getCommand().driver).context("NATIVE_APP");
				getCommand().captureScreenshot(finalPath1);
				log("Create custom Category page verification done  :Fail", LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}

			return this;

		}


		}
