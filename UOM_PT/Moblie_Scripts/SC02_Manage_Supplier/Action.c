Action()
{
	
	web_cleanup_cookies();
	
	web_cache_cleanup();
		
	web_set_sockets_option("SSL_VERSION", "TLS");

/*	web_reg_save_param("Corr_CustomerID","LB=\"id\":\"","RB=\",\"opco","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_OpCO","LB=\"opco\":{\"id\":\"","RB=\",\"name\"","NOTFOUND=warning","ORD=1",LAST);
	
	lr_start_transaction("SC02_01_Supplier_Login");
	
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

	lr_end_transaction("SC02_01_Supplier_Login", LR_AUTO);
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

		lr_start_transaction("SC02_01A_Supplier_Create_Account");
		
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
	
		lr_end_transaction("SC02_01A_Supplier_Create_Account", LR_AUTO);

	}
	
	lr_think_time(TT);
	
	lr_start_transaction("SC02_02_Supplier_Click_on_Suppliers");
	
//	web_add_header("Authorization","Bearer {P_OpCo}|{Corr_1CustomerID}|{P_UserID}");
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_Supplier","LB=\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_SupplierName","LB=\"name\":\"","RB=\",\"contactInformation\":","NOTFOUND=warning","ORD=All",LAST);

	web_reg_find("Text=suppliers",LAST);
		
	web_custom_request("suppliers",
		"URL={P_URL}/suppliers", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		LAST);
	
	countIDs=atoi(lr_eval_string("{Corr_Supplier_count}"));
		
		HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
		
		if (HttpRetCode == 200)
		{
			lr_end_transaction("SC02_02_Supplier_Click_on_Suppliers",LR_PASS);
		}
		else
		{
			lr_end_transaction("SC02_02_Supplier_Click_on_Suppliers",LR_FAIL);
		}
				
	lr_think_time(TT);

	count=0;
	
for(j=1;j<=4;j++)
{
		lr_start_transaction("SC02_03_Supplier_Add_Supplier");

		web_add_header("Origin","file:");

		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_reg_save_param("Corr_SupplierID","LB=\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=1",LAST);
		web_reg_save_param("Corr_SupplierName","LB=\"name\":\"","RB=\",\"","NOTFOUND=warning","ORD=1",LAST);

		web_custom_request("suppliers",
			"URL={P_URL}/suppliers", 
			"Method=POST", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer=", 
			"Snapshot=t3.inf", 
			"Mode=HTML", 
			"EncType=application/json", 
			"Body={\"name\":\"PTF_Supplier_{P_SupplierName}\",\"contactInformation\":{\"phoneNumber\":\"27042704\",\"address\":\"341 Laffayett St\",\"contactName\":\"Jr. Marketing Asscoiate\",\"emailAddress\":\"test@123.com\"},\"notes\":\"This is sample Noet to test the performance of the application... I hope this will help in adding and updating the supplier\"}", 
			LAST);
		
	if(strcmp(lr_eval_string("{Corr_SupplierGetID}"),"")==0)
	{ 	lr_end_transaction("SC02_03_Supplier_Add_Supplier",LR_FAIL); 	}

	else
	{	lr_end_transaction("SC02_03_Supplier_Add_Supplier",LR_PASS); 	

		lr_think_time(TT);
		
		lr_start_transaction("SC02_04_Supplier_Get_Suppliers_Details");
		
	//	web_add_header("Authorization","Bearer {P_OpCo}|{Corr_1CustomerID}|{P_UserID}");
		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_reg_save_param("Corr_SupplierGetID","LB=\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=1",LAST);
		web_reg_save_param("Corr_SupplierName","LB=\"name\":\"","RB=\",\"contactInformation\":","NOTFOUND=warning","ORD=1",LAST);
	
//		web_reg_find("Text=suppliers",LAST);
			
		web_custom_request("SupplierDetails",
			"URL={P_URL}/suppliers/{Corr_SupplierID}", 
			"Method=GET", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer=", 
			"Snapshot=t3.inf", 
			"Mode=HTML", 
			"EncType=application/json", 
			LAST);
		
			if(strcmp(lr_eval_string("{Corr_SupplierGetID}"),"")==0)
			{ 	lr_end_transaction("SC02_04_Supplier_Get_Suppliers_Details",LR_FAIL); 	}
			else
			{	lr_end_transaction("SC02_04_Supplier_Get_Suppliers_Details",LR_PASS); 	}
	}
}

	lr_think_time(TT);

	lr_start_transaction("SC02_02_Supplier_Click_on_Suppliers");
	
//	web_add_header("Authorization","Bearer {P_OpCo}|{Corr_1CustomerID}|{P_UserID}");
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_SupplierU","LB=\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_SupplierNameU","LB=\"name\":\"","RB=\",\"contactInformation\":","NOTFOUND=warning","ORD=All",LAST);

//	web_reg_find("Text=supplier",LAST);
		
	web_custom_request("suppliers",
		"URL={P_URL}/suppliers", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		LAST);
	
if(atoi(lr_eval_string("{Corr_SupplierU_count}"))>1)
{
	lr_end_transaction("SC02_02_Supplier_Click_on_Suppliers",LR_PASS);

	lr_think_time(TT);
	
	lr_start_transaction("SC02_05_Supplier_Edit_Supplier");
		
		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_reg_save_param("Corr_SupplierGetID_U","LB=\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=1",LAST);
		web_add_header("Origin","file://");
	
		web_custom_request("SupplierEdit", 
			"URL={P_URL}/suppliers/{Corr_SupplierU_1}", 
			"Method=PUT", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer=", 
			"Snapshot=t4.inf", 
			"Mode=HTML",		
			"Body={\"id\":\"\",\"name\":\"PTF_Supplier_{Corr_SupplierNameU_1}\",\"contactInformation\":{\"phoneNumber\":\"{P_PhoneNumber}\",\"address\":\"Updated Addres\",\"contactName\":\"Sr. Marketing Asscoiate\",\"emailAddress\":\"ds_wera@gmail123.com\"},\"notes\":\"This Sample Updated Supplier details... I hope this will help in adding and updating the supplier\"}", 
			"EncType=application/json",		
			LAST);
		
		HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
		
		if (HttpRetCode == 200)
		{
			lr_log_message("The script successfully edited First Supplier %s",lr_eval_string("{Corr_Supplier_1}"));
		
		lr_end_transaction("SC02_05_Supplier_Edit_Supplier", LR_AUTO);

		lr_think_time(TT);
		
		lr_start_transaction("SC02_04_Supplier_Get_Suppliers_Details");
		
	//	web_add_header("Authorization","Bearer {P_OpCo}|{Corr_1CustomerID}|{P_UserID}");
		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_reg_save_param("Corr_SupplierGetID","LB=\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=1",LAST);
		web_reg_save_param("Corr_SupplierName","LB=\"name\":\"","RB=\",\"contactInformation\":","NOTFOUND=warning","ORD=1",LAST);
	
//		web_reg_find("Text=suppliers",LAST);
			
		web_custom_request("SupplierDetails2",
			"URL={P_URL}/suppliers/{Corr_SupplierGetID_U}", 
			"Method=GET", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer=", 
			"Snapshot=t3.inf", 
			"Mode=HTML", 
			"EncType=application/json", 
			LAST);
		
			if(strcmp(lr_eval_string("{Corr_SupplierGetID}"),"")==0)
			{ 	lr_end_transaction("SC02_04_Supplier_Get_Suppliers_Details",LR_FAIL); 	}
			else
			{	lr_end_transaction("SC02_04_Supplier_Get_Suppliers_Details",LR_PASS); 	}

		}
		
		else
		{
			lr_log_message("The script failed to edit Supplier with http Request Header %d", HttpRetCode);
		}
			lr_think_time(TT);

		lr_start_transaction("SC02_06_Supplier_Delete_Supplier");

		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_add_header("Origin","file://");

		web_custom_request("DeleteFirstSupplier", 
			"URL={P_URL}/suppliers/{Corr_SupplierU_2}", 
			"Method=DELETE", 
			"Resource=0", 
			"Referer=", 
			"Snapshot=t5.inf", 
			"Mode=HTML", 
			LAST);
		
		HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);
		
		if (HttpRetCode == 204)
		{
			lr_log_message("The script successfully deleted First Supplier %s",lr_eval_string("{Corr_SupplierU_2}"));
		}
		
		else
		{
			lr_log_message("The script failed to delete Supplier with http Request Header %d", HttpRetCode);
		}
		
	lr_output_message(" Deleted ");
	
	lr_end_transaction("SC02_06_Supplier_Delete_Supplier", LR_AUTO); 
}
else
{
	lr_end_transaction("SC02_02_Supplier_Click_on_Suppliers",LR_FAIL);
}
	lr_think_time(TT);
/*
	lr_start_transaction("SC02_07_Supplier_Logout");
	
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

	lr_end_transaction("SC02_07_Supplier_Logout", LR_AUTO);
*/
	return 0;
}
	