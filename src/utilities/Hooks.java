package utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private static WebDriver driver;
	
	@Before
	public void beforeScenario() {
		String prjPath = System.getProperty("user.dir");
		String brPath = prjPath + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", brPath);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void afterScenario() {
		driver.close();
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
