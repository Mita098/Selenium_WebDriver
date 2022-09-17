package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Select s = new Select(driver.findElement(By.name("_sacat")));
		List<WebElement>elementi = s.getOptions();
//		for (int i = 0; i < elementi.size(); i++) {
//			String opcije = elementi.get(i).getText();
//			System.out.println(opcije);
//		}
		Random br = new Random();
		int random = br.nextInt(elementi.size());
//		elementi.get(random).click();
		s.selectByIndex(random);
		Thread.sleep(5000);
		driver.quit();
	}

}
