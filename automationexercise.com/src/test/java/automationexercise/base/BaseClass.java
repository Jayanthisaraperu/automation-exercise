package automationexercise.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import automationexercise.utility.ExtentManager;

//import com.adactin.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
//	public static WebDriver driver;
	// Declare ThreadLocal Driver
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
////	@BeforeTest(groups = {"Smoke", "Sanity", "Regression"})
//	@BeforeTest
//	public void BaseClass() {
//		DOMConfigurator.configure("log4j.xml");
////		prop = new Properties();
//		try {
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream(
//					System.getProperty("user.dir") + "\\Configuration\\config.properties");
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void launchApp( String browserName){
//	public void launchApp( ){
//		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
//			WebDriverManager.chromiumdriver().driverVersion("136.0.7103.114").setup();
//			WebDriverManager.chromiumdriver().driverVersion("137.0.7151.68").setup();

			
//			driver = new ChromeDriver(); 
			driver.set(new ChromeDriver());		}
		else if(browserName.equals("gecko")){
			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver(); 
			driver.set(new FirefoxDriver());
		}
		else if(browserName.equals("edge")){
			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver(); 
			driver.set(new EdgeDriver());
		}
		
		
		
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		getDriver().get(prop.getProperty("url"));
		
	}
	
	@AfterSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
	
	
	
}	

