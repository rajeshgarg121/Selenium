package scripts;

import org.testng.annotations.Test;

import base.BaseTest;

public class TestMethods extends BaseTest{
	
	@Test
	public void test1()
	{
		System.out.println("TestMethods class method 1");
		log.debug("TestMethods class method 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("TestMethods class method 2");
		log.debug("TestMethods class method 2");
	}
	
	
	
	

}
