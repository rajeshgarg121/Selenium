package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {

	WebDriver driver;
	@BeforeSuite
	@Parameters("browser")
	public void setup(String browser)
	{
		browser=browser.toLowerCase();

		switch(browser)
		{

		case "chrome":
		{
			System.setProperty("webdriver.chrome.driver", "src\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		case "explorer":
		{
			driver=new InternetExplorerDriver();
		}
		case "firefox":
		{
			driver=new FirefoxDriver();
		}
		}
		driver.get("https://www.google.com");
	}
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}

}
