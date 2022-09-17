package p16_09_2022;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HtmlTable {
	private WebElement webelement;

	public HtmlTable(WebElement webelement) {
		super();
		this.webelement = webelement;
	}
	public String getCellText(int row,int cell) {
				
		WebElement x = 
		webelement.findElement(By.xpath("//tr[" + row + "]/td[" + cell + "]"));
		return x.getText();
	}
//	public WebElement getColumnsByName(String naslov) {
//		List <WebElement> elementi = new ArrayList<WebElement>();
//		List <WebElement> elementiZaVracanje = new ArrayList<WebElement>();
//
//		elementi =
//				this.webelement.findElements(By.xpath("//table"));
//		for (int i = 0; i < elementi.size(); i++) {
//			if (elementi.get(i).getText().equals(naslov)) {
//				for (int j = 0; j < elementi.size(); j++) {
//					
//				}
//			}
//		}
//	}
}
