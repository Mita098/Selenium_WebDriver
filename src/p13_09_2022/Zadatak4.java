package p13_09_2022;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/oV91g");
		
		List<WebElement> pejdzevi = new ArrayList<WebElement>();
		pejdzevi=
		driver.findElements(By.xpath("//*[contains(@class, 'page_link')]"));
		for (int i = 0; i < pejdzevi.size(); i++) {
			pejdzevi.get(i).click();
			Thread.sleep(1000);
		}
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
