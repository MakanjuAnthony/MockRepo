Action()
{

/************************* Accounts ***************************/
//	lr_start_transaction("WS01_00_Get_AccountByCustomerID");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_reg_save_param("Corr_CustomerID","LB=\"customerId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_isCogs","LB=\"isCogs\":","RB=}","NOTFOUND=warning","ORD=1",LAST);

	web_url("GetAccount",
		"URL={P_URL}/accounts/mine",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

//	lr_end_transaction("WS01_00_Get_AccountByCustomerID", LR_AUTO);

	lr_think_time(5);
	
	if(strcmp(lr_eval_string("{Corr_CustomerID}"),"")==0)
{
	lr_start_transaction("WS01_01_Create_New_Account");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_CustomerID","LB=\"customerId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("accounts", 
		"URL={P_URL}/accounts", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"isCogs\": false\n}", 
		LAST);
	
	lr_end_transaction("WS01_01_Create_New_Account", LR_AUTO);
	
	lr_think_time(2);
	
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\NewAccount_QA.txt" );

		fp=fopen( temp,"a+" );
		fprintf( fp,"\n OpCo, Customer_ID and UserID:%s	%s	%s",lr_eval_string("{P_OpCo}"),lr_eval_string("{Corr_CustomerID}"),lr_eval_string("{P_UserID}"));
		fclose( fp );
}
else
{
	goto endofWS;
}

	lr_think_time(5);
	
	lr_start_transaction("WS01_02_Update_Account");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_reg_save_param("Corr_CustomerID","LB=\"customerId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("updateaccount", 
		"URL={P_URL}/accounts/mine", 
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
	
	lr_end_transaction("WS01_02_Update_Account", LR_AUTO);
	
	lr_think_time(5);
	
/************************* End of Accounts ************************/


/************************* Start of Groups ************************/

for (i=1;i<=6;i++) 
{

	lr_start_transaction("WS01_03_Create_Groups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("CreateGroup", 
		"URL={P_URL}/groups", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"name\": \"{P_GroupName}\",\n \"type\": \"{P_Location}\",\n \"storage\": \"{P_StorageName}\",\n \"foodType\": \"{P_FoodType}\"\n}",
		LAST);
	
	lr_end_transaction("WS01_03_Create_Groups", LR_AUTO);
	
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\CreateGroups_QA.txt" );

		fp=fopen( temp,"a+" );
		fprintf( fp,"\n Group Id, Name, Storage, Type, OPCO and CustomerID :\t%s\t%s\t%s\t%s\t%s\t%s",lr_eval_string("{Corr_GroupID}"),lr_eval_string("{Corr_GroupName}"),lr_eval_string("{P_StorageName}"),lr_eval_string("{P_Location}"),lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"));
		fclose( fp );

	lr_think_time(2);
}
/*
	lr_start_transaction("WS02_02_GetGroups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID_2","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);
	web_reg_save_param("Corr_Storage","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Type","LB=\"type\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetGroups",
		"URL={P_URL}/groups",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS02_02_GetGroups", LR_AUTO);

	lr_think_time(2);

	lr_start_transaction("WS02_03_Get_Groups_By_ID");
	
	//web_add_header("Authorization","Bearer {P_OpCo}|PT0111|PT0111");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_Name","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_Storage","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_Type","LB=\"type\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetGroup",
		"URL={P_URL}/groups/{Corr_GroupID_1}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);
	
	lr_end_transaction("WS02_03_Get_Groups_By_ID", LR_AUTO);

	lr_think_time(1);
	
	lr_start_transaction("WS02_03_Get_Groups_By_ID");
	
	//web_add_header("Authorization","Bearer {P_OpCo}|PT0111|PT0111");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_Name","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_Storage","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_Type","LB=\"type\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetGroup",
		"URL={P_URL}/groups/{Corr_GroupID_2}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);
	
	lr_end_transaction("WS02_03_Get_Groups_By_ID", LR_AUTO);

	lr_think_time(1);

	lr_start_transaction("WS02_04_UpdateGroups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_FoodType","LB=\"type\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_custom_request("UpdateGroups", 
		"URL={P_URL}/groups/{Corr_GroupID_2}", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
//		"Body={\n \"name\": \"{P_GroupName}U\",\n \"storage\": \"{P_StorageName}2\",\n \"foodType\": \"{P_FoodType}\"\n}",
		"Body={\n \"name\": \"{P_GroupName}U\",\n \"storage\": \"{P_StorageName}2\",\n}",
		LAST);
	
	lr_end_transaction("WS02_04_UpdateGroups", LR_AUTO);	

*/
/************************* End of Groups ***************************/

/************************* Start of Supplier ************************/

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_SupplierID_1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_SupplierName_1","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_SupplierID_2","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);
	web_reg_save_param("Corr_SupplierName_2","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_url("SuppliersList",
		"URL={P_URL}/suppliers",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

if(strcmp(lr_eval_string("{Corr_SupplierID_1}"),"")==0)
{
	for (i=1;i<=10;i++)
	{
	
		lr_start_transaction("WS01_04_Create_New_Suppliers");
		
		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_reg_save_param("Corr_SupplierID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
		web_reg_save_param("Corr_SupplierName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
		web_custom_request("CreateNewSupplier",
			"URL={P_URL}/suppliers", 
			"Method=POST", 
			"TargetFrame=", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer={P_URL}/swagger", 
			"Snapshot=t4.inf", 
			"Mode=HTML", 
			"EncType=application/json", 
			"Body={\n \"name\": \"{P_SupplierName}\",\n \"contactInformation\": {\n  \"address\": \"{P_Address}\",\n  \"contactName\": \"{P_ContactName}\",\n  \"emailAddress\": \"{P_Email}\",\n  \"phoneNumber\": \"{P_PhoneNumber}\" },\n \"notes\": \"{P_Notes}\"\n}", 
			LAST);
		
		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\Create_New_Suppliers_QA.txt" );
	
			fp=fopen( temp,"a+" );
			fprintf( fp,"\n CustomerID :%s, Supplier_ID :%s, Supplier_Name :%s",lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_SupplierID}"),lr_eval_string("{Corr_SupplierName}"));
			fclose( fp );
		
		lr_end_transaction("WS01_04_Create_New_Suppliers", LR_AUTO);
		
		lr_think_time(2);

	}
}

/************************* End of Supplier ***************************/
endofWS:

	return 0;
}