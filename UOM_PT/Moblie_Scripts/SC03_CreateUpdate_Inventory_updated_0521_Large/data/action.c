Action()
{

	web_add_cookie("BNES_homePath=704mWTw0obdcNN4IBkYyIVmlqa2arNsTxtmY8lYlfCC3MGo8FEkLVIQCGDPiH80zHktsD5pPeiCM7FqH/9zfCu04oyFHNf3M; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_jsessionid=TvJVYBgHmHhaEmJotiRVelR8lXodPXs5de0r+LpmUoONiLZ8DXcEYNiABvWQMXQIUmLKD4eEsXVfVeToUBlqKD7Rrz1slaN9ntTAZo2CSz42rA+OnpvGOA==; DOMAIN=onlineapi-qa.cloud.sysco.com");

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
		"Body={\"username\":\"PTNormal30\",\"password\":\"Security1\"}", 
		LAST);

	web_add_cookie("JSESSIONID=0000zOkvPOAlcsnNtuq57MKycgv:-1; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("system=sus; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("Path=/; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("homePath=OMAPX_r20.0.0.2; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_JSESSIONID=75gq+82dLDW48ojbSw2PrieOX/lhYFwb/xzLlNpNcp9p0SYKD1bMd3Vu0ExfGhLAJAZ8VIAOSSrOkR7BHM27riigXTMk6Pu+zayqGDNpfh43W8bp3DyxCA==; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_system=sYTIwSr8IMSCWiA2/tsO9TMEdUolBigKQScQ/cqPTJSXYjH82fjOm6IE7T7/QuFIXeEpgGwtppA=; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_homePath=eKLUeuQQPD2hO85buKiG3nw5RL/hpnc2uHFtsKZmgGpubKp8dCIlBxFwcyZsi3Z9hbkCnRrMJ23KtPnBqZEhgspyAMFo379O; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_custom_request("login_2", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/login", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"username\":\"PTNormal30\",\"password\":\"Security1\"}", 
		EXTRARES, 
		"Url=user", "Referer=", ENDITEM, 
		LAST);

	web_add_cookie("BNES_jsessionid=5vslXbKa3ZovEpzGiEjMbXazuOlrwm8PXltxqgTJvQv39Sd8zVvK09iqQEOjGK2Y6Lraq2pk2Djmrdal1DJ31wkq0GHZyjqPK1DccyOQpbK46D6m1w9F2A==; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_JSESSIONID=0QqIpK1Gbkh+owFbNof8mQeDpvh2lxCRKBZ87EAf0A5u/h8xKUFt4L30mjV7pdEslov/VYV438P1Axzh7VE9sKSSvp0NKAR0SH3zdYtLdGivi8sPttqpcA==; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_add_cookie("BNES_system=llqIsAReyltAZJMZuRFP85KTGUX8L/XY8x7+Oodwm6ctjM0w/nUlQqAlKfPuf0fKFds76AD6tDM=; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_custom_request("orderguide", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/inventory/import/orderguide", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"useEndecaOrderGuide\":true,\"groups\":\"default\"}", 
		LAST);

	web_custom_request("expensecategories", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/inventory/setup/expensecategories", 
		"Method=POST", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"groups\":\"food/nonfood\"}", 
		EXTRARES, 
		"Url=/inventories/current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		"Url=/groups?type=location", "Referer=", ENDITEM, 
		"Url=/groups", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("1be7749b-0ac9-4c77-ac39-e9c94b215424", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/1be7749b-0ac9-4c77-ac39-e9c94b215424", 
		"Method=PUT", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		body_variable_1, 
		EXTRARES, 
		"Url=../groups?type=location", "Referer=", ENDITEM, 
		"Url=../groups", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("1be7749b-0ac9-4c77-ac39-e9c94b215424_2", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/1be7749b-0ac9-4c77-ac39-e9c94b215424", 
		"Method=PUT", 
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t6.inf", 
		"Mode=HTML", 
		body_variable_2, 
		EXTRARES, 
		"Url=../groups?type=location", "Referer=", ENDITEM, 
		LAST);

	return 0;
}