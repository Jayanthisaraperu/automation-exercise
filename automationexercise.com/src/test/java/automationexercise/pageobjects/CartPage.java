package automationexercise.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class CartPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//div[@class='footer-widget']")
	WebElement footer;

	@FindBy(xpath = "//h2[text()='Subscription']")
	WebElement subs;

	@FindBy(id = "susbscribe_email")
	WebElement subscribeemail;

	@FindBy(id = "subscribe")
	WebElement btn_subscribe;

	@FindBy(xpath = "//td[@class='cart_quantity']")
	WebElement cartquantity;

	@FindBy(xpath = "//li[text()='Shopping Cart']")
	WebElement shoppingcart;

	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	WebElement proceedtochkout;

	@FindBy(xpath = "//a/u[text()='Register / Login']")
	WebElement registerlogin;
	
	@FindBy(xpath = "//table[@id='cart_info_table']/tbody//td[2]")
	List<WebElement>  productsincart;
	
	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_delete']")
	WebElement cartdelete;
	
	@FindBy(xpath = "//table[@id='cart_info_table']")
	WebElement productsdisplayed;
	
	@FindBy(xpath = "//a[text()=' Signup / Login']")
	WebElement link_SignupLogin;
	
	@FindBy(xpath = "//table[@id='cart_info_table']/tbody//td[2]")
	WebElement itemadded;
	
	//table[@id='cart_info_table']/tbody/tr/td/h4/a[text()='Blue Top']

	public CartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void scrollFooter() {
		action.scrollByVisibilityOfElement(getDriver(), footer);
	}

	public boolean verifySubs() {
		return action.isDisplayed(getDriver(), subs);
	}

	public void enterEmail(String email) {
		action.type(subscribeemail, email);
		action.click(getDriver(), btn_subscribe);
	}

	public String cartQuatity() {
		return cartquantity.getText();
	}

	public boolean verifyShoppingCartDisplayed() {
		return action.isDisplayed(getDriver(), shoppingcart);
	}

	public SignupPage clickProceedToChkout() throws Throwable {
		action.click(getDriver(), proceedtochkout);
		Thread.sleep(2000);
		action.click(getDriver(), registerlogin);
		return new SignupPage();
	}

	public CkeckoutPage clickProceedToChk() throws Throwable {
		action.click(getDriver(), proceedtochkout);
		Thread.sleep(2000);
		return new CkeckoutPage();
	}
	
	public ArrayList<Object> getProductsInCart() {
		System.out.println(productsincart.size());
		ArrayList<Object> productlist = new ArrayList<Object>();
		for(int i=0; i<productsincart.size(); i++) {
			String list = productsincart.get(i).getText();
			
			System.out.println(list);
			productlist.add(list);
		}
		return productlist;
//		String item = "Blue Top";
//		if(productlist.contains(item)) {
//			getDriver().findElement(By.xpath("//table[@id='cart_info_table']/tbody/tr/td/h4/a[text()='"+item+"']//parent::h4/parent::td/following-sibling::td[4]")).click();
//		}
	}
	
	public boolean productsDisplayed() {
		return action.isDisplayed(getDriver(), productsdisplayed);
	}
	
	public SignupPage clickLogin() {
		 action.click(getDriver(), link_SignupLogin);
		 return new SignupPage();
	}
	
	public String productVissibleInCart() {
	return 	itemadded.getText();
	}
}
