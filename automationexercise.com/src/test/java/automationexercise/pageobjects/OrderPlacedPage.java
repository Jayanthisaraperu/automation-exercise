package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class OrderPlacedPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//b[text()='Order Placed!']")
	WebElement orderplaced;
	
	@FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
	WebElement orderconfirmed;
	
	
	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement delete_account;
	
	@FindBy(xpath = "//a[text()='Download Invoice']")
	WebElement downloadinvoice;
	
	
	public OrderPlacedPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean orderPlacedDisplyed() {
		return action.isDisplayed(getDriver(), orderplaced);
	}
	
	public String orderConfirmed() {
		return orderconfirmed.getText();
	}
	
	public AccountDeletedPage deleteAccount() {
		action.click(getDriver(), delete_account);
		return new AccountDeletedPage();
	}
	
	public void  downloadInvoice() {
		action.click(getDriver(), downloadinvoice);
		
	}
}
