Action()
{
	char Invbody[1000]="";
	char InvbodyP1[10000]="";
	
	char Invbody1[1000]="";
	char InvbodyP2[10000]="";
	
	int i=0;
	int icount=0;
	char I_Product_ID[200];
	
	web_set_max_html_param_len("1024");

/************************* Create Inventory ************************/

	lr_start_transaction("WS05_00_Get_AccountByCustomerID");
	
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

	lr_end_transaction("WS05_00_Get_AccountByCustomerID", LR_AUTO);

	lr_think_time(1);
	
if(strcmp(lr_eval_string("{Corr_CustomerID}"),"")==0)
{
		
	//lr_start_transaction("Create_New_Account");
	
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
		"Body={\n \"isCogs\": true\n}", 
		LAST);
	
	//lr_end_transaction("Create_New_Account", LR_AUTO);
	
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\NewAccount_QA.txt" );
		fp=fopen( temp,"a+" );
		fprintf( fp,"\n OpCo, Customer_ID and UserID:%s	%s	%s",lr_eval_string("{P_OpCo}"),lr_eval_string("{Corr_CustomerID}"),lr_eval_string("{P_UserID}"));
		fclose( fp );

}

/************************* Get Inventory *************************/	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_InventoryName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_NumberofItems","LB=\"numberOfItems\":","RB=}","NOTFOUND=warning","ORD=All",LAST);
	
	web_url("InventoriesListforanAccount",
		"URL={P_URL}/inventories",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

if(strcmp(lr_eval_string("{Corr_InventoryID_count}"),"0")==0)
{
	lr_output_message("Looped into Create Inventory");
	goto CreateData;
}
	else
{
	lr_output_message("Not Looped into Create Inventory");
	goto endofWS;
}
	
CreateData:
	lr_start_transaction("WS05_01_Create_Groups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_Exp_Food","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

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
		"Body={\n \"name\": \"{P_GroupName}\",\n \"type\": \"expenseCategory\",\n \"storage\": \"{P_StorageName}\",\n \"foodType\": \"food\"\n}",
		LAST);
	
	lr_end_transaction("WS05_01_Create_Groups", LR_AUTO);

	lr_think_time(2);

	lr_start_transaction("WS05_01_Create_Groups");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_Location_Food","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

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
		"Body={\n \"name\": \"{P_GroupName}\",\n \"type\": \"location\",\n \"storage\": \"{P_StorageName}\",\n \"foodType\": \"food\"\n}",
		LAST);
	
	lr_end_transaction("WS05_01_Create_Groups", LR_AUTO);

	lr_think_time(2);
	
	lr_start_transaction("WS05_01_Create_Groups");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_Location_Food1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

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
		"Body={\n \"name\": \"{P_GroupName}\",\n \"type\": \"location\",\n \"storage\": \"{P_StorageName}\",\n \"foodType\": \"food\"\n}",
		LAST);
	
	lr_end_transaction("WS05_01_Create_Groups", LR_AUTO);

	lr_think_time(2);

	lr_start_transaction("WS05_01_Create_Groups");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_Exp_NonFood","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

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
		"Body={\n \"name\": \"{P_GroupName}\",\n \"type\": \"expenseCategory\",\n \"storage\": \"{P_StorageName}\",\n \"foodType\": \"nonFood\"\n}",
		LAST);
		
	lr_end_transaction("WS05_01_Create_Groups", LR_AUTO);
	lr_think_time(2);
	
	lr_start_transaction("WS05_01_Create_Groups");
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	web_reg_save_param("Corr_GroupID_Location_NonFood","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

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
		"Body={\n \"name\": \"{P_GroupName}\",\n \"type\": \"location\",\n \"storage\": \"{P_StorageName}\",\n \"foodType\": \"nonFood\"\n}",
		LAST);
	
	lr_end_transaction("WS05_01_Create_Groups", LR_AUTO);
	lr_think_time(2);
	
/*	lr_start_transaction("WS02_02_GetGroups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_Exp_Food","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID_Location_Food","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);
	web_reg_save_param("Corr_GroupID_Exp_NonFood","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=3",LAST);
	web_reg_save_param("Corr_GroupID_Location_NonFood","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=4",LAST);
	
	//web_reg_save_param("Corr_Storage","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Type","LB=\"type\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetGroups",
		"URL={P_URL}/groups",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS02_02_GetGroups", LR_AUTO);
	
	lr_think_time(1);
*/
/************************* End of Groups ***************************/

/************************* Start of Supplier ************************/

for (i=1;i<=5;i++) 
{

	lr_start_transaction("WS05_02_Create_New_Suppliers");
	
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
	
	lr_end_transaction("WS05_02_Create_New_Suppliers", LR_AUTO);
}

	lr_think_time(1);
	
	lr_start_transaction("WS05_03_Get_ListOfSuppliers");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_SupplierID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
//	web_reg_save_param("Corr_SupplierID_2","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);
//	web_reg_save_param("Corr_SupplierID_3","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=3",LAST);
//	web_reg_save_param("Corr_SupplierID_4","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=4",LAST);

	web_url("SuppliersList",
		"URL={P_URL}/suppliers",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS05_03_Get_ListOfSuppliers", LR_AUTO);  

	lr_think_time(2);
	
for (i=1;i<=20;i++) 
{
		
	lr_start_transaction("WS05_04_Insert_NonSysco_Product");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_ProductName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_MaterialID","LB=\"materialId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_ProductID_NonSysco","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("InsertNSproducts", 
		"URL={P_URL}/products", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"name\": \"{P_ProductName}\",\n \"materialId\": \"{P_MaterialID}\",\n \"supplier\": \"{Corr_SupplierID_1}\",\n \"brand\": \"{P_Brand}\",\n \"description\": \"{P_MaterialID}_{P_Brand}\",\n \"nickName\": \"ABC\",\n \"type\": \"nonSysco\",\n \"averageWeightPerCase\": {P_AvgWtPerCase},\n \"packSize\": {\n  \"pack\": \"string\",\n  \"size\": \"string\",\n  \"uom\": \"{P_UOM}\"\n }\n}",
		LAST);
	
	lr_end_transaction("WS05_04_Insert_NonSysco_Product", LR_AUTO);
	
		
	if(i<2)
	{
		//sprintf(Invbody,"{\"items\": [ { \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] },",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		sprintf(Invbody,"{\"items\": [ { \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] }, ",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_Food}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		//sprintf(Invbody,"{ \"items\": [ { \"id\": \"{Corr_ProductID_Prepared_1}\", \"price\": 10, \"priceUom\": \"CS\", \"groups\": [ { \"groupId\": \"{Corr_GroupID_Exp_NonFood}\"\n    },\n    {\n      \"groupId\": \"{Corr_GroupID_Location_NonFood}\", \"sequence\": 1, \"quantity\": 10, \"quantityUom\": \"CS\" } ], \"customerImages\": [ \"Test\" ] }, { \"id\": \"{Corr_ProductID_Prepared_2}\", \"price\": 10, \"priceUom\": \"CS\", \"groups\": [ { \"groupId\": \"{Corr_GroupID_Exp_Food}\" }, { \"groupId\": \"{Corr_GroupID_Location_Food}\", \"sequence\": 2, \"quantity\": 20, \"quantityUom\": \"CS\" } ], \"customerImages\": [ \"Test\" ] } ] }");
	}
	else if(i<7)
   	{
		
		//sprintf(Invbody,"{\"items\": [ { \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] },",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		sprintf(Invbody,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] }, ",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_NonFood}"), lr_eval_string("{Corr_GroupID_Location_Food}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
	else if(i<13)
    {
		sprintf(Invbody,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] }, ",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_Food1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
	else if(i<20)
	{
		sprintf(Invbody,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] }, ",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_NonFood}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
	else
	{
		//sprintf(Invbody,"{ \"id\": \"%s\",\n   \"price\": %s,\n   \"priceUom\": \"%s\",\n   \"groups\": [\n    {\n     \"groupId\": \"%s\"\n    },\n    {\n      \"groupId\": \"%s\",\"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] },\n{   \"id\":\"%s\",\n   \"price\": %s,\n   \"priceUom\": \"%s\",\n   \"groups\": [\n    {\n     \"groupId\": \"%s\"\n    },\n    {\n      \"groupId\": \"%s\",\n     \"sequence\": %d,\n    \"quantity\": %s,\n     \"quantityUom\": \"%s\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  }\n ]\n},",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_NonFood}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"),lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_NonFood}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		sprintf(Invbody,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] } ] }",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_NonFood}"), lr_eval_string("{Corr_GroupID_Location_NonFood}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		//sprintf(Invbody,"{ \"items\": [ { \"id\": \"{Corr_ProductID_Prepared_5}\", \"price\": 10, \"priceUom\": \"CS\", \"groups\": [ { \"groupId\": \"{Corr_GroupID_Exp_NonFood}\"\n    },\n    {\n      \"groupId\": \"{Corr_GroupID_Location_NonFood}\", \"sequence\": 1, \"quantity\": 10, \"quantityUom\": \"CS\" } ], \"customerImages\": [ \"Test\" ] }, { \"id\": \"{Corr_ProductID_Prepared_6}\", \"price\": 10, \"priceUom\": \"CS\", \"groups\": [ { \"groupId\": \"{Corr_GroupID_Exp_Food}\" }, { \"groupId\": \"{Corr_GroupID_Location_Food}\", \"sequence\": 2, \"quantity\": 20, \"quantityUom\": \"CS\" } ], \"customerImages\": [ \"Test\" ] } ] }");
	}

	lr_output_message("Body=%s", Invbody);
	strcat(InvbodyP1, Invbody);
			
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\Insert_NonSysco_Product_QA_Integrated.txt" );

		fp=fopen( temp,"a+" );
		fprintf( fp,"\n CustomerID :%s, Product_ID :%s, Product_Name :%s, SupplierID :%s",lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_ProductID_NonSysco}"),lr_eval_string("{Corr_ProductName}"),lr_eval_string("{Corr_SupplierID_2}"));
		fclose( fp );
}
	
	lr_save_string(lr_eval_string(InvbodyP1), "InvBody0");
	lr_output_message("Body=%s", lr_eval_string("{InvBody0}"));

	
	lr_think_time(3);
	
	lr_start_transaction("WS05_05_Create_New_Inventory");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_OpenDate","LB=\"openDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("inventories",
		"URL={P_URL}/inventories", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		//"Body={\n \"items\": [\n  {   \"id\": \"{Corr_ProductID}\",\n   \"price\": 10,\n   \"priceUom\": \"CS\",\n   \"groups\": [\n    {\n     \"groupId\": \"{Corr_GroupID}\",\n     \"sequence\": 1,\n    \"quantity\": 1,\n     \"quantityUom\": \"CS\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  }\n ]\n}", 
		//"Body={\n \"items\": [\n  {   \"id\": \"{Corr_ProductID_NonSysco}\",\n   \"price\": 10,\n   \"priceUom\": \"CS\",\n   \"groups\": [\n    {\n     \"groupId\": \"{Corr_GroupID_Exp_Food}\",\n     \"sequence\": 1,\n    \"quantity\": 1,\n     \"quantityUom\": \"CS\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  },\n{   \"id\": \"{Corr_ProductID_Prepared}\",\n   \"price\": 10,\n   \"priceUom\": \"CS\",\n   \"groups\": [\n    {\n     \"groupId\": \"{Corr_GroupID_Exp_NonFood}\",\n     \"sequence\": 1,\n    \"quantity\": 1,\n     \"quantityUom\": \"CS\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  }\n ]\n}",
//		"Body={\n \"items\": [\n  {   \"id\": \"{Corr_ProductID_NonSysco}\",\n   \"price\": 10,\n   \"priceUom\": \"CS\",\n   \"groups\": [\n    {\n     \"groupId\": \"{Corr_GroupID_Exp_NonFood}\"\n    },\n    {\n      \"groupId\": \"{Corr_GroupID_Location_NonFood}\",\n     \"sequence\": 1,\n    \"quantity\": 10,\n     \"quantityUom\": \"CS\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  },\n{   \"id\": \"{Corr_ProductID_Prepared}\",\n   \"price\": 10,\n   \"priceUom\": \"CS\",\n   \"groups\": [\n    {\n     \"groupId\": \"{Corr_GroupID_Exp_Food}\"\n    },\n    {\n      \"groupId\": \"{Corr_GroupID_Location_Food}\",\n     \"sequence\": 2,\n    \"quantity\": 20,\n     \"quantityUom\": \"CS\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  }\n ]\n}",
		"Body={InvBody0}",
		LAST);
		
	lr_end_transaction("WS05_05_Create_New_Inventory", LR_AUTO);
	
	lr_think_time(3);
	
		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\NewInventory_QA.txt" );
		fp=fopen( temp,"a+" );
		fprintf( fp,"\n OpCo :%s, Customer_ID :%s, InventoryID :%s, ProductID :%s, OpenDate :%s",lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_InventoryID}"),lr_eval_string("{Corr_ProductID}"),lr_eval_string("{Corr_OpenDate}"));
		fclose( fp );
		
	lr_start_transaction("WS05_06_Get_Current_Open_Inventory");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_OpenDate","LB=\"openDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Status","LB=\"state\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_url("GetCurrentOpenInventory",
		"URL={P_URL}/inventories/current?withAllProductAttributes=true",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);
	
	lr_end_transaction("WS05_06_Get_Current_Open_Inventory", LR_AUTO);

endofWS:
/************************* End of Create Inventory************************/
/**************************Start of Update Inventory**********************/

//	lr_start_transaction("WS02_02_GetGroups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_Exp_Food","LB=\"id\":\"","RB=\"foodType\":\"food\"","NOTFOUND=warning","SaveLen=36","ORD=1",LAST);
	
	web_reg_save_param("Corr_GroupID_Exp_NonFood","LB=\"id\":\"","RB=\"foodType\":\"nonFood\"","NOTFOUND=warning","SaveLen=36","ORD=1",LAST);
	
	
	web_url("GetGroups",
		"URL={P_URL}/v1/groups?type=expenseCategory",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);
	
	web_reg_save_param("Corr_GroupID_Location_Food","LB=\"id\":\"","RB=\"type\":\"location\"","NOTFOUND=warning","SaveLen=36","ORD=1",LAST);
	
	web_reg_save_param("Corr_GroupID_Location_Food1","LB=\"id\":\"","RB=\"type\":\"location\"","NOTFOUND=warning","SaveLen=36","ORD=2",LAST);
	
	web_reg_save_param("Corr_GroupID_Location_NonFood","LB=\"id\":\"","RB=\"type\":\"location\"","NOTFOUND=warning","SaveLen=36","ORD=3",LAST);
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_url("GetGroups",
		"URL={P_URL}/v1/groups?type=location",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);
	
	lr_start_transaction("WS05_07_Get_Current_Open_Inventory");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_OpenDate","LB=\"openDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Status","LB=\"state\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	//{"id":"e8111dcc-0062-411b-ac87-b6ccac2810b9","price":8.00,"priceUom":"ea","groups":[{"groupId":"b083ccf3-947a-497c-aceb-aa2535cfb6ee",
//"sequence":1,"quantity":12,"quantityUom":"ea"}],"customerImages":["string"]},
	web_reg_save_param("Corr_ProductID","LB={\"id\":\"","RB=\",\"price","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_price","LB=\"price\":","RB=,","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_priceUom","LB=\"priceUom\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_GroupID","LB={\"groupId\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_sequence","LB=\"sequence\":","RB=,","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_quantity","LB=\"quantity\":","RB=,","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_quantityUom","LB=\"quantityUom\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);


	web_url("GetCurrentOpenInventory",
		"URL={P_URL}/inventories/current",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS05_07_Get_Current_Open_Inventory", LR_AUTO);
	
	for (i=1;i<=20;i++)
	{
		//I_Product_ID
		sprintf(I_Product_ID,"{Corr_ProductID_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_ProductID_NonSysco");
		sprintf(I_Product_ID,"{Corr_price_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_price");
		sprintf(I_Product_ID,"{Corr_priceUom_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_priceUom");
		sprintf(I_Product_ID,"{Corr_GroupID_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_GroupID");
		sprintf(I_Product_ID,"{Corr_sequence_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_sequence");
		sprintf(I_Product_ID,"{Corr_quantity_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_quantity");
		sprintf(I_Product_ID,"{Corr_quantityUom_%d}",i);
		lr_save_string(lr_eval_string(I_Product_ID),"Corr_quantityUom");

			
	if(i<2)
	{
		//sprintf(Invbody,"{\"items\": [ { \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] },",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		sprintf(Invbody2,"{\"items\": [ { \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] }, ",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_Food}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		//sprintf(Invbody,"{ \"items\": [ { \"id\": \"{Corr_ProductID_Prepared_1}\", \"price\": 10, \"priceUom\": \"CS\", \"groups\": [ { \"groupId\": \"{Corr_GroupID_Exp_NonFood}\"\n    },\n    {\n      \"groupId\": \"{Corr_GroupID_Location_NonFood}\", \"sequence\": 1, \"quantity\": 10, \"quantityUom\": \"CS\" } ], \"customerImages\": [ \"Test\" ] }, { \"id\": \"{Corr_ProductID_Prepared_2}\", \"price\": 10, \"priceUom\": \"CS\", \"groups\": [ { \"groupId\": \"{Corr_GroupID_Exp_Food}\" }, { \"groupId\": \"{Corr_GroupID_Location_Food}\", \"sequence\": 2, \"quantity\": 20, \"quantityUom\": \"CS\" } ], \"customerImages\": [ \"Test\" ] } ] }");
	}
	else if(i<7)
   	{
		
		//sprintf(Invbody,"{\"items\": [ { \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] },",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		sprintf(Invbody2,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] }, ",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_NonFood}"), lr_eval_string("{Corr_GroupID_Location_Food}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
	else if(i<13)
    {
		sprintf(Invbody2,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] }, ",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_Food1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
	else if(i<20)
	{
		sprintf(Invbody2,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] }, ",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_NonFood}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
	else
	{
		//sprintf(Invbody,"{ \"id\": \"%s\",\n   \"price\": %s,\n   \"priceUom\": \"%s\",\n   \"groups\": [\n    {\n     \"groupId\": \"%s\"\n    },\n    {\n      \"groupId\": \"%s\",\"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] },\n{   \"id\":\"%s\",\n   \"price\": %s,\n   \"priceUom\": \"%s\",\n   \"groups\": [\n    {\n     \"groupId\": \"%s\"\n    },\n    {\n      \"groupId\": \"%s\",\n     \"sequence\": %d,\n    \"quantity\": %s,\n     \"quantityUom\": \"%s\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  }\n ]\n},",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_NonFood}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"),lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_Food}"), lr_eval_string("{Corr_GroupID_Location_NonFood}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		sprintf(Invbody2,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\" }, { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] } ] }",lr_eval_string("{Corr_ProductID_NonSysco}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_Exp_NonFood}"), lr_eval_string("{Corr_GroupID_Location_NonFood}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
		//sprintf(Invbody,"{ \"items\": [ { \"id\": \"{Corr_ProductID_Prepared_5}\", \"price\": 10, \"priceUom\": \"CS\", \"groups\": [ { \"groupId\": \"{Corr_GroupID_Exp_NonFood}\"\n    },\n    {\n      \"groupId\": \"{Corr_GroupID_Location_NonFood}\", \"sequence\": 1, \"quantity\": 10, \"quantityUom\": \"CS\" } ], \"customerImages\": [ \"Test\" ] }, { \"id\": \"{Corr_ProductID_Prepared_6}\", \"price\": 10, \"priceUom\": \"CS\", \"groups\": [ { \"groupId\": \"{Corr_GroupID_Exp_Food}\" }, { \"groupId\": \"{Corr_GroupID_Location_Food}\", \"sequence\": 2, \"quantity\": 20, \"quantityUom\": \"CS\" } ], \"customerImages\": [ \"Test\" ] } ] }");
	}

	lr_output_message("Body=%s", Invbody2);
	strcat(InvbodyP2, Invbody2);
			
//	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\Insert_NonSysco_Product_QA_Integrated.txt" );
//
//		fp=fopen( temp,"a+" );
//		fprintf( fp,"\n CustomerID :%s, Product_ID :%s, ExpenseCategoryGroupID :%s, LocationGroupID :%s",lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_ProductID}"),lr_eval_string("{Corr_ProductName}"),lr_eval_string("{Corr_SupplierID_2}"));
//		fclose( fp );
}
	
	lr_save_string(lr_eval_string(InvbodyP2), "InvBody3");
	lr_output_message("Body=%s", lr_eval_string("{InvBody3}"));
	
	lr_start_transaction("WS05_08_Update_Inventory_Contents");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_OpenDate","LB=\"openDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	//web_reg_save_param("Corr_ClosedDate","LB=\"closedDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Status","LB=\"state\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_reg_save_param("Corr_ExpenseCategoryGroupID","LB=\"groups\":[{\"groupId\":\"","RB=\"}","NOTFOUND=warning","ORD=All",LAST);	
	web_reg_save_param("Corr_LocationGroupID","LB=\"groupId\":\"","RB=\"sequence\"","NOTFOUND=warning","ORD=All",LAST);
	
	web_custom_request("updateInventory", 
		"URL={P_URL}/inventories/{Corr_InventoryID}", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		//"Body={\n \"items\": [\n  {   \"id\": \"{Corr_ProductID}\",\n   \"groups\": [\n    {\n     \"groupId\": \"{Corr_GroupID}\",\n     \"sequence\": 1\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  }\n ]\n}", 
		"Body={InvBody3}",
		LAST);
	
	lr_end_transaction("WS05_08_Update_Inventory_Contents", LR_AUTO);
	
/**************************End of Update Inventory**********************/
GetInv2:
	
	lr_think_time(4);
	
	lr_start_transaction("WS05_09_Get_AllClosedInventoriesDate");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_InventoryID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_ClosedDate","LB=\"closedDate\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	
	web_url("InventoriesListforanAccount",
		"URL={P_URL}/inventories/closed",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS05_09_Get_AllClosedInventoriesDate", LR_AUTO);

	lr_think_time(4);
	//http://internal-QA-uom-services-private-elb-306417685.us-east-1.elb.amazonaws.com:80/inventories/current?withAllProductAttributes=true&withGroupDefinitions=true

	lr_start_transaction("WS05_10_Get_CurrentInventory_WithAllAttributes");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID","LB={\"groupId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_OpenDate","LB=\"openDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	//type":"expenseCategory","foodType
//	web_reg_save_param("Corr_ExpCategory","LB=\"type\":\"","RB=\",\"foodType","NOTFOUND=warning","ORD=1",LAST);
//	web_reg_save_param("Corr_location","LB=\"type\":\"","RB=\",\"foodType","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetInventory",
		"URL={P_URL}/inventories/current?withAllProductAttributes=true&withGroupDefinitions=true",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS05_10_Get_CurrentInventory_WithAllAttributes", LR_AUTO);
	
	lr_think_time(4);
	
//	if((strcmp(lr_eval_string("{Corr_ExpCategory}"),"expenseCategory")==0)||(strcmp(lr_eval_string("{Corr_location}"),"location")==0))
//{
	lr_start_transaction("WS05_11_Close_Inventory");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_NewInventoryID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_OpenDate","LB=\"openDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Status","LB=\"state\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_custom_request("closeInventory", 
		"URL={P_URL}/inventories/{Corr_InventoryID}/complete",
		"Method=POST",		
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS05_11_Close_Inventory", LR_AUTO);
	
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\Close_Inventory_QA.txt" );

		fp=fopen( temp,"a+" );
		fprintf( fp,"\n OpCo :%s, Customer_ID :%s, ClosedInventoryID :%s, OpenDate :%s, NewInventoryID :%s, Status :%s",lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_InventoryID}"),lr_eval_string("{Corr_OpenDate}"),lr_eval_string("{Corr_NewInventoryID}"),lr_eval_string("{Corr_Status}"));
		fclose( fp );
//}	   
	return 0;
}