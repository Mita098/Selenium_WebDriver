package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/");
		WebElement tabla =
				driver.findElement(By.xpath("//table"));
		HtmlTable table = new HtmlTable(tabla);
		System.out.println(table.getCellText(3, 1));
		table.getColumnsByName("Athlete");
		for (int i = 0; i < table.getColumnsByName("Athlete").size(); i++) {
			System.out.println(table.getColumnsByName("Athlete").get(i).getText());
		}
		
		Thread.sleep(5000);
		driver.quit();

	}

}
