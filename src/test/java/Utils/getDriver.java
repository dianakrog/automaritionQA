package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDriver {

	public static WebDriver driver;

	public static void iniciarConfiguracion(String browser){

		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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

		}

	}
}
