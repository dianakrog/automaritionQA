package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class IndexPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	// Selectors
	By btn_SignIn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");

	/**
	 * 
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Open an maximize page http://automationpractice.com/
	 */
	public void openPage() {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	/**
	 * Action to access page login
	 */
	public void goSignIn() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement btnSingIn = driver.findElement(btn_SignIn);
		wait.until(ExpectedConditions.visibilityOf(btnSingIn));
		btnSingIn.click();

	}

}
