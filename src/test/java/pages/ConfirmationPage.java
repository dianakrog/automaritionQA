package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ConfirmationPage {
	
	private WebDriver driver;
	private Wait<WebDriver> wait;
	
	@FindBy(css = "#center_column > div > p")
	private WebElement textConfirm;

	// Selectors

	public ConfirmationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Valid ORDER CONFIRMATION
	 */
	public void orderCobfirmation() {
		
		wait.until(ExpectedConditions.titleContains("Order confirmation - My Store"));
		Assertions.assertEquals("Your order on My Store is complete.", textConfirm.getText());
	}

}
