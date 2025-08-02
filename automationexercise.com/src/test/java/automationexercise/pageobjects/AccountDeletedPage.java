package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class AccountDeletedPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	WebElement account_deleted;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement link_continue;
	
	public AccountDeletedPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyAccountDeleted() {
		return action.isDisplayed(getDriver(), account_deleted);
	}
	
	public void clickAccountDeleteContinue() {
		action.click(getDriver(), link_continue);
	}
}
