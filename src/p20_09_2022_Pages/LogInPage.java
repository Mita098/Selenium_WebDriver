package p20_09_2022_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public LogInPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@name='login']"));
	}
	public WebElement getErrorMassage() {
		return driver.findElement(By.xpath("//*[text()=' Username is required.		']"));
	}
	public WebElement getUsernameInput() {
		return driver.findElement(By.id("username"));
	}
	public WebElement getPasswprdInput() {
		return driver.findElement(By.id("password"));
	}
	public WebElement getErrorPasswordMassage() {
		return driver.findElement(By.xpath("//*[text()=': The password field is empty.		']"));
	}
	public WebElement getInvalidPasswordMassage() {
		return driver.findElement(By.xpath("//*[text()=': The password you entered for the username ']"));
	}
	public WebElement getInvalidUsernameMassage() {
		return driver.findElement(By.xpath("//*[text()=': Invalid username. ']"));
	}
	public WebElement getSuccessfulLoginMassage() {
		return driver.findElement(By.xpath("//*[text()='Hello ']"));
	}
}
