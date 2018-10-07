package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepoPage {

	@FindBy(xpath="//div/span[contains(text(),'CapitalOne DevOps Dashboard')]")
	public WebElement caponeDashboard;
	
	@FindBy(xpath="//li[1]/a/span[@class='num text-emphasized']")
	public static WebElement commitedNumber;
	
	@FindBy(xpath="//li[2]/a/span[@class='num text-emphasized']")
	public static WebElement branchesNumber;
	
	@FindBy(xpath="//li[3]/a/span[@class='num text-emphasized']")
	public static WebElement releasedNumber;
	
	@FindBy(xpath="//li[4]/a/span[@class='num text-emphasized']")
	public static WebElement contributorsNumber;
	
	public int getcommitedNumber() {
		return Integer.parseInt(commitedNumber.getText().replace(",", ""));
	}
	
	public int getbranchesNumber() {
		return Integer.parseInt(branchesNumber.getText().replace(",", ""));
	}
	
	public int getreleasedNumber() {
		return Integer.parseInt(releasedNumber.getText().replace(",", ""));
	}
	
	public int getcontributorsNumber() {
		return Integer.parseInt(contributorsNumber.getText().replace(",", ""));
	}
	
}
