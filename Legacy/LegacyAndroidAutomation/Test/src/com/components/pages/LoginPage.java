
package com.components.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;





public class LoginPage extends SitePage{

	/* Defining the locators on the Page */ 
	public static final Target SyscoLogo_img = new Target("SyscoLogo_img","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.Image[1]",Target.XPATH);
	public static final Target  HomUserName_txt= new Target("HomUserName_txt","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	public static final Target HomPassword_txt= new Target("HomPassword_txt","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]",Target.XPATH);
																				//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]
	public static final Target HomLogin_btn = new Target("HomLogin_btn","Login",Target.NAME);
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]/android.widget.Button[1]
	public static final Target saveUsername_radioBtn = new Target("saveUsername_radioBtn","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[2]",Target.XPATH);
	public static final Target keepMeLoged_radioBtn = new Target("keepMeLoged_radioBtn","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[2]",Target.XPATH);
	
	
	public static final Target HomUsername_txtClass= new Target("HomPassword_txt","Username",Target.NAME);
	public static final Target  HomUserName_txt1= new Target("HomUserName_txt","//*[@id='username']",Target.XPATH);
	public static final Target  HomUserName_txt2= new Target("HomUserName_txt","input text",Target.CLASS);
	public static final Target  HomUserName_txt3= new Target("HomUserName_txt","//*[@class='input text']/label",Target.XPATH);
	
	public static final Target home_Username= new Target("home_Username","//*[@class='login-content']//*[@class='login-form']//*[@class='input text']//*[@id='username']",Target.XPATH);
	public static final Target home_LoginButton= new Target("home_LoginButton","//*[@class='login-content']//*[@class='login-form']//*[@class='button']//*[@class='login']",Target.XPATH);
	public static final Target home_Password= new Target("home_Password","//*[@class='login-content']//*[@class='login-form']//*[@class='input password']//*[@id='password']",Target.XPATH);
	
	  
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";

	public LoginPage(SiteRepository repository)
	{
		super(repository);
	}

	/* Functions on the Page are defined below */
	
	public LoginPage atLoginPage()
	{
		log("Opened Login Page ",LogType.STEP);
		return this;
	}
	
	public LoginPage verifyLoginPage() throws InterruptedException{
		log("Verify login Page Elements",LogType.SCENARIO);
		try{	
		
			//getCommand().waitFor(20);
			getCommand().waitForTargetPresent(SyscoLogo_img);
			//System.out.println("login page");
			log("Sysco logo  displayed:Pass",LogType.STEP);		
		}
		catch(Exception e)
		{
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"verifyLoginPage"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			
			log("Sysco logo  displayed:Fail",LogType.VERIFICATION_STEP);	
			
		}

		return this;
	}
	
	public LoginPage loginToApplication(String UserName,String Password)
	{

		
		try{
		
	
		 Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
		System.out.println(contextNames);
	 ((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
	 
		System.out.println( ((AndroidDriver)getCommand().driver).getContext());

			/*Set<String> contextNames = ((AndroidDriver)getCommand().driver).getContextHandles();
			for (String contextName : contextNames) {
				System.out.println(contextName);
				if (contextName.contains("WEBVIEW")){
					((AndroidDriver)getCommand().driver).context(contextName);
					Thread.sleep(1000);
				}
			}*/
		
		
	//System.out.println("inside login to application");
	getCommand().waitForTargetPresent(home_Username);
	
		if (getCommand().isTargetPresent(home_Username))
		{
			log("Enter User Name",LogType.STEP);	
			getCommand().sendKeys(home_Username, UserName);							
		}
		getCommand().waitForTargetPresent(home_Password);
		if (getCommand().isTargetPresent(home_Password))
		{
			log("Enter Password",LogType.STEP);	
			//System.out.println("password in if password loop");
			getCommand().click(home_Password);
			getCommand().clear(home_Password);
			getCommand().sendKeys(home_Password, Password);
		}
		//System.out.println("Username text box present");
	 
		getCommand().waitForTargetPresent(home_LoginButton);
		if (getCommand().isTargetPresent(home_LoginButton))
		{
			log("Click on Login  Button",LogType.STEP);	
			getCommand().click(home_LoginButton);
			log("User Logged In: Pass",LogType.STEP);	
		}		
		((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		//System.out.println( ((AndroidDriver)getCommand().driver).getContext());
		getCommand().waitFor(10);
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"loginToApplication"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "loginToApplication:Fail");
		}
		return this;
	}
	
	
	public LoginPage closeBrowser()
	{
	log("Close Browser",LogType.STEP);
	getCommand().closeCurrentWindow();
	return this;
	}
	
	
	public LoginPage loginToApplicationNative(String UserName,String Password)
	{
		//getCommand().waitFor(5);
		
		try{		  
	//System.out.println("inside login to application");
		getCommand().waitForTargetPresent(HomUsername_txtClass);
		getCommand().waitForTargetPresent(HomPassword_txt);
		
//		getCommand().captureScreenshot(finalPath);
		
		if (getCommand().isTargetPresent(HomPassword_txt))
		{
			log("Enter Password",LogType.STEP);	
			//System.out.println("password in if password loop");
			getCommand().click(HomPassword_txt);
			getCommand().clear(HomPassword_txt);
			getCommand().sendKeys(HomPassword_txt, Password);
		}
		//System.out.println("Username text box present");
	 
		if (getCommand().isTargetPresent(HomUsername_txtClass))
		{
			log("Enter User Name",LogType.STEP);	
			getCommand().sendKeys(HomUsername_txtClass, UserName);							
		}
		
		if (getCommand().isTargetPresent(HomLogin_btn))
		{
			log("Click on Login  Button",LogType.STEP);	
			getCommand().click(HomLogin_btn);
			log("User Logged In: Pass",LogType.STEP);	
		}	
		getCommand().waitFor(10);
		}
		catch (Exception e) {
			
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPath1=drivePath+"loginToApplicationNative"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "loginToApplication:Fail");
		}
		return this;
	}
}
	
	
	
	
