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

public class AddressPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	// Selectors
	@FindBy(css = "#center_column > form > p > button")
	WebElement btnProceedAddress;

	public AddressPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Execute btn Proceed to checkout in page ADDRESSES
	 */
	public void proceedAddress() {

		wait.until(ExpectedConditions.visibilityOf(btnProceedAddress));
		btnProceedAddress.click();
	}

}
