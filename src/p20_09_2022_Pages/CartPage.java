package p20_09_2022_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public CartPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	} 
	
	public List<WebElement> getNumberOfProductsInCart() {
	 List<WebElement> elementi = driver.findElements(By.className("cart_item"));
	 return elementi;
	}
	public WebElement getRemoveButton(int row) {
		return driver.findElement(By.xpath("//*[contains(@class, 'shop_table')]/tbody/tr[" + row + "]/td/a"));
	}
	public WebElement getCouponInput() {
		return driver.findElement(By.id("coupon_code"));
	}
	public WebElement getApplyCouponButton() {
		return driver.findElement(By.xpath("//*[@name='apply_coupon']"));
	}
	public List<WebElement> getTableRows() {
		return driver.findElement(By.className("shop_table"))
				.findElement(By.tagName("tbody"))
				.findElements(By.tagName("tr"));	
				
	}
	public void waitForEmptyCartMassageToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("cart-empty")));
	}
	
}
