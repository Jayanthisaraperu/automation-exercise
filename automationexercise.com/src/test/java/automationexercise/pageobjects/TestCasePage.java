package automationexercise.pageobjects;

import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class TestCasePage extends BaseClass {
	Action action = new Action();
	
	public TestCasePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getTestCasePageUrl() {
		return action.getCurrentURL(getDriver());		
	}
}
