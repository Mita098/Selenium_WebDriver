package p20_09_2022_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}



	public WebElement getCartLink() {
		return driver.findElement(By.xpath("//*[@id='primary-menu']//li[1]/a"));
	}
	public WebElement getCheckoutLink() {
		return driver.findElement(By.xpath("//*[@id='primary-menu']//li[2]/a"));
	}
	public WebElement getMyAccountLink() {
		return driver.findElement(By.xpath("//*[@id='primary-menu']//li[3]/a"));
	}
	public WebElement getSamplePageLink() {
		return driver.findElement(By.xpath("//*[@id='primary-menu']//li[4]/a"));
	}
	public WebElement getShopLink() {
		return driver.findElement(By.xpath("//*[@id='primary-menu']//li[5]/a"));
	}
}
