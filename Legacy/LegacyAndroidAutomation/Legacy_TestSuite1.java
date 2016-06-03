
package com.tests;

import org.omg.CORBA._PolicyStub;

import org.testng.annotations.Test;

import com.components.entities.Start;
import com.components.yaml.SearchData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;

public class Legacy_TestSuite1 extends Initiator{

	@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from product categories.",priority=0)
	public void submitOrder_Categories() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.createNewOrder()
		._atCreateOrderPage()
		.createNewOrder_Categories()
		._atProductCategoriesPage()
		.Item_Click()
		.PlusBtn_Click()
		.categories_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose();
		
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
		.createNewOrder_OrderGuide()
		._atOrderGuide()
		.orderGuide_Click()
		.orderGuide_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		.myActiveOrder_alertClose();

	}
		
		@Test(groups={"Test_Script"}, description = "Creating a new order from Home and submitting an order from MyCustomList",priority=2)
	public void submitOrder_MyCustomLists() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.createNewOrder()
		._atCreateOrderPage()
		.createNewOrder_MyCustomLists()
		._atMyCustomListsPage()
		.customListstItem_Click()
		.customListsPlusBtn_Click()
		.customLists_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
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
			.createNewOrder_SyscoLists()
			._atSyscoListsPage()
			.syscoListItem_Click()
			.syscoListPlusBtn_Click()
			.syscoLists_CreateClick() 
			.syscoLists_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
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
			.createNewOrder_SharedLists()
			
			._atSharedListPage()
			.sharedListItem_Click()
			.sharedListPlusBtn_Click()
			.sharedLists_CartClick()
			
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			
			;
		}
		
		@Test(groups={"Test_Script"}, description = "Submit order through Order Guide  from home and then creating new order",priority=5)
		public void SubmitOrder_OrderGuideNewOrder() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.OrderGuide_Home()
			._atOrderGuide()
			.orderGuidePlusButton_Click()
			.orderGuide_CreateOrderClick()
			.orderGuide_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
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
			.openItem_ClickWeb()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			.myActiveOrder_alertClose()
			;
		}
		
		
		 @Test(groups={"Test_Script"}, description = "Submit Item Via Submitted after adding More Items From OrderGuide",priority=7)
		public void submitOrder_Submitted_AddMoreItems_OrderGuide() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.submittedList()
			._atSubmittedOrdersPage()
			.submittedItem_Click()
			._atSubmittedPage()
			.submitted_Modify()
			.ModifyOrder_Continue()
			._atMyActiveOrderPage()
			.myActiveOrder_AddMoreItems()
			._atListsPage()
			.lists_OrderGuide()
			._atOrderGuide()
			.orderGuide_PlusButton2ndItemClick()
			.orderGuide_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			.NonCancellableItems_Continue()
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
			.searchKeyword_Home(searchData.keyword)
			._atSearchResultPage()
			.searchResults_PlusButtonClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			.myActiveOrder_alertClose()
			;
		}
		
		@Test(groups={"Test_Script"}, description = "Creating a new order from My Active Order Screen and submitting an order",priority=9)
		public void submitOrder_ActiveOrder() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.createNewOrder()
			._atCreateOrderPage()
			.createNewOrder_Categories()
			._atProductCategoriesPage()
			.Item_Click()
			.PlusBtn_Click()
			.categories_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
			
		}
		
		
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Order Guide ",priority=10)
			public void submitOrder_OrderGuide_Hamburger() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.orderGuide_Hamburger()
				._atOrderGuide()
				.orderGuidePlusButton_Click()
				.orderGuide_CreateOrderClick()
				.orderGuide_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				.myActiveOrder_alertClose();
				;
						
		}
		 
		 
		 @Test(groups={"Test_Script"}, description = "Search From Hamburger Menu and submit order",priority=11)
		 public void submitOrder_SearchHamburger() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData = SearchData.fetch("SearchData");
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.HamburgerMenuClick()
			.searchOrLists_Hamburger()
			.searchKeyword_Home(searchData.keyword)
			._atSearchResultPage()
			.searchResults_PlusButtonClick()
			.searchResults_CreateClick()
			.searchResults_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			.myActiveOrder_alertClose()
			;		
	}  
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Product Categories",priority=12)
		 public void submitOrder_CategoriesHamburger() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.productCategories_Hamburger()
			._atProductCategoriesPage()
			.Item_Click()
			.PlusBtn_Click()
			.categories_CreateClick()
			.categories_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	}
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Search/Lists --> Product Ctegories",priority=13)
		 public void submitOrder_HamburgerSearchOrListsProductCategories() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.searchOrLists_Hamburger()
			._atListsPage()
			.lists_Categories()
			._atProductCategoriesPage()
			.Item_Click()
			.PlusBtn_Click()
			.categories_CreateClick()
			.categories_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	} 
		 
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Search/Lists --> OrderGuide",priority=14)
		 public void submitOrder_HamburgerSearchOrListsOrderGuide() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.searchOrLists_Hamburger()
			._atListsPage()
			.lists_OrderGuide()
			._atProductCategoriesPage()
			.Item_Click()
			.PlusBtn_Click()
			.categories_CreateClick()
			.categories_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	} 
		 
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Search/Lists --> MyCustomLists",priority=15)
		 public void submitOrder_HamburgerSearchOrListsMyCustomLists() throws InterruptedException {	
			
			 LoginData loginData =LoginData.fetch("LoginData");	
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.HamburgerMenuClick()
				.searchOrLists_Hamburger()
				._atListsPage()
				.lists_MyCustomLists()
				._atMyCustomListsPage()
				.customListstItem_Click()
				.customListsPlusBtn_Click()
				.customLists_CreateClick()
				.customLists_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				._atMyActiveOrderPage()
				.myActiveOrder_alertClose()
				;
					
	} 
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Search/Lists --> SyscoLists",priority=16)
		 public void submitOrder_HamburgerSearchOrListsSyscoLists() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.searchOrLists_Hamburger()
			._atListsPage()
			.lists_SyscoLists()
			._atSyscoListsPage()
			.syscoListItem_Click()
			.syscoListPlusBtn_Click()
			.syscoLists_CreateClick()
			.syscoLists_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	} 
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Search/Lists --> SharedLists",priority=17)
		 public void submitOrder_HamburgerSearchOrListsSharedLists() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.HamburgerMenuClick()
			.searchOrLists_Hamburger()
			._atListsPage()
			.lists_SharedLists()
			._atSharedListPage()
			.sharedListItem_Click()
			.sharedListPlusBtn_Click()
			.sharedLists_CreateClick()
			.sharedLists_CartClick()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose();
		
			;
					
	} 
		 
		  @Test(groups={"Test_Script"}, description = "Reorder Item Via Historical- Delivered",priority=18)
		  public void submitOrder_HistoricalDeliveredReorder() throws InterruptedException {	
			  LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.Historical_Home()
			._atHistoricalOrdersPage()
			.DeliveredItem_Click()
			._atDeliveredPage()
			.delivered_ReOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			;
	}	 
		 
		  @Test(groups={"Test_Script"}, description = "Submit Order with Case n Split non catchweight item.",priority=19)
			public void submitOrder_SearchcAndS_NCW() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.searchKeyword_Home(searchData.cAndS_NCW)
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				.myActiveOrder_alertClose()
				;
			}
		  
		  @Test(groups={"Test_Script"}, description = "Submit Order with Case n Split catchweight item.",priority=20)
			public void submitOrder_SearchcAndS_CW() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.searchKeyword_Home(searchData.cAndS_CW)
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				.myActiveOrder_alertClose()
				;
			}
			
		  @Test(groups={"Test_Script"}, description = "Submit Order with split only item.",priority=21)
			public void submitOrder_SearchSplitOnly() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.searchKeyword_Home(searchData.splitOnly)
				._atSearchResultPage()
				.searchResults_PlusButton2ndItemClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				.myActiveOrder_alertClose()
				;
			}
			
			@Test(groups={"Test_Script"}, description = "Submit Order with case only item.",priority=22)
			public void submitOrder_SearchCaseOnly() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.searchKeyword_Home(searchData.caseOnly)
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				.myActiveOrder_alertClose()
				;
			}
			
			@Test(groups={"Test_Script"}, description = "Submit Order with remoteStock item.",priority=23)
			public void submitOrder_SearchcAndS_RemoteStock() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.searchKeyword_Home(searchData.remoteStock)
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				.myActiveOrder_alertClose()
				;
			}
			
			
			@Test(groups={"Test_Script"}, description = "Submit Order with demand status item.",priority=24)
			public void submitOrder_SearchcAndS_DemandStatus() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				SearchData searchData = SearchData.fetch("SearchData");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.searchKeyword_Home(searchData.dmndStatus)
				._atSearchResultPage()
				.searchResults_PlusButtonClick()
				.searchResults_CreateClick()
				.searchResults_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				.myActiveOrder_alertClose()
				;
			}
			
			@Test(groups={"Test_Script"}, description = "Submit Order by Normal User and MA approves Item",priority=25)
			public void submitOrder_NormalUser_Categories_MA_Approve() throws InterruptedException {	
				
				LoginData loginDataNU =LoginData.fetch("LoginDataNU");
				LoginData loginDataMA =LoginData.fetch("LoginDataMA");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
				._atHomePage()
				.createNewOrder()
				._atCreateOrderPage()
				.createNewOrder_Categories()
				._atProductCategoriesPage()
				.Item_Click()
				.NU_PlusBtn_Click()
				.NU_categories_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				._atMyActiveOrderPage()
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
				.myActiveOrder_Approve()
				.myActiveOrder_alertClose()
			
			;
						
		}
		
			@Test(groups={"Test_Script"}, description = "Submit Order by Normal User and MA rejects Item",priority=26)
			public void submitOrder_NormalUser_Categories_MA_Reject() throws InterruptedException {	
				
				LoginData loginDataNU =LoginData.fetch("LoginDataNU");
				LoginData loginDataMA =LoginData.fetch("LoginDataMA");
				Start.asTester
				.goToLoginPage()
				.verifyLoginPage()
				.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
				._atHomePage()
				.createNewOrder()
				._atCreateOrderPage()
				.createNewOrder_Categories()
				._atProductCategoriesPage()
				.Item_Click()
				.NU_PlusBtn_Click()
				.NU_categories_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				._atMyActiveOrderPage()
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
				.myActiveOrder_Reject()
				._atPendingOrdersPage()
			
			;
						
		}
			
			@Test(groups={"Test_Script"}, description = "Modify the submitted item by adding More Items From Categories",priority=27)
			public void submitOrder_Submitted_AddMoreItems_Categories() throws InterruptedException {	
				
				LoginData loginData =LoginData.fetch("LoginData");	
				Start.asTester
				.goToLoginPage()
				//.verifyLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._atHomePage()
				.submittedList()
				._atSubmittedOrdersPage()
				.submittedItem_ClickWeb()
				._atSubmittedPage()
				.submitted_Modify()
				.ModifyOrder_Continue()
				._atMyActiveOrderPage()
				.myActiveOrder_AddMoreItems()
				._atListsPage()
				.lists_Categories()
				._atProductCategoriesPage()
				.Item_Click()
				.SecondPlusButton_Click()
				.categories_CartClick()
				._atMyActiveOrderPage()
				.myActiveOrder_SubmitOrder()
				.NonCancellableItems_Continue()
				._atMyActiveOrderPage()
				.myActiveOrder_alertClose()
				;
						
		}	
			
	/*@Test(groups={"Test_Script"}, description = "Submit order through Orders and then creating new order",priority=2)
	public void SubmitOrder_OrderNewOrder() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.OrderGuide_Home()
		._atOrderGuide()
		.orderGuidePlusButton_Click()
		.orderGuide_CreateOrderClick()
		.orderGuide_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		.myActiveOrder_alertClose()
		;
	}*/
		
	@Test(groups={"Test_Script"}, description = "Try to delete an order from historical list-Delivered",priority=28)
	  public void historicatDeliveredDelete() throws InterruptedException {	
		  LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.Historical_Home()
		._atHistoricalOrdersPage()
		.DeliveredItem_Click()
		._atDeliveredPage()
		.delivered_DeleteButtonCheck();
		;
}		
	
	@Test(groups={"Test_Script"}, description = "Try to delete an order from Historical list - Canceled ",priority=29)
	  public void historicalCanceledDelete() throws InterruptedException {	
		  LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.Historical_Home()
		._atHistoricalOrdersPage()
		.CanceledItem_Click()
		._atCanceledPage()
		.canceled_DeleteButtonCheck();
		;
}	
	
	@Test(groups={"Test_Script"}, description = "Try to delete an order from open order ",priority=30)
	  public void openDelete() throws InterruptedException {	
		  LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.openList()
		._atOpenOrdersPage()
		.openItem_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_DeleteOrderButtonCheck()
		;
}	
	@Test(groups={"Test_Script"}, description = "Try to modify an Order in Submitted Status before cutoff time and Place Order",priority=31)
	public void submitOrder_Submitted_Modify() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		//.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.submittedList()
		._atSubmittedOrdersPage()
		.submittedItem_ClickWeb()
		._atSubmittedPage()
		.submitted_Modify()
		.ModifyOrder_Continue()
		._atMyActiveOrderPage()
		.myActiveOrder_AddMoreItems()
		._atListsPage()
		.lists_Categories()
		._atProductCategoriesPage()
		.Item_Click()
		.SecondPlusButton_Click()
		.categories_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		.NonCancellableItems_Continue()
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
				
}	
	
	@Test(groups={"Test_Script"}, description = "Try to Modify an order from open order ",priority=32)
	  public void openModify() throws InterruptedException {	
		  LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.openList()
		._atOpenOrdersPage()
		.openItem_Click()
		._atMyActiveOrderPage()
		
		;
}	
	
	/*@Test(groups={"Test_Script"}, description = "Delete an order with Open Status",priority=19)
	public void Delete_NormalUser_Open() throws InterruptedException {	
		
		LoginData loginDataNU =LoginData.fetch("LoginDataNU");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.openList_NU()
		._atOpenOrdersPage()
		.openItem_NU_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_DeleteOrderClick()
		._atMyActiveOrderPage()
		.PleaseConfirmAlert_OK()
	
	;
				
} */
	@Test(groups={"Test_Script"}, description = "Delete an order with Rejected Status",priority=33)
	public void Delete_NormalUser_Reject() throws InterruptedException {	
		
		LoginData loginDataNU =LoginData.fetch("LoginDataNU");
		
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
		._atHomePage()
		.openList_NU()
		._atOpenOrdersPage()
		.rejectedItem_Click()
		._atMyActiveOrderPage()
		.myActiveOrder_DeleteOrderClick()
		._atMyActiveOrderPage()
		.PleaseConfirmAlert_OK()
	
	;
		
	}
	
	 
	 
	 /*  @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu through List"priority=20)
		public void submitOrder_Lists_Hamburger() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.HamburgerMenuClick()
			.searchOrLists_Hamburger()
			._atListsPage()
			.lists_OrderGuide()
			._atOrderGuide()
			.orderGuidePlusButton_Click()
			.orderGuideCreateLink_Click()
			.orderGuide_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		.myActiveOrder_alertClose();
		
			;
					
	}*/
	

	//---------------------April 6-------------------------------------


	/*
	@Test(groups={"Test_Script"}, description = "Submit Item Via submitOrder_MyCustomLists_Hamburger",priority=22)
	public void submitOrder_MyCustomLists_Hamburger() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData");	
		Start.asTester
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._atHomePage()
		.HamburgerMenuClick()
		.searchOrLists_Hamburger()
		._atListsPage()
		.lists_MyCustomLists()
		._atMyCustomListsPage()
		.customListstItem_Click()
		.customListsPlusBtn_Click()
		.customLists_CreateClick()
		.customLists_CartClick()
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
		}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test(groups={"Test_Script"}, description = "Submit Item Via Submitted after adding More Items From SharedList",priority=26)
	public void submitOrder_Submitted_AddMoreItems_SharedList() throws InterruptedException {	
		
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
		.myActiveOrder_AddMoreItems()
		._atListsPage()
		.lists_SharedLists()
		._atSharedListPage()
		.sharedListItem_Click()
		.sharedListPlusBtn_Click()
		.sharedLists_CartClick()
	    ._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
				
}*/
	  
	  
	
	  
	  
	  
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Test(groups={"Test_Script"}, description = "Creating a new order and submitting an order from MyLists")
	public void submitOrder_MyLists() throws InterruptedException {	
		
		LoginData loginData =LoginData.fetch("LoginData");	
		
		Start.asTester
		
		.goToLoginPage()
		.verifyLoginPage()
		.loginToApplication(loginData.UserName, loginData.Password)
		
		._atHomePage()
		.createNewOrder()
		
		._atCreateOrderPage()
		.createNewOrder_MyCustomLists()
		
		._atListsPage()
		.listItem_Click()
		.listPlusBtn_Click()
		.lists_CartClick()
		
		._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		
		;
		
		
		
		
}
	*/
	
	
	
/*	
	
		@Test(groups={"Test_Script"}, description = "Submit Item Via Lists")
		public void submitOrder_SyscoLists() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.createNewOrder()
			
			._atCreateOrderPage()
			.createNewOrder_MyCustomLists()
			
			._atListsPage()
			.syscoListItem_Click()
			.listPlusBtn_Click()
			.lists_CartClick()
			
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			
			._atCreateOrderPage()
			.createNewOrder_MyCustomLists()
			
			;
			
	}*/
		
		
		//----------------------March 31------
		

		/*@Test(groups={"Test_Script"}, description = "Submit Order Via Order Gide From Home Page")
		public void submitOrder_OrderGuide_Home() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.OrderGuide_Home()
			
			._atOrderGuide()
			.orderGuide_Click()
			.orderGuide_CartClick()
			
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			
			._atCreateOrderPage()
			.createNewOrder_MyCustomLists()
			
			;
			
			
		}*/
	
		
		
		/*
		@Test(groups={"Test_Script"}, description = "Search From Home Page")
		public void Search_Home() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			SearchData searchData=SearchData.fetch("SearchData");
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			
			._atHomePage()
			.searchKeyword_Home(searchData.keyword)
			
			._atOrderGuide()
			.orderGuide_Click()
			.orderGuide_CartClick()
			
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			
			._atCreateOrderPage()
			.createNewOrder_MyCustomLists()
			
			;
			
			    
		}*/
		
		
	/*	
		@Test(groups={"Test_Script"}, description = "Submit order via order guide from home")
		public void Search_Home() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
//			SearchData searchData=SearchData.fetch("SearchData");
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.OrderGuide_Home()
			._atOrderGuide()
			.orderGuidePlusButton_Click()
//			.orderGuideCreateLink_Click()
			.orderGuide_CartClick()
			.orderGuide_CartClick()
			
			._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			.myActiveOrder_alertClose()
			;
			
			
		}*/
		
/*		
		@Test(groups={"Test_Script"}, description = "Submit order via order guide from home")
		public void Search_Home() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
//			SearchData searchData=SearchData.fetch("SearchData");
			Start.asTester
			
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.searchKeyword_Home()
			;
			
			
		}*/
		
		
		/*@Test(groups={"Test_Script"}, description = "Modify order")
		public void submitOrder_OrderGuide() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.createNewOrder()
			._atCreateOrderPage()
			.createNewOrder_OrderGuide()
			._atOrderGuide()
			.orderGuide_Click()
			.orderGuide_CartClick()
			._atMyActiveOrderPage()
		
			
			
			
			  ;	
				
		}*/
	
	
	
	

	
	
	//---------------- APRIL 12 ----------------------------//
	
	
	
	
/*
	 @Test(groups={"Test_Script"}, description = "Submit Item Via Submitted after adding More Items From MyCustomList",priority=19)
	public void submitOrder_Submitted_AddMoreItems_MyCustomList() throws InterruptedException {	
		
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
		.myActiveOrder_AddMoreItems()
		._atListsPage()
		.lists_MyCustomLists()
		._atMyCustomListsPage()
		.customListstItem_Click()
		.customListsPlusBtn_Click()
		.customLists_CartClick()
	    ._atMyActiveOrderPage()
		.myActiveOrder_SubmitOrder()
		._atMyActiveOrderPage()
		.myActiveOrder_alertClose()
		;
				
}*/
	 
	 
	 /* @Test(groups={"Test_Script"}, description = "Submit Item Via Submitted after adding More Items From SyscoList",priority=19)
		public void submitOrder_Submitted_AddMoreItems_SyscoList() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.submittedList()
			._atSubmittedOrdersPage()
			.submittedItem_Click()
			._atSubmittedPage()
			.submitted_Modify()
			.ModifyOrder_Continue()
			._atMyActiveOrderPage()
			.myActiveOrder_AddMoreItems()
			._atListsPage()
			.lists_SyscoLists()
			._atSyscoListsPage()
			.syscoListItem_Click()
			.syscoListPlusBtn_Click()
			.syscoLists_CartClick()
		    ._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			;
					
	}*/
		/*@Test(groups={"Test_Script"}, description = "Submit Item Via Submitted after adding More Items From SharedList",priority=19)
		public void submitOrder_Submitted_AddMoreItems_SharedList() throws InterruptedException {	
			
			LoginData loginData =LoginData.fetch("LoginData");	
			Start.asTester
			.goToLoginPage()
			.verifyLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._atHomePage()
			.submittedList()
			._atSubmittedOrdersPage()
			.submittedItem_Click()
			._atSubmittedPage()
			.submitted_Modify()
			.ModifyOrder_Continue()
			._atMyActiveOrderPage()
			.myActiveOrder_AddMoreItems()
			._atListsPage()
			.lists_SharedLists()
			._atSharedListPage()
			.sharedListItem_Click()
			.sharedListPlusBtn_Click()
			.sharedLists_CartClick()
		    ._atMyActiveOrderPage()
			.myActiveOrder_SubmitOrder()
			._atMyActiveOrderPage()
			.myActiveOrder_alertClose()
			;
					
	}*/
	
	
	
	
	
	
	
	

 

		
	
}