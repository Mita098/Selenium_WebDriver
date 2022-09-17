package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.get("file:///C:/Users/PC/Downloads/Zadatak6.html");
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.id("showInBtn")).click();;
			driver.findElement(By.xpath("//*[contains(@id, 'id-"+ i +"')]"));
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
