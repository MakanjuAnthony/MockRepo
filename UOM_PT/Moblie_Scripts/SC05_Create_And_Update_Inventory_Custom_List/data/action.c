Action()
{

	web_add_cookie("BNES_homePath=CbhVSMPeZNpfma6mGx2/iIdPDUZaHn8eqBj4bVByY4anr0kV+wQ3EyosLLze8hxvKULDHAjCGyUI+e26omUP2iBvkt+C1wqz; DOMAIN=onlineapi-qa.cloud.sysco.com");

	web_url("user", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/user", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t1.inf", 
		LAST);

	web_custom_request("login", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/login", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTTP", 
		"EncType=application/json", 
		"Body={\"username\":\"PTNormal41\",\"password\":\"Security1\"}", 
		LAST);

	web_url("legacy-lists", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/legacy-lists", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t3.inf", 
		LAST);

	web_custom_request("legacylist", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/inventory/import/legacylist", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTTP", 
		"EncType=application/json", 
		"Body={\"lists\":[{\"id\":\"27128\",\"name\":\"PTNormal41_4/19/2016 11:50:39 AM_List\",\"type\":\"C\",\"owner\":\"PTNormal41\"}],\"groups\":\"default\"}", 
		LAST);

	web_custom_request("expensecategories", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/inventory/setup/expensecategories", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTTP", 
		"EncType=application/json", 
		"Body={\"groups\":\"food/nonfood\"}", 
		LAST);

	web_concurrent_start(NULL);

	web_url("current", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/current?withAllProductAttributes=true", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t6.inf", 
		LAST);

	web_url("groups", 
		"URL=https://onlineapi-qa.cloud.sysco.com/groups?type=location", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t7.inf", 
		LAST);

	web_url("groups_2", 
		"URL=https://onlineapi-qa.cloud.sysco.com/groups", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t8.inf", 
		LAST);

	web_concurrent_end(NULL);

	web_custom_request("8dc1e573-397f-40b8-bd3e-ba22a2c9e609", 
		"URL=https://onlineapi-qa.cloud.sysco.com/inventories/8dc1e573-397f-40b8-bd3e-ba22a2c9e609", 
		"Method=PUT", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t9.inf", 
		"Mode=HTTP", 
		"Body={\"items\":[{\"id\":\"1112606\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":0,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1112606\",\"packSize\":{\"pack\":\"1\",\"size\":\"40 LB\",\"uom\":\"cs\"},\"averageWeightPerCase\":40,\"name\":\"MILKFISH WHOLE\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\""
		"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"PACKER\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1112606\"},\"category\":{\"completeCategoryId\":\"04003099099\",\"mainCategoryId\":4,\"label\":\"MISC.\"},\"messages\":[{\"type\":\"info\",\"message\":\"Demand status\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.393Z\",\"nickName\":null,\""
		"originalIndex\":0},{\"id\":\"1190669\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":1,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1190669\",\"packSize\":{\"pack\":\"16\",\"size\":\".5 PT\",\"uom\":\"cs\"},\"averageWeightPerCase\":12,\"name\":\"MILK WHL\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min"
		"\":0,\"max\":0},\"bvRating\":null,\"brand\":\"PACKER\",\"isCatchWeight\":false,\"storageFlag\":\"C\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":true,\"replacementMaterialId\":\"5069323\"},\"category\":{\"completeCategoryId\":\"02005004002\",\"mainCategoryId\":2,\"label\":\"PORTION PACK\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"},{\"type\":\"warning\",\"message\":\"Leaving Soon. Replacement available\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,"
		"\"lastOrderedDate\":\"2016-05-30T04:37:59.394Z\",\"nickName\":null,\"originalIndex\":1},{\"id\":\"1190677\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":2,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1190677\",\"packSize\":{\"pack\":\"16\",\"size\":\".5 PT\",\"uom\":\"cs\"},\"averageWeightPerCase\":12,\"name\":\"MILK LO FAT 2%\",\"description\":null,\""
		"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"PACKER\",\"isCatchWeight\":false,\"storageFlag\":\"C\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":true,\"replacementMaterialId\":\"5069323\"},\"category\":{\"completeCategoryId\":\"02005004002\",\"mainCategoryId\":2,\"label\":\"PORTION PACK\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"},{\"type\":\"warning\",\"message\":\"Leaving Soon. "
		"Replacement available\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.395Z\",\"nickName\":null,\"originalIndex\":2},{\"id\":\"1190727\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":3,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1190727\",\"packSize\":{\"pack\":\"16\",\"size\":\".5 PT\",\"uom\":\"cs\""
		"},\"averageWeightPerCase\":12,\"name\":\"MILK SKIM\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"PACKER\",\"isCatchWeight\":false,\"storageFlag\":\"C\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1190727\"},\"category\":{\"completeCategoryId\":\"02005004002\",\"mainCategoryId\":2,\"label\":\"PORTION PACK\"},\"messages\":[{\"type\":\"info\",\"message"
		"\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.396Z\",\"nickName\":null,\"originalIndex\":3},{\"id\":\"1190735\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":4,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1190735\",\"packSize\":{\"pack\":\"16\",\"size\":\".5 PT\",\"uom\":\"cs\"},\""
		"averageWeightPerCase\":12,\"name\":\"MILK CHOCOLATE\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"PACKER\",\"isCatchWeight\":false,\"storageFlag\":\"C\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1190735\"},\"category\":{\"completeCategoryId\":\"02005004002\",\"mainCategoryId\":2,\"label\":\"PORTION PACK\"},\"messages\":[{\"type\":\"info\",\""
		"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.396Z\",\"nickName\":null,\"originalIndex\":4},{\"id\":\"1004449\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":5,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1004449\",\"packSize\":{\"pack\":\"12\",\"size\":\"8 CT\",\"uom\":\""
		"cs\"},\"averageWeightPerCase\":12,\"name\":\"DOUGH BISCUIT BUTR FLVR JB\",\"description\":\"Dough Biscuit Butter Flavor Jumbo\",\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"MERICO\",\"isCatchWeight\":false,\"storageFlag\":\"C\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1004449\"},\"category\":{\"completeCategoryId\":\"06001005020\",\"mainCategoryId\":6,\"label\":\"RAW\""
		"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.397Z\",\"nickName\":null,\"originalIndex\":5},{\"id\":\"1006410\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":6,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1006410\",\"packSize\":{\"pack\""
		":\"60\",\"size\":\"2 CT\",\"uom\":\"cs\"},\"averageWeightPerCase\":10.3,\"name\":\"SANDWICH SAUS &BISC PRCK 2.75Z\",\"description\":\"Sandwich Sausage & Biscuit Precooked 2.75 oz\",\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"RUDYS\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1006410\"},\"category\":{\"completeCategoryId\":\""
		"06002045005\",\"mainCategoryId\":6,\"label\":\"BISCUIT\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"./1006410/web/1.jpg\",\"./1006410/web/7.jpg\",\"./1006410/web/6.jpg\",\"./1006410/web/5.jpg\",\"./1006410/web/4.jpg\",\"./1006410/web/3.jpg\",\"./1006410/web/2.jpg\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.398Z\",\"nickName\":null,\"originalIndex\":6},{\"id\":\"1210996\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\""
		"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":7,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1210996\",\"packSize\":{\"pack\":\"12\",\"size\":\"10 CT\",\"uom\":\"cs\"},\"averageWeightPerCase\":9,\"name\":\"DOUGH BISCUIT BTRMLK TX STYLE\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"MERICO\",\""
		"isCatchWeight\":false,\"storageFlag\":\"C\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1210996\"},\"category\":{\"completeCategoryId\":\"06001005020\",\"mainCategoryId\":6,\"label\":\"RAW\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.399Z\",\"nickName\":null,\"originalIndex\":7},{\"id\":\"1290550\",\"priceUom\":\"cs\",\"groups\":["
		"{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":8,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1290550\",\"packSize\":{\"pack\":\"153\",\"size\":\"1.25OZ\",\"uom\":\"cs\"},\"averageWeightPerCase\":12,\"name\":\"HAM SLI FOR BISCUIT 3.5 IN\",\"description\":\"Ham Sliced For Biscuit 3.5\",\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\""
		"bvRating\":null,\"brand\":\"BRYAN\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1290550\"},\"category\":{\"completeCategoryId\":\"03004005001\",\"mainCategoryId\":3,\"label\":\"COOKED HAM\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.399Z\",\"nickName\":null,\"originalIndex\":8},{\"id\""
		":\"1677442\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":9,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1677442\",\"packSize\":{\"pack\":\"100\",\"size\":\"2.5 OZ\",\"uom\":\"cs\"},\"averageWeightPerCase\":15.6,\"name\":\"BISCUIT BTRMLK SLI 3\\\"\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\""
		"max\":0},\"bvRating\":null,\"brand\":\"BRDGFRD\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1677442\"},\"category\":{\"completeCategoryId\":\"06001005010\",\"mainCategoryId\":6,\"label\":\"FULLY BAKED\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.400Z\",\"nickName\":null,\""
		"originalIndex\":9},{\"id\":\"1003953\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":10,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1003953\",\"packSize\":{\"pack\":\"50\",\"size\":\"3.2 OZ\",\"uom\":\"cs\"},\"averageWeightPerCase\":10,\"name\":\"BEEF PATTY CHKN-FRY PRECOOKED\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\""
		":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"QTF\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1003953\"},\"category\":{\"completeCategoryId\":\"03002004003\",\"mainCategoryId\":3,\"label\":\"PATTIES\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":false,\"lastOrderedDate\":\"2016-05-30T04:37:59.401Z\",\""
		"nickName\":null,\"originalIndex\":10},{\"id\":\"1017086\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":11,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1017086\",\"packSize\":{\"pack\":\"96\",\"size\":\"4.5 OZ\",\"uom\":\"cs\"},\"averageWeightPerCase\":27,\"name\":\"CHICKEN 8PC IQF CUT\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\""
		"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"SYS CLS\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1017086\"},\"category\":{\"completeCategoryId\":\"05002001001\",\"mainCategoryId\":5,\"label\":\"RAW IQF BONE-IN\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"syscoBranded\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\""
		"2016-05-30T04:37:59.402Z\",\"nickName\":null,\"originalIndex\":11},{\"id\":\"1017094\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":12,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1017094\",\"packSize\":{\"pack\":\"60\",\"size\":\"8.75OZ\",\"uom\":\"cs\"},\"averageWeightPerCase\":31,\"name\":\"CHICKEN QUARTER IQF\",\"description\":null,\"type\":\"sysco\","
		"\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"SYS CLS\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1017094\"},\"category\":{\"completeCategoryId\":\"05002001001\",\"mainCategoryId\":5,\"label\":\"RAW IQF BONE-IN\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"syscoBranded\"],\"images\":[\"null\"],\"canBuy\":true,"
		"\"lastOrderedDate\":\"2016-05-30T04:37:59.402Z\",\"nickName\":null,\"originalIndex\":12},{\"id\":\"1017102\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":13,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1017102\",\"packSize\":{\"pack\":\"48\",\"size\":\"6.5 OZ\",\"uom\":\"cs\"},\"averageWeightPerCase\":19,\"name\":\"CHICKEN BRST HALF IQF\",\"description\""
		":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"SYS CLS\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1017102\"},\"category\":{\"completeCategoryId\":\"05002001001\",\"mainCategoryId\":5,\"label\":\"RAW IQF BONE-IN\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"syscoBranded\"],\"images\":[\""
		"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.403Z\",\"nickName\":null,\"originalIndex\":13},{\"id\":\"1017144\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":14,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1017144\",\"packSize\":{\"pack\":\"1\",\"size\":\"15 LB\",\"uom\":\"cs\"},\"averageWeightPerCase\":15,\"name\":\"CHICKEN WING IQF "
		"DRUMET 1 JT\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"SYS CLS\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1017144\"},\"category\":{\"completeCategoryId\":\"05002001001\",\"mainCategoryId\":5,\"label\":\"RAW IQF BONE-IN\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\""
		"syscoBranded\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.404Z\",\"nickName\":null,\"originalIndex\":14},{\"id\":\"1204908\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":15,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1204908\",\"packSize\":{\"pack\":\"12\",\"size\":\"4.4OZ\",\"uom\":\"cs\"},\"averageWeightPerCase\":4,"
		"\"name\":\"CANDY BAR SNICKERS\",\"description\":\"Candy Bar Snickers\",\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"MARS\",\"isCatchWeight\":false,\"storageFlag\":\"C\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1204908\"},\"category\":{\"completeCategoryId\":\"07006001003\",\"mainCategoryId\":7,\"label\":\"CANDY BARS\"},\"messages\":[{\"type\":\"info\",\"message\":\""
		"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.404Z\",\"nickName\":null,\"originalIndex\":15},{\"id\":\"1557214\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":16,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"1557214\",\"packSize\":{\"pack\":\"1\",\"size\":\"20 LB\",\"uom\":\"cs\"},\""
		"averageWeightPerCase\":20,\"name\":\"CANDY BAR SNICKER FUNSIZE\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"MARS\",\"isCatchWeight\":false,\"storageFlag\":\"C\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"1557214\"},\"category\":{\"completeCategoryId\":\"07006001003\",\"mainCategoryId\":7,\"label\":\"CANDY BARS\"},\"messages\":[{\"type\":\"info\",\""
		"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.405Z\",\"nickName\":null,\"originalIndex\":16},{\"id\":\"2522191\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":17,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"2522191\",\"packSize\":{\"pack\":\"2\",\"size\":\"100 CT\",\"uom\":"
		"\"cs\"},\"averageWeightPerCase\":10,\"name\":\"CANDY MINT CHANGEMAKER\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"FAZRMNT\",\"isCatchWeight\":false,\"storageFlag\":\"D\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"2522191\"},\"category\":{\"completeCategoryId\":\"07006001001\",\"mainCategoryId\":7,\"label\":\"MINTS\"},\"messages\":[{\"type\":\""
		"info\",\"message\":\"Remote stock / Drop ship\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.406Z\",\"nickName\":null,\"originalIndex\":17},{\"id\":\"3505187\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":18,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"3505187\",\"packSize\":{\"pack\":\"240\",\""
		"size\":\"1.5 OZ\",\"uom\":\"cs\"},\"averageWeightPerCase\":22.5,\"name\":\"DOUGH COOKIE CANDY CHOC CHIP\",\"description\":null,\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"MRSRICH\",\"isCatchWeight\":false,\"storageFlag\":\"F\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"3505187\"},\"category\":{\"completeCategoryId\":\"06001040020\",\"mainCategoryId\":6,\"label\":\"RAW "
		"DGH-PIECES\"},\"messages\":[{\"type\":\"info\",\"message\":\"Stocked item\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.407Z\",\"nickName\":null,\"originalIndex\":18},{\"id\":\"3872645\",\"priceUom\":\"cs\",\"groups\":[{\"groupId\":\"d94ad58d-b762-481c-b0a7-3c4d3738b380\"},{\"groupId\":\"edca4da3-00e4-48cd-9214-292ddb483eca\",\"sequence\":19,\"quantity\":10,\"quantityUom\":\"cs\"}],\"customerImages\":[],\"materialId\":\"3872645\",\""
		"packSize\":{\"pack\":\"1\",\"size\":\"11 LB\",\"uom\":\"cs\"},\"averageWeightPerCase\":11,\"name\":\"CANDY GINGER CHEWS\",\"description\":\"Candy Ginger Chews\",\"type\":\"sysco\",\"isSoldAs\":{\"case\":true,\"split\":false},\"split\":{\"min\":0,\"max\":0},\"bvRating\":null,\"brand\":\"GINGERP\",\"isCatchWeight\":false,\"storageFlag\":\"D\",\"isAvailable\":true,\"replacement\":{\"hasReplacement\":false,\"replacementMaterialId\":\"3872645\"},\"category\":{\"completeCategoryId\":\"07044030002\",\""
		"mainCategoryId\":7,\"label\":\"CANDY\"},\"messages\":[{\"type\":\"info\",\"message\":\"Remote stock / Drop ship\"}],\"flags\":[\"null\"],\"images\":[\"null\"],\"canBuy\":true,\"lastOrderedDate\":\"2016-05-30T04:37:59.407Z\",\"nickName\":null,\"originalIndex\":19}]}", 
		LAST);

	web_concurrent_start(NULL);

	web_url("groups_3", 
		"URL=https://onlineapi-qa.cloud.sysco.com/groups?type=location", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t10.inf", 
		LAST);

	web_url("groups_4", 
		"URL=https://onlineapi-qa.cloud.sysco.com/groups", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t11.inf", 
		LAST);

	web_url("groups_5", 
		"URL=https://onlineapi-qa.cloud.sysco.com/groups?type=location", 
		"Resource=1", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t12.inf", 
		LAST);

	web_concurrent_end(NULL);

	web_custom_request("logout", 
		"URL=https://onlineapi-qa.cloud.sysco.com/app/logout", 
		"Method=POST", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t13.inf", 
		"Mode=HTTP", 
		"EncType=", 
		LAST);

	return 0;
}