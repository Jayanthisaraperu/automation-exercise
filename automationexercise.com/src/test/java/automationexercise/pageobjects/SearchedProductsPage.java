package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class SearchedProductsPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//h2[text()='Searched Products']")
	WebElement searchedproducts;

	@FindBy(xpath = "//div[@class='features_items']")
	WebElement allproductvisi;

	@FindBy(xpath = "//a[text()='Add to cart']")
	WebElement addtocart;

	@FindBy(xpath = "//a/u[text()='View Cart']")
	WebElement viewcart;

	public SearchedProductsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifySearchedProductsDisplayed() {
		return action.isDisplayed(getDriver(), searchedproducts);

	}

	public boolean verifyAllSearchDisplayed() {
		return action.isDisplayed(getDriver(), allproductvisi);

	}

	public CartPage clickAddToCart() throws Throwable {
		action.click(getDriver(), addtocart);
		Thread.sleep(2000);
		action.click(getDriver(), viewcart);
		return new CartPage();
	}
}
