package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedPage {
	
	@FindBy(xpath="//nav[1]/a[1]/span[@data-search-type='Repositories']")
	public static WebElement resultLabel;
	
	@FindBy(xpath="//div/ul[@class='repo-list']")
	public static WebElement repositoryList;
	
	@FindBy(xpath="//div[contains(@class, 'repo-list-item')]")
	public static List<WebElement> repositories;
	
	@FindBy(xpath="//div[1]/h3/a/em[text()='Hygieia']")
	public static WebElement hygieiaLink;
	
	public String resultText() {
		return resultLabel.getText();
	}
	
	public int noOfRepo() {
		return repositories.size();
	}
	
	public void goToLink() {
		hygieiaLink.click();
	}
}
