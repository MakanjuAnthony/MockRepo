package com.tests;

import org.omg.CORBA._PolicyStub;


import org.testng.annotations.Test;

import com.components.entities.Start;
import com.components.yaml.SearchData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;

public class May27TestSuite5 extends Initiator{
	
	 @Test(groups={"Test_Script"}, description = "Submit Order with Case n Split non catchweight item.",priority=35)
		public void submitOrder_SearchAndS_NCW() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData = SearchData.fetch("SearchData");
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage() 
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.searchKeyword_Home(searchData.cAndS_NCW,"submitOrder_SearchAndS_NCW1")
			._atSearchResultPage()
			.searchResults_PlusButtonClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SearchAndS_NCW")
			.myActiveOrder_alertClose()
			;
		}
	 
	  
	  @Test(groups={"Test_Script"}, description = "Submit Order with Case n Split catchweight item.",priority=36)
		public void submitOrder_SearchAndS_CW() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData = SearchData.fetch("SearchData");
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.searchKeyword_Home(searchData.cAndS_CW,"submitOrder_SearchAndS_CW1")
			._atSearchResultPage()
			.searchResults_PlusButtonClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SearchAndS_CW")
			.myActiveOrder_alertClose()
			;
		}
	 
		
	  @Test(groups={"Test_Script"}, description = "Submit Order with split only item.",priority=37)
		public void submitOrder_SearchSplitOnly() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData = SearchData.fetch("SearchData");
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.searchKeyword_Home(searchData.splitOnly,"submitOrder_SearchSplitOnly1")
			._atSearchResultPage()
			.searchResults_PlusButton2ndItemClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SearchSplitOnly")
			.myActiveOrder_alertClose()
			;
		}
		
		@Test(groups={"Test_Script"}, description = "Submit Order with case only item.",priority=38)
		public void submitOrder_SearchCaseOnly() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData = SearchData.fetch("SearchData");
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.searchKeyword_Home(searchData.caseOnly,"submitOrder_SearchCaseOnly1")
			._atSearchResultPage()
			.searchResults_PlusButtonClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SearchCaseOnly")
			.myActiveOrder_alertClose()
			;
		}
		
		@Test(groups={"Test_Script"}, description = "Submit Order with remoteStock item.",priority=39)
		public void submitOrder_SearchcAndS_RemoteStock() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData = SearchData.fetch("SearchData");
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.searchKeyword_Home(searchData.remoteStock,"submitOrder_SearchcAndS_RemoteStock1")
			._atSearchResultPage()
			.searchResults_PlusButtonClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SearchcAndS_RemoteStock")
			.myActiveOrder_alertClose()
			;
		}
		
		
		@Test(groups={"Test_Script"}, description = "Submit Order with demand status item.",priority=40)
		public void submitOrder_SearchcAndS_DemandStatus() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData = SearchData.fetch("SearchData");
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.searchKeyword_Home(searchData.dmndStatus,"submitOrder_SearchcAndS_DemandStatus1")
			._atSearchResultPage()
			.searchResults_PlusButtonClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SearchcAndS_DemandStatus")
			.myActiveOrder_alertClose()
			;
		}
		

}
