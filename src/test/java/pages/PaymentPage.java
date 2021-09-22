package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PaymentPage {
	
	private WebDriver driver;
	private Wait<WebDriver> wait;

	// Selectors
	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	private WebElement opcPayByBank;
	
	@FindBy(css = "#cart_navigation > button")
	private WebElement btnConfirmPayment;
	
	public PaymentPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Select and Confirm Payment
	 */
	public void selectPaBankWire() {
		
		// Select Payment by bank wire
		
		wait.until(ExpectedConditions.visibilityOf(opcPayByBank));
		opcPayByBank.click();

		// Confirm Payment
		
		wait.until(ExpectedConditions.visibilityOf(btnConfirmPayment));
		btnConfirmPayment.click();

	
	}

}
