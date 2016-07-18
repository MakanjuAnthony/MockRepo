		/**
		 ********************************************************************************************************************************************
		 ********************************************************************************************************************************************
		 *																																		   	*
		 * 2016-2017 Infosys Limited, Banglore, India. All Rights Reserved																			*

		 * Version: 1.0																																*
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

package com.components.pages;

import com.components.repository.SiteRepository;

import com.iwaf.framework.BasePage;

public class SitePage extends BasePage {
	
	public static String drivePath = "/Users/jinita_jose/Desktop/ScreenShots_Android/WF/";
	public static String pathExtension = ".png";

	public static String string1 = "Success";
	public static String string2 = "Issue";
	
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
