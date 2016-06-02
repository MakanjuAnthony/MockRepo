char *strcat(char *, char *);
Action()
{	
	int count=30;
//	char Invbody[10000]="";

	web_cleanup_cookies();
	web_cache_cleanup( );
	web_set_max_html_param_len("2048");
	web_set_sockets_option("SSL_VERSION", "TLS");
	
	if ((InvbodyP1 = (char *)calloc(99999, sizeof(char))) == NULL) {

        lr_output_message ("Insufficient memory available");
        return -1;
    }
	
	if ((InvbodyP2 = (char *)calloc(99999, sizeof(char))) == NULL) {

        lr_output_message ("Insufficient memory available");
        return -1;
    }
	
/*	if ((InvbodyP3 = (char *)calloc(99999, sizeof(char))) == NULL) {

        lr_output_message ("Insufficient memory available");
        return -1;
    }
	
	if ((InvbodyP4 = (char *)calloc(999999, sizeof(char))) == NULL) {

        lr_output_message ("Insufficient memory available");
        return -1;
    }
*/	
	lr_output_message ("Memory allocated. Buffer address = %.8x", InvbodyP1);
	lr_output_message ("Memory allocated. Buffer address = %.8x", InvbodyP2);

/*	lr_start_transaction("SC04_01_Create_NS_Prod_Update_Inventory_Login");
	
	web_add_header("Authorization","Bearer ||");
	
	web_custom_request("login", 
		"URL={P_URL}/app/login", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"username\":\"{P_UserID}\",\"password\":\"{P_Password}\"}", 
		LAST);
	
	lr_end_transaction("SC04_01_Create_NS_Prod_Update_Inventory_Login", LR_AUTO);
*/	
	lr_think_time(TT);
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_CustomerID","LB=\"customerId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_url("GetAccountByCustomerAccount",
		"URL={P_WSURL}/accounts/mine",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);	


	if(strcmp(lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_CustomerID}"))==0)
    {
        goto CheckInventory;         
	}
        
	else
	{
		goto CreateAccount;
	}

CheckInventory:

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_LocationID","LB={\"groupId\":\"","RB=\",\"sequence","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_ExpenseCategoryID","LB=\"groups\":[{\"groupId\":\"","RB=\"},{\"groupId","NOTFOUND=warning","ORD=All",LAST);
	
	web_custom_request("Get_Inventory",
		"URL={P_WSURL}/inventories/current?withAllProductAttributes=true", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Mode=HTML", 
		"EncType=application/json", 
		LAST);
	

	if(strcmp(lr_eval_string("{Corr_InventoryID}"),"")==0)
	{ 	
		lr_output_message("There is no open Inventory");
		
		goto CreateInventory;
	}
	
	else
	{
		lr_output_message("Cleaning of Inventory %s",lr_eval_string("{P_CustomerID}"));
		
		web_custom_request("DataCleanup",
			"URL=http://uom-qa.na.sysco.net:8081/tasks/cleanupDataForAccount?opCo={P_OpCo}&customerId={P_CustomerID}", 
			"Method=POST", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer=", 
			"Mode=HTML", 
			"EncType=application/json", 
			LAST);
		
	}

CreateAccount:
	
	lr_start_transaction("SC04_02_Create_NS_Prod_Update_Inventory_Create_New_Account");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
//	//customerId":"228122","isCogs
	web_reg_save_param("Corr_CustomerID","LB=customerId\":\"","RB=\",\"isCogs","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("accounts", 
		"URL={P_WSURL}/accounts", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_WSURL}/swagger", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"isCogs\": true\n}", 
		LAST);
	
	lr_end_transaction("SC04_02_Create_NS_Prod_Update_Inventory_Create_New_Account", LR_AUTO);
	
	lr_think_time(TT);

	if(strcmp(lr_eval_string("{Corr_CustomerID}"),"")==0)
	{ 	
		lr_output_message("Account Not created for: %s", lr_eval_string("{P_CustomerID}"));
		
		goto EndofScenario;
	}
	
	
CreateInventory:
	
	lr_start_transaction("SC04_03_Create_NS_Prod_Update_Inventory_Create_Supplier");	
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	//{"id":"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c","name
	
	web_reg_save_param("Corr_SupplierID","LB={\"id\":\"","RB=\",\"name\":","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_SupplierName","LB=\"name\":\"","RB=\",\"","NOTFOUND=warning","ORD=1",LAST);

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
	
	lr_end_transaction("SC04_03_Create_NS_Prod_Update_Inventory_Create_Supplier",LR_AUTO);	
	
	for (i=0;i<count;i++) 
	{
//		char Invbody[10000]="";
//		char Invbody2[1000]="";
//		char Invbody3[1000]="";
	
		lr_start_transaction("SC04_04_Create_NS_Prod_Update_Inventory_Add_Non_Sysco_Items");

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
		
		lr_end_transaction("SC04_04_Create_NS_Prod_Update_Inventory_Add_Non_Sysco_Items",LR_AUTO);

		lr_think_time(1);
		
		if(strcmp(lr_eval_string("{Corr_ProductID_NonSysco}"),"")==0)
	    {
	        return 0;         
		}
        
		if(i<1)
		{									 
			sprintf(Invbody,"Body={\"items\": [ { \"id\": \"%s\",\"storageFlag\":\"\"}]}",lr_eval_string("{Corr_ProductID_NonSysco}"));
			sprintf(Invbody2,"Body={\"groups\": [ { \"name\": \"PT_loc_C\" , \"foodType\": \"C\" , \"items\": [\"%s\"]}]}",lr_eval_string("{Corr_ProductID_NonSysco}"));		
			sprintf(Invbody3,"Body={\"groups\": [ { \"name\": \"Exp_Food\" , \"foodType\": \"food\" , \"items\": [\"%s\"]}]}",lr_eval_string("{Corr_ProductID_NonSysco}"));	

			lr_start_transaction("SC04_05_Create_NS_Prod_Update_Inventory_Add_From_Scratch");
		
			web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
			
			web_reg_save_param("Corr_InventoryID","LB=\"id\":\"","RB=\",\"opCo","NOTFOUND=warning","ORD=1",LAST);
		
			web_custom_request("scratch", 
				"URL={P_URL}/app/inventory/setup/scratch", 
				"Method=POST", 
				"Resource=0", 
				"RecContentType=application/json", 
				"Referer=", 
				"Snapshot=t4.inf", 
				"Mode=HTML", 
				"EncType=application/json", 
//				"Body={InvBody0}",
				Invbody,				
				LAST);
			
			lr_end_transaction("SC04_05_Create_NS_Prod_Update_Inventory_Add_From_Scratch", LR_AUTO);
			
			lr_think_time(TT);
			
			lr_start_transaction("SC04_06_Create_NS_Prod_Update_Inventory_CreateFirstLocation");
			
			web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
			
			web_reg_save_param("Corr_LocationID","LB={\"groupId\":\"","RB=\",\"sequence","NOTFOUND=warning","ORD=All",LAST);
		
			web_custom_request("locations", 
				"URL={P_URL}/app/inventory/setup/locations", 
				"Method=POST", 
				"Resource=0", 
				"RecContentType=application/json", 
				"Referer=", 
				"Snapshot=t5.inf", 
				"Mode=HTML", 
				"EncType=application/json", 
//				"Body={InvBody00}",
				Invbody2,				
				LAST);
			
			lr_end_transaction("SC04_06_Create_NS_Prod_Update_Inventory_CreateFirstLocation", LR_AUTO);
			
			lr_think_time(TT);
		
			lr_start_transaction("SC04_07_Create_NS_Prod_Update_Inventory_CreateExpenseCategoryFood");
			
			web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
			
			//"groups":[{"groupId":"8a105f7c-60bc-4d8c-886f-48bf42392f9d"},{"groupId
			
			web_reg_save_param("Corr_ExpenseCategoryID","LB=\"groups\":[{\"groupId\":\"","RB=\"},{\"groupId","NOTFOUND=warning","ORD=1",LAST);
//			{"id":"1f9d7d07-3ef1-4735-ab33-22e78a5f2303","opCo":"
			web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=1",LAST);
			web_reg_save_param("Corr_ProductID_NonSysco_All","LB=\"id\":\"","RB=\",\"groups","NOTFOUND=warning","ORD=All",LAST);
		
			web_custom_request("expensecategories", 
				"URL={P_URL}/app/inventory/setup/expensecategories", 
				"Method=POST", 
				"Resource=0", 
				"RecContentType=application/json", 
				"Referer=", 
				"Snapshot=t6.inf", 
				"Mode=HTML", 
				"EncType=application/json", 
//				"Body={InvBody000}",
				Invbody3,				
				LAST);
		
			lr_end_transaction("SC04_07_Create_NS_Prod_Update_Inventory_CreateExpenseCategoryFood", LR_AUTO);
			
			web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
			web_reg_save_param("Corr_GetInventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=1",LAST);
	
			web_custom_request("Get_Inventory",
				"URL={P_URL}/inventories/current?withAllProductAttributes=true", 
				"Method=GET", 
				"Resource=0", 
				"RecContentType=application/json", 
				"Referer=", 
				"Snapshot=t1.inf", 
				"Mode=HTML", 
				"EncType=application/json", 
				LAST);
			
		sprintf(Invbody,"Body={\"items\": [ { \"id\": \"%s\",\"groups\": [ { \"groupId\": \"%s\" },{ \"groupId\": \"%s\",\"sequence\": \"%d\" } ] }",lr_eval_string("{Corr_ProductID_NonSysco}"),lr_eval_string("{Corr_ExpenseCategoryID}"),lr_eval_string("{Corr_LocationID_1}"),i);
		strcat(InvbodyP1, Invbody);
		strcat(InvbodyP2, Invbody);
		}

		else
		{	
			if(i==10)
			{
				lr_start_transaction("SC04_08_Create_NS_Prod_Update_Inventory_CreateNewLocation");
			
				web_reg_save_param("Corr_LocationID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);
				
				web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
			
				web_custom_request("groups", 
					"URL={P_URL}/groups", 
					"Method=POST", 
					"Resource=0", 
					"RecContentType=application/json", 
					"Referer=", 
					"Snapshot=t14.inf", 
					"Mode=HTML", 
					"EncType=application/json", 
					"Body={\"id\":\"\",\"type\":\"location\",\"name\":\"{P_LocationName}\",\"storage\":\"{P_Storage}\"}", 
					LAST);
				lr_end_transaction("SC04_08_Create_NS_Prod_Update_Inventory_CreateNewLocation", LR_AUTO);
			}
			lr_output_message("Looping: %d", i);
			if(i==20)
			{
				lr_start_transaction("SC04_08_Create_NS_Prod_Update_Inventory_CreateNewLocation");
			
				web_reg_save_param("Corr_LocationID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);
				
				web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
			
				web_custom_request("groups", 
					"URL={P_URL}/groups", 
					"Method=POST", 
					"Resource=0", 
					"RecContentType=application/json", 
					"Referer=", 
					"Snapshot=t14.inf", 
					"Mode=HTML", 
					"EncType=application/json", 
					"Body={\"id\":\"\",\"type\":\"location\",\"name\":\"{P_LocationName}\",\"storage\":\"{P_Storage}\"}", 
					LAST);
				lr_end_transaction("SC04_08_Create_NS_Prod_Update_Inventory_CreateNewLocation", LR_AUTO);

			}
	
			lr_think_time(1);

			sprintf(InvbodyP1, InvbodyP2);
			sprintf(Invbody,",{ \"id\": \"%s\",\"groups\": [ { \"groupId\": \"%s\" },{ \"groupId\": \"%s\",\"sequence\": \"%d\",\"quantity\": 10 } ] }",lr_eval_string("{Corr_ProductID_NonSysco}"),lr_eval_string("{Corr_ExpenseCategoryID}"),lr_eval_string("{Corr_LocationID_1}"),i);
			strcat(InvbodyP1, Invbody);
			strcat(InvbodyP2, Invbody);
			sprintf(Invbody," ] } ");
			strcat(InvbodyP1, Invbody);
//		lr_output_message("P1 -> Body=%s", InvbodyP1);
//		lr_output_message("P2 -> Body=%s", InvbodyP2);
			
			lr_start_transaction("SC04_09_Create_NS_Prod_Update_Inventory_UpdateInventoryWithNewItem");
		
			web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
			
			web_custom_request("{Corr_InventoryID}_5", 
				"URL={P_URL}/inventories/{Corr_InventoryID}", 
				"Method=PUT", 
				"Resource=0", 
				"RecContentType=application/json", 
				"Referer=", 
				"Snapshot=t16.inf", 
				"Mode=HTML", 
		//		"Body={InvBody0}",
				InvbodyP1,
				"EncType=application/json",
				LAST);
		
//				free(InvbodyP1);
				
			lr_end_transaction("SC04_09_Create_NS_Prod_Update_Inventory_UpdateInventoryWithNewItem", LR_AUTO);
		
			lr_think_time(TT);
			
			lr_start_transaction("SC04_10_Create_NS_Prod_Update_Inventory_GetCurrentInventory");
		
			web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
			web_reg_save_param("Corr_GetInventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=ALL",LAST);
			web_reg_save_param("Corr_ProductID","LB={\"id\":\"","RB=\",\"groups","NOTFOUND=warning","ORD=ALL",LAST);
			
			web_custom_request("expensecategories",
				"URL={P_URL}/inventories/current?withAllProductAttributes=true", 
				"Method=GET", 
				"Resource=0", 
				"RecContentType=application/json", 
				"Referer=", 
				"Snapshot=t4.inf", 
				"Mode=HTML", 
				"EncType=application/json",  
				LAST);
			
			lr_end_transaction("SC04_10_Create_NS_Prod_Update_Inventory_GetCurrentInventory", LR_AUTO);
			
			lr_think_time(TT);

		}
		
	}

	lr_think_time(TT);
	
	lr_start_transaction("SC04_10_Create_NS_Prod_Update_Inventory_GetCurrentInventory");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=ALL",LAST);

	web_reg_save_param("Corr_ProductID","LB={\"id\":\"","RB=\",\"groups","NOTFOUND=warning","ORD=ALL",LAST);
	
	web_custom_request("expensecategories",
		"URL={P_URL}/inventories/current?withAllProductAttributes=true", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json",  
		LAST);
	
	lr_end_transaction("SC04_10_Create_NS_Prod_Update_Inventory_GetCurrentInventory", LR_AUTO);
	
	lr_think_time(TT);
	
/*	lr_start_transaction("SC04_11_Create_NS_Prod_Update_Inventory_Logout");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("logout", 
		"URL={P_URL}/app/logout", 
		"Method=POST", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t20.inf", 
		"Mode=HTML", 
		"EncType=", 
		LAST);
	
	lr_end_transaction("SC04_11_Create_NS_Prod_Update_Inventory_Logout", LR_AUTO);
*/

EndofScenario:
	return 0;
}