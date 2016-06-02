char *strcat(char *, char *);

Action()
{
	char Invbody[800]="";
	char Invbody2[10000]="";
	int i=0;
	int icount=0;
	
	char material_x[50];

	web_set_max_html_param_len("5120");
/************************* Create Inventory ************************/

	lr_start_transaction("WS08_00_Get_AccountByCustomerID");
	
	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_SyscoID}");
	
	web_reg_save_param("Corr_CustomerID","LB=\"customerId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_isCogs","LB=\"isCogs\":","RB=}","NOTFOUND=warning","ORD=1",LAST);

	web_url("GetAccount",
		"URL={P_URL}/accounts/mine",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS08_00_Get_AccountByCustomerID", LR_AUTO);

	lr_think_time(1);
	
if(strcmp(lr_eval_string("{Corr_CustomerID}"),"")==0)
{	
	//lr_start_transaction("Create_New_Account");
	
	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_SyscoID}");
	
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
	
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\NewAccount_SysProduct_QA.txt" );

		fp=fopen( temp,"a+" );
		fprintf( fp,"\n OpCo, Customer_ID and UserID:%s	%s	%s",lr_eval_string("{P_Sys_Opco}"),lr_eval_string("{Corr_CustomerID}"),lr_eval_string("{P_UserID}"));
		fclose( fp );

	}

	lr_start_transaction("WS08_01_GetGroups");
	
	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_SyscoID}");
	
	web_reg_save_param("Corr_GroupID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	//web_reg_save_param("Corr_GroupID_2","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);
	web_reg_save_param("Corr_Storage","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Type","LB=\"type\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetGroups",
		"URL={P_URL}/groups",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS08_01_GetGroups", LR_AUTO);

	lr_think_time(1);

if(strcmp(lr_eval_string("{Corr_GroupID_2}"),"")==0)
{

for (i=1;i<=5;i++) 
{

	lr_start_transaction("WS08_02_Create_Groups");
	
	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_SyscoID}");
	
	web_reg_save_param("Corr_GroupID_1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

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
	
	lr_end_transaction("WS08_02_Create_Groups", LR_AUTO);
	
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\CreateGroups_SysProduct_QA.txt" );

		fp=fopen( temp,"a+" );
		fprintf( fp,"\n Group Id, Name, Storage, Type, OPCO and CustomerID :\t%s\t%s\t%s\t%s\t%s\t%s",lr_eval_string("{Corr_GroupID_1}"),lr_eval_string("{P_GroupName}"),lr_eval_string("{P_StorageName}"),lr_eval_string("{P_Location}"),lr_eval_string("{P_Sys_Opco}"),lr_eval_string("{P_SyscoID}"));
		fclose( fp );

	lr_think_time(2);

}
	lr_start_transaction("WS08_01_GetGroups");
	
	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_SyscoID}");
	
	web_reg_save_param("Corr_GroupID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	//web_reg_save_param("Corr_GroupID_2","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);
	//web_reg_save_param("Corr_GroupID_3","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=3",LAST);
	
	web_reg_save_param("Corr_Storage","LB=\"storage\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Type","LB=\"type\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetGroups",
		"URL={P_URL}/groups",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS08_01_GetGroups", LR_AUTO);
}
	lr_think_time(3);

/************************* End of Groups ***************************/
/************************* Get Inventory *************************/	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_SyscoID}|{P_SyscoID}");
	
	web_reg_save_param("Corr_InventoryID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_InventoryName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_NumberofItems","LB=\"numberOfItems\":","RB=}","NOTFOUND=warning","ORD=All",LAST);
	
	web_url("InventoriesListforanAccount",
		"URL={P_URL}/inventories",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

if(strcmp(lr_eval_string("{Corr_InventoryID}"),"")==0)
{
	lr_output_message("Looped into Create Invetory");
//	goto CreateData;
}
	else
{
	lr_output_message("Not Looped into Create Invetory");
	goto EndofWS;
}

lr_think_time(2);
		
for (i=0;i<=29;i++) {
	
		sprintf(material_x,"{P_SyscoProdID%d}",i);
		lr_save_string(lr_eval_string(material_x), "P_SyscoProdIDx");

	lr_start_transaction("WS08_03_Get_Product_By_Product_ID");

	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_SyscoID}");

	//web_reg_save_param("Corr_ProductID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_MaterialID","LB=\"materialId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_ProductName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Type","LB=\"type\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_AvgWght","LB=\"averageWeightPerCase\":","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Pack","LB={\"pack\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_Size","LB=\"size\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_UOM","LB=\"uom\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

	web_url("GetProductByProductID",
		"URL={P_URL}/products/{P_SyscoProdIDx}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);
	
	lr_end_transaction("WS08_03_Get_Product_By_Product_ID", LR_AUTO);
	
//*********************************/	
if(strcmp(lr_eval_string("{Corr_MaterialID}"),"")==0)
{
	break;
}
//lr_output_message("No Break");

if(i<1)
	    	{
				sprintf(Invbody,"{\"items\": [ { \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] },",lr_eval_string("{Corr_MaterialID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
//	    		sprintf(Invbody,"{\"items\": [ { \"id\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": 1, \"price\": 12.5, \"quantity\": 5, \"quantityUom\": \"EA\", \"priceUom\": \"EA\" } ], \"customerImages\": [ \"string\" ] } ]}",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{Corr_GroupID}"));
	    	}
	else if(i<29)
	{
				sprintf(Invbody,"{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] },",lr_eval_string("{Corr_MaterialID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_2}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
			else
			{
				sprintf(Invbody, "{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] } ] }",lr_eval_string("{Corr_MaterialID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_3}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
//	    		sprintf(Invbody, ",{\"items\": [ { \"id\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": 1, \"price\": 12.5, \"quantity\": 5, \"quantityUom\": \"EA\", \"priceUom\": \"EA\" } ], \"customerImages\": [ \"string\" ] } ]}",lr_eval_string("{P_ProductID}"),lr_eval_string("{P_ProductName}"));
//	    		sprintf(Invbody,",{\"items\": [ { \"id\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"price\": 12.5, \"quantity\": 5, \"quantityUom\": \"EA\", \"priceUom\": \"EA\" } ], \"customerImages\": [ \"string\" ] } ]}",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{Corr_GroupID}"),i);
			}
		lr_save_string(lr_eval_string(Invbody), "InvBody0");
		strcat(Invbody2, Invbody);

}
	
if(strcmp(lr_eval_string("{Corr_MaterialID}"),"")==0)
{
	lr_output_message("No products: %s",lr_eval_string("{P_SyscoID}"));
	goto EndofWS;
}

	lr_save_string(lr_eval_string(Invbody2), "InvBody0");
	lr_output_message("Body=%s", lr_eval_string("{InvBody0}"));

	lr_think_time(3);

	lr_start_transaction("WS08_04_Create_New_Inventory");
	
	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_SyscoID}");
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
		//"Body={\n \"items\": [\n  {   \"id\": \"{Corr_ProductID}\",\n   \"price\": 10,\n   \"priceUom\": \"CS\",\n   \"groups\": [\n    {\n     \"groupId\": \"{Corr_GroupID_1}\",\n     \"sequence\": 1,\n    \"quantity\": 1,\n     \"quantityUom\": \"CS\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  }\n ]\n}", 
		"Body={InvBody0}",
		LAST);
		
	lr_end_transaction("WS08_04_Create_New_Inventory", LR_AUTO);
	
		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\NewInventory_SyscoProducts_QA.txt" );
		fp=fopen( temp,"a+" );
		fprintf( fp,"\n OpCo :%s, Customer_ID :%s, InventoryID :%s, ProductID :%s, OpenDate :%s",lr_eval_string("{P_Sys_Opco}"),lr_eval_string("{P_SyscoID}"),lr_eval_string("{Corr_InventoryID}"),lr_eval_string("{Corr_ProductID}"),lr_eval_string("{Corr_OpenDate}"));
		fclose( fp );
			
	lr_start_transaction("WS08_05_Get_Current_Open_Inventory");
	
	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_SyscoID}");
	
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
	
	lr_end_transaction("WS08_05_Get_Current_Open_Inventory", LR_AUTO);

/************************* End of Create Inventory************************/

EndofWS:

	return 0;
}