package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationexercise.base.BaseClass;
import automationexercise.dataprovider.DataProviders;
import automationexercise.pageobjects.ContactusPage;
import automationexercise.pageobjects.HomePage;
import automationexercise.pageobjects.TestCasePage;
import automationexercise.utility.Log;

public class ContactusPageTest extends BaseClass {
	HomePage homePage;
	ContactusPage contactusPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(dataProvider = "contactusform", dataProviderClass = DataProviders.class)
	public void contactusPageFormTest(String name, String email, String sub, String msg) {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		contactusPage = homePage.clickContactus();
		Log.info("Verify verifygetInTouch is visible");
		Assert.assertTrue(contactusPage.verifygetInTouch());
		Log.info("verifygetInTouch is visible");
		homePage = contactusPage.enterContactusForm(name, email, sub, msg);
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
	}

	
}
