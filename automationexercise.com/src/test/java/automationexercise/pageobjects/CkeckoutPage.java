package automationexercise.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class CkeckoutPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//h2[text()='Address Details']")
	WebElement addressdetails;
	
	@FindBy(xpath = "//h2[text()='Review Your Order']")
	WebElement reviewyourorder;
	
	@FindBy(xpath = "//textarea[@name='message']")
	WebElement entertext;
	
	@FindBy(xpath = "//a[text()='Place Order']")
	WebElement placeorder;
	
	@FindBy(xpath = "//ul[@id='address_delivery']/li/following-sibling::li")
	List<WebElement> deliveryaddress;
	
	@FindBy(xpath = "//ul[@id='address_invoice']/li/following-sibling::li")
	List<WebElement> billingaddress;
	
	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement delete_account;
	
	public CkeckoutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyAdressDetailsDisplayed() {
		return 	action.isDisplayed(getDriver(), addressdetails);
		}
	
	public boolean verifyReviewOredrDisplayed() {
		return 	action.isDisplayed(getDriver(), reviewyourorder);
		}
	
	public PaymentPage clicKPlaceOrder() {
		action.click(getDriver(), placeorder);
		return new PaymentPage();
	}
	
	public PaymentPage enterTextAddressDetailsPage(String text) {
		action.type(entertext, text);
		action.click(getDriver(), placeorder);
		return new PaymentPage();
	}
	
	public ArrayList<Object> getDeliveryAddress() {
		ArrayList<Object> deliveraddress = new ArrayList<Object>();
		for(int i=0; i<deliveryaddress.size(); i++) {
			String addres = deliveryaddress.get(i).getText();
			deliveraddress.add(addres);
		}
		System.out.println("Actual Delivery Address : "+  deliveraddress);
		return deliveraddress;
	}
	
	public ArrayList<Object> getBillingAddress() {
		ArrayList<Object> billingaddress = new ArrayList<Object>();
		for(int i=0; i<deliveryaddress.size(); i++) {
			String addres = deliveryaddress.get(i).getText();
			billingaddress.add(addres);
		}
		System.out.println("Actual Billing Address : "+  billingaddress);
		return billingaddress;
	}
	
	public AccountDeletedPage deleteAccount() {
		action.click(getDriver(), delete_account);
		return new AccountDeletedPage();
	}
}
