package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class MenTshirtsProductsPage extends BaseClass {
	Action action = new Action();
	@FindBy(xpath = "//h2[text()='Men - Tshirts Products']")
	WebElement menTshirtsproduct;
	
	public MenTshirtsProductsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean menTshirtsProductDisplayed() {
		return action.isDisplayed(getDriver(), menTshirtsproduct);
	}
}
