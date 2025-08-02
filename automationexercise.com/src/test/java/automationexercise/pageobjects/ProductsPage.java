package automationexercise.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.actiondriver.Action;
import automationexercise.base.BaseClass;

public class ProductsPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//h2[text()='All Products']")
	WebElement allProducts;
	
	@FindBy(xpath = "//div[@class='features_items']")
	WebElement productlist;
	
	@FindBy(xpath = "(//a[text()='View Product'])[1]")
	WebElement firstproduct;
	
	
	@FindBy(id = "search_product")
	WebElement searchproduct;
	
	@FindBy(id = "submit_search")
	WebElement submitsearch;
	
	@FindBy(xpath = "//a[@data-product-id='1']")
	WebElement addfirstprod;
	
	@FindBy(xpath = "//a[@data-product-id='2']")
	WebElement addsecprod;
	
	@FindBy(xpath = "//a[@data-product-id='7']")
	WebElement addsevenprod;
	
	@FindBy(xpath = "//a[@data-product-id='5']")
	WebElement addfiveprod;
	
	@FindBy(xpath = "//a[@data-product-id='14']")
	WebElement addtenprod;
	
	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement continueshopping;
	
	@FindBy(xpath = "//a/u[text()='View Cart']")
	WebElement viewcart;
	
	@FindBy(xpath = "//h2[text()='Brands']")
	WebElement brands;
	
	@FindBy(xpath = "//a[text()='Polo']")
	WebElement polo;
	
	@FindBy(id = "product-1")
//	@FindBy(id = "//table[@id='cart_info_table']/tbody/tr[1]//td")
	List<WebElement> firstrowprod;
	
	@FindBy(id = "product-2")
	List<WebElement> secrowprod;
	
	public ProductsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyAllProductsDisplayed() {
		return action.isDisplayed(getDriver(), allProducts);
		
	}
	
	
	
	public boolean verifyProductListDisplayed() {
		return action.isDisplayed(getDriver(), productlist);
		
	}
	
	public ProductDetailedPage viewFirstProduct() {
		action.click(getDriver(), firstproduct);
		return new ProductDetailedPage();
	}
	
	public SearchedProductsPage verifySearchProduct(String prodname) {
		 action.type(searchproduct, prodname);
		action.click(getDriver(), submitsearch);
		return new SearchedProductsPage();
	}
	public CartPage addProductToCart() throws Throwable{
		action.click(getDriver(), addfirstprod);
		Thread.sleep(2000);
		action.click(getDriver(), continueshopping);
		Thread.sleep(2000);
		action.click(getDriver(), addsecprod);
		Thread.sleep(2000);
		action.click(getDriver(), viewcart);
		Thread.sleep(2000);
		return new CartPage();
	}
	
	public ArrayList<Object> verifyCartdetails() {
		ArrayList<Object> firstpd = new ArrayList<Object>();
//		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i=0; i<firstrowprod.size(); i++) {
			String add = firstrowprod.get(i).getText();
			firstpd.add(add);
			System.out.println("Actual text "+add);
		}
		return firstpd;
	}
	
	public boolean brandsDisplayed() {
		return action.isDisplayed(getDriver(), brands);
		
	}
	
	public BrandPoloProductPage clickPolo() throws Throwable {
		action.click(getDriver(), polo);
		Thread.sleep(5000);
		return new BrandPoloProductPage();
	}
	
	public SearchedProductsPage searchProduct(String search) throws Throwable {
		action.type(searchproduct, search);
		action.click(getDriver(), submitsearch);
		Thread.sleep(2000);
		return new SearchedProductsPage();
		
	}
	
}
