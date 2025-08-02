package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class EnterAccountInformationPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement enter_account_information;

	@FindBy(id = "id_gender2")
	WebElement radio_title;

	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(id = "days")
	WebElement dropdown_days;

	@FindBy(id = "months")
	WebElement dropdown_months;

	@FindBy(id = "years")
	WebElement dropdown_years;

	@FindBy(id = "newsletter")
	WebElement chkbox_newsletter;

	@FindBy(id = "optin")
	WebElement chkbox_specialoffer;

	@FindBy(id = "first_name")
	WebElement txt_first_name;

	@FindBy(id = "last_name")
	WebElement txt_last_name;

	@FindBy(id = "address1")
	WebElement txt_address1;

	@FindBy(id = "country")
	WebElement dropdown_country;

	@FindBy(id = "state")
	WebElement txt_state;

	@FindBy(id = "city")
	WebElement txt_city;

	@FindBy(id = "zipcode")
	WebElement txt_zipcode;

	@FindBy(id = "mobile_number")
	WebElement txt_mobile_number;

	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement create_account;

	public EnterAccountInformationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifyEnterAccountInformation() {
		return action.isDisplayed(getDriver(), enter_account_information);
	}

	public AccountCreatedPage enterRegistrationDetails(String pass, String fname, String lname, String add, String coun, String state,
			String city, String zcode, String mob) {
		action.click(getDriver(), radio_title);
		action.type(txt_password, pass);
//		action.selectByVisibleText(day, dropdown_days);
//		action.selectByVisibleText(month, dropdown_months);
//		action.selectByVisibleText(year, dropdown_years);
		action.click(getDriver(), chkbox_newsletter);
		action.click(getDriver(), chkbox_specialoffer);
		action.type(txt_first_name, fname);
		action.type(txt_last_name, lname);
		action.type(txt_address1, add);
		action.selectByVisibleText(coun, dropdown_country);
		action.type(txt_state, state);
		action.type(txt_city, city);
		action.type(txt_zipcode, zcode);
		action.type(txt_mobile_number, mob);
		action.click(getDriver(), create_account);
		return new AccountCreatedPage();

	}
}
