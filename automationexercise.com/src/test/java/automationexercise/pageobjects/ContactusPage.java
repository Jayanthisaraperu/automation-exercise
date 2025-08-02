package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class ContactusPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//h2[text()='Get In Touch']")
	WebElement getInTouch;

	@FindBy(xpath = "//input[@name='name']")
	WebElement name_contactus;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email_contactus;

	@FindBy(xpath = "//input[@name='subject']")
	WebElement subject_contactus;

	@FindBy(id = "message")
	WebElement txt_msg;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement submit;

	@FindBy(xpath = "//div[@class='status alert alert-success']")
	WebElement msg_success;

	@FindBy(xpath = "//a[text()=' Home']")
	WebElement link_home;
	
	public ContactusPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifygetInTouch() {
		return action.isDisplayed(getDriver(), getInTouch);
	}

	public HomePage enterContactusForm(String name, String email, String sub, String msg) {
		action.type(name_contactus, name);
		action.type(email_contactus, email);
		action.type(subject_contactus, sub);
		action.type(txt_msg, msg);
		action.click(getDriver(), submit);
		getDriver().switchTo().alert().accept();
		String msgg = msg_success.getText();
		System.out.println(msgg);
		action.click(getDriver(), link_home);
		return new HomePage();

	}
}
