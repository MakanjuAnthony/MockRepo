Action()
{
	
	web_cleanup_cookies();
	
	web_cache_cleanup();
		
	web_set_sockets_option("SSL_VERSION", "TLS");

/*	web_reg_save_param("Corr_CustomerID","LB=\"id\":\"","RB=\",\"opco","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_OpCO","LB=\"opco\":{\"id\":\"","RB=\",\"name\"","NOTFOUND=warning","ORD=1",LAST);
	
	lr_start_transaction("SC01_01_Location_Login");
	
	web_add_header("Authorization","Bearer |");

	web_add_header("Origin","file://");
	
	web_reg_find("Text=locations",LAST);
	
	web_custom_request("login", 
		"URL={P_URL}/app/login", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"username\":\"{P_UserID}\",\"password\":\"{P_Password}\"}",
		LAST);
	
	HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
	
	if (HttpRetCode == 200)
	{
		lr_log_message("The script successfully completed login");
	}
	else
	{
		lr_log_message("The script failed to complete login with http Request Header %d", HttpRetCode);
	}

	lr_end_transaction("SC01_01_Location_Login", LR_AUTO);
*/	
	lr_think_time(TT);

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_CustomerID1","LB=\"customerId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_url("GetAccountByCustomerAccount",
		"URL={P_WSURL}/accounts/mine",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);	

	if(strcmp(lr_eval_string("{Corr_CustomerID1}"),"")==0)
    {
		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_reg_save_param("Corr_CustomerID","LB=\"customerId\":\"","RB=\",\"isCogs","NOTFOUND=warning","ORD=1",LAST);
	
		lr_start_transaction("SC01_01A_Location_Create_Account");
		
		web_custom_request("accounts", 
			"URL={P_WSURL}/accounts", 
			"Method=POST", 
			"TargetFrame=", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer={P_URL}/swagger", 
			"Snapshot=t4.inf", 
			"Mode=HTML", 
			"EncType=application/json", 
			"Body={\n \"isCogs\": true\n}", 
			LAST);
	
		lr_end_transaction("SC01_01A_Location_Create_Account", LR_AUTO);
	}
	
	lr_think_time(2);
	
	lr_start_transaction("SC01_02_Location_Click_on_ExpenseCategory");

//	web_add_header("Authorization","Bearer {Corr_1OpCO}|{Corr_1CustomerID}|{P_UserID}");
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_reg_save_param("Corr_ExpenseCategoryIDs","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
//	web_reg_find("Text=expenseCategory",LAST);
		
	web_custom_request("ExpenseCategory",
		"URL={P_URL}/groups?type=expenseCategory", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		LAST);
	
		HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
		
		if (HttpRetCode == 200)
		{
			lr_end_transaction("SC01_02_Location_Click_on_ExpenseCategory",LR_PASS);
		}
		else
		{
			lr_end_transaction("SC01_02_Location_Click_on_ExpenseCategory",LR_FAIL);
		}
		
	lr_think_time(TT);

	lr_start_transaction("SC01_03_Location_Add_expenseCategory");
		
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_ExpenseCategoryID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
		
	web_custom_request("ExpenseCategory_1",
		"URL={P_URL}/groups", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"id\":\"\",\"type\":\"expenseCategory\",\"name\":\"PT_Exp_{P_LocationId}\",\"foodType\":\"food\"}", 
		LAST);
	
	HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
	
	if (HttpRetCode == 201)
	{
		lr_log_message("The script successfully created Expense Category");
		
		lr_end_transaction("SC01_03_Location_Add_expenseCategory",LR_PASS);
	}
	else
	{
		lr_log_message("The script failed to create Expense Category with http Request Header %d", HttpRetCode);
		
		lr_end_transaction("SC01_03_Location_Add_expenseCategory",LR_FAIL);
	}
		
	lr_think_time(TT);

	lr_start_transaction("SC01_04_Location_Click_on_Locations");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_LocationIDs","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_Storages","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
//	web_reg_find("Text=location",LAST);
		
	web_custom_request("Locations",
		"URL={P_URL}/groups?type=location", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		LAST);
	
		HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
		
		if (HttpRetCode == 200)
		{
			lr_end_transaction("SC01_04_Location_Click_on_Locations",LR_PASS);
		}
		else
		{
			lr_end_transaction("SC01_04_Location_Click_on_Locations",LR_FAIL);
		}
		
	lr_think_time(TT);

for(j=1;j<=4;j++)
{
		lr_start_transaction("SC01_05_Location_Create_Location");
		
		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_reg_save_param("Corr_LocationID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
		web_reg_save_param("Corr_Storage","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
		web_reg_save_param("Corr_LocName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
//		web_reg_find("Text=location",LAST);
		
		web_custom_request("groups",
			"URL={P_URL}/groups", 
			"Method=POST", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer=", 
			"Snapshot=t4.inf", 
			"Mode=HTML", 
			"EncType=application/json", 
			"Body={\"id\":\"\",\"type\":\"location\",\"name\":\"PT_Loc_{P_LocationId}\",\"storage\":\"{P_Storage}\"}", 
			LAST);
	
		if(strcmp(lr_eval_string("{Corr_LocationID}"),"")==0)
		{ 	lr_end_transaction("SC01_05_Location_Create_Location",LR_FAIL); 	}
	
		else
		{	lr_end_transaction("SC01_05_Location_Create_Location",LR_PASS); 	
	
			lr_think_time(TT);
			
			lr_start_transaction("SC01_06_Location_Get_Location_Details");
			
		//	web_add_header("Authorization","Bearer {P_OpCo}|{Corr_1CustomerID}|{P_UserID}");
			web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
			
			web_reg_save_param("Corr_LocationGetID","LB=\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=1",LAST);
			web_reg_save_param("Corr_LocationGetName","LB=\"name\":\"","RB=\",\"","NOTFOUND=warning","ORD=1",LAST);
		
			web_reg_find("Text=location",LAST);
				
			web_custom_request("LocationDetails",
				"URL={P_URL}/groups/{Corr_LocationID}", 
				"Method=GET", 
				"Resource=0", 
				"RecContentType=application/json", 
				"Referer=", 
				"Snapshot=t3.inf", 
				"Mode=HTML", 
				"EncType=application/json", 
				LAST);
			
				if(strcmp(lr_eval_string("{Corr_LocationGetID}"),"")==0)
				{ 	lr_end_transaction("SC01_06_Location_Get_Location_Details",LR_FAIL); 	}
				else
				{	lr_end_transaction("SC01_06_Location_Get_Location_Details",LR_PASS); 	}
		}
}
	
	
/*	lr_start_transaction("SC01_06_Location_Get_LocationByID");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_find("Text=location",LAST);
		
		web_custom_request("groups",
			"URL={P_URL}/groups/{Corr_LocationID}", 
			"Method=GET", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer=", 
			"Snapshot=t4.inf", 
			"Mode=HTML", 
			"EncType=application/json",  
			LAST);
	
		HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
		
		if (HttpRetCode == 200)
		{
			lr_log_message("The script successfully get location");
			lr_end_transaction("SC01_06_Location_Get_LocationByID",LR_AUTO);
		}
		else
		{
			lr_log_message("The script failed to get location with http Request Header %d", HttpRetCode);
			lr_end_transaction("SC01_06_Location_Get_LocationByID",LR_AUTO);
		}
*/		
	lr_think_time(TT);

	lr_start_transaction("SC01_04_Location_Click_on_Locations");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_LocationIDs_U","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_Storages_U","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
//	web_reg_find("Text=location",LAST);
		
	web_custom_request("Locations",
		"URL={P_URL}/groups?type=location", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		LAST);
	
if(atoi(lr_eval_string("{Corr_LocationIDs_U_count}"))>1)
{
			lr_end_transaction("SC01_04_Location_Click_on_Locations",LR_PASS);
		
	lr_think_time(TT);

	lr_start_transaction("SC01_07_Location_Edit_location");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_find("Text=location",LAST);
	
	web_custom_request("EditLocation",
		"URL={P_URL}/groups/{Corr_LocationIDs_U_1}", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		"Body={\"id\":\"{Corr_LocationIDs_U_1}\",\"type\":\"location\",\"name\":\"PT_Loc_U_{Corr_LocName}\",\"storage\":\"{Corr_Storages_U_1}\"}", 
		LAST);
	
	HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
	
	if (HttpRetCode == 200)
	{
		lr_log_message("The script successfully edited location : %d ", lr_eval_string("{P_LocationId}"));
	}
	else
	{
		lr_log_message("The script failed to edit location with http Request Header %d", HttpRetCode);
	}
	
	lr_end_transaction("SC01_07_Location_Edit_location",LR_AUTO);
	
}
else
{
	lr_end_transaction("SC01_04_Location_Click_on_Locations",LR_FAIL);
}
	lr_think_time(TT);

	lr_start_transaction("SC01_04_Location_Click_on_Locations");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_LocationIDs","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_Storages","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
//	web_reg_find("Text=location",LAST);
		
	web_custom_request("Locations",
		"URL={P_URL}/groups?type=location", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		LAST);
	
		HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
		
		if (HttpRetCode == 200)
		{
			lr_end_transaction("SC01_04_Location_Click_on_Locations",LR_PASS);
		}
		else
		{
			lr_end_transaction("SC01_04_Location_Click_on_Locations",LR_FAIL);
		}
		
	lr_think_time(TT);
	
if(atoi(lr_eval_string("{Corr_LocationIDs_count}"))>1)
{

	lr_start_transaction("SC01_08_Location_Delete");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_custom_request("DeleteLocation", 
		"URL={P_URL}/groups/{Corr_LocationIDs_1}", 
		"Method=DELETE", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t6.inf", 
		"Mode=HTML", 
		LAST);
	
	HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
	
	if (HttpRetCode == 204)
	{
		lr_log_message("The script successfully deleted expenseCategorylocation");
		lr_output_message(" Deleted ");
	}
	else
	{
		lr_log_message("The script failed to delete location with http Request Header %d", HttpRetCode);
	}

	lr_end_transaction("SC01_08_Location_Delete",LR_AUTO);
}
	lr_think_time(TT);

/*	lr_start_transaction("SC01_09_Location_Logout");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("logout", 
		"URL={P_URL}/app/logout", 
		"Method=POST", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=", 
		LAST);

	lr_end_transaction("SC01_09_Location_Logout", LR_AUTO);
*/
	return 0;
}
	