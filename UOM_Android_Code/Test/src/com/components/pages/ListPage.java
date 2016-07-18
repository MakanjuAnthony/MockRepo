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

import org.testng.Assert;
import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

import io.appium.java_client.android.AndroidDriver;

public class ListPage extends SitePage {

	public static final Target SetUp_Pg1Title = new Target("SetUp_Pg1Title",
			"//*[@class='mm-c-inventory-setup']//*[contains(text(),'Import Items')]", Target.XPATH);
	public static final Target CustomList = new Target("CustomList",
			"//*[@type='button' and contains(text(),'Custom List')]", Target.XPATH);

	public static final Target Continue = new Target("Continue",
			"//*[@class='btn btn-default' and contains(text(),'Continue')]", Target.XPATH);
	public static final Target Category_Header = new Target("Category_Header",
			"//*[@id='mount']/div/div/div[2]/nav/div/div/span/h3", Target.XPATH);
	public static final Target Next = new Target("Next", "//*[@id='next-nav']/a", Target.XPATH);

	public ListPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public ListPage atListPage() {
		log("Opened List Page ", LogType.STEP);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public ListPage TapCustomList(String string) {

		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		log("Selecting custom list  ", LogType.STEP);

		try {
			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(SetUp_Pg1Title);
			getCommand().waitForTargetPresent(CustomList);
			getCommand().clickWithJavascript(CustomList);

			log("Selected  custom list  from SetupInventoryImportItems:Pass", LogType.VERIFICATION_STEP);

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Selected  custom list  from SetupInventoryImportItems :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public ListPage tapContinue(String string) {

		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;
		try {

			getCommand().waitForTargetPresent(Continue);
			getCommand().clickWithJavascript(Continue);

			log("Tapped on Continue :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on Continue :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public ListPage SelectListwithItems(String name, String string) {

		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		log("Selecting list", LogType.STEP);
		try {
			String listName = name;

			getCommand().waitFor(2);
			final Target Listname = new Target("Listname",
					"//*[@class='mm-c-simplelist__item list-group-item']//*[contains(text(),'" + listName
							+ "')]/ancestor::button[@class='mm-c-simplelist__item list-group-item']/child::i[@class='mm-o-icon icon-uncheck-circle']",
					Target.XPATH);

			getCommand().click(Listname);

			log("List is selected :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("List is selected   :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public ListPage TapOnNext(String string) {
		String string2 = "Issue";

		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(Next);
			if (getCommand().isTargetPresent(Next)) {

				getCommand().click(Next);
				log("Tapped on Next : Pass", LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on Next :Fail", LogType.VERIFICATION_STEP);

			Assert.assertTrue(false);
		}

		return this;
	}
}
