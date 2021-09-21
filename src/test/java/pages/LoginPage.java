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

public class LoginPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	By input_User = By.name("email");
	By input_Password = By.name("passwd");
	By btn_SendLogin = By.cssSelector("#SubmitLogin > span");

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

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement inputUser = driver.findElement(input_User);
		wait.until(ExpectedConditions.visibilityOf(inputUser));
		inputUser.sendKeys(user);

		WebElement inputPassword = driver.findElement(input_Password);
		wait.until(ExpectedConditions.visibilityOf(inputPassword));
		inputPassword.sendKeys(password);

		WebElement btnSendLogin = driver.findElement(btn_SendLogin);
		wait.until(ExpectedConditions.visibilityOf(btnSendLogin));
		btnSendLogin.click();

	}

}
