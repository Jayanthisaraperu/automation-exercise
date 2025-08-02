package automationexercise.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationexercise.base.BaseClass;
import automationexercise.dataprovider.DataProviders;
import automationexercise.pageobjects.AccountCreatedPage;
import automationexercise.pageobjects.AccountDeletedPage;
import automationexercise.pageobjects.CartPage;
import automationexercise.pageobjects.CkeckoutPage;
import automationexercise.pageobjects.EnterAccountInformationPage;
import automationexercise.pageobjects.HomePage;
import automationexercise.pageobjects.OrderPlacedPage;
import automationexercise.pageobjects.PaymentPage;
import automationexercise.pageobjects.SignupPage;
import automationexercise.utility.Log;

public class CartPageTest extends BaseClass {

	HomePage homePage;
	CartPage cartPage;
	SignupPage signupPage;
	EnterAccountInformationPage enterAccountInformationPage;
	AccountCreatedPage accountCreatedPage;
	CkeckoutPage ckeckoutPage;
	PaymentPage paymentPage;
	AccountDeletedPage accountDeletedPage;
	OrderPlacedPage orderPlacedPage;

	@BeforeMethod
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}


	@Test(dataProvider = "subscriptionEmail", dataProviderClass = DataProviders.class, groups = { "smoke","sanity"}, priority = 0)
	public void verifySubscriptionInCartPage(String email) {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		cartPage = homePage.clickCart();
		cartPage.scrollFooter();
		Assert.assertTrue(cartPage.verifySubs());
		cartPage.enterEmail(email);
	}

	@Test(dataProvider = "placeOrder", dataProviderClass = DataProviders.class, groups = "regression", priority = 1)
	public void placeOrderRegisterWhileChkout(String name, String email, String pass, String fname, String lname,
			String add, String coun, String state, String city, String zcode, String mob, String text, String num,
			String cvcno, String month, String year) throws Throwable {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		cartPage = homePage.addProductsAndChkout();
		Assert.assertTrue(cartPage.verifyShoppingCartDisplayed());
		signupPage = cartPage.clickProceedToChkout();
		enterAccountInformationPage = signupPage.enterSignupCredentials(name, email);
		accountCreatedPage = enterAccountInformationPage.enterRegistrationDetails(pass, fname, lname, add, coun, state,
				city, zcode, mob);
		homePage = accountCreatedPage.clickContinue();
		String actual = homePage.getLoggedAs();
		System.out.println(actual);
		Log.info("Verify Logged in as username is vissible ");
		Assert.assertEquals(actual, "Logged in as " + name, "Incorrect User");
		Log.info("Logged in as username is vissible ");
		cartPage = homePage.clickCart();
		ckeckoutPage = cartPage.clickProceedToChk();
		Assert.assertTrue(ckeckoutPage.verifyAdressDetailsDisplayed());
		Assert.assertTrue(ckeckoutPage.verifyReviewOredrDisplayed());
		paymentPage = ckeckoutPage.enterTextAddressDetailsPage(text);
		orderPlacedPage = paymentPage.enterPaymentCredentials(name, num, cvcno, month, year);
		Assert.assertTrue(orderPlacedPage.orderPlacedDisplyed());
		String successmsg = orderPlacedPage.orderConfirmed();
		boolean flag = false;
		System.out.println(successmsg);
		if(successmsg.contains("Congratulations! Your order has been confirmed!")) {
			flag = true;
		}
		Assert.assertTrue(flag);
		
		accountDeletedPage = orderPlacedPage.deleteAccount();
		Assert.assertTrue(accountDeletedPage.verifyAccountDeleted());
		accountDeletedPage.clickAccountDeleteContinue();

	}

	@Test(dataProvider = "placeOrder", dataProviderClass = DataProviders.class, groups = "regression", priority = 2)
	public void placeOrderRegisterbeforeChkout(String name, String email, String pass, String fname, String lname,
			String add, String coun, String state, String city, String zcode, String mob, String text, String num,
			String cvcno, String month, String year) throws Throwable {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		signupPage = homePage.registerUser();
		enterAccountInformationPage = signupPage.enterSignupCredentials(name, email);
		accountCreatedPage = enterAccountInformationPage.enterRegistrationDetails(pass, fname, lname, add, coun, state,
				city, zcode, mob);
		homePage = accountCreatedPage.clickContinue();
		String actual = homePage.getLoggedAs();
		System.out.println(actual);
		Log.info("Verify Logged in as username is vissible ");
		Assert.assertEquals(actual, "Logged in as " + name, "Incorrect User");
		Log.info("Logged in as username is vissible ");
		cartPage = homePage.addProductsAndChkout();
		Assert.assertTrue(cartPage.verifyShoppingCartDisplayed());
		ckeckoutPage = cartPage.clickProceedToChk();
		Assert.assertTrue(ckeckoutPage.verifyAdressDetailsDisplayed());
		Assert.assertTrue(ckeckoutPage.verifyReviewOredrDisplayed());
		paymentPage = ckeckoutPage.enterTextAddressDetailsPage(text);
		orderPlacedPage = paymentPage.enterPaymentCredentials(name, num, cvcno, month, year);
		Assert.assertTrue(orderPlacedPage.orderPlacedDisplyed());
		String successmsg = orderPlacedPage.orderConfirmed();
		boolean flag = false;
		System.out.println(successmsg);
		if(successmsg.contains("Congratulations! Your order has been confirmed!")) {
			flag = true;
		}
		Assert.assertTrue(flag);
		System.out.println(successmsg);
		accountDeletedPage = orderPlacedPage.deleteAccount();
		Assert.assertTrue(accountDeletedPage.verifyAccountDeleted());
		accountDeletedPage.clickAccountDeleteContinue();


	}

	@Test(dataProvider = "placeOrderBeforeLogin", dataProviderClass = DataProviders.class, groups = "regression", priority = 3)
	public void placeOrderLoginBeforeChkout(String name, String email, String pass, String text, String num,
			String cvcno, String month, String year) throws Throwable {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		signupPage = homePage.registerUser();
		homePage = signupPage.enterCorrectEmailAndPassword(email, pass);
		String actual = homePage.getLoggedAs();
		System.out.println(actual);
		Log.info("Verify Logged in as username is vissible ");
		Assert.assertEquals(actual, "Logged in as " + name, "Incorrect User");
		Log.info("Logged in as username is vissible ");
		cartPage = homePage.addProductsAndChkout();
		Assert.assertTrue(cartPage.verifyShoppingCartDisplayed());
		ckeckoutPage = cartPage.clickProceedToChk();
		Assert.assertTrue(ckeckoutPage.verifyAdressDetailsDisplayed());
		Assert.assertTrue(ckeckoutPage.verifyReviewOredrDisplayed());
		paymentPage = ckeckoutPage.enterTextAddressDetailsPage(text);
		orderPlacedPage = paymentPage.enterPaymentCredentials(name, num, cvcno, month, year);
		Assert.assertTrue(orderPlacedPage.orderPlacedDisplyed());
		String successmsg = orderPlacedPage.orderConfirmed();
		boolean flag = false;
		System.out.println(successmsg);
		if(successmsg.contains("Congratulations! Your order has been confirmed!")) {
			flag = true;
		}
		Assert.assertTrue(flag);
		System.out.println(successmsg);
	}
	
	@Test(groups = "smoke", priority = 4)
	public void removeProductsFromCart() throws Throwable {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		cartPage = homePage.addProductsAndChkout();
		Assert.assertTrue(cartPage.verifyShoppingCartDisplayed());
		cartPage.getProductsInCart();
		String item = "Blue Top";
		if(cartPage.getProductsInCart().contains(item)) {
			getDriver().findElement(By.xpath("//table[@id='cart_info_table']/tbody/tr/td/h4/a[text()='"+item+"']"
					+ "//parent::h4/parent::td/following-sibling::td[4]/a/i[@class='fa fa-times']")).click();
			Thread.sleep(10000);

		}
		
	}
}
