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

public class AddressPage {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	// Selectors
	By btn_ProceedAddress = By.cssSelector("#center_column > form > p > button");

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

		WebElement btnProceedAddress = driver.findElement(btn_ProceedAddress);
		wait.until(ExpectedConditions.visibilityOf(btnProceedAddress));
		btnProceedAddress.click();
	}

}
