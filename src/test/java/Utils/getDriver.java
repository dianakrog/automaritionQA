package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDriver {

	public static WebDriver driver;

	public static void startConfig() throws Exception{

		switch (System.getProperty("exeBrowser","chrome")) {
		case "chrome":
			WebDriverManager wdmC = WebDriverManager.chromedriver();
			ChromeOptions optionsC = new ChromeOptions();;
			driver = wdmC.capabilities(optionsC).create();
			driver.manage().window().maximize();
			
			break;
		case "firefox":
			WebDriverManager wdmF = WebDriverManager.firefoxdriver();
			FirefoxOptions optionsF = new FirefoxOptions();
			driver = wdmF.capabilities(optionsF).create();
			driver.manage().window().maximize();
			break;
		default:
			throw new Exception(System.getProperty("exeBrowser","chrome")+ " browser not supported" );

		}

	}
}
