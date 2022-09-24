package domaci_zadatak_20_09_2022_PAGES;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public HeaderPage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	public WebElement getShopPhoneElement() {
		return driver.findElement(By.xpath("//*[contains(@class, 'shop-phone')]//strong"));
	}
	public WebElement getContactUsLink() {
		return driver.findElement(By.xpath("//*[@id='contact-link']/a"));
	}
	public WebElement getSingInLink() {
		return driver.findElement(By.className("login"));
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public boolean getVisibilityOfPhoneNumber() {
		try {
			  WebElement t = driver.findElement(By.xpath("//*[contains(@class, 'shop-phone')]//strong"));
			  
			  if (t.isDisplayed()){
	               return true;
	         }else {
	        	 return false;
	         }
		}
	      catch(NoSuchElementException n) {
	    	  return false;
	      }
	}
}
