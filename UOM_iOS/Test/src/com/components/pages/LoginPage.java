		
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

import java.util.Set;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;
import io.appium.java_client.ios.IOSDriver;

public class LoginPage extends SitePage {

	/* Defining the locators on the Page */

	public static final Target InvToolsPage = new Target("InvToolsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Inventory Tools')]", Target.XPATH);

	public static final Target HomUserName = new Target("HomUserName", "//*[@id='username-input']", Target.XPATH);
	public static final Target HomPwd = new Target(" HomPwd", "//*[@id='password-input']", Target.XPATH);
	public static final Target HomLogin = new Target("HomLogin", "//*[@id='login-button']", Target.XPATH);

	public static final Target SaveUserName = new Target("SaveUserName", "//*[@id='save-username-input']",
			Target.XPATH);

	HomePage homepage = new HomePage(repository);

	public LoginPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public LoginPage atLoginPage() {
		log("Launched Sysco UOM", LogType.STEP);

		return this;
	}

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public LoginPage verifyLoginPage(String string) {

		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;
		try {

			Set<String> contextNames1 = ((IOSDriver) getCommand().driver).getContextHandles();
			System.out.println("contxtname is " + contextNames1);

			for (String contextName : contextNames1) {
				System.out.println("inside loop " + contextNames1);
			}
			System.out.println(((IOSDriver) getCommand().driver).context((String) contextNames1.toArray()[1]));

			getCommand().waitFor(5);
			getCommand().waitForTargetPresent(HomUserName);
			getCommand().waitForTargetPresent(HomPwd);
			getCommand().waitForTargetPresent(HomLogin);

			log("Login page verification :Pass", LogType.STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Login page verification :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LoginPage signIn(String UserName, String Password, String string) {
		log("Sign In", LogType.STEP);

		String string1 = "Details";
		String string3 = "issue";
		String finalPath = GlobalVariable.drivePath + string + string1 + GlobalVariable.pathExtension;
		String finalPath2 = GlobalVariable.drivePath + string + string3 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(HomUserName);

			getCommand().click(HomUserName);
			getCommand().clear(HomUserName);
			getCommand().sendKeys(HomUserName, UserName);

			getCommand().waitForTargetPresent(HomPwd);
			getCommand().click(HomPwd);
			getCommand().sendKeys(HomPwd, Password);

			getCommand().captureScreenshot(finalPath);
			if (getCommand().isTargetPresent(HomLogin)) {
				getCommand().click(HomLogin);
			}

			getCommand().waitFor(20);
			getCommand().waitForTargetPresent(InvToolsPage);

			if (getCommand().isTargetPresent(InvToolsPage)) {
				log("Sign in :Pass", LogType.STEP);

			}

		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath2);
			log("Sign in :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LoginPage saveUsernameCheckBoxClick(String string) {
		String string2 = "issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			getCommand().waitForTargetPresent(SaveUserName);
			getCommand().click(SaveUserName);

			log("Save username verification :Pass", LogType.STEP);
		} catch (Exception e) {
			((IOSDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Save username verification :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

}
