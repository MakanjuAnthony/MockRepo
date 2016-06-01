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

import com.components.pages.CanceledPage;
import com.components.pages.CreateOrderPage;
import com.components.pages.DeliveredPage;
import com.components.pages.HistoricalOrdersPage;
import com.components.pages.HomePage;
import com.components.pages.InventoryPage;
import com.components.pages.ListsPage;
import com.components.pages.LoginPage;
import com.components.pages.MyActiveOrderPage;
import com.components.pages.MyCustomListsPage;
import com.components.pages.OpenOrdersPage;
import com.components.pages.OrderGuide;
import com.components.pages.PendingOrdersPage;
import com.components.pages.ProductCategoriesPage;
import com.components.pages.SearchResultPage;
import com.components.pages.SharedListPage;
import com.components.pages.SubmittedOrdersPage;
import com.components.pages.SubmittedPage;
import com.components.pages.SyscoListsPage;



public class SiteRepository{

	
	public HomePage homePage()
	
	{
		return new HomePage(this);
	}
	
	public SearchResultPage searchResultPage()
	
	{
		return new SearchResultPage(this);
	}
	
	public LoginPage loginPage()
	
	{
		return new LoginPage(this);
	}
	
public CreateOrderPage createOrderPage()
	
	{
		return new CreateOrderPage(this);
	}	
public OrderGuide orderGuide()

{
	return new OrderGuide(this);
}

//-----------------------March 30-------------

public ProductCategoriesPage productCategoriesPage()

{
	return new ProductCategoriesPage(this);
}
public ListsPage listsPage()

{
	return new ListsPage(this);
}

public MyActiveOrderPage myActiveOrderPage()

{
	return new MyActiveOrderPage(this);
}


//-----------------------March 31--------------


public HistoricalOrdersPage historicalOrdersPage()

{
	return new HistoricalOrdersPage(this);
}
public DeliveredPage deliveredPage()

{
	return new DeliveredPage(this);
}

public CanceledPage canceledPage()

{
	return new CanceledPage(this);
}
public SubmittedOrdersPage submittedOrdersPage()

{
	return new SubmittedOrdersPage(this);
}

public SubmittedPage submittedPage()

{
	return new SubmittedPage(this);
}
//--------open

public OpenOrdersPage openOrdersPage()

{
	return new OpenOrdersPage(this);
}
public SyscoListsPage syscoListsPage()
{
	return new SyscoListsPage(this);
}
public SharedListPage sharedListPage()
{
	return new SharedListPage(this);
}

public MyCustomListsPage myCustomListsPage()
{
	return new MyCustomListsPage(this);
}


//------------Apr 12 ----------
public PendingOrdersPage pendingOrdersPage()
{
	return new PendingOrdersPage(this);
}

//May 24

public InventoryPage inventoryPage()
{
	return new InventoryPage(this);
}

}