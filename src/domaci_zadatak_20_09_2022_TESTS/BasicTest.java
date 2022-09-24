package domaci_zadatak_20_09_2022_TESTS;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import domaci_zadatak_20_09_2022_PAGES.BuyBoxPage;
import domaci_zadatak_20_09_2022_PAGES.HeaderPage;
import domaci_zadatak_20_09_2022_PAGES.LayerCartPage;
import domaci_zadatak_20_09_2022_PAGES.TopMenuPage;
import p20_09_2022_Pages.CartPage;
import p20_09_2022_Pages.LogInPage;
import p20_09_2022_Pages.NavPage;
import p20_09_2022_Pages.ProductPage;



public abstract class BasicTest {
	protected WebDriver driver;
	protected String baseUrl = "http://automationpractice.com/";
	protected BuyBoxPage buyBoxPage;
	protected HeaderPage headerPage;
	protected LayerCartPage layerCartPage;
	protected TopMenuPage topMenuPage;


	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		buyBoxPage = new BuyBoxPage(driver);
		headerPage = new HeaderPage(driver);
		layerCartPage = new LayerCartPage(driver);
		topMenuPage = new TopMenuPage(driver);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}

	
	
	
	