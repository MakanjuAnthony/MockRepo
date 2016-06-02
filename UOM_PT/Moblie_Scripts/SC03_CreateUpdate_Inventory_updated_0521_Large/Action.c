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
	

//	web_reg_save_param("Corr_CustomerID","LB=\"id\":\"","RB=\",\"opco","NOTFOUND=warning","ORD=1",LAST);
//	web_reg_save_param("Corr_OpCO","LB=\"opco\":{\"id\":\"","RB=\",\"name\"","NOTFOUND=warning","ORD=1",LAST);
//	lr_start_transaction("SC03_01_Setup_Inventory_Login");
//	
//	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
//
//	web_add_header("Origin","file://");
//	
//	web_add_header("X-Requested-With","com.syscocorp.uomqa");
//
//	web_custom_request("login", 
//		"URL={P_URL}/app/login", 
//		"Method=POST", 
//		"Resource=0", 
//		"RecContentType=application/json", 
//		"Referer=", 
//		"Snapshot=t1.inf", 
//		"Mode=HTML", 
//		"EncType=application/json", 
//		"Body={\"username\":\"{P_UserID}\",\"password\":\"{P_Password}\"}", 
//		LAST);
//
//	lr_end_sub_transaction("SC03_01_Setup_Inventory_Login", LR_AUTO);

//goto JumpOn;

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
/*
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("accounts", 
		"URL={P_WSURL}/accounts", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_WSURL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"isCogs\": true\n}", 
		LAST);
*/

CheckInventory:

	lr_start_transaction("SC03_02_Setup_Inventory_Get_Iventory");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

//{"id":"1be7749b-0ac9-4c77-ac39-e9c94b215424","opCo":"067"
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=1",LAST);

	web_reg_save_param("Corr_OriginalQuantity","LB=quantity\":","RB=,\"quantityUom","NOTFOUND=warning","ORD=All",LAST);
	
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
	
	lr_end_transaction("SC03_02_Setup_Inventory_Get_Iventory", LR_AUTO);

	lr_think_time(TT);

	if(strcmp(lr_eval_string("{Corr_InventoryID}"),"")==0)
	{ 	
		lr_output_message("There is no open Inventory");
		goto ImportOG;
	}
	
	else
	{
		lr_output_message("Cleaning of Inventory %s",lr_eval_string("{Corr_InventoryID}"));
		
		web_custom_request("DataCleanup",
			"URL=http://uom-qa.na.sysco.net:8081/tasks/cleanupDataForAccount?opCo={P_OpCo}&customerId={P_CustomerID}", 
			"Method=POST", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer=", 
			"Snapshot=t3.inf", 
			"Mode=HTML", 
			"EncType=application/json", 
			LAST);
		
	}

CreateAccount:
	
	lr_start_transaction("SC03_03_Create_New_Account");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("accounts", 
		"URL={P_WSURL}/accounts", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_WSURL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"isCogs\": true\n}", 
		LAST);
	
	lr_end_transaction("SC03_03_Create_New_Account", LR_AUTO);
	
	lr_think_time(TT);

ImportOG:
	lr_start_transaction("SC03_04_Setup_Inventory_Import_OrderGuide");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("orderguide",
		"URL={P_URL}/app/inventory/import/orderguide", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"useEndecaOrderGuide\":true,\"groups\":\"default\"}", 
		LAST);

	lr_end_transaction("SC03_04_Setup_Inventory_Import_OrderGuide", LR_AUTO);

	lr_think_time(TT);
	
	lr_start_transaction("SC03_05_Setup_Inventory_Setup_ExpenseCategory");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("expensecategories",
		"URL={P_URL}/app/inventory/setup/expensecategories", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"groups\":\"food/nonfood\"}", 
		LAST);

	lr_end_transaction("SC03_05_Setup_Inventory_Setup_ExpenseCategory", LR_AUTO);

	lr_think_time(TT);

//JumpOn:
	lr_start_transaction("SC03_06_Setup_Inventory_Get_Inventory");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\",\"opCo\":","NOTFOUND=warning","ORD=ALL",LAST);
//{"id":"2389260","priceUom":"lb","groups":[{"groupId":"51f7c67b-87c7-431a-b637-96fb59bfc7d0"},{"groupId":"35e7be54-3034-49da-b235-6dd710abbbbc","sequence":0,"quantity":0,"quantityUom":"lb"}]
	web_reg_save_param("Corr_ItemID","LB={\"id\":\"","RB=\",\"priceUom","NOTFOUND=warning","ORD=ALL",LAST);
//{"id":"2389260","priceUom":"lb","groups":[{"groupId":"51f7c67b-87c7-431a-b637-96fb59bfc7d0"},{"groupId":"35e7be54-3034-49da-b235-6dd710abbbbc","sequence":0,"quantity":0,"quantityUom":"lb"}],"customerImages":[],"materialId":"2389260","packSize":{"pack":"3","size":"12#AVG"},"averageWeightPerCase":34.316,"name":"CHEESE PROVOLONE","description":"Cheese Provolone","type":"sysco","isSoldAs":{"case":false,"split":false},"split":{"min":1,"max":3},"bvRating":null,"brand":"AREZZIO","isCatchWeight":true,"storageFlag":"C","isAvailable":true,"replacement":{"hasReplacement":true,"replacementMaterialId":"8602732"},"category":{"completeCategoryId":"02004008002","mainCategoryId":2,"label":"CHEDDAR/COLBY"},"messages":[{"type":"info","message":"Stocked item"},{"type":"warning","message":"Leaving Soon. Replacement available"}],"flags":["syscoBranded"],"images":["./2389260/web/1.jpg"],"canBuy":true,"lastOrderedDate":"2016-05-13T19:19:21.020Z","nickName":null,"originalIndex":0},{"id":"
	web_reg_save_param("Corr_ItemIDBody","LB={\"id\":\"","RB=,\"quantity","NOTFOUND=warning","ORD=ALL",LAST);
//	originalIndex":0},{"id":"
	web_reg_save_param("Corr_ItemDetails","LB=,\"quantityUom\":\"","RB=},{\"id\":\"","NOTFOUND=warning","ORD=ALL",LAST);
	
	web_reg_save_param("Corr_ItemDetail_Last","LB=,\"quantityUom\":\"","RB=}]}","NOTFOUND=warning","ORD=1",LAST);

//"quantity":0,"quantityUom"
	
	web_custom_request("expensecategories",
		"URL={P_URL}/inventories/current?withAllProductAttributes=true", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		EXTRARES, 
		LAST);

	lr_end_transaction("SC03_06_Setup_Inventory_Get_Inventory", LR_AUTO);
	
	count=atoi(lr_eval_string("{Corr_ItemID_count}"));

	lr_think_time(TT);

	lr_start_transaction("SC03_07_Setup_Inventory_Get_Locations");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_LocID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);

	web_custom_request("Get_Locations",
		"URL={P_URL}/groups?type=location", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		EXTRARES, 
		LAST);

	lr_end_transaction("SC03_07_Setup_Inventory_Get_Locations", LR_AUTO);

	lr_think_time(TT);
	
	lr_start_transaction("SC03_08_Setup_Inventory_Get_Groups");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);

	web_custom_request("Get_Groups",
		"URL={P_URL}/groups", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		EXTRARES, 
		LAST);

	lr_end_transaction("SC03_08_Setup_Inventory_Get_Groups", LR_AUTO);

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
	
	lr_start_transaction("SC03_09_Setup_Inventory_Update_Inventory_Content");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_add_header("Origin","file://");

	web_add_header("JSESSIONID","");
	
	web_add_header("X-Requested-With","com.syscocorp.uomqa");

	web_reg_save_param("Corr_ChangedQuantity","LB=quantity\":","RB=,\"quantityUom","NOTFOUND=warning","ORD=All",LAST);
	
	web_custom_request("{Corr_InventoryID_1}",
		"URL={P_URL}/inventories/{Corr_InventoryID_1}", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		//body_variable_1,
		"Body={InvBody0}",
		"EncType=application/json",		
		LAST);

	lr_end_transaction("SC03_09_Setup_Inventory_Update_Inventory_Content", LR_AUTO);
	
	free(InvbodyP1);

	lr_think_time(TT);
	
	for (i=1;i<=count;i++)
	{		
		char I_Product_ID[2000]="";
		
		sprintf(I_Product_ID,"{Corr_OriginalQuantity_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_OriginalQuantity");
		sprintf(I_Product_ID,"{Corr_ChangedQuantity_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_ChangedQuantity");
	
		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\SC03_CreateUpdateInventory_Updated.txt" );
		fp=fopen( temp,"a+" );
		fprintf( fp,"OpCo :%s, Customer_ID :%s, UserID :%s, InventoryID :%s, OriginalQuantity :%s, NewQuantity :%s\n",lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"),lr_eval_string("{P_UserID}"),lr_eval_string("{Corr_InventoryID_1}"),lr_eval_string("{Corr_OriginalQuantity}"),lr_eval_string("{Corr_ChangedQuantity}"));
		fclose( fp ); 
	}

	lr_start_transaction("SC03_10_Setup_Inventory_Get_Locations");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_LocID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);

	web_custom_request("Get_Locations_1",
		"URL={P_URL}/groups?type=location", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		EXTRARES, 
		LAST);

	lr_end_transaction("SC03_10_Setup_Inventory_Get_Locations", LR_AUTO);

	lr_think_time(TT);

	lr_start_transaction("SC03_11_Setup_Inventory_Get_Groups");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID","LB={\"id\":\"","RB=\",\"name","NOTFOUND=warning","ORD=All",LAST);

	web_custom_request("Get_Groups_1",
		"URL={P_URL}/groups", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		EXTRARES, 
		LAST);

	lr_end_transaction("SC03_11_Setup_Inventory_Get_Groups", LR_AUTO);

	lr_think_time(TT);

//	lr_start_transaction("SC03_12_Setup_Inventory_Logout");
//	
//	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
//
//	web_custom_request("logout", 
//		"URL={P_URL}/app/logout", 
//		"Method=POST", 
//		"Resource=0", 
//		"Referer=", 
//		"Snapshot=t3.inf", 
//		"Mode=HTML", 
//		"EncType=", 
//		LAST);
//
//	lr_end_transaction("SC03_12_Setup_Inventory_Logout", LR_AUTO);

	return 0;
}