package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://docs.katalon.com/");
		WebElement pregledHTML=
		driver.findElement(By.xpath("/html"));
		if (pregledHTML.getAttribute("data-theme").equals("light")) {
			System.out.println("Tema sajta je light!");
		}else {
			System.out.println("Tema sajta se nije promenila");
		}
	    
	    driver.findElement(By.xpath("//*[contains(@class, 'toggleButton_rCf9')]")).click();
		if (pregledHTML.getAttribute("data-theme").equals("dark")) {
			System.out.println("Tema sajta je crna!");
		}else {
			System.out.println("Tema sajta se nije promenila");
		}
		 new Actions(driver)
         .keyDown(Keys.CONTROL)
         .sendKeys("k")
         .perform();
		 
		 WebElement pregledInputa=
					driver.findElement(By.id("docsearch-input"));
		if (pregledInputa.getAttribute("type").equals("search")) {
			System.out.println("Tip inputa jeste search");
		}else {
			System.out.println("Tip inputa nije search");
		}
		Thread.sleep(5000);
		driver.quit();

	}

}
