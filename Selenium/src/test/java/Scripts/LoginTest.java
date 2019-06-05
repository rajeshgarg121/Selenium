package scripts;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.BaseTest;
import helper.LoggerDemo;

public class LoginTest extends BaseTest{

	@Test
	public void test1()
	{
		System.out.println("Mayank");
		//System.out.println("Mayank");
		log.debug("My log 1");
		//assertTrue(false);
		//driver.findElement(By.id("dkdkd")).click();
		log.debug("test1");
	}
	@Test
	public void test2()
	{
		System.out.println("Sahani");
		log.debug("test2");
	}
}
