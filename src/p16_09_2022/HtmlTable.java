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
	public List<WebElement> getColumnsByName(String naslov) {
		List <WebElement> th = 
				webelement.findElements(By.xpath("//table[contains(@class, 'searchable sortable')]//th"));
		List<WebElement> telo=
				webelement.findElements(By.xpath("//table[contains(@class, 'searchable sortable')]//tr"));
		List<WebElement> kolone = new ArrayList<WebElement>();
		for (int i = 0; i < th.size(); i++) {
			int x = 0;
			x = x + i + 1;
			if (naslov.equals(th.get(i).getText())) {
				for (int j = 1; j < telo.size(); j++) {
//					if (i > 0) {
						kolone.add(webelement.findElement(By.xpath("//table[contains(@class, 'searchable sortable')]//tr[" + j + "]/td[" + x + "]")));

//					}else {
//					kolone.add(webelement.findElement(By.xpath("//table[contains(@class, 'searchable sortable')]//tr[" + j + "]/td")));
//					}
				}
			}
		}
		return kolone;
			
		
	}
}
