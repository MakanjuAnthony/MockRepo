		
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

import io.appium.java_client.ios.IOSDriver;



import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class PurchasesPage extends SitePage {

	public static final Target Purchases_Add = new Target("InvToolsPage",
			"//*[@id='add-nav']/a/i", Target.XPATH);
	public static final Target Purchases_Back = new Target("InvToolsPage",
			"//*[@id='back-nav']", Target.XPATH);
	public static final Target PurchasesDetails_Done = new Target(
			"InvToolsPage", "//*[@id='done-nav']", Target.XPATH);
	public static final Target PurchasesDetails_Supplier = new Target(
			"InvToolsPage", "//*[@id='supplier']", Target.XPATH);
	public static final Target PurchasesPage = new Target("InvToolsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Purchases')]",
			Target.XPATH);

	HomePage homepage = new HomePage(repository);

	public PurchasesPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public PurchasesPage atPurchasesPage() {
		log("In Purchases page", LogType.STEP);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public PurchasesPage AddPurchases(String string) {

		String string2 = "Issue";

			String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(PurchasesPage);

			if (getCommand().isTargetPresent(PurchasesPage)) {
				getCommand().click(Purchases_Add);
				getCommand().waitForTargetPresent(PurchasesDetails_Done);

				log("Tapped  Add purchases :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped  Add purchases :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
	@SuppressWarnings("rawtypes")
	public PurchasesPage SupplierSelect(String string) {

		log("Creating purchases  ", LogType.STEP);
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2
				+ SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(PurchasesDetails_Supplier);

			if (getCommand().isTargetPresent(PurchasesDetails_Supplier)) {
				getCommand().selectDropDown(PurchasesDetails_Supplier, 1);

				log("Selected  vendor:Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected  vendor:Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

}
