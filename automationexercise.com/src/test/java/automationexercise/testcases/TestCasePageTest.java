package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationexercise.base.BaseClass;
import automationexercise.pageobjects.HomePage;
import automationexercise.pageobjects.TestCasePage;
import automationexercise.utility.Log;

public class TestCasePageTest extends BaseClass {
	HomePage homePage;
	TestCasePage testCasePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	
	@Test
	public void verifyTestCasePage() {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		testCasePage = homePage.clickTestcase();
		Assert.assertEquals(testCasePage.getTestCasePageUrl(), "https://www.automationexercise.com/test_cases");
	}
}
