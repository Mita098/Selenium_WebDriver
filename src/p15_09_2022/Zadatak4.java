package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://cms.demo.katalon.com/");
		driver.manage().window().maximize();
		
		WebElement menu =	driver.findElement(By.className("menu-toggle"));
		if (menu.isDisplayed()) {
			System.out.println("Element je vidljiv");
		}else {
			System.out.println("Element je nevidljiv");
		}
		Thread.sleep(2000);
		driver.manage().window().setSize(new Dimension(700,700));
		if (menu.isDisplayed()) {
			System.out.println("Element je vidljiv");
		}else {
			System.out.println("Element je nevidljiv");
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
