package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TShirtPage {

	private WebDriver driver;
	Actions action;
	private Wait<WebDriver> wait;

	// Selectors
	By text_product_name = By.xpath("//h5[@itemprop='name']//a");
	By shirt_Item = By.cssSelector(".replace-2x.img-responsive");
	By btn_addToCart = By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default");

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
		WebElement textOroductName = driver.findElement(text_product_name);
		wait.until(ExpectedConditions.visibilityOf(textOroductName));
		textOroductName.sendKeys(Keys.DOWN);

		//WebElement shirtItem = driver.findElement(shirt_Item);
		action.moveToElement(textOroductName).build().perform();

		WebElement addCart = driver.findElement(btn_addToCart);
		wait.until(ExpectedConditions.visibilityOf(addCart));
		addCart.click();
	}
}
