
	Action()
{
		
		
		int i=0;

	web_set_sockets_option("SSL_VERSION", "TLS1.2");


	web_reg_save_param("Corr_CustomerID","LB=\"id\":\"","RB=\",\"opco","NOTFOUND=warning","ORD=1",LAST);
	
	web_reg_save_param("Corr_OpCO","LB=\"opco\":{\"id\":\"","RB=\",\"name\"","NOTFOUND=warning","ORD=1",LAST);
	
	//{"id":"f0e3322a-4cc3-4d46-b804-8d7e4dcdadb0","name":
	
//	web_reg_save_param("Corr_ID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);	
	
	//"id":"f0e3322a-4cc3-4d46-b804-8d7e4dcdadb0","name":"{param_LocationId} edit","storage
	
//	TX 77341","id":"024448","opco":{"id":"067","name"
	
	web_add_header("Authorization","Bearer {Corr_OpCO}|{Corr_CustomerID}|{UserID}");
	web_add_header("Origin","file://");
	web_reg_find("Text=locations",LAST);
	web_custom_request("login_2", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/login", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"username\":\"{UserID}\",\"password\":\"{paramPassword}\"}",
//		EXTRARES,
//	    "Url=../inventories/current?withAllProductAttributes=true", "Referer=", ENDITEM, 		
		LAST);


	lr_start_transaction("create location");
	
	web_add_header("Authorization","Bearer {Corr_OpCO}|{Corr_CustomerID}|{UserID}");
	web_reg_save_param("Corr_ID","LB=\"id\":\"","RB=\"","NOTFOUND=warning","ORD=1",LAST);
	
	web_custom_request("groups",
		"URL=https://onlineapi-qa.cloud.sysco.com/groups", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"id\":\"\",\"type\":\"location\",\"name\":\"{param_LocationId}\",\"storage\":\"C\"}", 
		//EXTRARES, 
		//"Url=/groups/{Corr_ID}", "Referer=", ENDITEM, 
		//"Url=/groups?type=location", "Referer=", ENDITEM, 
		LAST);
if(strcmp(lr_eval_string("{Corr_ID}"),"")==0)
{lr_end_transaction("create location",LR_FAIL);}
	
else
{lr_end_transaction("create location",LR_PASS);}



	lr_start_transaction("Edit location");
	web_add_header("Authorization","Bearer {Corr_OpCO}|{Corr_CustomerID}|{UserID}");
	web_custom_request("{Corr_ID}", 
		"URL=https://onlineapi-qa.cloud.sysco.com/groups/{Corr_ID}", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		"Body={\"id\":\"{Corr_ID}\",\"type\":\"location\",\"name\":\"{param_LocationId} edit\",\"storage\":\"C\"}", 
	//	EXTRARES, 
	//	"Url=../groups?type=location", "Referer=", ENDITEM, 
	//	"Url={Corr_ID}", "Referer=", ENDITEM, 
//		
		LAST);

	
if(strcmp(lr_eval_string("{Corr_ID}"),"")==0)
{lr_end_transaction("Edit location",LR_FAIL);}
	
else
{lr_end_transaction("Edit location",LR_PASS);}


	


	lr_start_transaction("Delete");
	web_add_header("Authorization","Bearer {Corr_OpCO}|{Corr_CustomerID}|{UserID}");
	web_custom_request("{Corr_ID}_2", 
		"URL=https://onlineapi-qa.cloud.sysco.com/groups/{Corr_ID}", 
		"Method=DELETE", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t6.inf", 
		"Mode=HTML", 
//		EXTRARES, 
//		"Url=../groups?type=location", "Referer=", ENDITEM, 
//		
		LAST);
	lr_output_message(" Deleted ");
		
if(strcmp(lr_eval_string("{Corr_ID}"),"")==0)
{lr_end_transaction("Delete",LR_FAIL);}
	
else
{lr_end_transaction("Delete",LR_PASS);}


	

	return 0;
}
	