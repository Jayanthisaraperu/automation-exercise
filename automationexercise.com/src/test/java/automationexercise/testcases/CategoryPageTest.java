package automationexercise.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationexercise.base.BaseClass;
import automationexercise.dataprovider.DataProviders;
import automationexercise.pageobjects.AccountCreatedPage;
import automationexercise.pageobjects.AccountDeletedPage;
import automationexercise.pageobjects.BrandMadameProductsPage;
import automationexercise.pageobjects.BrandPoloProductPage;
import automationexercise.pageobjects.CartPage;
import automationexercise.pageobjects.CkeckoutPage;
import automationexercise.pageobjects.EnterAccountInformationPage;
import automationexercise.pageobjects.HomePage;
import automationexercise.pageobjects.MenTshirtsProductsPage;
import automationexercise.pageobjects.OrderPlacedPage;
import automationexercise.pageobjects.PaymentPage;
import automationexercise.pageobjects.ProductDetailedPage;
import automationexercise.pageobjects.ProductsPage;
import automationexercise.pageobjects.SearchedProductsPage;
import automationexercise.pageobjects.SignupPage;
import automationexercise.pageobjects.WomenDressProductsPage;
import automationexercise.utility.Log;

public class CategoryPageTest extends BaseClass {
	HomePage homepage;
	WomenDressProductsPage womenDressProductsPage;
	MenTshirtsProductsPage menTshirtsProductsPage;
	ProductsPage productsPage;
	BrandPoloProductPage brandPoloProductPage;
	BrandMadameProductsPage brandMadameProductsPage;
	SearchedProductsPage searchedProductsPage;
	CartPage cartPage;
	SignupPage signupPage;
	ProductDetailedPage productDetailedPage;
	EnterAccountInformationPage enterAccountInformationPage;
	AccountCreatedPage accountCreatedPage;
	CkeckoutPage ckeckoutPage;
	AccountDeletedPage accountDeletedPage;
	PaymentPage paymentPage;
	OrderPlacedPage orderPlacedPage;
	
	@BeforeMethod
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Test(priority = 0)
	public void viewCategoryProducts() throws Throwable {
		homepage = new HomePage();
		homepage.leftbarDisplayed();
		womenDressProductsPage = homepage.clickWomenCategory();
		menTshirtsProductsPage = womenDressProductsPage.clickMenCategory();
		Assert.assertTrue(menTshirtsProductsPage.menTshirtsProductDisplayed());
	}

	@Test(priority = 1)
	public void viewCartBrandProducts() throws Throwable {
		homepage = new HomePage();
		productsPage = homepage.clickProducts();
		Assert.assertTrue(productsPage.brandsDisplayed());
		brandPoloProductPage = productsPage.clickPolo();
		Assert.assertTrue(brandPoloProductPage.poloBrandDisplayed());
		brandMadameProductsPage = brandPoloProductPage.clickMadame();
		Assert.assertTrue(brandMadameProductsPage.madameProductsDisplayed());
	}

	@Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class, priority = 2)
	public void searchProductsVerifyCartAfterLogin(String search, String email, String pass) throws Throwable {
		homepage = new HomePage();
		productsPage = homepage.clickProducts();
		Assert.assertTrue(productsPage.verifyAllProductsDisplayed());
		searchedProductsPage = productsPage.searchProduct(search);
		Assert.assertTrue(searchedProductsPage.verifyAllSearchDisplayed());
		Assert.assertTrue(searchedProductsPage.verifySearchedProductsDisplayed());
		cartPage = searchedProductsPage.clickAddToCart();
		Assert.assertTrue(cartPage.productsDisplayed());
		signupPage = cartPage.clickLogin();
		homepage = signupPage.enterCorrectEmailAndPassword(email, pass);
		cartPage = homepage.clickCart();
		String item = cartPage.productVissibleInCart();
		System.out.println(item);
		boolean flag = false;
		if (item.contains(search)) {
			flag = true;
		}
		Assert.assertTrue(flag);
	}

	@Test(dataProvider = "writeReview", dataProviderClass = DataProviders.class, priority = 3)
	public void addReviewOnProduct(String name, String email, String review) throws Throwable {
		homepage = new HomePage();
		productsPage = homepage.clickProducts();
		Assert.assertTrue(productsPage.verifyAllProductsDisplayed());
		productDetailedPage = productsPage.viewFirstProduct();
		Assert.assertTrue(productDetailedPage.writeYourReviewDisplayed());	
//		productDetailedPage.enterReviewDetails(name, email, review);
		Assert.assertTrue(productDetailedPage.enterReviewDetails(name, email, review));
	}
	
	@Test(priority = 4)
	public void addToCartFromRecommendedItems() throws Throwable {
		homepage = new HomePage();
		Thread.sleep(5000);
		homepage.scrollBottomOfPage();
		Thread.sleep(5000);
	}
	
	
	@Test(dataProvider = "signUpPageCredentials", dataProviderClass = DataProviders.class, priority = 6)
	public void verifyAddressDetailsInChkoutPage(String name, String email, String pass, String fname, String lname, String add,
			String coun, String state, String city, String zcode, String mob) throws Throwable {
		homepage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homepage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		signupPage = homepage.registerUser();
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
		homepage = accountCreatedPage.clickContinue();
		String actual = homepage.getLoggedAs();
		System.out.println(actual);
		Log.info("Verify Logged in as username is vissible ");
		Assert.assertEquals(actual, "Logged in as "+ name, "Incorrect User");
		Log.info("Logged in as username is vissible ");
		cartPage = homepage.addProductsAndChkout();
		Assert.assertTrue(cartPage.verifyShoppingCartDisplayed());
		ckeckoutPage = cartPage.clickProceedToChk();
		Assert.assertTrue(ckeckoutPage.verifyAdressDetailsDisplayed());
		Assert.assertTrue(ckeckoutPage.verifyReviewOredrDisplayed());
		ArrayList<Object> delieveradd = new ArrayList<Object>();
		delieveradd.add("Mrs. "+ name +" "+lname );
		delieveradd.add(add);
		delieveradd.add(city +" "+ state +" "+ zcode);
		delieveradd.add(coun);
		delieveradd.add(mob);
		System.out.println("Expect Delivery And Billing Address : "+  delieveradd);
//		ckeckoutPage.getDeliveryAddress();
		Assert.assertEquals(ckeckoutPage.getDeliveryAddress(), delieveradd);
		Assert.assertEquals(ckeckoutPage.getBillingAddress(), delieveradd);

		accountDeletedPage = ckeckoutPage.deleteAccount();
		Assert.assertTrue(accountDeletedPage.verifyAccountDeleted());
		accountDeletedPage.clickAccountDeleteContinue();
	}
	
	@Test(dataProvider = "downloadInvoice", dataProviderClass = DataProviders.class, priority = 5)
	public void downloadInvoice(String email, String pass, String name, String text, String num, String cvcno, String month, String year  ) throws Throwable {
		homepage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homepage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		cartPage = homepage.addProductsAndChkout();
		Assert.assertTrue(cartPage.verifyShoppingCartDisplayed());
		signupPage = cartPage.clickProceedToChkout();
		homepage = signupPage.enterCorrectEmailAndPassword(email, pass);
		String actual = homepage.getLoggedAs();
		System.out.println(actual);
		Log.info("Verify Logged in as username is vissible ");
		Assert.assertEquals(actual, "Logged in as " + name, "Incorrect User");
		Log.info("Logged in as username is vissible ");
		cartPage = homepage.addProductsAndChkout();
		Assert.assertTrue(cartPage.verifyShoppingCartDisplayed());
		ckeckoutPage = cartPage.clickProceedToChk();
		Assert.assertTrue(ckeckoutPage.verifyAdressDetailsDisplayed());
		Assert.assertTrue(ckeckoutPage.verifyReviewOredrDisplayed());
		paymentPage = ckeckoutPage.enterTextAddressDetailsPage(text);
		orderPlacedPage = paymentPage.enterPaymentCredentials(name, num, cvcno, month, year);
		Thread.sleep(2000);
		Assert.assertTrue(orderPlacedPage.orderPlacedDisplyed());
		boolean flag = false;
		String successmsg = orderPlacedPage.orderConfirmed();
		if(successmsg.contains("Congratulations! Your order has been confirmed!")) {
			flag = true;
		}
		System.out.println(successmsg);
		Assert.assertTrue(flag);
		orderPlacedPage.downloadInvoice();
//		ckeckoutPage = cartPage.clickProceedToChk();
//		paymentPage = ckeckoutPage.clicKPlaceOrder();
//		orderPlacedPage = paymentPage.enterPaymentCredentials(name, num, cvcno, month, year);
//		orderPlacedPage.downloadInvoice();
	}
}
