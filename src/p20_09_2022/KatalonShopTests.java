package p20_09_2022;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import p20_09_2022_Pages.CartPage;
import p20_09_2022_Pages.LogInPage;
import p20_09_2022_Pages.NavPage;
import p20_09_2022_Pages.ProductPage;

public class KatalonShopTests {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";
	private NavPage navPage;
	private CartPage cartPage;
	private ProductPage productPage;
	private LogInPage login;

	

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		navPage = new NavPage(driver, wait);
		cartPage = new CartPage(driver, wait);
		productPage = new ProductPage(driver, wait);
		login = new LogInPage(driver, wait);

		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@Test(priority = 10)
	public void addingProductWithQuantityToTheCart() {
		driver.get(baseUrl+"/product/flying-ninja/");
		productPage.getQuantityInput().sendKeys("3");
		productPage.getAddToCartButton().click();
		String actualM = productPage.getAddToCartMassage().getText();
		Assert.assertTrue(actualM.contains("“Flying Ninja”"), "Error: Add to cart massage should contain “Flying Ninja”");
		navPage.getCartLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Error: Cart page url should contain '/cart'");
		Assert.assertEquals(cartPage.getNumberOfProductsInCart().size(), 1,"Error: Cart should contain only one item");
	}

	@Test (priority = 20)
	public void removingProductFromCart() throws InterruptedException {
		navPage.getCartLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Error: Cart page url should contain '/cart'");
		Assert.assertEquals(cartPage.getNumberOfProductsInCart().size(), 1,"Error: Cart should contain only one item");
		cartPage.getRemoveButton(1).click();
		cartPage.waitForEmptyCartMassageToBeVisible();
		Assert.assertEquals(cartPage.getNumberOfProductsInCart().size(), 0,"Error: Cart should contain no items");
	}
	@Test (priority = 30)
	public void verifyErrorIsDisplayedWhenUsernameIsMissing()  {
		navPage.getMyAccountLink().click();
		login.getLoginButton().click();
		
		Assert.assertEquals(login.getErrorMassage().getText(),"Error: Username is required.", "Error:Username is required massage should apeer");
	}
	@Test (priority = 40)
	public void verifyErrorIsDisplayedWhenPasswordIsMissing()  {
		navPage.getMyAccountLink().click();
		login.getUsernameInput().sendKeys("customer");
		login.getLoginButton().click();
		Assert.assertEquals(login.getErrorPasswordMassage().getText(),"ERROR: The password field is empty.", "'ERROR: The password field is empty' massage should apeer");
	}
	@Test (priority = 50)
	public void verifyErrorIsDisplayedWhenPasswordIsWrong()  {
		navPage.getMyAccountLink().click();
		login.getUsernameInput().sendKeys("customer");
		login.getPasswprdInput().sendKeys("invalidpassword");
		login.getLoginButton().click();
		Assert.assertEquals(login.getInvalidPasswordMassage().getText(),
				"ERROR: The password you entered for the username customer is incorrect. Lost your password?",
				"Error: Wrong password error massage should apeer!");

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
