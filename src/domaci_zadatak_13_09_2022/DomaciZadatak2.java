package domaci_zadatak_13_09_2022;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DomaciZadatak2 {

	public static void main(String[] args) throws InterruptedException {
		Scanner s = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/WaXlr");
		List<WebElement> dugmici =
		driver.findElements(By.xpath("//*[contains(@id, 'rating-star-')]"));
		System.out.println("Unesite broj zvezdica: ");
		int zvezdica = s.nextInt();
		for (int i = 0; i < dugmici.size(); i++) {
			if(i + 1 == zvezdica) {
				dugmici.get(i).click();
			}
		}
		
		
		Thread.sleep(5000);
		driver.quit();
	}

//	Zadatak 
//	Maksimizirati prozor
//	Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//	Dohvatite dugmice za rejting kao listu. XPath za trazenje treba da bude preko id atributa i za ovo trebace vam contains u xpath-u
//	Od korisnika ucitati broj (preko scannera) na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//	I izvrsite akciju klik na odgovarajuci element preko indeksa
//	Na kraju programa ugasite pretrazivac.

}
