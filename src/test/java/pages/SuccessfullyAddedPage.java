package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SuccessfullyAddedPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	// Selectors
	By btn_ProceedCheckout = By.cssSelector(".btn.btn-default.button.button-medium");

	public SuccessfullyAddedPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Execute btn Proceed to checkout in message Product successfully added
	 * shopping cart
	 */
	public void proceedCheckout() {

		WebElement btnProceedCheckout = driver.findElement(btn_ProceedCheckout);
		wait.until(ExpectedConditions.visibilityOf(btnProceedCheckout));
		btnProceedCheckout.click();

	}

}
