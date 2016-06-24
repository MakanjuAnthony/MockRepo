package com.components.pages;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;
import com.components.pages.HomePage;

public class AccountsPage extends SitePage {

	public static final Target Menu_Account = new Target("Menu_Accounts", "//*[@id='accounts']", Target.XPATH);
	public static final Target Accounts_Page = new Target("Accounts_Page",
			"//*[@class='navbar-brand']//*[contains(text(),'Accounts')]", Target.XPATH);
	public static final Target Accounts_1Account = new Target("Accounts_1Account", "//*[@id='list-item'][1]",
			Target.XPATH);
	public static final Target Accounts_2Account = new Target("Accounts_2Account", "//*[@id='list-item'][2]",
			Target.XPATH);
	public static final Target Accounts_3Account = new Target("Accounts_3Account", "//*[@id='list-item'][3]",
			Target.XPATH);
	public static final Target Accounts_4Account = new Target("Accounts_4Account", "//*[@id='list-item'][4]",
			Target.XPATH);
	public static final Target Accounts_5Account = new Target("Accounts_5Account", "//*[@id='list-item'][5]",
			Target.XPATH);
	public static final Target Accounts_6Account = new Target("Accounts_6Account", "//*[@id='list-item'][6]",
			Target.XPATH);
	public static final Target InventoryToolsPage_Accountinfo = new Target("InventoryToolsPage_Accountinfo",
			"//*[@id='mount']/div/div/div[2]/nav/div/div/span/h4/a", Target.XPATH);
	public static final Target HamburgerMenu = new Target("HamburgerMenu", "//*[@id='hamburger-nav']", Target.XPATH);
	public static final Target InvToolsPage = new Target("InvToolsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Inventory Tools')]", Target.XPATH);
	public static final Target selectAcc = new Target("selectAcc",
			"//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]", Target.XPATH);
	public static final Target account_None = new Target("account_None",
			"//*[@class='navbar-brand']//*[contains(text(),'Please select an account')]", Target.XPATH);

	public String T_AccountInfo;
	public String F_AccountInfo;
	public String FfAccountInfo;
	public String SxAccountInfo;
	public String SecondAccountInfo;
	public String FirstAccountInfo;

	public String firstAccount;
	public String secondAccount;

	HomePage homepage = new HomePage(repository);

	public AccountsPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public AccountsPage atAccountsPage() {
		log("Opened Accounts Page ", LogType.STEP);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public AccountsPage HamMenu_Accounts(String string) {
		log("Tapping on Accounts from Hamburger menu", LogType.STEP);

		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(Menu_Account);
			getCommand().click(Menu_Account);
			getCommand().waitForTargetPresent(Accounts_Page);

			log("Account page displayed :Pass", LogType.STEP);

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Account page displayed :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public AccountsPage AccountSwitchFirstID(String str1, String string) {
		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;

		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {

				if (getCommand().isTargetPresent(Accounts_1Account)) {

					getCommand().click(Accounts_1Account);
					getCommand().waitForTargetPresent(InvToolsPage);

					getCommand().waitFor(5);
					if (getCommand().isTargetPresent(account_None)) {

						log("Account switch  :Fail", LogType.VERIFICATION_STEP);
						Assert.assertTrue(false);
					} else {
						FirstAccountInfo = getCommand().getText(InventoryToolsPage_Accountinfo);

						log("First Account switched for user :Pass", LogType.VERIFICATION_STEP);
					}
				}
			}
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("First Account switched for user :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage AccountSwitchSecondID(String str1, String string) {

		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;

		try {

			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {
				if (getCommand().isTargetPresent(Accounts_2Account)) {

					getCommand().click(Accounts_2Account);
					getCommand().waitForTargetPresent(InvToolsPage);
					getCommand().waitFor(5);
					if (getCommand().isTargetPresent(account_None)) {

						log("Account switch for user :Fail", LogType.VERIFICATION_STEP);
						Assert.assertTrue(false);
					} else {
						SecondAccountInfo = getCommand().getText(InventoryToolsPage_Accountinfo);

						if (FirstAccountInfo != SecondAccountInfo) {
							log("Account switched for user :Pass", LogType.VERIFICATION_STEP);
						}

						else {
							Assert.assertTrue(false);
						}

					}
				}

				else
					log("No accounts available to switch :Pass", LogType.VERIFICATION_STEP);

			}
		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Account switched for user :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage Third_AccountSelection(String str1, String string) {
		log("Selecting 3 account from Accounts page", LogType.STEP);
		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {

				getCommand().waitForTargetPresent(Accounts_3Account, 10).click(Accounts_3Account);
				if (getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					T_AccountInfo = getCommand().getText(InventoryToolsPage_Accountinfo);

				}
				log("Got 3 account information :Pass", LogType.VERIFICATION_STEP);
			}
		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Got 3 account information :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage Fourth_AccountSelection(String str1, String string) {
		log("Selecting 4 account from Accounts page", LogType.STEP);
		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {

				getCommand().waitForTargetPresent(Accounts_4Account);
				getCommand().click(Accounts_4Account);
				getCommand().waitFor(5);

				if (getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					F_AccountInfo = getCommand().getText(InventoryToolsPage_Accountinfo);

				}

				log("Got 4 account information :Pass", LogType.VERIFICATION_STEP);
			}
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Got 4 account information :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage Fifth_AccountSelection(String str1, String string) {
		log("Selecting 5 account from Accounts page", LogType.STEP);
		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {

				getCommand().waitForTargetPresent(Accounts_5Account);
				getCommand().click(Accounts_5Account);
				getCommand().waitFor(5);

				if (getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					FfAccountInfo = getCommand().getText(InventoryToolsPage_Accountinfo);

				}
				log("Got 5 account information :Pass", LogType.VERIFICATION_STEP);
			}
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Got 5 account information :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage Sixth_AccountSelection(String str1, String string) {
		log("Selecting 6 account from Accounts page", LogType.STEP);

		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;
		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {

				getCommand().waitForTargetPresent(Accounts_6Account);
				getCommand().click(Accounts_6Account);
				getCommand().waitFor(5);
				if (getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					SxAccountInfo = getCommand().getText(InventoryToolsPage_Accountinfo);

				}

				log("Got 6 account information :Pass", LogType.VERIFICATION_STEP);
			}
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Got 6 account information :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage ClickAccount(String string) {
		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;

		try {

			if (getCommand().isTargetPresent(selectAcc)) {
				getCommand().click(selectAcc);
				log("Clicked select account :Pass", LogType.VERIFICATION_STEP);
			}
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Clicked select account :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage First_AccountSelection(String str1, String string) {
		log("Selecting 1st account from Accounts page", LogType.STEP);

		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;

		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {
				getCommand().waitForTargetPresent(Accounts_1Account, 10).click(Accounts_1Account);
				if (getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					T_AccountInfo = getCommand().getText(InventoryToolsPage_Accountinfo);

				}

				log("Got 1st account information :Pass", LogType.VERIFICATION_STEP);
			}
		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Got 1st account information :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public AccountsPage Second_AccountSelection(String str1, String string) {
		log("Selecting 1st account from Accounts page", LogType.STEP);
		String finalPath1 = GlobalVariable.drivePath + string + GlobalVariable.string2 + GlobalVariable.pathExtension;

		try {
			if ((str1.equalsIgnoreCase("uomsa001")) || (str1.equalsIgnoreCase("uomsa002"))) {

				getCommand().waitForTargetPresent(Accounts_2Account, 10).click(Accounts_2Account);
				if (getCommand().isTargetPresentAfterWait(InventoryToolsPage_Accountinfo, 20)) {
					T_AccountInfo = getCommand().getText(InventoryToolsPage_Accountinfo);

				}
				log("Got 2nd account information :Pass", LogType.VERIFICATION_STEP);
			}
		} catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Got 2nd account information :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);

		}

		return this;

	}
}
