package automationexercise.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class ProductDetailedPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//h2[text()='Blue Top']")
	WebElement productname;

	@FindBy(xpath = "//div[@class='product-information']//p")
	List<WebElement> productinfo;

	@FindBy(xpath = "//div[@class='view-product']")
	WebElement productdetail;

	@FindBy(xpath = "//input[@id='quantity']")
	WebElement quantity;

	@FindBy(xpath = "//button[@type='button']")
	WebElement itemaddtocart;

	@FindBy(xpath = "//a/u[text()='View Cart']")
	WebElement prodviewcart;

	@FindBy(xpath = "(//a[@href='/view_cart'])[2]")
	WebElement cartquantity;

	@FindBy(xpath = "//div[@class='col-sm-12']/ul/li/a[text()='Write Your Review']")
	WebElement writeyourreview;

	@FindBy(id = "name")
	WebElement reviewname;

	@FindBy(id = "email")
	WebElement reviewemail;

	@FindBy(id = "review")
	WebElement enterreview;

	@FindBy(id = "button-review")
	WebElement btnreview;
	
	@FindBy(id = "//span[text()='Thank you for your review.']")
	WebElement success;

	public ProductDetailedPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifyProductnameDisplayed() {
		return action.isDisplayed(getDriver(), productname);
	}

	public ArrayList<Object> productInfoList() {

		ArrayList<Object> proddetails = new ArrayList<Object>();

		for (int i = 0; i < productinfo.size(); i++) {

			String details = productinfo.get(i).getText();
			proddetails.add(details);
			System.out.println("Actual:" + details);
		}
		return proddetails;
	}

	public boolean verifyProductDetaiDisplayed() {
		return action.isDisplayed(getDriver(), productdetail);
	}

	public CartPage clickQuantity() throws Throwable {
		quantity.clear();
		action.type(quantity, "4");
		Thread.sleep(2000);
		action.click(getDriver(), itemaddtocart);
		Thread.sleep(10000);
		action.click(getDriver(), prodviewcart);
		Thread.sleep(2000);
		return new CartPage();
	}

	public boolean writeYourReviewDisplayed() {
		return action.isDisplayed(getDriver(), writeyourreview);
	}

	public boolean enterReviewDetails(String name, String email, String review) throws Throwable {
		action.type(reviewname, name);
		action.type(reviewemail, email);
		action.type(enterreview, review);
		action.click(getDriver(), btnreview);
		Thread.sleep(2000);
		return action.isDisplayed(getDriver(), btnreview); 
	}
}
