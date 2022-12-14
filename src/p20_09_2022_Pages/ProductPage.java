package p20_09_2022_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	} 
	public WebElement getQuantityInput() {
		return driver.findElement(By.xpath("//*[@name='quantity']"));
	}
	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[@name='add-to-cart']"));
	}
	public WebElement getAddToCartMassage() {
		return driver.findElement(By.className("woocommerce-message"));
	}
	
}
