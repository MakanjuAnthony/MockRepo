Action()
{

	web_add_cookie("BNES_homePath=6cRmfgnttF7f3o8PRCxxaK67KTJAGHAcc11R5lXEyKXLu0tKNSzo7T/uS4jurxJ7vsGJg98joX0iMHmcquy/R7gEWHVvwZyZ; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_custom_request("login", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/login", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"username\":\"PTNormal06\",\"password\":\"Security1\"}", 
		EXTRARES, 
		"Url=user", "Referer=", ENDITEM, 
		"Url=../suppliers", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("suppliers", 
		"URL=https://onlineapi-qa.cloud.sysco.com/suppliers", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"id\":\"\",\"name\":\"PT_Supplier\",\"contactInformation\":{\"phoneNumber\":\"345 345 4567\",\"address\":\"28 main st\",\"contactName\":\"Mr tester\",\"emailAddress\":\"mtester@tester.com\"},\"notes\":\"Sample text\"}", 
		EXTRARES, 
		"Url=/suppliers/1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c", "Referer=", ENDITEM, 
		"Url=/suppliers", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("nonsysco", 
		"URL=https://onlineapi-qa.cloud.sysco.com/products/nonsysco", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\",\"uom\":\"\"},\"type\":\"nonsysco\"}", 
		EXTRARES, 
		"Url=../groups", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("scratch", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/inventory/setup/scratch", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"storageFlag\":\"\"}]}", 
		EXTRARES, 
		"Url=/inventories/current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("locations", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/inventory/setup/locations", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"groups\":[{\"name\":\"PT_loc_C\",\"foodType\":\"cooler\",\"items\":[\"cec00f98-a43d-423d-a1b6-4632e061e056\"]}]}", 
		EXTRARES, 
		"Url=/inventories/current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("expensecategories", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/inventory/setup/expensecategories", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t6.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"groups\":[{\"name\":\"Exp_Food\",\"foodType\":\"food\",\"items\":[]}]}", 
		EXTRARES, 
		"Url=/inventories/current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		"Url=/groups?type=location", "Referer=", ENDITEM, 
		"Url=/groups", "Referer=", ENDITEM, 
		"Url=/suppliers", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("nonsysco_2", 
		"URL=https://onlineapi-qa.cloud.sysco.com/products/nonsysco", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t7.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"name\":\"PT_Prod02\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSProd02\",\"brand\":\"Pbrand2\",\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\",\"uom\":\"\"},\"type\":\"nonsysco\"}", 
		LAST);

	web_custom_request("2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t8.inf", 
		"Mode=HTML", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0}],\"customerImages\":[],\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\"},\"deleted\":false,\"originalIndex\":0},{\"selected\":true,\"storageFlag\":\"\""
		",\"opCo\":\"067\",\"customerId\":\"468140\",\"id\":\"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"name\":\"PT_Prod02\",\"materialId\":\"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"brand\":\"Pbrand2\",\"type\":\"nonSysco\",\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\"},\"deleted\":false,\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"quantity\":0,\"quantityUom\":\"cs\",\"sequence\":0}],\""
		"price\":3,\"priceUom\":\"cs\"}]}", 
		EXTRARES, 
		"Url=../groups", "Referer=", ENDITEM, 
		"Url=current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		"Url=../suppliers", "Referer=", ENDITEM, 
		"Url=../groups?type=expensecategory", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("nonsysco_3", 
		"URL=https://onlineapi-qa.cloud.sysco.com/products/nonsysco", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t9.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"name\":\"PT_Prod03\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp03\",\"brand\":\"Pbrand\",\"nickName\":\"\",\"averageWeightPerCase\":4,\"packSize\":{\"pack\":\"4\",\"size\":\"4\",\"uom\":\"\"},\"type\":\"nonsysco\"}", 
		LAST);

	web_custom_request("2e073a31-ccf4-4519-a499-fb4e6ccdaac6_2", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t10.inf", 
		"Mode=HTML", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0}],\"customerImages\":[],\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\"},\"deleted\":false,\"originalIndex\":0},{\"id\":\""
		"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"price\":3,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod02\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSProd02\",\"brand\":\"Pbrand2\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\"},\"deleted\":false,\""
		"originalIndex\":1},{\"selected\":true,\"storageFlag\":\"\",\"opCo\":\"067\",\"customerId\":\"468140\",\"id\":\"c3dd01e2-c455-424d-870b-d16baeef8cb6\",\"name\":\"PT_Prod03\",\"materialId\":\"c3dd01e2-c455-424d-870b-d16baeef8cb6\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"nickName\":\"\",\"averageWeightPerCase\":4,\"packSize\":{\"pack\":\"4\",\"size\":\"4\"},\"deleted\":false,\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\""
		"quantity\":0,\"quantityUom\":\"cs\",\"sequence\":0}],\"price\":4,\"priceUom\":\"cs\"}]}", 
		EXTRARES, 
		"Url=../groups", "Referer=", ENDITEM, 
		"Url=current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		"Url=../suppliers", "Referer=", ENDITEM, 
		"Url=../groups?type=expensecategory", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("nonsysco_4", 
		"URL=https://onlineapi-qa.cloud.sysco.com/products/nonsysco", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t11.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"name\":\"PT_Prod04\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp04\",\"brand\":\"Pbrand4\",\"nickName\":\"\",\"averageWeightPerCase\":5,\"packSize\":{\"pack\":\"5\",\"size\":\"5\",\"uom\":\"\"},\"type\":\"nonsysco\"}", 
		LAST);

	web_custom_request("2e073a31-ccf4-4519-a499-fb4e6ccdaac6_3", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t12.inf", 
		"Mode=HTML", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0}],\"customerImages\":[],\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\"},\"deleted\":false,\"originalIndex\":0},{\"id\":\""
		"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"price\":3,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod02\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSProd02\",\"brand\":\"Pbrand2\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\"},\"deleted\":false,\""
		"originalIndex\":1},{\"id\":\"c3dd01e2-c455-424d-870b-d16baeef8cb6\",\"price\":4,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod03\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp03\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":4,\"packSize\":{\"pack\":\"4\",\"size\":\"4\"},\""
		"deleted\":false,\"originalIndex\":2},{\"selected\":true,\"storageFlag\":\"\",\"opCo\":\"067\",\"customerId\":\"468140\",\"id\":\"d22b2ef7-94bb-4303-9975-ea08832b976e\",\"name\":\"PT_Prod04\",\"materialId\":\"d22b2ef7-94bb-4303-9975-ea08832b976e\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"brand\":\"Pbrand4\",\"type\":\"nonSysco\",\"nickName\":\"\",\"averageWeightPerCase\":5,\"packSize\":{\"pack\":\"5\",\"size\":\"5\"},\"deleted\":false,\"groups\":[{\"groupId\":\""
		"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"quantity\":0,\"quantityUom\":\"cs\",\"sequence\":0}],\"price\":5,\"priceUom\":\"cs\"}]}", 
		EXTRARES, 
		"Url=../groups", "Referer=", ENDITEM, 
		"Url=current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("2e073a31-ccf4-4519-a499-fb4e6ccdaac6_4", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t13.inf", 
		"Mode=HTML", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0}],\"customerImages\":[],\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\"},\"deleted\":false,\"originalIndex\":0},{\"id\":\""
		"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"price\":3,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod02\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSProd02\",\"brand\":\"Pbrand2\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\"},\"deleted\":false,\""
		"originalIndex\":1},{\"id\":\"c3dd01e2-c455-424d-870b-d16baeef8cb6\",\"price\":4,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod03\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp03\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":4,\"packSize\":{\"pack\":\"4\",\"size\":\"4\"},\""
		"deleted\":false,\"originalIndex\":2},{\"id\":\"d22b2ef7-94bb-4303-9975-ea08832b976e\",\"price\":5,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod04\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp04\",\"brand\":\"Pbrand4\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":5,\"packSize\":{\"pack\":\"5\","
		"\"size\":\"5\"},\"deleted\":false,\"originalIndex\":3}]}", 
		EXTRARES, 
		"Url=../groups?type=location", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("groups", 
		"URL=https://onlineapi-qa.cloud.sysco.com/groups", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t14.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"id\":\"\",\"type\":\"location\",\"name\":\"PT_loc_F\",\"storage\":\"F\"}", 
		EXTRARES, 
		"Url=/groups/afa8d221-ea99-4a7e-ac22-9b5812ab5853", "Referer=", ENDITEM, 
		"Url=/groups?type=location", "Referer=", ENDITEM, 
		"Url=/groups", "Referer=", ENDITEM, 
		"Url=/inventories/current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		"Url=/suppliers", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("nonsysco_5", 
		"URL=https://onlineapi-qa.cloud.sysco.com/products/nonsysco", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t15.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"name\":\"PT_Prod06\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp06\",\"brand\":\"Pbrand6\",\"nickName\":\"\",\"averageWeightPerCase\":6,\"packSize\":{\"pack\":\"6\",\"size\":\"6\",\"uom\":\"\"},\"type\":\"nonsysco\"}", 
		LAST);

	web_custom_request("2e073a31-ccf4-4519-a499-fb4e6ccdaac6_5", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t16.inf", 
		"Mode=HTML", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0}],\"customerImages\":[],\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\"},\"deleted\":false,\"originalIndex\":0},{\"id\":\""
		"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"price\":3,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod02\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSProd02\",\"brand\":\"Pbrand2\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\"},\"deleted\":false,\""
		"originalIndex\":1},{\"id\":\"c3dd01e2-c455-424d-870b-d16baeef8cb6\",\"price\":4,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod03\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp03\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":4,\"packSize\":{\"pack\":\"4\",\"size\":\"4\"},\""
		"deleted\":false,\"originalIndex\":2},{\"id\":\"d22b2ef7-94bb-4303-9975-ea08832b976e\",\"price\":5,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod04\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp04\",\"brand\":\"Pbrand4\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":5,\"packSize\":{\"pack\":\"5\","
		"\"size\":\"5\"},\"deleted\":false,\"originalIndex\":3},{\"selected\":true,\"storageFlag\":\"\",\"opCo\":\"067\",\"customerId\":\"468140\",\"id\":\"2d784160-909a-41b9-a881-651a48427a20\",\"name\":\"PT_Prod06\",\"materialId\":\"2d784160-909a-41b9-a881-651a48427a20\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"brand\":\"Pbrand6\",\"type\":\"nonSysco\",\"nickName\":\"\",\"averageWeightPerCase\":6,\"packSize\":{\"pack\":\"6\",\"size\":\"6\"},\"deleted\":false,\"groups\":[{\"groupId\":\""
		"afa8d221-ea99-4a7e-ac22-9b5812ab5853\",\"quantity\":0,\"quantityUom\":\"cs\",\"sequence\":0}],\"price\":6,\"priceUom\":\"cs\"}]}", 
		EXTRARES, 
		"Url=../groups", "Referer=", ENDITEM, 
		"Url=current?withAllProductAttributes=true", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("2e073a31-ccf4-4519-a499-fb4e6ccdaac6_6", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t17.inf", 
		"Mode=HTML", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0}],\"customerImages\":[],\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\"},\"deleted\":false,\"originalIndex\":0},{\"id\":\""
		"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"price\":3,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod02\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSProd02\",\"brand\":\"Pbrand2\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\"},\"deleted\":false,\""
		"originalIndex\":1},{\"id\":\"c3dd01e2-c455-424d-870b-d16baeef8cb6\",\"price\":4,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod03\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp03\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":4,\"packSize\":{\"pack\":\"4\",\"size\":\"4\"},\""
		"deleted\":false,\"originalIndex\":2},{\"id\":\"d22b2ef7-94bb-4303-9975-ea08832b976e\",\"price\":5,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod04\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp04\",\"brand\":\"Pbrand4\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":5,\"packSize\":{\"pack\":\"5\","
		"\"size\":\"5\"},\"deleted\":false,\"originalIndex\":3},{\"id\":\"2d784160-909a-41b9-a881-651a48427a20\",\"price\":6,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"afa8d221-ea99-4a7e-ac22-9b5812ab5853\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod06\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp06\",\"brand\":\"Pbrand6\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":6,\"packSize"
		"\":{\"pack\":\"6\",\"size\":\"6\"},\"deleted\":false,\"originalIndex\":4}]}", 
		EXTRARES, 
		"Url=../groups?type=location", "Referer=", ENDITEM, 
		"Url=../groups", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("2e073a31-ccf4-4519-a499-fb4e6ccdaac6_7", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t18.inf", 
		"Mode=HTML", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":10}],\"customerImages\":[],\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\"},\"deleted\":false,\"originalIndex\":0},{\"id\":\""
		"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"price\":3,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod02\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSProd02\",\"brand\":\"Pbrand2\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\"},\"deleted\":false,\""
		"originalIndex\":1},{\"id\":\"c3dd01e2-c455-424d-870b-d16baeef8cb6\",\"price\":4,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod03\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp03\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":4,\"packSize\":{\"pack\":\"4\",\"size\":\"4\"},\""
		"deleted\":false,\"originalIndex\":2},{\"id\":\"d22b2ef7-94bb-4303-9975-ea08832b976e\",\"price\":5,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod04\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp04\",\"brand\":\"Pbrand4\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":5,\"packSize\":{\"pack\":\"5\""
		",\"size\":\"5\"},\"deleted\":false,\"originalIndex\":3},{\"id\":\"2d784160-909a-41b9-a881-651a48427a20\",\"price\":6,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"afa8d221-ea99-4a7e-ac22-9b5812ab5853\",\"sequence\":0,\"quantity\":0,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod06\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp06\",\"brand\":\"Pbrand6\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":6,\""
		"packSize\":{\"pack\":\"6\",\"size\":\"6\"},\"deleted\":false,\"originalIndex\":4}]}", 
		EXTRARES, 
		"Url=../groups?type=location", "Referer=", ENDITEM, 
		"Url=../groups", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("2e073a31-ccf4-4519-a499-fb4e6ccdaac6_8", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/2e073a31-ccf4-4519-a499-fb4e6ccdaac6", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t19.inf", 
		"Mode=HTML", 
		"Body={\"items\":[{\"id\":\"cec00f98-a43d-423d-a1b6-4632e061e056\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":10}],\"customerImages\":[],\"name\":\"Prod01\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSP01\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":2,\"packSize\":{\"pack\":\"2\",\"size\":\"2\"},\"deleted\":false,\"originalIndex\":0},{\"id\":\""
		"f7cb58d9-1203-43ea-9811-226e23c6789b\",\"price\":3,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod02\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"NSProd02\",\"brand\":\"Pbrand2\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":3,\"packSize\":{\"pack\":\"3\",\"size\":\"3\"},\"deleted\":false,\""
		"originalIndex\":1},{\"id\":\"c3dd01e2-c455-424d-870b-d16baeef8cb6\",\"price\":4,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod03\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp03\",\"brand\":\"Pbrand\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":4,\"packSize\":{\"pack\":\"4\",\"size\":\"4\"},\""
		"deleted\":false,\"originalIndex\":2},{\"id\":\"d22b2ef7-94bb-4303-9975-ea08832b976e\",\"price\":5,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"5a5bee83-8b35-4311-8067-861115a9a0aa\",\"sequence\":0,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod04\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp04\",\"brand\":\"Pbrand4\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":5,\"packSize\":{\"pack\":\"5\""
		",\"size\":\"5\"},\"deleted\":false,\"originalIndex\":3},{\"id\":\"2d784160-909a-41b9-a881-651a48427a20\",\"price\":6,\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"afa8d221-ea99-4a7e-ac22-9b5812ab5853\",\"sequence\":0,\"quantity\":20,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"name\":\"PT_Prod06\",\"supplier\":\"1c6caa9c-2f6d-48b5-9f37-5c0c771cc26c\",\"materialId\":\"Nsp06\",\"brand\":\"Pbrand6\",\"type\":\"nonSysco\",\"description\":null,\"nickName\":\"\",\"averageWeightPerCase\":6,\""
		"packSize\":{\"pack\":\"6\",\"size\":\"6\"},\"deleted\":false,\"originalIndex\":4}]}", 
		EXTRARES, 
		"Url=../groups?type=location", "Referer=", ENDITEM, 
		"Url=../groups", "Referer=", ENDITEM, 
		LAST);

	web_custom_request("logout", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/logout", 
		"Method=POST", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t20.inf", 
		"Mode=HTML", 
		"EncType=", 
		LAST);

	return 0;
}