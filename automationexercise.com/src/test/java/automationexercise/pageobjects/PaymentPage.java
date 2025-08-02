package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class PaymentPage extends BaseClass{
	Action action = new Action();

	@FindBy(xpath = "//input[@name='name_on_card']")
	WebElement nameoncard;
	
	@FindBy(xpath = "//input[@name='card_number']")
	WebElement cardnum;
	
	@FindBy(xpath = "//input[@name='cvc']")
	WebElement cvc;
	
	@FindBy(xpath = "//input[@name='expiry_month']")
	WebElement expirymonth;
	
	@FindBy(xpath = "//input[@name='expiry_year']")
	WebElement expiryyear;

	@FindBy(id = "submit")
	WebElement payandconfirmorder;
	
	@FindBy(id = "success_message")
	WebElement successmsg;
	
	
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	public OrderPlacedPage enterPaymentCredentials(String name,String num, String cvcno, String month, String year  ) throws Throwable {
		action.type(nameoncard, name);
		action.type(cardnum, num);
		action.type(cvc, cvcno);
		action.type(expirymonth, month);
		action.type(expiryyear, year);
		action.click(getDriver(), payandconfirmorder);
		Thread.sleep(2000);
		return new OrderPlacedPage();
	}
	
}
