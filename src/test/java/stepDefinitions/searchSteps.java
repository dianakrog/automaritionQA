package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.*;
import Utils.*;

public class searchSteps {
	
	public String browser="chrome";
	
	@Given("browser is open")
	public void browser_is_open(String browser) {
		getDriver.iniciarConfiguracion(browser);
		PageFactory.initElements(getDriver.driver, this);
	}

	@And("go to google page")
	public void go_to_google_page() {

		getDriver.driver.get("https://www.google.com");

	}

	@When("user send word to search")
	public void user_send_automation_to_search() {

		getDriver.driver.findElement(By.name("q")).sendKeys("automation");
	}

	@And("execute enter key")
	public void execute_enter_key() throws InterruptedException {

		getDriver.driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		TimeUnit.SECONDS.sleep(3);

	}

	@Then("user see the results")
	public void user_see_the_results() {

		getDriver.driver.getPageSource().contains("LTAutomation - Process Automation Experts");

	}

	@AfterAll
	public void quit() {

		getDriver.driver.close();
		getDriver.driver.quit();

	}

}
