package p19_09_2022;

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

public class UvodUTestNg {

	private WebDriver driver;
	private WebDriverWait wait;

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
		driver.get("https://www.google.com/");
	}

	
	@Test (priority = 20)
	public void test2() {

		String actualTitle = driver.getTitle();
		String expecetedTitle = "Google";

		Assert.assertEquals(actualTitle, expecetedTitle, "ERROR: Unexpected title.");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
