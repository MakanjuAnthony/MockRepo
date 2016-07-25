package com.components.pages;


import org.testng.Assert;
import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;
import io.appium.java_client.android.AndroidDriver;


public class FoodCostPage extends SitePage {

	public static final Target FoodCostsPage = new Target("InvToolsPage","//*[contains(text(),'Food Costs')]", Target.XPATH);
	public static final Target BeginInventory = new Target("InvToolsPage","(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[1]//*[contains(text(),'$')]", Target.XPATH);
	public static final Target TotalPurchases = new Target("InvToolsPage","(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[2]//*[contains(text(),'$')]", Target.XPATH);
	public static final Target NetPurchases = new Target("InvToolsPage","(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[3]//*[contains(text(),'$')]", Target.XPATH);
	
	public static final Target EndInventory = new Target("InvToolsPage","(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[4]//*[contains(text(),'$')]", Target.XPATH);
	public static final Target CostOfGoodSold = new Target("InvToolsPage","(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[5]//*[contains(text(),'$')]", Target.XPATH);
	public static String BeginInventoryValue;
	public static String TotalPurchasesValue;
	public static String NetPurchasesValue;
	public static String EndInventoryValue;
	public static String CostOfGoodSoldValue;
	
	public static String[] BeginInventoryValue1;
	public static String[] TotalPurchasesValue1;
	public static String[] NetPurchasesValue1;
	public static String[] EndInventoryValue1;
	public static String[] CostOfGoodSoldValue1;
	
	public static float	beginInv;
	public static float totPurchase;
	public static float netPurchase;
	public static float costGoods;
	public static float endInv;
	public static float foodSales;
	public static int foodSales1;
	public static String foodSales2;
	public static float revenue;
	public static String foodSalesPercent;
	public static String[] foodSalesPercent1;
	public static final Target Revenue = new Target("Revenue","//*[@class='mm-c-food-cost__details container']//*[@placeholder='Revenue']", Target.XPATH);
	
	public static final Target FoodSalesPercent = new Target("FoodSales","//*[@class='mm-c-food-cost__details container']//*[@class='mm-c-food-cost__percentage_number row']/div", Target.XPATH);
	public static final Target Back = new Target("Back",
			"//*[@id='back-nav']/a/i", Target.XPATH);


	public FoodCostPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public FoodCostPage atPurchasesPage() {
		log("In FoodCost page", LogType.STEP);
		return this;
	}
	
	
	
	
	@SuppressWarnings("rawtypes")
	public FoodCostPage VerifyTotalPurchase(String value, String string) {
		log("Verify purchase value",LogType.STEP);
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			getCommand().waitForTargetPresent(TotalPurchases); 

			
			TotalPurchasesValue =getCommand().getText(TotalPurchases);
			TotalPurchasesValue1 = TotalPurchasesValue.split("\\s");
			
			if(!(TotalPurchasesValue1[1].equals(value))){
				throw new Exception();
			}
			
			log("Verify purchase value :Pass",LogType.VERIFICATION_STEP);						

			System.out.println("tot purch passed"+value+TotalPurchasesValue1[1]);

		}
		catch(Exception e){
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Verify purchase value :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public FoodCostPage VerifyNetPurchases(String string) {
		log("Verify net purchase value",LogType.STEP);
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			getCommand().waitForTargetPresent(NetPurchases); 

			BeginInventoryValue =getCommand().getText(BeginInventory);
			BeginInventoryValue1 = BeginInventoryValue.split("\\s");
			
			TotalPurchasesValue =getCommand().getText(TotalPurchases);
			TotalPurchasesValue1 = TotalPurchasesValue.split("\\s");
			
			NetPurchasesValue =getCommand().getText(NetPurchases);
			NetPurchasesValue1 = NetPurchasesValue.split("\\s");
			
			 beginInv=Float.parseFloat(BeginInventoryValue1[1]);
			 totPurchase=Float.parseFloat(TotalPurchasesValue1[1]);
			 netPurchase=Float.parseFloat(NetPurchasesValue1[1]);
			
			
			
			if(!(netPurchase==(beginInv+totPurchase))){
				throw new Exception();
			}
			
			log("Verify net purchase value :Pass",LogType.VERIFICATION_STEP);						

			System.out.println("net pur passed"+beginInv+totPurchase+netPurchase);

		}
		catch(Exception e){
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Verify purchase value :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	
	@SuppressWarnings("rawtypes")
	public FoodCostPage VerifyCostOfGoodsSold(String string) {
		log("Verify cost of goods sold value",LogType.STEP);
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			getCommand().waitFor(15);
			getCommand().waitForTargetPresent(CostOfGoodSold); 
			
			
			EndInventoryValue =getCommand().getText(EndInventory);
			EndInventoryValue1 = EndInventoryValue.split("\\s");
			
			CostOfGoodSoldValue =getCommand().getText(CostOfGoodSold);
			CostOfGoodSoldValue1 = CostOfGoodSoldValue.split("\\s");
			
			costGoods=Float.parseFloat(CostOfGoodSoldValue1[1]);
			endInv=Float.parseFloat(EndInventoryValue1[1]);
			
			if(!(costGoods==(netPurchase-endInv))){
				throw new Exception();
			}

			
			System.out.println(costGoods);
			
			log("Verify cost of goods sold value :Pass",LogType.VERIFICATION_STEP);						


		}
		catch(Exception e){
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Verify cost of goods sold value :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public FoodCostPage EnterRevenue(String value,String string) {
		log("Enter Revenue value",LogType.STEP);
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			revenue=Float.parseFloat(value);
			getCommand().waitForTargetPresent(Revenue); 
			
			getCommand().click(Revenue);
			
			getCommand().sendKeys(Revenue, value);
			
			getCommand().click(CostOfGoodSold);
			getCommand().waitFor(3);
			
	
			log("Enter Revenue :Pass",LogType.VERIFICATION_STEP);						


		}
		catch(Exception e){
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Enter Revenue  :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	
	@SuppressWarnings("rawtypes")
	public FoodCostPage CalculateFoodCost(String string) {
		log("Calculating Food cost", LogType.STEP);
		String string2 = "Issue";
		String finalPath1 = drivePath + string + string2 + pathExtension;
		try {
			
			getCommand().waitFor(15);
			foodSales = (costGoods / revenue) * 100;
			
			System.out.println(foodSales);
			
			foodSales1 = (int) Math.round(foodSales);
			foodSales2 = String.valueOf(foodSales1);
			
			System.out.println("foodSales2" + foodSales2);
			
			foodSalesPercent = getCommand().getText(FoodSalesPercent);
			foodSalesPercent1 = foodSalesPercent.split("%");
			
			System.out.println(foodSales2 + foodSalesPercent1[0]);
			
			if (!(foodSales2.equals(foodSalesPercent1[0]))) {
				throw new Exception();
			}
			
			log("Food cost calculation :Pass", LogType.VERIFICATION_STEP);
			
		}
		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Food cost calculation :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}
	@SuppressWarnings("rawtypes")
	public FoodCostPage TapOnBack(String string) {
			String string2 = "Issue";

			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(Back);
			if (getCommand().isTargetPresent(Back)) {

				getCommand().click(Back);
				log("tap on back :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			log("tap on back :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}
	@SuppressWarnings("rawtypes")
	public FoodCostPage VerifyCurrentAndLastclosedPrice(String string) {
			String string2 = "Issue";

			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(BeginInventory);
			BeginInventoryValue =getCommand().getText(BeginInventory);
			BeginInventoryValue1 = BeginInventoryValue.split("\\s");
			 beginInv=Float.parseFloat(BeginInventoryValue1[1]);
			
			if(!(endInv==beginInv)){
				throw new Exception();
			}
			log("Verify current price same as price when the inventory closed :Pass", LogType.VERIFICATION_STEP);
			
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			log("Verify current price same as price when the inventory closed :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

}

