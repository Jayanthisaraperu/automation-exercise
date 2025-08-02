package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationexercise.base.BaseClass;
import automationexercise.dataprovider.DataProviders;
import automationexercise.pageobjects.AccountCreatedPage;
import automationexercise.pageobjects.AccountDeletedPage;
import automationexercise.pageobjects.EnterAccountInformationPage;
import automationexercise.pageobjects.HomePage;
import automationexercise.pageobjects.SignupPage;
import automationexercise.utility.Log;

public class HomePageTest extends BaseClass {

	HomePage homePage;
	SignupPage signupPage;
	EnterAccountInformationPage enterAccountInformationPage;
	AccountCreatedPage accountCreatedPage;
	AccountDeletedPage accountDeletedPage;

	@BeforeMethod
	public void setUp( String browser) {
		launchApp(browser);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test(dataProvider = "signUpPageCredentials", dataProviderClass = DataProviders.class)
	public void registerUserTest(String name, String email, String pass, String fname, String lname, String add,
			String coun, String state, String city, String zcode, String mob) throws Throwable {
		Log.startTestCase("registerUserTest");
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		signupPage = homePage.registerUser();
		Log.info("Verify NewUserSignup is vissible ");
		Assert.assertTrue(signupPage.verifyNewUserSignup());
		Log.info("NewUserSignup is vissible ");
		enterAccountInformationPage = signupPage.enterSignupCredentials(name, email);
		Log.info("Verify EnterAccountInformation is vissible ");
		Assert.assertTrue(enterAccountInformationPage.verifyEnterAccountInformation());
		Log.info("EnterAccountInformation is vissible ");
		accountCreatedPage = enterAccountInformationPage.enterRegistrationDetails(pass, fname, lname, add, coun, state,
				city, zcode, mob);
		Log.info("Verify AccountCreated is vissible ");
		Assert.assertTrue(accountCreatedPage.verifyAccountCreated());
		Log.info("AccountCreated is vissible ");
		homePage = accountCreatedPage.clickContinue();
		String actual = homePage.getLoggedAs();
		System.out.println(actual);
		Log.info("Verify Logged in as username is vissible ");
		Assert.assertEquals(actual, "Logged in as "+ name, "Incorrect User");
		Log.info("Logged in as username is vissible ");
		accountDeletedPage = homePage.deleteAccount();
		Log.info("Verify AccountDeleted is vissible ");
		Assert.assertTrue(accountDeletedPage.verifyAccountDeleted());
		Log.info("AccountDeleted is vissible ");
		accountDeletedPage.clickAccountDeleteContinue();
		Log.endTestCase("registerUserTest");
//		Thread.sleep(2000);
	}

	@Test(dataProvider = "loginDetails", dataProviderClass = DataProviders.class)
	public void loginUserWithCorrectEmailAndPassword(String email, String pass)throws Throwable {
		Log.startTestCase("loginUserWithCorrectEmailAndPassword");
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		signupPage = homePage.registerUser();
		Log.info("Verify Login to your account is vissible");
		Assert.assertTrue(signupPage.logIntoYourAccountDisplayed());
		Log.info("Login to your account is vissible");
		homePage =  signupPage.enterCorrectEmailAndPassword(email, pass);
		String actual = homePage.getLoggedAs();
		System.out.println(actual);
		Log.info("Verify Logged in as username is vissible ");
		Assert.assertEquals(actual, "Logged in as Tester", "Incorrect User");
		Log.info("Logged in as username is vissible ");
		Log.endTestCase("loginUserWithCorrectEmailAndPassword");

	}
	
	@Test(dataProvider = "logincredentials", dataProviderClass = DataProviders.class)
	public void loginUserWithInCorrectEmailAndPassword(String email, String pass) throws Throwable{
		Log.startTestCase("loginUserWithInCorrectEmailAndPassword");

		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		signupPage = homePage.registerUser();
		Log.info("Verify Login to your account is vissible");
		Assert.assertTrue(signupPage.logIntoYourAccountDisplayed());
		Log.info("Login to your account is vissible");
		homePage =  signupPage.enterCorrectEmailAndPassword(email, pass);
//		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("Verify Your email or password is incorrect! is vissible");
		Assert.assertTrue(signupPage.incorrectDisplayed());
		Log.info("Your email or password is incorrect! is vissible");
		Log.endTestCase("loginUserWithInCorrectEmailAndPassword");

	}
	
	@Test(dataProvider = "loginDetails", dataProviderClass = DataProviders.class)
	public void logoutUser(String email, String pass) throws Throwable {
		Log.startTestCase("logoutUser");
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		signupPage = homePage.registerUser();
		homePage =  signupPage.enterCorrectEmailAndPassword(email, pass);
		String actual = homePage.getLoggedAs();
		System.out.println(actual);
		Log.info("Verify Logged in as username is vissible ");
		Assert.assertEquals(actual, "Logged in as Tester", "Incorrect User");
		Log.info("Logged in as username is vissible ");
		signupPage =  homePage.clickLogout();
		Assert.assertEquals(signupPage.getSignupPageUrl(), "https://www.automationexercise.com/login");
		Log.endTestCase("logoutUser");

	}
	@Test(dataProvider = "signUpCredentials", dataProviderClass = DataProviders.class)
	public void registerUserwithExistingEmail(String name, String email) {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		signupPage = homePage.registerUser();
		Log.info("Verify NewUserSignup is vissible ");
		Assert.assertTrue(signupPage.verifyNewUserSignup());
		Log.info("NewUserSignup is vissible ");
		signupPage.enterSignupCredentials(name, email);
		Assert.assertTrue(signupPage.emailExisttDisplayed());
		
	}
	@Test(dataProvider = "subscriptionEmail", dataProviderClass = DataProviders.class)
	public void verifySubscriptionInhomePage(String email) {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		homePage.verifySubscriptionFooter(email);
		Assert.assertTrue(homePage.verifySubscribeMsg());

//		String msg = homePage.verifySubscribeMsg();
//		System.out.println(msg);
	}

}
