package com.components.pages;

import io.appium.java_client.ios.IOSDriver;

import java.util.Set;

import org.testng.Assert;


import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;
import com.components.pages.HomePage;

public class AccountsPage extends SitePage{

	//String drivePath="/Users/sujina_s/Desktop/Sysco/iOSScreenshot/";
	String pathExtension=".png";
	
	
	
	
	public static final Target Menu_Account = new Target("Menu_Accounts","//*[@id='accounts']",Target.XPATH);
    public static final Target Accounts_Page= new Target("Accounts_Page","//*[@class='navbar-brand']//*[contains(text(),'Accounts')]",Target.XPATH);
	 public static final Target Accounts_1Account = new Target("Accounts_1Account","//*[@id='list-item'][1]",Target.XPATH);
	 public static final Target Accounts_2Account = new Target("Accounts_2Account","//*[@id='list-item'][2]",Target.XPATH);
	 public static final Target Accounts_3Account = new Target("Accounts_3Account","//*[@id='list-item'][3]",Target.XPATH);
	 public static final Target Accounts_4Account = new Target("Accounts_4Account","//*[@id='list-item'][4]",Target.XPATH);
	 public static final Target Accounts_5Account = new Target("Accounts_5Account","//*[@id='list-item'][5]",Target.XPATH);
	 public static final Target Accounts_6Account = new Target("Accounts_6Account","//*[@id='list-item'][6]",Target.XPATH);
	 public static final Target InventoryToolsPage_Accountinfo = new Target("InventoryToolsPage_Accountinfo","//*[@id='mount']/div/div/div[2]/nav/div/div/span/h4/a",Target.XPATH);
	 public static final Target HamburgerMenu = new Target("HamburgerMenu","//*[@id='hamburger-nav']",Target.XPATH);
	 public static final Target InvToolsPage = new Target("InvToolsPage","//*[@class='navbar-brand']//*[contains(text(),'Inventory Tools')]",Target.XPATH);
	 public static final Target selectAcc = new Target("selectAcc","//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]",Target.XPATH);
	 public static final Target account_None= new Target("account_None","//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]",Target.XPATH);
		
		public String T_AccountInfo;
		public String F_AccountInfo;
		public String FfAccountInfo;
		public String SxAccountInfo;
		public String SecondAccountInfo; 
		public String FirstAccountInfo; 
	//public static final Target Menu_Account= new Target("Menu_Account","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[3]",Target.XPATH);
	
//	"//*[@id='accounts']/span[2]"
	// public static final Target Accounts_Page= new Target("Accounts_Page","//UIAStaticText[@label='Accounts']",Target.XPATH);
	 public static final Target FirstAccounts= new Target("FirstAccounts","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[2]",Target.XPATH);
	 //selctd 3rd accnt
	 public static final Target SecondAccounts= new Target("FirstAccounts","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[3]",Target.XPATH);
	//  public static final Target account_None= new Target("account_None","//UIALink[@label='Account: none ( select here )']",Target.XPATH);
	 //public static final Target accountID= new Target("accountID","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[15]",Target.XPATH);
	  public static final Target accountID= new Target("accountID","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[5]",Target.XPATH);
		
	// public static final Target HamburgerMenu = new Target("HamburgerMenu","//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[6]",Target.XPATH);
	// public static final Target InvToolsPage = new Target("InvToolsPage","//UIAStaticText[@label='Inventory Tools']",Target.XPATH);
			
	 public String firstAccount;
	 public String secondAccount;
	 
	 HomePage homepage=new HomePage(repository);

	  
	
	public AccountsPage(SiteRepository repository)
	{ 
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public AccountsPage atAccountsPage()
	{
		log("Opened Accounts Page ",LogType.STEP);
		return this;
	}
	public AccountsPage HamMenu_Accounts(String string)
	{
		 String string1="Success";
		  String string2="Issue";
		  String finalPath=LoginPage.drivePath+string+string1+pathExtension;
		  String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
		log("Tapping on Accounts from Hamburger menu",LogType.STEP);
		
		try{
			/*Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));*/
	  	
			getCommand().waitForTargetPresent(Menu_Account);
		    getCommand().click(Menu_Account);
		    System.out.println("Tapped accnt");
		
			
			getCommand().waitForTargetPresent(Accounts_Page);
		
		log("Account page displayed :Pass",LogType.STEP);	
		
		/* ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		 ////////getCommand().captureScreenshot(finalPath);
*/	}
	

	catch(Exception e)
	{
		//getCommand().captureScreenshot(finalPath1);
		log("Account page displayed :Fail",LogType.VERIFICATION_STEP);
		Assert.assertTrue(false);
	}
	return this;
	}
			
	/*public AccountsPage AccountSwitchFirstID(String string)
	{
		String string1="FirstAccountInfo";
		  String string2="Issue";
		  String finalPath=LoginPage.drivePath+string+string1+pathExtension;
	        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
			
		
		try{	
			Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
	  	
			if (getCommand().isTargetPresent(FirstAccounts))
			{
			getCommand().click(FirstAccounts);
			System.out.println("clicked frst accnt");
			
			getCommand().waitForTargetPresent(InvToolsPage);
			System.out.println("Inv tool page");
			getCommand().waitFor(5);
					if (getCommand().isTargetPresent(account_None))
					{
						System.out.println("No account ID displayed");
						log("Account switch  :Fail",LogType.VERIFICATION_STEP);	
						Assert.assertTrue(false);					
					}
					else{
						firstAccount=getCommand().getText(accountID);
						System.out.println("First Account ID "+firstAccount);
					
						 //////////getCommand().captureScreenshot(finalPath);
					log("First Account switched for user :Pass",LogType.VERIFICATION_STEP);
			}
			}}
		catch(Exception e)
		{
			  getCommand().captureScreenshot(finalPath1);
			log("First Account switched for user :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	
	public AccountsPage AccountSwitchSecondID(String string)
	{
		  	try{
			if (getCommand().isTargetPresent(SecondAccounts))
			{
			getCommand().click(SecondAccounts);
			
			getCommand().waitForTargetPresent(InvToolsPage);
			getCommand().waitFor(5);
				if (getCommand().isTargetPresent(account_None))
				{
					System.out.println("No account ID displayed");
					log("Account switch for user :Fail",LogType.VERIFICATION_STEP);	
					Assert.assertTrue(false);					
				}
				else{
					secondAccount=getCommand().getText(accountID);
					System.out.println("Second Account ID "+secondAccount);
					if(firstAccount!=secondAccount)
						log("Account switched for user :Pass",LogType.VERIFICATION_STEP);
					else
						Assert.assertTrue(false);
				}
			}
			
			else
				log("No accounts available to switch :Pass",LogType.VERIFICATION_STEP);	
			
			
		}
		
	
		catch(Exception e)
		{
			log("Account switched for user :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}*/
	public AccountsPage AccountSwitchFirstID(String string)
	{
		String string1="FirstAccountInfo";
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
	*/  	if (getCommand().isTargetPresent(Accounts_1Account))
			{
			getCommand().click(Accounts_1Account);
			System.out.println("clicked frst accnt");
			
			getCommand().waitForTargetPresent(InvToolsPage);
			System.out.println("Inv tool page");
			getCommand().waitFor(5);
					if (getCommand().isTargetPresent(account_None))
					{
						System.out.println("No account ID displayed");
						log("Account switch  :Fail",LogType.VERIFICATION_STEP);	
						Assert.assertTrue(false);					
					}
					else{
						FirstAccountInfo=getCommand().getText(InventoryToolsPage_Accountinfo);
						System.out.println("First Account ID "+FirstAccountInfo);
						/* ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
						 ////////getCommand().captureScreenshot(finalPath);*/
					log("First Account switched for user :Pass",LogType.VERIFICATION_STEP);
			}
			}
	  	}
		catch(Exception e)
		{
			 // getCommand().captureScreenshot(finalPath1);
			log("First Account switched for user :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	
	public AccountsPage AccountSwitchSecondID(String string)
	{
		String string1="FirstAccountInfo";
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
*/	  	if (getCommand().isTargetPresent(Accounts_2Account))
			{
			getCommand().click(Accounts_2Account);
			
			getCommand().waitForTargetPresent(InvToolsPage);
			getCommand().waitFor(5);
				if (getCommand().isTargetPresent(account_None))
				{
					System.out.println("No account ID displayed");
					log("Account switch for user :Fail",LogType.VERIFICATION_STEP);	
					Assert.assertTrue(false);					
				}
				else{
					SecondAccountInfo=getCommand().getText(InventoryToolsPage_Accountinfo);
					System.out.println("Second Account ID "+SecondAccountInfo);
					
				
					if(FirstAccountInfo!=SecondAccountInfo){
						/* ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
						////////getCommand().captureScreenshot(finalPath);
					*/	log("Account switched for user :Pass",LogType.VERIFICATION_STEP);
					}
					
					else{
						Assert.assertTrue(false);
					//	getCommand().captureScreenshot(finalPath1);
					}
					
					
				}
			}
			
			else
				log("No accounts available to switch :Pass",LogType.VERIFICATION_STEP);	
			
	  	// ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		}
		
	
		catch(Exception e)
		{
			//getCommand().captureScreenshot(finalPath1);
			log("Account switched for user :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	
	public AccountsPage Third_AccountSelection(String str1,String string)
	{
		log("Selecting 3 account from Accounts page",LogType.STEP);
		
		 
		  String string1="3AccountInfo";
		  String string2="Issue";
       
        String finalPath=LoginPage.drivePath+string+string1+pathExtension;
        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
		try
		{
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002")) ){
			/*Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
	*/	  getCommand().waitForTargetPresent(Accounts_3Account,10).click(Accounts_3Account);
		  if(getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20))
	         {
			  T_AccountInfo =getCommand().getText(InventoryToolsPage_Accountinfo);
			  System.out.println("3rd acount:"+T_AccountInfo);
	         }
		 /* ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		  //////getCommand().captureScreenshot(finalPath);
		*/  log("Got 3 account information :Pass",LogType.VERIFICATION_STEP);
		}
		}
       catch(Exception e){
    	     getCommand().captureScreenshot(finalPath1);
			log("Got 3 account information :Fail",LogType.VERIFICATION_STEP);
			
			Assert.assertTrue(false);
			
		}
		return this;
		
	}
	public AccountsPage Fourth_AccountSelection(String str1,String string)
	{
		log("Selecting 4 account from Accounts page",LogType.STEP);
		 
		  String string1="4AccountInfo";
		  String string2="Issue";
       
        String finalPath=LoginPage.drivePath+string+string1+pathExtension;
        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
		try
		{
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002")) ){
		/*	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));*/
		  getCommand().waitForTargetPresent(Accounts_4Account);
		  getCommand().click(Accounts_4Account);
		  System.out.println("cliked 4 acount");
		
		  getCommand().waitFor(5);
		
         if(getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20))
         {
		  F_AccountInfo =getCommand().getText(InventoryToolsPage_Accountinfo);
		  System.out.println("4 acount:"+F_AccountInfo);
         }
        /* ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		  ////////getCommand().captureScreenshot(finalPath);
		*/  
		 
		 
         log("Got 4 account information :Pass",LogType.VERIFICATION_STEP);
		}
		}
       catch(Exception e){
    	     //getCommand().captureScreenshot(finalPath1);
			log("Got 4 account information :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
			
		}
		return this;
		
	}
	public AccountsPage Fifth_AccountSelection(String str1,String string)
	{
		log("Selecting 5 account from Accounts page",LogType.STEP);
		  
		  String string1="5AccountInfo";
		  String string2="Issue";
       
        String finalPath=LoginPage.drivePath+string+string1+pathExtension;
        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
		try
		{
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002")) ){
		/*	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
*/		  getCommand().waitForTargetPresent(Accounts_5Account);
		  
		 
		  getCommand().click(Accounts_5Account);
		  System.out.println("cliked 5 acount");
		
		  getCommand().waitFor(5);
		
         if(getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20))
         {
		  FfAccountInfo =getCommand().getText(InventoryToolsPage_Accountinfo);
		  System.out.println("5 acount:"+FfAccountInfo);
         }
       /*  ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		  //////getCommand().captureScreenshot(finalPath);
	*/	
         log("Got 5 account information :Pass",LogType.VERIFICATION_STEP);
		}
		}
       catch(Exception e){
    	     getCommand().captureScreenshot(finalPath1);
			log("Got 5 account information :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
			
		}
		return this;
		
	}
	
	public AccountsPage Sixth_AccountSelection(String str1,String string)
	{
		log("Selecting 6 account from Accounts page",LogType.STEP);
		 
		  String string1="6AccountInfo";
		  String string2="Issue";
       
        String finalPath=LoginPage.drivePath+string+string1+pathExtension;
        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
		try
		{
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002")) ){
		/*	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));  getCommand().waitForTargetPresent(Accounts_6Account);
*/		  
		 
		  getCommand().click(Accounts_6Account);
		  System.out.println("cliked 6 acount");
		//  System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		  getCommand().waitFor(5);
		//  getCommand().waitForTargetPresent(InventoryToolsPage_Accountinfo);
     //     System.out.println("waiting for");
         if(getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20))
         {
		  SxAccountInfo =getCommand().getText(InventoryToolsPage_Accountinfo);
		  System.out.println("6 acount:"+SxAccountInfo);
         }
       /*  ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		  //////////getCommand().captureScreenshot(finalPath);
		*/
         log("Got 6 account information :Pass",LogType.VERIFICATION_STEP);
		}
		}
       catch(Exception e){
    	     getCommand().captureScreenshot(finalPath1);
			log("Got 6 account information :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
			
		}
		return this;
		
	}

	public AccountsPage ClickAccount(String string)
	{
		String string1="FirstAccountInfo";
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
*/	  	if (getCommand().isTargetPresent(selectAcc))
			{
			getCommand().click(selectAcc);
			System.out.println("clicked accnt");
			log("Clicked select account :Pass",LogType.VERIFICATION_STEP);
			}		
}
		catch(Exception e)
		{
			  getCommand().captureScreenshot(finalPath1);
			log("Clicked select account :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
		
	
	}
	public AccountsPage First_AccountSelection(String str1,String string)
	{
		log("Selecting 1st account from Accounts page",LogType.STEP);
		
		 
		  String string1="3AccountInfo";
		  String string2="Issue";
       
        String finalPath=LoginPage.drivePath+string+string1+pathExtension;
        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
		try
		{
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002")) ){
				
			
		/*	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
*/		  getCommand().waitForTargetPresent(Accounts_1Account,10).click(Accounts_1Account);
		  if(getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20))
	         {
			  T_AccountInfo =getCommand().getText(InventoryToolsPage_Accountinfo);
			  System.out.println("1st acount:"+T_AccountInfo);
	         }
		/*  ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		  ////////getCommand().captureScreenshot(finalPath);
		*/  log("Got 1st account information :Pass",LogType.VERIFICATION_STEP);
		}
		}
       
       catch(Exception e){
    	     getCommand().captureScreenshot(finalPath1);
			log("Got 1st account information :Fail",LogType.VERIFICATION_STEP);
			
			Assert.assertTrue(false);
			
		}
		return this;
		
	}
	public AccountsPage Second_AccountSelection(String str1,String string)
	{
		log("Selecting 1st account from Accounts page",LogType.STEP);
		
		 
		  String string1="3AccountInfo";
		  String string2="Issue";
       
        String finalPath=LoginPage.drivePath+string+string1+pathExtension;
        String finalPath1=LoginPage.drivePath+string+string2+pathExtension;
		try
		{
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002")) ){
		/*	Set<String> contextNames1 = ((IOSDriver)getCommand().driver).getContextHandles();
	  		System.out.println("contxtname is "+contextNames1);
	  		
	  		 for (String contextName : contextNames1){
	  			 System.out.println("inside loop "+contextNames1);
	  		 }
	  	System.out.println(((IOSDriver)getCommand().driver).context((String) contextNames1.toArray()[1]));
*/		  getCommand().waitForTargetPresent(Accounts_2Account,10).click(Accounts_2Account);
		  if(getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20))
	         {
			  T_AccountInfo =getCommand().getText(InventoryToolsPage_Accountinfo);
			  System.out.println("2nd acount:"+T_AccountInfo);
	         }
		/*  ((IOSDriver)getCommand().driver).context("NATIVE_APP"); 
		  //////////getCommand().captureScreenshot(finalPath);
	*/	  log("Got 2nd account information :Pass",LogType.VERIFICATION_STEP);
		}
		}
       catch(Exception e){
    	     getCommand().captureScreenshot(finalPath1);
			log("Got 2nd account information :Fail",LogType.VERIFICATION_STEP);
			
			Assert.assertTrue(false);
			
		}
		return this;
		
	}
}


