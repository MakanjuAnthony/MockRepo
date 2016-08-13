
/**
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 *																																		   	*
 * 2016-2017 Infosys Limited, Banglore, India. All Rights Reserved																			*

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
package com.sysco.pages;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import io.appium.java_client.ios.IOSDriver;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

import com.sysco.jsn_framework.JSN_Framework;
import com.sysco.locators.Screenshot;



public class FoodCostPage extends JSN_Framework {
	
	private static final Logger LOGGER= Logger.getLogger(FoodCostPage.class.getCanonicalName());

	public static final String FoodCostsPage = "//*[contains(text(),'Food Costs')]";
	public static final String BeginInventory = "(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[1]//*[contains(text(),'$')]";
	public static final String TotalPurchases = "(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[2]//*[contains(text(),'$')]";
	public static final String NetPurchases = "(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[3]//*[contains(text(),'$')]";
	
	public static final String EndInventory = "(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[4]//*[contains(text(),'$')]";
	public static final String CostOfGoodSold = "(//*[@class='mm-c-food-cost__details container']//*[@class='row'])[5]//*[contains(text(),'$')]";
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
	public static final String Revenue = "//*[@class='mm-c-food-cost__details container']//*[@placeholder='Revenue']";
	
	public static final String FoodSalesPercent = "//*[@class='mm-c-food-cost__details container']//*[@class='mm-c-food-cost__percentage_number row']/div";
	
	public static float beginInvValue;
	public static float endInvValue;

	
	
	
	public FoodCostPage VerifyTotalPurchase(String value, String string) throws InterruptedException, IOException {
		Reporter.log("Verify purchase value");
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			waitForElementPresent(TotalPurchases); 

			
			TotalPurchasesValue =getElementText(TotalPurchases);
			TotalPurchasesValue1 = TotalPurchasesValue.split("\\s");
			// totPurchase=Integer.parseInt(TotalPurchasesValue1[1]);
			if(!(TotalPurchasesValue1[1].equals(value))){
				throw new Exception();
			}
			
			Reporter.log("Verify purchase value :Pass");						
System.out.println("tot purch passed"+value+TotalPurchasesValue1[1]);

		}
		catch(Exception e){
			Reporter.log("Verify purchase value :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	public FoodCostPage VerifyNetPurchases(String string) throws InterruptedException, IOException {
		Reporter.log("Verify net purchase value");
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			waitForElementPresent(NetPurchases); 

			BeginInventoryValue =getElementText(BeginInventory);
			BeginInventoryValue1 = BeginInventoryValue.split("\\s");
			
			TotalPurchasesValue =getElementText(TotalPurchases);
			TotalPurchasesValue1 = TotalPurchasesValue.split("\\s");
			
			NetPurchasesValue =getElementText(NetPurchases);
			NetPurchasesValue1 = NetPurchasesValue.split("\\s");
			
			 beginInv=Float.parseFloat(BeginInventoryValue1[1]);
			 totPurchase=Float.parseFloat(TotalPurchasesValue1[1]);
			 netPurchase=Float.parseFloat(NetPurchasesValue1[1]);
			
			
			
			if(!(netPurchase==(beginInv+totPurchase))){
				throw new Exception();
			}
			
			Reporter.log("Verify net purchase value :Pass");						
System.out.println("net pur passed"+beginInv+totPurchase+netPurchase);

		}
		catch(Exception e){
			Reporter.log("Verify purchase value :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	
	public FoodCostPage VerifyCostOfGoodsSold(String string) throws InterruptedException, IOException {
		Reporter.log("Verify cost of goods sold value");
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			waitForElementPresent(CostOfGoodSold); 

			EndInventoryValue =getElementText(EndInventory);
			EndInventoryValue1 = EndInventoryValue.split("\\s");
			
			CostOfGoodSoldValue =getElementText(CostOfGoodSold);
			CostOfGoodSoldValue1 = CostOfGoodSoldValue.split("\\s");
			
			costGoods=Float.parseFloat(CostOfGoodSoldValue1[1]);
			endInv=Float.parseFloat(EndInventoryValue1[1]);
			
			if(!(costGoods==(netPurchase-endInv))){
				throw new Exception();
			}

			System.out.println("cost "+costGoods);
			
			Reporter.log("Verify cost of goods sold value :Pass");						


		}
		catch(Exception e){
			Reporter.log("Verify cost of goods sold value :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	public FoodCostPage EnterRevenue(String value,String string) throws InterruptedException, IOException {
		Reporter.log("Enter Revenue value");
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			revenue=Integer.parseInt(value);
			waitForElementPresent(Revenue); 

			waitForElementPresent(Revenue);
			
			sendText(Revenue, value);
		
			waitForElementPresent(CostOfGoodSold);
			waitFor(5); 
			
			/*((IOSDriver) getCommand().driver).findElement(
					By.xpath("//*[@placeholder='Revenue']"))
					.sendKeys(Keys.ENTER);
			*/
			
			
			Reporter.log("Enter Revenue :Pass");						


		}
		catch(Exception e){
			Reporter.log("Enter Revenue  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	public FoodCostPage CalculateFoodCost(String string) throws InterruptedException, IOException {
		Reporter.log("Calculating Food cost");
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;

		try{
			
			foodSales=(costGoods/revenue)*100;
			System.out.println(foodSales);
			/*foodSales1=String.valueOf(foodSales);
			System.out.println(foodSales1);  //round
	*/
			foodSales1=(int)Math.round(foodSales);
			foodSales2 = String.valueOf(foodSales1);
			System.out.println("foodSales2 "+foodSales2);
			/*foodSales2 = foodSales1.split(".");  //delete
			System.out.println(foodSales2);
			*/
					
			foodSalesPercent =getElementText(FoodSalesPercent);
			foodSalesPercent1 = foodSalesPercent.split("%");
			
			if(!(foodSales2.equals(foodSalesPercent1[0]))){
				throw new Exception();
			}
			
			Reporter.log("Food cost calculation :Pass");						
System.out.println(foodSales2+foodSalesPercent1[0]);

		}
		catch(Exception e){
			Reporter.log("Food cost calculation  :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public FoodCostPage VerifyBeginningInventory(String qty1,String foodprice, String string) throws InterruptedException, IOException {
		
		Reporter.log("Verify purchase value");
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;


		try{
			waitForElementPresent(BeginInventory);
		
			BeginInventoryValue =getElementText(BeginInventory);
			BeginInventoryValue1 = BeginInventoryValue.split("\\s");
		   beginInv=Float.parseFloat(BeginInventoryValue1[1]);
			System.out.println(beginInv);
			beginInvValue= (Float.parseFloat(qty1))*(Float.parseFloat(foodprice));
			//beginInvValue= qty1*foodprice;
			System.out.println("Calaculated"+beginInvValue);
			

			if(!(beginInv==beginInvValue)){
				throw new Exception();
			}
			
				Reporter.log("Verify beginning inventory value :Pass");
			

		}
		catch(Exception e){
		
			Reporter.log("Verify beginning inventory value :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);

		}

		return this;

	}
	
	public FoodCostPage VerifyEndingInventory(String qty1,String foodprice, String string) throws InterruptedException, IOException {
		
		Reporter.log("Verify purchase value");
		
		String string2="Issue";

		String finalPath1=drivePath+string+string2+Screenshot.pathExtension;



		try{
			waitForElementPresent(EndInventory);
		
			EndInventoryValue =getElementText(EndInventory);
			EndInventoryValue1 = EndInventoryValue.split("\\s");
			endInv=Float.parseFloat(EndInventoryValue1[1]);
			System.out.println(endInv);
			
			endInvValue=  (Float.parseFloat(qty1))*(Float.parseFloat(foodprice));
			System.out.println("Calaculated"+endInvValue);
			

			if(!(endInv==endInvValue)){
				throw new Exception();
			}
							
			Reporter.log("Verify ending inventory value :Pass");
			
			

		}
		catch(Exception e){

			Reporter.log("Verify ending inventory value :Fail");
			switchToNativeContext();
			takeScreenshot(finalPath1);
			
			Assert.assertTrue(false);
		}

		return this;

	}
	}
	
	
	
