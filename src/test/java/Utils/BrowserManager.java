package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

	public static WebDriver startConfig(){
		
		String browser = System.getProperty("exeBrowser","firefox");

		switch (browser) {
		case "chrome":
			return  WebDriverManager.chromedriver().capabilities(new ChromeOptions()).create();
		case "firefox":
			return  WebDriverManager.firefoxdriver().capabilities(new FirefoxOptions()).create();
		default:
			throw new IllegalStateException(browser + " browser not supported");

		}

	}

}
