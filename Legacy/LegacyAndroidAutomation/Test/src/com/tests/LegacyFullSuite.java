package com.tests;

import org.omg.CORBA._PolicyStub;


import org.testng.annotations.Test;

import com.components.entities.Start;
import com.components.yaml.SearchData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;

public class LegacyFullSuite extends Initiator{


	
	@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from inventory.",priority=0)
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
		;
		
	}
	

	@Test(groups={"Test_Script"}, description = "Creating a new order from home and submitting an order from Order Guide.",priority=1)
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
		.myActiveOrder_alertClose()
		;

	}
	
	
		@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from MyCustomList",priority=2)
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
		

		
	
		@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from SyscoList",priority=3)
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
		
		

		@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from SharedList",priority=4)
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

		@Test(groups={"Test_Script"}, description = "Submit order through Open Lists  from home and then creating new order",priority=5)
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
	
		
		 @Test(groups={"Test_Script"}, description = "Submit Item Via Submitted after adding More Items From OrderGuide",priority=6)
		public void submitOrder_Submitted_AddMoreItems_OrderGuide() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
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
		
		 
		@Test(groups={"Test_Script"}, description = "Searching for an item from Home and submitting order.",priority=7)
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
		
		

		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Order Guide ",priority=8)
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
		
		
		 
		 @Test(groups={"Test_Script"}, description = "Search From Hamburger Menu and submit order",priority=9)
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
		

	
	@Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Inventory",priority=10)
		 public void submitOrder_InventoryHamburger() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.inventory_Hamburger("submitOrder_InventoryHamburger1")
			._atInventoryPage()
			.firstItem_PlusBtn_Click()
			.inventory_CreateClick()
			.inventory_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_InventoryHamburger")
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	}
	
	
	@Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> Inventory",priority=11)
		 public void submitOrder_HamburgerListsInventory() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.lists_Hamburger()
			._atListsPage()
			.lists_Inventory("submitOrder_HamburgerListsInventory1")
			._atInventoryPage()
			.firstItem_PlusBtn_Click()
			.inventory_CreateClick()
			.inventory_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_HamburgerListsInventory")
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	} 
	
	 
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> OrderGuide",priority=12)
		 public void submitOrder_HamburgerListsOrderGuide() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.lists_Hamburger()
			._atListsPage()
			.lists_OrderGuide("submitOrder_HamburgerListsOrderGuide1")
			._atOrderGuide()
			.orderGuidePlusButton_Click()
			.orderGuide_CreateOrderClick()
			.orderGuide_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_HamburgerListsOrderGuide")
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	} 
		
		 
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> MyCustomLists",priority=13)
		 public void submitOrder_HamburgerListsMyCustomLists() throws InterruptedException {	
			
			 LoginData loginData =LoginData.fetch("LoginData1");	
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.lists_Hamburger()
				._atListsPage()
				.lists_MyCustomLists("submitOrder_HamburgerListsMyCustomLists1")
				._atMyCustomListsPage()
				.customListstItem_ClickWithScreenshot("submitOrder_HamburgerListsMyCustomLists2")
				.customListsPlusBtn_Click()
				.customLists_CreateClick()
				.customLists_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_HamburgerListsMyCustomLists3")
				._atMyActiveOrderPage()
				.myActiveOrder_alertClose()
				;
					
	} 
		
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> SyscoLists",priority=14)
		 public void submitOrder_HamburgerListsSyscoLists() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.lists_Hamburger()
			._atListsPage()
			.lists_SyscoLists("submitOrder_HamburgerListsSyscoLists1")
			._atSyscoListsPage()
			.syscoListItem_ClickWithScreenshot("submitOrder_HamburgerListsSyscoLists2")
			.syscoListPlusBtn_Click()
			.syscoLists_CreateClick()
			.syscoLists_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_HamburgerListsSyscoLists3")
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	} 

		
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> SharedLists",priority=15)
		 public void submitOrder_HamburgerListsSharedLists() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.lists_Hamburger()
			._atListsPage()
			.lists_SharedLists("submitOrder_HamburgerListsSharedLists1")
			._atSharedListPage()
			.sharedListItem_ClickWithScreenshots("submitOrder_HamburgerListsSharedLists2")
			.sharedListPlusBtn_Click()
			.sharedLists_CreateClick()
			.sharedLists_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_HamburgerListsSharedLists3")
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	} 
		
		 
		  @Test(groups={"Test_Script"}, description = "Reorder Item Via Historical- Delivered",priority=16)
		  public void submitOrder_HistoricalDeliveredReorder() throws InterruptedException {	
			  LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.Historical_Home()
			._atHistoricalOrdersPage()
			.DeliveredItem_Click("submitOrder_HistoricalDeliveredReorder1")
			._atDeliveredPage()
			.delivered_ReOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_HistoricalDeliveredReorder")
			.myActiveOrder_alertClose()
			;
	}
	
		
		  
		  @Test(groups={"Test_Script"}, description = "Submit Order with Case n Split non catchweight item.",priority=17)
			public void submitOrder_SearchAndS_NCW() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage() 
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.search_Hamburger()
				.searchKeyword_Hamburger(searchData.cAndS_NCW,"submitOrder_SearchAndS_NCW1")
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_SearchAndS_NCW")
				.myActiveOrder_alertClose()
				;
			}
		
		  
		  @Test(groups={"Test_Script"}, description = "Submit Order with Case n Split catchweight item.",priority=18)
			public void submitOrder_SearchAndS_CW() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.search_Hamburger()
				.searchKeyword_Hamburger(searchData.cAndS_CW,"submitOrder_SearchAndS_CW1")
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_SearchAndS_CW")
				.myActiveOrder_alertClose()
				;
			}
		
			
		  @Test(groups={"Test_Script"}, description = "Submit Order with split only item.",priority=19)
			public void submitOrder_SearchSplitOnly() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.search_Hamburger()
				.searchKeyword_Hamburger(searchData.splitOnly,"submitOrder_SearchSplitOnly1")
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_SearchSplitOnly")
				.myActiveOrder_alertClose()
				;
			}
			
		 
			@Test(groups={"Test_Script"}, description = "Submit Order with case only item.",priority=20)
			public void submitOrder_SearchCaseOnly() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.search_Hamburger()
				.searchKeyword_Hamburger(searchData.caseOnly,"submitOrder_SearchCaseOnly1")
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_SearchCaseOnly")
				.myActiveOrder_alertClose()
				;
			}
			
			@Test(groups={"Test_Script"}, description = "Submit Order with remoteStock item.",priority=21)
			public void submitOrder_SearchcAndS_RemoteStock() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.search_Hamburger()
				.searchKeyword_Hamburger(searchData.remoteStock,"submitOrder_SearchcAndS_RemoteStock1")
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_SearchcAndS_RemoteStock")
				.myActiveOrder_alertClose()
				;
			}
			
			
			@Test(groups={"Test_Script"}, description = "Submit Order with demand status item.",priority=22)
			public void submitOrder_SearchcAndS_DemandStatus() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.search_Hamburger()
				.searchKeyword_Hamburger(searchData.dmndStatus,"submitOrder_SearchcAndS_DemandStatus1")
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_SearchcAndS_DemandStatus")
				.myActiveOrder_alertClose()
				;
			}
			
			
			
			@Test(groups={"Test_Script"}, description = "Submit Order by Normal User and MA approves Item",priority=23)
			public void submitOrder_NormalUser_OrderGuide_MA_Approve() throws InterruptedException {	
				

				LoginData loginDataMA =LoginData.fetch("LoginDataMA");
				LoginData loginData =LoginData.fetch("LoginData");	
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.createNewOrder()
				._atCreateOrderPage()
				.createNewOrder_OrderGuide("submitOrder_NormalUser_OrderGuide_MA_Approve1")
				._atOrderGuide()
				.orderGuidePlusButton_Click()
				.orderGuide_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_NormalUser_OrderGuide_MA_Approve2")
				.myActiveOrder_alertClose()
				
				._atHomePage()
				.HamburgerMenuClick()
				.logout_Hamburger()
			
				._atLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginDataMA.UserName, loginDataMA.Password)
				._atHomePage()
				.pendingList_MA()
				
				._atPendingOrdersPage()
				.pendingApprovalItem_Click()
				
				._atMyActiveOrderPage()
				.myActiveOrder_Approve("submitOrder_NormalUser_OrderGuide_MA_Approve3")
				.myActiveOrder_alertClose()
			
			;
						
		}
		
		
			@Test(groups={"Test_Script"}, description = "Submit Order by Normal User and MA rejects Item",priority=24)
			public void submitOrder_NormalUser_OrderGuide_MA_Reject() throws InterruptedException {	
				
				
				LoginData loginDataMA =LoginData.fetch("LoginDataMA");
				LoginData loginData =LoginData.fetch("LoginData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.createNewOrder()
				._atCreateOrderPage()
				.createNewOrder_OrderGuide("submitOrder_NormalUser_OrderGuide_MA_Reject1")
				._atOrderGuide()
				.orderGuidePlusButton_Click()
				.orderGuide_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_NormalUser_OrderGuide_MA_Reject2")
				.myActiveOrder_alertClose()
				
				._atHomePage()
				.HamburgerMenuClick()
				.logout_Hamburger()
				
				._atLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginDataMA.UserName, loginDataMA.Password)
				._atHomePage()
				.pendingList_MA()
				
				._atPendingOrdersPage()
				.pendingApprovalItem_Click()
				
				._atMyActiveOrderPage()
				.myActiveOrder_Reject("submitOrder_NormalUser_OrderGuide_MA_Reject3")
				
			
			;
						
		}
		
	
		
			
			@Test(groups={"Test_Script"}, description = "Modify the open item by adding More Items From Orderguide",priority=25)
			public void submitOrder_Open_AddMoreItems_OrderGuide() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.openList()
				._atOpenOrdersPage()
				.openItem_Click("submitOrder_Open_AddMoreItems_OrderGuide1")
				
				._atMyActiveOrderPage()
				.myActiveOrder_AddMoreItemsWithScreenshot("submitOrder_Submitted_AddMoreItems_OrderGuide2")
				._atListsPage()
				.lists_OrderGuide("submitOrder_Open_AddMoreItems_OrderGuide3")
				._atOrderGuide()
				.orderGuidePlusButton_Click()
				.orderGuide_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder("submitOrder_Submitted_AddMoreItems_OrderGuide4")
				._atMyActiveOrderPage()
				.myActiveOrder_alertClose();
				;
						
		}
	
		
	
			
		  @Test(groups={"Test_Script"}, description = "Try to delete an order from historical list-Delivered",priority=26)
		  public void historicalDeliveredDelete() throws InterruptedException {	
			  LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.Historical_Home()
			._atHistoricalOrdersPage()
			.DeliveredItem_Click("historicalDeliveredDelete1")
			._atDeliveredPage()
			.delivered_DeleteButtonCheck("historicalDeliveredDelete");
			;
	}	
	
	

	
		@Test(groups={"Test_Script"}, description = "Try to delete an order from Historical list - Canceled ",priority=27)
		  public void historicalCanceledDelete() throws InterruptedException {	
			  LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.Historical_Home()
			._atHistoricalOrdersPage()
			.CanceledItem_Click("historicalCanceledDelete1")
			._atCanceledPage()
			.canceled_DeleteButtonCheck("historicalCanceledDelete");
			;
	}	
	

	
		
		@Test(groups={"Test_Script"}, description = "Try to modify an Order in Submitted Status before cutoff time and Place Order",priority=28)
		public void submitOrder_Submitted_Modify() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.submittedList()
			._atSubmittedOrdersPage()
			.submittedItem_ClickWeb()
			._atSubmittedPage()
			.submitted_Modify()
			.ModifyOrder_Continue()
			._atMyActiveOrderPage()
			.myActiveOrder_AddMoreItemsWithScreenshot("submitOrder_Submitted_Modify1")
			._atListsPage()
			.lists_Inventory("submitOrder_Submitted_Modify2")
			._atInventoryPage()
			.firstItem_PlusBtn_Click()
			.inventory_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder("submitOrder_Submitted_Modify3")
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			;
			;
		}

		

	
		@Test(groups={"Test_Script"}, description = "Delete an order with Open Status",priority=29)
		public void Delete_NormalUser_Open() throws InterruptedException {	
			
			LoginData loginDataNU =LoginData.fetch("LoginDataNU");
			
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
			._atHomePage()
			.openList_NU()
			._atOpenOrdersPage()
			.openItem_NU_Click("Delete_NormalUser_Open1")
			._atMyActiveOrderPage()
			.myActiveOrder_DeleteOrderClick()
			._atMyActiveOrderPage()
			.PleaseConfirmAlert_OK("Delete_NormalUser_Open")
		
		;
					
	} 
		 
		@Test(groups={"Test_Script"}, description = "Delete an order with Rejected Status",priority=30)
		public void Delete_NormalUser_Reject() throws InterruptedException {	
			
			LoginData loginDataNU =LoginData.fetch("LoginDataNU");
			
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
			._atHomePage()
			.openList_NU()
			._atOpenOrdersPage()
			.rejectedItem_Click("Delete_NormalUser_Reject1")
			._atMyActiveOrderPage()
			.myActiveOrder_DeleteOrderClick()
			._atMyActiveOrderPage()
			.PleaseConfirmAlert_OK("Delete_NormalUser_Reject")
		
		;
			
		}
		

		@Test(groups={"Test_Script"}, description = "Modify order with Pending approval status of Normal User",priority=31)
		public void submitOrder_NormalUser_Modify_PendingApproval() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginData");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.openList_NU()
		._atOpenOrdersPage()
		.pendingApprovalItem_Click("submitOrder_NormalUser_Modify_PendingApproval1")
		._atPendingOrdersPage()
		.pending_Modify()
		.ModifyOrder_Continue()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("submitOrder_NormalUser_Modify_PendingApproval")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		
		}
		

		@Test(groups={"Test_Script"}, description = "Delete order with Pending approval status of Normal User",priority=32)
		public void NormalUser_Delete_PendingApproval() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginDataNU");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.openList_NU()
		._atOpenOrdersPage()
		.pendingApprovalItem_Click("NormalUser_Delete_PendingApproval1")
		._atPendingOrdersPage()
		.pending_Delete()
		.PleaseConfirmAlert_OK("NormalUser_Delete_PendingApproval")
		
		;
		
		} 
	
		@Test(groups={"Test_Script"}, description = "Submit order from category in home page",priority=33)
		public void SubmitOrder_Categories_Home() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginData");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.home_Category()
		.subcategory_Select("SubmitOrder_Categories_Home1")
		._atProductCategoriesPage()
		.plus_Click()
		.create_Click()
		.cart_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("SubmitOrder_Categories_Home")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		}
		
		
		@Test(groups={"Test_Script"}, description = "Submit order from Brand in home page",priority=34)
		public void SubmitOrder_Brand_Home() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginData");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.home_Brand()
		.brand_Select("SubmitOrder_Brand_Home1")
		._atProductCategoriesPage()
		.second_Plus_Click()
		.create_Click()
		.cart_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("SubmitOrder_Brand_Home")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		}
		
		
		@Test(groups={"Test_Script"}, description = "Submit order from Nutrition in home page",priority=35)
		public void SubmitOrder_Nutrition_Home() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginData");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.home_Nutrition()
		.nutrition_Select("SubmitOrder_Nutrition_Home1")
		._atProductCategoriesPage()
		.plus_Click()
		.create_Click()
		.cart_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("SubmitOrder_Nutrition_Home")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		}
		
		
		@Test(groups={"Test_Script"}, description = "Submit order from Size in home page",priority=36)
		public void SubmitOrder_Size_Home() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginData");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.home_Size()
		.size_Select("SubmitOrder_Size_Home1")
		._atProductCategoriesPage()
		.second_Plus_Click()
		.create_Click()
		.cart_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("SubmitOrder_Size_Home")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		}
		
		@Test(groups={"Test_Script"}, description = "Submit order from category via search in home page",priority=37)
		public void SubmitOrder_Categories_Search_Home() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginData");
		SearchData searchData = SearchData.fetch("SearchData");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.home_Category()
		.search_Select(searchData.keyword)
		.category_Search_Select("SubmitOrder_Categories_Search_Home1")
		._atProductCategoriesPage()
		.plus_Click()
		.create_Click()
		.cart_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("SubmitOrder_Categories_Search_Home")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		}
		
		
	
		@Test(groups={"Test_Script"}, description = "Submit order from brand via search in home page",priority=38)
		public void SubmitOrder_Brand_Search_Home() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginData");
		SearchData searchData = SearchData.fetch("SearchData");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.home_Brand()
		.search_Select_Brand(searchData.brand)
		.brand_Search_Select("SubmitOrder_Brand_Search_Home1")
		._atProductCategoriesPage()
		.second_Plus_Click()
		.create_Click()
		.cart_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("SubmitOrder_Brand_Search_Home")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		}
		

		@Test(groups={"Test_Script"}, description = "Submit order from size via search in home page",priority=39)
		public void SubmitOrder_Size_Search_Home() throws InterruptedException {
		
		LoginData loginDataNU =LoginData.fetch("LoginData");
		SearchData searchData = SearchData.fetch("SearchData");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.home_Size()
		.search_Select_Size(searchData.size)
		.size_Search_Select("SubmitOrder_Size_Search_Home1")
		._atProductCategoriesPage()
		.second_Plus_Click()
		.create_Click() 
		.cart_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder("SubmitOrder_Size_Search_Home")
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		}

				
}
