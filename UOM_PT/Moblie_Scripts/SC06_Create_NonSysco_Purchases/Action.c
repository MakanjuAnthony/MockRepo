Action()
{
	
	web_cleanup_cookies();
	web_cache_cleanup( );
	web_set_max_html_param_len("1024");
	web_set_sockets_option("SSL_VERSION", "TLS");
	
	lr_start_transaction("SC06_01_Create_Purchases_Login");
	
	web_add_header("Authorization","Bearer ||");

	web_reg_save_param("Corr_CustomerID","LB=\"id\":\"","RB=\",\"opco","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_OpCO","LB=\"opco\":{\"id\":\"","RB=\",\"name\"","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("login",
		"URL={P_URL}/app/login", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"username\":\"{P_UserID}\",\"password\":\"{P_Password}\"}", 
		LAST);
	
	lr_end_transaction("SC06_01_Create_Purchases_Login", LR_AUTO);
	
	lr_think_time(TT);
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_CustomerID","LB=\"customerId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_url("GetAccountByCustomerAccount",
		"URL={P_QAURL}/accounts/mine",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);	


	if(strcmp(lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_CustomerID}"))==0)
    {
        goto CreatePurchase;         
	}
        
	else
	{
		goto CreateAccount;
	}
	
CreateAccount:
	
	lr_start_transaction("SC06_02_Create_Purchases_CreateAccount");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("accounts", 
		"URL={P_QAURL}/accounts", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_QAURL}/swagger", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"isCogs\": true\n}", 
		LAST);
	
	lr_end_transaction("SC06_02_Create_Purchases_CreateAccount", LR_AUTO);

	lr_think_time(TT);
	
CreatePurchase:
	
	lr_start_transaction("SC06_03_Create_Purchases_CreateSupplier");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	//{"id":"5ced9cda-9a01-4539-b14a-419fb64182c9","name
	
	web_reg_save_param("Corr_SupplierID","LB={\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("suppliers", 
		"URL={P_URL}/suppliers", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"id\":\"\",\"name\":\"PT_Supplier_{P_Date}\",\"contactInformation\":{\"phoneNumber\":\"345 345 4567\",\"address\":\"28 main st\",\"contactName\":\"Mr tester\",\"emailAddress\":\"mtester@tester.com\"},\"notes\":\"Sample text\"}", 
		LAST);
	
	lr_end_transaction("SC06_03_Create_Purchases_CreateSupplier", LR_AUTO);
	
	lr_think_time(TT);
	
	lr_start_transaction("SC06_04_Create_Purchases_CreateNSProduct");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	//cec00f98-a43d-423d-a1b6-4632e061e056
	web_reg_save_param("Corr_NSProductName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_MaterialID","LB=\"materialId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_ProductID_NonSysco","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_custom_request("nonsysco", 
		"URL={P_URL}/products/nonsysco", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"name\":\"PT_Prod_{P_Date}\",\"supplier\":\"{Corr_SupplierID}\",\"materialId\":\"NSP_MAT_{P_Date}\",\"brand\":\"Pbrand_{P_Date}\",\"nickName\":\"\",\"averageWeightPerCase\":{P_Number},\"packSize\":{\"pack\":\"{P_Number}\",\"size\":\"{P_Number}\",\"uom\":\"\"},\"type\":\"nonsysco\"}", 
		LAST);
	
	lr_end_transaction("SC06_04_Create_Purchases_CreateNSProduct", LR_AUTO);
	
	lr_think_time(TT);
	
	lr_start_transaction("SC06_05_Create_Purchases_CreateExpenseCategory");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_ExpenseCategoryID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_custom_request("CreateExpenseCategory",
		"URL={P_QAURL}/groups", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_QAURL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"name\": \"Exp_Food\",\n \"type\": \"expenseCategory\",\n \"foodType\": \"food\"\n}",
		LAST);

	lr_end_transaction("SC06_05_Create_Purchases_CreateExpenseCategory", LR_AUTO);
	
	lr_think_time(TT);

	lr_start_transaction("SC06_06_Create_Purchases_CreatePurchase");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_DeletedStatus","LB=\"deleted\":","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_PurchaseID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_SupplierID","LB=\"supplier\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_custom_request("purchases", 
		"URL={P_URL}/purchases", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"supplier\":\"{Corr_SupplierID}\",\"invoiceNumber\":\"PINV_{P_Date}\",\"date\":\"{P_Inv_Time}\",\"invoiceTotal\":100,\"expenseCategory\":\"{Corr_ExpenseCategoryID}\",\"expenseAmount\":\"100\",\"items\":[]}", 
		LAST);
	
	lr_end_transaction("SC06_06_Create_Purchases_CreatePurchase", LR_AUTO);
	
	lr_think_time(TT);

	lr_start_transaction("SC06_07_Create_Purchases_GetAllPurchasesTimePeriod");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_PurchaseID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	web_reg_save_param("Corr_SupplierID","LB=\"supplier\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	
	web_url("GetAllPurchaseWithDateRange",
		"URL={P_QAURL}/purchases?withSupplierDefinitions=true&fromDate={P_StartDate}&toDate={P_EndDate}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);
	
	lr_end_transaction("SC06_07_Create_Purchases_GetAllPurchasesTimePeriod", LR_AUTO);
	
	lr_think_time(TT);

	lr_start_transaction("SC06_08_Create_Purchases_Logout");

	web_add_header("Authorization","Bearer {P_OpCo}|{Corr_CustomerID}|{P_UserID}");

	web_custom_request("logout", 
		"URL={P_URL}/app/logout", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=", 
		LAST);
	
	lr_end_transaction("SC06_08_Create_Purchases_Logout", LR_AUTO);

	return 0;
}