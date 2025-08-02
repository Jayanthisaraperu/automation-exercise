package automationexercise.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class HomePage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	WebElement link_SignupLogin;

	@FindBy(xpath = "//a[text()=' Logged in as ']")
	WebElement loggedAs;

	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement delete_account;

	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement logout;

	@FindBy(xpath = "//a[text()=' Contact us']")
	WebElement contactus;

	@FindBy(xpath = "//a[text()=' Test Cases']")
	WebElement testcase;

	@FindBy(xpath = "//a[text()=' Products']")
	WebElement products;
	
	@FindBy(id = "susbscribe_email")
	WebElement subscription;
	
	@FindBy(id = "subscribe")
	WebElement btn_subscribe;
	
	@FindBy(id = "//div[@class='alert-success alert']")
	WebElement alertmsg;
	
	@FindBy(xpath = "//a[text()=' Cart']")
	WebElement cart;
	
	@FindBy(xpath = "(//a[text()='View Product'])[2]")
	WebElement secproduct;
	
	@FindBy(xpath = "//a[@data-product-id='1']")
	WebElement addfirstprod;
	
	@FindBy(xpath = "//a[@data-product-id='2']")
	WebElement addsecprod;
	
	@FindBy(xpath = "//a[@data-product-id='3']")
	WebElement addthirdprod;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement continueshopping;
	
	@FindBy(xpath = "//a/u[text()='View Cart']")
	WebElement viewcart;
	
	@FindBy(xpath = "//div[@class='left-sidebar']")
	WebElement leftbar;
	
	@FindBy(xpath = "(//span[@class='badge pull-right'])[1]")
	WebElement women;
	
	@FindBy(xpath = "//a[text()='Dress ']")
	WebElement dress;
	
	@FindBy(xpath = "//h2[text()='recommended items']")
	WebElement recommendeditems;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getHomePageTitle() {
		return action.getTitle(getDriver());
	}

	public SignupPage registerUser() {
		action.click(getDriver(), link_SignupLogin);
		return new SignupPage();
	}

	public String getLoggedAs() {
		return loggedAs.getText();
	}

	public AccountDeletedPage deleteAccount() {
		action.click(getDriver(), delete_account);
		return new AccountDeletedPage();
	}

	public SignupPage clickLogout() {
		action.click(getDriver(), logout);
		return new SignupPage();

	}

	public ContactusPage clickContactus() {
		action.click(getDriver(), contactus);
		return new ContactusPage();
	}

	public TestCasePage clickTestcase() {
		action.click(getDriver(), testcase);
		return new TestCasePage();
	}

	public ProductsPage clickProducts() {
		action.click(getDriver(), products);
		return new ProductsPage();
	}
	
	public void verifySubscriptionFooter(String email) {
		action.scrollByVisibilityOfElement(getDriver(), subscription);
		action.type(subscription, email);
		action.click(getDriver(), btn_subscribe);
	}
	
	public boolean verifySubscribeMsg() {
		return alertmsg.isDisplayed();

	}
	
	public CartPage clickCart() {
		action.click(getDriver(), cart);
		return new CartPage();
	}
	public ProductDetailedPage clickSecProductInHomePage() {
		action.click(getDriver(), secproduct);
		return new ProductDetailedPage();
	}
	public CartPage addProductsAndChkout() throws Throwable  {
		action.click(getDriver(), addfirstprod);
		Thread.sleep(2000);
		action.click(getDriver(), continueshopping);
		action.click(getDriver(), addsecprod);
		Thread.sleep(2000);
		action.click(getDriver(), continueshopping);
//		Thread.sleep(2000);
//		action.scrollByVisibilityOfElement(getDriver(), addthirdprod);
		action.click(getDriver(), addthirdprod);
		Thread.sleep(2000);
		action.click(getDriver(), viewcart);
		Thread.sleep(2000);
		return new CartPage();
	}
	public CartPage addFirstProduct() throws Throwable {
		action.click(getDriver(), addfirstprod);
		Thread.sleep(2000);
		action.click(getDriver(), viewcart);
		Thread.sleep(2000);
		return new CartPage();
	}
	public void leftbarDisplayed() {
		action.isDisplayed(getDriver(), leftbar);
	}
	
	public WomenDressProductsPage clickWomenCategory() throws Throwable {
		action.click(getDriver(), women);
		Thread.sleep(5000);
		action.click(getDriver(), dress);
		Thread.sleep(5000);
		return new WomenDressProductsPage();
	}

	public void scrollBottomOfPage() {
//		JavascriptExecutor js = (JavascriptExecutor)getDriver();
//		js.executeScript("window.scrollBy(0,500);");
		action.scrollByVisibilityOfElement(getDriver(), recommendeditems);
	}
}