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

public class ShippingPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	// Selectors
	By check_Terms = By.id("uniform-cgv");
	By btn_ProceedShipping = By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium");

	public ShippingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Check agree terms
	 */
	public void agreeTerms() {

		WebElement checkTerms = driver.findElement(check_Terms);
		wait.until(ExpectedConditions.visibilityOf(checkTerms));
		checkTerms.click();

	}

	/**
	 * Execute btn Proceed to checkout in page Shipping
	 */
	public void checkoutShipping() {

		WebElement btnProceedShipping = driver.findElement(btn_ProceedShipping);
		wait.until(ExpectedConditions.visibilityOf(btnProceedShipping));
		btnProceedShipping.click();

	}

}
