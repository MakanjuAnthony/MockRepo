package com.tests;

import org.omg.CORBA._PolicyStub;


import org.testng.annotations.Test;

import com.components.entities.Start;
import com.components.yaml.SearchData;
import com.iwaf.framework.Initiator;
import com.components.yaml.LoginData;

public class May27TestSuite4 extends Initiator{
	
	
	@Test(groups={"Test_Script"}, description = "Submit order from category in home page",priority=28)
	public void SubmitOrder_Categories_Home() throws InterruptedException {
	
	LoginData loginDataNU =LoginData.fetch("LoginData");
	
	Start.asTester
	.goToLoginPage()
	.verifyLoginPage()
	.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
	._atHomePage()
	.home_Category()
	.subcategory_Select("SubmitOrder_Categories_Home1")
	._atProductCategoriesPage()
	.plus_Click()
	.create_Click()
	.cart_Click()
	._atMyActiveOrderPage()
	.myActiveOrder_SubmitOrder("SubmitOrder_Categories_Home")
	._atMyActiveOrderPage()
	.myActiveOrder_alertClose()
	;
	}

	/*
	@Test(groups={"Test_Script"}, description = "Submit order from Brand in home page",priority=29)
	public void SubmitOrder_Brand_Home() throws InterruptedException {
	
	LoginData loginDataNU =LoginData.fetch("LoginData");
	
	Start.asTester
	.goToLoginPage()
	.verifyLoginPage()
	.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
	._atHomePage()
	.home_Brand()
	.brand_Select("SubmitOrder_Brand_Home1")
	._atProductCategoriesPage()
	.second_Plus_Click()
	.create_Click()
	.cart_Click()
	._atMyActiveOrderPage()
	.myActiveOrder_SubmitOrder("SubmitOrder_Brand_Home")
	._atMyActiveOrderPage()
	.myActiveOrder_alertClose()
	;
	}
	
	
	@Test(groups={"Test_Script"}, description = "Submit order from Nutrition in home page",priority=30)
	public void SubmitOrder_Nutrition_Home() throws InterruptedException {
	
	LoginData loginDataNU =LoginData.fetch("LoginData");
	
	Start.asTester
	.goToLoginPage()
	.verifyLoginPage()
	.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
	._atHomePage()
	.home_Nutrition()
	.nutrition_Select("SubmitOrder_Nutrition_Home1")
	._atProductCategoriesPage()
	.plus_Click()
	.create_Click()
	.cart_Click()
	._atMyActiveOrderPage()
	.myActiveOrder_SubmitOrder("SubmitOrder_Nutrition_Home")
	._atMyActiveOrderPage()
	.myActiveOrder_alertClose()
	;
	}
	
	@Test(groups={"Test_Script"}, description = "Submit order from Size in home page",priority=31)
	public void SubmitOrder_Size_Home() throws InterruptedException {
	
	LoginData loginDataNU =LoginData.fetch("LoginData");
	
	Start.asTester
	.goToLoginPage()
	.verifyLoginPage()
	.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
	._atHomePage()
	.home_Size()
	.size_Select("SubmitOrder_Size_Home1")
	._atProductCategoriesPage()
	.second_Plus_Click()
	.create_Click()
	.cart_Click()
	._atMyActiveOrderPage()
	.myActiveOrder_SubmitOrder("SubmitOrder_Size_Home")
	._atMyActiveOrderPage()
	.myActiveOrder_alertClose()
	;
	}
	
	*/
	@Test(groups={"Test_Script"}, description = "Submit order from category via search in home page",priority=32)
	public void SubmitOrder_Categories_Search_Home() throws InterruptedException {
	
	LoginData loginDataNU =LoginData.fetch("LoginData");
	SearchData searchData = SearchData.fetch("SearchData");
	
	Start.asTester
	.goToLoginPage()
	.verifyLoginPage()
	.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
	._atHomePage()
	.home_Category()
	.search_Select(searchData.keyword)
	.category_Search_Select("SubmitOrder_Categories_Search_Home1")
	._atProductCategoriesPage()
	.plus_Click()
	.create_Click()
	.cart_Click()
	._atMyActiveOrderPage()
	.myActiveOrder_SubmitOrder("SubmitOrder_Categories_Search_Home")
	._atMyActiveOrderPage()
	.myActiveOrder_alertClose()
	;
	}
	


	@Test(groups={"Test_Script"}, description = "Submit order from brand via search in home page",priority=33)
	public void SubmitOrder_Brand_Search_Home() throws InterruptedException {
	
	LoginData loginDataNU =LoginData.fetch("LoginData");
	SearchData searchData = SearchData.fetch("SearchData");
	
	Start.asTester
	.goToLoginPage()
	.verifyLoginPage()
	.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
	._atHomePage()
	.home_Brand()
	.search_Select_Brand(searchData.brand)
	.brand_Search_Select("SubmitOrder_Brand_Search_Home1")
	._atProductCategoriesPage()
	.second_Plus_Click()
	.create_Click()
	.cart_Click()
	._atMyActiveOrderPage()
	.myActiveOrder_SubmitOrder("SubmitOrder_Brand_Search_Home")
	._atMyActiveOrderPage()
	.myActiveOrder_alertClose()
	;
	}
	
/*
	@Test(groups={"Test_Script"}, description = "Submit order from size via search in home page",priority=34)
	public void SubmitOrder_Size_Search_Home() throws InterruptedException {
	
	LoginData loginDataNU =LoginData.fetch("LoginData");
	SearchData searchData = SearchData.fetch("SearchData");
	
	Start.asTester
	.goToLoginPage()
	.verifyLoginPage()
	.loginToApplication(loginDataNU.UserName, loginDataNU.Password)
	._atHomePage()
	.home_Size()
	.search_Select_Size(searchData.size)
	.size_Search_Select("SubmitOrder_Size_Search_Home1")
	._atProductCategoriesPage()
	.second_Plus_Click()
	.create_Click() 
	.cart_Click()
	._atMyActiveOrderPage()
	.myActiveOrder_SubmitOrder("SubmitOrder_Size_Search_Home")
	._atMyActiveOrderPage()
	.myActiveOrder_alertClose()
	;
	}
*/
}
