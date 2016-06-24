package com.components.pages;

import java.util.Set;
import org.testng.Assert;
import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;
import io.appium.java_client.android.AndroidDriver;

public class VendorPage extends SitePage {

	public static final Target ADD_Vendor = new Target("ADD_Vendor", "//*[@id='add-nav']/a/i", Target.XPATH);
	public static final Target ADD_VendorPage = new Target("ADD_VendorPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Add Supplier')]", Target.XPATH);

	public static final Target ADD_VendorName = new Target("ADD_VendorName", "//*[@id='name']", Target.XPATH);
	public static final Target ADD_VendorNumber = new Target("ADD_VendorNumber", "//*[@id='phoneNumber']",
			Target.XPATH);
	public static final Target ADD_VendorAddress = new Target("ADD_VendorAddress", "//*[@id='address']", Target.XPATH);
	public static final Target ADD_VendorContactInfo = new Target("ADD_VendorContactInfo", "//*[@id='contactName']",
			Target.XPATH);
	public static final Target ADD_VendorEmail = new Target("ADD_VendorEmail", "//*[@id='emailAddress']", Target.XPATH);
	public static final Target ADD_VendorNote = new Target("ADD_VendorNote", "//*[@id='notes']", Target.XPATH);
	public static final Target DoneWeb = new Target("Done", "//*[@id='done-nav']/a/i", Target.XPATH);
	public static final Target Done = new Target("Done", "//*[@id='done-nav']/a", Target.XPATH);
	public static final Target Back = new Target("Continue", "//*[@id='back-nav']/a/i", Target.XPATH);
	public static final Target Vendor_firstVendorname = new Target("Vendor_firstVendorname",
			"(//*[@id='list-item'])[1]", Target.XPATH);

	public static final Target Edit = new Target("EditVendor", "//*[@id='edit-nav']", Target.XPATH);

	public static String Name;
	public static final Target ADD_VendorDelete = new Target("Back",
			"//*[@id='delete-button' and contains(text(),'Delete Supplier')]", Target.XPATH);
	public static final Target Delete_Yes = new Target("Back",
			"//*[@id='yes-button' and contains(text(),'Yes, Delete')]", Target.XPATH);
	public static final Target Delete_Cancel = new Target("Back",
			"//*[@id='yes-button' and contains(text(),'No, Cancel')]", Target.XPATH);

	public static final Target VendorDetails_name = new Target("VendorDetails_name",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[1]",
			Target.XPATH);
	public static final Target VendorDetails_number = new Target("VendorDetails_number",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[2]",
			Target.XPATH);
	public static final Target VendorDetails_address = new Target("VendorDetails_address",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[3]",
			Target.XPATH);
	public static final Target VendorDetails_contact = new Target("VendorDetails_contact",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[4]",
			Target.XPATH);
	public static final Target VendorDetails_email = new Target("VendorDetails_email",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[5]",
			Target.XPATH);
	public static final Target VendorDetails_note = new Target("VendorDetails_note",
			"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[6]",
			Target.XPATH);
	public static final Target VendorsPage = new Target("VendorsPage",
			"//*[@class='navbar-brand']//*[contains(text(),'Suppliers')]", Target.XPATH);

	public static final Target ADD_VendorNameLabel = new Target("ADD_VendorNameLabel",
			"//*[contains(text(),'SUPPLIER NAME')]", Target.XPATH);
	public static final Target ADD_VendorNumberLabel = new Target("ADD_VendorNumberLabel",
			"//*[contains(text(),'PHONE NUMBER')]", Target.XPATH);
	public static final Target ADD_VendorAddressLabel = new Target("ADD_VendorAddress",
			"//*[contains(text(),'ADDRESS')]", Target.XPATH);
	public static final Target ADD_VendorContactInfoLabel = new Target("ADD_VendorContactInfoLabel",
			"//*[contains(text(),'CONTACT INFORMATION')]", Target.XPATH);
	public static final Target ADD_VendorEmailLabel = new Target("ADD_VendorEmailLabel",
			"//*[contains(text(),'EMAIL ADDRESS')]", Target.XPATH);
	public static final Target ADD_VendorNoteLabel = new Target("ADD_VendorNoteLabel",
			"//*[contains(text(),'NOTE/COMMENTS')]", Target.XPATH);
	public static final Target Cancel = new Target("EditVendor", "//*[contains(text(),'Cancel')]", Target.XPATH);

	public VendorPage(SiteRepository repository) {
		super(repository);
	}

	/* Functions on the Page are defined below */

	public VendorPage atVendorPage() {
		log("Opened Vendor Page ", LogType.STEP);
		return this;
	}

	public VendorPage verifySupplierPage(String string) {
		log("Verify the Supplier Page", LogType.STEP);

		getCommand().waitForTargetPresent(VendorsPage);
		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage Add_Supplier(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Add vendor tap", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(ADD_Vendor);

			if (getCommand().isTargetPresent(ADD_Vendor)) {
				log("Click on ADD Vendor Button", LogType.STEP);
				getCommand().waitFor(5);
				getCommand().clickWithJavascript(ADD_Vendor);

			}
			getCommand().waitForTargetPresent(ADD_VendorPage);

			if (getCommand().isTargetPresent(ADD_VendorPage)) {

				log("In Add Vendor Page", LogType.STEP);
				log("Add vendor button click :Pass", LogType.VERIFICATION_STEP);

			}

		}

		catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Add vendor button click :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage AddSupplier_Details(String name, String number, String address, String contactinfo, String email,
			String note, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Adding vendor details", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(ADD_VendorNameLabel);
			getCommand().waitForTargetPresent(ADD_VendorName);
			getCommand().click(ADD_VendorName);
			if (getCommand().isTargetPresent(ADD_VendorName)) {
				log("Enter vendorname", LogType.STEP);
				getCommand().clear(ADD_VendorName);
				getCommand().sendKeys(ADD_VendorName, name);

			}
			getCommand().waitForTargetPresent(ADD_VendorNumberLabel);
			if (getCommand().isTargetPresent(ADD_VendorNumber)) {
				getCommand().click(ADD_VendorNumber);
				log("Enter vendornumber", LogType.STEP);
				getCommand().clear(ADD_VendorNumber);
				getCommand().sendKeys(ADD_VendorNumber, number);

			}
			getCommand().waitForTargetPresent(ADD_VendorAddressLabel);
			if (getCommand().isTargetPresent(ADD_VendorAddress)) {
				getCommand().click(ADD_VendorAddress);
				log("Enter vendor address", LogType.STEP);
				getCommand().clear(ADD_VendorAddress);
				getCommand().sendKeys(ADD_VendorAddress, address);

			}
			getCommand().waitForTargetPresent(ADD_VendorContactInfoLabel);
			if (getCommand().isTargetPresent(ADD_VendorContactInfo)) {
				getCommand().click(ADD_VendorContactInfo);
				log("Enter vendor contact info", LogType.STEP);
				getCommand().clear(ADD_VendorContactInfo);
				getCommand().sendKeys(ADD_VendorContactInfo, contactinfo);

			}
			getCommand().waitForTargetPresent(ADD_VendorEmailLabel);
			if (getCommand().isTargetPresent(ADD_VendorEmail)) {
				getCommand().click(ADD_VendorEmail);
				log("Enter vendor email", LogType.STEP);
				getCommand().clear(ADD_VendorEmail);
				getCommand().sendKeys(ADD_VendorEmail, email);

			}
			getCommand().waitForTargetPresent(ADD_VendorNoteLabel);
			if (getCommand().isTargetPresent(ADD_VendorNote)) {
				getCommand().click(ADD_VendorNote);
				log("Enter vendor note", LogType.STEP);
				getCommand().clear(ADD_VendorNote);
				getCommand().sendKeys(ADD_VendorNote, note);
				getCommand().waitFor(5);

			}

			log("Vendor details entered  :Pass", LogType.VERIFICATION_STEP);

		} catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Vendor details entered  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;

	}

	@SuppressWarnings("rawtypes")
	public VendorPage TapOnDone(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(Done);
			if (getCommand().isTargetPresent(Done)) {

				getCommand().clickWithJavascript(Done);

				log("Tapped on done:Pass", LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tapped on done :Fail", LogType.VERIFICATION_STEP);

			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage TapOnBack(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(Back);
			if (getCommand().isTargetPresent(Back)) {

				getCommand().clickWithJavascript(Back);

				log("tap on back :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("tap on back :Fail", LogType.VERIFICATION_STEP);

			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage SupplierSelect(String name, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Selecting vendor", LogType.STEP);
		try {

			String vendorName = name;

			getCommand().waitFor(2);

			final Target VD_Vendorname = new Target("VD_Vendorname",
					"//*[@id='list-item']//*[contains(text(),'" + vendorName + "')]", Target.XPATH);

			getCommand().click(VD_Vendorname);

			log("Vendor is selected for item :Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Vendor is selected for item   :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public VendorPage SuppliersList(String vendorname, String string) {
		log("Vendor List", LogType.STEP);

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			String y = vendorname;
			boolean c = getCommand().getDriver().getPageSource().contains(y);

			if (c == true) {

				log("Added  vendor is listed :Pass", LogType.VERIFICATION_STEP);
			} else {
				log("Added  vendor is listed :Fail", LogType.VERIFICATION_STEP);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
			log("Added new vendor is listed   :Fail", LogType.VERIFICATION_STEP);

		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage Supplier_List(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		log("Verifying supplier list page ", LogType.STEP);
		try {

			getCommand().waitForTargetPresent(Vendor_firstVendorname);

			log("Vendor list is displayed :Pass", LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Vendor list is displayed :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public VendorPage ViewSupplierDetails(String name, String number, String address, String contactinfo, String email,
			String note, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			System.out.println("checking vendor details");

			if (getCommand().isTargetPresent(VendorDetails_name)) {

				Name = getCommand().getText(VendorDetails_name);

				if (Name.equals(name)) {

					log("view vendor name :Pass", LogType.VERIFICATION_STEP);
				}
			}

			if (getCommand().isTargetPresent(VendorDetails_number)) {

				String Num = getCommand().getText(VendorDetails_number);
				if (Num.equals(number)) {

					log("view vendor no   :Pass", LogType.VERIFICATION_STEP);
				}
			}

			if (getCommand().isTargetPresent(VendorDetails_address)) {

				String Address = getCommand().getText(VendorDetails_address);
				if (Address.equals(address)) {

					log("view vendor Address   :Pass", LogType.VERIFICATION_STEP);
				}
			}

			if (getCommand().isTargetPresent(VendorDetails_contact)) {

				String Contact = getCommand().getText(VendorDetails_contact);
				if (Contact.equals(contactinfo)) {

					log("view vendor Contact   :Pass", LogType.VERIFICATION_STEP);
				}
			}

			if (getCommand().isTargetPresent(VendorDetails_email)) {

				String Email = getCommand().getText(VendorDetails_email);
				if (Email.equals(email)) {

					log("view vendor Email   :Pass", LogType.VERIFICATION_STEP);
				}
			}

			if (getCommand().isTargetPresent(VendorDetails_note)) {

				String Note = getCommand().getText(VendorDetails_note);
				if (Note.equals(note)) {

					log("view vendor Note  :Pass", LogType.VERIFICATION_STEP);
				}
			}

			log("View vendor details   :Pass", LogType.VERIFICATION_STEP);
			Set<String> contextNames = ((AndroidDriver) getCommand().driver).getContextHandles();

			for (String contextName : contextNames) {
				System.out.println(contextNames);
			}
			System.out.println(((AndroidDriver) getCommand().driver).context((String) contextNames.toArray()[1]));
		} catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);

			log("View vendor detaisl  :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public VendorPage AddedVendorDetails(String vendorname, String number, String address, String contactinfo,
			String email, String note, String string) {
		log("Checking vendor details", LogType.STEP);

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {
			String vendorName = vendorname;
			String vendorPhoneNum = number;
			String vendorAddress = address;
			String vendorContactInfo = contactinfo;
			String vendorEmail = email;
			String vendorNote = note;

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			final Target VD_Vendorname1 = new Target("VD_Vendorname1", vendorName, Target.NAME);
			getCommand().waitForTargetPresent(VD_Vendorname1);

			if (getCommand().isTargetPresent(VD_Vendorname1)) {

				getCommand().waitForTargetPresent(VD_Vendorname1);
				System.out.println("vendor name " + VD_Vendorname1);
				log("vendor name is displayed on Vendor details page :Pass", LogType.VERIFICATION_STEP);

				final Target VD_VendorPhone = new Target("VD_VendorPhone", vendorPhoneNum, Target.NAME);
				getCommand().waitForTargetPresent(VD_VendorPhone);
				System.out.println("vendor phone " + VD_VendorPhone);
				log("vendor phonenumber is displayed on Vendor details page :Pass", LogType.VERIFICATION_STEP);

				final Target VD_VendorAddress = new Target("VD_VendorAddress", vendorAddress, Target.NAME);
				getCommand().waitForTargetPresent(VD_VendorAddress);
				System.out.println("vendor address " + VD_VendorAddress);
				log("vendor address is displayed on Vendor details page :Pass", LogType.VERIFICATION_STEP);

				final Target VD_VendorContactInfo = new Target("VD_VendorContactInfo", vendorContactInfo, Target.NAME);
				getCommand().waitForTargetPresent(VD_VendorContactInfo);
				System.out.println("vendor contact info " + VD_VendorContactInfo);
				log("vendor contact info is displayed on Vendor details page :Pass", LogType.VERIFICATION_STEP);

				final Target VD_VendorEmail = new Target("VD_VendorEmail", vendorEmail, Target.NAME);
				getCommand().waitForTargetPresent(VD_VendorEmail);
				System.out.println("vendor email " + VD_VendorEmail);
				log("vendor email address is displayed on Vendor details page :Pass", LogType.VERIFICATION_STEP);

				final Target VD_VendorNote = new Target("VD_VendorNote", vendorNote, Target.NAME);
				getCommand().waitForTargetPresent(VD_VendorNote);
				System.out.println("vendor note " + VD_VendorNote);
				log("note is displayed on Vendor details page :Pass", LogType.VERIFICATION_STEP);

				Set<String> contextNames = ((AndroidDriver) getCommand().driver).getContextHandles();

				for (String contextName : contextNames) {
					System.out.println(contextNames);
				}
				System.out.println(((AndroidDriver) getCommand().driver).context((String) contextNames.toArray()[1]));

				log("vendor details displayed   :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);

			log("vendor details displayed   :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage DeleteSupplier(String string) {

		log("Delete a vendor", LogType.STEP);

		String string2 = "Issue";

		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;
		try {

			getCommand().waitForTargetPresent(ADD_VendorDelete);
			if (getCommand().isTargetPresent(ADD_VendorDelete)) {

				getCommand().click(ADD_VendorDelete);

			}

			getCommand().waitForTargetPresent(Delete_Yes);
			if (getCommand().isTargetPresent(Delete_Yes)) {

				getCommand().click(Delete_Yes);

			}

			log("Deleting vender :Pass", LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Deleting vender :Fail", LogType.VERIFICATION_STEP);

			Assert.assertTrue(false);

		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage TapOnEdit(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(Edit);
			if (getCommand().isTargetPresent(Edit)) {

				getCommand().click(Edit);

				log("Tap on Edit :Pass", LogType.VERIFICATION_STEP);
			}

		} catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Tap on Edit :Fail", LogType.VERIFICATION_STEP);

			Assert.assertTrue(false);
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public VendorPage VerifyDeletedSupplier(String name, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Selecting vendor", LogType.STEP);
		try {

			String vendorName = name;

			getCommand().waitFor(2);

			final Target VD_Vendorname = new Target("VD_Vendorname",
					"//*[@id='list-item']//*[contains(text(),'" + vendorName + "')]", Target.XPATH);

			Boolean flag = getCommand().isTargetPresent(VD_Vendorname);
			if ((flag)) {
				throw new Exception();
			}

			else
				log("Deleted supplier is not listed on supplier page :Pass", LogType.VERIFICATION_STEP);

		}

		catch (Exception e) {

			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Deleted supplier is not listed on supplier page :Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public VendorPage SupplierCancelledVerify(String name, String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		log("Searching for cancelled supplier", LogType.STEP);
		try {

			String vendorName = name;

			final Target VD_Vendorname = new Target("VD_Vendorname",
					"//*[@id='list-item']//*[contains(text(),'" + vendorName + "')]", Target.XPATH);

			getCommand().waitFor(6);
			if (getCommand().isTargetPresent(VD_Vendorname)) {
				throw new Exception();
			}

			log("Supplier which was cancelleld is not present: Pass", LogType.VERIFICATION_STEP);
		}

		catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			getCommand().captureScreenshot(finalPath1);
			log("Supplier which was cancelleld is not present: Fail", LogType.VERIFICATION_STEP);
			Assert.assertTrue(false);
		}
		return this;

	}

	@SuppressWarnings("rawtypes")
	public VendorPage TapOnCancel(String string) {

		String string2 = "Issue";
		String finalPath1 = GlobalVariable.drivePath + string + string2 + GlobalVariable.pathExtension;

		try {

			getCommand().waitForTargetPresent(Cancel);
			if (getCommand().isTargetPresent(Cancel)) {

				getCommand().click(Cancel);

				log("Tapped on Cancel", LogType.VERIFICATION_STEP);

			}

		} catch (Exception e) {
			((AndroidDriver) getCommand().driver).context("NATIVE_APP");
			log("Tapped on Cancel :Fail", LogType.VERIFICATION_STEP);
			getCommand().captureScreenshot(finalPath1);
			Assert.assertTrue(false);
		}

		return this;
	}

}
