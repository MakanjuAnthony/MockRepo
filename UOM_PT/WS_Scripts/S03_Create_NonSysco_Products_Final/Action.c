Action()
{
int i=0;

/*************************Start of Create Non-Sysco Products ***************************/

	lr_start_transaction("WS03_00_Get_AccountByCustomerID");
	
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

	lr_end_transaction("WS03_00_Get_AccountByCustomerID", LR_AUTO);

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
//else
//{
//	goto endofWS;
//}

//	lr_start_transaction("WS02_05_Get_ListOfSuppliers");
	
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

//	lr_end_transaction("WS02_05_Get_ListOfSuppliers", LR_AUTO);

if(strcmp(lr_eval_string("{Corr_SupplierID_1}"),"")==0)
{
	for (i=1;i<=5;i++) 
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
	
	lr_end_transaction("WS01_04_Create_New_Suppliers", LR_AUTO);
		
		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\Create_New_Suppliers_QA.txt" );
	
			fp=fopen( temp,"a+" );
			fprintf( fp,"\n CustomerID :%s, Supplier_ID :%s, Supplier_Name :%s",lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_SupplierID}"),lr_eval_string("{Corr_SupplierName}"));
			fclose( fp );
		
	lr_think_time(2);
	}

	lr_think_time(3);
	
	lr_start_transaction("WS03_01_Get_ListOfSuppliers");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_SupplierID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_SupplierName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);

	web_url("SuppliersList",
		"URL={P_URL}/suppliers",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS03_01_Get_ListOfSuppliers", LR_AUTO);
}
	
	lr_think_time(3);
	
for (i=1;i<=10;i++)
{
	
	lr_start_transaction("WS03_02_Insert_NonSysco_Product");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_ProductName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_MaterialID","LB=\"materialId\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_ProductID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);

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
		"Body={\n \"name\": \"{P_ProductName}\",\n \"materialId\": \"{P_MaterialID}\",\n \"supplier\": \"{Corr_SupplierID_2}\",\n \"brand\": \"{P_Brand}\",\n \"description\": \"Test1\",\n \"nickName\": \"ABC\",\n \"type\": \"prepared\",\n \"averageWeightPerCase\": {P_AvgWtPerCase},\n \"packSize\": {\n  \"pack\": \"string\",\n  \"size\": \"string\",\n  \"uom\": \"{P_UOM}\"\n }\n}",
		LAST);

	lr_end_transaction("WS03_02_Insert_NonSysco_Product", LR_AUTO);
	
	sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\Insert_NonSysco_Product_QA_Integrated.txt" );

		fp=fopen( temp,"a+" );
		fprintf( fp,"\n CustomerID :%s, Product_ID :%s, Product_Name :%s, SupplierID :%s",lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_ProductID}"),lr_eval_string("{Corr_ProductName}"),lr_eval_string("{Corr_SupplierID_2}"));
		fclose( fp );

	lr_think_time(3);
}

	lr_start_transaction("WS03_03_Get_Product_By_Product_ID");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_url("GetProductByProductID",
		"URL={P_URL}/products/{Corr_ProductID}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);
	
	lr_end_transaction("WS03_03_Get_Product_By_Product_ID", LR_AUTO);

	lr_think_time(2);
	
	lr_start_transaction("WS03_04_Get_NonSysco_ListOfProducts");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_ProductID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_MaterialID","LB=\"materialId\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_ProductName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	
	web_url("ProductsList",
		"URL={P_URL}/products",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS03_04_Get_NonSysco_ListOfProducts", LR_AUTO);
	
	lr_think_time(3); 
	
	lr_start_transaction("WS03_05_Update_NonSysco_Product");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("UpdateProduct", 
		"URL={P_URL}/products/{Corr_ProductID_1}", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n \"materialId\": \"{Corr_MaterialID_1}\",\"name\": \"{P_ProductName}\",\n \"description\": \"Test1\",\n \"nickName\": \"ABC\",\n \"brand\": \"{P_Brand}\",\n  \"supplier\": \"{Corr_SupplierID_2}\",\n \"averageWeightPerCase\": {P_AvgWtPerCase},\n \"packSize\": {\n  \"pack\": \"String\",\n  \"size\": \"String\",\n  \"uom\": \"CS\"\n }\n}",
		LAST);
	
	lr_end_transaction("WS03_05_Update_NonSysco_Product", LR_AUTO);
	
	lr_think_time(4);
	
	lr_start_transaction("WS03_06_Delete_NonSysco_Product");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");

	web_custom_request("DeleteNonSyscoProduct",
		"URL={P_URL}/products/{Corr_ProductID_1}",
		"Method=Delete",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

 	lr_end_transaction("WS03_06_Delete_NonSysco_Product", LR_AUTO); 

	lr_think_time(3);

for(i=1;i<=5;i++)
{
	lr_start_transaction("WS03_07_Get_SyscoProducts");
	
	web_add_header("Authorization","Bearer {P_Sys_Opco}|{P_SyscoID}|{P_UserID}");
	
	web_reg_save_param("Corr_ProductID","LB={\"id\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_MaterialID","LB=\"materialId\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	web_reg_save_param("Corr_ProductName","LB=\"name\":\"","RB=\"","NOTFOUND=warning","ORD=All",LAST);
	
	web_url("SyscoProductsList",
		"URL={P_URL}/products/{P_SyscoProdID}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS03_07_Get_SyscoProducts", LR_AUTO);
}
/************************* End of Create Non-Sysco Products************************/
endofWS:

	return 0;
}