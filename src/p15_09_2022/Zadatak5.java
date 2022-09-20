package p15_09_2022;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/login");
		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		driver.findElement(By.id("password")).sendKeys("ITBootcamp2021!");
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
			boolean daLiPostoji = true;
		try {
			driver.findElement(By.id("submit"));
		}catch(NoSuchElementException error) {
			daLiPostoji = false;
		}
		
		if (daLiPostoji) {
			System.out.println("Uspesno ste se ulogovali!");
		}else {
			System.out.println("Niste se uspesno ulogovali!");
		}
		
		if (daLiPostoji) {
			driver.findElement(By.id("submit")).click();;
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
