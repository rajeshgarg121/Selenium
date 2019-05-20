package helper;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static void getScreenShot(WebDriver driver, String testName)
	{
	    String id=Thread.currentThread().getName();
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		 // now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File(getFileName(testName+"_"+id)));
		}
		catch(Exception e)
		{
		}
		
		
	}
	private static String getFileName(String testName){
		// TODO Auto-generated method stub
		long date=System.currentTimeMillis();
		SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String formattedDate=dateFormat.format(date);
		String scriptLogFilePath =System.getProperty("user.dir")+"\\src\\main\\Screenshot\\screenshot_"+testName+"_"+formattedDate+".jpg";
		return scriptLogFilePath;
	}

}
