package com.components.pages;

import com.components.repository.SiteRepository;

import com.iwaf.framework.BasePage;

public class SitePage extends BasePage {
	protected SiteRepository repository;

	SitePage(SiteRepository repository) {
		this.repository = repository;

	}

	public LoginPage _atLoginPage() {
		return this.repository.loginPage();
	}

	public HomePage _atHomePage() {
		return this.repository.homePage();

	}

	public VendorPage _atVendorPage() {
		return this.repository.vendorPage();
	}

	public InventoryToolPage _atInventoryToolPage() {
		return this.repository.inventoryToolPage();
	}

	public LocationsPage _atLocationsPage() {
		return this.repository.locationsPage();
	}

	public SetupInventoryPage _atSetupInventoryPage() {
		return this.repository.setUpInventoryPage();
	}

	public PurchasesPage _atPurchasesPage() {
		return this.repository.purchasesPage();
	}

	public AccountsPage _atAccountsPage() {
		return this.repository.accountsPage();
	}

	public CategoryPage _atCategoryPage() {
		return this.repository.categoryPage();
	}

	public ListPage _atListPage() {
		return this.repository.listPage();
	}
}
