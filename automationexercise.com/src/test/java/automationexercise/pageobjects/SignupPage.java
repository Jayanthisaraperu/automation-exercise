package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class SignupPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//h2[text()='New User Signup!']")
	WebElement new_User_Signup;

	@FindBy(xpath = "//input[@name='name']")
	WebElement txt_nameSignup;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	WebElement txt_emailSignup;

	@FindBy(xpath = "//button[text()='Signup']")
	WebElement btn_Signup;

	@FindBy(xpath = "//h2[text()='Login to your account']")
	WebElement logintoyouraccount;

	@FindBy(xpath = "(//input[@name='email'])[1]")
	WebElement txt_emailLogin;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_pass;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement btn_login;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement incorrect;
	
	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	WebElement emailexist;
	
	
	
	public SignupPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getSignupPageUrl() {
		return action.getCurrentURL(getDriver());
	}
	
	public boolean verifyNewUserSignup() {
		return action.isDisplayed(getDriver(), new_User_Signup);
	}

	public EnterAccountInformationPage enterSignupCredentials(String name, String email) {
		action.type(txt_nameSignup, name);
		action.type(txt_emailSignup, email);
		action.click(getDriver(), btn_Signup);
		return new EnterAccountInformationPage();

	}

	public boolean logIntoYourAccountDisplayed() {
		return action.isDisplayed(getDriver(), logintoyouraccount);
	}

	public HomePage enterCorrectEmailAndPassword(String email, String pass) {
		action.type(txt_emailLogin, email);
		action.type(txt_pass, pass);
		action.click(getDriver(), btn_login);
		return new HomePage();
	}
	
	public boolean incorrectDisplayed() {
		return action.isDisplayed(getDriver(), incorrect);
	}
	
	public boolean emailExisttDisplayed() {
		return action.isDisplayed(getDriver(), emailexist);
	}
}
