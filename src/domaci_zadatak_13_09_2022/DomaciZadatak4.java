package domaci_zadatak_13_09_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DomaciZadatak4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");
		Scanner s = new Scanner(System.in);
		System.out.println("Unesite formulu: ");
		String formula = s.next();
		List<Character> chars = new ArrayList<>();
		for (char ch : formula.toCharArray()) {  
            chars.add(ch);
        }
		
		for (int i = 0; i < chars.size(); i++) {
			if (chars.get(i).equals('-')) {
				chars.set(i, '−');
			}
			if (chars.get(i).equals('/')) {
				chars.set(i, '÷');
			}
			if (chars.get(i).equals('*')) {
				chars.set(i, '×');
			}
			driver.findElement(By.xpath("//*[@id= 'calculator']//div//*[@value ='" + chars.get(i) + "']")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(5000);
		driver.quit();
	}
		
//	.Zadatak (Za vezbanje)
//	Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
//	Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
//	Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
//	1243+329=
//	21912-4=
//	12913÷4=
//	U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere. Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
//	Zatim u odnosu na karakter uradite odredjenu logiku

}
