/**
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 *																																		   	*
 * 2011-2012 Infosys Limited, Banglore, India. All Rights Reserved																			*
 * Version: 2.0																																*
 * 																																			*
 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
 * and will be prosecuted to the maximum extent possible under the law 																		*
 *																																			*
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 **/
package com.components.repository;

import com.components.pages.HomePage;




import com.components.pages.InventoryToolPage;
import com.components.pages.LoginPage;

import com.components.pages.CategoryPage;
import com.components.pages.FoodCostPage;
import com.components.pages.ListPage;
import com.components.pages.PurchasesPage;
import com.components.pages.VendorPage;
import com.components.pages.LocationsPage;
import com.components.pages.SetupInventoryPage;
import com.components.pages.AccountsPage;



public class SiteRepository{

	
	public HomePage homePage()
	
	{
		return new HomePage(this);
	}
	
	
	
	public LoginPage loginPage()
	
	{
		return new LoginPage(this);
	}
	
   public VendorPage vendorPage()
	
	{
		return new VendorPage(this);
	}
   public InventoryToolPage inventoryToolPage()
	
	{
		return new InventoryToolPage(this);
	}

public LocationsPage locationsPage() 
{
	
	return new LocationsPage(this);
}
public SetupInventoryPage setUpInventoryPage() 
{
	
	return new SetupInventoryPage(this);
}
public AccountsPage accountsPage() 
{
	
	return new AccountsPage(this);
}
public PurchasesPage purchasesPage()

{
	return new PurchasesPage(this);
}
public CategoryPage categoryPage()

{
	return new CategoryPage(this);
}
public ListPage listPage()

{
	return new ListPage(this);
}



public FoodCostPage foodCostPage() {
	return new FoodCostPage(this);
}
}