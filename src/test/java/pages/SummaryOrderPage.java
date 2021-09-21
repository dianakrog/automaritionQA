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

public class SummaryOrderPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	// Selectors
	@FindBy(css = ".button.btn.btn-default.standard-checkout.button-medium")
	WebElement btnProceedSummary;

	public SummaryOrderPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Execute btn Proceed to checkout in page SHOPPING-CART SUMMARY
	 */
	public void proceedSummary() {

		wait.until(ExpectedConditions.visibilityOf(btnProceedSummary));
		btnProceedSummary.click();

	}

}
