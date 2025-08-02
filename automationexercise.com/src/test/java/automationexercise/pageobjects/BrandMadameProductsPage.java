package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class BrandMadameProductsPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//h2[@class='title text-center']")
	WebElement madameproducts;
	
	public BrandMadameProductsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean madameProductsDisplayed() {
	return 	action.isDisplayed(getDriver(), madameproducts);
	}
}
