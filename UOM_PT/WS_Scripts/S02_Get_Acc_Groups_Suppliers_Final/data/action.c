Action()
{

	web_reg_find("Text=Swagger UI", 
		LAST);

	web_url("swagger", 
		"URL=http://10.239.251.82:8080/swagger", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		LAST);

	web_url("droid-sans-v6-latin-700.woff2", 
		"URL=http://10.239.251.82:8080/swagger-static/fonts/droid-sans-v6-latin-700.woff2", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://10.239.251.82:8080/swagger-static/css/typography.css", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		LAST);

	web_url("droid-sans-v6-latin-regular.woff2", 
		"URL=http://10.239.251.82:8080/swagger-static/fonts/droid-sans-v6-latin-regular.woff2", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://10.239.251.82:8080/swagger-static/css/typography.css", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		LAST);

	lr_think_time(11);

	lr_start_transaction("Create_New_Account");

	web_custom_request("accounts", 
		"URL=http://10.239.251.82:8080/accounts", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=http://10.239.251.82:8080/swagger", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\n  \"accountNumber\": \"10223\",\n  \"locations\": [\n    \"Store\"\n  ],\n  \"categories\": [\n    {\n      \"name\": \"Paper Towel\",\n      \"foodType\": \"NonFood\"\n    }\n  ]\n}", 
		LAST);

	return 0;
}