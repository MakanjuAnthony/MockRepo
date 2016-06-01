package com.components.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.Set;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class LocationsPage extends SitePage{

	String drivePath="/Users/sujina_s/Desktop/Sysco/iOSScreenshot/";
	String pathExtension=".png";

	
	public static final Target NewLocation = new Target("LocationName","//*[@class='mm-c-customlocation__setup-form']//*[@name='formFields[0].name']",Target.XPATH);
	public static final Target LocationCooler= new Target("LocationCooler","(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[1]",Target.XPATH);
	public static final Target Next= new Target("Next","//UIAStaticText[@label='Next']",Target.XPATH); 
	//*[@id='next-nav']/a
	public static final Target SetUp_Pg2Title = new Target("SetUp_Pg2Title","//*[@class='mm-c-inventory-setup']//*[contains(text(),'Setup Locations')]",Target.XPATH);
    public static final Target DefaultLocation = new Target("DefaultLocation","//*[@class='btn btn-sm btn-primary' and contains(text(),'Default')]",Target.XPATH);
    public static final Target CustomLocations = new Target("CustomLocations","//*[@class='btn btn-sm btn-primary' and contains(text(),'Custom Locations')]",Target.XPATH);
    public static final Target Continue = new Target("Continue","//*[@class='btn btn-default' and contains(text(),'Continue')]",Target.XPATH);
   // public static final Target Done= new Target("Done","//*[@id='done-nav']/a",Target.XPATH);
    public static final Target Done= new Target("DoneWeb","//UIAStaticText[@label='Done']",Target.XPATH); 
	
    public static final Target Location_FirstItemSelect= new Target("LocationName","(//*[@class='mm-c-product-list__details-wrapper'])[1]/h4",Target.XPATH);
    public static final Target Location_FirstItem= new Target("LocationName","(//*[@class='checkbox']//*[@class='mm-o-icon'])[1]",Target.XPATH);
    public static final Target LocationsPage_Header= new Target("LocationName","//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3",Target.XPATH);

    //public static final Target Header= new Target("Category_Header","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[8]",Target.XPATH);
	  
    public static final Target OrderGuide_FirstItemSelect= new Target("Category_FirstItemSelect","(//*[@id='mount']//*[@class='mm-o-icon'])[1]",Target.XPATH); 
     public static String Location1ItemSelected;
    public static String Location1ItemAdded;
 	public static final Target Location_FirstItemAdded= new Target("LocationName","//*[@id='mount']/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/div[2]/div[2]/h4",Target.XPATH);
 	
 	public static final Target AddLocation_LocName= new Target("ADDLocation_LocName","//*[@id='name']",Target.XPATH);
 	public static final Target AddLocation_LocTypeCoolerWeb= new Target("ADDLocation_LocTypeCooler","(//*[@class='mm-c-location__details-radio']//*[@class='radio'])[1]",Target.XPATH);
    
 	public static final Target AddWeb= new Target("ADD_Vendor","//*[@id='add-nav']/a/i",Target.XPATH);
	  public static final Target EditWeb = new Target("Edit","//*[@id='edit-nav']/a/i",Target.XPATH);
	  public static final Target AddLocation_LocTypeCooler= new Target("LocationDry","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]",Target.XPATH);
		
	  public static final Target Back = new Target("Back","//*[@id='back-nav']/a/i",Target.XPATH);
 	
	//public static final Target LocationName = new Target("LocationName","//UIAStaticText[@label='LOCATION NAME']",Target.XPATH);
	/*public static final Target NewLocation = new Target("LocationName","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]",Target.XPATH);
	public static final Target LocationCooler= new Target("LocationDry","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[1]",Target.XPATH);
	public static final Target Next= new Target("Next","//UIAStaticText[@label='Next']",Target.XPATH); 
	public static final Target SetUp_Pg2Title = new Target("SetUp_Pg2Title","//UIAStaticText[@label='SETUP LOCATIONS']",Target.XPATH);
    public static final Target DefaultLocation = new Target("DefaultLocation","//UIAButton[@label='Default']",Target.XPATH);
    public static final Target CustomLocations = new Target("CustomLocations","//UIAButton[@label='Custom Locations']",Target.XPATH);
    public static final Target Continue = new Target("Continue","//UIAButton[@label='Continue']",Target.XPATH);
    public static final Target Header= new Target("Category_Header","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[8]",Target.XPATH);
	  
    public static final Target OrderGuide_FirstItemSelect= new Target("Category_FirstItemSelect","(//*[@id='mount']//*[@class='mm-o-icon'])[1]",Target.XPATH); 
    public static final Target Location_FirstItemSelect= new Target("LocationName","(//*[@class='mm-c-product-list__details-wrapper'])[1]/h4",Target.XPATH);
    public static final Target Location_FirstItem= new Target("LocationName","(//*[@class='checkbox']//*[@class='mm-o-icon'])[1]",Target.XPATH);
    public static String Location1ItemSelected;
    
    public static final Target Done= new Target("DoneWeb","//UIAStaticText[@label='Done']",Target.XPATH); 
    public static String Location1ItemAdded;
 	  public static final Target Location_FirstItemAdded= new Target("LocationName","//*[@id='mount']/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/div[2]/div[2]/h4",Target.XPATH);
 	 public static final Target LocationsPage_Header= new Target("LocationName","//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3",Target.XPATH);
*/
 	 
 	 ///////////////
 	 public static final Target ADD_AnotherLocation = new Target("LocationName","//*[@class='mm-c-customlocation__setup-cta']//*[contains(text(),'Add Another Location')]",Target.XPATH);
	 public static final Target LocType_Dry1 = new Target("LocationName","(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]",Target.XPATH);
	 public static final Target LocType_Dry1T2 = new Target("LocationName","(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]//*[@type='radio']",Target.XPATH);
		  
	 public static final Target LocType_Dry2 = new Target("LocationName","(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]",Target.XPATH);
	 public static final Target LocType_Dry2T1 = new Target("LocationName","(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]/label",Target.XPATH);
	 public static final Target LocType_Dry2T2 = new Target("LocationName","(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[6]//*[@type='radio']",Target.XPATH);
	 public static final Target ADD_LocationName = new Target("LocationName","//*[@id='name']",Target.XPATH);
		public static final Target ADD_LocTypeDry = new Target("LocationName","//*[@value='D']",Target.XPATH);
	public static final Target ADD_LocationName1 = new Target("LocationName","//*[@class='mm-c-customlocation__setup-form']//*[@name='formFields[0].name']",Target.XPATH);
	public static final Target SetupInventoryLocationUncategorizedTab = new Target("SetupInventoryCustomLoc_LocName","//*[@id='mount']//*[@class='mm-c-productList--pill-right']/a",Target.XPATH);
		
	      public static final Target SetupInventoryLocationAllItemsTab = new Target("SetupInventoryCustomLoc_LocName","//*[@id='mount']//*[@class='mm-c-productList--pill-left']/a",Target.XPATH);
	    public static String Location2ItemSelected;
	    public static String  value= "3.8";
		  public static String value2 = "4";
		
	    public static  String locationInputTextBox="//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"+value+"']";
		public static String locationInputTextBox2="//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"+value2+"']";
		public static final Target LocationItem1_InputTextBox = new Target("LocationItem1_InputTextBox","//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control']",Target.XPATH);
	    public static final Target LocationItem1_InputTextBoxCheck = new Target("LocationItem1_InputTextBoxCheck",locationInputTextBox,Target.XPATH);
	    public static final Target LocationItem2_InputTextBoxCheck = new Target("LocationItem1_InputTextBoxCheck",locationInputTextBox2,Target.XPATH);
	    public static String Location2ItemAdded;
	    public static final Target  BackWeb= new Target("Back","//*[@class='nav navbar-nav']//*[@role='presentation']//*[@class='mm-o-icon icon-chevron-left']",Target.XPATH);
		 //  public static final Target LocationName = new Target("LocationName","//UIAStaticText[@label='LOCATION NAME']",Target.XPATH);
			
	    public static final Target Locator_firstLocname = new Target("Locator_firstLocname","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]",Target.XPATH);
	    public static final Target EditBtnLocDetailsPg = new Target("Edit","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]/UIALink[1]/UIAStaticText[1]",Target.XPATH);
	   public static final Target LocationFreezer= new Target("LocationFreezer","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[3]",Target.XPATH);
		public static final Target LocationDry= new Target("LocationCooler","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]",Target.XPATH);
		public static final Target Update = new Target("Update","//UIAStaticText[@label='Update']",Target.XPATH);
		public static final Target Delete = new Target("Back","//*[@id='delete-button' and contains(text(),'Delete Location')]",Target.XPATH);
		public static final Target YesDelete = new Target("Back","//*[@id='yes-button' and contains(text(),'Yes, Delete')]",Target.XPATH);
		
		public static final Target AddItem_OrderGuide = new Target("OrderGuide","//*[@type='button']//span[contains(text(),'Add From Order Guide')]",Target.XPATH);
		public static final Target Category_Header= new Target("Category_Header","//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3",Target.XPATH);

		public static final Target  LocationsDone= new Target("LocationsDone","//*[@type='button' and contains(text(),'Done')]",Target.XPATH);
		public static final Target AddProductPage_AddLocations= new Target("AddProductPage_AddLocations","//*[@class='row']//*[contains(text(),'Add/Select Location(s)')]",Target.XPATH);
		public static final Target ProductDetailsPage= new Target("ProductDetailsPage","//*[@class='navbar-brand']//*[contains(text(),'Product Details')]",Target.XPATH); 
	
		
 public static final Target Locations_1stItemSelect= new Target("Locations_1stItemSelect","(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[1]",Target.XPATH);
	public static final Target Locations_2ndItemSelect= new Target("Locations_2ndItemSelect","(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[2]",Target.XPATH);
	public static final Target Locations_3rdItemSelect= new Target("Locations_3rdItemSelect","(//*[@class='mm-c-product-minlist mm-c-product__sysco']//*[@class='mm-o-icon'])[3]",Target.XPATH);
	public static final Target Locations_1stItemHeading= new Target("Locations_1stItemHeading","(//*[@class='mm-c-product-minlist__item']/h4)[1]",Target.XPATH);
	public static final Target Locations_2ndItemHeading= new Target("Locations_2ndItemHeading","(//*[@class='mm-c-product-minlist__item']/h4)[2]",Target.XPATH);
	public static final Target Locations_3rdItemHeading= new Target("Locations_3rdItemHeading","(//*[@class='mm-c-product-minlist__item']/h4)[3]",Target.XPATH);

	String LocationsItemName1_1;
	String LocationsItemName1_2;
	String LocationsItemName1_3;
	
	String LocationsItemName2_1;
	String LocationsItemName2_2;
	String LocationsItemName2_3;
	
	int locationsNoOfElements1;
	int locationsNoOfElements2;
	
	String LocationsItemPresent1_1;
	String LocationsItemPresent1_2;
	String LocationsItemPresent1_3;
	
	
	String LocationsItemPresent2_1;
	String LocationsItemPresent2_2;
	String LocationsItemPresent2_3;
	
	
	public  final Target Location1_FirstItemSelectedVerify= new Target("Location1_FirstItemSelectedVerify","//*[contains(text(),'"+LocationsItemName1_1+"')]",Target.XPATH);
	public  final Target Location1_SecondItemSelectedVerify= new Target("Location1_SecondItemSelectedVerify","//*[contains(text(),'"+LocationsItemName1_2+"')]",Target.XPATH);
	public  final Target Location1_ThirdItemSelectedVerify= new Target("Location1_ThirdItemSelectedVerify","//*[contains(text(),'"+LocationsItemName1_3+"')]",Target.XPATH);

	public  final Target Location2_FirstItemSelectedVerify= new Target("Location2_FirstItemSelectedVerify","//*[contains(text(),'"+LocationsItemName2_1+"')]",Target.XPATH);
	public  final Target Location2_SecondItemSelectedVerify= new Target("Location2_SecondItemSelectedVerify","//*[contains(text(),'"+LocationsItemName2_2+"')]",Target.XPATH);
	public  final Target Location2_ThirdItemSelectedVerify= new Target("Location2_ThirdItemSelectedVerify","//*[contains(text(),'"+LocationsItemName2_3+"')]",Target.XPATH);
			
	
public static final Target LocType_Dry1T1 = new Target("LocationName","(//*[@class='mm-c-customlocation__details-column']//*[@class='radio'])[3]/label",Target.XPATH);

public static final Target ADD_LocationName2 = new Target("LocationName","//*[@class='mm-c-customlocation__setup-form']//*[@name='formFields[1].name']",Target.XPATH);

public static final Target AddProductPage_AddCategory= new Target("AddProductPage_AddCategory","//*[@class='row']//*[contains(text(),'Add/Select Expense Category')]",Target.XPATH);

public static final Target LocationItem1_QuantityInput = new Target("LocationItem1_QuantityInput","(//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'])[1]",Target.XPATH);
public static final Target LocationItem2_QuantityInput = new Target("LocationItem1_QuantityInput","(//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'])[2]",Target.XPATH);
public static final Target UomUNITCS= new Target("LocationName","(//*[@id='uom']/option[1])[1]",Target.XPATH);
public static final Target UomUNITLB= new Target("LocationName","(//*[@id='uom']/option[2])[1]",Target.XPATH);
public static final Target UomUNITEA= new Target("LocationName","(//*[@id='uom']/option[3])[1]",Target.XPATH);
public static final Target UomUNITOZ= new Target("LocationName","(//*[@id='uom']/option[4])[1]",Target.XPATH);

		
		public LocationsPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public LocationsPage atLocationsPage()
	{
		log("Opened Locations Page ",LogType.STEP);
		return this;
	}

	
	public LocationsPage EnterLocationName(String locationName,String string)
   	{
   		String string1="Success";
   		String string2="Issue";   
   		String finalPath=drivePath+string+string1+pathExtension;
   		String finalPath1=drivePath+string+string2+pathExtension;	
   		
   		try{
   			System.out.println("inside frst page");
   		 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
   	  		System.out.println("contxtname is "+contextNames1);
   	  		
   	  		 for (String contextName : contextNames1){
   	  			 System.out.println("inside loop "+contextNames1);
   	  		 }
   	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
   	  	
   		//	getCommand().waitForTargetPresent(LocationName);
   			getCommand().click(NewLocation);
   			getCommand().sendKeys(NewLocation,locationName);
   			
   		   ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
   			 		getCommand().captureScreenshot(finalPath);
   			 		log("added location name :Pass",LogType.VERIFICATION_STEP);
   			}
   			
   	
   		
   		catch(Exception e)
   		{
   			getCommand().captureScreenshot(finalPath1);
   			log("added location name :Fail",LogType.VERIFICATION_STEP);
   			Assert.assertTrue(false);
   		}
   		
   		return this;
   		
   	}
	   public LocationsPage SelectLocationCooler(String string)
	   	{
	   		String string1="Success";
	   		String string2="Issue";   
	   		String finalPath=drivePath+string+string1+pathExtension;
	   		String finalPath1=drivePath+string+string2+pathExtension;	
	   		
	   		try{
	   			
	   				
	   					getCommand().waitForTargetPresent(LocationCooler);
	   		    getCommand().click(LocationCooler);
	   		    System.out.println("selected cooler");
	   		    
	   			 
	   			 		getCommand().captureScreenshot(finalPath);
	   			 		log("Selected cooler :Pass",LogType.VERIFICATION_STEP);
	   			}
	   			
	   	
	   		
	   		catch(Exception e)
	   		{
	   			getCommand().captureScreenshot(finalPath1);
	   			log("Selected cooler :Fail",LogType.VERIFICATION_STEP);
	   			Assert.assertTrue(false);
	   		}
	   		
	   		return this;
	   		
	   	}
	   public LocationsPage TapOnNext(String string){
	       	String string1="Success";
	       	  String string2="Issue";

	       String finalPath=drivePath+string+string1+pathExtension;
	       String finalPath1=drivePath+string+string2+pathExtension;

	       	try{
	       			getCommand().waitForTargetPresent(Next);
	       		if (getCommand().isTargetPresent(Next))
	       		{
	       			
	       			getCommand().click(Next);
	       			log("Tapped on Next : Pass",LogType.VERIFICATION_STEP);
	       				getCommand().captureScreenshot(finalPath);
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
	   public LocationsPage CustomLocation(String string){
	   		String string1="Success";
	   		  String string2="Issue";
	   			  String finalPath=drivePath+string+string1+pathExtension;
	   	   String finalPath1=drivePath+string+string2+pathExtension;	
	   		try{
	   			Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  	  		System.out.println("contxtname is "+contextNames1);
	  	  		
	  	  		 for (String contextName : contextNames1){
	  	  			 System.out.println("inside loop "+contextNames1);
	  	  		 }
	  	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
	   				
	  			getCommand().waitForTargetPresent(SetUp_Pg2Title);
	   			getCommand().waitForTargetPresent(CustomLocations);
	   			getCommand().click(CustomLocations);
	   		 ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
	  			getCommand().captureScreenshot(finalPath);	
	   				
	   			
	   			log("custom location clicked :Pass",LogType.VERIFICATION_STEP);
	   		}
	   		
	   		catch(Exception e)
	   		{
	   			getCommand().captureScreenshot(finalPath1);	
	   			log("custom location clicked :Fail",LogType.VERIFICATION_STEP);
	   			Assert.assertTrue(false);

	   		}
	   		
	   		return this;
	   		
	   	}    





      public LocationsPage DefaultLocation(String string){
  		String string1="Success";
  		  String string2="Issue";
  			  String finalPath=drivePath+string+string1+pathExtension;
  	   String finalPath1=drivePath+string+string2+pathExtension;	
  		try{
  		
  			Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
  	  		System.out.println("contxtname is "+contextNames1);
  	  		
  	  		 for (String contextName : contextNames1){
  	  			 System.out.println("inside loop "+contextNames1);
  	  		 }
  	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
  	  	
  			getCommand().waitForTargetPresent(SetUp_Pg2Title);
  			getCommand().waitForTargetPresent(DefaultLocation);
  				getCommand().click(DefaultLocation);
  				
  				 ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
  			getCommand().captureScreenshot(finalPath);	
  				
  			
  			log("custom location clicked :Pass",LogType.VERIFICATION_STEP);
  		}
  		
  		catch(Exception e)
  		{
  			getCommand().captureScreenshot(finalPath1);	
  			log("custom location clicked :Fail",LogType.VERIFICATION_STEP);
  			Assert.assertTrue(false);

  		}
  		
  		return this;
  		
  	}   
      public LocationsPage tapContinue(String string){
		  String string1="Success";
		  String string2="Issue";
		   String finalPath=drivePath+string+string1+pathExtension;
	       String finalPath1=drivePath+string+string2+pathExtension;
	     	try{
	     		
	     		Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	      		System.out.println("contxtname is "+contextNames1);
	      		
	      		 for (String contextName : contextNames1){
	      			 System.out.println("inside loop "+contextNames1);
	      		 }
	      	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
	      	
				getCommand().waitForTargetPresent(Continue);
			getCommand().click(Continue);
			
			 ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath);
				
			
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
      public  LocationsPage SelectItemFromLocations(String string){

    	  log("Selecting item",LogType.STEP);
    	  String string1="Success";
    	  String string2="Issue";

    	  String finalPath=drivePath+string+string1+pathExtension;
    	    String finalPath1=drivePath+string+string2+pathExtension;
    	  try{	
    	  	 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    	  		System.out.println("contxtname is "+contextNames1);
    	  		
    	  		 for (String contextName : contextNames1){
    	  			 System.out.println("inside loop "+contextNames1);
    	  		 }
    	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    	  		getCommand().waitForTargetPresent(LocationsPage_Header);
    	
    	  		if (getCommand().isTargetPresent(LocationsPage_Header))
    	  		{
    	  			System.out.println(getCommand().getText(LocationsPage_Header));
    	  			
    	  				getCommand().waitFor(5);
    	  	        getCommand().click(Location_FirstItem);
    	  	       
    	  	       
    	  	        Location1ItemSelected= getCommand().getText(Location_FirstItemSelect);
    	  		    System.out.println("loc1item:"+Location1ItemSelected);
    	  		    
    	  		        System.out.println("selected first item");
    	  		        getCommand().waitFor(5);
    	  	        
    	  	          ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    	  	        getCommand().captureScreenshot(finalPath);
    	  			log("Selecting item1 :Pass",LogType.VERIFICATION_STEP);						
    	  		}

    	  	}
    	  catch(Exception e){
    	  	getCommand().captureScreenshot(finalPath1);
    	  	log("Selecting item1 :Fail",LogType.VERIFICATION_STEP);
    	  	Assert.assertTrue(false);
    	  		}

    	  		return this;

    	  }
      public LocationsPage TapOnDone(String string){
         	String string1="Success";
         	  String string2="Issue";

         String finalPath=drivePath+string+string1+pathExtension;
         String finalPath1=drivePath+string+string2+pathExtension;

         	try{
         		
         		/*Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
          		System.out.println("contxtname is "+contextNames1);
          		
          		 for (String contextName : contextNames1){
          			 System.out.println("inside loop "+contextNames1);
          		 }
          	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
          	*/
         			getCommand().waitForTargetPresent(Done);
         		if (getCommand().isTargetPresent(Done))
         		{
         			
         			getCommand().click(Done);
         			log("Tapped on done:Pass",LogType.VERIFICATION_STEP);
         			
         			// ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
         				getCommand().captureScreenshot(finalPath);
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
      public  LocationsPage ItemVerifyOnLocation(String location,String string){

    		String string1="Success";
    		String string2="Issue";	
    		  String finalPath=drivePath+string+string1+pathExtension;
    		  String finalPath1=drivePath+string+string2+pathExtension;
    		
    			log("location Item verify ",LogType.STEP);
    			try{
    				 
    				 
    				 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    	    	  		System.out.println("contxtname is "+contextNames1);
    	    	  		
    	    	  		 for (String contextName : contextNames1){
    	    	  			 System.out.println("inside loop "+contextNames1);
    	    	  		 }
    	    	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    	    	  	
    	    	 
    			Location1ItemAdded=getCommand().getText(Location_FirstItemAdded);
    			System.out.println(Location1ItemAdded);
    			System.out.println(Location1ItemSelected);
    			final Target Locations_Productcheck= new Target("Locations_check","//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+Location1ItemSelected+"')]",Target.XPATH);
    			
    			
    			
    			 getCommand().waitForTargetPresent(Locations_Productcheck);
    				boolean flag = getCommand().isTargetPresentAfterWait(Locations_Productcheck, 3);
    			    System.out.println("Flag1: "+flag);
    			   
    			    
    			   if(!flag){ 
    				   ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
       				getCommand().captureScreenshot(finalPath1);
    				   throw new Exception();
    			   }
    			    
    			     
    			     
    			   ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    					getCommand().captureScreenshot(finalPath);
    					
    					log("Item verification done :Pass",LogType.VERIFICATION_STEP);
    				  }
    			catch(Exception e){
    				 ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    				getCommand().captureScreenshot(finalPath1);
    				log("Item verification done  :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			 }
    			
    			
    			
    			
    			return this;
    			
    			}
      public  LocationsPage NonSyscoItemVerifyTrackInventory(String location,String product,String string){

  		String string1="Success";
  		String string2="Issue";	
  		  String finalPath=drivePath+string+string1+pathExtension;
  		  String finalPath1=drivePath+string+string2+pathExtension;
  		
  			log("locationItem verify ",LogType.STEP);
  			try{
  				 
  				 
  				 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
  	    	  		System.out.println("contxtname is "+contextNames1);
  	    	  		
  	    	  		 for (String contextName : contextNames1){
  	    	  			 System.out.println("inside loop "+contextNames1);
  	    	  		 }
  	    	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
  	    	  	 final Target Locations_random1= new Target("Locations_random1","//*[@id='list-item' and contains(text(),'"+location+"')]",Target.XPATH);
   				 
  				 
  			getCommand().waitForTargetPresent(Locations_random1);
  			getCommand().click(Locations_random1);
  			System.out.println("clicked location");
  			
  			Location1ItemAdded=getCommand().getText(Location_FirstItemAdded);
  			System.out.println(Location1ItemAdded);
  			
  			//System.out.println(Location1ItemSelected);
  			//final Target Locations_Productcheck= new Target("Locations_check","//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+Location1ItemSelected+"')]",Target.XPATH);
  			
  			System.out.println(product);
  			final Target Locations_Productcheck= new Target("Locations_check","//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+product+"')]",Target.XPATH);
  			
  			
  			 getCommand().waitForTargetPresent(Locations_Productcheck);
  				boolean flag = getCommand().isTargetPresentAfterWait(Locations_Productcheck, 3);
  			    System.out.println("Flag1: "+flag);
  			   
  			    
  			   if(!flag){
  				   throw new Exception();
  			   }
  			    
  			     
  			     
  			   ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
  					getCommand().captureScreenshot(finalPath);
  					
  					log("Item verification done :Pass",LogType.VERIFICATION_STEP);
  				  }
  			catch(Exception e){
  				getCommand().captureScreenshot(finalPath1);
  				log("Item verification done  :Fail",LogType.VERIFICATION_STEP);
  				Assert.assertTrue(false);
  			 }
  			
  			
  			
  			
  			return this;
  			
  			}
      
      
      /////////////////////////////////
      public  LocationsPage AddLocations1_name(String locname){
    		
    		log("Entering Location name1",LogType.STEP);
    	try{	
    		 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    			System.out.println("contxtname is "+contextNames1);
    			
    			 for (String contextName : contextNames1){
    				 System.out.println("inside loop "+contextNames1);
    			 }
    		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));

    		getCommand().waitForTargetPresent(ADD_LocationName1);
    		System.out.println("got loca");
    		if (getCommand().isTargetPresent(ADD_LocationName1))
    		{
    			getCommand().click(ADD_LocationName1);
    			//clearing filed
    			getCommand().clear(ADD_LocationName1);
    			getCommand().waitFor(5);
    			
    			getCommand().sendKeys(ADD_LocationName1, locname);
    			getCommand().waitFor(5);
    			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    			log("Entered location name1 in add Locations page :Pass",LogType.VERIFICATION_STEP);						
    		}
    		
    	}
    		catch(Exception e){
    		//	getCommand().captureScreenshot("/Users/jinita_jose/Desktop/ScreenShots_Android/Functional/AddLocationNameEnter_issue.png");
    			log("Entered location name1 in add Locations page  :Fail",LogType.VERIFICATION_STEP);
    			Assert.assertTrue(false);
    		}
    		
    		return this;
    		
    	}

    	public  LocationsPage AddLocations1_TypeDry(String string){

    	log("Entering type Dry",LogType.STEP);
    	String string1="Success";
    	String string2="Issue";   
    	String finalPath=drivePath+string+string1+pathExtension;
    	String finalPath1=drivePath+string+string2+pathExtension;

    	try{	

    		 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    			System.out.println("contxtname is "+contextNames1);
    			
    			 for (String contextName : contextNames1){
    				 System.out.println("inside loop "+contextNames1);
    			 }
    		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));


    		
    		/*getCommand().waitForTargetPresent(LocType_Dry1);

    		if (getCommand().isTargetPresent(LocType_Dry1))
    			{
    			getCommand().waitFor(5);
    				getCommand().click(LocType_Dry1);
    				getCommand().waitFor(5);
    				System.out.println("selcted dry by ist");
    				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 	  
    				getCommand().captureScreenshot(finalPath); 
    				log("Entered type in add Locations page :Pass",LogType.VERIFICATION_STEP);						
    			}*/
    		
    		
    		if (getCommand().isTargetPresent(LocType_Dry1T1))
    		{getCommand().waitFor(5);
    			getCommand().click(LocType_Dry1T1);
    			getCommand().waitFor(5);
    			System.out.println("selcted dry by 2nd");
    			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 	  
    			getCommand().captureScreenshot(finalPath); 
    			log("Entered type in add Locations page :Pass",LogType.VERIFICATION_STEP);						
    		}
    		
    		if (getCommand().isTargetPresent(LocType_Dry1T2))
    		{getCommand().waitFor(5);
    			getCommand().click(LocType_Dry1T2);
    			getCommand().waitFor(5);
    			System.out.println("selcted dry by 3rd");
    			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 	  
    			getCommand().captureScreenshot(finalPath); 
    			log("Entered type in add Locations page :Pass",LogType.VERIFICATION_STEP);						
    		}
    		

    		}
    	catch(Exception e){
    		getCommand().captureScreenshot(finalPath1); 
    		log("Entered location type in add Locations page  :Fail",LogType.VERIFICATION_STEP);
    		Assert.assertTrue(false);
    			}

    			return this;

    	}
    	public  LocationsPage AddLocations2_name(String locname){
    		
    		log("Entering Location name",LogType.STEP);
    		System.out.println("in 2ndloc");
    	try{	
    		 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    			System.out.println("contxtname is "+contextNames1);
    			
    			 for (String contextName : contextNames1){
    				 System.out.println("inside loop "+contextNames1);
    			 }
    		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));

    		getCommand().waitForTargetPresent(ADD_LocationName2);
    		System.out.println("got second loc");
    		if (getCommand().isTargetPresent(ADD_LocationName2))
    		{
    			getCommand().click(ADD_LocationName2);
    			//clearing filed
    			getCommand().clear(ADD_LocationName2);
    			getCommand().waitFor(5);
    			
    			getCommand().sendKeys(ADD_LocationName2, locname);
    			getCommand().waitFor(5);
    			 ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 

    			log("Entered location name2 in add Locations page :Pass",LogType.VERIFICATION_STEP);						
    		}
    		
    	}
    		catch(Exception e){
    		//	getCommand().captureScreenshot("/Users/jinita_jose/Desktop/ScreenShots_Android/Functional/AddLocationNameEnter_issue.png");
    			log("Entered location name2 in add Locations page  :Fail",LogType.VERIFICATION_STEP);
    			Assert.assertTrue(false);
    		}
    		
    		return this;
    		
    	}
    	public  LocationsPage AddLocations2_TypeDry(String string){

    	log("Entering type Dry",LogType.STEP);
    	String string1="Success";
    	String string2="Issue";   
    	String finalPath=drivePath+string+string1+pathExtension;
    	String finalPath1=drivePath+string+string2+pathExtension;
    	try{	

    		 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    			System.out.println("contxtname is "+contextNames1);
    			
    			 for (String contextName : contextNames1){
    				 System.out.println("inside loop "+contextNames1);
    			 }
    		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));

    		System.out.println("switched");
//    		getCommand().waitForTargetPresent(LocType_Dry2);
    	System.out.println("checking if conditions Dry");
    	/*	if (getCommand().isTargetPresent(LocType_Dry2))
    			{
    				System.out.println("dry by 1");
    				getCommand().click(LocType_Dry2);
    				System.out.println("selecteddry by 1");
    				getCommand().waitFor(5);
    				 ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 		
    				 getCommand().captureScreenshot(finalPath); 	   
    				log("Entered type in add Locations page :Pass",LogType.VERIFICATION_STEP);						
    			}*/
    		
    		
    		if (getCommand().isTargetPresent(LocType_Dry2T1))
    		{
    			System.out.println("dry by 2");
    			getCommand().click(LocType_Dry2T1);
    			getCommand().waitFor(5);
    			System.out.println("selcted dry by 2nd");
    			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 	  
    			getCommand().captureScreenshot(finalPath); 
    			log("Entered type in add Locations page :Pass",LogType.VERIFICATION_STEP);						
    		}
    		
    		if (getCommand().isTargetPresent(LocType_Dry2T2))
    		{
    			System.out.println("dry by 3");
    			getCommand().click(LocType_Dry2T2);
    			getCommand().waitFor(5);
    			System.out.println("selcted dry by 3rd");
    			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 	  
    			getCommand().captureScreenshot(finalPath); 
    			log("Entered type in add Locations page :Pass",LogType.VERIFICATION_STEP);						
    		}

    		}
    	catch(Exception e){
    		getCommand().captureScreenshot(finalPath1);   
    		log("Entered location type in add Locations page  :Fail",LogType.VERIFICATION_STEP);
    		Assert.assertTrue(false);
    			}

    			return this;

    	}
    	public  LocationsPage AddLocations2(){

    		log("Entering anotherloc",LogType.STEP);

    		try{	

    			 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    				System.out.println("contxtname is "+contextNames1);
    				
    				 for (String contextName : contextNames1){
    					 System.out.println("inside loop "+contextNames1);
    				 }
    			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));


    			
    			getCommand().waitForTargetPresent(ADD_AnotherLocation);

    			if (getCommand().isTargetPresent(ADD_AnotherLocation))
    				{
    					getCommand().click(ADD_AnotherLocation);
    					getCommand().waitFor(5);
    					System.out.println("another loc");
    					 ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    			
    					   
    					log("Entered second loc in Locations page :Pass",LogType.VERIFICATION_STEP);						
    				}

    			}
    		catch(Exception e){
    			   
    			log("Entered second loc in Locations page  :Fail",LogType.VERIFICATION_STEP);
    			Assert.assertTrue(false);
    				}

    				return this;

    		}
    	public  LocationsPage Itemselect1(String string){

    		log("Selecting item",LogType.STEP);
    		String string1="Success";
    		String string2="Issue";

    		String finalPath=drivePath+string+string1+pathExtension;
    		  String finalPath1=drivePath+string+string2+pathExtension;
    		try{	
    			 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    				System.out.println("contxtname is "+contextNames1);
    				
    				 for (String contextName : contextNames1){
    					 System.out.println("inside loop "+contextNames1);
    				 }
    			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    			System.out.println("in temselect");
    			getCommand().waitForTargetPresent(LocationsPage_Header);
    		System.out.println("got header");
    			if (getCommand().isTargetPresent(LocationsPage_Header))
    				{
    					//getCommand().click(Location2_Allitems);
    				//	System.out.println("all items");
    					getCommand().waitFor(5);
    			        getCommand().click(Location_FirstItem);
    			       
    			       
    			        Location1ItemSelected= getCommand().getText(Location_FirstItemSelect);
    				    System.out.println("loc1item:"+Location1ItemSelected);
    				    
    				        System.out.println("selected first item");
    				        getCommand().waitFor(5);
    			        
    			        
    				//	getCommand().captureScreenshot("/Users/jinita_jose/Desktop/ScreenShots_Android/Functional/LocTypeDryEnter_success.png");
    			        ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    			        getCommand().captureScreenshot(finalPath);
    					log("Selecting item1 :Pass",LogType.VERIFICATION_STEP);						
    				}

    			}
    		catch(Exception e){
//    			getCommand().captureScreenshot("/Users/jinita_jose/Desktop/ScreenShots_Android/Functional/LocTypeDryEnter_issue.png");
    			getCommand().captureScreenshot(finalPath1);
    			log("Selecting item1 :Fail",LogType.VERIFICATION_STEP);
    			Assert.assertTrue(false);
    				}

    				return this;

    		}

    		public  LocationsPage Itemselect2(String string){

    		log("Selecting item",LogType.STEP);
    		String string1="Success";
    		String string2="Issue";

    		String finalPath=drivePath+string+string1+pathExtension;
    		  String finalPath1=drivePath+string+string2+pathExtension;
    		try{	
    			 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    				System.out.println("contxtname is "+contextNames1);
    				
    				 for (String contextName : contextNames1){
    					 System.out.println("inside loop "+contextNames1);
    				 }
    			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    			getCommand().waitForTargetPresent(LocationsPage_Header);

    			if (getCommand().isTargetPresent(LocationsPage_Header))
    				{
    					getCommand().click(SetupInventoryLocationAllItemsTab);
    					System.out.println("all items");
    					getCommand().waitFor(5);
    			        getCommand().click(Location_FirstItem);
    			        
    			        Location2ItemSelected= getCommand().getText(Location_FirstItemSelect);
    		    		System.out.println("loc2item:"+Location2ItemSelected);

    			        
    			        System.out.println("selected first item");
    			        getCommand().waitFor(5);
    			        
    			        System.out.println("Selected1"+Location1ItemSelected);
    			    	
    			    	if((Location2ItemSelected.equalsIgnoreCase(Location1ItemSelected))){
    			    		log("Same item is  selected for location2 :Pass",LogType.VERIFICATION_STEP);	
    			    	}
    			    	else{
    			        	log("Same item is selected for location2 :Fail",LogType.VERIFICATION_STEP);		
    			        }

    			        
    				//	getCommand().captureScreenshot("/Users/jinita_jose/Desktop/ScreenShots_Android/Functional/LocTypeDryEnter_success.png");
    			        ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    			        getCommand().captureScreenshot(finalPath);
    					log("Selecting item1 :Pass",LogType.VERIFICATION_STEP);						
    				}

    			}
    		catch(Exception e){
//    			getCommand().captureScreenshot("/Users/jinita_jose/Desktop/ScreenShots_Android/Functional/LocTypeDryEnter_issue.png");
    			getCommand().captureScreenshot(finalPath1);
    			log("Selecting item1 :Fail",LogType.VERIFICATION_STEP);
    			Assert.assertTrue(false);
    				}

    				return this;

    		}
    		public  LocationsPage locationItemClick1AndEnterValue(String location,String string){
    			String string1="Success";
    			String string2="Issue";

    			String finalPath=drivePath+string+string1+pathExtension;
    			  String finalPath1=drivePath+string+string2+pathExtension;
    			log("locationItemClick1AndEnterValue ",LogType.STEP);
    			try{
    				 
//    				 final Target Locations_random1= new Target("Locations_random1","//*[@id='list-item' and contains(text(),'{0}')]",Target.XPATH);
    				 final Target Locations_random1= new Target("Locations_random1","//*[@id='list-item' and contains(text(),'"+location+"')]",Target.XPATH);
    					  
    			     System.out.println("location1" +location);

    				 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    					System.out.println("contxtname is "+contextNames1);
    					
    					 for (String contextName : contextNames1){
    						 System.out.println("inside loop "+contextNames1);
    					 }
    				System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
//    				final Target Locations_random1= new Target("Locations_random1","//*[@id='list-item' and contains(text(),'{0}')]",Target.XPATH);
    				
    				
    			getCommand().waitForTargetPresent(Locations_random1);
    			getCommand().click(Locations_random1);
    			
    			Location1ItemAdded=getCommand().getText(Location_FirstItemAdded);
    			System.out.println(Location1ItemAdded);
    			
    			/*boolean c=getCommand().getDriver().getPageSource().contains(Location1ItemSelected); 
    		 	if(c==true){ 
    		 		
    				log("Added item is present in location1 :Pass",LogType.VERIFICATION_STEP);	
    			//	getCommand().captureScreenshot(finalPath);
    				} 
    			else{ 
    				log("Added item is present in location1   :Fail",LogType.VERIFICATION_STEP);	
    				Assert.assertTrue(false);
    		          }
    		*/
    			
//    			getCommand().click(Locations_random1.format(location));
    			
    		    getCommand().waitForTargetPresent(LocationItem1_InputTextBox);
    		    getCommand().sendKeys(LocationItem1_InputTextBox, value);
    		    System.out.println("enterd value");
    		    getCommand().waitFor(2);
    		    System.out.println("got back");
    		    getCommand().waitForTargetPresent(Back);
    		    getCommand().click(Back);
    		    System.out.println("back clicked");
    		    getCommand().waitForTargetPresent(Locations_random1);
    			getCommand().click(Locations_random1);
    			
    			boolean flag = getCommand().isTargetPresentAfterWait(LocationItem1_InputTextBoxCheck, 5);
    		    System.out.println("Flag1: "+flag);
    		   
    		    
    		   if(!flag){
    			   throw new Exception();
    		   }
    		    
    		   log("locationItemClick1AndEnterValue :Pass",LogType.VERIFICATION_STEP);
    		     
    		     
    		   ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    				getCommand().captureScreenshot(finalPath);
    				
    				log("locationItemClick1AndEnterValue :Pass",LogType.VERIFICATION_STEP);
    			  }
    			catch(Exception e){
    				getCommand().captureScreenshot(finalPath1);
    				log("locationItemClick1AndEnterValue :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			 }
    			
    			return this;
    			
    		    }
    		public  LocationsPage locationItemClick2AndEnterValue(String location,String string){
    			String string1="Success";
    			String string2="Issue";

    			String finalPath=drivePath+string+string1+pathExtension;
    			  String finalPath1=drivePath+string+string2+pathExtension;
    		log("locationItemClick1AndEnterValue ",LogType.STEP);
    		try{	 
    			
//    			final Target Locations_random2= new Target("Locations_random1","//*[@id='list-item' and contains(text(),'{0}')]",Target.XPATH);
//    			final Target Locations_random2= new Target("Locations_random1","//*[@id='list-item' and contains(text(),'loc2')]",Target.XPATH);
    			final Target Locations_random2= new Target("Locations_random2","//*[@id='list-item' and contains(text(),'"+location+"')]",Target.XPATH);
    			System.out.println("location2" +location);

    			
    			 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    				System.out.println("contxtname is "+contextNames1);
    				
    				 for (String contextName : contextNames1){
    					 System.out.println("inside loop "+contextNames1);
    				 }
    			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    			//final Target Locations_random2= new Target("Locations_random1","//*[@id='list-item' and contains(text(),'loc2')]",Target.XPATH);
    			
    			 getCommand().waitForTargetPresent(Back);
    			 getCommand().click(Back);
    			
    		getCommand().waitForTargetPresent(Locations_random2);
    		getCommand().click(Locations_random2);

    		Location2ItemAdded=getCommand().getText(Location_FirstItemAdded);
    		System.out.println("added"+Location2ItemAdded);

    		/*if(Location2ItemAdded==Location2ItemSelected){
    			log("Added item is present in location2 :Pass",LogType.VERIFICATION_STEP);
    		}
    		*/

    		/*boolean c=getCommand().getDriver().getPageSource().contains(Location2ItemSelected); 
    			if(c==true){ 
    				
    			log("Added item is present in location2 :Pass",LogType.VERIFICATION_STEP);	
//    			getCommand().captureScreenshot(finalPath);
    			} 
    		else{ 
    			log("Added item is present in location2   :Fail",LogType.VERIFICATION_STEP);	
    			Assert.assertTrue(false);
    		      }*/

    			
    		//getCommand().click(Locations_random2.format(location));
    		getCommand().waitForTargetPresent(LocationItem1_InputTextBox);
    		getCommand().sendKeys(LocationItem1_InputTextBox, value2);

    		getCommand().waitForTargetPresent(Back);
    		getCommand().click(Back);

    		getCommand().waitForTargetPresent(Locations_random2);
    		getCommand().click(Locations_random2);

    		boolean flag = getCommand().isTargetPresentAfterWait(LocationItem2_InputTextBoxCheck, 5);
    		System.out.println("Flag2: "+flag);

    		if(!flag){
    		   throw new Exception();
    		}

    		log("locationItemClick2AndEnterValue :Pass",LogType.VERIFICATION_STEP);
    		 
    		 
    		((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    			getCommand().captureScreenshot(finalPath);
    			
    			log("locationItemClick2AndEnterValue :Pass",LogType.VERIFICATION_STEP);
    		  }
    		catch(Exception e){
    			getCommand().captureScreenshot(finalPath1);
    			log("locationItemClick1AndEnterValue :Fail",LogType.VERIFICATION_STEP);
    			Assert.assertTrue(false);
    		 }

    		return this;

    		}
    		public LocationsPage TapAddLocation(String string)
    		{
    			String string1="Success";
    			String string2="Issue";   
    			String finalPath=drivePath+string+string1+pathExtension;
    			String finalPath1=drivePath+string+string2+pathExtension;	
    			
    			try{
    				
    				Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    				System.out.println("contxtname is "+contextNames1);
    				
    				 for (String contextName : contextNames1){
    					 System.out.println("inside loop "+contextNames1);
    				 }
    			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    			
    				getCommand().waitForTargetPresent(AddWeb);
    				if(getCommand().isTargetPresent(AddWeb))
    				{
    					getCommand().click(AddWeb);
    					((IOSDriver)getCommand().driver).context("NATIVE_APP"); 	
    				
    	            //    getCommand().waitForTargetPresent(AddLocationPage);
    				
    					System.out.println("Inside add locations pg");
    				
    					log("Navigating to Add Locations page :Pass",LogType.VERIFICATION_STEP);	
    					
    				
    					
    				
    				}
    				
    				
    			}
    			catch(Exception e)
    			{
    				getCommand().captureScreenshot(finalPath1);
    				log("Navigating to Add Locations page :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			}
    			
    			return this;
    			
    		}
    		public LocationsPage AddLocationDetails(String locationName,String string)
    		{
    			String string1="Success";
    			String string2="Issue";   
    			String finalPath=drivePath+string+string1+pathExtension;
    			String finalPath1=drivePath+string+string2+pathExtension;	
    			
    			try{
    				
    				//getCommand().waitForTargetPresent(LocationName);
    				System.out.println("got locname");
    				getCommand().click(NewLocation);
    				System.out.println("got locname");
    				getCommand().sendKeys(NewLocation,locationName);
    				System.out.println("entered location");	

    			/*	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    				System.out.println("contxtname is "+contextNames1);
    				
    				 for (String contextName : contextNames1){
    					 System.out.println("inside loop "+contextNames1);
    				 }
    			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    			*/
    			getCommand().waitForTargetPresent(LocationCooler);
    			    getCommand().click(LocationCooler);
    			    System.out.println("selected cooler");
    			    
    				 		//((IOSDriver)getCommand().driver).context("NATIVE_APP");
    			    
    				 		getCommand().captureScreenshot(finalPath);
    				 		log("added location details :Pass",LogType.VERIFICATION_STEP);
    				}
    				
    		
    			
    			catch(Exception e)
    			{
    				getCommand().captureScreenshot(finalPath1);
    				log("added location details :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			}
    			
    			return this;
    			
    		}
    		public LocationsPage SelectLocation(String name,String string)
    		{
    			
    			  String pathExtension=".png";
    			  String string1="Success";
    			  String string2="Issue";
    			  
    		    String finalPath=drivePath+string+string1+pathExtension;
    		    String finalPath1=drivePath+string+string2+pathExtension;
    		    
    			log("Selecting location",LogType.STEP);
    		try{
    			String locationName=name;
    			 Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
    				
    			 for (String contextName : contextNames){
    				 System.out.println(contextNames);
    			 }
    		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));

    		 getCommand().waitFor(2);
    			final Target  Locname= new Target("Locname","//*[@id='list-item']//*[contains(text(),'"+locationName+"')]",Target.XPATH);   
    			  getCommand().click(Locname); 
    		      
    			  ((IOSDriver)getCommand().driver).context("NATIVE_APP");
    			
    		  
    		       getCommand().captureScreenshot(finalPath);
    		  
    				log("Location is selected for item :Pass",LogType.VERIFICATION_STEP);						
    			}
    			
    			
    			
    			catch(Exception e){
    				 getCommand().captureScreenshot(finalPath1); 
    				log("Location is selected for item   :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			}
    			return this;
    			
    		}
    		public LocationsPage AddLocationName(String locationName,String string)
    	   	{
    	   		String string1="Success";
    	   		String string2="Issue";   
    	   		String finalPath=drivePath+string+string1+pathExtension;
    	   		String finalPath1=drivePath+string+string2+pathExtension;	
    	   		
    	   		try{
    	   			Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
     				
    	 			 for (String contextName : contextNames){
    	 				 System.out.println(contextNames);
    	 			 }
    System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
    	   			getCommand().clear(AddLocation_LocName);
    	   			getCommand().click(AddLocation_LocName);
    	   			getCommand().sendKeys(AddLocation_LocName,locationName);
    	   		 ((IOSDriver)getCommand().driver).context("NATIVE_APP");   
    	   			 		getCommand().captureScreenshot(finalPath);
    	   			 		log("added location name :Pass",LogType.VERIFICATION_STEP);
    	   			}
    	   			
    	   	
    	   		
    	   		catch(Exception e)
    	   		{
    	   			getCommand().captureScreenshot(finalPath1);
    	   			log("added location name :Fail",LogType.VERIFICATION_STEP);
    	   			Assert.assertTrue(false);
    	   		}
    	   		
    	   		return this;
    	   		
    	   	}
    	   public LocationsPage AddLocationCooler(String string)
    	   	{
    	   		String string1="Success";
    	   		String string2="Issue";   
    	   		String finalPath=drivePath+string+string1+pathExtension;
    	   		String finalPath1=drivePath+string+string2+pathExtension;	
    	   		
    	   		try{
    	   			
    	   		/* Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
    				
     			 for (String contextName : contextNames){
     				 System.out.println(contextNames);
     			 }
    System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));*/	
    	   					getCommand().waitForTargetPresent(AddLocation_LocTypeCooler);
    	   		    getCommand().click(AddLocation_LocTypeCooler);
    	   		    System.out.println("selected cooler");
    	   		    
    	   		// ((IOSDriver)getCommand().driver).context("NATIVE_APP");
    	   			 		getCommand().captureScreenshot(finalPath);
    	   			 		log("Selected cooler :Pass",LogType.VERIFICATION_STEP);
    	   			}
    	   			
    	   	
    	   		
    	   		catch(Exception e)
    	   		{
    	   			getCommand().captureScreenshot(finalPath1);
    	   			log("Selected cooler :Fail",LogType.VERIFICATION_STEP);
    	   			Assert.assertTrue(false);
    	   		}
    	   		
    	   		return this;
    	   		
    	   	}
    	   public LocationsPage TapOnBack(String string){
    	  		String string1="Success";
    	  		  String string2="Issue";

    	  	String finalPath=drivePath+string+string1+pathExtension;
    	  	String finalPath1=drivePath+string+string2+pathExtension;

    	  		try{
    	  			Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
    	  		    getCommand().captureScreenshot(finalPath);
    	  			 for (String contextName : contextNames){
    	  				 System.out.println(contextNames);
    	  			 }
    	  		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
    	  		
    	  			getCommand().waitForTargetPresent(Back);
    	  			if (getCommand().isTargetPresent(Back))
    	  			{
    	  				
    	  				getCommand().click(Back);
    	  				
    	  				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    	  				getCommand().captureScreenshot(finalPath);
    	  				log("tap on back :Pass",LogType.VERIFICATION_STEP);
    	  			}
    	  			
    	  		}
    	  		catch(Exception e)
    	  		{
    	  			log("tap on back :Fail",LogType.VERIFICATION_STEP);
    	  			getCommand().captureScreenshot(finalPath1);
    	  			Assert.assertTrue(false);
    	  		}
    	  		
    	  		return this;
    	  	}
    	   public  LocationsPage VerifyLocationList(String locationAdded,String string){
    	  		String string1="Success";
    	  		  String string2="Issue";
    	  		 
    	  	    String finalPath=drivePath+string+string1+pathExtension;
    	  	    String finalPath1=drivePath+string+string2+pathExtension;
    	  		log("Checking addeded Location in location list",LogType.STEP);
    	  	  try{	
    	  		
    	  		String AddedLocation=locationAdded;
    	  	System.out.println("inside loc");
    	  	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    			System.out.println("contxtname is "+contextNames1);
    			
    			 for (String contextName : contextNames1){
    				 System.out.println("inside loop "+contextNames1);
    			 }
    		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    	  		final Target  LocAdded= new Target("PrepProduct","//*[@id='list-item']//span[contains(text(),'"+AddedLocation+"')]",Target.XPATH);   
    	  		
    	  		getCommand().waitForTargetPresent(LocAdded);
    	  		System.out.println("got target");
    	  		if (getCommand().isTargetPresent(LocAdded)) {
    	  			System.out.println("loc there");
    	  			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 	
    	  			 getCommand().captureScreenshot(finalPath);
    	  			log("Location is added :Pass",LogType.VERIFICATION_STEP);
    	  		}
    	  		
    	  	}
    	  	catch(Exception e)
    	  	{
    	  		getCommand().captureScreenshot(finalPath1);
    	  		log("Added new location is listed   :Fail",LogType.VERIFICATION_STEP);	
    	  		Assert.assertTrue(false);
    	  	}

    	  	return this;

    	  		
    	  	}
    	   public LocationsPage editLocation(String editlocation,String string){
    			
    			try{
    				
    				getCommand().waitForTargetPresent(Locator_firstLocname);
    				getCommand().click(Locator_firstLocname);
    				System.out.println("clicked first lcoator");
    				
    				
    				getCommand().waitForTargetPresent(EditBtnLocDetailsPg);
    				getCommand().click(EditBtnLocDetailsPg);
    				System.out.println("tap edit");
    				
    				String Name=getCommand().getText(NewLocation);
    				System.out.println("location name "+Name); 
    				
    				getCommand().click(NewLocation);
    				getCommand().clear(NewLocation);
    				getCommand().sendKeys(NewLocation,editlocation);
    				System.out.println("entered new location");
    				
    				getCommand().waitForTargetPresent(LocationDry);
    				getCommand().click(LocationDry);
    				System.out.println("selected freezer");
    				
    				getCommand().waitForTargetPresent(Update);
    				getCommand().click(Update);
    				//getCommand().click(Update);
    				System.out.println("updated");
    				
    				getCommand().waitForTargetPresent(Back);
    				getCommand().click(Back);
    				System.out.println("selected Back btn");
    				
    				
    		       
    		       
    				log("Edit location  :Pass",LogType.VERIFICATION_STEP);	
    			}
    			catch(Exception e)
    			{
    				log("Edit location  :Fail",LogType.VERIFICATION_STEP);	
    				Assert.assertTrue(false);
    			}
    			
    			return this;
    		}
    		
    	   public LocationsPage TapOnEdit(String string){
     	  		String string1="Success";
     	  		  String string2="Issue";

     	  	String finalPath=drivePath+string+string1+pathExtension;
     	  	String finalPath1=drivePath+string+string2+pathExtension;
     	  	log("Editing",LogType.STEP);
     	  		try{
     	  			Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
     	  		    getCommand().captureScreenshot(finalPath);
     	  			 for (String contextName : contextNames){
     	  				 System.out.println(contextNames);
     	  			 }
     	  		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
     	  		
     	  			getCommand().waitForTargetPresent(EditWeb);
     	  			if (getCommand().isTargetPresent(EditWeb))
     	  			{
     	  				
     	  				getCommand().click(EditWeb);
     	  				
     	  				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
     	  				getCommand().captureScreenshot(finalPath);
     	  				log("tap on edit :Pass",LogType.VERIFICATION_STEP);
     	  			}
     	  			
     	  		}
     	  		catch(Exception e)
     	  		{
     	  			log("tap on edit :Fail",LogType.VERIFICATION_STEP);
     	  			getCommand().captureScreenshot(finalPath1);
     	  			Assert.assertTrue(false);
     	  		}
     	  		
     	  		return this;
     	  	}
   	   
    	   public LocationsPage TapOnDeleteLocation(String string){
      	  		String string1="Success";
      	  		  String string2="Issue";

      	  	String finalPath=drivePath+string+string1+pathExtension;
      	  	String finalPath1=drivePath+string+string2+pathExtension;
      	  log("Delete cliking",LogType.STEP);
      	  		try{
      	  			Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
      	  		    getCommand().captureScreenshot(finalPath);
      	  			 for (String contextName : contextNames){
      	  				 System.out.println(contextNames);
      	  			 }
      	  		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
      	  		
      	  			getCommand().waitForTargetPresent(Delete);
      	  			if (getCommand().isTargetPresent(Delete))
      	  			{
      	  				
      	  				getCommand().click(Delete);
      	  				
      	  				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
      	  				getCommand().captureScreenshot(finalPath);
      	  				log("tap on delete :Pass",LogType.VERIFICATION_STEP);
      	  			}
      	  			
      	  		}
      	  		catch(Exception e)
      	  		{
      	  			log("tap on delete :Fail",LogType.VERIFICATION_STEP);
      	  			getCommand().captureScreenshot(finalPath1);
      	  			Assert.assertTrue(false);
      	  		}
      	  		
      	  		return this;
      	  	}
      	   
       	   public LocationsPage TapOnYesDelete(String string){
         	  		String string1="Success";
         	  		  String string2="Issue";

         	  	String finalPath=drivePath+string+string1+pathExtension;
         	  	String finalPath1=drivePath+string+string2+pathExtension;
         	  	log("Deleted",LogType.STEP);
         	  		try{
         	  			Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
         	  		    getCommand().captureScreenshot(finalPath);
         	  			 for (String contextName : contextNames){
         	  				 System.out.println(contextNames);
         	  			 }
         	  		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
         	  		
         	  			getCommand().waitForTargetPresent(YesDelete);
         	  			if (getCommand().isTargetPresent(YesDelete))
         	  			{
         	  				
         	  				getCommand().click(YesDelete);
         	  				
         	  				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
         	  				getCommand().captureScreenshot(finalPath);
         	  				log("tap on yes delete button :Pass",LogType.VERIFICATION_STEP);
         	  			}
         	  			
         	  		}
         	  		catch(Exception e)
         	  		{
         	  			log("tap on yes delete button :Fail",LogType.VERIFICATION_STEP);
         	  			getCommand().captureScreenshot(finalPath1);
         	  			Assert.assertTrue(false);
         	  		}
         	  		
         	  		return this;
         	  	}
       	 public  LocationsPage VerifyCancelledLocationList(String locationAdded,String string){
    	  		String string1="Success";
    	  		  String string2="Issue";
    	  		 
    	  	    String finalPath=drivePath+string+string1+pathExtension;
    	  	    String finalPath1=drivePath+string+string2+pathExtension;
    	  		log("Checking addeded Location in location list",LogType.STEP);
    	  	  try{	
    	  		
    	  		String AddedLocation=locationAdded;
    	  	System.out.println("inside loc");
    	  	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    			System.out.println("contxtname is "+contextNames1);
    			
    			 for (String contextName : contextNames1){
    				 System.out.println("inside loop "+contextNames1);
    			 }
    		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    	  		final Target  LocAdded= new Target("LocAdded","//*[@id='list-item']//span[contains(text(),'"+AddedLocation+"')]",Target.XPATH);   
    	  		System.out.println("finding target");
    	  	//	getCommand().waitForTargetPresent(LocAdded);
    	  //		System.out.println("got target");
    	  		if (getCommand().isTargetPresent(LocAdded)) {
    	  			System.out.println("loc there");
    	  			((IOSDriver)getCommand().driver).context("NATIVE_APP"); 	
    	  			 getCommand().captureScreenshot(finalPath1);
    	  			log("Cancelled Location is there :Fail",LogType.VERIFICATION_STEP);
    	  			Assert.assertTrue(false);
    	  		}
    	  		((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    	  		getCommand().captureScreenshot(finalPath);
    	  		log("Cancelled location is not listed   :Pass",LogType.VERIFICATION_STEP);
    	  	}
    	  	catch(Exception e)
    	  	{	((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    	  		getCommand().captureScreenshot(finalPath1);
    	  		log("Cancelled location is  listed   :Fail",LogType.VERIFICATION_STEP);	
    	  		Assert.assertTrue(false);
    	  	}

    	  	return this;

    	  		
    	  	}  	
       	public LocationsPage AddItemFrom_OrderGuide(String string) {
		   	 String string1="Success";
		   	  String string2="Issue";
		   	  
		      String finalPath=drivePath+string+string1+pathExtension;
		      String finalPath1=drivePath+string+string2+pathExtension;
		      
		       try{
		    	   Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
		     		System.out.println("contxtname is "+contextNames1);
		     		
		     		 for (String contextName : contextNames1){
		     			 System.out.println("inside loop "+contextNames1);
		     		 }
		     	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
		     	
		    	   getCommand().waitForTargetPresent(AddItem_OrderGuide);
		        	
		        	if (getCommand().isTargetPresent(AddItem_OrderGuide))
		        	{

		        		
		        		getCommand().click(AddItem_OrderGuide);	
		        	
		        	//	getCommand().waitForTargetPresent(Category_Header);
		        	
		        	//	  System.out.println("heading:"+getCommand().getText(Category_Header));
		        		  ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		        		getCommand().captureScreenshot(finalPath);
		        		  log("Order Guide Click : Pass",LogType.VERIFICATION_STEP);		
		        		
		        	}
		        		
		       }
		   	catch(Exception e){
		   	  log("Order Guide Click : Fail",LogType.VERIFICATION_STEP);
		   			Assert.assertTrue(false);
		   		}
		  	return this;
		    }

       	
        public LocationsPage AddLocation_AddProductDetailsPage(String string)
        {
        	
        	
        	  String string1="Success";
        	  String string2="Issue";
             
              String finalPath=drivePath+string+string1+pathExtension;
            String finalPath1=drivePath+string+string2+pathExtension;
         try{
         	
         	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
       		System.out.println("contxtname is "+contextNames1);
       		
       		 for (String contextName : contextNames1){
       			 System.out.println("inside loop "+contextNames1);
       		 }
       	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
         	
        		getCommand().captureScreenshot(finalPath);
        		
        		getCommand().waitForTargetPresent(AddProductPage_AddLocations);
        		if (getCommand().isTargetPresent(AddProductPage_AddLocations)){
        		getCommand().click(AddProductPage_AddLocations);
        		}
        		log("Selected locations : Pass",LogType.STEP);						
         ((IOSDriver)getCommand().driver).context("NATIVE_APP");
         getCommand().captureScreenshot(finalPath);
        }	
         catch(Exception e){
    			getCommand().captureScreenshot(finalPath1);
    			log("Selected locations :Fail",LogType.VERIFICATION_STEP);
    			Assert.assertTrue(false);
    		}
    		return this;
 }
 	   
	
        public  LocationsPage ProductSelect(String item,String string){
			String string1="Success";
			String string2="Issue";

			String finalPath=drivePath+string+string1+pathExtension;
			  String finalPath1=drivePath+string+string2+pathExtension;
		log("Selecting an item from location ",LogType.STEP);
		try{	 

			
			 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
				System.out.println("contxtname is "+contextNames1);
				
				 for (String contextName : contextNames1){
					 System.out.println("inside loop "+contextNames1);
				 }
			System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
			// final Target Product_Select= new Target("Product_Select","//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+item+"')",Target.XPATH);
			 final Target Product_Select= new Target("Product_Select","//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+item+"')]/ancestor::div[@class='mm-c-product-list__item mm-c-product__custom']//*[@class='mm-c-product-list__image']/a",Target.XPATH); 		
 //final Target Product_Select= new Target("Product_Select","//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+item+"')]/ancestor::div[@class='mm-c-product-list__item mm-c-product__custom']//*[@class='mm-c-product-list__image']",Target.XPATH);
		   
			// final Target Product_Select= new Target("Product_Select","//*[@class='mm-c-product-list__details-wrapper']//*[contains(text(),'"+item+"')]/ancestor::div[@class='mm-c-product-list__item mm-c-product__custom']",Target.XPATH);
		      System.out.println("target declaed");
			 getCommand().waitForTargetPresent(Product_Select);
		      System.out.println("got product");
			 getCommand().click(Product_Select);
			// getCommand().click(Product_Select);
			  // getCommand().doubleClick(Product_Select);
		       System.out.println("pd selected");
		       getCommand().waitForTargetPresent(ProductDetailsPage);
		       
		((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
			getCommand().captureScreenshot(finalPath);
			
			log("Selecting an item from location :Pass",LogType.VERIFICATION_STEP);
		  }
		catch(Exception e){
			getCommand().captureScreenshot(finalPath1);
			log("Selecting an item from location :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		 }

		return this;

		}
        public LocationsPage LocationDoneSelection(String string){
   	  		String string1="Success";
   	  		  String string2="Issue";

   	  	String finalPath=drivePath+string+string1+pathExtension;
   	  	String finalPath1=drivePath+string+string2+pathExtension;

   	  		try{
   	  			Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
   	  		    getCommand().captureScreenshot(finalPath);
   	  			 for (String contextName : contextNames){
   	  				 System.out.println(contextNames);
   	  			 }
   	  		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
   	  		
   	  			getCommand().waitForTargetPresent(LocationsDone);
   	  			if (getCommand().isTargetPresent(LocationsDone))
   	  			{
   	  				
   	  				getCommand().click(LocationsDone);
   	  				
   	  				((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
   	  				getCommand().captureScreenshot(finalPath);
   	  				log("tap on back :Pass",LogType.VERIFICATION_STEP);
   	  			}
   	  			
   	  		}
   	  		catch(Exception e)
   	  		{
   	  			log("tap on back :Fail",LogType.VERIFICATION_STEP);
   	  			getCommand().captureScreenshot(finalPath1);
   	  			Assert.assertTrue(false);
   	  		}
   	  		
   	  		return this;
   	  	}
        public LocationsPage selectMultipleItemsFromLocation1(String string) {
      	   	 String string1="Success";
      	   	  String string2="Issue";
      	   	  
      	     String finalPath=drivePath+string+string1+pathExtension;
      	     String finalPath1=drivePath+string+string2+pathExtension;
      	      try{

      	   		log(" Adding Item from Order Guide",LogType.STEP);
      	   		
      	   		
      	    
      	      	  Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
      	   			System.out.println("contxtname is "+contextNames);
      	   			
      	   			 for (String contextName : contextNames){
      	   				 System.out.println("inside loop "+contextNames);
      	   			 }
      	   		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));

    	      	getCommand().waitForTargetPresent(Locations_1stItemHeading);
    	      	
      	   		if(getCommand().isTargetPresent(Locations_1stItemSelect))
      	   		{
      	   			locationsNoOfElements1++;
      	   			LocationsItemName1_1=getCommand().getText(Locations_1stItemHeading);
      	   			getCommand().click(Locations_1stItemSelect);
      	   			System.out.println("Item heading:"+LocationsItemName1_1);
      	   			
      	   		}
      	   		if(getCommand().isTargetPresent(Locations_2ndItemHeading)){
      	   			
      	   			locationsNoOfElements1++;
      	   			LocationsItemName1_2=getCommand().getText(Locations_2ndItemHeading);
      	   			getCommand().click(Locations_2ndItemSelect);
      	   			System.out.println("Item heading:"+LocationsItemName1_2);
      	   		}
      	   			
      	   		if(getCommand().isTargetPresent(Locations_3rdItemHeading)){	
      	   			locationsNoOfElements1++;
      	   			LocationsItemName1_3=getCommand().getText(Locations_3rdItemHeading);
      	   			getCommand().click(Locations_3rdItemSelect);
      	   			System.out.println("Item heading:"+LocationsItemName1_3);
      	   		}
      	   			
      	   			
      	   			
      	   			((IOSDriver)getCommand().driver).context("NATIVE_APP");
      	   			getCommand().captureScreenshot(finalPath);
      	   			
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


        public LocationsPage selectMultipleItemsFromLocation2(String string) {
     	   	 String string1="Success";
     	   	  String string2="Issue";
     	   	  
     	     String finalPath=drivePath+string+string1+pathExtension;
     	     String finalPath1=drivePath+string+string2+pathExtension;
     	      try{

     	   		log(" Adding Item from Order Guide",LogType.STEP);
     	   		
     	   		
     	    
     	      	  Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
     	   			System.out.println("contxtname is "+contextNames);
     	   			
     	   			 for (String contextName : contextNames){
     	   				 System.out.println("inside loop "+contextNames);
     	   			 }
     	   		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));

   	      	getCommand().waitForTargetPresent(Locations_1stItemHeading);
   	      	
     	   		if(getCommand().isTargetPresent(Locations_1stItemHeading))
     	   		{
     	   			locationsNoOfElements1++;
     	   			LocationsItemName2_1=getCommand().getText(Locations_1stItemHeading);
     	   			getCommand().click(Locations_1stItemSelect);
     	   			System.out.println("Item heading:"+LocationsItemName2_1);
     	   			
     	   		}
     	   		if(getCommand().isTargetPresent(Locations_2ndItemHeading)){
     	   			
     	   			locationsNoOfElements1++;
     	   			LocationsItemName2_2=getCommand().getText(Locations_2ndItemHeading);
     	   			getCommand().click(Locations_2ndItemSelect);
     	   			System.out.println("Item heading:"+LocationsItemName2_2);
     	   		}
     	   			
     	   		if(getCommand().isTargetPresent(Locations_3rdItemHeading)){	
     	   			locationsNoOfElements1++;
     	   			LocationsItemName2_3=getCommand().getText(Locations_3rdItemHeading);
     	   			getCommand().click(Locations_3rdItemSelect);
     	   			System.out.println("Item heading:"+LocationsItemName2_3);
     	   		}
     	   			
     	   			
     	   			
     	   			((IOSDriver)getCommand().driver).context("NATIVE_APP");
     	   			getCommand().captureScreenshot(finalPath);
     	   			
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



        public  LocationsPage ItemVerifyOnLocation2(String location,String string){

    		String string1="Success";
    		String string2="Issue";	
    		  String finalPath=drivePath+string+string1+pathExtension;
    		  String finalPath1=drivePath+string+string2+pathExtension;
    		
    			log("locationItem verify ",LogType.STEP);
    			try{
    				 
    				 
    				 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    	    	  		System.out.println("contxtname is "+contextNames1);
    	    	  		
    	    	  		 for (String contextName : contextNames1){
    	    	  			 System.out.println("inside loop "+contextNames1);
    	    	  		 }
    	    	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    			 getCommand().waitForTargetPresent(Location1_FirstItemSelectedVerify);
    				boolean flag2_1 = getCommand().isTargetPresentAfterWait(Location2_FirstItemSelectedVerify, 3);
    				boolean flag2_2 = getCommand().isTargetPresentAfterWait(Location2_SecondItemSelectedVerify, 3);
    				boolean flag2_3 = getCommand().isTargetPresentAfterWait(Location2_ThirdItemSelectedVerify, 3);
    				
    			    System.out.println("Flag2: "+flag2_1+flag2_2+flag2_3);
    			   if(!(flag2_1||flag2_2||flag2_3)){ 
    				   throw new Exception();
    			   }    			     
    			   ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    					getCommand().captureScreenshot(finalPath);
    					log("Item verification done :Pass",LogType.VERIFICATION_STEP);
    				  }
    			catch(Exception e){
    				getCommand().captureScreenshot(finalPath1);
    				log("Item verification done  :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			 }

    			return this;
    			
    			}
        
        public  LocationsPage ItemVerifyOnLocation1(String string){

    		String string1="Success";
    		String string2="Issue";	
    		  String finalPath=drivePath+string+string1+pathExtension;
    		  String finalPath1=drivePath+string+string2+pathExtension;
    		
    			log("locationItem verify ",LogType.STEP);
    			try{
    				 
    				 
    				 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
    	    	  		System.out.println("contxtname is "+contextNames1);
    	    	  		
    	    	  		 for (String contextName : contextNames1){
    	    	  			 System.out.println("inside loop "+contextNames1);
    	    	  		 }
    	    	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
    			 getCommand().waitForTargetPresent(Location1_FirstItemSelectedVerify);
    				boolean flag1_1 = getCommand().isTargetPresentAfterWait(Location1_FirstItemSelectedVerify, 3);
    				boolean flag1_2 = getCommand().isTargetPresentAfterWait(Location1_SecondItemSelectedVerify, 3);
    				boolean flag1_3 = getCommand().isTargetPresentAfterWait(Location1_ThirdItemSelectedVerify, 3);
    				
    			    System.out.println("Flag1: "+flag1_1+flag1_2+flag1_3);
    			   if(!(flag1_1||flag1_2||flag1_3)){ 
    				   throw new Exception();
    			   }    			     
    			   ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
    					getCommand().captureScreenshot(finalPath);
    					log("Item verification done :Pass",LogType.VERIFICATION_STEP);
    				  }
    			catch(Exception e){
    				getCommand().captureScreenshot(finalPath1);
    				log("Item verification done  :Fail",LogType.VERIFICATION_STEP);
    				Assert.assertTrue(false);
    			 }

    			return this;
    			
    			}

         public LocationsPage AddCategory_AddProductDetailsPage(String string)
            {
            	
            	
            	  String string1="Success";
            	  String string2="Issue";
                 
                  String finalPath=drivePath+string+string1+pathExtension;
                String finalPath1=drivePath+string+string2+pathExtension;
             try{
             	
             	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
           		System.out.println("contxtname is "+contextNames1);
           		
           		 for (String contextName : contextNames1){
           			 System.out.println("inside loop "+contextNames1);
           		 }
           	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
             	
            		getCommand().captureScreenshot(finalPath);
            		
            		getCommand().waitForTargetPresent(AddProductPage_AddCategory);
            		if (getCommand().isTargetPresent(AddProductPage_AddCategory)){
            		getCommand().click(AddProductPage_AddCategory);
            		}
            		log("Selected add category : Pass",LogType.STEP);						
             ((IOSDriver)getCommand().driver).context("NATIVE_APP");
             getCommand().captureScreenshot(finalPath);
            }	
             catch(Exception e){
        			getCommand().captureScreenshot(finalPath1);
        			log("Selected add category :Fail",LogType.VERIFICATION_STEP);
        			Assert.assertTrue(false);
        		}
        		return this;
        }
        

         public  LocationsPage ProductQtyEnter(String qty,String string){
                 		String string1="Success";
                 		String string2="Issue";

                 		String finalPath=drivePath+string+string1+pathExtension;
                 		  String finalPath1=drivePath+string+string2+pathExtension;
                 	log("Quantity entering  ",LogType.STEP);
                 	try{	 

                 		
                 		 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
                 			System.out.println("contxtname is "+contextNames1);
                 			
                 			 for (String contextName : contextNames1){
                 				 System.out.println("inside loop "+contextNames1);
                 			 }
                 		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
                 		 
                 		getCommand().waitForTargetPresent(LocationItem1_QuantityInput).isTargetAvailable(LocationItem1_QuantityInput);
                 	//	getCommand().waitForTargetPresent(LocationItem2_QuantityInput).isTargetAvailable(LocationItem2_QuantityInput);
                  	     
               	        getCommand().sendKeys(LocationItem1_QuantityInput, qty);
               	   //   getCommand().sendKeys(LocationItem2_QuantityInput, qty1);
               	        System.out.println("qty enter");

                 	((IOSDriver)getCommand().driver).context("NATIVE_APP"); 

                 		getCommand().captureScreenshot(finalPath);
                 		
                 		log("Quantity entered in locations page :Pass",LogType.VERIFICATION_STEP);
                 	  }
                 	catch(Exception e){
                 		getCommand().captureScreenshot(finalPath1);
                 		log("Quantity entered in locations page:Fail",LogType.VERIFICATION_STEP);
                 		Assert.assertTrue(false);
                 	 }

                 	return this;

                 	}
                  public  LocationsPage UomEnterOZ(String uom,String string){
              		String string1="Success";
              		String string2="Issue";

              		String finalPath=drivePath+string+string1+pathExtension;
              		  String finalPath1=drivePath+string+string2+pathExtension;
              	log("Quantity entering  ",LogType.STEP);
              	try{	 

              		
              		 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
              			System.out.println("contxtname is "+contextNames1);
              			
              			 for (String contextName : contextNames1){
              				 System.out.println("inside loop "+contextNames1);
              			 }
              		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
              		 System.out.println("finding target");
         	        getCommand().waitForTargetPresent(UomUNITOZ);
         	        System.out.println("got target");
         	          getCommand().click(UomUNITOZ);
         	     //  Uomvalue=  getCommand().getText(UomUNITOZ);
         	        System.out.println("unit oz");
         	     //   System.out.println(Uomvalue);
         	        
              	((IOSDriver)getCommand().driver).context("NATIVE_APP"); 

              		getCommand().captureScreenshot(finalPath);
              		
              		log("Uom entered in locations page :Pass",LogType.VERIFICATION_STEP);
              	  }
              	catch(Exception e){
              		getCommand().captureScreenshot(finalPath1);
              		log("Uom entered in locations page:Fail",LogType.VERIFICATION_STEP);
              		Assert.assertTrue(false);
              	 }

              	return this;

              	}
               
                  
                  public  LocationsPage QuantityVerify(String qty,String string){
                 		String string1="Success";
                 		String string2="Issue";

                 		String finalPath=drivePath+string+string1+pathExtension;
                 		  String finalPath1=drivePath+string+string2+pathExtension;
                 	log("Quantity verification ",LogType.STEP);
                 	try{	 

                 		
                 		 Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
                 			System.out.println("contxtname is "+contextNames1);
                 			
                 			 for (String contextName : contextNames1){
                 				 System.out.println("inside loop "+contextNames1);
                 			 }
                 		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
                 	     String locationInputTextBox3="//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"+qty+"']";
                 	     final Target InputTextBoxCheck1 = new Target("InputTextBoxCheck1",locationInputTextBox3,Target.XPATH);

                 	   //  String locationInputTextBox4="//*[@class='mm-c-product-list']//*[@class='item-input mm-u-input-border mm-c-product-list__qty form-control'and @placeholder='"+qty1+"']";
                 	  //   final Target InputTextBoxCheck2 = new Target("InputTextBoxCheck2",locationInputTextBox4,Target.XPATH);

                 	     boolean flag = getCommand().isTargetPresentAfterWait(InputTextBoxCheck1, 5);
                 	    // boolean flag1 = getCommand().isTargetPresentAfterWait(InputTextBoxCheck2, 5);
                 	    System.out.println("Flag1: "+flag);
                 	  //  System.out.println("Flag1: "+flag1);
                  	   
                 	    if(!flag){
                 	 	   throw new Exception();
                 	    }
                 	 	
                 		
                 	((IOSDriver)getCommand().driver).context("NATIVE_APP"); 

                 		getCommand().captureScreenshot(finalPath);
                 		
                 		log("Quantities updated :Pass",LogType.VERIFICATION_STEP);
                 	  }
                 	catch(Exception e){
                 		getCommand().captureScreenshot(finalPath1);
                 		log("Quantities updated:Fail",LogType.VERIFICATION_STEP);
                 		Assert.assertTrue(false);
                 	 }

                 	return this;

                 	}
                  

}



