package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import Utils.*;

public class SearchSteps {

	public WebDriver driver = BrowserManager.startConfig();

	@Given("browser is open")
	public void browser_is_open() {
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
	}

	@And("go to google page")
	public void go_to_google_page() {

		driver.get("https://www.google.com");

	}

	@When("user send word to search")
	public void user_send_automation_to_search() {

		driver.findElement(By.name("q")).sendKeys("automation");
	}

	@And("execute enter key")
	public void execute_enter_key() {

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	@Then("user see the results")
	public void user_see_the_results() throws InterruptedException {

		TimeUnit.SECONDS.sleep(4);
		driver.getPageSource().contains("LTAutomation - Process Automation Experts");

	}
	
	@After
	public void quit() {

		driver.close();

	}

}
