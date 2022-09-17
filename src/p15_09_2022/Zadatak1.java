package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cms.demo.katalon.com/my-account/");
		
		driver.findElement(By.name("rememberme")).click();
		System.out.println(	driver.findElement(By.name("rememberme")).isSelected());

		Thread.sleep(5000);
		driver.quit();
	}

}
