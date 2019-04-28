package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {

	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser)
	{
		browser=browser.toLowerCase();

		switch(browser)
		{

		case "chrome":
		{
			System.setProperty("webdriver.chrome.driver", "src\\lib\\chromedriver.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			driver=new ChromeDriver(cap);
			break;
		}
		case "explorer":
		{
			System.setProperty("webdriver.ie.driver", "src\\lib\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
		}
		case "firefox":
		{
			driver=new FirefoxDriver();
			break;
		}
		default:
		{
			driver=new FirefoxDriver();
		}
		}
		driver.get("https://www.google.com/");
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
