package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.RepoPage;
import pages.SearchedPage;
import utilities.Hooks;

public class GitTestSteps {
	
	private WebDriver driver;
	private HomePage homePage;
	private SearchedPage searchedPage;
	private RepoPage repoPage;

	public GitTestSteps() {
		this.driver = Hooks.getDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchedPage = PageFactory.initElements(driver, SearchedPage.class);
		repoPage = PageFactory.initElements(driver, RepoPage.class);
	}

	@Given("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to(String url) throws Throwable {
		driver.get(url);
	}

	@Given("^I search a text \"([^\"]*)\"$")
	public void i_search_a_text(String stext) throws Throwable {
		homePage.putSearchText(stext);
	}

	@When("^I click on the search icon$")
	public void i_click_on_the_search_icon() throws Throwable {
		homePage.runSearch();
	}

	@Then("^I see the search result$")
	public void i_see_the_search_result() throws Throwable {
		Assert.assertNotNull(searchedPage.resultText());
	}
	
	@Then("^The number of repositories should be more than \"([^\"]*)\"$")
	public void the_number_of_repositories_should_be_more_than(String repo) throws Throwable {
		Assert.assertTrue(searchedPage.noOfRepo() > Integer.parseInt(repo));
	}
	
	@When("^I click on the Hygieia link$")
	public void i_click_on_the_Hygieia_link() throws Throwable {
		searchedPage.goToLink();
		WebDriverWait wait = new WebDriverWait(driver, 30, 50);
		wait.until(ExpectedConditions.visibilityOf(repoPage.caponeDashboard));
	}

	@Then("^I navigate to the Hygieia repository$")
	public void i_navigate_to_the_Hygieia_repository() throws Throwable {
		Assert.assertEquals("GitHub - Hygieia/Hygieia: CapitalOne DevOps Dashboard", driver.getTitle());
	}

	@Then("^The number of commits is more than \"([^\"]*)\"$")
	public void the_number_of_commits_is_more_than(String comm) throws Throwable {
		Assert.assertTrue(repoPage.getcommitedNumber() > Integer.parseInt(comm));
	}

	@Then("^The number of branches is more than \"([^\"]*)\"$")
	public void the_number_of_branches_is_more_than(String bran) throws Throwable {
		Assert.assertTrue(repoPage.getbranchesNumber() > Integer.parseInt(bran));
	}
	
	@Then("^The number of release is more than or equal to \"([^\"]*)\"$")
	public void the_number_of_release_is_more_than_or_equal_to(String rel) throws Throwable {
		Assert.assertTrue(repoPage.getreleasedNumber() >= Integer.parseInt(rel));
	}

	@Then("^The number of contributors is more than \"([^\"]*)\"$")
	public void the_number_of_contributors_is_more_than(String cont) throws Throwable {
		Assert.assertTrue(repoPage.getcontributorsNumber() > Integer.parseInt(cont));
	}
}
