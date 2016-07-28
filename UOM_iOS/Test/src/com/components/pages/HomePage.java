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
import io.appium.java_client.android.AndroidDriver;
import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;

public class HomePage extends SitePage {

	/* Defining the locators on the Page */
	public static final Target selectAcc = new Target("selectAcc",
			"//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]", Target.XPATH);
	public static final Target HamMenu = new Target("HamburgerMenu",
			"//*[@id='hamburger-nav']//*[@class='mm-o-icon icon-menu']", Target.XPATH);
	public static final Target HamLogout = new Target("HamLogout", "//*[@class='mm-c-menu__logout']", Target.XPATH);

	public HomePage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public HomePage atHomePage() {
		log("Launched Sysco UOM homepage", LogType.STEP);
		return this;

	}

	@SuppressWarnings("rawtypes")
	public HomePage HamburgerMenu(String string) {
		log("Tapping on Hamburger menu", LogType.STEP);

		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(HamMenu);

			if (getCommand().isTargetPresent(HamMenu)) {
				getCommand().click(HamMenu);
				getCommand().waitFor(5);
			}
			log("Navigating to menu page :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Navigating to menu page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public HomePage HamMenu_Logout(String string) {
		log("Tapping on Logout from Hamburger menu", LogType.STEP);

		String finalPath1 = SitePage.drivePath + string + SitePage.string2 + SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(HamLogout);

			if (getCommand().isTargetPresent(HamLogout)) {
				log("Tap on Inventory Tool from Hamburger menu", LogType.STEP);
				getCommand().click(HamLogout);
				log("Logout :Pass", LogType.VERIFICATION_STEP);
			}

		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Logout :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public HomePage ClickAccount(String str1, String string) {
		String finalPath1 = SitePage.drivePath + string + SitePage.string2 + SitePage.pathExtension;

		try {

			if ((str1.equalsIgnoreCase("sqsauser33")) || (str1.equalsIgnoreCase("sqsauser32"))) {

				getCommand().waitFor(10);
				if (getCommand().isTargetPresent(selectAcc)) {
					getCommand().click(selectAcc);

					log("Clicked  account :Pass", LogType.VERIFICATION_STEP);
				}
			}
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Clicked  account :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

}