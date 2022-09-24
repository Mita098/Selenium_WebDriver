package domaci_zadatak_20_09_2022_PAGES;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LayerCartPage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.xpath("//*[@title='Continue shopping']"));
	}

	public WebElement getProcedToCheckoutButton() {
		return driver.findElement(By.xpath("//*[@title='Proceed to checkout']"));
	}

	public WebElement getProductAtributes() {
		return driver.findElement(By.id("layer_cart_product_attributes"));
	}

	public WebElement getProductQuantity() {
		return driver.findElement(By.id("layer_cart_product_quantity"));
	}

	public WebElement getProductPrice() {
		return driver.findElement(By.id("layer_cart_product_price"));
	}

	public void waitForDialogToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
	}

	public void waitForDialogToBeInvisible() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layer_cart")));
	}

	public boolean getVerificationValue() {
		String str = driver.findElement(By.id("layer_cart_product_price")).getText();
		char[] ch = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
			if (ch[i] == '$') {
				ch[i] = '0';
			}
		}
		String str1 = String.valueOf(ch);
		double punaCena = Double.parseDouble(str1);
		String originalCena = driver.findElement(By.id("our_price_display")).getText();
		char[] originalCenaCH = new char[originalCena.length()];
		for (int i = 0; i < originalCena.length(); i++) {
			originalCenaCH[i] = originalCena.charAt(i);
			if (originalCenaCH[i] == '$') {
				originalCenaCH[i] = '0';
			}
		}
		String originalCena1 = String.valueOf(originalCenaCH);
		double original = Double.parseDouble(originalCena1);
		String quantiti = driver.findElement(By.id("layer_cart_product_quantity")).getText();
		double quantity = Double.parseDouble(quantiti);
		if (punaCena / quantity == original) {
			return true;
		} else {
			return false;
		}


	}
}
