package com.components.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

import java.util.Set;

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
	
	public static int	beginInv;
	public static int totPurchase;
	public static int netPurchase;
	public static int costGoods;
	public static int endInv;
	public static int foodSales;
	public static String foodSales1;
	public static String[] foodSales2;
	public static int revenue;
	public static String foodSalesPercent;
	public static String[] foodSalesPercent1;
	public static final Target Revenue = new Target("Revenue","//*[@class='mm-c-food-cost__details container']//*[@placeholder='Revenue']", Target.XPATH);
	
	public static final Target FoodSalesPercent = new Target("FoodSales","//*[@class='mm-c-food-cost__details container']//*[@class='mm-c-food-cost__percentage_number row']", Target.XPATH);
	
	public FoodCostPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public FoodCostPage atPurchasesPage() {
		log("In FoodCost page", LogType.STEP);
		return this;
	}
	
	
	
	
	public FoodCostPage VerifyTotalPurchase(String value, String string) {
		log("Verify purchase value",LogType.STEP);
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			getCommand().waitForTargetPresent(TotalPurchases); 

			
			TotalPurchasesValue =getCommand().getText(TotalPurchases);
			TotalPurchasesValue1 = TotalPurchasesValue.split("\\s");
			// totPurchase=Integer.parseInt(TotalPurchasesValue1[1]);
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
			
			 beginInv=Integer.parseInt(BeginInventoryValue1[1]);
			 totPurchase=Integer.parseInt(TotalPurchasesValue1[1]);
			 netPurchase=Integer.parseInt(NetPurchasesValue1[1]);
			
			
			
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
	
	public FoodCostPage VerifyCostOfGoodsSold(String string) {
		log("Verify cost of goods sold value",LogType.STEP);
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			getCommand().waitForTargetPresent(CostOfGoodSold); 

			EndInventoryValue =getCommand().getText(EndInventory);
			EndInventoryValue1 = EndInventoryValue.split("\\s");
			
			CostOfGoodSoldValue =getCommand().getText(CostOfGoodSold);
			CostOfGoodSoldValue1 = CostOfGoodSoldValue.split("\\s");
			
			costGoods=Integer.parseInt(CostOfGoodSoldValue1[1]);
			endInv=Integer.parseInt(EndInventoryValue1[1]);
			
			if(!(costGoods==(netPurchase-endInv))){
				throw new Exception();
			}

			
			
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
	public FoodCostPage EnterRevenue(String value,String string) {
		log("Enter Revenue value",LogType.STEP);
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			revenue=Integer.parseInt(value);
			getCommand().waitForTargetPresent(Revenue); 

			getCommand().click(Revenue);
			
			getCommand().sendKeys(Revenue, value);
			
			/*((IOSDriver) getCommand().driver).findElement(
					By.xpath("//*[@placeholder='Revenue']"))
					.sendKeys(Keys.ENTER);
			*/
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
	public FoodCostPage CalculateFoodCost(String string) {
		log("Calculating Food cost",LogType.STEP);
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+pathExtension;

		try{
			
			foodSales=(costGoods/revenue)*100;
			System.out.println(foodSales);
			foodSales1=String.valueOf(foodSales);
			System.out.println(foodSales1);
			
			foodSales2 = foodSales1.split(".");
			System.out.println(foodSales2);
			
			foodSalesPercent =getCommand().getText(FoodSalesPercent);
			foodSalesPercent1 = foodSales1.split("%");
			
			if(!(foodSales2[0]==foodSalesPercent1[0])){
				throw new Exception();
			}
			
			log("Food cost calculation :Pass",LogType.VERIFICATION_STEP);						
System.out.println(foodSales2[0]+foodSalesPercent1[0]);

		}
		catch(Exception e){
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Food cost calculation  :Fail",LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	}

