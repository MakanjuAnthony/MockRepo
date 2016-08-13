package com.components.pages;

import com.components.repository.SiteRepository;
import com.iwaf.framework.BasePage;



public class SitePage extends BasePage
{
	protected SiteRepository repository;
	
	SitePage(SiteRepository repository)
	{
		this.repository=repository;
		
	}

	public LoginPage _atLoginPage() 
	{
		return this.repository.loginPage();
	}
	public HomePage _atHomePage() 
	{
		return this.repository.homePage();
		
	}
	public SearchResultPage _atSearchResultPage() 
	{
		return this.repository.searchResultPage();
	}
	public CreateOrderPage _atCreateOrderPage()
	{
		return this.repository.createOrderPage();
	}
	
	public OrderGuide _atOrderGuide()
	{
		return this.repository.orderGuide();
	}
	
	
	//------------March 30--------
	public ProductCategoriesPage _atProductCategoriesPage ()
	{
		return this.repository.productCategoriesPage();
	}
	public ListsPage _atListsPage ()
	{
		return this.repository.listsPage();
	}
	public MyActiveOrderPage _atMyActiveOrderPage()
	{
		return this.repository.myActiveOrderPage();
	}
	
	
	//------------March 31--------
	public HistoricalOrdersPage _atHistoricalOrdersPage ()
	{
		return this.repository.historicalOrdersPage();
	}
	public DeliveredPage _atDeliveredPage()
	{
		return this.repository.deliveredPage();
	}
	public CanceledPage _atCanceledPage()
	{
		return this.repository.canceledPage();
	}
	public SubmittedPage _atSubmittedPage()
	{
		return this.repository.submittedPage();
	}
	public SubmittedOrdersPage _atSubmittedOrdersPage()
	{
		return this.repository.submittedOrdersPage();
	}
	
//-----------------Open 
	public OpenOrdersPage _atOpenOrdersPage()
	{
		return this.repository.openOrdersPage();
	}
	public SyscoListsPage _atSyscoListsPage()
	{
		return this.repository.syscoListsPage();
	}
	
	public SharedListPage _atSharedListPage()
	{
		return this.repository.sharedListPage();
	}
	
	public MyCustomListsPage _atMyCustomListsPage ()
	{
		return this.repository.myCustomListsPage();
	}
	
	//----------------Apr 12 ---------
	public PendingOrdersPage _atPendingOrdersPage ()
	{
		return this.repository.pendingOrdersPage();
	}
	
	//May 24
	public InventoryPage _atInventoryPage()
	{
		return this.repository.inventoryPage();
	}

	
}
	
	