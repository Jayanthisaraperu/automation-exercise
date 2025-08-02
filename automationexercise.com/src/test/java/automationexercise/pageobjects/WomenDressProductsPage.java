package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class WomenDressProductsPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "(//span[@class='badge pull-right'])[2]")
	WebElement men;
	
	@FindBy(xpath = "//a[text()='Tshirts ']")
	WebElement Tshirts;
	
	public WomenDressProductsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public MenTshirtsProductsPage clickMenCategory() throws Throwable {
		action.click(getDriver(), men);
		Thread.sleep(5000);
		action.click(getDriver(), Tshirts);
		Thread.sleep(5000);
		return new MenTshirtsProductsPage();
	}
}
