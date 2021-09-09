package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class searchSteps {

	WebDriver driver;
	
	WebDriverManager wdmC = WebDriverManager.chromedriver();
	WebDriverManager wdmF = WebDriverManager.firefoxdriver();
	

	@Given("{string} is open")
	public void browser_is_open(String browser) {

		//String projectPath = System.getProperty("user.dir");

		switch (browser) {
		case "chrome":
			
			 ChromeOptions optionsC = new ChromeOptions();

			//System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
			//driver = new ChromeDriver();
			driver = wdmC.capabilities(optionsC).create();
			break;

		case "firefox":
			
			FirefoxOptions optionsF = new FirefoxOptions();
			//System.setProperty("webdriver.gecko.driver", projectPath + "/src/test/resources/drivers/geckodriver.exe");
			//driver = new FirefoxDriver();
			driver = wdmF.capabilities(optionsF).create();
			break;

		}

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Then("user see the results")
	public void user_see_the_results() {

		driver.getPageSource().contains("LTAutomation - Process Automation Experts");

	}

	@After
	public void quit() {

		driver.quit();

	}

}
