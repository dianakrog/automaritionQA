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

public class MyAccountPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	// Selectors
	@FindBy(xpath = "(//a[contains(text(),'T-shirts')])[2]")
	WebElement tabShirt;

	public MyAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Select tab T-Shirt actions
	 */
	public void selectTabTShirt() {

		// Select tab t-shirt
		wait.until(ExpectedConditions.visibilityOf(tabShirt));
		tabShirt.click();

	}

}
