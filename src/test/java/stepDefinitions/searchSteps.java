package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class searchSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {

		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@And("go to google page")
	public void go_to_google_page() {

		driver.navigate().to("https://www.google.com");

	}

	@When("user send word to search")
	public void user_send_automation_to_search() {

		driver.findElement(By.name("q")).sendKeys("automation");
	}

	@And("execute enter key")
	public void execute_enter_key() {

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user see the results")
	public void user_see_the_results() {

		driver.getPageSource().contains("Automatización industrial - Wikipedia, la enciclopedia libre");

	}

	@After
	public void quit() {

		driver.close();
		driver.quit();

	}

}
