package com.components.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;


import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class VendorPage extends SitePage{
	
	
	String drivePath="/Users/sujina_s/Desktop/Sysco/iOSScreenshot/";
	String pathExtension=".png";
	
	
	  public static final Target ADD_Vendor= new Target("ADD_Vendor","//*[@id='add-nav']/a/i",Target.XPATH);	
	  public static final Target  ADD_VendorPage= new Target("ADD_VendorPage","//*[@class='navbar-brand']//*[contains(text(),'Add Supplier')]",Target.XPATH);
	  
	  public static final Target  ADD_VendorName= new Target("ADD_VendorName","//*[@id='name']",Target.XPATH);
	     public static final Target  ADD_VendorNumber= new Target("ADD_VendorNumber","//*[@id='phoneNumber']",Target.XPATH);
	     public static final Target  ADD_VendorAddress= new Target("ADD_VendorAddress","//*[@id='address']",Target.XPATH);
	     public static final Target  ADD_VendorContactInfo= new Target("ADD_VendorContactInfo","//*[@id='contactName']",Target.XPATH);
	     public static final Target  ADD_VendorEmail= new Target("ADD_VendorEmail","//*[@id='emailAddress']",Target.XPATH);
	     public static final Target  ADD_VendorNote= new Target("ADD_VendorNote","//*[@id='notes']",Target.XPATH);
	     public static final Target DoneWeb= new Target("Done","//*[@id='done-nav']/a/i",Target.XPATH);
	     public static final Target Done= new Target("Done","//UIAStaticText[@label='Done']",Target.XPATH);
	     public static final Target Back = new Target("Continue","//*[@id='back-nav']/a/i",Target.XPATH);
	 	 
	     public static final Target VendorsPage = new Target("VendorsPage","//UIAStaticText[@label='Suppliers']",Target.XPATH);
	     public static final Target  Vendor_firstVendorname= new Target("Vendor_firstVendorname","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]",Target.XPATH);
	 	
	     public static final Target  VendorDetails_name= new Target("VendorDetails_name","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]",Target.XPATH);
	     public static final Target  VendorDetails_number= new Target("VendorDetails_number","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]",Target.XPATH);
	     public static final Target  VendorDetails_address= new Target("VendorDetails_address","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[3]",Target.XPATH);
	     public static final Target  VendorDetails_contact= new Target("VendorDetails_contact","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[4]",Target.XPATH);
	     public static final Target  VendorDetails_email= new Target("VendorDetails_email","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[5]",Target.XPATH);
	     public static final Target  VendorDetails_note= new Target("VendorDetails_note","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[6]",Target.XPATH);
	     public static final Target  Edit= new Target("EditVendor","//*[@id='edit-nav']",Target.XPATH);
	     public String Name;
	     public static final Target  ADD_VendorDelete= new Target("ADD_VendorDelete","//UIAButton[@label='Delete Supplier']",Target.XPATH);
	      public static final Target  Delete_Yes= new Target("Delete_Yes","//UIAButton[@label='Yes, Delete']",Target.XPATH);
	       public static final Target  Delete_Cancel= new Target("Delete_Cancel","//UIAButton[@label='No, Cancel']",Target.XPATH);
	    
	    
	
    public VendorPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public VendorPage atVendorPage()
	{
		log("Opened Vendor Page ",LogType.STEP);
		return this;
	}
	public VendorPage verifySupplierPage(String string)
	{
		log("Verify the Supplier Page",LogType.STEP);
		
		getCommand().waitForTargetPresent(VendorsPage);
		return this;
	}
	public VendorPage Add_Supplier(String string)
	{
		  String string1="Success";
		  String string2="Issue";
	 
	  String finalPath=drivePath+string+string1+pathExtension;
	  String finalPath1=drivePath+string+string2+pathExtension;
	  log("Add vendor tap",LogType.STEP);
		try{
			System.out.println("inside supplier page");
			 Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
				
			 for (String contextName : contextNames){
				 System.out.println(contextNames);
			 }
		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
		
		
		getCommand().waitForTargetPresent(ADD_Vendor);
		
		if (getCommand().isTargetPresent(ADD_Vendor))
		{
			log("Click on ADD Vendor Button",LogType.STEP);	
			getCommand().click(ADD_Vendor);
			
		    System.out.println("inside add supplier page");
		    
			    
		}	
		
		  
	    getCommand().waitForTargetPresent(ADD_VendorPage);
	 
		if (getCommand().isTargetPresent(ADD_VendorPage))
		{
			  ((IOSDriver)getCommand().driver).context("NATIVE_APP");
			   getCommand().captureScreenshot(finalPath);
			log("In Add Vendor Page",LogType.STEP);	
			log("Add vendor button click :Pass",LogType.VERIFICATION_STEP);
			
		}
		 ((IOSDriver)getCommand().driver).context("NATIVE_APP");
		}
		
		catch(Exception e)
		{
			getCommand().captureScreenshot(finalPath1);
			log("Add vendor button click :Fail",LogType.VERIFICATION_STEP);	
			Assert.assertTrue(false);
		}
		
		return this;
	}
	
	public VendorPage AddSupplier_Details(String name,String number, String address, String contactinfo, String email, String note,String string){
		  String string1="Success";
		  String string2="Issue";
 
  String finalPath=drivePath+string+string1+pathExtension;
  String finalPath1=drivePath+string+string2+pathExtension;
		log("Adding vendor details",LogType.STEP);
		try{
			System.out.println("adding vdr details");
			
			 Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
				
 			 for (String contextName : contextNames){
 				 System.out.println(contextNames);
 			 }
System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));

			getCommand().waitForTargetPresent(ADD_VendorName);
			getCommand().click(ADD_VendorName);
			if (getCommand().isTargetPresent(ADD_VendorName))
			{
				log("Enter vendorname",LogType.STEP);
				
				getCommand().sendKeys(ADD_VendorName, name);
				
	
			}
			if (getCommand().isTargetPresent(ADD_VendorNumber))
			{
				getCommand().click(ADD_VendorNumber);
				log("Enter vendornumber",LogType.STEP);	
				getCommand().sendKeys(ADD_VendorNumber, number);
				
			}
			if (getCommand().isTargetPresent(ADD_VendorAddress))
			{
				getCommand().click(ADD_VendorAddress);
				log("Enter vendor address",LogType.STEP);	
				getCommand().sendKeys(ADD_VendorAddress, address);
				
			}
			if (getCommand().isTargetPresent(ADD_VendorContactInfo))
			{
				getCommand().click(ADD_VendorContactInfo);
				log("Enter vendor contact info",LogType.STEP);	
				getCommand().sendKeys(ADD_VendorContactInfo, contactinfo);
				
			}
			if (getCommand().isTargetPresent(ADD_VendorEmail))
			{
				getCommand().click(ADD_VendorEmail);
				log("Enter vendor email",LogType.STEP);	
				getCommand().sendKeys(ADD_VendorEmail, email);
				
			}
			
			if (getCommand().isTargetPresent(ADD_VendorNote))
			{
				getCommand().click(ADD_VendorNote);
				log("Enter vendor note",LogType.STEP);	
				getCommand().sendKeys(ADD_VendorNote, note);
				getCommand().waitFor(5);
					
			}
			
			 ((IOSDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			log("Vendor details entered  :Pass",LogType.VERIFICATION_STEP);	 
			
		}
		catch(Exception e)
		{
			getCommand().captureScreenshot(finalPath1);
			log("Vendor details entered  :Fail",LogType.VERIFICATION_STEP);	
			Assert.assertTrue(false);
		}
		
		return this;
		
	}
	
	public VendorPage TapOnDone(String string){
       	String string1="Success";
       	  String string2="Issue";

       String finalPath=drivePath+string+string1+pathExtension;
       String finalPath1=drivePath+string+string2+pathExtension;

       	try{
       	 /*Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
			
			 for (String contextName : contextNames){
				 System.out.println(contextNames);
			 }
System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));*/
       			getCommand().waitForTargetPresent(Done);
       		if (getCommand().isTargetPresent(Done))
       		{
       			
       			getCommand().click(Done);
       			System.out.println("done clicked");
       			log("Tapped on done:Pass",LogType.VERIFICATION_STEP);
       				getCommand().captureScreenshot(finalPath);
       		}
    //   	 ((IOSDriver)getCommand().driver).context("NATIVE_APP");
       	}
       	catch(Exception e)
       	{
       		log("Tapped on done :Fail",LogType.VERIFICATION_STEP);
       		getCommand().captureScreenshot(finalPath1);
       		Assert.assertTrue(false);
       	}
       	
       	return this;
       }
	public VendorPage TapOnBack(String string){
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
				System.out.println("back clicked");
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
	public VendorPage VendorSelect(String name,String string)
	{
		
		  String pathExtension=".png";
		  String string1="Success";
		  String string2="Issue";
		  
	    String finalPath=drivePath+string+string1+pathExtension;
	    String finalPath1=drivePath+string+string2+pathExtension;
	    
		log("Selecting vendor",LogType.STEP);
	try{
		
		String vendorName=name;
		System.out.println(vendorName);
		
		 Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
			
		 for (String contextName : contextNames){
			 System.out.println(contextNames);
		 }
	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
getCommand().waitFor(2);
	  // final Target  VD_Vendorname= new Target("VD_Vendorname","//*[@id='list-item']//span[contains(text(),'{0}')]",Target.XPATH);
		 //getCommand().click(VD_Vendorname.format(vendorName));
		final Target  VD_Vendorname= new Target("VD_Vendorname","//*[@id='list-item']//*[contains(text(),'"+vendorName+"')]",Target.XPATH);   
		
		//$x("//*[@id='list-item']//*[contains(text(),'no location')]")
		
		getCommand().click(VD_Vendorname); 
	      
		  ((IOSDriver)getCommand().driver).context("NATIVE_APP");
		
	  
	       getCommand().captureScreenshot(finalPath);
	  
			log("Vendor is selected for item :Pass",LogType.VERIFICATION_STEP);						
		}
		
		
		
		catch(Exception e){
			 getCommand().captureScreenshot(finalPath1); 
			log("Vendor is selected for item   :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	}
	public VendorPage SuppliersList(String vendorname,String string){
		log("Vendor List",LogType.STEP);
		String string1="Success";
		  String string2="Issue";

String finalPath=drivePath+string+string1+pathExtension;
String finalPath1=drivePath+string+string2+pathExtension;

		try{
		
			String y=vendorname;
	
			System.out.println(y);
			System.out.println("Vendors Page source ::\n" +getCommand().getDriver().getPageSource());
			boolean c=getCommand().getDriver().getPageSource().contains(y);
			System.out.println("Vendors Page contains"+c);
			
			getCommand().captureScreenshot(finalPath);
		if(c==true){
			
			log("Added  vendor is listed :Pass",LogType.VERIFICATION_STEP);		
		}
		else{	
			log("Added  vendor is listed :Fail",LogType.VERIFICATION_STEP);	
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
			log("Added new vendor is listed   :Fail",LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
		}
		
		return this;
	}
public VendorPage Supplier_List(String string){
		
		log("Verifying supplier list page ",LogType.STEP);
		try{
			System.out.println("inside vendorlist");
			/* getCommand().waitForTargetPresent(Vendor_firstVendorname);
			 log("vendor name displayed",LogType.STEP);	
				
			 getCommand().waitForTargetPresent(Vendor_firstVendorphone);
			 log("phonenum icon is displayed",LogType.STEP);
			 
			 getCommand().waitForTargetPresent(Vendor_firstVendorinfo);
			 log("vendor information button is displayed",LogType.STEP);*/
			
			getCommand().waitForTargetPresent(Vendor_firstVendorname);
			
			Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
			
			 for (String contextName : contextNames){
				 System.out.println(contextNames);
			 }
		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
		
			getCommand().isTargetPresent(ADD_Vendor);
			getCommand().isTargetPresent(Back);
			
			 ((IOSDriver)getCommand().driver).context("NATIVE_APP");
			 
			 log("Vendor list is displayed :Pass",LogType.VERIFICATION_STEP);	
				
		}
		
		catch(Exception e)
		{
			log("Vendor list is displayed :Fail",LogType.VERIFICATION_STEP);	
			Assert.assertTrue(false);
		}
		
		return this;
	}
public VendorPage ViewVendorDetails(String string){
	String string1="Success";
	  String string2="Issue";

String finalPath=drivePath+string+string1+pathExtension;
String finalPath1=drivePath+string+string2+pathExtension;
		try{
			
			getCommand().waitForTargetPresent(Vendor_firstVendorname);
			getCommand().click(Vendor_firstVendorname);
			
		
			
			Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
			
			 for (String contextName : contextNames){
				 System.out.println(contextNames);
			 }
		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
		getCommand().waitForTargetPresent(Edit);
		getCommand().click(Edit);
		
	      ((IOSDriver)getCommand().driver).context("NATIVE_APP");
			System.out.println("checking vendor details");
			
			
			
			if (getCommand().isTargetPresent(VendorDetails_name)){
				
			 Name=getCommand().getText(VendorDetails_name);
			System.out.println(getCommand().getText(VendorDetails_name));
			
			if(Name!=null){
				System.out.println(Name);
				log("view vendor name   :Pass",LogType.VERIFICATION_STEP);	
			    }
			}
			
			
			if (getCommand().isTargetPresent(VendorDetails_number)){
				
				String Num=getCommand().getText(VendorDetails_number);
				if(Num!=null){
					System.out.println(Num);
					log("view vendor no   :Pass",LogType.VERIFICATION_STEP);	
				    }
				}
			
	       if (getCommand().isTargetPresent(VendorDetails_address)){
				
				String Address=getCommand().getText(VendorDetails_address);
				if(Address!=null){
					System.out.println(Address);
					log("view vendor Address   :Pass",LogType.VERIFICATION_STEP);	
				    }
				}

	       if (getCommand().isTargetPresent(VendorDetails_contact)){
				
				String Contact=getCommand().getText(VendorDetails_contact);
				if(Contact!=null){
					System.out.println(Contact);
					log("view vendor Contact   :Pass",LogType.VERIFICATION_STEP);	
				    }
				}
	       
	       if (getCommand().isTargetPresent(VendorDetails_email)){
				
				String Email=getCommand().getText(VendorDetails_email);
				if(Email!=null){
					System.out.println(Email);
					log("view vendor Email   :Pass",LogType.VERIFICATION_STEP);	
				    }
				}
	       
	       if (getCommand().isTargetPresent(VendorDetails_note)){
				
				String Note=getCommand().getText(VendorDetails_note);
				if(Note!=null){
					System.out.println(Note);
					log("view vendor Note  :Pass",LogType.VERIFICATION_STEP);	
				    }
				}
	       getCommand().captureScreenshot(finalPath); 
	
			log("view vendor detail   :Pass",LogType.VERIFICATION_STEP);	
		}
		catch(Exception e)
		{
			 getCommand().captureScreenshot(finalPath1); 
			log("view vendor detail  :Fail",LogType.VERIFICATION_STEP);	
		Assert.assertTrue(false);
		}
		
		return this;
	}
public VendorPage AddedVendorDetails(String vendorname,String number, String address, String contactinfo, String email, String note,String string){
	log("Checking vendor details",LogType.STEP);
	 String string1="Success";
	  String string2="Issue";
     
      String finalPath=drivePath+string+string1+pathExtension;
    String finalPath1=drivePath+string+string2+pathExtension;
	try{
	       String vendorName=vendorname;
	       String vendorPhoneNum=number;
	       String vendorAddress=address;
	       String vendorContactInfo=contactinfo;
	       String vendorEmail=email;
	       String vendorNote=note;
	  
	       Set<String> contextNames = ((IOSDriver)getCommand().driver).getContextHandles();
			
			 for (String contextName : contextNames){
				 System.out.println(contextNames);
			 }
		System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames.toArray()[1]));
		  
	       final Target  VD_Vendorname= new Target("VD_Vendorname","//*[@id='list-item']//span[contains(text(),'{0}')]",Target.XPATH);
	       
	    //   final Target  VD_Vendorname= new Target("VD_Vendorname","//*[@id='list-item' and contains(text(),'{0}')]"",Target.XPATH);
	       
	      // $x("//*[@id='list-item' and contains(text(),'T2')]")
	       getCommand().click(VD_Vendorname.format(vendorName));
	         
	       
	       ((IOSDriver)getCommand().driver).context("NATIVE_APP");
	       
	       
	       
	  final Target  VD_Vendorname1= new Target("VD_Vendorname1", vendorName,Target.NAME);
	  getCommand().waitForTargetPresent(VD_Vendorname1);
	       
	 
	 if (getCommand().isTargetPresent(VD_Vendorname1))
		{
		 
			getCommand().waitForTargetPresent(VD_Vendorname1);
			System.out.println("vendor name "+VD_Vendorname1);
			log("vendor name is displayed on Vendor details page :Pass",LogType.VERIFICATION_STEP);	
			
	  final Target  VD_VendorPhone= new Target("VD_VendorPhone", vendorPhoneNum,Target.NAME);
	  getCommand().waitForTargetPresent(VD_VendorPhone); 
	  System.out.println("vendor phone "+VD_VendorPhone);
	  log("vendor phonenumber is displayed on Vendor details page :Pass",LogType.VERIFICATION_STEP);	
	
	  final Target  VD_VendorAddress= new Target("VD_VendorAddress", vendorAddress,Target.NAME);
	  getCommand().waitForTargetPresent(VD_VendorAddress);
	  System.out.println("vendor address "+VD_VendorAddress);
	  log("vendor address is displayed on Vendor details page :Pass",LogType.VERIFICATION_STEP);	
		
	  final Target  VD_VendorContactInfo= new Target("VD_VendorContactInfo", vendorContactInfo,Target.NAME);
	  getCommand().waitForTargetPresent(VD_VendorContactInfo);
	  System.out.println("vendor contact info "+VD_VendorContactInfo);
	  log("vendor contact info is displayed on Vendor details page :Pass",LogType.VERIFICATION_STEP);	
	
	  final Target  VD_VendorEmail= new Target("VD_VendorEmail", vendorEmail,Target.NAME);
	  getCommand().waitForTargetPresent(VD_VendorEmail);
	  System.out.println("vendor email "+VD_VendorEmail);
	  log("vendor email address is displayed on Vendor details page :Pass",LogType.VERIFICATION_STEP);	
	  
	  final Target  VD_VendorNote= new Target("VD_VendorNote", vendorNote,Target.NAME);
	  getCommand().waitForTargetPresent(VD_VendorNote);
	  System.out.println("vendor note "+VD_VendorNote);
	  log("note is displayed on Vendor details page :Pass",LogType.VERIFICATION_STEP);	
	  
	  getCommand().captureScreenshot(finalPath); 	
	  log("vendor details displayed   :Pass",LogType.VERIFICATION_STEP);	
		}
	 
	}
	catch(Exception e)
	{
		getCommand().captureScreenshot(finalPath1); 	
		log("vendor details displayed   :Fail",LogType.VERIFICATION_STEP);	
		Assert.assertTrue(false);
	}
	
	return this;
}
public VendorPage DeleteVendor(String vendorname,String string){
	
	log("Delete a vendor",LogType.STEP);
	String string1="Success";
	  String string2="Issue";
   
    String finalPath=drivePath+string+string1+pathExtension;
  String finalPath1=drivePath+string+string2+pathExtension;
	try{
		
		String Vendor_name=vendorname;
    
		System.out.println("inside delete");
		
		//deleting first vendor TBR
		getCommand().waitForTargetPresent(Vendor_firstVendorname);
		getCommand().click(Vendor_firstVendorname);
			//TBR
		
		getCommand().waitForTargetPresent(ADD_VendorDelete);
		if (getCommand().isTargetPresent(ADD_VendorDelete))
		{
			
		   getCommand().click(ADD_VendorDelete);
		  
  System.out.println("delete clik");
		}
		
		getCommand().waitForTargetPresent(Delete_Yes);
		if (getCommand().isTargetPresent(Delete_Yes))
		{
			
		   getCommand().click(Delete_Yes);
			System.out.println("deleting");
		}
		
		
		getCommand().waitForTargetPresent(VendorsPage);
		System.out.println("venders pgr");
		/*System.out.println(Name);
		//System.out.println("Vendors Page source ::\n" +getCommand().getDriver().getPageSource());
					boolean c=getCommand().getDriver().getPageSource().contains(Name);
					System.out.println(Name);
					System.out.println("Vendors Page contains"+c);

			if(c==true){
					
					log("Deleting vender :Fail",LogType.VERIFICATION_STEP);	
					Assert.assertTrue(false);
				}
				else{	
					log("Deleting vender :Pass",LogType.VERIFICATION_STEP);	
					
				}
		
		*/
		log("Deleting vender :Pass",LogType.VERIFICATION_STEP);
		}
		
		

	catch(Exception e){
		log("Deleting vender :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	
	}
	
	return this;	
}
}

