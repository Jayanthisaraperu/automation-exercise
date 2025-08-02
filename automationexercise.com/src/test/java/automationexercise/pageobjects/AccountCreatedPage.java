package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class AccountCreatedPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//b[text()='Account Created!']")
	WebElement account_created;
	
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement acccontinue;
	
	
	public AccountCreatedPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyAccountCreated() {
	return 	action.isDisplayed(getDriver(), account_created) ;
	}
	
	public HomePage clickContinue() {
		action.click(getDriver(), acccontinue);
		return new HomePage();
	}
}
