package com.tests;

import org.omg.CORBA._PolicyStub;


import org.testng.annotations.Test;

import com.components.entities.Start;
import com.components.yaml.SearchData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;

public class LegacyTestSuite1 extends Initiator{



	@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from inventory.",priority=1)
	public void submitOrder_Inventories() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginDataNU");	
		Start.asTester  
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		
		._atHomePage()
		.createNewOrder()
		
		._atCreateOrderPage()
		.createNewOrder_Inventory("submitOrder_Inventories1")
		
		._atInventoryPage()
		.plusBtn_Click()
		.inventory_CartClick()
		
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("submitOrder_Inventories")
		
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose();
		
		
	}
	

	
	@Test(groups={"Test_Script"}, description = "Creating a new order from home and submitting an order from Order Guide.",priority=2)
	public void submitOrder_OrderGuide() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.createNewOrder()
		._atCreateOrderPage()
		.createNewOrder_OrderGuide("submitOrder_OrderGuide1")
		._atOrderGuide()
		.orderGuidePlusButton_Click()
		.orderGuide_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("submitOrder_OrderGuide")
		.myActiveOrder_alertClose();

	}

	
		@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from MyCustomList",priority=3)
	public void submitOrder_MyCustomLists() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData1");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.createNewOrder()
	
		._atCreateOrderPage()
		
		.createNewOrder_MyCustomLists("submitOrder_MyCustomLists1")
		._atMyCustomListsPage()
		.customListstItem_ClickWithScreenshot("submitOrder_MyCustomLists2")
		.customListsPlusBtn_Click()
		.customLists_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("submitOrder_MyCustomLists3")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		
	}
		

		
	
		@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from SyscoList",priority=4)
		public void submitOrder_SyscoLists() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.createNewOrder()
			._atCreateOrderPage()
			.createNewOrder_SyscoLists("submitOrder_SyscoLists1")
			._atSyscoListsPage()
			.syscoListItem_ClickWithScreenshot("submitOrder_SyscoLists2")
			.syscoListPlusBtn_Click()
			.syscoLists_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SyscoLists3")
			.myActiveOrder_alertClose()
			;
			
		}
		


		@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from SharedList",priority=5)
		public void submitOrder_SharedLists() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.createNewOrder()
			
			._atCreateOrderPage()
			.createNewOrder_SharedLists("submitOrder_SharedLists1")
			
			._atSharedListPage()
			.sharedListItem_ClickWithScreenshots("submitOrder_SharedLists2")
			.sharedListPlusBtn_Click()
			.sharedLists_CartClick()
			
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SharedLists3")
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			
			;
		}
	
	
		@Test(groups={"Test_Script"}, description = "Submit order through Open Lists  from home and then creating new order",priority=6)
		public void SubmitOrder_OpenListNewOrder() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.openList()
			._atOpenOrdersPage()
			.openItem_Click("SubmitOrder_OpenListNewOrder1")
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("SubmitOrder_OpenListNewOrder")
			.myActiveOrder_alertClose()
			;
		}

		
		 @Test(groups={"Test_Script"}, description = "Submit Item Via Submitted after adding More Items From OrderGuide",priority=7)
		public void submitOrder_Submitted_AddMoreItems_OrderGuide() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData1");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.submittedList()
			._atSubmittedOrdersPage()
			.submittedItem_ClickWeb()
			._atSubmittedPage()
			.submitted_Modify()
			.ModifyOrder_Continue()
			._atMyActiveOrderPage()
			.myActiveOrder_AddMoreItemsWithScreenshot("submitOrder_Submitted_AddMoreItems_OrderGuide1")
			._atListsPage()
			.lists_OrderGuide("submitOrder_Submitted_AddMoreItems_OrderGuide2")
			._atOrderGuide()
			.orderGuide_Click()
			.orderGuide_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_Submitted_AddMoreItems_OrderGuide3")
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			;
					
	}
	
		 
		@Test(groups={"Test_Script"}, description = "Searching for an item from Home and submitting order.",priority=8)
		public void submitOrder_SearchHome() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData = SearchData.fetch("SearchData");
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.searchKeyword_Home(searchData.keyword,"submitOrder_SearchHome1")
			._atSearchResultPage()
			.searchResults_PlusButtonClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_SearchHome")
			.myActiveOrder_alertClose()
			;
		}
		

		@Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Order Guide ",priority=9)
		public void submitOrder_OrderGuide_Hamburger() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.HamburgerMenuClick()
			.orderGuide_Hamburger("submitOrder_OrderGuide_Hamburger1")
			._atOrderGuide()
			.orderGuidePlusButton_Click()
			.orderGuide_CreateOrderClick()
			.orderGuide_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_OrderGuide_Hamburger")
			.myActiveOrder_alertClose();
			;
					
	}


	 
	 @Test(groups={"Test_Script"}, description = "Search From Hamburger Menu and submit order",priority=10)
	 public void submitOrder_SearchHamburger() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData");	
		SearchData searchData = SearchData.fetch("SearchData");
		Start.asTester
		
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.HamburgerMenuClick()
		.search_Hamburger()
		.searchKeyword_Hamburger(searchData.keyword,"submitOrder_SearchHamburger1")
		._atSearchResultPage()
		.searchResults_PlusButtonClick()
		.searchResults_CreateClick()
		.searchResults_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("submitOrder_SearchHamburger")
		.myActiveOrder_alertClose()
		;		
	}  

	
}
		