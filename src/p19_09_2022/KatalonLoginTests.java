package p19_09_2022;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KatalonLoginTests {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";
	
	@BeforeClass 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@Test (priority = 100)
	public void VisitLoginPageFromNavBar() {

		driver.findElement(By.xpath("//*[contains(@class, ' nav-menu')]/li[3]/a")).click();
		
		
		String expecetedTitle = "My account – Katalon Shop";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expecetedTitle, "ERROR: Unexpected title.");
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "/my-account";
		Assert.assertTrue(actualUrl.contains(expectedUrl), "ERROR: Url should contain /my-account");
		
	}
	
	@Test (priority = 200)
	public void CheckInputTypes() {
		driver.get(baseUrl + "/my-account");
		String actualType = driver.findElement(By.id("username")).getAttribute("type");
		String expectedType = "text";
		Assert.assertEquals(actualType, expectedType,"ERROR: Email input field does not contain type-text attribute!");
		
		actualType = driver.findElement(By.id("password")).getAttribute("type");
		expectedType = "password";
		Assert.assertEquals(actualType, expectedType,"ERROR: Password input field does not contain type-password attribute!");
		
		actualType = driver.findElement(By.id("rememberme")).getAttribute("type");
		expectedType = "checkbox";
		Assert.assertEquals(actualType, expectedType,"ERROR: Checkbox field does not contain type-checkbox attribute!");
		
		boolean actual = driver.findElement(By.id("rememberme")).isSelected();
		boolean expected = false;
		Assert.assertEquals(actual, expected,"ERROR:Checkbox field should not be checked");
	}
	
	@Test (priority = 300)
	public void DisplayErrorWhenCredentialsAreWrog() throws InterruptedException {
		driver.get(baseUrl + "/my-account");
		driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
		driver.findElement(By.id("password")).sendKeys("invalid123");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		boolean exists = driver.findElements( By.xpath("//*[contains(@class, 'woocommerce-error')]/li")).size() != 0;
		
		Assert.assertTrue(exists, "ERROR:Element displaying error should exist!");
		
		String actual = driver.findElement(By.xpath("//*[text()='ERROR']")).getText();
		String expected = "ERROR: Invalid email address";
		Assert.assertEquals(actual, expected, "ERROR:Error massage should apper");
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "/my-account";
		Assert.assertTrue(actualUrl.contains(expectedUrl), "ERROR: Url should contain /my-account");
		
		Thread.sleep(5000);
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
