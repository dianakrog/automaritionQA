package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

	public static WebDriver startConfig(){

		switch (System.getProperty("exeBrowser","chrome")) {
		case "chrome":
			return  WebDriverManager.chromedriver().capabilities(new ChromeOptions()).create();
		case "firefox":
			return  WebDriverManager.firefoxdriver().capabilities(new FirefoxOptions()).create();
		default:
			throw new IllegalStateException(System.getProperty("exeBrowser","chrome") + " browser not supported");

		}

	}

}
