Action()
{

	web_add_cookie("BNES_homePath=uFBQiUkMwH6MNVF0mGQps0AKZFEXPZG3TCrb2P2HQ+KsAUFmEFko7W5PZybLpAQAzH6jAeVm8pXIHG6nNDQN5pb1w1nDGq0x; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("JSESSIONID=0000x_oh6vzjL0S5yPJxB9rQsRX:-1; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("system=sus; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("Path=/; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("homePath=OMAPX_r20.0.0.2; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_JSESSIONID=ok3BRP20Ybf0xB6Bz44eTUQ3POouoXL5lHLc6h4X9DhCt7PSFxAykMXpXKrDUC11IJmdR/lpfjHcUvvOqLCE0ar7ckcdiP+S4tQOYHbSXUDXFUQ4OvEiow==; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_system=2SbkBq4OMXCK/GAh1LUrv4hawKhp0tDWuY7YXs41vK7SdLChQtbR82fi5tMANo3VgxUKeF5DLk0=; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_homePath=cwbwLt00oriiRGBfXxb0iLPzvwOHBR0OjJaVlPsNbOdLB/xTIWPCe7CMoqJMZkCr2eRT/KLgp76Ouf3Utw1o85sfUS8zX3e/; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_jsessionid=JNgkiEb4oX/Arw9kem6lw2WUqNMllqKI4AmrxvuEC6fwyZvGpPMLHCiOIR0AHsGhyw3Aufwq0d2/urErF0RJZ/uiPOh1qNR7NPe4ZtlcwvshXFSnhZ2Yiw==; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_JSESSIONID=b0XWQulESj1CPJuHUw0ErFZiMMWYBJ3vetZs9vkDUW3DzGnziAKlWzQ5nfIqMmzr/+l68cccRck7LIk1hIe4WbpE1EFn7A/10dxr48zAzeWZMP7DMtySXg==; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_system=rX9UVpVq4t4Zn+gTIbZn+LwdnoQnR4FUiBCCQbJGMkO6yHZ3GoJcD1IqBrcWIfPF7yrQWYkVU24=; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_custom_request("login", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/login", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"username\":\"PTMApp44\",\"password\":\"Security1\"}", 
		EXTRARES, 
		"Url=user", "Referer=", ENDITEM, 
		"Url=../inventories/current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		"Url=../suppliers", "Referer=", ENDITEM, 
		"Url=../inventories/timePeriods", "Referer=", ENDITEM, 
		"Url=../purchases?fromDate=2016-05-12T10%3A53%3A47.847Z&toDate=2016-05-23T15%3A03%3A11.681Z", "Referer=", ENDITEM, 
		"Url=../groups?type=expensecategory", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("purchases", 
		"URL=https://onlineapi-qa.cloud.sysco.com/purchases", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"supplier\":\"5ced9cda-9a01-4539-b14a-419fb64182c9\",\"invoiceNumber\":\"2345\",\"date\":\"2016-05-22\",\"invoiceTotal\":100,\"expenseCategory\":\"02ddd82a-24aa-41e1-8e49-446e4f237584\",\"expenseAmount\":\"100\",\"items\":[]}", 
		EXTRARES, 
		"Url=/inventories/timePeriods", "Referer=", ENDITEM, 
		"Url=/purchases?fromDate=2016-05-12T10%3A53%3A47.847Z&toDate=2016-05-23T15%3A03%3A50.498Z", "Referer=", ENDITEM, 
		"Url=/suppliers", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("logout", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/logout", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=", 
		LAST);

	return 0;
}