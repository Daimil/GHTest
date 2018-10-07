package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	final WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath="//form/label/input[@name='q']")
	public static WebElement searchBox;
	
	@FindBy(css="#jump-to-suggestion-search-global > a:nth-child(1) > div:nth-child(1) > svg:nth-child(3)")
	public static WebElement searchButton;
	
	public void putSearchText(String stext) throws InterruptedException {
		searchBox.sendKeys(stext);
		Thread.sleep(1000);
	}
	
	public void runSearch() {
		Actions action = new Actions(driver);
		action.click(searchButton).build().perform();
	}
}
