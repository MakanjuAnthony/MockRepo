package com.tests;

import org.omg.CORBA._PolicyStub;


import org.testng.annotations.Test;

import com.components.entities.Start;
import com.components.yaml.SearchData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;

public class LegacyTestSuite3 extends Initiator{

	
	@Test(groups={"Test_Script"}, description = "Try to delete an order from historical list-Delivered",priority=21)
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




	@Test(groups={"Test_Script"}, description = "Try to delete an order from Historical list - Canceled ",priority=22)
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


	
	@Test(groups={"Test_Script"}, description = "Try to modify an Order in Submitted Status before cutoff time and Place Order",priority=23)
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
	}




	@Test(groups={"Test_Script"}, description = "Delete an order with Open Status",priority=24)
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
	 
	@Test(groups={"Test_Script"}, description = "Delete an order with Rejected Status",priority=25)
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
	

	@Test(groups={"Test_Script"}, description = "Modify order with Pending approval status of Normal User",priority=26)
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
	

	@Test(groups={"Test_Script"}, description = "Delete order with Pending approval status of Normal User",priority=27)
	public void NormalUser_Delete_PendingApproval() throws InterruptedException {
	
	LoginData loginDataNU =LoginData.fetch("LoginData");
	
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

	
}
