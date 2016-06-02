//char *strcat(char *, char *);
Action()
{
//	char Revenuebody[500]="";
//	char Revenuebody2[5000]="";
	int i=0;
	int icount=0;
//	char Revenuebody1[500]="";
//	char Revenuebody3[5000]="";
	
/*************************Start of Revenues ************************/

	lr_start_transaction("WS07_00_Get_AccountByCustomerID");
	
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

	lr_end_transaction("WS07_00_Get_AccountByCustomerID", LR_AUTO);

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

/****************************************************Start Revenue***********************************************/
/*		
for (i=1;i<=20;i++) {
	
	if(i<2)
	{
		sprintf(Revenuebody,"{\"value\": \"100\"},{\"value\": \"200\"},{\"value\": \"300\"},{\"value\": \"400\"},{\"value\": \"500\"},");
	}
	else if(i<20)
	{	
	sprintf(Revenuebody,"{\"value\": \"100\"},{\"value\": \"200\"},{\"value\": \"300\"},{\"value\": \"400\"},{\"value\": \"500\"},");
	
	}
	else
	{
	sprintf(Revenuebody,"{\"value\": \"100\"},{\"value\": \"200\"},{\"value\": \"300\"},{\"value\": \"400\"},{\"value\": \"500\"}");
	}

		strcat(Revenuebody2, Revenuebody);

}

	lr_save_string(lr_eval_string(Revenuebody2), "Revenuebody0");
	lr_output_message("%s", lr_eval_string("{Revenuebody0}"));
*/	
	lr_think_time(2);
	
/************************************************Start of Revenues********************************************************/

	lr_start_transaction("WS07_01_Create_Revenue");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_RevenueID1","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_startDate1","LB=\"startDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_endDate1","LB=\"endDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_custom_request("CreateRevenue",
		"URL={P_URL}/revenues", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		//"Body={\n \"startDate\": \"{P_StartDate}\",\n \"endDate\": \"{P_EndDate}\",\n \"transactions\": [\n    {\"value\": \"100\"},{\"value\": \"200\"},{\"value\": \"300\"},{\"value\": \"400\"},{\"value\": \"500\"}\n ]\n}",
		"Body={\n \"startDate\": \"{P_StartDate}\",\n \"endDate\": \"{P_EndDate}\",\n \"transactions\": [\n {\"value\": \"100\"},{\"value\": \"200\"},{\"value\": \"300\"},{\"value\": \"400\"},{\"value\": \"500\"}\n ]\n}",
		LAST);
	
	lr_end_transaction("WS07_01_Create_Revenue", LR_AUTO);
	
		sprintf( temp,"\\\\ms240corp05\\DATA\\PerformanceTesting\\11_UOM\\Runtime_Data\\CreateRevenue_QA.txt" );
		fp=fopen( temp,"a+" );
		fprintf( fp,"OpCo :%s, Customer_ID :%s, RevenueID :%s, StartDate :%s, EndDate :%s",lr_eval_string("{P_OpCo}"),lr_eval_string("{P_CustomerID}"),lr_eval_string("{Corr_RevenueID}"),lr_eval_string("{P_StartDate}"),lr_eval_string("{P_EndDate}"));
		fclose( fp ); 

	lr_think_time(2);
	
//http://internal-qa-uom-services-private-elb-306417685.us-east-1.elb.amazonaws.com:80/revenues?startDate=2016-04-16T03%3A42%3A28.335Z&endDate=2016-04-20T04%3A42%3A28.335Z

	lr_start_transaction("WS07_02_Get_RevenueByID");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_RevenueID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_startDate","LB=\"startDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_endDate","LB=\"endDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_RevenueID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);

	web_url("GetRevenueBetweenDates",
		"URL={P_URL}/revenues?startDate={P_Filedate}&endDate={P_EndDate}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS07_02_Get_RevenueByID", LR_AUTO);

	lr_think_time(3);

	lr_start_transaction("WS07_03_Get_RevenueByID");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_RevenueID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_startDate","LB=\"startDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	web_reg_save_param("Corr_endDate","LB=\"endDate\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_url("GetRevenueByID",
		"URL={P_URL}/revenues/{Corr_RevenueID}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("WS07_03_Get_RevenueByID", LR_AUTO);
	
/*for (i=1;i<=20;i++) {	

	if(i<2)
	{
		sprintf(Revenuebody1,"{\"value\": \"10\"},{\"value\": \"20\"},{\"value\": \"30\"},{\"value\": \"40\"},{\"value\": \"50\"},");
	}
	else if(i<20)
	{	
	sprintf(Revenuebody1,"{\"value\": \"60\"},{\"value\": \"70\"},{\"value\": \"80\"},{\"value\": \"90\"},{\"value\": \"25\"},");
	
	}
	else
	{
	sprintf(Revenuebody1,"{\"value\": \"15\"},{\"value\": \"25\"},{\"value\": \"35\"},{\"value\": \"45\"},{\"value\": \"55\"}");
	}

		strcat(Revenuebody3, Revenuebody1);
	}
	lr_save_string(lr_eval_string(Revenuebody3), "Revenuebody4");
	lr_output_message("%s", lr_eval_string("{Revenuebody4}"));
*/

	lr_start_transaction("WS07_04_Update_Revenue");
	
	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_RevenueID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_custom_request("UpdateRevenue",
		"URL={P_URL}/revenues/{Corr_RevenueID}", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer={P_URL}/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		//"Body={\n \"items\": [\n  {   \"id\": \"{Corr_ProductID}\",\n   \"price\": 10,\n   \"priceUom\": \"CS\",\n   \"groups\": [\n    {\n     \"groupId\": \"{Corr_GroupID}\",\n     \"sequence\": 1,\n    \"quantity\": 1,\n     \"quantityUom\": \"CS\"\n    }\n   ],\n   \"customerImages\": [\n    \"Test\"\n   ]\n  }\n ]\n}", 
		"Body={\n \"startDate\": \"{Corr_startDate1}\",\n \"endDate\": \"{Corr_endDate}\",\n \"transactions\": [\n {\"value\": \"110\"},{\"value\": \"210\"},{\"value\": \"310\"},{\"value\": \"410\"},{\"value\": \"510\"},{\"value\": \"110\"} \n ]\n}",
		LAST);
	
	lr_end_transaction("WS07_04_Update_Revenue", LR_AUTO);
	
	lr_think_time(3);
	//revenues?startDate=2016-04-18T10%3A07%3A25.603Z&endDate=2016-04-19T10%3A07%3A25.603Z
		
/*	lr_start_transaction("Get_Revenue_Between_Dates");

	web_add_header("Authorization","Bearer {P_OpCo}|{P_CustomerID}|{P_UserID}");
	
	web_reg_save_param("Corr_RevenueID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=ALL",LAST);

	web_url("GetRevenueBetweenDates",
		"URL={P_URL}/revenues?startDate={P_StartDate}&endDate={P_EndDate}",
		"TargetFrame=",
		"Resource=0",
		"Referer=",
		"Mode=HTML",
		LAST);

	lr_end_transaction("Get_Revenue_Between_Dates", LR_AUTO);
*/
	
/*************************************************End of Revenues********************************************************/

	return 0;
}