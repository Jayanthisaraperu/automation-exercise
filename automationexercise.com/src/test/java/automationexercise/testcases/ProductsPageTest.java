package automationexercise.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationexercise.base.BaseClass;
import automationexercise.dataprovider.DataProviders;
import automationexercise.pageobjects.CartPage;
import automationexercise.pageobjects.HomePage;
import automationexercise.pageobjects.ProductDetailedPage;
import automationexercise.pageobjects.ProductsPage;
import automationexercise.pageobjects.SearchedProductsPage;
import automationexercise.utility.Log;

public class ProductsPageTest extends BaseClass {

	HomePage homePage;
	ProductsPage productsPage;
	ProductDetailedPage productDetailedPage;
	SearchedProductsPage searchedProductsPage;
	CartPage cartPage;
	
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
	public void verifyAllProductsAndProductDetails() {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		productsPage = homePage.clickProducts();
		Assert.assertTrue(productsPage.verifyAllProductsDisplayed());
		Assert.assertTrue(productsPage.verifyProductListDisplayed());
		productDetailedPage =  productsPage.viewFirstProduct();
		Assert.assertTrue(productDetailedPage.verifyProductnameDisplayed());
		
		ArrayList<Object > proddetails = new ArrayList<Object>();
		proddetails.add("Category: Women > Tops");
		proddetails.add("Availability: In Stock");
		proddetails.add("Condition: New");
		proddetails.add("Brand: Polo");
		System.out.println("Expected:"+   proddetails.size());
		System.out.println("Actual:"+   productDetailedPage.productInfoList().size());

			Assert.assertEquals(productDetailedPage.productInfoList() , proddetails);

	}
	
	@Test(dataProvider = "prodName", dataProviderClass = DataProviders.class)
	public void searchProduct(String prodname) {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		productsPage = homePage.clickProducts();
		Assert.assertTrue(productsPage.verifyAllProductsDisplayed());
		searchedProductsPage =  productsPage.verifySearchProduct(prodname);
		Assert.assertTrue(searchedProductsPage.verifySearchedProductsDisplayed());
		Assert.assertTrue(searchedProductsPage.verifyAllSearchDisplayed());

		
	}
	
	@Test(dataProvider = "firstRow", dataProviderClass = DataProviders.class)
	public void addProductsInCart(String item, String des, String price, String quan, String total ) throws Throwable {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		productsPage = homePage.clickProducts();
		productsPage.addProductToCart();
		ArrayList<Object> first = new ArrayList<Object>();
		first.add(item);
		first.add(des);
		first.add(price);
		first.add(quan);
		first.add(total);
		System.out.println("expected   :"+first.size());
		System.out.println("actual   :"+productsPage.verifyCartdetails().size());
//		Assert.assertTrue(first.contains(productsPage.verifyCartdetails().get(0))); 
		Assert.assertEquals(productsPage.verifyCartdetails(), first);
	}

	@Test
	public void verifyProductQuantityInCart() throws Throwable {
		homePage = new HomePage();
		Log.info("Verify HomePage is Successfull");
		Assert.assertEquals(homePage.getHomePageTitle(), "Automation Exercise", "Incorrect Title");
		Log.info("HomePage is Successfull");
		productDetailedPage =  homePage.clickSecProductInHomePage();
		Assert.assertTrue(productDetailedPage.verifyProductDetaiDisplayed());
		cartPage = productDetailedPage.clickQuantity();
		Assert.assertEquals(cartPage.cartQuatity(), "4");
	}
}
