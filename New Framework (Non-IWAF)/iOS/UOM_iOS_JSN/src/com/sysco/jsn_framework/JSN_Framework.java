package com.sysco.jsn_framework;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sysco.locators.DataPoolCoordinates;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class JSN_Framework {
	public static	String drivePath="/Users/naveen_raj04/Desktop/Sysco/iOSScreenshot/";
	protected static AppiumDriver driver;
	//public static AppiumDriver driver;
	String excelFilePath = "DataPool.xlsx";
	 Workbook workbook;
	 protected Sheet loginExcelData;
	 Sheet locationsExcelData;
	 Sheet categoryExcelData;
	 public String userName1;
	 public String password1;
	 public static String userName2;
	 public static String password2;
	 String locationName;
	 String editedLocationName;
	 String locationName1;
	 String locationName2;
	 String categoryName1;
	 String categoryName2;
	 
	 public static String userName[];
	 public static String password[] ;
	 
	 
	 protected static Integer noOfElements;
	 
	 
	/* 
	 public  JSN_Framework switchToWebContext(){
			Set<String> contextNames1 = driver.getContextHandles();
			for (String contextName : contextNames1){
			System.out.println("inside loop "+contextNames1);
			}
			System.out.println(driver.context((String) contextNames1.toArray()[1]));
			//driver.context("WEBVIEW_com.madmobiledev.uomqasq");
			//driver.context("WEBVIEW_com.syscouom.uomqasq");
			return this;
			}*/
	 
public  JSN_Framework switchToWebContext(){
	Set<String> contextNames1 = driver.getContextHandles();
	for (String contextName : contextNames1){
	System.out.println("inside loop "+contextNames1);
	}
	System.out.println(driver.context((String) contextNames1.toArray()[1]));
	return this;
	}

public  JSN_Framework switchToNativeContext(){
	driver.context("NATIVE_APP");
	return this;
	}

	
public  JSN_Framework waitForElementPresent(String element) throws InterruptedException{
	new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		return this;
	}
public  JSN_Framework waitForElementToBeClickable(String element) throws InterruptedException{
	  new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		return this;
	}
public  JSN_Framework waitForElementToBeClickableWithWait(String element) throws InterruptedException{
	new WebDriverWait(driver, 4);
	  new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		return this;
	}
public  JSN_Framework clickElement(String clickElement) throws InterruptedException{

	driver.findElement(By.xpath(clickElement)).click();
		return this;
	}


public  JSN_Framework clearElement(String clear){
	driver.findElement(By.xpath(clear)).clear();
	return this;
	}

public  JSN_Framework sendText(String sendText, String text){
	driver.findElement(By.xpath(sendText)).sendKeys(text);
	return this;
	}

/*public  boolean isElementPresent(String elementPresent){
	boolean element=driver.findElement(By.xpath(elementPresent)).isDisplayed();

	return  element;
	}
*/
public  Boolean isElementPresent(String elementPresent){
	boolean element;
	try{
		driver.findElement(By.xpath(elementPresent)).isDisplayed();
		element=true;
	}
	catch (Exception e) {
		element=false;
	}
	
	return  element;
	}

public  Boolean isElementPresentAfterWait(String elementPresent, int time){
	boolean element;
	try{
		new WebDriverWait(driver, time);
		driver.findElement(By.xpath(elementPresent)).isDisplayed();
		element=true;
	}
	catch (Exception e) {
		element=false;
	}
	
	return  element;
	}


public  String getElementText(String elementText){
		String test=driver.findElement(By.xpath(elementText)).getText();
		return test;
	}

public  JSN_Framework waitFor(long time) throws InterruptedException{
		new WebDriverWait(driver, time);
		return this;
	}

public  JSN_Framework takeScreenshot(String screenshotPathAddress) throws InterruptedException, IOException{
	//String screenShotPathAddress = "/Users/naveen_raj04/Desktop/Sysco/"+screenshotName+".jpeg";
	File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(sourceFile,new File(screenshotPathAddress));
	return this;
}
public  JSN_Framework getElementCount(String xpath){
	 noOfElements=driver.findElements(By.xpath(xpath)).size();
	return this;
	}
public  JSN_Framework selectDropDownByIndex(String xpath,int index){
	Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
	dropdown.selectByIndex(index);
	return this;
	}
public  JSN_Framework selectDropDownByValue(String xpath,String value){
	Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
	dropdown.selectByValue(value);
	return this;
	}
}
