
package com.components.pages;

import java.util.Set;

import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;
import io.appium.java_client.android.AndroidDriver;

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

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public LoginPage verifyLoginPage(String string) {

		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {
			getCommand().waitFor(5);
			log("Verify the Login Page", LogType.STEP);
			Set<String> contextNames1 = ((AndroidDriver) getCommand().driver).getContextHandles();

			for (String contextName : contextNames1) {
				System.out.println(contextNames1);
			}
			((AndroidDriver) getCommand().driver).context((String) contextNames1.toArray()[1]);
			System.out.println(((AndroidDriver) getCommand().driver).context((String) contextNames1.toArray()[1]));
			getCommand().waitFor(2);
			getCommand().waitForTargetPresent(HomUserName);
			getCommand().waitForTargetPresent(HomPwd);
			getCommand().waitForTargetPresent(HomLogin);

			log("Login page verification :Pass", LogType.STEP);
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Login page verification :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LoginPage signIn(String UserName, String Password, String string) {
		log("Sign In", LogType.STEP);

		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {

			getCommand().waitForTargetPresent(HomUserName);

			getCommand().click(HomUserName);
			getCommand().clear(HomUserName);
			getCommand().sendKeys(HomUserName, UserName);

			getCommand().waitForTargetPresent(HomPwd);
			getCommand().click(HomPwd);
			getCommand().sendKeys(HomPwd, Password);

			getCommand().waitForTargetPresent(HomLogin).clickWithJavascript(HomLogin);

			getCommand().waitForTargetPresent(InvToolsPage);

			if (getCommand().isTargetPresent(InvToolsPage)) {

				log("Sign in :Pass", LogType.STEP);
			}

			log("Sign in :Pass", LogType.STEP);

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Sign in :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

	@SuppressWarnings("rawtypes")
	public LoginPage saveUsernameCheckBoxClick(String string) {

		String string2 = "Issue";
		String finalPath1 = SitePage.drivePath + string + string2 + SitePage.pathExtension;

		try {
			getCommand().waitForTargetPresent(SaveUserName);
			getCommand().clickWithJavascript(SaveUserName);
			getCommand().waitForTargetPresent(HomUserName).clear(HomUserName);

			log("Login page verification :Pass", LogType.STEP);
		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Login page verification :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;
	}

}
