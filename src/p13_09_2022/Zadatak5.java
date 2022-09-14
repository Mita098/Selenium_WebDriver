package p13_09_2022;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/z80en");
		
		List<WebElement> pejdzevi = new ArrayList<WebElement>();
		pejdzevi=
		driver.findElements(By.xpath("//*[@id ='lorem']//tbody//td[1]"));
		for (int i = 0; i < pejdzevi.size(); i++) {
			System.out.println(pejdzevi.get(i).getText());
			Thread.sleep(1000);
		}
		pejdzevi =
				driver.findElements(By.xpath("//*[@id ='lorem']//tbody//tr[1]/td"));
		for (int i = 0; i < pejdzevi.size(); i++) {
			System.out.println(pejdzevi.get(i).getText());

		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
