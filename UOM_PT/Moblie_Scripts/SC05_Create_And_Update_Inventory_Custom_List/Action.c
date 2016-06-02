Action()
{

	web_cleanup_cookies();
	web_cache_cleanup( );
	web_set_max_html_param_len("1024");
	web_set_sockets_option("SSL_VERSION", "TLS");
	
	if ((InvbodyP1 = (char *)calloc(999999, sizeof(char))) == NULL) {

        lr_output_message ("Insufficient memory available");
        return -1;
    }

    lr_output_message ("Memory allocated. Buffer address = %.8x", InvbodyP1);
	
	lr_start_transaction("SC05_01_Create_And_Update_Inventory_Custom_List_Login");
	
	web_add_header("Authorization","Bearer ||");
	
	web_reg_save_param("Corr_CustomerID","LB=\"id\":\"","RB=\",\"opco","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_OpCO","LB=\"opco\":{\"id\":\"","RB=\",\"name\"","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("login",
		"URL={P_URL}/app/login", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTTP", 
		"EncType=application/json", 
		"Body={\"username\":\"{P_UserID}\",\"password\":\"{P_Password}\"}", 
		LAST);
	
	web_add_header("Authorization","Bearer ||{P_UserID}");

	web_custom_request("user", 
		"URL={P_URL}/app/user", 
		"Method=GET", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t1.inf", 
		LAST);
	
	lr_end_transaction("SC05_01_Create_And_Update_Inventory_Custom_List_Login", LR_AUTO);
	
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
	
	lr_start_transaction("SC05_02_Create_And_Update_Inventory_Custom_List_Get_Inventory");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_OriginalQuantity","LB=quantity\":","RB=,\"quantityUom","NOTFOUND=warning","ORD=All",LAST);
	
	web_custom_request("Get_Inventory",
		"URL={P_WSURL}/inventories/current?withAllProductAttributes=true", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Mode=HTML", 
		"EncType=application/json", 
		LAST);
	
	lr_end_transaction("SC05_02_Create_And_Update_Inventory_Custom_List_Get_Inventory", LR_AUTO);

	lr_think_time(TT);

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
	
	lr_start_transaction("SC05_03_Create_And_Update_Inventory_Custom_List_Create_New_Account");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

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
	
	lr_end_transaction("SC05_03_Create_And_Update_Inventory_Custom_List_Create_New_Account", LR_AUTO);

	lr_think_time(TT);
	
	if(strcmp(lr_eval_string("{Corr_CustomerID}"),"")==0)
	{ 	
		lr_output_message("Account Not created for: %s", lr_eval_string("{P_CustomerID}"));
		
		goto EndofScenario;
	}
	
	
CreateInventory:
	
	lr_start_transaction("SC05_04_Create_And_Update_Inventory_Custom_List_Import_CustomList");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_ListID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);
	
	web_reg_save_param("Corr_ListName","LB=\"name\":\"","RB=\",\"createdOn","NOTFOUND=warning","ORD=All",LAST);
	
	//"type":"C","owner
	web_reg_save_param("Corr_ListType","LB=\"type\":\"","RB=\",\"owner","NOTFOUND=warning","ORD=All",LAST);

	web_custom_request("legacy-lists", 
		"URL={P_URL}/app/legacy-lists", 
		"Method=GET", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		LAST);
	
	if(strcmp(lr_eval_string("{Corr_ListID_1}"),"")==0)
	{ 	
		lr_output_message("Custom Lists are not available for Account %s and User ID %s ", lr_eval_string("{P_CustomerID}"), lr_eval_string("{P_UserID}"));
		
		lr_end_transaction("SC05_04_Create_And_Update_Inventory_Custom_List_Import_CustomList", LR_AUTO);
		
		goto EndofScenario;
	}
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	//{"id":"8dc1e573-397f-40b8-bd3e-ba22a2c9e609","opCo
	
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\",\"opCo","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("legacylist", 
		"URL={P_URL}/app/inventory/import/legacylist", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTTP", 
		"EncType=application/json", 
		"Body={\"lists\":[{\"id\":\"{Corr_ListID_1}\",\"name\":\"{Corr_ListName_1}\",\"type\":\"{Corr_ListType_1}\",\"owner\":\"{P_UserID}\"}],\"groups\":\"default\"}",
		LAST);
	
	lr_end_transaction("SC05_04_Create_And_Update_Inventory_Custom_List_Import_CustomList", LR_AUTO);
	
	lr_think_time(TT);

	lr_start_transaction("SC05_05_Create_And_Update_Inventory_Custom_List_Setup_ExpenseCategory");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	//,"groups":[{"groupId":"d94ad58d-b762-481c-b0a7-3c4d3738b380"},{"groupId
	
	web_reg_save_param("Corr_ExpenseCategoryID","LB=\"groups\":[{\"groupId\":\"","RB=\"},{\"groupId","NOTFOUND=warning","ORD=All",LAST);
	
	web_custom_request("expensecategories", 
		"URL={P_URL}/app/inventory/setup/expensecategories", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTTP", 
		"EncType=application/json", 
		"Body={\"groups\":\"food/nonfood\"}", 
		LAST);
	
	lr_end_transaction("SC05_05_Create_And_Update_Inventory_Custom_List_Setup_ExpenseCategory", LR_AUTO);
	
	lr_think_time(TT);
	
	lr_start_transaction("SC05_06_Create_And_Update_Inventory_Custom_List_Get_Current_Inventory");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=ALL",LAST);

	web_reg_save_param("Corr_ItemID","LB={\"id\":\"","RB=\",\"priceUom","NOTFOUND=warning","ORD=ALL",LAST);

	web_reg_save_param("Corr_ItemIDBody","LB={\"id\":\"","RB=,\"quantity","NOTFOUND=warning","ORD=ALL",LAST);

	web_reg_save_param("Corr_ItemDetails","LB=,\"quantityUom\":\"","RB=},{\"id\":\"","NOTFOUND=warning","ORD=ALL",LAST);
	
	web_reg_save_param("Corr_ItemDetail_Last","LB=,\"quantityUom\":\"","RB=}]}","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("currentInventory", 
		"URL={P_URL}/inventories/current?withAllProductAttributes=true", 
		"Method=GET", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t6.inf", 
		LAST);
	
	lr_end_transaction("SC05_06_Create_And_Update_Inventory_Custom_List_Get_Current_Inventory", LR_AUTO);
	
	lr_think_time(TT);
	
	count=atoi(lr_eval_string("{Corr_ItemID_count}"));
	
	lr_start_transaction("SC05_07_Create_And_Update_Inventory_Custom_List_Get_Locations");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	//{"id":"df8eaa86-c00a-4f75-aca5-edc20541a4bf","name
	
	web_reg_save_param("Corr_LocationID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);
	
	web_custom_request("groups", 
		"URL={P_URL}/groups?type=location", 
		"Method=GET", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t7.inf", 
		LAST);
	
	lr_end_transaction("SC05_07_Create_And_Update_Inventory_Custom_List_Get_Locations", LR_AUTO);
	
	lr_think_time(TT);

	lr_start_transaction("SC05_08_Create_And_Update_Inventory_Custom_List_Get_Groups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	//[{"id":"d94ad58d-b762-481c-b0a7-3c4d3738b380","name"
	
	web_reg_save_param("Corr_GroupID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);

	web_url("groups_2", 
		"URL={P_URL}/groups", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t8.inf", 
		LAST);
	
	lr_end_transaction("SC05_08_Create_And_Update_Inventory_Custom_List_Get_Groups", LR_AUTO);

	lr_think_time(TT);
	
	for (i=1;i<=count;i++)
	{
		char Invbody[2000]="";
		
		char I_Product_ID[2000]="";
		
		sprintf(I_Product_ID,"{Corr_ItemIDBody_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_ItemIDBody");
		sprintf(I_Product_ID,"{Corr_ItemDetails_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_ItemDetails");
			
	if(i<2)
	{
		
		sprintf(Invbody,"{\"items\": [ { \"id\": \"%s, \"quantity\": {P_Quantity}, \"quantityUom\": \"%s}, ",lr_eval_string("{Corr_ItemIDBody}"), lr_eval_string("{Corr_ItemDetails}"));
	
	}
	else if(i<count)
	{
		sprintf(Invbody,"{ \"id\": \"%s, \"quantity\": {P_Quantity}, \"quantityUom\": \"%s}, ",lr_eval_string("{Corr_ItemIDBody}"), lr_eval_string("{Corr_ItemDetails}"));
		
	}
	else
	{
		sprintf(Invbody,"{ \"id\": \"%s, \"quantity\": {P_Quantity}, \"quantityUom\": \"%s} ] }",lr_eval_string("{Corr_ItemIDBody}"), lr_eval_string("{Corr_ItemDetail_Last}"));
	
	}

	lr_output_message("Body=%s", Invbody);
	
	strcat(InvbodyP1, Invbody);
		
}
	
	lr_save_string(lr_eval_string(InvbodyP1), "InvBody0");
	
	lr_output_message("Body=%s", lr_eval_string("{InvBody0}"));
	
	lr_start_transaction("SC05_09_Create_And_Update_Inventory_Custom_List_Update_Inventory_Content");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_ChangedQuantity","LB=quantity\":","RB=,\"quantityUom","NOTFOUND=warning","ORD=All",LAST);
	
	web_custom_request("UpdateInventory",
		"URL={P_URL}/inventories/{Corr_InventoryID_1}", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		"Body={InvBody0}",
		"EncType=application/json",		
		LAST);
	
	lr_end_transaction("SC05_09_Create_And_Update_Inventory_Custom_List_Update_Inventory_Content", LR_AUTO);
	
	lr_think_time(TT);
	
	free(InvbodyP1);
	
	for (i=1;i<=count;i++)
	{		
		char I_Product_ID[2000]="";
		
		sprintf(I_Product_ID,"{Corr_OriginalQuantity_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_OriginalQuantity");
		sprintf(I_Product_ID,"{Corr_ChangedQuantity_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_ChangedQuantity");
	
		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\SC05_CreateUpdateInventory_Updated.txt" );
		fp=fopen( temp,"a+" );
		fprintf( fp,"OpCo :%s, Customer_ID :%s, UserID :%s, InventoryID :%s, SelectedCustomListID :%s, OriginalQuantity :%s, NewQuantity :%s\n",lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"),lr_eval_string("{P_UserID}"),lr_eval_string("{Corr_InventoryID_1}"),lr_eval_string("{Corr_ListID_1}"),lr_eval_string("{Corr_OriginalQuantity}"),lr_eval_string("{Corr_ChangedQuantity}"));
		fclose( fp ); 
	}
	
	lr_start_transaction("SC05_10_Create_And_Update_Inventory_Custom_List_Get_Locations");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_url("groups_3", 
		"URL={P_URL}/groups?type=location", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t10.inf", 
		LAST);
	
	lr_end_transaction("SC05_10_Create_And_Update_Inventory_Custom_List_Get_Locations", LR_AUTO);
	
	lr_think_time(TT);
	
	lr_start_transaction("SC05_11_Create_And_Update_Inventory_Custom_List_Get_Groups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_url("groups_4", 
		"URL={P_URL}/groups", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t11.inf", 
		LAST);
	
	lr_end_transaction("SC05_11_Create_And_Update_Inventory_Custom_List_Get_Groups", LR_AUTO);
	
	lr_think_time(TT);

EndofScenario:
	
	lr_start_transaction("SC05_12_Create_And_Update_Inventory_Custom_List_Logout");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{Corr_CustomerID}|{P_UserID}");

	web_custom_request("logout", 
		"URL={P_URL}/app/logout", 
		"Method=POST", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t13.inf", 
		"Mode=HTTP", 
		"EncType=", 
		LAST);
	
	lr_end_transaction("SC05_12_Create_And_Update_Inventory_Custom_List_Logout", LR_AUTO);

	return 0;
}