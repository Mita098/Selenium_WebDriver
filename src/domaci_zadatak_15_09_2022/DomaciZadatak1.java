package domaci_zadatak_15_09_2022;

import java.time.Duration; 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DomaciZadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		boolean gasi = true;		
//						BRISANJE ODOZGO
		while(gasi) {
			try {
				driver.findElement(By.className("close")).click();
			}catch(NoSuchElementException error) {
				gasi = false;
			}
			if (gasi) {
				System.out.println("Element obrisan");
			}else {
				System.out.println("Nema vise elemenata za brisanje");
			}
			Thread.sleep(2000);
		}
		
//							BRISANJE ODOZDO
//		List<WebElement> elementi = 
//		driver.findElements(By.xpath("//*[contains(@class, 'close')]"));
//		for (int i = elementi.size(); i > 0; i--) {
//			elementi.get(i-1).click();
//			System.out.println("Element obrisan!");
//			Thread.sleep(2000);
//		}
//		System.out.println("Nema vise elemenata za brisanje!");
		Thread.sleep(5000);
		driver.quit();
	}

	
//	.Zad
//	Napisati program koji:
//	Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//	Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//	POMOC: Brisite elemente odozdo.
//	(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

}
