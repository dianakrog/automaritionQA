package stepDefinitions;

import java.time.Duration;
import java.util.NoSuchElementException;

import Utils.*;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class BuyShirtSteps {

	public WebDriver driver = BrowserManager.startConfig();

	Actions action = new Actions(driver);

	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
			.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

	@Given("an existing {string} and {string} accesses to the online store")
	public void an_existing_user_accesses_to_the_online_store(String user, String password) {

		// Open Browser
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		// Login user
		WebElement btnLogin = driver
				.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		btnLogin.click();

		WebElement inputUser = driver.findElement(By.name("email"));
		wait.until(ExpectedConditions.visibilityOf(inputUser));
		inputUser.sendKeys(user);

		WebElement inputPassword = driver.findElement(By.name("passwd"));
		wait.until(ExpectedConditions.visibilityOf(inputPassword));
		inputPassword.sendKeys(password);

		WebElement btnSendLogin = driver.findElement(By.cssSelector("#SubmitLogin > span"));
		wait.until(ExpectedConditions.visibilityOf(btnSendLogin));
		btnSendLogin.click();

	}

	@When("buy a t-shirt")
	public void buy_a_t_shirt() {

		// Select tab t-shirt
		WebElement tabShirt = driver.findElement(By.xpath("(//a[contains(text(),'T-shirts')])[2]"));
		wait.until(ExpectedConditions.visibilityOf(tabShirt));
		tabShirt.click();

		// Execute Add to car Faded Short Sleeve T-shirts
		wait.until(ExpectedConditions.titleContains("T-shirts - My Store"));
		WebElement shirtItem = driver.findElement(By.xpath("//h5[@itemprop='name']//a")); 
		wait.until(ExpectedConditions.visibilityOf(shirtItem));
		
		shirtItem.sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector(".compare-form")).click();
		action.moveToElement(shirtItem).build().perform();
		

		// Execute btn Proceed to checkout in message Product successfully added
		// shopping cart
		WebElement addCart = driver.findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default"));
		wait.until(ExpectedConditions.visibilityOf(addCart));
		addCart.click();

		WebElement btnProceedCheckout = driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium"));
		wait.until(ExpectedConditions.visibilityOf(btnProceedCheckout));
		btnProceedCheckout.click();

		// Execute btn Proceed to checkout in page SHOPPING-CART SUMMARY
		WebElement btnProceedSummary = driver
				.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium"));
		wait.until(ExpectedConditions.visibilityOf(btnProceedSummary));
		btnProceedSummary.click();

		// Execute btn Proceed to checkout in page ADDRESSES
		WebElement btnProceedAddress = driver.findElement(By.cssSelector("#center_column > form > p > button"));
		wait.until(ExpectedConditions.visibilityOf(btnProceedAddress));
		btnProceedAddress.click();

		// Check agree terms
		WebElement checkTerms = driver.findElement(By.id("uniform-cgv"));
		wait.until(ExpectedConditions.visibilityOf(checkTerms));
		checkTerms.click();

		// Execute btn Proceed to checkout in page Shipping
		WebElement btnProceedShipping = driver
				.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium"));
		wait.until(ExpectedConditions.visibilityOf(btnProceedShipping));
		btnProceedShipping.click();

	}

	@When("pay by bank wire")
	public void pay_by_bank_wire() {

		// Select Payment
		WebElement opcPayByBank = driver.findElement(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a"));
		wait.until(ExpectedConditions.visibilityOf(opcPayByBank));
		opcPayByBank.click();

		// Confirm Payment
		WebElement btnConfirmPayment = driver.findElement(By.cssSelector("#cart_navigation > button"));
		wait.until(ExpectedConditions.visibilityOf(btnConfirmPayment));
		btnConfirmPayment.click();

	}

	@Then("the order is confirmed")
	public void the_order_is_confirmed() throws InterruptedException {

		WebElement texConfirm = driver.findElement(By.cssSelector("#center_column > div > p"));
		wait.until(ExpectedConditions.titleContains("Order confirmation - My Store"));
		Assertions.assertEquals("Your order on My Store is complete.", texConfirm.getText());

	}

	@After
	public void quit() {

		driver.close();

	}

}
