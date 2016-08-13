package com.tests;

import org.omg.CORBA._PolicyStub;


import org.testng.annotations.Test;

import com.components.entities.Start;
import com.components.yaml.SearchData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;

public class LegacyTestSuite2 extends Initiator{
	
		@Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Inventory",priority=11)
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
		
		
		@Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> Inventory",priority=12)
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
		
		
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> OrderGuide",priority=13)
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
		
		
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> MyCustomLists",priority=14)
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
		
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> SyscoLists",priority=15)
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
		
		
		 @Test(groups={"Test_Script"}, description = "Submit Item From Hamburger Menu - Lists --> SharedLists",priority=16)
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
		 
		 
		 @Test(groups={"Test_Script"}, description = "Reorder Item Via Historical- Delivered",priority=17)
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
		 
		 
		 @Test(groups={"Test_Script"}, description = "Submit Order by Normal User and MA approves Item",priority=18)
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
		
		
			@Test(groups={"Test_Script"}, description = "Submit Order by Normal User and MA rejects Item",priority=19)
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
		
	
		
			
			@Test(groups={"Test_Script"}, description = "Modify the open item by adding More Items From Orderguide",priority=20)
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
	

}
