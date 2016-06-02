char *strcat(char *, char *);
Action()
{
	char Purbody[500]="";
	char Purbody2[5000]="";
	int i=0;
	int j=0;
	int icount=0;
	
	char Purbody1[500]="";
	char Purbody3[5000]="";


/************************* Create Purchase ************************/

	lr_start_transaction("WS02_00_Get_AccountByCustomerID");
	
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

	lr_end_transaction("WS02_00_Get_AccountByCustomerID", LR_AUTO);

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

/*
if(strcmp(lr_eval_string("{Corr_PurchaseID}"),"")==0)
{
	lr_output_message("Looped into Create Purchase");
	goto CreateData;
}
	else
{
	lr_output_message("Not Looped into Create Purchase");
	goto endofWS;
}
	
CreateData:*/
/************************* Start of Supplier ************************/
	lr_start_transaction("WS02_05_Get_ListOfSuppliers");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_SupplierID_1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_SupplierID_2","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);

	web_url("SuppliersList",
		"URL={P_URL}/suppliers",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS02_05_Get_ListOfSuppliers", LR_AUTO);

	lr_think_time(1);

if(strcmp(lr_eval_string("{Corr_SupplierID_2}"),"")==0)
{
for (i=1;i<=2;i++) 
{
	lr_start_transaction("WS01_04_Create_New_Suppliers");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_SupplierID_1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
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
		fprintf( fp,"\n CustomerID :%s, Supplier_ID :%s, Supplier_Name :%s",lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_SupplierID_1}"),lr_eval_string("{Corr_SupplierName}"));
		fclose( fp );
	
	lr_end_transaction("WS01_04_Create_New_Suppliers", LR_AUTO);
	
	lr_think_time(1);
}
}
/************************* Start of Groups ************************/
	lr_start_transaction("WS02_02_GetGroups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID_2","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);
	web_reg_save_param("Corr_GroupID_3","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=3",LAST);
	web_reg_save_param("Corr_GroupID_4","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=4",LAST);
	web_reg_save_param("Corr_GroupID_5","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=5",LAST);
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

	lr_think_time(1);

if(strcmp(lr_eval_string("{Corr_GroupID_2}"),"")==0)
{

for (i=1;i<=5;i++) 
{

	lr_start_transaction("WS01_03_Create_Groups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
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
	
	lr_end_transaction("WS01_03_Create_Groups", LR_AUTO);
	
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\CreateGroups_QA.txt" );

		fp=fopen( temp,"a+" );
		fprintf( fp,"\n Group Id, Name, Storage, Type, OPCO and CustomerID :\t%s\t%s\t%s\t%s\t%s\t%s",lr_eval_string("{Corr_GroupID_1}"),lr_eval_string("{P_GroupName}"),lr_eval_string("{P_StorageName}"),lr_eval_string("{P_Location}"),lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"));
		fclose( fp );

	lr_think_time(2);

}
	lr_start_transaction("WS02_02_GetGroups");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_GroupID_1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID_2","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=2",LAST);
	web_reg_save_param("Corr_GroupID_3","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=3",LAST);
	web_reg_save_param("Corr_GroupID_4","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=4",LAST);
	web_reg_save_param("Corr_GroupID_5","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=5",LAST);
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
}

/************************* End of Groups ***************************/

lr_think_time(2);

for(j=1;j<=2;j++)
{
for (i=1;i<=5;i++) {
	
	if(i<2)
	{
		sprintf(Purbody,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 20\n   },",lr_eval_string("{Corr_GroupID_1}"));
//		sprintf(Purbody,"{\"items\": [ { \"id\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": 1, \"price\": 12.5, \"quantity\": 5, \"quantityUom\": \"EA\", \"priceUom\": \"EA\" } ], \"customerImages\": [ \"string\" ] } ]}",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{Corr_GroupID}"));
	}
	else if(i<3)
	{
		sprintf(Purbody,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 20\n   },",lr_eval_string("{Corr_GroupID_2}"));
	}
	else if(i<4)
	{
		sprintf(Purbody,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 20\n   },",lr_eval_string("{Corr_GroupID_3}"));
	}
	else if(i<5)
	{
		sprintf(Purbody,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 20\n   },",lr_eval_string("{Corr_GroupID_4}"));
	}
	else
	{
		sprintf(Purbody,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 20\n   }",lr_eval_string("{Corr_GroupID_5}"));
//		sprintf(Purbody, "{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] } ] }",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
//		lr_save_string(lr_eval_string(Purbody), "Purbody0");
		strcat(Purbody2, Purbody);

}
	
	lr_save_string(lr_eval_string(Purbody2), "Purbody0");
	lr_output_message("%s", lr_eval_string("{Purbody0}"));

	sprintf(Purbody2,"");
	
	lr_think_time(2);
	
	lr_start_transaction("WS06_01_Get_Create_NonSysco_Purchase");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_DeletedStatus","LB=\"deleted\":","RB=}","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_PurchaseID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_SupplierID","LB=\"supplier\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID","LB=\"groupId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);	
//	web_reg_save_param("Corr_InvoiceDate","LB=\"date\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
//P_Inv_Time
	if(j==1)
	{
	web_custom_request("CreateNonSyscoPurchase", 
		"URL={P_URL}/purchases", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
	//	"Body={\n \"supplier\": \"{Corr_SupplierID_2}\",\n \"date\": \"{Corr_InvoiceDate}\",\n \"invoiceNumber\": \"{P_InvoiceNumber}\",\n    \"invoiceTotal\": 10,\n \"items\": [\n  {\n    \"groupId\": \"{Corr_GroupID}\",\n    \"currentExtendedPrice\": 10\n  }\n ]\n}",
		"Body={\n  \"supplier\": \"{Corr_SupplierID_1}\",\n \"date\": \"{P_Inv_Time}\",\n \"invoiceNumber\": \"{P_InvoiceNumber}\",\n \"invoiceTotal\": 100,\n \"items\": [\n  {Purbody0}\n ]\n}",	
		LAST);
	}
	else
	{
	web_custom_request("CreateNonSyscoPurchase", 
		"URL={P_URL}/purchases", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
	//	"Body={\n \"supplier\": \"{Corr_SupplierID_2}\",\n \"date\": \"{Corr_InvoiceDate}\",\n \"invoiceNumber\": \"{P_InvoiceNumber}\",\n    \"invoiceTotal\": 10,\n \"items\": [\n  {\n    \"groupId\": \"{Corr_GroupID}\",\n    \"currentExtendedPrice\": 10\n  }\n ]\n}",
		"Body={\n  \"supplier\": \"{Corr_SupplierID_2}\",\n \"date\": \"{P_Inv_Time}\",\n \"invoiceNumber\": \"{P_InvoiceNumber}\",\n \"invoiceTotal\": 100,\n \"items\": [\n  {Purbody0}\n ]\n}",	
		LAST);
		
	}
		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\NewPurchase_QA.txt" );
		fp=fopen( temp,"a+" );
		fprintf( fp,"\n OpCo :%s, Customer_ID :%s, PurchaseID :%s, SupplierID :%s, GroupID :%s",lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_PurchaseID}"),lr_eval_string("{Corr_SupplierID}"),lr_eval_string("{Corr_GroupID}"));
		fclose( fp );
		
	lr_end_transaction("WS06_01_Get_Create_NonSysco_Purchase", LR_AUTO);
	
}
	
/************************* End of Create Purchase ************************/

	lr_think_time(4);

/*	lr_start_transaction("WS06_08_Get_All_Purchases");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_PurchaseID_A","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	web_reg_save_param("Corr_SupplierID","LB=\"supplier\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID","LB=\"groupId\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	
	web_url("GetAllPurchase",
		"URL={P_URL}/purchases?withSupplierDefinitions=true",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS06_08_Get_All_Purchases", LR_AUTO);

	lr_think_time(4);
	*/
	lr_start_transaction("WS06_02_Get_All_Purchases");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_PurchaseID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	web_reg_save_param("Corr_SupplierID","LB=\"supplier\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID","LB=\"groupId\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	
	web_url("GetAllPurchaseWithDateRange",
		"URL={P_URL}/purchases?withSupplierDefinitions=true&fromDate={P_StartDate}&toDate={P_EndDate}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS06_02_Get_All_Purchases", LR_AUTO);
	
	lr_start_transaction("WS06_03_Get_PurchaseByID");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_PurchaseID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_SupplierID","LB=\"supplier\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_date","LB=\"date\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID","LB=\"groupId\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_InvNumber","LB=\"invoiceNumber\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetPurchaseByID",
		"URL={P_URL}/purchases/{Corr_PurchaseID}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS06_03_Get_PurchaseByID", LR_AUTO);

	lr_think_time(4);
	
for (i=1;i<=5;i++) 
{
	
	if(i<2)
	{
		sprintf(Purbody1,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 30\n   },",lr_eval_string("{Corr_GroupID_1}"));
//		sprintf(Purbody,"{\"items\": [ { \"id\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": 1, \"price\": 12.5, \"quantity\": 5, \"quantityUom\": \"EA\", \"priceUom\": \"EA\" } ], \"customerImages\": [ \"string\" ] } ]}",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{Corr_GroupID}"));
	}
	else if(i<3)
	{
		sprintf(Purbody1,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 20\n   },",lr_eval_string("{Corr_GroupID_2}"));
	}
	else if(i<4)
	{
		sprintf(Purbody1,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 30\n   },",lr_eval_string("{Corr_GroupID_3}"));
	}
	else if(i<5)
	{
		sprintf(Purbody1,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 20\n   },",lr_eval_string("{Corr_GroupID_4}"));
	}
	else
	{
		sprintf(Purbody1,"{\n     \"groupId\": \"%s\",\n     \"currentExtendedPrice\": 30\n   }",lr_eval_string("{Corr_GroupID_5}"));
//		sprintf(Purbody, "{ \"id\": \"%s\", \"price\": %s, \"priceUom\": \"%s\", \"groups\": [ { \"groupId\": \"%s\", \"sequence\": %d, \"quantity\": %s, \"quantityUom\": \"%s\" } ], \"customerImages\": [ \"string\" ] } ] }",lr_eval_string("{Corr_ProductID}"), lr_eval_string("{P_Price}"), lr_eval_string("{P_UOM}"), lr_eval_string("{Corr_GroupID_1}"), i, lr_eval_string("{P_Quantity}"), lr_eval_string("{P_UOM}"));
	}
//		lr_save_string(lr_eval_string(Purbody), "Purbody0");
		strcat(Purbody3, Purbody1);
		
}
	
	lr_save_string(lr_eval_string(Purbody3), "Purbody4");
	lr_output_message("%s", lr_eval_string("{Purbody4}"));
	sprintf(Purbody3,"");

	
	lr_start_transaction("WS06_04_Update_Purchase");
		
		web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
		
		web_reg_save_param("Corr_PurchaseID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
		web_reg_save_param("Corr_DeletedStatus","LB=\"deleted\":","RB=","NOTFOUND=warning","ORD=1",LAST);
		web_reg_save_param("Corr_SupplierID","LB=\"supplier\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
		web_reg_save_param("Corr_GroupID","LB=\"groupId\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	
		web_custom_request("UpdatePurchase", 
			"URL={P_URL}/purchases/{Corr_PurchaseID}", 
			"Method=POST", 
			"TargetFrame=", 
			"Resource=0", 
			"RecContentType=application/json", 
			"Referer={P_URL}/swagger", 
			"Snapshot=t4.inf", 
			"Mode=HTML", 
			"EncType=application/json", 
			//"Body={\n \"supplier\": \"{Corr_SupplierID}\",\n \"date\": \"{P_Inv_Time}\",\n \"invoiceNumber\": \"{P_InvoiceNumber}\",\n    \"invoiceTotal\": 130,\n \"items\": [\n  {\n    \"groupId\": \"{Corr_GroupID}\",\n    \"currentExtendedPrice\": 30\n  }\n ]\n}",
			//"Body={Purbody4}",
			"Body= {\n  \"supplier\": \"{Corr_SupplierID}\",\n \"date\": \"{Corr_date}\",\n \"invoiceNumber\": \"{Corr_InvNumber}\",\n \"invoiceTotal\": 130,\n \"items\": [\n  {Purbody4}\n ]\n}",
			LAST);

		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\UpdatePurchase_QA.txt" );
	
			fp=fopen( temp,"a+" );
			fprintf( fp,"OpCo :%s, Customer_ID :%s, PurchaseID :%s, SupplierID :%s, GroupID :%s, InvoiceNumber :%s, InvoiceDate :%s, Deleted :%s",lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_PurchaseID}"),lr_eval_string("{Corr_SupplierID}"),lr_eval_string("{Corr_GroupID}"),lr_eval_string("{P_Inv_Time}"),lr_eval_string("{P_InvoiceDate}"),lr_eval_string("{Corr_DeletedStatus}"));
			fclose( fp ); 
			
	lr_end_transaction("WS06_04_Update_Purchase", LR_AUTO);

	lr_think_time(4);
	
	lr_start_transaction("WS06_05_Delete_Purchase");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
//	web_reg_save_param("Corr_InvoiceDate","LB=\"date\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_PurchaseID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_SupplierID","LB=\"supplier\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_GroupID","LB=\"groupId\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);
	web_reg_save_param("Corr_DeletedStatus","LB=\"deleted\":","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_custom_request("DeletePurchase",
		"URL={P_URL}/purchases/{Corr_PurchaseID_1}",
		"Method=Delete",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS06_05_Delete_Purchase", LR_AUTO);


/*************************************************End of Purchase********************************************************/
	
endofWS:

	return 0;
}