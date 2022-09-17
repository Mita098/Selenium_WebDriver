package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/modal-dialogs");
		driver.findElement(By.xpath("//*[@id= 'modalWrapper']/div/button[2]")).click();
		boolean daLiRadi = true;
		try {
			driver.findElement(By.id("closeLargeModal"));
		}catch(NoSuchElementException error) {
			daLiRadi = false;
		}
		
		if (daLiRadi) {
			System.out.println("Lagre dugme radi i poruka se ispisuje na ekranu");
		}else {
			System.out.println("Lagre dugme ne radi");

		}
		Thread.sleep(5000);
		driver.quit();
	}

}
