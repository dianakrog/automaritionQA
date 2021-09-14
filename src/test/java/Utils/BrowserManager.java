package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

	public static WebDriver startConfig(){

		switch (System.getProperty("exeBrowser","chrome")) {
		case "chrome":
			WebDriverManager wdmC = WebDriverManager.chromedriver();
			ChromeOptions optionsC = new ChromeOptions();
			WebDriver driverChrome = wdmC.capabilities(optionsC).create();
			return driverChrome;
		case "firefox":
			WebDriverManager wdmF = WebDriverManager.firefoxdriver();
			FirefoxOptions optionsF = new FirefoxOptions();
			WebDriver driverFirefox = wdmF.capabilities(optionsF).create();
			return driverFirefox;
		default:
			throw new IllegalStateException(System.getProperty("exeBrowser","chrome") + " browser not supported");

		}

	}

}
