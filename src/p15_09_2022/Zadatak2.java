package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
//		driver.findElement(By.xpath("//*[@name= '_sacat']//*[@value= '14339']"))
		Select kategorije = new Select(driver.findElement(By.xpath("//*[@name= '_sacat']")));
		kategorije.selectByVisibleText("Crafts");
		Thread.sleep(5000);
		driver.quit();
	}

}
