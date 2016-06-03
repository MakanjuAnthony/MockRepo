
package com.components.pages;

import java.util.Set;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;

public class HomePage extends SitePage {

	/* Defining the locators on the Page */

	// ------------------------Elements in Home Page-------------------

	public static final Target syscoLogo_home = new Target("syscoLogoHome", "", Target.XPATH);

	//public static final Target HambergerMenu_home = new Target("HambergerMenu_home","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[3]/android.view.View[1]/android.view.View[1]",Target.XPATH);
			// android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[3]/android.view.View[1]/android.view.View[1]
	public static final Target HambergerMenu_home = new Target("HambergerMenu_home","//*[@class='app-header']//*[@class='header-nav']//*[@class='menu']//*[@class='icon']",Target.XPATH);
	
	public static final Target Home_Category = new Target("Home_Category","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement categories level-0']",Target.XPATH);
	
	public static final Target Home_Brand = new Target("Home_Brand","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement brand level-0']",Target.XPATH);
	
	public static final Target Home_Nutrition = new Target("Home_Nutrition","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement nutrition level-0']",Target.XPATH);
	
	public static final Target Home_Size = new Target("Home_Size","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement size level-0']",Target.XPATH);
	
	public static final Target Home_Subcategory = new Target("Home_Subcategory","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement categories level-0 active']//*[@id='refinement-Category-0']//*[@data-nvalue='2000000']",Target.XPATH);
	
	public static final Target Home_Brand_Select = new Target("Home_Brand_Select","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement brand level-0 active']//*[@id='refinement-Brand-0']//*[@data-nvalue='4294966874']",Target.XPATH);
	
	public static final Target Home_Nutrition_Select = new Target("Home_Nutrition_Select","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement nutrition level-0 active']//*[@id='refinement-Nutrition-0']//*[@data-nvalue='8']",Target.XPATH);
	
	public static final Target Home_Size_Select = new Target("Home_Size_Select","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement size level-0 active']//*[@id='refinement-Size-0']//*[@data-nvalue='4294965382']",Target.XPATH);
	
	public static final Target Home_Category_Search = new Target("Home_Category_Search","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='dim-search categories-search']//*[@class='search selected input']",Target.XPATH);
	
	public static final Target Home_Brand_Search = new Target("Home_Brand_Search","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='dim-search brand-search']//*[@class='search selected input']",Target.XPATH);
	
	public static final Target Home_Size_Search = new Target("Home_Size_Search","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='dim-search size-search']//*[@class='search selected input']",Target.XPATH);
	
	public static final Target Category_Search = new Target("Category_Search","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement categories level-0 active']//*[@id='refinement-Category-0']//*[@data-nvalue='0+2050000']",Target.XPATH);
	
	public static final Target Brand_Search = new Target("Brand_Search","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement brand level-0 active']//*[@id='refinement-Brand-0']//*[@data-nvalue='0+4294966874']",Target.XPATH);
	
	public static final Target Size_Search = new Target("Size_Search","//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement size level-0 active']//*[@id='refinement-Size-0']//*[@data-nvalue='0+4294965382']",Target.XPATH);
	
	// public static final Target HambergerMenu_home=new
	// Target("HambergerMenu_home","",Target.NAME);

	public static final Target Cart_home = new Target("Cart_home",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",
			Target.XPATH);
			// public static final Target Cart_home=new
			// Target("Cart_home","",Target.NAME);

	// public static final Target SearchCatalog_home=new
	// Target("SearchCatalog_home","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[1]/android.widget.EditText[1]",Target.XPATH);
	// android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.view.View[1]/android.widget.EditText[1]
	public static final Target SearchCatalog_home = new Target("SearchCatalog_home","//*[@class='app-search']//*[@id='search-form']//*[@id='search']", Target.XPATH);
	public static final Target SearchCatalog_hamburger = new Target("SearchCatalog_hamburger","//*[@class='app-search']//*[@class='input']//*[@class='search selected']", Target.XPATH);
	
	public static final Target SearchCatalog_homeSubmit = new Target("SearchCatalog_homeSubmit","//*[@class='app-search']//*[@id='search-form']//*[@class='submit-search']", Target.XPATH);
	//public static final Target SearchCatalog_homeSubmit = new Target("SearchCatalog_homeSubmit","//*[@class='app-search']//*[@class='input']//*[@class='button']//*[@class='submit-search']//*[@class='icon']", Target.XPATH);
	
	public static final Target OrderGuide_home = new Target("OrderGuide_home",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]",
			Target.XPATH);
	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[3]/android.view.View[1]
	// public static final Target OrderGuide_home=new
	// Target("OrderGuide_home"," Order Guide  ",Target.NAME);
	// public static final Target OrderGuide_homeTest=new
	// Target("OrderGuide_home"," Order Guide ",Target.LINKTEXT);

	public static final Target MySyscoTruck_home = new Target("MySyscoTruck_home",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[6]",
			Target.XPATH);
	// public static final Target MySyscoTruck_home=new
	// Target("MySyscoTruck_home","My Sysco Truck",Target.NAME);

	public static final Target NoOrdersOutForDelivery_home = new Target("NoOrdersOutForDelivery_home",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[8]",
			Target.XPATH);
	// public static final Target NoOrdersOutForDelivery_home=new
	// Target("NoOrdersOutForDelivery_home","No orders out for
	// delivery",Target.NAME);

	//public static final Target CreateNewOrder_home = new Target("CreateNewOrder_home","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[11]",Target.XPATH);
	public static final Target CreateNewOrder_home = new Target("CreateNewOrder_home","//*[@class='call-out order']//*[@class='create-order-call-out']//*[@class='body']",Target.XPATH);
	// public static final Target CreateNewOrder_home=new
	// Target("CreateNewOrder_home","Create new order",Target.NAME);

	public static final Target Open_home = new Target("Open_home","//*[@class='header OPEN']//*[@href='/orders/OPEN/none']",Target.XPATH);
	// public static final Target Open_home = new
	// Target("Open_home","Open",Target.NAME);

	public static final Target Submitted_home = new Target("Submitted_home","//*[@class='header SUBMITTED']//*[@href='/orders/SUBMITTED/none']",Target.XPATH);
	// public static final Target Submitted_home = new
	// Target("Submitted_home","Submitted",Target.NAME);

	public static final Target Historical_home = new Target("Historical_home","//*[@class='header NON_OPEN']//*[@href='/orders/NON_OPEN/none']",Target.XPATH);
			// public static final Target Historical_home = new
			// Target("Historical_home","Historical",Target.NAME);

	// -------------------------Elemments in Hamburger Menu-----------------
	public static final Target Home_hamburger = new Target("Home_hamburger",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[1]/android.view.View[1]",
			Target.XPATH);
	// public static final Target Home_hamburger = new
	// Target("Home_hamburger","Home",Target.NAME);

	public static final Target MySyscoTruck_hamburger = new Target("MySyscoTruck_hamburger", "", Target.XPATH);
	// public static final Target MySyscoTruck_hamburger = new
	// Target("MySyscoTruck_hamburger"," My Sysco Truck
	// //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[2]/android.view.View[1]",Target.NAME);

	//public static final Target OrderGuide_hamburger = new Target("OrderGuide_hamburger","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[3]/android.view.View[1]",Target.XPATH);
	public static final Target OrderGuide_hamburger = new Target("OrderGuide_hamburger","//*[@class='app-nav']//*[@class='primary-nav']//*[@href='/guide']//*[@class='icon spin-target']",Target.XPATH);
	
	// public static final Target OrderGuide_hamburger = new
	// Target("OrderGuide_hamburger","  Order Guide",Target.NAME);

	//public static final Target Lists_hamburger = new Target("Lists_hamburger","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[4]/android.view.View[1]",Target.XPATH);
	public static final Target Lists_hamburger = new Target("Lists_hamburger","//*[@class='app-nav']//*[@class='primary-nav']//*[@href='/orders-home/M']//*[@class='icon spin-target']",Target.XPATH);
	//public static final Target Search_hamburger = new Target("Lists_hamburger","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[4]/android.view.View[1]",Target.XPATH);
	public static final Target Search_hamburger = new Target("Lists_hamburger","//*[@class='app-nav']//*[@class='primary-nav']//*[@href='#']//*[@class='icon spin-target']",Target.XPATH);
	// public static final Target Lists_hamburger = new
	// Target("Lists_hamburger","  Search / Lists",Target.NAME);

	public static final Target ProductCategories_hamburger = new Target("ProductCategories_hamburger",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[5]/android.view.View[1]",
			Target.XPATH);
	// public static final Target ProductCategories_hamburger = new
	// Target("ProductCategories_hamburger"," Product Categories",Target.NAME);
	
	public static final Target Inventory_hamburger = new Target("Lists_hamburger","//*[@class='app-nav']//*[@class='primary-nav']//*[@href='/products/inventory']//*[@class='icon spin-target']",Target.XPATH);


	//public static final Target Logout_hamburger = new Target("Logout_hamburger","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[6]/android.view.View[1]",Target.XPATH);
	public static final Target Logout_hamburger = new Target("Logout_hamburger","//*[@class='app-nav']//*[@class='secondary-nav']//*[@href='/logout']//*[@class='icon spin-target']",Target.XPATH);
	
	
	// public static final Target Logout_hamburger = new
	// Target("Logout_hamburger","Logout",Target.NAME);

	public static final Target Open_Home = new Target("OpenList_Home", "Open", Target.NAME);
	public static final Target Submitted_Home = new Target("SubmittedList_Home", "Submitted", Target.NAME);

	// -----------------Apr 12 ----------- //

	// ---- Home page elemts while login as Multiple User---------
	
	
	
	public static final Target Open_MA = new Target("Open_MA","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[12]",Target.XPATH);
	// public static final Target Open_MA = new
	// Target("Open_MA","Open",Target.NAME);

	
	//public static final Target Pending_MA = new Target("Pending_MA","//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[15]",Target.XPATH);
	public static final Target Pending_MA = new Target("Pending_MA","//*[@class='scroll-area']//*[@class='orders fadein']//*[@class='header PENDING_APPROVAL']//*[@href='/orders/PENDING_APPROVAL/none']//*[@class='icon spin-target']",Target.XPATH);
																	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[15]
																	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[15]
	// public static final Target Pending_MA = new
	// Target("Pending_MA","Pending",Target.NAME);
	
	
	

	public static final Target Submitted_MA = new Target("Submitted_MA",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[13]",
			Target.XPATH);
	// public static final Target Submitted_MA = new
	// Target("Submitted_MA","Submitted",Target.NAME);

	public static final Target Historical_MA = new Target("Historical_MA",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[14]",
			Target.XPATH);
			// public static final Target Historical_MA = new
			// Target("Historical_MA","Submitted",Target.NAME);

	// --------------Home page elemts while login as MNormal User ---------
	public static final Target Open_NU = new Target("Open_NU","//*[@class='header OPEN']//*[@href='/orders/OPEN/none']",Target.XPATH);
	// public static final Target Open_MA = new
	// Target("Open_MA","Open",Target.NAME);

	public static final Target Submitted_NU = new Target("Submitted_NU","//*[@class='header OPEN']//*[@href='/orders/SUBMITTED/none']",Target.XPATH);
	// public static final Target Submitted_NU = new
	// Target("Submitted_NU","Open",Target.NAME);

	public static final Target Cart_homeWeb = new Target("Cart_home",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[2]",
			Target.XPATH);
	
	String drivePath="/Users/jithya.joseph/Desktop/Screenshots_Legacy/";
	String pathExtension=".png";

	public HomePage(SiteRepository repository) {
		super(repository);
	}

	
	
	/* Functions on the Page are defined below */

	public HomePage atHomePage() {
		log("At Home Page", LogType.STEP);
		return this;

	}

	public HomePage verifyHomePage() {
		log("Verify the Home Page Logo", LogType.STEP);
		return this;
	}

	public HomePage createNewOrder() {

		try{
			((AndroidDriver) getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(10);
		log("at createNewOrder", LogType.STEP);
		getCommand().waitForTargetPresent(CreateNewOrder_home);
		
		
		if (getCommand().isTargetPresent(CreateNewOrder_home)) 
		{
			log("Create new Order Page: Pass", LogType.STEP);
			getCommand().click(CreateNewOrder_home);
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"createNewOrder"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "createNewOrder:Fail");
		}
		return this;
	}
	public HomePage createNewOrderWithScreenshot(String string) {
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver) getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(10);
		log("at createNewOrder", LogType.STEP);
		getCommand().waitForTargetPresent(CreateNewOrder_home);
		
		//getCommand().captureScreenshot(finalPath);
		if (getCommand().isTargetPresent(CreateNewOrder_home)) 
		{
			log("Create new Order Page: Pass", LogType.STEP);
			getCommand().click(CreateNewOrder_home);
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");

		}
		}
		catch (Exception e) {
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "createNewOrder:Fail");
		}
		return this;
	}
	public HomePage OrderGuide_Home() {
		try{
		getCommand().waitFor(10);
		System.out.println("In OrderGuide From Home Page");
		log("at OrderGuide_Home", LogType.STEP);
		getCommand().waitForTargetPresent(OrderGuide_home);
		if (getCommand().isTargetPresent(OrderGuide_home)) {
			getCommand().waitFor(10);
			System.out.println("Waiting for OG");
			getCommand().click(OrderGuide_home);
			getCommand().waitFor(5);
			System.out.println("Waiting After Click for OG");
			System.out.println("clicked");
			log("Clicked on OrderGuide in home Page: Pass", LogType.STEP);
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"OrderGuide_Home"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "OrderGuide_Home:Fail");
		}
		return this;
	}

	public HomePage searchKeyword_Home(String keyword, String string) {
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
try{
		Set<String> contextNames = ((AndroidDriver) getCommand().driver).getContextHandles();
		System.out.println(contextNames);
		((AndroidDriver) getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		System.out.println(((AndroidDriver) getCommand().driver).getContext());
	
/*try{
	Set<String> contextNames = ((AndroidDriver) getCommand().driver).getContextHandles();
	System.out.println(contextNames);
	for(String contextName: contextNames){
		System.out.println(contextNames);
	
	((AndroidDriver) getCommand().driver).context((String) contextNames.toArray()[1]);
	System.out.println(((AndroidDriver) getCommand().driver).getContext());
}*/
	
/*}
catch (Exception e) {
	Set<String> contextNames = ((AndroidDriver) getCommand().driver).getContextHandles();
	System.out.println(contextNames);
	for(String contextName: contextNames){
		System.out.println(contextNames);
	((AndroidDriver) getCommand().driver).context((String) contextNames.toArray()[1]);
	System.out.println(((AndroidDriver) getCommand().driver).getContext());
	
}
	*/

	
		getCommand().waitFor(10);
		System.out.println("In Search_Home From Home Page");
		log("at Search_Home", LogType.STEP);
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(SearchCatalog_home);
		if (getCommand().isTargetPresent(SearchCatalog_home)) {
			System.out.println("inside if loop of search");
			log("Search for keyword <B>" + keyword + "</B> from home page", LogType.STEP);
			getCommand().click(SearchCatalog_home);
			getCommand().sendKeys(SearchCatalog_home, keyword);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().waitForTargetPresent(SearchCatalog_homeSubmit);
			getCommand().click(SearchCatalog_homeSubmit);

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			System.out.println(((AndroidDriver) getCommand().driver).getContext());
			getCommand().waitFor(10);

		}

}
catch (Exception e) {
	((AndroidDriver) getCommand().driver).context("NATIVE_APP");
	getCommand().captureScreenshot(finalPath1);
	Assert.assertFalse(true, "searchKeyword_Home:Fail");
}
		return this;
	}
	
	
	public HomePage searchKeyword_Hamburger(String keyword, String string) {
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
				Set<String> contextNames = ((AndroidDriver) getCommand().driver).getContextHandles();
				System.out.println(contextNames);
				((AndroidDriver) getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
				System.out.println(((AndroidDriver) getCommand().driver).getContext());
			
		

			
				getCommand().waitFor(10);
				System.out.println("In Search from Hamburger");
				log("at Search_Home", LogType.STEP);
				getCommand().waitFor(5);
				getCommand().waitForTargetPresent(SearchCatalog_hamburger);
				if (getCommand().isTargetPresent(SearchCatalog_hamburger)) {
					System.out.println("inside if loop of search");
					log("Search for keyword <B>" + keyword + "</B> from home page", LogType.STEP);
					getCommand().click(SearchCatalog_hamburger);
					getCommand().sendKeys(SearchCatalog_hamburger, keyword+"\n");
					((AndroidDriver)getCommand().driver).context("NATIVE_APP");
					getCommand().captureScreenshot(finalPath);
					((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
					/*getCommand().waitForTargetPresent(SearchCatalog_homeSubmit);
					getCommand().click(SearchCatalog_homeSubmit);*/

					((AndroidDriver) getCommand().driver).context("NATIVE_APP");
					System.out.println(((AndroidDriver) getCommand().driver).getContext());
					getCommand().waitFor(10);

				}

		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "searchKeyword_Hamburger:Fail");
		}
				return this;
			}

	
	public HomePage searchKeyword_HomeWithScreenshot(String keyword, String string) {
		
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		
try{
		Set<String> contextNames = ((AndroidDriver) getCommand().driver).getContextHandles();
	
		System.out.println(contextNames);
		((AndroidDriver) getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		System.out.println(((AndroidDriver) getCommand().driver).getContext());

		getCommand().waitFor(5);
		System.out.println("In Search_Home From Home Page");
		log("at Search_Home", LogType.STEP);
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(SearchCatalog_home);
		if (getCommand().isTargetPresent(SearchCatalog_home)) {
			System.out.println("inside if loop of search");
			log("Search for keyword <B>" + keyword + "</B> from home page", LogType.STEP);
			getCommand().click(SearchCatalog_home);
			getCommand().sendKeys(SearchCatalog_home, keyword);
			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(SearchCatalog_homeSubmit);
			getCommand().click(SearchCatalog_homeSubmit);
		
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			
			System.out.println(((AndroidDriver) getCommand().driver).getContext());
			getCommand().captureScreenshot(finalPath);
			getCommand().waitFor(10);

		}
}
catch (Exception e) {
	getCommand().captureScreenshot(finalPath1);
	Assert.assertFalse(true, "searchKeyword_Home:Fail");
}
		return this;
	}

	
	public HomePage HamburgerMenuClick() {
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("InHamburgerMenuClick  Page");
		log("at HamburgerMenuClick", LogType.STEP);
		getCommand().waitForTargetPresent(HambergerMenu_home);
		if (getCommand().isTargetPresent(HambergerMenu_home)) {

			getCommand().click(HambergerMenu_home);
			System.out.println("clicked");
			log("Clicked on HambergerMenu_home in hamburger Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"HamburgerMenuClick"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "HamburgerMenuClick:Fail");
		}
		return this;
	}

	public HomePage home_Hamburger() {
		try{
		getCommand().waitFor(5);
		System.out.println("In home_Hamburger  Page");
		log("at home_Hamburger", LogType.STEP);
		getCommand().waitForTargetPresent(Home_hamburger);
		if (getCommand().isTargetPresent(Home_hamburger)) {

			getCommand().click(Home_hamburger);
			System.out.println("clicked");
			log("Clicked on home in hamburger Page: Pass", LogType.STEP);

		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"home_Hamburger"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "home_Hamburger:Fail");
		}
		return this;
	}

	public HomePage mySyscoTruck_Hamburger() {
		try{
		getCommand().waitFor(5);
		System.out.println("In mySyscoTruck_Hamburger  Page");
		log("at mySyscoTruck_Hamburger", LogType.STEP);
		getCommand().waitForTargetPresent(MySyscoTruck_hamburger);
		if (getCommand().isTargetPresent(MySyscoTruck_hamburger)) {

			getCommand().click(MySyscoTruck_hamburger);
			System.out.println("clicked");
			log("Clicked on mySyscoTruck in hamburger Page: Pass", LogType.STEP);
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"mySyscoTruck_Hamburger"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "mySyscoTruck_Hamburger:Fail");
		}
		return this;
	}

	public HomePage orderGuide_Hamburger(String string) {
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("In orderGuide_Hamburger  Page");
		log("at orderGuide_Hamburger", LogType.STEP);
		getCommand().waitForTargetPresent(OrderGuide_hamburger);
		if (getCommand().isTargetPresent(OrderGuide_hamburger)) {

			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(OrderGuide_hamburger);
			System.out.println("clicked");
			log("Clicked on orderGuide in hamburger Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");

		}
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "orderGuide_Hamburger:Fail");
		}
		return this;
	}

	public HomePage lists_Hamburger() {
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("In lists_Hamburger  Page");
		log("at lists_Hamburger", LogType.STEP);
		getCommand().waitForTargetPresent(Lists_hamburger);
		if (getCommand().isTargetPresent(Lists_hamburger)) {

			getCommand().click(Lists_hamburger);
			System.out.println("clicked");
			log("Clicked on lists/search  in hamburger Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"lists_Hamburger"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "lists_Hamburger:Fail");
		}
		return this;
	}
	
	public HomePage search_Hamburger() {
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("In search_Hamburger  Page");
		log("at search_Hamburger", LogType.STEP);
		getCommand().waitForTargetPresent(Search_hamburger);
		if (getCommand().isTargetPresent(Search_hamburger)) {

			getCommand().click(Search_hamburger);
			System.out.println("clicked");
			log("Clicked on search in hamburger Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"search_Hamburger"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "search_Hamburger:Fail");
		}
		return this;
	}

	public HomePage productCategories_Hamburger() {
		try{
		getCommand().waitFor(5);
		System.out.println("In productCategories_Hamburger  Page");
		log("at productCategories_Hamburger", LogType.STEP);
		getCommand().waitForTargetPresent(ProductCategories_hamburger);
		if (getCommand().isTargetPresent(ProductCategories_hamburger)) {

			getCommand().click(ProductCategories_hamburger);
			System.out.println("clicked");
			log("Clicked on product Categories in hamburger Page: Pass", LogType.STEP);

		}
	}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"productCategories_Hamburger"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "productCategories_Hamburger:Fail");
		}
		return this;
	}

	public HomePage openList() {
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("In openList  Page");
		log("at openList", LogType.STEP);
		getCommand().waitForTargetPresent(Open_home);
		if (getCommand().isTargetPresent(Open_home)) {

			getCommand().click(Open_home);
			System.out.println("clicked");
			log("Clicked on open list in home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"openList"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "openList:Fail");
		}
		return this;
	}

	public HomePage submittedList() {
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("In submittedList  Page");
		log("at submittedList", LogType.STEP);
		getCommand().waitForTargetPresent(Submitted_home);
		if (getCommand().isTargetPresent(Submitted_home)) {

			getCommand().click(Submitted_home);
			System.out.println("clicked");
			log("Clicked on submitted list in home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");

		}
	}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"submittedList"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "submittedList:Fail");
		}
		return this;
	}

	public HomePage historicalList() {
		try{
		getCommand().waitFor(5);
		System.out.println("In historicalList  Page");
		log("at historicalList", LogType.STEP);
		getCommand().waitForTargetPresent(Historical_home);
		if (getCommand().isTargetPresent(Historical_home)) {

			getCommand().click(Historical_home);
			System.out.println("clicked");
			log("Clicked on historical list in home Page: Pass", LogType.STEP);
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"historicalList"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "historicalList:Fail");
		}
		return this;
	}

	public HomePage Historical_Home() {
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("In Historical_Home From Home Page");
		log("at Historical_Home", LogType.STEP);
		getCommand().waitForTargetPresent(Historical_home);
		if (getCommand().isTargetPresent(Historical_home)) {
			getCommand().waitFor(5);

			getCommand().click(Historical_home);
			System.out.println("Waiting After Click for Open");
			System.out.println("clicked");
			log("Clicked on Historical in home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"Historical_Home"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "Historical_Home:Fail");
		}
		return this;
	}

	// --------------Apr 12 ---------------
	public HomePage logout_Hamburger() {
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("In Hamburger -Logout Page");
		log("at  Hamburger -Logout ", LogType.STEP);
		getCommand().waitForTargetPresent(Logout_hamburger);
		if (getCommand().isTargetPresent(Logout_hamburger)) {

			getCommand().click(Logout_hamburger);
			getCommand().waitFor(10);
			System.out.println("clicked");
			log("Clicked on Logout in hamburger Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"logout_Hamburger"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "logout_Hamburger:Fail");
		}
		return this;
	}

	public HomePage openList_MA() {
		try{
		getCommand().waitFor(10);
		System.out.println("In openList  Page");
		log("at openList", LogType.STEP);
		getCommand().waitForTargetPresent(Open_MA);
		if (getCommand().isTargetPresent(Open_MA)) {

			getCommand().click(Open_MA);
			System.out.println("clicked");
			log("Clicked on open list in home Page of MA: Pass", LogType.STEP);
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"openList_MA"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "openList_MA:Fail");
		}
		return this;
	}

	public HomePage pendingList_MA() {
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(10);
		System.out.println("In pendingList  Page");
		log("at pendingList", LogType.STEP);
		getCommand().waitForTargetPresent(Pending_MA);
		if (getCommand().isTargetPresent(Pending_MA)) {

			getCommand().click(Pending_MA);
			System.out.println("clicked");
			log("Clicked on Pending list in home Page of MA: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"pendingList_MA"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "pendingList_MA:Fail");
		}
		return this;
	}

	public HomePage openList_NU() {
		try{
			
		((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(10);
		System.out.println("In openList  Page ");
		log("at openList", LogType.STEP);
		getCommand().waitForTargetPresent(Open_NU);
		if (getCommand().isTargetPresent(Open_NU)) {

			getCommand().click(Open_NU);
			System.out.println("clicked");
			log("Clicked on open list in home Page of Normal User: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"openList_NU"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "openList_NU:Fail");
		}
		return this;
	}

	public HomePage inventory_Hamburger(String string) {
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		System.out.println("In inventory_Hamburger  Page");
		log("at inventory_Hamburger", LogType.STEP);
		getCommand().waitForTargetPresent(Inventory_hamburger);
		if (getCommand().isTargetPresent(Inventory_hamburger)) {
			
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(Inventory_hamburger);
			System.out.println("clicked");
			log("Clicked on inventory in hamburger Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
	}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "inventory_Hamburger:Fail");
		}
		return this;
	}
	
	//May 26
	public HomePage home_Category(){
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at category home click", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Category);
		if (getCommand().isTargetPresent(Home_Category)) {

			getCommand().click(Home_Category);
			System.out.println("clicked");
			log("Clicked on category in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"home_Category"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "home_Category:Fail");
		}
		return this;
	}
	
	public HomePage subcategory_Select(String string){
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at  subcategory home click", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Subcategory);
		if (getCommand().isTargetPresent(Home_Subcategory)) {
			
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

			getCommand().click(Home_Subcategory);
			System.out.println("clicked");
			log("Clicked on subcategory in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "subcategory_Select:Fail");
		}
		return this;
	}
	
	public HomePage home_Brand(){
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at brand home click", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Brand);
		if (getCommand().isTargetPresent(Home_Brand)) {

			getCommand().click(Home_Brand);
			System.out.println("clicked");
			log("Clicked on brand in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"home_Brand"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "home_Brand:Fail");
		}
		return this;
	}
	
	public HomePage brand_Select(String string){
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at select brand home", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Brand_Select);
		if (getCommand().isTargetPresent(Home_Brand_Select)) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

			getCommand().click(Home_Brand_Select);
			System.out.println("clicked");
			log("Clicked on an item in brand in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "brand_Select:Fail");
		}
		return this;
	}
	
	public HomePage home_Nutrition(){
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at nutrition home click", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Nutrition);
		if (getCommand().isTargetPresent(Home_Nutrition)) {

			getCommand().click(Home_Nutrition);
			System.out.println("clicked");
			log("Clicked on nutrition in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"home_Nutrition"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "home_Nutrition:Fail");
		}
		return this;
	}
	
	public HomePage nutrition_Select(String string){
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at select nutrition home", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Nutrition_Select);
		if (getCommand().isTargetPresent(Home_Nutrition_Select)) {
			
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(Home_Nutrition_Select);
			System.out.println("clicked");
			log("Clicked on an item in nutrition in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "nutrition_Select:Fail");
		}
		return this;
	}
	
	public HomePage home_Size(){
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at size home click", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Size);
		if (getCommand().isTargetPresent(Home_Size)) {

			getCommand().click(Home_Size);
			System.out.println("clicked");
			log("Clicked on size in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"home_Size"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "home_Size:Fail");
		}
		return this;
	}
	
	public HomePage size_Select(String string){
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at select size home", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Size_Select);
		if (getCommand().isTargetPresent(Home_Size_Select)) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

			getCommand().click(Home_Size_Select);
			System.out.println("clicked");
			log("Clicked on an item in size in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "size_Select:Fail");
		}
		return this;
	}
	
	
	public HomePage search_Select(String keyword){
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at category home search click", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Category_Search);
		if (getCommand().isTargetPresent(Home_Category_Search)) {

			getCommand().click(Home_Category_Search);
			getCommand().sendKeys(Home_Category_Search, keyword+"\n");
			System.out.println("clicked");
			log("Clicked on category search in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"search_Select"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "search_Select:Fail");
		}
		return this;
	}
	
	public HomePage category_Search_Select(String string){
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at select category home click", LogType.STEP);
		getCommand().waitForTargetPresent(Category_Search);
		if (getCommand().isTargetPresent(Category_Search)) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

			getCommand().click(Category_Search);
			System.out.println("clicked");
			log("Clicked on an item in category in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "category_Search_Select:Fail");
		}
		return this;
	}
	
	public HomePage search_Select_Brand(String keyword){
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at brand home search click", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Brand_Search);
		if (getCommand().isTargetPresent(Home_Brand_Search)) {

			getCommand().click(Home_Brand_Search);
			getCommand().sendKeys(Home_Brand_Search, keyword+"\n");
			System.out.println("clicked");
			log("Clicked on brand search in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"search_Select_Brand"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "search_Select_Brand:Fail");
		}
		return this;
	}
	
	public HomePage brand_Search_Select(String string){
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at brand home search click", LogType.STEP);
		getCommand().waitForTargetPresent(Brand_Search);
		//*[@class='main-content']//*[@class='home-page ']//*[@id='refine-sub-view']//*[@class='refinement brand level-0 active']//*[@id='refinement-Brand-0']//*[@data-nvalue='0+4294966874']
		if (getCommand().isTargetPresent(Brand_Search)) {

			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
			getCommand().click(Brand_Search);
			System.out.println("clicked");
			log("Clicked on an item in brand search in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "brand_Search_Select:Fail");
		}
		return this;
	}
	
	public HomePage search_Select_Size(String keyword){
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at size home search click", LogType.STEP);
		getCommand().waitForTargetPresent(Home_Size_Search);
		if (getCommand().isTargetPresent(Home_Size_Search)) {

			getCommand().click(Home_Size_Search);
			getCommand().sendKeys(Home_Size_Search, keyword+"\n");
			System.out.println("clicked");
			log("Clicked on search in size in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			String finalPathfail=drivePath+"search_Select_Size"+"Fail"+pathExtension;
			getCommand().captureScreenshot(finalPathfail);
			Assert.assertFalse(true, "search_Select_Size:Fail");
		}
		return this;
	}
	
	public HomePage size_Search_Select(String string){
		String string1="Success";
		String string2="Issue";
		String finalPath=drivePath+string+string1+pathExtension;
		String finalPath1=drivePath+string+string2+pathExtension;
		try{
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");
		getCommand().waitFor(5);
		log("at size home click", LogType.STEP);
		getCommand().waitForTargetPresent(Size_Search);
		if (getCommand().isTargetPresent(Size_Search)) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath);
			((AndroidDriver)getCommand().driver).context("WEBVIEW_com.madmobiledev.syscoendeca");

			getCommand().click(Size_Search);
			System.out.println("clicked");
			log("Clicked on an item in search in size in Home Page: Pass", LogType.STEP);
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
		}
		}
		catch (Exception e) {
			((AndroidDriver)getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertFalse(true, "size_Search_Select:Fail");
		}
		return this;
	}
}
