package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		// Creates an input file stream to read from the specified File object.
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAurl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven =System.getProperty("browser"); // coming from terminal
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.getProperty("webdriver.chrome.driver",("user.dir") + "//src//test//resources//chromedriver");
				// System.setProperty("webdriver.chrome.driver",
				// "/Users/tejashreepatwardhan/Documents/chromedriver"); // setting up the
				// chromeDriver
				driver = new ChromeDriver();
			}
			if (browser.equalsIgnoreCase("firefox")) {
				System.getProperty("webdriver.chrome.driver",("user.dir") + "//src//test//resources//geckodriver");
				driver = new FirefoxDriver();
			}
			// 5 sec time out set for the entire framework
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;

	}

}
