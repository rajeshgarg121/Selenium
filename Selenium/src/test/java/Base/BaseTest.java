package base;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
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

import helper.LoggerDemo;
import helper.Report;

public class BaseTest {

	public static Logger log;
	public WebDriver driver;
	public LoggerDemo logger;
	public Report report;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		browser = browser.toLowerCase();
		logger = new LoggerDemo();
		report =Report.getinstance();
		report.startReport();
		switch (browser) {

		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "src\\lib\\chromedriver.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			driver = new ChromeDriver(cap);
			
			
			break;
		}
		case "explorer": {
			System.setProperty("webdriver.ie.driver", "src\\lib\\IEDriverServer.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			driver = new InternetExplorerDriver();
			/*
			 * report =Report.getinstance(); report.startReport(browser);
			 */
			break;
		}
		case "firefox": {
			driver = new FirefoxDriver();
			/*
			 * report = Report.getinstance(); report.startReport(browser);
			 */
			break;
		}
		default: {
			driver = new FirefoxDriver();
			/*
			 * report = Report.getinstance(); report.startReport(browser);
			 */
		}
		}
		driver.get("https://www.google.com/");
	}

	
	  @BeforeMethod
	  public void settest(ITestResult result) {
	 report=Report.getinstance();
	  report.setTest(result); }
	 
	@AfterMethod
	public void getresult(ITestResult result) {
		report=Report.getinstance();
		report.getResult(result);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		
	}
	@AfterSuite
	public void teardown2() {
		report=Report.getinstance();
		report.endReport();
		
	}
	
}
