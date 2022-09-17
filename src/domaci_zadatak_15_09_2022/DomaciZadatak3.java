package domaci_zadatak_15_09_2022;

import java.time.Duration; 



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;


public class DomaciZadatak3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://seeds.sproutsocial.com/components/loader-button/");
		   WebElement target = driver.findElement(By.xpath("//*[contains(@class, 'CodeSandbox__Container-sc-9lhwa5-0 dzITGt')]"));
		   WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(target);
	        new Actions(driver)
	                .scrollFromOrigin(scrollOrigin, 0, 300)
	                .perform();
			driver.findElement(By.xpath("//*[text()='Click me to load!']")).click();
	      
			
				driver.findElement(By.xpath("//button[@data-qa-button-isloading= 'false']"));
				System.out.println("Dugme je klikljivo!");
			

		Thread.sleep(5000);
		driver.quit();
	}
//	Napisati program koji 
//	Ucitava https://seeds.sproutsocial.com/components/loader-button/
//	Odskrola do Loader buttons are used to display a loading indicator inside of a button. paragrafa. Koristan link
//	Klikce ne dugme 
//	Ceka da dugme zavrsi sa loadingom 
//	Ispisati poruku na ekranu
//	Zatvoriti pretrazivac
//	HINT: Koristite data-qa-button-isloading  atribut elementa za cekanje odredjenog stanja tog elementa

}
