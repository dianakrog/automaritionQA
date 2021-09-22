package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TShirtPage {

	private WebDriver driver;
	Actions action;
	private Wait<WebDriver> wait;

	// Selectors
	@FindBy(xpath = "//h5[@itemprop='name']//a")
	private WebElement textOroductName;
	
	@FindBy(css = ".button.ajax_add_to_cart_button.btn.btn-default")
	private WebElement addCart;

	public TShirtPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Add product to cart actions
	 */
	public void addToCartProduct() {

		// Execute Add to car Faded Short Sleeve T-shirts
		
		wait.until(ExpectedConditions.visibilityOf(textOroductName));
		textOroductName.sendKeys(Keys.DOWN);
		action.moveToElement(textOroductName).build().perform();

		wait.until(ExpectedConditions.visibilityOf(addCart));
		addCart.click();
	}
}
