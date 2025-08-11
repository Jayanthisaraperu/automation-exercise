package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class BrandPoloProductPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//h2[@class='title text-center']")
	WebElement polobrand;
	
	@FindBy(xpath = "//a[text()='Madame']")
	WebElement madame;
	
	public BrandPoloProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean poloBrandDisplayed() {
		return action.isDisplayed(getDriver(), polobrand);
	}
	
	public BrandMadameProductsPage clickMadame() throws Throwable {
		action.click(getDriver(), madame);
		Thread.sleep(2000);
		return new BrandMadameProductsPage();
	}

}
