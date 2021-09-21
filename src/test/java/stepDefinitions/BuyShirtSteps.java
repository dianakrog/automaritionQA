package stepDefinitions;

import Utils.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.*;

public class BuyShirtSteps {

	private WebDriver driver;
	private IndexPage index;
	private LoginPage login;
	private MyAccountPage accountPage;
	private TShirtPage tShirtPage;
	private SuccessfullyAddedPage addedPage;
	private SummaryOrderPage summaryOrder;
	private AddressPage address;
	private ShippingPage shipping;
	private PaymentPage payment;
	private ConfirmationPage confirmation;

	@Before
	public void initClass() {

		driver = new BrowserManager().startConfig();
		PageFactory.initElements(driver, this);

		index = new IndexPage(driver);
		login = new LoginPage(driver);
		accountPage = new MyAccountPage(driver);
		tShirtPage = new TShirtPage(driver);
		addedPage = new SuccessfullyAddedPage(driver);
		summaryOrder = new SummaryOrderPage(driver);
		address = new AddressPage(driver);
		shipping = new ShippingPage(driver);
		payment = new PaymentPage(driver);
		confirmation = new ConfirmationPage(driver);

	}

	@Given("an existing {string} and {string} accesses to the online store")
	public void an_existing_user_accesses_to_the_online_store(String user, String password) {

		index.openPage();
		index.goSignIn();
		login.loginValidUser(user, password);

	}

	@When("buy a t-shirt")
	public void buy_a_t_shirt() {

		accountPage.selectTabTShirt();
		tShirtPage.addToCartProduct();

		addedPage.proceedCheckout();
		summaryOrder.proceedSummary();

		address.proceedAddress();
		shipping.agreeTerms();
		shipping.checkoutShipping();

	}

	@When("pay by bank wire")
	public void pay_by_bank_wire() {

		payment.selectPaBankWire();

	}

	@Then("the order is confirmed")
	public void the_order_is_confirmed() throws InterruptedException {

		confirmation.orderCobfirmation();

	}

	@After
	public void quit() {

		driver.close();

	}

}
