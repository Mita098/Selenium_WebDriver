package domaci_zadatak_16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DomaciZadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		driver.manage().window().maximize();
		File slika1 = new File("slike/Front_Dimitrije_Stojanovic.png");
		File slika2 = new File("slike/left_Dimitrije_Stojanovic.png");
		File slika3 = new File("slike/back_Dimitrije_Stojanovic.png");
		File slika4 = new File("slike/right_Dimitrije_Stojanovic.png");
		for (int i = 1; i < 5; i++) {
			File slika = null;
			if (i==1) {
				slika = slika1;
			}else if(i==2) {
				slika = slika2;
			}else if(i==3) {
				slika = slika3;
			}else if(i==4) {
				slika = slika4;
			}
			driver.findElement(By.xpath("//*[@alt= 'image "+ i + "']")).click();
			driver.findElement(By.xpath("//*[contains(text(),'+ Add photo')]")).click();
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(slika.getAbsolutePath());
			Thread.sleep(1000);
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[@loading='lazy']"), i));
			driver.findElement(By.xpath("//img[@loading='lazy']")).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Use One Side Only']")));
			driver.findElement(By.xpath("//*[text()='Use One Side Only']")).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Done']")));
			driver.findElement(By.xpath("//*[text()='Done']")).click();
			Thread.sleep(1000);	
		}
			Random random = new Random();
			int x = random.nextInt(0,4);
			driver.findElement(By.xpath("//*[@name='"+ x +"']")).click();
			Thread.sleep(1000);	
			driver.findElement(By.xpath("//*[text()='Add to cart ']")).click();
			Thread.sleep(1000);	
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //*[@action='error']")));
			System.out.println("Greska je izlozena!");
		Thread.sleep(5000);
		driver.quit();

	}
//	Zadatak
//	Napisati program koji ima:
//	Podesava:
//	implicitno cekanje za trazenje elemenata od 10s
//	implicitno cekanje za ucitavanje stranice od 10s
//	eksplicitno cekanje podeseno na 10s
//	Podaci:
//	Potrebno je u projektu ukljuciti 4 slike.
//	Imenovanje slika neka bude po pravilu pozicija_ime_prezime_polaznika.ekstenzija
//	Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
//	Koraci:
//	Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//	Maksimizuje prozor
//	Selektuje Image - Front klikom na tu karticu u dnu ekrana
//	Klik na add photo iz levog navigacionog menia
//	Upload slike. Upload preko File objekta koristeci getAbsolutePath
//	Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
//	Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljanje
//	Ceka da dijalog bude vidljiv
//	Klik na Use One Side Only dugme
//	Ceka da se pojavi dijalog sa slikom
//	Klik na Done
//	Ponoviti proces za Left, Right i Back
//	Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
//	Kliknuti na Add To Cart dugme
//	Verifikovati postojanje greske Oops! It looks like you`ve not added an text to this field, please add one before continuing.
//	Xpath: //*[@action='error']
//	Zatvorite pretrazivac

}
