package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.*;
import Utils.*;

public class searchSteps {
	
	public WebDriver driver = BrowserManager.startConfig();

	@Given("browser is open")
	public void browser_is_open() throws Exception {
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
	}

	@And("go to google page")
	public void go_to_google_page() throws Exception {

		driver.get("https://www.google.com");

	}

	@When("user send word to search")
	public void user_send_automation_to_search() throws Exception {

		driver.findElement(By.name("q")).sendKeys("automation");
	}

	@And("execute enter key")
	public void execute_enter_key() throws Exception {

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	@Then("user see the results")
	public void user_see_the_results() throws Exception {

		driver.getPageSource().contains("LTAutomation - Process Automation Experts");

	}

	@AfterAll
	public void quit() throws Exception {

		driver.close();
		driver.quit();

	}

}
