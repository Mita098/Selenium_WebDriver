package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://crop-circle.imageonline.co/#circlecropresult");
		driver.findElement(By.xpath("//*[@type= 'file']")).sendKeys("C:\\Users\\PC\\Desktop\\Screenshot_4.png");
        new Actions(driver)
                .scrollToElement(driver.findElement(By.xpath("//*[text()='Check out the crop circle tool demo here']")))
                .perform();
        
        driver.findElement(By.id("photobutton")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
