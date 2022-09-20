package domaci_zadatak_19_09_2022;


import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapTableTests {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://s.bootsnipp.com\r\n";

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

	@Test(priority = 100)
	public void editRow() throws InterruptedException {

		String fName = "Dimitrije";
		String lName = "Stojanovic";
		String mName = "Jovan";

		driver.get(baseUrl + "/iframe/K5yrx\r\n");
		String actual = driver.getTitle();
		String expected = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actual, expected,
				"ERROR: Title of page should be 'Table with Edit and Update Data - Bootsnipp.com'");

		driver.findElement(By.xpath("//tbody/tr/td[5]/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit")));
		driver.findElement(By.xpath("//input[1]")).clear();
		driver.findElement(By.xpath("//input[1]")).sendKeys(fName);
		driver.findElement(By.xpath("//input[2]")).clear();
		driver.findElement(By.xpath("//input[2]")).sendKeys(lName);
		driver.findElement(By.xpath("//input[3]")).clear();
		driver.findElement(By.xpath("//input[3]")).sendKeys(mName);
		driver.findElement(By.id("up")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit")));
		actual = driver.findElement(By.id("f1")).getText();
		expected = fName;
		Assert.assertEquals(actual, expected, "ERROR: First name did not match expected first name!");
		actual = driver.findElement(By.id("l1")).getText();
		expected = lName;
		Assert.assertEquals(actual, expected, "ERROR: Last name did not match expected last name!");
		actual = driver.findElement(By.id("m1")).getText();
		expected = mName;
		Assert.assertEquals(actual, expected, "ERROR: Middle name did not match expected middle name!");

	}

	@Test (priority = 200)
	public void deleteRow() {
		driver.get(baseUrl + "/iframe/K5yrx\r\n");
		String actual = driver.getTitle();
		String expected = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actual, expected,
				"ERROR: Title of page should be 'Table with Edit and Update Data - Bootsnipp.com'");
		
		driver.findElement(By.xpath("//tbody/tr/td[6]/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete")));
		int before = driver.findElements(By.xpath("//tbody")).size() + 1;
		driver.findElement(By.id("del")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delete")));
		int actualRows = driver.findElements(By.xpath("//tbody")).size() + 1;
		int expectedRows = before - 1;
		Assert.assertEquals(actualRows, expectedRows,"ERROR:Table should contain one row less!");
	}
	@Test (priority = 300)
	public void takeAScreenshot() throws IOException {
		driver.get(baseUrl + "/iframe/K5yrx\r\n");
		String actual = driver.getTitle();
		String expected = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actual, expected,
				"ERROR: Title of page should be 'Table with Edit and Update Data - Bootsnipp.com'");
		
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\PC\\eclipse-workspace\\Selenium_WebDriver\\slike\\Screenshot.png");
		FileHandler.copy(srcFile, destFile);
		 
	
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
