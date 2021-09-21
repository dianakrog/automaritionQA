package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;
	
	@FindBy(name = "email")
	WebElement inputUser;
	
	@FindBy(name = "passwd")
	WebElement inputPassword;
	
	@FindBy(css = "#SubmitLogin > span")
	WebElement btnSendLogin;

	/**
	 * 
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * User login actions
	 */
	public void loginValidUser(String user, String password) {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(inputUser));
		inputUser.sendKeys(user);

		wait.until(ExpectedConditions.visibilityOf(inputPassword));
		inputPassword.sendKeys(password);

		wait.until(ExpectedConditions.visibilityOf(btnSendLogin));
		btnSendLogin.click();

	}

}
